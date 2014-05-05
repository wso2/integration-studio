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
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IConstants;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;




/**
 * Validates Empty nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */


public class AssignValidator extends CActivityValidator {
		
	final int COPY_MAX = Integer.MAX_VALUE;
	final int COPY_MIN = 1;							// at least either one Copy or one ExtensionAssignOperation node per Assign
	final int EXTENSION_ASSIGN_OPERATION_MAX = 1; 	// This implementation supports only one ExtensionAssignOpearation
	final int EXTENSION_ASSIGN_OPERATION_MIN = 1; 	// at least either one Copy or one ExtensionAssignOperation node per Assign
	protected String fValidate;

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	
	@Override
	public void checkChildren () {
		super.checkChildren ();
		
		// This will call both Copy and ExtensionAssign Validation
		checkChild(ND_COPY, COPY_MIN, COPY_MAX);
		checkChild(ND_EXTENSION_ASSIGN_OPERATION, EXTENSION_ASSIGN_OPERATION_MIN, EXTENSION_ASSIGN_OPERATION_MAX);

	}
	
	/**
	 * Method was override to support ExtensionAssignOpearation 
	 * This is custom method to Validate both ExtensionAssignOperation and Copy nodes.
	 * NOTE: The Existing Validator is not suitable to validate two children at ones.
	 */
	@Override
	public int checkChild ( IFilter<INode> filter, int min, int max) {
		
		final int CASE_COPY =1; 						// represents the case of default Assign Activity which has a copy element 
		final int CASE_EXTENSION_ASSIGN_OPERATION =2;	// represents the case of ExtensionAssignOperation 
		
		IFilter<INode> filterExtensionAssignOperation =  new NodeNameFilter(ND_EXTENSION_ASSIGN_OPERATION);
		IFilter<INode> filterCopy =  new NodeNameFilter(ND_COPY);
		IProblem problem;
		
		int count = 0;
		int copyCount = 0;
		int extensionAssignOperationCount = 0;
		int filterCase =0;
		
		for(INode n : fChildren) {
			if (filterCopy.select(n)) {
				copyCount += 1;
			}
			if (filterExtensionAssignOperation.select(n)) {
				extensionAssignOperationCount += 1;
			}
		}
		
		if(filter.toString().equals(filterCopy.toString()))
		{	
			if(copyCount==0 && extensionAssignOperationCount>0)
			{	//checking for wrong activity 
				return copyCount;
			}else if (copyCount>0)
			{	
				filterCase = CASE_COPY;
				count = copyCount;
			}
				
		}else if (filter.toString().equals(filterExtensionAssignOperation.toString()))
		{	
			if(copyCount>0 && extensionAssignOperationCount==0)
			{	//checking for wrong activity 
				return extensionAssignOperationCount;
			}else if (extensionAssignOperationCount>0)
			{	
				filterCase = CASE_EXTENSION_ASSIGN_OPERATION;
				count = extensionAssignOperationCount;
			}
		}
		
		if(extensionAssignOperationCount>0 && copyCount >0 && (filterCase== CASE_EXTENSION_ASSIGN_OPERATION|| filterCase== CASE_COPY ))
		{
			problem = createError();
			problem.fill("BPELC_ASSIGN__ELEMENT");
			return copyCount;
		}
				
		if (count < min) {
			problem = createError();
			problem.fill("BPELC__MIN_IN_PARENT",										
					toString(mNode.nodeName()),
					getNodeKind ( mNode ),
					IConstants.KIND_NODE,
					filter.toString(),					
					count,
					min
			);			
			
		} else if (count > max) {
			problem = createError();
			problem.fill("BPELC__MAX_IN_PARENT",
					toString(mNode.nodeName()),
					getNodeKind ( mNode ),
					IConstants.KIND_NODE,
					filter.toString(),
					count,
					max
			);
		}
		
		return count;		
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
