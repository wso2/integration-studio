// Generated from Mapping.g4 by ANTLR 4.1

  package org.wso2.datamapper.parsers;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MappingLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, DOT=8, VAR=9, 
		ID=10, DELEMETER=11, INT=12, NEWLINE=13, WS=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'>'", "')'", "','", "'-'", "'('", "'='", "';'", "DOT", "'var'", "ID", 
		"DELEMETER", "INT", "NEWLINE", "WS"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "DOT", "VAR", 
		"ID", "DELEMETER", "INT", "NEWLINE", "WS"
	};


	public MappingLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mapping.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 13: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\20M\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\6\13\65\n\13\r"+
		"\13\16\13\66\3\f\3\f\3\f\3\f\3\r\6\r>\n\r\r\r\16\r?\3\16\5\16C\n\16\3"+
		"\16\3\16\3\17\6\17H\n\17\r\17\16\17I\3\17\3\17\2\20\3\3\1\5\4\1\7\5\1"+
		"\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17"+
		"\1\35\20\2\3\2\6\3\2\60\60\4\2C\\c|\3\2\62;\6\2\13\13\"\"))~~P\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t%\3"+
		"\2\2\2\13\'\3\2\2\2\r)\3\2\2\2\17+\3\2\2\2\21-\3\2\2\2\23/\3\2\2\2\25"+
		"\64\3\2\2\2\278\3\2\2\2\31=\3\2\2\2\33B\3\2\2\2\35G\3\2\2\2\37 \7@\2\2"+
		" \4\3\2\2\2!\"\7+\2\2\"\6\3\2\2\2#$\7.\2\2$\b\3\2\2\2%&\7/\2\2&\n\3\2"+
		"\2\2\'(\7*\2\2(\f\3\2\2\2)*\7?\2\2*\16\3\2\2\2+,\7=\2\2,\20\3\2\2\2-."+
		"\t\2\2\2.\22\3\2\2\2/\60\7x\2\2\60\61\7c\2\2\61\62\7t\2\2\62\24\3\2\2"+
		"\2\63\65\t\3\2\2\64\63\3\2\2\2\65\66\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2"+
		"\2\67\26\3\2\2\289\7$\2\29:\13\2\2\2:;\7$\2\2;\30\3\2\2\2<>\t\4\2\2=<"+
		"\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\32\3\2\2\2AC\7\17\2\2BA\3\2\2"+
		"\2BC\3\2\2\2CD\3\2\2\2DE\7\f\2\2E\34\3\2\2\2FH\t\5\2\2GF\3\2\2\2HI\3\2"+
		"\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\b\17\2\2L\36\3\2\2\2\7\2\66?BI";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}