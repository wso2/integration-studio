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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.common.ui.editmodel.AbstractEditModelCommand;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;


/**
 * A Command that knows how to capture and restore a selection in the EditPartViewer.
 * 
 * On execute(), this Command remembers the set of model objects whose EditParts are
 * selected in the EditPartViewer.  On undo(), the EditParts representing those model
 * objects are re-selected in the same order.
 * 
 * This is used to restore the user context when a DeleteSelectedAction is undone.
 */
public class RestoreViewerSelectionCommand extends AbstractEditModelCommand {

	EditPartViewer viewer;
	List selectedModelObjects;
	boolean restoreOnUndo, restoreOnRedo;

	public RestoreViewerSelectionCommand(EditPartViewer viewer, boolean restoreOnUndo,
		boolean restoreOnRedo)
	{
		this.viewer = viewer;
		this.restoreOnUndo = restoreOnUndo;
		this.restoreOnRedo = restoreOnRedo;
	}

	// This method may be called directly before execute() is called.  Otherwise,
	// it will be called by execute().
	public void captureSelection() {
		// Remember the model objects whose EditParts are selected in the viewer.
		// (note: the EditParts themselves may be destroyed and re-created)
		selectedModelObjects = new ArrayList();
		for (Iterator it = viewer.getSelectedEditParts().iterator(); it.hasNext(); ) {
			Object modelObject = ((EditPart)it.next()).getModel();
			if (modelObject != null)  selectedModelObjects.add(modelObject);
		}
	}

	@Override
	public void execute() {
		if (selectedModelObjects == null)  captureSelection();
	}
	
	protected void restoreSelection() {
		// Re-select the current EditParts for the formerly selected model objects.
		viewer.deselectAll();
		Map modelObject2EditPart = viewer.getEditPartRegistry();
		for (Iterator it = selectedModelObjects.iterator(); it.hasNext(); ) {
			EditPart editPart = (EditPart)modelObject2EditPart.get(it.next());
			if (editPart != null)  viewer.appendSelection(editPart);
		}
	}

	@Override
	public void undo() { if (restoreOnUndo)  restoreSelection(); }
	@Override
	public void redo() { if (restoreOnRedo)  restoreSelection(); }

	@Override
	public Resource[] getResources() { return EMPTY_RESOURCE_ARRAY; }
	@Override
	public Resource[] getModifiedResources() { return EMPTY_RESOURCE_ARRAY; }
}
