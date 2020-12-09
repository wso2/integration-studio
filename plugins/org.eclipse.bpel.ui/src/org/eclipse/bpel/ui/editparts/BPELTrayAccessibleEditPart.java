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
package org.eclipse.bpel.ui.editparts;

import org.eclipse.bpel.common.ui.tray.TrayAccessibleEditPart;
import org.eclipse.bpel.common.ui.tray.TrayEditPart;
import org.eclipse.bpel.ui.adapters.ILabeledElement;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.swt.accessibility.AccessibleEvent;


public class BPELTrayAccessibleEditPart extends TrayAccessibleEditPart {

	public BPELTrayAccessibleEditPart(TrayEditPart part) {
		super(part);
	}

	@Override
	public void getName(AccessibleEvent e) {
		String childType = null;
		String displayName = null;
		ILabeledElement labeledElement = BPELUtil.adapt(part.getModel(), ILabeledElement.class);
		if (labeledElement != null) {
			childType = labeledElement.getTypeLabel(part.getModel());
			displayName = labeledElement.getLabel(part.getModel());
			// bug 327644
			// prevent possible NPE
			if (childType != null && childType.equals(displayName)) {
				childType = null;
			}
		} else {
			e.result = null;
			return;
		}

		// return something reasonable (type followed by name if any)
		// or nothing at all

		StringBuffer concat = new StringBuffer();
		if (childType != null && childType.length() > 0)
			concat.append(childType);
		if (concat.length() > 0)
			concat.append(" "); //$NON-NLS-1$
		if (displayName != null && displayName.length() > 0)
			concat.append(displayName);
		if (concat.length() > 0)
			e.result = concat.toString();
		else
			e.result = null;
		return;
	}
}
