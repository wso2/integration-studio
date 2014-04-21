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
import org.eclipse.bpel.ui.adapters.IFaultHandlerHolder;
import org.eclipse.bpel.ui.editparts.ScopeEditPart;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.IWorkbenchPart;


/**
 * Menu action to toggle display of fault handlers
 * 
 * TODO: Make this work for Invokes
 */
public class ToggleShowFaultHandler extends SelectionAction {

	public static final String ACTION_ID = "ToggleShowFaultHandler"; //$NON-NLS-1$
	
	protected BPELEditor editor;
	
	public ToggleShowFaultHandler(IWorkbenchPart part) {
		super(part);
		this.editor = (BPELEditor)part;
		setId(ACTION_ID);
		setText(Messages.ToggleShowFaultHandler_Show_Fault_Handler_2); 
		setToolTipText(Messages.ToggleShowFaultHandler_Shows_fault_handler_activities_3); 
	}

	@Override
	public void run() {
		List selList = getSelectedObjects();
		if (selList.size() == 1) {
			Scope scope = (Scope)selList.get(0);
			ScopeEditPart editPart = (ScopeEditPart)editor.getGraphicalViewer().getEditPartRegistry().get(scope);
			if (editPart != null) {
				boolean state = BPELUtil.getShowFaultHandler(editPart);
				BPELUtil.setShowFaultHandler(editPart, !state);
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
			IFaultHandlerHolder holder = BPELUtil.adapt(o, IFaultHandlerHolder.class);
			if (holder != null) {
				if (holder.getFaultHandler(o) != null)
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
			return BPELUtil.getShowFaultHandler(editPart);
		}
		return false;
	}
}
