package org.wso2.developerstudio.eclipse.artifact.analytics.execution.plan.model;

/*
*  Copyright (c) 2005-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.analytics.execution.plan.Activator;
import org.wso2.developerstudio.eclipse.artifact.analytics.execution.plan.utils.ExecutionPlanConstants;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsConstants;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class ExecutionPlanModel extends ProjectDataModel {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private IContainer execution_planSaveLocation;
	
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equals(ExecutionPlanConstants.WIZARD_OPTION_EXECUTIONPLAN_SAVE_LOCATION)) {
				IContainer container= getExecution_planSaveLocation();
				if(container != null && container instanceof IFolder){
					IFolder execution_planFolder = container.getProject().getFolder("src").getFolder("main").getFolder(AnalyticsConstants.ANALYTICS_EXECUTION_PLAN_DIR);
					modelPropertyValue = execution_planFolder;
				}else{
					modelPropertyValue = container;
				}	
			}
		}
		return modelPropertyValue;
	}

	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnResult = super.setModelPropertyValue(key, data);
		
		if(key.equals(ExecutionPlanConstants.WIZARD_OPTION_NEW_EXECUTIONPLAN_PROJECT)){
			setProjectName(data.toString());
		}
		else if (key.equals(ExecutionPlanConstants.WIZARD_OPTION_IMPORT_EXECUTIONPLAN_PROJECT)) {
			setImportFile((File) data);	
		} else if (key.equals(ExecutionPlanConstants.WIZARD_OPTION_EXECUTIONPLAN_SAVE_LOCATION)) {
			IContainer container=(IContainer) data;
			if(container != null && container instanceof IFolder){
				IFolder execution_planFolder = container.getProject().getFolder("src").getFolder("main").getFolder(AnalyticsConstants.ANALYTICS_EXECUTION_PLAN_DIR);
				setExecution_planSaveLocation(execution_planFolder);
			}else{
				setExecution_planSaveLocation(container);
			}
		} else if (key.equals(ExecutionPlanConstants.WIZARD_OPTION_CREATE_ANALYTICS_PROJECT)) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			IProject analyticsProject = AnalyticsProjectUtils.createAnalyticsProject(shell,getLocation());
			if(analyticsProject!=null){
				setExecution_planSaveLocation(analyticsProject);
			}	
		}
		return returnResult;
	}
	
	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getExecution_planSaveLocation() == null && absolutionPath != null) {
			IContainer newExecution_planSaveLocation =
			        getContainer(absolutionPath,AnalyticsConstants.ANALYTICS_PROJECT_NATURE);
			setExecution_planSaveLocation(newExecution_planSaveLocation);
		}
	}

	public static IContainer getContainer(File absolutionPath, String projectNature) {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		int length = 0;
		IProject currentSelection = null;
		for (IProject project : projects) {
			try {
				if (project.isOpen() && project.hasNature(projectNature)) {
					File projectLocation = project.getLocation().toFile();
					int projectLocationLength = projectLocation.toString().length();
					if (projectLocationLength > length &&
					    projectLocationLength <= absolutionPath.toString().length()) {
						if (absolutionPath.toString().startsWith(projectLocation.toString())) {
							length = projectLocationLength;
							currentSelection = project;
						}
					}
				}
			} catch (CoreException e) {
				log.error("An unexpected error has occurred", e);
			}
		}
		IContainer newExecution_planSaveLocation = null;
		if (currentSelection != null) {
			String path =
			        absolutionPath.toString().substring(
			                                            currentSelection.getLocation().toFile()
			                                                    .toString().length());

			if (path.equals("")) {
				newExecution_planSaveLocation = currentSelection;
			} else {
				newExecution_planSaveLocation = currentSelection.getFolder(path);
			}
		}
		return newExecution_planSaveLocation;
	}

	public void setExecution_planSaveLocation(IContainer execution_planSaveLocation) {
		this.execution_planSaveLocation = execution_planSaveLocation;
	}

	public IContainer getExecution_planSaveLocation() {
		return execution_planSaveLocation;
	}
	
}