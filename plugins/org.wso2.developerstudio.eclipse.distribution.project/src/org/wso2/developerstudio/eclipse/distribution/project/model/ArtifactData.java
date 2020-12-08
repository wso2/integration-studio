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

import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.distribution.project.util.ArtifactPriorityMapping;

public class ArtifactData implements Comparable<ArtifactData> {
	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}
	/**
	 * @return the resource
	 */
	public IResource getResource() {
		return resource;
	}
	/**
	 * @param resource the resource to set
	 */
	public void setResource(IResource resource) {
		this.resource = resource;
	}
	/**
	 * @param dependencyData the dependencyData to set
	 */
	public void setDependencyData(DependencyData dependencyData) {
		this.dependencyData = dependencyData;
	}
	/**
	 * @return the dependencyData
	 */
	public DependencyData getDependencyData() {
		return dependencyData;
	}

	private String file;
	private IResource resource;
	private DependencyData dependencyData;
	
	@Override
	public int compareTo(ArtifactData compareArtifactData) {
		ArtifactPriorityMapping artifactPriorityMapping = new ArtifactPriorityMapping();
		return artifactPriorityMapping.getPriority(this.getDependencyData()
				.getCApptype())
				- artifactPriorityMapping.getPriority(compareArtifactData
						.getDependencyData().getCApptype());
	}
}
