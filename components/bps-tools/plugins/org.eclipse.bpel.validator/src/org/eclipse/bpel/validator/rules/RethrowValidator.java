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

import javax.xml.namespace.QName;

import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;



/**
 * Validates Rethrow nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 5, 2006
 *
 */


public class RethrowValidator extends CActivityValidator {
		
	/**
	 * Checks to make sure that "rethrow" is only placed within a 
	 * catch or catchAll.
	 */
	
	@ARule (
		date = "10/5/2006",
		author = "michal.chmielewski@oracle.com",
		desc = "Check rethrow placement (catch or catchAll)",
		sa = 6 ,
		errors="BPELC_RETHROW__NOT_IN_FAULT_HANDLER"
	)
	
	public void rule_CheckRethrowPlacement_10 () {
		
		INode parent = mNode.parentNode();
		while (parent != null) {
			QName nodeName = parent.nodeName();
			if (ND_CATCH.equals ( nodeName ) || ND_CATCH_ALL.equals (nodeName )) {
				return ;
			}			
			parent = parent.parentNode();
		}
		
		// at this point we have a problem.
		IProblem problem = createError();
		problem.fill("BPELC_RETHROW__NOT_IN_FAULT_HANDLER", //$NON-NLS-1$
				ncName,
				toString(mNode.nodeName()) );		
	}
	
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
