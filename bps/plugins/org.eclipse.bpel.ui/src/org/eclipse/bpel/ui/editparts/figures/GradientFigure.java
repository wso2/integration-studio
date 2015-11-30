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

import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.bpel.ui.editparts.borders.GradientBorder;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;


/** 
 * a figure that will draw a gradient based on its nesting inside the tree
 * 
 * This is to be used in conjunction with GradientBorder
 */

public class GradientFigure extends Figure {

	Object modelObject;
	
	public GradientFigure(Object modelObject) {
		super();
		this.modelObject = modelObject;
	}
	@Override
	protected void paintClientArea(Graphics graphics) {
		Border b = getBorder();
		if (b != null && b instanceof GradientBorder) 
			((GradientBorder)b).paintGradient(graphics);
			
		super.paintClientArea(graphics);
	}

	/** 
	 * the gradient logic needs the reference to the parent EditPart
	 * in order to figure out how to draw the gradient
	 * If you don't set this, the gradient fill will not be drawn
	 */	
	public void setEditPart(BPELEditPart part) {
		Border b = getBorder();
		if (b != null && b instanceof GradientBorder) 
			((GradientBorder)b).setEditPart(part);
	}
	
	public String getNameString() {
		ILabeledElement labeledElement = BPELUtil.adapt(modelObject, ILabeledElement.class);
		if (labeledElement == null) return null;
		return labeledElement.getLabel(modelObject);
	}
}
