package org.eclipse.bpel.xpath10.parser;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.Tree;
import org.eclipse.bpel.xpath10.Expr;
import org.eclipse.bpel.xpath10.parser.XPath10Lexer;
import org.eclipse.bpel.xpath10.parser.XPath10Parser;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertNotNull;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 */

@SuppressWarnings("nls")

public abstract class AbstractTC  {
	
	static protected int CMP_AST   = 1;	
	static protected int CMP_EXPR_TEXT   = 2;
	static protected int CMP_EXPR_STRING = 3;
	
    
	protected void runTest(int compare, String source, String expected) throws RecognitionException {
    	
    	p("-----------------------------------------------------------");
    	p("  Input : " + source);

    	XPath10Parser parser = createParser(source);        
    	XPath10Parser.expr_return result = parser.expr();
    	
        String astString = toStringTree(result);
        String exprString = null;
        String exprText  = null;
        Expr   expr = null;
        
        p("AST-Text: " + astString);
        p("AST-Tree: ");
        
        dumpAST( (Tree) result.getTree() , 0 );
        
        if (result.result != null) {
        	expr = result.result;
        	exprString = expr.toString();
        	exprText =   expr.getText();
        	
        	p("toString: " + exprString);
        	p(" getText: " + exprText);
        	(new SemanticTreeVistor()).visit (expr) ;
        	
        }
        
        if (compare == CMP_EXPR_TEXT) {
        	assertTrue("Expected " + expected + ", found " + exprText, expected.equals(exprText));        
        } else if (compare == CMP_EXPR_STRING) {
        	assertTrue("Expected " + expected + ", found " + exprString, expected.equals(exprString));        	
        } else {        	
            assertTrue("Expected " + expected + ", found " + astString,astString.equals(expected));           
        }
        
        if (expr != null) {
        	assertTrue("Start position is negative",  expr.getPosition() >= 0);
        	assertTrue("End   position is negative",  expr.getEndPosition() >= 0);
        }
        
    }


    protected XPath10Parser createParser(String testString) {
        XPath10Lexer lexer = createLexer(testString);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        XPath10Parser parser = new XPath10Parser(tokens);
        return parser;
    }

    private XPath10Lexer createLexer(String testString) {
        CharStream stream = new ANTLRStringStream(testString);
        XPath10Lexer lexer = new XPath10Lexer(stream);
        return lexer;
    }

    String toStringTree(ParserRuleReturnScope result) {
        assertNotNull("Result is is null",result);
        String st = ((Tree) result.getTree()).toStringTree();
        return st;
    }
    

 
    
    void dumpAST(Tree tree, int level) {
    	for(int i =level*2; i>0; i--) {
    		System.out.print(" ");
    	}    	
    	System.out.println(level+" <" + XPath10Parser.tokenNames[ tree.getType() ] + "> " + tree.getText());    	
    	for(int i=0; i < tree.getChildCount(); i++) {
    		dumpAST(tree.getChild(i),level+1);
    	}
    }
    
    static  protected void p ( String msg ) {
    	System.out.flush();
    	System.err.flush();
    	
    	System.out.println(msg);
    	System.out.flush();
    }
}
