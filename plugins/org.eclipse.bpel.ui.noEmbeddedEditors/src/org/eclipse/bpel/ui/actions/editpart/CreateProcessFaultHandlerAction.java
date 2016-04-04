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

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.FaultHandler;
import org.eclipse.bpel.model.Process;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.editparts.StartNodeEditPart;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.bpel.ui.uiextensionmodel.StartNode;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;


/**
 * TODO: why is this class needed?  Should it be a subclass of CreateFaultHandlerAction?
 */
public class CreateProcessFaultHandlerAction implements IEditPartAction {
	protected final Object modelObject;
	protected final EditPart editPart;
	protected final EditPartViewer viewer;

	public CreateProcessFaultHandlerAction(EditPart editPart) {
		StartNode startNode = ((StartNodeEditPart)editPart).getStartNode();
		Process process = startNode.getProcess();
		this.modelObject = process;
		this.editPart = editPart;
		this.viewer = editPart.getViewer();
	}

	public Image getIconImg() {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ACTION_FAULTHANDLER);
	}

	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_FAULTHANDLER);
	}

	public boolean onButtonPressed() {
		CompoundCommand command = new CompoundCommand(IBPELUIConstants.CMD_ADD_FAULTHANDLER);
		final FaultHandler faultHandler = BPELFactory.eINSTANCE.createFaultHandler();
		// Create an empty Catch inside it.
		final Catch _catch = (Catch)UIObjectFactoryProvider.getInstance().getFactoryFor(
			BPELPackage.eINSTANCE.getCatch()).createInstance();
		faultHandler.getCatch().add(_catch);
		command.add(new InsertInContainerCommand((EObject)modelObject, faultHandler, null)); 
		command.add(new SetNameAndDirectEditCommand(_catch, viewer));
		ModelHelper.getBPELEditor(modelObject).getCommandStack().execute(command);
		BPELUtil.setShowFaultHandler(editPart, true);
		return true;
	}

	public String getToolTip() {
		return Messages.CreateFaultHandlerAction_Add_Fault_Handler_1; 
	}
	// default implementations for uncommonly-used methods
	public void onMouseEnter(Point location) { }
	public void onMouseExit(Point location) { }
	public void onDispose() { }
	public void onCreate() { }

	
	public ImageDescriptor getDisabledIcon() { return ImageDescriptor.getMissingImageDescriptor(); }
	public boolean isEnabled() { return true; }	
}
