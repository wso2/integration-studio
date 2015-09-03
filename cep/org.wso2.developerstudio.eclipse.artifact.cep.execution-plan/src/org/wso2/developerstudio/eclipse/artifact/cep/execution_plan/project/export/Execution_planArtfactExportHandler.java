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

package org.wso2.developerstudio.eclipse.artifact.cep.execution_plan.project.export;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.wso2.developerstudio.eclipse.platform.core.project.export.ProjectArtifactHandler;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Execution_planArtfactExportHandler extends ProjectArtifactHandler{
	private static final String FILE_EXTENSION = "siddhiql";

    public List<IResource> exportArtifact(IProject project) throws Exception {
    	List<IResource> exportResources = new ArrayList<IResource>();
			 File[] siddhiqlfiles = FileUtils.getAllMatchingFiles(project.getLocation()
					.toString(), null, FILE_EXTENSION,
					   new ArrayList<File>());
			 for(File siddhiqlfile : siddhiqlfiles) {
				if(isExecution_plan(siddhiqlfile)) {
					String siddhiqlFileLocation = siddhiqlfile.toString()
					.replaceAll(
							"^" + project.getLocation().toString()
									+ File.separator, "");
					IFile siddhiqlFileRef = project.getFile(siddhiqlFileLocation);
					exportResources.add((IResource) siddhiqlFileRef);
				}
			 }
		return exportResources;
    }
    
    private boolean isExecution_plan(File siddhiqlFile){
		try {
			OMElement documentElement = new StAXOMBuilder(new FileInputStream(siddhiqlFile))
					.getDocumentElement();
			String localName = documentElement.getLocalName();
			if (localName.equals("execution_plan")) {
				return true;
			}
		} catch (Exception ignored ) {
	      // ignored 
		} 
		return false;
	}

}
