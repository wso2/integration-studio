package org.eclipse.bpel.apache.ode.runtime;

/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

import java.io.File;

import org.eclipse.bpel.runtimes.publishers.GenericBPELPublisher;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jst.server.core.PublishUtil;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IModuleArtifact;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.model.IModuleResource;
import org.eclipse.wst.server.core.model.ModuleDelegate;

/**
 * BPEL publisher for Apache ODE.
 * 
 * @author Tammo van Lessen (IAAS)
 * @author Simon Moser (IBM)
 */
public class OdeBPELPublisher extends GenericBPELPublisher {

	public OdeBPELPublisher() {
		super();
	}

	@Override
	public IStatus[] publish(IModuleArtifact[] artifacts, IProgressMonitor monitor) {
		// resources will always be null for some weird reason :(
		// therefore we generate a BPELModuleArtifact
		// the module id value enables us to get BPEL file path relative to its project
		IModule[] modules = super.getModule();
		
		try {
			IModule last = modules[modules.length-1];
			IPath root = createDeploymentDestination(last);
			ModuleDelegate delegate = (ModuleDelegate)last.loadAdapter(ModuleDelegate.class, new NullProgressMonitor());
			IModuleResource[] resources = delegate.members();
			PublishUtil.publishFull(resources, root, monitor);

			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=379613
			// remove the "*.deployed" file, so Ode knows to reload the changes
			File f = root.addFileExtension("deployed").toFile();
			if (f.exists()) {
				f.delete();
			}
			
		} catch(  CoreException ce ) {
			// TODO return bad status
		}
		return new IStatus[]{Status.OK_STATUS};

	}

	@Override
	public IStatus[] unpublish(IProgressMonitor monitor) {
		IModule[] modules = super.getModule();
		IModule last = modules[modules.length - 1];
		IStatus[] result = new Status[modules.length];
		IPath root = createDeploymentDestination(last);
		PublishUtil.deleteDirectory(root.toFile(), monitor);
		return result;
	}

	/**
	 * This method will create a folder inside the WEB-INF\processes subfolder
	 * of the ODE installation
	 */
	protected IPath createDeploymentDestination(IModule module) {
		String moduleName = module.getName();
		String deployAppName = moduleName;

		// get TOMCAT_HOME
		IRuntime serverDef = getServerRuntime().getRuntime();
		IPath tomcatHome = serverDef.getLocation();

		// append ODE's Process target Dir tomcatHome
		IPath deployTarget = tomcatHome.append("webapps").append("ode")
				.append("WEB-INF").append("processes").append(deployAppName);

		File f = deployTarget.toFile();
		if (!f.exists()) {
			f.mkdir();
		}

		return deployTarget;
	}
}
