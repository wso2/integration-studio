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
import org.eclipse.jface.window.Window;
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
import org.wso2.developerstudio.eclipse.registry.manager.local.dialog.ResourceCheckoutStateDialog;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;


public class CommitAction extends BaseRegistryAction {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	ISelection selection;
	private boolean requestUser = false;

	/**
	 * set Request User
	 * @param requestUser
	 */
	public void setRequestUser(boolean requestUser) {
		this.requestUser = requestUser;
	}

	/**
	 * is Request User
	 * @return
	 */
	public boolean isRequestUser() {
		return requestUser;
	}

	/**
	 * 
	 */
	protected void selectedResource(IResource resource, IAction action) {
	}

	/**
	 * 
	 */
	protected void executeFile(IFile file, IAction action) {
		
		ResourceCheckoutStateDialog r = new ResourceCheckoutStateDialog(Display.getCurrent().getActiveShell(), 
											file);
		if (r.open() == Window.OK) {
			String path = file.getLocation().toOSString();
			try {
				RemoteRegistryInfo ri = RegistryCheckInClientUtils.getResourceRemoteRegistryUrlInfo(path);
				Credentials credentials = null;
				String username = "";
				if (isRequestUser()) {
					username = RegistryCredentialData.getInstance().getUsername(ri.getUrl().toString());
					if (username == null){
						username = "";
					}
				} else
					credentials = RegistryCredentialData.getInstance().getCredentials(
											ri.getUrl().toString());
					if (credentials == null) {
						credentials = SWTControlUtils.requestCredentials(
										Display.getCurrent().getActiveShell(), 
										ri.getUrl().toString(), 
										username);
						if (credentials == null){
							return;
						}
					}
					Registry.registryInit();
					RegistryCheckInClientUtils.commit(path, credentials.getUsername(), credentials.getUsername());
					RegistryResourceDecorator.refreshProjectResource(file.getProject());
					file.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
					RegistryResourceUtils.updateMetaData(path, RegistryResourceUtils.RegistryState.COMMITED);
					MessageDialog.openInformation(Display.getCurrent().getActiveShell(), 
												 "Success",
												 "Successfully commited changes");
				} catch (Exception e) {
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", e.getMessage());
				}
			}
	}

	/**
	 * execute Folder
	 */
	protected void executeFolder(IFolder folder, IAction action) {
		execute(action, folder, false);
	}

	/**
	 * 
	 */
	protected void executeResource(IResource resource, IAction action) {

	}

	/**
	 * diasble action for selected File
	 */
	protected void selectedFile(IFile file, IAction action) {
		String path = file.getLocation().toOSString();
		if(!RegistryCheckInClientUtils.isRegistryResource(file.getLocation().toOSString()) || (RegistryCheckInClientUtils.isRegistryResource(file.getLocation().toOSString()) && 
				RegistryCheckInClientUtils.getResourceState(file.getLocation().toOSString()) == RegistryCheckInClientUtils.RESOURCE_STATE_NORMAL)){
			action.setEnabled(false);
		}else{
			try {
				if (isRequestUser()) {
					action.setText("Commit changes as user...");
				} else {
					RemoteRegistryInfo r = RegistryCheckInClientUtils
														.getResourceRemoteRegistryUrlInfo(path);
					String username = RegistryCredentialData.getInstance()
															.getUsername(r.getUrl().toString());
					if (username != null && !username.equals("")){
						action.setText("Commit changes [user:" + username+ "]");
					}else {
						action.setText("Commit changes");
						action.setEnabled(false);
					}
				}
			} catch (Exception e) {
//				MessageDialog.openError(Display.getCurrent().getActiveShell(), 
//										"Failure", 
//										"Commit Failed due to un-availability of the registry instance..");
				log.error(e);
			}
		}
		
		
//		if(!RegistryCheckInClientUtils.isRegistryResource(file.getLocation().toOSString())){
//			action.setEnabled(false);
//		}
	}

	/**
	 * diasble action for selected folder
	 */
	protected void selectedFolder(IFolder folder, IAction action) {
		String path = folder.getLocation().toOSString();
		if (RegistryCheckInClientUtils.isRegistryResource(path)) {
			int resourceState = RegistryCheckInClientUtils.getResourceState(path);
			if (resourceState == RegistryCheckInClientUtils.RESOURCE_STATE_NORMAL
					|| resourceState == RegistryCheckInClientUtils.RESOURCE_STATE_CONFLICT){
				action.setEnabled(false);
			}
			else {
				try {
					if (isRequestUser()) {
						action.setText("Commit changes as user...");
					} else {
						RemoteRegistryInfo r = RegistryCheckInClientUtils
															.getResourceRemoteRegistryUrlInfo(path);
						String username = RegistryCredentialData.getInstance()
																.getUsername(r.getUrl().toString());
						if (username != null && !username.equals("")){
							action.setText("Commit changes [user:" + username+ "]");
						}else {
							action.setText("Commit changes");
							action.setEnabled(false);
						}
					}
				} catch (Exception e) {
//					MessageDialog.openError(Display.getCurrent().getActiveShell(), 
//											"Failure", 
//											"Commit Failed due to un-availability of the registry instance..");
					log.error(e);
				}
			}

		} else
			action.setEnabled(false);

	}

	/**
	 * execute check out
	 * @param action
	 * @param folder
	 * @param requestUser
	 */
	protected void execute(IAction action, IFolder folder, boolean requestUser) {
		ResourceCheckoutStateDialog r = new ResourceCheckoutStateDialog(
															  Display.getCurrent().getActiveShell(), 
															  folder);
		if (r.open() == Window.OK) {
			String path = folder.getLocation().toOSString();
			try {
				RemoteRegistryInfo ri = RegistryCheckInClientUtils.getResourceRemoteRegistryUrlInfo(path);
				Credentials credentials = null;
				String username = "";
				if (isRequestUser()) {
					username = RegistryCredentialData.getInstance().getUsername(ri.getUrl().toString());
					if (username == null){
						username = "";
					}
				} else
					credentials = RegistryCredentialData.getInstance().getCredentials(
																			ri.getUrl().toString());
				if (credentials == null) {
					credentials = SWTControlUtils.requestCredentials(
															  Display.getCurrent().getActiveShell(), 
															  ri.getUrl().toString(), 
															  username);
					if (credentials == null){
						return;
					}
				}
				Registry.registryInit();
				RegistryCheckInClientUtils.commit(path, 
										   credentials.getUsername(),
										   credentials.getUsername());
				RegistryResourceDecorator.refreshProjectResource(folder.getProject());
				folder.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
				RegistryResourceUtils.updateMetaData(path, RegistryResourceUtils.RegistryState.COMMITED);
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(), 
											  "Success",
											  "Successfully commited changes");
			} catch (Exception e) {
				MessageDialog.openError(Display.getCurrent().getActiveShell(),
										"Error", 
										e.getMessage());
			}
		}
	}

}
