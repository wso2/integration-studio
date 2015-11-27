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

import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.uiextensionmodel.ReferencePartnerLinks;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.requests.CreateRequest;


/**
 * ContainerEditPolicy for the tray categories.
 */
public class TrayContainerEditPolicy extends ContainerEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		CompoundCommand command = new CompoundCommand();
		EditPart host = getHost();
		EObject parent = (EObject) host.getModel();
		EObject child = (EObject) request.getNewObject();
		if (parent instanceof ReferencePartnerLinks) {
			parent = ((ReferencePartnerLinks)parent).getPartnerLinks();
		} 
		command.add(new InsertInContainerCommand(parent, child, null));
		command.add(new SetNameAndDirectEditCommand(child, getHost().getViewer()));
		return command;
	}
}
