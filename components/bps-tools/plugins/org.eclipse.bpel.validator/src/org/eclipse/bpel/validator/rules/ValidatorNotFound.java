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
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.Validator;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 22, 2006
 *
 */

@SuppressWarnings("nls")

public class ValidatorNotFound extends Validator {

	/**
	 * Just announce that we don't have a validator for this node.
	 *
	 */
	
	@ARule(
			author = "michal.chmielewski@oracle.com",
			desc = "Internal error: no validator defined for this element.",
			date = "01/10/2007",
			warnings="BPELC__VALIDATOR_NOT_FOUND"
		)
	public void rule_NoValidatorDefined_1 () {
		IProblem problem = createInfo();
		problem.fill( "BPELC__VALIDATOR_NOT_FOUND",  toString(mNode.nodeName()));
	}
}
