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
package org.eclipse.bpel.ui.commands;

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.ui.IBPELUIConstants;


/** 
 * Sets the "partnerLinkType" property of a model object.  This is supported
 * for Partner objects.
 */
public class SetPartnerLinkTypeCommand extends SetCommand {

	public String getDefaultLabel() {
		return IBPELUIConstants.CMD_SELECT_PARTNERLINK;
	}

	public SetPartnerLinkTypeCommand(PartnerLink partnerLink, PartnerLinkType newPLT)  {
		super(partnerLink, newPLT);
	}

	@Override
	public Object get() {
		return ((PartnerLink)fTarget).getPartnerLinkType();
	}
	@Override
	public void set(Object o) {
		((PartnerLink)fTarget).setPartnerLinkType((PartnerLinkType)o);
	}
}
