/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.docker.distribution.ui.wizard;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.Xpp3DomBuilder;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.wso2.developerstudio.eclipse.distribution.project.util.ArtifactTypeMapping;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.model.DockerModel;
import org.wso2.developerstudio.eclipse.docker.distribution.utils.DockerImageUtils;
import org.wso2.developerstudio.eclipse.docker.distribution.utils.DockerProjectConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.MavenDetailsPage;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

/**
 * Wizard to create a new Docker project.
 */
public class DockerProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String POM_FILE = "pom.xml";
	private IProject project;
	private final DockerModel dockerModel;

	public DockerProjectCreationWizard() {
		this.dockerModel = new DockerModel();
		setModel(this.dockerModel);
		setWindowTitle(DockerProjectConstants.DS_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(DockerImageUtils.getInstance().getImageDescriptor("ds-wizard.png"));
	}

	private void createFolder(String folderName) throws CoreException {
		IFolder carbonAppsFolder = ProjectUtils.getWorkspaceFolder(project, folderName);
		if (!carbonAppsFolder.exists()) {
			// creates the CarbonAppsFolder
			ProjectUtils.createFolder(carbonAppsFolder);
		}
	}

	/**
	 * Copy the docker file to project directory if not exists.
	 * 
	 * @throws IOException
	 * @throws CoreException
	 */
	private void copyDockerFile() throws IOException, CoreException {
		IFile dockerFile = project.getFile("Dockerfile");
		File newFile = new File(dockerFile.getLocationURI().getPath());
		if (!newFile.exists()) {
			// Creating the new docker file
			URL url = new URL(
					"platform:/plugin/org.wso2.developerstudio.eclipse.docker.distribution/DockerFile/Dockerfile");
			if (newFile.createNewFile()) {
				InputStream inputStream = url.openConnection().getInputStream();
				OutputStream outputStream = new FileOutputStream(newFile);
				IOUtils.copy(inputStream, outputStream);
			}
		}
	}

	public boolean performFinish() {
		try {

			project = createNewProject();

			// Creating CarbonApps and Libs folders
			createFolder(DockerProjectConstants.CARBON_APP_FOLDER);
			createFolder(DockerProjectConstants.LIBS_FOLDER);

			// Copy docker file
			copyDockerFile();

			File pomfile = project.getFile(POM_FILE).getLocation().toFile();
			createPOM(pomfile);
			ProjectUtils.addNatureToProject(project, false, DockerProjectConstants.DOCKER_NATURE);
			MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
					new String[] { DockerProjectConstants.DOCKER_NATURE });
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);

			// Adding maven-dependency plugin
			// This will copy the CAR files from .m2 to CarbonApps folder
			Plugin dependencyPlugin = MavenUtils.createPluginEntry(mavenProject, "org.apache.maven.plugins",
					"maven-dependency-plugin", DockerProjectConstants.MAVEN_DEPENDENCY_PLUGIN_VERSION, true);
			PluginExecution dependencyPluginExecution = new PluginExecution();
			dependencyPluginExecution.addGoal("copy-dependencies");
			dependencyPluginExecution.setId("copy-dependencies");
			dependencyPluginExecution.setPhase("package");

			String pluginConfig = "<configuration>\n"
					+ "                <outputDirectory>${project.build.directory}/../CarbonApps</outputDirectory>\n"
					+ "                <overWriteReleases>false</overWriteReleases>\n"
					+ "                <overWriteSnapshots>false</overWriteSnapshots>\n"
					+ "                <overWriteIfNewer>true</overWriteIfNewer>\n"
					+ "                <excludeTransitive>true</excludeTransitive>\n" 
					+ "           </configuration>";
			Xpp3Dom dom = Xpp3DomBuilder.build(new ByteArrayInputStream(pluginConfig.getBytes()), "UTF-8");
			dependencyPluginExecution.setConfiguration(dom);
			dependencyPlugin.addExecution(dependencyPluginExecution);

			// Adding spotify docker plugin
			Plugin spotifyPlugin = MavenUtils.createPluginEntry(mavenProject, "com.spotify", "dockerfile-maven-plugin",
					DockerProjectConstants.SPOTIFY_DOCKER_PLUGIN_VERSION, true);
			PluginExecution spotifyPluginExecution = new PluginExecution();
			spotifyPluginExecution.addGoal("build");
			spotifyPluginExecution.setId("default");

			String spotifyPluginConfig = "<configuration>\n"
					+ "					      <repository>${docker.repository}</repository>\n"
					+ "					      <tag>${docker.tag}</tag>\n" 
					+ "				      </configuration>";
			Xpp3Dom spotifyDom = Xpp3DomBuilder.build(new ByteArrayInputStream(spotifyPluginConfig.getBytes()),
					"UTF-8");
			spotifyPluginExecution.setConfiguration(spotifyDom);
			spotifyPlugin.addExecution(spotifyPluginExecution);

			// Adding dependencies
			List<Dependency> dependencyList = new ArrayList<Dependency>();

			MavenUtils.addMavenDependency(mavenProject, dependencyList);

			// Adding properties ( docker repository and tag )
			Properties properties = mavenProject.getModel().getProperties();
			ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
			properties.put("artifact.types", artifactTypeMapping.getArtifactTypes());
			properties.put("docker.repository", dockerModel.getRepository());
			properties.put("docker.tag", dockerModel.getTag());
			mavenProject.getModel().setProperties(properties);

			MavenUtils.saveMavenProject(mavenProject, pomfile);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			openEditor();

		} catch (Exception e) {
			log.error("An error occurred generating a project: ", e);
			return false;
		}
		return true;
	}

	public IResource getCreatedResource() {
		return project;
	}

	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if (page instanceof MavenDetailsPage) {
			nextPage = null;

		}
		return nextPage;
	}

	public IWizardPage getPreviousPage(IWizardPage page) {
		IWizardPage previousPage = super.getNextPage(page);
		return previousPage;
	}

	public boolean canFinish() {
		if (getContainer().getCurrentPage() instanceof MavenDetailsPage) {
			return true;
		}
		return super.canFinish();
	}

	public DockerModel getDockerModel() {
		return dockerModel;
	}

	public void openEditor() {
		try {
			IFile pom = project.getFile("pom.xml");
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IWorkbenchPage page = window.getActivePage();
			page.openEditor(new FileEditorInput(pom), DockerProjectConstants.DOCKER_EDITOR);
		} catch (Exception e) {
			/* ignore */}
	}

}
