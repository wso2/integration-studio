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
package org.eclipse.bpel.validator.rules;

/**
 * Dependency on the BPEL validator model facade.
 */

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Selector;



/**
 * Validates While nodes.
 *   
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 2nd, 2006
 *
 */


public class WhileValidator extends CActivityValidator {
			
	protected String exprLanguage;
	protected INode conditionExpr;
	protected INode activity;
		
	
	/**
	 * Start the validation of this node.
	 */
	@Override
	protected void start () {
		super.start();
		
		conditionExpr = mNode.getNode(ND_CONDITION);				
		activity = mSelector.selectNode(mNode, Selector.ALL, Filters.ACTIVITIES);		
	}

	/**
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	
	@Override
	public void checkChildren () {
		super.checkChildren();
		
		checkChild(ND_CONDITION, 1, 1);
		checkChild(Filters.ACTIVITIES,1,1);
	}
	
	
	/** 
	 * Do a basic sanity check on the wait activity.
	 */
	
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "Check if a condition is present on the while activity",		
		date = "10/2/2006",
		sa = 1000 ,
		errors="BPELC_NO_EXPRESSION"
	)
	
	public void rule_BasicSanityCheck_11 () {
		
		IProblem problem;
		
		if (conditionExpr == null) {
			// both undefined
			problem = createError();
			problem.fill( 
					"BPELC_NO_EXPRESSION", //$NON-NLS-1$
					AT_CONDITION,
					toString(mNode.nodeName()) );
		} 				
	}	
	
	
	

	
	
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
