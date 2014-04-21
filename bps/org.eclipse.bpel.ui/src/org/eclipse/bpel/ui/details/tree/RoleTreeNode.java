/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.details.tree;

import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.wst.wsdl.PortType;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 17, 2006
 *
 */
public class RoleTreeNode extends TreeNode {

	
	public RoleTreeNode(Role role, boolean isCondensed) {
		super(role, isCondensed);
		if (role.getPortType() == null) {
			
		}
	}

	
	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.details.tree.TreeNode#getChildren()
	 */
	
	@Override
	public Object[] getChildren() {
		Role role = (Role) modelObject;
		if (role == null) {
			return EMPTY_ARRAY;
		}
		
		return new Object[] {
			new PortTypeTreeNode((PortType)role.getPortType(), isCondensed)
		};
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.details.tree.TreeNode#hasChildren()
	 */
	@Override
	public boolean hasChildren() {
		Role role = (Role) modelObject;
		return role != null && role.getPortType() != null ;
	}

}
