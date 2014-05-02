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

import java.util.List;

import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.emf.ecore.EObject;


/**
 * Subclasses of this command insert a model object to a list in a target model object.
 */
public abstract class InsertToListCommand extends AutoUndoCommand {

	protected EObject target;
	protected EObject newElement;
	protected int pos;

	public InsertToListCommand(EObject target, EObject newElement, int pos, String cmdLabel) {
		super(cmdLabel, target);
		this.target = target;
		this.newElement = newElement;
		this.pos = pos;
	}

	/**
	 * Subclasses should override this to return the intended list from target.
	 */
	protected abstract List getList();

	@Override
	public void doExecute() {
		if (newElement == null) throw new IllegalStateException();
		List list = getList();
		if (list == null) throw new IllegalStateException();
		list.add(pos, newElement);
	}

}
