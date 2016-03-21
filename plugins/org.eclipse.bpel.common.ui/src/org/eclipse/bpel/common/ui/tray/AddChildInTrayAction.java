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

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPart;

public class AddChildInTrayAction extends SelectionAction {
	protected static final String ID = "org.eclipse.bpel.common.ui.tray.AddChildInTrayAction"; //$NON-NLS-1$
	protected Class clazz;
	protected TrayCategoryEditPart target;
	
	/**
	 * @param part
	 */
	public AddChildInTrayAction(IWorkbenchPart part, Class clazz, String label, ImageDescriptor icon) {
		super(part);
		setText(label);
		setToolTipText(label);
		setImageDescriptor(icon);
		this.clazz = clazz;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.ui.actions.WorkbenchPartAction#calculateEnabled()
	 */
	@Override
	protected boolean calculateEnabled() {
		List selected = getSelectedObjects();
		target = null;
		if (getSelectedObjects().size() >  0 && (selected.get(0) instanceof EditPart)) {
			Object model = ((EditPart) selected.get(0)).getModel();
			for (Iterator it = selected.iterator(); it.hasNext(); ) {
				Object o = it.next();
				if (o instanceof TrayCategoryEditPart)
					target = (TrayCategoryEditPart) o;
				if (o instanceof EditPart) {
					if (!model.equals(((EditPart) o).getModel()))
						return false;
				}
			}
			if (target != null && clazz == target.getClass())
				return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.IAction#run()
	 */
	@Override
	public void run() {
		if (target != null) 
			target.publicAddEntry();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.IAction#getId()
	 */
	@Override
	public String getId() {
		return ID + "." + clazz; //$NON-NLS-1$
	}
	
	public static String calculateId(Class clazz) {
		return ID + "." + clazz; //$NON-NLS-1$
	}
}
