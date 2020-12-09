/*
 * Copyright (c) 2010 JBoss, Inc. and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.bpel.validator.rules;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IProblem;

/*
 * This validator handles unknown BPEL elements. Actually not a validator at all, just an error reporter.
 *
 * @see Bugzilla 324165
 * @author Bob Brodt
 * @date Aug 13, 2010
 */
public class UnknownElementValidator extends CValidator {
	
	@Override
	@ARule(
			sa = -1,
			desc = "Check for unknown elements",
			author = "bbrodt@redhat.com",
			date = "08/13/2010",
			errors="BPELC_UNKNOWN__ELEMENT"
		)
	protected void start () {
		super.start();
		
		IProblem problem = createError();

		problem.fill("BPELC_UNKNOWN__ELEMENT",
			toString(mNode.nodeName()),
			mNode.nodeName().getNamespaceURI());
	}
	
	@Override
	public void checkParentNode () {
	}
}
