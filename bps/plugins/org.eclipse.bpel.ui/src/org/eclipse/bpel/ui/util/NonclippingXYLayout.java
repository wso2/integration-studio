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
package org.eclipse.bpel.ui.util;

import java.util.Iterator;

import org.eclipse.bpel.ui.editparts.util.GraphAnimation;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;


/**
 * Our version of XYLayout that doesn't allow negative x,y children to be clipped.
 * It also has size attribute that overrides what the preferred size should be.
 */
public class NonclippingXYLayout extends XYLayout {

	private Point displacement = new Point(0, 0);
	private Dimension size;
	
	/**
	 * @return the offset of the children in the container
	 */
	public Point getDisplacement() {
		return displacement;
	}

	@Override
	public void layout(IFigure parent) {
		GraphAnimation.recordInitialState(parent);
		if (GraphAnimation.playbackState(parent))
			return;
		
		Point offset = getOrigin(parent);
		IFigure f;

		// calculate a new displacement
		refreshDisplacement(parent);

		Iterator children;
		children = parent.getChildren().iterator();
		while (children.hasNext()) {
			f = (IFigure) children.next();
			Rectangle bounds = (Rectangle) getConstraint(f);
			if (bounds == null)
				continue;
			bounds = bounds.getTranslated(offset);
			if (bounds.width == -1 || bounds.height == -1) {
				Dimension preferredSize = f.getPreferredSize();
				bounds = bounds.getCopy();
				if (bounds.width == -1)
					bounds.width = preferredSize.width;
				if (bounds.height == -1)
					bounds.height = preferredSize.height;
			}
			bounds = bounds.getTranslated(displacement);
			f.setBounds(bounds);
		}
	}

	public void refreshDisplacement(IFigure parent) {
		IFigure f;

		// calculate a new displacement
		Iterator children = parent.getChildren().iterator();
		int minX = 0, minY = 0;
		while (children.hasNext()) {
			f = (IFigure) children.next();
			Rectangle bounds = (Rectangle) getConstraint(f);
			if (bounds == null)
				continue;
			if (bounds.x < 0)
				minX = Math.min(minX, bounds.x);
			if (bounds.y < 0)
				minY = Math.min(minY, bounds.y);
		}
		displacement = new Point(-minX, -minY);
	}

	@Override
	public void setConstraint(IFigure figure, Object newConstraint) {
		Rectangle bounds = null;
		if (newConstraint != null) {
			bounds = ((Rectangle) newConstraint).getCopy();
			bounds.translate(-displacement.x, -displacement.y);
		}
		super.setConstraint(figure, bounds);
//		if (bounds != null)
//			constraints.put(figure, bounds);
	}
	@Override
	protected Dimension calculatePreferredSize(IFigure f, int wHint, int hHint) {
		Dimension result = super.calculatePreferredSize(f, wHint, hHint);
		if (size != null) {
			Dimension largest = new Dimension(size);
			largest.width = Math.max(result.width, size.width);
			largest.height = Math.max(result.height, size.height);
			return largest;
		}
		
		return result;
	}
	public void setSize(Dimension size) {
		this.size = size;
	}
}