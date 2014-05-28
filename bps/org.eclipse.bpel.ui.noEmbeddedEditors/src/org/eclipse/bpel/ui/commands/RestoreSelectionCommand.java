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
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;


/**
 * A Command that knows how to capture and restore a selection in the EditPartViewer.
 * 
 * NOTE: This won't work with an EditPartViewer or a MultiViewerSelectionProvider.
 * However, it will work with an AdaptingSelectionProvider.
 * 
 * This is used to restore the user context when a DeleteSelectedAction is undone.
 */
public class RestoreSelectionCommand extends AbstractEditModelCommand {

	ISelectionProvider selectionProvider;
	ISelection storedSelection;
	boolean restoreOnUndo, restoreOnRedo;

	public RestoreSelectionCommand(ISelectionProvider selectionProvider, boolean restoreOnUndo,
		boolean restoreOnRedo)
	{
		this.selectionProvider = selectionProvider;
		this.restoreOnUndo = restoreOnUndo;
		this.restoreOnRedo = restoreOnRedo;
	}

	// This method may be called directly before execute() is called.  Otherwise,
	// it will be called by execute().
	public void captureSelection() {
		storedSelection = selectionProvider.getSelection();
	}

	@Override
	public void execute() {
		if (storedSelection == null)  captureSelection();
	}
	
	protected void restoreSelection() {
		selectionProvider.setSelection(storedSelection);
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
