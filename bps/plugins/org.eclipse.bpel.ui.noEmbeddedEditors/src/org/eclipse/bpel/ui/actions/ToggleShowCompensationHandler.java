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

import java.util.List;

import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.ICompensationHandlerHolder;
import org.eclipse.bpel.ui.editparts.ScopeEditPart;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;


/**
 * Menu action to toggle display of compensation handler activities
 */
public class ToggleShowCompensationHandler extends SelectionAction {
	
	public static final String ACTION_ID = "ToggleShowCompensationHandler"; //$NON-NLS-1$
	
	protected BPELEditor editor;
	
	public ToggleShowCompensationHandler(IWorkbenchPart part) {
		super(part);
		this.editor = (BPELEditor)part;
		setId(ACTION_ID);
		setText(Messages.ToggleShowCompensationHandler_Show_Compensation_Handler_2); 
		setToolTipText(Messages.ToggleShowCompensationHandler_Shows_compensation_handler_activities_3); 
	}

	@Override
	public void run() {
		List selList = getSelectedObjects();
		if (selList.size() == 1) {
			Scope scope = (Scope)selList.get(0);
			ScopeEditPart editPart = (ScopeEditPart)editor.getGraphicalViewer().getEditPartRegistry().get(scope);
			if (editPart != null) {
				boolean state = BPELUtil.getShowCompensationHandler(editPart);
				BPELUtil.setShowCompensationHandler(editPart, !state);
			}
		}
	}

	@Override
	protected boolean calculateEnabled() {
		List selList = getSelectedObjects();
		if (selList.size() != 1)
			return false;
		Object o = selList.get(0);
		if (o instanceof Scope) {
			ICompensationHandlerHolder holder = BPELUtil.adapt(o, ICompensationHandlerHolder.class);
			if (holder != null) {
				if (holder.getCompensationHandler(o) != null)
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean isChecked() {
		List selList = getSelectedObjects();
		if (selList.size() == 1) {
			ScopeEditPart editPart = (ScopeEditPart)editor.getGraphicalViewer().getEditPartRegistry().get(selList.get(0));
			return BPELUtil.getShowCompensationHandler(editPart);
		}
		return false;
	}
}
