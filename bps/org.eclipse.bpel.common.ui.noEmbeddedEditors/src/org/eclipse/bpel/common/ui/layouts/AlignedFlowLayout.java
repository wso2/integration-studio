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
package org.eclipse.bpel.common.ui.layouts;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.AbstractHintLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Transposer;

/** A version of FlowLayout that doesn't wrap the children 
 * and allows aligning in both orientations
 * as well as alignment of the children relative to each other
 * 
 * some parameters you can set:
 * 
 * horizontal - orientation of children
 * 	if true, children laid across, and width respected
 * 	if false. children laid downwards, height respected.
 * 
 * fill - if true and layout is horizontal, height not respected
 * 		  if false and layout is horizontal, height respected
 *        if true and layout is vertical, width not respected
 * 
 * fillParent - if true, tries to fill the child to the container size 
 * 		
 * horizontal or vertical alignment
 * 	specifies which 1 of 3 areas the children are placed into
 * 
 * ALIGN_BEGIN means either left or top
 * ALIGN_END means either right or bottom
 * ALIGN_CENTER means in the middle
 *  
 * secondaryAlignment - how the children are lined up in secondary axis
 *   if horizontal - specfies if children are aligned to their tops, center or bottom
 * 	 if vertical - specifies if children are aligned to left, right or center.
 * 
 */

public class AlignedFlowLayout extends AbstractHintLayout {
	/*
	 * Constants defining the alignment of the components
	 */
	public static final int ALIGN_CENTER = 0, ALIGN_BEGIN = 1, ALIGN_END = 2;
	public static final boolean HORIZONTAL = true, VERTICAL = false;

	protected boolean horizontal = true;
	protected boolean fill = false;
	protected boolean fillParent = false;

	protected Transposer transposer;
	{
		transposer = new Transposer();
		transposer.setEnabled(!horizontal);
	}

	/*
	 * Internal state
	 */
	protected int horizontalAlignment = ALIGN_BEGIN;
	protected int verticalAlignment = ALIGN_BEGIN;
	protected int secondaryAlignment = ALIGN_BEGIN;
	
	
	protected int horizontalSpacing = 5, verticalSpacing = 5;
	private WorkingData data = null;

	/**
	 * Holds the necessary information for layout calculations.
	 */
	class WorkingData {
		int rowHeight, rowWidth, rowCount, rowX, rowY; 
		Rectangle bounds[], area;
		IFigure row[];
		Dimension spacing;
	}

	public AlignedFlowLayout() {
	}

	public AlignedFlowLayout(boolean isHorizontal) {
		setHorizontal(isHorizontal);
	}

	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		int cHorizontalSpacing = horizontalSpacing;
		if (!isHorizontal()) {
			cHorizontalSpacing = verticalSpacing;
		}
		
		// Subtract out the insets from the hints
		if (wHint > -1)
			wHint = Math.max(0, wHint - container.getInsets().getWidth());
		if (hHint > -1)
			hHint = Math.max(0, hHint - container.getInsets().getHeight());

		// Figure out the new hint that we are interested in based on the orientation
		// Ignore the other hint (by setting it to -1).  NOTE: The children of the
		// parent figure will then be asked to ignore that hint as well.  
		int maxWidth;
		if (isHorizontal()) {
			maxWidth = wHint;
			hHint = -1;
		} else {
			maxWidth = hHint;
			wHint = -1;
		}
		if (maxWidth <= 0) {
			maxWidth = Integer.MAX_VALUE;
		}

		// The preferred dimension that is to be calculated and returned
		Dimension prefSize = new Dimension();

		List children = container.getChildren();
		int width = 0;
		int height = 0;
		IFigure child;
		Dimension childSize;

		//Build the sizes for each row, and update prefSize accordingly
		for (int i = 0; i < children.size(); i++) {
			child = (IFigure) children.get(i);
			childSize = transposer.t(getChildSize(child, wHint, hHint));
			if (i == 0) {
				width = childSize.width;
				height = childSize.height;
			} else 
			{
				// fit another child.
				width += childSize.width + cHorizontalSpacing;
				height = Math.max(height, childSize.height);
			}
		}

		// Flush out the last row's data
		prefSize.height += height;
		prefSize.width = Math.max(prefSize.width, width);

		// Transpose the dimension back, and compensate for the border.
		prefSize = transposer.t(prefSize);
		prefSize.width += container.getInsets().getWidth();
		prefSize.height += container.getInsets().getHeight();
		prefSize.union(getBorderPreferredSize(container));
		return prefSize;
	}

	/**
	 * Provides the given child's preferred size
	 * 
	 * @param child	The Figure whose preferred size needs to be calculated
	 * @param wHint	The width hint to be used when calculating the child's preferred size
	 * @param hHint	The height hint to be used when calculating the child's preferred size
	 * @return the child's preferred size
	 */
	protected Dimension getChildSize(IFigure child, int wHint, int hHint) {
		return child.getPreferredSize(wHint, hHint);
	}

	public int getHorizontalAlignment() {
		return horizontalAlignment;
	}

	public int getVerticalSpacing() {
		return verticalSpacing;
	}

	public int getVerticalAlignment() {
		return verticalAlignment;
	}

	public int getHorizontalSpacing() {
		return horizontalSpacing;
	}

	/**
	 * Initializes the state of row data, which is internal
	 * to the layout process. 
	 */
	private void initRow() {
		data.rowX = 0;
		data.rowHeight = 0;
		data.rowWidth = 0;
		data.rowCount = 0;
	}

	/**
	 * Initializes state data for laying out children, based
	 * on the Figure given as input.
	 *
	 * @param parent  Figure for which the children are to 
	 *                 be arranged.
	 * @since 2.0 
	 */
	private void initVariables(IFigure parent) {
		data.row = new IFigure[parent.getChildren().size()];
		data.bounds = new Rectangle[data.row.length];
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	@Override
	protected boolean isSensitiveHorizontally(IFigure parent) {
		return isHorizontal();
	}

	@Override
	protected boolean isSensitiveVertically(IFigure parent) {
		return !isHorizontal();
	}

	public void layout(IFigure parent) {
		data = new WorkingData();
		Rectangle relativeArea = parent.getClientArea();
		data.area = transposer.t(relativeArea);
		data.spacing = transposer.t(new Dimension(horizontalSpacing, verticalSpacing));

		Iterator iterator = parent.getChildren().iterator();
		int dx;

		//Calculate the hints to be passed to children
		int wHint = -1;
		int hHint = -1;
		if (isHorizontal())
			wHint = parent.getClientArea().width;
		else
			hHint = parent.getClientArea().height;

		initVariables(parent);
		initRow();
		int i = 0;
		while (iterator.hasNext()) {
			IFigure f = (IFigure) iterator.next();
			Dimension pref = transposer.t(getChildSize(f, wHint, hHint));
			Rectangle r = new Rectangle(0, 0, pref.width, pref.height);
			r.x = data.rowX;
			r.y = data.rowY;
			dx = r.width + data.spacing.width;
			data.rowX += dx;
			data.rowWidth += dx;
			data.rowHeight = Math.max(data.rowHeight, r.height);
			if (fillParent)
			    data.rowHeight = Math.max(data.area.height, r.height);
			
			data.row[data.rowCount] = f;
			data.bounds[data.rowCount] = r;
			data.rowCount++;
			i++;
		}
		if (data.rowCount != 0)
			layoutRow(parent);
		data = null;
	}

	/**
	 * Layouts one row of components. This is done based on
	 * the layout's orientation, minor alignment and major alignment.
	 *
	 * @param parent  Figure whose children are to be placed.
	 * @since 2.0
	 */
	protected void layoutRow(IFigure parent) {
		int majorAdjustment = 0;
		int minorAdjustment = 0;
		int justification = 0;
		int correctHorizontalAlignment = horizontalAlignment;
		int correctVerticalAlignment = verticalAlignment;

		majorAdjustment = data.area.width - data.rowWidth;
		if (!isHorizontal()) {
			correctHorizontalAlignment = verticalAlignment;
			correctVerticalAlignment = horizontalAlignment;
		}
		switch (correctHorizontalAlignment) {
			case ALIGN_BEGIN :
				majorAdjustment = 0;
				break;
			case ALIGN_CENTER :
				majorAdjustment /= 2;
				break;
			case ALIGN_END :
				break;
		}
		minorAdjustment = data.area.height - data.rowHeight;
		switch (correctVerticalAlignment) {
			case ALIGN_BEGIN :
				minorAdjustment = 0;
				break;
			case ALIGN_CENTER :
				minorAdjustment /= 2;
				break;
			case ALIGN_END :
				break;
		}

		for (int j = 0; j < data.rowCount; j++) {
			if (fill) {
				data.bounds[j].height = data.rowHeight;
			} else {
				justification = data.rowHeight - data.bounds[j].height;
				switch (secondaryAlignment) {
					case ALIGN_BEGIN :
						justification = 0;
						break;
					case ALIGN_CENTER :
						justification /= 2;
						break;
					case ALIGN_END :
						break;
				}
				data.bounds[j].y += minorAdjustment + justification;
			}
			data.bounds[j].x += majorAdjustment;

			setBoundsOfChild(parent, data.row[j], transposer.t(data.bounds[j]));
		}
		data.rowY += data.spacing.height + data.rowHeight;
		initRow();
	}

	/**
	 * Sets the given bounds for the child figure input.
	 *
	 * @param parent  Parent Figure which holds the child.
	 * @param child   Child Figure whose bounds are to be set.
	 * @param bounds  The size of the child to be set.
	 * @since 2.0
	 */
	protected void setBoundsOfChild(IFigure parent, IFigure child, Rectangle bounds) {
		parent.getClientArea(Rectangle.SINGLETON);
		bounds.translate(Rectangle.SINGLETON.x, Rectangle.SINGLETON.y);
		child.setBounds(bounds);
	}

	/**
	 * Sets flag based on layout orientation.
	 * If in Horizontal orientation, all Figures will have the same height.
	 * If in vertical orientation, all Figures will have the same width.
	 *
	 * @param value  Fill state desired.
	 * @since 2.0
	 */
	public void setStretchMinorAxis(boolean value) {
		fill = value;
	}

	public void setHorizontal(boolean flag) {
		if (horizontal == flag)
			return;
		invalidate();
		horizontal = flag;
		transposer.setEnabled(!horizontal);
	}

	public void setHorizontalAlignment(int align) {
		horizontalAlignment = align;
	}

	/**
	 * Sets the spacing in pixels to be used between children in 
	 * the direction parallel to the layout's orientation.
	 *
	 * @param n  Amount of major space.
	 * @see  #setHorizontalSpacing(int)
	 * @since 2.0
	 */
	public void setVerticalSpacing(int n) {
		verticalSpacing = n;
	}

	public void setVerticalAlignment(int align) {
		verticalAlignment = align;
	}

	public void setHorizontalSpacing(int n) {
		horizontalSpacing = n;
	}
	
	public int getSecondaryAlignment() {
		return secondaryAlignment;
	}

	public void setSecondaryAlignment(int i) {
		secondaryAlignment = i;
	}
	
	/**
	 * 
	 * @param fillParent - if setStretchMinorAxis is true, setting
	 * this flag will make the stretch fill the client area of the container
	 */
    public void setStretchMinorAxisToParent(boolean fillParent) {
        this.fillParent = fillParent;
    }


}