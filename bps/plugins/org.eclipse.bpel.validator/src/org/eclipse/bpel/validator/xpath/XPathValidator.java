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
package org.eclipse.bpel.validator.xpath;

/**
 * Validator BPEL model dependency
 */

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IConstants;
import org.eclipse.bpel.validator.model.IFunctionMeta;
import org.eclipse.bpel.validator.model.IModelQuery;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.Validator;
import org.eclipse.bpel.validator.tools.ParserTool;
import org.eclipse.bpel.xpath10.AdditiveExpr;
import org.eclipse.bpel.xpath10.EqualityExpr;
import org.eclipse.bpel.xpath10.Expr;
import org.eclipse.bpel.xpath10.FunctionCallExpr;
import org.eclipse.bpel.xpath10.LiteralExpr;
import org.eclipse.bpel.xpath10.LogicalExpr;
import org.eclipse.bpel.xpath10.MultiplicativeExpr;
import org.eclipse.bpel.xpath10.NumberExpr;
import org.eclipse.bpel.xpath10.RelationalExpr;
import org.eclipse.bpel.xpath10.UnaryExpr;
import org.eclipse.bpel.xpath10.VariableReferenceExpr;
import org.eclipse.bpel.xpath10.parser.XPath10Exception;
import org.eclipse.bpel.xpath10.parser.XPath10Factory;

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
 * <li>branches - unsigned integer
 * <li>condition - boolean
 * <li>finalCounterValue - unsigned integer
 * <li>for - duration
 * <li>from - any
 * <li>joinCondition - boolean
 * <li>repeatEvery - duration
 * <li>startCounterValue - unsigned integer
 * <li>to - variable reference expression ($var/foo)
 * <li>transitionCondition - boolean
 * <li>until - deadline
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

@SuppressWarnings({ "nls", "boxing" })
public class XPathValidator extends Validator {

	/** The string format of the XPath expression */
	String exprString;

	String exprStringTrimmed;

	/** the parsed XPath expression */
	Expr xpathExpr;

	/** For static analysis */
	XPathVisitor mVisitor;

	/** expression name by node name */
	protected String fExprByNode;

	/** parent node */
	protected INode fParentNode;

	/**
	 * Start the validation of this XPathExpression
	 */

	@Override
	public void start() {
		super.start();

		exprString = mModelQuery.lookup(mNode,
				IModelQueryLookups.LOOKUP_TEXT_TEXT, null, null);

		exprStringTrimmed = exprString.trim();

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
			problem.fill("XPATH_EMPTY_EXPRESSION", toString(mNode.nodeName()),
					fExprByNode);
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
			xpathExpr = XPath10Factory.create(exprString);
		} catch (XPath10Exception e) {
			problem = createError();
			problem.fill("XPATH_EXPRESSION_SYNTAX", toString(mNode.nodeName()),
					exprStringTrimmed, fExprByNode, e.getMessage());
			repointOffsets(problem, e.getPosition(), e.getPosition() + 3);
			// TODO: Position in the expression ... ?
			disableRules();
		}
	}

	protected void repointOffsets(IProblem problem, Expr expr) {
		if (expr.getPosition() < 0 || expr.getEndPosition() < 0) {
			return;
		}
		repointOffsets(problem, expr.getPosition(), expr.getEndPosition());
	}

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

		mVisitor = new XPathVisitor(this);

		INode typeNode = getValue("expression.type", null);

		if (typeNode != null) {
			mVisitor.contextPush(typeNode);
		}
	}

	/**
	 * Sets the value of the expression result. This is run as the last rule in
	 * pass1 and it examines the top element on the stack that the
	 * visitor/validator combination has produced.
	 * 
	 */

	public void rule_ExpressionType_999999() {

		if (mVisitor == null) {
			return;
		}

		Object obj = mVisitor.contextPop();

		// Type needs to be re-mapped to XSD types that our model understands.

		if (XPathVisitor.isSimpleType(obj)) {

			setValue("expression.value", obj);

			QName typeQName = null;

			if (obj instanceof String) {

				typeQName = new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI,
						"string");

			} else if (obj instanceof Number) {

				Number num = (Number) obj;

				if (num.intValue() == num.doubleValue()) {

					if (mNode.equals(ND_START_COUNTER_VALUE)
							|| mNode.equals(ND_FINAL_COUNTER_VALUE)) {
						if (num.intValue() >= 0) {
							typeQName = new QName(
									XMLConstants.W3C_XML_SCHEMA_NS_URI,
									"unsignedInt");
						}
					}

					if (typeQName == null) {
						typeQName = new QName(
								XMLConstants.W3C_XML_SCHEMA_NS_URI, "integer");
					}
				} else {
					typeQName = new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI,
							"double");
				}

			} else if (obj instanceof Boolean) {

				typeQName = new QName(XMLConstants.W3C_XML_SCHEMA_NS_URI,
						"boolean");

			}

			INode basicType = mModelQuery.lookup(mNode.rootNode(),
					IModelQueryLookups.LOOKUP_NODE_XSD_TYPE, typeQName);

			if (isUndefined(basicType)) {
				setValue("expression.type", null);
			} else {
				setValue("expression.type", basicType);
			}

		} else if (obj instanceof INode) {

			setValue("expression.type", obj);

		} else if (obj instanceof List) {

			// node list, we can't check the types

		} else {
			// everything else we ignore
		}

	}

	/**
	 * Check the deadline expression.
	 */

	public void checkDeadlineExpression() {

		IProblem problem;
		Expr expr = xpathExpr;
		// Bugzilla 320539:
		if (expr instanceof UnaryExpr) {
			expr = ((UnaryExpr) expr).getExpr();
		}

		if (expr instanceof LiteralExpr) {
			LiteralExpr lexpr = (LiteralExpr) expr;
			try {
				ParserTool.parseDateAndTime(lexpr.getLiteral());
			} catch (Exception e) {
				problem = createError();
				problem.fill("XPATH_EXPRESSION_SYNTAX",
						toString(mNode.nodeName()), lexpr.getLiteral(),
						fExprByNode, e.getMessage());
				repointOffsets(problem, expr);
			}
		} else if (expr instanceof FunctionCallExpr) {
			mVisitor.visit((FunctionCallExpr) expr);
		} else {
			problem = createError();
			problem.fill("XPATH_EXPRESSION_TYPE", toString(mNode.nodeName()),
					exprStringTrimmed, fExprByNode);
			repointOffsets(problem, expr);
		}

		disableRules();
	}

	/**
	 * Check the duration expression variant.
	 */

	public void checkDurationExpression() {

		IProblem problem;
		Expr expr = xpathExpr;

		// Bugzilla 320539:
		if (expr instanceof UnaryExpr) {
			expr = ((UnaryExpr) expr).getExpr();
		}

		if (expr instanceof LiteralExpr) {
			LiteralExpr lexpr = (LiteralExpr) expr;
			try {
				ParserTool.parseDuration(lexpr.getLiteral());
			} catch (Exception e) {
				problem = createError();
				problem.fill("XPATH_EXPRESSION_SYNTAX",
						toString(mNode.nodeName()), lexpr.getLiteral(),
						fExprByNode, e.getLocalizedMessage());
				repointOffsets(problem, expr);
			}
		} else if (expr instanceof FunctionCallExpr) {
			mVisitor.visit((FunctionCallExpr) expr);
		} else {
			problem = createError();
			problem.fill("XPATH_EXPRESSION_TYPE", toString(mNode.nodeName()),
					exprStringTrimmed, fExprByNode);
			repointOffsets(problem, expr);
		}

		disableRules();
	}

	/**
	 * Check boolean expressions
	 */

	public void checkBooleanExpression() {

		Expr expr = xpathExpr;

		IProblem problem;

		if (expr instanceof LogicalExpr) {
			mVisitor.visit((LogicalExpr) expr);
		} else if (expr instanceof EqualityExpr) {
			mVisitor.visit((EqualityExpr) expr);
		} else if (expr instanceof RelationalExpr) {
			mVisitor.visit((RelationalExpr) expr);
		} else if (expr instanceof UnaryExpr
				&& !(((UnaryExpr) expr).getExpr() instanceof FunctionCallExpr)) {
			// Bugzilla 320538:
			// Allow unary expressions like variable references and literals
			// Since we're using XPath 1.0 there's no XSD type checking
			mVisitor.visit((UnaryExpr) expr);
		} else {
			FunctionCallExpr fce = null;
			// Bugzilla 320535:
			// apparently XPath functions are Unary expressions first
			if (expr instanceof UnaryExpr
					&& ((UnaryExpr) expr).getExpr() instanceof FunctionCallExpr) {
				fce = (FunctionCallExpr) ((UnaryExpr) expr).getExpr();
			} else if (expr instanceof FunctionCallExpr) {
				fce = (FunctionCallExpr) expr;
			}

			if (fce != null) {
				if (isBooleanFunction(fce) == false) {

					problem = createWarning();
					problem.fill("XPATH_EXPRESSION_TYPE",
							toString(mNode.nodeName()), exprStringTrimmed,
							fExprByNode);
					repointOffsets(problem, fce);
				}

				mVisitor.visit(fce);

			} else {
				problem = createError();
				problem.fill("XPATH_EXPRESSION_TYPE",
						toString(mNode.nodeName()), exprStringTrimmed,
						fExprByNode

				);
				repointOffsets(problem, expr);
			}
		}

		// Once validated this type of expression we are done.

		disableRules();
	}

	/**
	 * Check the integer expression.
	 * 
	 * Not this is not a rule.
	 */

	public void checkIntegerExpression() {

		IProblem problem;
		Expr expr = xpathExpr;

		if (expr instanceof MultiplicativeExpr) {
			mVisitor.visit((MultiplicativeExpr) expr);
		} else if (expr instanceof AdditiveExpr) {
			mVisitor.visit((AdditiveExpr) expr);
		} else if (expr instanceof UnaryExpr) {
			mVisitor.visit((UnaryExpr) expr);
		} else if (expr instanceof NumberExpr) {
			mVisitor.visit((NumberExpr) expr);
		} else if (expr instanceof VariableReferenceExpr) {
			mVisitor.visit((VariableReferenceExpr) expr);
		} else {
			problem = createError();
			problem.fill("XPATH_EXPRESSION_TYPE", toString(mNode.nodeName()),
					exprStringTrimmed, fExprByNode);
		}

		disableRules();
	}

	/**
	 * Check function call expression.
	 * 
	 * @param expr
	 */
	@ARule(sa = 1015, desc = "Check functions in XPath expressions", author = "michal.chmielewski@oracle.com", date = "03/02/2007", tag = "functions", order = 1)
	public void checkFunctions(FunctionCallExpr expr) {

		String functionPrefix = expr.getPrefix();
		String nsURI = lookupNamespace(functionPrefix);

		if (XPathVisitor.isBPELNS(nsURI)) {
			runRules("bpel.functions", expr);
		}

		IFunctionMeta meta = lookup(expr);

		checkFunctionMeta(expr, meta);
		checkFunctionCall(expr, meta);

	}

	/**
	 * Check the GetVariableProperty function.
	 * 
	 * @param expr
	 */

	@ARule(sa = 30, desc = "Arguments to getVariableProperty must be quoted strings", author = "michal.chmielewski@oracle.com", date = "01/29/2007", tag = "bpel.functions")
	public void checkGetVariableProperty(FunctionCallExpr expr) {

		String fn = expr.getFunctionName();
		if ("getVariableProperty".equals(fn) == false) {
			return;
		}

		List<?> params = expr.getParameters();
		IProblem problem;

		int psize = params.size();
		if (psize != 2) {
			problem = createError();
			int pz = (params.size() - 2 < 0) ? 0 : 1;
			problem.fill("XPATH_FN_ARGS", toString(mNode.nodeName()), fn,
					expr.getText(), pz, 2);
			repointOffsets(problem, expr);

			if (psize < 1) {
				return;
			}
		}

		for (int i = 0, j = Math.min(2, params.size()); i < j; i++) {
			Expr p = (Expr) params.get(i);
			if ((p instanceof LiteralExpr) == false) {
				problem = createError();
				problem.fill("XPATH_FN_LITERAL_ARGS",
						toString(mNode.nodeName()), fn, expr.getText(), i + 1,
						p.getText());

				repointOffsets(problem, p);
			}
		}

		// check to see if the variable exists, it must be the 1st argument
		Expr p1 = (Expr) params.get(0);
		if (p1 instanceof LiteralExpr) {
			LiteralExpr p1l = (LiteralExpr) p1;

			// check to make sure we don't print the same message twice.
			if (duplicateThing("duplicate.variable.check.", p1l.getLiteral()) == false) {

				INode variableNode = mModelQuery.lookup(mNode,
						IModelQueryLookups.LOOKUP_NODE_VARIABLE,
						p1l.getLiteral());

				if (isUndefined(variableNode)) {
					problem = createError();
					problem.fill("XPATH_UNDEF_VARIABLE", //$NON-NLS-1$
							p1l.getLiteral(), expr.getText());
					repointOffsets(problem, p1l);
				}
			}
		}

	}

	/**
	 * @param expr
	 */
	@ARule(sa = 31, desc = "The second argument MUST be a string literal conforming to the definition of QName in section 3", author = "michal.chmielewski@oracle.com", date = "01/29/2007", tag = "bpel.functions")
	public void checkGetVariableProperty2ndArgument(FunctionCallExpr expr) {

		String fn = expr.getFunctionName();

		if ("getVariableProperty".equals(fn) == false) {
			return;
		}

		List<?> params = expr.getParameters();

		if (params.size() < 2
				|| ((params.get(1) instanceof LiteralExpr) == false)) {
			// already handled in previous rule.
			return;
		}

		LiteralExpr p2l = (LiteralExpr) params.get(1);

		// Make sure that the 2nd argument is a QName
		QName qname = mModelQuery.createQName(mNode, p2l.getLiteral());
		IProblem problem;

		if (isNamespaceOK(qname) == false) {
			problem = createError();

			problem.fill("XPATH_UNRESOLVED_NAMESPACE_PREFIX",
					qname.getPrefix(), qname.getLocalPart());

			repointOffsets(problem, p2l);

			return;
		}

		// look up variable property in the model ?
	}

	/**
	 * Check XslTransform function
	 * 
	 * @param expr
	 */

	@ARule(sa = 39, desc = "1st arguments to doXslTransform must be quoted string", author = "michal.chmielewski@oracle.com", date = "01/29/2007", tag = "bpel.functions")
	public void CheckDoXslTransform_10(FunctionCallExpr expr) {

		String fn = expr.getFunctionName();
		if ("doXslTransform".equals(fn) == false) {
			return;
		}

		List<?> params = expr.getParameters();
		IProblem problem;
		int psize = params.size();

		if (psize < 2) {

			problem = createError();
			problem.fill("XPATH_FN_ARGS", toString(mNode.nodeName()), fn,
					expr.getText(), 0, 2);
			repointOffsets(problem, expr);

			if (psize < 1) {
				return;
			}
		}

		Expr p = (Expr) params.get(0);

		if ((p instanceof LiteralExpr) == false) {
			problem = createError();
			problem.fill("XPATH_FN_LITERAL_ARGS", toString(mNode.nodeName()),
					fn, expr.getText(), 1, p.getText());

			repointOffsets(problem, p);
			return;
		}

		LiteralExpr lexpr = (LiteralExpr) p;
		
		// quick check if this is valid URI ...
		try {
			new java.net.URI( lexpr.getLiteral());
			
		} catch (URISyntaxException e) {
			problem = createWarning();
			problem.fill("XPATH_URI_SYNTAX", toString(mNode.nodeName()),
					lexpr.getLiteral(), expr.getText(), e.getMessage());
			repointOffsets(problem, lexpr);
		}

	}

	/**
	 * @param expr
	 */
	@ARule(sa = 40, desc = "There must be an even number of arguments doXslTransform", author = "michal.chmielewski@oracle.com", date = "01/29/2007", tag = "bpel.functions")
	public void CheckDoXslTransform_11(FunctionCallExpr expr) {

		String fn = expr.getFunctionName();
		if ("doXslTransform".equals(fn) == false) {
			return;
		}

		List<?> params = expr.getParameters();
		if (params.size() < 2) {
			// handled in other rule
			return;
		}

		IProblem problem;
		if (params.size() % 2 != 0) {
			problem = createError();
			problem.fill("XPATH_FN_ARGS", toString(mNode.nodeName()), fn,
					expr.getText(), 0, 2);
			repointOffsets(problem, expr);
		}
	}

	/**
	 * Even number of arguments must be present.
	 * 
	 * @param expr
	 */

	@ARule(sa = 41, desc = "3rd,5th,7th, etc. arguments must be QName strings", author = "michal.chmielewski@oracle.com", date = "01/29/2007", tag = "bpel.functions")
	public void CheckDoXslTransform_15(FunctionCallExpr expr) {

		String fn = expr.getFunctionName();
		if ("doXslTransform".equals(fn) == false) {
			return;
		}

		List<?> params = expr.getParameters();
		if (params.size() < 3) {
			// handled in other rule
			return;
		}

		IProblem problem;

		// check the 3rd, 5th, 7th etc. arguments of the XPath expression to
		// make sure
		// that they are QNames.
		for (int i = 2, j = params.size(); i < j; i += 2) {
			Expr p = (Expr) params.get(i);
			if (p instanceof LiteralExpr) {
				LiteralExpr p2l = (LiteralExpr) p;

				QName qname = mModelQuery.createQName(mNode, p2l.getLiteral());

				if (isNamespaceOK(qname) == false) {
					problem = createError();
					problem.fill("XPATH_UNRESOLVED_NAMESPACE_PREFIX",
							qname.getPrefix(), qname.getLocalPart());
					repointOffsets(problem, p);
				}
			} else {
				problem = createError();
				problem.fill("XPATH_FN_LITERAL_ARGS",
						toString(mNode.nodeName()), fn, expr.getText(), i + 1,
						p.getText());
				repointOffsets(problem, p);
			}
		}

		//

	}

	/**
	 * Check variables used in XPath expressions.
	 * 
	 * @param expr
	 */

	@ARule(
			sa = 0,
			desc = "Check the variable namespace prefix",
			author = "michal.chmielewski@oracle.com",
			date = "01/30/2007",
			tag = "variables",
			errors="XPATH_INVALID_VARREF_PREFIX"
	)
	public void rule_CheckVariable_10(VariableReferenceExpr expr) {

		if (isJoinCondition()) {
			return;
		}

		String prefix = expr.getPrefix();
		String name = expr.getVariableName();
		IProblem problem;

		// Bugzilla 320537:
		// this returns too soon - only check duplicateThing if we're sure that
		// there really IS a problem
		// check to make sure we don't print the same message twice.
		// if (duplicateThing("duplicate.variable.check.", name)) {
		// return;
		// }

		if (isEmpty(prefix) == false) {
			// check to make sure we don't print the same message twice.
			if (duplicateThing("duplicate.variable.check.", name)) {
				return;
			}
			problem = createError();
			problem.fill("XPATH_INVALID_VARREF_PREFIX", //$NON-NLS-1$
					prefix + ":" + name); //$NON-NLS-1$
		}

		int i = name.indexOf('.');
		String varName, partName;
		if (i < 0) {
			varName = name;
			partName = null;
		} else {
			varName = name.substring(0, i);
			partName = name.substring(i + 1);
		}

		INode variable = mModelQuery.lookup(mNode,
				IModelQueryLookups.LOOKUP_NODE_VARIABLE, varName);

		if (isUndefined(variable)) {

			// Bugzilla 320537:
			// check to make sure we don't print the same message twice.
			if (duplicateThing("duplicate.variable.check.", name)) {
				return;
			}
			problem = createError();
			problem.fill("XPATH_UNDEF_VARIABLE", //$NON-NLS-1$
					varName, expr.getText());

			repointOffsets(problem, expr);

			// if it does not exist, we are done
			mVisitor.contextPush(Collections.EMPTY_LIST);
			return;
		}

		// Get the type reference of the variable
		INode varTypeNode = getValue(variable, "type", null);

		// If the variable has problems, leave now
		if (hasProblems(variable) || isUndefined(varTypeNode)) {
			mVisitor.contextPush(Collections.EMPTY_LIST);
			return;
		}

		mVisitor.contextPush(Collections.EMPTY_LIST);

		// check variable parts
		INode variablePart = null;

		if (partName != null) {

			variablePart = mModelQuery.lookup(varTypeNode,
					IModelQueryLookups.LOOKUP_NODE_TYPE_OF_PART, partName);
		}

		if (partName != null) {

			if (WSDL_ND_MESSAGE.equals(varTypeNode.nodeName()) == false) {
				// Bugzilla 320537:
				// check to make sure we don't print the same message twice.
				if (duplicateThing("duplicate.variable.check.", name)) {
					return;
				}
				problem = createError();
				problem.fill("XPATH_VARIABLE_PART", varName, partName,
						expr.getText(), 0);
				repointOffsets(problem, expr);

			} else if (isUndefined(variablePart)) {

				// Bugzilla 320537:
				// check to make sure we don't print the same message twice.
				if (duplicateThing("duplicate.variable.check.", name)) {
					return;
				}
				problem = createError();
				problem.fill("XPATH_UNDEF_VARIABLE_PART", //$NON-NLS-1$
						varName, partName, expr.getText());
				repointOffsets(problem, expr);

			} else {
				mVisitor.contextPop();
				mVisitor.contextPush(variablePart);
			}

		} else {
			// there is no part name specified, but variable does have more then
			// 1 part.
			if (WSDL_ND_MESSAGE.equals(varTypeNode.nodeName())) {
				// Bugzilla 320537:
				// check to make sure we don't print the same message twice.
				if (duplicateThing("duplicate.variable.check.", name)) {
					return;
				}
				problem = createError();
				problem.fill("XPATH_VARIABLE_PART", varName,
						"text.term.unspecified", expr.getText(), 1);
				repointOffsets(problem, expr);

			} else {
				mVisitor.contextPop();
				mVisitor.contextPush(varTypeNode);
			}
		}

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

	/**
	 * Check if the function is a boolean function.
	 * 
	 * @param functionExpr
	 * @return true if a function is boolean, false otherwise.
	 */
	boolean isBooleanFunction(FunctionCallExpr functionExpr) {

		IFunctionMeta meta = lookup(functionExpr);
		if (meta == null) {
			return false;
		}
		return meta.getReturnType() == Boolean.class;
	}

	/**
	 * Empty prefix in functionExpr implies an XPath function.
	 * 
	 * @param functionExpr
	 */
	protected void checkFunctionMeta(FunctionCallExpr functionExpr,
			IFunctionMeta meta) {

		String fnCall = functionExpr.getFunctionName();
		if (isEmptyOrWhitespace(functionExpr.getPrefix()) == false) {
			fnCall = functionExpr.getPrefix() + ":" + fnCall;
		}

		if (duplicateThing("function.meta.", fnCall)) {
			return;
		}

		IProblem problem;

		if (meta == null) {
			problem = createWarning();
			problem.fill("XPATH_FUNCTION_UNKNOWN", //$NON-NLS-1$
					toString(mNode.nodeName()), fnCall);
			repointOffsets(problem, functionExpr);

			return;
		}

		if (meta.isDeprecated()) {
			problem = createWarning();
			problem.fill(
					"XPATH_FUNCTION_DEPRECATED", //$NON-NLS-1$
					toString(mNode.nodeName()), fnCall,
					meta.getDeprecateComment());
			repointOffsets(problem, functionExpr);
		}
	}

	protected void checkFunctionCall(FunctionCallExpr functionExpr,
			IFunctionMeta meta) {

		if (meta == null || functionExpr == null) {
			return;
		}

		String fnCall = functionExpr.getFunctionName();
		if (isEmptyOrWhitespace(functionExpr.getPrefix()) == false) {
			fnCall = functionExpr.getPrefix() + ":" + fnCall;
		}

		IProblem problem;

		List<?> params = functionExpr.getParameters();
		if (params.size() < meta.getMinArity()) {
			problem = createError();
			problem.fill(
					"XPATH_FUNCTION_MIN_ARGS", //$NON-NLS-1$
					toString(mNode.nodeName()), fnCall, meta.getMinArity(),
					params.size());
			repointOffsets(problem, functionExpr);
		}

		if (params.size() > meta.getMaxArity()) {
			problem = createError();
			problem.fill(
					"XPATH_FUNCTION_MAX_ARGS", //$NON-NLS-1$
					toString(mNode.nodeName()), fnCall, meta.getMaxArity(),
					params.size());
		}

	}

	protected IFunctionMeta lookup(FunctionCallExpr functionExpr) {

		String ns = null;
		if (isEmptyOrWhitespace(functionExpr.getPrefix())) {
			ns = IConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE;
		} else {
			ns = lookupNamespace(functionExpr.getPrefix());
		}
		return mModelQuery.lookupFunction(
				IConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE, ns,
				functionExpr.getFunctionName());
	}

}
