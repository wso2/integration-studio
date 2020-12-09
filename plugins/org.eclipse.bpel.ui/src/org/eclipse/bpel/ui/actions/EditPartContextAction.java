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
package org.eclipse.bpel.ui.actions;

import org.eclipse.bpel.ui.actions.editpart.IEditPartAction;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;


/** 
 * Class used to add context menu actions
 */
public class EditPartContextAction extends SelectionAction {
	
	IEditPartAction action;
	EditPart editPart;

	public EditPartContextAction(IWorkbenchPart part, EditPart editPart, IEditPartAction action) {
		super(part);
		this.action = action;
		this.editPart = editPart;
		
		// get the icon and text
		setText(action.getToolTip());
		setImageDescriptor(action.getIcon());
		setId(action.toString());
	}

	@Override
	protected boolean calculateEnabled() {
		return true;
	}

	@Override
	public void run() {
		action.onButtonPressed();
	}
}
