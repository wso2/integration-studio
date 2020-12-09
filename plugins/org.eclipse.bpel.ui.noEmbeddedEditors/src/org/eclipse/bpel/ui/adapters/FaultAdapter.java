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
package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.model.adapters.AbstractStatefulAdapter;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.swt.graphics.Image;

import org.eclipse.wst.wsdl.Fault;

public class FaultAdapter extends AbstractStatefulAdapter implements ILabeledElement, IContentProposal {

	/* ILabeledElement */
	
	// TODO: need a unique icon for WSDL faults
	
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_THROW_16);
	}
	
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_THROW_32);
	}	
	
	public String getTypeLabel(Object object) {
		return Messages.FaultAdapter_Fault_1; 
	}
	public String getLabel(Object object) {
		String name = getTarget(object, Fault.class).getName();
		if (name != null)  {
			return name;
		}
		return getTypeLabel(object);
	}

	public String getContent() {
		return getLabel ( getTarget() );		
	}

	public int getCursorPosition() {
		// TODO Why -1?
		return -1;
	}

	public String getDescription() {
		// TODO Temporary returns null, then should be updated
		return null;
	}

	public String getLabel() {
		return getLabel ( getTarget() ) + " - " + getLabel ( getTarget() );		
	}
}
