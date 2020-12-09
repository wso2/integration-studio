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
package org.eclipse.bpel.common.ui.decorator;

import org.eclipse.draw2d.AbstractHintLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * This layout is to assist in the placement of decorations in a layer over top
 * of a particular figure.
 * 
 * There are nine possible locations for a decoration, as defined in the constants.
 * 
 * Subclasses should implement the calculateLocation method to specify where a
 * decoration of a given size should go in the given container, taking into
 * account the location hint.
 */
public class DecorationLayout extends AbstractHintLayout {
	protected IFigure center, left, top, bottom, right, topLeft, topRight, bottomLeft, bottomRight;

	public DecorationLayout() {
		super();
	}
	
	/** 
	 * Calculate an x+y location for a decoration. This method should take into account the location hint,
	 * which specifies which of nine locations the decoration should go. Different edit parts could
	 * consider those locations to be at different x+y coordinates depending on the visuals of that edit
	 * part. For example, in a leaf edit part which has a round rectangle surrounding the activity label,
	 * the top left should be considered to be just inside the top left corner of the rectangle, as opposed
	 * to in the top left corner of the figure, which would lie outside this rectangle.
	 * 
	 * @param locationHint  one of the nine location constants defining where the decoration should go
	 * @param container  the containing figure into which the decoration will be inserted
	 * @param childDimension  the preferred size of the decoration
	 * @return the preferred location of the decoration based on the input
	 */
	protected Point calculateLocation(int locationHint, IFigure container, Dimension childDimension) {
		Rectangle area = container.getClientArea();
		switch (locationHint) {
			case PositionConstants.CENTER: // Center
				return new Point(area.x + area.width / 2 - childDimension.width / 2, area.y + area.height / 2 - childDimension.height / 2);
			case PositionConstants.TOP: // Top Center
				return new Point(area.x + area.width / 2 - childDimension.width / 2, area.y );
			case PositionConstants.BOTTOM: // Bottom Center
				return new Point(area.x + area.width / 2 - childDimension.width / 2, area.y + area.height - childDimension.height);
			case PositionConstants.LEFT: // Center Left
				return new Point(area.x, area.y + area.height / 2 - childDimension.width / 2);
			case PositionConstants.RIGHT: // Center Right
				return new Point(area.x + area.width - childDimension.width, area.y + area.height / 2 - childDimension.height / 2);
			case PositionConstants.TOP | PositionConstants.LEFT: // Top Left
				return new Point(area.x, area.y); 
			case PositionConstants.TOP | PositionConstants.RIGHT: // Top Right
				return new Point(area.x + area.width - childDimension.width, area.y );
			case PositionConstants.BOTTOM | PositionConstants.LEFT: // Bottom Left
				return new Point(area.x, area.y + area.height - childDimension.height);
			case PositionConstants.BOTTOM | PositionConstants.RIGHT: // Bottom Right
				return new Point(area.x + area.width - childDimension.width, area.y + area.height - childDimension.height);
			default:
				return new Point(area.x, area.y);
		}
	}
	
	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		return new Dimension(0, 0);
	}

	public void layout(IFigure container) {
		Rectangle rect = new Rectangle();
		if (top != null && top.isVisible()) {
			Dimension d = top.getPreferredSize(-1, -1);
			rect.setLocation(calculateLocation(IMarkerConstants.TOP.intValue(), container, d));
			rect.setSize(d);
			top.setBounds(rect);
		}
		if (bottom != null && bottom.isVisible()) {
			Dimension d = bottom.getPreferredSize(-1, -1);
			rect.setLocation(calculateLocation(IMarkerConstants.BOTTOM.intValue(), container, d));
			rect.setSize(d);
			bottom.setBounds(rect);
		}
		if (left != null && left.isVisible()) {
			Dimension d = left.getPreferredSize(-1, -1);
			rect.setLocation(calculateLocation(IMarkerConstants.LEFT.intValue(), container, d));
			rect.setSize(d);
			left.setBounds(rect);
		}
		if (right != null && right.isVisible()) {
			Dimension d = right.getPreferredSize(-1, -1);
			rect.setLocation(calculateLocation(IMarkerConstants.RIGHT.intValue(), container, d));
			rect.setSize(d);
			right.setBounds(rect);
		}
		if (center != null && center.isVisible()) {
			Dimension d = center.getPreferredSize(-1, -1);
			rect.setLocation(calculateLocation(IMarkerConstants.CENTER.intValue(), container, d));
			rect.setSize(d);
			center.setBounds(rect);
		}
		if (topLeft != null && topLeft.isVisible()) {
			Dimension d = topLeft.getPreferredSize(-1, -1);
			rect.setLocation(calculateLocation(IMarkerConstants.TOP_LEFT.intValue(), container, d));
			rect.setSize(d);
			topLeft.setBounds(rect);
		}
		if (topRight != null && topRight.isVisible()) {
			Dimension d = topRight.getPreferredSize(-1, -1);
			rect.setLocation(calculateLocation(IMarkerConstants.TOP_RIGHT.intValue(), container, d));
			rect.setSize(d);
			topRight.setBounds(rect);
		}
		if (bottomLeft != null && bottomLeft.isVisible()) {
			Dimension d = bottomLeft.getPreferredSize(-1, -1);
			rect.setLocation(calculateLocation(IMarkerConstants.BOTTOM_LEFT.intValue(), container, d));
			rect.setSize(d);
			bottomLeft.setBounds(rect);
		}
		if (bottomRight != null && bottomRight.isVisible()) {
			Dimension d = bottomRight.getPreferredSize(-1, -1);
			rect.setLocation(calculateLocation(IMarkerConstants.BOTTOM_RIGHT.intValue(), container, d));
			rect.setSize(d);
			bottomRight.setBounds(rect);
		}
	}
	
	@Override
	public void remove(IFigure child) {
		if (center == child) {
			center = null;
		} else if (top == child) {
			top = null;
		} else if (bottom == child) {
			bottom = null;
		} else if (right == child) {
			right = null;
		} else if (left == child) {
			left = null;
		} else if (topLeft == child) {
			topLeft = null;
		} else if (topRight == child) {
			topRight = null;
		} else if (bottomLeft == child) {
			bottomLeft = null;
		} else if (bottomRight == child) {
			bottomRight = null;
		}
	}
	
	@Override
	public void setConstraint(IFigure child, Object constraint) {
		remove(child);
		super.setConstraint(child, constraint);
		if (constraint == null) {
			return;
		}
	
		switch (((Integer) constraint).intValue()) {
			case PositionConstants.CENTER :
				center = child;
				break;
			case PositionConstants.TOP :
				top = child;
				break;
			case PositionConstants.BOTTOM :
				bottom = child;
				break;
			case PositionConstants.RIGHT :
				right = child;
				break;
			case PositionConstants.LEFT :
				left = child;
				break;
			case PositionConstants.TOP | PositionConstants.LEFT :
				topLeft = child;
				break;
			case PositionConstants.TOP | PositionConstants.RIGHT :
				topRight = child;
				break;
			case PositionConstants.BOTTOM | PositionConstants.LEFT :
				bottomLeft = child;
				break;
			case PositionConstants.BOTTOM | PositionConstants.RIGHT :
				bottomRight = child;
				break;
			default :
				break;
		}
	}
}