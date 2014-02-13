/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.brs.model;

import org.wso2.developerstudio.eclipse.artifact.brs.utils.RuleServiceArtifactConstants;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;


public class RuleServiceModel extends ProjectDataModel  {
	private String serviceName;
	private String serviceNameSpace;

	public RuleServiceModel(){

	}

	@Override
	public boolean setModelPropertyValue(String key, Object data)throws ObserverFailedException {
		boolean returnValue = super.setModelPropertyValue(key, data);

		if(key.equals(RuleServiceArtifactConstants.WIZARD_OPTION_IMPORT_FILE)){
			if(getImportFile()!=null && !getImportFile().toString().equals("")){
				setProjectName(ProjectUtils.fileNameWithoutExtension(getImportFile().getName()));
			}
		}
		else if(key.equals(RuleServiceArtifactConstants.WIZARD_OPTION_SERVICE_NAME)){
			setServiceName(data.toString());
		}
		else if(key.equals(RuleServiceArtifactConstants.WIZARD_OPTION_SERVICE_NS)){
			setNameSpace(data.toString());
		}
		return returnValue;
	}

	@Override
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);

		if(key.equals(RuleServiceArtifactConstants.WIZARD_OPTION_SERVICE_NAME)){
			modelPropertyValue=getServiceName();
		}
		else if(key.equals(RuleServiceArtifactConstants.WIZARD_OPTION_SERVICE_NS)){
			modelPropertyValue=getNameSpace();
		}
		return modelPropertyValue;
	}

	public String getServiceName(){
		return serviceName;
	}

	public void setServiceName(String servicename){
		this.serviceName=servicename;
	}

	public String getNameSpace(){
		return serviceNameSpace;
	}

	public void setNameSpace(String servicenamespace){
		this.serviceNameSpace=servicenamespace;
	}
}
