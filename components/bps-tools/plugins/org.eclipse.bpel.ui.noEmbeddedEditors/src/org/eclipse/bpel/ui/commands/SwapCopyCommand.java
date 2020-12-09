/*******************************************************************************
 * Copyright (c) 2008, 2012 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Oleg Danilov, Intel - Initial API and Implementation
 *
 *******************************************************************************/

package org.eclipse.bpel.ui.commands;

import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.emf.common.util.EList;

public class SwapCopyCommand extends SwapInListCommand {

	public SwapCopyCommand(Assign target, int firstElement, int secondElement) {
		super(target, firstElement, secondElement,
				IBPELUIConstants.CMD_SWAP_COPY);
	}

	@Override
	protected EList<Copy> getList() {
		return ((Assign) target).getCopy();
	}

}
