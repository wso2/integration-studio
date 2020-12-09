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
package org.eclipse.bpel.ui.details.tree;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.wst.wsdl.PortType;

/**
 * Tree node to represent a PartnerLink model object.
 */
public class PartnerLinkTreeNode extends TreeNode {

	public PartnerLinkTreeNode(PartnerLink partnerLink, boolean isCondensed) {
		super(partnerLink, isCondensed);
	}

	/* ITreeNode */

	@Override
	public Object[] getChildren() {
		
		PartnerLink partnerLink = (PartnerLink)modelObject;
		
		if (partnerLink == null) {
			return EMPTY_ARRAY;
		}
		
		List<PortTypeTreeNode> list = new ArrayList<PortTypeTreeNode>(2);
		
		Role role = partnerLink.getMyRole();
		PortTypeTreeNode node = null;
		PortType portType = null;
		
		if (role != null && !role.eIsProxy() ) {
			portType = (PortType) role.getPortType();
			if (portType != null) {
				node = new PortTypeTreeNode((PortType)role.getPortType(), isCondensed);
				node.setDerivedFromMyRole(true);
				list.add(node);
			}
		}
		
		role = partnerLink.getPartnerRole();
		
		if (role != null && !role.eIsProxy() )  {
			portType = (PortType) role.getPortType();
			if (portType != null) {
				node = new PortTypeTreeNode((PortType)role.getPortType(), isCondensed);
				node.setDerivedFromPartnerRole(true);
				list.add(node);
			}
		}
		
		return list.toArray();
	}

	@Override
	public boolean hasChildren() {
		PartnerLink partnerLink = (PartnerLink)modelObject;
		
		if (partnerLink == null)  {
			return false;
		}
		
		Role role = partnerLink.getMyRole();
		if (role != null && !role.eIsProxy()) {
			return true;
		}
		role = partnerLink.getPartnerRole();
		if (role != null && !role.eIsProxy() ) {
			return true;
		}
		return false;
	}
}
