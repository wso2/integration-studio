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
 * Dependency on the BPEL Validation Model API
 */
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;


/**
 * Validates Wait nodes.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 22, 2006
 *
 */


public class WaitValidator extends CActivityValidator {
			
	protected INode untilExpr;
	protected INode forExpr;	
	
	
	
	/**
	 * Start the validation of this node.
	 */
	@Override
	protected void start () {
		
		super.start();		
		forExpr = mNode.getNode( ND_FOR );
		untilExpr = mNode.getNode( ND_UNTIL );
		
	}
		
	
	/** 
	 * Do a basic sanity check on the wait activity.
	 */
	@ARule(
		date = "9/22/2006",		
		desc = "Do a basic sanity check on the wait activity.",
		author = "michal.chmielewski@oracle.com",
		errors="BPELC_EMPTY_EXPIRATION_SETTING,BPELC_MULTIPLE_EXPIRATION_SETTING"
	)
	
	public void rule_BasicSanityCheck_5 () {
		
		IProblem problem;
		
		if (forExpr == null && untilExpr == null) {
			// both undefined
			problem = createError();
			problem.setAttribute(IProblem.CONTEXT, AT_FOR);
			problem.fill( 
					"BPELC_EMPTY_EXPIRATION_SETTING", //$NON-NLS-1$
					toString(mNode.nodeName()) );
		} 
		
		
		if (forExpr != null && untilExpr != null) {
			// both defined
			problem = createError();
			problem.setAttribute(IProblem.CONTEXT, AT_FOR);
			problem.fill( 
					"BPELC_MULTIPLE_EXPIRATION_SETTING", //$NON-NLS-1$
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
