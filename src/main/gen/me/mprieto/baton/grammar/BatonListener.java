// Generated from java-escape by ANTLR 4.11.1
package me.mprieto.baton.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Baton}.
 */
public interface BatonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Baton#batonUnit}.
	 * @param ctx the parse tree
	 */
	void enterBatonUnit(Baton.BatonUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#batonUnit}.
	 * @param ctx the parse tree
	 */
	void exitBatonUnit(Baton.BatonUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(Baton.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(Baton.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#structDef}.
	 * @param ctx the parse tree
	 */
	void enterStructDef(Baton.StructDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#structDef}.
	 * @param ctx the parse tree
	 */
	void exitStructDef(Baton.StructDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#keyTypePair}.
	 * @param ctx the parse tree
	 */
	void enterKeyTypePair(Baton.KeyTypePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#keyTypePair}.
	 * @param ctx the parse tree
	 */
	void exitKeyTypePair(Baton.KeyTypePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#type}.
	 * @param ctx the parse tree
	 */
	void enterType(Baton.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#type}.
	 * @param ctx the parse tree
	 */
	void exitType(Baton.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#taskDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTaskDeclaration(Baton.TaskDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#taskDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTaskDeclaration(Baton.TaskDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#taskParams}.
	 * @param ctx the parse tree
	 */
	void enterTaskParams(Baton.TaskParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#taskParams}.
	 * @param ctx the parse tree
	 */
	void exitTaskParams(Baton.TaskParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#workflowDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterWorkflowDeclaration(Baton.WorkflowDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#workflowDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitWorkflowDeclaration(Baton.WorkflowDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#workflowParams}.
	 * @param ctx the parse tree
	 */
	void enterWorkflowParams(Baton.WorkflowParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#workflowParams}.
	 * @param ctx the parse tree
	 */
	void exitWorkflowParams(Baton.WorkflowParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#workflowOutput}.
	 * @param ctx the parse tree
	 */
	void enterWorkflowOutput(Baton.WorkflowOutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#workflowOutput}.
	 * @param ctx the parse tree
	 */
	void exitWorkflowOutput(Baton.WorkflowOutputContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#metadataParams}.
	 * @param ctx the parse tree
	 */
	void enterMetadataParams(Baton.MetadataParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#metadataParams}.
	 * @param ctx the parse tree
	 */
	void exitMetadataParams(Baton.MetadataParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void enterKeyValuePair(Baton.KeyValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void exitKeyValuePair(Baton.KeyValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(Baton.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(Baton.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(Baton.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(Baton.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(Baton.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(Baton.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(Baton.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(Baton.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(Baton.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(Baton.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(Baton.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(Baton.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Baton.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Baton.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(Baton.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(Baton.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(Baton.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(Baton.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStmt(Baton.VarDeclStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStmt(Baton.VarDeclStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(Baton.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(Baton.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(Baton.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(Baton.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(Baton.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(Baton.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(Baton.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(Baton.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(Baton.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(Baton.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dotExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void enterDotExpr(Baton.DotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dotExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void exitDotExpr(Baton.DotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(Baton.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(Baton.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr(Baton.LogicExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr(Baton.LogicExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code executeExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void enterExecuteExpr(Baton.ExecuteExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code executeExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 */
	void exitExecuteExpr(Baton.ExecuteExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#execParams}.
	 * @param ctx the parse tree
	 */
	void enterExecParams(Baton.ExecParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#execParams}.
	 * @param ctx the parse tree
	 */
	void exitExecParams(Baton.ExecParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Baton#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(Baton.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Baton#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(Baton.ParExpressionContext ctx);
}