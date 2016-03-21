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
package org.eclipse.bpel.ui.editparts.borders;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;

public class ElseElseIfBorder extends LineBorder {

	public static final int MARKER_WIDTH = 15;
	private Image image;
	
	@Override
	public Insets getInsets(IFigure figure) {
		Insets result = super.getInsets(figure);
		result.left += MARKER_WIDTH;
		result.right += MARKER_WIDTH;
		result.top += 1;
		result.bottom += 1;
		return result;
	}
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		super.paint(figure, graphics, insets);
		Rectangle bounds = figure.getBounds();
		if (image != null) {
			int x = bounds.x;
			int y = bounds.y;
			graphics.drawImage(image, x, y);
		}
	}
	public void setImage(Image leftImage) {
		this.image = leftImage;
	}
}
