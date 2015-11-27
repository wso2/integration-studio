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
package org.eclipse.bpel.ui.actions;

import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.common.ui.tray.AddChildInTrayAction;
import org.eclipse.bpel.common.ui.tray.TrayCategoryEditPart;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;


public class BPELAddChildInTrayAction extends AddChildInTrayAction {

	public BPELAddChildInTrayAction(IWorkbenchPart part, Class clazz, String label, ImageDescriptor icon) {
		super(part, clazz, label, icon);
	}
	
	@Override
	protected boolean calculateEnabled() {
		List selected = getSelectedObjects();
		target = null;
		if (getSelectedObjects().size() >  0 && (selected.get(0) instanceof EObject)) {
			EObject model = ((EObject) selected.get(0));
			for (Iterator it = selected.iterator(); it.hasNext(); ) {
				Object o = it.next();
				EditPart part = (EditPart) ((BPELEditor) getWorkbenchPart()).getTrayViewer().getEditPartRegistry().get(o);
				if(part instanceof TrayCategoryEditPart)
					target = (TrayCategoryEditPart) part;
				if (o instanceof EObject) {
					if (!model.equals(o)) return false;
				}
			}
			if (target != null && clazz == target.getClass())
				return true;
		}
		return false;
	}

}
