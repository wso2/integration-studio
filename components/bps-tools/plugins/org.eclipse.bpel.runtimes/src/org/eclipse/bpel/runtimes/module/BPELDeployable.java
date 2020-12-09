/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.runtimes.module;

import org.eclipse.core.resources.IProject;
import org.eclipse.wst.common.componentcore.internal.flat.IFlattenParticipant;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;

public class BPELDeployable extends FlatComponentDeployable {

	public BPELDeployable(IProject project) {
		super(project);
	}
	
	public BPELDeployable(IProject project, IVirtualComponent aComponent) {
		super(project, aComponent);
	}
	
	@Override
	public boolean shouldCache() {
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.runtimes.module.FlatComponentDeployable#getParticipants()
	 */
	protected IFlattenParticipant[] getParticipants() {
		/*
		 * No work really needs to be done here. The BPEL project
		 * doesn't need to map source in instead, it doesn't need to 
		 * update a manifest file, it doesn't need to add in classpath dependencies, etc etc
		 * 
		 * Just standard traversals as of now. 
		 */
		return super.getParticipants();
	}
}
