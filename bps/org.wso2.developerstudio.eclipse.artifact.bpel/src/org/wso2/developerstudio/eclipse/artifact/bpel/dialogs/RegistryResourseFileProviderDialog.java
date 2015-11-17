/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.bpel.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.general.project.dialogs.DeveloperStudioElementProviderDialog;
import org.wso2.developerstudio.eclipse.registry.core.RegistryManager;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;

/**
 * Provides a dialog box to select resource files from the workspace for BPEL artifacts
 */
public class RegistryResourseFileProviderDialog extends DeveloperStudioElementProviderDialog {

	public RegistryResourseFileProviderDialog(Shell parentShell, Class<?>[] type, Map<String, List<String>> filters) {
		super(parentShell, type, filters);
	}

	/**
	 * Provides registry file list in the workspace
	 * 
	 * @return List<Object>
	 */
	@Override
	protected List<Object> addResourseFilesToList(List<Class<?>> typesList) {
		List<Object> list = new ArrayList<Object>();
		if (typesList.contains(IRegistryFile.class)) {
			list.addAll(Arrays.asList(RegistryManager.getResourceProviders(true)));
		}
		return list;
	}

}
