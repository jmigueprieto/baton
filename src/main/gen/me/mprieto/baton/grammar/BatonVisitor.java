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
	 * Visit a parse tree produced by {@link BatonParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(BatonParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#taskDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskDeclaration(BatonParser.TaskDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(BatonParser.ParametersContext ctx);
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
	 * Visit a parse tree produced by {@link BatonParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BatonParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#customType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomType(BatonParser.CustomTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObject(BatonParser.ObjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(BatonParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(BatonParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#workflowDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWorkflowDeclaration(BatonParser.WorkflowDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#workflowBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWorkflowBlock(BatonParser.WorkflowBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(BatonParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BatonParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(BatonParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(BatonParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(BatonParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#parExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpression(BatonParser.ParExpressionContext ctx);
}