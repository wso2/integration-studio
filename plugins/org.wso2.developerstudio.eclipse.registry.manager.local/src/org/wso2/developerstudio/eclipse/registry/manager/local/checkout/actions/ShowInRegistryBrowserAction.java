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

package org.wso2.developerstudio.eclipse.registry.manager.local.checkout.actions;

import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.registry.manager.remote.views.RegistryBrowserView;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceUtils;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.bean.RemoteRegistryInfo;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;

public class ShowInRegistryBrowserAction extends BaseRegistryAction {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	protected void executeFile(IFile file, IAction action) {
	}

	protected void executeFolder(IFolder folder, IAction action) {
	}

	/**
	 * execute show in registry browser action
	 */
	protected void executeResource(IResource resource, IAction action) {
		try {
			IViewReference[] viewReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
			boolean found=false;
//			for (IViewReference view : viewReferences) {
//                if (view.getId().equals("org.wso2.developerstudio.registry.remote.registry.view")){
//                	PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(view.getView(true).getViewSite().getPart());
//                	found=true;
//                	break;
//                }
//            }
			try {
				if (!found){
    				PlatformUI.getWorkbench().getActiveWorkbenchWindow()
    							.getActivePage().showView("org.wso2.developerstudio.registry.remote.registry.view");
				}
			} catch (PartInitException e1) {
				e1.printStackTrace();
			}
			RemoteRegistryInfo info = RegistryCheckInClientUtils.getResourceRemoteRegistryUrlInfo(
																resource.getLocation().toOSString());
			String registryUrl = info.getUrl().toString();
			String shlashRegistry = "/registry";
			if (registryUrl.endsWith(shlashRegistry)) {
				registryUrl = registryUrl.substring(0, registryUrl.length() - shlashRegistry.length());
			}
			info.setUrl(new URL(registryUrl));
			
			RegistryBrowserView view = RegistryBrowserView.lastInstance;
			if (view != null) {
				view.traverseRegistryBrowser(info.getUrl().toString(),info.getPath());
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * disable action for the file
	 */
	protected void selectedFile(IFile file, IAction action) {
		int resourceState = RegistryCheckInClientUtils.getResourceState(file.getLocation().toOSString());
		int registryState = RegistryResourceUtils.getRegistryState(file.getLocation().toOSString());
		if (resourceState == RegistryCheckInClientUtils.RESOURCE_STATE_NOT_RESOURCE
			|| resourceState == RegistryCheckInClientUtils.RESOURCE_STATE_NEW
			|| registryState == RegistryResourceUtils.RegistryState.ADDED ){
			action.setEnabled(false);
		}

	}

	/**
	 * disable action for the folder
	 */
	protected void selectedFolder(IFolder folder, IAction action) {
		int resourceState = RegistryCheckInClientUtils.getResourceState(folder.getLocation().toOSString());
		int registryState = RegistryResourceUtils.getRegistryState(folder.getLocation().toOSString());
		if (resourceState == RegistryCheckInClientUtils.RESOURCE_STATE_NOT_RESOURCE 
			|| resourceState == RegistryCheckInClientUtils.RESOURCE_STATE_NEW
			|| registryState == RegistryResourceUtils.RegistryState.ADDED ){
			action.setEnabled(false);
		}
	}

	protected void selectedResource(IResource resource, IAction action) {

	}

}
