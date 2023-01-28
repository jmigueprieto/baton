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
		WORKFLOW=10, TASK=11, STRUCT=12, DEF=13, EXECUTE=14, TYPE_STRING=15, TYPE_BOOLEAN=16, 
		TYPE_INTEGER=17, TYPE_DECIMAL=18, LPAREN=19, RPAREN=20, LBRACE=21, RBRACE=22, 
		LBRACK=23, RBRACK=24, COLON=25, COMMA=26, DOT=27, ASSIGNMENT=28, IF=29, 
		ELSE=30, VAR=31, WHILE=32, RETURN=33, LITERAL_BOOL=34, LITERAL_STRING=35, 
		LITERAL_INTEGER=36, LITERAL_DECIMAL=37, LITERAL_NULL=38, IDENTIFIER=39;
	public static final int
		RULE_batonUnit = 0, RULE_structDeclaration = 1, RULE_structDef = 2, RULE_structKeyValuePair = 3, 
		RULE_type = 4, RULE_taskDeclaration = 5, RULE_object = 6, RULE_keyValuePair = 7, 
		RULE_key = 8, RULE_value = 9, RULE_literal = 10, RULE_parameters = 11, 
		RULE_array = 12, RULE_workflowDeclaration = 13, RULE_workflowOutput = 14, 
		RULE_block = 15, RULE_statement = 16, RULE_expression = 17, RULE_parExpression = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"batonUnit", "structDeclaration", "structDef", "structKeyValuePair", 
			"type", "taskDeclaration", "object", "keyValuePair", "key", "value", 
			"literal", "parameters", "array", "workflowDeclaration", "workflowOutput", 
			"block", "statement", "expression", "parExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", "'-'", "'=='", "'!='", "'&&'", "'||'", null, null, null, 
			"'workflow'", "'task'", "'struct'", "'def'", "'execute'", "'String'", 
			"'Boolean'", "'Integer'", "'Decimal'", "'('", "')'", "'{'", "'}'", "'['", 
			"']'", "':'", "','", "'.'", "'='", "'if'", "'else'", "'var'", "'while'", 
			"'return'", null, null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", 
			"WORKFLOW", "TASK", "STRUCT", "DEF", "EXECUTE", "TYPE_STRING", "TYPE_BOOLEAN", 
			"TYPE_INTEGER", "TYPE_DECIMAL", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"LBRACK", "RBRACK", "COLON", "COMMA", "DOT", "ASSIGNMENT", "IF", "ELSE", 
			"VAR", "WHILE", "RETURN", "LITERAL_BOOL", "LITERAL_STRING", "LITERAL_INTEGER", 
			"LITERAL_DECIMAL", "LITERAL_NULL", "IDENTIFIER"
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
		public TerminalNode EOF() { return getToken(BatonParser.EOF, 0); }
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
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TASK || _la==STRUCT) {
				{
				setState(40);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRUCT:
					{
					setState(38);
					structDeclaration();
					}
					break;
				case TASK:
					{
					setState(39);
					taskDeclaration();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
			workflowDeclaration();
			setState(46);
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
		public TerminalNode STRUCT() { return getToken(BatonParser.STRUCT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
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
			setState(48);
			match(STRUCT);
			setState(49);
			match(IDENTIFIER);
			setState(50);
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
		public TerminalNode LBRACE() { return getToken(BatonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(BatonParser.RBRACE, 0); }
		public List<StructKeyValuePairContext> structKeyValuePair() {
			return getRuleContexts(StructKeyValuePairContext.class);
		}
		public StructKeyValuePairContext structKeyValuePair(int i) {
			return getRuleContext(StructKeyValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BatonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BatonParser.COMMA, i);
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
			setState(52);
			match(LBRACE);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LITERAL_STRING || _la==IDENTIFIER) {
				{
				setState(53);
				structKeyValuePair();
				}
			}

			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(56);
				match(COMMA);
				setState(57);
				structKeyValuePair();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
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
	public static class StructKeyValuePairContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BatonParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public StructDefContext structDef() {
			return getRuleContext(StructDefContext.class,0);
		}
		public StructKeyValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structKeyValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterStructKeyValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitStructKeyValuePair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitStructKeyValuePair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructKeyValuePairContext structKeyValuePair() throws RecognitionException {
		StructKeyValuePairContext _localctx = new StructKeyValuePairContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structKeyValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			key();
			setState(66);
			match(COLON);
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_STRING:
			case TYPE_BOOLEAN:
			case TYPE_INTEGER:
			case TYPE_DECIMAL:
				{
				setState(67);
				type();
				}
				break;
			case IDENTIFIER:
				{
				setState(68);
				match(IDENTIFIER);
				}
				break;
			case LBRACE:
				{
				setState(69);
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
		public TerminalNode TYPE_BOOLEAN() { return getToken(BatonParser.TYPE_BOOLEAN, 0); }
		public TerminalNode TYPE_STRING() { return getToken(BatonParser.TYPE_STRING, 0); }
		public TerminalNode TYPE_INTEGER() { return getToken(BatonParser.TYPE_INTEGER, 0); }
		public TerminalNode TYPE_DECIMAL() { return getToken(BatonParser.TYPE_DECIMAL, 0); }
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
			setState(72);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 491520L) != 0) ) {
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
		public TerminalNode TASK() { return getToken(BatonParser.TASK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
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
			setState(74);
			match(TASK);
			setState(75);
			match(IDENTIFIER);
			setState(76);
			object();
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
		public TerminalNode LBRACE() { return getToken(BatonParser.LBRACE, 0); }
		public List<KeyValuePairContext> keyValuePair() {
			return getRuleContexts(KeyValuePairContext.class);
		}
		public KeyValuePairContext keyValuePair(int i) {
			return getRuleContext(KeyValuePairContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(BatonParser.RBRACE, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BatonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BatonParser.COMMA, i);
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
		enterRule(_localctx, 12, RULE_object);
		int _la;
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				match(LBRACE);
				setState(79);
				keyValuePair();
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(80);
					match(COMMA);
					setState(81);
					keyValuePair();
					}
					}
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(87);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(LBRACE);
				setState(90);
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
	public static class KeyValuePairContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BatonParser.COLON, 0); }
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
		enterRule(_localctx, 14, RULE_keyValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			key();
			setState(94);
			match(COLON);
			setState(95);
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
		public TerminalNode LITERAL_STRING() { return getToken(BatonParser.LITERAL_STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 16, RULE_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
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
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
		enterRule(_localctx, 18, RULE_value);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(IDENTIFIER);
				}
				break;
			case TYPE_STRING:
			case TYPE_BOOLEAN:
			case TYPE_INTEGER:
			case TYPE_DECIMAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(100);
				type();
				}
				break;
			case LITERAL_BOOL:
			case LITERAL_STRING:
			case LITERAL_INTEGER:
			case LITERAL_DECIMAL:
			case LITERAL_NULL:
				enterOuterAlt(_localctx, 3);
				{
				setState(101);
				literal();
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 4);
				{
				setState(102);
				array();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 5);
				{
				setState(103);
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
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode LITERAL_STRING() { return getToken(BatonParser.LITERAL_STRING, 0); }
		public TerminalNode LITERAL_INTEGER() { return getToken(BatonParser.LITERAL_INTEGER, 0); }
		public TerminalNode LITERAL_DECIMAL() { return getToken(BatonParser.LITERAL_DECIMAL, 0); }
		public TerminalNode LITERAL_BOOL() { return getToken(BatonParser.LITERAL_BOOL, 0); }
		public TerminalNode LITERAL_NULL() { return getToken(BatonParser.LITERAL_NULL, 0); }
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
		enterRule(_localctx, 20, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 532575944704L) != 0) ) {
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
	public static class ParametersContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(BatonParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(BatonParser.RPAREN, 0); }
		public List<KeyValuePairContext> keyValuePair() {
			return getRuleContexts(KeyValuePairContext.class);
		}
		public KeyValuePairContext keyValuePair(int i) {
			return getRuleContext(KeyValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(BatonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BatonParser.COMMA, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(LPAREN);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LITERAL_STRING || _la==IDENTIFIER) {
				{
				setState(109);
				keyValuePair();
				}
			}

			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(112);
				match(COMMA);
				setState(113);
				keyValuePair();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
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
	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(BatonParser.LBRACK, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(BatonParser.RBRACK, 0); }
		public List<TerminalNode> COMMA() { return getTokens(BatonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(BatonParser.COMMA, i);
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
		enterRule(_localctx, 24, RULE_array);
		int _la;
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(LBRACK);
				setState(122);
				value();
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(123);
					match(COMMA);
					setState(124);
					value();
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(130);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(LBRACK);
				setState(133);
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
	public static class WorkflowDeclarationContext extends ParserRuleContext {
		public TerminalNode WORKFLOW() { return getToken(BatonParser.WORKFLOW, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BatonParser.COLON, 0); }
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
		enterRule(_localctx, 26, RULE_workflowDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(WORKFLOW);
			setState(137);
			match(IDENTIFIER);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(138);
				parameters();
				}
			}

			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(141);
				match(COLON);
				setState(142);
				workflowOutput();
				}
			}

			setState(145);
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
	public static class WorkflowOutputContext extends ParserRuleContext {
		public StructDefContext structDef() {
			return getRuleContext(StructDefContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 28, RULE_workflowOutput);
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				structDef();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
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
		enterRule(_localctx, 30, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(LBRACE);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 1095754080262L) != 0) {
				{
				{
				setState(152);
				statement();
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(158);
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
		public TerminalNode WHILE() { return getToken(BatonParser.WHILE, 0); }
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
		public TerminalNode RETURN() { return getToken(BatonParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	public static class AssignmentStmtContext extends StatementContext {
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(BatonParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStmtContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterAssignmentStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitAssignmentStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitAssignmentStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclStmtContext extends StatementContext {
		public TerminalNode DEF() { return getToken(BatonParser.DEF, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(BatonParser.ASSIGNMENT, 0); }
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
		enterRule(_localctx, 32, RULE_statement);
		int _la;
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(IF);
				setState(161);
				parExpression();
				setState(162);
				block();
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(163);
					match(ELSE);
					setState(164);
					block();
					}
				}

				}
				break;
			case 2:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				match(WHILE);
				setState(168);
				parExpression();
				setState(169);
				block();
				}
				break;
			case 3:
				_localctx = new VarDeclStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(DEF);
				setState(172);
				match(IDENTIFIER);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGNMENT) {
					{
					setState(173);
					match(ASSIGNMENT);
					setState(174);
					expression(0);
					}
				}

				}
				break;
			case 4:
				_localctx = new AssignmentStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
				match(IDENTIFIER);
				setState(178);
				match(ASSIGNMENT);
				setState(179);
				expression(0);
				}
				break;
			case 5:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				match(RETURN);
				setState(181);
				expression(0);
				}
				break;
			case 6:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(182);
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
	public static class PrefixOpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterPrefixOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitPrefixOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitPrefixOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterEqOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitEqOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitEqOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LogicOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterLogicOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitLogicOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitLogicOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExecuteContext extends ExpressionContext {
		public TerminalNode EXECUTE() { return getToken(BatonParser.EXECUTE, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public TerminalNode LITERAL_STRING() { return getToken(BatonParser.LITERAL_STRING, 0); }
		public ExecuteContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterExecute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitExecute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitExecute(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public PrimaryContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class DotOpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOT() { return getToken(BatonParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public DotOpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterDotOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitDotOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitDotOp(this);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
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
				_localctx = new PrimaryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(189);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(186);
					match(IDENTIFIER);
					}
					break;
				case LITERAL_BOOL:
				case LITERAL_STRING:
				case LITERAL_INTEGER:
				case LITERAL_DECIMAL:
				case LITERAL_NULL:
					{
					setState(187);
					literal();
					}
					break;
				case LPAREN:
					{
					setState(188);
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
				_localctx = new ExecuteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(EXECUTE);
				setState(192);
				_la = _input.LA(1);
				if ( !(_la==LITERAL_STRING || _la==IDENTIFIER) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(193);
				parameters();
				}
				break;
			case T__0:
			case T__1:
				{
				_localctx = new PrefixOpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(195);
				expression(3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(210);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new EqOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(198);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(199);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__3) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(200);
						expression(3);
						}
						break;
					case 2:
						{
						_localctx = new LogicOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(201);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(202);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(203);
						expression(2);
						}
						break;
					case 3:
						{
						_localctx = new DotOpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(205);
						match(DOT);
						setState(206);
						match(IDENTIFIER);
						setState(208);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
						case 1:
							{
							setState(207);
							expression(0);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		enterRule(_localctx, 36, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(LPAREN);
			setState(216);
			expression(0);
			setState(217);
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
		case 17:
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
		"\u0004\u0001\'\u00dc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0005\u0000)\b\u0000\n\u0000\f\u0000,\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u00027\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002;\b\u0002\n\u0002\f\u0002>\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003G\b\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006S\b\u0006\n\u0006\f\u0006V\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\\\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\ti\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0003"+
		"\u000bo\b\u000b\u0001\u000b\u0001\u000b\u0005\u000bs\b\u000b\n\u000b\f"+
		"\u000bv\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0005\f~\b\f\n\f\f\f\u0081\t\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u0087\b\f\u0001\r\u0001\r\u0001\r\u0003\r\u008c\b\r\u0001\r\u0001\r"+
		"\u0003\r\u0090\b\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u0096\b\u000e\u0001\u000f\u0001\u000f\u0005\u000f\u009a\b\u000f\n\u000f"+
		"\f\u000f\u009d\t\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00a6\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00b0\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00b8\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00be\b\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00c5\b\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00d1\b\u0011"+
		"\u0005\u0011\u00d3\b\u0011\n\u0011\f\u0011\u00d6\t\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0000\u0001\"\u0013\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$\u0000\u0006\u0001\u0000\u000f\u0012\u0002\u0000##\'\'\u0001\u0000"+
		"\"&\u0001\u0000\u0001\u0002\u0001\u0000\u0003\u0004\u0001\u0000\u0005"+
		"\u0006\u00eb\u0000*\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000"+
		"\u00044\u0001\u0000\u0000\u0000\u0006A\u0001\u0000\u0000\u0000\bH\u0001"+
		"\u0000\u0000\u0000\nJ\u0001\u0000\u0000\u0000\f[\u0001\u0000\u0000\u0000"+
		"\u000e]\u0001\u0000\u0000\u0000\u0010a\u0001\u0000\u0000\u0000\u0012h"+
		"\u0001\u0000\u0000\u0000\u0014j\u0001\u0000\u0000\u0000\u0016l\u0001\u0000"+
		"\u0000\u0000\u0018\u0086\u0001\u0000\u0000\u0000\u001a\u0088\u0001\u0000"+
		"\u0000\u0000\u001c\u0095\u0001\u0000\u0000\u0000\u001e\u0097\u0001\u0000"+
		"\u0000\u0000 \u00b7\u0001\u0000\u0000\u0000\"\u00c4\u0001\u0000\u0000"+
		"\u0000$\u00d7\u0001\u0000\u0000\u0000&)\u0003\u0002\u0001\u0000\')\u0003"+
		"\n\u0005\u0000(&\u0001\u0000\u0000\u0000(\'\u0001\u0000\u0000\u0000),"+
		"\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000"+
		"\u0000+-\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000-.\u0003\u001a"+
		"\r\u0000./\u0005\u0000\u0000\u0001/\u0001\u0001\u0000\u0000\u000001\u0005"+
		"\f\u0000\u000012\u0005\'\u0000\u000023\u0003\u0004\u0002\u00003\u0003"+
		"\u0001\u0000\u0000\u000046\u0005\u0015\u0000\u000057\u0003\u0006\u0003"+
		"\u000065\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u00007<\u0001\u0000"+
		"\u0000\u000089\u0005\u001a\u0000\u00009;\u0003\u0006\u0003\u0000:8\u0001"+
		"\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000\u0000><\u0001\u0000\u0000"+
		"\u0000?@\u0005\u0016\u0000\u0000@\u0005\u0001\u0000\u0000\u0000AB\u0003"+
		"\u0010\b\u0000BF\u0005\u0019\u0000\u0000CG\u0003\b\u0004\u0000DG\u0005"+
		"\'\u0000\u0000EG\u0003\u0004\u0002\u0000FC\u0001\u0000\u0000\u0000FD\u0001"+
		"\u0000\u0000\u0000FE\u0001\u0000\u0000\u0000G\u0007\u0001\u0000\u0000"+
		"\u0000HI\u0007\u0000\u0000\u0000I\t\u0001\u0000\u0000\u0000JK\u0005\u000b"+
		"\u0000\u0000KL\u0005\'\u0000\u0000LM\u0003\f\u0006\u0000M\u000b\u0001"+
		"\u0000\u0000\u0000NO\u0005\u0015\u0000\u0000OT\u0003\u000e\u0007\u0000"+
		"PQ\u0005\u001a\u0000\u0000QS\u0003\u000e\u0007\u0000RP\u0001\u0000\u0000"+
		"\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WX\u0005"+
		"\u0016\u0000\u0000X\\\u0001\u0000\u0000\u0000YZ\u0005\u0015\u0000\u0000"+
		"Z\\\u0005\u0016\u0000\u0000[N\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000\\\r\u0001\u0000\u0000\u0000]^\u0003\u0010\b\u0000^_\u0005\u0019"+
		"\u0000\u0000_`\u0003\u0012\t\u0000`\u000f\u0001\u0000\u0000\u0000ab\u0007"+
		"\u0001\u0000\u0000b\u0011\u0001\u0000\u0000\u0000ci\u0005\'\u0000\u0000"+
		"di\u0003\b\u0004\u0000ei\u0003\u0014\n\u0000fi\u0003\u0018\f\u0000gi\u0003"+
		"\f\u0006\u0000hc\u0001\u0000\u0000\u0000hd\u0001\u0000\u0000\u0000he\u0001"+
		"\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000"+
		"i\u0013\u0001\u0000\u0000\u0000jk\u0007\u0002\u0000\u0000k\u0015\u0001"+
		"\u0000\u0000\u0000ln\u0005\u0013\u0000\u0000mo\u0003\u000e\u0007\u0000"+
		"nm\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000ot\u0001\u0000\u0000"+
		"\u0000pq\u0005\u001a\u0000\u0000qs\u0003\u000e\u0007\u0000rp\u0001\u0000"+
		"\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001"+
		"\u0000\u0000\u0000uw\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000"+
		"wx\u0005\u0014\u0000\u0000x\u0017\u0001\u0000\u0000\u0000yz\u0005\u0017"+
		"\u0000\u0000z\u007f\u0003\u0012\t\u0000{|\u0005\u001a\u0000\u0000|~\u0003"+
		"\u0012\t\u0000}{\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0082\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005\u0018\u0000\u0000\u0083\u0087\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0005\u0017\u0000\u0000\u0085\u0087\u0005\u0018\u0000\u0000\u0086"+
		"y\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000\u0000\u0087\u0019"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0005\n\u0000\u0000\u0089\u008b\u0005"+
		"\'\u0000\u0000\u008a\u008c\u0003\u0016\u000b\u0000\u008b\u008a\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0005\u0019\u0000\u0000\u008e\u0090\u0003\u001c"+
		"\u000e\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0003\u001e"+
		"\u000f\u0000\u0092\u001b\u0001\u0000\u0000\u0000\u0093\u0096\u0003\u0004"+
		"\u0002\u0000\u0094\u0096\u0005\'\u0000\u0000\u0095\u0093\u0001\u0000\u0000"+
		"\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u001d\u0001\u0000\u0000"+
		"\u0000\u0097\u009b\u0005\u0015\u0000\u0000\u0098\u009a\u0003 \u0010\u0000"+
		"\u0099\u0098\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000"+
		"\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"+
		"\u009c\u009e\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0005\u0016\u0000\u0000\u009f\u001f\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0005\u001d\u0000\u0000\u00a1\u00a2\u0003$\u0012\u0000\u00a2"+
		"\u00a5\u0003\u001e\u000f\u0000\u00a3\u00a4\u0005\u001e\u0000\u0000\u00a4"+
		"\u00a6\u0003\u001e\u000f\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a6\u00b8\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0005 \u0000\u0000\u00a8\u00a9\u0003$\u0012\u0000\u00a9\u00aa\u0003"+
		"\u001e\u000f\u0000\u00aa\u00b8\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		"\r\u0000\u0000\u00ac\u00af\u0005\'\u0000\u0000\u00ad\u00ae\u0005\u001c"+
		"\u0000\u0000\u00ae\u00b0\u0003\"\u0011\u0000\u00af\u00ad\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b2\u0005\'\u0000\u0000\u00b2\u00b3\u0005\u001c\u0000\u0000"+
		"\u00b3\u00b8\u0003\"\u0011\u0000\u00b4\u00b5\u0005!\u0000\u0000\u00b5"+
		"\u00b8\u0003\"\u0011\u0000\u00b6\u00b8\u0003\"\u0011\u0000\u00b7\u00a0"+
		"\u0001\u0000\u0000\u0000\u00b7\u00a7\u0001\u0000\u0000\u0000\u00b7\u00ab"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b1\u0001\u0000\u0000\u0000\u00b7\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8!\u0001"+
		"\u0000\u0000\u0000\u00b9\u00bd\u0006\u0011\uffff\uffff\u0000\u00ba\u00be"+
		"\u0005\'\u0000\u0000\u00bb\u00be\u0003\u0014\n\u0000\u00bc\u00be\u0003"+
		"$\u0012\u0000\u00bd\u00ba\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00be\u00c5\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c0\u0005\u000e\u0000\u0000\u00c0\u00c1\u0007\u0001"+
		"\u0000\u0000\u00c1\u00c5\u0003\u0016\u000b\u0000\u00c2\u00c3\u0007\u0003"+
		"\u0000\u0000\u00c3\u00c5\u0003\"\u0011\u0003\u00c4\u00b9\u0001\u0000\u0000"+
		"\u0000\u00c4\u00bf\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c5\u00d4\u0001\u0000\u0000\u0000\u00c6\u00c7\n\u0002\u0000\u0000"+
		"\u00c7\u00c8\u0007\u0004\u0000\u0000\u00c8\u00d3\u0003\"\u0011\u0003\u00c9"+
		"\u00ca\n\u0001\u0000\u0000\u00ca\u00cb\u0007\u0005\u0000\u0000\u00cb\u00d3"+
		"\u0003\"\u0011\u0002\u00cc\u00cd\n\u0004\u0000\u0000\u00cd\u00ce\u0005"+
		"\u001b\u0000\u0000\u00ce\u00d0\u0005\'\u0000\u0000\u00cf\u00d1\u0003\""+
		"\u0011\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u00c6\u0001\u0000"+
		"\u0000\u0000\u00d2\u00c9\u0001\u0000\u0000\u0000\u00d2\u00cc\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5#\u0001\u0000\u0000"+
		"\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005\u0013\u0000"+
		"\u0000\u00d8\u00d9\u0003\"\u0011\u0000\u00d9\u00da\u0005\u0014\u0000\u0000"+
		"\u00da%\u0001\u0000\u0000\u0000\u0018(*6<FT[hnt\u007f\u0086\u008b\u008f"+
		"\u0095\u009b\u00a5\u00af\u00b7\u00bd\u00c4\u00d0\u00d2\u00d4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}