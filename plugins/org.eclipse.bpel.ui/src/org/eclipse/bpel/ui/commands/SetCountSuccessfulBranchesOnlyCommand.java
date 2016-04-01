/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.commands;

import org.eclipse.bpel.model.Branches;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.emf.ecore.EObject;

/**
 * Sets the the countSuccessfulBranchesOnly flag in the completionCondition -
 * Branches element of a forEach activity.
 */
public class SetCountSuccessfulBranchesOnlyCommand extends SetCommand {

	public String getDefaultLabel() {
		return IBPELUIConstants.CMD_SET_SUCCESSFUL_BRANCHES_ONLY;
	}

	public SetCountSuccessfulBranchesOnlyCommand(EObject branches,
			boolean successfulBranchesOnly) {
		super(branches, Boolean.valueOf( successfulBranchesOnly ));
	}

	@Override
	public Object get() {
		return ((Branches) fTarget).isSetCountCompletedBranchesOnly();
	}

	@Override
	public void set(Object o) {
		((Branches) fTarget).setCountCompletedBranchesOnly(((Boolean) o)
				.booleanValue());
	}
}
