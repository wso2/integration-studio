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
package org.eclipse.bpel.ui.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.RevalidateLinksCommand;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.DragEditPartsTracker;


/**
 * Overridden DragEditPartsTracker to provide more intelligent
 * behavior when dragging children that don't all have the same parent.
 */
public class BPELDragEditPartsTracker extends DragEditPartsTracker {

	public BPELDragEditPartsTracker(EditPart sourceEditPart) {
		super(sourceEditPart);
	}

	@Override
	protected Command getCommand() {
		CompoundCommand command = new CompoundCommand(Messages.BPELDragEditPartsTracker_Drag_1); 
		command.setDebugLabel("Drag Object Tracker"); //$NON-NLS-1$
		Iterator iter = getOperationSet().iterator();
		Set activitiesNeedingRevalidation = null;
		while (iter.hasNext()) {
			EditPart editPart = (EditPart) iter.next();
			Request request = getTargetRequest();
			
			// make sure the request only has this particular editpart.
			((ChangeBoundsRequest)request).setEditParts(editPart);
			
			boolean isMove = editPart.getParent() == getTargetEditPart();
			
			request.setType(isMove ? REQ_MOVE : REQ_ORPHAN);
			command.add(editPart.getCommand(request));
		
			if (!isMove) {
				request.setType(REQ_ADD);
				if (getTargetEditPart() == null) return UnexecutableCommand.INSTANCE;
				command.add(getTargetEditPart().getCommand(getTargetRequest()));
			}
			
			// remember activities whose links will need revalidating.
			if (!isMove) {
				Object model = editPart.getModel();
				if (model instanceof Activity) {
					if (activitiesNeedingRevalidation == null) {
						activitiesNeedingRevalidation = new HashSet();
					}
					activitiesNeedingRevalidation.add(model);
				}
			}
		}
		if (activitiesNeedingRevalidation != null) {
			command.add(new RevalidateLinksCommand(activitiesNeedingRevalidation));
		}
		
		return command;
	}
}
