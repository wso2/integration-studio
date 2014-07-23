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

import org.eclipse.bpel.runtimes.IBPELModuleFacetConstants;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jem.util.logger.proxy.Logger;
import org.eclipse.wst.common.project.facet.core.IFacetedProject;
import org.eclipse.wst.common.project.facet.core.IProjectFacet;
import org.eclipse.wst.common.project.facet.core.ProjectFacetsManager;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IModuleArtifact;
import org.eclipse.wst.server.core.ServerUtil;

/**
 * Utility to adapt an object (in this case an <code>IProject</code< or an 
 * <code>IFile</code>) toa <code>BPELModuleArtifact</code>.
 *
 * @author Bruno Wassermann, written Aug 14, 2006
 */
public class BPELDeployableArtifactUtil {

	public BPELDeployableArtifactUtil() {
		super();
	}
	
	/**
	 * Adapt an object to an <code>IModuleArtifact</code>
	 * 
	 * @param obj
	 * @return <code>IModuleArtifact</code>
	 */
	public static IModuleArtifact getModuleObject(Object obj) {
		if (obj instanceof IProject) {
			return getModuleObject((IProject) obj);
		}
			
		if (obj instanceof IFile) {
			return getModuleObject((IFile) obj);
		}
			
		return null;
	}
	
	protected static IModuleArtifact getModuleObject(IProject project) {
		return null;
	}
	
	protected static IModuleArtifact getModuleObject(IFile file) {
		// TODO this is not really how you should be using BPELModuleDelegate 
		BPELModuleDelegate moduleDelegate = new BPELModuleDelegate(file.getProject(), file);
		IStatus fileStatus = moduleDelegate.validate();
		
		if (IStatus.OK != fileStatus.getCode()) return null; // not a valid BPEL file
		
		IModule[] modules = ServerUtil.getModules(IBPELModuleFacetConstants.BPEL20_MODULE_TYPE);
		
		for (int i=0; i<modules.length; i++) {
			
			if (modules[i].getProject().equals(file.getProject()) 
					&& modules[i].getName().equals(file.getName())) 
			{
				return new BPELModuleArtifact(modules[i], file);
			}
		}
		return null;
	}
}
