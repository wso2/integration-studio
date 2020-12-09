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

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.NodeNameFilter;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 6, 2006
 *
 */
public class BranchesValidator extends ConditionValidator {
	
	/** Parent node names */	
	@SuppressWarnings("hiding")
	static public IFilter<INode> PARENTS = new NodeNameFilter ( ND_COMPLETION_CONDITION );
	
	protected String fSuccessfulBranchesOnly;

	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.ConditionValidator#start()
	 */
	
	@Override
	protected void start() {		
		super.start();
	}	
	
	/**
	 * Check to see if successful branches is set to yes or no.
	 */
	
	@ARule(
			desc = "Check successfulBranchesOnly attribute.",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
		)
	public void rule_CheckSuccessfulBranchesOnly () {
		
		fSuccessfulBranchesOnly = getAttribute(mNode, 
				AT_SUCCESSFUL_BRANCHES_ONLY,				
				KIND_NODE, 
				Filters.BOOLEAN_FILTER,
				false);
		if (isEmpty(fSuccessfulBranchesOnly)) {
			fSuccessfulBranchesOnly = NO;
		}
	}

	
}
