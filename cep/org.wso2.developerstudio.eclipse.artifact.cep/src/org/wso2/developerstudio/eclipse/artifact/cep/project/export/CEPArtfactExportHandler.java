/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.cep.project.export;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CEPArtfactExportHandler extends ProjectArtifactHandler {
	private static final String CEP_FILE_EXTENSION = "xml";

	public List<IResource> exportArtifact(IProject project) throws Exception {
		List<IResource> exportResources = new ArrayList<IResource>();
		File[] cepFiles = FileUtils.getAllMatchingFiles(project.getLocation()
				.toString(), null, CEP_FILE_EXTENSION, new ArrayList<File>());
		for (File cepFile : cepFiles) {
			IFile cepFileRef = ResourcesPlugin
					.getWorkspace()
					.getRoot()
					.getFileForLocation(
							Path.fromOSString(cepFile.getAbsolutePath()));
			if (!cepFile.getName().equals("pom.xml")) {
				exportResources.add((IResource) cepFileRef);
			}
		}
		return exportResources;
	}

}
