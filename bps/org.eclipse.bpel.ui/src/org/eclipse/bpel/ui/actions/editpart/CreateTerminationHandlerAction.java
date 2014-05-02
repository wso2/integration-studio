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
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.factories.UIObjectFactoryProvider;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;


/**
 * @IBM Original contribution
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 *
 */
public class CreateTerminationHandlerAction extends AbstractAction {

	/**
	 * Brand new CreateTerminationHandlerAction action.
	 * @param anEditPart
	 */
	public CreateTerminationHandlerAction(EditPart anEditPart) {
		super(anEditPart);
	}


	/**
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#getIcon()
	 */
	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_TERMINATIONHANDLER);
	}

	/**
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#onButtonPressed()
	 */
	public boolean onButtonPressed() {
		CompoundCommand command = new CompoundCommand(IBPELUIConstants.CMD_ADD_TERMINATIONHANDLER);
		final EObject child = UIObjectFactoryProvider.getInstance().getFactoryFor(
				BPELPackage.eINSTANCE.getTerminationHandler()).createInstance();
		
		command.add(new InsertInContainerCommand((EObject)modelObject, child, null));
		command.add(new SetNameAndDirectEditCommand(child, viewer));
		ModelHelper.getBPELEditor(modelObject).getCommandStack().execute(command);
		BPELUtil.setShowTerminationHandler(editPart, true);
		return true;
	}

	/**
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#getToolTip()
	 */
	public String getToolTip() {
		return Messages.CreateTerminationHandlerAction_Add_Termination_Handler_1;
	}

	
	
}
