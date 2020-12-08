/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.registry.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryResource;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryResourceProvider;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioElement;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;

public class RegistryResourceProvider implements IRegistryResourceProvider {
	
	List<IRegistryResourceProvider> subProviders;

	public RegistryResourceProvider() {
	}

	public IRegistryResource[] getResources(Map<String, List<String>> filters) {
		return null;
	}

	public IRegistryResourceProvider[] getCategories(Map<String, List<String>> filters) {
		if (subProviders == null) {
			subProviders = new ArrayList<IRegistryResourceProvider>();
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
					.getProjects();
			for (IProject project : projects) {
				try {
					if (project.isOpen()
							&& project
									.hasNature("org.wso2.developerstudio.eclipse.general.project.nature")) {
						project.refreshLocal(IResource.DEPTH_INFINITE, null);
						if (DeveloperStudioProviderUtils.isInProjectFilterPassed(
								filters, project)) {
							ProjectRegistryResourceProvider cAppProjectRegistryResourceProvider = new ProjectRegistryResourceProvider(
									project);
							IRegistryResourceProvider[] categories = cAppProjectRegistryResourceProvider
									.getCategories(filters);
							if (categories != null && categories.length > 0) {
								subProviders
										.add(cAppProjectRegistryResourceProvider);
							}
						}
					}
				} catch (CoreException ignored) {
					// ignored
				}
			}
		}
		return subProviders.toArray(new IRegistryResourceProvider[]{});
	}

	public ImageDescriptor getIcon() {
		return ResourceManager.getImageDescriptor(this.getClass(),"/icons/application-registry-resource-icon.png"); 
	}

	public String getId() {
		return null;
	}

	public String getText() {
		return null;
	}

	public void refresh() {
		subProviders=null;
		
	}

	public IDeveloperStudioElement[] getElements(Map<String, List<String>> filters) {
		return getResources(filters);
	}

	
}
