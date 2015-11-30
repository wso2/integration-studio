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
public class TargetValidator extends CValidator {
	
	/** Parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_TARGETS );
	
	
	String ncName ;


	protected INode fFlowNode;


	protected Set<String> fSet;


	protected Map<String,INode> fTargetMap;


	protected INode fRepeatableConstructNode;


	protected INode fEventHanderNode;	

	
	
	/**
	 * Start performing variable checks.
	 */	
	
	@Override
	protected void start () {
		super.start();		
		ncName = mNode.getAttribute( AT_LINK_NAME );

	}
	
	/**
	 * Rule to check the name of the variable. 
	 */
	
	@ARule(
			date = "9/14/2006",		
			desc = "Check the target variable NCName",
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

		fFlowNode = mSelector.selectParent(mNode, Filters.FLOW);
		
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
		desc = "The value of the linkName attribute of <target> MUST be the name of a <link> declared in an enclosing <flow> activity.",
		author = "michal.chmielewski@oracle.com",
		date = "02/16/2007",
		errors="BPELC_LINK__UNDEFINED"
	)		
	
	public void rule_CheckAgainstDeclaredLink_12 () {
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
		
		fTargetMap = getValue(fFlowNode, FlowValidator.TARGET_MAP,null);
					
		IProblem problem;
		
		if (fTargetMap.containsKey(ncName)) {
			problem = createError();
			problem.fill("BPELC_LINK__NAME_USED",
				toString(mNode.nodeName()),
				ncName
			);			
			return ;
		}
		
		//	targets/target
		fTargetMap.put( ncName, mNode.parentNode().parentNode() );
	}	
	
	
	


	/** 
	 * End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
