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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;

/**
 * An experimental {@link BorderItemLocator} capable of attaching child figures
 * to a fixed location on the parent border.
 */
public class FixedBorderItemLocator extends BorderItemLocator {
	/**
	 * Border item figure.
	 */
	private IFigure borderItemFigure;
	
	/**
	 * Hint about border item location.
	 */
	private double locationScale;

	/**
	 * Creates a new {@link FixedBorderItemLocator} instance.
	 * 
	 * @param parentFigure
	 *            parent figure.
	 * @param borderItemFigure
	 *            border item figure.
	 * @param side
	 *            which side should the border item be sliding on.
	 * @param locationScale
	 *            how far away should the border item be placed (0.0 - 1.0).
	 */
	public FixedBorderItemLocator(IFigure parentFigure, IFigure borderItemFigure, int side, double locationScale) {
		super(parentFigure, side);
		this.borderItemFigure = borderItemFigure;
		this.locationScale = (locationScale < 0) ? 0.0 : ((locationScale > 1) ? 1.0 : locationScale); 
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected Point getPreferredLocation(int side, IFigure borderItem) {
		Rectangle bounds = getParentBorder();
		double parentFigureWidth = bounds.width;
		double parentFigureHeight = bounds.height;
		double parentFigureX = bounds.x;
		double parentFigureY = bounds.y;
		double x = parentFigureX;
		double y = parentFigureY;

		Dimension borderItemSize = getSize(borderItem);

		// Modified in order to correctly place the border item.
		if (side == PositionConstants.WEST) {
			x = parentFigureX - borderItemSize.width + getBorderItemOffset().width;
			y += parentFigureHeight * locationScale;
			y -= borderItemSize.height / 2;
		} else if (side == PositionConstants.EAST) {
			x = parentFigureX + parentFigureWidth - getBorderItemOffset().width;
			y += parentFigureHeight * locationScale;
			y -= borderItemSize.height / 2;
		} else if (side == PositionConstants.NORTH) {
			x += parentFigureWidth * locationScale;
			x -= borderItemSize.width / 2;
			y = parentFigureY - borderItemSize.height + getBorderItemOffset().height;
		} else if (side == PositionConstants.SOUTH) {
			x += parentFigureWidth * locationScale;
			x -= borderItemSize.width / 2;
			y = parentFigureY + parentFigureHeight - getBorderItemOffset().height;
		}
		return new PrecisionPoint(x, y);		
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected Point locateOnBorder(Point suggestedLocation, int suggestedSide, int circuitCount, IFigure borderItem) {
		Point recommendedLocation = locateOnParent(suggestedLocation, suggestedSide, borderItem);
		double resultX = recommendedLocation.preciseX();
		double resultY = recommendedLocation.preciseY();
		Rectangle bounds = getParentBorder();
		double parentFigureWidth = bounds.width;
		double parentFigureHeight = bounds.height;
		double parentFigureX = bounds.x;
		double parentFigureY = bounds.y;
		Dimension borderItemSize = getSize(borderItem);		
		
		if (suggestedSide == PositionConstants.WEST) {
			resultY = parentFigureY + (parentFigureHeight * locationScale) - (borderItemSize.height / 2);
		} else if (suggestedSide == PositionConstants.SOUTH) {
			resultX = parentFigureX + (parentFigureWidth * locationScale) - (borderItemSize.width / 2);
		} else if (suggestedSide == PositionConstants.EAST) {
			resultY = parentFigureY + (parentFigureHeight * locationScale) - (borderItemSize.height / 2);
		} else {
			resultX = parentFigureX + (parentFigureWidth * locationScale) - (borderItemSize.width / 2);
		}		
		recommendedLocation.setLocation(new PrecisionPoint(resultX, resultY));

		return recommendedLocation;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Dimension getBorderItemOffset() {
		switch (getPreferredSideOfParent()) {
		case PositionConstants.WEST:
		case PositionConstants.EAST:
			return new Dimension(borderItemFigure.getSize().width / 2, 0);
		default:
			return new Dimension(0, borderItemFigure.getSize().height / 2);
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
}
