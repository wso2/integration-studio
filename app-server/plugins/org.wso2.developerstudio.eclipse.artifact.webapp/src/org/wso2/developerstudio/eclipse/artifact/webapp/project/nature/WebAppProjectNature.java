/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.webapp.project.nature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Repository;
import org.apache.maven.model.RepositoryPolicy;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.wso2.developerstudio.eclipse.artifact.webapp.utils.WebAppTemplateUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.nature.AbstractWSO2ProjectNature;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;
import org.wso2.developerstudio.eclipse.utils.wst.WebUtils;

public class WebAppProjectNature extends AbstractWSO2ProjectNature {

	private static IDeveloperStudioLog log = Logger
			.getLog(org.wso2.developerstudio.eclipse.artifact.webapp.Activator.PLUGIN_ID);

	public void configure() throws CoreException {
		/*since we reuse the dynamic web project,we need to identify it when adding the project nature
		to do that we keep this variable as a switch*/
		JavaUtils.isWebApp = true;
		addJavaProjectNature();
		try {
			updatePom();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		JavaUtils.isWebApp = false;
	}
	
	private void setupAsWebApp() throws CoreException, IOException {
		IFile webXmlLocation = WebUtils.getWEBXmlLocation(getProject());
		if (webXmlLocation == null) {
			IFolder webappFolder =
			        ProjectUtils.getWorkspaceFolder(getProject(), "src", "main", "webapp");
			ITemporaryFileTag warTempTag = FileUtils.createNewTempTag();
			File webappTemplateArchive =
			        new WebAppTemplateUtils().getResourceFile("webapp-template.war");
			WebUtils.extractWAR(webappFolder, webappTemplateArchive);
			warTempTag.clearAndEnd();
		}
	} 

	public void deconfigure() throws CoreException {

	}

	public void updatePom() throws Exception {
		File mavenProjectPomLocation = getProject().getFile("pom.xml").getLocation().toFile();
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		/*Adding J2EE Dependency*/
		List<Dependency> dependencies = new ArrayList<Dependency>();
		Dependency j2eeDepen = new Dependency();
		j2eeDepen.setGroupId("javax");
		j2eeDepen.setArtifactId("javaee-web-api");
		j2eeDepen.setVersion("6.0");
		j2eeDepen.setScope("provided");
		dependencies.add(j2eeDepen);
		MavenUtils.addMavenDependency(mavenProject, dependencies);
		/*Adding Plugins*/
		MavenUtils.updateMavenProjectWithWarBuilderPlugin(getProject(), mavenProject,mavenProjectPomLocation);
		
		Repository repo = new Repository();
		repo.setUrl("http://download.java.net/maven/2");
		repo.setId("java.net2");
		repo.setName("Repository hosting the jee6 artifacts");
		RepositoryPolicy releasePolicy=new RepositoryPolicy();
		releasePolicy.setEnabled(true);
		releasePolicy.setUpdatePolicy("daily");
		releasePolicy.setChecksumPolicy("ignore");
		repo.setReleases(releasePolicy);
		mavenProject.getModel().addRepository(repo);
		
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

}
