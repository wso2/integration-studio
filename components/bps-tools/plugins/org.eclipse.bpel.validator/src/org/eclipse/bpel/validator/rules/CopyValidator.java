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
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;
import org.eclipse.bpel.validator.model.Validator;



/**
 * Validates Empty nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */


@SuppressWarnings("nls")

public class CopyValidator extends CValidator {
			
	/** My parents */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_ASSIGN );

	protected INode fToNode;
	protected INode fFromNode;

	protected Validator fromNodeValidator;

	protected Validator toNodeValidator;

	protected String fKeepSrcElement;

	protected INode fFromTypeNode;

	protected INode fToTypeNode;
		
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren ( ) {
		super.checkChildren ();
		checkChild(ND_FROM,1,1);
		checkChild(ND_TO,1,1);		
	}
	
	/** 
	 * Start validation process on this node.
	 * 
	 */
	
	@Override
	protected void start() {		
		super.start();
		
		fToNode = mNode.getNode(ND_TO);
		fFromNode = mNode.getNode(ND_FROM);
	}



	/**
	 * Checks the verifyKeepSrcElement attribute.
	 *
	 */
	
	@ARule(
		sa = 1001,
		desc = "Check to see if keep source element is one of the allowed values",
		author = "michal.chmielewski@oracle.com",
		date = "02/12/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
	)
	public void rule_VerifyKeepSrcElement_5 () {
		
		fKeepSrcElement = getAttribute(mNode, 
				AT_KEEP_SRC_ELEMENT_NAME, 
				KIND_NODE, 
				Filters.BOOLEAN_FILTER, 
				false);
		
		if (isEmpty(fKeepSrcElement)) {
			fKeepSrcElement = NO;
		}		
	}

	
	
	
	/**
	 * Check to see if the copy rule is compatible.
	 *
	 */
	
	
	@ARule(
		sa = 43,
		desc = "From and to spec must have compatible types",
		author = "michal.chmielewski@oracle.com",
		date = "02/16/2007",
		tag = "pass2",
		errors="BPELC_COPY__INCOMPATIBLE",
		warnings="BPELC_COPY__INCOMPATIBLE_SIMPLE",
		infos = "BPELC_COPY__NOT_CHECKED"
	)	
	public void rule_CheckCompatibleCopy_40 () {
		
		compatibleCopyCheck(fFromNode,fToNode);
	}
	
	
	
	

	/**
	 * This rule gets run after all the validation rules have been (on 2nd pass).
	 */
	
	@ARule(
		sa = 42,
		desc = "Check if both from and to specs are EII; only then can keepSrcElement be set",
		author = "michal.chmielewski@oracle.com",
		date = "02/16/2007",
		tag = "pass2",
		errors="BPELC_COPY__KEEP_ELEMENT_NAME"
	)	
	public void rule_CheckKeepSrcElement_50 () {
		
		if (NO.equals(fKeepSrcElement)) {
			return ;
		}
		
		fFromTypeNode = getValue(fFromNode,"type",null);
		fToTypeNode = getValue(fToTypeNode,"type",null);
		
		if (fFromTypeNode == null || fToTypeNode == null) {
			return ;
		}
		
		
		IProblem problem;
		
		if (mModelQuery.check(IModelQueryLookups.TEST_IS_SIMPLE_TYPE,fFromTypeNode,null) ) {
		
			problem = createError();
			problem.fill("BPELC_COPY__KEEP_ELEMENT_NAME",
					toString(mNode.nodeName()),
					AT_KEEP_SRC_ELEMENT_NAME,
					"text.term.from",					
					fFromTypeNode					
			);
		}

		if (mModelQuery.check(IModelQueryLookups.TEST_IS_SIMPLE_TYPE,fToTypeNode,null) ) {
			
			problem = createError();
			problem.fill("BPELC_COPY__KEEP_ELEMENT_NAME",
					toString(mNode.nodeName()),
					AT_KEEP_SRC_ELEMENT_NAME,
					"text.term.to",					
					fToTypeNode
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
