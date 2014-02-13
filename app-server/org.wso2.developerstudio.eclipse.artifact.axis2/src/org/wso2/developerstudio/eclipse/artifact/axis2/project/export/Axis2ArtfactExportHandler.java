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

package org.wso2.developerstudio.eclipse.artifact.axis2.project.export;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.archive.ArchiveManipulator;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.file.TempFileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Axis2ArtfactExportHandler extends ProjectArtifactHandler{

    public List<IResource> exportArtifact(IProject project) throws Exception {
    	List<IResource> exportResources = new ArrayList<IResource>();
		
			ArchiveManipulator archiveManipulator = new ArchiveManipulator();
			//cleaning target directory 
			clearTarget(project);
			IPath outPutPath = buildJavaProject(project);
	        
	        //get resource location
			IPath resources = getResourcePath(project);
	        
	        //Let's create a temp project 
	        File tempProject = createTempProject();
	        
	        File axis2Resources = createTempDir(tempProject,"axis2_resources");
	       
	        FileUtils.copyDirectoryContents(outPutPath.toFile(), axis2Resources); // copy binaries 
	        if(resources.toFile().exists()) {
	        	FileUtils.copyDirectoryContents(resources.toFile(), axis2Resources); // copy resources
	        }
	        File tmpArchive = new File(tempProject,project.getName().concat(".aar"));
	        archiveManipulator.archiveDir(tmpArchive.toString(), axis2Resources.toString());

	        IFile serviceArchive = getTargetArchive(project,"aar");
	        FileUtils.copy(tmpArchive, serviceArchive.getLocation().toFile());
	        exportResources.add((IResource)serviceArchive);
	        
	        //cleaning temp project
//	        if(!org.apache.commons.io.FileUtils.deleteQuietly(tempProject.getLocation().toFile())){
//	        	tempProject.delete(true, getProgressMonitor());
//	        }
	        
	        TempFileUtils.cleanUp();
		return exportResources;
    }

}
