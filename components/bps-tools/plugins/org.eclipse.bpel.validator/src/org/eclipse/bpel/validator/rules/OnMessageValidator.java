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
 * Dependency on the BPEL validation model only in here ...
 */



/**
 * Validate the receive activity.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 25, 2006
 *
 */

@SuppressWarnings("hiding")

public class OnMessageValidator extends ReceiveValidator {
		

	/** The parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_PICK );
	
	/**
	 * 
	 * @see org.eclipse.bpel.validator.model.Validator#start()
	 */
	
	@Override
	protected void start () {		
		super.start();		
	}
	


	/**
	 * @see org.eclipse.bpel.validator.rules.CActivityValidator#rule_CheckName_1()
	 */
	@Override
	public void rule_CheckName_1() {
		// we don't check the name, disable it here.
	}

	/**
	 * @see org.eclipse.bpel.validator.rules.CActivityValidator#rule_CheckSuppressJoinFailure_1()
	 */
	@Override
	public void rule_CheckSuppressJoinFailure_1() {
		// we don't do anything here, disable it on OnMessage
	}
	
	
	/**
	 * Check the presence of fromParts.
	 */
	
	@Override
	@SuppressWarnings("nls")
	
	@ARule(
		sa = 63,
		desc = "Check to see if fromPart is specified; if so then " +
		       " variable must not be used on onMessage.",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__PA_PARTS"
	)	
	public void rule_checkFromPartsPresence_50 () {
		
		// we do this so that the code which generates the completeness tests
		// includes this rule.
		
		super.rule_checkFromPartsPresence_50();
	}	
}
