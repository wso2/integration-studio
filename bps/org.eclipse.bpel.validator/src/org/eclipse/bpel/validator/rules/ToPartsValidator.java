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

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 7, 2006
 *
 */

@SuppressWarnings("nls")

public class ToPartsValidator extends CContainerValidator {

	/** Nodes which can be our parents */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_REPLY, ND_INVOKE );
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CContainerValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {		
		super.checkChildren();
		checkChild(ND_TO_PART, 1, Integer.MAX_VALUE);
				
	}

	
	/**
	 * 
	 *
	 */

	@ARule(
		sa = 50,
		desc = "Check to make sure that every to part is used",
		author = "michal.chmielewski@oracle.com",
		date = "03/10/2007",
		tag = "pass2",
		errors="BPELC_PART__MISSING_PART"
	)
	public void rule_CheckEveryPartUsed_10 () {
		INode inputMessageType = getValue(fParentNode,"input.message.type",null);
		
		if (isUndefined(inputMessageType)) {
			return ;
		}
		
		// we do this for invoke only 
		if (ND_INVOKE.equals(fParentNode.nodeName()) == false) {
			return ;
		}
		
		
		IProblem problem ;
		
		List<INode> nodes = mSelector.selectNodes(inputMessageType, WSDL_ND_PART);
		
		for(INode n : nodes) {
			String name = n.getAttribute(AT_NAME);
			if (containsValueKey("part." + name) == false) {
				problem = createError();
				problem.fill("BPELC_PART__MISSING_PART",
						toString(mNode.nodeName()),
						fParentNode.nodeName(),
						ND_TO_PARTS,
						name
				);
			}
		}
		
	}
}
