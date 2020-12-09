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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.ui.details.tree.PortTypeTreeNode;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.PortType;

/**
 * Provides a tree of model objects representing some expansion of the underlying graph
 * of model objects whose roots are the PortTypes of a Role. 
 */
public class PortTypeTreeContentProvider extends ModelTreeContentProvider {

	public PortTypeTreeContentProvider(boolean isCondensed) {
		super(isCondensed);
	}

	@Override
	public Object[] primGetElements (Object inputElement) {
		
		List list = new LinkedList();
		if (inputElement instanceof Role) {
			Role r = (Role) inputElement;
			list.add(new PortTypeTreeNode((PortType) r.getPortType(), isCondensed));
		} else if (inputElement instanceof Definition) {
			Definition defn = (Definition) inputElement;
			Iterator it = defn.getPortTypes().values().iterator();
			while (it.hasNext()) {
				PortType element = (PortType) it.next();
				list.add ( new PortTypeTreeNode(element,isCondensed));
			}			
		}
		// https://jira.jboss.org/browse/JBIDE-6697
		// from eclipse.org/bpel rev 1.5 on 5/5/2010 5:13AM by smoser: fix for bidirectional PLT - > Tammo/JAX Session Feedback
		else if (inputElement instanceof List){
			List inputList = (List) inputElement;
			for (Iterator iterator = inputList.iterator(); iterator.hasNext();) {
				Definition def = (Definition) iterator.next();
				Iterator it = def.getPortTypes().values().iterator();
				while (it.hasNext()) {
					PortType element = (PortType) it.next();
					list.add ( new PortTypeTreeNode(element,isCondensed));
				}		
			}
			
		}
		return list.isEmpty() ? EMPTY_ARRAY : list.toArray();
	}
}
