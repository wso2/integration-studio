/*******************************************************************************
 * Copyright (c) 2006, 2012 University College London Software Systems Engineering
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Bruno Wassermann - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.runtimes.module;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.debug.ui.actions.ILaunchable;
import org.eclipse.wst.server.core.IModuleArtifact;
import org.eclipse.wst.server.core.model.ModuleArtifactAdapterDelegate;

/**
 * Preliminary implementation of <code>ModuleArtifactAdapterDelegate</code> 
 * and <code>I</code>for BPEL modules.
 *
 * @author Bruno Wassermann, written Aug 14, 2006
 */
public class BPELDeployableArtifactAdapterFactory extends
		ModuleArtifactAdapterDelegate implements IAdapterFactory 
{

	/**
	 * 
	 */
	public BPELDeployableArtifactAdapterFactory() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.wst.server.core.model.ModuleArtifactAdapterDelegate#getModuleArtifact(java.lang.Object)
	 */
	@Override
	public IModuleArtifact getModuleArtifact(Object obj) {
		return BPELDeployableArtifactUtil.getModuleObject(obj);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
	 */
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	public Class[] getAdapterList() {
		
		// TODO replace ILaunchable with interface of BPEL module artifacts once available
		return new Class[]{ILaunchable.class};
	}

}
