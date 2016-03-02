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
public class EvenlyDividedFixedBorderItemLocator extends BorderItemLocator {
	/**
	 * Border item figure.
	 */
	private IFigure borderItemFigure;
	/**
	 * The id of the figure, this is used to arrange the item
	 */
	private int id;

	/**
	 * number of siblings sharing the space of the border, set by parent edit
	 * part as new connectors are added
	 */
	private int siblingCount;

	/**
	 * Creates a new {@link EvenlyDividedFixedBorderItemLocator} instance.
	 * 
	 * @param parentFigure
	 *            parent figure to which the arranging part belongs to.
	 * @param borderItemFigure
	 *            border item figure (which is going to be correctly placed).
	 * @param side
	 *            which side should the border item be sliding on.
	 * @param locationScale
	 *            how far away should the border item be placed (0.0 - 1.0).
	 */
	public EvenlyDividedFixedBorderItemLocator(IFigure parentFigure,
			IFigure borderItemFigure, int side, int id, int siblingCount) {
		super(parentFigure, side);
		this.borderItemFigure = borderItemFigure;
		this.id = id;
		this.siblingCount = siblingCount;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Point getPreferredLocation(int side, IFigure borderItem) {
		return locateOnBorder(null, side, 0, borderItem);
	}

	/**
	 * should be set by parent edit part as new connectors are added
	 * 
	 * @param unitSpace
	 *            space between two children of parent edit part
	 */
	public void setSiblingCount(int siblingCount) {
		this.siblingCount = siblingCount;
	}

	/**
	 * {@inheritDoc}
	 */
	protected Point locateOnBorder(Point suggestedLocation, int suggestedSide,
			int circuitCount, IFigure borderItem) {
		double resultX = 0.0;
		double resultY = 0.0;
		Rectangle bounds = getParentBorder();
		double parentFigureWidth = bounds.width;
		double parentFigureHeight = bounds.height;
		double parentFigureX = bounds.x;
		double parentFigureY = bounds.y;
		double unitSpace = (double) 1 / ((double) (siblingCount + 1));
		Dimension borderItemSize = getSize(borderItem);

		if (suggestedSide == PositionConstants.WEST) {
			resultX = parentFigureX - borderItemSize.width
					+ getBorderItemOffset().width;
			resultY = parentFigureY + (parentFigureHeight * unitSpace * id)
					- (borderItemSize.height / 2);
		} else if (suggestedSide == PositionConstants.SOUTH) {
			resultX = parentFigureX + (parentFigureWidth * unitSpace * id)
					- (borderItemSize.width / 2);
			resultY = parentFigureY - borderItemSize.height
					+ getBorderItemOffset().height;
		} else if (suggestedSide == PositionConstants.EAST) {
			resultX = parentFigureX + parentFigureWidth - borderItemSize.width
					+ getBorderItemOffset().width;
			resultY = parentFigureY + (parentFigureHeight * unitSpace * id)
					- (borderItemSize.height / 2);
		} else {
			resultX = parentFigureX + (parentFigureWidth * unitSpace * id)
					- (borderItemSize.width / 2);
			resultY = parentFigureY - borderItemSize.height
					+ getBorderItemOffset().height;
		}
		return new PrecisionPoint(resultX, resultY);
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
	public Rectangle getValidLocation(Rectangle proposedLocation,
			IFigure borderItem) {
		Rectangle realLocation = new Rectangle(proposedLocation);
		Point newTopLeft = locateOnBorder(realLocation.getTopLeft(),
				getPreferredSideOfParent(), 0, borderItem);
		realLocation.setLocation(newTopLeft);
		return realLocation;
	}

	/**
	 * {@inheritDoc}
	 */
	public void relocate(IFigure borderItem) {
		Dimension size = getSize(borderItem);
		Point ptNewLocation = locateOnBorder(getPreferredLocation(borderItem),
				getPreferredSideOfParent(), 0, borderItem);
		borderItem.setBounds(new Rectangle(ptNewLocation, size));
	}
}
