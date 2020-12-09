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
package org.eclipse.bpel.common.ui.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.RelativeHandleLocator;

/**
 * Override the normal relative handle locator. This is required to move the
 * handles out of the absolute corners and closer to the "apparent" bounds of
 * the figure.
 */
public class InsetRelativeHandleLocator extends RelativeHandleLocator {

	int fVerticalInset;

	int fHorizontalInset;

	int fLocation;

	/**
	 * @param reference
	 * @param aLocation
	 * @param verticalInset
	 * @param horizontalInset
	 */

	public InsetRelativeHandleLocator(IFigure reference, int aLocation,
			int verticalInset, int horizontalInset) {
		super(reference, aLocation);

		this.fVerticalInset = verticalInset;
		this.fHorizontalInset = horizontalInset;
		this.fLocation = aLocation;
	}

	/**
	 * @see org.eclipse.draw2d.RelativeLocator#relocate(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void relocate(IFigure target) {

		IFigure reference = getReferenceFigure();
		Rectangle targetBounds = new PrecisionRectangle(getReferenceBox()
				.getResized(-1, -1));
		reference.translateToAbsolute(targetBounds);
		target.translateToRelative(targetBounds);
		targetBounds.resize(1, 1);

		Dimension targetSize = target.getPreferredSize();

		switch (fLocation & PositionConstants.EAST_WEST) {
			case PositionConstants.WEST:
				targetBounds.x -= (targetSize.width) / 2;
				targetBounds.x += fHorizontalInset;
				break;
			case PositionConstants.EAST:
				targetBounds.x += targetBounds.width - (targetSize.width) / 2;
				targetBounds.x -= fHorizontalInset;
				break;
			
			// Only North || South is given
			default :
				targetBounds.x += targetBounds.width/2  ;
				break;
		}
		switch (fLocation & PositionConstants.NORTH_SOUTH) {
			case PositionConstants.NORTH:
				targetBounds.y -= (targetSize.height) / 2;
				targetBounds.y += fVerticalInset;
				break;
			case PositionConstants.SOUTH:
				targetBounds.y += targetBounds.height - (targetSize.height + 2)	/ 2;
				targetBounds.y -= fVerticalInset;
				break;
				
				// Only West || East is given
			default :
				targetBounds.y += targetBounds.height/2 ;
				break;
				
		}

		targetBounds.setSize(targetSize);
		target.setBounds(targetBounds);
	}

}
