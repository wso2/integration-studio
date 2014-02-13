// Generated from Mapping.g4 by ANTLR 4.1

  package org.wso2.datamapper.parsers;
  import java.util.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MappingParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, DOT=8, VAR=9, 
		ID=10, DELEMETER=11, INT=12, NEWLINE=13, WS=14;
	public static final String[] tokenNames = {
		"<INVALID>", "'>'", "')'", "','", "'-'", "'('", "'='", "';'", "DOT", "'var'", 
		"ID", "DELEMETER", "INT", "NEWLINE", "WS"
	};
	public static final int
		RULE_statment = 0, RULE_deftype = 1, RULE_defelement = 2, RULE_outputelement = 3, 
		RULE_value = 4, RULE_var = 5, RULE_function = 6, RULE_funcid = 7, RULE_varid = 8, 
		RULE_arg = 9;
	public static final String[] ruleNames = {
		"statment", "deftype", "defelement", "outputelement", "value", "var", 
		"function", "funcid", "varid", "arg"
	};

	@Override
	public String getGrammarFileName() { return "Mapping.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public MappingParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StatmentContext extends ParserRuleContext {
		public DefelementContext defelement(int i) {
			return getRuleContext(DefelementContext.class,i);
		}
		public List<DeftypeContext> deftype() {
			return getRuleContexts(DeftypeContext.class);
		}
		public List<DefelementContext> defelement() {
			return getRuleContexts(DefelementContext.class);
		}
		public DeftypeContext deftype(int i) {
			return getRuleContext(DeftypeContext.class,i);
		}
		public StatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).enterStatment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).exitStatment(this);
		}
	}

	public final StatmentContext statment() throws RecognitionException {
		StatmentContext _localctx = new StatmentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_statment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(20); deftype();
					}
					break;

				case 2:
					{
					setState(21); defelement();
					}
					break;
				}
				setState(24); match(7);
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR || _la==ID );
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

	public static class DeftypeContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(MappingParser.DOT); }
		public List<TerminalNode> ID() { return getTokens(MappingParser.ID); }
		public TerminalNode DOT(int i) {
			return getToken(MappingParser.DOT, i);
		}
		public TerminalNode ID(int i) {
			return getToken(MappingParser.ID, i);
		}
		public DeftypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deftype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).enterDeftype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).exitDeftype(this);
		}
	}

	public final DeftypeContext deftype() throws RecognitionException {
		DeftypeContext _localctx = new DeftypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_deftype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30); match(ID);
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(31); match(DOT);
				setState(32); match(ID);
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38); match(4);
			setState(39); match(1);
			setState(40); match(ID);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(41); match(DOT);
				setState(42); match(ID);
				}
				}
				setState(47);
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

	public static class DefelementContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public OutputelementContext outputelement() {
			return getRuleContext(OutputelementContext.class,0);
		}
		public DefelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defelement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).enterDefelement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).exitDefelement(this);
		}
	}

	public final DefelementContext defelement() throws RecognitionException {
		DefelementContext _localctx = new DefelementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_defelement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48); outputelement();
			setState(49); match(6);
			setState(50); value();
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

	public static class OutputelementContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(MappingParser.DOT); }
		public List<TerminalNode> ID() { return getTokens(MappingParser.ID); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode DOT(int i) {
			return getToken(MappingParser.DOT, i);
		}
		public TerminalNode ID(int i) {
			return getToken(MappingParser.ID, i);
		}
		public OutputelementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outputelement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).enterOutputelement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).exitOutputelement(this);
		}
	}

	public final OutputelementContext outputelement() throws RecognitionException {
		OutputelementContext _localctx = new OutputelementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_outputelement);
		int _la;
		try {
			setState(61);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(52); match(ID);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(53); match(DOT);
					setState(54); match(ID);
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(60); var();
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

	public static class ValueContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_value);
		int _la;
		try {
			setState(69);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(63); function();
					}
					}
					setState(66); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ID );
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(68); arg();
				}
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(MappingParser.VAR, 0); }
		public VaridContext varid() {
			return getRuleContext(VaridContext.class,0);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); match(VAR);
			setState(72); varid();
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

	public static class FunctionContext extends ParserRuleContext {
		public FuncidContext funcid() {
			return getRuleContext(FuncidContext.class,0);
		}
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); funcid();
			setState(75); match(5);
			setState(76); arg();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(77); match(3);
				setState(78); arg();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84); match(2);
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

	public static class FuncidContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MappingParser.ID, 0); }
		public FuncidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).enterFuncid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).exitFuncid(this);
		}
	}

	public final FuncidContext funcid() throws RecognitionException {
		FuncidContext _localctx = new FuncidContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(ID);
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

	public static class VaridContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MappingParser.ID, 0); }
		public VaridContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).enterVarid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).exitVarid(this);
		}
	}

	public final VaridContext varid() throws RecognitionException {
		VaridContext _localctx = new VaridContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varid);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(ID);
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

	public static class ArgContext extends ParserRuleContext {
		public List<TerminalNode> DOT() { return getTokens(MappingParser.DOT); }
		public List<TerminalNode> ID() { return getTokens(MappingParser.ID); }
		public TerminalNode DELEMETER() { return getToken(MappingParser.DELEMETER, 0); }
		public TerminalNode DOT(int i) {
			return getToken(MappingParser.DOT, i);
		}
		public TerminalNode ID(int i) {
			return getToken(MappingParser.ID, i);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MappingListener ) ((MappingListener)listener).exitArg(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_arg);
		int _la;
		try {
			setState(99);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(90); match(ID);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(91); match(DOT);
					setState(92); match(ID);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DELEMETER:
				enterOuterAlt(_localctx, 2);
				{
				setState(98); match(DELEMETER);
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

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\20h\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\3\2\5\2\31\n\2\3\2\3\2\6\2\35\n\2\r\2\16\2\36\3\3\3\3\3\3\7\3$\n\3"+
		"\f\3\16\3\'\13\3\3\3\3\3\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\7\5:\n\5\f\5\16\5=\13\5\3\5\5\5@\n\5\3\6\6\6C\n\6"+
		"\r\6\16\6D\3\6\5\6H\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\7\bR\n\b\f\b\16"+
		"\bU\13\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\7\13`\n\13\f\13\16\13"+
		"c\13\13\3\13\5\13f\n\13\3\13\2\f\2\4\6\b\n\f\16\20\22\24\2\2h\2\34\3\2"+
		"\2\2\4 \3\2\2\2\6\62\3\2\2\2\b?\3\2\2\2\nG\3\2\2\2\fI\3\2\2\2\16L\3\2"+
		"\2\2\20X\3\2\2\2\22Z\3\2\2\2\24e\3\2\2\2\26\31\5\4\3\2\27\31\5\6\4\2\30"+
		"\26\3\2\2\2\30\27\3\2\2\2\31\32\3\2\2\2\32\33\7\t\2\2\33\35\3\2\2\2\34"+
		"\30\3\2\2\2\35\36\3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\3\3\2\2\2 %\7"+
		"\f\2\2!\"\7\n\2\2\"$\7\f\2\2#!\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2"+
		"&(\3\2\2\2\'%\3\2\2\2()\7\6\2\2)*\7\3\2\2*/\7\f\2\2+,\7\n\2\2,.\7\f\2"+
		"\2-+\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\5\3\2\2\2\61/\3\2\2"+
		"\2\62\63\5\b\5\2\63\64\7\b\2\2\64\65\5\n\6\2\65\7\3\2\2\2\66;\7\f\2\2"+
		"\678\7\n\2\28:\7\f\2\29\67\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<@\3\2"+
		"\2\2=;\3\2\2\2>@\5\f\7\2?\66\3\2\2\2?>\3\2\2\2@\t\3\2\2\2AC\5\16\b\2B"+
		"A\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EH\3\2\2\2FH\5\24\13\2GB\3\2\2"+
		"\2GF\3\2\2\2H\13\3\2\2\2IJ\7\13\2\2JK\5\22\n\2K\r\3\2\2\2LM\5\20\t\2M"+
		"N\7\7\2\2NS\5\24\13\2OP\7\5\2\2PR\5\24\13\2QO\3\2\2\2RU\3\2\2\2SQ\3\2"+
		"\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7\4\2\2W\17\3\2\2\2XY\7\f\2\2Y\21"+
		"\3\2\2\2Z[\7\f\2\2[\23\3\2\2\2\\a\7\f\2\2]^\7\n\2\2^`\7\f\2\2_]\3\2\2"+
		"\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bf\3\2\2\2ca\3\2\2\2df\7\r\2\2e\\\3\2"+
		"\2\2ed\3\2\2\2f\25\3\2\2\2\r\30\36%/;?DGSae";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}