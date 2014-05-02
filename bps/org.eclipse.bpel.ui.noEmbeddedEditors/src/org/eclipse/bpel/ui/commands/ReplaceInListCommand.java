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

import java.util.List;

import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.emf.ecore.EObject;


/**
 * Subclasses of this command replace a model object in a list with a different model object.
 * 
 * (For example, ReplacePropertyCommand is used to replace one of the properties in a
 * CorrelationSet with a different property).
 */
public abstract class ReplaceInListCommand extends AutoUndoCommand {

	protected EObject target;
	protected Object oldElement, newElement;
	protected int index;

	public ReplaceInListCommand(EObject target, Object oldElement, Object newElement, String cmdLabel) {
		super(cmdLabel, target);
		this.target = target;
		this.oldElement = oldElement;
		this.newElement = newElement;
	}

	/**
	 * Subclasses should override this to return the intended list.
	 */
	protected abstract List getList();

	@Override
	public boolean canDoExecute() {
		return true;  // !getList().contains(newElement)
	}

	@Override
	public void doExecute() {
		index = getList().indexOf(oldElement);
		getList().set(index, newElement);
	}
}
