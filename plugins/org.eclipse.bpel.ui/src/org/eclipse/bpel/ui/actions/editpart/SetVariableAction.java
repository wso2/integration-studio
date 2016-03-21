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
package org.eclipse.bpel.ui.actions.editpart;

import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.SetVariableCommand;
import org.eclipse.bpel.ui.dialogs.VariableSelectorDialog;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;


/**
 * Action for setting a REQUEST or RESPONSE variable.
 */
public class SetVariableAction extends AbstractAction {

	public static final int REQUEST = 1;
	public static final int RESPONSE = 2;
	
	protected int type;
	
	/**
	 * The type can be REQUEST or RESPONSE.
	 */
	public SetVariableAction(EditPart editPart, int type) {
		super(editPart);
		this.type = type;
	}

	public Image getIconImg() {
		if (type == RESPONSE) {
			return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ACTION_OUTGOING);
		}
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ACTION_INCOMING);
	}

	public ImageDescriptor getIcon() {
		if (type == RESPONSE) {
			return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_OUTGOING);
		}
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_INCOMING);
	}

	public boolean onButtonPressed() {
		Shell shell = viewer.getControl().getShell();
		EObject model = (EObject)editPart.getModel();
		VariableSelectorDialog dialog = new VariableSelectorDialog(shell, model, ModelHelper.getVariableType(model, getDirection()));
		dialog.setTitle(getDialogTitle());
		if (dialog.open() == Window.OK) {
			Variable variable = dialog.getVariable();
			Command command = new SetVariableCommand(model, variable, getDirection());
			viewer.getEditDomain().getCommandStack().execute(command);
		}
		return true;
	}
	
	protected int getDirection() {
		if (modelObject instanceof Invoke) {
			return (type == RESPONSE) ? ModelHelper.INCOMING : ModelHelper.OUTGOING;
		}
		return (type == RESPONSE) ? ModelHelper.OUTGOING : ModelHelper.INCOMING;
	}

	protected String getDialogTitle() {
		if (type == RESPONSE) {
			return Messages.SetVariableAction_Select_Response_Variable_2; 
		}
		return Messages.SetVariableAction_Select_Request_Variable_2; 
	}
	
	public String getToolTip() {
		if (type == RESPONSE) {
			return Messages.SetResponseVarAction_Set_Response_Variable_1; 
		}
		return Messages.SetRequestVarAction_Set_Request_Variable_1; 
	}
	
	@Override
	public ImageDescriptor getDisabledIcon() { return ImageDescriptor.getMissingImageDescriptor(); }
	@Override
	public boolean isEnabled() { return true; }	
}