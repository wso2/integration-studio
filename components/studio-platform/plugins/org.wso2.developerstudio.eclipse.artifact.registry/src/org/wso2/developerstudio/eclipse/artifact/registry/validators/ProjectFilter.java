/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.registry.validators;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.wso2.developerstudio.eclipse.artifact.registry.Activator;
import org.wso2.developerstudio.eclipse.artifact.registry.utils.RegistryArtifactConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ProjectFilter extends ViewerFilter {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		if (element instanceof IContainer) {
			try {
				IContainer iContainer = (IContainer) element;
				IProject project = iContainer.getProject();
				String containerName = iContainer.getName();
				if (!containerName.equalsIgnoreCase("target") &&
						!containerName.equalsIgnoreCase(".meta") && 
						!containerName.equalsIgnoreCase(".settings") &&
						!containerName.equalsIgnoreCase("bin")) {
					if (project.isOpen() && project.hasNature(RegistryArtifactConstants.GENERAL_PROJECT_NATURE)) {
						return true;
					}
				}else{
					return false;
				}
			} catch (Exception e) {
				log.warn(e);
			}
		}
		return false;
	}

}
