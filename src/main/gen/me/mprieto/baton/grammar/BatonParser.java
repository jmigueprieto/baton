// Generated from java-escape by ANTLR 4.11.1
package me.mprieto.baton.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class BatonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, WS=7, COMMENT=8, LINE_COMMENT=9, 
		WORKFLOW=10, TASK=11, TYPE=12, DEF=13, EXECUTE=14, INPUT=15, OUTPUT=16, 
		PROPERTIES=17, TYPE_STRING=18, TYPE_BOOLEAN=19, TYPE_INTEGER=20, TYPE_DECIMAL=21, 
		LPAREN=22, RPAREN=23, LBRACE=24, RBRACE=25, LBRACK=26, RBRACK=27, COLON=28, 
		COMMA=29, DOT=30, ASSIGNMENT=31, IF=32, ELSE=33, VAR=34, WHILE=35, BOOL_LITERAL=36, 
		STRING_LITERAL=37, NUMBER_LITERAL=38, NULL_LITERAL=39, IDENTIFIER=40;
	public static final int
		RULE_batonUnit = 0, RULE_typeDeclaration = 1, RULE_params = 2, RULE_param = 3, 
		RULE_workflowDeclaration = 4, RULE_workflowBlock = 5, RULE_taskDeclaration = 6, 
		RULE_taskBlock = 7, RULE_block = 8, RULE_statement = 9, RULE_expression = 10, 
		RULE_primary = 11, RULE_parExpression = 12, RULE_propertiesBlock = 13, 
		RULE_propertiesPair = 14, RULE_propertiesArray = 15, RULE_propertiesValue = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"batonUnit", "typeDeclaration", "params", "param", "workflowDeclaration", 
			"workflowBlock", "taskDeclaration", "taskBlock", "block", "statement", 
			"expression", "primary", "parExpression", "propertiesBlock", "propertiesPair", 
			"propertiesArray", "propertiesValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", "'-'", "'=='", "'!='", "'&&'", "'||'", null, null, null, 
			"'workflow'", "'task'", "'type'", "'def'", "'execute'", "'input'", "'output'", 
			"'properties'", "'String'", "'Boolean'", "'Integer'", "'Decimal'", "'('", 
			"')'", "'{'", "'}'", "'['", "']'", "':'", "','", "'.'", "'='", "'if'", 
			"'else'", "'var'", "'while'", null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", 
			"WORKFLOW", "TASK", "TYPE", "DEF", "EXECUTE", "INPUT", "OUTPUT", "PROPERTIES", 
			"TYPE_STRING", "TYPE_BOOLEAN", "TYPE_INTEGER", "TYPE_DECIMAL", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "COLON", "COMMA", "DOT", 
			"ASSIGNMENT", "IF", "ELSE", "VAR", "WHILE", "BOOL_LITERAL", "STRING_LITERAL", 
			"NUMBER_LITERAL", "NULL_LITERAL", "IDENTIFIER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BatonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BatonUnitContext extends ParserRuleContext {
		public WorkflowDeclarationContext workflowDeclaration() {
			return getRuleContext(WorkflowDeclarationContext.class,0);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public List<TaskDeclarationContext> taskDeclaration() {
			return getRuleContexts(TaskDeclarationContext.class);
		}
		public TaskDeclarationContext taskDeclaration(int i) {
			return getRuleContext(TaskDeclarationContext.class,i);
		}
		public BatonUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_batonUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterBatonUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitBatonUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitBatonUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BatonUnitContext batonUnit() throws RecognitionException {
		BatonUnitContext _localctx = new BatonUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_batonUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(34);
				typeDeclaration();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			workflowDeclaration();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TASK) {
				{
				{
				setState(41);
				taskDeclaration();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDeclarationContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(BatonParser.TYPE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitTypeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitTypeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(TYPE);
			setState(48);
			match(IDENTIFIER);
			setState(49);
			params();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BatonParser.LBRACE, 0); }
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(BatonParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BatonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BatonParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(LBRACE);
			setState(52);
			param();
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(53);
				match(COMMA);
				setState(54);
				param();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(BatonParser.STRING_LITERAL, 0); }
		public TerminalNode COLON() { return getToken(BatonParser.COLON, 0); }
		public TerminalNode TYPE_BOOLEAN() { return getToken(BatonParser.TYPE_BOOLEAN, 0); }
		public TerminalNode TYPE_STRING() { return getToken(BatonParser.TYPE_STRING, 0); }
		public TerminalNode TYPE_INTEGER() { return getToken(BatonParser.TYPE_INTEGER, 0); }
		public TerminalNode TYPE_DECIMAL() { return getToken(BatonParser.TYPE_DECIMAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(STRING_LITERAL);
			setState(63);
			match(COLON);
			setState(64);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 1099515559936L) != 0) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WorkflowDeclarationContext extends ParserRuleContext {
		public TerminalNode WORKFLOW() { return getToken(BatonParser.WORKFLOW, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public WorkflowBlockContext workflowBlock() {
			return getRuleContext(WorkflowBlockContext.class,0);
		}
		public WorkflowDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_workflowDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterWorkflowDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitWorkflowDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitWorkflowDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WorkflowDeclarationContext workflowDeclaration() throws RecognitionException {
		WorkflowDeclarationContext _localctx = new WorkflowDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_workflowDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(WORKFLOW);
			setState(67);
			match(IDENTIFIER);
			setState(68);
			workflowBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WorkflowBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BatonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BatonParser.RBRACE, 0); }
		public TerminalNode INPUT() { return getToken(BatonParser.INPUT, 0); }
		public TerminalNode OUTPUT() { return getToken(BatonParser.OUTPUT, 0); }
		public TerminalNode PROPERTIES() { return getToken(BatonParser.PROPERTIES, 0); }
		public PropertiesBlockContext propertiesBlock() {
			return getRuleContext(PropertiesBlockContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<ParamsContext> params() {
			return getRuleContexts(ParamsContext.class);
		}
		public ParamsContext params(int i) {
			return getRuleContext(ParamsContext.class,i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BatonParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BatonParser.IDENTIFIER, i);
		}
		public WorkflowBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_workflowBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterWorkflowBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitWorkflowBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitWorkflowBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WorkflowBlockContext workflowBlock() throws RecognitionException {
		WorkflowBlockContext _localctx = new WorkflowBlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_workflowBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(LBRACE);
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INPUT) {
				{
				setState(71);
				match(INPUT);
				setState(74);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
					{
					setState(72);
					params();
					}
					break;
				case IDENTIFIER:
					{
					setState(73);
					match(IDENTIFIER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUTPUT) {
				{
				setState(78);
				match(OUTPUT);
				setState(81);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
					{
					setState(79);
					params();
					}
					break;
				case IDENTIFIER:
					{
					setState(80);
					match(IDENTIFIER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PROPERTIES) {
				{
				setState(85);
				match(PROPERTIES);
				setState(86);
				propertiesBlock();
				}
			}

			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				statement();
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((_la) & ~0x3f) == 0 && ((1L << _la) & 2168962703366L) != 0 );
			setState(94);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TaskDeclarationContext extends ParserRuleContext {
		public TerminalNode TASK() { return getToken(BatonParser.TASK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public TaskBlockContext taskBlock() {
			return getRuleContext(TaskBlockContext.class,0);
		}
		public TaskDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_taskDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterTaskDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitTaskDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitTaskDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaskDeclarationContext taskDeclaration() throws RecognitionException {
		TaskDeclarationContext _localctx = new TaskDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_taskDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(TASK);
			setState(97);
			match(IDENTIFIER);
			setState(98);
			taskBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TaskBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BatonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BatonParser.RBRACE, 0); }
		public TerminalNode PROPERTIES() { return getToken(BatonParser.PROPERTIES, 0); }
		public PropertiesBlockContext propertiesBlock() {
			return getRuleContext(PropertiesBlockContext.class,0);
		}
		public TerminalNode INPUT() { return getToken(BatonParser.INPUT, 0); }
		public TerminalNode OUTPUT() { return getToken(BatonParser.OUTPUT, 0); }
		public List<ParamsContext> params() {
			return getRuleContexts(ParamsContext.class);
		}
		public ParamsContext params(int i) {
			return getRuleContext(ParamsContext.class,i);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(BatonParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(BatonParser.IDENTIFIER, i);
		}
		public TaskBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_taskBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterTaskBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitTaskBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitTaskBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaskBlockContext taskBlock() throws RecognitionException {
		TaskBlockContext _localctx = new TaskBlockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_taskBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(LBRACE);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INPUT) {
				{
				setState(101);
				match(INPUT);
				setState(104);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
					{
					setState(102);
					params();
					}
					break;
				case IDENTIFIER:
					{
					setState(103);
					match(IDENTIFIER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OUTPUT) {
				{
				setState(108);
				match(OUTPUT);
				setState(111);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
					{
					setState(109);
					params();
					}
					break;
				case IDENTIFIER:
					{
					setState(110);
					match(IDENTIFIER);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			{
			setState(115);
			match(PROPERTIES);
			setState(116);
			propertiesBlock();
			}
			setState(118);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BatonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BatonParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(LBRACE);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 2168962703366L) != 0) {
				{
				{
				setState(121);
				statement();
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(127);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(BatonParser.IF, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(BatonParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(BatonParser.WHILE, 0); }
		public TerminalNode DEF() { return getToken(BatonParser.DEF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(BatonParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		int _la;
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(IF);
				setState(130);
				parExpression();
				setState(131);
				block();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(132);
					match(ELSE);
					setState(133);
					block();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(WHILE);
				setState(137);
				parExpression();
				setState(138);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				match(DEF);
				setState(141);
				match(IDENTIFIER);
				setState(142);
				match(ASSIGNMENT);
				setState(143);
				expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
				match(IDENTIFIER);
				setState(145);
				match(ASSIGNMENT);
				setState(146);
				expression(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(147);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode EXECUTE() { return getToken(BatonParser.EXECUTE, 0); }
		public PropertiesBlockContext propertiesBlock() {
			return getRuleContext(PropertiesBlockContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(BatonParser.STRING_LITERAL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOT() { return getToken(BatonParser.DOT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case BOOL_LITERAL:
			case STRING_LITERAL:
			case NUMBER_LITERAL:
			case NULL_LITERAL:
			case IDENTIFIER:
				{
				setState(151);
				primary();
				}
				break;
			case EXECUTE:
				{
				setState(152);
				match(EXECUTE);
				setState(153);
				_la = _input.LA(1);
				if ( !(_la==STRING_LITERAL || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(154);
				propertiesBlock();
				}
				break;
			case T__0:
			case T__1:
				{
				setState(155);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(156);
				expression(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(171);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(159);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(160);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(161);
						expression(3);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(162);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(163);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(164);
						expression(2);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(165);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(166);
						match(DOT);
						setState(167);
						match(IDENTIFIER);
						setState(169);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
						case 1:
							{
							setState(168);
							expression(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode NUMBER_LITERAL() { return getToken(BatonParser.NUMBER_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(BatonParser.STRING_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(BatonParser.BOOL_LITERAL, 0); }
		public TerminalNode NULL_LITERAL() { return getToken(BatonParser.NULL_LITERAL, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_primary);
		try {
			setState(182);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(NUMBER_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(STRING_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(178);
				match(BOOL_LITERAL);
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(179);
				match(NULL_LITERAL);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				match(IDENTIFIER);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(181);
				parExpression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BatonParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(BatonParser.RPAREN, 0); }
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterParExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitParExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitParExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(LPAREN);
			setState(185);
			expression(0);
			setState(186);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertiesBlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(BatonParser.LBRACE, 0); }
		public List<PropertiesPairContext> propertiesPair() {
			return getRuleContexts(PropertiesPairContext.class);
		}
		public PropertiesPairContext propertiesPair(int i) {
			return getRuleContext(PropertiesPairContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(BatonParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BatonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BatonParser.COMMA, i);
		}
		public PropertiesBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertiesBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterPropertiesBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitPropertiesBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitPropertiesBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertiesBlockContext propertiesBlock() throws RecognitionException {
		PropertiesBlockContext _localctx = new PropertiesBlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_propertiesBlock);
		int _la;
		try {
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(188);
				match(LBRACE);
				setState(189);
				propertiesPair();
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(190);
					match(COMMA);
					setState(191);
					propertiesPair();
					}
					}
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(197);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(LBRACE);
				setState(200);
				match(RBRACE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertiesPairContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(BatonParser.STRING_LITERAL, 0); }
		public TerminalNode COLON() { return getToken(BatonParser.COLON, 0); }
		public PropertiesValueContext propertiesValue() {
			return getRuleContext(PropertiesValueContext.class,0);
		}
		public PropertiesPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertiesPair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterPropertiesPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitPropertiesPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitPropertiesPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertiesPairContext propertiesPair() throws RecognitionException {
		PropertiesPairContext _localctx = new PropertiesPairContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_propertiesPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(STRING_LITERAL);
			setState(204);
			match(COLON);
			setState(205);
			propertiesValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertiesArrayContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(BatonParser.LBRACK, 0); }
		public List<PropertiesValueContext> propertiesValue() {
			return getRuleContexts(PropertiesValueContext.class);
		}
		public PropertiesValueContext propertiesValue(int i) {
			return getRuleContext(PropertiesValueContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(BatonParser.RBRACK, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BatonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BatonParser.COMMA, i);
		}
		public PropertiesArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertiesArray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterPropertiesArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitPropertiesArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitPropertiesArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertiesArrayContext propertiesArray() throws RecognitionException {
		PropertiesArrayContext _localctx = new PropertiesArrayContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_propertiesArray);
		int _la;
		try {
			setState(220);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(207);
				match(LBRACK);
				setState(208);
				propertiesValue();
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(209);
					match(COMMA);
					setState(210);
					propertiesValue();
					}
					}
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(216);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(LBRACK);
				setState(219);
				match(RBRACK);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertiesValueContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(BatonParser.STRING_LITERAL, 0); }
		public TerminalNode NUMBER_LITERAL() { return getToken(BatonParser.NUMBER_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(BatonParser.BOOL_LITERAL, 0); }
		public TerminalNode NULL_LITERAL() { return getToken(BatonParser.NULL_LITERAL, 0); }
		public PropertiesArrayContext propertiesArray() {
			return getRuleContext(PropertiesArrayContext.class,0);
		}
		public PropertiesBlockContext propertiesBlock() {
			return getRuleContext(PropertiesBlockContext.class,0);
		}
		public PropertiesValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertiesValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterPropertiesValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitPropertiesValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitPropertiesValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertiesValueContext propertiesValue() throws RecognitionException {
		PropertiesValueContext _localctx = new PropertiesValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_propertiesValue);
		try {
			setState(229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(222);
				match(IDENTIFIER);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(STRING_LITERAL);
				}
				break;
			case NUMBER_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				match(NUMBER_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(225);
				match(BOOL_LITERAL);
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(226);
				match(NULL_LITERAL);
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 6);
				{
				setState(227);
				propertiesArray();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 7);
				{
				setState(228);
				propertiesBlock();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u00e8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0000\u0001\u0000\u0005\u0000+\b\u0000\n\u0000\f\u0000"+
		".\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00028\b\u0002\n\u0002\f\u0002"+
		";\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005K\b\u0005\u0003\u0005"+
		"M\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005R\b\u0005\u0003"+
		"\u0005T\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005X\b\u0005\u0001\u0005"+
		"\u0004\u0005[\b\u0005\u000b\u0005\f\u0005\\\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007i\b\u0007\u0003\u0007k\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007p\b\u0007\u0003\u0007r\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0005\b{\b\b\n\b\f\b~\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u0087\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0095\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u009e\b\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00aa\b\n\u0005\n\u00ac\b\n\n\n\f\n\u00af\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00b7"+
		"\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u00c1\b\r\n\r\f\r\u00c4\t\r\u0001\r\u0001\r\u0001\r\u0001\r"+
		"\u0003\r\u00ca\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00d4\b\u000f\n"+
		"\u000f\f\u000f\u00d7\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00dd\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00e6\b\u0010\u0001"+
		"\u0010\u0000\u0001\u0014\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\u0005\u0002\u0000\u0012"+
		"\u0015((\u0002\u0000%%((\u0001\u0000\u0001\u0002\u0001\u0000\u0003\u0004"+
		"\u0001\u0000\u0005\u0006\u00fe\u0000%\u0001\u0000\u0000\u0000\u0002/\u0001"+
		"\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000\u0006>\u0001\u0000\u0000"+
		"\u0000\bB\u0001\u0000\u0000\u0000\nF\u0001\u0000\u0000\u0000\f`\u0001"+
		"\u0000\u0000\u0000\u000ed\u0001\u0000\u0000\u0000\u0010x\u0001\u0000\u0000"+
		"\u0000\u0012\u0094\u0001\u0000\u0000\u0000\u0014\u009d\u0001\u0000\u0000"+
		"\u0000\u0016\u00b6\u0001\u0000\u0000\u0000\u0018\u00b8\u0001\u0000\u0000"+
		"\u0000\u001a\u00c9\u0001\u0000\u0000\u0000\u001c\u00cb\u0001\u0000\u0000"+
		"\u0000\u001e\u00dc\u0001\u0000\u0000\u0000 \u00e5\u0001\u0000\u0000\u0000"+
		"\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001\u0000"+
		"\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&(\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000(,\u0003\b\u0004\u0000)+"+
		"\u0003\f\u0006\u0000*)\u0001\u0000\u0000\u0000+.\u0001\u0000\u0000\u0000"+
		",*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-\u0001\u0001\u0000"+
		"\u0000\u0000.,\u0001\u0000\u0000\u0000/0\u0005\f\u0000\u000001\u0005("+
		"\u0000\u000012\u0003\u0004\u0002\u00002\u0003\u0001\u0000\u0000\u0000"+
		"34\u0005\u0018\u0000\u000049\u0003\u0006\u0003\u000056\u0005\u001d\u0000"+
		"\u000068\u0003\u0006\u0003\u000075\u0001\u0000\u0000\u00008;\u0001\u0000"+
		"\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:<\u0001"+
		"\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000<=\u0005\u0019\u0000\u0000"+
		"=\u0005\u0001\u0000\u0000\u0000>?\u0005%\u0000\u0000?@\u0005\u001c\u0000"+
		"\u0000@A\u0007\u0000\u0000\u0000A\u0007\u0001\u0000\u0000\u0000BC\u0005"+
		"\n\u0000\u0000CD\u0005(\u0000\u0000DE\u0003\n\u0005\u0000E\t\u0001\u0000"+
		"\u0000\u0000FL\u0005\u0018\u0000\u0000GJ\u0005\u000f\u0000\u0000HK\u0003"+
		"\u0004\u0002\u0000IK\u0005(\u0000\u0000JH\u0001\u0000\u0000\u0000JI\u0001"+
		"\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000LG\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MS\u0001\u0000\u0000\u0000NQ\u0005\u0010\u0000"+
		"\u0000OR\u0003\u0004\u0002\u0000PR\u0005(\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000QP\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SN\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000UV\u0005"+
		"\u0011\u0000\u0000VX\u0003\u001a\r\u0000WU\u0001\u0000\u0000\u0000WX\u0001"+
		"\u0000\u0000\u0000XZ\u0001\u0000\u0000\u0000Y[\u0003\u0012\t\u0000ZY\u0001"+
		"\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000"+
		"\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0005\u0019\u0000"+
		"\u0000_\u000b\u0001\u0000\u0000\u0000`a\u0005\u000b\u0000\u0000ab\u0005"+
		"(\u0000\u0000bc\u0003\u000e\u0007\u0000c\r\u0001\u0000\u0000\u0000dj\u0005"+
		"\u0018\u0000\u0000eh\u0005\u000f\u0000\u0000fi\u0003\u0004\u0002\u0000"+
		"gi\u0005(\u0000\u0000hf\u0001\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000"+
		"ik\u0001\u0000\u0000\u0000je\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000kq\u0001\u0000\u0000\u0000lo\u0005\u0010\u0000\u0000mp\u0003\u0004"+
		"\u0002\u0000np\u0005(\u0000\u0000om\u0001\u0000\u0000\u0000on\u0001\u0000"+
		"\u0000\u0000pr\u0001\u0000\u0000\u0000ql\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0005\u0011\u0000\u0000"+
		"tu\u0003\u001a\r\u0000uv\u0001\u0000\u0000\u0000vw\u0005\u0019\u0000\u0000"+
		"w\u000f\u0001\u0000\u0000\u0000x|\u0005\u0018\u0000\u0000y{\u0003\u0012"+
		"\t\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000"+
		"\u0000\u0000|}\u0001\u0000\u0000\u0000}\u007f\u0001\u0000\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000\u007f\u0080\u0005\u0019\u0000\u0000\u0080\u0011"+
		"\u0001\u0000\u0000\u0000\u0081\u0082\u0005 \u0000\u0000\u0082\u0083\u0003"+
		"\u0018\f\u0000\u0083\u0086\u0003\u0010\b\u0000\u0084\u0085\u0005!\u0000"+
		"\u0000\u0085\u0087\u0003\u0010\b\u0000\u0086\u0084\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0095\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0005#\u0000\u0000\u0089\u008a\u0003\u0018\f\u0000\u008a"+
		"\u008b\u0003\u0010\b\u0000\u008b\u0095\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0005\r\u0000\u0000\u008d\u008e\u0005(\u0000\u0000\u008e\u008f\u0005"+
		"\u001f\u0000\u0000\u008f\u0095\u0003\u0014\n\u0000\u0090\u0091\u0005("+
		"\u0000\u0000\u0091\u0092\u0005\u001f\u0000\u0000\u0092\u0095\u0003\u0014"+
		"\n\u0000\u0093\u0095\u0003\u0014\n\u0000\u0094\u0081\u0001\u0000\u0000"+
		"\u0000\u0094\u0088\u0001\u0000\u0000\u0000\u0094\u008c\u0001\u0000\u0000"+
		"\u0000\u0094\u0090\u0001\u0000\u0000\u0000\u0094\u0093\u0001\u0000\u0000"+
		"\u0000\u0095\u0013\u0001\u0000\u0000\u0000\u0096\u0097\u0006\n\uffff\uffff"+
		"\u0000\u0097\u009e\u0003\u0016\u000b\u0000\u0098\u0099\u0005\u000e\u0000"+
		"\u0000\u0099\u009a\u0007\u0001\u0000\u0000\u009a\u009e\u0003\u001a\r\u0000"+
		"\u009b\u009c\u0007\u0002\u0000\u0000\u009c\u009e\u0003\u0014\n\u0003\u009d"+
		"\u0096\u0001\u0000\u0000\u0000\u009d\u0098\u0001\u0000\u0000\u0000\u009d"+
		"\u009b\u0001\u0000\u0000\u0000\u009e\u00ad\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\n\u0002\u0000\u0000\u00a0\u00a1\u0007\u0003\u0000\u0000\u00a1\u00ac"+
		"\u0003\u0014\n\u0003\u00a2\u00a3\n\u0001\u0000\u0000\u00a3\u00a4\u0007"+
		"\u0004\u0000\u0000\u00a4\u00ac\u0003\u0014\n\u0002\u00a5\u00a6\n\u0004"+
		"\u0000\u0000\u00a6\u00a7\u0005\u001e\u0000\u0000\u00a7\u00a9\u0005(\u0000"+
		"\u0000\u00a8\u00aa\u0003\u0014\n\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ab\u009f\u0001\u0000\u0000\u0000\u00ab\u00a2\u0001\u0000\u0000\u0000"+
		"\u00ab\u00a5\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000"+
		"\u00ae\u0015\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b7\u0005&\u0000\u0000\u00b1\u00b7\u0005%\u0000\u0000\u00b2\u00b7"+
		"\u0005$\u0000\u0000\u00b3\u00b7\u0005\'\u0000\u0000\u00b4\u00b7\u0005"+
		"(\u0000\u0000\u00b5\u00b7\u0003\u0018\f\u0000\u00b6\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b1\u0001\u0000\u0000\u0000\u00b6\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b7\u0017\u0001\u0000"+
		"\u0000\u0000\u00b8\u00b9\u0005\u0016\u0000\u0000\u00b9\u00ba\u0003\u0014"+
		"\n\u0000\u00ba\u00bb\u0005\u0017\u0000\u0000\u00bb\u0019\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0005\u0018\u0000\u0000\u00bd\u00c2\u0003\u001c\u000e"+
		"\u0000\u00be\u00bf\u0005\u001d\u0000\u0000\u00bf\u00c1\u0003\u001c\u000e"+
		"\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0005\u0019\u0000\u0000\u00c6\u00ca\u0001\u0000\u0000"+
		"\u0000\u00c7\u00c8\u0005\u0018\u0000\u0000\u00c8\u00ca\u0005\u0019\u0000"+
		"\u0000\u00c9\u00bc\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001\u0000\u0000"+
		"\u0000\u00ca\u001b\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005%\u0000\u0000"+
		"\u00cc\u00cd\u0005\u001c\u0000\u0000\u00cd\u00ce\u0003 \u0010\u0000\u00ce"+
		"\u001d\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005\u001a\u0000\u0000\u00d0"+
		"\u00d5\u0003 \u0010\u0000\u00d1\u00d2\u0005\u001d\u0000\u0000\u00d2\u00d4"+
		"\u0003 \u0010\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001"+
		"\u0000\u0000\u0000\u00d8\u00d9\u0005\u001b\u0000\u0000\u00d9\u00dd\u0001"+
		"\u0000\u0000\u0000\u00da\u00db\u0005\u001a\u0000\u0000\u00db\u00dd\u0005"+
		"\u001b\u0000\u0000\u00dc\u00cf\u0001\u0000\u0000\u0000\u00dc\u00da\u0001"+
		"\u0000\u0000\u0000\u00dd\u001f\u0001\u0000\u0000\u0000\u00de\u00e6\u0005"+
		"(\u0000\u0000\u00df\u00e6\u0005%\u0000\u0000\u00e0\u00e6\u0005&\u0000"+
		"\u0000\u00e1\u00e6\u0005$\u0000\u0000\u00e2\u00e6\u0005\'\u0000\u0000"+
		"\u00e3\u00e6\u0003\u001e\u000f\u0000\u00e4\u00e6\u0003\u001a\r\u0000\u00e5"+
		"\u00de\u0001\u0000\u0000\u0000\u00e5\u00df\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e5\u00e1\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e6!\u0001\u0000\u0000\u0000\u001a%,"+
		"9JLQSW\\hjoq|\u0086\u0094\u009d\u00a9\u00ab\u00ad\u00b6\u00c2\u00c9\u00d5"+
		"\u00dc\u00e5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}