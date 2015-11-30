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
package org.eclipse.bpel.runtimes.facets;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.wst.common.componentcore.internal.resources.VirtualArchiveComponent;
import org.eclipse.wst.common.componentcore.internal.resources.VirtualComponent;
import org.eclipse.wst.common.componentcore.internal.resources.VirtualFolder;
import org.eclipse.wst.common.componentcore.internal.util.IComponentImplFactory;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;
import org.eclipse.wst.common.componentcore.resources.IVirtualFolder;

public class BPELVirtualComponent extends VirtualComponent implements IComponentImplFactory {
	public BPELVirtualComponent() {
		super();
	}
	
	public BPELVirtualComponent(IProject aProject, IPath aRuntimePath) {
		super(aProject, aRuntimePath);
	}
	
	public IVirtualComponent createComponent(IProject aProject) {
		return new BPELVirtualComponent(aProject, new Path("/"));
	}
	
	public IVirtualFolder createFolder(IProject aProject, IPath aRuntimePath) {
		return new VirtualFolder(aProject, aRuntimePath);
	}
	
	public IVirtualComponent createArchiveComponent(IProject aProject,
			String archiveLocation, IPath aRuntimePath) {
		return new VirtualArchiveComponent(aProject, archiveLocation, aRuntimePath);
	}
}
