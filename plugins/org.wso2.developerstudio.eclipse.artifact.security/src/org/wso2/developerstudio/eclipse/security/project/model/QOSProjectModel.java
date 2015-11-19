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

package org.wso2.developerstudio.eclipse.security.project.model;

import java.io.File;

import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class QOSProjectModel extends ProjectDataModel {	
	private File serviceMetaLocation;
	private String serviceClass;
	private String wsdlURI;
	private String serviceName;
	
	
	public void setLocation(File location) {
		// TODO Auto-generated method stub
		super.setLocation(location);
	}
	
	public File getLocation() {
		// TODO Auto-generated method stub
		return super.getLocation();
	}
	
 	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Object getModelPropertyValue(String key) {
 		  Object modelPropertyValue = super.getModelPropertyValue(key);
 		  if(key.equals("ps.type")){
 				modelPropertyValue = getServiceName();
 			}  
 		  return modelPropertyValue;
 		}
	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean isUiControlUpdated = super.setModelPropertyValue(key, data);
		if("ps.type".equals(key)){
			setServiceName(data.toString());
		}  
		return isUiControlUpdated;
	}
	
	public void setServiceMataLocation(File synapseConfigLocation) {
		this.serviceMetaLocation=synapseConfigLocation;
	}	
	public File getServiceMetaLocation() {
		return serviceMetaLocation;
	}

	public String getWsdlURI() {
		return wsdlURI;
	}

	public void setWsdlURI(String wsdlURI) {
		this.wsdlURI = wsdlURI;
	}

	public String getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}
}
