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

import java.util.Map;
import java.util.Set;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;



/**
 * Validates variable related rules.
 * <p>
 * When thinking 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */

@SuppressWarnings("nls")

public class SourceValidator extends CValidator {
	
	/** Parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_SOURCES );
	
	
	String ncName ;	

	INode fFlowNode;


	protected Set<String> fSet;

	protected Map<String,INode> fSourceMap;


	protected INode fRepeatableConstructNode;


	protected INode fFaultHandlerNode;


	protected INode fActivityNode;


	protected Map<String,INode> fTargetMap;


	protected INode fTargetActivity;
	
	
	/**
	 * Start performing checks.
	 */	
	
	@Override
	protected void start () {
		super.start();		
		ncName = mNode.getAttribute( AT_LINK_NAME );
		
		// activity/sources/source
		fActivityNode = fParentNode.parentNode();
	}
	
	
	/**
	 * Rule to check the name of the variable. 
	 */
	
	@ARule(
			date = "9/14/2006",		
			desc = "Check the source variable NCName",
			author = "michal.chmielewski@oracle.com",
			errors="BPELC__UNSET_ATTRIBUTE,General.NCName_Bad"
		)	
	public void rule_CheckName_1 () {					
		// Must be a valid NCName ...
		checkNCName(mNode, ncName, AT_LINK_NAME );			
	}
	
	
	/**
	 * 
	 */
	@ARule(
		sa = 1200,
		desc = "Check if we are within a flow, if not disable rest of rules",
		author = "michal.chmielewski@oracle.com",
		date = "02/17/2007"
	)
	public void rule_CheckIfInFlow_2 () {
		
		fFlowNode = mSelector.selectParent(fActivityNode, Filters.FLOW );
		if (isUndefined(fFlowNode) ) {
			
			disableRules(10,1000);
			return ;
		} 	
		fSet = getValue(fFlowNode, FlowValidator.LINKS_SET,null);
	}
	
	
	/**
	 * 
	 */
	
	@ARule(
		sa = 65,
		desc = "The value of the linkName attribute of <source> MUST be the name of a <link> declared in an enclosing <flow> activity.",
		author = "michal.chmielewski@oracle.com",
		date = "02/16/2007",
		errors="BPELC_LINK__UNDEFINED"
	)		
	
	public void rule_CheckAgainstDeclaredLink_11 () {
		if (fSet == null) {
			return ;
		}
		
		IProblem problem;
		
		if (fSet.contains(ncName) == false) {
			problem = createError();
			problem.fill("BPELC_LINK__UNDEFINED", 
					toString(mNode.nodeName()),
					ncName
			);
		}				
	}
	
	
	/**
	 * Check if source already used.
	 */
	
	@ARule(
		sa = 66,
		desc = "Every link must have exactly one activity as source and one as target",
		author = "michal.chmielewski@oracle.com",
		date = "02/17/2007",
		errors="BPELC_LINK__NAME_USED"
	)
	public void rule_CheckIfSourceAlreadyUsed_12 () {
		fSourceMap = getValue(fFlowNode, FlowValidator.SOURCE_MAP,null);
		
		IProblem problem;
		
		if (fSourceMap.containsKey(ncName)) {
			problem = createError();
			problem.fill("BPELC_LINK__NAME_USED",
				toString(mNode.nodeName()),
				ncName
			);
			
			return ;
		}
		
		// activity/sources/source
		fSourceMap.put( ncName, fActivityNode );
	}
	
	

	/**
	 * Cross of repeatable constructs.
	 */
	
	@ARule(
		sa = 70,
		desc = "Link must not cross repeatable constructs",
		author = "michal.chmielewski@oracle.com",
		date = "02/17/2007",
		errors="BPELC_LINK__CROSS_REPEATABLE"
	)
	
	public void rule_CheckRepeatableConstruct_15 () {

		// activity / sources / source
		
		fRepeatableConstructNode = mSelector.selectParent(
				fActivityNode.parentNode(), 
				Filters.REPEATABLE_CONSTRUCT);
	
		// if not there, then we are done
		if (isUndefined(fRepeatableConstructNode)) {
			return ;
		}
		
		// otherwise check if 
		// fFlowNode is a ancestor of fRepeatableNode
		INode aFlowNode = mSelector.selectParent(fRepeatableConstructNode, 
			new IFilter<INode>() {
				public boolean select(INode node) {
					return node.equals(fFlowNode);
				}			
			}
		);
		
		IProblem problem;
		
		if (mModelQuery.check(IModelQueryLookups.TEST_EQUAL, aFlowNode, fFlowNode)) {
			
			problem = createError();
			problem.fill("BPELC_LINK__CROSS_REPEATABLE",
					toString(mNode.nodeName()),
					ncName,
					toString(fRepeatableConstructNode.nodeName()),
					fRepeatableConstructNode.getAttribute(AT_NAME)
			);			
		}		
		
	}
	
	

	/**
	 * Cross of event handler boundary. We run this rule at the end, to make sure 
	 * that all the links had been resolved during pass 1.
	 */
	
	
	@ARule(
		sa = 71,
		desc = "Check for links crossing event handlers boundaries",
		author = "michal.chmielewski@oracle.com",
		date = "02/17/2007",
		tag = "pass2",
		errors="BPELC_LINK__OUTBOUND_ONLY"
	)
	
	public void rule_CheckEventHandlersBoundary_20 () {

		// activity / sources / source
		
		// see if we are crossing an fault handler boundary
		fFaultHandlerNode = mSelector.selectParent(
				fActivityNode.parentNode(), 
				Filters.FAULT_HANDLER_BOUNDARY );
	
		
		// if not there, then we are done
		if (isUndefined(fFaultHandlerNode)) {
			return ;
		}
		
		// Lookup the target map, so that we can find out what the target 
		// of this link is.
		fTargetMap = getValue(fFlowNode, FlowValidator.TARGET_MAP, null);
		
		// Get the target activity ...
		fTargetActivity = fTargetMap.get(ncName);
		
		// if not there, we are out
		if (isUndefined(fTargetActivity)) {
			return ;
		}
		
		// make sure that the target activity is outside the scope 
		// containing the event handler.
		INode scope = mSelector.selectParent(fFaultHandlerNode, Filters.SCOPE);
		
		if (isUndefined(scope)) {
			// problem !
			return ;
		}
		
		// walk up from the target activity, if we hit the scope then bad.
		// we must be outside the scope.
		
		INode target = fTargetActivity;
		while (target != null) {
			
			if (mModelQuery.check(IModelQueryLookups.TEST_EQUAL, target, scope)) {
				
				// problem
				
				IProblem problem = createError();
				problem.fill("BPELC_LINK__OUTBOUND_ONLY",
						toString(mNode.nodeName()),
						ncName,
						toString(fFaultHandlerNode.nodeName()) 
					);

				break;
			}
			
			target = target.parentNode();
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
