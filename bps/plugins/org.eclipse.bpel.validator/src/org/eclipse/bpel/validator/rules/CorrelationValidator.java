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


import java.util.List;

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.NodeNameFilter;



/**
 * Validates variable related rules.
 * <p>
 * When thinking 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */

@SuppressWarnings({"nls","boxing"})

public class CorrelationValidator extends CValidator {
	
	/** Parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter(  ND_CORRELATIONS  );
	
	
	protected String fSetName ;
	
	protected String fInitiate;


	protected String fPattern;


	protected INode fActivityNode;


	protected INode fCorrelationSet;
	
	
	/**
	 * Start performing variable checks.
	 */	
	
	@Override
	protected void start () {
		super.start();				
		fActivityNode = fParentNode.parentNode();
		
	}
	
	/**
	 * Check the NCName of the correlation set.
	 */
	@ARule(
		sa = 0,
		desc = "Check the NCName of the correlation",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
	)
	public void rule_CheckName_1 () {
		fSetName = getAttribute(mNode, AT_SET, KIND_NODE, Filters.NC_NAME, true);				
	}
	
	/**
	 * 
	 */
	@ARule(
		sa = 1010,
		desc = "Check the initiate attribute values",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
	)
	
	
	public void rule_CheckInitiate_2 () {
		
		fInitiate = getAttribute(mNode, 
				AT_INITIATE, 
				KIND_NODE, 
				Filters.INITIATE_FILTER, 
				false);
		
		if (isEmpty(fInitiate)) {
			fInitiate = NO;
		}
	}

	/**
	 * 
	 */

	@ARule(
		sa = 46,
		desc = "Check the pattern attribute values of correlation",
		author = "michal.chmielewski@oracle.com",
		date = "02/20/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__SET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
	)	
	
	public void rule_CheckPatternValues_5 () {
		
		fPattern = getAttribute(mNode, 
				AT_PATTERN, 
				KIND_NODE, 
				Filters.PATTERN_FILTER, 
				false);
		
		
		if (isEmpty(fPattern)) {
			fPattern = null;
		}					
		
	
		IProblem problem;
		
		boolean is2Way = getValue(fActivityNode,"2way",false);
		
		// invoke		
		if (ND_INVOKE.equals(fActivityNode.nodeName())) {
			
			if (is2Way && isEmpty(fPattern)) {
				problem = createError();
				problem.fill("BPELC__UNSET_ATTRIBUTE",
						toString(mNode.nodeName()),
						AT_PATTERN,						
						KIND_NODE );
			}
			
			if (is2Way == false && isEmpty(fPattern) == false) {
				problem = createError();
				problem.fill("BPELC__SET_ATTRIBUTE",
						AT_PATTERN,
						toString(mNode.nodeName()),
						KIND_NODE );					
			}			
			
		} else {
			
			if (isEmpty(fPattern) == false) {
				problem = createError();
				problem.fill("BPELC__SET_ATTRIBUTE",
						AT_PATTERN,
						toString(mNode.nodeName()),
						KIND_NODE );
			}
		}
	}

	/**
	 * Check if the correlation already exists.
	 *
	 */
	
	@ARule(
		sa = 0,
		desc = "Check to see if the correlation is already specified",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC_CORRELATION__EXIST"
	)
	public void rule_CheckDuplicateCorrelation_10 () {
		if (fSetName == null) {
			return ;
		}
		String key = "set." + fSetName;
		
		// 		
		if (containsValueKey(fParentNode,key)) {
			IProblem problem = createError();
			problem.fill("BPELC_CORRELATION__EXIST", 
					toString(mNode.nodeName()),
					fSetName);
			return ;
		}
		
		setValue(fParentNode,key, Boolean.TRUE);				
	}
	
	/**
	 * Check the existence of the correlation set
	 */
	
	@ARule(
			sa = 0,
			desc = "Check to see if the correlation set exists",
			author = "michal.chmielewski@oracle.com",
			date = "01/20/2007",
			errors="BPELC_CORRELATION__EXIST,BPELC__UNRESOLVED_ATTRIBUTE"
		)
	public void rule_ExistCorrelationSet_12 () {
		if (isEmpty(fSetName) || ND_ON_EVENT.equals(fActivityNode.nodeName() )) {
			return ;
		}
		
		fCorrelationSet = mModelQuery.lookup(mNode, IModelQueryLookups.LOOKUP_NODE_CORRELLETION_SET, fSetName);
				
		if (checkAttributeNode(mNode, fCorrelationSet, AT_SET, KIND_NODE) == false) {
			return ;
		}
		
		// otherwise, the correlationSet is available 				
		List<INode> sets = getValue(fActivityNode, "correlation.sets", null );		
		if (sets != null) {
			sets.add(fCorrelationSet);
		}
	}
	
	/**
	 * For <onEvent>, the resolution order of the correlation set(s) referenced
	 * by <correlation> MUST be first the associated scope and then the ancestor
	 * scopes.
	 */
	
	@ARule(
		sa = 88,
		desc = "Correlation set lookup, first associated scope, then ancestor scopes",
		author = "michal.chmielewski@oracle.com",
		date = "03/15/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE"
	)
	
	public void rule_ExistCorrelationSet_13 () {
		
		if (isEmpty(fSetName) || ND_ON_EVENT.equals(fActivityNode.nodeName()) == false) {
			return ;
		}		
		
		
		INode associatedScope = getValue(fActivityNode,"associated.scope",mNode);
		
		fCorrelationSet = mModelQuery.lookup(associatedScope, IModelQueryLookups.LOOKUP_NODE_CORRELLETION_SET, fSetName);
		
		markSAExecution(null);
		
		if (checkAttributeNode(mNode, fCorrelationSet, AT_SET, KIND_NODE) == false) {
			return ;
		}
		
		// otherwise, the correlationSet is available 				
		List<INode> sets = getValue(fActivityNode, "correlation.sets", null );		
		if (sets != null) {
			sets.add(fCorrelationSet);
		}
	}
		
	
	/** 
	 * End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
