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
import org.eclipse.bpel.validator.model.INode;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 7, 2006
 *
 */
public class PartnerLinksValidator extends CContainerValidator {

	/** 
	 * Parent nodes for Variables
	 */
	static public IFilter<INode> PARENTS = Filters.SCOPE_OR_PROCESS;
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CContainerValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {		
		super.checkChildren();
		checkChild(ND_PARTNER_LINK, 1, Integer.MAX_VALUE);	
	}

	
	
	/**
	 * Checks if a child element has a duplicate name
	 *
	 */
	@ARule(
		author = "michal.chmielewski@oracle.com",
		date = "12/7/2006",
		desc = "Checks for duplicate partner link name",
		sa = 18 ,
		errors="BPELC_DUPLICATE_NAME"
	)
	
	public void rule_CheckDuplicateName_40 () {
		checkDuplicateName();		
	}
}
