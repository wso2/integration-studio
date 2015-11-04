/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.registry.base.artifact.export;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.distribution.project.export.DefaultArtifactExportHandler;
import org.wso2.developerstudio.eclipse.distribution.project.model.ArtifactData;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.platform.core.project.export.util.ExportUtil;

public class RegistryArtifactExporter extends DefaultArtifactExportHandler {

	@Override
	public void exportArtifact(List<ArtifactData> artifactList,
	                           Map<IProject, Map<String, IResource>> resourceProjectList, IFolder splitESBResources,
	                           DependencyData dependencyData, Object parent, Object self) throws Exception {
		IProject resProject = (IProject) parent;
		if (!resourceProjectList.containsKey(resProject)) {
			Map<String, IResource> artifacts = new HashMap<String, IResource>();
			List<IResource> buildProject = ExportUtil.buildProject(resProject, dependencyData.getCApptype());
			for (IResource res : buildProject) {
				if (res instanceof IFolder) {
					artifacts.put(res.getName(), res);
				}
			}
			resourceProjectList.put(resProject, artifacts);
		}
		if (resourceProjectList.containsKey(resProject)) {
			Map<String, IResource> artifacts = resourceProjectList.get(resProject);
			if (artifacts.containsKey(getArtifactDir(dependencyData))) {
				ArtifactData artifactData = new ArtifactData();
				artifactData.setDependencyData(dependencyData);
				artifactData.setFile("registry-info.xml");
				artifactData.setResource(artifacts.get(getArtifactDir(dependencyData)));
				artifactList.add(artifactData);
			}
		}
	}

	private String getArtifactDir(DependencyData dependencyData) {
		String artifactDir =
		                     String.format("%s_%s", dependencyData.getDependency().getArtifactId(),
		                                   dependencyData.getDependency().getVersion());
		return artifactDir;
	}

}
