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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.uiextensionmodel.ReferencePartnerLinks;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;


public class ReferencePartnerLinksEditPart extends PartnerLinksEditPart {

	/**
	 * Only add outbound partners.
	 */
	@Override
	protected List<PartnerLink> getModelChildren() {
		List<PartnerLink> result = new ArrayList<PartnerLink>();
		for (Iterator<PartnerLink> iter = getPartnerLinks().getChildren().iterator(); iter.hasNext();) {
			PartnerLink	partner = iter.next();
			if (ModelHelper.isReferencePartnerLink(partner) && !ModelHelper.isInterfacePartnerLink(partner)) {
				result.add(partner);
			}
		}
		return result;
	}

	@Override
	protected int getRoleKind() {
		return ModelHelper.PARTNER_ROLE;
	}
	
	@Override
	protected PartnerLinks getPartnerLinks() {
		return ((ReferencePartnerLinks)getModel()).getPartnerLinks();
	}

	@Override
	public void activate() {
		super.activate();
		getPartnerLinks().eAdapters().add(adapter);
	}

	@Override
	public void deactivate() {
		super.deactivate();
		getPartnerLinks().eAdapters().remove(adapter);
	}

	@Override
	protected IFigure getAddToolTip() {
	    return new Label(Messages.ReferencePartnerLinksEditPart_0); 
	}
	
	@Override
	protected IFigure getRemoveToolTip() {
	    return new Label(Messages.ReferencePartnerLinksEditPart_1); 
	}
}
