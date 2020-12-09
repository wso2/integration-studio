/*******************************************************************************
 * Copyright (c) 2009, 2012 Red Hat and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  THIS CLASS IS AN EXACT CLONE OF 
 *  org.eclipse.wst.web.internal.deployables.FlatComponentDeployable
 *  
 *  This class is a candidate for being pushed into COMMON TOOLS
 *******************************************************************************/
package org.eclipse.bpel.runtimes.module;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.wst.common.componentcore.ComponentCore;
import org.eclipse.wst.common.componentcore.internal.flat.FlatVirtualComponent;
import org.eclipse.wst.common.componentcore.internal.flat.FlatVirtualComponent.FlatComponentTaskModel;
import org.eclipse.wst.common.componentcore.internal.flat.IChildModuleReference;
import org.eclipse.wst.common.componentcore.internal.flat.IFlatFile;
import org.eclipse.wst.common.componentcore.internal.flat.IFlatFolder;
import org.eclipse.wst.common.componentcore.internal.flat.IFlatResource;
import org.eclipse.wst.common.componentcore.internal.flat.IFlatVirtualComponent;
import org.eclipse.wst.common.componentcore.internal.flat.IFlattenParticipant;
import org.eclipse.wst.common.componentcore.internal.util.VirtualReferenceUtilities;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;
import org.eclipse.wst.common.project.facet.core.IFacetedProject;
import org.eclipse.wst.common.project.facet.core.IProjectFacet;
import org.eclipse.wst.common.project.facet.core.ProjectFacetsManager;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.ServerUtil;
import org.eclipse.wst.server.core.model.IModuleFile;
import org.eclipse.wst.server.core.model.IModuleFolder;
import org.eclipse.wst.server.core.model.IModuleResource;
import org.eclipse.wst.server.core.model.ModuleDelegate;
import org.eclipse.wst.server.core.util.ModuleFile;
import org.eclipse.wst.server.core.util.ProjectModule;

public abstract class FlatComponentDeployable extends ProjectModule {

	/*
	 * Register an adapt IModule to IVirtualComponent 
	 */
	static {
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {
			public Class[] getAdapterList() {
				return new Class[] { IVirtualComponent.class };
			}

			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof IModule) {
					IModule module = (IModule) adaptableObject;
					FlatComponentDeployable deployable = (FlatComponentDeployable) module.loadAdapter(FlatComponentDeployable.class, null);
					if(deployable != null){
						IVirtualComponent virtualComponent = deployable.getComponent();
						return virtualComponent;
					}
				}
				return null;
			}
		}, IModule.class);
	}
	
	protected IVirtualComponent component = null;
	protected List<IModuleResource> members = new ArrayList<IModuleResource>();
	
	public FlatComponentDeployable(IProject project) {
		this(project,ComponentCore.createComponent(project));
	}
	
	public FlatComponentDeployable(IProject project, IVirtualComponent aComponent) {
		super(project);
		this.component = aComponent;
	}

	public IVirtualComponent getComponent() {
		return component;
	}
	
	/**
	 * We will cache the flattened piece here, and instead redirect
	 * the module factories to recreate the modules *whenever* there is 
	 * a workspace change. This will still be much more efficient than
	 * traversing the tree each time a call to getResources() or getChildModules(). 
	 */
	private FlatVirtualComponent cacheFlattened = null;

	
	public boolean shouldCache() {
		return false;
	}
	
	public void clearCache() {
		cacheFlattened = null;
	}
	
	/**
	 * The export model is what does the grunt of the work
	 * @return
	 */
	protected IFlatVirtualComponent getFlatComponent() {
		if( !shouldCache() || cacheFlattened == null ) {
			FlatComponentTaskModel options = new FlatComponentTaskModel();
			options.put(FlatVirtualComponent.PARTICIPANT_LIST, Arrays.asList(getParticipants()));
			FlatVirtualComponent tmp = new FlatVirtualComponent(component, options);
			if( shouldCache())
				cacheFlattened = tmp;
			return tmp;
		}
		return cacheFlattened;
	}
	
	/**
	 * Subclasses can provide a list of participants who may
	 * be involved in forming the export model
	 * 
	 * A deployable with no participant should still properly
	 * consume consumed references and traverse the model appropriately
	 * 
	 * @return
	 */
	protected IFlattenParticipant[] getParticipants() {
		return new IFlattenParticipant[]{
		};
	}
	
	public boolean isBinary() {
		return component == null ? false : component.isBinary();
	}

	@Override
	public IModuleResource[] members() throws CoreException {
		if( component.isBinary() ) 
			return LEGACY_binaryMembers();
		
		IFlatVirtualComponent em = getFlatComponent();
		IFlatResource[] resources = em.fetchResources();
		return convert(resources);
		
	}

	protected IModuleResource[] LEGACY_binaryMembers() {
		IFile ifile = (IFile)component.getAdapter(IFile.class);
		File file = (File)component.getAdapter(File.class);
		ModuleFile mf = ifile != null ? new ModuleFile(ifile, ifile.getName(), new Path(""))  //$NON-NLS-1$
		 		: new ModuleFile(file, file.getName(), new Path("")); //$NON-NLS-1$
		return new IModuleResource[]{mf};
	}
	
	 /**
     * Returns the child modules of this module.
     * 
     * @return org.eclipse.wst.server.core.model.IModule[]
     */
    @Override
	public IModule[] getChildModules() {
        return getModules();
    }
    
    public /* non api */ IChildModuleReference[] getExportModelChildren() throws CoreException {
    	IFlatVirtualComponent em = getFlatComponent();
    	IChildModuleReference[] children = em.getChildModules();
    	return children;
    }
    
    public IModule[] getModules() {
    	// Legacy, here in case the old modules are used
    	if( component.isBinary() ) 
    		return new IModule[]{};
    		
    	try {
    		List<IModule> modules = new ArrayList<IModule>();
	    	IChildModuleReference[] children = getExportModelChildren();
	    	for( int i = 0; i < children.length; i++ ) {
	    		IModule child = gatherModuleReference(component, children[i]);
	    		if( child != null )
	    			modules.add(child);
	    	}
	    	return modules.toArray(new IModule[modules.size()]);
    	} catch( CoreException ce ) {
    	}
    	return new IModule[]{};
	}
    
	@Override
	public String getPath(IModule m) {
		return getURI(m);
	}

	/**
	 * Returns the URI of the given contained CHILD module.
	 * 
	 * SOFT requirements (NOT API!!) in use by some adopters
	 * If the passed in module is equal to this module, return our own deployed name
	 *
	 * @param module a module
	 * @return the URI of the given module, or <code>null</code> if the URI could
	 *    not be found
	 */
	public String getURI(IModule module) {
		ProjectModule md = (ProjectModule)module.loadAdapter(ProjectModule.class, new NullProgressMonitor());
		if( md == this ) {
			// guess my own name
			return VirtualReferenceUtilities.INSTANCE.getDefaultProjectArchiveName(this.component);
		}
		try {
			FlatComponentDeployable cd = (FlatComponentDeployable)module.loadAdapter(FlatComponentDeployable.class, new NullProgressMonitor());
			if( cd != null ) {
		    	IFlatVirtualComponent em = getFlatComponent();
		    	IChildModuleReference[] children = em.getChildModules();
		    	for( int i = 0; i < children.length; i++ ) {
		    		IModule child = gatherModuleReference(component, children[i]);
		    		if( child != null && child.getId().equals(module.getId()))
		    			return children[i].getRelativeURI().toString();
		    	}
			}
		} catch( CoreException ce ) {
		}
		return null;
	}
    
    /**
     * If I know how to find an IModule for this child, do so now
     * 
     * I would love to see this replaced with some API to locate a 
     * possible child module based on a virtual component.
     * 
     * @param component
     * @param targetComponent
     * @return
     */
    protected IModule gatherModuleReference(IVirtualComponent component, IChildModuleReference child) {
    	// Handle workspace project module components
    	// Subclasses should extend 
    	IVirtualComponent targetComponent = child.getComponent();
    	if (targetComponent != null && targetComponent.getProject()!= component.getProject()) {
			if (!targetComponent.isBinary()) {
				return filterModuleDelegates(ServerUtil.getModules(targetComponent.getProject()));
			}
		}
		return null;
    }
    	
    /**
     * An extender may wish to override this method in order to control which
     * delegate is returned in the scenario where more than one exist.  By default
     * the first one found is returned.
     * 
     * @param IModule[] modules
     * @return IModule[]
     */
    protected IModule filterModuleDelegates(IModule[] modules) {
    	for (int i = 0; i < modules.length; i++) {
			ModuleDelegate md = (ModuleDelegate)modules[i].loadAdapter(ModuleDelegate.class, new NullProgressMonitor());
			if (md instanceof ProjectModule) {
				return modules[i];
			}
		}
    	return modules.length > 0 ? modules[0] : null;
	}
    
    /*
     * Below are STATIC utility classes and methods
     */
	protected static IModuleResource[] convert(IFlatResource[] resources) {
		ArrayList<IModuleResource> list = new ArrayList<IModuleResource>();
		for( int i = 0; i < resources.length; i++ ) {
			if( resources[i] instanceof IFlatFile)
				list.add(new ComponentModuleFile(resources[i]));
			else if( resources[i] instanceof IFlatFolder) 
				list.add(new ComponentModuleFolder(resources[i]));
		}
		return list.toArray(new IModuleResource[list.size()]);
	}
	
	public static class ComponentModuleResource {
		protected IFlatResource delegate;
		public ComponentModuleResource(IFlatResource resource) {
			this.delegate = resource;
		}
		public long getModificationStamp() {
			return ((IFlatFile)delegate).getModificationStamp();
		}
		
		public IPath getModuleRelativePath() {
			return delegate.getModuleRelativePath();
		}
		public String getName() {
			return delegate.getName();
		}
		public Object getAdapter(Class adapter) {
			return delegate.getAdapter(adapter);
		}
		public IModuleResource[] members() {
			IFlatResource[] children = ((IFlatFolder)delegate).members();
			return convert(children);
		}
	}

	public static class ComponentModuleFile extends ComponentModuleResource implements IModuleFile{
		public ComponentModuleFile(IFlatResource resource) {
			super(resource);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj == this)
				return true;
			
			if (!(obj instanceof IModuleFile))
				return false;
			
			IModuleFile mf = (IModuleFile) obj;
			if (!getName().equals(mf.getName()))
				return false;
			if (!getModuleRelativePath().equals(mf.getModuleRelativePath()))
				return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			return getName().hashCode() * 37 + getModuleRelativePath().hashCode();
		}
	}

	public static class ComponentModuleFolder extends ComponentModuleResource implements IModuleFolder {
		public ComponentModuleFolder(IFlatResource resource) {
			super(resource);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj == this)
				return true;
			
			if (!(obj instanceof IModuleFolder))
				return false;
			
			IModuleFolder mf = (IModuleFolder) obj;
			if (!getName().equals(mf.getName()))
				return false;
			if (!getModuleRelativePath().equals(mf.getModuleRelativePath()))
				return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			return getName().hashCode() * 37 + getModuleRelativePath().hashCode();
		}
		
	}

	protected static boolean isProjectOfType(IProject project, String typeID) {
		IFacetedProject facetedProject = null;
		try {
			facetedProject = ProjectFacetsManager.create(project);
		} catch (CoreException e) {
			return false;
		}
		
		if (facetedProject !=null && ProjectFacetsManager.isProjectFacetDefined(typeID)) {
			IProjectFacet projectFacet = ProjectFacetsManager.getProjectFacet(typeID);
			return projectFacet!=null && facetedProject.hasProjectFacet(projectFacet);
		}
		return false;
	}
}
