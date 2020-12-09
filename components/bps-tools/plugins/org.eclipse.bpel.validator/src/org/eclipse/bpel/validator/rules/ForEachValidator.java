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





/**
 * Validates Empty nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */


public class ForEachValidator extends CActivityValidator {
			
	
	protected String fCounterName;
	protected String fParallel;

	/**(non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CActivityValidator#start()
	 */
	
	@Override
	protected void start () {
		super.start();
	}
	
	/**
	 * Check parallel attribute values
	 *
	 */
	
	@ARule(
			desc = "Check parallel attribute in forEach activity.",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
		)
	public void rule_CheckParallel_1 () {
		fParallel = getAttribute(mNode, 
				AT_PARALLEL, 
				KIND_ACTIVITY, 
				Filters.BOOLEAN_FILTER, 
				true);
		
		if (isEmpty(fParallel)) {
			fParallel = NO;
		}
	}
	
	/**
	 * Check the name of the counter variable, to make sure it's a valid NCName
	 */
	
	@ARule(
			sa = 0,
			desc = "Check the NCName of the forEach activity counter.",
			author = "michal.chmielewski@oracle.com",
			date = "01/20/2007",
			errors="BPELC__UNSET_ATTRIBUTE,General.NCName_Bad"
		)
	public void rule_CheckCounterName_2 () {
		
		fCounterName = mNode.getAttribute(AT_COUNTER_NAME);
		
		checkNCName(mNode, fCounterName, AT_COUNTER_NAME);
		
	}
	
	
	
	/**
	 * @see org.eclipse.bpel.validator.rules.CActivityValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {
		
		super.checkChildren();
		
		checkChild(ND_START_COUNTER_VALUE,   1,1);
		checkChild(ND_FINAL_COUNTER_VALUE,   1,1);
		checkChild(ND_COMPLETION_CONDITION,  0,1);		
		checkChild(ND_SCOPE, 1,1);		
	}
	
	
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
