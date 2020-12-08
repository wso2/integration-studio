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

package org.wso2.developerstudio.eclipse.registry.manager.local.decorators;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.ImageUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.bean.RemoteRegistryInfo;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;

public class RegistryResourceDecorator extends LabelProvider implements ILightweightLabelDecorator {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private static List<String> distinctFiles = Collections.unmodifiableList(Arrays.asList("pom.xml", ".classpath", "artifact.xml", ".project"));

	/**
	 * decorate checked out files and folders with images according to the state
	 * whether the file or folder is in-sync with remote registry etc
	 */
	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof IFolder || element instanceof IFile) {
			IResource resource = (IResource) element;
			if(distinctFiles.contains(resource.getName())){
				if(resource.getParent() instanceof IProject)
					return;
			}
			ImageDescriptor imageDescriptor = getImageDescriptor(resource);
			if (imageDescriptor != null) {
				decoration.addOverlay(imageDescriptor);
			}
			if (resource.getLocation() != null) {
				if (RegistryCheckInClientUtils.isRegistryResource(resource.getLocation()
				                                                          .toOSString())) {
					try {
						RemoteRegistryInfo r =
						                       RegistryCheckInClientUtils.getResourceRemoteRegistryUrlInfo(resource.getLocation()
						                                                                                           .toOSString());
						Date date = new Date(r.getResourceLastUpdateTime());
						SimpleDateFormat simpleDateFormat =
						                                    new SimpleDateFormat(
						                                                         "M/d/yyyy, h:mm a ");
						String suffix =
						                " [" + simpleDateFormat.format(date) + " " +
						                    r.getResourceLastUpdateUser() + "] ";
						decoration.addSuffix(suffix);
					} catch (Exception e) {
						decoration.addSuffix(" Error");
					}
				}
			}
		}
	}

	/**
	 * get ImageDescriptor for resource
	 * @param resource
	 * @return
	 */
	private ImageDescriptor getImageDescriptor(IResource resource) {
		ImageDescriptor overlay = null;
		if (resource == null){
			return ImageUtils.getImageDescriptor(ImageUtils.STATE_NORMAL);
		}
		
		IPath location = resource.getLocation();
		int resourceState = RegistryCheckInClientUtils.RESOURCE_STATE_NOT_RESOURCE;

		if (location != null) {
			resourceState = RegistryCheckInClientUtils.getResourceState(location.toOSString());
		}
		switch (resourceState) {
			case RegistryCheckInClientUtils.RESOURCE_STATE_NORMAL:
				overlay = ImageUtils.getImageDescriptor(ImageUtils.STATE_NORMAL);
				break;
			case RegistryCheckInClientUtils.RESOURCE_STATE_MODIFIED:
				overlay = ImageUtils.getImageDescriptor(ImageUtils.STATE_MODIFIED);
				break;
			case RegistryCheckInClientUtils.RESOURCE_STATE_NEW:
				overlay = ImageUtils.getImageDescriptor(ImageUtils.STATE_NEW);
				break;
			case RegistryCheckInClientUtils.RESOURCE_STATE_CONFLICT:
				overlay = ImageUtils.getImageDescriptor(ImageUtils.STATE_CONFLICT);
				break;
			case RegistryCheckInClientUtils.RESOURCE_STATE_DELETED:
				overlay = ImageUtils.getImageDescriptor(ImageUtils.STATE_DELETED);
				break;
			case RegistryCheckInClientUtils.RESOURCE_STATE_ADDED:
				overlay = ImageUtils.getImageDescriptor(ImageUtils.STATE_ADDED);
				break;
		}
		return overlay;

	}

	/**
	 * refresh project
	 * @param projects
	 */
	public void refresh(final Object[] projects) {
		final LabelProviderChangedEvent labelProviderChangedEvent = new LabelProviderChangedEvent(
																					this, projects);
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				fireLabelProviderChanged(labelProviderChangedEvent);
			}
		});
	}

	/**
	 *  refresh project
	 * @param projects
	 */
	public void refreshProject(IProject projects) {
		final ArrayList list = new ArrayList();
		try {
			projects.accept(new IResourceVisitor() {
				public boolean visit(IResource arg0) throws CoreException {
					if ((arg0 instanceof IFolder) || (arg0 instanceof IFile)){
						list.add(arg0);
					}
					return true;
				}

			});
		} catch (CoreException e) {
			log.error(e);
		}
		refresh(list.toArray());
	}

	/**
	 * get RegistryResourceFileDecorator instance
	 * @return
	 */
	private static RegistryResourceDecorator getRegistryResourceFileDecoratorInstance() {
		return getRegistryResourceDecoratorInstance("org.wso2.developerstudio.eclipse.greg.manager.local.decorators.RegistryResourceDecoratorFileLightWeight");
	}

	/**
	 * get RegistryResourceFolderDecorator instance
	 * @return
	 */
	private static RegistryResourceDecorator getRegistryResourceFolderDecoratorInstance() {
		return getRegistryResourceDecoratorInstance("org.wso2.developerstudio.eclipse.greg.manager.local.decorators.RegistryResourceDecoratorFolderLightWeight");
	}

	/**
	 * get RegistryResourceDecorator instance
	 * @param id
	 * @return
	 */
	private static RegistryResourceDecorator getRegistryResourceDecoratorInstance(String id) {
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		String decoratorId = id;
		IBaseLabelProvider baseLabelProvider = decoratorManager.getBaseLabelProvider(decoratorId);
		if (baseLabelProvider == null) {
			decoratorManager = Activator.getDefault().getWorkbench().getDecoratorManager();
			baseLabelProvider = decoratorManager.getBaseLabelProvider(decoratorId);
			if (baseLabelProvider == null){
				baseLabelProvider = decoratorManager.getLabelDecorator(decoratorId);
			}
		}
		return (RegistryResourceDecorator) baseLabelProvider;
	}

	/**
	 * refresh resource
	 * @param objects
	 */
	public static void refreshResources(Object[] objects) {
		RegistryResourceDecorator registryResourceFileDecorator = RegistryResourceDecorator
														.getRegistryResourceFileDecoratorInstance();
		if (registryResourceFileDecorator != null){
			registryResourceFileDecorator.refresh(objects);
		}
		registryResourceFileDecorator = RegistryResourceDecorator
													  .getRegistryResourceFolderDecoratorInstance();
		if (registryResourceFileDecorator != null){
			registryResourceFileDecorator.refresh(objects);
		}

	}

	/**
	 * refresh Project Resource
	 * @param p
	 */
	public static void refreshProjectResource(IProject p) {
		RegistryResourceDecorator registryResourceFileDecorator = RegistryResourceDecorator
														.getRegistryResourceFileDecoratorInstance();
		if (registryResourceFileDecorator != null){
			registryResourceFileDecorator.refreshProject(p);
		}
		registryResourceFileDecorator = RegistryResourceDecorator
													  .getRegistryResourceFolderDecoratorInstance();
		if (registryResourceFileDecorator != null){
			registryResourceFileDecorator.refreshProject(p);
		}
	}
}
