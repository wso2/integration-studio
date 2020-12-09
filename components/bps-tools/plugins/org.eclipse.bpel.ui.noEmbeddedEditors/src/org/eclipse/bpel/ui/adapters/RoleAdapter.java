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

import org.eclipse.bpel.model.adapters.AbstractAdapter;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.swt.graphics.Image;


public class RoleAdapter extends AbstractAdapter implements INamedElement, ILabeledElement {

	/* INamedElement */
	
	public String getName(Object namedElement) {
		return ((Role)namedElement).getName();
	}
	
	public void setName(Object namedElement, String name) {
		((Role)namedElement).setName(name);
	}
	
	public boolean isNameAffected(Object modelObject, Notification n) {
		return (n.getFeatureID(Role.class) == PartnerlinktypePackage.ROLE__NAME);
	}

	/* ILabeledElement */
	
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ROLE_16);
	}
	
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_ROLE_32);
	}	
	
	public String getTypeLabel(Object object) {
		return Messages.RoleAdapter_Role_1; 
	}	
	public String getLabel(Object object) {
		String name = getName(object);
		if (name != null)  return name;
		return getTypeLabel(object);
	}
}