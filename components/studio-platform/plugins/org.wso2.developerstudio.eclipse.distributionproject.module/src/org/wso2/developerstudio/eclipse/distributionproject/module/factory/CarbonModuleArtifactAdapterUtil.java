/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.developerstudio.eclipse.distributionproject.module.factory;

import org.eclipse.core.resources.IProject;
import org.eclipse.wst.server.core.IModule;
import org.eclipse.wst.server.core.IModuleArtifact;
import org.eclipse.wst.server.core.ServerUtil;
import org.wso2.developerstudio.eclipse.distributionproject.module.utils.Constants;

public class CarbonModuleArtifactAdapterUtil {

	public static IModuleArtifact getModuleObject(Object obj) {
		if (obj instanceof IProject) {
			IProject project = (IProject) obj;
			if (hasInterestedComponents(project))
				return new CarbonModuleArtifact(getModule(project));
			return null;	
		}
		return null; 

	}

	protected static IModule getModule(IProject project) {
		if (hasInterestedComponents(project))
			return ServerUtil.getModule(project);
		return null;
	}
	
	protected static boolean hasInterestedComponents(IProject project) {
		return isProjectOfType(project,Constants.CAPP_NATURE_ID);
	}
	
	protected static boolean isProjectOfType(IProject project, String typeID) {
		/*
		 * TODO: Use ProjectFacetsManager.isProjectFacetDefined() instead of
		 *   project.hasNature()
		 */
		try {
			if (project.hasNature(typeID)) {
				return true;
			}
		} catch (Exception e) {
			// ignore
		}
		return false;
	}
}
