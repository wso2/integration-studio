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
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;


/**
 * This border knows about collapsability. Specifically, it has icons for expand
 * and collapse, does hit testing for these icons, has an image and label to use
 * when collapsed, and does complete rendering when collapsed to look similar to
 * a leaf border (except with the addition of an expand icon).
 * 
 * It does not do rendering for the expanded state. The rationale is that things
 * should look similar when collapsed (like a leaf node) but may have different
 * appearances when expanded.
 */
public abstract class CollapsableBorder extends GradientBorder {

	// Whether or not we are collapsed.
	private boolean collapsed = false;
	// The location of the collapsed image (+).
	protected Rectangle rectCollapsed;
	// The images for collapsed (+) and expanded (-).
	protected Image collapsedImage, expandedImage;
	// The width and height of the expanded image. Collapsed should be the same.
	protected int expandedWidth, expandedHeight;
	// The label to use when collapsed. Subclasses may also use it when expanded.
	protected Label collapsedNameLabel = null;
	// The image to use when collapsed. Subclasses may also use it when expanded.
	protected Image image;
	// The label containing the image.
	protected ImageFigure imageLabel = null;
	// Our parent figure. Used for relative location calculation.
	protected IFigure parentFigure;
	// The calculated rectangle for the collapsed border. This is null
	// when not collapsed, so subclasses shouldn't assume it's there.
	protected Rectangle collapsedBounds;
	// The calculated location of the top and bottom drawer images as well as
	// the top and bottom drawers themselves.
	protected Point topImageLocation = new Point(), bottomImageLocation = new Point();
	protected Point topDrawerLocation = new Point(), bottomDrawerLocation = new Point();
	// The calculated bounds of the rectangle to draw when collapsed
	protected Rectangle collapsedRectangle;
	
	public CollapsableBorder(boolean isVertical, int arcWidth, IFigure parentFigure, String labelText, Image image) {
		super(isVertical, arcWidth);
		this.parentFigure = parentFigure;
		
		this.image = image;
		this.imageLabel = new ImageFigure(image);

		this.collapsedImage = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_FIGURE_COLLAPSED);
		this.expandedImage = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_FIGURE_EXPANDED);
		this.expandedHeight = expandedImage.getBounds().height;
		this.expandedWidth = expandedImage.getBounds().width;
		
		this.collapsedNameLabel = new Label(labelText);
		this.collapsedNameLabel.setFont(JFaceResources.getFontRegistry().get(JFaceResources.DEFAULT_FONT));
	}
	
	/**
	 * Tests whether the given point is inside the collapsed image.
	 * The superclass only knows where the collapsed image is located; if subclasses
	 * want to do hit testing on the expanded image, they may override but may want
	 * to call super if we are collapsed.
	 */
	public boolean isPointInCollapseImage(int x, int y) {
		if (!isCollapsed()) return false;
		Point p = new Point(x,y);
		parentFigure.translateToRelative(p);
		Rectangle rect = rectCollapsed.getCopy();
		rect.expand(new Insets(1,1,1,1));
		return rect.contains(p);
	}
	
	public boolean isCollapsed() {
		return collapsed;
	}
	
	public void setCollapsed(boolean showCollapse) {
		this.collapsed = showCollapse;
	}

	/**
	 * Throw away computed values that determine the layout
	 */
	public void invalidate() {
		// rectCollapsed = null;
		collapsedBounds = null;
	}
	
	public Label getLabel() {
		return collapsedNameLabel;
	}

	public void setName(String name) {
		collapsedNameLabel.setText(name);
	}
	
	protected void calculate(IFigure figure) {
		// Calculate the coordinates for collapsed state, even though
		// we may currently be expanded.
		if (collapsedBounds == null) {
			collapsedBounds = figure.getBounds().getCopy();			
			this.collapsedRectangle = collapsedBounds.getCopy();				

			// Leave room on the left and right for the drawer.
			collapsedRectangle.x += DRAWER_WIDTH;
			collapsedRectangle.width -= DRAWER_WIDTH * 2;				

			// area for collapsed button
			rectCollapsed = new Rectangle(collapsedBounds.x + collapsedBounds.width / 2 - expandedWidth/2, collapsedBounds.y + collapsedBounds.height - expandedHeight, expandedWidth, expandedHeight);
		}
	}

	/**
	 * This method first invalidates and recalculates any bounds, and then
	 * paints the top and bottom drawers, as well as any markers contained within them.
	 */
	@Override
	public final void paint(IFigure figure, Graphics graphics, Insets insets) {
		invalidate();
		calculate(figure);
		doPaint(figure, graphics, insets);
	}

	/**
	 * Subclasses should call this paint method unless there is a very good
	 * reason for overriding its behaviour. To affect where various things
	 * appear, override the calculate() method.
	 */
	protected void doPaint(IFigure figure, Graphics graphics, Insets insets) {
		// Remember the clipping rectangle
		Rectangle oldClip = new Rectangle();
		oldClip = graphics.getClip(oldClip);

		IMarker topMarker = getTopMarker();
		IMarker bottomMarker = getBottomMarker();
		if (topMarker != null || bottomMarker != null) {
			ColorRegistry registry = BPELUIPlugin.INSTANCE.getColorRegistry();
			graphics.setForegroundColor(registry.get(IBPELUIConstants.COLOR_ACTIVITY_BORDER));
			Rectangle clippingRect;
			if (bottomMarker == null) {
				clippingRect = new Rectangle(topDrawerLocation.x, topDrawerLocation.y, DRAWER_WIDTH, DRAWER_HALF_HEIGHT + 1);
			} else if (topMarker == null) {
				clippingRect = new Rectangle(bottomDrawerLocation.x, bottomDrawerLocation.y, DRAWER_WIDTH, DRAWER_HALF_HEIGHT + 1);
			} else {
				clippingRect = new Rectangle(topDrawerLocation.x, topDrawerLocation.y, DRAWER_WIDTH, DRAWER_HEIGHT + 1);
			}
			graphics.setClip(clippingRect);
			// -1 due to GEF
			graphics.drawRoundRectangle(new Rectangle(topDrawerLocation.x + DRAWER_INSET, topDrawerLocation.y, DRAWER_WIDTH * 2, DRAWER_HEIGHT - 1), IBPELUIConstants.ARC_WIDTH, IBPELUIConstants.ARC_WIDTH);
			graphics.setClip(oldClip);
			if (bottomMarker == null || topMarker == null) {
				graphics.drawLine(topDrawerLocation.x + DRAWER_INSET, topDrawerLocation.y + DRAWER_HALF_HEIGHT, topDrawerLocation.x + DRAWER_WIDTH, topDrawerLocation.y + DRAWER_HALF_HEIGHT);
			}
			
		}
		
		// Draw the actual breakpoints
		Image topImage = getTopImage();
		if (topImage != null) {
			graphics.drawImage(topImage, topImageLocation);
		}
		Image bottomImage = getBottomImage();
		if (bottomImage != null) {
			graphics.drawImage(bottomImage, bottomImageLocation);
		}
	}	

	/**
	 * We only know about the gradient rectangle when we are collapsed.
	 * TODO: Do we need a gradient rectangle when collapsed?
	 */
	@Override
	protected Rectangle getGradientRect() {
		return new Rectangle(0,0,0,0);
	}
	
	@Override
	public boolean isPointInTopDrawer(int x, int y) {
		if (getTopMarker() == null) return false;
		Point p = new Point(x, y);
		Image image = getTopImage();
		org.eclipse.swt.graphics.Rectangle imageSize = image.getBounds();
		Rectangle imageBounds = new Rectangle(topImageLocation.x, topImageLocation.y, imageSize.width, imageSize.height);
		return imageBounds.contains(p);
	}
	
	@Override
	public boolean isPointInBottomDrawer(int x, int y) {
		if (getBottomMarker() == null) return false;
		Point p = new Point(x, y);
		Image image = getBottomImage();
		org.eclipse.swt.graphics.Rectangle imageSize = image.getBounds();
		Rectangle imageBounds = new Rectangle(bottomImageLocation.x, bottomImageLocation.y, imageSize.width, imageSize.height);
		return imageBounds.contains(p);
	}
	
	/**
	 * Calculate the insets when in the collapsed state. In expanded state, we don't
	 * know how to answer. Insets don't matter in the collapsed state because there
	 * are no children.
	 */
	@Override
	public Insets getInsets(IFigure figure) {
		return new Insets(0, 0, 0, 0);
	}	
}
