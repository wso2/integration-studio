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
import java.util.HashMap;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 7, 2006
 *
 */

@SuppressWarnings("nls")
public class TargetsValidator extends CContainerValidator {

	/** Nodes which can be our parents */
	static public IFilter<INode> PARENTS = Filters.ACTIVITIES ;
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CContainerValidator#getFilter()
	 */
	

	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CContainerValidator#checkChildren()
	 */
	@Override
	public void checkChildren() {
		super.checkChildren();
		checkChild( ND_JOIN_CONDITION, 0,1 );
		checkChild( ND_TARGET,1, Integer.MAX_VALUE);
	}
	
	
	
	/**
	 * 
	 */
	
	@ARule(
		sa = 69,
		desc = "<target> elements must have distinct linkNames",
		author = "michal.chmielewski@oracle.com",
		date = "02/16/2007",
		errors="BPELC_DUPLICATE_NAME"
	)
	
	public void rule_CheckUniqueTargetName_10 () {
			
		HashMap<String,INode> map = new HashMap<String,INode>();
		
		List<INode> children = mSelector.selectNodes(mNode, ND_TARGET );
		
		for(INode next : children ) {			
			String name = next.getAttribute(AT_LINK_NAME);
			INode present = map.get(next.getAttribute(AT_LINK_NAME) );
			if (present == null) {
				map.put(name,next);
			} else {
				IProblem problem = createError( next );
				problem.setAttribute(IProblem.CONTEXT, AT_LINK_NAME);
				problem.fill( "BPELC_DUPLICATE_NAME",
						toString(mNode.nodeName()), 
						toString( next.nodeName() ),  
						name); 
			}			
		}		
		map.clear();
	}	
}
