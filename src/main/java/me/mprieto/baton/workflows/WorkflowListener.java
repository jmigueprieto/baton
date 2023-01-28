package me.mprieto.baton.workflows;

import lombok.RequiredArgsConstructor;
import me.mprieto.baton.grammar.BatonBaseListener;
import me.mprieto.baton.grammar.BatonParser;
import me.mprieto.baton.common.model.BGenericObj;
import me.mprieto.baton.structs.model.BStructObj;

import java.util.Map;

@RequiredArgsConstructor
public class WorkflowListener extends BatonBaseListener {

    private final Map<String, BGenericObj> tasks;
    private final Map<String, BStructObj> structs;

    @Override
    public void enterWorkflowDeclaration(BatonParser.WorkflowDeclarationContext ctx) {
        super.enterWorkflowDeclaration(ctx);
    }

    @Override
    public void enterWorkflowOutput(BatonParser.WorkflowOutputContext ctx) {
        super.enterWorkflowOutput(ctx);
    }
}
