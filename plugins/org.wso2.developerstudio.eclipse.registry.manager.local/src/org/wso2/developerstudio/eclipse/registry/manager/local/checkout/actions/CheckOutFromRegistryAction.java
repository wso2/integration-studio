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

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;
import org.wso2.developerstudio.eclipse.registry.manager.local.dialog.RegistryCheckoutDialog;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.Utils;

public class CheckOutFromRegistryAction extends BaseRegistryAction {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	protected void executeFile(IFile file, IAction action) {

	}

	/**
	 * execute folder 
	 */
	protected void executeFolder(IFolder folder, IAction action) {
		final RegistryCheckoutDialog dialog = new RegistryCheckoutDialog(
															"Check-out from WSO2 Registry Wizard", 
															Display.getCurrent().getActiveShell(),
															folder);
		dialog.create();
		dialog.getShell().setSize(500, 500);
		if (dialog.open() == Window.OK) {
			ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(
															 Display.getCurrent().getActiveShell());
			try {
				progressMonitorDialog.run(false, 
										  false,
										  new IRunnableWithProgress() {
											public void run(IProgressMonitor monitor)
																	throws InvocationTargetException,
																	InterruptedException {
												IPath selectedCheckoutPath = dialog
																		 .getSelectedCheckoutPath();
												RegistryResourceNode selectedPath = dialog
																				.getSelectedPath();
												try {
													monitor.beginTask("Checkin out from "+ 
																	(new URL(selectedPath.getConnectionInfo().getUrl(),
																			selectedPath.getRegistryResourcePath())).toString(),
																			IProgressMonitor.UNKNOWN);
													try {
														Utils.checkoutFromRegistry(selectedCheckoutPath,
																				   selectedPath);
													} catch (Exception e) {
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
												} catch (MalformedURLException e) {
													log.error(e);
												}
												monitor.done();
				
											}
						});
			} catch (InvocationTargetException e) {
				log.error(e);
			} catch (InterruptedException e) {
				log.error(e);
			}

		}
	}

	protected void executeResource(IResource resource, IAction action) {

	}

	/**
	 * disable the action for the given file
	 */
	protected void selectedFile(IFile file, IAction action) {
		action.setEnabled(false);
	}

	/**
	 * disable the action for the given folder
	 */
	protected void selectedFolder(IFolder folder, IAction action) {
		int resourceState = RegistryCheckInClientUtils.getResourceState(folder.getLocation().toOSString());
		if (resourceState != RegistryCheckInClientUtils.RESOURCE_STATE_NOT_RESOURCE){
			action.setEnabled(false);
		}
	}

	protected void selectedResource(IResource resource, IAction action) {

	}

}
