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

import java.util.Iterator;
import java.util.Map;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.Problem;
import org.eclipse.bpel.xpath10.Expr;
import org.eclipse.bpel.xpath10.FunctionCallExpr;
import org.eclipse.bpel.xpath10.LocationPath;
import org.eclipse.bpel.xpath10.UnaryExpr;
import org.eclipse.bpel.xpath10.VariableReferenceExpr;
import org.eclipse.bpel.xpath10.parser.XPath10Parser.unaryExpr_return;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Mar 23, 2007
 *
 */

@SuppressWarnings({"nls","boxing"})
public class Query extends XPathValidator {

	boolean bBpelFunctions  = true;
	boolean bBpelVariables  = false;
	
	
	/**
	 * @see org.eclipse.bpel.validator.xpath.XPathValidator#start()
	 */
	
	@Override
	public void start () {
		super.start();
		bBpelFunctions = getValue("bpel.function",  bBpelFunctions);
		bBpelVariables = getValue("bpel.variables", bBpelVariables);
	}
	/**
	 * Check query type of expressions (can only LocationPaths).
	 *
	 */
	
	@ARule(
		sa = 27,
		desc = "Check the query location path",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		order = 16
	)
	
	public void CheckQuery () {			
		
		IProblem problem;
		Expr expr = xpathExpr ;
		
		if (expr instanceof UnaryExpr && ((UnaryExpr)expr).getExpr() instanceof LocationPath) {
			expr = ((UnaryExpr)expr).getExpr();
			
			Object obj = mVisitor.contextPeek();
			if (obj instanceof INode) {
				mVisitor.visit( expr );
			} else {
				problem = createError();
				problem.fill("XPATH_NO_LOCATION_PATH", 
						expr.getText(),
						toString(mNode.nodeName())  );			
				repointOffsets(problem, expr);
			}
		} else {
			problem = createError();
			problem.fill("XPATH_NOT_A_LOCATION", //$NON-NLS-1$
					exprStringTrimmed,
					toString(mNode.nodeName())
				);	
			repointOffsets(problem, expr);
		}			
		
		// Don't run anything else.
		disableRules();
	}
	
	
	
	
	/**
	 * Check Location path expressions
	 * @param expr the location path expr
	 *
	 */
	

	@ARule(
		sa = 27,
		desc = "There is no implicit context node in XPath expressions used in BPEL",
		author = "michal.chmielewski@oracle.com",
		date = "0/20/2007",
		tag = "location"		
	)
	
	public void CheckLocationPath ( LocationPath expr ) {			
		
		Object obj = mVisitor.contextPeek();
		if (obj instanceof INode) {
			return ;
		}
		
		IProblem problem = createError();
		problem.fill("XPATH_NO_LOCATION_PATH", 
				expr.getText(),
				toString(mNode.nodeName()) );			
		repointOffsets(problem, expr);
	
		disableRules();
	}
	
	
	
	/**
	 * @param expr
	 */
	@ARule(
		sa = 29,
		desc = "BPEL variables cannot be used in propertyAlias queries",
		author = "michal.chmielewski@oracle.com",
		date = "01/30/2007",
		tag = "variables"
	)		
	
	public void CheckVariable ( VariableReferenceExpr expr ) {
		if (bBpelVariables) {
			return ;
		}
	}

	
	/**
	 * @param expr
	 */
	@SuppressWarnings("nls")
	@ARule(
		sa = 29,
		desc = "BPEL Functions must not be used in query expressions for propertyAlias",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		tag = "bpel.functions"
	)
	public void CheckBPELFunctions ( FunctionCallExpr expr ) {
				
		if (bBpelFunctions) {
			return ;
		}
		
		IProblem problem = createError();
		problem.fill("XPATH_BPEL_FUNCTION", 
				toString(mNode.nodeName()),				
				expr.getFunctionName(),
				fExprByNode
			);		
		repointOffsets(problem, expr);				
	}
	
	
	
}
