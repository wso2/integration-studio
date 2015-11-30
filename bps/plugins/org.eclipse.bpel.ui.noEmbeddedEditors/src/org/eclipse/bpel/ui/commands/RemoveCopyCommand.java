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

import org.eclipse.bpel.model.Assign;
import org.eclipse.bpel.model.Copy;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.emf.common.util.EList;


/**
 * Removes a Copy from an Assign activity.
 */
public class RemoveCopyCommand extends RemoveFromListCommand {

	public RemoveCopyCommand(Assign target, Copy oldCopy) {
		super(target, oldCopy, IBPELUIConstants.CMD_DELETE_COPY);
	}

	@Override
	protected EList<Copy> getList() {
		return ((Assign)target).getCopy();
	}
}
