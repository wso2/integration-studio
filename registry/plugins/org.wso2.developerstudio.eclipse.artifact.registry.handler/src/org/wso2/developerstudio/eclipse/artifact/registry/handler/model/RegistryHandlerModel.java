/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.registry.handler.model;


import java.io.File;
import java.util.HashMap;

import org.eclipse.core.resources.IProject;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.Constants;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class RegistryHandlerModel extends ProjectDataModel {

	private String handlerClassSeletionMethod = Constants.NEW_HANDLER_CLASS_TEXT;
	private HashMap<IProject,String> importHandlerList = new HashMap<IProject, String>();
	private File externalJar; 
	

	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if (Constants.OPT_NEW_HANDLER_CLASS.equals(key)) {
				modelPropertyValue = handlerClassSeletionMethod
						.equalsIgnoreCase(Constants.NEW_HANDLER_CLASS_TEXT);
			} else if (Constants.OPT_IMPORT_HANDLER_CLASS_FROM_WS.equals(key)) {
				modelPropertyValue = handlerClassSeletionMethod
						.equalsIgnoreCase(Constants.IMPORT_HANDLER_CLASS_FROM_WS_TEXT);
			} else if(Constants.OPT_IMPORT_HANDLER_CLASS_FROM_FS.equals(key)){
				modelPropertyValue =handlerClassSeletionMethod
				.equalsIgnoreCase(Constants.IMPORT_HANDLER_CLASS_FROM_FS_TEXT);
			}
		}
		return modelPropertyValue;
	}

	public boolean setModelPropertyValue(String key, Object data)
			throws ObserverFailedException {
		boolean ret = super.setModelPropertyValue(key, data);
		if (Constants.OPT_NEW_HANDLER_CLASS.equals(key)) {
			setHandlerClassSeletionMethod(Constants.NEW_HANDLER_CLASS_TEXT);
		} else if (Constants.OPT_IMPORT_HANDLER_CLASS_FROM_WS.equals(key)) {
			setHandlerClassSeletionMethod(Constants.IMPORT_HANDLER_CLASS_FROM_WS_TEXT);
		} else if (Constants.OPT_IMPORT_HANDLER_CLASS_FROM_FS.equals(key)) {
			setHandlerClassSeletionMethod(Constants.IMPORT_HANDLER_CLASS_FROM_FS_TEXT);
		}
		return ret;
	}

	public void setHandlerClassSeletionMethod(String handlerClassSeletionMethod) {
		this.handlerClassSeletionMethod = handlerClassSeletionMethod;
	}

	public String getHandlerClassSeletionMethod() {
		return handlerClassSeletionMethod;
	}

	public HashMap<IProject,String> getImportHandlerList() {
		return importHandlerList;
	}

	public void setExternalJar(File externalJar) {
	    this.externalJar = externalJar;
    }

	public File getExternalJar() {
	    return externalJar;
    }

}
