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
 * Subclasses of this command remove a model object from a list in a target model object.
 * 
 * (For example, RemovePropertyCommand is used to remove a Property from the list of properties
 * in a CorrelationSet).
 */
public abstract class RemoveFromListCommand extends AutoUndoCommand {

	protected EObject target;
	protected Object oldElement;

	protected int oldIndex;

	public RemoveFromListCommand(EObject target, String cmdLabel) {
		super(cmdLabel, target);
		this.target = target;
	}

	public RemoveFromListCommand(EObject target, Object oldElement, String cmdLabel) {
		super(cmdLabel, target);
		this.target = target;
		this.oldElement = oldElement;
	}

	/**
	 * Subclasses should override this to return the intended list from target.
	 */
	protected abstract List getList();

	/**
	 * Called before undoing a remove if getList() is empty or null.
	 */
	protected void createList() {	}

	/**
	 * Called after removing an element from the list, if the list is now empty.
	 */
	protected void deleteList() {	}


	@Override
	public boolean canDoExecute() {
		if (oldElement == null) return false;
		if (getList().indexOf(oldElement) < 0) return false;

		return true; // !getList().contains(newElement)
	}

	@Override
	public void doExecute() {
		if (oldElement == null) throw new IllegalStateException();

		List list = getList();
		oldIndex = list.indexOf(oldElement);
		if (oldIndex >= 0)
			list.remove(oldIndex);
		if (list.isEmpty())  deleteList();
	}

	public Object getOldElement() { return oldElement; }
	public void setOldElement(Object object) { oldElement = object; }
}
