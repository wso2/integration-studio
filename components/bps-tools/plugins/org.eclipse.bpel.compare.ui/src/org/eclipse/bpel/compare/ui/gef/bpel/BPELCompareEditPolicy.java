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
package org.eclipse.bpel.compare.ui.gef.bpel;

import java.util.List;

import org.eclipse.bpel.compare.ui.annotation.AnnotationsStore;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.swt.graphics.Color;

public class BPELCompareEditPolicy extends GraphicalEditPolicy {
	
	private static Color COLOR_GREEN = new Color(null, 160, 255, 160);
	private static Color COLOR_YELLOW = new Color(null, 255, 255, 160);
	private static Color COLOR_NONE = new Color(null, 255, 255, 255);
	private static Color COLOR_BLUE = new Color(null, 175, 238, 238);
	
	@Override
	public void activate() {
		super.activate();
		EObject model = (EObject) getHost().getModel();
		if (getHost().getParent().getModel() == model) {
			return;
		}
		DiffElement annotation = AnnotationsStore.getInstance()
				.getAnnotation(model);
		if (annotation == null) {
			getHostFigure().setBackgroundColor(COLOR_NONE);
			return;
		}
		
		//if (annotation instanceof AddModelElement) {
		if (annotation instanceof ModelElementChangeLeftTarget) {
			getHostFigure().setBackgroundColor(COLOR_GREEN);
		//} else if (annotation instanceof RemoveModelElement) {
		} else if (annotation instanceof ModelElementChangeRightTarget) {
			getHostFigure().setBackgroundColor(COLOR_GREEN);
		} else if (annotation instanceof MoveModelElement) {
			getHostFigure().setBackgroundColor(COLOR_BLUE);
		} else if (annotation instanceof UpdateAttribute) {
			List children = getHostFigure().getChildren();
			int num = 0;
			if (children.size() > num) {
				IFigure child = (IFigure) children.get(num);
				child.setBackgroundColor(COLOR_YELLOW);
			}
		}
		
//		if (++index == 2) {
//		switch (annotation) {
//		case Added:
//			getHostFigure().setBackgroundColor(COLOR_GREEN);
//			break;
//		case Modified:
//			List children = getHostFigure().getChildren();
//			int num = 0;
//			if (children.size() > num) {
//				IFigure child = (IFigure) children.get(num);
//				child.setBackgroundColor(COLOR_YELLOW);
//			}
////			getHostFigure().setBackgroundColor(COLOR_YELLOW);
//			break;
//		case Moved:
//			getHostFigure().setBackgroundColor(COLOR_BLUE);
//			break;
//		}
//		getHostFigure().setForegroundColor();
//		getHostFigure().setBackgroundColor(new Color(null, 160, 255, 160));
//		figure = parent;
//		List children = parent.getChildren();
//		for (Object child : children) {
//			if (child instanceof IFigure) {
//				updateAllChildren((IFigure) child);
//			}
//		}
//		}
//		if (hostFigure instanceof LayeredPane) {
//			LayeredPane lp = (LayeredPane) hostFigure;
//			int i = 0;
//			Layer layer = lp.getLayer(i++);
//			while (layer != null) {
//				layer.setForegroundColor(new Color(null, 160, 255, 160));
//				layer = lp.getLayer(i++);
//			}
//		}
	}

	private void updateAllChildren(IFigure parent) {
//		parent.setForegroundColor(new Color(null, 160, 255, 160));
//		parent.setBackgroundColor(new Color(null, 160, 255, 160));
		List children = parent.getChildren();
		for (Object child : children) {
			if (child instanceof IFigure) {
				updateAllChildren((IFigure) child);
			}
		}
	}

}
