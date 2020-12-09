// $ANTLR 3.0.1 /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g 2008-06-23 18:23:26
   
   package org.eclipse.bpel.xpath10.parser;      
   import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.MismatchedSetException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.Parser;
import org.antlr.runtime.ParserRuleReturnScope;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.RewriteEarlyExitException;
import org.antlr.runtime.tree.RewriteRuleSubtreeStream;
import org.antlr.runtime.tree.RewriteRuleTokenStream;
import org.antlr.runtime.tree.TreeAdaptor;
import org.eclipse.bpel.xpath10.AdditiveExpr;
import org.eclipse.bpel.xpath10.AllNodeStep;
import org.eclipse.bpel.xpath10.Axis;
import org.eclipse.bpel.xpath10.CommentNodeStep;
import org.eclipse.bpel.xpath10.EqualityExpr;
import org.eclipse.bpel.xpath10.Expr;
import org.eclipse.bpel.xpath10.FilterExpr;
import org.eclipse.bpel.xpath10.FunctionCallExpr;
import org.eclipse.bpel.xpath10.LiteralExpr;
import org.eclipse.bpel.xpath10.LocationPath;
import org.eclipse.bpel.xpath10.LogicalExpr;
import org.eclipse.bpel.xpath10.MultiplicativeExpr;
import org.eclipse.bpel.xpath10.NameStep;
import org.eclipse.bpel.xpath10.NumberExpr;
import org.eclipse.bpel.xpath10.PathExpr;
import org.eclipse.bpel.xpath10.Predicate;
import org.eclipse.bpel.xpath10.ProcessingInstructionNodeStep;
import org.eclipse.bpel.xpath10.RelationalExpr;
import org.eclipse.bpel.xpath10.Step;
import org.eclipse.bpel.xpath10.TextNodeStep;
import org.eclipse.bpel.xpath10.UnaryExpr;
import org.eclipse.bpel.xpath10.UnionExpr;
import org.eclipse.bpel.xpath10.VariableReferenceExpr;

public class XPath10Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "OR", "AND", "MOD", "DIV", "LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "PIPE", "DOT", "DOT2", "AT", "COMMA", "COLON2", "COLON", "SLASH", "SLASH2", "DOLLAR", "PLUS", "MINUS", "EQ", "NE", "LT", "LTE", "GT", "GTE", "STAR", "Args", "IDENTIFIER", "LITERAL", "NUMBER", "WS", "DIGITS", "SINGLE_QUOTE_STRING", "DOUBLE_QUOTE_STRING"
    };
    public static final int DOLLAR=21;
    public static final int LT=26;
    public static final int STAR=30;
    public static final int SLASH2=20;
    public static final int MOD=6;
    public static final int DIGITS=36;
    public static final int GTE=29;
    public static final int NUMBER=34;
    public static final int Args=31;
    public static final int LITERAL=33;
    public static final int MINUS=23;
    public static final int AND=5;
    public static final int EOF=-1;
    public static final int LTE=27;
    public static final int LPAREN=8;
    public static final int LBRACKET=10;
    public static final int AT=15;
    public static final int COLON=18;
    public static final int RPAREN=9;
    public static final int SINGLE_QUOTE_STRING=37;
    public static final int WS=35;
    public static final int SLASH=19;
    public static final int DOUBLE_QUOTE_STRING=38;
    public static final int COMMA=16;
    public static final int IDENTIFIER=32;
    public static final int OR=4;
    public static final int GT=28;
    public static final int PLUS=22;
    public static final int PIPE=12;
    public static final int DOT2=14;
    public static final int EQ=24;
    public static final int DIV=7;
    public static final int RBRACKET=11;
    public static final int DOT=13;
    public static final int COLON2=17;
    public static final int NE=25;

        public XPath10Parser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[33+1];
         }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "/org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g"; }

    
          
        boolean isNodeNodeName (String node) {
        		return "node".equals(node);
        }
        boolean isTextNodeName (String node) {
        	  return "text".equals(node);
        }
        boolean isCommentNodeName (String node) {
        	  return "comment".equals(node);
        }
        boolean isProcessingInstructionNodeName (String node) {
        	  return "processing-instruction".equals(node);
        }
          
        static int positionOf (Token token, boolean start) {
        		if (token instanceof CommonToken) {
        		    CommonToken t = (CommonToken)token;
        		    if (start) {
        		    		 return t.getStartIndex();    		    	   
        		    }
        		    return t.getStopIndex();
        		}
        		return -1;
        }
        
        static int positionOfIfUnset (Token token, boolean start, int currentValue) {
        		if (currentValue < 0) {
       					return positionOf(token,start); 		
        		}
        		return currentValue;
        }
    
    	  public void displayRecognitionError(String[] tokenNames, RecognitionException re)
    	  {		    
    		    String msg = getErrorMessage(re, tokenNames);
    		    // we don't recover
             throw new XPath10Exception(msg,re.getCause(),re.index);
    	  }
    	


    public static class xpath_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start xpath
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:109:0: xpath returns [Expr result] : e= unionExpr ;
    public final xpath_return xpath() throws RecognitionException {
        xpath_return retval = new xpath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        unionExpr_return e = null;



        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:110:3: (e= unionExpr )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:110:5: e= unionExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_unionExpr_in_xpath742);
            e=unionExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( backtracking==0 ) {
               retval.result = e.result; 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end xpath

    public static class locationPath_return extends ParserRuleReturnScope {
        public LocationPath result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start locationPath
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:114:0: locationPath returns [LocationPath result] : (aloc= absoluteLocationPath | rloc= relativeLocationPath );
    public final locationPath_return locationPath() throws RecognitionException {
        locationPath_return retval = new locationPath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        absoluteLocationPath_return aloc = null;

        relativeLocationPath_return rloc = null;



        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:114:43: (aloc= absoluteLocationPath | rloc= relativeLocationPath )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=SLASH && LA1_0<=SLASH2)) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=DOT && LA1_0<=AT)||LA1_0==STAR||LA1_0==IDENTIFIER) ) {
                alt1=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("114:0: locationPath returns [LocationPath result] : (aloc= absoluteLocationPath | rloc= relativeLocationPath );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:115:2: aloc= absoluteLocationPath
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_absoluteLocationPath_in_locationPath769);
                    aloc=absoluteLocationPath();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, aloc.getTree());
                    if ( backtracking==0 ) {
                       retval.result =aloc.result; 
                    }

                    }
                    break;
                case 2 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:117:4: rloc= relativeLocationPath
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_relativeLocationPath_in_locationPath781);
                    rloc=relativeLocationPath();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, rloc.getTree());
                    if ( backtracking==0 ) {
                       retval.result =rloc.result; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end locationPath

    public static class absoluteLocationPath_return extends ParserRuleReturnScope {
        public LocationPath result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start absoluteLocationPath
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:121:0: absoluteLocationPath returns [LocationPath result] : (op= SLASH2 | op= SLASH ) ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | ) ;
    public final absoluteLocationPath_return absoluteLocationPath() throws RecognitionException {
        absoluteLocationPath_return retval = new absoluteLocationPath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        i_relativeLocationPath_return loc = null;


        Object op_tree=null;

        
        	Step ans = null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:124:3: ( (op= SLASH2 | op= SLASH ) ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | ) )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:125:3: (op= SLASH2 | op= SLASH ) ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )
            {
            root_0 = (Object)adaptor.nil();

            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:125:3: (op= SLASH2 | op= SLASH )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==SLASH2) ) {
                alt2=1;
            }
            else if ( (LA2_0==SLASH) ) {
                alt2=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("125:3: (op= SLASH2 | op= SLASH )", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:125:4: op= SLASH2
                    {
                    op=(Token)input.LT(1);
                    match(input,SLASH2,FOLLOW_SLASH2_in_absoluteLocationPath811); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }
                    if ( backtracking==0 ) {
                       
                      		     ans=new AllNodeStep(Axis.DESCENDANT_OR_SELF); 
                      		     ans.setPosition(positionOf(op,true),positionOf(op,false)); 
                    }

                    }
                    break;
                case 2 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:127:73: op= SLASH
                    {
                    op=(Token)input.LT(1);
                    match(input,SLASH,FOLLOW_SLASH_in_absoluteLocationPath820); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
                    }

                    }
                    break;

            }

            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==IDENTIFIER) && (synpred1())) {
                alt3=1;
            }
            else if ( (LA3_0==AT) && (synpred1())) {
                alt3=1;
            }
            else if ( (LA3_0==STAR) ) {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==LBRACKET) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==SLASH2) ) {
                    switch ( input.LA(3) ) {
                    case IDENTIFIER:
                        {
                        int LA3_52 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 52, input);

                            throw nvae;
                        }
                        }
                        break;
                    case AT:
                        {
                        int LA3_53 = input.LA(4);

                        if ( (LA3_53==IDENTIFIER) ) {
                            int LA3_158 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 158, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_53==STAR) ) {
                            int LA3_159 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 159, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 53, input);

                            throw nvae;
                        }
                        }
                        break;
                    case STAR:
                        {
                        int LA3_54 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 54, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DOT:
                        {
                        int LA3_55 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 55, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DOT2:
                        {
                        int LA3_56 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 56, input);

                            throw nvae;
                        }
                        }
                        break;
                    case OR:
                    case AND:
                    case MOD:
                    case DIV:
                    case RPAREN:
                    case RBRACKET:
                    case PIPE:
                    case COMMA:
                    case PLUS:
                    case MINUS:
                    case EQ:
                    case NE:
                    case LT:
                    case LTE:
                    case GT:
                    case GTE:
                        {
                        alt3=2;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 24, input);

                        throw nvae;
                    }

                }
                else if ( (LA3_3==SLASH) ) {
                    switch ( input.LA(3) ) {
                    case IDENTIFIER:
                        {
                        int LA3_73 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 73, input);

                            throw nvae;
                        }
                        }
                        break;
                    case AT:
                        {
                        int LA3_74 = input.LA(4);

                        if ( (LA3_74==IDENTIFIER) ) {
                            int LA3_255 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 255, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_74==STAR) ) {
                            int LA3_256 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 256, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 74, input);

                            throw nvae;
                        }
                        }
                        break;
                    case STAR:
                        {
                        int LA3_75 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 75, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DOT:
                        {
                        int LA3_76 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 76, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DOT2:
                        {
                        int LA3_77 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 77, input);

                            throw nvae;
                        }
                        }
                        break;
                    case OR:
                    case AND:
                    case MOD:
                    case DIV:
                    case RPAREN:
                    case RBRACKET:
                    case PIPE:
                    case COMMA:
                    case PLUS:
                    case MINUS:
                    case EQ:
                    case NE:
                    case LT:
                    case LTE:
                    case GT:
                    case GTE:
                        {
                        alt3=2;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 25, input);

                        throw nvae;
                    }

                }
                else if ( (LA3_3==PIPE) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==EOF) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==STAR) ) {
                    int LA3_28 = input.LA(3);

                    if ( ((LA3_28>=OR && LA3_28<=DIV)||(LA3_28>=RPAREN && LA3_28<=PIPE)||LA3_28==COMMA||LA3_28==PLUS||(LA3_28>=EQ && LA3_28<=GTE)) ) {
                        alt3=2;
                    }
                    else if ( (LA3_28==SLASH2) ) {
                        int LA3_95 = input.LA(4);

                        if ( (LA3_95==IDENTIFIER) ) {
                            int LA3_328 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 328, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_95==AT) ) {
                            int LA3_329 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 329, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_95==STAR) ) {
                            int LA3_330 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 330, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_95==DOT) ) {
                            int LA3_331 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 331, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_95==DOT2) ) {
                            int LA3_332 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 332, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_95==PIPE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==PLUS) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==MINUS) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==LT) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==GT) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==LTE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==GTE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==EQ) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==NE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==AND) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==OR) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==RBRACKET) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==RPAREN) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==COMMA) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==DIV) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_95==MOD) && (synpred1())) {
                            alt3=1;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 95, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA3_28==SLASH) ) {
                        int LA3_96 = input.LA(4);

                        if ( (LA3_96==IDENTIFIER) ) {
                            int LA3_349 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 349, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_96==AT) ) {
                            int LA3_350 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 350, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_96==STAR) ) {
                            int LA3_351 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 351, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_96==DOT) ) {
                            int LA3_352 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 352, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_96==DOT2) ) {
                            int LA3_353 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 353, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_96==PIPE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==PLUS) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==MINUS) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==LT) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==GT) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==LTE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==GTE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==EQ) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==NE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==AND) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==OR) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==RBRACKET) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==RPAREN) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==COMMA) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==DIV) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_96==MOD) && (synpred1())) {
                            alt3=1;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 96, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA3_28==MINUS) ) {
                        switch ( input.LA(4) ) {
                        case SLASH2:
                            {
                            int LA3_370 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 370, input);

                                throw nvae;
                            }
                            }
                            break;
                        case SLASH:
                            {
                            int LA3_371 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 371, input);

                                throw nvae;
                            }
                            }
                            break;
                        case IDENTIFIER:
                            {
                            int LA3_372 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 372, input);

                                throw nvae;
                            }
                            }
                            break;
                        case AT:
                            {
                            int LA3_373 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 373, input);

                                throw nvae;
                            }
                            }
                            break;
                        case STAR:
                            {
                            int LA3_374 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 374, input);

                                throw nvae;
                            }
                            }
                            break;
                        case DOT:
                            {
                            int LA3_375 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 375, input);

                                throw nvae;
                            }
                            }
                            break;
                        case DOT2:
                            {
                            int LA3_376 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 376, input);

                                throw nvae;
                            }
                            }
                            break;
                        case DOLLAR:
                            {
                            int LA3_377 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 377, input);

                                throw nvae;
                            }
                            }
                            break;
                        case LPAREN:
                            {
                            int LA3_378 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 378, input);

                                throw nvae;
                            }
                            }
                            break;
                        case LITERAL:
                            {
                            int LA3_379 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 379, input);

                                throw nvae;
                            }
                            }
                            break;
                        case NUMBER:
                            {
                            int LA3_380 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 380, input);

                                throw nvae;
                            }
                            }
                            break;
                        case MINUS:
                            {
                            int LA3_381 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 381, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 99, input);

                            throw nvae;
                        }

                    }
                    else if ( (LA3_28==STAR) ) {
                        int LA3_111 = input.LA(4);

                        if ( (LA3_111==LBRACKET) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==SLASH2) ) {
                            int LA3_383 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 383, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_111==SLASH) ) {
                            int LA3_384 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 384, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_111==PIPE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==PLUS) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==MINUS) ) {
                            int LA3_387 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 387, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_111==LT) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==GT) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==LTE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==GTE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==EQ) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==NE) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==AND) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==OR) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==RBRACKET) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==RPAREN) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==COMMA) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==STAR) ) {
                            int LA3_399 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 399, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_111==DIV) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==MOD) && (synpred1())) {
                            alt3=1;
                        }
                        else if ( (LA3_111==LPAREN||(LA3_111>=DOT && LA3_111<=AT)||LA3_111==DOLLAR||(LA3_111>=IDENTIFIER && LA3_111<=NUMBER)) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 111, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA3_28==IDENTIFIER) && (synpred1())) {
                        alt3=1;
                    }
                    else if ( (LA3_28==AT) && (synpred1())) {
                        alt3=1;
                    }
                    else if ( (LA3_28==DOT) && (synpred1())) {
                        alt3=1;
                    }
                    else if ( (LA3_28==DOT2) && (synpred1())) {
                        alt3=1;
                    }
                    else if ( (LA3_28==DOLLAR) && (synpred1())) {
                        alt3=1;
                    }
                    else if ( (LA3_28==LPAREN) && (synpred1())) {
                        alt3=1;
                    }
                    else if ( (LA3_28==LITERAL) && (synpred1())) {
                        alt3=1;
                    }
                    else if ( (LA3_28==NUMBER) && (synpred1())) {
                        alt3=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 28, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_3==DIV) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==MOD) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==PLUS) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==MINUS) ) {
                    switch ( input.LA(3) ) {
                    case SLASH2:
                        {
                        int LA3_122 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 122, input);

                            throw nvae;
                        }
                        }
                        break;
                    case SLASH:
                        {
                        int LA3_123 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 123, input);

                            throw nvae;
                        }
                        }
                        break;
                    case IDENTIFIER:
                        {
                        int LA3_124 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 124, input);

                            throw nvae;
                        }
                        }
                        break;
                    case AT:
                        {
                        int LA3_125 = input.LA(4);

                        if ( (LA3_125==IDENTIFIER) ) {
                            int LA3_475 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 475, input);

                                throw nvae;
                            }
                        }
                        else if ( (LA3_125==STAR) ) {
                            int LA3_476 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 476, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 125, input);

                            throw nvae;
                        }
                        }
                        break;
                    case STAR:
                        {
                        int LA3_126 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 126, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DOT:
                        {
                        int LA3_127 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 127, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DOT2:
                        {
                        int LA3_128 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 128, input);

                            throw nvae;
                        }
                        }
                        break;
                    case DOLLAR:
                        {
                        int LA3_129 = input.LA(4);

                        if ( (LA3_129==IDENTIFIER) ) {
                            int LA3_537 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 537, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 129, input);

                            throw nvae;
                        }
                        }
                        break;
                    case LPAREN:
                        {
                        switch ( input.LA(4) ) {
                        case SLASH2:
                            {
                            int LA3_538 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 538, input);

                                throw nvae;
                            }
                            }
                            break;
                        case SLASH:
                            {
                            int LA3_539 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 539, input);

                                throw nvae;
                            }
                            }
                            break;
                        case IDENTIFIER:
                            {
                            int LA3_540 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 540, input);

                                throw nvae;
                            }
                            }
                            break;
                        case AT:
                            {
                            int LA3_541 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 541, input);

                                throw nvae;
                            }
                            }
                            break;
                        case STAR:
                            {
                            int LA3_542 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 542, input);

                                throw nvae;
                            }
                            }
                            break;
                        case DOT:
                            {
                            int LA3_543 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 543, input);

                                throw nvae;
                            }
                            }
                            break;
                        case DOT2:
                            {
                            int LA3_544 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 544, input);

                                throw nvae;
                            }
                            }
                            break;
                        case DOLLAR:
                            {
                            int LA3_545 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 545, input);

                                throw nvae;
                            }
                            }
                            break;
                        case LPAREN:
                            {
                            int LA3_546 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 546, input);

                                throw nvae;
                            }
                            }
                            break;
                        case LITERAL:
                            {
                            int LA3_547 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 547, input);

                                throw nvae;
                            }
                            }
                            break;
                        case NUMBER:
                            {
                            int LA3_548 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 548, input);

                                throw nvae;
                            }
                            }
                            break;
                        case MINUS:
                            {
                            int LA3_549 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 549, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 130, input);

                            throw nvae;
                        }

                        }
                        break;
                    case LITERAL:
                        {
                        int LA3_131 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 131, input);

                            throw nvae;
                        }
                        }
                        break;
                    case NUMBER:
                        {
                        int LA3_132 = input.LA(4);

                        if ( (synpred1()) ) {
                            alt3=1;
                        }
                        else if ( (true) ) {
                            alt3=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 132, input);

                            throw nvae;
                        }
                        }
                        break;
                    case MINUS:
                        {
                        switch ( input.LA(4) ) {
                        case SLASH2:
                            {
                            int LA3_590 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 590, input);

                                throw nvae;
                            }
                            }
                            break;
                        case SLASH:
                            {
                            int LA3_591 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 591, input);

                                throw nvae;
                            }
                            }
                            break;
                        case IDENTIFIER:
                            {
                            int LA3_592 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 592, input);

                                throw nvae;
                            }
                            }
                            break;
                        case AT:
                            {
                            int LA3_593 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 593, input);

                                throw nvae;
                            }
                            }
                            break;
                        case STAR:
                            {
                            int LA3_594 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 594, input);

                                throw nvae;
                            }
                            }
                            break;
                        case DOT:
                            {
                            int LA3_595 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 595, input);

                                throw nvae;
                            }
                            }
                            break;
                        case DOT2:
                            {
                            int LA3_596 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 596, input);

                                throw nvae;
                            }
                            }
                            break;
                        case DOLLAR:
                            {
                            int LA3_597 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 597, input);

                                throw nvae;
                            }
                            }
                            break;
                        case LPAREN:
                            {
                            int LA3_598 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 598, input);

                                throw nvae;
                            }
                            }
                            break;
                        case LITERAL:
                            {
                            int LA3_599 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 599, input);

                                throw nvae;
                            }
                            }
                            break;
                        case NUMBER:
                            {
                            int LA3_600 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 600, input);

                                throw nvae;
                            }
                            }
                            break;
                        case MINUS:
                            {
                            int LA3_601 = input.LA(5);

                            if ( (synpred1()) ) {
                                alt3=1;
                            }
                            else if ( (true) ) {
                                alt3=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 601, input);

                                throw nvae;
                            }
                            }
                            break;
                        default:
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 133, input);

                            throw nvae;
                        }

                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 32, input);

                        throw nvae;
                    }

                }
                else if ( (LA3_3==LT) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==GT) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==LTE) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==GTE) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==EQ) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==NE) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==AND) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==OR) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==RBRACKET) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==RPAREN) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==COMMA) && (synpred1())) {
                    alt3=1;
                }
                else if ( (LA3_3==LPAREN||(LA3_3>=DOT && LA3_3<=AT)||LA3_3==DOLLAR||(LA3_3>=IDENTIFIER && LA3_3<=NUMBER)) ) {
                    alt3=2;
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 3, input);

                    throw nvae;
                }
            }
            else if ( (LA3_0==DOT) && (synpred1())) {
                alt3=1;
            }
            else if ( (LA3_0==DOT2) && (synpred1())) {
                alt3=1;
            }
            else if ( (LA3_0==EOF||(LA3_0>=OR && LA3_0<=DIV)||LA3_0==RPAREN||(LA3_0>=RBRACKET && LA3_0<=PIPE)||LA3_0==COMMA||(LA3_0>=PLUS && LA3_0<=GTE)) ) {
                alt3=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("129:7: ( ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath | )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:129:9: ( AT | STAR | IDENTIFIER )=>loc= i_relativeLocationPath
                    {
                    pushFollow(FOLLOW_i_relativeLocationPath_in_absoluteLocationPath853);
                    loc=i_relativeLocationPath();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, loc.getTree());
                    if ( backtracking==0 ) {
                       retval.result = loc.result; 
                    }

                    }
                    break;
                case 2 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:129:88: 
                    {
                    if ( backtracking==0 ) {
                       retval.result = new LocationPath(true); 
                    }

                    }
                    break;

            }

            if ( backtracking==0 ) {
               if (retval.result != null) {
              		          if (ans != null) { retval.result.addFirstStep(ans); }
              		          retval.result.setIsAbsolute(true);
              		       }
              		     
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end absoluteLocationPath

    public static class relativeLocationPath_return extends ParserRuleReturnScope {
        public LocationPath result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start relativeLocationPath
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:137:0: relativeLocationPath returns [LocationPath result] : e= i_relativeLocationPath ;
    public final relativeLocationPath_return relativeLocationPath() throws RecognitionException {
        relativeLocationPath_return retval = new relativeLocationPath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        i_relativeLocationPath_return e = null;



        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:137:51: (e= i_relativeLocationPath )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:138:3: e= i_relativeLocationPath
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_i_relativeLocationPath_in_relativeLocationPath898);
            e=i_relativeLocationPath();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( backtracking==0 ) {
               retval.result = e.result; 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end relativeLocationPath

    public static class i_relativeLocationPath_return extends ParserRuleReturnScope {
        public LocationPath result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start i_relativeLocationPath
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:142:0: i_relativeLocationPath returns [LocationPath result] : s1= step ( (op= SLASH2 | SLASH ) s2= step )* ;
    public final i_relativeLocationPath_return i_relativeLocationPath() throws RecognitionException {
        i_relativeLocationPath_return retval = new i_relativeLocationPath_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        Token SLASH1=null;
        step_return s1 = null;

        step_return s2 = null;


        Object op_tree=null;
        Object SLASH1_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:142:53: (s1= step ( (op= SLASH2 | SLASH ) s2= step )* )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:143:4: s1= step ( (op= SLASH2 | SLASH ) s2= step )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_step_in_i_relativeLocationPath926);
            s1=step();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, s1.getTree());
            if ( backtracking==0 ) {
               retval.result =new LocationPath(false, s1.result); 
            }
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:144:7: ( (op= SLASH2 | SLASH ) s2= step )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=SLASH && LA5_0<=SLASH2)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:144:9: (op= SLASH2 | SLASH ) s2= step
            	    {
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:144:9: (op= SLASH2 | SLASH )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==SLASH2) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==SLASH) ) {
            	        alt4=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("144:9: (op= SLASH2 | SLASH )", 4, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:144:10: op= SLASH2
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,SLASH2,FOLLOW_SLASH2_in_i_relativeLocationPath941); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            adaptor.addChild(root_0, op_tree);
            	            }
            	            if ( backtracking==0 ) {
            	               retval.result.addStep(new AllNodeStep(Axis.DESCENDANT_OR_SELF)); 
            	              	                    retval.result.setPosition(positionOf(op,true),positionOf(op,false));
            	              	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:146:23: SLASH
            	            {
            	            SLASH1=(Token)input.LT(1);
            	            match(input,SLASH,FOLLOW_SLASH_in_i_relativeLocationPath946); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            SLASH1_tree = (Object)adaptor.create(SLASH1);
            	            adaptor.addChild(root_0, SLASH1_tree);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_step_in_i_relativeLocationPath952);
            	    s2=step();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, s2.getTree());
            	    if ( backtracking==0 ) {
            	      retval.result.addStep(s2.result);
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end i_relativeLocationPath

    public static class step_return extends ParserRuleReturnScope {
        public Step result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start step
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:154:0: step returns [Step result] : ( ( ( ( IDENTIFIER COLON2 | AT )=> axis | ) ( ( (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR ) ) | ss= specialStep ) (p= predicate )* ) | as= abbrStep (p= predicate )* );
    public final step_return step() throws RecognitionException {
        step_return retval = new step_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token ns=null;
        Token id=null;
        Token COLON3=null;
        specialStep_return ss = null;

        predicate_return p = null;

        abbrStep_return as = null;

        axis_return axis2 = null;


        Object ns_tree=null;
        Object id_tree=null;
        Object COLON3_tree=null;

        
        	// default axis, per XPath spec.
        	int anAxis  = Axis.CHILD;
        	int posStart = -1;
        	String aNs  = null;
        	

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:161:4: ( ( ( ( IDENTIFIER COLON2 | AT )=> axis | ) ( ( (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR ) ) | ss= specialStep ) (p= predicate )* ) | as= abbrStep (p= predicate )* )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==AT||LA12_0==STAR||LA12_0==IDENTIFIER) ) {
                alt12=1;
            }
            else if ( ((LA12_0>=DOT && LA12_0<=DOT2)) ) {
                alt12=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("154:0: step returns [Step result] : ( ( ( ( IDENTIFIER COLON2 | AT )=> axis | ) ( ( (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR ) ) | ss= specialStep ) (p= predicate )* ) | as= abbrStep (p= predicate )* );", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:162:3: ( ( ( IDENTIFIER COLON2 | AT )=> axis | ) ( ( (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR ) ) | ss= specialStep ) (p= predicate )* )
                    {
                    root_0 = (Object)adaptor.nil();

                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:162:3: ( ( ( IDENTIFIER COLON2 | AT )=> axis | ) ( ( (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR ) ) | ss= specialStep ) (p= predicate )* )
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:164:4: ( ( IDENTIFIER COLON2 | AT )=> axis | ) ( ( (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR ) ) | ss= specialStep ) (p= predicate )*
                    {
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:164:4: ( ( IDENTIFIER COLON2 | AT )=> axis | )
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==IDENTIFIER) ) {
                        int LA6_1 = input.LA(2);

                        if ( (LA6_1==EOF||(LA6_1>=OR && LA6_1<=PIPE)||LA6_1==COMMA||(LA6_1>=COLON && LA6_1<=SLASH2)||(LA6_1>=PLUS && LA6_1<=STAR)) ) {
                            alt6=2;
                        }
                        else if ( (LA6_1==COLON2) && (synpred2())) {
                            alt6=1;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("164:4: ( ( IDENTIFIER COLON2 | AT )=> axis | )", 6, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA6_0==AT) && (synpred2())) {
                        alt6=1;
                    }
                    else if ( (LA6_0==STAR) ) {
                        alt6=2;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("164:4: ( ( IDENTIFIER COLON2 | AT )=> axis | )", 6, 0, input);

                        throw nvae;
                    }
                    switch (alt6) {
                        case 1 :
                            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:164:6: ( IDENTIFIER COLON2 | AT )=> axis
                            {
                            pushFollow(FOLLOW_axis_in_step1015);
                            axis2=axis();
                            _fsp--;
                            if (failed) return retval;
                            if ( backtracking==0 ) adaptor.addChild(root_0, axis2.getTree());
                            if ( backtracking==0 ) {
                               anAxis=axis2.axis; posStart = axis2.posStart;
                            }

                            }
                            break;
                        case 2 :
                            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:164:124: 
                            {
                            }
                            break;

                    }

                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:166:4: ( ( (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR ) ) | ss= specialStep )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==IDENTIFIER) ) {
                        int LA9_1 = input.LA(2);

                        if ( (LA9_1==LPAREN) ) {
                            alt9=2;
                        }
                        else if ( (LA9_1==EOF||(LA9_1>=OR && LA9_1<=DIV)||(LA9_1>=RPAREN && LA9_1<=PIPE)||LA9_1==COMMA||(LA9_1>=COLON && LA9_1<=SLASH2)||(LA9_1>=PLUS && LA9_1<=STAR)) ) {
                            alt9=1;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("166:4: ( ( (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR ) ) | ss= specialStep )", 9, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA9_0==STAR) ) {
                        alt9=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("166:4: ( ( (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR ) ) | ss= specialStep )", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:167:5: ( (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR ) )
                            {
                            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:167:5: ( (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR ) )
                            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:167:7: (ns= IDENTIFIER COLON )? (id= IDENTIFIER | id= STAR )
                            {
                            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:167:7: (ns= IDENTIFIER COLON )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==IDENTIFIER) ) {
                                int LA7_1 = input.LA(2);

                                if ( (LA7_1==COLON) ) {
                                    alt7=1;
                                }
                            }
                            switch (alt7) {
                                case 1 :
                                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:167:8: ns= IDENTIFIER COLON
                                    {
                                    ns=(Token)input.LT(1);
                                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_step1042); if (failed) return retval;
                                    if ( backtracking==0 ) {
                                    ns_tree = (Object)adaptor.create(ns);
                                    adaptor.addChild(root_0, ns_tree);
                                    }
                                    COLON3=(Token)input.LT(1);
                                    match(input,COLON,FOLLOW_COLON_in_step1044); if (failed) return retval;
                                    if ( backtracking==0 ) {
                                    COLON3_tree = (Object)adaptor.create(COLON3);
                                    adaptor.addChild(root_0, COLON3_tree);
                                    }
                                    if ( backtracking==0 ) {
                                       aNs=ns.getText(); posStart=positionOfIfUnset(ns,true,posStart); 
                                    }

                                    }
                                    break;

                            }

                            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:167:97: (id= IDENTIFIER | id= STAR )
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( (LA8_0==IDENTIFIER) ) {
                                alt8=1;
                            }
                            else if ( (LA8_0==STAR) ) {
                                alt8=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("167:97: (id= IDENTIFIER | id= STAR )", 8, 0, input);

                                throw nvae;
                            }
                            switch (alt8) {
                                case 1 :
                                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:167:99: id= IDENTIFIER
                                    {
                                    id=(Token)input.LT(1);
                                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_step1056); if (failed) return retval;
                                    if ( backtracking==0 ) {
                                    id_tree = (Object)adaptor.create(id);
                                    adaptor.addChild(root_0, id_tree);
                                    }

                                    }
                                    break;
                                case 2 :
                                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:167:113: id= STAR
                                    {
                                    id=(Token)input.LT(1);
                                    match(input,STAR,FOLLOW_STAR_in_step1060); if (failed) return retval;
                                    if ( backtracking==0 ) {
                                    id_tree = (Object)adaptor.create(id);
                                    adaptor.addChild(root_0, id_tree);
                                    }

                                    }
                                    break;

                            }

                            if ( backtracking==0 ) {
                              				 
                              					          retval.result = new NameStep(anAxis,aNs,id.getText()); 
                              					          retval.result.setPosition(positionOfIfUnset(id,true,posStart), positionOf(id,false));
                              				          
                            }

                            }


                            }
                            break;
                        case 2 :
                            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:173:5: ss= specialStep
                            {
                            pushFollow(FOLLOW_specialStep_in_step1081);
                            ss=specialStep();
                            _fsp--;
                            if (failed) return retval;
                            if ( backtracking==0 ) adaptor.addChild(root_0, ss.getTree());
                            if ( backtracking==0 ) {
                              retval.result = ss.result; retval.result.setAxis(anAxis); 
                            }

                            }
                            break;

                    }

                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:175:6: (p= predicate )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==LBRACKET) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:175:8: p= predicate
                    	    {
                    	    pushFollow(FOLLOW_predicate_in_step1099);
                    	    p=predicate();
                    	    _fsp--;
                    	    if (failed) return retval;
                    	    if ( backtracking==0 ) adaptor.addChild(root_0, p.getTree());
                    	    if ( backtracking==0 ) {
                    	      retval.result.addPredicate(p.result);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:178:5: as= abbrStep (p= predicate )*
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_abbrStep_in_step1121);
                    as=abbrStep();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, as.getTree());
                    if ( backtracking==0 ) {
                      
                      		              retval.result =as.result; 
                      		              retval.result.setPosition(as.posStart,as.posEnd);
                      		             
                    }
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:181:19: (p= predicate )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==LBRACKET) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:181:21: p= predicate
                    	    {
                    	    pushFollow(FOLLOW_predicate_in_step1130);
                    	    p=predicate();
                    	    _fsp--;
                    	    if (failed) return retval;
                    	    if ( backtracking==0 ) adaptor.addChild(root_0, p.getTree());
                    	    if ( backtracking==0 ) {
                    	      retval.result.addPredicate(p.result);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end step

    public static class specialStep_return extends ParserRuleReturnScope {
        public Step result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start specialStep
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:187:0: specialStep returns [Step result] : ({...}?id= IDENTIFIER LPAREN (pi= IDENTIFIER )? rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN );
    public final specialStep_return specialStep() throws RecognitionException {
        specialStep_return retval = new specialStep_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token pi=null;
        Token rp=null;
        Token LPAREN4=null;
        Token LPAREN5=null;
        Token LPAREN6=null;
        Token LPAREN7=null;

        Object id_tree=null;
        Object pi_tree=null;
        Object rp_tree=null;
        Object LPAREN4_tree=null;
        Object LPAREN5_tree=null;
        Object LPAREN6_tree=null;
        Object LPAREN7_tree=null;

        
           String piID = null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:190:3: ({...}?id= IDENTIFIER LPAREN (pi= IDENTIFIER )? rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN )
            int alt14=4;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==IDENTIFIER) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==LPAREN) ) {
                    int LA14_2 = input.LA(3);

                    if ( (LA14_2==RPAREN) ) {
                        int LA14_3 = input.LA(4);

                        if ( (	isProcessingInstructionNodeName( input.LT(1).getText() ) ) ) {
                            alt14=1;
                        }
                        else if ( ( isCommentNodeName(input.LT(1).getText()) ) ) {
                            alt14=2;
                        }
                        else if ( ( isTextNodeName(input.LT(1).getText())  ) ) {
                            alt14=3;
                        }
                        else if ( ( isNodeNodeName(input.LT(1).getText())  ) ) {
                            alt14=4;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("187:0: specialStep returns [Step result] : ({...}?id= IDENTIFIER LPAREN (pi= IDENTIFIER )? rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN );", 14, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA14_2==IDENTIFIER) ) {
                        alt14=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("187:0: specialStep returns [Step result] : ({...}?id= IDENTIFIER LPAREN (pi= IDENTIFIER )? rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN );", 14, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("187:0: specialStep returns [Step result] : ({...}?id= IDENTIFIER LPAREN (pi= IDENTIFIER )? rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN );", 14, 1, input);

                    throw nvae;
                }
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("187:0: specialStep returns [Step result] : ({...}?id= IDENTIFIER LPAREN (pi= IDENTIFIER )? rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN | {...}?id= IDENTIFIER LPAREN rp= RPAREN );", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:191:2: {...}?id= IDENTIFIER LPAREN (pi= IDENTIFIER )? rp= RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !(	isProcessingInstructionNodeName( input.LT(1).getText() ) ) ) {
                        if (backtracking>0) {failed=true; return retval;}
                        throw new FailedPredicateException(input, "specialStep", "\tisProcessingInstructionNodeName( input.LT(1).getText() ) ");
                    }
                    id=(Token)input.LT(1);
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_specialStep1167); if (failed) return retval;
                    if ( backtracking==0 ) {
                    id_tree = (Object)adaptor.create(id);
                    root_0 = (Object)adaptor.becomeRoot(id_tree, root_0);
                    }
                    LPAREN4=(Token)input.LT(1);
                    match(input,LPAREN,FOLLOW_LPAREN_in_specialStep1170); if (failed) return retval;
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:192:27: (pi= IDENTIFIER )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==IDENTIFIER) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:192:29: pi= IDENTIFIER
                            {
                            pi=(Token)input.LT(1);
                            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_specialStep1177); if (failed) return retval;
                            if ( backtracking==0 ) {
                            pi_tree = (Object)adaptor.create(pi);
                            adaptor.addChild(root_0, pi_tree);
                            }
                            if ( backtracking==0 ) {
                              piID=pi.getText(); 
                            }

                            }
                            break;

                    }

                    rp=(Token)input.LT(1);
                    match(input,RPAREN,FOLLOW_RPAREN_in_specialStep1186); if (failed) return retval;
                    if ( backtracking==0 ) {
                       retval.result = new ProcessingInstructionNodeStep(0, piID );
                      			    retval.result.setPosition(positionOf(id,true),positionOf(rp,false));
                      			  
                    }

                    }
                    break;
                case 2 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:197:4: {...}?id= IDENTIFIER LPAREN rp= RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !( isCommentNodeName(input.LT(1).getText()) ) ) {
                        if (backtracking>0) {failed=true; return retval;}
                        throw new FailedPredicateException(input, "specialStep", " isCommentNodeName(input.LT(1).getText()) ");
                    }
                    id=(Token)input.LT(1);
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_specialStep1215); if (failed) return retval;
                    if ( backtracking==0 ) {
                    id_tree = (Object)adaptor.create(id);
                    root_0 = (Object)adaptor.becomeRoot(id_tree, root_0);
                    }
                    LPAREN5=(Token)input.LT(1);
                    match(input,LPAREN,FOLLOW_LPAREN_in_specialStep1218); if (failed) return retval;
                    rp=(Token)input.LT(1);
                    match(input,RPAREN,FOLLOW_RPAREN_in_specialStep1223); if (failed) return retval;
                    if ( backtracking==0 ) {
                       retval.result = new CommentNodeStep(Axis.CHILD); 
                      	        retval.result.setPosition(positionOf(id,true),positionOf(rp,false));
                      	      
                    }

                    }
                    break;
                case 3 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:202:4: {...}?id= IDENTIFIER LPAREN rp= RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !( isTextNodeName(input.LT(1).getText())  ) ) {
                        if (backtracking>0) {failed=true; return retval;}
                        throw new FailedPredicateException(input, "specialStep", " isTextNodeName(input.LT(1).getText())  ");
                    }
                    id=(Token)input.LT(1);
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_specialStep1262); if (failed) return retval;
                    if ( backtracking==0 ) {
                    id_tree = (Object)adaptor.create(id);
                    root_0 = (Object)adaptor.becomeRoot(id_tree, root_0);
                    }
                    LPAREN6=(Token)input.LT(1);
                    match(input,LPAREN,FOLLOW_LPAREN_in_specialStep1265); if (failed) return retval;
                    rp=(Token)input.LT(1);
                    match(input,RPAREN,FOLLOW_RPAREN_in_specialStep1270); if (failed) return retval;
                    if ( backtracking==0 ) {
                       retval.result = new TextNodeStep(Axis.CHILD);
                      	        retval.result.setPosition(positionOf(id,true),positionOf(rp,false)); 
                      	      
                    }

                    }
                    break;
                case 4 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:207:4: {...}?id= IDENTIFIER LPAREN rp= RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    if ( !( isNodeNodeName(input.LT(1).getText())  ) ) {
                        if (backtracking>0) {failed=true; return retval;}
                        throw new FailedPredicateException(input, "specialStep", " isNodeNodeName(input.LT(1).getText())  ");
                    }
                    id=(Token)input.LT(1);
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_specialStep1302); if (failed) return retval;
                    if ( backtracking==0 ) {
                    id_tree = (Object)adaptor.create(id);
                    root_0 = (Object)adaptor.becomeRoot(id_tree, root_0);
                    }
                    LPAREN7=(Token)input.LT(1);
                    match(input,LPAREN,FOLLOW_LPAREN_in_specialStep1305); if (failed) return retval;
                    rp=(Token)input.LT(1);
                    match(input,RPAREN,FOLLOW_RPAREN_in_specialStep1310); if (failed) return retval;
                    if ( backtracking==0 ) {
                       retval.result = new AllNodeStep(Axis.CHILD); 
                      	        retval.result.setPosition(positionOf(id,true),positionOf(rp,false));
                      	      
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end specialStep

    public static class axis_return extends ParserRuleReturnScope {
        public int axis;
        public int posStart;
        public int posEnd;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start axis
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:214:0: axis returns [int axis, int posStart, int posEnd ] : (id= IDENTIFIER COLON2 | at= AT );
    public final axis_return axis() throws RecognitionException {
        axis_return retval = new axis_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token id=null;
        Token at=null;
        Token COLON28=null;

        Object id_tree=null;
        Object at_tree=null;
        Object COLON28_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:214:51: (id= IDENTIFIER COLON2 | at= AT )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER) ) {
                alt15=1;
            }
            else if ( (LA15_0==AT) ) {
                alt15=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("214:0: axis returns [int axis, int posStart, int posEnd ] : (id= IDENTIFIER COLON2 | at= AT );", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:215:4: id= IDENTIFIER COLON2
                    {
                    root_0 = (Object)adaptor.nil();

                    id=(Token)input.LT(1);
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_axis1366); if (failed) return retval;
                    if ( backtracking==0 ) {
                    id_tree = (Object)adaptor.create(id);
                    adaptor.addChild(root_0, id_tree);
                    }
                    COLON28=(Token)input.LT(1);
                    match(input,COLON2,FOLLOW_COLON2_in_axis1368); if (failed) return retval;
                    if ( backtracking==0 ) {
                    COLON28_tree = (Object)adaptor.create(COLON28);
                    root_0 = (Object)adaptor.becomeRoot(COLON28_tree, root_0);
                    }
                    if ( backtracking==0 ) {
                       retval.axis = Axis.getAxis( id.getText()); 
                        	      retval.posStart = positionOf(id,true);
                        	      retval.posEnd = positionOf(id,false);
                        	    
                    }

                    }
                    break;
                case 2 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:220:6: at= AT
                    {
                    root_0 = (Object)adaptor.nil();

                    at=(Token)input.LT(1);
                    match(input,AT,FOLLOW_AT_in_axis1388); if (failed) return retval;
                    if ( backtracking==0 ) {
                    at_tree = (Object)adaptor.create(at);
                    adaptor.addChild(root_0, at_tree);
                    }
                    if ( backtracking==0 ) {
                       retval.axis = Axis.ATTRIBUTE;
                        	      retval.posStart = positionOf(at,true);
                        	      retval.posEnd = positionOf(at,false);
                        	    
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end axis

    public static class predicate_return extends ParserRuleReturnScope {
        public Predicate result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start predicate
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:235:0: predicate returns [Predicate result] : LBRACKET e= predicateExpr RBRACKET ;
    public final predicate_return predicate() throws RecognitionException {
        predicate_return retval = new predicate_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LBRACKET9=null;
        Token RBRACKET10=null;
        predicateExpr_return e = null;


        Object LBRACKET9_tree=null;
        Object RBRACKET10_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:235:37: ( LBRACKET e= predicateExpr RBRACKET )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:236:3: LBRACKET e= predicateExpr RBRACKET
            {
            root_0 = (Object)adaptor.nil();

            LBRACKET9=(Token)input.LT(1);
            match(input,LBRACKET,FOLLOW_LBRACKET_in_predicate1430); if (failed) return retval;
            if ( backtracking==0 ) {
            LBRACKET9_tree = (Object)adaptor.create(LBRACKET9);
            root_0 = (Object)adaptor.becomeRoot(LBRACKET9_tree, root_0);
            }
            pushFollow(FOLLOW_predicateExpr_in_predicate1435);
            e=predicateExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            RBRACKET10=(Token)input.LT(1);
            match(input,RBRACKET,FOLLOW_RBRACKET_in_predicate1437); if (failed) return retval;
            if ( backtracking==0 ) {
               retval.result = e.result ; 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end predicate

    public static class predicateExpr_return extends ParserRuleReturnScope {
        public Predicate result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start predicateExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:242:0: predicateExpr returns [Predicate result] : e= expr ;
    public final predicateExpr_return predicateExpr() throws RecognitionException {
        predicateExpr_return retval = new predicateExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        expr_return e = null;



        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:243:3: (e= expr )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:243:5: e= expr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expr_in_predicateExpr1468);
            e=expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( backtracking==0 ) {
               retval.result = new Predicate(e.result) ; 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end predicateExpr

    public static class abbrStep_return extends ParserRuleReturnScope {
        public Step result;
        public int posStart;
        public int posEnd;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start abbrStep
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:251:0: abbrStep returns [Step result, int posStart, int posEnd ] : (d= DOT | d= DOT2 );
    public final abbrStep_return abbrStep() throws RecognitionException {
        abbrStep_return retval = new abbrStep_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token d=null;

        Object d_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:251:58: (d= DOT | d= DOT2 )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==DOT) ) {
                alt16=1;
            }
            else if ( (LA16_0==DOT2) ) {
                alt16=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("251:0: abbrStep returns [Step result, int posStart, int posEnd ] : (d= DOT | d= DOT2 );", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:252:4: d= DOT
                    {
                    root_0 = (Object)adaptor.nil();

                    d=(Token)input.LT(1);
                    match(input,DOT,FOLLOW_DOT_in_abbrStep1500); if (failed) return retval;
                    if ( backtracking==0 ) {
                    d_tree = (Object)adaptor.create(d);
                    adaptor.addChild(root_0, d_tree);
                    }
                    if ( backtracking==0 ) {
                       retval.result = new AllNodeStep(Axis.SELF);   retval.posStart = positionOf(d,true); retval.posEnd = retval.posStart+1; 
                    }

                    }
                    break;
                case 2 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:253:4: d= DOT2
                    {
                    root_0 = (Object)adaptor.nil();

                    d=(Token)input.LT(1);
                    match(input,DOT2,FOLLOW_DOT2_in_abbrStep1513); if (failed) return retval;
                    if ( backtracking==0 ) {
                    d_tree = (Object)adaptor.create(d);
                    adaptor.addChild(root_0, d_tree);
                    }
                    if ( backtracking==0 ) {
                       retval.result = new AllNodeStep(Axis.PARENT); retval.posStart = positionOf(d,true); retval.posEnd = retval.posStart+2; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end abbrStep

    public static class abbrAxisSpecifier_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start abbrAxisSpecifier
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:259:0: abbrAxisSpecifier : ( AT )? ;
    public final abbrAxisSpecifier_return abbrAxisSpecifier() throws RecognitionException {
        abbrAxisSpecifier_return retval = new abbrAxisSpecifier_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token AT11=null;

        Object AT11_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:259:19: ( ( AT )? )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:259:21: ( AT )?
            {
            root_0 = (Object)adaptor.nil();

            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:259:21: ( AT )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==AT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:259:23: AT
                    {
                    AT11=(Token)input.LT(1);
                    match(input,AT,FOLLOW_AT_in_abbrAxisSpecifier1531); if (failed) return retval;
                    if ( backtracking==0 ) {
                    AT11_tree = (Object)adaptor.create(AT11);
                    adaptor.addChild(root_0, AT11_tree);
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end abbrAxisSpecifier

    public static class expr_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start expr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:274:0: expr returns [Expr result] : e= orExpr ;
    public final expr_return expr() throws RecognitionException {
        expr_return retval = new expr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        orExpr_return e = null;



        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:275:3: (e= orExpr )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:275:5: e= orExpr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_orExpr_in_expr1565);
            e=orExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( backtracking==0 ) {
               retval.result = e.result ; 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end expr

    public static class primaryExpr_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start primaryExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:281:0: primaryExpr returns [Expr result] : (varRef= variableReference | LPAREN exp= expr RPAREN | lit= literal | num= number | fn= functionCall );
    public final primaryExpr_return primaryExpr() throws RecognitionException {
        primaryExpr_return retval = new primaryExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN12=null;
        Token RPAREN13=null;
        variableReference_return varRef = null;

        expr_return exp = null;

        literal_return lit = null;

        number_return num = null;

        functionCall_return fn = null;


        Object LPAREN12_tree=null;
        Object RPAREN13_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:281:34: (varRef= variableReference | LPAREN exp= expr RPAREN | lit= literal | num= number | fn= functionCall )
            int alt18=5;
            switch ( input.LA(1) ) {
            case DOLLAR:
                {
                alt18=1;
                }
                break;
            case LPAREN:
                {
                alt18=2;
                }
                break;
            case LITERAL:
                {
                alt18=3;
                }
                break;
            case NUMBER:
                {
                alt18=4;
                }
                break;
            case IDENTIFIER:
                {
                alt18=5;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("281:0: primaryExpr returns [Expr result] : (varRef= variableReference | LPAREN exp= expr RPAREN | lit= literal | num= number | fn= functionCall );", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:282:4: varRef= variableReference
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_variableReference_in_primaryExpr1594);
                    varRef=variableReference();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, varRef.getTree());
                    if ( backtracking==0 ) {
                       retval.result = varRef.result ; 
                    }

                    }
                    break;
                case 2 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:283:5: LPAREN exp= expr RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN12=(Token)input.LT(1);
                    match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpr1611); if (failed) return retval;
                    pushFollow(FOLLOW_expr_in_primaryExpr1616);
                    exp=expr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, exp.getTree());
                    RPAREN13=(Token)input.LT(1);
                    match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpr1618); if (failed) return retval;
                    if ( backtracking==0 ) {
                       retval.result = exp.result; retval.result.setWrapParen(true);  
                    }

                    }
                    break;
                case 3 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:284:5: lit= literal
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_literal_in_primaryExpr1638);
                    lit=literal();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, lit.getTree());
                    if ( backtracking==0 ) {
                       retval.result = lit.result ;
                    }

                    }
                    break;
                case 4 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:285:5: num= number
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_number_in_primaryExpr1670);
                    num=number();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, num.getTree());
                    if ( backtracking==0 ) {
                       retval.result = num.result ; 
                    }

                    }
                    break;
                case 5 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:286:5: fn= functionCall
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionCall_in_primaryExpr1703);
                    fn=functionCall();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, fn.getTree());
                    if ( backtracking==0 ) {
                       retval.result = fn.result ; 
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end primaryExpr

    public static class literal_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start literal
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:290:0: literal returns [Expr result] : lit= LITERAL ;
    public final literal_return literal() throws RecognitionException {
        literal_return retval = new literal_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token lit=null;

        Object lit_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:291:2: (lit= LITERAL )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:291:4: lit= LITERAL
            {
            root_0 = (Object)adaptor.nil();

            lit=(Token)input.LT(1);
            match(input,LITERAL,FOLLOW_LITERAL_in_literal1741); if (failed) return retval;
            if ( backtracking==0 ) {
            lit_tree = (Object)adaptor.create(lit);
            root_0 = (Object)adaptor.becomeRoot(lit_tree, root_0);
            }
            if ( backtracking==0 ) {
               retval.result = new LiteralExpr(lit.getText()) ; 
              	    retval.result.setPosition (positionOf(lit,true),positionOf(lit,false) );
              	  
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end literal

    public static class number_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start number
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:297:0: number returns [Expr result] : num= NUMBER ;
    public final number_return number() throws RecognitionException {
        number_return retval = new number_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token num=null;

        Object num_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:298:4: (num= NUMBER )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:298:6: num= NUMBER
            {
            root_0 = (Object)adaptor.nil();

            num=(Token)input.LT(1);
            match(input,NUMBER,FOLLOW_NUMBER_in_number1767); if (failed) return retval;
            if ( backtracking==0 ) {
            num_tree = (Object)adaptor.create(num);
            root_0 = (Object)adaptor.becomeRoot(num_tree, root_0);
            }
            if ( backtracking==0 ) {
               retval.result = new NumberExpr(num.getText());
                      retval.result.setPosition(positionOf(num,true),positionOf(num,false));
                    
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end number

    public static class variableReference_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start variableReference
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:304:0: variableReference returns [Expr result] : DOLLAR var= qName ;
    public final variableReference_return variableReference() throws RecognitionException {
        variableReference_return retval = new variableReference_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DOLLAR14=null;
        qName_return var = null;


        Object DOLLAR14_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:305:3: ( DOLLAR var= qName )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:305:5: DOLLAR var= qName
            {
            root_0 = (Object)adaptor.nil();

            DOLLAR14=(Token)input.LT(1);
            match(input,DOLLAR,FOLLOW_DOLLAR_in_variableReference1798); if (failed) return retval;
            if ( backtracking==0 ) {
            DOLLAR14_tree = (Object)adaptor.create(DOLLAR14);
            root_0 = (Object)adaptor.becomeRoot(DOLLAR14_tree, root_0);
            }
            pushFollow(FOLLOW_qName_in_variableReference1803);
            var=qName();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, var.getTree());
            if ( backtracking==0 ) {
               retval.result = new VariableReferenceExpr(var.prefix, var.localName);
              				  retval.result.setPosition( var.startOffset, var.endOffset );
              				
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end variableReference

    public static class functionCall_return extends ParserRuleReturnScope {
        public FunctionCallExpr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start functionCall
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:318:0: functionCall returns [FunctionCallExpr result ] : qn= qName LPAREN (list= argList )? RPAREN ;
    public final functionCall_return functionCall() throws RecognitionException {
        functionCall_return retval = new functionCall_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token LPAREN15=null;
        Token RPAREN16=null;
        qName_return qn = null;

        argList_return list = null;


        Object LPAREN15_tree=null;
        Object RPAREN16_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:319:5: (qn= qName LPAREN (list= argList )? RPAREN )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:319:7: qn= qName LPAREN (list= argList )? RPAREN
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_qName_in_functionCall1838);
            qn=qName();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, qn.getTree());
            if ( backtracking==0 ) {
               retval.result = new FunctionCallExpr(qn.prefix,qn.localName);
                          retval.result.setPosition (qn.startOffset,qn.endOffset); 
                        
            }
            LPAREN15=(Token)input.LT(1);
            match(input,LPAREN,FOLLOW_LPAREN_in_functionCall1863); if (failed) return retval;
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:323:18: (list= argList )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LPAREN||(LA19_0>=DOT && LA19_0<=AT)||(LA19_0>=SLASH && LA19_0<=DOLLAR)||LA19_0==MINUS||LA19_0==STAR||(LA19_0>=IDENTIFIER && LA19_0<=NUMBER)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:323:20: list= argList
                    {
                    pushFollow(FOLLOW_argList_in_functionCall1870);
                    list=argList();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, list.getTree());
                    if ( backtracking==0 ) {
                       retval.result.getParameters().addAll(list.result); 
                    }

                    }
                    break;

            }

            RPAREN16=(Token)input.LT(1);
            match(input,RPAREN,FOLLOW_RPAREN_in_functionCall1877); if (failed) return retval;

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end functionCall

    public static class argList_return extends ParserRuleReturnScope {
        public List<Expr> result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start argList
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:328:0: argList returns [ List<Expr> result ] : a= argument ( COMMA b= argument )* -> ^( Args ( argument )+ ) ;
    public final argList_return argList() throws RecognitionException {
        argList_return retval = new argList_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA17=null;
        argument_return a = null;

        argument_return b = null;


        Object COMMA17_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_argument=new RewriteRuleSubtreeStream(adaptor,"rule argument");
        
           retval.result = new ArrayList<Expr>();

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:332:3: (a= argument ( COMMA b= argument )* -> ^( Args ( argument )+ ) )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:332:5: a= argument ( COMMA b= argument )*
            {
            pushFollow(FOLLOW_argument_in_argList1914);
            a=argument();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) stream_argument.add(a.getTree());
            if ( backtracking==0 ) {
               retval.result.add(a.result); 
            }
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:333:5: ( COMMA b= argument )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==COMMA) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:333:7: COMMA b= argument
            	    {
            	    COMMA17=(Token)input.LT(1);
            	    match(input,COMMA,FOLLOW_COMMA_in_argList1925); if (failed) return retval;
            	    if ( backtracking==0 ) stream_COMMA.add(COMMA17);

            	    pushFollow(FOLLOW_argument_in_argList1929);
            	    b=argument();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) stream_argument.add(b.getTree());
            	    if ( backtracking==0 ) {
            	       retval.result.add(b.result); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            // AST REWRITE
            // elements: argument
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            if ( backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"token retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 334:8: -> ^( Args ( argument )+ )
            {
                // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:334:11: ^( Args ( argument )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(adaptor.create(Args, "Args"), root_1);

                if ( !(stream_argument.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_argument.hasNext() ) {
                    adaptor.addChild(root_1, stream_argument.next());

                }
                stream_argument.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end argList

    public static class argument_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start argument
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:338:0: argument returns [Expr result] : e= expr ;
    public final argument_return argument() throws RecognitionException {
        argument_return retval = new argument_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        expr_return e = null;



        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:339:4: (e= expr )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:339:6: e= expr
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_expr_in_argument1980);
            e=expr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( backtracking==0 ) {
               retval.result = e.result ; 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end argument

    public static class unionExpr_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unionExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:350:0: unionExpr returns [Expr result] : (a= pathExpr ) ( (op= PIPE ) b= pathExpr )* ;
    public final unionExpr_return unionExpr() throws RecognitionException {
        unionExpr_return retval = new unionExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        pathExpr_return a = null;

        pathExpr_return b = null;


        Object op_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:351:3: ( (a= pathExpr ) ( (op= PIPE ) b= pathExpr )* )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:351:5: (a= pathExpr ) ( (op= PIPE ) b= pathExpr )*
            {
            root_0 = (Object)adaptor.nil();

            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:351:5: (a= pathExpr )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:351:6: a= pathExpr
            {
            pushFollow(FOLLOW_pathExpr_in_unionExpr2015);
            a=pathExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, a.getTree());

            }

            if ( backtracking==0 ) {
               retval.result = a.result; 
            }
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:353:5: ( (op= PIPE ) b= pathExpr )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==PIPE) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:353:6: (op= PIPE ) b= pathExpr
            	    {
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:353:6: (op= PIPE )
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:353:7: op= PIPE
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,PIPE,FOLLOW_PIPE_in_unionExpr2036); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }

            	    }

            	    pushFollow(FOLLOW_pathExpr_in_unionExpr2042);
            	    b=pathExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, b.getTree());
            	    if ( backtracking==0 ) {
            	      retval.result = new UnionExpr(op.getText(),retval.result,b.result); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end unionExpr

    public static class pathExpr_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start pathExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:360:0: pathExpr returns [Expr result] : (loc= locationPath | e= filterExpr ( ( SLASH | SLASH2 ) path= relativeLocationPath )? );
    public final pathExpr_return pathExpr() throws RecognitionException {
        pathExpr_return retval = new pathExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SLASH18=null;
        Token SLASH219=null;
        locationPath_return loc = null;

        filterExpr_return e = null;

        relativeLocationPath_return path = null;


        Object SLASH18_tree=null;
        Object SLASH219_tree=null;

        
            Step ans = null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:363:2: (loc= locationPath | e= filterExpr ( ( SLASH | SLASH2 ) path= relativeLocationPath )? )
            int alt24=2;
            switch ( input.LA(1) ) {
            case DOT:
            case DOT2:
            case AT:
            case SLASH:
            case SLASH2:
            case STAR:
                {
                alt24=1;
                }
                break;
            case IDENTIFIER:
                {
                switch ( input.LA(2) ) {
                case COLON:
                    {
                    int LA24_12 = input.LA(3);

                    if ( (LA24_12==IDENTIFIER) ) {
                        int LA24_36 = input.LA(4);

                        if ( (LA24_36==LPAREN) ) {
                            alt24=2;
                        }
                        else if ( (LA24_36==EOF||(LA24_36>=OR && LA24_36<=DIV)||(LA24_36>=RPAREN && LA24_36<=PIPE)||LA24_36==COMMA||(LA24_36>=SLASH && LA24_36<=SLASH2)||(LA24_36>=PLUS && LA24_36<=STAR)) ) {
                            alt24=1;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("360:0: pathExpr returns [Expr result] : (loc= locationPath | e= filterExpr ( ( SLASH | SLASH2 ) path= relativeLocationPath )? );", 24, 36, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA24_12==STAR) ) {
                        alt24=1;
                    }
                    else {
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("360:0: pathExpr returns [Expr result] : (loc= locationPath | e= filterExpr ( ( SLASH | SLASH2 ) path= relativeLocationPath )? );", 24, 12, input);

                        throw nvae;
                    }
                    }
                    break;
                case LPAREN:
                    {
                    switch ( input.LA(3) ) {
                    case RPAREN:
                        {
                        int LA24_38 = input.LA(4);

                        if ( (( isCommentNodeName(input.LT(1).getText()) || isNodeNodeName(input.LT(1).getText())  || isTextNodeName(input.LT(1).getText())  ||	isProcessingInstructionNodeName( input.LT(1).getText() ) )) ) {
                            alt24=1;
                        }
                        else if ( (true) ) {
                            alt24=2;
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("360:0: pathExpr returns [Expr result] : (loc= locationPath | e= filterExpr ( ( SLASH | SLASH2 ) path= relativeLocationPath )? );", 24, 38, input);

                            throw nvae;
                        }
                        }
                        break;
                    case IDENTIFIER:
                        {
                        int LA24_39 = input.LA(4);

                        if ( ((LA24_39>=OR && LA24_39<=LPAREN)||LA24_39==LBRACKET||LA24_39==PIPE||(LA24_39>=COMMA && LA24_39<=SLASH2)||(LA24_39>=PLUS && LA24_39<=STAR)) ) {
                            alt24=2;
                        }
                        else if ( (LA24_39==RPAREN) ) {
                            int LA24_97 = input.LA(5);

                            if ( (	isProcessingInstructionNodeName( input.LT(1).getText() ) ) ) {
                                alt24=1;
                            }
                            else if ( (true) ) {
                                alt24=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("360:0: pathExpr returns [Expr result] : (loc= locationPath | e= filterExpr ( ( SLASH | SLASH2 ) path= relativeLocationPath )? );", 24, 97, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (backtracking>0) {failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("360:0: pathExpr returns [Expr result] : (loc= locationPath | e= filterExpr ( ( SLASH | SLASH2 ) path= relativeLocationPath )? );", 24, 39, input);

                            throw nvae;
                        }
                        }
                        break;
                    case LPAREN:
                    case DOT:
                    case DOT2:
                    case AT:
                    case SLASH:
                    case SLASH2:
                    case DOLLAR:
                    case MINUS:
                    case STAR:
                    case LITERAL:
                    case NUMBER:
                        {
                        alt24=2;
                        }
                        break;
                    default:
                        if (backtracking>0) {failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("360:0: pathExpr returns [Expr result] : (loc= locationPath | e= filterExpr ( ( SLASH | SLASH2 ) path= relativeLocationPath )? );", 24, 13, input);

                        throw nvae;
                    }

                    }
                    break;
                case EOF:
                case OR:
                case AND:
                case MOD:
                case DIV:
                case RPAREN:
                case LBRACKET:
                case RBRACKET:
                case PIPE:
                case COMMA:
                case COLON2:
                case SLASH:
                case SLASH2:
                case PLUS:
                case MINUS:
                case EQ:
                case NE:
                case LT:
                case LTE:
                case GT:
                case GTE:
                case STAR:
                    {
                    alt24=1;
                    }
                    break;
                default:
                    if (backtracking>0) {failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("360:0: pathExpr returns [Expr result] : (loc= locationPath | e= filterExpr ( ( SLASH | SLASH2 ) path= relativeLocationPath )? );", 24, 3, input);

                    throw nvae;
                }

                }
                break;
            case LPAREN:
            case DOLLAR:
            case LITERAL:
            case NUMBER:
                {
                alt24=2;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("360:0: pathExpr returns [Expr result] : (loc= locationPath | e= filterExpr ( ( SLASH | SLASH2 ) path= relativeLocationPath )? );", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:364:3: loc= locationPath
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_locationPath_in_pathExpr2092);
                    loc=locationPath();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, loc.getTree());
                    if ( backtracking==0 ) {
                       retval.result = loc.result; 
                    }

                    }
                    break;
                case 2 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:366:5: e= filterExpr ( ( SLASH | SLASH2 ) path= relativeLocationPath )?
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_filterExpr_in_pathExpr2109);
                    e=filterExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, e.getTree());
                    if ( backtracking==0 ) {
                       retval.result = e.result; 
                    }
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:367:8: ( ( SLASH | SLASH2 ) path= relativeLocationPath )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( ((LA23_0>=SLASH && LA23_0<=SLASH2)) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:367:10: ( SLASH | SLASH2 ) path= relativeLocationPath
                            {
                            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:367:10: ( SLASH | SLASH2 )
                            int alt22=2;
                            int LA22_0 = input.LA(1);

                            if ( (LA22_0==SLASH) ) {
                                alt22=1;
                            }
                            else if ( (LA22_0==SLASH2) ) {
                                alt22=2;
                            }
                            else {
                                if (backtracking>0) {failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("367:10: ( SLASH | SLASH2 )", 22, 0, input);

                                throw nvae;
                            }
                            switch (alt22) {
                                case 1 :
                                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:367:11: SLASH
                                    {
                                    SLASH18=(Token)input.LT(1);
                                    match(input,SLASH,FOLLOW_SLASH_in_pathExpr2124); if (failed) return retval;
                                    if ( backtracking==0 ) {
                                    SLASH18_tree = (Object)adaptor.create(SLASH18);
                                    adaptor.addChild(root_0, SLASH18_tree);
                                    }

                                    }
                                    break;
                                case 2 :
                                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:367:17: SLASH2
                                    {
                                    SLASH219=(Token)input.LT(1);
                                    match(input,SLASH2,FOLLOW_SLASH2_in_pathExpr2126); if (failed) return retval;
                                    if ( backtracking==0 ) {
                                    SLASH219_tree = (Object)adaptor.create(SLASH219);
                                    adaptor.addChild(root_0, SLASH219_tree);
                                    }
                                    if ( backtracking==0 ) {
                                       ans=new AllNodeStep(Axis.DESCENDANT_OR_SELF);
                                    }

                                    }
                                    break;

                            }

                            pushFollow(FOLLOW_relativeLocationPath_in_pathExpr2133);
                            path=relativeLocationPath();
                            _fsp--;
                            if (failed) return retval;
                            if ( backtracking==0 ) adaptor.addChild(root_0, path.getTree());
                            if ( backtracking==0 ) {
                               
                              		         retval.result = new PathExpr(e.result,path.result); 
                              		         if (ans != null) { path.result.addFirstStep(ans); } 
                              		     
                            }

                            }
                            break;

                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end pathExpr

    public static class filterExpr_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start filterExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:375:0: filterExpr returns [Expr result] : e= primaryExpr (p= predicate )* ;
    public final filterExpr_return filterExpr() throws RecognitionException {
        filterExpr_return retval = new filterExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        primaryExpr_return e = null;

        predicate_return p = null;



        
        	FilterExpr filter = null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:379:3: (e= primaryExpr (p= predicate )* )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:379:5: e= primaryExpr (p= predicate )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_primaryExpr_in_filterExpr2172);
            e=primaryExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            if ( backtracking==0 ) {
               filter = new FilterExpr(e.result) ; 
            }
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:380:9: (p= predicate )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==LBRACKET) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:380:11: p= predicate
            	    {
            	    pushFollow(FOLLOW_predicate_in_filterExpr2189);
            	    p=predicate();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, p.getTree());
            	    if ( backtracking==0 ) {
            	      filter.addPredicate(p.result); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            if ( backtracking==0 ) {
               retval.result = filter.hasPredicates() ? filter : filter.getExpr(); 
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end filterExpr

    public static class orExpr_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start orExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:393:0: orExpr returns [Expr result] : (a= andExpr ) ( (op= OR ) b= andExpr )* ;
    public final orExpr_return orExpr() throws RecognitionException {
        orExpr_return retval = new orExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        andExpr_return a = null;

        andExpr_return b = null;


        Object op_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:394:3: ( (a= andExpr ) ( (op= OR ) b= andExpr )* )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:394:5: (a= andExpr ) ( (op= OR ) b= andExpr )*
            {
            root_0 = (Object)adaptor.nil();

            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:394:5: (a= andExpr )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:394:6: a= andExpr
            {
            pushFollow(FOLLOW_andExpr_in_orExpr2234);
            a=andExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, a.getTree());

            }

            if ( backtracking==0 ) {
               retval.result = a.result; 
            }
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:396:9: ( (op= OR ) b= andExpr )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==OR) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:396:10: (op= OR ) b= andExpr
            	    {
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:396:10: (op= OR )
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:396:11: op= OR
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,OR,FOLLOW_OR_in_orExpr2266); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }

            	    }

            	    pushFollow(FOLLOW_andExpr_in_orExpr2272);
            	    b=andExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, b.getTree());
            	    if ( backtracking==0 ) {
            	       retval.result = new LogicalExpr(op.getText(), retval.result, b.result); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end orExpr

    public static class andExpr_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start andExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:404:0: andExpr returns [Expr result] : (a= equalityExpr ) ( (op= AND ) b= equalityExpr )* ;
    public final andExpr_return andExpr() throws RecognitionException {
        andExpr_return retval = new andExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        equalityExpr_return a = null;

        equalityExpr_return b = null;


        Object op_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:405:3: ( (a= equalityExpr ) ( (op= AND ) b= equalityExpr )* )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:405:6: (a= equalityExpr ) ( (op= AND ) b= equalityExpr )*
            {
            root_0 = (Object)adaptor.nil();

            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:405:6: (a= equalityExpr )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:405:7: a= equalityExpr
            {
            pushFollow(FOLLOW_equalityExpr_in_andExpr2332);
            a=equalityExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, a.getTree());

            }

            if ( backtracking==0 ) {
               retval.result = a.result; 
            }
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:407:12: ( (op= AND ) b= equalityExpr )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==AND) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:407:13: (op= AND ) b= equalityExpr
            	    {
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:407:13: (op= AND )
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:407:14: op= AND
            	    {
            	    op=(Token)input.LT(1);
            	    match(input,AND,FOLLOW_AND_in_andExpr2377); if (failed) return retval;
            	    if ( backtracking==0 ) {
            	    op_tree = (Object)adaptor.create(op);
            	    root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	    }

            	    }

            	    pushFollow(FOLLOW_equalityExpr_in_andExpr2383);
            	    b=equalityExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, b.getTree());
            	    if ( backtracking==0 ) {
            	       retval.result = new LogicalExpr(op.getText(),retval.result,b.result); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end andExpr

    public static class equalityExpr_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start equalityExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:414:0: equalityExpr returns [Expr result] : (a= relationalExpr ) ( (op= EQ | op= NE ) b= relationalExpr )* ;
    public final equalityExpr_return equalityExpr() throws RecognitionException {
        equalityExpr_return retval = new equalityExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        relationalExpr_return a = null;

        relationalExpr_return b = null;


        Object op_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:415:3: ( (a= relationalExpr ) ( (op= EQ | op= NE ) b= relationalExpr )* )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:415:5: (a= relationalExpr ) ( (op= EQ | op= NE ) b= relationalExpr )*
            {
            root_0 = (Object)adaptor.nil();

            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:415:5: (a= relationalExpr )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:415:6: a= relationalExpr
            {
            pushFollow(FOLLOW_relationalExpr_in_equalityExpr2452);
            a=relationalExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, a.getTree());

            }

            if ( backtracking==0 ) {
               retval.result = a.result; 
            }
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:417:12: ( (op= EQ | op= NE ) b= relationalExpr )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=EQ && LA29_0<=NE)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:417:13: (op= EQ | op= NE ) b= relationalExpr
            	    {
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:417:13: (op= EQ | op= NE )
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==EQ) ) {
            	        alt28=1;
            	    }
            	    else if ( (LA28_0==NE) ) {
            	        alt28=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("417:13: (op= EQ | op= NE )", 28, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:417:14: op= EQ
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,EQ,FOLLOW_EQ_in_equalityExpr2484); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:417:21: op= NE
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,NE,FOLLOW_NE_in_equalityExpr2489); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationalExpr_in_equalityExpr2495);
            	    b=relationalExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, b.getTree());
            	    if ( backtracking==0 ) {
            	       retval.result = new EqualityExpr(op.getText(), retval.result, b.result ); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end equalityExpr

    public static class relationalExpr_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start relationalExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:424:0: relationalExpr returns [Expr result] : (a= additiveExpr ) ( (op= LT | op= GT | op= LTE | op= GTE ) b= additiveExpr )* ;
    public final relationalExpr_return relationalExpr() throws RecognitionException {
        relationalExpr_return retval = new relationalExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        additiveExpr_return a = null;

        additiveExpr_return b = null;


        Object op_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:425:3: ( (a= additiveExpr ) ( (op= LT | op= GT | op= LTE | op= GTE ) b= additiveExpr )* )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:425:5: (a= additiveExpr ) ( (op= LT | op= GT | op= LTE | op= GTE ) b= additiveExpr )*
            {
            root_0 = (Object)adaptor.nil();

            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:425:5: (a= additiveExpr )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:425:6: a= additiveExpr
            {
            pushFollow(FOLLOW_additiveExpr_in_relationalExpr2565);
            a=additiveExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, a.getTree());

            }

            if ( backtracking==0 ) {
               retval.result = a.result; 
            }
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:427:13: ( (op= LT | op= GT | op= LTE | op= GTE ) b= additiveExpr )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=LT && LA31_0<=GTE)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:427:14: (op= LT | op= GT | op= LTE | op= GTE ) b= additiveExpr
            	    {
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:427:14: (op= LT | op= GT | op= LTE | op= GTE )
            	    int alt30=4;
            	    switch ( input.LA(1) ) {
            	    case LT:
            	        {
            	        alt30=1;
            	        }
            	        break;
            	    case GT:
            	        {
            	        alt30=2;
            	        }
            	        break;
            	    case LTE:
            	        {
            	        alt30=3;
            	        }
            	        break;
            	    case GTE:
            	        {
            	        alt30=4;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("427:14: (op= LT | op= GT | op= LTE | op= GTE )", 30, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt30) {
            	        case 1 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:427:15: op= LT
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,LT,FOLLOW_LT_in_relationalExpr2595); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:427:22: op= GT
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,GT,FOLLOW_GT_in_relationalExpr2600); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:427:29: op= LTE
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,LTE,FOLLOW_LTE_in_relationalExpr2605); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:427:37: op= GTE
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,GTE,FOLLOW_GTE_in_relationalExpr2610); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_additiveExpr_in_relationalExpr2616);
            	    b=additiveExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, b.getTree());
            	    if ( backtracking==0 ) {
            	       retval.result = new RelationalExpr(op.getText(), retval.result, b.result); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end relationalExpr

    public static class additiveExpr_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start additiveExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:440:0: additiveExpr returns [Expr result] : (a= multExpr ) ( (op= PLUS | op= MINUS ) b= multExpr )* ;
    public final additiveExpr_return additiveExpr() throws RecognitionException {
        additiveExpr_return retval = new additiveExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        multExpr_return a = null;

        multExpr_return b = null;


        Object op_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:441:2: ( (a= multExpr ) ( (op= PLUS | op= MINUS ) b= multExpr )* )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:441:5: (a= multExpr ) ( (op= PLUS | op= MINUS ) b= multExpr )*
            {
            root_0 = (Object)adaptor.nil();

            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:441:5: (a= multExpr )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:441:6: a= multExpr
            {
            pushFollow(FOLLOW_multExpr_in_additiveExpr2677);
            a=multExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, a.getTree());

            }

            if ( backtracking==0 ) {
               retval.result = a.result; 
            }
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:443:12: ( (op= PLUS | op= MINUS ) b= multExpr )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=PLUS && LA33_0<=MINUS)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:443:13: (op= PLUS | op= MINUS ) b= multExpr
            	    {
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:443:13: (op= PLUS | op= MINUS )
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==PLUS) ) {
            	        alt32=1;
            	    }
            	    else if ( (LA32_0==MINUS) ) {
            	        alt32=2;
            	    }
            	    else {
            	        if (backtracking>0) {failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("443:13: (op= PLUS | op= MINUS )", 32, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:443:14: op= PLUS
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,PLUS,FOLLOW_PLUS_in_additiveExpr2709); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:443:23: op= MINUS
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,MINUS,FOLLOW_MINUS_in_additiveExpr2714); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multExpr_in_additiveExpr2720);
            	    b=multExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, b.getTree());
            	    if ( backtracking==0 ) {
            	       retval.result = new AdditiveExpr(op.getText(),retval.result, b.result); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end additiveExpr

    public static class multExpr_return extends ParserRuleReturnScope {
        public Expr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start multExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:450:0: multExpr returns [Expr result] : (a= unaryExpr ) ( (op= STAR | op= DIV | op= MOD ) b= unaryExpr )* ;
    public final multExpr_return multExpr() throws RecognitionException {
        multExpr_return retval = new multExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        unaryExpr_return a = null;

        unaryExpr_return b = null;


        Object op_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:451:3: ( (a= unaryExpr ) ( (op= STAR | op= DIV | op= MOD ) b= unaryExpr )* )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:451:5: (a= unaryExpr ) ( (op= STAR | op= DIV | op= MOD ) b= unaryExpr )*
            {
            root_0 = (Object)adaptor.nil();

            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:451:5: (a= unaryExpr )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:451:6: a= unaryExpr
            {
            pushFollow(FOLLOW_unaryExpr_in_multExpr2799);
            a=unaryExpr();
            _fsp--;
            if (failed) return retval;
            if ( backtracking==0 ) adaptor.addChild(root_0, a.getTree());

            }

            if ( backtracking==0 ) {
               retval.result = a.result; 
            }
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:453:10: ( (op= STAR | op= DIV | op= MOD ) b= unaryExpr )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=MOD && LA35_0<=DIV)||LA35_0==STAR) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:453:11: (op= STAR | op= DIV | op= MOD ) b= unaryExpr
            	    {
            	    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:453:11: (op= STAR | op= DIV | op= MOD )
            	    int alt34=3;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt34=1;
            	        }
            	        break;
            	    case DIV:
            	        {
            	        alt34=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt34=3;
            	        }
            	        break;
            	    default:
            	        if (backtracking>0) {failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("453:11: (op= STAR | op= DIV | op= MOD )", 34, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt34) {
            	        case 1 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:453:12: op= STAR
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,STAR,FOLLOW_STAR_in_multExpr2827); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:453:21: op= DIV
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,DIV,FOLLOW_DIV_in_multExpr2832); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:453:29: op= MOD
            	            {
            	            op=(Token)input.LT(1);
            	            match(input,MOD,FOLLOW_MOD_in_multExpr2837); if (failed) return retval;
            	            if ( backtracking==0 ) {
            	            op_tree = (Object)adaptor.create(op);
            	            root_0 = (Object)adaptor.becomeRoot(op_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpr_in_multExpr2843);
            	    b=unaryExpr();
            	    _fsp--;
            	    if (failed) return retval;
            	    if ( backtracking==0 ) adaptor.addChild(root_0, b.getTree());
            	    if ( backtracking==0 ) {
            	       retval.result = new MultiplicativeExpr(op.getText(), retval.result, b.result); 
            	    }

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end multExpr

    public static class unaryExpr_return extends ParserRuleReturnScope {
        public UnaryExpr result;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start unaryExpr
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:460:0: unaryExpr returns [UnaryExpr result] : (u= unionExpr | op= MINUS n= unaryExpr );
    public final unaryExpr_return unaryExpr() throws RecognitionException {
        unaryExpr_return retval = new unaryExpr_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token op=null;
        unionExpr_return u = null;

        unaryExpr_return n = null;


        Object op_tree=null;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:461:3: (u= unionExpr | op= MINUS n= unaryExpr )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==LPAREN||(LA36_0>=DOT && LA36_0<=AT)||(LA36_0>=SLASH && LA36_0<=DOLLAR)||LA36_0==STAR||(LA36_0>=IDENTIFIER && LA36_0<=NUMBER)) ) {
                alt36=1;
            }
            else if ( (LA36_0==MINUS) ) {
                alt36=2;
            }
            else {
                if (backtracking>0) {failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("460:0: unaryExpr returns [UnaryExpr result] : (u= unionExpr | op= MINUS n= unaryExpr );", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:461:5: u= unionExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_unionExpr_in_unaryExpr2907);
                    u=unionExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, u.getTree());
                    if ( backtracking==0 ) {
                       retval.result = new UnaryExpr(u.result); 
                    }

                    }
                    break;
                case 2 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:464:5: op= MINUS n= unaryExpr
                    {
                    root_0 = (Object)adaptor.nil();

                    op=(Token)input.LT(1);
                    match(input,MINUS,FOLLOW_MINUS_in_unaryExpr2929); if (failed) return retval;
                    if ( backtracking==0 ) {
                    op_tree = (Object)adaptor.create(op);
                    adaptor.addChild(root_0, op_tree);
                    }
                    pushFollow(FOLLOW_unaryExpr_in_unaryExpr2933);
                    n=unaryExpr();
                    _fsp--;
                    if (failed) return retval;
                    if ( backtracking==0 ) adaptor.addChild(root_0, n.getTree());
                    if ( backtracking==0 ) {
                       
                      		     retval.result = n.result;
                      		     retval.result.setOperand(op.getText());
                      		     retval.result.setPosition(positionOf(op,true),-1);
                      		   
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end unaryExpr

    public static class qName_return extends ParserRuleReturnScope {
        public String prefix;
        public String localName;
        public int startOffset;
        public int endOffset;
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start qName
    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:476:0: qName returns [String prefix, String localName , int startOffset, int endOffset ] : (p= IDENTIFIER COLON )? n= IDENTIFIER ;
    public final qName_return qName() throws RecognitionException {
        qName_return retval = new qName_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token p=null;
        Token n=null;
        Token COLON20=null;

        Object p_tree=null;
        Object n_tree=null;
        Object COLON20_tree=null;

       	retval.prefix = "";
       	retval.startOffset = -1;

        try {
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:481:3: ( (p= IDENTIFIER COLON )? n= IDENTIFIER )
            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:482:6: (p= IDENTIFIER COLON )? n= IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:482:6: (p= IDENTIFIER COLON )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==IDENTIFIER) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==COLON) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:482:7: p= IDENTIFIER COLON
                    {
                    p=(Token)input.LT(1);
                    match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qName2972); if (failed) return retval;
                    if ( backtracking==0 ) {
                    p_tree = (Object)adaptor.create(p);
                    adaptor.addChild(root_0, p_tree);
                    }
                    COLON20=(Token)input.LT(1);
                    match(input,COLON,FOLLOW_COLON_in_qName2974); if (failed) return retval;
                    if ( backtracking==0 ) {
	                    COLON20_tree = (Object)adaptor.create(COLON20);
	                    root_0 = (Object)adaptor.becomeRoot(COLON20_tree, root_0);
                    }
                    if ( backtracking==0 ) {
                       retval.prefix =p.getText() ; retval.startOffset = positionOf(p,true); 
                    }

                    }
                    break;

            }

            n=(Token)input.LT(1);
            match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_qName2992); if (failed) return retval;
            if ( backtracking==0 ) {
            n_tree = (Object)adaptor.create(n);
            adaptor.addChild(root_0, n_tree);
            }
            if ( backtracking==0 ) {
               retval.localName =n.getText();
              	         if (retval.startOffset < 0) {
              	             retval.startOffset = positionOf(n,true);
              	         }
              	         retval.endOffset = positionOf(n,false); 
                       
            }

            }

            retval.stop = input.LT(-1);

            if ( backtracking==0 ) {
                retval.tree = (Object)adaptor.rulePostProcessing(root_0);
                adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end qName

    // $ANTLR start synpred1
    public final void synpred1_fragment() throws RecognitionException {   
        // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:129:9: ( AT | STAR | IDENTIFIER )
        // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:
        {
        if ( input.LA(1)==AT||input.LA(1)==STAR||input.LA(1)==IDENTIFIER ) {
            input.consume();
            errorRecovery=false;failed=false;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            MismatchedSetException mse =
                new MismatchedSetException(null,input);
            recoverFromMismatchedSet(input,mse,FOLLOW_set_in_synpred1842);    throw mse;
        }


        }
    }
    // $ANTLR end synpred1

    // $ANTLR start synpred2
    public final void synpred2_fragment() throws RecognitionException {   
        // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:164:6: ( IDENTIFIER COLON2 | AT )
        int alt38=2;
        int LA38_0 = input.LA(1);

        if ( (LA38_0==IDENTIFIER) ) {
            alt38=1;
        }
        else if ( (LA38_0==AT) ) {
            alt38=2;
        }
        else {
            if (backtracking>0) {failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("164:6: synpred2 : ( IDENTIFIER COLON2 | AT );", 38, 0, input);

            throw nvae;
        }
        switch (alt38) {
            case 1 :
                // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:164:7: IDENTIFIER COLON2
                {
                match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred21003); if (failed) return ;
                match(input,COLON2,FOLLOW_COLON2_in_synpred21005); if (failed) return ;

                }
                break;
            case 2 :
                // /org.eclipse.bpel.xpath10/src/org/eclipse/bpel/xpath10/parser/XPath10.g:164:27: AT
                {
                match(input,AT,FOLLOW_AT_in_synpred21009); if (failed) return ;

                }
                break;

        }}
    // $ANTLR end synpred2

    public final boolean synpred1() {
        backtracking++;
        int start = input.mark();
        try {
            synpred1_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }
    public final boolean synpred2() {
        backtracking++;
        int start = input.mark();
        try {
            synpred2_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !failed;
        input.rewind(start);
        backtracking--;
        failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_unionExpr_in_xpath742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_absoluteLocationPath_in_locationPath769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relativeLocationPath_in_locationPath781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SLASH2_in_absoluteLocationPath811 = new BitSet(new long[]{0x000000014000E002L});
    public static final BitSet FOLLOW_SLASH_in_absoluteLocationPath820 = new BitSet(new long[]{0x000000014000E002L});
    public static final BitSet FOLLOW_i_relativeLocationPath_in_absoluteLocationPath853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_i_relativeLocationPath_in_relativeLocationPath898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_step_in_i_relativeLocationPath926 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_SLASH2_in_i_relativeLocationPath941 = new BitSet(new long[]{0x000000014000E000L});
    public static final BitSet FOLLOW_SLASH_in_i_relativeLocationPath946 = new BitSet(new long[]{0x000000014000E000L});
    public static final BitSet FOLLOW_step_in_i_relativeLocationPath952 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_axis_in_step1015 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_step1042 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COLON_in_step1044 = new BitSet(new long[]{0x0000000140000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_step1056 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_STAR_in_step1060 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_specialStep_in_step1081 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_predicate_in_step1099 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_abbrStep_in_step1121 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_predicate_in_step1130 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_IDENTIFIER_in_specialStep1167 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_specialStep1170 = new BitSet(new long[]{0x0000000100000200L});
    public static final BitSet FOLLOW_IDENTIFIER_in_specialStep1177 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RPAREN_in_specialStep1186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_specialStep1215 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_specialStep1218 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RPAREN_in_specialStep1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_specialStep1262 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_specialStep1265 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RPAREN_in_specialStep1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_specialStep1302 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_specialStep1305 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RPAREN_in_specialStep1310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_axis1366 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON2_in_axis1368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_axis1388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBRACKET_in_predicate1430 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_predicateExpr_in_predicate1435 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_RBRACKET_in_predicate1437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expr_in_predicateExpr1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_abbrStep1500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT2_in_abbrStep1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_abbrAxisSpecifier1531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_orExpr_in_expr1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_variableReference_in_primaryExpr1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpr1611 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_expr_in_primaryExpr1616 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpr1618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_literal_in_primaryExpr1638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_in_primaryExpr1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_primaryExpr1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LITERAL_in_literal1741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NUMBER_in_number1767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOLLAR_in_variableReference1798 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_qName_in_variableReference1803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qName_in_functionCall1838 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_LPAREN_in_functionCall1863 = new BitSet(new long[]{0x0000000740B8E300L});
    public static final BitSet FOLLOW_argList_in_functionCall1870 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_RPAREN_in_functionCall1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argument_in_argList1914 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_COMMA_in_argList1925 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_argument_in_argList1929 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_expr_in_argument1980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pathExpr_in_unionExpr2015 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_PIPE_in_unionExpr2036 = new BitSet(new long[]{0x000000074038E100L});
    public static final BitSet FOLLOW_pathExpr_in_unionExpr2042 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_locationPath_in_pathExpr2092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_filterExpr_in_pathExpr2109 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_SLASH_in_pathExpr2124 = new BitSet(new long[]{0x000000014000E000L});
    public static final BitSet FOLLOW_SLASH2_in_pathExpr2126 = new BitSet(new long[]{0x000000014000E000L});
    public static final BitSet FOLLOW_relativeLocationPath_in_pathExpr2133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpr_in_filterExpr2172 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_predicate_in_filterExpr2189 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_andExpr_in_orExpr2234 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_OR_in_orExpr2266 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_andExpr_in_orExpr2272 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr2332 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_AND_in_andExpr2377 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_equalityExpr_in_andExpr2383 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr2452 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_EQ_in_equalityExpr2484 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_NE_in_equalityExpr2489 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_relationalExpr_in_equalityExpr2495 = new BitSet(new long[]{0x0000000003000002L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr2565 = new BitSet(new long[]{0x000000003C000002L});
    public static final BitSet FOLLOW_LT_in_relationalExpr2595 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_GT_in_relationalExpr2600 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_LTE_in_relationalExpr2605 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_GTE_in_relationalExpr2610 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_additiveExpr_in_relationalExpr2616 = new BitSet(new long[]{0x000000003C000002L});
    public static final BitSet FOLLOW_multExpr_in_additiveExpr2677 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_PLUS_in_additiveExpr2709 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_MINUS_in_additiveExpr2714 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_multExpr_in_additiveExpr2720 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_unaryExpr_in_multExpr2799 = new BitSet(new long[]{0x00000000400000C2L});
    public static final BitSet FOLLOW_STAR_in_multExpr2827 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_DIV_in_multExpr2832 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_MOD_in_multExpr2837 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_unaryExpr_in_multExpr2843 = new BitSet(new long[]{0x00000000400000C2L});
    public static final BitSet FOLLOW_unionExpr_in_unaryExpr2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpr2929 = new BitSet(new long[]{0x0000000740B8E100L});
    public static final BitSet FOLLOW_unaryExpr_in_unaryExpr2933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qName2972 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_COLON_in_qName2974 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_qName2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred1842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred21003 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_COLON2_in_synpred21005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_synpred21009 = new BitSet(new long[]{0x0000000000000002L});

}