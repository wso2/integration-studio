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

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetConstraintCommand;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;


/**
 * Specific edit policy implementation for Flows 
 */
public class FlowXYLayoutEditPolicy extends BPELXYLayoutEditPolicy {

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		CompoundCommand command = new CompoundCommand();
		final Activity child = (Activity)request.getNewObject();
		command.add(createCreateCommand((EObject)getHost().getModel(), child));

		if (request.getLocation() != null) {
			Rectangle constraint = (Rectangle)getConstraintFor(request);
			command.add(new SetConstraintCommand(child, constraint.getLocation(), constraint.getSize()));
		}
		// TODO: the setLabel is suspicious.  What is this?
		command.setLabel(Messages.FlowXYLayoutEditPolicy_Create_1); 
		return command;
	}
}
