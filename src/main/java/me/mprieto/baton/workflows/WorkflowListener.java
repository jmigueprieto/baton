package me.mprieto.baton.workflows;

import com.netflix.conductor.common.metadata.workflow.WorkflowDef;
import me.mprieto.baton.common.BGenericObjectParser;
import me.mprieto.baton.grammar.BatonBaseListener;
import me.mprieto.baton.grammar.Baton;
import me.mprieto.baton.common.model.BGenericObj;
import me.mprieto.baton.structs.model.BStructObj;

import java.util.Map;

public class WorkflowListener extends BatonBaseListener {

    private final Map<String, BGenericObj> tasks;
    private final BGenericObjectParser objectParser;
    private final WorkflowDef workflowDef = new WorkflowDef();

    public WorkflowListener(Map<String, BStructObj> structs, Map<String, BGenericObj> tasks) {
        this.objectParser = new BGenericObjectParser(structs);
        this.tasks = tasks;
    }

    @Override
    public void enterWorkflowDeclaration(Baton.WorkflowDeclarationContext ctx) {
        //TODO
        workflowDef.setName(ctx.IDENTIFIER().getText());
        if (ctx.workflowParameters() != null) {
            var parameters = objectParser.parse("_", ctx.workflowParameters().parameters());
            if (parameters.get("description") != null) {
                var desc = parameters.get("description");
                workflowDef.setDescription((String) desc.getValue());
            }
        }
        super.enterWorkflowDeclaration(ctx);
    }

    @Override
    public void enterWorkflowOutput(Baton.WorkflowOutputContext ctx) {
        super.enterWorkflowOutput(ctx);
    }

    public WorkflowDef getWorkflowDef() {
        return this.workflowDef;
    }
}
