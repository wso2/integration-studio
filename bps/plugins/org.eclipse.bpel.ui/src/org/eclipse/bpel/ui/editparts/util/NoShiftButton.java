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
package org.eclipse.bpel.ui.editparts.util;

import org.eclipse.bpel.common.ui.details.widgets.NoBorderButton;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;


public class NoShiftButton extends NoBorderButton {
	
	private static final Rectangle PRIVATE_RECT = new Rectangle();

	public NoShiftButton(Image image) {
		super(image);
	}
	@Override
	protected void paintClientArea(Graphics graphics) {
		if (getChildren().isEmpty())
			return;

		boolean optimizeClip = getBorder() == null || getBorder().isOpaque();

		if (useLocalCoordinates()) {
			graphics.translate(
				getBounds().x + getInsets().left,
				getBounds().y + getInsets().top);
			if (!optimizeClip)
				graphics.clipRect(getClientArea(PRIVATE_RECT));
			graphics.pushState();
			paintChildren(graphics);
			graphics.popState();
			graphics.restoreState();
		} else {
			if (optimizeClip)
				paintChildren(graphics);
			else {
				graphics.clipRect(getClientArea(PRIVATE_RECT));
				graphics.pushState();
				paintChildren(graphics);
				graphics.popState();
				graphics.restoreState();
			}
		}
	}
}
