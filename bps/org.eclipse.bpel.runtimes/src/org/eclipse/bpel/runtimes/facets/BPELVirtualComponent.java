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
