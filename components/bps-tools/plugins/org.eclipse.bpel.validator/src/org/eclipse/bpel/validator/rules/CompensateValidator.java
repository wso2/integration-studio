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
 * Validates Compensate nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 5, 2006
 *
 */


public class CompensateValidator extends CActivityValidator {
							
	/**
	 * Checks to make sure that "compensate" is only placed within a 
	 * fault handler (catch, catchAll), another compensation handler,
	 * or a termination handler.
	 */
	
	@ARule (
		date = "10/5/2006",
		author = "michal.chmielewski@oracle.com",
		desc = "Check compensate placement",
		sa = 8 ,
		errors="BPELC_COMPENSATE__NOT_IN_HANDLER"
	)
	
	public void rule_CheckPlacement_10 () {
		
		INode parent = mNode.parentNode();
		while (parent != null) {
			QName nodeName = parent.nodeName();
			
			if (ND_COMPENSATION_HANDLER.equals ( nodeName ) ||
				ND_TERMINATION_HANDLER.equals ( nodeName ) ||
				ND_CATCH_ALL.equals ( nodeName ) ||
				ND_CATCH.equals ( nodeName ) ) 
			{ 
				return ;
			}			
			parent = parent.parentNode();
		}
		
		// at this point we have a problem.
		IProblem problem = createError();
		problem.fill("BPELC_COMPENSATE__NOT_IN_HANDLER", //$NON-NLS-1$
				toString(mNode.nodeName()),
				ncName
				 );		
	}
	
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
