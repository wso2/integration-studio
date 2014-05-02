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
import org.eclipse.bpel.validator.model.NodeNameFilter;



/**
 * Validates message exchange 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */


@SuppressWarnings("nls")

public class MessageExchangeValidator extends CValidator {
	
	/** Parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_MESSAGE_EXCHANGES );
	
	
	String ncName ;
	
	
	/**
	 * Start performing link checks.
	 */	
	
	@Override
	protected void start () {
		super.start();		
	
	}
	
	/**
	 * Rule to check the name of the link. 
	 */
	@ARule(
		sa = 0,
		desc = "Check the NCName of the messageExchange",
		author = "michal.chmielewski@oracle.com",
		date = "02/15/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
	)
	
	public void rule_CheckName_1 () {
		
		ncName = getAttribute(mNode, AT_NAME, KIND_NODE, Filters.NC_NAME, true);							
	}
	
	
	
	/** 
	 * End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
