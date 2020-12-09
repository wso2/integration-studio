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
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.bpel.ui.editparts.FlowEditPart;
import org.eclipse.core.resources.IMarker;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Image;


public class FlowBorder extends GradientBorder {
	
	static final int margin = 1;
	public static final int LINE_WIDTH = 2;
	
	private IFigure parentFigure;
	private Rectangle bounds;
	
	public FlowBorder(IFigure parentFigure) {
		super(true, IBPELUIConstants.ARC_WIDTH);
		this.parentFigure = parentFigure;
	}
	
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		this.bounds = figure.getBounds();
		
		int topDrawerX = bounds.x;
		int topDrawerY = bounds.y + IBPELUIConstants.ARC_WIDTH;
		int bottomDrawerX = bounds.x;
		int bottomDrawerY = bounds.y + IBPELUIConstants.ARC_WIDTH + DRAWER_HALF_HEIGHT;
		
		IMarker topMarker = getTopMarker();
		IMarker bottomMarker = getBottomMarker();
		if (topMarker != null || bottomMarker != null) {
			// Remember the clipping rectangle
			Rectangle oldClip = new Rectangle();
			oldClip = graphics.getClip(oldClip);

			ColorRegistry registry = BPELUIPlugin.INSTANCE.getColorRegistry();
			graphics.setForegroundColor(registry.get(IBPELUIConstants.COLOR_ACTIVITY_BORDER));
			Rectangle clippingRect;
			if (bottomMarker == null) {
				clippingRect = new Rectangle(topDrawerX, topDrawerY, DRAWER_WIDTH, DRAWER_HALF_HEIGHT + 1);
			} else if (topMarker == null) {
				clippingRect = new Rectangle(bottomDrawerX, bottomDrawerY, DRAWER_WIDTH, DRAWER_HALF_HEIGHT + 1);
			} else {
				clippingRect = new Rectangle(topDrawerX, topDrawerY, DRAWER_WIDTH, DRAWER_HEIGHT + 1);
			}
			graphics.setClip(clippingRect);
			// -1 due to GEF
			graphics.drawRoundRectangle(new Rectangle(topDrawerX + DRAWER_INSET, topDrawerY, DRAWER_WIDTH * 2, DRAWER_HEIGHT - 1), IBPELUIConstants.ARC_WIDTH, IBPELUIConstants.ARC_WIDTH);
			graphics.setClip(oldClip);
			if (bottomMarker == null || topMarker == null) {
				graphics.drawLine(topDrawerX + DRAWER_INSET, topDrawerY + DRAWER_HALF_HEIGHT, topDrawerX + DRAWER_WIDTH, topDrawerY + DRAWER_HALF_HEIGHT);
			}
		}
		
		// Draw the actual breakpoints
		Image topImage = getTopImage();
		if (topImage != null) {
			graphics.drawImage(topImage, topDrawerX, topDrawerY);
		}
		Image bottomImage = getBottomImage();
		if (bottomImage != null) {
			graphics.drawImage(bottomImage, bottomDrawerX, bottomDrawerY);
		}
		
		ColorRegistry registry = BPELUIPlugin.INSTANCE.getColorRegistry();
		graphics.setForegroundColor(registry.get(IBPELUIConstants.COLOR_COMPOSITE_ACTIVITY_BORDER));
		Rectangle roundBounds = bounds.getCopy();
		roundBounds.crop(new Insets(0, DRAWER_WIDTH, 1, DRAWER_WIDTH));
		graphics.drawRoundRectangle(roundBounds, IBPELUIConstants.ARC_WIDTH, IBPELUIConstants.ARC_WIDTH);
		graphics.setForegroundColor(registry.get(IBPELUIConstants.COLOR_FLOW_BORDER));
		int lineStartX = roundBounds.x + 15;
		int lineEndX = roundBounds.x + roundBounds.width - 15;
		graphics.drawLine(lineStartX, roundBounds.y, lineEndX, roundBounds.y);
		graphics.drawLine(lineStartX, roundBounds.y+1, lineEndX, roundBounds.y+1);
		int y = roundBounds.bottom() - LINE_WIDTH + 1;
		graphics.drawLine(lineStartX, y, lineEndX, y);
		graphics.drawLine(lineStartX, y+1, lineEndX, y+1);
	}

	@Override
	public Insets getInsets(IFigure figure) {
		return new Insets(margin + LINE_WIDTH, margin + DRAWER_WIDTH, margin + LINE_WIDTH, margin + DRAWER_WIDTH);
	}
	@Override
	public Dimension getPreferredSize(IFigure f) {
		return new Dimension(200, 200);
	}
	
	@Override
	protected Rectangle getGradientRect() {
		
		BPELEditPart ep = getEditPart();
		Rectangle rect = null;
		if (ep != null) {
			IFigure fig = ep.getContentPane();
			if (fig != null)
				rect = fig.getBounds();
			
			if (!((FlowEditPart)ep).isCollapsed()) {
				rect = rect.getCopy();
				rect.crop(new Insets(0, DRAWER_WIDTH, 0, DRAWER_WIDTH));
			}
		}
		
		return rect;
	}
	@Override
	public boolean isPointInTopDrawer(int x, int y) {
		if (bounds == null) return false;
		if (getTopMarker() == null) return false;
		Point p = new Point(x, y);
		parentFigure.translateToRelative(p);
		Image image = getTopImage();
		org.eclipse.swt.graphics.Rectangle imageSize = image.getBounds();
		int imageX = bounds.x + DRAWER_INSET;
		int imageY = bounds.y + DRAWER_INSET + IBPELUIConstants.ARC_WIDTH;
		Rectangle imageBounds = new Rectangle(imageX, imageY, imageSize.width, imageSize.height);
		return imageBounds.contains(p);
	}
	@Override
	public boolean isPointInBottomDrawer(int x, int y) {
		if (bounds == null) return false;
		if (getBottomMarker() == null) return false;
		Point p = new Point(x, y);
		parentFigure.translateToRelative(p);
		Image image = getBottomImage();
		org.eclipse.swt.graphics.Rectangle imageSize = image.getBounds();
		int imageX = bounds.x + DRAWER_INSET;
		int imageY = bounds.y + DRAWER_INSET + DRAWER_HALF_HEIGHT + IBPELUIConstants.ARC_WIDTH;
		Rectangle imageBounds = new Rectangle(imageX, imageY, imageSize.width, imageSize.height);
		return imageBounds.contains(p);
	}
}
