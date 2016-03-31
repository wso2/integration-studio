/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.developerstudio.eclipse.security.project.utils;

import java.io.File;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.wso2.carbon.registry.synchronization.SynchronizationException;
import org.wso2.developerstudio.eclipse.registry.manager.local.utils.RegistryCheckInClientUtils;
import org.wso2.developerstudio.eclipse.security.project.ui.dialog.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class RegistryUtils {

	private static RegistryUtils instance;

	private RegistryUtils() {

	}

	public static RegistryUtils getInstance() {
		if (instance == null) {
			instance = new RegistryUtils();
		}

		return instance;
	}

	public void checkoutFromRegistry(RegistryKeyProperty registryKeyProperty) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		
		IPath path = new Path(File.separator + ".tmp");
		String checkoutPath = "";
		String chkoutFolder = getLastSegmentInPath(registryKeyProperty.getRegistryData().getPath());
		path = path.append(chkoutFolder);
		path = root.getLocation().append(path);
		checkoutPath = getCheckoutPath(registryKeyProperty);

		try {
			if (RegistryCheckInClientUtils.isCheckoutPathValid(path.toOSString())) {
				(new File(path.toOSString())).mkdirs();
				try {
					RegistryCheckInClientUtils.checkout(registryKeyProperty.getRegistryData()
							.getUsername(), registryKeyProperty.getRegistryData().getPassword(),
							path.toOSString(), registryKeyProperty.getRegistryData().getURL()
									.toString(), checkoutPath);
					registryKeyProperty.setTempPolicyFilePath(path.toString());
				} catch (SynchronizationException e1) {
					e1.printStackTrace();
				}
			}
		} catch (Exception e1) {
			// TODO:Handle properly
			e1.printStackTrace();
		}

	}
	
	/**
	 * Delete temporary created folder.
	 * @param registryKeyProperty
	 */
	public void deleteTempFiles(RegistryKeyProperty registryKeyProperty) {
		if (StringUtils.isNotBlank(registryKeyProperty.getTempPolicyFilePath())) {
			File tempDir = new File(registryKeyProperty.getTempPolicyFilePath());
			FileUtils.deleteDir(tempDir);
		}	
	}

	private String getLastSegmentInPath(String path) {
		String[] split = path.split("/");
		if (split.length > 3) {
			return split[3];
		} else {
			return "";
		}
	}

	private String getCheckoutPath(RegistryKeyProperty registryKeyProperty) {
		String path = registryKeyProperty.getRegistryData().getPath();
		String[] split = path.split("/");
		String fileName = split[split.length - 1];
		String checkoutPath = path.substring(0, (path.length() - fileName.length()));

		registryKeyProperty.setPolicyFileName(fileName);
		return checkoutPath;
	}
	
}
