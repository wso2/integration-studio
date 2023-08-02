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

package org.wso2.integrationstudio.artifact.connector.project.nature;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.wso2.integrationstudio.artifact.connector.Activator;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.maven.util.MavenUtils;
import org.wso2.integrationstudio.platform.core.nature.AbstractWSO2ProjectNature;

public class ConnectorProjectNature extends AbstractWSO2ProjectNature {

	private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String CAPP_TYPE = "synapse/lib";

	public void configure() {
		updatePom();
	}

	private void updatePom() {
		// TODO update the pom with the relavant packaging types & maven pligins
		File mavenProjectPomLocation = getProject().getFile("pom.xml").getLocation().toFile();
		if (!mavenProjectPomLocation.exists()) {
		    return;
		}
		try {
			MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
			// Adding typrLidt property
			MavenUtils.updateMavenProjectWithCAppType(mavenProject, CAPP_TYPE);
			// Setting the directory
			// Adding maven test skip property
			MavenUtils.updateMavenProjectWithSkipTests(mavenProject);
			MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);

		} catch (Exception e) {
			log.error(e);
		}

		try {
			getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			log.error(e);
		}
	}

	public void deconfigure() throws CoreException {
		
	}
}
