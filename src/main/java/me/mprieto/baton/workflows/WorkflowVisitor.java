package me.mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask;
import me.mprieto.baton.exceptions.InvalidTypeException;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.model.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkflowVisitor extends Visitor<WorkflowDef> {

    private final WorkflowDef workflowDef;
    private final BlockVisitor blockVisitor;

    public WorkflowVisitor(Map<String, BStruct> structDefinitions,
                           Map<String, BMetadataParams> taskDefinitions) {
        super(new VisitorContext(taskDefinitions, structDefinitions));
        workflowDef = vCtx.workflowDef();
        blockVisitor = new BlockVisitor(vCtx);
    }

    @Override
    public WorkflowDef visitWorkflowDeclaration(Baton.WorkflowDeclarationContext ctx) {
        workflowDef.setName(ctx.IDENTIFIER().getText());
        if (ctx.workflowParams() != null) {
            visitWorkflowParams(ctx.workflowParams());
        }

        if (ctx.workflowOutput() != null) {
            visitWorkflowOutput(ctx.workflowOutput());
        }

        List<WorkflowTask> tasks = blockVisitor.visit(ctx.block());
        workflowDef.setTasks(tasks);

        return workflowDef;
    }

    @Override
    public WorkflowDef visitWorkflowParams(Baton.WorkflowParamsContext ctx) {
        var parameters = vCtx.metadataParamsParser().parse(ctx.metadataParams());
        var inputParam = parameters.getInput();

        if (inputParam != null) {
            var struct = getMetadataIOStruct(inputParam);
            vCtx.addVar("input", new BVar(ctx, BType.OBJECT, struct));

            var inputParameters = struct.list()
                    .stream()
                    .map(BaseObject.BaseProperty::getName)
                    .collect(Collectors.toList());
            workflowDef.setInputParameters(inputParameters);
        }

        var desc = parameters.get("description");
        if (desc != null) {
            workflowDef.setDescription(desc.asString());
        }

        var version = parameters.get("version");
        if (version != null) {
            workflowDef.setVersion(version.asLong().intValue());
        }

        var failureWorkflow = parameters.get("failureWorkflow");
        if (failureWorkflow != null) {
            workflowDef.setFailureWorkflow(failureWorkflow.asString());
        }

        var restartable = parameters.get("restartable");
        if (restartable != null) {
            workflowDef.setRestartable(restartable.asBoolean());
        }

        var workflowStatusListenerEnabled = parameters.get("workflowStatusListenerEnabled");
        if (workflowStatusListenerEnabled != null) {
            workflowDef.setWorkflowStatusListenerEnabled(workflowStatusListenerEnabled.asBoolean());
        }

        var timeoutPolicy = parameters.get("timeoutPolicy");
        if (timeoutPolicy != null) {
            var name = timeoutPolicy.asString();
            var valid = Arrays.stream(WorkflowDef.TimeoutPolicy.values()).anyMatch(it -> it.name().equals(name));
            if (valid) {
                workflowDef.setTimeoutPolicy(WorkflowDef.TimeoutPolicy.valueOf(name));
            } else {
                throw new InvalidTypeException(String.format("TimeoutPolicy accepted values are: %s, but I got %s",
                        Arrays.toString(WorkflowDef.TimeoutPolicy.values()),
                        name));
            }
        }
        var timeoutSeconds = parameters.get("timeoutSeconds");
        if (timeoutSeconds != null) {
            workflowDef.setTimeoutSeconds(timeoutSeconds.asLong());
        }

        var ownerEmail = parameters.get("ownerEmail");
        if (ownerEmail != null) {
            workflowDef.setOwnerEmail(ownerEmail.asString());
        }

        //TODO if there's any unsupported param throw an Exception
        return workflowDef;
    }

    @Override
    public WorkflowDef visitWorkflowOutput(Baton.WorkflowOutputContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            var identifier = ctx.IDENTIFIER().getText();
            if (!vCtx.containsStruct(identifier)) {
                throw new InvalidTypeException("Invalid type " + identifier);
            }
            vCtx.addStruct("workflow.output", vCtx.getStruct(identifier));
        } else if (ctx.structDef() != null) {
            var struct = vCtx.structParser().parse(ctx.structDef());
            vCtx.addStruct("workflow.output", struct);
        }

        return workflowDef;
    }
}
