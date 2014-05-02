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

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;

public class OverlayCompositeImageDescriptor extends CompositeImageDescriptor {
	
	ImageData background;
	ImageData topLeft;
	ImageData topRight;
	ImageData bottomLeft;
	ImageData bottomRight;
	
	public OverlayCompositeImageDescriptor(ImageData background, ImageData tl, ImageData tr, ImageData bl, ImageData br) {
		this.background = background;
		this.topLeft = tl;
		this.topRight = tr;
		this.bottomLeft = bl;
		this.bottomRight = br;
	}
	@Override
	protected void drawCompositeImage(int width, int height) {
		drawImage(background, 0, 0);
		if (topLeft != null) {
			drawImage(topLeft, 0, 0);
		}
		if (topRight != null) {
			drawImage(topRight, background.width - topRight.width, 0);
		}
		if (bottomLeft != null) {
			drawImage(bottomLeft, 0, background.height - bottomLeft.height);
		}
		if (bottomRight != null) {
			drawImage(bottomRight, background.width - bottomRight.width, background.height - bottomRight.height);
		}
	}
	@Override
	protected Point getSize() {
		return new Point(background.width, background.height);
	}
}
