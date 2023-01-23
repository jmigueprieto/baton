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
	 * Enter a parse tree produced by {@link BatonParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(BatonParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(BatonParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#structDef}.
	 * @param ctx the parse tree
	 */
	void enterStructDef(BatonParser.StructDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#structDef}.
	 * @param ctx the parse tree
	 */
	void exitStructDef(BatonParser.StructDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#structKeyValuePair}.
	 * @param ctx the parse tree
	 */
	void enterStructKeyValuePair(BatonParser.StructKeyValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#structKeyValuePair}.
	 * @param ctx the parse tree
	 */
	void exitStructKeyValuePair(BatonParser.StructKeyValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BatonParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BatonParser.TypeContext ctx);
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
	 * Enter a parse tree produced by {@link BatonParser#object}.
	 * @param ctx the parse tree
	 */
	void enterObject(BatonParser.ObjectContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#object}.
	 * @param ctx the parse tree
	 */
	void exitObject(BatonParser.ObjectContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void enterKeyValuePair(BatonParser.KeyValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void exitKeyValuePair(BatonParser.KeyValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(BatonParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(BatonParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(BatonParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(BatonParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(BatonParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(BatonParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(BatonParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(BatonParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link BatonParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(BatonParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(BatonParser.ArrayContext ctx);
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
	 * Enter a parse tree produced by {@link BatonParser#workflowOutput}.
	 * @param ctx the parse tree
	 */
	void enterWorkflowOutput(BatonParser.WorkflowOutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link BatonParser#workflowOutput}.
	 * @param ctx the parse tree
	 */
	void exitWorkflowOutput(BatonParser.WorkflowOutputContext ctx);
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
}