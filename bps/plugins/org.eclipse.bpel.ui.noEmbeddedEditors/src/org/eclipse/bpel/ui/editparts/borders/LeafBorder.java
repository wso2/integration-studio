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
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Image;


public class LeafBorder extends GradientBorder {
	
	// The horizontal margin between the border and the image/text 
	private static final int leftMargin = 6;
	private static final int rightMargin = 13;
	// The vertical margin between the border and the image/text
	private static final int topMargin = 4;
	private static final int bottomMargin = 3;
	
	// The width of the border and the drawer border.
	private static final int borderWidth = 1;
	
	private static final int yHandlerIconOffset = 5;
	
	private int faultImageWidth, faultImageHeight;
	private int compensationImageWidth, compensationImageHeight;
	private int eventImageWidth, eventImageHeight;
	private Image compensationImage;
	private Image faultImage;
	private Image eventImage;
	private boolean showFault;
	private boolean showCompensation;
	private boolean showEvent;
	private Rectangle rectFault;
	private Rectangle rectCompensation;
	private Rectangle rectEvent;
	private Rectangle bounds;
	
	// Parent figure used for absolute bounds conversion
	private IFigure parentFigure;
	
	private Rectangle rectBounds;
	
	private IFigure faultImageFigure;
	private IFigure compensationImageFigure;
	private IFigure eventImageFigure;
	
	public LeafBorder(IFigure parentFigure) {
		super(false, IBPELUIConstants.ARC_WIDTH);
		this.parentFigure = parentFigure;

		// Initialize images for fault, compensation and event handler decorations
		this.faultImage = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_FAULT_INDICATOR);
		org.eclipse.swt.graphics.Rectangle r = faultImage.getBounds();
		this.faultImageWidth = r.width;
		this.faultImageHeight = r.height;

		this.compensationImage = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_COMPENSATION_INDICATOR);
		r = compensationImage.getBounds();
		this.compensationImageWidth = r.width;
		this.compensationImageHeight = r.height;

		this.eventImage = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_EVENT_INDICATOR);
		r = eventImage.getBounds();
		this.eventImageWidth = r.width;
		this.eventImageHeight = r.height;
		
		faultImageFigure = new ImageFigure(faultImage);
		faultImageFigure.setParent(parentFigure);
		
		compensationImageFigure = new ImageFigure(compensationImage);
		compensationImageFigure.setParent(parentFigure);
		
		eventImageFigure = new ImageFigure(eventImage);
		eventImageFigure.setParent(parentFigure);
	}

	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		this.bounds = figure.getBounds();
		ColorRegistry registry = BPELUIPlugin.INSTANCE.getColorRegistry();
		graphics.setForegroundColor(registry.get(IBPELUIConstants.COLOR_ACTIVITY_BORDER));
		int arcSize = IBPELUIConstants.ARC_WIDTH;
		// Remember the clipping rectangle
		Rectangle oldClip = new Rectangle();
		oldClip = graphics.getClip(oldClip);
		
		IMarker topMarker = getTopMarker();
		IMarker bottomMarker = getBottomMarker();
		if (topMarker != null || bottomMarker != null) {
			// Draw the drawers
			Rectangle clippingRect;
			if (bottomMarker == null) {
				clippingRect = new Rectangle(bounds.x, bounds.y, DRAWER_WIDTH, DRAWER_HALF_HEIGHT + 1);
			} else if (topMarker == null) {
				clippingRect = new Rectangle(bounds.x, bounds.y + DRAWER_HALF_HEIGHT, DRAWER_WIDTH, DRAWER_HALF_HEIGHT + 1);
			} else {
				clippingRect = new Rectangle(bounds.x, bounds.y, DRAWER_WIDTH, DRAWER_HEIGHT + 1);
			}
			graphics.setClip(clippingRect);
			// -1 due to GEF
			graphics.drawRoundRectangle(new Rectangle(bounds.x + DRAWER_INSET, bounds.y, DRAWER_WIDTH * 2, DRAWER_HEIGHT - 1), IBPELUIConstants.ARC_WIDTH, IBPELUIConstants.ARC_WIDTH);
			graphics.setClip(oldClip);
			if (bottomMarker == null || topMarker == null) {
				graphics.drawLine(bounds.x + DRAWER_INSET, bounds.y + DRAWER_HALF_HEIGHT, bounds.x + DRAWER_WIDTH, bounds.y + DRAWER_HALF_HEIGHT);
			}
		}
		
		// Draw the actual breakpoints
		Image topImage = getTopImage();
		if (topImage != null) {
			int x = bounds.x + DRAWER_INSET;
			int y = bounds.y + DRAWER_INSET;
			graphics.drawImage(topImage, x, y);
		}
		Image bottomImage = getBottomImage();
		if (bottomImage != null) {
			int x = bounds.x + DRAWER_INSET;
			int y = bounds.y + DRAWER_INSET + DRAWER_HALF_HEIGHT;
			graphics.drawImage(bottomImage, x, y);
		}
		
		// Determine whether or not square corners are needed on the left edge.
		boolean needSquareCorners = (topImage != null) || (bottomImage != null);
		
		// Calculate the bounding rectangle for the round rectangle
		this.rectBounds = new Rectangle();
		rectBounds.x = bounds.x + DRAWER_WIDTH;
		rectBounds.y = bounds.y;
		rectBounds.width = bounds.width - DRAWER_WIDTH * 2;
		// -1 due to GEF
		rectBounds.height = bounds.height - 1;

		if (needSquareCorners) {
			Rectangle clippingRect = new Rectangle(rectBounds.x + rectBounds.width / 2, rectBounds.y, rectBounds.width / 2 + 2, rectBounds.height + 1);
			graphics.setClip(clippingRect);
			graphics.drawRoundRectangle(rectBounds, arcSize, arcSize);
			clippingRect = new Rectangle(rectBounds.x, rectBounds.y, rectBounds.width / 2 + 1, rectBounds.height + 1);
			graphics.setClip(clippingRect);
			graphics.drawRectangle(rectBounds);
			graphics.setClip(oldClip);
		} else {
			graphics.drawRoundRectangle(rectBounds, arcSize, arcSize);
		}
		
		computeHandlerIconPositions(ModelHelper.isHorizontalLayout(getEditPart().getModel()));

		// Draw the fault image in the upper right hand corner of the round rectangle
		if (showFault) {
			graphics.setClip(faultImageFigure.getBounds().getCopy());
			faultImageFigure.paint(graphics);
			graphics.setClip(oldClip);
		}
		// Draw the compensation image in the upper right hand corner of the round rectangle
		if (showCompensation) {
			graphics.setClip(compensationImageFigure.getBounds().getCopy());
			compensationImageFigure.paint(graphics);
			graphics.setClip(oldClip);
		}
		if (showEvent) {
			graphics.setClip(eventImageFigure.getBounds().getCopy());
			eventImageFigure.paint(graphics);
			graphics.setClip(oldClip);
		}
	}

	@Override
	public Insets getInsets(IFigure figure) {
		return new Insets(borderWidth + topMargin, borderWidth + leftMargin + DRAWER_WIDTH, borderWidth + bottomMargin, borderWidth + rightMargin + DRAWER_WIDTH);
	}

	public void setFaultImage(Image faultImage) {
		this.faultImage = faultImage;
		org.eclipse.swt.graphics.Rectangle r = faultImage.getBounds();
		this.faultImageWidth = r.width;
		this.faultImageHeight = r.height;
	}
	public boolean isPointInFaultImage(int x, int y) {
		if (showFault) {
			Point p = new Point(x, y);
			parentFigure.translateToRelative(p);
			return rectFault.contains(p);
		}
		return false;
	}	
	public void setShowFault(boolean showFault) {
		this.showFault = showFault;
	}
	
	public void setCompensationImage(Image compensationImage) {
		this.compensationImage = compensationImage;
		org.eclipse.swt.graphics.Rectangle r = compensationImage.getBounds();
		this.compensationImageWidth = r.width;
		this.compensationImageHeight = r.height;
	}
	public boolean isPointInCompensationImage(int x, int y) {
		if (showCompensation) {
			Point p = new Point(x, y);
			parentFigure.translateToRelative(p);
			return rectCompensation.contains(p);
		}
		return false;
	}	
	public void setShowCompensation(boolean showCompensation) {
		this.showCompensation = showCompensation;
	}
	
	public void setEventImage(Image eventImage) {
		this.eventImage = eventImage;
		org.eclipse.swt.graphics.Rectangle r = eventImage.getBounds();
		this.eventImageWidth = r.width;
		this.eventImageHeight = r.height;
	}
	public boolean isPointInEventImage(int x, int y) {
		if (showEvent) {
			Point p = new Point(x, y);
			parentFigure.translateToRelative(p);
			return rectEvent.contains(p);
		}
		return false;
	}	
	public void setShowEvent(boolean showEvent) {
		this.showEvent = showEvent;
	}
	
	@Override
	protected Rectangle getGradientRect() {
		Rectangle bounds = parentFigure.getBounds();
		this.rectBounds = new Rectangle();
		rectBounds.x = bounds.x + DRAWER_WIDTH;
		rectBounds.y = bounds.y;
		rectBounds.width = bounds.width - DRAWER_WIDTH * 2;
		rectBounds.height = bounds.height;
		if (Platform.getWS().equals(Platform.WS_GTK)) {
			rectBounds.height = rectBounds.height - 1;
		}
		return rectBounds;
	}
	@Override
	public boolean isPointInTopDrawer(int x, int y) {
		if (getTopMarker() == null) return false;
		if (bounds == null) return false;
		Point p = new Point(x, y);
		parentFigure.translateToRelative(p);
		Image image = getTopImage();
		org.eclipse.swt.graphics.Rectangle imageSize = image.getBounds();
		int imageX = bounds.x + DRAWER_INSET;
		int imageY = bounds.y + DRAWER_INSET + 2;
		Rectangle imageBounds = new Rectangle(imageX, imageY, imageSize.width, imageSize.height);
		return imageBounds.contains(p);
	}
	@Override
	public boolean isPointInBottomDrawer(int x, int y) {
		if (getBottomMarker() == null) return false;
		if (bounds == null) return false;
		Point p = new Point(x, y);
		parentFigure.translateToRelative(p);
		Image image = getBottomImage();
		org.eclipse.swt.graphics.Rectangle imageSize = image.getBounds();
		int imageX = bounds.x + DRAWER_INSET;
		int imageY = bounds.y + DRAWER_INSET + 2 + DRAWER_HALF_HEIGHT;
		Rectangle imageBounds = new Rectangle(imageX, imageY, imageSize.width, imageSize.height);
		return imageBounds.contains(p);
	}	
	
	private void computeHandlerIconPositions(boolean horizontal){
		if(horizontal){
			// Draw the fault image in the upper right hand corner of the round rectangle
			if (showFault) {
				int x = bounds.x + bounds.width - faultImageWidth - DRAWER_WIDTH+1;
				if(showCompensation)
					x -= compensationImageWidth;
				if(showEvent)
					x -= eventImageWidth;
				this.rectFault = new Rectangle(x, getGradientRect().y+getGradientRect().height-faultImageHeight+yHandlerIconOffset, faultImageWidth, faultImageHeight);
			}
			// Draw the compensation image in the upper right hand corner of the round rectangle
			if (showCompensation) {
				int x = bounds.x + bounds.width - compensationImageWidth - DRAWER_WIDTH+1;
				if(showEvent)
					x -= eventImageWidth;
				this.rectCompensation = new Rectangle(x,  getGradientRect().y+getGradientRect().height-compensationImageHeight+yHandlerIconOffset, compensationImageWidth, compensationImageHeight);
			}
			if (showEvent) {
				int x = bounds.x + bounds.width - eventImageWidth - DRAWER_WIDTH+1;
				this.rectEvent = new Rectangle(x,  getGradientRect().y+getGradientRect().height-eventImageHeight+yHandlerIconOffset, eventImageWidth, eventImageHeight);
			}
		}else{
			// Draw the fault image in the upper right hand corner of the round rectangle
			if (showFault) {
				this.rectFault = new Rectangle(bounds.x + bounds.width - faultImageWidth - DRAWER_WIDTH+1, bounds.y, faultImageWidth, faultImageHeight);
			}
			// Draw the compensation image in the upper right hand corner of the round rectangle
			if (showCompensation) {
				int compensationImageOffset = bounds.y;
				if (showFault) {
					compensationImageOffset += faultImageHeight;
				}
				this.rectCompensation = new Rectangle(bounds.x + bounds.width - compensationImageWidth - DRAWER_WIDTH+1, compensationImageOffset, compensationImageWidth, compensationImageHeight);
			}
			if (showEvent) {
				int eventImageOffset = bounds.y;
				if (showFault) {
					eventImageOffset += faultImageHeight;
				}
				if (showCompensation) {
					eventImageOffset += compensationImageHeight;
				}
				this.rectEvent = new Rectangle(bounds.x + bounds.width - eventImageWidth - DRAWER_WIDTH+1, eventImageOffset, eventImageWidth, eventImageHeight);
			}	
		}
		
		// Apply the bounds to the figures
		if(showFault)
			faultImageFigure.setBounds(rectFault);
		if(showCompensation)
			compensationImageFigure.setBounds(rectCompensation);
		if(showEvent)
			eventImageFigure.setBounds(rectEvent);
	}

	public IFigure getFaultImageFigure() {
		return faultImageFigure;
	}

	public IFigure getCompensationImageFigure() {
		return compensationImageFigure;
	}

	public IFigure getEventImageFigure() {
		return eventImageFigure;
	}	
}
