// Generated from java-escape by ANTLR 4.11.1
package me.mprieto.baton.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Baton}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BatonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Baton#batonUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBatonUnit(Baton.BatonUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(Baton.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#structDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDef(Baton.StructDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#keyTypePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyTypePair(Baton.KeyTypePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(Baton.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#taskDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskDeclaration(Baton.TaskDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#taskParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskParams(Baton.TaskParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#workflowDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWorkflowDeclaration(Baton.WorkflowDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#workflowParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWorkflowParams(Baton.WorkflowParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#workflowOutput}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWorkflowOutput(Baton.WorkflowOutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#metadataParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetadataParams(Baton.MetadataParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#keyValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValuePair(Baton.KeyValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(Baton.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(Baton.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(Baton.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(Baton.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(Baton.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(Baton.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(Baton.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(Baton.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(Baton.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclStmt(Baton.VarDeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(Baton.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(Baton.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link Baton#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(Baton.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negationExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationExpr(Baton.NegationExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(Baton.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompExpr(Baton.CompExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicExpr(Baton.LogicExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code executeCmdExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteCmdExpr(Baton.ExecuteCmdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code executeExpr}
	 * labeled alternative in {@link Baton#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecuteExpr(Baton.ExecuteExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#execParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecParams(Baton.ExecParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Baton#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(Baton.ParExpressionContext ctx);
}