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
public class Baton extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, COMMENT=2, LINE_COMMENT=3, WORKFLOW=4, TASK=5, STRUCT=6, DEF=7, 
		EXECUTE=8, TYPE_STRING=9, TYPE_BOOLEAN=10, TYPE_INTEGER=11, TYPE_DECIMAL=12, 
		LPAREN=13, RPAREN=14, LBRACE=15, RBRACE=16, LBRACK=17, RBRACK=18, COLON=19, 
		COMMA=20, DOT=21, ASSIGNMENT=22, NOT=23, SUB=24, ADD=25, MULT=26, DIV=27, 
		EQ=28, NEQ=29, LT=30, GT=31, LTE=32, GTE=33, AND=34, OR=35, IF=36, ELSE=37, 
		VAR=38, WHILE=39, RETURN=40, LITERAL_BOOL=41, LITERAL_STRING=42, LITERAL_INTEGER=43, 
		LITERAL_DECIMAL=44, LITERAL_NULL=45, IDENTIFIER=46;
	public static final int
		RULE_batonUnit = 0, RULE_structDeclaration = 1, RULE_structDef = 2, RULE_keyTypePair = 3, 
		RULE_type = 4, RULE_taskDeclaration = 5, RULE_taskParams = 6, RULE_workflowDeclaration = 7, 
		RULE_workflowParams = 8, RULE_workflowOutput = 9, RULE_metadataParams = 10, 
		RULE_keyValuePair = 11, RULE_key = 12, RULE_value = 13, RULE_object = 14, 
		RULE_identifier = 15, RULE_literal = 16, RULE_array = 17, RULE_block = 18, 
		RULE_statement = 19, RULE_expression = 20, RULE_execParams = 21, RULE_parExpression = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"batonUnit", "structDeclaration", "structDef", "keyTypePair", "type", 
			"taskDeclaration", "taskParams", "workflowDeclaration", "workflowParams", 
			"workflowOutput", "metadataParams", "keyValuePair", "key", "value", "object", 
			"identifier", "literal", "array", "block", "statement", "expression", 
			"execParams", "parExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'workflow'", "'task'", "'struct'", "'def'", 
			"'execute'", "'String'", "'Boolean'", "'Integer'", "'Decimal'", "'('", 
			"')'", "'{'", "'}'", "'['", "']'", "':'", "','", "'.'", "'='", "'!'", 
			"'-'", "'+'", "'*'", "'/'", "'=='", "'!='", "'<'", "'>'", "'>='", "'<='", 
			"'&&'", "'||'", "'if'", "'else'", "'var'", "'while'", "'return'", null, 
			null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WS", "COMMENT", "LINE_COMMENT", "WORKFLOW", "TASK", "STRUCT", 
			"DEF", "EXECUTE", "TYPE_STRING", "TYPE_BOOLEAN", "TYPE_INTEGER", "TYPE_DECIMAL", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "COLON", 
			"COMMA", "DOT", "ASSIGNMENT", "NOT", "SUB", "ADD", "MULT", "DIV", "EQ", 
			"NEQ", "LT", "GT", "LTE", "GTE", "AND", "OR", "IF", "ELSE", "VAR", "WHILE", 
			"RETURN", "LITERAL_BOOL", "LITERAL_STRING", "LITERAL_INTEGER", "LITERAL_DECIMAL", 
			"LITERAL_NULL", "IDENTIFIER"
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

	public Baton(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BatonUnitContext extends ParserRuleContext {
		public WorkflowDeclarationContext workflowDeclaration() {
			return getRuleContext(WorkflowDeclarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Baton.EOF, 0); }
		public List<StructDeclarationContext> structDeclaration() {
			return getRuleContexts(StructDeclarationContext.class);
		}
		public StructDeclarationContext structDeclaration(int i) {
			return getRuleContext(StructDeclarationContext.class,i);
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
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TASK || _la==STRUCT) {
				{
				setState(48);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRUCT:
					{
					setState(46);
					structDeclaration();
					}
					break;
				case TASK:
					{
					setState(47);
					taskDeclaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(53);
			workflowDeclaration();
			setState(54);
			match(EOF);
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
	public static class StructDeclarationContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(Baton.STRUCT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Baton.IDENTIFIER, 0); }
		public StructDefContext structDef() {
			return getRuleContext(StructDefContext.class,0);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_structDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(STRUCT);
			setState(57);
			match(IDENTIFIER);
			setState(58);
			structDef();
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
	public static class StructDefContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Baton.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Baton.RBRACE, 0); }
		public List<KeyTypePairContext> keyTypePair() {
			return getRuleContexts(KeyTypePairContext.class);
		}
		public KeyTypePairContext keyTypePair(int i) {
			return getRuleContext(KeyTypePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Baton.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Baton.COMMA, i);
		}
		public StructDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterStructDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitStructDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitStructDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDefContext structDef() throws RecognitionException {
		StructDefContext _localctx = new StructDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_structDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(LBRACE);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LITERAL_STRING || _la==IDENTIFIER) {
				{
				setState(61);
				keyTypePair();
				}
			}

			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(64);
				match(COMMA);
				setState(65);
				keyTypePair();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
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
	public static class KeyTypePairContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Baton.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(Baton.IDENTIFIER, 0); }
		public StructDefContext structDef() {
			return getRuleContext(StructDefContext.class,0);
		}
		public KeyTypePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyTypePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterKeyTypePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitKeyTypePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitKeyTypePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyTypePairContext keyTypePair() throws RecognitionException {
		KeyTypePairContext _localctx = new KeyTypePairContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_keyTypePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			key();
			setState(74);
			match(COLON);
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_STRING:
			case TYPE_BOOLEAN:
			case TYPE_INTEGER:
			case TYPE_DECIMAL:
				{
				setState(75);
				type();
				}
				break;
			case IDENTIFIER:
				{
				setState(76);
				match(IDENTIFIER);
				}
				break;
			case LBRACE:
				{
				setState(77);
				structDef();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TYPE_BOOLEAN() { return getToken(Baton.TYPE_BOOLEAN, 0); }
		public TerminalNode TYPE_STRING() { return getToken(Baton.TYPE_STRING, 0); }
		public TerminalNode TYPE_INTEGER() { return getToken(Baton.TYPE_INTEGER, 0); }
		public TerminalNode TYPE_DECIMAL() { return getToken(Baton.TYPE_DECIMAL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 7680L) != 0) ) {
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
	public static class TaskDeclarationContext extends ParserRuleContext {
		public TerminalNode TASK() { return getToken(Baton.TASK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Baton.IDENTIFIER, 0); }
		public TaskParamsContext taskParams() {
			return getRuleContext(TaskParamsContext.class,0);
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
		enterRule(_localctx, 10, RULE_taskDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(TASK);
			setState(83);
			match(IDENTIFIER);
			setState(84);
			taskParams();
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
	public static class TaskParamsContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Baton.LBRACE, 0); }
		public MetadataParamsContext metadataParams() {
			return getRuleContext(MetadataParamsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(Baton.RBRACE, 0); }
		public TaskParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_taskParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterTaskParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitTaskParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitTaskParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaskParamsContext taskParams() throws RecognitionException {
		TaskParamsContext _localctx = new TaskParamsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_taskParams);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(LBRACE);
			setState(87);
			metadataParams();
			setState(88);
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
	public static class WorkflowDeclarationContext extends ParserRuleContext {
		public TerminalNode WORKFLOW() { return getToken(Baton.WORKFLOW, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Baton.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WorkflowParamsContext workflowParams() {
			return getRuleContext(WorkflowParamsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Baton.COLON, 0); }
		public WorkflowOutputContext workflowOutput() {
			return getRuleContext(WorkflowOutputContext.class,0);
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
		enterRule(_localctx, 14, RULE_workflowDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(WORKFLOW);
			setState(91);
			match(IDENTIFIER);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(92);
				workflowParams();
				}
			}

			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(95);
				match(COLON);
				setState(96);
				workflowOutput();
				}
			}

			setState(99);
			block();
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
	public static class WorkflowParamsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Baton.LPAREN, 0); }
		public MetadataParamsContext metadataParams() {
			return getRuleContext(MetadataParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Baton.RPAREN, 0); }
		public WorkflowParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_workflowParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterWorkflowParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitWorkflowParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitWorkflowParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WorkflowParamsContext workflowParams() throws RecognitionException {
		WorkflowParamsContext _localctx = new WorkflowParamsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_workflowParams);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(LPAREN);
			setState(102);
			metadataParams();
			setState(103);
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
	public static class WorkflowOutputContext extends ParserRuleContext {
		public StructDefContext structDef() {
			return getRuleContext(StructDefContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(Baton.IDENTIFIER, 0); }
		public WorkflowOutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_workflowOutput; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterWorkflowOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitWorkflowOutput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitWorkflowOutput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WorkflowOutputContext workflowOutput() throws RecognitionException {
		WorkflowOutputContext _localctx = new WorkflowOutputContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_workflowOutput);
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				structDef();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(IDENTIFIER);
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
	public static class MetadataParamsContext extends ParserRuleContext {
		public KeyValuePairContext keyValuePair() {
			return getRuleContext(KeyValuePairContext.class,0);
		}
		public KeyTypePairContext keyTypePair() {
			return getRuleContext(KeyTypePairContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(Baton.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Baton.COMMA, i);
		}
		public List<MetadataParamsContext> metadataParams() {
			return getRuleContexts(MetadataParamsContext.class);
		}
		public MetadataParamsContext metadataParams(int i) {
			return getRuleContext(MetadataParamsContext.class,i);
		}
		public MetadataParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metadataParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterMetadataParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitMetadataParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitMetadataParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetadataParamsContext metadataParams() throws RecognitionException {
		MetadataParamsContext _localctx = new MetadataParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_metadataParams);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(109);
				keyValuePair();
				}
				break;
			case 2:
				{
				setState(110);
				keyTypePair();
				}
				break;
			}
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(113);
					match(COMMA);
					setState(114);
					metadataParams();
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
	public static class KeyValuePairContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Baton.COLON, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public KeyValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterKeyValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitKeyValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitKeyValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyValuePairContext keyValuePair() throws RecognitionException {
		KeyValuePairContext _localctx = new KeyValuePairContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_keyValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			key();
			setState(121);
			match(COLON);
			setState(122);
			value();
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
	public static class KeyContext extends ParserRuleContext {
		public TerminalNode LITERAL_STRING() { return getToken(Baton.LITERAL_STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Baton.IDENTIFIER, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !(_la==LITERAL_STRING || _la==IDENTIFIER) ) {
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
	public static class ValueContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_value);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				identifier();
				}
				break;
			case LITERAL_BOOL:
			case LITERAL_STRING:
			case LITERAL_INTEGER:
			case LITERAL_DECIMAL:
			case LITERAL_NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				literal();
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				array();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 4);
				{
				setState(129);
				object();
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
	public static class ObjectContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Baton.LBRACE, 0); }
		public List<KeyValuePairContext> keyValuePair() {
			return getRuleContexts(KeyValuePairContext.class);
		}
		public KeyValuePairContext keyValuePair(int i) {
			return getRuleContext(KeyValuePairContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(Baton.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Baton.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Baton.COMMA, i);
		}
		public ObjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitObject(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitObject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectContext object() throws RecognitionException {
		ObjectContext _localctx = new ObjectContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_object);
		int _la;
		try {
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(LBRACE);
				setState(133);
				keyValuePair();
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(134);
					match(COMMA);
					setState(135);
					keyValuePair();
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(LBRACE);
				setState(144);
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(Baton.IDENTIFIER, 0); }
		public List<TerminalNode> DOT() { return getTokens(Baton.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Baton.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(IDENTIFIER);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(148);
					match(DOT);
					setState(149);
					identifier();
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode LITERAL_STRING() { return getToken(Baton.LITERAL_STRING, 0); }
		public TerminalNode LITERAL_INTEGER() { return getToken(Baton.LITERAL_INTEGER, 0); }
		public TerminalNode LITERAL_DECIMAL() { return getToken(Baton.LITERAL_DECIMAL, 0); }
		public TerminalNode LITERAL_BOOL() { return getToken(Baton.LITERAL_BOOL, 0); }
		public TerminalNode LITERAL_NULL() { return getToken(Baton.LITERAL_NULL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 68169720922112L) != 0) ) {
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
	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(Baton.LBRACK, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(Baton.RBRACK, 0); }
		public List<TerminalNode> COMMA() { return getTokens(Baton.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Baton.COMMA, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_array);
		int _la;
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(LBRACK);
				setState(158);
				value();
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(159);
					match(COMMA);
					setState(160);
					value();
					}
					}
					setState(165);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(166);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(LBRACK);
				setState(169);
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Baton.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Baton.RBRACE, 0); }
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
		enterRule(_localctx, 36, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(LBRACE);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 140256460415360L) != 0) {
				{
				{
				setState(173);
				statement();
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(179);
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
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterExprStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitExprStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitExprStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(Baton.WHILE, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends StatementContext {
		public TerminalNode IF() { return getToken(Baton.IF, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Baton.ELSE, 0); }
		public IfStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(Baton.RETURN, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
		}
		public ReturnStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclStmtContext extends StatementContext {
		public TerminalNode DEF() { return getToken(Baton.DEF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Baton.IDENTIFIER, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(Baton.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterVarDeclStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitVarDeclStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitVarDeclStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statement);
		int _la;
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				match(IF);
				setState(182);
				parExpression();
				setState(183);
				block();
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(184);
					match(ELSE);
					setState(185);
					block();
					}
				}

				}
				break;
			case WHILE:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(188);
				match(WHILE);
				setState(189);
				parExpression();
				setState(190);
				block();
				}
				break;
			case DEF:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(DEF);
				setState(193);
				match(IDENTIFIER);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGNMENT) {
					{
					setState(194);
					match(ASSIGNMENT);
					setState(195);
					expression(0);
					}
				}

				}
				break;
			case RETURN:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(198);
				match(RETURN);
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(199);
					object();
					}
				}

				}
				break;
			case EXECUTE:
			case LPAREN:
			case NOT:
			case LITERAL_BOOL:
			case LITERAL_STRING:
			case LITERAL_INTEGER:
			case LITERAL_DECIMAL:
			case LITERAL_NULL:
			case IDENTIFIER:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(202);
				expression(0);
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
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegationExprContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(Baton.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegationExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterNegationExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitNegationExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitNegationExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExprContext extends ExpressionContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public PrimaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterPrimaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitPrimaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitPrimaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CompExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(Baton.EQ, 0); }
		public TerminalNode NEQ() { return getToken(Baton.NEQ, 0); }
		public TerminalNode LT() { return getToken(Baton.LT, 0); }
		public TerminalNode GT() { return getToken(Baton.GT, 0); }
		public TerminalNode LTE() { return getToken(Baton.LTE, 0); }
		public TerminalNode GTE() { return getToken(Baton.GTE, 0); }
		public CompExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitCompExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitCompExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(Baton.AND, 0); }
		public TerminalNode OR() { return getToken(Baton.OR, 0); }
		public LogicExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterLogicExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitLogicExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitLogicExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExecuteExprContext extends ExpressionContext {
		public TerminalNode EXECUTE() { return getToken(Baton.EXECUTE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(Baton.IDENTIFIER, 0); }
		public TerminalNode LITERAL_STRING() { return getToken(Baton.LITERAL_STRING, 0); }
		public ExecParamsContext execParams() {
			return getRuleContext(ExecParamsContext.class,0);
		}
		public ExecuteExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterExecuteExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitExecuteExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitExecuteExpr(this);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case LITERAL_BOOL:
			case LITERAL_STRING:
			case LITERAL_INTEGER:
			case LITERAL_DECIMAL:
			case LITERAL_NULL:
			case IDENTIFIER:
				{
				_localctx = new PrimaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(209);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(206);
					identifier();
					}
					break;
				case LITERAL_BOOL:
				case LITERAL_STRING:
				case LITERAL_INTEGER:
				case LITERAL_DECIMAL:
				case LITERAL_NULL:
					{
					setState(207);
					literal();
					}
					break;
				case LPAREN:
					{
					setState(208);
					parExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case EXECUTE:
				{
				_localctx = new ExecuteExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(211);
				match(EXECUTE);
				setState(212);
				_la = _input.LA(1);
				if ( !(_la==LITERAL_STRING || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(214);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(213);
					execParams();
					}
					break;
				}
				}
				break;
			case NOT:
				{
				_localctx = new NegationExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				match(NOT);
				setState(217);
				expression(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(226);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new CompExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(220);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(221);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 16911433728L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(222);
						expression(3);
						}
						break;
					case 2:
						{
						_localctx = new LogicExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(224);
						_la = _input.LA(1);
						if ( !(_la==AND || _la==OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(225);
						expression(2);
						}
						break;
					}
					} 
				}
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
	public static class ExecParamsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Baton.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Baton.RPAREN, 0); }
		public List<KeyValuePairContext> keyValuePair() {
			return getRuleContexts(KeyValuePairContext.class);
		}
		public KeyValuePairContext keyValuePair(int i) {
			return getRuleContext(KeyValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Baton.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Baton.COMMA, i);
		}
		public ExecParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_execParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterExecParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitExecParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitExecParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExecParamsContext execParams() throws RecognitionException {
		ExecParamsContext _localctx = new ExecParamsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_execParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(LPAREN);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LITERAL_STRING || _la==IDENTIFIER) {
				{
				setState(232);
				keyValuePair();
				}
			}

			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(235);
				match(COMMA);
				setState(236);
				keyValuePair();
				}
				}
				setState(241);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(242);
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
	public static class ParExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Baton.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Baton.RPAREN, 0); }
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
		enterRule(_localctx, 44, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(LPAREN);
			setState(245);
			expression(0);
			setState(246);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 20:
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001.\u00f9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0005\u00001\b\u0000"+
		"\n\u0000\f\u00004\t\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u0002"+
		"?\b\u0002\u0001\u0002\u0001\u0002\u0005\u0002C\b\u0002\n\u0002\f\u0002"+
		"F\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"^\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007b\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0003\tl\b\t\u0001"+
		"\n\u0001\n\u0003\np\b\n\u0001\n\u0001\n\u0005\nt\b\n\n\n\f\nw\t\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u0083\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u0089\b\u000e\n\u000e\f\u000e\u008c\t\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0092\b\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0097\b\u000f\n\u000f\f\u000f"+
		"\u009a\t\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u00a2\b\u0011\n\u0011\f\u0011\u00a5\t\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00ab\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u00af\b\u0012\n\u0012\f\u0012\u00b2\t\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u00bb\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u00c5\b\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00c9\b\u0013\u0001"+
		"\u0013\u0003\u0013\u00cc\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u00d2\b\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u00d7\b\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00db\b\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0005\u0014\u00e3\b\u0014\n\u0014\f\u0014\u00e6\t\u0014\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u00ea\b\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u00ee"+
		"\b\u0015\n\u0015\f\u0015\u00f1\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0000\u0001(\u0017\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,\u0000\u0005\u0001\u0000\t\f\u0002\u0000**..\u0001\u0000"+
		")-\u0001\u0000\u001c!\u0001\u0000\"#\u0106\u00002\u0001\u0000\u0000\u0000"+
		"\u00028\u0001\u0000\u0000\u0000\u0004<\u0001\u0000\u0000\u0000\u0006I"+
		"\u0001\u0000\u0000\u0000\bP\u0001\u0000\u0000\u0000\nR\u0001\u0000\u0000"+
		"\u0000\fV\u0001\u0000\u0000\u0000\u000eZ\u0001\u0000\u0000\u0000\u0010"+
		"e\u0001\u0000\u0000\u0000\u0012k\u0001\u0000\u0000\u0000\u0014o\u0001"+
		"\u0000\u0000\u0000\u0016x\u0001\u0000\u0000\u0000\u0018|\u0001\u0000\u0000"+
		"\u0000\u001a\u0082\u0001\u0000\u0000\u0000\u001c\u0091\u0001\u0000\u0000"+
		"\u0000\u001e\u0093\u0001\u0000\u0000\u0000 \u009b\u0001\u0000\u0000\u0000"+
		"\"\u00aa\u0001\u0000\u0000\u0000$\u00ac\u0001\u0000\u0000\u0000&\u00cb"+
		"\u0001\u0000\u0000\u0000(\u00da\u0001\u0000\u0000\u0000*\u00e7\u0001\u0000"+
		"\u0000\u0000,\u00f4\u0001\u0000\u0000\u0000.1\u0003\u0002\u0001\u0000"+
		"/1\u0003\n\u0005\u00000.\u0001\u0000\u0000\u00000/\u0001\u0000\u0000\u0000"+
		"14\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u000023\u0001\u0000\u0000"+
		"\u000035\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000056\u0003\u000e"+
		"\u0007\u000067\u0005\u0000\u0000\u00017\u0001\u0001\u0000\u0000\u0000"+
		"89\u0005\u0006\u0000\u00009:\u0005.\u0000\u0000:;\u0003\u0004\u0002\u0000"+
		";\u0003\u0001\u0000\u0000\u0000<>\u0005\u000f\u0000\u0000=?\u0003\u0006"+
		"\u0003\u0000>=\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?D\u0001"+
		"\u0000\u0000\u0000@A\u0005\u0014\u0000\u0000AC\u0003\u0006\u0003\u0000"+
		"B@\u0001\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000"+
		"\u0000DE\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000FD\u0001\u0000"+
		"\u0000\u0000GH\u0005\u0010\u0000\u0000H\u0005\u0001\u0000\u0000\u0000"+
		"IJ\u0003\u0018\f\u0000JN\u0005\u0013\u0000\u0000KO\u0003\b\u0004\u0000"+
		"LO\u0005.\u0000\u0000MO\u0003\u0004\u0002\u0000NK\u0001\u0000\u0000\u0000"+
		"NL\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000O\u0007\u0001\u0000"+
		"\u0000\u0000PQ\u0007\u0000\u0000\u0000Q\t\u0001\u0000\u0000\u0000RS\u0005"+
		"\u0005\u0000\u0000ST\u0005.\u0000\u0000TU\u0003\f\u0006\u0000U\u000b\u0001"+
		"\u0000\u0000\u0000VW\u0005\u000f\u0000\u0000WX\u0003\u0014\n\u0000XY\u0005"+
		"\u0010\u0000\u0000Y\r\u0001\u0000\u0000\u0000Z[\u0005\u0004\u0000\u0000"+
		"[]\u0005.\u0000\u0000\\^\u0003\u0010\b\u0000]\\\u0001\u0000\u0000\u0000"+
		"]^\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_`\u0005\u0013\u0000"+
		"\u0000`b\u0003\u0012\t\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000cd\u0003$\u0012\u0000d\u000f\u0001\u0000"+
		"\u0000\u0000ef\u0005\r\u0000\u0000fg\u0003\u0014\n\u0000gh\u0005\u000e"+
		"\u0000\u0000h\u0011\u0001\u0000\u0000\u0000il\u0003\u0004\u0002\u0000"+
		"jl\u0005.\u0000\u0000ki\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000\u0000"+
		"l\u0013\u0001\u0000\u0000\u0000mp\u0003\u0016\u000b\u0000np\u0003\u0006"+
		"\u0003\u0000om\u0001\u0000\u0000\u0000on\u0001\u0000\u0000\u0000op\u0001"+
		"\u0000\u0000\u0000pu\u0001\u0000\u0000\u0000qr\u0005\u0014\u0000\u0000"+
		"rt\u0003\u0014\n\u0000sq\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v\u0015\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000xy\u0003\u0018\f\u0000yz\u0005\u0013"+
		"\u0000\u0000z{\u0003\u001a\r\u0000{\u0017\u0001\u0000\u0000\u0000|}\u0007"+
		"\u0001\u0000\u0000}\u0019\u0001\u0000\u0000\u0000~\u0083\u0003\u001e\u000f"+
		"\u0000\u007f\u0083\u0003 \u0010\u0000\u0080\u0083\u0003\"\u0011\u0000"+
		"\u0081\u0083\u0003\u001c\u000e\u0000\u0082~\u0001\u0000\u0000\u0000\u0082"+
		"\u007f\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082"+
		"\u0081\u0001\u0000\u0000\u0000\u0083\u001b\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0005\u000f\u0000\u0000\u0085\u008a\u0003\u0016\u000b\u0000\u0086"+
		"\u0087\u0005\u0014\u0000\u0000\u0087\u0089\u0003\u0016\u000b\u0000\u0088"+
		"\u0086\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a"+
		"\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b"+
		"\u008d\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d"+
		"\u008e\u0005\u0010\u0000\u0000\u008e\u0092\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0005\u000f\u0000\u0000\u0090\u0092\u0005\u0010\u0000\u0000\u0091"+
		"\u0084\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092"+
		"\u001d\u0001\u0000\u0000\u0000\u0093\u0098\u0005.\u0000\u0000\u0094\u0095"+
		"\u0005\u0015\u0000\u0000\u0095\u0097\u0003\u001e\u000f\u0000\u0096\u0094"+
		"\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096"+
		"\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u001f"+
		"\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0007\u0002\u0000\u0000\u009c!\u0001\u0000\u0000\u0000\u009d\u009e\u0005"+
		"\u0011\u0000\u0000\u009e\u00a3\u0003\u001a\r\u0000\u009f\u00a0\u0005\u0014"+
		"\u0000\u0000\u00a0\u00a2\u0003\u001a\r\u0000\u00a1\u009f\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0012\u0000"+
		"\u0000\u00a7\u00ab\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u0011\u0000"+
		"\u0000\u00a9\u00ab\u0005\u0012\u0000\u0000\u00aa\u009d\u0001\u0000\u0000"+
		"\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab#\u0001\u0000\u0000\u0000"+
		"\u00ac\u00b0\u0005\u000f\u0000\u0000\u00ad\u00af\u0003&\u0013\u0000\u00ae"+
		"\u00ad\u0001\u0000\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0"+
		"\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0005\u0010\u0000\u0000\u00b4%\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0005$\u0000\u0000\u00b6\u00b7\u0003,\u0016\u0000\u00b7\u00ba\u0003$"+
		"\u0012\u0000\u00b8\u00b9\u0005%\u0000\u0000\u00b9\u00bb\u0003$\u0012\u0000"+
		"\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bb\u00cc\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\'\u0000\u0000\u00bd"+
		"\u00be\u0003,\u0016\u0000\u00be\u00bf\u0003$\u0012\u0000\u00bf\u00cc\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c1\u0005\u0007\u0000\u0000\u00c1\u00c4\u0005"+
		".\u0000\u0000\u00c2\u00c3\u0005\u0016\u0000\u0000\u00c3\u00c5\u0003(\u0014"+
		"\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c5\u00cc\u0001\u0000\u0000\u0000\u00c6\u00c8\u0005(\u0000\u0000"+
		"\u00c7\u00c9\u0003\u001c\u000e\u0000\u00c8\u00c7\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cc\u0003(\u0014\u0000\u00cb\u00b5\u0001\u0000\u0000\u0000\u00cb"+
		"\u00bc\u0001\u0000\u0000\u0000\u00cb\u00c0\u0001\u0000\u0000\u0000\u00cb"+
		"\u00c6\u0001\u0000\u0000\u0000\u00cb\u00ca\u0001\u0000\u0000\u0000\u00cc"+
		"\'\u0001\u0000\u0000\u0000\u00cd\u00d1\u0006\u0014\uffff\uffff\u0000\u00ce"+
		"\u00d2\u0003\u001e\u000f\u0000\u00cf\u00d2\u0003 \u0010\u0000\u00d0\u00d2"+
		"\u0003,\u0016\u0000\u00d1\u00ce\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2\u00db\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0005\b\u0000\u0000\u00d4\u00d6\u0007\u0001"+
		"\u0000\u0000\u00d5\u00d7\u0003*\u0015\u0000\u00d6\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00db\u0001\u0000\u0000"+
		"\u0000\u00d8\u00d9\u0005\u0017\u0000\u0000\u00d9\u00db\u0003(\u0014\u0003"+
		"\u00da\u00cd\u0001\u0000\u0000\u0000\u00da\u00d3\u0001\u0000\u0000\u0000"+
		"\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00e4\u0001\u0000\u0000\u0000"+
		"\u00dc\u00dd\n\u0002\u0000\u0000\u00dd\u00de\u0007\u0003\u0000\u0000\u00de"+
		"\u00e3\u0003(\u0014\u0003\u00df\u00e0\n\u0001\u0000\u0000\u00e0\u00e1"+
		"\u0007\u0004\u0000\u0000\u00e1\u00e3\u0003(\u0014\u0002\u00e2\u00dc\u0001"+
		"\u0000\u0000\u0000\u00e2\u00df\u0001\u0000\u0000\u0000\u00e3\u00e6\u0001"+
		"\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e5)\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e9\u0005\r\u0000\u0000\u00e8\u00ea\u0003\u0016\u000b"+
		"\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ea\u00ef\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005\u0014\u0000"+
		"\u0000\u00ec\u00ee\u0003\u0016\u000b\u0000\u00ed\u00eb\u0001\u0000\u0000"+
		"\u0000\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005\u000e\u0000"+
		"\u0000\u00f3+\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\r\u0000\u0000"+
		"\u00f5\u00f6\u0003(\u0014\u0000\u00f6\u00f7\u0005\u000e\u0000\u0000\u00f7"+
		"-\u0001\u0000\u0000\u0000\u001c02>DN]akou\u0082\u008a\u0091\u0098\u00a3"+
		"\u00aa\u00b0\u00ba\u00c4\u00c8\u00cb\u00d1\u00d6\u00da\u00e2\u00e4\u00e9"+
		"\u00ef";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}