package me.mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.tasks.TaskType;
import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import com.netflix.conductor.common.metadata.workflow.WorkflowTask;
import me.mprieto.baton.exceptions.InvalidTypeException;
import me.mprieto.baton.exceptions.UnknownSymbolException;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.grammar.BatonBaseListener;
import me.mprieto.baton.model.*;
import me.mprieto.baton.model.parsers.BMetadataParamsParser;
import me.mprieto.baton.model.parsers.BObjParser;
import me.mprieto.baton.model.parsers.BStructParser;
import org.antlr.v4.runtime.Token;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkflowListener extends BatonBaseListener {

    private final BObjParser objectParser = new BObjParser();
    private final BMetadataParamsParser metadataParamsParser = new BMetadataParamsParser();

    private final BStructParser structParser = new BStructParser();

    private final WorkflowDef workflowDef = new WorkflowDef();

    private final Map<String, BVar> variables = new HashMap<>();

    private final Map<String, BMetadataParams> taskDefinitions;
    private final Map<String, BStruct> structDefinitions;

    public WorkflowListener(Map<String, BStruct> structDefinitions,
                            Map<String, BMetadataParams> taskDefinitions) {
        this.structDefinitions = structDefinitions;
        this.taskDefinitions = taskDefinitions;
    }

    public WorkflowDef getWorkflowDef() {
        return this.workflowDef;
    }

    @Override
    public void enterWorkflowDeclaration(Baton.WorkflowDeclarationContext ctx) {
        workflowDef.setName(ctx.IDENTIFIER().getText());
    }

    @Override
    public void enterWorkflowParams(Baton.WorkflowParamsContext ctx) {
        var parameters = metadataParamsParser.parse(ctx.metadataParams());
        var inputParam = parameters.getInput();

        if (inputParam != null) {
            var struct = getMetadataIOStruct(inputParam);
            variables.put("input", new BVar(ctx, BType.OBJECT, struct));

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
    }

    @Override
    public void enterWorkflowOutput(Baton.WorkflowOutputContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            var identifier = ctx.IDENTIFIER().getText();
            if (!structDefinitions.containsKey(identifier)) {
                throw new InvalidTypeException("Invalid type " + identifier);
            }
            structDefinitions.put("workflow.output", structDefinitions.get(identifier));
        } else if (ctx.structDef() != null) {
            var struct = structParser.parse(ctx.structDef());
            structDefinitions.put("workflow.output", struct);
        }
    }

    @Override
    public void enterReturnStmt(Baton.ReturnStmtContext ctx) {
        if (ctx.object() == null) {
            return;
        }

        //TODO type check with structDefinitions "workflow.output"
        var objectCtx = ctx.object();
        var retObj = objectParser.parse(objectCtx);
        var map = convertToMap(retObj);
        workflowDef.setOutputParameters(map);
    }

    @Override
    public void enterVarDeclStmt(Baton.VarDeclStmtContext ctx) {
        var identifier = ctx.IDENTIFIER().getText();
        if ("input".equals(identifier)) {
            throw new RuntimeException("input is an implicit variable for the workflow input");
        }
        variables.put(identifier, new BVar(ctx, null, null));
    }

    @Override
    public void enterExecuteExpr(Baton.ExecuteExprContext ctx) {
        var varName = getVarName(ctx);
        var taskType = getTaskType(ctx);
        var taskDefinition = taskDefinitions.get(taskType);

        if (varName != null && taskDefinition != null) {
            var output = taskDefinition.getOutput();
            if (output != null) {
                var variable = variables.get(varName);
                variable.setType(BType.OBJECT);
                variable.setStruct(getMetadataIOStruct(output));
            }
        } else if (taskDefinition == null) {
            var variable = variables.get(varName);
            variable.setType(BType.UNKNOWN);
        } else {
            varName = implicitVarName(taskType, ctx.getStart());
            var variable = variables.get(varName);
            variable.setType(BType.UNKNOWN);
        }

        var task = new WorkflowTask();
        if (Arrays.stream(TaskType.values()).anyMatch(t -> t.name().toLowerCase().equals(taskType))) {
            task.setType(taskType.toUpperCase());
            task.setName(varName);
        } else {
            task.setType(TaskType.SIMPLE.name());
            task.setName(varName);
        }

        task.setTaskReferenceName(varName);
        workflowDef.getTasks().add(task);

        if (ctx.execParams() != null) {
            loadTaskParams(ctx, taskType, task);
        }
    }

    private void loadTaskParams(Baton.ExecuteExprContext ctx, String taskType, WorkflowTask task) {
        //TODO complete
        var params = objectParser.parse(ctx.execParams());
        var inputProperty = params.get("input");
        if (inputProperty != null) {
            if (inputProperty.getType() != BType.OBJECT) {
                throw new InvalidTypeException("Task input must be an Object. " +
                        "Line: " + inputProperty.getCtx().getStart().getLine());
            }

            var inputObj = inputProperty.asBObj();
            typeCheck(taskType, inputObj);
            task.setInputParameters(convertToMap(inputObj));
        }

        var description = params.get("description");
        if (description != null) {
            task.setDescription(description.asString());
        }

        var startDelay = params.get("startDelay");
        if (startDelay != null) {
            task.setStartDelay(startDelay.asInteger());
        }

        var optional = params.get("optional");
        if (optional != null) {
            task.setOptional(optional.asBoolean());
        }

        var asyncComplete = params.get("asyncComplete");
        if (asyncComplete != null) {
            task.setAsyncComplete(asyncComplete.asBoolean());
        }

        var retryCount = params.get("retryCount");
        if (retryCount != null) {
            task.setRetryCount(retryCount.asInteger());
        }

        //TODO if there's any unsupported param throw an Exception
    }

    private void typeCheck(String taskType, BObj input) {
        if (!taskDefinitions.containsKey(taskType)) {
            return;
        }

        var taskDefinition = taskDefinitions.get(taskType);
        var taskDefinitionInputProperty = taskDefinition.getInput();
        if (taskDefinitionInputProperty == null) {
            return;
        }

        final var struct = getMetadataIOStruct(taskDefinitionInputProperty);
        for (var prop : input.list()) {
            var s = struct;
            var structProperty = s.get(prop.getName());
            var expectedType = structProperty.getType();
            while (expectedType == BType.IDENTIFIER) {
                s = structDefinitions.get(structProperty.getIdentifier());
                structProperty = s.get(prop.getName());
                expectedType = structProperty.getType();
            }

            var actualType = getType(prop);
            if (expectedType != actualType) {
                throw new InvalidTypeException(String.format("Expected %s to be %s but got %s. Line: %d",
                        prop.getName(),
                        expectedType,
                        actualType,
                        prop.getCtx().getStart().getLine()));
            }
        }

    }

    private BType getType(BObj.Property prop) {
        if (prop.getType() == BType.IDENTIFIER) {
            // lookup the type
            return getVariableType(prop.asString());
        }

        return prop.getType();
    }

    private BType getVariableType(String identifier) {
        var split = identifier.split("\\.");
        var variable = variables.get(split[0]);
        var type = variable.getType();

        if (split.length > 1 && type != BType.OBJECT) {
            throw new RuntimeException(String.format("%s is not an Object, cannot access %s", split[0], identifier));
        }

        var struct = variable.getStruct();
        for (int i = 1; i < split.length; i++) {
            var id = split[i];
            if (type != BType.OBJECT) {
                throw new RuntimeException(String.format("%s is not an Object, cannot access %s", id, identifier));
            }

            type = struct.get(id).getType();
            while (type == BType.IDENTIFIER) {
                struct = structDefinitions.get(id);
                type = struct.get(id).getType();
            }

        }

        return type;

    }

    private static String implicitVarName(String taskType, Token ctx) {
        return taskType + "_" + ctx.getLine();
    }

    private List<Object> convertToList(List<BObj> list) {
        return list.stream()
                .map(this::convertToMap)
                .collect(Collectors.toList());
    }

    private Map<String, Object> convertToMap(BObj obj) {
        return obj.list()
                .stream()
                .collect(Collectors.toMap(BaseObject.BaseProperty::getName, prop -> {
                    var type = prop.getType();
                    if (type == BType.IDENTIFIER) {
                        return convertIdentifierToRef(prop);
                    } else if (type == BType.OBJECT) {
                        return convertToMap(obj);
                    } else if (type == BType.ARRAY) {
                        //noinspection unchecked
                        return convertToList((List<BObj>) prop.getValue());
                    }

                    return prop.getValue();
                }));

    }

    private String convertIdentifierToRef(BObj.Property prop) {
        var identifier = (String) prop.getValue();
        var split = identifier.split("\\.");
        var rootObj = split[0];
        if (!rootObj.equalsIgnoreCase("input")) {
            if (!variables.containsKey(rootObj)) {
                throw new UnknownSymbolException("Unknown symbol " + rootObj +
                        " line " + prop.getCtx().getStart().getLine());
            }
            return String.format("${%s}", identifier);
        } else {
            return String.format("${workflow.%s}", identifier);
        }
    }

    private String getVarName(Baton.ExecuteExprContext ctx) {
        if (ctx.getParent() instanceof Baton.VarDeclStmtContext) {
            return ((Baton.VarDeclStmtContext) ctx.getParent()).IDENTIFIER().getText();
        }

        return null;
    }

    private String getTaskType(Baton.ExecuteExprContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            return ctx.IDENTIFIER().getText();
        }

        if (ctx.LITERAL_STRING() != null) {
            var str = ctx.LITERAL_STRING().getText();
            return str.substring(1, str.length() - 1);
        }

        throw new RuntimeException("Cannot get task type");
    }

    private BStruct getMetadataIOStruct(BStruct.Property inputOrOutput) {
        if (inputOrOutput.getType() == BType.IDENTIFIER) {
            var identifier = inputOrOutput.getIdentifier();
            if (!structDefinitions.containsKey(identifier)) {
                throw new InvalidTypeException("Invalid type " + identifier);
            }
            return structDefinitions.get(identifier);
        } else if (inputOrOutput.getType() == BType.OBJECT) {
            return inputOrOutput.getStruct();
        }

        throw new InvalidTypeException("Invalid Type. Workflow and Task input/output must be a struct. " +
                "Line " + inputOrOutput.getCtx().getStart().getLine());
    }

}
