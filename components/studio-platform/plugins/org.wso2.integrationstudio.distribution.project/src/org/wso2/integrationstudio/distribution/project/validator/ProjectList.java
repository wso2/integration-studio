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

package org.wso2.integrationstudio.distribution.project.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.wso2.integrationstudio.distribution.project.Activator;
import org.wso2.integrationstudio.distribution.project.export.CappArtifactsListProvider;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.core.model.AbstractListDataProvider;
import org.wso2.integrationstudio.platform.core.project.model.ProjectDataModel;

public class ProjectList extends AbstractListDataProvider {

	private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public List<ListData> getListData(String modelProperty, ProjectDataModel model, String extensionpointId) {
		if (extensionpointId == null || "".equals(extensionpointId)) {
			// setting to default
			extensionpointId = "org.wso2.integrationstudio.capp.artifacts.provider";
		}
		List<ListData> list = new ArrayList<ListData>();

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionpointId);

		for (IConfigurationElement element : config) {
			Object obj = null;
			try {
				obj = element.createExecutableExtension("class");
			} catch (CoreException ex) {
				log.error("Error executing CappArtifactsListProvider extension ", ex);
			}

			if (obj instanceof CappArtifactsListProvider) {
				CappArtifactsListProvider provider = (CappArtifactsListProvider) obj;
				String nature = element.getAttribute("nature");
				for (IProject project : projects) {
					try {
						if (project.isOpen() && project.hasNature(nature)) {
							List<ListData> listReceivedFromprovider = null;
							listReceivedFromprovider = provider.getArtifactsListForCappExport(project);
							list.addAll(listReceivedFromprovider);
						}
					} catch (Exception e) {
						log.error("Error getting artifacts from extension", e);
					}
				}
			}

		}

		return list;
	}

	@Override
	public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
		// TODO Auto-generated method stub
		return this.getListData(modelProperty, model, null);
	}

}
