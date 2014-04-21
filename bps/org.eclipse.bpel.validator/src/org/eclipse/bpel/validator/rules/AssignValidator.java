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


public class AssignValidator extends CActivityValidator {
		
	
	
	protected String fValidate;

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	
	@Override
	public void checkChildren () {
		super.checkChildren ();
		checkChild(ND_COPY, 1, Integer.MAX_VALUE);
		checkChild(ND_EXTENSION_ASSIGN_OPERATION, 0, Integer.MAX_VALUE);
	}
	/**
	 * 
	 */
	
	@Override
	protected void start () {
		super.start();
		
	}
	
	/**
	 *  
	 * 
	 */
	
	@ARule(
			desc = "Check validate attribute in assign activity.",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
		)
	public void rule_CheckValidate_10 () {
		fValidate = getAttribute(mNode, 
				AT_VALIDATE,  
				KIND_NODE, 
				Filters.BOOLEAN_FILTER, 
				false);
		
		if (isEmpty(fValidate)) {
			fValidate = NO;
		}
		
	}
	
	
	/** 
	 * End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function. 
	 */

}
