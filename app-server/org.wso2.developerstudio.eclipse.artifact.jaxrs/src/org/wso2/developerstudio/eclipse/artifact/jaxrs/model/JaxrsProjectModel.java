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

package org.wso2.developerstudio.eclipse.artifact.jaxrs.model;

import java.io.File;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.wso2.developerstudio.eclipse.artifact.jaxrs.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class JaxrsProjectModel  extends ProjectDataModel {

	private String sourcePackage;
	private String serviceClass;
	private String serviceClassPackage;
	//private IWorkspace workSpace;
	private String cxfRuntime;
	//private IWorkspaceRoot root;
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	
	public JaxrsProjectModel() {
		//workSpace=ResourcesPlugin.getWorkspace();
		//root=workSpace.getRoot();
		/*String cxfruntime=getCXFRuntime();
		if(!cxfruntime.equals("")){
			setCXFRuntime(cxfruntime);
		}*/
	}

	public void setServiceClassPackage(String serviceClassPackage) {
		this.serviceClassPackage = serviceClassPackage;
	}
	public String getServiceClassPackage() {
		return serviceClassPackage;
	}
	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}
	public String getServiceClass() {
		return serviceClass;
	}
	public void setSourcePackage(String sourcePackage){
		this.sourcePackage = sourcePackage;
	}
	
	public String getSourcePackage(){
		return this.sourcePackage;
	}

	public void setCXFRuntime(String cxfRuntime) {
		this.cxfRuntime = cxfRuntime;
	/*	try {
			root.setSessionProperty(new QualifiedName("","CXF path"),cXFRuntime);
		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		}	*/
	}
	
	public String getCXFRuntime() {
		/*String cxfRuntime="";
		try {
			if(root.getSessionProperties().size()>0){
				cxfRuntime = root.getSessionProperty(new QualifiedName("","CXF path")).toString();
			}
		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		}*/
		return cxfRuntime;
	}
	
	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (key.equalsIgnoreCase("runtime")) {
				modelPropertyValue = getCXFRuntime();
			}else if (key.equals("service.class.package.name")) {
				modelPropertyValue = getServiceClassPackage();
			} else if (key.equals("service.class.name")) {
				modelPropertyValue = getServiceClass();
			}
		}
		return modelPropertyValue;
	}

	
	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		boolean returnValue = super.setModelPropertyValue(key, data);
		if (key.equals("source.package")) {
			setSourcePackage(data.toString());
		} else if (key.equalsIgnoreCase("runtime")) {
			setCXFRuntime(data.toString());
		}	else if (key.equals("service.class.package.name")) {
			setServiceClassPackage(data.toString());
		} else if (key.equals("service.class.name")) {
			setServiceClass(data.toString());
		} if (key.equals("import.file")) {
			if(getProjectName()==null || getProjectName().trim().equals("")){
				if (getImportFile() != null && !getImportFile().toString().equals("")) {
					setProjectName(ProjectUtils.fileNameWithoutExtension(getImportFile().getName()));
				}
			}
		} 
		return returnValue;
	}
	
	@Override
	public void setImportFile(File importFile) {
			super.importFile=importFile;

	}

}
