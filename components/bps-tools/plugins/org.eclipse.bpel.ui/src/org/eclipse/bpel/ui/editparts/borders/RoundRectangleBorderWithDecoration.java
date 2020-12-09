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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;

public class RoundRectangleBorderWithDecoration extends RoundRectangleBorder {
	Image decoration;
	
	private int decoXOffset;
	private int decoYOffset;
	
	private IFigure decorationFigure;
	
	public RoundRectangleBorderWithDecoration(IFigure parent, Image decoration) {
		this(parent,decoration,new Insets(5,5,5,5));
	}
	public RoundRectangleBorderWithDecoration(IFigure parent, Image decoration, Insets insets) {
		super(insets);
		this.decoration = decoration;
		decoXOffset = 0;
		decoYOffset = -(decoration.getBounds().height/2);
		
		this.decorationFigure = new ImageFigure(decoration);
		this.decorationFigure.setParent(parent);
	}
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		super.paint(figure, graphics, insets);
		if (decoration != null) {
			Rectangle r = figure.getBounds();
			graphics.pushState();
			Rectangle decoBounds = new Rectangle(r.x+decoXOffset,r.y+decoYOffset,decoration.getBounds().width,decoration.getBounds().height);
			decorationFigure.setBounds(decoBounds);
			graphics.setClip(decoBounds);
			decorationFigure.paint(graphics);
			graphics.popState();
		}
	}
	
	public int getDecoXOffset() {
		return decoXOffset;
	}
	public int getDecoYOffset() {
		return decoYOffset;
	}
	public Image getDecoration() {
		return decoration;
	}
	public IFigure getDecorationFigure() {
		return decorationFigure;
	}
}
