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

package org.wso2.developerstudio.eclipse.artifact.carbon.ui.bundle.model;

import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class CarbonUiModel extends ProjectDataModel {
	private String id;
	private String version = "1.0.0.qualifier";
	private String name;
    private IProject carbonUIproject;
    private boolean isActivatorRequired=true;
    private String  activatorClassName=".Activator";
    private String deployPath ="web/customui/";
    
	
	public Object getModelPropertyValue(String key) {
	  Object modelPropertyValue = super.getModelPropertyValue(key);
	  if((modelPropertyValue == null)&&("uibundle.id".equals(key))){
		  modelPropertyValue = this.getId();
	  }
	  if((modelPropertyValue == null)&&("uibundle.version".equals(key))){
		  modelPropertyValue = this.getVersion();
	  }
	  if((modelPropertyValue == null)&&("uibundle.name".equals(key))){
		  modelPropertyValue = this.getName();
	  }
	  if((modelPropertyValue == null)&&("import.project.list".equals(key))){
		  modelPropertyValue = this.getCarbonUIproject();
	  }
	  if((modelPropertyValue == null)&&("create.class".equals(key))){
		  modelPropertyValue = this.isActivatorRequired();
	  }
	  if((modelPropertyValue == null)&&("activator.class".equals(key))){
		  modelPropertyValue = this.getActivatorClassName();
	  }
	  if((modelPropertyValue == null)&&("deploy.path".equals(key))){
		  modelPropertyValue = this.getDeployPath();
	  }
	  
	  return modelPropertyValue;
	}
	
	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean isUiControlUpdated = super.setModelPropertyValue(key, data);
		if ("uibundle.id".equals(key)) {
			this.setId(data.toString());
		}
		if("uibundle.version".equals(key)){
			this.setVersion(data.toString());
		}
		if("uibundle.name".equals(key)){
			this.setName(data.toString());
		}
		if("import.project.list".equals(key)){
			this.setCarbonUIproject((IProject)data);
		}
		if("create.class".equals(key)){
			this.setActivatorRequired((Boolean)data);
		}
		if("activator.class".equals(key)){
		   this.setActivatorClassName(data.toString());
		}
		if("deploy.path".equals(key)){
			this.setDeployPath(data.toString());
		}
		return isUiControlUpdated;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCarbonUIproject(IProject mediatorProject) {
		this.carbonUIproject = mediatorProject;
	}

	public IProject getCarbonUIproject() {
		return carbonUIproject;
	}

	public boolean isActivatorRequired() {
		return isActivatorRequired;
	}

	public void setActivatorRequired(boolean isActivatorRequired) {
		this.isActivatorRequired = isActivatorRequired;
	}

	public String getActivatorClassName() {
		return activatorClassName;
	}

	public void setActivatorClassName(String activatorClassName) {
			this.activatorClassName = activatorClassName;
	}

	public String getDeployPath() {
		return deployPath;
	}

	public void setDeployPath(String deployPath) {
		this.deployPath = deployPath;
	}
	
}
