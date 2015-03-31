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

package org.wso2.developerstudio.eclipse.artifact.dataserviceProject.ui.wizard;

import java.io.File;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.wizard.IWizardPage;
import org.wso2.developerstudio.eclipse.artifact.dataserviceProject.Activator;
import org.wso2.developerstudio.eclipse.artifact.dataserviceProject.artifact.DSSProjectArtifact;
import org.wso2.developerstudio.eclipse.artifact.dataserviceProject.model.DataServiceModel;
import org.wso2.developerstudio.eclipse.artifact.dataserviceProject.utils.DataServiceImageUtils;
import org.wso2.developerstudio.eclipse.artifact.dataserviceProject.utils.DataServiceProjectConstants;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.MavenDetailsPage;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class DataServiceProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String DS_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.ds.project.nature";
	private static final String POM_FILE = "pom.xml";
	private static final String ARTIFACT_FILE = "artifact.xml";
	private static final String PACKAGE_NAME = "service/dataservice";
	private static final String GROUP_ID = "org.wso2.maven";
	private static final String ARTIFACT_ID = "maven-dataservice-plugin";

	private final DataServiceModel dsModel;
	private IProject project;

	public DataServiceProjectCreationWizard() {
		this.dsModel = new DataServiceModel();
		setModel(this.dsModel);
		setWindowTitle(DataServiceProjectConstants.DS_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(DataServiceImageUtils.getInstance().getImageDescriptor(
				"ds-wizard.png"));
	}

	public boolean performFinish() {
		try {
			// creates a new project
			project = createNewProject();

			IFolder dsfolder = ProjectUtils.getWorkspaceFolder(project,
					DataServiceProjectConstants.DS_PROJECT_SOURCE_FOLDER,
					DataServiceProjectConstants.DS_PROJECT_MAIN_FOLDER,
					DataServiceProjectConstants.DS_PROJECT_DATASERVICE_FOLDER);
			if (!dsfolder.exists()) {
				// creates the template
				ProjectUtils.createFolder(dsfolder);
			}

			File pomfile = project.getFile(POM_FILE).getLocation().toFile();
			getModel().getMavenInfo().setPackageName(PACKAGE_NAME);
			// creates the pom file
			createPOM(pomfile);
			// updates pom file with data service plugin
			updatePom(pomfile);

			ProjectUtils.addNatureToProject(project, false, DS_PROJECT_NATURE);
			MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
					new String[] { DS_PROJECT_NATURE });
			getModel().addToWorkingSet(project);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

			// creates the artifact.xml file
			createArtifactXMLFile();

		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}

		return true;
	}

	/**
	 * Updates the pom file
	 * 
	 * @param openFile
	 *            current .dbs file
	 * @throws Exception
	 */
	public void updatePom(File mavenProjectPomLocation) throws Exception {
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID,
				MavenConstants.MAVEN_DATASERVICE_PLUGIN_VERSION);

		if (!pluginExists) {
			MavenUtils.createPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID,
					MavenConstants.MAVEN_DATASERVICE_PLUGIN_VERSION, true);
		}

		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	/**
	 * Creating the metadata file artifact.xml while creating the DSS project.
	 * It will be hidden and users won't be able to see it via Eclipse.
	 * 
	 * @throws Exception
	 * @throws CoreException
	 */
	private void createArtifactXMLFile() throws Exception, CoreException {
		DSSProjectArtifact artifact = new DSSProjectArtifact();
		IFile file = project.getFile(ARTIFACT_FILE);
		artifact.setSource(file.getLocation().toFile());
		artifact.toFile();
		getModel().addToWorkingSet(project);
		/*
		 * Refresh the project to show the changes. But still won't see the
		 * newly created project.
		 */
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		refreshDistProjects();
		// Setting the created file to be hidden so that users won't see it.
		if (file.exists()) {
			file.setHidden(true);
		}
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

}
