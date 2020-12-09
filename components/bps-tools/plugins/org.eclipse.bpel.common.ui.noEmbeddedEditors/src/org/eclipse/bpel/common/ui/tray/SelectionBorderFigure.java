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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Selection border works differently than selection handles.
 * We don't use the normal selection handles because they do not
 * work properly within a ScrollPane. Selection handles are drawn in a layer of the
 * root figure so even when figures in the ScrollPane are not visible, if that figure
 * was selected before, the handle is drawn on top of other figures.
 * Selection borders are drawn by the selected figure.
 */
public class SelectionBorderFigure extends Figure {

	protected boolean shouldPaintSelectionBorder;
	
	public SelectionBorderFigure() {
		super();
		shouldPaintSelectionBorder = false;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);
		paintSelectionBorder(graphics);
	}
	
	protected void paintSelectionBorder(Graphics graphics) {
		if (shouldPaintSelectionBorder) {
			Rectangle rect = getBounds().getCopy();
			rect.shrink(1, 1);
			graphics.drawRectangle(rect);
		}
	}
	
	public void setPaintSelectionBorder(boolean paint) {
		shouldPaintSelectionBorder = paint;
	}
}
