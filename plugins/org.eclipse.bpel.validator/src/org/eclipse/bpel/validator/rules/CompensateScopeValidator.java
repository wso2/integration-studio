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

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;



/**
 * Validates CompensateScope nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 5, 2006
 *
 */

@SuppressWarnings({"nls","boxing"})

public class CompensateScopeValidator extends CActivityValidator {
		
	protected INode fOwnerScopeProcess = null ;
	
	protected String fTargetScopeNCName = null;

	protected  INode fTargetScope = null;
	
	/**
	 * Checks to make sure that "compensate" is only placed within a 
	 * fault handler (catch, catchAll), another compensation handler,
	 * or a termination handler.
	 */
	
	@ARule (
		date = "10/5/2006",
		author = "michal.chmielewski@oracle.com",
		desc = "Check compensateScope placement.",
		sa = 7 ,
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
				
				fOwnerScopeProcess = mSelector.selectParent(parent, Filters.SCOPE_OR_PROCESS );
				// found the scope or process
				return ;
			}
			parent = parent.parentNode();
		}
		
		// at this point we have a problem.
		IProblem problem = createError();
		problem.fill("BPELC_COMPENSATE__NOT_IN_HANDLER", //$NON-NLS-1$
				toString(mNode.nodeName()),
				ncName );		
	}
	
	
	/**
	 * Check to target scope NCName
	 * 
	 */
	
	@ARule(
		sa = 1004,
		desc = "Check target scope NCName",
		author = "michal.chmielewski@oracle.com",
		date = "02/27/2007",
		errors="BPELC__UNSET_ATTRIBUTE,General.NCName_Bad"
	)
		
	public void rule_CheckTargetScopeNCName_15 () {
		fTargetScopeNCName = mNode.getAttribute( AT_TARGET );
		if (checkNCName(mNode, fTargetScopeNCName, AT_TARGET) == false) {
			disableRules();
		}		
	}
	
	
	
	/**
	 * Check target scope
	 * 
	 */
	
	
	@ARule(
		sa = 77,
		desc = "Make sure that the target scope exists",
		author = "michal.chmielewski@oracle.com",
		date = "02/27/2007",
		tag = "pass2",
		errors="BPELC_COMPENSATE_SCOPE__NO_TARGET"
	)
		
	public void rule_CheckTargetScope_25 () {
		
		if (isUndefined(fOwnerScopeProcess)) {
			return ;
		}
		
		IProblem problem;
		
		fTargetScope = getValue(fOwnerScopeProcess, "immediate.scope.name." + fTargetScopeNCName , null);
		
		if (isUndefined(fTargetScope)) {		
			problem = createError();
			problem.fill("BPELC_COMPENSATE_SCOPE__NO_TARGET",
					toString(mNode.nodeName()),
					mNode.getAttribute(AT_NAME),
					fTargetScopeNCName
			);
			
			return ;			
		}
		
		QName targetNodeName = fTargetScope.nodeName();
		
		if (targetNodeName.equals(ND_SCOPE) == false && targetNodeName.equals(ND_INVOKE) == false ) {
			problem = createError();
			problem.fill("BPELC_COMPENSATE_SCOPE__NO_TARGET",
					toString(mNode.nodeName()),
					mNode.getAttribute(AT_NAME),
					fTargetScopeNCName
			);
			return ;
		}
		
		// it exists, hurray !				
	}
	
	
	/**
	 * The target attribute of a <compensateScope> activity MUST refer to a 
	 * scope or an invoke activity with a fault handler or compensation handler.
	 *
	 */
	
	
	@ARule(
		sa = 78,
		desc = "Target of compenateScope must have a fault or compensation handler",
		author = "michal.chmielewski@oracle.com",
		date = "02/27/2007",
		tag = "pass2",
		errors="BPELC_COMPENSATE_SCOPE__TARGET_NO_HANDLERS"
	)
			
	public void rule_CheckTargetScopeHandlers_27 () {
		
		if (isUndefined(fTargetScope)) {
			return ;
		}
		
		IProblem problem;			
		
		int compensationHandlers = getValue(fTargetScope, ND_COMPENSATION_HANDLER + ".count", 0);		
		int faultHandlers = getValue(fTargetScope,ND_FAULT_HANDLERS + ".count",0);
		
		if (faultHandlers < 1 && compensationHandlers < 1) {
			problem = createError();
			problem.fill("BPELC_COMPENSATE_SCOPE__TARGET_NO_HANDLERS",
				toString(mNode.nodeName()),
				mNode.getAttribute(AT_NAME),
				fTargetScopeNCName,
				toString(fTargetScope.nodeName())
			);
		}
	}
	
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
