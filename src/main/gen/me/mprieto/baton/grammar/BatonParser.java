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
		WORKFLOW=10, TASK=11, TYPE=12, DEF=13, EXECUTE=14, TYPE_STRING=15, TYPE_BOOLEAN=16, 
		TYPE_INTEGER=17, TYPE_DECIMAL=18, LPAREN=19, RPAREN=20, LBRACE=21, RBRACE=22, 
		LBRACK=23, RBRACK=24, COLON=25, COMMA=26, DOT=27, ASSIGNMENT=28, IF=29, 
		ELSE=30, VAR=31, WHILE=32, RETURN=33, BOOL_LITERAL=34, STRING_LITERAL=35, 
		NUMBER_LITERAL=36, NULL_LITERAL=37, IDENTIFIER=38;
	public static final int
		RULE_batonUnit = 0, RULE_typeDeclaration = 1, RULE_taskDeclaration = 2, 
		RULE_parameters = 3, RULE_keyValuePair = 4, RULE_key = 5, RULE_type = 6, 
		RULE_customType = 7, RULE_object = 8, RULE_array = 9, RULE_value = 10, 
		RULE_workflowDeclaration = 11, RULE_workflowBlock = 12, RULE_block = 13, 
		RULE_statement = 14, RULE_returnStatement = 15, RULE_expression = 16, 
		RULE_primary = 17, RULE_parExpression = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"batonUnit", "typeDeclaration", "taskDeclaration", "parameters", "keyValuePair", 
			"key", "type", "customType", "object", "array", "value", "workflowDeclaration", 
			"workflowBlock", "block", "statement", "returnStatement", "expression", 
			"primary", "parExpression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", "'-'", "'=='", "'!='", "'&&'", "'||'", null, null, null, 
			"'workflow'", "'task'", "'type'", "'def'", "'execute'", "'String'", "'Boolean'", 
			"'Integer'", "'Decimal'", "'('", "')'", "'{'", "'}'", "'['", "']'", "':'", 
			"','", "'.'", "'='", "'if'", "'else'", "'var'", "'while'", "'return'", 
			null, null, null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "WS", "COMMENT", "LINE_COMMENT", 
			"WORKFLOW", "TASK", "TYPE", "DEF", "EXECUTE", "TYPE_STRING", "TYPE_BOOLEAN", 
			"TYPE_INTEGER", "TYPE_DECIMAL", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"LBRACK", "RBRACK", "COLON", "COMMA", "DOT", "ASSIGNMENT", "IF", "ELSE", 
			"VAR", "WHILE", "RETURN", "BOOL_LITERAL", "STRING_LITERAL", "NUMBER_LITERAL", 
			"NULL_LITERAL", "IDENTIFIER"
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
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE) {
				{
				{
				setState(38);
				typeDeclaration();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TASK) {
				{
				{
				setState(44);
				taskDeclaration();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(50);
			workflowDeclaration();
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
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
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
			setState(52);
			match(TYPE);
			setState(53);
			match(IDENTIFIER);
			setState(54);
			parameters();
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
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
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
		enterRule(_localctx, 4, RULE_taskDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(TASK);
			setState(57);
			match(IDENTIFIER);
			setState(58);
			parameters();
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
		enterRule(_localctx, 6, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(LPAREN);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING_LITERAL || _la==IDENTIFIER) {
				{
				setState(61);
				keyValuePair();
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
				keyValuePair();
				}
				}
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(71);
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
	public static class KeyValuePairContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(BatonParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ObjectContext object() {
			return getRuleContext(ObjectContext.class,0);
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
		enterRule(_localctx, 8, RULE_keyValuePair);
		try {
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				key();
				setState(74);
				match(COLON);
				setState(75);
				type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				key();
				setState(78);
				match(COLON);
				setState(79);
				value();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				key();
				setState(82);
				match(COLON);
				setState(83);
				object();
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
	public static class KeyContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(BatonParser.STRING_LITERAL, 0); }
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
		enterRule(_localctx, 10, RULE_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_la = _input.LA(1);
			if ( !(_la==STRING_LITERAL || _la==IDENTIFIER) ) {
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode TYPE_BOOLEAN() { return getToken(BatonParser.TYPE_BOOLEAN, 0); }
		public TerminalNode TYPE_STRING() { return getToken(BatonParser.TYPE_STRING, 0); }
		public TerminalNode TYPE_INTEGER() { return getToken(BatonParser.TYPE_INTEGER, 0); }
		public TerminalNode TYPE_DECIMAL() { return getToken(BatonParser.TYPE_DECIMAL, 0); }
		public CustomTypeContext customType() {
			return getRuleContext(CustomTypeContext.class,0);
		}
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
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(94);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE_BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(TYPE_BOOLEAN);
				}
				break;
			case TYPE_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(TYPE_STRING);
				}
				break;
			case TYPE_INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				match(TYPE_INTEGER);
				}
				break;
			case TYPE_DECIMAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				match(TYPE_DECIMAL);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(93);
				customType();
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
	public static class CustomTypeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public CustomTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_customType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterCustomType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitCustomType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitCustomType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CustomTypeContext customType() throws RecognitionException {
		CustomTypeContext _localctx = new CustomTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_customType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(IDENTIFIER);
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
		enterRule(_localctx, 16, RULE_object);
		int _la;
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				match(LBRACE);
				setState(99);
				keyValuePair();
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(100);
					match(COMMA);
					setState(101);
					keyValuePair();
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				match(LBRACE);
				setState(110);
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
		enterRule(_localctx, 18, RULE_array);
		int _la;
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(LBRACK);
				setState(114);
				value();
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(115);
					match(COMMA);
					setState(116);
					value();
					}
					}
					setState(121);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(122);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(LBRACK);
				setState(125);
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
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(BatonParser.STRING_LITERAL, 0); }
		public TerminalNode NUMBER_LITERAL() { return getToken(BatonParser.NUMBER_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(BatonParser.BOOL_LITERAL, 0); }
		public TerminalNode NULL_LITERAL() { return getToken(BatonParser.NULL_LITERAL, 0); }
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
		enterRule(_localctx, 20, RULE_value);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				match(IDENTIFIER);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(STRING_LITERAL);
				}
				break;
			case NUMBER_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(130);
				match(NUMBER_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				match(BOOL_LITERAL);
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(132);
				match(NULL_LITERAL);
				}
				break;
			case LBRACK:
				enterOuterAlt(_localctx, 6);
				{
				setState(133);
				array();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 7);
				{
				setState(134);
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
	public static class WorkflowDeclarationContext extends ParserRuleContext {
		public TerminalNode WORKFLOW() { return getToken(BatonParser.WORKFLOW, 0); }
		public TerminalNode IDENTIFIER() { return getToken(BatonParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(BatonParser.COLON, 0); }
		public List<ParametersContext> parameters() {
			return getRuleContexts(ParametersContext.class);
		}
		public ParametersContext parameters(int i) {
			return getRuleContext(ParametersContext.class,i);
		}
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
		enterRule(_localctx, 22, RULE_workflowDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(WORKFLOW);
			setState(138);
			match(IDENTIFIER);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(139);
				parameters();
				}
			}

			setState(142);
			match(COLON);
			setState(143);
			parameters();
			setState(144);
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
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(BatonParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 24, RULE_workflowBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(LBRACE);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 537408331782L) != 0) {
				{
				{
				setState(147);
				statement();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
			returnStatement();
			setState(154);
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
		enterRule(_localctx, 26, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(LBRACE);
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 537408331782L) != 0) {
				{
				{
				setState(157);
				statement();
				}
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(163);
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
		enterRule(_localctx, 28, RULE_statement);
		int _la;
		try {
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(IF);
				setState(166);
				parExpression();
				setState(167);
				block();
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(168);
					match(ELSE);
					setState(169);
					block();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(WHILE);
				setState(173);
				parExpression();
				setState(174);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(DEF);
				setState(177);
				match(IDENTIFIER);
				setState(178);
				match(ASSIGNMENT);
				setState(179);
				expression(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
				match(IDENTIFIER);
				setState(181);
				match(ASSIGNMENT);
				setState(182);
				expression(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(183);
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
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(BatonParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BatonListener ) ((BatonListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BatonVisitor ) return ((BatonVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(RETURN);
			setState(187);
			expression(0);
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
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case BOOL_LITERAL:
			case STRING_LITERAL:
			case NUMBER_LITERAL:
			case NULL_LITERAL:
			case IDENTIFIER:
				{
				setState(190);
				primary();
				}
				break;
			case EXECUTE:
				{
				setState(191);
				match(EXECUTE);
				setState(192);
				_la = _input.LA(1);
				if ( !(_la==STRING_LITERAL || _la==IDENTIFIER) ) {
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
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(210);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
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
						_localctx = new ExpressionContext(_parentctx, _parentState);
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
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(205);
						match(DOT);
						setState(206);
						match(IDENTIFIER);
						setState(208);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
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
		enterRule(_localctx, 34, RULE_primary);
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(NUMBER_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(STRING_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				match(BOOL_LITERAL);
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				match(NULL_LITERAL);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(219);
				match(IDENTIFIER);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(220);
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
		enterRule(_localctx, 36, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(LPAREN);
			setState(224);
			expression(0);
			setState(225);
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
		case 16:
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
		"\u0004\u0001&\u00e4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0005\u0000(\b\u0000\n\u0000\f\u0000+\t\u0000\u0001\u0000"+
		"\u0005\u0000.\b\u0000\n\u0000\f\u00001\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0003\u0003?\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003C\b\u0003\n\u0003\f\u0003F\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004V\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"_\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\bg\b\b\n\b\f\bj\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bp\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0005\tv\b\t\n\t\f\ty\t\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u007f\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0003\n\u0088\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u008d\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0005\f\u0095\b\f\n\f\f\f\u0098\t\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0005\r\u009f\b\r\n\r\f\r\u00a2\t\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ab"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00b9\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00c5\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u00d1\b\u0010\u0005\u0010\u00d3\b\u0010\n\u0010\f\u0010"+
		"\u00d6\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00de\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0000\u0001 \u0013\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$\u0000\u0004"+
		"\u0002\u0000##&&\u0001\u0000\u0001\u0002\u0001\u0000\u0003\u0004\u0001"+
		"\u0000\u0005\u0006\u00f7\u0000)\u0001\u0000\u0000\u0000\u00024\u0001\u0000"+
		"\u0000\u0000\u00048\u0001\u0000\u0000\u0000\u0006<\u0001\u0000\u0000\u0000"+
		"\bU\u0001\u0000\u0000\u0000\nW\u0001\u0000\u0000\u0000\f^\u0001\u0000"+
		"\u0000\u0000\u000e`\u0001\u0000\u0000\u0000\u0010o\u0001\u0000\u0000\u0000"+
		"\u0012~\u0001\u0000\u0000\u0000\u0014\u0087\u0001\u0000\u0000\u0000\u0016"+
		"\u0089\u0001\u0000\u0000\u0000\u0018\u0092\u0001\u0000\u0000\u0000\u001a"+
		"\u009c\u0001\u0000\u0000\u0000\u001c\u00b8\u0001\u0000\u0000\u0000\u001e"+
		"\u00ba\u0001\u0000\u0000\u0000 \u00c4\u0001\u0000\u0000\u0000\"\u00dd"+
		"\u0001\u0000\u0000\u0000$\u00df\u0001\u0000\u0000\u0000&(\u0003\u0002"+
		"\u0001\u0000\'&\u0001\u0000\u0000\u0000(+\u0001\u0000\u0000\u0000)\'\u0001"+
		"\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*/\u0001\u0000\u0000\u0000"+
		"+)\u0001\u0000\u0000\u0000,.\u0003\u0004\u0002\u0000-,\u0001\u0000\u0000"+
		"\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000/0\u0001\u0000"+
		"\u0000\u000002\u0001\u0000\u0000\u00001/\u0001\u0000\u0000\u000023\u0003"+
		"\u0016\u000b\u00003\u0001\u0001\u0000\u0000\u000045\u0005\f\u0000\u0000"+
		"56\u0005&\u0000\u000067\u0003\u0006\u0003\u00007\u0003\u0001\u0000\u0000"+
		"\u000089\u0005\u000b\u0000\u00009:\u0005&\u0000\u0000:;\u0003\u0006\u0003"+
		"\u0000;\u0005\u0001\u0000\u0000\u0000<>\u0005\u0013\u0000\u0000=?\u0003"+
		"\b\u0004\u0000>=\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?D\u0001"+
		"\u0000\u0000\u0000@A\u0005\u001a\u0000\u0000AC\u0003\b\u0004\u0000B@\u0001"+
		"\u0000\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000"+
		"DE\u0001\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000"+
		"\u0000GH\u0005\u0014\u0000\u0000H\u0007\u0001\u0000\u0000\u0000IJ\u0003"+
		"\n\u0005\u0000JK\u0005\u0019\u0000\u0000KL\u0003\f\u0006\u0000LV\u0001"+
		"\u0000\u0000\u0000MN\u0003\n\u0005\u0000NO\u0005\u0019\u0000\u0000OP\u0003"+
		"\u0014\n\u0000PV\u0001\u0000\u0000\u0000QR\u0003\n\u0005\u0000RS\u0005"+
		"\u0019\u0000\u0000ST\u0003\u0010\b\u0000TV\u0001\u0000\u0000\u0000UI\u0001"+
		"\u0000\u0000\u0000UM\u0001\u0000\u0000\u0000UQ\u0001\u0000\u0000\u0000"+
		"V\t\u0001\u0000\u0000\u0000WX\u0007\u0000\u0000\u0000X\u000b\u0001\u0000"+
		"\u0000\u0000Y_\u0005\u0010\u0000\u0000Z_\u0005\u000f\u0000\u0000[_\u0005"+
		"\u0011\u0000\u0000\\_\u0005\u0012\u0000\u0000]_\u0003\u000e\u0007\u0000"+
		"^Y\u0001\u0000\u0000\u0000^Z\u0001\u0000\u0000\u0000^[\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000^]\u0001\u0000\u0000\u0000_\r\u0001\u0000"+
		"\u0000\u0000`a\u0005&\u0000\u0000a\u000f\u0001\u0000\u0000\u0000bc\u0005"+
		"\u0015\u0000\u0000ch\u0003\b\u0004\u0000de\u0005\u001a\u0000\u0000eg\u0003"+
		"\b\u0004\u0000fd\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001"+
		"\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000"+
		"jh\u0001\u0000\u0000\u0000kl\u0005\u0016\u0000\u0000lp\u0001\u0000\u0000"+
		"\u0000mn\u0005\u0015\u0000\u0000np\u0005\u0016\u0000\u0000ob\u0001\u0000"+
		"\u0000\u0000om\u0001\u0000\u0000\u0000p\u0011\u0001\u0000\u0000\u0000"+
		"qr\u0005\u0017\u0000\u0000rw\u0003\u0014\n\u0000st\u0005\u001a\u0000\u0000"+
		"tv\u0003\u0014\n\u0000us\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000z{\u0005\u0018\u0000\u0000{\u007f\u0001"+
		"\u0000\u0000\u0000|}\u0005\u0017\u0000\u0000}\u007f\u0005\u0018\u0000"+
		"\u0000~q\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0013"+
		"\u0001\u0000\u0000\u0000\u0080\u0088\u0005&\u0000\u0000\u0081\u0088\u0005"+
		"#\u0000\u0000\u0082\u0088\u0005$\u0000\u0000\u0083\u0088\u0005\"\u0000"+
		"\u0000\u0084\u0088\u0005%\u0000\u0000\u0085\u0088\u0003\u0012\t\u0000"+
		"\u0086\u0088\u0003\u0010\b\u0000\u0087\u0080\u0001\u0000\u0000\u0000\u0087"+
		"\u0081\u0001\u0000\u0000\u0000\u0087\u0082\u0001\u0000\u0000\u0000\u0087"+
		"\u0083\u0001\u0000\u0000\u0000\u0087\u0084\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088"+
		"\u0015\u0001\u0000\u0000\u0000\u0089\u008a\u0005\n\u0000\u0000\u008a\u008c"+
		"\u0005&\u0000\u0000\u008b\u008d\u0003\u0006\u0003\u0000\u008c\u008b\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0005\u0019\u0000\u0000\u008f\u0090\u0003"+
		"\u0006\u0003\u0000\u0090\u0091\u0003\u0018\f\u0000\u0091\u0017\u0001\u0000"+
		"\u0000\u0000\u0092\u0096\u0005\u0015\u0000\u0000\u0093\u0095\u0003\u001c"+
		"\u000e\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0098\u0001\u0000"+
		"\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000"+
		"\u0000\u0000\u0097\u0099\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0003\u001e\u000f\u0000\u009a\u009b\u0005\u0016"+
		"\u0000\u0000\u009b\u0019\u0001\u0000\u0000\u0000\u009c\u00a0\u0005\u0015"+
		"\u0000\u0000\u009d\u009f\u0003\u001c\u000e\u0000\u009e\u009d\u0001\u0000"+
		"\u0000\u0000\u009f\u00a2\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005\u0016"+
		"\u0000\u0000\u00a4\u001b\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u001d"+
		"\u0000\u0000\u00a6\u00a7\u0003$\u0012\u0000\u00a7\u00aa\u0003\u001a\r"+
		"\u0000\u00a8\u00a9\u0005\u001e\u0000\u0000\u00a9\u00ab\u0003\u001a\r\u0000"+
		"\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ab\u00b9\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005 \u0000\u0000\u00ad"+
		"\u00ae\u0003$\u0012\u0000\u00ae\u00af\u0003\u001a\r\u0000\u00af\u00b9"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\r\u0000\u0000\u00b1\u00b2\u0005"+
		"&\u0000\u0000\u00b2\u00b3\u0005\u001c\u0000\u0000\u00b3\u00b9\u0003 \u0010"+
		"\u0000\u00b4\u00b5\u0005&\u0000\u0000\u00b5\u00b6\u0005\u001c\u0000\u0000"+
		"\u00b6\u00b9\u0003 \u0010\u0000\u00b7\u00b9\u0003 \u0010\u0000\u00b8\u00a5"+
		"\u0001\u0000\u0000\u0000\u00b8\u00ac\u0001\u0000\u0000\u0000\u00b8\u00b0"+
		"\u0001\u0000\u0000\u0000\u00b8\u00b4\u0001\u0000\u0000\u0000\u00b8\u00b7"+
		"\u0001\u0000\u0000\u0000\u00b9\u001d\u0001\u0000\u0000\u0000\u00ba\u00bb"+
		"\u0005!\u0000\u0000\u00bb\u00bc\u0003 \u0010\u0000\u00bc\u001f\u0001\u0000"+
		"\u0000\u0000\u00bd\u00be\u0006\u0010\uffff\uffff\u0000\u00be\u00c5\u0003"+
		"\"\u0011\u0000\u00bf\u00c0\u0005\u000e\u0000\u0000\u00c0\u00c1\u0007\u0000"+
		"\u0000\u0000\u00c1\u00c5\u0003\u0006\u0003\u0000\u00c2\u00c3\u0007\u0001"+
		"\u0000\u0000\u00c3\u00c5\u0003 \u0010\u0003\u00c4\u00bd\u0001\u0000\u0000"+
		"\u0000\u00c4\u00bf\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c5\u00d4\u0001\u0000\u0000\u0000\u00c6\u00c7\n\u0002\u0000\u0000"+
		"\u00c7\u00c8\u0007\u0002\u0000\u0000\u00c8\u00d3\u0003 \u0010\u0003\u00c9"+
		"\u00ca\n\u0001\u0000\u0000\u00ca\u00cb\u0007\u0003\u0000\u0000\u00cb\u00d3"+
		"\u0003 \u0010\u0002\u00cc\u00cd\n\u0004\u0000\u0000\u00cd\u00ce\u0005"+
		"\u001b\u0000\u0000\u00ce\u00d0\u0005&\u0000\u0000\u00cf\u00d1\u0003 \u0010"+
		"\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u00c6\u0001\u0000\u0000"+
		"\u0000\u00d2\u00c9\u0001\u0000\u0000\u0000\u00d2\u00cc\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d6\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5!\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d7\u00de\u0005$\u0000\u0000\u00d8"+
		"\u00de\u0005#\u0000\u0000\u00d9\u00de\u0005\"\u0000\u0000\u00da\u00de"+
		"\u0005%\u0000\u0000\u00db\u00de\u0005&\u0000\u0000\u00dc\u00de\u0003$"+
		"\u0012\u0000\u00dd\u00d7\u0001\u0000\u0000\u0000\u00dd\u00d8\u0001\u0000"+
		"\u0000\u0000\u00dd\u00d9\u0001\u0000\u0000\u0000\u00dd\u00da\u0001\u0000"+
		"\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00dc\u0001\u0000"+
		"\u0000\u0000\u00de#\u0001\u0000\u0000\u0000\u00df\u00e0\u0005\u0013\u0000"+
		"\u0000\u00e0\u00e1\u0003 \u0010\u0000\u00e1\u00e2\u0005\u0014\u0000\u0000"+
		"\u00e2%\u0001\u0000\u0000\u0000\u0015)/>DU^how~\u0087\u008c\u0096\u00a0"+
		"\u00aa\u00b8\u00c4\u00d0\u00d2\u00d4\u00dd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}