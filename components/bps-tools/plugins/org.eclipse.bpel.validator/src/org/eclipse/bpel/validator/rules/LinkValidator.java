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

public class LinkValidator extends CValidator {
	
	/** Parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_LINKS );
	
	
	String ncName ;


	protected INode fFlowNode;


	protected Set<String> fSet;	

	protected Map<String,INode> fSourceMap;
	
	protected Map<String,INode> fTargetMap;


	protected INode fSourceNode;

	protected INode fTargetNode;
	
	
	
	/**
	 * Start performing link checks.
	 */	
	
	@Override
	protected void start () {
		super.start();		
		ncName = mNode.getAttribute( AT_NAME );
		
		fFlowNode = mSelector.selectParent(mNode, Filters.FLOW);
		
	}
	
	/**
	 * Rule to check the name of the link. 
	 */
	@ARule(
		sa = 0,
		desc = "Check the NCName of the link",
		author = "michal.chmielewski@oracle.com",
		date = "02/15/2007",
		errors="BPELC__UNSET_ATTRIBUTE,General.NCName_Bad"
	)
	
	public void rule_CheckName_1 () {
		
		// Must be a valid NCName ...		
		if (checkNCName(mNode, ncName, AT_NAME ) == false) {
			disableRules();
		}
			
		fSet = getValue (fFlowNode, FlowValidator.LINKS_SET , null);
		if (fSet != null) {
			fSet.add ( ncName );
		}			
		
	}
	
	
	 
	/**
	 * Checks the link connections to source and target.
	 * 
	 */
	
	
	@ARule(
		sa = 66,
		desc = "Every link must have exactly one activity as source and one as target",
		author = "michal.chmielewski@oracle.com",
		date = "02/17/2007",
		tag = "pass2",
		order = 10 ,
		errors="BPELC_LINK__NO_SOURCE,BPELC_LINK__NO_TARGET"
	)
	
	public void rule_CheckLinkConnections_10 () {
		IProblem problem;
		
		fSourceMap = getValue(fFlowNode,FlowValidator.SOURCE_MAP,null);
		
		if (fSourceMap != null) {
			
			if (fSourceMap.containsKey(ncName) == false) {
				problem = createError();
				problem.fill("BPELC_LINK__NO_SOURCE",
						toString(mNode.nodeName()),
						ncName);
			}
			fSourceNode = fSourceMap.get(ncName);
		}
		
		
		fTargetMap = getValue (fFlowNode,FlowValidator.TARGET_MAP,null);
		if (fTargetMap != null) {
			if (fTargetMap.containsKey(ncName) == false) {
				problem = createError();
				problem.fill("BPELC_LINK__NO_TARGET",
						toString(mNode.nodeName()),
						ncName);
			}
			
			fTargetNode = fTargetMap.get(ncName);
		}
	}
	
	
	 
	/**
	 * Checks the link connections to source and target.
	 * 
	 */
	
	
	@ARule(
		sa = 67,
		desc = "Two different links MUST NOT share the same source *and* target activities; "
			   + " that is, at most one link may be used to connect two activities.",
		author = "michal.chmielewski@oracle.com",
		date = "02/17/2007",
		tag = "pass2",
		order = 12 ,
		errors="BPELC_LINK__NOT_UNIQUE"
	)
	
	public void rule_CheckDistinctLinks_12 () {
		IProblem problem;
		
		if (fSourceMap == null || fTargetMap == null || fSourceNode == null || fTargetNode == null ) {
			return ;
		}				
		
		for(String linkName : fSet) {
			
			// skip ourselves.
			if (linkName.equals(ncName)) {
				continue;
			}
			
			INode linkTarget = fTargetMap.get(linkName);
			INode linkSource = fSourceMap.get(linkName);
			
			if (mModelQuery.check(IModelQueryLookups.TEST_EQUAL, linkTarget, fTargetNode) &&
				mModelQuery.check(IModelQueryLookups.TEST_EQUAL, linkSource, fSourceNode)) {
			
				problem = createError();
				problem.fill("BPELC_LINK__NOT_UNIQUE",
						toString(mNode.nodeName()),
						ncName,
						linkName);				
			}			
		}
	}
	
	
	
	/**
	 * Check for target before the source ... 
	 */
	
	@ARule(
		sa = 72,
		desc = "A <link> declared in a <flow> MUST NOT create a control cycle, "
			 + " that is, the source activity must not " 
			 + " have the target activity as a logically preceding activity.",			 
		author = "michal.chmielewski@oracle.com",
		date = "02/17/2007",
		tag = "pass2",
		order = 14 ,
		errors="BPELC_LINK__CYCLE"
	)
		
	public void rule_ControlCycle_14 () {
		IProblem problem;
		
		if (fSourceNode == null || fTargetNode == null ) {
			return ;
		}
		
		
		// check if we can get from target to source node ...
		
	
		INode linkTarget = null;
		INode linkSource = null;
		
		if (mModelQuery.check(IModelQueryLookups.TEST_EQUAL, linkTarget, fTargetNode) &&
			mModelQuery.check(IModelQueryLookups.TEST_EQUAL, linkSource, fSourceNode)) {
		
			problem = createError();
			problem.fill("BPELC_LINK__CYCLE",
					toString(mNode.nodeName()),
					ncName,
					fSourceNode.nodeName(),
					fTargetNode.nodeName()
					);				
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
