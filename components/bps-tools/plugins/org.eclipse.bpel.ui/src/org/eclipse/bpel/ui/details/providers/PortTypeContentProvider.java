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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.PortType;

/**
 * Content provider for PortTypes.
 * 
 * Expects a Role or a Definition or a context as input.
 */
public class PortTypeContentProvider extends AbstractContentProvider  {

	@Override
	public void collectElements(Object input, List list)  {
		
		if (input instanceof Definition) {
			Definition defn = (Definition) input;
			list.addAll ( defn.getEPortTypes() );
			
		} else if (input instanceof PortType) {
			
			PortType pt = (PortType) input;
			collectElements ( pt.eContainer(), list );
			
		} else if (input instanceof Role) {
		
			Role role = (Role) input;
			PortType portType = ModelHelper.getRolePortType(role);
			if (portType != null) {
				list.add ( portType );
			}
			
		} else if (input instanceof EObject) {
			EObject eObj = (EObject) input;
			
			// everything else is expected to be a Process or something inside a Process.			
			PartnerLink[] partnerLinks = BPELUtil.getVisiblePartnerLinks( eObj );			
			Set portTypeSet = new HashSet();
			for (int i = 0; i<partnerLinks.length; i++) {
				PortType pt = ModelHelper.getPartnerPortType(partnerLinks[i], ModelHelper.INCOMING);
				if (pt != null) {
					if (portTypeSet.add(pt)) {
						list.add(pt);
					}
				}
				pt = ModelHelper.getPartnerPortType(partnerLinks[i], ModelHelper.OUTGOING);
				if (pt != null) {
					if (portTypeSet.add(pt)) {
						list.add(pt);
					}
				}
			}
			
		}
	}
}
