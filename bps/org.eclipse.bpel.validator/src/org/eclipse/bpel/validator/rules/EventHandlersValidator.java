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
 * Event handlers.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jan 18, 2007
 *
 */

@SuppressWarnings({ "nls", "boxing" })
public class EventHandlersValidator extends CValidator {

	/** Parent nodes */
	static public IFilter<INode> PARENTS = Filters.SCOPE_OR_PROCESS;
	
	int fOnEvents;
	int fOnAlarms;	
	
	static final IFilter<INode> EVENTS = new NodeNameFilter( ND_ON_EVENT, ND_ON_ALARM );
	
	/**
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {
		super.checkChildren();
		fOnEvents = checkChild (ND_ON_EVENT,0,Integer.MAX_VALUE);
		fOnAlarms = checkChild (ND_ON_ALARM,0,Integer.MAX_VALUE);
	}
	
	
	/**
	 * Check the count of the handlers to be at least 1.
	 *
	 */

	@ARule(
		date = "01/10/2007",
		author = "michal.chmielewski@oracle.com",
		desc = "At least one onAlarm or onEvent must be present in event handlers.",
		sa = 83 ,
		errors="BPELC__AT_LEAST_ONE"
	)
	
	public void rule_CheckHandlerCount_1 () {
		
		int count = fOnAlarms + fOnEvents ;
		IProblem problem;
		
		if (count < 1) {
			problem = createError();
			problem.fill("BPELC__AT_LEAST_ONE",
					toString(mNode.nodeName()) ,
					KIND_NODE,
					EVENTS,
					KIND_NODE);					
		}		
	}
	
	
	
	
	
}
