/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.editparts.borders;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.swt.graphics.Image;

/**
 * Basically a container border which is able to add some 
 * extra vertical space based on the orientation of a pick
 * @author ascharf
 *
 */
public class PickBorder extends ContainerBorder {
	
	private boolean horizontal;
	
	static final int marginLeft = 20;
	static final int marginRight = 0;
	
	public PickBorder(IFigure parentFigure, Image image, String labelText){
		super(parentFigure, image, labelText);
	}
	
	@Override
	public Insets getInsets(IFigure figure) {
		Insets ins = super.getInsets(figure);
		if(horizontal){
			ins.left += marginLeft;
			ins.right += marginRight;
		}
		return ins;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
}
