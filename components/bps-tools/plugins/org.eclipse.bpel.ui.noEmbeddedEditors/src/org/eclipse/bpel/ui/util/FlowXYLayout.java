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
package org.eclipse.bpel.ui.util;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.ui.GraphicalBPELRootEditPart;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;


/**
 * A NonclippingXYLayout that knows how to re-create missing constraints from a model object.
 * 
 */
public class FlowXYLayout extends NonclippingXYLayout {

	EditPart flowEditPart;

	public FlowXYLayout(EditPart flowEditPart) {
		super();
		this.flowEditPart = flowEditPart;
	}

	@Override
	public Object getConstraint(IFigure figure) {
		Object constraint = super.getConstraint(figure);
		if (constraint != null) return constraint;
		
		// We don't have a constraint yet.  Try and create one.
		
		EditPart editPart = BPELUtil.mapFigure2EditPart(flowEditPart.getViewer(), figure);
		if (editPart != null && (editPart.getModel() instanceof Activity)) {

			EditPart rootEditPart = editPart.getRoot();
			if (rootEditPart instanceof GraphicalBPELRootEditPart) {
				Point p = ModelHelper.getLocation((Activity)editPart.getModel());
				if (p.x == Integer.MIN_VALUE) {
					// HACK: We don't know its position, pretend it's at 0, 0.  This should only
					// be necessary during brief edge-case situations (like during startup before
					// we've done auto-layout on flows without metadata)..
					p = new Point(0, 0);
				}
				Dimension s = new Dimension(-1, -1);
				Rectangle r = new Rectangle(p, s);
				//System.out.println("Created constraint: "+r);
				//setConstraint(figure, r);
				((GraphicalEditPart)flowEditPart).setLayoutConstraint(editPart, figure, r);
				return r;
			}
		}
		
		return super.getConstraint(figure);
	}

}
