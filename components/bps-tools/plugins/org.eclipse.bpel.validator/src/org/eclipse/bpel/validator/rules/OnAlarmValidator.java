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
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;



/**
 * Validates Wait nodes.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 22, 2006
 *
 */


public class OnAlarmValidator extends CValidator {
			
	protected INode untilExpr;
	protected INode forExpr;
	
	protected boolean fIsEventHandler = false;
	
	/** Parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter(
			ND_PICK, ND_EVENT_HANDLERS
	);
	
	
	/**
	 * Start the validation of this node.
	 */
	@Override
	protected void start () {
		super.start();		
		forExpr = mNode.getNode( ND_FOR );
		untilExpr = mNode.getNode( ND_UNTIL );	
		
		fIsEventHandler = fParentNode.nodeName().equals(ND_EVENT_HANDLERS);						
	}
		
	
	/**
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {
		
		super.checkChildren();
		if (fIsEventHandler) {
			checkChild(ND_REPEAT_EVERY, 0, 1);
			checkChild(ND_SCOPE,1,1);
		} else {
			checkChild(Filters.ACTIVITIES,1,1);
		}
	}
		
	
	/** 
	 * Do a basic sanity check on the wait activity.
	 */
	
	@ARule(
			desc = "Basic sanity check of wait activity",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC_EMPTY_EXPIRATION_SETTING,BPELC_MULTIPLE_EXPIRATION_SETTING"
		)
	public void rule_BasicSanityCheck_5 () {
		
		IProblem problem;
		
		if (forExpr == null && untilExpr == null) {
			// both undefined
			problem = createError();
			problem.fill( 
					"BPELC_EMPTY_EXPIRATION_SETTING", //$NON-NLS-1$
					toString(mNode.nodeName()) );
		} 
		
		
		if (forExpr != null && untilExpr != null) {
			// both defined
			problem = createError();
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
