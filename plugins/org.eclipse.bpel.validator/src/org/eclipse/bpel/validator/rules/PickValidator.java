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


import java.util.List;

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

@SuppressWarnings("nls")

public class PickValidator extends CActivityValidator {

	protected String fCreateInstance;
	
	protected int fOnMessages = 0;
	
	protected int fOnAlarms = 0;
	
	
	static IFilter<INode> CHILDREN = new NodeNameFilter(
			ND_ON_ALARM, ND_ON_MESSAGE 
	);
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	
	@Override
	public void checkChildren () {
		super.checkChildren();
		
		fOnMessages = checkChild(ND_ON_MESSAGE,1,Integer.MAX_VALUE);				
		fOnAlarms = checkChild(ND_ON_ALARM,  0,Integer.MAX_VALUE);
	}
	
	
	
	/**
	 * Checks the value of the createInstance attribute to see if it has been
	 * set.
	 */
	@ARule(
		sa = 0,
		desc = "Checks to see if the createInstance attribute is set.",
		author = "michal.chmielewski@oracle.com",
		date = "01/10/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
	)
	
	public void rule_CheckCreateInstanceSet_1 () {
		
		fCreateInstance = getAttribute(mNode, 
				AT_CREATE_INSTANCE, 
				KIND_ACTIVITY, 
				Filters.BOOLEAN_FILTER, 
				false);
		
		if (isEmpty(fCreateInstance)) {			
			fCreateInstance = NO;
		} 
	}
	
	
	/**
	 * Check the onMessageOnAlarms, there must be at least 1.
	 */
	
	
	@SuppressWarnings("boxing")	
	@ARule(
		sa = 0,
		desc = "Check if at least 1 onAlarm/onMessage is present in a <pick>",
		author="michal.chmielewski@oracle.com",
		date="01/15/2007",
		errors="BPELC__AT_LEAST_ONE"
	)
	
	public void rule_CheckOnMessagesOnAlarms_1 () {
		int count = fOnMessages + fOnAlarms;
		
		IProblem problem ;
		
		if (count == 0) {
			problem = createError();
			problem.fill("BPELC__AT_LEAST_ONE",
					toString(mNode.nodeName()),
					KIND_ACTIVITY,
					CHILDREN,
					KIND_NODE );
		}
	}
	
	
	/**
	 * When createInstance is set to yes, onAlarm must not be specified.
	 */
	@ARule(
		sa = 62,
		desc = "When createInstance is set to yes, onAlarm must not be there.",
		author = "michal.chmielewski@oracle.com",
		date = "01/10/2007",
		errors="BPELC_PICK__ON_ALARM"
	)
			
	public void rule_CheckNoAlaram_2 () {			
	
		IProblem problem;
		
		if (YES.equals(fCreateInstance) && fOnAlarms > 0) {
			problem = createError();
			problem.fill("BPELC_PICK__ON_ALARM",
				toString(mNode.nodeName()),
				AT_CREATE_INSTANCE,
				fCreateInstance );
		}
		
	}
	
	
	/**
	 * Check if this is a valid start activity. 
	 *
	 */
	@ARule(
		sa = 56,
		desc = "Check if this pick activity is positioned correctly",
		author = "michal.chmielewski@oracle.com",
		date = "01/10/2007",
		errors="BPELC__START_ACTIVITY"
	)
	
	public void rule_CheckIfStartActivity_3 () {
		
		if (NO.equals(fCreateInstance)) {
			return ;
		}
		checkStartActivityPositioning();
		
		/** mark in the process that we are a start activity. */											
		List<INode> starts = getValue ( mNode.rootNode(), "start.activities" , null );								
		starts.add( mNode );
	}
	
}
