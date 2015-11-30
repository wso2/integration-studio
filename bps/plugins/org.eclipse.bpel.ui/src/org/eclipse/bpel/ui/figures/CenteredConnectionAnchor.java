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

import org.eclipse.bpel.ui.editparts.borders.DrawerBorder;
import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * FixedConnectionAnchor is an anchor at either the top, bottom, left
 * or right of the node, centered along the edge.
 */
public class CenteredConnectionAnchor extends AbstractConnectionAnchor {

	public static final int TOP = 0;
	public static final int BOTTOM = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	public static final int TOP_INNER = 4;
	public static final int BOTTOM_INNER = 5;	
	public static final int LEFT_INNER = 6;
	public static final int RIGHT_INNER = 7;
	private int location;
	private int inset;
	private int offset = 0;
	
	public CenteredConnectionAnchor(IFigure owner, int location, int inset) {
		super(owner);
		this.location = location;
		this.inset = inset;
	}
	
	public CenteredConnectionAnchor(IFigure owner, int location, int inset, int offset) {
		this(owner, location, inset);
		this.offset = offset;
	}
	
	public Point getLocation(Point reference) {
		Rectangle r = getOwner().getBounds().getCopy();
		int x, y;
		switch (location) {
			case TOP:
				x = r.right() - r.width / 2 + offset - 1;
				y = r.y + inset;
				x = ConnectionCoordHistory.getInstance().adjustX(x);					
				break;
			case BOTTOM:
				x = r.right() - r.width / 2 + offset - 1;
				y = r.bottom() - inset;			
				x = ConnectionCoordHistory.getInstance().adjustX(x);						
				break;
			case LEFT:
				x = r.x + inset;
				y = r.bottom() - r.height / 2 + offset;
				y = ConnectionCoordHistory.getInstance().adjustY(y);
				break;
			case RIGHT:
				x = r.right() - inset;
				y = r.bottom() - r.height / 2 + offset;
				y = ConnectionCoordHistory.getInstance().adjustY(y);
				break;
			case TOP_INNER:
				x = r.right() - r.width / 2 + offset - 1;
				y = r.y + inset;
				x = ConnectionCoordHistory.getInstance().adjustX(x);					
				break;
			case BOTTOM_INNER:
				x = r.right() - r.width / 2 + offset - 1;
				// TODO: GIGANTIC hack. 11 is the offset from the bottom of a sequence to the
				// top of its lower +/- expansion arrow.
				y = r.bottom() - 11 - inset;
				x = ConnectionCoordHistory.getInstance().adjustX(x);
				break;		
			case LEFT_INNER:
				x = r.x + inset + DrawerBorder.DRAWER_WIDTH;
				y = r.bottom() - r.height / 2 + offset;
				y = ConnectionCoordHistory.getInstance().adjustY(y);
				break;		
			case RIGHT_INNER:
				x = r.right() - inset - DrawerBorder.DRAWER_WIDTH;
				y = r.bottom() - r.height / 2 + offset;
				y = ConnectionCoordHistory.getInstance().adjustY(y);
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
