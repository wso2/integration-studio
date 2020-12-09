/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.editors.xpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.bpel.ui.editors.xpath.rules.AxisRule;
import org.eclipse.bpel.ui.editors.xpath.rules.FloatRule;
import org.eclipse.bpel.ui.editors.xpath.rules.FunctionRule;
import org.eclipse.bpel.ui.editors.xpath.rules.ITokenContext;
import org.eclipse.bpel.ui.editors.xpath.rules.SingleCharRule;
import org.eclipse.bpel.ui.editors.xpath.rules.SingleOperatorRule;
import org.eclipse.bpel.ui.editors.xpath.rules.StringRule;
import org.eclipse.bpel.ui.editors.xpath.rules.WordRule;
import org.eclipse.bpel.ui.preferences.PreferenceConstants;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.BufferedRuleBasedScanner;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.swt.SWT;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 25, 2006
 */
public class XPathSourceScanner extends BufferedRuleBasedScanner {
		
	IWordDetector fNCNameDetector = new XPathWordDetector.NCNameWordDetector ();
	
	IWordDetector fWordDetector = new XPathWordDetector();
	
	IWordDetector fVariableNameDetector = new XPathWordDetector.VariableDetector();
	
	IWordDetector fQNameDetector = new XPathWordDetector.QNameDetector ();
	
	
	LinkedList<IToken> tokenWindow = new LinkedList<IToken>();
	
	/**
	 * The scanner for the XPath source editor, which provides
	 * syntax coloring based on the default damager and repairer.
	 * 
	 * @param manager
	 */
	
	@SuppressWarnings("nls")
	public XPathSourceScanner( ColorManager manager ) {

		IToken defToken = new Token ( 
					new TextAttribute (
						manager.getColor( PreferenceConstants.DEFAULT  )												
					) );
		
		final IToken operatorToken = new Token ( 
				new TextAttribute (
						manager.getColor( PreferenceConstants.OPERAND  ),
						null,
						SWT.BOLD						
				) );
		
		IToken number = new Token (
				new TextAttribute (
						manager.getColor( PreferenceConstants.NUMBER  ),
						null,
						SWT.BOLD						
				) );

					
		IToken string = new Token ( 
				new TextAttribute (  
						manager.getColor( PreferenceConstants.STRING ) ) ) ;
		
		
		IToken brackets = new Token (
				new TextAttribute (  
						manager.getColor( PreferenceConstants.BRACKET ),
						null,
						SWT.BOLD ) 						
				);


		IToken axis = new Token (
				new TextAttribute (  
						manager.getColor( PreferenceConstants.AXIS ),
						null,
						SWT.ITALIC ) 						
				);

		IToken pathSep = new Token (
					new TextAttribute (  
							manager.getColor( PreferenceConstants.PATH_SEPARATOR ),
							null,
							SWT.BOLD ) 						
					);					
		
		IToken functionsDefault = new Token (
				new TextAttribute (  
						manager.getColor( PreferenceConstants.FUNCTIONS_XPATH ),
						null,
						SWT.ITALIC ) 											
				);
		
		IToken functions = new Token (
				new TextAttribute (  
						manager.getColor( PreferenceConstants.FUNCTIONS_XPATH ),
						null,
						SWT.BOLD)
				) ;
		
		final IToken variableToken = new Token ( 
				new TextAttribute( 
						manager.getColor( PreferenceConstants.VARIABLES ),
						null,
						SWT.BOLD
				));
				
		IToken partToken = new Token ( 
				new TextAttribute( 
						manager.getColor( PreferenceConstants.VARIABLE_PART ),
						null,
						SWT.BOLD
				));
						
		
		// The list of rules for this scanner.
		List<IRule> rules = new ArrayList<IRule>(24);
		
				
		// Add rule for double quotes string
		rules.add( new SingleLineRule("\"", "\"", string , '\\') ); //$NON-NLS-1$ //$NON-NLS-2$
		// Add a rule for single quotes string
		rules.add( new SingleLineRule("'", "'", string , '\\') ); //$NON-NLS-1$ //$NON-NLS-2$
	
		// Add function calls ...
		
		// Add generic whitespace rule.
		rules.add( new WhitespaceRule(new XPathWhitespaceDetector()) );
		
		// numbers
		rules.add ( new FloatRule ( number )) ;

		WordRule wordRule;
		
		// variable rule
		wordRule = new WordRule ( fVariableNameDetector );
		wordRule.addWord ( WordRule.ANY , variableToken );
		rules.add (wordRule);
		
		// Variable part rule
		wordRule = new WordRule ( new XPathWordDetector.MessagePartDetector() );
		wordRule.addWord ( WordRule.ANY , partToken );
		wordRule.setTokenContextCheck( new TokenContext () {
			@Override
			public boolean checkSeenTokens(XPathSourceScanner scanner) {
				return (scanner.lastToken(0) == variableToken);
			}			
		});
		rules.add (wordRule);
		
		
		// Some operators.
		rules.add ( new SingleOperatorRule ( operatorToken, "+-*=|/<>" ) );
		
		// Operators of sorts ...
		rules.add ( new StringRule ( operatorToken, "!=") );
		rules.add ( new StringRule ( operatorToken, ">=") );
		rules.add ( new StringRule ( operatorToken, "<=") );
		rules.add ( new StringRule ( operatorToken, ">=") );
		
		rules.add ( new SingleCharRule ( brackets, "[]().@," ) );			
		
		rules.add ( new StringRule ( operatorToken, "//") );	
		
		rules.add ( new StringRule ( pathSep, "::") );	
		
		
		// rule for operators ...
		wordRule = new WordRule( new XPathWordDetector () );
		
		wordRule.addWord ("mod",operatorToken);
		wordRule.addWord ("div",operatorToken);
		wordRule.addWord ("and",operatorToken);
		wordRule.addWord ("or",operatorToken);
		
		wordRule.setTokenContextCheck( new TokenContext() {
			@Override
			public boolean checkSeenTokens(XPathSourceScanner scanner) {
				int idx = (scanner.lastToken(0) == Token.WHITESPACE ? 1 : 0);								
				return scanner.lastToken(idx) != operatorToken;
			}			
		});
		
		
		rules.add( wordRule );

		AxisRule axisRule = new AxisRule ( fNCNameDetector );
		axisRule.addWords(AXIS, axis);
		rules.add(axisRule);
		
				
		// The basic XPath functions
		FunctionRule functionRule = new FunctionRule ( fQNameDetector );
		functionRule.addWords(XPATH_FUNCTIONS,functionsDefault);
		rules.add(functionRule);
		
		// All other functions
		functionRule = new FunctionRule ( fQNameDetector );
		functionRule.addWord( WordRule.ANY,functions);
		rules.add(functionRule);
				
		
		wordRule = new WordRule( fWordDetector );
		wordRule.addWord ( WordRule.ANY, defToken );
		rules.add( wordRule );
		
		
		setDefaultReturnToken( defToken ) ;
		
		setRules ( rules.toArray(new IRule[]{} ));		
	}

	
	
	/**
	 * 
	 * @see org.eclipse.jface.text.rules.RuleBasedScanner#nextToken()
	 */
	
	@Override
	public IToken nextToken() {
		
		IToken next = super.nextToken();
		
		tokenWindow.addFirst(next);
		if (tokenWindow.size() > 4) {
			tokenWindow.removeLast();
		}
		
		return next;
	}


	/**
	 * Returns the last token with the index of offset. Index 0 means the last token seen,
	 * 1 means the one before the last token seen.
	 * 
	 * @param offset
	 * @return the token requested or undefined.
	 */
	
	public IToken lastToken ( int offset ) {
		try {
			return tokenWindow.get(offset);
		} catch (Throwable t) {
			return Token.UNDEFINED;
		}		
	}
	

	static private final String[] XPATH_FUNCTIONS = {
		
		"last","position","count","id","local-name","namespace-uri","name",
		"string","concat","starts-with","contains","substring-before","substring-after",
		"substring","string-length","normalize-space","translate",
		"boolean","not","true","false","lang",
		"number","sum","floor","ceiling","round"
	};
	
	
	static private final String[] AXIS = {
		"ancestor",
		"ancestor-or-self",
		"attribute",
		"child",
		"descendant",
		"descendant-or-self",
		"following",
		"following-sibling",
		"namespace",
		"parent",
		"preceding",
		"preceding-sibling",
		"self"		
	};
	
	
	/**
	 * The TokenContext class allows us to see what tokens we have seen
	 * so far. In some syntax coloring constructs we need to have a memory
	 * (albeit a simple one) of where we have been.
	 *  
	 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
	 * @date Nov 27, 2006
	 */
	
	
	abstract class TokenContext implements ITokenContext {

		/** (non-Javadoc)
		 * @see org.eclipse.bpel.ui.editors.xpath.rules.ITokenContext#check(org.eclipse.jface.text.rules.ICharacterScanner)
		 */
		public boolean check (ICharacterScanner scanner) {
			if (scanner instanceof XPathSourceScanner) {
				return checkSeenTokens ( (XPathSourceScanner) scanner); 
			}
			return false;
		}
		
		/**
		 * 
		 * @param scanner
		 * @return true if the right tokens have been seen so far, false
		 * otherwise.
		 * 
		 */
		
		public abstract boolean checkSeenTokens ( XPathSourceScanner scanner ) ;
	}
	
}
