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
package org.eclipse.bpel.ui.editparts.borders;

import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;


/**
 * This is the border for sequence, switch, pick and while.
 * 
 * When expanded it displays a label and text at the top as well as showing the
 * contents.
 */
public class ContainerBorder extends CollapsableBorder {
	
	// The horizontal margin between the border and the image/text 
	private static final int leftMargin = 6;
	private static final int rightMargin = 10;
	// The vertical margin between the border and the image/text
	private static final int topMargin = 6;
	private static final int bottomMargin = 3;
	
	// space between image and label
	static final int spacing = 5;
	static final int borderWidth = 1;
	static final int margin = 11;
	
	// space between the inside of the border and the contents
	static final int hBorderInsets = 3;
	static final int vBorderInsets = 22;
	
	// We keep this round rect around to paint.
	private RoundedRectangle roundRect;
	
	// The bounds of the "-" icon at the top and bottom of the expanded figure
	private Rectangle rectExpandedTop, rectExpandedBottom;

	// The calculated bounds of the label and the image when expanded
	private Rectangle rectLabel, rectImageLabel;

	// The bounds of the round rectangle surrounding the label and image 
	// when expanded
	private Rectangle rectLabelBorder;
	
	// The bounds of the rectangle surrounding the children when expanded.
	// Computed to take into account drawers.
	private Rectangle expandedBounds;
	
	public ContainerBorder(IFigure parentFigure, Image image, String labelText) {
		super(true, IBPELUIConstants.ARC_WIDTH, parentFigure, labelText, image);

		this.roundRect = new RoundedRectangle();
		this.roundRect.setOpaque(true);
		this.roundRect.setCornerDimensions(new Dimension(IBPELUIConstants.ARC_WIDTH, IBPELUIConstants.ARC_WIDTH));
	}

	@Override
	public Dimension getPreferredSize(IFigure f) {
		calculate(f);
		Dimension d = new Dimension(rectLabelBorder.getSize().width, rectLabelBorder.getSize().height + expandedHeight);
		d.width += DRAWER_WIDTH * 2;
		if (!isCollapsed()) {
			d.width += IBPELUIConstants.ARC_WIDTH * 2;
		}
		return d;
	}
	
	@Override
	protected void doPaint(IFigure figure, Graphics graphics, Insets insets) {
		super.doPaint(figure, graphics, insets);
		ColorRegistry registry = BPELUIPlugin.INSTANCE.getColorRegistry();
		graphics.setForegroundColor(registry.get(IBPELUIConstants.COLOR_COMPOSITE_ACTIVITY_BORDER));
		if (!isCollapsed()) {
			// Paint the round rectangle around the lower part of the figure (surrounding the
			// children figures).
			graphics.drawRoundRectangle(expandedBounds, IBPELUIConstants.ARC_WIDTH, IBPELUIConstants.ARC_WIDTH);
		}
				
		// Paint the round rectangle at the top.
		// First determine whether or not square corners are needed on the left edge.
		boolean needSquareCorners = (getTopMarker() != null) || (getBottomMarker() != null);		
		if (isCollapsed() && needSquareCorners) {
			// Remember the clipping rectangle
			Rectangle oldClip = new Rectangle();
			oldClip = graphics.getClip(oldClip);

			Rectangle clippingRect = new Rectangle(rectLabelBorder.x + rectLabelBorder.width / 2, rectLabelBorder.y, rectLabelBorder.width / 2 + 2, rectLabelBorder.height + 1);
			graphics.setClip(clippingRect);
			graphics.drawRoundRectangle(rectLabelBorder, IBPELUIConstants.ARC_WIDTH, IBPELUIConstants.ARC_WIDTH);
			clippingRect = new Rectangle(rectLabelBorder.x, rectLabelBorder.y, rectLabelBorder.width / 2 + 1, rectLabelBorder.height + 1);
			graphics.setClip(clippingRect);
			graphics.drawRectangle(rectLabelBorder);
			
			// Restore the clipping
			graphics.setClip(oldClip);
		} else {
			roundRect.setBounds(rectLabelBorder);
			roundRect.setForegroundColor(BPELUIPlugin.INSTANCE.getColorRegistry().get(IBPELUIConstants.COLOR_ACTIVITY_BORDER));
			roundRect.paint(graphics);
		}
		
		Color old = graphics.getForegroundColor();
		graphics.setForegroundColor(registry.get(IBPELUIConstants.COLOR_BLACK));
		collapsedNameLabel.setBounds(rectLabel);
		collapsedNameLabel.paint(graphics);
		imageLabel.setBounds(rectImageLabel);
		imageLabel.paint(graphics);
		graphics.setForegroundColor(old);
				
		if (isCollapsed()) {
			graphics.drawImage(collapsedImage, rectCollapsed.getLocation());
		} else {
			graphics.drawImage(expandedImage, rectExpandedTop.getLocation());
			graphics.drawImage(expandedImage, rectExpandedBottom.getLocation());
		}			
	}
	
	// Initialize a bunch of location and size variables based on the contents
	@Override
	protected void calculate(IFigure figure) {
		super.calculate(figure);

		// bounds of the figure that we are given
		Rectangle figureBounds = figure.getBounds().getCopy();
		
		// preferred size of the image
		Dimension imageLabelSize = imageLabel.getPreferredSize().getCopy();
		// preferred size of the text label
		Dimension labelSize = collapsedNameLabel.getPreferredSize().getCopy();
		
		// calculate the label border for the round rectangle
		// surrounding the label and image
		int w = labelSize.width + spacing + imageLabelSize.width;
		int h = Math.max(labelSize.height, imageLabelSize.height);
		int x = figureBounds.x + figureBounds.width / 2 - (w/2);
		int y = figureBounds.y;
		rectLabelBorder = new Rectangle(x, y, w, h);

		// expand the border for aesthetics and to account for arc size.
		// note we don't use the entire arc size to conserve space.
		// also remember we can't expand in the upwards direction.
		int verticalMargin = topMargin + bottomMargin;
		if (isCollapsed()) verticalMargin--;
		rectLabelBorder.expand(new Insets(0, leftMargin, verticalMargin, rightMargin));
		
		// rectangle for image label
		x = rectLabelBorder.x + leftMargin;
		y = rectLabelBorder.y + topMargin;
		w = imageLabelSize.width;
		h = imageLabelSize.height;
		rectImageLabel = new Rectangle(x, y, w, h);
					
		// rectangle for text label	
		x = rectLabelBorder.x + leftMargin + imageLabelSize.width + spacing;
		y = rectLabelBorder.y + topMargin;
		w = labelSize.width;
		h = labelSize.height;
		rectLabel = new Rectangle(x, y, w, h);
		
		// calculate the size of the round rectangle surrounding the children,
		// taking into account arc size and drawer width
		this.expandedBounds = figureBounds.getCopy();
		// adjust for drawer width
		expandedBounds.x += DRAWER_WIDTH;
		expandedBounds.width -= DRAWER_WIDTH * 2;
		// adjust for half height of the label and image
		expandedBounds.y += rectLabelBorder.height / 2;
		expandedBounds.height -= rectLabelBorder.height / 2;
		// subtract half the height of the minus button at the bottom.
		expandedBounds.height -= expandedHeight / 2;
		
		// area for plus/minus buttons
		rectExpandedTop = new Rectangle(rectLabelBorder.x + rectLabelBorder.width/2 - expandedWidth/2, rectLabelBorder.y + rectLabelBorder.height - 1, expandedWidth, expandedHeight);
		rectExpandedBottom = new Rectangle(figureBounds.x + figureBounds.width / 2 - expandedWidth / 2, figureBounds.y + figureBounds.height - expandedHeight, expandedWidth, expandedHeight);
		
		// Top drawer
		IMarker topMarker = getTopMarker();
		if (topMarker != null) {
			// Draw the image for the top drawer
			if (isCollapsed()) {
				topDrawerLocation.x = collapsedRectangle.x - DRAWER_WIDTH + DRAWER_INSET + 1;
				topDrawerLocation.y = collapsedRectangle.y;
			} else {
				topDrawerLocation.x = expandedBounds.x - DRAWER_WIDTH;
				topDrawerLocation.y = expandedBounds.y + IBPELUIConstants.ARC_WIDTH;
			}
		}
		// Bottom drawer
		IMarker bottomMarker = getBottomMarker();
		if (bottomMarker != null) {
			// Draw the image for the bottom drawer
			if (isCollapsed()) {
				bottomDrawerLocation.x = collapsedRectangle.x - DRAWER_WIDTH + DRAWER_INSET + 1;
				bottomDrawerLocation.y = collapsedRectangle.y + DRAWER_HALF_HEIGHT;
			} else {
				bottomDrawerLocation.x = expandedBounds.x - DRAWER_WIDTH;
				bottomDrawerLocation.y = expandedBounds.y + DRAWER_HALF_HEIGHT + IBPELUIConstants.ARC_WIDTH;
			}
		}
		// Top drawer marker image
		Image topImage = getTopImage();
		if (topImage != null) {
			if (isCollapsed()) {
				topImageLocation.x = collapsedRectangle.x - DRAWER_WIDTH + DRAWER_INSET + 2;
				topImageLocation.y = collapsedRectangle.y + DRAWER_INSET;
			} else {
				topImageLocation.x = expandedBounds.x - DRAWER_WIDTH + DRAWER_INSET;
				topImageLocation.y = expandedBounds.y + IBPELUIConstants.ARC_WIDTH + DRAWER_INSET;
			}
		}
		// Bottom drawer marker image
		Image bottomImage = getBottomImage();
		if (bottomImage != null) {
			if (isCollapsed()) {
				bottomImageLocation.x = collapsedRectangle.x - DRAWER_WIDTH + DRAWER_INSET + 2;
				bottomImageLocation.y = collapsedRectangle.y + DRAWER_INSET + DRAWER_HALF_HEIGHT;
			} else {
				bottomImageLocation.x = expandedBounds.x - DRAWER_WIDTH + DRAWER_INSET;
				bottomImageLocation.y = expandedBounds.y + IBPELUIConstants.ARC_WIDTH + DRAWER_HALF_HEIGHT + DRAWER_INSET;
			}
		}
		
	}
	
	/**
	 * Compute the insets. We only know how to do this for expanded borders,
	 * so delegate to super in the collapsed state.
	 */
	@Override
	public Insets getInsets(IFigure figure) {
		if (isCollapsed()) return super.getInsets(figure);
		calculate(figure);
		Insets result = new Insets(vBorderInsets + rectLabelBorder.height, hBorderInsets, vBorderInsets, hBorderInsets);
		result.left += DRAWER_WIDTH;
		result.right += DRAWER_WIDTH;
		return result;
	}

	/**
	 * throw away values that determine the layout
	 */
	@Override
	public void invalidate() {
		super.invalidate();
		rectLabelBorder = null;
		rectLabel = null;
		rectExpandedTop = null;
		rectExpandedBottom = null;
	}

	/**
	 * Tests whether the given point is inside the collapse image. The superclass
	 * does not know where the collapse image(s) is located.
	 */
	@Override
	public boolean isPointInCollapseImage(int x, int y) {
		if (isCollapsed()) return super.isPointInCollapseImage(x, y);
		Point p = new Point(x,y);
		parentFigure.translateToRelative(p);
		Rectangle rect = rectExpandedTop.getCopy();
		rect.expand(new Insets(1,1,1,1));
		if (rect.contains(p)) return true;
		if (!isCollapsed()) {
			rect = rectExpandedBottom.getCopy();
			rect.expand(new Insets(1,1,1,1));
			return rect.contains(p);
		}
		return false;
	}
	
	/**
	 * Provide gradient rectangle.
	 */
	@Override
	protected Rectangle getGradientRect() {
		if (isCollapsed()) return super.getGradientRect();
		invalidate();
		calculate(parentFigure);
		return expandedBounds;
	}
	
	/**
	 * Edit parts may like to know what the top inset is - this is
	 * the distance between the top of the border and the top of the
	 * container round rectangle. This is useful because this is where
	 * selection handles are often located.
	 */
	public int getTopInset() {
		// HACK! This is necessary to prevent certain NPEs.
		if (rectLabelBorder == null || expandedBounds == null) {
			calculate(parentFigure);
		}
		
		return expandedBounds.y - rectLabelBorder.y;
	}
}
