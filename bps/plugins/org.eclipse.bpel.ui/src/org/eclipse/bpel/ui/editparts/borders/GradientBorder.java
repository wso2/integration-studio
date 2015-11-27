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
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.swt.graphics.Color;


/** 
 * A border to be used for GradientFigure 
 * Because the border determines the area that the gradient should be displayed, 
 * it acts as a delegate for drawing the gradient 
 */
public abstract class GradientBorder extends DrawerBorder {
	
	private BPELEditPart editPart;
	private boolean isVertical = false;
	private int arcWidth = -1;
	
	public GradientBorder(boolean isVertical) {
		this.editPart = null;
		this.isVertical = isVertical;	
	}

	public GradientBorder(boolean isVertical, int arcWidth) {
		this(isVertical);
		this.arcWidth = arcWidth;
	}
	
	/**
	 * @return the editpart using this border
	 */
	public BPELEditPart getEditPart() {
		return editPart;
	}

	public Insets getInsets(IFigure arg0) {
		return null;
	}

	public void paint(IFigure arg0, Graphics arg1, Insets arg2) {
	}
	
	protected Rectangle getGradientRect() {
		return null;
	}

	/**
	 * @param graphics - graphics object 
	 */
	public void paintGradient(Graphics graphics) {
		Rectangle rect = getGradientRect();
		if (rect == null)
			return;

		int fill = 0;
		if (editPart != null && editPart.getContentPane() != null)
			fill = BPELUtil.getRepaintFillType(editPart.getContentPane());
		
		Color oldBack = graphics.getBackgroundColor();
		Color oldFore = graphics.getForegroundColor();

		ColorRegistry registry = BPELUIPlugin.INSTANCE.getColorRegistry();
		Color from = registry.get(IBPELUIConstants.COLOR_GRADIENT_FROM);
		Color to = registry.get(IBPELUIConstants.COLOR_GRADIENT_TO);
		if (arcWidth == -1) {
			if (fill == 0 || fill == 2)	{
				graphics.setForegroundColor(from);
				graphics.setBackgroundColor(to);
//			} else if (fill == 2) {
//				graphics.setForegroundColor(to);
//				graphics.setBackgroundColor(from);
			} else {
				graphics.setBackgroundColor(from);
				graphics.setForegroundColor(from);
			}
			graphics.fillGradient(rect, isVertical());
		} else {
			if (fill == 0 || fill == 2) {
				if (isVertical()) {
					graphics.setForegroundColor(from);
					graphics.setBackgroundColor(from);
					graphics.fillRoundRectangle(new Rectangle(rect.x, rect.y, rect.width, arcWidth * 2), arcWidth, arcWidth);
					graphics.setForegroundColor(to);
					graphics.setBackgroundColor(to);
					graphics.fillRoundRectangle(new Rectangle(rect.x, rect.y + rect.height - arcWidth * 2, rect.width, arcWidth * 2), arcWidth, arcWidth);
					graphics.setForegroundColor(from);
					graphics.setBackgroundColor(to);
					graphics.fillGradient(new Rectangle(rect.x, rect.y + arcWidth, rect.width, rect.height - arcWidth * 2), true);
				} else {
					graphics.setForegroundColor(from);
					graphics.setBackgroundColor(from);
					graphics.fillRoundRectangle(new Rectangle(rect.x, rect.y, arcWidth * 2, rect.height), arcWidth, arcWidth);
					graphics.setForegroundColor(to);
					graphics.setBackgroundColor(to);
					graphics.fillRoundRectangle(new Rectangle(rect.x + rect.width - arcWidth * 2, rect.y, arcWidth * 2, rect.height), arcWidth, arcWidth);
					graphics.setForegroundColor(from);
					graphics.setBackgroundColor(to);
					graphics.fillGradient(new Rectangle(rect.x + arcWidth, rect.y, rect.width - arcWidth * 2, rect.height), false);
				}
//			} else if (fill == 2) {
//				if (isVertical()) {
//					graphics.setForegroundColor(to);
//					graphics.setBackgroundColor(to);
//					graphics.fillRoundRectangle(new Rectangle(rect.x, rect.y, rect.width, arcWidth * 2), arcWidth, arcWidth);
//					graphics.setForegroundColor(from);
//					graphics.setBackgroundColor(from);
//					graphics.fillRoundRectangle(new Rectangle(rect.x, rect.y + rect.height - arcWidth * 2, rect.width, arcWidth * 2), arcWidth, arcWidth);
//					graphics.setForegroundColor(to);
//					graphics.setBackgroundColor(from);
//					graphics.fillGradient(new Rectangle(rect.x, rect.y + arcWidth, rect.width, rect.height - arcWidth * 2), true);
//				} else {
//					graphics.setForegroundColor(to);
//					graphics.setBackgroundColor(to);
//					graphics.fillRoundRectangle(new Rectangle(rect.x, rect.y, arcWidth * 2, rect.height), arcWidth, arcWidth);
//					graphics.setForegroundColor(from);
//					graphics.setBackgroundColor(from);
//					graphics.fillRoundRectangle(new Rectangle(rect.x + rect.width - arcWidth * 2, rect.y, arcWidth * 2, rect.height), arcWidth, arcWidth);
//					graphics.setForegroundColor(to);
//					graphics.setBackgroundColor(from);
//					graphics.fillGradient(new Rectangle(rect.x + arcWidth, rect.y, rect.width - arcWidth * 2, rect.height), false);
//				}
			} else {
				graphics.setBackgroundColor(from);
				graphics.setForegroundColor(from);
				graphics.fillGradient(rect, isVertical());
			}
		}

		graphics.setBackgroundColor(oldBack);
		graphics.setForegroundColor(oldFore);
	}
	
	/**
	 * @param editpart
	 */
	public void setEditPart(BPELEditPart editpart) {
		this.editPart = editpart;
	}
	
	protected boolean isVertical() {
		return isVertical;
	}
}
