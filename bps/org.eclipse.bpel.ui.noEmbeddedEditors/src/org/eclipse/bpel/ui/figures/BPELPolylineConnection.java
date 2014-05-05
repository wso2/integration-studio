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

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;


public class BPELPolylineConnection extends PolylineConnection {

	private static final int LEFT_RIGHT = 0, RIGHT_LEFT = 1, TOP_BOTTOM = 2, BOTTOM_TOP = 3;
	
	Color color1, color2, color3;
	Image topLeft, topRight, bottomLeft, bottomRight, arrowDown, arrowRight;
	
	public BPELPolylineConnection(Image topLeft, Image topRight, Image bottomLeft, Image bottomRight, Image arrowDown, Image arrowRight) {
		BPELUIPlugin plugin = BPELUIPlugin.INSTANCE;
		ColorRegistry colorRegistry = plugin.getColorRegistry();
		color1 = colorRegistry.get(IBPELUIConstants.COLOR_LINK_ONE);
		color2 = colorRegistry.get(IBPELUIConstants.COLOR_LINK_TWO);
		color3 = colorRegistry.get(IBPELUIConstants.COLOR_LINK_THREE);
		this.topLeft = topLeft;
		this.topRight = topRight;
		this.bottomLeft = bottomLeft;
		this.bottomRight = bottomRight;
		this.arrowDown = arrowDown;
		this.arrowRight = arrowRight;
		// Leave room for the 3-pixel wide line, as well as our custom arrowhead.
		setLineWidth(12);
	}
	
	@Override
	protected void outlineShape(Graphics g) {
		PointList list = getPoints();
		int size = list.size();
		int lastDirection = LEFT_RIGHT;
		for (int i = 0; i < size - 1; i++) {
			Point p1 = list.getPoint(i);
			Point p2 = list.getPoint(i + 1);
			// First determine the direction of the line.
			int direction;
			if (p1.x == p2.x) {
				if (p1.y > p2.y) {
					direction = BOTTOM_TOP;
				} else {
					direction = TOP_BOTTOM;
				}
			} else {
				if (p1.x > p2.x) {
					direction = RIGHT_LEFT;
				} else {
					direction = LEFT_RIGHT;
				}
			}

			// If we are on the last one, draw the arrow too.
			if (i == size - 2) {
				Image arrowImage = arrowDown;
				// If the end is horizontal, transform the arrow
				if(direction == RIGHT_LEFT || direction == LEFT_RIGHT){
					arrowImage = arrowRight;
				}
				g.drawImage(arrowImage, p2.x - 6, p2.y - 6);
			}
			
			// Draw the line.
			// If we are on the last one, the line should fall short by 4 pixels.
			if (i == size - 2) {
				if(direction == RIGHT_LEFT || direction == LEFT_RIGHT)
					p2.x -= 4;
				else
					p2.y -= 4;
			}
			g.setLineWidth(1);
			g.setForegroundColor(color2);
			g.drawLine(p1, p2);
			if (direction == BOTTOM_TOP || direction == TOP_BOTTOM) {
				// Vertical
				g.setForegroundColor(color1);
				g.drawLine(p1.x-1, p1.y, p2.x-1, p2.y);
				g.setForegroundColor(color3);
				g.drawLine(p1.x+1, p1.y, p2.x+1, p2.y);
			} else {
				// Horizontal
				g.setForegroundColor(color1);
				g.drawLine(p1.x, p1.y-1, p2.x, p2.y-1);
				g.setForegroundColor(color3);
				g.drawLine(p1.x, p1.y+1, p2.x, p2.y+1);
			}
			// If we are on the second (or greater), draw the corner.
			if (i != 0) {
				// Draw the corner connection
				Image image;
				switch (lastDirection) {
					case TOP_BOTTOM:
						if (direction == LEFT_RIGHT) {
							image = bottomLeft;
						} else {
							image = bottomRight;
						}
						break;
					case BOTTOM_TOP:
						if (direction == LEFT_RIGHT) {
							image = topLeft;
						} else {
							image = topRight;
						}
						break;
					case LEFT_RIGHT:
						if (direction == TOP_BOTTOM) {
							image = topRight;
						} else {
							image = bottomRight;
						}
						break;
					default:
						if (direction == TOP_BOTTOM) {
							image = topLeft;
						} else {
							image = bottomLeft;
						}
						break;
				}
				//int x = p1.x - 1;
				//int y = p1.y - 1;
				g.drawImage(image, p1.x-1, p1.y-1);
			}
			lastDirection = direction;
		}
	}
}
