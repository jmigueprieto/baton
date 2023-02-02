package me.mprieto.baton.workflows;

import me.mprieto.baton.grammar.Baton;

import java.util.HashMap;
import java.util.Map;

/**
 * Translates a conditional expression in an IF or WHILE statement to
 * a javascript expression that can be evaluated by Conductor's JS engine.
 */
class CondExprInputParamsVisitor extends Visitor<Map<String, Object>> {

    private Map<String, Object> inputParams = new HashMap<>();

    CondExprInputParamsVisitor(VisitorContext vCtx) {
        super(vCtx);
    }

    @Override
    public Map<String, Object> visitParExpression(Baton.ParExpressionContext ctx) {
        return visit(ctx.getChild(1));
    }

    @Override
    public Map<String, Object> visitPrimaryExpr(Baton.PrimaryExprContext ctx) {
        if (ctx.identifier() != null) {
            var identifier = ctx.identifier().getText();
            var root = identifier.split("\\.")[0];
            //TODO check that this identifier is valid. Check the variables.
            //var variable = vCtx.getVar(root);
            inputParams.put(root, String.format("${%s}", "input".equals(root) ? "workflow." + root : root + ".output"));
        } else if (ctx.parExpression() != null) {
            visit(ctx.parExpression());
        }

        return inputParams;
    }

    @Override
    public Map<String, Object> visitNegationExpr(Baton.NegationExprContext ctx) {
        return visit(ctx.getChild(1));
    }

    @Override
    public Map<String, Object> visitLogicExpr(Baton.LogicExprContext ctx) {
        visit(ctx.getChild(0));
        visit(ctx.getChild(2));
        return inputParams;
    }

    @Override
    public Map<String, Object> visitCompExpr(Baton.CompExprContext ctx) {
        visit(ctx.getChild(0));
        visit(ctx.getChild(2));
        return inputParams;
    }
}
