/*******************************************************************************
 * Copyright (c) 2003, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.runtimes.module;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.runtimes.IBPELModuleFacetConstants;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.wst.common.componentcore.ComponentCore;
import org.eclipse.wst.common.componentcore.internal.StructureEdit;
import org.eclipse.wst.common.componentcore.internal.flat.IChildModuleReference;
import org.eclipse.wst.common.componentcore.internal.util.FacetedProjectUtilities;
import org.eclipse.wst.common.componentcore.resources.IVirtualComponent;
import org.eclipse.wst.common.componentcore.resources.IVirtualReference;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.internal.Module;
import org.eclipse.wst.server.core.internal.ModuleFactory;
import org.eclipse.wst.server.core.internal.ServerPlugin;
import org.eclipse.wst.server.core.model.ModuleDelegate;
import org.eclipse.wst.server.core.model.ModuleFactoryDelegate;
import org.eclipse.wst.server.core.util.ProjectModuleFactoryDelegate;

/**
 * J2EE module factory.
 */
public class BPELModuleFactoryDelegate extends ProjectModuleFactoryDelegate implements IResourceChangeListener {
	protected Map <IModule, FlatComponentDeployable> moduleDelegates = new HashMap<IModule, FlatComponentDeployable>(5);

	public static final String BPEL_FACTORY = "org.eclipse.bpel.runtimes.module.moduleFactory"; //$NON-NLS-1$ 
	
	public static BPELModuleFactoryDelegate FACTORY;
	public static BPELModuleFactoryDelegate factoryInstance() {
		if( FACTORY == null ) {
			ensureFactoryLoaded(BPEL_FACTORY);
		}
		return FACTORY;
	}
	
	public static void ensureFactoryLoaded(String factoryId) {
        ModuleFactory[] factories = ServerPlugin.getModuleFactories();
        for( int i = 0; i < factories.length; i++ ) {
                if( factories[i].getId().equals(factoryId)) {
                        factories[i].getDelegate(new NullProgressMonitor());
                }
        }
	}
	
	public BPELModuleFactoryDelegate() {
		super();
	}
	
	@Override
	public void initialize() {
		super.initialize();
		if( getId().equals(BPEL_FACTORY))
			FACTORY = this;
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
	}
	
	@Override
	protected IModule[] createModules(IProject project) {
		IVirtualComponent component = ComponentCore.createComponent(project);
		if(component != null)
			return createModuleDelegates(component);
		return null;
	}


	@Override
	public ModuleDelegate getModuleDelegate(IModule module) {
		if (module == null)
			return null;

		ModuleDelegate md = moduleDelegates.get(module);
//		if( md == null && ((Module)module).getInternalId().startsWith(BINARY_PREFIX))
//			return createDelegate(module);
		
		if (md == null) {
			createModules(module.getProject());
			md = moduleDelegates.get(module);
		}
		return md;
	}

	@SuppressWarnings("restriction")
	protected boolean canHandleProject(IProject p) {
		boolean result = FacetedProjectUtilities.isProjectOfType(p, IBPELModuleFacetConstants.BPEL20_PROJECT_FACET);
		return result;
	}
	
	protected IModule[] createModuleDelegates(IVirtualComponent component) {
		if(component == null){
			return null;
		}
		
		List<IModule> projectModules = new ArrayList<IModule>();
		IProject project = component.getProject();
		
		try {
			if (canHandleProject(project)) {
				// defer to other ProjectModuleFactoryDelegates who think they can handle BPEL modules
				ModuleFactory[] factories = ServerPlugin.getModuleFactories();
				for (int i = 0; i < factories.length; i++) {
					if(!factories[i].getId().equals(BPEL_FACTORY)) { // it's not me!
						ModuleFactoryDelegate d = factories[i].getDelegate(new NullProgressMonitor());
						if (d instanceof ProjectModuleFactoryDelegate) {
							ProjectModuleFactoryDelegate pd = (ProjectModuleFactoryDelegate)d;
							IModule[] modules = pd.getModules(project);
							if (modules!=null && modules.length>0)
								// return empty array - let the other guy handle this one
								return new IModule[0];
						}
					}
				}
				
				String type = IBPELModuleFacetConstants.BPEL20_MODULE_TYPE;
				String version = IBPELModuleFacetConstants.BPEL20_MODULE_VERSION;
				IModule module = createModule(component.getName(), component.getName(), type, version, project);
				FlatComponentDeployable moduleDelegate = createModuleDelegate(project, component);
				moduleDelegates.put(module, moduleDelegate);
				projectModules.add(module);

				// Check to add any binary modules
//				if (J2EEProjectUtilities.ENTERPRISE_APPLICATION.equals(type))
//					projectModules.addAll(LEGACY_createBinaryModules(component));
			} else {
				return null;
			}
		} catch (Exception e) {
//			e.printStackTrace();
//			J2EEPlugin.logError(e);
		}
		return projectModules.toArray(new IModule[projectModules.size()]);
	}

	protected FlatComponentDeployable createModuleDelegate(IProject project, IVirtualComponent component) {
		return new BPELDeployable(project, component);
	}

//	protected FlatComponentDeployable getNestedDelegate(IVirtualComponent component) {
//		return new BPELDeployable(component.getProject(), component);
//	}
	
	/**
	 * Returns the list of resources that the module should listen to for state
	 * changes. The paths should be project relative paths. Subclasses can
	 * override this method to provide the paths.
	 * 
	 * @return a possibly empty array of paths
	 */
	@Override
	protected IPath[] getListenerPaths() {
		return new IPath[] { new Path(".project"), // nature //$NON-NLS-1$
				new Path(StructureEdit.MODULE_META_FILE_NAME), // component
				new Path(".settings/org.eclipse.wst.common.project.facet.core.xml") // facets //$NON-NLS-1$
		};
	}

	@Override
	protected void clearCache(IProject project) {
		super.clearCache(project);
		List<IModule> modulesToRemove = null;
		for (Iterator<IModule> iterator = moduleDelegates.keySet().iterator(); iterator.hasNext();) {
			IModule module = iterator.next();
			if (module.getProject().equals(project)) {
				if (modulesToRemove == null) {
					modulesToRemove = new ArrayList<IModule>();
				}
				modulesToRemove.add(module);
			}
		}
		if (modulesToRemove != null) {
			for (IModule module : modulesToRemove) {
				moduleDelegates.remove(module);
			}
		}
	}
	
//	/**
//	 * From this point on, when queried, projects will generate their binary 
//	 * child modules on the fly and they will be small and dumb
//	 * 
//	 * @param parent
//	 * @param child
//	 * @return
//	 */
//	public IModule createChildModule(FlatComponentDeployable parent, IChildModuleReference child) {
//		File file = child.getFile();
//		if( file != null ) {
//			IPath p = new Path(file.getAbsolutePath());
//			JavaEEQuickPeek qp = JavaEEBinaryComponentHelper.getJavaEEQuickPeek(p);
//			IModule module = createModule(qp, BINARY_PREFIX + file.getAbsolutePath(), file.getName(), parent.getProject());
//			FlatComponentDeployable moduleDelegate = getNestedDelegate(child.getComponent());
//			moduleDelegates.put(module, moduleDelegate);
//			return module;
//		}
//		return null;
//	}
	
//	/**
//	 * Create a module delegate on the fly for this binary file
//	 * @param module
//	 * @return
//	 */
//	public ModuleDelegate createDelegate(IModule module) {
//		String internalId = ((Module)module).getInternalId();
//		String path = internalId.substring(BINARY_PREFIX.length());
//		File f = new File(path);
//		return new BinaryFileModuleDelegate(f);
//	}

	public void resourceChanged(IResourceChangeEvent event) {
		cleanAllDelegates();
	}
	
	protected void cleanAllDelegates() {
		Iterator<FlatComponentDeployable> i = moduleDelegates.values().iterator();
		while(i.hasNext()) {
			i.next().clearCache();
		}
		modulesChanged();
	}
}
