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
import org.eclipse.bpel.ui.editparts.util.ReferencedAddRequest;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.requests.CreateRequest;


/**
 * this edit policy encapsulates some of the container operations that we
 * want to do with containers in general. Normally, with the viewer we do everything
 * with the layout edit policy, but there are instances that we will
 * do things through context menus and manipulate the process model directly
 * This is especially important because we want to have actions that are 
 * accessible (usually keyboard shortcuts). This edit policy provides a means
 * of doing such actions through a programmatic manner instead of mouse interaction
 * 
 * TODO: refactor this class
 */
public class BPELContainerEditPolicy extends ContainerEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		return null;		
	}
	
	@Override
	public Command getCommand(Request request) {		
		if (ReferencedAddRequest.typeString.equals(request.getType())) {
			// TODO: this is for AppendNewAction, etc.
			return getReferencedAddCommand((ReferencedAddRequest)request);
		} else if (REQ_CLONE.equals(request.getType())) {
			System.out.println("Clone Request!!");
		}
		return super.getCommand(request);
	}

	private Command getReferencedAddCommand(ReferencedAddRequest request) {
		Object before = request.getReferencedObject();
		return createCreateCommand((EObject) getHost().getModel(), (EObject) request.getNewObject(), (EObject) before);		
	}
		
	protected Command createCreateCommand(EObject parent, final EObject child, EObject beforeObject) {
		CompoundCommand command = new CompoundCommand();
		command.add(new InsertInContainerCommand(parent, child, beforeObject));
		command.add(new SetNameAndDirectEditCommand(child, getHost().getViewer()));
		return command;
	}
}
