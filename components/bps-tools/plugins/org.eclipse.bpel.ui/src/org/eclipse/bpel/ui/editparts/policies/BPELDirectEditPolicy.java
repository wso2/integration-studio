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
package org.eclipse.bpel.ui.editparts.policies;

import org.eclipse.bpel.common.ui.tray.TrayEditPart;
import org.eclipse.bpel.ui.commands.SetNameCommand;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.jface.viewers.CellEditor;


/**
 * @author IBM 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 16, 2007
 */


public class BPELDirectEditPolicy extends DirectEditPolicy {
	
	@Override
	protected Command getDirectEditCommand(DirectEditRequest edit) {		
		Command cmd = null;
		CellEditor editor = edit.getCellEditor();
		if (editor == null) {
			return cmd;
		}
		
		// Only allow return the command if the label is non-empty.
		
		String labelText = (String) editor.getValue();
		if (labelText != null) {
			labelText = labelText.trim();
			if (labelText.length() > 0 && labelText.length() < 128 ) {
				cmd = getFinalizeCommand(getHost().getModel(), labelText);
			}
		}
		
		return cmd;
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		if (getHost() instanceof BPELEditPart) {
			BPELEditPart part = (BPELEditPart) getHost();
			part.getLabelFigure().setText(value);
		} else if (getHost() instanceof TrayEditPart) {
			TrayEditPart part = (TrayEditPart) getHost();
			part.getDirectEditLabel().setText(value);
		}
		//hack to prevent async layout from placing the cell editor twice.
		getHostFigure().getUpdateManager().performUpdate();
	}

	/**
	 * 
	 * @param model
	 * @param name
	 * @return the command to finalize the edit
	 */
	static public Command getFinalizeCommand(Object model, String name) {
		
		Command command = null;
		
		// JM - btw, is this a bug? missing supports uiextensionmodel
		/*if (ModelHelper.supportsUIExtension etc.) {
			command = new SetDisplayNameCommand((EObject)model, name);
		} else {*/
			command = new SetNameCommand((EObject)model, name);
		//}
			
		if (command.canExecute()) {
			return command;
		}
		
		return null;
	}
}
