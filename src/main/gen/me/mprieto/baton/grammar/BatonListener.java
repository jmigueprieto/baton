// Generated from java-escape by ANTLR 4.11.1
package me.mprieto.baton.grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BatonParser}.
 */
public interface BatonListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BatonParser#batonUnit}.
	 * @param ctx the parse tree
	 */
	void enterBatonUnit(BatonParser.BatonUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#batonUnit}.
	 * @param ctx the parse tree
	 */
	void exitBatonUnit(BatonParser.BatonUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(BatonParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(BatonParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(BatonParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(BatonParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(BatonParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(BatonParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#workflowDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterWorkflowDeclaration(BatonParser.WorkflowDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#workflowDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitWorkflowDeclaration(BatonParser.WorkflowDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#workflowBlock}.
	 * @param ctx the parse tree
	 */
	void enterWorkflowBlock(BatonParser.WorkflowBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#workflowBlock}.
	 * @param ctx the parse tree
	 */
	void exitWorkflowBlock(BatonParser.WorkflowBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#taskDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTaskDeclaration(BatonParser.TaskDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#taskDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTaskDeclaration(BatonParser.TaskDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#taskBlock}.
	 * @param ctx the parse tree
	 */
	void enterTaskBlock(BatonParser.TaskBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#taskBlock}.
	 * @param ctx the parse tree
	 */
	void exitTaskBlock(BatonParser.TaskBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(BatonParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(BatonParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BatonParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BatonParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(BatonParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(BatonParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(BatonParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(BatonParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(BatonParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(BatonParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#propertiesBlock}.
	 * @param ctx the parse tree
	 */
	void enterPropertiesBlock(BatonParser.PropertiesBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#propertiesBlock}.
	 * @param ctx the parse tree
	 */
	void exitPropertiesBlock(BatonParser.PropertiesBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#propertiesPair}.
	 * @param ctx the parse tree
	 */
	void enterPropertiesPair(BatonParser.PropertiesPairContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#propertiesPair}.
	 * @param ctx the parse tree
	 */
	void exitPropertiesPair(BatonParser.PropertiesPairContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#propertiesArray}.
	 * @param ctx the parse tree
	 */
	void enterPropertiesArray(BatonParser.PropertiesArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#propertiesArray}.
	 * @param ctx the parse tree
	 */
	void exitPropertiesArray(BatonParser.PropertiesArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#propertiesValue}.
	 * @param ctx the parse tree
	 */
	void enterPropertiesValue(BatonParser.PropertiesValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#propertiesValue}.
	 * @param ctx the parse tree
	 */
	void exitPropertiesValue(BatonParser.PropertiesValueContext ctx);
}