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

import java.util.Collections;
import java.util.List;

import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.emf.ecore.EObject;

/**
 * Subclasses of this command swap a model objects in a list in a target model
 * object.
 */
public abstract class SwapInListCommand extends AutoUndoCommand {

	protected EObject target;
	private int firstNo;
	private int secondNo;

	public SwapInListCommand(EObject target, int firstElement, int secondElement, String cmdLabel) {
		super(cmdLabel, target);
		this.target = target;
		if (firstElement < secondElement){
			this.firstNo = firstElement;
			this.secondNo = secondElement;
		} else {
			this.firstNo = secondElement;
			this.secondNo = firstElement;
		}
	}

	/**
	 * Subclasses should override this to return the intended list from target.
	 */
	@SuppressWarnings("unchecked")
	protected abstract List getList();

	@SuppressWarnings("unchecked")
	@Override
	public void doExecute() {
		List list = getList();
		if (list == null || list.isEmpty())
			throw new IllegalStateException();
		Object first = list.get(firstNo);
		Object second = list.get(secondNo);
		list.remove(secondNo);
		list.remove(firstNo);
		list.add(firstNo, second);
		list.add(secondNo, first);
	}

}
