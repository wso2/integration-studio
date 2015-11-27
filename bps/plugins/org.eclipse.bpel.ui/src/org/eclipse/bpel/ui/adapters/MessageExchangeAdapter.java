/**
 * <copyright>
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 */
 
package org.eclipse.bpel.ui.adapters;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.editparts.MessageExchangeEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.properties.PropertiesLabelProvider;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;


/**
 * @author Miriam Grundig (MGrundig@de.ibm.com)
 */
// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
// https://jira.jboss.org/browse/JBIDE-7526
// push all of the Marker stuff up to MarkerHolderAdapter to avoid duplication
public class MessageExchangeAdapter extends MarkerHolderAdapter implements INamedElement,
	ILabeledElement, EditPartFactory, IOutlineEditPartFactory, IMarkerHolder,
	ITrayEditPartFactory, IContentProposal,
	AdapterNotification
{
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.INamedElement#getName(java.lang.Object)
	 */
	public String getName (Object namedElement) {
		return getTarget( namedElement, MessageExchange.class ).getName();		
	}
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.INamedElement#setName(java.lang.Object, java.lang.String)
	 */
	public void setName(Object namedElement, String name) {
		getTarget( namedElement, MessageExchange.class ).setName(name);		
	}
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.INamedElement#isNameAffected(java.lang.Object, org.eclipse.emf.common.notify.Notification)
	 */
	public boolean isNameAffected(Object modelObject, Notification n) {
		return (n.getFeatureID(MessageExchange.class) == BPELPackage.MESSAGE_EXCHANGE__NAME);
	}
		
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getSmallImage(java.lang.Object)
	 */
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_MESSAGEEXCHANGE_16);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getLargeImage(java.lang.Object)
	 */
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_MESSAGEEXCHANGE_32);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.adapters.ILabeledElement#getTypeLabel(java.lang.Object)
	 */
	public String getTypeLabel(Object object) {
		return Messages.MessageExchangeAdapter_TypeLabel; 
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
		MessageExchangeEditPart result = new MessageExchangeEditPart();
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
		// TODO message to catalog
		return NLS.bind("{0} - {1}", 
				getTypeLabel( obj ) ,
				getName( obj ) );
	}
}
