// Generated from java-escape by ANTLR 4.11.1
package me.mprieto.baton.grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BatonParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BatonVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BatonParser#batonUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBatonUnit(BatonParser.BatonUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#structDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclaration(BatonParser.StructDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#structDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDef(BatonParser.StructDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#structKeyValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructKeyValuePair(BatonParser.StructKeyValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BatonParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#taskDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskDeclaration(BatonParser.TaskDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(BatonParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#keyValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValuePair(BatonParser.KeyValuePairContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(BatonParser.KeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(BatonParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(BatonParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(BatonParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(BatonParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#workflowDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWorkflowDeclaration(BatonParser.WorkflowDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#workflowOutput}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWorkflowOutput(BatonParser.WorkflowOutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(BatonParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStmt}
	 * labeled alternative in {@link BatonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(BatonParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStmt}
	 * labeled alternative in {@link BatonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(BatonParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDeclStmt}
	 * labeled alternative in {@link BatonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclStmt(BatonParser.VarDeclStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentStmt}
	 * labeled alternative in {@link BatonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(BatonParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link BatonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(BatonParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStmt}
	 * labeled alternative in {@link BatonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(BatonParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixOp}
	 * labeled alternative in {@link BatonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOp(BatonParser.PrefixOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqOp}
	 * labeled alternative in {@link BatonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqOp(BatonParser.EqOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicOp}
	 * labeled alternative in {@link BatonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOp(BatonParser.LogicOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code execute}
	 * labeled alternative in {@link BatonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExecute(BatonParser.ExecuteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primary}
	 * labeled alternative in {@link BatonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(BatonParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dotOp}
	 * labeled alternative in {@link BatonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotOp(BatonParser.DotOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(BatonParser.ParExpressionContext ctx);
}