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
package org.wso2.developerstudio.eclipse.wso2plugin.template.manager.project;

import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class WSO2PluginProjectModel extends ProjectDataModel {
	private String pluginProjectName;

	public String getPluginProjectName() {
		return pluginProjectName;
	}

	public void setPluginProjectName(String pluginProjectName) {
		this.pluginProjectName = pluginProjectName;
	}

	private IProject pluginProject;

	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if ((modelPropertyValue == null) && ("plugin.project.name".equals(key))) {
			modelPropertyValue = this.getPluginProjectName();
		}

		return modelPropertyValue;
	}

	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean isUiControlUpdated = super.setModelPropertyValue(key, data);

		if ("plugin.project.name".equals(key)) {
			this.setPluginProjectName(data.toString());
		}

		return isUiControlUpdated;
	}

	public void setPluginProject(IProject mediatorProject) {
		this.pluginProject = mediatorProject;
		try {
			if (mediatorProject != null)
				this.setProjectName(mediatorProject.getName());
		} catch (ObserverFailedException e) {
			// ignore.
		}
	}

	public IProject getPluginProject() {
		return pluginProject;
	}
}
