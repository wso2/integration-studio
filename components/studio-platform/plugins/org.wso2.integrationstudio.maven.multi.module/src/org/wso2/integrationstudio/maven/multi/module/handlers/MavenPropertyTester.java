/*
 * Copyright (c) 2010-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.integrationstudio.maven.multi.module.handlers;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.maven.multi.module.Activator;
import org.wso2.integrationstudio.platform.core.utils.Constants;


import java.util.List;

public class MavenPropertyTester extends PropertyTester {
	private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	private static IProject selectedProject;

	public boolean test(Object arg0, String arg1, Object[] arg2, Object arg3) {

		if (arg0 instanceof IProject) {
			IProject project = (IProject) arg0;
			if (project != null && project.exists() && project.isOpen()) {

				try {
					if (project.hasNature(Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE)) {
					    this.selectedProject = project;
						return true;
					}
				} catch (CoreException e) {
					log.error("Error while getting the nature in MavenPropertyTester", e);
				}
			}
		}

		return false;
	}
	
	public static IProject getSelectedProjectToCreateMMM() {
        return selectedProject;
    }

}
