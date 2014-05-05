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

import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;


/**
 * Menu item action for auto flow layout mode
 */
public class ToggleAutoFlowLayout extends SelectionAction {

	public static final String ACTION_ID = "ToggleAutoFlowLayout"; //$NON-NLS-1$
	
	public ToggleAutoFlowLayout(IWorkbenchPart part) {
		super(part);
		setId(ACTION_ID);
		setText(Messages.ToggleAutoFlowLayout_Align_Flow_Contents_Automatically_2); 
		setToolTipText(Messages.ToggleAutoFlowLayout_Align_activities_in_Flows_automatically_3); 
	}

	@Override
	public void run() {
		BPELEditor editor = (BPELEditor)getWorkbenchPart();
		editor.setAutoFlowLayout(!editor.getAutoFlowLayout());
		editor.refreshGraphicalViewer();
	}

	@Override
	protected boolean calculateEnabled() {
		return true;
	}

	@Override
	public boolean isChecked() {
		return ((BPELEditor)getWorkbenchPart()).getAutoFlowLayout();
	}
}
