/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.factory;

import java.io.File;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.developerstudio.eclipse.artifact.connection.model.ConnectionModel;
import org.wso2.developerstudio.eclipse.artifact.connection.ui.wizard.ConnectionProjectCreationWizard;
import org.wso2.developerstudio.eclipse.artifact.localentry.model.LocalEntryModel;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.artifact.localentry.ui.wizard.LocalEntryProjectCreationWizard;

public class ConnectionFileCreator implements IFileCreator{
	
	public ConnectionFileCreator (){
	}
	
	public void createConnectionFile(String content, IContainer artifactLocation, String configName) throws Exception{	
		
		ConnectionModel connectionModel = new ConnectionModel();
		connectionModel.setLocalEntrySaveLocation(artifactLocation);
		connectionModel.setLocalENtryName(configName);
		connectionModel.setSelectedOption("");
		connectionModel.setSelectedLocalEntryType("");
				
		IProject project = connectionModel.getLocalEntrySaveLocation().getProject();
		ConnectionProjectCreationWizard connectionProjectCreationWizard = new ConnectionProjectCreationWizard();
		connectionProjectCreationWizard.setProject(project);
		connectionProjectCreationWizard.setModel(connectionModel);
		
		//TODO : remove this part createConnectionArtifact already creates the file
		if(connectionProjectCreationWizard.createConnectionArtifact(connectionModel)){
	        IContainer location = project.getFolder("src" + File.separator + "main"	+ File.separator + "integration-config" + File.separator + "connections");
	        File destFile = new File(location.getLocation().toFile(), connectionModel.getLocalENtryName() + ".xml");
	        FileUtils.writeContent(destFile, content);
		}		
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}

	
}
