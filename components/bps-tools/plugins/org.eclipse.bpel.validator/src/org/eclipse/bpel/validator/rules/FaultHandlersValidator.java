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

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.NodeNameFilter;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jan 18, 2007
 *
 */

@SuppressWarnings({ "nls", "boxing" })

public class FaultHandlersValidator extends CValidator {

	int fCatches;
	int fCatchAll;
	
	/** my parents */
	static public IFilter<INode> PARENTS = Filters.SCOPE_OR_PROCESS;
	
	/** Catches that are part of event handlers */
	static IFilter<INode> CATCHES = new NodeNameFilter( ND_CATCH , ND_CATCH_ALL );
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	
	@Override
	public void checkChildren () {
		super.checkChildren();
		fCatches  = checkChild(ND_CATCH,     0, Integer.MAX_VALUE);
		fCatchAll = checkChild(ND_CATCH_ALL, 0, 1);		
	}
	
	/**
	 * Start the rules for fault handlers.
	 * @see org.eclipse.bpel.validator.model.Validator#start()
	 */
	
	@Override
	protected void start () {
		super.start();

	}		
	
	
	/**
	 * Check the count of the handlers to be at least 1.
	 *
	 */

	@ARule(
		date = "01/10/2007",
		author = "michal.chmielewski@oracle.com",
		desc = "At least one catch or catchAll must be present in fault handlers.",
		sa = 80 ,
		errors="BPELC__AT_LEAST_ONE"
	)
	
	public void rule_CheckHandlerCount_1 () {
		
		int count = fCatchAll+ fCatches;
		IProblem problem;
		
		if (count < 1) {
			problem = createError();
			problem.fill("BPELC__AT_LEAST_ONE",
					toString(mNode.nodeName()),
					KIND_NODE,
					CATCHES,
					KIND_NODE
					);					
		}		
	}
	
	
	
}
