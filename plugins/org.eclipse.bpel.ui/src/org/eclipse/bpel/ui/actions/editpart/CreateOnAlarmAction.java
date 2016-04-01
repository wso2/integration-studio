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

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;


public class CreateOnAlarmAction extends AbstractAction {

	public CreateOnAlarmAction(EditPart editPart) {
		super(editPart);
	}

	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_ONALARM);
	}

	public Image getIconImg() {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ACTION_ONALARM);
	}

	public boolean onButtonPressed() {
		CompoundCommand command = new CompoundCommand();
		EObject child = UIObjectFactoryProvider.getInstance().getFactoryFor(
			BPELPackage.eINSTANCE.getOnAlarm()).createInstance(); 
		command.add(new InsertInContainerCommand((EObject)modelObject, child, null));
		command.add(new SetNameAndDirectEditCommand(child, viewer));
		BPELEditor bpelEditor = ModelHelper.getBPELEditor(modelObject);
		bpelEditor.getCommandStack().execute(command);
		return true;
	}

	public String getToolTip() {
		return Messages.CreateOnAlarmAction_Add_OnAlarm_1; 
	}
	
	@Override
	public ImageDescriptor getDisabledIcon() { return ImageDescriptor.getMissingImageDescriptor(); }
	@Override
	public boolean isEnabled() { return true; }	
}