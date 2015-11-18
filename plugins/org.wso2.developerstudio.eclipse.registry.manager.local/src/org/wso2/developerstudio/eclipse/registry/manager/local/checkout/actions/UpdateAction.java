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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.registry.base.core.Registry;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData;
import org.wso2.developerstudio.eclipse.registry.base.persistent.RegistryCredentialData.Credentials;
import org.wso2.developerstudio.eclipse.registry.base.ui.util.SWTControlUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceUtils;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.bean.RemoteRegistryInfo;
import org.wso2.developerstudio.eclipse.registry.manager.local.decorators.RegistryResourceDecorator;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;

public class UpdateAction extends BaseRegistryAction {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	ISelection selection;

	/**
	 * execute sync with registry action 
	 * @param action
	 * @param resource
	 * @param requestUser
	 */
	public void execute(IAction action, IResource resource, boolean requestUser) {
		if ((resource instanceof IFolder)) {
			IFolder folder = (IFolder) resource;
			String path = folder.getLocation().toOSString();
			if (RegistryCheckInClientUtils.isRegistryResource(path)) {
				try {
					RemoteRegistryInfo resourceRemoteRegistryUrlInfo = RegistryCheckInClientUtils
															.getResourceRemoteRegistryUrlInfo(path);
					Credentials credentials = RegistryCredentialData.getInstance().getCredentials(
												 resourceRemoteRegistryUrlInfo.getUrl().toString());
					if (credentials == null) {
						credentials = SWTControlUtils.requestCredentials(
												  Display.getCurrent().getActiveShell(),
												  resourceRemoteRegistryUrlInfo.getUrl().toString(), 
												  "");
						if (credentials == null){
							return;
						}
					}
					Registry.registryInit();
					RegistryCheckInClientUtils.update(path, 
											   credentials.getUsername(),
											   credentials.getPassword());
					
					RegistryResourceDecorator.refreshProjectResource(folder.getProject());
					folder.refreshLocal(IResource.DEPTH_INFINITE,
										new NullProgressMonitor());
					RegistryResourceUtils.updateMetaData(path, RegistryResourceUtils.RegistryState.UPDATED);
					MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
												  "Success",
												  "Successfully synched with registry");
				} catch (Exception e) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), 
											"Error", 
											"Error in updating with registry");
					log.error(e);
					return;
				}

			}
		}		

	}

	/**
	 * disable action for given resource
	 */
	protected void selectedResource(IResource resource, IAction action) {
		if (!RegistryCheckInClientUtils.isRegistryResource(resource.getLocation().toOSString())){
			action.setEnabled(false);		
		}
	}

	/**
	 * execute File
	 */
	protected void executeFile(IFile file, IAction action) {
	}

	/**
	 * execute Folder
	 */
	protected void executeFolder(IFolder folder, IAction action) {
		execute(action,folder,false);
	}

	/**
	 *  selected File
	 */
	protected void selectedFile(IFile file, IAction action) {
	}

	protected void selectedFolder(IFolder folder, IAction action) {
	}

	protected void executeResource(IResource resource, IAction action) {
	}

}
