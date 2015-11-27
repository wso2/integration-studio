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
package org.eclipse.bpel.ui.contentassist;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

import org.eclipse.bpel.model.Link;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.details.providers.LinkContentProvider;
import org.eclipse.bpel.ui.expressions.IEditorConstants;
import org.eclipse.bpel.ui.properties.BPELPropertySection;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.XSDUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContentAssistEvent;
import org.eclipse.jface.text.contentassist.ICompletionListener;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistantExtension2;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDAttributeDeclaration;
import org.eclipse.xsd.XSDComplexTypeDefinition;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDSimpleTypeDefinition;
import org.eclipse.xsd.XSDTypeDefinition;


/**
 * @author Edward Gee (edward.gee@oracle.com)
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 */

public class ExpressionContentAssistProcessor
     implements IContentAssistProcessor, ICompletionListener {

	static String EMPTY_STRING = ""; //$NON-NLS-1$
	
	static ICompletionProposal[] EMPTY_COMPLETION_PROPOSALS = {} ; 
	
	// members of class ExpressionContentAssistProcessor
	private Object theModel = null; 
	private BPELPropertySection propertySection;

	public void setPropertySection(BPELPropertySection propertySection) {
		this.propertySection = propertySection;
	}
		
	private int theToggle = 3;
	private String theLastBeginsWith = EMPTY_STRING; 
	private String theExpressionContext = EMPTY_STRING; 
	private IContentAssistantExtension2 theContentAssistant;
	
	

	/**
	 * The function templates content assist processor.
	 */
	
    FunctionTemplatesContentAssistProcessor fFunctionTemplates = new FunctionTemplatesContentAssistProcessor();
    XPathTemplateCompletionProcessor fXpathTemplates = new XPathTemplateCompletionProcessor();
    	
	// public constants
    static final String MINUS = "-"; //$NON-NLS-1$
    static final String PLUS = "+"; //$NON-NLS-1$
    static final String MULTIPLY = "*"; //$NON-NLS-1$
    static final String DIVIDE = "/"; //$NON-NLS-1$
    static final String OPEN_PAREN = "("; //$NON-NLS-1$
    static final String CLOSE_PAREN = ")"; //$NON-NLS-1$
    static final String OPEN_BRACKET = "["; //$NON-NLS-1$
    static final String CLOSE_BRACKET = "]"; //$NON-NLS-1$
    static final String COMMA = ","; //$NON-NLS-1$
    static final String DOLLAR = "$"; //$NON-NLS-1$
    static final String EQUAL = "="; //$NON-NLS-1$
    static final String NOT_EQUAL = "!="; //$NON-NLS-1$
    static final String LESS_THAN = "<"; //$NON-NLS-1$
    static final String LESS_THAN_EQUAL = "<="; //$NON-NLS-1$
    static final String GREATER_THAN = ">"; //$NON-NLS-1$
    static final String GREATER_THAN_EQUAL = ">="; //$NON-NLS-1$
    static final String MOD = "mod"; //$NON-NLS-1$
    static final String DIV = "div"; //$NON-NLS-1$
    static final String AND = "and"; //$NON-NLS-1$
    static final String OR = "or"; //$NON-NLS-1$
    static final String COLON = ":"; //$NON-NLS-1$
    static final String AT = "@"; //$NON-NLS-1$
    
	// helper class for defining proposal types
	class ProposalType {
		private int theType;
		private String theBeginsWith;
		
		// bitwise flags for different types
		static final int PROPTYPE_VARIABLE = 1;
		static final int PROPTYPE_FUNCTION = 2;
		static final int PROPTYPE_OPERATOR = 4;
		
		ProposalType(int type, String beginsWith) {
			theType = type;
			theBeginsWith = beginsWith;
		}
		
		boolean isVariable() { return ((theType & PROPTYPE_VARIABLE) == PROPTYPE_VARIABLE); }
		boolean isFunction() { return ((theType & PROPTYPE_FUNCTION) == PROPTYPE_FUNCTION); }
		boolean isOperator() { return ((theType & PROPTYPE_OPERATOR) == PROPTYPE_OPERATOR); }
		boolean isVariableAndFunction() { return ((theType & (PROPTYPE_VARIABLE | PROPTYPE_FUNCTION)) == (PROPTYPE_VARIABLE | PROPTYPE_FUNCTION)); }
	}
	
	// helper class for defining expression types within xpath expression... used by XPathStack
	class ExpressionType {
		private int theType;
		private String theGrammar;
		
		static final int EXPRTYPE_VARIABLE = 1;
		static final int EXPRTYPE_FUNCTION = 2;
		static final int EXPRTYPE_LITERAL = 3;
		static final int EXPRTYPE_NUMBER = 4;
		static final int EXPRTYPE_UNARY_OPERATOR = 5;
		static final int EXPRTYPE_NUMERIC_OPERATOR = 6;
		static final int EXPRTYPE_BOOLEAN_OPERATOR = 7;
		static final int EXPRTYPE_NEW_EXPRESSION = 8;
		static final int EXPRTYPE_FUNCTION_ARGUMENTS = 9;
		static final int EXPRTYPE_FUNCTION_ARGUMENT_SEPARATOR = 10;
		
		static final int CLASS_NUMERIC = 100;
		static final int CLASS_BOOLEAN = 101;
		static final int CLASS_EXPRESSION = 102;
		
		
		ExpressionType(int type, String grammar) {
			theType = type;
			theGrammar = grammar;
		}
	}
	
	// simple call stack used for parsing XPath expressions
	protected class XPathStack {
		
		Stack<ExpressionType> theCallStack;
		int theStatus;
		IDocument theDocument;
		int theOffset;
		int theIndex;
		int theTopOfStackExprType = -1;
		
		XPathStack(ITextViewer viewer, int offset) {
			theCallStack = new Stack<ExpressionType>();
			theStatus = 0;	// flag for stack's integrity
			theDocument = viewer.getDocument();
			theOffset = offset;
			theIndex = 0;
		}
		
		//parse numeric expression
		private boolean parseNumberExpression() throws BadLocationException {
			char currChar;
			boolean proceed = false;
			while (theIndex < theOffset) {
				currChar = theDocument.getChar(theIndex);
				
				// variable
				if (currChar == '$') {
					if ((theTopOfStackExprType == ExpressionType.EXPRTYPE_UNARY_OPERATOR) ||
							//(theTopOfStackExprType == ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR) ||
							(theTopOfStackExprType == ExpressionType.EXPRTYPE_NUMERIC_OPERATOR))
						return parseVariable();
					
					if (!parseVariable())
						return false;
				}	
				// literal
				else if ((currChar == '\'') || (currChar == '"')) {
					if ((theTopOfStackExprType == ExpressionType.EXPRTYPE_UNARY_OPERATOR) ||
							//(theTopOfStackExprType == ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR) ||
							(theTopOfStackExprType == ExpressionType.EXPRTYPE_NUMERIC_OPERATOR))
						return parseLiteral();
					
					if (!parseLiteral())
						return false;
				}
				else if (Character.isDigit(currChar) || (currChar == '.')) {
					if ((theTopOfStackExprType == ExpressionType.EXPRTYPE_UNARY_OPERATOR) ||
							//(theTopOfStackExprType == ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR) ||
							(theTopOfStackExprType == ExpressionType.EXPRTYPE_NUMERIC_OPERATOR))
						return parseNumber();
					
					if (!parseNumber())
						return false;
				}
				else if (isReservedOperatorCharacter(currChar)) { 
					if ((theTopOfStackExprType == ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR) ||
							(theTopOfStackExprType == ExpressionType.EXPRTYPE_NUMERIC_OPERATOR) ||
							(theTopOfStackExprType == ExpressionType.EXPRTYPE_UNARY_OPERATOR) ||
							(theTopOfStackExprType == -1)) {
						// check to see if it's a unary operator
						if (currChar == '-') {
							theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_UNARY_OPERATOR, MINUS));
							theTopOfStackExprType = ExpressionType.EXPRTYPE_UNARY_OPERATOR;
							theIndex++;
							if (parseNumberExpression()) {
								// pop the operand
								theCallStack.pop();
								// pop the unary operator
								theCallStack.pop();
								// push "numeric" value
								theCallStack.push(new ExpressionType(ExpressionType.CLASS_NUMERIC, EMPTY_STRING));
								theTopOfStackExprType = ExpressionType.CLASS_NUMERIC;
							}
						}
						else {
							theStatus = -1;
							return false;
						}
					}
					else {
						String tempOper = Character.toString(currChar);
						if ((theIndex+1) < theOffset) {
							if (isReservedOperatorCharacter(theDocument.getChar(theIndex+1))) {
								theIndex++;
								tempOper = tempOper + Character.toString(theDocument.getChar(theIndex));
							}
							int tempType = 0;
							if ((tempOper.compareTo(PLUS) == 0) || (tempOper.compareTo(MINUS) == 0) || 
									(tempOper.compareTo(MULTIPLY) == 0) || (tempOper.compareTo(DIVIDE) == 0))
								tempType = ExpressionType.EXPRTYPE_NUMERIC_OPERATOR;
							else
								tempType = ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR;
									
							theCallStack.push(new ExpressionType(tempType, tempOper));
							theTopOfStackExprType = tempType;
							theIndex++;
							if (tempType == ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR) {
								return parseBooleanExpression();
							}
							if (parseNumberExpression()) {
								// pop the operand
								theCallStack.pop();
								// pop the operator
								theCallStack.pop();
								// pop the first operand;
								theCallStack.pop();
								// push "numeric value"
								theCallStack.push(new ExpressionType(ExpressionType.CLASS_NUMERIC, EMPTY_STRING)); 
								theTopOfStackExprType = ExpressionType.CLASS_NUMERIC;
							}
							else {
								return false;						
							}
						}
						else {// return
							int tempType = 0;
							if ((tempOper.compareTo(PLUS) == 0) || (tempOper.compareTo(MINUS) == 0) || 
									(tempOper.compareTo(MULTIPLY) == 0) || (tempOper.compareTo(DIVIDE) == 0))
								tempType = ExpressionType.EXPRTYPE_NUMERIC_OPERATOR;
							else
								tempType = ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR;
									
							theCallStack.push(new ExpressionType(tempType, tempOper));
							theTopOfStackExprType = tempType;
							return false;
							
						}
					}
				}
				else if (Character.isWhitespace(currChar)) {
					// just ignore
				}
				else if (currChar == '(') {
					theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_NEW_EXPRESSION, Character.toString(currChar)));
					theTopOfStackExprType = ExpressionType.EXPRTYPE_NEW_EXPRESSION;
					theIndex++;
					if (parseBooleanExpression()) {
						// peek and set top of stack id
						ExpressionType tempExpr = theCallStack.peek();
						int type = tempExpr.theType;
						theCallStack.push(new ExpressionType(ExpressionType.CLASS_EXPRESSION, EMPTY_STRING)); 
						theTopOfStackExprType = ExpressionType.CLASS_EXPRESSION;
						if ((type == ExpressionType.EXPRTYPE_UNARY_OPERATOR) ||
								(theTopOfStackExprType == ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR) ||
								(theTopOfStackExprType == ExpressionType.EXPRTYPE_NUMERIC_OPERATOR))
							return true;
					}
					else
						return false;
				}
				else if (isClosingExpressionCharacter(currChar)) {
					try {
						ExpressionType tempExpr = theCallStack.pop();
						while (!((tempExpr.theType == ExpressionType.EXPRTYPE_NEW_EXPRESSION) || 
								(tempExpr.theType == ExpressionType.EXPRTYPE_FUNCTION_ARGUMENTS))) {
							tempExpr = theCallStack.pop();	
						}
						if (tempExpr != null) {
							if (tempExpr.theType == ExpressionType.EXPRTYPE_NEW_EXPRESSION) {
								switch (currChar) {
								case ')':
									if (tempExpr.theGrammar.compareTo(OPEN_PAREN) == 0) {
										return true;
									}
									theStatus = -1;
									return false;
									
								case ']':
									if (tempExpr.theGrammar.compareTo(OPEN_BRACKET) == 0) {
										return true;
									}
									theStatus = -1;
									return false;
								default:
									theStatus = -1;
									return false;
								}
							}
							else if (tempExpr.theType == ExpressionType.EXPRTYPE_FUNCTION_ARGUMENTS) {
								if (currChar == ')') {
									return true;
								}
								theStatus = -1;
								return false;
							}
							theStatus = -1;
							return false;
						}
					}
					catch (EmptyStackException e) {
						theStatus = -1;
						return false;
					}
					theStatus = -1;
					return false;
				}
				else if (currChar == ',') {
					// could be a function argument
					return true;
				}
				else {
					int type = theTopOfStackExprType;
					proceed = parseWord();
					if (proceed) {
						if ((theTopOfStackExprType == ExpressionType.EXPRTYPE_NUMERIC_OPERATOR) ||
								(theTopOfStackExprType == ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR)) {
							if ((type == ExpressionType.EXPRTYPE_NUMERIC_OPERATOR) ||
									(type == ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR) ||
									(type == ExpressionType.EXPRTYPE_UNARY_OPERATOR) ||
									(type == -1)) {
								theStatus = -1;
								return false;
								}
								
							theIndex++;
							if (theTopOfStackExprType == ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR) {
								return parseBooleanExpression();
							}
							if (parseNumberExpression()) {
								// pop the operand
								theCallStack.pop();
								// pop the operator
								theCallStack.pop();
								// pop the first operand;
								theCallStack.pop();
								// push "numeric value"
								theCallStack.push(new ExpressionType(ExpressionType.CLASS_NUMERIC, EMPTY_STRING)); 
								theTopOfStackExprType = ExpressionType.CLASS_NUMERIC;
							} else {
								return false;
							}
						}
						else {
							if ((type == ExpressionType.EXPRTYPE_UNARY_OPERATOR) ||
									(theTopOfStackExprType == ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR) ||
									(theTopOfStackExprType == ExpressionType.EXPRTYPE_NUMERIC_OPERATOR))
								return true;
						}
					}
					else
						return false;
						
				}
				theIndex++;			
			}
			return false;
		}
		
		// parse boolean expressions
		boolean parseBooleanExpression() throws BadLocationException {
			
			boolean proceed = parseNumberExpression();
			while (proceed) {
				ExpressionType tempExpr = theCallStack.peek();
				if (tempExpr.theType == ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR)
					proceed = parseNumberExpression();
				else
					return proceed;
			}
			return proceed;
		}
		
		// parse word found in numeric expression
		private boolean parseWord() throws BadLocationException {
			String word = EMPTY_STRING; 
			char nextChar;
			while (theIndex < theOffset) {
				nextChar = theDocument.getChar(theIndex);
				if (nextChar == '(') {
					if (word.length() > 0) {
						theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_FUNCTION, word));
						theTopOfStackExprType = ExpressionType.EXPRTYPE_FUNCTION;
						boolean proceed = parseFunction();
						if (proceed) {
							// pop the function name
							theCallStack.pop();
							// push the expression
							theCallStack.push(new ExpressionType(ExpressionType.CLASS_EXPRESSION, EMPTY_STRING));
							theTopOfStackExprType = ExpressionType.CLASS_EXPRESSION;
							return true;
						}
						return false;
					}
				}
				if (Character.isWhitespace(nextChar)) {
					if (word.length() > 0) {
						if ((word.compareToIgnoreCase(MOD) == 0) || 
								(word.compareToIgnoreCase(DIV) == 0)) {
							theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_NUMERIC_OPERATOR, word));
							theTopOfStackExprType = ExpressionType.EXPRTYPE_NUMERIC_OPERATOR;
							return true;
						}
						if ((word.compareToIgnoreCase(AND) == 0) ||
								(word.compareToIgnoreCase(OR) == 0)) {
							theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR, word));
							theTopOfStackExprType = ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR;
							return true;
						}
						
						//maybe it's a function name... next character should be whitespace or (
						int tempIndex = theIndex;
						while (tempIndex < theOffset) {
							if (!Character.isWhitespace(theDocument.getChar(tempIndex))) {
								if (theDocument.getChar(tempIndex) == '(') { 
									break;
								}
								theStatus = -1;
								return false;
							}
							tempIndex++;						
						}
					}
				}
				word = word + nextChar;
				theIndex++;
			}
			if (theIndex >= theOffset) {
				theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_FUNCTION, word));
				theStatus = 1;
				return false;
			}
			
			return false;
		}
		
		// parse function
		private boolean parseFunction() throws BadLocationException {			
			char nextChar;
			while (theIndex < theOffset) {
				nextChar = theDocument.getChar(theIndex);
				if (nextChar == '(')
					theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_FUNCTION_ARGUMENTS, OPEN_PAREN));
				else if (nextChar == ')') {
					try {
						ExpressionType tempExpr = theCallStack.peek();
						
						if (tempExpr != null) {
							if (tempExpr.theType == ExpressionType.EXPRTYPE_FUNCTION)
								return true;
							else if (tempExpr.theType == ExpressionType.EXPRTYPE_FUNCTION_ARGUMENTS) {
								theCallStack.pop();
								return true;
							}
							else {
								theStatus = -1;
								return false;
							}
						}
					}
					catch (EmptyStackException e) {
						theStatus = -1;
						return false;
					}
					theStatus = -1;
					return false;
				}
				else if (nextChar == ',') {
					theIndex++;
					theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_FUNCTION_ARGUMENT_SEPARATOR, COMMA));
					boolean proceed = parseBooleanExpression();
					if (!proceed)
						return false;
					
					continue;
				}
				else if (Character.isWhitespace(nextChar)) {
					//ignore
				}
				else {
					boolean proceed = parseBooleanExpression();
					if (!proceed)
						return false;
					
					continue;
				}
				
				theIndex++;
			}
			return false;
		}
		
		// parse literal values
		private boolean parseLiteral() throws BadLocationException {
			String literal = EMPTY_STRING; 
			char nextChar = theDocument.getChar(theIndex);
			// delimiter could be single or double quote
			char delimiter = nextChar;
			literal = literal + nextChar;
			theIndex++;
			while (theIndex < theOffset) {
				nextChar = theDocument.getChar(theIndex);
				if (nextChar != delimiter) {
					literal = literal + nextChar;
				}
				else {
					literal = literal + nextChar;
					theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_LITERAL, literal));
					theTopOfStackExprType = ExpressionType.EXPRTYPE_LITERAL;
					return true;
				}						
				theIndex++;
			}
			
			if (theIndex >= theOffset) {
				theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_LITERAL, literal));
				theStatus = 1;
				return false;
			}
			return false;
		}
		
		// parse number values
		private boolean parseNumber() throws BadLocationException {
			String number = EMPTY_STRING; 
			char nextChar;
			while (theIndex < theOffset) {
				nextChar = theDocument.getChar(theIndex);
				if ((Character.isDigit(nextChar) || (nextChar == '.'))) {
					number = number + nextChar;
				}
				else {
					theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_NUMBER, number));
					theTopOfStackExprType = ExpressionType.EXPRTYPE_NUMBER;
					theIndex--;
					return true;
				}
				theIndex++;
			}
			
			if (theIndex >= theOffset) {
				theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_NUMBER, number));
				return false;
			}
			return false;
		}
		
		// parse variable
		private boolean parseVariable() throws BadLocationException {
			theIndex++; // move past $ token
			String variable = DOLLAR;
			char nextChar;
			while (theIndex < theOffset) {
				nextChar = theDocument.getChar(theIndex);
				if (isLocationPathCharacter(nextChar)) {
					variable = variable + nextChar;
				}
				else if (nextChar == '[') {
					theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_VARIABLE, variable));
					theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_NEW_EXPRESSION, OPEN_BRACKET));
					theIndex++;
					boolean proceed = parseBooleanExpression();
					if (proceed) {
						nextChar = theDocument.getChar(theIndex);
						if (nextChar == ']') {
							try {
								ExpressionType tempExpr = theCallStack.pop();
								while (tempExpr.theType != ExpressionType.EXPRTYPE_NEW_EXPRESSION) {
									// continue popping until we find a new expression type
									tempExpr = theCallStack.pop();
								}
								if (tempExpr != null) {
									if (tempExpr.theGrammar.compareTo(CLOSE_BRACKET) == 0) {
										return true;
									}
								}
							}
							catch (EmptyStackException e) {
								theStatus = -1;
								return false;
							}
						}
						else {
							// in error ... maybe throw something here
							theStatus = -1;
							return false;
						}
					}
					else {
						return proceed;
					}						
				}
				else {
					theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_VARIABLE, variable));
					theTopOfStackExprType = ExpressionType.EXPRTYPE_VARIABLE;
					theIndex--;
					return true;
				}
				theIndex++;
			}
			
			if (theIndex >= theOffset) {
				theCallStack.push(new ExpressionType(ExpressionType.EXPRTYPE_VARIABLE, variable));
				theStatus = 1;
				return false;
				//return new ProposalType(ProposalType.PROPTYPE_VARIABLE, variable);
			}

			// shouldn't get here
			theStatus = -1;
			return false;
		}
		
		/**
		 * Parse XPath expression
		 * @return true of parsed OK
		 */
		
		public boolean parse() {
			try {
				parseBooleanExpression();
				return (theStatus != -1);
			}
			catch (BadLocationException e) {
				System.out.println(e.toString());			
			}
			return false;
		}
		 
		/** 
		 * Retrieve suggestion after parsing
		 * @return the suggestion.
		 */
		public ExpressionType getSuggestion() {
			try {
				return theCallStack.peek();
			}
			catch (EmptyStackException e) {
				return null;
			}
		}
		
	}
	
	
	/**
	 * @see org.eclipse.jface.text.contentassist.ICompletionListener#assistSessionStarted(org.eclipse.jface.text.contentassist.ContentAssistEvent)
	 */
	public void assistSessionStarted(ContentAssistEvent event) {
		
		IContentAssistant assistant= event.assistant;
	    if (assistant instanceof IContentAssistantExtension2) {
	        theContentAssistant= (IContentAssistantExtension2)assistant;
	    }		
	}
	
	/**
	 * @see org.eclipse.jface.text.contentassist.ICompletionListener#assistSessionEnded(org.eclipse.jface.text.contentassist.ContentAssistEvent)
	 */
	public void assistSessionEnded(ContentAssistEvent event) {
        theContentAssistant= null;
        theToggle = 3;
        theLastBeginsWith = EMPTY_STRING; 
	}
	
	/**
	 * @see org.eclipse.jface.text.contentassist.ICompletionListener#selectionChanged(org.eclipse.jface.text.contentassist.ICompletionProposal, boolean)
	 */
	public void selectionChanged(ICompletionProposal proposal, boolean smartToggle) {
		// do nothing
	}
	

	/**
	 * @param model
	 */
	public void setModelObject(Object model) {
		theModel = model;
		fFunctionTemplates.setModel(model);
	}
	
	/**
	 * @param expressionContext
	 */
	public void setExpressionContext(String expressionContext) {
		theExpressionContext = expressionContext;
	}

	
	/**
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeCompletionProposals(org.eclipse.jface.text.ITextViewer, int)
	 */
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,	int offset) {
		return generateProposals(viewer, offset);
	}

	
	/**
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#computeContextInformation(org.eclipse.jface.text.ITextViewer, int)
	 */
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {		
		return null;
	}

	/**
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getCompletionProposalAutoActivationCharacters()
	 */
	public char[] getCompletionProposalAutoActivationCharacters() {
		// for variables
		return new char[] { '$', '/', '@', '.' };
	}

	/**
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationAutoActivationCharacters()
	 */
	public char[] getContextInformationAutoActivationCharacters() {
		// do nothing for now
		return null;
	}

	/**
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getContextInformationValidator()
	 */
	public IContextInformationValidator getContextInformationValidator() {
		// do nothing for now
		return null;
	}

	/**
	 * @see org.eclipse.jface.text.contentassist.IContentAssistProcessor#getErrorMessage()
	 */
	public String getErrorMessage() {
		// do nothing for now
		return Messages.getString("ExpressionContentAssistProcessor.32"); //$NON-NLS-1$
	}
	
	/*
	 * Second iteration of determining proposal type.  Attempts to parse the xpath 
	 * expression until offset is reached or it can not ascertain what the expression
	 * means.  If parsing fails, tries to identify the word located right before
	 * the offset and provide proposal types based on that information.
	 */
	private ProposalType determineProposalType2(ITextViewer viewer, int offset) {
		XPathStack callStack = new XPathStack(viewer, offset);
		if (callStack.parse()) {
			
			ExpressionType expr = callStack.getSuggestion();
			
			if (expr != null) {		
				switch (expr.theType) {
				case ExpressionType.EXPRTYPE_VARIABLE:
					if (callStack.theStatus == 1) {
						return new ProposalType(ProposalType.PROPTYPE_VARIABLE, expr.theGrammar);
					}					
					return new ProposalType(ProposalType.PROPTYPE_OPERATOR, EMPTY_STRING);
					
				case ExpressionType.EXPRTYPE_FUNCTION:
					if (callStack.theStatus == 1) {
						return new ProposalType(ProposalType.PROPTYPE_FUNCTION, expr.theGrammar);
					}
					return new ProposalType(ProposalType.PROPTYPE_OPERATOR, EMPTY_STRING);
					
				case ExpressionType.EXPRTYPE_BOOLEAN_OPERATOR:
				case ExpressionType.EXPRTYPE_NUMERIC_OPERATOR:
				case ExpressionType.EXPRTYPE_UNARY_OPERATOR:
				case ExpressionType.EXPRTYPE_FUNCTION_ARGUMENTS:
				case ExpressionType.EXPRTYPE_FUNCTION_ARGUMENT_SEPARATOR:
				case ExpressionType.EXPRTYPE_NEW_EXPRESSION:
					return new ProposalType(ProposalType.PROPTYPE_FUNCTION | ProposalType.PROPTYPE_VARIABLE, EMPTY_STRING);
				case ExpressionType.CLASS_BOOLEAN:
				case ExpressionType.CLASS_NUMERIC:
				case ExpressionType.CLASS_EXPRESSION:
				case ExpressionType.EXPRTYPE_NUMBER:
					return new ProposalType(ProposalType.PROPTYPE_OPERATOR, EMPTY_STRING); 
				case ExpressionType.EXPRTYPE_LITERAL:
					if (callStack.theStatus == 1) {
						return (new ProposalType(0, EMPTY_STRING));
					}
					return new ProposalType(ProposalType.PROPTYPE_OPERATOR, EMPTY_STRING);
					
				default:
					return (new ProposalType(0, EMPTY_STRING)); 
				}
			}
			// try suggesting everything
			return new ProposalType(ProposalType.PROPTYPE_FUNCTION | ProposalType.PROPTYPE_VARIABLE, EMPTY_STRING);
		}
		
		// try last ditch effort
		String tempContext = startOfVariable(viewer, offset);
		if (tempContext != null) {
			return new ProposalType(ProposalType.PROPTYPE_VARIABLE, tempContext);
		}
		tempContext = startOfFunction(viewer, offset);
		if (tempContext != null) {
			return new ProposalType(ProposalType.PROPTYPE_FUNCTION, tempContext);
		}			
		return new ProposalType(ProposalType.PROPTYPE_FUNCTION | ProposalType.PROPTYPE_VARIABLE, EMPTY_STRING); 
	}
	
	/*
	 * Try best guess to generate proposals based on provided context information
	 */
	private ICompletionProposal[] generateProposals(ITextViewer viewer, int offset) {
		ProposalType propType = determineProposalType2(viewer, offset);
		// only toggle if the begins with hasn't changed
		boolean toggle = false;
		if (theLastBeginsWith.compareTo(propType.theBeginsWith) == 0)
			toggle = true;
		else
			theLastBeginsWith = propType.theBeginsWith;

		String funcStart = EMPTY_STRING; 
		String varlinkStart = EMPTY_STRING; 
		
		if (propType.isVariableAndFunction()) {
			theToggle = (theToggle+1) % 4;
			funcStart = propType.theBeginsWith;
			varlinkStart = propType.theBeginsWith;
		}
		else if (propType.isVariable()) {
			if (toggle)
				theToggle = (theToggle+1) % 4;
			else
				theToggle = 0;
			funcStart = EMPTY_STRING; 
			varlinkStart = propType.theBeginsWith;
		}
		else if (propType.isFunction()) {
			if (toggle)
				theToggle = (theToggle+1) % 4;
			else
				theToggle = 1;
			funcStart = propType.theBeginsWith;
			varlinkStart = EMPTY_STRING; 
		}
		else if (propType.isOperator()) {
			if (toggle)
				theToggle = (theToggle+1) % 4;
			else
				theToggle = 2;
			funcStart = EMPTY_STRING; 
			varlinkStart = EMPTY_STRING; 
		}
		
		switch (theToggle) {
		case 0:
			theContentAssistant.setStatusMessage(Messages.getString("ExpressionContentAssistProcessor.44")); //$NON-NLS-1$
			if (theExpressionContext.compareTo(IEditorConstants.ET_JOIN) == 0) {
				return generateLinkProposals(varlinkStart, offset);
			}
			return generateVariableProposals(varlinkStart, offset);
		case 1:
			theContentAssistant.setStatusMessage(Messages.getString("ExpressionContentAssistProcessor.45"));   //$NON-NLS-1$
			return generateFunctionProposals(viewer, funcStart, offset);
		case 2:
			theContentAssistant.setStatusMessage(Messages.getString("ExpressionContentAssistProcessor.46"));   //$NON-NLS-1$
			return generateOperatorProposals(EMPTY_STRING, offset);

		case 3:
			if (theExpressionContext.compareTo(IEditorConstants.ET_JOIN) == 0)
				theContentAssistant.setStatusMessage(Messages.getString("ExpressionContentAssistProcessor.48")); //$NON-NLS-1$
			else
				theContentAssistant.setStatusMessage(Messages.getString("ExpressionContentAssistProcessor.49")); //$NON-NLS-1$
			//return generateTemplateProposals(tempStart, offset);
			return (fXpathTemplates.computeCompletionProposals(viewer, offset));
		}

		return null;
	}
	
	/**
	 * From model, determine list of functions the user may want to choose from.
	 */
	ICompletionProposal[] generateFunctionProposals(ITextViewer viewer, String context, int offset) {	
		return fFunctionTemplates.computeCompletionProposals(viewer, offset);
	}
	
	/*
	 * Static proposal list of supported operators.  Could refine the list
	 * to group by numeric or boolean operators.
	 */
	static final String[] OPERATOR_LIST = {AND, OR, EQUAL, NOT_EQUAL, LESS_THAN, GREATER_THAN, 
			LESS_THAN_EQUAL, GREATER_THAN_EQUAL, PLUS, MINUS, MULTIPLY, DIV, MOD};

	ICompletionProposal[] generateOperatorProposals(String context, int offset) {

		Image img = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_OPERATION_16);
		
		ICompletionProposal[] proposals = new ICompletionProposal[OPERATOR_LIST.length];
		for (int i=0; i<OPERATOR_LIST.length; i++) {
			proposals[i] = new CompletionProposal(OPERATOR_LIST[i], offset, 0, OPERATOR_LIST[i].length(), img, OPERATOR_LIST[i], null, null);
		}		
		return proposals;
	}
	
	
	ICompletionProposal[] generateLinkProposals(String context, int offset) {
		
		ArrayList<ICompletionProposal> results = new ArrayList<ICompletionProposal>();
				
		Image linkImg = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_LINK_16);
		
		//for( Object next : new LinkContentProvider( LinkContentProvider.INCOMING ).getElements(theModel) ) {
		for( Object next : new LinkContentProvider(LinkContentProvider.INCOMING ).getElements(propertySection.getInput())) {
			Link link = (Link) next;
			
			String replName = DOLLAR + link.getName();
			if (replName.startsWith(context)) {
				results.add(new CompletionProposal(replName, 
						offset - context.length(), context.length(),
						replName.length(), linkImg, link.getName() , 
						null, null));	
			}			
		}
				
		if (results.size() < 1) {
			return new ICompletionProposal[] {
					new CompletionProposal(EMPTY_STRING, offset, 0,			
					0, null, Messages.getString("ExpressionContentAssistProcessor.31"), //$NON-NLS-1$
					null, null) };			
		}
		return results.toArray(EMPTY_COMPLETION_PROPOSALS);
	}
	
	// Bugzilla 320654
	String getNamespacePrefix(EObject context, String namespace)
	{
		String prefix = BPELUtils.getNamespacePrefix(context, namespace);
		while ( prefix==null )
		{
			prefix = BPELUtil.lookupOrCreateNamespacePrefix(context, namespace, null, null);
			if ( prefix == null )
				throw new IllegalArgumentException("namespace prefix is null");
		}
		return prefix;
	}
	
	/**
	 * From model, determine list of variables the user may want to choose from.
	 */
	ICompletionProposal[] generateVariableProposals(String context, int offset) {
		boolean seekChildren = false;

		String context2;
		if ((context.length() > 0) && (context.charAt(0) == '$'))
			context2 = context.substring(1);
		else
			context2 = context;
			
		int slash = context2.indexOf('/');
		int dot = context2.indexOf('.');
		int at = context2.indexOf('@');
		
		if ((slash > -1) || (dot > -1) || (at > -1))
			seekChildren = true;
		
		//Variable[] variables = BPELUtil.getVisibleVariables((EObject)theModel); 
		Variable[] variables = BPELUtil.getVisibleVariables(propertySection.getInput());
		ArrayList<ICompletionProposal> results = new ArrayList<ICompletionProposal>();
		CompletionProposal prop = null;
		String name;
		Variable currVar = null;
		XSDTypeDefinition currXsdType = null;
		Message currMsg = null;
		XSDElementDeclaration currXsdElem = null;

		Image varImg = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_VARIABLE_16);
		Image partImg = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PART_16);
		Image elementImg = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_XSD_ELEMENT_DECLARATION_16);
		Image attrImg = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_XSD_ATTRIBUTE_DECLARATION_16);
		try
		{
			if (seekChildren) {
				// walk down path
				int index = 0;
				int level = 0;
				int token = -1;
				char t = 0;
				String levelName;
	
				while (index < context2.length()) {
					t = context2.charAt(index);
					if ((t == '.') || (t == '/')) {
						levelName = context2.substring(token+1, index);
						/*
						// check for namespace
						int ns = levelName.indexOf(':');
						if (ns > -1) {
							levelNSPrefix = levelName.substring(0, ns);
							levelName = levelName.substring(ns+1);
						}
						else
							levelNSPrefix = null;
						 */
						
						// find variable
						if (level == 0) {
							for (int i=0; i<variables.length; i++) {
								if (levelName.compareTo(variables[i].getName()) == 0) {
									currVar = variables[i]; 
									currXsdType = currVar.getType();
									currMsg = currVar.getMessageType();
									currXsdElem = currVar.getXSDElement();
									
									level++;
									break;
								}
							}
							if (currVar == null)
								break;
						}
						// traverse down
						else {
							boolean childFound = false;
							if (context2.charAt(token) == '.') {
								if (currMsg != null) {								
									if (currMsg.getParts() != null) {	
										for(Object next : currMsg.getParts().values()) {
											Part item = (Part) next ;
											if (levelName.compareTo(item.getName()) == 0) {
												currXsdType = item.getTypeDefinition();
												currMsg = item.getEMessage();
												currXsdElem = item.getElementDeclaration();
												childFound = true;
												break;
											}
										}
									}
								}
								if (!childFound)
									break;
							}
							// search for child objects
							else if (context2.charAt(token) == '/') {
								if (currXsdType == null) {
									if (currXsdElem != null) {
										currXsdType = currXsdElem.getTypeDefinition();
									}
								}
								if (currXsdType instanceof XSDComplexTypeDefinition) {
									XSDComplexTypeDefinition xsdcomplex = (XSDComplexTypeDefinition)currXsdType;
									
									for(Object next : XSDUtils.getChildElements(xsdcomplex)) {
										XSDElementDeclaration elem = ((XSDElementDeclaration)next).getResolvedElementDeclaration();
										String elemName = elem.getName();
										if (elem.getTargetNamespace() != null) {
												String elemNSPrefix = getNamespacePrefix(currVar, elem.getTargetNamespace());
											if (elemNSPrefix != null) {
												elemName = elemNSPrefix + COLON + elemName;
											}
										}
	
										if (levelName.compareTo(elemName) == 0) {
											currXsdType = elem.getTypeDefinition();
											currXsdElem = null;
											currMsg = null;
											//currXsdElem = elem.getResolvedElementDeclaration();
											childFound = true;
											break;
										}
									}
								}
								else if (currXsdType instanceof XSDSimpleTypeDefinition) {
									XSDSimpleTypeDefinition xsdsimple = (XSDSimpleTypeDefinition)currXsdType;
									//currXsdType = xsdsimple.getBaseType();
									//XSDSimpleTypeDefinition tempsimple = xsdsimple.getBaseTypeDefinition();
									//org.eclipse.xsd.XSDParticle temppart = xsdsimple.getComplexType();
									//XSDSimpleTypeDefinition tempsimple2 = xsdsimple.getItemTypeDefinition();
									String tempname = xsdsimple.getName();
									if (levelName.compareTo(tempname) == 0) {
										childFound = true;
									}
								}
								if (!childFound)
									break;
							}
						}	
						token = index;							
					}
					else if (t == '@')
						token = index;
					
					index++;
				}
				// determine if last character is a special character if above is successful
				if (index == context2.length()) {
					// looking for parts, attributes or elements?
					String beginsWith;
					if ((index-1) == token)
						beginsWith = EMPTY_STRING;
					else
						beginsWith = context2.substring(token+1);
					
					if ((context2.charAt(token) == '/') || (context2.charAt(token) == '@')) {
						if (currXsdType == null) {
							if (currXsdElem != null) {
								currXsdType = currXsdElem.getTypeDefinition();
							}
						}					
						if (currXsdType instanceof XSDComplexTypeDefinition) {
							XSDComplexTypeDefinition xsdcomplex = (XSDComplexTypeDefinition)currXsdType;
								@SuppressWarnings("rawtypes")
							Iterator eaIter;
							if (context2.charAt(token) == '/')
								eaIter = XSDUtils.getXSDElementsAndAttributes(xsdcomplex).iterator();
							else
								eaIter = XSDUtils.getChildAttributes(xsdcomplex).iterator();
							Image img = null;
							String tempReplName = null;
							String tempDispName = null;
							String namespace = null;
							String nsprefix = null;
							while (eaIter.hasNext()) {
								Object tempEA = eaIter.next();
	
								if (tempEA instanceof XSDAttributeDeclaration) {
									XSDAttributeDeclaration attr = (XSDAttributeDeclaration)tempEA;
									tempReplName = AT + attr.getName();
									tempDispName = attr.getName();
									namespace = attr.getTargetNamespace();
									if ((namespace != null) && (namespace.length() > 0)) {
											nsprefix = getNamespacePrefix(currVar, namespace);
										tempReplName = AT + nsprefix + COLON + attr.getName();
										tempDispName = nsprefix + COLON + tempDispName;
									}								
									img = attrImg;
								}
								else if (tempEA instanceof XSDElementDeclaration) {
									XSDElementDeclaration elem = ((XSDElementDeclaration)tempEA).getResolvedElementDeclaration();
									tempReplName = elem.getName();
									tempDispName = tempReplName;
									namespace = elem.getTargetNamespace();
									if ((namespace != null) && (namespace.length() > 0)) {
											nsprefix = getNamespacePrefix(currVar, namespace);
										tempReplName = nsprefix + COLON + tempDispName;
										tempDispName = tempReplName;
									}
									img = elementImg;
								}
								if (tempReplName != null) {
										if ((beginsWith.length() == 0) || (tempDispName != null && tempDispName.startsWith(beginsWith))) {
										int replOffset = offset-beginsWith.length();
										int replLen = beginsWith.length();
										if (context2.charAt(token) == '@') {
											replOffset--;
											replLen++;
										}
											
										prop = new CompletionProposal(tempReplName, replOffset, replLen,
												tempReplName.length(), img, tempDispName + "   " , //$NON-NLS-1$
												null, null);
										results.add(prop);
									}
								}
								tempReplName = null;
								tempDispName = null;
							}
						}
						else if (currXsdType instanceof XSDSimpleTypeDefinition) {
							XSDSimpleTypeDefinition simple = (XSDSimpleTypeDefinition)currXsdType;
							// do nothing?
						}
					}
					// search for parts
					else if (context2.charAt(token) == '.') {
						if (currMsg != null) {
							if (currMsg.getParts() != null) {
								for(Object next : currMsg.getParts().values() ) {													
									Part item = (Part) next;
									if ((beginsWith.length() == 0) || (item.getName().startsWith(beginsWith))) {
										prop = new CompletionProposal(item.getName(), offset-beginsWith.length(), beginsWith.length(),
												item.getName().length(), partImg, item.getName() + "   " , //$NON-NLS-1$
												null, null);
										results.add(prop);			
									}
								}
							}
						}
					}
				}
			}
			//variables
			else {
				for (Variable v : variables) {			
					name = v.getName();			
					if (name.startsWith(context2)) {
						prop = new CompletionProposal(DOLLAR + name, offset-context.length(), context.length(),
								name.length()+1, varImg, name + "   " , //$NON-NLS-1$
								null, null);
						results.add(prop);
					}
				}
			}
		}
		catch(IllegalArgumentException ex)
		{
			results.toArray(EMPTY_COMPLETION_PROPOSALS);
		}
		
		if (results.size() < 1) {
			return new ICompletionProposal [] {
						new CompletionProposal(EMPTY_STRING, offset, 0, 
								0, null, Messages.getString("ExpressionContentAssistProcessor.31"), //$NON-NLS-1$
								null, null) };
		}
		
		return results.toArray(EMPTY_COMPLETION_PROPOSALS);
	}
	
	// simple form of determining if variable is located at offset
	String startOfVariable(ITextViewer viewer, int offset) {
		int startPosition = offset-1;
		char currChar;
		String context = EMPTY_STRING; 
		IDocument document = viewer.getDocument();

		try {
			while (startPosition >= 0) {
				currChar = document.getChar(startPosition);
				
				if (currChar == '$')
					return context;
				
				if (!(Character.isLetterOrDigit(currChar) || currChar == '/' 
						|| currChar == '.' || currChar == '@' || currChar == '_'))
					return null;
				
				context = currChar + context;
				startPosition--;
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}
	
	// simple form of determing if function is located at offset
	String startOfFunction(ITextViewer viewer, int offset) {
		int startPosition = offset-1;
		char currChar;
		String context = EMPTY_STRING; 
		IDocument document = viewer.getDocument();

		try {
			while (startPosition >= 0) {
				if (Character.isWhitespace(currChar = document.getChar(startPosition)) ||
						isReservedOperatorCharacter(currChar) ||
						(currChar == '(') || (currChar == '[')) {
					if (context.length() > 0) {
						return context;
					}
					return null;
				}
				context = currChar + context;
				startPosition--;
			}
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		return context;
	}
	
	private boolean isLocationPathCharacter(char c) {
		final String LOCATION_CHARS = "./:@-"; //$NON-NLS-1$
		if ((LOCATION_CHARS.indexOf(c) > -1) || (Character.isLetterOrDigit(c) || c == '_'))
			return true;
		return false;
	}
	
	final static String RESERVED_OPERATOR_CHARS = "+-*/"; //$NON-NLS-1$
	
	private boolean isReservedOperatorCharacter(char c) {
		return RESERVED_OPERATOR_CHARS.indexOf(c) > -1;			
	}
	
	final static String RESERVED_CLOSING_EXPR_CHARS = ")]"; //$NON-NLS-1$
	
	private boolean isClosingExpressionCharacter(char c) {		
		return (RESERVED_CLOSING_EXPR_CHARS.indexOf(c) > -1);
	}	
}