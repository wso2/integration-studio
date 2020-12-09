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
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.util.ModelHelper;


/** 
 * Sets the "myRole" or "partnerRole" property of a model object.  This is supported
 * for Partner objects.
 */
public class SetRoleCommand extends SetCommand {

	int roleNum;
	
	public String getDefaultLabel() {
		if (roleNum == ModelHelper.MY_ROLE) {
			return IBPELUIConstants.CMD_SELECT_MYROLE;
		}
		return IBPELUIConstants.CMD_SELECT_PARTNERROLE;
	}

	public SetRoleCommand(PartnerLink partnerLink, Role newRole, int roleNum)  {
		super(partnerLink, newRole);
		this.roleNum = roleNum;		
	}

	@Override
	public Object get() {
		switch (roleNum) {
			case ModelHelper.MY_ROLE:
				return ((PartnerLink)fTarget).getMyRole();
			case ModelHelper.PARTNER_ROLE:
				return ((PartnerLink)fTarget).getPartnerRole();
		}
		return null;
	}
	@Override
	public void set(Object o) {
		switch (roleNum) {
			case ModelHelper.MY_ROLE:
				((PartnerLink)fTarget).setMyRole((Role)o);
				return;
			case ModelHelper.PARTNER_ROLE:
				((PartnerLink)fTarget).setPartnerRole((Role)o);
				return;
		}
	}
}
