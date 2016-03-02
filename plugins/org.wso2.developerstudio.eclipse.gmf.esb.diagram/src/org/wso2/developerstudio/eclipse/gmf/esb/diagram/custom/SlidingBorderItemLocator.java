/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;

/**
 * An experimental {@link BorderItemLocator} capable of attaching child figures
 * to a single side of the parent figure and making it possible to slide those
 * figures along the parent figure's specified side.
 */
public class SlidingBorderItemLocator extends BorderItemLocator {
	/**
	 * Border item figure.
	 */
	private IFigure borderItemFigure;

	/**
	 * Margin to be left at parent corners.
	 */
	private int cornerMargin;

	/**
	 * Gap between border item figures.
	 */
	private int interval;
	
	/**
	 * Map of predefined Y values
	 */
	private static Map<IFigure,Integer> predefinedYValues = new HashMap<IFigure, Integer>();

	/**
	 * Creates a new {@link SlidingBorderItemLocator} instance.
	 * 
	 * @param parentFigure
	 *            parent figure.
	 * @param borderItemFigure
	 *            border item figure.
	 * @param side
	 *            which side should the child be sliding on.
	 * @param cornerMargin
	 *            margin to be left at parent corners.
	 * @param interval
	 *            gap between border item figures.
	 */
	public SlidingBorderItemLocator(IFigure parentFigure, IFigure borderItemFigure, int side, int cornerMargin,
			int interval) {
		super(parentFigure, side, interval);
		this.borderItemFigure = borderItemFigure;
		this.cornerMargin = cornerMargin;
		this.interval = interval;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Point getPreferredLocation(int side, IFigure borderItem) {
		Rectangle bounds = getParentBorder();
		int parentFigureWidth = bounds.width;
		int parentFigureHeight = bounds.height;
		int parentFigureX = bounds.x;
		int parentFigureY = bounds.y;
		int x = parentFigureX;
		int y = parentFigureY;

		Dimension borderItemSize = getSize(borderItem);

		// Modified in order to correctly center the border item.
		if (side == PositionConstants.WEST) {
			x = parentFigureX - borderItemSize.width + getBorderItemOffset().width;
			y += parentFigureHeight / 2 - borderItemSize.height / 2;
		} else if (side == PositionConstants.EAST) {
			x = parentFigureX + parentFigureWidth - getBorderItemOffset().width;
			int predefinedYValue = getPredefinedYValue(borderItem); 
			// checking for Checking for predefined Y value
			if(predefinedYValue > 1){
				y = predefinedYValue;
				setPredefinedYValue(borderItem,-1); // Disposing value
			} else{
				y = borderItem.getBounds().getLocation().y;
			}
			
			//y += parentFigureHeight / 2 - borderItemSize.height / 2;
		} else if (side == PositionConstants.NORTH) {
			x += parentFigureWidth / 2 - borderItemSize.width / 2;
			y = parentFigureY - borderItemSize.height + getBorderItemOffset().height;
		} else if (side == PositionConstants.SOUTH) {
			x += parentFigureWidth / 2 - borderItemSize.width / 2;
			y = parentFigureY + parentFigureHeight - getBorderItemOffset().height;
		}
		return new Point(x, y);
		
	}

	/**
	 * {@inheritDoc}
	 */
	protected IFigure getConflictingBorderItemFigure(Point recommendedLocation, IFigure targetBorderItem) {
		Rectangle recommendedRect = new Rectangle(recommendedLocation, getSize(targetBorderItem));
		List<?> borderItems = targetBorderItem.getParent().getChildren();

		// Modified to consider all border items except current one.
		int currentIndex = borderItems.indexOf(targetBorderItem);
		for (int i = 0; i < borderItems.size(); i++) {
			if (i != currentIndex) {
				IFigure borderItem = (IFigure) borderItems.get(i);
				if (borderItem.isVisible()) {
					Rectangle rect = borderItem.getBounds().getCopy();
					if (rect.intersects(recommendedRect)) {
						return borderItem;
					}
				}
			}
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Point locateOnBorder(Point suggestedLocation, int suggestedSide, int circuitCount, IFigure borderItem) {
		Point recommendedLocation = locateOnParent(suggestedLocation, suggestedSide, borderItem);
		Dimension borderItemSize = getSize(borderItem);
		IFigure conflictingBorderItem = getConflictingBorderItemFigure(recommendedLocation, borderItem);

		// Assume a counter-clockwise search algorithm and rewind as necessary.
		if (circuitCount < 2 && conflictingBorderItem != null) {
			if (suggestedSide == PositionConstants.WEST) {
				do {
					calculateNextNonConflictingPosition(recommendedLocation, interval, suggestedSide, borderItem,
							conflictingBorderItem.getBounds());
					conflictingBorderItem = getConflictingBorderItemFigure(recommendedLocation, borderItem);
				} while (conflictingBorderItem != null);

				int maxY = getParentBorder().getBottomLeft().y - (borderItemSize.height + cornerMargin);
				if (recommendedLocation.y > maxY) {
					// Off bottom, rewind to top.
					recommendedLocation.y = getParentBorder().getTopLeft().y + cornerMargin;
					return locateOnBorder(recommendedLocation, PositionConstants.WEST, circuitCount + 1, borderItem);
				}
			} else if (suggestedSide == PositionConstants.SOUTH) {
				do {
					calculateNextNonConflictingPosition(recommendedLocation, interval, suggestedSide, borderItem,
							conflictingBorderItem.getBounds());
					conflictingBorderItem = getConflictingBorderItemFigure(recommendedLocation, borderItem);
				} while (conflictingBorderItem != null);

				int maxX = getParentBorder().getBottomRight().x - (borderItemSize.width + cornerMargin);
				if (recommendedLocation.x > maxX) {
					// Off right, rewind to left.
					recommendedLocation.x = getParentBorder().getBottomLeft().x + cornerMargin;
					return locateOnBorder(recommendedLocation, PositionConstants.SOUTH, circuitCount + 1, borderItem);
				}
			} else if (suggestedSide == PositionConstants.EAST) {
				do {
					calculateNextNonConflictingPosition(recommendedLocation, interval, suggestedSide, borderItem,
							conflictingBorderItem.getBounds());
					conflictingBorderItem = getConflictingBorderItemFigure(recommendedLocation, borderItem);
				} while (conflictingBorderItem != null);

				int minY = getParentBorder().getTopRight().y + cornerMargin;
				if (recommendedLocation.y < minY) {
					// Off the top, rewind to bottom.
					recommendedLocation.y = getParentBorder().getBottomRight().y
							- (borderItemSize.height + cornerMargin);
					return locateOnBorder(recommendedLocation, PositionConstants.EAST, circuitCount + 1, borderItem);
				}
			} else {
				do {
					calculateNextNonConflictingPosition(recommendedLocation, interval, suggestedSide, borderItem,
							conflictingBorderItem.getBounds());
					conflictingBorderItem = getConflictingBorderItemFigure(recommendedLocation, borderItem);
				} while (conflictingBorderItem != null);

				int minX = getParentBorder().getTopLeft().x + cornerMargin;
				if (recommendedLocation.x < minX) {
					// Off the left, rewind to right.
					recommendedLocation.x = getParentBorder().getTopRight().x - (borderItemSize.width + cornerMargin);
					return locateOnBorder(recommendedLocation, PositionConstants.NORTH, circuitCount + 1, borderItem);
				}
			}
		}
		return recommendedLocation;
	}

	/**
	 * {@inheritDoc}
	 */
	public Dimension getBorderItemOffset() {
		switch (getPreferredSideOfParent()) {
		case PositionConstants.WEST:
		case PositionConstants.EAST:
			return new Dimension(borderItemFigure.getSize().width / 2, cornerMargin);
		default:
			return new Dimension(cornerMargin, borderItemFigure.getSize().height / 2);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		Rectangle realLocation = new Rectangle(proposedLocation);
		Point newTopLeft = locateOnBorder(realLocation.getTopLeft(), getPreferredSideOfParent(), 0, borderItem);
		realLocation.setLocation(newTopLeft);
		return realLocation;
	}

	/**
	 * {@inheritDoc}
	 */
	public void relocate(IFigure borderItem) {
		Dimension size = getSize(borderItem);
		Point ptNewLocation = locateOnBorder(getPreferredLocation(borderItem), getPreferredSideOfParent(), 0,
				borderItem);
		borderItem.setBounds(new Rectangle(ptNewLocation, size));
	}
	
	/**
	 * Set the Y value for a figure
	 * @param figure
	 * @param predefinedValue
	 */
	public static void setPredefinedYValue(IFigure figure,int predefinedValue) {
		predefinedYValues.put(figure, predefinedValue);
	}

	/**
	 * Get predefined Y value of a figure
	 * @param figure
	 * @return
	 */
	public static int getPredefinedYValue(IFigure figure) {
		if (predefinedYValues.containsKey(figure)) {
			return predefinedYValues.get(figure);
		}
		return -1;
	}
}
