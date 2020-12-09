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

package org.wso2.developerstudio.eclipse.artifact.ds.validator.model;

import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class DataServiceValidatorModel extends ProjectDataModel {
	private String validatorClass;
	private String validatorClassPackage;
    private IProject validatorProject;
    
	
	public Object getModelPropertyValue(String key) {
	  Object modelPropertyValue = super.getModelPropertyValue(key);
	  if((modelPropertyValue == null)&&("vaildatorClass.name".equals(key))){
		  modelPropertyValue = this.getValidatorClass();
	  }
	  if((modelPropertyValue == null)&&("vaildatorClass.package.name".equals(key))){
		  modelPropertyValue = this.getValidatorClassPackage();
	  }
	  if((modelPropertyValue == null)&&("import.project.list".equals(key))){
		  modelPropertyValue = this.getValidatorProject();
	  }
	  return modelPropertyValue;
	}
	
	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean isUiControlUpdated = super.setModelPropertyValue(key, data);
		if ("vaildatorClass.name".equals(key)) {
			this.setValidatorClass(data.toString());
		}
		if("vaildatorClass.package.name".equals(key)){
			this.setValidatorClassPackage(data.toString());
		}
		if("import.project.list".equals(key)){
			this.setValidatorProject((IProject)data);
		}
		return isUiControlUpdated;
	}

	public void setValidatorClass(String validatorClass) {
		this.validatorClass = validatorClass;
	}

	public String getValidatorClass() {
		return validatorClass;
	}

	public void setValidatorClassPackage(String validatorClassPackage) throws ObserverFailedException {
		this.validatorClassPackage = validatorClassPackage;
		super.setGroupId(validatorClassPackage);
	}

	public String getValidatorClassPackage() {
		return validatorClassPackage;
	}

	public void setValidatorProject(IProject validatorProject) {
		this.validatorProject = validatorProject;
		try {
			if (validatorProject != null)
			this.setProjectName(validatorProject.getName());
		} catch (ObserverFailedException e) {
			//ignore.
		}
	}

	public IProject getValidatorProject() {
		return validatorProject;
	}

}
