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
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.NodeNameFilter;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 7, 2006
 *
 */
@SuppressWarnings("nls")
public class LinksValidator extends CContainerValidator {

	
	
	/** Nodes which can be our parents */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_FLOW );		
	
	
	/**
	 * Checks if a child element has a duplicate name
	 *
	 */
	@ARule(
		author = "michal.chmielewski@oracle.com",
		date = "12/7/2006",
		desc = "Check for unique link name",
		sa = 64 ,
		errors="BPELC_DUPLICATE_NAME"
	)
	
	public void rule_CheckDuplicateLinkName_40 () {
		checkDuplicateName();
	}


	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CContainerValidator#checkChildren()
	 */
	@Override
	public void checkChildren() {
		super.checkChildren();
		checkChild( ND_LINK, 1, Integer.MAX_VALUE);
	}
	
	
	
	
	 
}
