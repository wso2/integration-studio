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

package org.wso2.developerstudio.eclipse.artifact.analytics.stream.model;

import java.io.File;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.analytics.stream.Activator;
import org.wso2.developerstudio.eclipse.artifact.analytics.stream.utils.StreamConstants;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsConstants;
import org.wso2.developerstudio.eclipse.artifact.analytics.utils.AnalyticsProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class StreamModel extends ProjectDataModel {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private IContainer streamSaveLocation;
	
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equals(StreamConstants.WIZARD_OPTION_STREAM_SAVE_LOCATION)) {
				IContainer container= getStreamSaveLocation();
				if(container != null && container instanceof IFolder){
					IFolder streamFolder = container.getProject().getFolder("src").getFolder("main").getFolder(AnalyticsConstants.ANALYTICS_STREAM_DIR);
					modelPropertyValue = streamFolder;
				}else{
					modelPropertyValue = container;
				}	
			}
		}
		return modelPropertyValue;
	}

	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnResult = super.setModelPropertyValue(key, data);
		
		if(key.equals(StreamConstants.WIZARD_OPTION_NEW_STREAM_PROJECT)){
			setProjectName(data.toString());
		}
		else if (key.equals(StreamConstants.WIZARD_OPTION_IMPORT_STREAM_PROJECT)) {
			setImportFile((File) data);	
		} else if (key.equals(StreamConstants.WIZARD_OPTION_STREAM_SAVE_LOCATION)) {
			IContainer container=(IContainer) data;
			if(container != null && container instanceof IFolder){
				IFolder streamFolder = container.getProject().getFolder("src").getFolder("main").getFolder(AnalyticsConstants.ANALYTICS_STREAM_DIR);
				setStreamSaveLocation(streamFolder);
			}else{
				setStreamSaveLocation(container);
			}
		} else if (key.equals(StreamConstants.WIZARD_OPTION_CREATE_ANALYTICS_PROJECT)) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			IProject analyticsProject = AnalyticsProjectUtils.createAnalyticsProject(shell,getLocation());
			if(analyticsProject!=null){
				setStreamSaveLocation(analyticsProject);
			}	
		}
		return returnResult;
	}
	
	public void setLocation(File location) {
		super.setLocation(location);
		File absolutionPath = getLocation();
		if (getStreamSaveLocation() == null && absolutionPath != null) {
			IContainer newStreamSaveLocation =
			        getContainer(absolutionPath,AnalyticsConstants.ANALYTICS_PROJECT_NATURE);
			setStreamSaveLocation(newStreamSaveLocation);
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
		IContainer newStreamSaveLocation = null;
		if (currentSelection != null) {
			String path =
			        absolutionPath.toString().substring(
			                                            currentSelection.getLocation().toFile()
			                                                    .toString().length());

			if (path.equals("")) {
				newStreamSaveLocation = currentSelection;
			} else {
				newStreamSaveLocation = currentSelection.getFolder(path);
			}
		}
		return newStreamSaveLocation;
	}

	public void setStreamSaveLocation(IContainer execution_planSaveLocation) {
		this.streamSaveLocation = execution_planSaveLocation;
	}

	public IContainer getStreamSaveLocation() {
		return streamSaveLocation;
	}
	
}
