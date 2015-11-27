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
 * Validates If nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */


public class IfValidator extends WhileValidator {
			
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.WhileValidator#checkChildren()
	 */
	
	@Override
	public void checkChildren() {
		super.checkChildren();
		checkChild(ND_ELSEIF,0,Integer.MAX_VALUE);
		checkChild(ND_ELSE,0,1);
	}
	
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
