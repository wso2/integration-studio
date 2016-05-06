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

package org.wso2.developerstudio.eclipse.maven.multi.module.handlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.multi.module.Activator;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.project.extensions.handlers.ProjectNatureListProvider;


public class MvnMultiModuleProjectList extends AbstractListDataProvider {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public List<ListData> getListData(String modelProperty, ProjectDataModel model) {
		List<ListData> list = new ArrayList<ListData>();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();
		MvnMultiModuleModel moduleModel = null;
		if (model instanceof MvnMultiModuleModel) {
			moduleModel = (MvnMultiModuleModel) model;
			moduleModel.getArtifactId();
		}
		for (IProject project : projects) {
			ProjectNatureListProvider projectNatureListProvider = new ProjectNatureListProvider();
			if (project != null && project.exists() && project.isOpen() &&
			    !moduleModel.getArtifactId().equals(project.getName())) {
				try {
					if (project.hasNature(Constants.JAVA_PROJECT_NATURE)
							|| projectNatureListProvider.isWSO2ProjectType(project)) {

						ListData data = new ListData(project.getName(), project);
						list.add(data);
					}

				} catch (CoreException e) {
					log.error("Error reading project nature list", e);
				}
			}
		}
		return list;
	}

}
