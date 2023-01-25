package me.mprieto.baton.tree;

import lombok.RequiredArgsConstructor;
import me.mprieto.baton.grammar.BatonBaseListener;
import me.mprieto.baton.grammar.BatonParser;
import me.mprieto.baton.model.BGenericObj;
import me.mprieto.baton.model.BStructObj;

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
