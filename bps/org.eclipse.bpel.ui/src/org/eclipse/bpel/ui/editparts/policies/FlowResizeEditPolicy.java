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

import java.util.List;

import org.eclipse.bpel.model.Flow;
import org.eclipse.bpel.ui.commands.SetConstraintCommand;
import org.eclipse.bpel.ui.editparts.FlowEditPart;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;


/**
 * Edit Policy which handles the resizing of a child flow
 */
public class FlowResizeEditPolicy extends AbstractEditPolicy {

	@Override
	public Command getCommand(Request request) {
		if (REQ_RESIZE.equals(request.getType()))
			return getResizeFlowCommand((ChangeBoundsRequest)request);
		return super.getCommand(request);
	}
	protected Command getResizeFlowCommand(ChangeBoundsRequest request) {
		List children = request.getEditParts();
		// We only know how to resize a single edit part
		if (children.size() != 1) return null;
		FlowEditPart child = (FlowEditPart)children.get(0);
		Rectangle rect = child.getFigure().getBounds();
		Rectangle newRect = request.getTransformedRectangle(rect);
		return new SetConstraintCommand((Flow)child.getModel(), null, newRect.getSize());
	}
}
