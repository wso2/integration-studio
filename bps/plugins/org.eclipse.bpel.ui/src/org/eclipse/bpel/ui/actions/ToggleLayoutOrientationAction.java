/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.actions;

import java.util.List;

import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.bpel.ui.editparts.ProcessEditPart;
import org.eclipse.bpel.ui.figures.ILayoutAware;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;

public class ToggleLayoutOrientationAction extends SelectionAction {
	
	public final static String ACTION_ID = "ToggleLayoutOrientationAction"; //$NON-NLS-1$

	public ToggleLayoutOrientationAction(IWorkbenchPart part) {
		super(part);
		setId(ACTION_ID);
		setText(getText()); 
	}
	
	@Override
	public void run() {
		BPELEditor editor = (BPELEditor)getWorkbenchPart();
		editor.setHorizontalLayout(!editor.isHorizontalLayout());
		
		// Get the processEditPart 
		ProcessEditPart process = (ProcessEditPart)editor.getGraphicalViewer().getEditPartRegistry().get(editor.getProcess());
		
		doSwitchOrientation(process, editor.isHorizontalLayout());
		
		setText(getText());

		editor.refreshGraphicalViewer();
	}
	
	private void doSwitchOrientation(BPELEditPart part, boolean horizontal){
		List<BPELEditPart> children = part.getChildren();
		for(BPELEditPart child : children){
			doSwitchOrientation(child, horizontal);
		}
		if(part instanceof ILayoutAware){
			((ILayoutAware)part).switchLayout(horizontal);
		}
		
	}
	
	@Override
	protected boolean calculateEnabled() {
		List sel = getSelectedObjects();
		return sel.size() > 0 && sel.get(0) instanceof org.eclipse.bpel.model.Process; 
	}
	
	@Override
	public String getText() {
		BPELEditor editor = (BPELEditor)getWorkbenchPart();
		if(editor.isHorizontalLayout())
			return Messages.ToggleLayoutOrientation_2;
		else
			return Messages.ToggleLayoutOrientation_1;
	}
}
