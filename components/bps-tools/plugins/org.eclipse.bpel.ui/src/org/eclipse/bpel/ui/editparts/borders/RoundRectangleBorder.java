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
import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;


public class RoundRectangleBorder extends AbstractBorder {

	private Insets insets;
	
	public RoundRectangleBorder() {
		this(new Insets(5, 5, 5, 5));
	}
	public RoundRectangleBorder(Insets insets) {
		this.insets = insets;
	}
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		graphics.setForegroundColor(BPELUIPlugin.INSTANCE.getColorRegistry().get(IBPELUIConstants.COLOR_GRAY));
		Rectangle r = figure.getBounds().getCopy();
		r.height -= 1;
		r.width -= 1;
		graphics.drawRoundRectangle(r, IBPELUIConstants.ARC_WIDTH, IBPELUIConstants.ARC_WIDTH);
	}
	public Insets getInsets(IFigure figure) {
		return insets;
	}
	@Override
	public Dimension getPreferredSize(IFigure f) {
		return new Dimension(50, 50);
	}
}
