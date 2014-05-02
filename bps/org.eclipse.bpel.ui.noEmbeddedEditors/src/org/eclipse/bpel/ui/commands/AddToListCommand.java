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
 * Subclasses of this command add a model object to a list in a target model object.
 * 
 * (For example, AddPropertyCommand is used to add a Property to the list of properties
 * in a CorrelationSet).
 */
public abstract class AddToListCommand extends AutoUndoCommand {

	protected EObject target;
	protected Object newElement;

	public AddToListCommand(EObject target, Object newElement, String cmdLabel) {
		super(cmdLabel, target);
		this.target = target;
		this.newElement = newElement;
	}

	public AddToListCommand(EObject target, String cmdLabel) {
		super(cmdLabel, target);
		this.target = target;
	}

	/**
	 * Called before adding to the list, if getList() returns null or if it returns an empty list.
	 */
	protected void createList() {	}

	/**
	 * Called when undoing the add results in an empty list.
	 */
	protected void deleteList() {	}

	/**
	 * Subclasses should override this to return the intended list from target.
	 */
	protected abstract List getList();


	@Override
	public void doExecute() {
		if (newElement == null) throw new IllegalStateException();

		List list = getList();
		if (list == null || list.isEmpty()) {
			createList();
			list = getList();
		}
		list.add(newElement);
	}

	public Object getNewElement() { return newElement; }
	public void setNewElement(Object object) { newElement = object; }

}
