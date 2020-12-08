/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.distributionproject.module.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.model.ModuleDelegate;
import org.eclipse.wst.server.core.model.ModuleFactoryDelegate;
import org.wso2.developerstudio.eclipse.distributionproject.module.Activator;
import org.wso2.developerstudio.eclipse.distributionproject.module.utils.Constants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;


public class CarbonModuleFactory extends ModuleFactoryDelegate{
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	protected IWorkspaceRoot root;
	private Map<IProject, IModule> modules = new HashMap<IProject, IModule>();

	public CarbonModuleFactory() {
		super();
		root = ResourcesPlugin.getWorkspace().getRoot();
	}
	
	public ModuleDelegate getModuleDelegate(IModule module) {
		return null;
	}

	public IModule[] getModules() {
		cacheModules();
		List<IModule> list = new ArrayList<IModule>();
		Iterator<IModule> iter = modules.values().iterator();
		while (iter.hasNext()) {
			IModule m = (IModule) iter.next();
			if (m != null) {
				list.add(m);
			}
		}

		IModule[] modulesArray = new IModule[list.size()];
		list.toArray(modulesArray);
		return modulesArray;
	}

	public final void cacheModules() {
		try {
			clearCache();
			IProject[] projects = root.getProjects();
			int size = projects.length;

			for (int i = 0; i < size; i++) {
				if (projects[i].isAccessible()) {
					boolean cache = true;
					try {
						Object o = modules.get(projects[i]);
						if (o != null) {
							cache = false;
						}

					} catch (Exception e) {
						// ignore
					}

					if (cache) {
						try {
							if (projects[i].hasNature(Constants.CAPP_NATURE_ID)) {
								/*
								 * TODO: Use ProjectFacetsManager.isProjectFacetDefined() instead of
								 *   project.hasNature()
								 */
								IModule module = createModule(projects[i].getName(),
								                              projects[i].getName(),
								                              Constants.CAPP_MODULE_ID,
								                              Constants.CAPP_MODULE_VERSION,
								                              projects[i]);
								if (module != null) {
									modules.put(projects[i], module);
								}
							}
						} catch (Throwable t) {
							log.error("Error creating module for " + projects[i].getName(), t);
						}
					}

				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
	
	protected void clearCache() {
		modules = new HashMap<IProject, IModule>();
	}
	
	
}
