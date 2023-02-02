package me.mprieto.baton.workflows;

import me.mprieto.baton.grammar.Baton;

/**
 * Translates a conditional expression in an IF or WHILE statement to
 * a javascript expression that can be evaluated by Conductor's JS engine.
 */
class CondExprJSVisitor extends Visitor<String> {

    CondExprJSVisitor(VisitorContext vCtx) {
        super(vCtx);
    }

    @Override
    public String visitExecuteExpr(Baton.ExecuteExprContext ctx) {
        throw new RuntimeException("Cannot execute a task in an if condition. Line: " + ctx.getStart().getLine());
    }

    @Override
    public String visitParExpression(Baton.ParExpressionContext ctx) {
        if (ctx.getParent() instanceof Baton.ExpressionContext) {
            return ctx.getChild(0).getText() + visit(ctx.getChild(1)) + ctx.getChild(2).getText();
        }

        return visit(ctx.getChild(1));
    }

    @Override
    public String visitPrimaryExpr(Baton.PrimaryExprContext ctx) {
        if (ctx.identifier() != null) {
            var identifier = ctx.identifier().getText();
            return String.format("$.%s", identifier);
        } else if (ctx.literal() != null) {
            return ctx.literal().getText();
        }

        return visit(ctx.parExpression());
    }

    @Override
    public String visitNegationExpr(Baton.NegationExprContext ctx) {
        return ctx.getChild(0).getText() + visit(ctx.getChild(1));
    }

    @Override
    public String visitLogicExpr(Baton.LogicExprContext ctx) {
        return visit(ctx.getChild(0)) + " " + ctx.getChild(1).getText() + " " + visit(ctx.getChild(2));
    }

    @Override
    public String visitCompExpr(Baton.CompExprContext ctx) {
        return visit(ctx.getChild(0)) + " " + ctx.getChild(1).getText() + " " + visit(ctx.getChild(2));
    }
}
