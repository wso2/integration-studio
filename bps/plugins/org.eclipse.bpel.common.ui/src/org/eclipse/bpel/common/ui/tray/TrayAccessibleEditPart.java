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

import java.util.List;
import java.util.Vector;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.swt.accessibility.ACC;
import org.eclipse.swt.accessibility.AccessibleControlEvent;
import org.eclipse.swt.accessibility.AccessibleEvent;


public class TrayAccessibleEditPart extends AccessibleEditPart {

	protected TrayEditPart part;
	
	public TrayAccessibleEditPart(TrayEditPart part) {
		super();
		this.part = part; 
	}

	@Override
	public void getChildCount(AccessibleControlEvent e) {
		getChildren(e);
		e.detail = e.children.length;
	}

	@Override
	public void getChildren(AccessibleControlEvent e) {
		List<EditPart> list = part.getChildren();
		Vector<Integer> childList = new Vector<Integer>();
		for (int i = 0; i < list.size(); i++) {
			EditPart child = list.get(i);
			AccessibleEditPart access = (AccessibleEditPart)child.getAdapter(AccessibleEditPart.class);
			if (access == null)
				continue;
			childList.add( Integer.valueOf( access.getAccessibleID()));
		}
		e.children = childList.toArray();
	}

	@Override
	public void getName(AccessibleEvent e) {
		Label label = part.getDirectEditLabel();
		if (label != null) {
			e.result = label.getText();
		} else {
			e.result = null;
		}
	}

	@Override
	public void getLocation(AccessibleControlEvent e) {
		Rectangle bounds = part.getFigure().getBounds().getCopy();
		part.getFigure().translateToAbsolute(bounds);
		org.eclipse.swt.graphics.Point p = new org.eclipse.swt.graphics.Point(0, 0);
		p = part.getViewer().getControl().toDisplay(p);
		e.x = bounds.x + p.x;
		e.y = bounds.y + p.y;
		e.width = bounds.width;
		e.height = bounds.height;
	}

	@Override
	public void getState(AccessibleControlEvent e) {
		e.detail = ACC.STATE_SELECTABLE | ACC.STATE_FOCUSABLE;
		if (part.getSelected() != EditPart.SELECTED_NONE)
			e.detail |= ACC.STATE_SELECTED;
		if (part.getViewer().getFocusEditPart() == part)
			e.detail = ACC.STATE_FOCUSED;
	}

}
