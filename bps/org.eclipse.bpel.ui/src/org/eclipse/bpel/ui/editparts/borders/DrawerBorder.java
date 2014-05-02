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

import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.swt.graphics.Image;

public abstract class DrawerBorder extends AbstractBorder {
	
	public static final int DRAWER_WIDTH = 16;
	public static final int DRAWER_HALF_HEIGHT = 12;
	public static final int DRAWER_HEIGHT = 25;
	public static final int DRAWER_INSET = 30;
	
	private Image topImage;
	private Image bottomImage;
	private IMarker topMarker;
	private IMarker bottomMarker;
	
	public void setTopImage(Image image) {
		this.topImage = image;
	}
	public void setBottomImage(Image image) {
		this.bottomImage = image;
	}
	public void setTopMarker(IMarker marker) {
		this.topMarker = marker;
	}
	public void setBottomMarker(IMarker marker) {
		this.bottomMarker = marker;
	}
	public Image getTopImage() {
		return topImage;
	}
	public Image getBottomImage() {
		return bottomImage;
	} 
	public IMarker getTopMarker() {
		return topMarker;
	}
	public IMarker getBottomMarker() {
		return bottomMarker;
	}
	public abstract boolean isPointInTopDrawer(int x, int y);
	public abstract boolean isPointInBottomDrawer(int x, int y);
}