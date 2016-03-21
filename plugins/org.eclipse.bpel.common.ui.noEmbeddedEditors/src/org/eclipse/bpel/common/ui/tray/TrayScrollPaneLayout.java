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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ScrollBar;
import org.eclipse.draw2d.ScrollPane;
import org.eclipse.draw2d.ScrollPaneLayout;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;


public class TrayScrollPaneLayout extends ScrollPaneLayout {

	public TrayScrollPaneLayout() {
		super();
	}

	@Override
	public void layout(IFigure parent) {
		ScrollPane scrollpane = (ScrollPane)parent;
		Rectangle clientArea = parent.getClientArea();

		ScrollBar hBar = scrollpane.getHorizontalScrollBar(),
			    vBar = scrollpane.getVerticalScrollBar();
		Viewport viewport = scrollpane.getViewport();

		Insets insets = new Insets();
		insets.bottom = hBar.getPreferredSize(clientArea.width, clientArea.height).height;
		insets.right  = vBar.getPreferredSize(clientArea.width, clientArea.height).width;

		int hVis = scrollpane.getHorizontalScrollBarVisibility(),
		    vVis = scrollpane.getVerticalScrollBarVisibility();

		Dimension available = clientArea.getSize(),
			preferred =
				viewport.getPreferredSize(available.width, available.height).getCopy();

		boolean none = available.contains(preferred),
			  both = !none && vVis != NEVER && hVis != NEVER && preferred.contains(available),
			  showV = both || preferred.height > available.height,
			  showH = both || preferred.width > available.width;

		//Adjust for visibility override flags
		showV = !(vVis == NEVER) && (showV || vVis == ALWAYS);
		showH = !(hVis == NEVER) && (showH || hVis == ALWAYS);

		if (!showV) insets.right = 0;
		if (!showH) insets.bottom = 0;
		Rectangle bounds, viewportArea = clientArea;

		if (showV) {
			bounds = new Rectangle(
				viewportArea.right() - insets.right,
				viewportArea.y, insets.right, viewportArea.height);
			vBar.setBounds(bounds);
		}
		if (showH) {
			bounds = new Rectangle(viewportArea.x, 
				viewportArea.bottom() - insets.bottom,
				viewportArea.width, insets.bottom);
			hBar.setBounds(bounds);
		}
		vBar.setVisible(showV);
		hBar.setVisible(showH);
		viewport.setBounds(viewportArea);
	}
}
