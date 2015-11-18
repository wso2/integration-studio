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

package org.wso2.developerstudio.eclipse.artifact.jaxws.project.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.file.TempFileUtils;

public class JaxwsArtfactExportHandler extends ProjectArtifactHandler {

	public List<IResource> exportArtifact(IProject project) throws Exception{
		List<IResource> exportResources = new ArrayList<IResource>();
	        
		ArchiveManipulator archiveManipulator = new ArchiveManipulator();

		clearTarget(project);
		IPath outPutPath = buildJavaProject(project);

		// get webapp files location
		IPath webapp = project.getFolder(
				"src" + File.separator + "main" + File.separator + "webapp").getLocation();

		File tempProject = createTempProject();

		File webappResources = createTempDir(tempProject, "webapp_resources");

		if (webapp.toFile().exists()) {
			FileUtils.copyDirectoryContents(webapp.toFile(), webappResources); // copy webapp files
			File classes = new File(webappResources, "WEB-INF" + File.separator + "classes");
			classes.mkdirs();
			FileUtils.copyDirectoryContents(outPutPath.toFile(), classes); // copy class files
			
			IPath resources = getResourcePath(project); //get resource location
			if(resources.toFile().exists()) {
	        	FileUtils.copyDirectoryContents(resources.toFile(), classes); // copy resources
	        }
		}
		File tmpArchive = new File(tempProject, project.getName().concat(".war"));
		archiveManipulator.archiveDir(tmpArchive.toString(), webappResources.toString());
		IFile webArchive = getTargetArchive(project, "war");
		FileUtils.copy(tmpArchive, webArchive.getLocation().toFile());
		exportResources.add((IResource) webArchive);
		TempFileUtils.cleanUp();

		return exportResources;
	}

}
