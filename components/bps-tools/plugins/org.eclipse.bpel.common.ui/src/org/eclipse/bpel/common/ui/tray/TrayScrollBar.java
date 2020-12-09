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
package org.eclipse.bpel.common.ui.tray;

import org.eclipse.bpel.common.ui.CommonUIPlugin;
import org.eclipse.bpel.common.ui.details.IDetailsColors;
import org.eclipse.draw2d.ArrowButton;
import org.eclipse.draw2d.Button;
import org.eclipse.draw2d.Clickable;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RangeModel;
import org.eclipse.draw2d.ScrollBar;
import org.eclipse.draw2d.ScrollBarLayout;
import org.eclipse.draw2d.TreeSearch;
import org.eclipse.draw2d.Triangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;


public class TrayScrollBar extends ScrollBar {

	protected static final int BUTTON_HEIGHT = 13;

	public TrayScrollBar() {
		super();
		
		setLayoutManager(new ScrollBarLayout(transposer) {
			@Override
			protected Rectangle layoutButtons(ScrollBar scrollBar) {
				Rectangle bounds = transposer.t(scrollBar.getClientArea());
				Dimension buttonSize = new Dimension(bounds.width, BUTTON_HEIGHT);
				getButtonUp().setBounds(transposer.t(new Rectangle(bounds.getTopLeft(), buttonSize)));
				Rectangle r = new Rectangle (bounds.x, bounds.bottom() - buttonSize.height, buttonSize.width, buttonSize.height);
				getButtonDown().setBounds(transposer.t(r));
				Rectangle trackBounds = bounds.getCropped(new Insets(buttonSize.height, 0, buttonSize.height, 0));
				RangeModel model = scrollBar.getRangeModel();
				getButtonUp().setVisible(model.getValue() != model.getMinimum());
				getButtonDown().setVisible(model.getValue() != model.getMaximum() - model.getExtent());
				return trackBounds;
			}
		});
		
		setPageUp(null);
		setPageDown(null);
		setThumb(null);
		setOpaque(false);
	}

	// make it non-clickable otherwise it will block tooltips and direct edit
	@Override
	public IFigure findFigureAt(int x, int y, TreeSearch search) {
		IFigure result = super.findFigureAt(x, y, search);
		if (result != this)
			return result;
		return null;
	}
	
	@Override
	public boolean containsPoint(int x, int y) {
		IFigure up = getButtonUp();
		IFigure down = getButtonDown();
		return (up.isVisible() && up.getBounds().contains(x, y))
			|| (down.isVisible() && down.getBounds().contains(x, y));
	}

	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		return new Dimension(wHint, hHint);
	}
	
	@Override
	protected Clickable createDefaultDownButton() {
		return createButton();
	}
	
	@Override
	protected Clickable createDefaultUpButton() {
		return createButton();
	}
	
	protected Clickable createButton() {
		final Color foreground = CommonUIPlugin.getDefault().getColorRegistry().get(IDetailsColors.COLOR_DARK_SHADOW);
		final Color background = CommonUIPlugin.getDefault().getColorRegistry().get(IDetailsColors.COLOR_TRAY_BACKGROUND);
		Button result = new ArrowButton() {
			@Override
			protected void paintBorder(Graphics graphics) {
				graphics.setForegroundColor(foreground);
				Rectangle r = getBounds().getCopy();
				r.shrink(0, 2);
				r.width -= 1;
				graphics.drawRectangle(r);
			}
		};
		result.setBackgroundColor(background);
		// sets the triangle color
		((Triangle)result.getChildren().get(0)).setBackgroundColor(foreground);
		return result;
	}
}
