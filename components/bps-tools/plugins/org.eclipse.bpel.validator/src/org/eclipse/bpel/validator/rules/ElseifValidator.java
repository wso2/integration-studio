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
 * Validates ElseIf nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */


public class ElseifValidator extends ElseValidator {						
		
	

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.ElseValidator#checkChildren()
	 */
	
	@Override
	public void checkChildren () {		
		checkChild(ND_CONDITION,1,1);
		super.checkChildren();
	}
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */
}
