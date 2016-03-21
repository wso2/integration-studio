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
import org.eclipse.bpel.model.adapters.IStatefullAdapter;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Element;


public class PartnerLinkTypeAdapter extends AbstractAdapter implements INamedElement,
	ILabeledElement, IContentProposal, IStatefullAdapter
{
		
	PartnerLinkType myPartnerLinkType ( Object obj ) {
		return getTarget (obj,PartnerLinkType.class);
	}
	
	
	/* INamedElement */
	
	public String getName (Object namedElement) {
		return myPartnerLinkType ( namedElement ).getName();		
	}
	
	public void setName(Object namedElement, String name) {
		myPartnerLinkType (namedElement).setName(name);		
	}
	
	public boolean isNameAffected(Object modelObject, Notification n) {
		return (n.getFeatureID(PartnerLinkType.class) == PartnerlinktypePackage.PARTNER_LINK_TYPE__NAME);
	}

	/* ILabeledElement */
	
	public Image getSmallImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PARTNERLINKTYPE_16);
	}
	
	public Image getLargeImage(Object object) {
		return BPELUIPlugin.INSTANCE.getImage(IBPELUIConstants.ICON_PARTNERLINKTYPE_32);
	}	
	
	public String getTypeLabel(Object object) {
		return Messages.PartnerLinkTypeAdapter_Partner_Link_Type_1; 
	}
	
	public String getLabel (Object object) {
		String name = getName(object);
		if (name != null)  {
			return name;
		}
		return getTypeLabel(object);
	}

	/** IContentProposal */
	
	/* 
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getContent()
	 */
	
	public String getContent() {
		return getName( getTarget() );
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getCursorPosition()
	 */
	public int getCursorPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getDescription()
	 */
	public String getDescription() {
		PartnerLinkType plt = myPartnerLinkType ( null);
		// ??
		Element elm = plt.getDocumentationElement();
		return (elm != null ? elm.getNodeValue() : null);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.fieldassist.IContentProposal#getLabel()
	 */
	
	public String getLabel() {		
		return NLS.bind(Messages.PartnerLinkTypeAdapter_0, 
				Messages.PartnerLinkTypeAdapter_Partner_Link_Type_1 ,
				getName( getTarget() ) );
	}
}
