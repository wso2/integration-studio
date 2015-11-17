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

package org.wso2.developerstudio.eclipse.registry.manager.local.utils;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.wso2.carbon.registry.synchronization.SynchronizationException;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.manager.local.Activator;

public class Utils {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * check out From Registry
	 * @param path
	 * @param r
	 * @throws Exception 
	 */
	public static void checkoutFromRegistry(IPath path,	RegistryResourceNode r) throws Exception {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		if (root.exists(path)) {
			String chkoutFolder;
			if (r.getResourceType()==RegistryResourceType.RESOURCE){
				chkoutFolder = r.getRegistryResourceNodeParent().getLastSegmentInPath();
			}else if(r.getResourceType()==RegistryResourceType.UNDEFINED){
				throw new Exception("No Resources Defined");
			}
			else{
				chkoutFolder = r.getLastSegmentInPath();
			}
			if (chkoutFolder.equals("/")){
				chkoutFolder = "ROOT";
			}
			path = path.append(chkoutFolder);
			IProject project = root.getProject(path.segment(0));
			path = root.getLocation().append(path);
			try {
				RegistryCheckInClientUtils.isCheckoutPathValid(path.toOSString());
			} catch (Exception e1) {
				MessageDialog.openError(Display.getDefault().getActiveShell(),
										"Error in checkout path", 
										e1.getMessage());
				return;
			}
			(new File(path.toOSString())).mkdirs();
			try {
				RegistryCheckInClientUtils.checkout(r.getConnectionInfo().getUsername(),
											 r.getConnectionInfo().getPassword(),
											 path.toOSString(), 
											 r.getConnectionInfo().getUrl().toString(), 
											 r.getRegistryResourcePath());
			} catch (SynchronizationException e1) {
				e1.printStackTrace();
			}

			try {
				project.refreshLocal(IResource.DEPTH_INFINITE,new NullProgressMonitor());
			} catch (CoreException e) {
				log.error(e);
			}
		}
	}
}
