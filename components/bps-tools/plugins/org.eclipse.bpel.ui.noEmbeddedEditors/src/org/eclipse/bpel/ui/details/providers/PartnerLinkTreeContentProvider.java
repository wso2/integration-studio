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

import java.util.ArrayList;

import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.ui.details.tree.PartnerLinkTreeNode;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;


/**
 * Provides a tree of model objects representing some expansion of the underlying graph
 * of model objects whose roots are the PartnerLinks of a Process. 
 */
public class PartnerLinkTreeContentProvider extends ModelTreeContentProvider {

	public PartnerLinkTreeContentProvider (boolean isCondensed) {
		super(isCondensed);
	}

	@Override
	public Object[] primGetElements (Object inputElement) {
		
		PartnerLink links[] = BPELUtil.getVisiblePartnerLinks( (EObject) inputElement);
		ArrayList list = new ArrayList( links.length + 1);
		for(int i=0; i<links.length; i++) {
			list.add( new PartnerLinkTreeNode( links[i], isCondensed ));
		}
		return list.toArray();
	}
}
