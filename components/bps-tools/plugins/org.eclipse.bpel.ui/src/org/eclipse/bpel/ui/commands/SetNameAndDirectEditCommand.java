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

import org.eclipse.bpel.common.ui.editmodel.AbstractEditModelCommand;
import org.eclipse.bpel.model.Process;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.requests.DirectEditRequest;


/**
 * Sets a unique name/display name to the model object and triggers direct edit afterwards. 
 */
public class SetNameAndDirectEditCommand extends SetUniqueNameCommand {

	protected EditPartViewer viewer;

	public SetNameAndDirectEditCommand(Object model, EditPartViewer viewer) {
		super((Process)(viewer.getContents()).getModel(), model);
		this.viewer = viewer;
	}
	
	@Override
	public void execute() {
		// we should only do direct edit if we were able to set a name or label
		if (!getCommands().isEmpty()) {
			// direct edit
			add(new AbstractEditModelCommand() {
				@Override
				public void execute() {
					
					// Before calling direct edit the figure and its border have to layout properly
					// in order for the cell editor to appear in the correct location. So we postpone
					// the direct edit using an async call.
					viewer.getControl().getDisplay().asyncExec(new Runnable() {
						public void run() {
							// TODO: HACK HACK: since we used batched adapters to refresh the edit parts,
							// this *only works* because of the asyncExec().
							GraphicalEditPart editPart = (GraphicalEditPart)viewer.getEditPartRegistry().get(model);
							if (editPart != null) {
								editPart.getFigure().getParent().getLayoutManager().invalidate();
								editPart.performRequest(new DirectEditRequest());
							}
						}
					});
				}
				@Override
				public Resource[] getResources() { return EMPTY_RESOURCE_ARRAY; }
				@Override
				public Resource[] getModifiedResources() { return EMPTY_RESOURCE_ARRAY; }
			});
		}

		// execute the contained commands.
		super.execute();
	}
	
	@Override
	public boolean canExecute() {
		if (getCommands().isEmpty()) {
			// it will be a no-op but it is harmless since this command is always
			// together with a command creating a model object
			return true;
		}
		return super.canExecute();
	}
	
	@Override
	public boolean canUndo() {
		if (getCommands().isEmpty()) {
			// it will be a no-op but it is harmless since this command is always
			// together with a command creating a model object
			return true;
		}
		return super.canUndo();
	}
}
