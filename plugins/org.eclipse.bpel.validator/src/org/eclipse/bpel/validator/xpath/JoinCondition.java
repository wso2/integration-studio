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

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.xpath10.FunctionCallExpr;
import org.eclipse.bpel.xpath10.VariableReferenceExpr;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Mar 23, 2007
 *
 */

@SuppressWarnings("nls")
public class JoinCondition extends XPathValidator {
	
	/**
	 * Boolean expressions on joinCondition
	 */
	@Override
	@ARule(
		sa = 73,
		desc = "Checks for boolean expression on joinCondition",
		author = "michal.chmielewski@oracle.com",
		date = "01/30/2007",
		order = 15
	)
	
	public void checkBooleanExpression () {
		super.checkBooleanExpression();
	}
	
	
	
	
	/**
	 * BPEL Functions must not be used in joinConditions
	 * @param expr the function call expression
	 */
	
	@SuppressWarnings("nls")
	@ARule(
		sa = 28,
		desc = "BPEL Functions must not be used in joinConditions",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		tag = "bpel.functions"
	)
	public void checkBPELFunctionsInJoinConditions ( FunctionCallExpr expr ) {
				
		IProblem problem = createError();
		problem.fill("XPATH_BPEL_FUNCTION", 
				toString(mNode.nodeName()),				
				expr.getFunctionName(),
				fExprByNode
			);		
		repointOffsets(problem, expr);				
	}
	

	/**
	 * Check link reference expression 
	 * @param expr
	 */
	

	@ARule(
		sa = 73,
		desc = "Check the link reference for joinCondition (only incoming link names)",
		author = "michal.chmielewski@oracle.com",
		date = "01/30/2007",
		tag = "variables",
		order = 17
	)
	
	public void checkLinkReference ( VariableReferenceExpr expr ) {
			
		String prefix = expr.getPrefix();
		final String name = expr.getVariableName();
		IProblem problem;

		// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
		if ( isEmpty ( prefix ) == false  ) {
			if (duplicateThing( "duplicate.joinCondition.link.check.", name)) {
				return ;
			}

			problem = createError();
			problem.fill("XPATH_PREFIX_NOT_ALLOWED",  
					toString(mNode.nodeName()),
					expr.getText(),
					prefix);
			repointOffsets(problem, expr);
		}
		
		
		// Select the target link name.
		INode target = mSelector.selectNode(fParentNode, ND_TARGET, 
				new IFilter<INode>() {
					public boolean select(INode node) {
						return name.equals(node.getAttribute(AT_LINK_NAME));
					}
				}
		);
								
		if (isUndefined(target)) {			
			if (duplicateThing( "duplicate.joinCondition.link.check.", name)) {
				return ;
			}
			problem = createError();
			problem.fill("XPATH_LINK_UNDEF", name , expr.getText() );	
			repointOffsets(problem, expr);
		}
		
	}
	
}
