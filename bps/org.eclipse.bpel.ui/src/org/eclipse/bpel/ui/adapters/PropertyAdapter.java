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
import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.swt.graphics.Image;


public class PropertyAdapter extends AbstractAdapter implements ILabeledElement,
	INamedElement
{

	/* ILabeledElement */
	
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PROPERTY_16);
	}
	
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PROPERTY_32);
	}	
	
	public String getTypeLabel(Object object) {
		return Messages.PropertyAdapter_Property_1; 
	}
	
	public String getLabel(Object object) {
		String name = ((Property)object).getName();
		if (name != null)  return name;
		return getTypeLabel(object);
	}
	
	/* INamedElement */
	
	public String getName(Object modelObject) {
		return ((Property)modelObject).getName();
	}
	
	public void setName(Object modelObject, String name) {
		((Property)modelObject).setName(name);
	}
	
	public boolean isNameAffected(Object modelObject, Notification n) {
		return (n.getFeatureID(Property.class) == MessagepropertiesPackage.PROPERTY__NAME);
	}
}
