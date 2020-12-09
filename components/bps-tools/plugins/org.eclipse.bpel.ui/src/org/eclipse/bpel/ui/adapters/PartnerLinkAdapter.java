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
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.editparts.PartnerLinkEditPart;
import org.eclipse.bpel.ui.properties.PropertiesLabelProvider;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;


/**
 * @author IBM, Original Contribution
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 5, 2007
 *
 */
// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
// https://jira.jboss.org/browse/JBIDE-7526
// push all of the Marker stuff up to MarkerHolderAdapter to avoid duplication
public class PartnerLinkAdapter extends MarkerHolderAdapter implements INamedElement,
	ILabeledElement, EditPartFactory, IOutlineEditPartFactory, IMarkerHolder,
	ITrayEditPartFactory, IContentProposal,
	AdapterNotification
{
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.INamedElement#getName(java.lang.Object)
	 */
	public String getName (Object namedElement) {
		return getTarget( namedElement, PartnerLink.class ).getName();		
	}
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.INamedElement#setName(java.lang.Object, java.lang.String)
	 */
	public void setName(Object namedElement, String name) {
		getTarget( namedElement, PartnerLink.class ).setName(name);		
	}
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.INamedElement#isNameAffected(java.lang.Object, org.eclipse.emf.common.notify.Notification)
	 */
	public boolean isNameAffected(Object modelObject, Notification n) {
		return (n.getFeatureID(PartnerLink.class) == BPELPackage.PARTNER_LINK__NAME);
	}
		
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getSmallImage(java.lang.Object)
	 */
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PARTNER_16);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getLargeImage(java.lang.Object)
	 */
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PARTNER_32);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getTypeLabel(java.lang.Object)
	 */
	public String getTypeLabel(Object object) {
		return Messages.PartnerLinkAdapter_Partner_1; 
	}	
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getLabel(java.lang.Object)
	 */
	public String getLabel(Object object) {
		String name = getName(object);
		if (name != null)  {
			return name;
		}
		return getTypeLabel(object);
	}

	
	/**
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		PartnerLinkEditPart result = new PartnerLinkEditPart();
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


	/**
	 * IContentProposal
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getContent()
	 */
	
	public String getContent() {
		return getLabel( getTarget() );		
	}

	/**
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getCursorPosition()
	 */
	public int getCursorPosition() {
		// TODO Auto-generated method stub
		return -1;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getDescription()
	 */
	public String getDescription() {		
		return null;
	}

	/**
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getLabel()
	 */
	public String getLabel() {		
		Object obj = getTarget();
		return NLS.bind(Messages.PartnerLinkAdapter_0, 
				getTypeLabel( obj ) ,
				getName( obj ) );
	}
}
