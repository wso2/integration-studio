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

import org.eclipse.bpel.ui.editparts.policies.BPELContainerEditPolicy;
import org.eclipse.gef.EditPolicy;


/**
 * A CompositeActivityEditPart represents an activity which can contain one or
 * more activities.
 * 
 * Useless class? Doesn't know about contained children. Only knows about connections
 * involving implicit links.
 */
public abstract class CompositeActivityEditPart extends ActivityEditPart {

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new BPELContainerEditPolicy());
	}
	
	/** 
	 * overridden if you don't want the implicit links to flow from top to bottom
	 */
	protected boolean isParallelImplicitLinksAtTop() {
		return true;
	}
	
	protected boolean isParallelImplicitLinksAtBottom() {
		return true;
	}
}
