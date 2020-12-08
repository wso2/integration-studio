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

package org.wso2.developerstudio.eclipse.registry.manager.local.manager;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.decorators.RegistryResourceDecorator;

public class FileModificationManager implements IResourceChangeListener {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	protected int INTERESTING_CHANGES = IResourceDelta.CONTENT | 
										IResourceDelta.MOVED_FROM | 
										IResourceDelta.MOVED_TO	| 
										IResourceDelta.REPLACED;

	/**
	 * handle resource changed event
	 */
	public void resourceChanged(IResourceChangeEvent event) {
		try {
			final List<IResource> modifiedResources = new ArrayList<IResource>();
			final List<IResource> modifiedInfiniteDepthResources = new ArrayList<IResource>();

			event.getDelta().accept(new IResourceDeltaVisitor() {
				public boolean visit(IResourceDelta delta) {
					IResource resource = delta.getResource();
					if (resource.getType() == IResource.ROOT) {
						return true;
					}else if (resource.getType() == IResource.PROJECT) {
						return true;
					}else if (resource.getType() == IResource.FILE) {
						if (delta.getKind() == IResourceDelta.CHANGED && resource.exists()) {
							if ((delta.getFlags() & INTERESTING_CHANGES) != 0) {
								modifiedResources.add(resource);
								return true;
							}
						} else if (delta.getKind() == IResourceDelta.ADDED) {
							modifiedResources.add(resource);
							return true;
						} else if (delta.getKind() == IResourceDelta.REMOVED) {
							modifiedResources.add(resource);
							return true;
						}
					} else if (resource.getType() == IResource.FOLDER) {
						modifiedResources.add(resource);
						return true;
					}
					return false;
				}
			});

			final List<IProject> projects=new ArrayList<IProject>();
			for (IResource resource : modifiedResources) {
				IProject project = resource.getProject();
				if (!projects.contains(project)){
					projects.add(project);
				}
			}
			
			RegistryResourceDecorator.refreshResources(modifiedResources.toArray(new Object[]{}));
			RegistryResourceDecorator.refreshResources(modifiedResources.toArray(new Object[]{}));
		} catch (CoreException e) {
			log.error(e);
		}
	}

}
