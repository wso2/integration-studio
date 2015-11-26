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

package org.wso2.developerstudio.eclipse.artifact.registry.filter.model;

import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class RegistryFilterModel extends ProjectDataModel {

	private String filterClass;
	private String filterClassPackage;

	public String getFilterClass() {
		return filterClass;
	}

	public void setFilterClass(String filterClass) {
		this.filterClass = filterClass;
	}

	public String getFilterClassPackage() {
		return filterClassPackage;
	}

	public void setFilterClassPackage(String filterClassPackage) throws ObserverFailedException {
		this.filterClassPackage = filterClassPackage;
		super.setGroupId(filterClassPackage);
	}

	public Object getModelPropertyValue(String key) {
		Object modelPropertyValue = super.getModelPropertyValue(key);
		if (modelPropertyValue == null) {
			if ("filterClass.name".equals(key)) {
				modelPropertyValue = getFilterClass();
			} else if ("filterClass.package.name".equals(key)) {
				modelPropertyValue = getFilterClassPackage();
			}
		}
		return modelPropertyValue;
	}

	public boolean setModelPropertyValue(String key, Object data)
			throws ObserverFailedException {
		boolean ret = super.setModelPropertyValue(key, data);
		if ("filterClass.name".equals(key)) {
			setFilterClass(data.toString());
		} else if ("filterClass.package.name".equals(key)) {
			setFilterClassPackage(data.toString());
		}
		return ret;
	}
}
