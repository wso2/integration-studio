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
package org.eclipse.bpel.ui.editparts.util;

import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.Policy;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.osgi.util.NLS;


public class BPELEditPartFactory implements EditPartFactory {

	public EditPart createEditPart(EditPart context, Object model) {
		EditPartFactory adapter = BPELUtil.adapt(model, EditPartFactory.class);
		if (adapter != null) return adapter.createEditPart(context, model);
		if (Policy.DEBUG) System.out.println(NLS.bind(Messages.BPELEditPartFactory_Could_not_create_edit_part_for, (new Object[] { model }))); 
		return null;
	}
}
