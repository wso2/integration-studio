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
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;


/**
 * This is the border for scope.
 */
public class ScopeBorder extends CollapsableBorder {
	
	// TODO: Move these or remove them
	static final int borderWidth = 1;
	static final int margin = 11;
	// space between the inside of the border and the contents
	static final int hBorderInsets = 11;
	static final int vBorderInsets = 16;
	// extra horizontal space to use when we have no children.
	static final int extraHorizontalSpace = 50;
	
	// Location of the "-" icons when the border is expanded
	private Rectangle rectExpandedTop, rectExpandedBottom;

	// The bounds of the border of the scope when expanded. Takes
	// into account space for the drawer.
	private Rectangle expandedBounds;
	
	// Fault handler, Compensation handler and Event handler support
	private int faultImageWidth, faultImageHeight;
	private int compensationImageWidth, compensationImageHeight;
	private int terminationImageWidth, terminationImageHeight;
	private int eventImageWidth, eventImageHeight;
	private Image compensationImage;
	private Image terminationImage;
	private Image faultImage;
	private Image eventImage;
	private boolean showFault;
	private boolean showCompensation;
	private boolean showTermination;
	private boolean showEvent;
	private Rectangle rectFault;
	private Rectangle rectCompensation;
	private Rectangle rectTermination;
	private Rectangle rectEvent;
	
	private IFigure faultImageFigure;
	private IFigure compensationImageFigure;
	private IFigure terminationImageFigure;
	private IFigure eventImageFigure;
	
	public ScopeBorder(IFigure parentFigure, String labelText, Image image) {
		super(true, IBPELUIConstants.ARC_WIDTH, parentFigure, labelText, image);
		
		// Initialize images for fault, compensation and event handler decorations
		this.faultImage = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_FAULT_INDICATOR);
		org.eclipse.swt.graphics.Rectangle r = faultImage.getBounds();
		this.faultImageWidth = r.width;
		this.faultImageHeight = r.height;

		this.compensationImage = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_COMPENSATION_INDICATOR);
		r = compensationImage.getBounds();
		this.compensationImageWidth = r.width;
		this.compensationImageHeight = r.height;

		this.terminationImage = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_TERMINATION_INDICATOR);
		r = terminationImage.getBounds();
		this.terminationImageWidth = r.width;
		this.terminationImageHeight = r.height;

		this.eventImage = BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_EVENT_INDICATOR);
		r = eventImage.getBounds();
		this.eventImageWidth = r.width;
		this.eventImageHeight = r.height;
		
		faultImageFigure = new ImageFigure(faultImage);
		faultImageFigure.setParent(parentFigure);
		
		compensationImageFigure = new ImageFigure(compensationImage);
		compensationImageFigure.setParent(parentFigure);
		
		terminationImageFigure = new ImageFigure(terminationImage);
		terminationImageFigure.setParent(parentFigure);
		
		eventImageFigure = new ImageFigure(eventImage);
		eventImageFigure.setParent(parentFigure);
	}

	@Override
	public Dimension getPreferredSize(IFigure f) {
		calculate(f);
		Dimension d = new Dimension(rectCollapsed.width, rectCollapsed.height + expandedHeight);
		d.width += DRAWER_WIDTH * 2;
		if (!isCollapsed()) {
			d.width += extraHorizontalSpace;
		}
		return d;
	}
	
	@Override
	protected void doPaint(IFigure figure, Graphics graphics, Insets insets) {
		super.doPaint(figure, graphics, insets);
		
		ColorRegistry registry = BPELUIPlugin.INSTANCE.getColorRegistry();

		Color old = graphics.getForegroundColor();
		graphics.setForegroundColor(registry.get(IBPELUIConstants.COLOR_SCOPE_BORDER));
		graphics.drawRoundRectangle(expandedBounds, IBPELUIConstants.ARC_WIDTH, IBPELUIConstants.ARC_WIDTH);
		graphics.drawRectangle(expandedBounds.x, expandedBounds.y, expandedBounds.width, 3);
		graphics.setForegroundColor(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		graphics.drawRectangle(expandedBounds.x + 1, expandedBounds.y + 1, expandedBounds.width - 2, 1);
		graphics.setForegroundColor(old);
		if (isCollapsed()) {
			graphics.drawImage(collapsedImage, rectCollapsed.getLocation());
		} else {
			graphics.drawImage(expandedImage, rectExpandedTop.getLocation());
			graphics.drawImage(expandedImage, rectExpandedBottom.getLocation());
		}
		
		Rectangle oldClip = new Rectangle();
		oldClip = graphics.getClip(oldClip);

		// Draw the fault image in the upper right hand corner of the round rectangle
		if (showFault) {
			graphics.setClip(faultImageFigure.getBounds().getCopy());
			faultImageFigure.paint(graphics);
			graphics.setClip(oldClip);
		}
		// Draw the compensation image in the upper right hand corner of the round rectangle,
		// leaving room for the fault image.
		if (showCompensation) {
			graphics.setClip(compensationImageFigure.getBounds().getCopy());
			compensationImageFigure.paint(graphics);
			graphics.setClip(oldClip);
		}
		// Draw the termination image in the upper right hand corner of the round rectangle,
		// leaving room for the fault image.
		if (showTermination) {
			graphics.setClip(terminationImageFigure.getBounds().getCopy());
			terminationImageFigure.paint(graphics);
			graphics.setClip(oldClip);
		}
		// Draw the event image in the upper right hand corner of the round rectangle,
		// leaving room for fault and compensation.
		if (showEvent) {
			graphics.setClip(eventImageFigure.getBounds().getCopy());
			eventImageFigure.paint(graphics);
			graphics.setClip(oldClip);
		}
	}
	
	@Override
	protected void calculate(IFigure figure) {
		super.calculate(figure);

		// Bounds of the figure that we are given
		Rectangle figureBounds = figure.getBounds().getCopy();
		
		// area for plus/minus buttons
		rectExpandedTop = new Rectangle(figureBounds.x + figureBounds.width / 2 - expandedWidth/2, figureBounds.y, expandedWidth, expandedHeight);
		rectExpandedBottom = new Rectangle(figureBounds.x + figureBounds.width/2 - expandedWidth/2, figureBounds.y + figureBounds.height - expandedHeight - borderWidth, expandedWidth, expandedHeight);
				
		this.expandedBounds = figureBounds.getCopy();
		// Leave room for the drawers
		expandedBounds.x += DRAWER_WIDTH;
		expandedBounds.width -= DRAWER_WIDTH * 2;
		// Leave room on the top for part of the top expanded image
		expandedBounds.y += expandedHeight / 2 - 1;
		expandedBounds.height -= expandedHeight / 2 - 1;
		// Room for the bottom
		expandedBounds.height -= expandedHeight / 2;
		
		// Calculate the positions of the handler icons
		computeHandlerIconPositions(ModelHelper.isHorizontalLayout(getEditPart().getModel()),figure);

		// Top drawer
		IMarker topMarker = getTopMarker();
		if (topMarker != null) {
			// Draw the image for the top drawer
			if (isCollapsed()) {
				topDrawerLocation.x = expandedBounds.x - DRAWER_WIDTH + DRAWER_INSET;
				topDrawerLocation.y = expandedBounds.y;
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
				bottomDrawerLocation.x = expandedBounds.x - DRAWER_WIDTH + DRAWER_INSET;
				bottomDrawerLocation.y = expandedBounds.y + DRAWER_HALF_HEIGHT;
			} else {
				bottomDrawerLocation.x = expandedBounds.x - DRAWER_WIDTH;
				bottomDrawerLocation.y = expandedBounds.y + DRAWER_HALF_HEIGHT + IBPELUIConstants.ARC_WIDTH;
			}
		}
		// Top drawer marker image
		Image topImage = getTopImage();
		if (topImage != null) {
			if (isCollapsed()) {
				topImageLocation.x = expandedBounds.x - DRAWER_WIDTH + DRAWER_INSET + 1;
				topImageLocation.y = expandedBounds.y + DRAWER_INSET;
			} else {
				topImageLocation.x = expandedBounds.x - DRAWER_WIDTH + DRAWER_INSET;
				topImageLocation.y = expandedBounds.y + IBPELUIConstants.ARC_WIDTH + DRAWER_INSET;
			}
		}
		// Bottom drawer marker image
		Image bottomImage = getBottomImage();
		if (bottomImage != null) {
			if (isCollapsed()) {
				bottomImageLocation.x = expandedBounds.x - DRAWER_WIDTH + DRAWER_INSET + 1;
				bottomImageLocation.y = expandedBounds.y + DRAWER_INSET + DRAWER_HALF_HEIGHT;
			} else {
				bottomImageLocation.x = expandedBounds.x - DRAWER_WIDTH + DRAWER_INSET;
				bottomImageLocation.y = expandedBounds.y + IBPELUIConstants.ARC_WIDTH + DRAWER_HALF_HEIGHT + DRAWER_INSET;
			}
		}
	}
	

	@Override
	public Insets getInsets(IFigure figure) {
		calculate(figure);
		Insets result;
		// TODO: Fix
		if (isCollapsed()) {
			result = new Insets(borderWidth + margin, borderWidth + margin + DRAWER_WIDTH, borderWidth + margin, borderWidth + margin + DRAWER_WIDTH);
		} else {	
			result = new Insets(vBorderInsets + expandedHeight, hBorderInsets, vBorderInsets + expandedHeight, hBorderInsets);
			result.left += DRAWER_WIDTH;
			result.right += DRAWER_WIDTH;
		}
		return result;
	}
	
	/**
	 * Throw away values that determine the layout
	 */
	@Override
	public void invalidate() {
		rectExpandedTop = null;
		rectExpandedBottom = null;
	}

	public boolean isPointInFaultImage(int x, int y) {
		if (showFault) {
			Point p = new Point(x, y);
			parentFigure.translateToRelative(p);
			return rectFault.contains(p);
		}
		return false;
	}	

	public boolean isPointInCompensationImage(int x, int y) {
		if (showCompensation) {
			Point p = new Point(x, y);
			parentFigure.translateToRelative(p);
			return rectCompensation.contains(p);
		}
		return false;
	}	

	public boolean isPointInTerminationImage(int x, int y) {
		if (showTermination) {
			Point p = new Point(x, y);
			parentFigure.translateToRelative(p);
			return rectTermination.contains(p);
		}
		return false;
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

	public void setShowCompensation(boolean showCompensation) {
		this.showCompensation = showCompensation;
	}

	public void setShowTermination(boolean showTermination) {
		this.showTermination = showTermination;
	}

	public void setShowFault(boolean showFault) {
		this.showFault = showFault;
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
	
	private void computeHandlerIconPositions(boolean horizontal, IFigure figure){
		if(horizontal){
			// Calculate the location of the fault/event/compensation decorations
			if (showFault) {
				int x = expandedBounds.x + expandedBounds.width - faultImageWidth;
				if(showCompensation)
					x -= compensationImageWidth;
				if(showTermination)
					x -= terminationImageWidth;
				if(showEvent)
					x -= eventImageWidth;
				this.rectFault = new Rectangle(x, figure.getBounds().y+figure.getBounds().height-faultImageHeight, faultImageWidth, faultImageHeight);
			}
			if (showCompensation) {
				int x = expandedBounds.x + expandedBounds.width - compensationImageWidth;
				if(showTermination)
					x -= terminationImageWidth;
				if(showEvent)
					x -= eventImageWidth;
			 	this.rectCompensation = new Rectangle(x, figure.getBounds().y+figure.getBounds().height-compensationImageHeight, compensationImageWidth, compensationImageHeight);
			}
			if (showTermination) {
				int x = expandedBounds.x + expandedBounds.width - terminationImageWidth;
				if(showEvent)
					x -= eventImageWidth;
			 	this.rectTermination = new Rectangle(x, figure.getBounds().y+figure.getBounds().height-terminationImageHeight, terminationImageWidth, terminationImageHeight);
			}
			if (showEvent) {
				int x = expandedBounds.x + expandedBounds.width - eventImageWidth;
				this.rectEvent = new Rectangle(x, figure.getBounds().y+figure.getBounds().height-eventImageHeight, eventImageWidth, eventImageHeight);
			}
		}else{
			// Calculate the location of the fault/event/compensation decorations
			// Draw the fault image in the upper right hand corner of the round rectangle
			if (showFault) {
				int x = expandedBounds.x + expandedBounds.width - faultImageWidth +1;
				this.rectFault = new Rectangle(x, expandedBounds.y, faultImageWidth, faultImageHeight);
			}
			// Draw the compensation image in the upper right hand corner of the round rectangle,
			// leaving room for the fault image.
			if (showCompensation) {
				int x = expandedBounds.x + expandedBounds.width - compensationImageWidth +1;
				int y = expandedBounds.y;
				if (showFault) {
					y += faultImageHeight;
				}
			 	this.rectCompensation = new Rectangle(x, y, compensationImageWidth, compensationImageHeight);
			}
			// Draw the termination image in the upper right hand corner of the round rectangle,
			// leaving room for fault and compensation.
			if (showTermination) {
				int x = expandedBounds.x + expandedBounds.width - terminationImageWidth +1;
				int y = expandedBounds.y;
				if (showFault) {
					y += faultImageWidth;
				}
				if (showCompensation) {
					y += compensationImageWidth;
				}
			 	this.rectTermination = new Rectangle(x, y, terminationImageWidth, terminationImageHeight);
			}
			// Draw the event image in the upper right hand corner of the round rectangle,
			// leaving room for fault, termination and compensation.
			if (showEvent) {
				int x = expandedBounds.x + expandedBounds.width - eventImageWidth+1;
				int y = expandedBounds.y;
				if (showFault) {
					y += faultImageHeight;
				}
				if (showCompensation) {
					y += compensationImageHeight;
				}
				if (showTermination) {
					y += terminationImageWidth;
				}
				this.rectEvent = new Rectangle(x, y, eventImageWidth, eventImageHeight);
			}	
		}
		
		// Apply the bounds to the figures
		if(showFault)
			this.faultImageFigure.setBounds(rectFault);
		if(showCompensation)
			this.compensationImageFigure.setBounds(rectCompensation);
		if(showTermination)
			this.terminationImageFigure.setBounds(rectTermination);
		if(showEvent)
			this.eventImageFigure.setBounds(rectEvent);
	}

	public IFigure getFaultImageFigure() {
		return faultImageFigure;
	}

	public IFigure getCompensationImageFigure() {
		return compensationImageFigure;
	}

	public IFigure getTerminationImageFigure() {
		return terminationImageFigure;
	}

	public IFigure getEventImageFigure() {
		return eventImageFigure;
	}
}