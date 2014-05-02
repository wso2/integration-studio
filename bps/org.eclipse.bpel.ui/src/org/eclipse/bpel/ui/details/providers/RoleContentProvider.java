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
package org.eclipse.bpel.ui.details.providers;

import java.util.List;

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;


/**
 * Content provider for Roles.
 * 
 * Expects a PartnerLinkType or a Partner as input.
 */
public class RoleContentProvider extends AbstractContentProvider {

	@Override
	public void collectElements(Object input,List list)  {
		
		if (input instanceof PartnerLinkType) {
			PartnerLinkType plt = (PartnerLinkType) input;
			list.addAll ( plt.getRole() );			
			
		} else if (input instanceof PartnerLink) {
			
			PartnerLink partnerLink = (PartnerLink)input;
			if (partnerLink.getMyRole() != null) {
				list.add(partnerLink.getMyRole());
			}
			if (partnerLink.getPartnerRole() != null) {
				list.add(partnerLink.getPartnerRole());
			}			
		}		
	}
}
