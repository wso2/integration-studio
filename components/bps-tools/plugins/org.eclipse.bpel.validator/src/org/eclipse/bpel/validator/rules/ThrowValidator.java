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

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;



/**
 * Validates Throw activities.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */


public class ThrowValidator extends CActivityValidator {
			
	String fFaultName;
	INode fFaultVariable;
	
	protected QName fFaultQName;
	
	
	/**
	 * Start the validation.
	 * 
	 */
	@Override
	protected void start () {
		super.start();
			
		fFaultVariable = mModelQuery.lookup(mNode, 
							IModelQueryLookups.LOOKUP_NODE_VARIABLE,
							mNode.getAttribute( AT_FAULT_VARIABLE ) );
	}
	/**
	 * Check the fault name being thrown.
	 *
	 */
	
	public void rule_CheckFaultName_10 () {		
		fFaultName = mNode.getAttribute(AT_FAULT_NAME);
		
		if (isEmpty(fFaultName)) {
			// problem
			return ;
		}
		
		fFaultQName = mModelQuery.createQName(mNode, fFaultName);		
	}
	
	/** 
	 * Check to make sure that the fault if specified, is valid.
	 *
	 */
	@SuppressWarnings("boxing")
	@ARule(
		sa = 0,
		desc = "Check if the fault is valid",
		author = "michal.chmielewski@oracle.com",
		date = "02/15/2007",
		errors="BPELC_THROW__NO_SUCH_VARIABLE,BPELC_REF_NODE_PROBLEMS",
		warnings="BPELC_REF_NODE_PROBLEMS"
	)
	public void rule_CheckFaultVariable_12 () {
		
		if (fFaultVariable == null) {
			// DO: bugid 3282
			return;
		}
		
		IProblem problem;
		
		String varName = mNode.getAttribute( AT_FAULT_VARIABLE );
		
		if (isUndefined(fFaultVariable)) {
			problem = createError();
			problem.fill("BPELC_THROW__NO_SUCH_VARIABLE", //$NON-NLS-1$
					varName );
			return ;
		}		
		
		// see if the variable's validator has reported problems
		
		if (fFaultVariable.nodeValidator().hasProblems()) {
			
			problem = createWarning();
			problem.fill("BPELC_REF_NODE_PROBLEMS", //$NON-NLS-1$
					toString(mNode.nodeName()),
					ND_VARIABLE,
					AT_FAULT_VARIABLE,
					KIND_ACTIVITY );
		}
		
	}
	
	
	/**
	 * Check to make sure that the variable type matches the
	 * fault name or that fault names can be associated into
	 * that variable.
	 */
	
	public void rule_CheckVariableType_14 () {
		// TODO: 
	}
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
