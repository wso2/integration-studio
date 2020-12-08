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

package org.wso2.developerstudio.eclipse.registry.manager.local.ui.controls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;

public class WorkspaceResourceTreeViewer extends TreeViewer {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	List<IResource> allRootResources;

	/**
	 * WorkspaceResourceTreeViewer constructor
	 * @param parent
	 * @param style
	 */
	public WorkspaceResourceTreeViewer(Composite parent, int style) {
		super(parent, style);
		setupProviders();
	}

	/**
	 * get the current active shell
	 * @return
	 */
	protected Shell getShell() {
		return getTree().getShell();
	}

	/**
	 * setup Providers
	 */
	private void setupProviders() {
		setContentProvider(new ITreeContentProvider() {
			Map<IFolder, ArrayList<IResource>> lists = new HashMap<IFolder, ArrayList<IResource>>();
			
			public void dispose() {
			}

			public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
			}

			public Object[] getChildren(Object arg0) {
				if (arg0 instanceof List) {
					List<IResource> resources = (List<IResource>) arg0;
					return resources.toArray();
				} else if ((arg0 instanceof IFolder)) {
					final IFolder o = (IFolder) arg0;
					retrieveFolderResources(o);
					return lists.get(o).toArray();
				} else if ((arg0 instanceof IFile)){
					return new Object[] { arg0 };
				}
				return new Object[] {};
			}

			public Object getParent(Object arg0) {
				return null;
			}

			public boolean hasChildren(Object arg0) {
				if (arg0 instanceof List) {
					return ((List) arg0).size() > 0;
				} else if (arg0 instanceof IFolder) {
					final IFolder o = (IFolder) arg0;
					retrieveFolderResources(o);
					return lists.get(o).size() > 0;
				} else if ((arg0 instanceof IFile))
					return false;
				return false;
			}

			public Object[] getElements(Object arg0) {
				return getChildren(arg0);
			}

			private void retrieveFolderResources(final IFolder folder) {
				if (lists.containsKey(folder)){
					return;
				}
				final ArrayList<IResource> list = new ArrayList<IResource>();
				try {
					final boolean isResource = !(RegistryCheckInClientUtils.getResourceState(
												folder.getLocation().toOSString()) == 
												RegistryCheckInClientUtils.RESOURCE_STATE_NOT_RESOURCE);
					folder.accept(new IResourceVisitor() {
						public boolean visit(IResource resource) throws CoreException {
							if (!folder.getLocation().toOSString().equals(resource.getLocation().toOSString())) {
								if (isResource) {
									if (!resource.getName().equals(".meta")) {
										int state = RegistryCheckInClientUtils.getResourceState(
																resource.getLocation().toOSString());
										if (state == RegistryCheckInClientUtils.RESOURCE_STATE_DELETED || 
											state == RegistryCheckInClientUtils.RESOURCE_STATE_MODIFIED || 
											state == RegistryCheckInClientUtils.RESOURCE_STATE_NEW){
											list.add(resource);
										}
									}
								} else{
									list.add(resource);
								}
							}
							return folder.getLocation().toOSString().equals(resource.getLocation().toOSString());
						}

					});
				} catch (CoreException e) {
					log.error(e);
				}
				String[] deletedResources = RegistryCheckInClientUtils.getDeletedResourcesInPath(
																 folder.getLocation().toOSString());
				for (String deleted : deletedResources) {
					list.add(folder.getFile(deleted));
				}
				lists.put(folder, list);
			}
		});
		setLabelProvider(WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider());

	}

}
