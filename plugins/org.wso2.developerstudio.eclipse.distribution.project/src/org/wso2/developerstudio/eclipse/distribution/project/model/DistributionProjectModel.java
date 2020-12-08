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

package org.wso2.developerstudio.eclipse.distribution.project.model;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

public class DistributionProjectModel extends ProjectDataModel {
	private List<DependencyData> selectedProjects = new ArrayList<DependencyData>();

	public boolean setModelPropertyValue(String key, Object data)
			throws ObserverFailedException {
		boolean ret = super.setModelPropertyValue(key, data);
		if (key.equals("workspace.project")) {
			Object[] selectedPrjs = (Object[]) data;
			selectedProjects.clear();
			for (Object object : selectedPrjs) {
				if (object instanceof DependencyData) {
					selectedProjects.add((DependencyData) object);
				}
			}
		}
		return ret;
	}

	public Object getModelPropertyValue(String key) {
		Object value = super.getModelPropertyValue(key);
		if (value == null) {
			if (key.equals("workspace.project")) {
				value = selectedProjects.toArray();
			}
		}
		return value;

	}

	public void setSelectedProjects(List<DependencyData> selectedProjects) {
		this.selectedProjects = selectedProjects;
	}

	public List<DependencyData> getSelectedProjects() {
		return selectedProjects;
	}
}
