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
package org.eclipse.bpel.ui.editparts.figures;

import org.eclipse.bpel.ui.editparts.borders.CollapsableBorder;
import org.eclipse.bpel.ui.editparts.borders.ContainerBorder;
import org.eclipse.draw2d.Label;
import org.eclipse.swt.graphics.Image;


/**
 * A collapsable container figure has a collapsable border, as well as an
 * image and text for the border. 
 */
public class CollapsableContainerFigure extends GradientFigure {
	
	protected CollapsableBorder border;
	protected Image borderImage;
	protected String borderText;
	
	public CollapsableContainerFigure(Object modelObject, Image image, String text) {
		super(modelObject);
		this.borderImage = image;
		this.borderText = text;
		initializeBorder();
		this.setBorder(border);
	}
	
	/**
	 * Subclasses may override.
	 */
	protected void initializeBorder() {
		this.border = new ContainerBorder(this, borderImage, borderText);
	}
	
	public Label getNameLabel() {
		return border.getLabel();
	}
	
	public void setName(String name) {
		border.setName(name);
		invalidate();
	}
	
	@Override
	public void invalidate() {
		border.invalidate();
		super.invalidate();
	}

	public void setCollapsed(boolean collapsed) {
		border.setCollapsed(collapsed);
		invalidate();
	}
	
	public boolean isCollapsed() {
		return border.isCollapsed();
	}

	public boolean isPointInCollapseImage(int i, int j) {
		return border.isPointInCollapseImage(i,j);
	}
}
