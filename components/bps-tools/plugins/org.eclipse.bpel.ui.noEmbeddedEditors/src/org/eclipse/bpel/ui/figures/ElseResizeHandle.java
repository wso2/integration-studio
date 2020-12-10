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
package org.eclipse.bpel.ui.figures;

import org.eclipse.bpel.common.ui.figures.InsetRelativeHandleLocator;
import org.eclipse.bpel.common.ui.figures.InsetResizeHandle;
import org.eclipse.bpel.ui.editparts.ElseIfEditPart;
import org.eclipse.gef.GraphicalEditPart;


public class ElseResizeHandle extends InsetResizeHandle {
	public ElseResizeHandle(GraphicalEditPart owner, int direction) {
		super(owner, direction, 0, 0);
		ElseIfEditPart editPart = (ElseIfEditPart)owner;
		setLocator(new InsetRelativeHandleLocator(editPart.getNameLabel(), direction, 0, 0));
	}
}
