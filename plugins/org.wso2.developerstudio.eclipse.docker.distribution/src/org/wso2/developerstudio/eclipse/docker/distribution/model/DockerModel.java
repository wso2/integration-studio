/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.docker.distribution.model;

import java.util.ArrayList;
import java.util.List;

import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.platform.core.exception.ObserverFailedException;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;

/**
 * Model class for the docker project type.
 * Additional properties ( docker tag, docker repository )
 */
public class DockerModel extends ProjectDataModel {

	private List<DependencyData> selectedProjects = new ArrayList<DependencyData>();

	private String repository;

	public List<DependencyData> getSelectedProjects() {
		return selectedProjects;
	}

	public void setSelectedProjects(List<DependencyData> selectedProjects) {
		this.selectedProjects = selectedProjects;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getRepository() {
		return repository;
	}

	public void setRepository(String repository) {
		this.repository = repository;
	}

	private String tag;

	public void ProjectDataModel() {

	}

	public boolean setModelPropertyValue(String key, Object data) throws ObserverFailedException {
		super.setModelPropertyValue(key, data);
		if (key.equalsIgnoreCase("project.tag")) {
			setTag(data.toString());
		} else if (key.equalsIgnoreCase("project.repository")) {
			setRepository(data.toString());
		}
		return false;
	}

}
