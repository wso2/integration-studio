/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.tray;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;

/**
 * Add handles to the selected edit part. We use this instead of
 * NonResizableEditPolicy because we don't want a focus rectangle.
 */
public class TraySelectionEditPolicy extends NonResizableEditPolicy {
	
	@Override
	protected List<Handle> createSelectionHandles() {
		List<Handle> result = new ArrayList<Handle>();
		GraphicalEditPart owner = (GraphicalEditPart)getHost();
		result.add(createHandle(owner));
		return result;
	}
	
	protected Handle createHandle(GraphicalEditPart owner) {
		return new TraySelectionHandle(owner, (SelectionBorderFigure)owner.getFigure());
	}
}
