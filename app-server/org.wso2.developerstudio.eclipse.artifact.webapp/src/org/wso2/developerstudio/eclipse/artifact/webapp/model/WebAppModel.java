/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.webapp.model;

import java.io.File;

import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class WebAppModel extends ProjectDataModel {

	private String webContextRoot;
    private boolean isNewWebApp=true;
    private String warName;
    private File saveLocation;
	
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equalsIgnoreCase("web.context.root")) {
				modelPropertyValue = getWebContextRoot();
			}
		}
		return modelPropertyValue;
	}

	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnValue = super.setModelPropertyValue(key, data);
		if (key.equals("import.file")) {
			if (getImportFile() != null && !getImportFile().toString().equals("")) {
				setProjectName(ProjectUtils.fileNameWithoutExtension(getImportFile().getName()));
			}
		} else if (key.equals("web.context.root")) {
			setWebContextRoot(data.toString());
		}
		return returnValue;
	}

	public void setWebContextRoot(String webContextRoot) {
		this.webContextRoot = webContextRoot;
	}

	public String getWebContextRoot() {
		return webContextRoot;
	}

	
	public void setProjectName(String projectName) throws ObserverFailedException {
		if (getProjectName() != null && getProjectName().equals(getWebContextRoot())) {
			setWebContextRoot(projectName);
		}
		super.setProjectName(projectName);
	}


	public void setNewWebApp(boolean isNewWebApp) {
		this.isNewWebApp = isNewWebApp;
	}


	public boolean isNewWebApp() {
		return isNewWebApp;
	}


	public void setWarName(String warName) {
		this.warName = warName;
	}


	public String getWarName() {
		return warName;
	}


	public void setSaveLocation(File saveLocation) {
		this.saveLocation = saveLocation;
	}


	public File getSaveLocation() {
		return saveLocation;
	}

}
