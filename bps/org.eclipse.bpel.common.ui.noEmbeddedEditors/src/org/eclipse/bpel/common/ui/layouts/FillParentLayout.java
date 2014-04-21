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
package org.eclipse.bpel.common.ui.layouts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Rectangle;


public class FillParentLayout extends ToolbarLayout { // TODO: probably shouldn't have to derive from toolbarlayout
	public FillParentLayout() {
		super();
	}
	
	@Override
	public void layout(IFigure parent) {
		List children = parent.getChildren();
		Rectangle clientArea = parent.getClientArea();
		if(children.size() < 1)
			return;

		
		for (int i = 0; i < children.size(); i++) {
			IFigure lastChild = (IFigure)children.get(i);
			Rectangle r = lastChild.getBounds().getCopy();
			r.width = clientArea.width;
			r.x = clientArea.x;
			r.height = clientArea.height;			
			r.y = clientArea.y;
			lastChild.setBounds(r);
		}
	}
}
