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
import org.eclipse.bpel.model.Catch;
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


/**
 * CreateCatchAction
 * 
 * @author IBM Original contribution.  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 */

public class CreateCatchAction extends AbstractAction {

	/**
	 * Create a brand new CreateCatchAction object.
	 * 
	 * @param anEditPart the edit part to create the action on.
	 */
	public CreateCatchAction(EditPart anEditPart) {
		super(anEditPart);
	}

	/**
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#getIcon()
	 */
	public ImageDescriptor getIcon() {
		return BPELUIPlugin.INSTANCE.getImageDescriptor(IBPELUIConstants.ICON_ACTION_CATCH);
	}


	/**
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#onButtonPressed()
	 */
	public boolean onButtonPressed() {
		CompoundCommand command = new CompoundCommand();
		final Catch child = (Catch)UIObjectFactoryProvider.getInstance().getFactoryFor(
				BPELPackage.eINSTANCE.getCatch()).createInstance();
		command.add(new InsertInContainerCommand((EObject)modelObject, child, null));
		command.add(new SetNameAndDirectEditCommand(child, viewer));

		BPELEditor bpelEditor = ModelHelper.getBPELEditor(modelObject);
		bpelEditor.getCommandStack().execute(command);
		return true;
	}

	/**
	 * @see org.eclipse.bpel.ui.actions.editpart.IEditPartAction#getToolTip()
	 */
	public String getToolTip() {
		return Messages.CreateCatchAction_Add_Catch_1; 
	}
}