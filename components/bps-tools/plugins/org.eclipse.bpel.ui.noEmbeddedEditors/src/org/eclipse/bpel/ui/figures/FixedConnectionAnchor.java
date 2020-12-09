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

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * FixedConnectionAnchor is an anchor at either the top, bottom, left
 * or right of the node, at a fixed offset along the edge.
 */
public class FixedConnectionAnchor extends AbstractConnectionAnchor {

	public static final int TOP = 0;
	public static final int BOTTOM = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;

	private int location;
	private int inset;
	// The offset is measured from the top (for LEFT and RIGHT) or the left (for TOP or BOTTOM)
	private int offset;
	
	public FixedConnectionAnchor(IFigure owner, int location, int inset, int offset) {
		super(owner);
		this.location = location;
		this.inset = inset;
		this.offset = offset;
	}
	
	public Point getLocation(Point reference) {
		Rectangle r = getOwner().getBounds();
		int x, y;
		switch (location) {
			case TOP:
				x = r.x + offset;
				y = r.y + inset;
				break;
			case BOTTOM:
				x = r.x + offset;
				y = r.bottom() - inset;
				break;
			case LEFT:
				x = r.x + inset;
				y = r.y + offset;
				break;
			case RIGHT:
				x = r.right() - inset;
				y = r.y + offset;
				break;
			default:
				// Something went wrong. Attach the anchor to the middle
				x = r.right() - r.width / 2;
				y = r.bottom() - r.height / 2;
		}
		Point p = new PrecisionPoint(x,y);
		getOwner().translateToAbsolute(p);
		return p;
	}
	
	@Override
	public Point getReferencePoint() {
		return getLocation(null);
	}
		
}
