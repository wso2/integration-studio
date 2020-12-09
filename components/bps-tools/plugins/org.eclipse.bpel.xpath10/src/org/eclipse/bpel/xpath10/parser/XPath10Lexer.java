// $ANTLR 3.0.1 XPath10__.g 2008-06-23 18:23:27
	 
	 package org.eclipse.bpel.xpath10.parser;	 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class XPath10Lexer extends Lexer {
    public static final int DOLLAR=21;
    public static final int LT=26;
    public static final int SLASH2=20;
    public static final int STAR=30;
    public static final int MOD=6;
    public static final int DIGITS=36;
    public static final int GTE=29;
    public static final int NUMBER=34;
    public static final int Args=31;
    public static final int LITERAL=33;
    public static final int MINUS=23;
    public static final int AND=5;
    public static final int Tokens=39;
    public static final int EOF=-1;
    public static final int LTE=27;
    public static final int LPAREN=8;
    public static final int COLON=18;
    public static final int LBRACKET=10;
    public static final int AT=15;
    public static final int RPAREN=9;
    public static final int SINGLE_QUOTE_STRING=37;
    public static final int SLASH=19;
    public static final int WS=35;
    public static final int COMMA=16;
    public static final int DOUBLE_QUOTE_STRING=38;
    public static final int IDENTIFIER=32;
    public static final int OR=4;
    public static final int GT=28;
    public static final int PIPE=12;
    public static final int PLUS=22;
    public static final int DOT2=14;
    public static final int RBRACKET=11;
    public static final int DIV=7;
    public static final int EQ=24;
    public static final int DOT=13;
    public static final int COLON2=17;
    public static final int NE=25;
    
    	  public void displayRecognitionError(String[] tokenNames, RecognitionException re)
    	  {		    
    		    String msg = getErrorMessage(re, tokenNames);
    		    // we don't recover
             throw new XPath10Exception(msg,re.getCause(),re.index);
    	  }

    public XPath10Lexer() {;} 
    public XPath10Lexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "XPath10__.g"; }

    // $ANTLR start OR
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            // XPath10__.g:14:4: ( 'or' )
            // XPath10__.g:14:6: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end OR

    // $ANTLR start AND
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            // XPath10__.g:15:5: ( 'and' )
            // XPath10__.g:15:7: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AND

    // $ANTLR start MOD
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            // XPath10__.g:16:5: ( 'mod' )
            // XPath10__.g:16:7: 'mod'
            {
            match("mod"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MOD

    // $ANTLR start DIV
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            // XPath10__.g:17:5: ( 'div' )
            // XPath10__.g:17:7: 'div'
            {
            match("div"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DIV

    // $ANTLR start LPAREN
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            // XPath10__.g:18:8: ( '(' )
            // XPath10__.g:18:10: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LPAREN

    // $ANTLR start RPAREN
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            // XPath10__.g:19:8: ( ')' )
            // XPath10__.g:19:10: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RPAREN

    // $ANTLR start LBRACKET
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            // XPath10__.g:20:10: ( '[' )
            // XPath10__.g:20:12: '['
            {
            match('['); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LBRACKET

    // $ANTLR start RBRACKET
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            // XPath10__.g:21:10: ( ']' )
            // XPath10__.g:21:12: ']'
            {
            match(']'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RBRACKET

    // $ANTLR start PIPE
    public final void mPIPE() throws RecognitionException {
        try {
            int _type = PIPE;
            // XPath10__.g:22:6: ( '|' )
            // XPath10__.g:22:8: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PIPE

    // $ANTLR start DOT
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            // XPath10__.g:23:5: ( '.' )
            // XPath10__.g:23:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOT

    // $ANTLR start DOT2
    public final void mDOT2() throws RecognitionException {
        try {
            int _type = DOT2;
            // XPath10__.g:24:6: ( '..' )
            // XPath10__.g:24:8: '..'
            {
            match(".."); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOT2

    // $ANTLR start AT
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            // XPath10__.g:25:4: ( '@' )
            // XPath10__.g:25:6: '@'
            {
            match('@'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end AT

    // $ANTLR start COMMA
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            // XPath10__.g:26:7: ( ',' )
            // XPath10__.g:26:9: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMA

    // $ANTLR start COLON2
    public final void mCOLON2() throws RecognitionException {
        try {
            int _type = COLON2;
            // XPath10__.g:27:8: ( '::' )
            // XPath10__.g:27:10: '::'
            {
            match("::"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLON2

    // $ANTLR start COLON
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            // XPath10__.g:28:7: ( ':' )
            // XPath10__.g:28:9: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COLON

    // $ANTLR start SLASH
    public final void mSLASH() throws RecognitionException {
        try {
            int _type = SLASH;
            // XPath10__.g:29:7: ( '/' )
            // XPath10__.g:29:9: '/'
            {
            match('/'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SLASH

    // $ANTLR start SLASH2
    public final void mSLASH2() throws RecognitionException {
        try {
            int _type = SLASH2;
            // XPath10__.g:30:8: ( '//' )
            // XPath10__.g:30:10: '//'
            {
            match("//"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end SLASH2

    // $ANTLR start DOLLAR
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            // XPath10__.g:31:8: ( '$' )
            // XPath10__.g:31:10: '$'
            {
            match('$'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end DOLLAR

    // $ANTLR start PLUS
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            // XPath10__.g:32:6: ( '+' )
            // XPath10__.g:32:8: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end PLUS

    // $ANTLR start MINUS
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            // XPath10__.g:33:7: ( '-' )
            // XPath10__.g:33:9: '-'
            {
            match('-'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end MINUS

    // $ANTLR start EQ
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            // XPath10__.g:34:4: ( '=' )
            // XPath10__.g:34:6: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end EQ

    // $ANTLR start NE
    public final void mNE() throws RecognitionException {
        try {
            int _type = NE;
            // XPath10__.g:35:4: ( '!=' )
            // XPath10__.g:35:6: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NE

    // $ANTLR start LT
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            // XPath10__.g:36:4: ( '<' )
            // XPath10__.g:36:6: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LT

    // $ANTLR start LTE
    public final void mLTE() throws RecognitionException {
        try {
            int _type = LTE;
            // XPath10__.g:37:5: ( '<=' )
            // XPath10__.g:37:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LTE

    // $ANTLR start GT
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            // XPath10__.g:38:4: ( '>' )
            // XPath10__.g:38:6: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GT

    // $ANTLR start GTE
    public final void mGTE() throws RecognitionException {
        try {
            int _type = GTE;
            // XPath10__.g:39:5: ( '>=' )
            // XPath10__.g:39:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end GTE

    // $ANTLR start STAR
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            // XPath10__.g:40:6: ( '*' )
            // XPath10__.g:40:8: '*'
            {
            match('*'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end STAR

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // XPath10__.g:493:4: ( ( '\\n' | ' ' | '\\t' | '\\r' )+ )
            // XPath10__.g:493:6: ( '\\n' | ' ' | '\\t' | '\\r' )+
            {
            // XPath10__.g:493:6: ( '\\n' | ' ' | '\\t' | '\\r' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\t' && LA1_0<='\n')||LA1_0=='\r'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // XPath10__.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);

            	channel=HIDDEN;

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start DIGITS
    public final void mDIGITS() throws RecognitionException {
        try {
            // XPath10__.g:497:8: ( ( '0' .. '9' )+ )
            // XPath10__.g:497:10: ( '0' .. '9' )+
            {
            // XPath10__.g:497:10: ( '0' .. '9' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // XPath10__.g:497:10: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end DIGITS

    // $ANTLR start SINGLE_QUOTE_STRING
    public final void mSINGLE_QUOTE_STRING() throws RecognitionException {
        try {
            // XPath10__.g:500:21: ( '\\'' (~ ( '\\'' ) )* '\\'' )
            // XPath10__.g:500:23: '\\'' (~ ( '\\'' ) )* '\\''
            {
            match('\''); 
            // XPath10__.g:500:29: (~ ( '\\'' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='\u0000' && LA3_0<='&')||(LA3_0>='(' && LA3_0<='\uFFFE')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // XPath10__.g:500:30: ~ ( '\\'' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match('\''); 

            }

        }
        finally {
        }
    }
    // $ANTLR end SINGLE_QUOTE_STRING

    // $ANTLR start DOUBLE_QUOTE_STRING
    public final void mDOUBLE_QUOTE_STRING() throws RecognitionException {
        try {
            // XPath10__.g:503:21: ( '\"' (~ ( '\"' ) )* '\"' )
            // XPath10__.g:503:23: '\"' (~ ( '\"' ) )* '\"'
            {
            match('\"'); 
            // XPath10__.g:503:28: (~ ( '\"' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='\uFFFE')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // XPath10__.g:503:29: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\"'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end DOUBLE_QUOTE_STRING

    // $ANTLR start LITERAL
    public final void mLITERAL() throws RecognitionException {
        try {
            int _type = LITERAL;
            // XPath10__.g:505:9: ( SINGLE_QUOTE_STRING | DOUBLE_QUOTE_STRING )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\'') ) {
                alt5=1;
            }
            else if ( (LA5_0=='\"') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("505:1: LITERAL : ( SINGLE_QUOTE_STRING | DOUBLE_QUOTE_STRING );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // XPath10__.g:505:11: SINGLE_QUOTE_STRING
                    {
                    mSINGLE_QUOTE_STRING(); 

                    }
                    break;
                case 2 :
                    // XPath10__.g:505:33: DOUBLE_QUOTE_STRING
                    {
                    mDOUBLE_QUOTE_STRING(); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LITERAL

    // $ANTLR start NUMBER
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            // XPath10__.g:507:8: ( ( DIGITS ) ( '.' DIGITS )? | '.' DIGITS )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                alt7=1;
            }
            else if ( (LA7_0=='.') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("507:1: NUMBER : ( ( DIGITS ) ( '.' DIGITS )? | '.' DIGITS );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // XPath10__.g:507:10: ( DIGITS ) ( '.' DIGITS )?
                    {
                    // XPath10__.g:507:10: ( DIGITS )
                    // XPath10__.g:507:11: DIGITS
                    {
                    mDIGITS(); 

                    }

                    // XPath10__.g:507:19: ( '.' DIGITS )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='.') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // XPath10__.g:507:20: '.' DIGITS
                            {
                            match('.'); 
                            mDIGITS(); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // XPath10__.g:507:34: '.' DIGITS
                    {
                    match('.'); 
                    mDIGITS(); 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end NUMBER

    // $ANTLR start IDENTIFIER
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            // XPath10__.g:509:12: ( ( '\\u0241' .. '\\u0377' | 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '\\u0241' .. '\\u0377' | 'a' .. 'z' | 'A' .. 'Z' | '-' | '_' | '0' .. '9' | '.' )* )
            // XPath10__.g:510:3: ( '\\u0241' .. '\\u0377' | 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( '\\u0241' .. '\\u0377' | 'a' .. 'z' | 'A' .. 'Z' | '-' | '_' | '0' .. '9' | '.' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u0241' && input.LA(1)<='\u0377') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // XPath10__.g:510:46: ( '\\u0241' .. '\\u0377' | 'a' .. 'z' | 'A' .. 'Z' | '-' | '_' | '0' .. '9' | '.' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='-' && LA8_0<='.')||(LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')||(LA8_0>='\u0241' && LA8_0<='\u0377')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // XPath10__.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<='.')||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u0241' && input.LA(1)<='\u0377') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end IDENTIFIER

    public void mTokens() throws RecognitionException {
        // XPath10__.g:1:8: ( OR | AND | MOD | DIV | LPAREN | RPAREN | LBRACKET | RBRACKET | PIPE | DOT | DOT2 | AT | COMMA | COLON2 | COLON | SLASH | SLASH2 | DOLLAR | PLUS | MINUS | EQ | NE | LT | LTE | GT | GTE | STAR | WS | LITERAL | NUMBER | IDENTIFIER )
        int alt9=31;
        int LA9_0 = input.LA(1);

        if ( (LA9_0=='o') ) {
            int LA9_1 = input.LA(2);

            if ( (LA9_1=='r') ) {
                int LA9_27 = input.LA(3);

                if ( ((LA9_27>='-' && LA9_27<='.')||(LA9_27>='0' && LA9_27<='9')||(LA9_27>='A' && LA9_27<='Z')||LA9_27=='_'||(LA9_27>='a' && LA9_27<='z')||(LA9_27>='\u0241' && LA9_27<='\u0377')) ) {
                    alt9=31;
                }
                else {
                    alt9=1;}
            }
            else {
                alt9=31;}
        }
        else if ( (LA9_0=='a') ) {
            int LA9_2 = input.LA(2);

            if ( (LA9_2=='n') ) {
                int LA9_28 = input.LA(3);

                if ( (LA9_28=='d') ) {
                    int LA9_42 = input.LA(4);

                    if ( ((LA9_42>='-' && LA9_42<='.')||(LA9_42>='0' && LA9_42<='9')||(LA9_42>='A' && LA9_42<='Z')||LA9_42=='_'||(LA9_42>='a' && LA9_42<='z')||(LA9_42>='\u0241' && LA9_42<='\u0377')) ) {
                        alt9=31;
                    }
                    else {
                        alt9=2;}
                }
                else {
                    alt9=31;}
            }
            else {
                alt9=31;}
        }
        else if ( (LA9_0=='m') ) {
            int LA9_3 = input.LA(2);

            if ( (LA9_3=='o') ) {
                int LA9_29 = input.LA(3);

                if ( (LA9_29=='d') ) {
                    int LA9_43 = input.LA(4);

                    if ( ((LA9_43>='-' && LA9_43<='.')||(LA9_43>='0' && LA9_43<='9')||(LA9_43>='A' && LA9_43<='Z')||LA9_43=='_'||(LA9_43>='a' && LA9_43<='z')||(LA9_43>='\u0241' && LA9_43<='\u0377')) ) {
                        alt9=31;
                    }
                    else {
                        alt9=3;}
                }
                else {
                    alt9=31;}
            }
            else {
                alt9=31;}
        }
        else if ( (LA9_0=='d') ) {
            int LA9_4 = input.LA(2);

            if ( (LA9_4=='i') ) {
                int LA9_30 = input.LA(3);

                if ( (LA9_30=='v') ) {
                    int LA9_44 = input.LA(4);

                    if ( ((LA9_44>='-' && LA9_44<='.')||(LA9_44>='0' && LA9_44<='9')||(LA9_44>='A' && LA9_44<='Z')||LA9_44=='_'||(LA9_44>='a' && LA9_44<='z')||(LA9_44>='\u0241' && LA9_44<='\u0377')) ) {
                        alt9=31;
                    }
                    else {
                        alt9=4;}
                }
                else {
                    alt9=31;}
            }
            else {
                alt9=31;}
        }
        else if ( (LA9_0=='(') ) {
            alt9=5;
        }
        else if ( (LA9_0==')') ) {
            alt9=6;
        }
        else if ( (LA9_0=='[') ) {
            alt9=7;
        }
        else if ( (LA9_0==']') ) {
            alt9=8;
        }
        else if ( (LA9_0=='|') ) {
            alt9=9;
        }
        else if ( (LA9_0=='.') ) {
            switch ( input.LA(2) ) {
            case '.':
                {
                alt9=11;
                }
                break;
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                {
                alt9=30;
                }
                break;
            default:
                alt9=10;}

        }
        else if ( (LA9_0=='@') ) {
            alt9=12;
        }
        else if ( (LA9_0==',') ) {
            alt9=13;
        }
        else if ( (LA9_0==':') ) {
            int LA9_13 = input.LA(2);

            if ( (LA9_13==':') ) {
                alt9=14;
            }
            else {
                alt9=15;}
        }
        else if ( (LA9_0=='/') ) {
            int LA9_14 = input.LA(2);

            if ( (LA9_14=='/') ) {
                alt9=17;
            }
            else {
                alt9=16;}
        }
        else if ( (LA9_0=='$') ) {
            alt9=18;
        }
        else if ( (LA9_0=='+') ) {
            alt9=19;
        }
        else if ( (LA9_0=='-') ) {
            alt9=20;
        }
        else if ( (LA9_0=='=') ) {
            alt9=21;
        }
        else if ( (LA9_0=='!') ) {
            alt9=22;
        }
        else if ( (LA9_0=='<') ) {
            int LA9_20 = input.LA(2);

            if ( (LA9_20=='=') ) {
                alt9=24;
            }
            else {
                alt9=23;}
        }
        else if ( (LA9_0=='>') ) {
            int LA9_21 = input.LA(2);

            if ( (LA9_21=='=') ) {
                alt9=26;
            }
            else {
                alt9=25;}
        }
        else if ( (LA9_0=='*') ) {
            alt9=27;
        }
        else if ( ((LA9_0>='\t' && LA9_0<='\n')||LA9_0=='\r'||LA9_0==' ') ) {
            alt9=28;
        }
        else if ( (LA9_0=='\"'||LA9_0=='\'') ) {
            alt9=29;
        }
        else if ( ((LA9_0>='0' && LA9_0<='9')) ) {
            alt9=30;
        }
        else if ( ((LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='b' && LA9_0<='c')||(LA9_0>='e' && LA9_0<='l')||LA9_0=='n'||(LA9_0>='p' && LA9_0<='z')||(LA9_0>='\u0241' && LA9_0<='\u0377')) ) {
            alt9=31;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( OR | AND | MOD | DIV | LPAREN | RPAREN | LBRACKET | RBRACKET | PIPE | DOT | DOT2 | AT | COMMA | COLON2 | COLON | SLASH | SLASH2 | DOLLAR | PLUS | MINUS | EQ | NE | LT | LTE | GT | GTE | STAR | WS | LITERAL | NUMBER | IDENTIFIER );", 9, 0, input);

            throw nvae;
        }
        switch (alt9) {
            case 1 :
                // XPath10__.g:1:10: OR
                {
                mOR(); 

                }
                break;
            case 2 :
                // XPath10__.g:1:13: AND
                {
                mAND(); 

                }
                break;
            case 3 :
                // XPath10__.g:1:17: MOD
                {
                mMOD(); 

                }
                break;
            case 4 :
                // XPath10__.g:1:21: DIV
                {
                mDIV(); 

                }
                break;
            case 5 :
                // XPath10__.g:1:25: LPAREN
                {
                mLPAREN(); 

                }
                break;
            case 6 :
                // XPath10__.g:1:32: RPAREN
                {
                mRPAREN(); 

                }
                break;
            case 7 :
                // XPath10__.g:1:39: LBRACKET
                {
                mLBRACKET(); 

                }
                break;
            case 8 :
                // XPath10__.g:1:48: RBRACKET
                {
                mRBRACKET(); 

                }
                break;
            case 9 :
                // XPath10__.g:1:57: PIPE
                {
                mPIPE(); 

                }
                break;
            case 10 :
                // XPath10__.g:1:62: DOT
                {
                mDOT(); 

                }
                break;
            case 11 :
                // XPath10__.g:1:66: DOT2
                {
                mDOT2(); 

                }
                break;
            case 12 :
                // XPath10__.g:1:71: AT
                {
                mAT(); 

                }
                break;
            case 13 :
                // XPath10__.g:1:74: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 14 :
                // XPath10__.g:1:80: COLON2
                {
                mCOLON2(); 

                }
                break;
            case 15 :
                // XPath10__.g:1:87: COLON
                {
                mCOLON(); 

                }
                break;
            case 16 :
                // XPath10__.g:1:93: SLASH
                {
                mSLASH(); 

                }
                break;
            case 17 :
                // XPath10__.g:1:99: SLASH2
                {
                mSLASH2(); 

                }
                break;
            case 18 :
                // XPath10__.g:1:106: DOLLAR
                {
                mDOLLAR(); 

                }
                break;
            case 19 :
                // XPath10__.g:1:113: PLUS
                {
                mPLUS(); 

                }
                break;
            case 20 :
                // XPath10__.g:1:118: MINUS
                {
                mMINUS(); 

                }
                break;
            case 21 :
                // XPath10__.g:1:124: EQ
                {
                mEQ(); 

                }
                break;
            case 22 :
                // XPath10__.g:1:127: NE
                {
                mNE(); 

                }
                break;
            case 23 :
                // XPath10__.g:1:130: LT
                {
                mLT(); 

                }
                break;
            case 24 :
                // XPath10__.g:1:133: LTE
                {
                mLTE(); 

                }
                break;
            case 25 :
                // XPath10__.g:1:137: GT
                {
                mGT(); 

                }
                break;
            case 26 :
                // XPath10__.g:1:140: GTE
                {
                mGTE(); 

                }
                break;
            case 27 :
                // XPath10__.g:1:144: STAR
                {
                mSTAR(); 

                }
                break;
            case 28 :
                // XPath10__.g:1:149: WS
                {
                mWS(); 

                }
                break;
            case 29 :
                // XPath10__.g:1:152: LITERAL
                {
                mLITERAL(); 

                }
                break;
            case 30 :
                // XPath10__.g:1:160: NUMBER
                {
                mNUMBER(); 

                }
                break;
            case 31 :
                // XPath10__.g:1:167: IDENTIFIER
                {
                mIDENTIFIER(); 

                }
                break;

        }

    }


 

}