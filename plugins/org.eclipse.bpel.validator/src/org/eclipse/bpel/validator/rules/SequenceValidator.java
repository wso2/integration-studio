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


/**
 * Validates sequences.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */

public class SequenceValidator extends CActivityValidator {
	
	/**
	 * @see org.eclipse.bpel.validator.rules.CActivityValidator#checkChildren()
	 */
	
	@Override
	public void checkChildren () {
		super.checkChildren();
		checkChild(Filters.ACTIVITIES,1,Integer.MAX_VALUE);
	}
	
	/**
	 * Start the validation process
	 */
	
	@Override
	protected void start () {		
		super.start();
							
	}
	
			
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
