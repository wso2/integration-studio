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

package org.wso2.developerstudio.eclipse.artifact.mediator.model;

import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class CustomMediatorModel extends ProjectDataModel {
	private String mediatorClass;
	private String mediatorClassPackage;
    private IProject mediatorProject;
    
	
	public Object getModelPropertyValue(String key) {
	  Object modelPropertyValue = super.getModelPropertyValue(key);
	  if((modelPropertyValue == null)&&("mediatorClass.name".equals(key))){
		  modelPropertyValue = this.getMediatorClassName();
	  }
	  if((modelPropertyValue == null)&&("mediatorClass.package.name".equals(key))){
		  modelPropertyValue = this.getMediatorClassPackageName();
	  }
	  if((modelPropertyValue == null)&&("import.project.list".equals(key))){
		  modelPropertyValue = this.getMediatorProject();
	  }
	  return modelPropertyValue;
	}
	
	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean isUiControlUpdated = super.setModelPropertyValue(key, data);
		if ("mediatorClass.name".equals(key)) {
			this.setMediatorClassName(data.toString());
		}
		if("mediatorClass.package.name".equals(key)){
			this.setMediatorClassPackageName(data.toString());
		}
		if("import.project.list".equals(key)){
			this.setMediatorProject((IProject)data);
		}
		return isUiControlUpdated;
	}

	public void setMediatorClassName(String mediatorClass) {
		this.mediatorClass=mediatorClass;
	}
	
	public String getMediatorClassName(){
		return mediatorClass;
	}

	public void setMediatorClassPackageName(String mediatorClassPackage) throws ObserverFailedException {
		this.mediatorClassPackage = mediatorClassPackage;
		super.setGroupId(mediatorClassPackage);
	}

	public String getMediatorClassPackageName() {
		return mediatorClassPackage;
	}

	public void setMediatorProject(IProject mediatorProject) {
		this.mediatorProject = mediatorProject;
		try {
			if (mediatorProject != null)
			this.setProjectName(mediatorProject.getName());
		} catch (ObserverFailedException e) {
			//ignore.
		}
	}

	public IProject getMediatorProject() {
		return mediatorProject;
	}
}
