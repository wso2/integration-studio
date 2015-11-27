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

import java.util.ArrayList;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.editparts.CorrelationSetEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.properties.PropertiesLabelProvider;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.swt.graphics.Image;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 5, 2007
 *
 */
// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
// https://jira.jboss.org/browse/JBIDE-7526
// push all of the Marker stuff up to MarkerHolderAdapter to avoid duplication
public class CorrelationSetAdapter extends MarkerHolderAdapter implements INamedElement,
	ILabeledElement, EditPartFactory, IOutlineEditPartFactory, IMarkerHolder,
	ITrayEditPartFactory,AdapterNotification
{
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.INamedElement#getName(java.lang.Object)
	 */
	public String getName(Object namedElement) {
		return ((CorrelationSet)namedElement).getName();
	}
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.INamedElement#setName(java.lang.Object, java.lang.String)
	 */
	public void setName(Object namedElement, String name) {
		((CorrelationSet)namedElement).setName(name);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.INamedElement#isNameAffected(java.lang.Object, org.eclipse.emf.common.notify.Notification)
	 */
	public boolean isNameAffected(Object modelObject, Notification n) {
		return (n.getFeatureID(CorrelationSet.class) == BPELPackage.CORRELATION_SET__NAME);
	}


	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getSmallImage(java.lang.Object)
	 */
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(
				IBPELUIConstants.ICON_CORRELATIONSET_16);
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getLargeImage(java.lang.Object)
	 */
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(
				IBPELUIConstants.ICON_CORRELATIONSET_32);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getTypeLabel(java.lang.Object)
	 */
	public String getTypeLabel(Object object) {
		return Messages.CorrelationSetAdapter_Correlation_Set_1; 
	}	
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getLabel(java.lang.Object)
	 */
	public String getLabel(Object object) {
		String name = getName(object);
		if (name != null)  return name;
		return getTypeLabel(object);
	}
	

	
	/**
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		CorrelationSetEditPart result = new CorrelationSetEditPart();
		result.setLabelProvider(PropertiesLabelProvider.getInstance());
		result.setModel(model);
		return result;
	}

	/**
	 * @see org.eclipse.bpel.ui.adapters.IOutlineEditPartFactory#createOutlineEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createOutlineEditPart(EditPart context, Object model) {
		EditPart result = new OutlineTreeEditPart();
		result.setModel(model);
		return result;
	}
		
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.ITrayEditPartFactory#createTrayEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createTrayEditPart(EditPart context, Object model) {
		return createEditPart(context, model);
	}

}
