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
package org.wso2.developerstudio.eclipse.distribution.project.export;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.distribution.project.model.ArtifactData;
import org.wso2.developerstudio.eclipse.distribution.project.model.DependencyData;
import org.wso2.developerstudio.eclipse.distribution.project.util.DistProjectUtils;
import org.wso2.developerstudio.eclipse.platform.core.project.export.util.ExportUtil;

public class DefaultArtifactExportHandler {
	DistProjectUtils distProjectUtils = new DistProjectUtils();

	public void exportArtifact(List<ArtifactData> artifactList,
	                           Map<IProject, Map<String, IResource>> graphicalSynapseProjectList,
	                           IFolder splitESBResources, DependencyData dependencyData, Object parent, Object self)
	                                                                                                                throws Exception {
		if (self instanceof IProject) {
			List<IResource> buildProject = ExportUtil.buildProject((IProject) self, dependencyData.getCApptype());
			if (buildProject.size() == 1) {
				ArtifactData artifactData = new ArtifactData();
				artifactData.setDependencyData(dependencyData);
				artifactData.setFile(distProjectUtils.getFileName(dependencyData));
				artifactData.setResource(buildProject.get(0));
				artifactList.add(artifactData);
			} else {
				throw new Exception("No resource found that matches the given type: " + dependencyData.getCApptype());
			}
		}
	}
}
