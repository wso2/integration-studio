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

package org.wso2.developerstudio.eclipse.platform.ui.mvn.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractListDataProvider;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.platform.ui.Activator;



public class MvnMultiModuleProjectList   extends AbstractListDataProvider {
	
private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	public List<ListData> getListData(String modelProperty,ProjectDataModel model) {
		List<ListData> list = new ArrayList<ListData>();
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();
		for (IProject project : projects) {
				if(project.isOpen()){
					try {
						if(project.hasNature(Constants.AXIS2_PROJECT_NATURE) ||
						   project.hasNature(Constants.BPEL_PROJECT_NATURE) ||
						   project.hasNature(Constants.DS_PROJECT_NATURE) ||
						   project.hasNature(Constants.DS_VALIDATOR_PROJECT_NATURE) ||
						   project.hasNature(Constants.ESB_PROJECT_NATURE) ||
						   project.hasNature(Constants.JAXWS_PROJECT_NATURE) ||
						   project.hasNature(Constants.JAXRS_PROJECT_NATURE) ||
						   project.hasNature(Constants.CEP_PROJECT_NATURE) ||
						   project.hasNature(Constants.WEBAPP_PROJECT_NATURE) ||
						   project.hasNature(Constants.GADGET_PROJECT_NATURE) ||
						   project.hasNature(Constants.LIBRARY_PROJECT_NATURE) ||
						   project.hasNature(Constants.MEDIATOR_PROJECT_NATURE) ||
						   project.hasNature(Constants.REGISTRY_FILTER_PROJECT_NATURE) ||
						   project.hasNature(Constants.REGISTRY_HANDLER_PROJECT_NATURE) ||
						   project.hasNature(Constants.GENERAL_PROJECT_NATURE) ||
						   project.hasNature(Constants.CARBON_UI_PROJECT_NATURE) ||
						   project.hasNature(Constants.JAVA_PROJECT_NATURE) ||
						   project.hasNature(Constants.JAGGERY_NATURE) ||
						   project.hasNature(Constants.DISTRIBUTION_PROJECT_NATURE)||
						   project.hasNature(Constants.CONNECTOR_PROJECT_NATURE)||
						   project.hasNature(Constants.MAVEN_MULTI_MODULE_PROJECT_NATURE)){
							 
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
	