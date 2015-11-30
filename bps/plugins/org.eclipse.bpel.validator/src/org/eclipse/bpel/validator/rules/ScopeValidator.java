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
 * Java JDK dependency
 */
import java.util.List;

/**
 * Dependency on the BPEL validation model only in here ...
 */


import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;


/**
 * Validates scopes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */

@SuppressWarnings({"nls","boxing"} )
public class ScopeValidator extends CActivityValidator {
				

	protected String fExitStandardFault;

	protected String fIsolated;
	
	protected List<INode> fActivities;

	private int fCompensationHandlerCount = 0;

	protected int fFaultHandlersCount = 0;
	
	/**
	 * Start validation for this node
	 * 
	 */
	
	@Override
	protected void start () {
		super.start ();				
	}
	
	/**
	 * @see org.eclipse.bpel.validator.rules.CActivityValidator#checkChildren()
	 */
	
	
	@Override
	public void checkChildren () {
		
		super.checkChildren();
		
		checkChild(ND_PARTNER_LINKS, 0, 1);
		checkChild(ND_MESSAGE_EXCHANGES, 0, 1);
		checkChild(ND_VARIABLES, 0, 1);
		checkChild(ND_CORRELATION_SETS, 0, 1);
		
		fFaultHandlersCount  = checkChild(ND_FAULT_HANDLERS, 0, 1);
		fCompensationHandlerCount  = checkChild(ND_COMPENSATION_HANDLER, 0, 1);
		
		checkChild(ND_EVENT_HANDLERS, 0, 1);
		checkChild(Filters.ACTIVITIES,1,1);				
		
		setValue(ND_COMPENSATION_HANDLER + ".count", fCompensationHandlerCount);
		setValue(ND_FAULT_HANDLERS + ".count", fFaultHandlersCount);
	}
	
	
	
	
	/**
	 * Check exit on standard fault
	 *
	 */
	@ARule(
		sa = 0,
		desc = "Check isolated attribute setting on scope",
		author = "michal.chmielewski@oracle.com",
		date = "01/10/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
	)
	
	public void rule_CheckIsolatedAttribute_10 () {
		
		fIsolated = getAttribute(mNode, 
				AT_ISOLATED, 
				KIND_ACTIVITY, 
				Filters.BOOLEAN_FILTER, 
				false);
		
		if (isEmpty(fIsolated)) {					
			fIsolated = NO;
		} 
		setValue(AT_ISOLATED, fIsolated);		
	}	
	
	
	/**
	 * Check exit on standard fault
	 *
	 */
	@ARule(
		sa = 0,
		desc = "Check exitOnStandardFault attribute setting",
		author = "michal.chmielewski@oracle.com",
		date = "01/10/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
	)
	
	public void rule_CheckExitOnStandardFault_10 () {
		
		fExitStandardFault = getAttribute(mNode, 
				AT_EXIT_ON_STANDARD_FAULT, 
				KIND_NODE, 
				Filters.BOOLEAN_FILTER, 
				false);
		

		if (isEmpty(fExitStandardFault)) {	
			
			INode scope = mSelector.selectParent(fParentNode, Filters.SCOPE_OR_PROCESS);
			
			while (scope != null && isEmpty(fExitStandardFault)) {
				fExitStandardFault = getValue(scope,AT_EXIT_ON_STANDARD_FAULT,null);
				scope = mSelector.selectParent(scope.parentNode(), Filters.SCOPE_OR_PROCESS);
			}
		}
				
		setValue(AT_EXIT_ON_STANDARD_FAULT,fExitStandardFault);		
	}	
	
	
	/**
	 * Isolated scopes cannot contain other isolated scopes.
	 */
	@ARule(
		sa = 91,
		desc = "Isolated scopes may not contain other isolated scopes",
		author = "michal.chmielewski@oracle.com",
		date = "01/24/2007",
		errors="BPELC_SCOPE__ISOLATED"
	)
	
	public void rule_CheckNoIsolatedScopeDescendants_20 () {
		
		if (NO.equals(fIsolated)) {
			return ;
		}
		
		INode node = mSelector.selectParent(fParentNode,Filters.SCOPE);
		IProblem problem;
		
		while (node != null) {
			
			String isolated = getValue(node,AT_ISOLATED,NO);
			if (YES.equals(isolated)) {				
				problem = createError(mNode);
				problem.fill("BPELC_SCOPE__ISOLATED",
						toString(mNode.nodeName()),
						ncName,
						toString(node.nodeName()),
						node.getAttribute(AT_NAME)
				);
			}
			node = mSelector.selectParent(node.parentNode(), Filters.SCOPE);			
		}
		//
	}
	
	
	
	/**
	 * Isolated scopes cannot contain other isolated scopes.
	 */
	@ARule(
		sa = 92,
		desc = "Within a scope all immediately enclosed scopes must have unique name",
		author = "michal.chmielewski@oracle.com",
		date = "01/24/2007",
		errors="BPELC_SCOPE__UNIQUE_NAME"
	)
	
	public void rule_CheckUniqueScopeNames_20 () {
		
		INode scope = mSelector.selectParent(fParentNode,Filters.SCOPE_OR_PROCESS);
		IProblem problem;
		
		if (isUndefined(scope)) {
			return ;
		}
		
		// 
		String key   = "immediate.scope.name." + ncName;
		INode  aNode  = getValue(scope, key,null);	
	
		if (aNode == null) {
			setValue(scope,key, mNode);
		} else if (aNode == mNode) {
			// do nothing, its us
		} else {
			problem = createError(mNode);
			problem.fill("BPELC_SCOPE__UNIQUE_NAME",
					toString(mNode.nodeName()),
					ncName,
					toString(scope.nodeName()),
					scope.getAttribute(AT_NAME)
			);
		}
		//
	}

	
	
	/**
	 * The root scope inside a FCT-handler MUST not have a compensation handler.
	 */
	
	@ARule(
		sa = 79,
		desc = "Root scope inside an FCT-handler MUST not have a compensation handler",
		author = "michal.chmielewski@oracle.com",
		date = "02/28/2007",
		errors="BPELC_SCOPE__COMPENSATION_HANDLER"
	)
	
	public void rule_CheckRootFCTScope_25 () {
		
		INode node = mSelector.selectParent(mNode, Filters.FCT_HANDLER);
		
		if (mModelQuery.check(IModelQueryLookups.TEST_EQUAL, node, fParentNode) == false) {
			return ;
		}
		
		IProblem problem;
		// make sure we don't have a compensation handler ...
		if (fCompensationHandlerCount > 0) {
			
			problem = createError();
			problem.fill("BPELC_SCOPE__COMPENSATION_HANDLER",
					toString(mNode.nodeName()),
					ncName,
					toString(node.nodeName())
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
