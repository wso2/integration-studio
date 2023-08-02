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

package org.wso2.integrationstudio.esb.project.nature;

import java.io.File;
import java.io.FileNotFoundException;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.integrationstudio.esb.core.utils.SynapseConstants;
import org.wso2.integrationstudio.esb.core.utils.SynapseUtils;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.platform.core.nature.AbstractWSO2ProjectNature;
import org.wso2.integrationstudio.utils.project.ProjectUtils;

public class ESBProjectNature extends AbstractWSO2ProjectNature {
	private static final String CAPP_TYPE = "bpel/workflow=zip,lib/registry/filter=jar,webapp/jaxws=war,lib/library/bundle=jar,service/dataservice=dbs,synapse/local-entry=xml,synapse/proxy-service=xml,carbon/application=car,registry/resource=zip,lib/dataservice/validator=jar,synapse/endpoint=xml,web/application=war,lib/carbon/ui=jar,service/axis2=aar,synapse/sequence=xml,synapse/configuration=xml,wso2/gadget=dar,lib/registry/handlers=jar,lib/synapse/mediator=jar,synapse/task=xml,synapse/api=xml,synapse/template=xml,synapse/message-store=xml,synapse/message-processors=xml,synapse/inbound-endpoint=xml,synapse/metadata=yaml";
	
	public void configure() throws CoreException {
		String[] childrenList = { "endpoints", "proxy-services", "sequences", "local-entries", "tasks", "templates",
				"api", "message-stores", "message-processors", "inbound-endpoints" };
		IFolder parentFolder = ProjectUtils.getWorkspaceFolder(getProject(), "src", "main", "synapse-config");
		IFolder parentTestFolder = ProjectUtils.getWorkspaceFolder(getProject(), "test", "resources", "mock-services");
		IFolder metadataFolder = ProjectUtils.getWorkspaceFolder(getProject(), "src", "main", "resources", "metadata");
		IFolder buildArtifactsFolder = ProjectUtils.getWorkspaceFolder(getProject(), 
		        SynapseConstants.BUILD_ARTIFACTS_FOLDER);
		buildArtifactsFolder.setHidden(true);
		ProjectUtils.createFolder(parentFolder);
		ProjectUtils.createFolder(parentTestFolder);
		ProjectUtils.createFolder(metadataFolder);
		ProjectUtils.createFolder(buildArtifactsFolder);
		getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		for (String child : childrenList) {
			createChildren(parentFolder, child);
		}
		SynapseUtils.createBuildArtifactsModulePom(getProject(), buildArtifactsFolder);
		updatePom();
	}

	private void updatePom() {
		// TODO update the pom with the relavant packaging types & maven pligins
		File mavenProjectPomLocation = getProject().getFile("pom.xml").getLocation().toFile();
		try {
			MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
			//Adding typrLidt property
			MavenUtils.updateMavenProjectWithCAppType(mavenProject, CAPP_TYPE);
//			Adding maven test skip property
			MavenUtils.updateMavenProjectWithSkipTests(mavenProject);

			MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
			
		} catch (FileNotFoundException e) {
			// ignore
		} catch (Exception e) {
			// TODO Handle this properly.
			e.printStackTrace();
		}
		
		try {
			getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Handle this properly.
			e.printStackTrace();
		}
	}

	public void createChildren(IFolder parent, String... children) throws CoreException {
		IFolder childFolder = ProjectUtils.getWorkspaceFolder(parent, children);
		ProjectUtils.createFolder(childFolder);
		getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

	}

	
	public void deconfigure() throws CoreException {
		// TODO Auto-generated method stub

	}
}
