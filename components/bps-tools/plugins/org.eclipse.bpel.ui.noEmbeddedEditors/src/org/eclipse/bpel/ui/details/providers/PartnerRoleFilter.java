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

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.ui.details.tree.ITreeNode;
import org.eclipse.bpel.ui.details.tree.PortTypeTreeNode;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


/**
 * Filter which excludes from a set of PartnerLinks those which are missing one or both roles.
 * 
 * For situations when one or the other role (or both) are required. 
 */
public class PartnerRoleFilter extends ViewerFilter
	implements IFilter
{
	boolean requireMyRole = true;
	boolean requirePartnerRole = true;
	
	public PartnerRoleFilter () {
		
	}
	public PartnerRoleFilter ( boolean requireMyRole, boolean requirePartnerRole) {
		this.requireMyRole = requireMyRole;
		this.requirePartnerRole = requirePartnerRole;
	}
	
	public void setRequireMyRole ( boolean value )
	{
		this.requireMyRole = value;
	}
	
	public void setRequirePartnerRole ( boolean value) 
	{
		this.requirePartnerRole = value;
	}
	
	
	@Override
	public boolean select (Viewer viewer, Object parentElement, Object element) {
		

		if (element instanceof PortTypeTreeNode) {
			return select ( element );
		}
		
		if (element instanceof ITreeNode) {
			return select ( ((ITreeNode)element).getModelObject() );			
		}
		return select ( element );
	}

	/** 
	 * @see org.eclipse.jface.viewers.IFilter#select(java.lang.Object)
	 */
	
	public boolean select (Object toTest) {

		if (toTest == null) {
			return false;
		}
		// Allow under these circumstances.
		if (requireMyRole == false && requirePartnerRole == false) {
			return true;
		}
		
		
		if ( PartnerLink.class.isInstance(toTest) ) {
			
			PartnerLink partnerLink = (PartnerLink) toTest;
			if (requireMyRole && partnerLink.getMyRole() == null) {
				return false;
			}
			if (requirePartnerRole && partnerLink.getPartnerRole() == null) {
				return false;
			}
		}
		
		// Filter away port types which are not derived from the right roles
		if (PortTypeTreeNode.class.isInstance( toTest )) {
			
			PortTypeTreeNode portTypeTreeNode = (PortTypeTreeNode) toTest;
			if (portTypeTreeNode.isDerivedFromMyRole() == false && requireMyRole) {
				return false;
			}
			if (portTypeTreeNode.isDerivedFromPartnerRole() == false && requirePartnerRole) {
				return false;
			}
		}
		
		return true;
	}
	
	
}
