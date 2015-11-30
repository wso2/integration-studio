/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.validator.xpath0;

/**
 * Validator BPEL model dependency
 */

import javax.xml.namespace.QName;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IModelQuery;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.Validator;


/**
 * This validator validates the XPath expressions used in the BPEL source.
 * <p>
 * The validation consists of 2 steps:
 * <ul>
 * <li>Compilation and syntax check,and
 * <li>Static analysis on the expression
 * </ul>
 * <p>
 * The static analysis is performed by visiting the parsed expression tree and
 * checking certain things against the actual BPEL model.
 * <p>
 * The nodes which may contain XPath expressions in BPEL 2.0 and their expected
 * type is as follows:
 * 
 * <ul>
 * <li> branches - unsigned integer
 * <li> condition - boolean
 * <li> finalCounterValue - unsigned integer
 * <li> for - duration
 * <li> from - any
 * <li> joinCondition - boolean
 * <li> repeatEvery - duration
 * <li> startCounterValue - unsigned integer
 * <li> to - variable reference expression ($var/foo)
 * <li> transitionCondition - boolean
 * <li> until - deadline
 * 
 * </ul>
 * 
 * 
 * <p>
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 27, 2006
 * 
 */

@SuppressWarnings( { "nls", "boxing" })
public class XPathValidator extends Validator {

	/** The string format of the XPath expression */
	String exprString;
	String exprStringTrimmed;

	/** The node name in which this expression is placed */
	protected String fNodeName;

	/** expression name by node name */
	protected String fExprByNode;

	/** parent node */
	protected INode fParentNode;

	protected XPathExpression xpathExpression;

	/**
	 * Start the validation of this XPathExpression
	 */

	@Override
	public void start() {
		super.start();

		exprString = mModelQuery.lookup(mNode,
				IModelQueryLookups.LOOKUP_TEXT_TEXT, null, null);

		exprStringTrimmed = exprString.trim();

		fNodeName = toString(mNode.nodeName());

		fParentNode = mNode.parentNode();

		/** fExprByNode is a key to a localization map */
		fExprByNode = "text.node." + mNode.nodeName().getLocalPart();
	}

	/**
	 * Do a quick sanity check.
	 */

	@ARule(
			desc = "XPath sanity check",
			author = "michal.chmielewski@oracle.com",
			date = "02/16/2007",
			errors="XPATH_EMPTY_EXPRESSION"
		)
	public void rule_SanityCheck_1() {
		IProblem problem;

		if (isEmptyOrWhitespace(exprString)) {
			problem = createError();
			problem.fill("XPATH_EMPTY_EXPRESSION", fNodeName, fExprByNode);
			exprString = null;

			disableRules();
		}
	}

	/**
	 * Check syntax of this expression ...
	 * 
	 */

	@ARule(
			desc = "XPath syntax check",
			author = "michal.chmielewski@oracle.com",
			date = "02/16/2007",
			errors="XPATH_EXPRESSION_SYNTAX"
		)
	public void rule_CheckExpressionSyntax_2() {

		if (exprString == null) {
			return;
		}

		IProblem problem;

		try {
			XPathFactory factory = XPathFactory.newInstance();
			xpathExpression = factory.newXPath().compile(exprString);			
		} catch (XPathExpressionException e) {
			String message = getMessageFrom ( e );
						problem = createError();
			problem.fill("XPATH_EXPRESSION_SYNTAX", fNodeName,
					exprStringTrimmed, fExprByNode, message);
			// repointOffsets(problem, e.getPosition(), e.getPosition() + 3);
			// TODO: Position in the expression ... ?
			disableRules();

		} 
	}

	/**
	 * Sets the value of the expression result. This is run as the last rule in
	 * pass1 and it examines the top element on the stack that the
	 * visitor/validator combination has produced.
	 * 
	 */

	public void rule_ExpressionType_999999() {
		setValue("expression.type",null);
	}
	
	
	
	
	String getMessageFrom (Throwable t) {
		int i = 10;
		while (t.getCause() != null && i > 0) {
			t = t.getCause();
			i--;
		}
		return t.getMessage();		
	}
	
	
//	protected void repointOffsets(IProblem problem, Expr expr) {
//		if (expr.getPosition() < 0 || expr.getEndPosition() < 0) {
//			return;
//		}
//		repointOffsets(problem, expr.getPosition(), expr.getEndPosition());
//	}

	/**
	 * @param problem
	 * @param offset
	 * @param offsetEnd
	 */
	protected void repointOffsets(IProblem problem, int offset, int offsetEnd) {

		int charStart = mModelQuery.lookup(mNode,
				IModelQueryLookups.LOOKUP_NUMBER_CHAR_START_2, -1);
		int charEnd = mModelQuery.lookup(mNode,
				IModelQueryLookups.LOOKUP_NUMBER_CHAR_END_2, -1);

		int lineNo = mModelQuery.lookup(mNode,
				IModelQueryLookups.LOOKUP_NUMBER_LINE_NO_2, -1);
		int columnNo = mModelQuery.lookup(mNode,
				IModelQueryLookups.LOOKUP_NUMBER_COLUMN_NO_2, -1);

		if (charStart < 0 || charEnd < 0) {
			return;
		}

		charStart += offset;
		charEnd += offsetEnd;

		// Technically that should be it, but there are 3 issues:
		// - have to re-point column
		// - have to re-point row
		// - have to adjust for \n in charStart and charEnd (JAXEN issue).

		for (int i = 0, j = Math.min(exprString.length(), offset); i < j; i++) {

			if (exprString.charAt(i) == '\n') {
				// This is a JAXEN problem/hack
				charStart += 1;

				if (lineNo > 0) {
					lineNo += 1;
				}
				columnNo = 0;
			}

			if (columnNo >= 0) {
				columnNo += 1;
			}
		}

		// Now do the same thing for charEnd
		for (int i = 0, j = Math.min(exprString.length(), offsetEnd); i < j; i++) {
			// This is a JAXEN problem/hack
			if (exprString.charAt(i) == '\n') {
				charEnd += 1;
			}
		}

		problem.setAttribute(IProblem.CHAR_START, charStart);
		problem.setAttribute(IProblem.CHAR_END, charEnd);

		if (lineNo > 0) {
			problem.setAttribute(IProblem.LINE_NUMBER, lineNo);
		}
		if (columnNo > 0) {
			problem.setAttribute(IProblem.COLUMN_NUMBER, columnNo);
		}

	}

	/**
	 * Perform static analysis of this XPath expression.
	 * 
	 */
	@ARule(
			sa = 0,
			desc = "Create the static analysis visitor for expression analysis",
			author = "michal.chmielewski@oracle.com",
			date = "01/30/2007",
			errors="XPATH_EXPRESSION_SYNTAX,XPATH_EXPRESSION_TYPE,XPATH_FN_ARGS,"+
				"XPATH_FN_LITERAL_ARGS,XPATH_UNDEF_VARIABLE,XPATH_UNRESOLVED_NAMESPACE_PREFIX"+
				"XPATH_INVALID_VARREF_PREFIX,XPATH_VARIABLE_PART,XPATH_UNDEF_VARIABLE_PART"+
				"XPATH_FUNCTION_MIN_ARGS,XPATH_FUNCTION_MAX_ARGS,XPATH_EMPTY_EXPRESSION",
			warnings="XPATH_URI_SYNTAX,XPATH_FUNCTION_UNKNOWN,XPATH_FUNCTION_DEPRECATED,XPATH_EXPRESSION_TYPE"
			
		)
	public void rule_StaticXPathExpressionAnalysis_10() {

		// mVisitor = new XPathVisitor(this);

		// INode typeNode = getValue("expression.type", null);

//		if (typeNode != null) {
//			mVisitor.contextPush(typeNode);
//		}
	}


	/**
	 * Check the deadline expression.
	 */

	public void checkDeadlineExpression() {

	}

	/**
	 * Check the duration expression variant.
	 */

	public void checkDurationExpression() {
	}

	/**
	 * Check boolean expressions
	 */

	public void checkBooleanExpression() {

	}

	/**
	 * Check the integer expression.
	 * 
	 * Not this is not a rule.
	 */

	public void checkIntegerExpression() {
	}

	boolean isNamespaceOK(QName qname) {
		if (qname == null) {
			return false;
		}
		return (isEmpty(qname.getNamespaceURI()) == isEmpty(qname.getPrefix()));
	}

	protected boolean isJoinCondition() {
		/** ND_ are QNames, so make sure you compare apples to apples ... */
		return ND_JOIN_CONDITION.equals(mNode.nodeName());
	}

	protected IModelQuery getModelQuery() {
		return mModelQuery;
	}

	protected INode getNode() {
		return mNode;
	}

	/**
	 * This exists here for visibility to XPathVisitor.
	 * 
	 * @see org.eclipse.bpel.validator.model.Validator#createError()
	 */

	@Override
	protected IProblem createError() {
		return super.createError();
	}

	/**
	 * This exists here for visibility to XPathVisitor.
	 * 
	 * @see org.eclipse.bpel.validator.model.Validator#createInfo()
	 */
	@Override
	protected IProblem createInfo() {
		return super.createInfo();
	}

	/**
	 * This exists here for visibility to XPathVisitor.
	 * 
	 * @see org.eclipse.bpel.validator.model.Validator#createWarning()
	 */
	@Override
	protected IProblem createWarning() {
		return super.createWarning();
	}

	/**
	 * @see org.eclipse.bpel.validator.model.Validator#runRules(java.lang.String,
	 *      java.lang.Object[])
	 */

	@Override
	protected void runRules(String tag, Object... args) {
		// this exists here for visibility to XPathVisitor.
		super.runRules(tag, args);
	}

	protected boolean duplicateThing(String... args) {

		String key = null;
		if (args.length == 1) {
			key = args[0];
		} else {
			StringBuilder sb = new StringBuilder();
			for (String a : args) {
				sb.append(a);
			}
			key = sb.toString();
		}

		if (containsValueKey(key)) {
			return true;
		}

		setValue(key, Boolean.TRUE);
		return false;
	}

	protected boolean checkPrefix(String prefix, String name) {

		if (isEmptyOrWhitespace(prefix)) {
			return true;
		}

		String nsURI = lookupNamespace(prefix);

		if (isEmpty(nsURI)) {
			IProblem problem = createError();
			problem.fill("XPATH_UNRESOLVED_NAMESPACE_PREFIX", //$NON-NLS-1$
					prefix, name);

			return false;
		}

		return true;
	}

	protected String lookupNamespace(String prefix) {
		return mModelQuery.lookup(mNode,
				IModelQueryLookups.LOOKUP_TEXT_PREFIX2NS, prefix, null);
	}


}
