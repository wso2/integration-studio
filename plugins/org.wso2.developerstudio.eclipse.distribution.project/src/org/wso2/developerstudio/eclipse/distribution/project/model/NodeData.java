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

import org.apache.maven.model.Dependency;
import org.eclipse.core.resources.IProject;

public class NodeData {
	public NodeData(Object obj){
		if(obj instanceof Dependency){
			dependency = (Dependency) obj;
		}
		else if (obj instanceof IProject) {
			project  = (IProject) obj;
			setHaschildren(true);

		}
	}

	public boolean hasChildren() {
		return hasChildren;
	}
	public void setHaschildren(boolean hasChildren) {
		this.hasChildren = hasChildren;
	}
	public Dependency getDependency() {
		return dependency;
	}
	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
		this.project=null;
	}
	public IProject getProject() {
		return project;
	}
	public void setProject(IProject project) {
		this.project = project;
	}
	public void setServerRole(String serverRole) {
		this.serverRole = serverRole;
	}

	public String getServerRole() {
		return serverRole;
	}
	private boolean hasChildren;
	private Dependency dependency;
	private IProject project;
	private String serverRole;
}
