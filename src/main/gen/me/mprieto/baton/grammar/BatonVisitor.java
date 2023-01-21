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
	 * Visit a parse tree produced by {@link BatonParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(BatonParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(BatonParser.ParamContext ctx);
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
	 * Visit a parse tree produced by {@link BatonParser#taskDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskDeclaration(BatonParser.TaskDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#taskBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTaskBlock(BatonParser.TaskBlockContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link BatonParser#propertiesBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertiesBlock(BatonParser.PropertiesBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#propertiesPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertiesPair(BatonParser.PropertiesPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#propertiesArray}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertiesArray(BatonParser.PropertiesArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link BatonParser#propertiesValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertiesValue(BatonParser.PropertiesValueContext ctx);
}