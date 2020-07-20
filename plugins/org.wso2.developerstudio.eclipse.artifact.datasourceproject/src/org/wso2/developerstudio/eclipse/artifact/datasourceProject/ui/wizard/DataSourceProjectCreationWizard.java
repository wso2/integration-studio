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

package org.wso2.developerstudio.eclipse.artifact.datasourceProject.ui.wizard;

import java.io.File;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.artifact.datasourceProject.Activator;
import org.wso2.developerstudio.eclipse.artifact.datasourceProject.artifact.DataSourceProjectArtifact;
import org.wso2.developerstudio.eclipse.artifact.datasourceProject.model.DataSourceModel;
import org.wso2.developerstudio.eclipse.artifact.datasourceProject.utils.DataSourceImageUtils;
import org.wso2.developerstudio.eclipse.artifact.datasourceProject.utils.DataSourceProjectConstants;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.project.presentation.ProjectPresentation;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.MavenDetailsPage;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class DataSourceProjectCreationWizard extends AbstractWSO2ProjectCreationWizard {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String DS_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.datasource.project.nature";
	private static final String POM_FILE = "pom.xml";
	private static final String ARTIFACT_FILE = "artifact.xml";
	private static final String PACKAGE_NAME = "pom";
	private static final String CAPP_TYPE = "bpel/workflow=zip,lib/registry/filter=jar,webapp/jaxws=war,lib/library/bundle=jar,service/dataservice=dbs,datasource/datasource=xml,synapse/local-entry=xml,synapse/proxy-service=xml,carbon/application=car,registry/resource=zip,lib/dataservice/validator=jar,synapse/endpoint=xml,web/application=war,lib/carbon/ui=jar,service/axis2=aar,synapse/sequence=xml,synapse/configuration=xml,wso2/gadget=dar,lib/registry/handlers=jar,lib/synapse/mediator=jar,synapse/task=xml,synapse/api=xml,synapse/template=xml,synapse/message-store=xml,synapse/message-processors=xml,synapse/inbound-endpoint=xml";
	private static final String DSS_PERSPECTIVE = "org.wso2.developerstudio.eclipse.ds.presentation.custom.perspective";
	private IProject project;
	private final DataSourceModel dsModel;

	public DataSourceProjectCreationWizard() {
		this.dsModel = new DataSourceModel();
		setModel(this.dsModel);
		setWindowTitle(DataSourceProjectConstants.DS_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(DataSourceImageUtils.getInstance().getImageDescriptor("ds-wizard.png"));
	}

	public boolean performFinish() {
		try {
			setProjectNature(DS_PROJECT_NATURE);
			// creates a new project
			project = createNewProject();

			IFolder dsfolder = ProjectUtils.getWorkspaceFolder(project,
					DataSourceProjectConstants.DS_PROJECT_DATASERVICE_FOLDER);
			if (!dsfolder.exists()) {
				// creates the template
				ProjectUtils.createFolder(dsfolder);
			}

			File pomfile = project.getFile(POM_FILE).getLocation().toFile();
			getModel().getMavenInfo().setPackageName(PACKAGE_NAME);
			// creates the pom file
			createPOM(pomfile);
			// updates pom file with data source plugin
			updatePom(pomfile);

			ProjectUtils.addNatureToProject(project, false, DS_PROJECT_NATURE);
			MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {}, new String[] { DS_PROJECT_NATURE });
			getModel().addToWorkingSet(project);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

			// creates the artifact.xml file
			createArtifactXMLFile();
            try {
                IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
                PlatformUI.getWorkbench().showPerspective(DSS_PERSPECTIVE, window);
                ProjectPresentation.setHierarchicalProjectPresentation();
            } catch (Exception e) {
                log.error(DataSourceProjectConstants.ERROR_MESSAGE_CORE_EXCEPTION, e);
            }
		} catch (CoreException e) {
			log.error(DataSourceProjectConstants.ERROR_MESSAGE_CORE_EXCEPTION, e);
		} catch (Exception e) {
			log.error(DataSourceProjectConstants.ERROR_MESSAGE_UNEXPECTED_ERROR, e);
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
		try {
			MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
			// Adding typrLidt property
			MavenUtils.updateMavenProjectWithCAppType(mavenProject, CAPP_TYPE);
			// Setting the directory
			mavenProject.getBuild().setDirectory("target/capp");
			// Adding maven test skip property
			MavenUtils.updateMavenProjectWithSkipTests(mavenProject);

			// Adding maven exec plugin entry
			Plugin plugin = MavenUtils.createPluginEntry(mavenProject, "org.codehaus.mojo", "exec-maven-plugin", "1.4.0",
					true);

			{
				PluginExecution pluginExecution = new PluginExecution();
				pluginExecution.setId(MavenConstants.PACKAGE_PHASE);
				pluginExecution.addGoal(MavenConstants.EXEC_GOAL);
				pluginExecution.setPhase(MavenConstants.PACKAGE_PHASE);

				Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
				Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, MavenConstants.EXECUTABLE_TAG);
				executableNode.setValue(MavenConstants.EXECUTABLE_VALUE);
				Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode,
						MavenConstants.WORKING_DIRECTORY_TAG);
				workingDirectoryNode.setValue(MavenConstants.WORKING_DIRECTORY_VALUE);
				Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, MavenConstants.ARGUMENTS_TAG);
				Xpp3Dom cleanArgumentNode = MavenUtils.createXpp3Node(argumentsNode, MavenConstants.ARGUMENT_TAG);
				cleanArgumentNode.setValue(MavenConstants.ARGUMENT_VALUE_CLEAN);
				Xpp3Dom installArgumentNode = MavenUtils.createXpp3Node(argumentsNode, MavenConstants.ARGUMENT_TAG);
				installArgumentNode.setValue(MavenConstants.PACKAGE_PHASE);
				Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, MavenConstants.ARGUMENT_TAG);
				testSkipArgumentNode.setValue(MavenConstants.ARGUMENT_VALUE_SKIP_TESTS);

				pluginExecution.setConfiguration(configurationNode);

				plugin.addExecution(pluginExecution);
			}
			{
				PluginExecution pluginExecution = new PluginExecution();
				pluginExecution.setId(MavenConstants.INSTALL_PHASE);
				pluginExecution.addGoal(MavenConstants.EXEC_GOAL);
				pluginExecution.setPhase(MavenConstants.INSTALL_PHASE);

				Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
				Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, MavenConstants.EXECUTABLE_TAG);
				executableNode.setValue(MavenConstants.EXECUTABLE_VALUE);
				Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode,
						MavenConstants.WORKING_DIRECTORY_TAG);
				workingDirectoryNode.setValue(MavenConstants.WORKING_DIRECTORY_VALUE);
				Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, MavenConstants.ARGUMENTS_TAG);
				Xpp3Dom cleanArgumentNode = MavenUtils.createXpp3Node(argumentsNode, MavenConstants.ARGUMENT_TAG);
				cleanArgumentNode.setValue(MavenConstants.ARGUMENT_VALUE_CLEAN);
				Xpp3Dom installArgumentNode = MavenUtils.createXpp3Node(argumentsNode, MavenConstants.ARGUMENT_TAG);
				installArgumentNode.setValue(MavenConstants.INSTALL_PHASE);
				Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, MavenConstants.ARGUMENT_TAG);
				testSkipArgumentNode.setValue(MavenConstants.ARGUMENT_VALUE_SKIP_TESTS);

				pluginExecution.setConfiguration(configurationNode);

				plugin.addExecution(pluginExecution);
			}
			{
				PluginExecution pluginExecution = new PluginExecution();
				pluginExecution.setId(MavenConstants.DEPLOY_PHASE);
				pluginExecution.addGoal(MavenConstants.EXEC_GOAL);
				pluginExecution.setPhase(MavenConstants.DEPLOY_PHASE);

				Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
				Xpp3Dom executableNode = MavenUtils.createXpp3Node(configurationNode, MavenConstants.EXECUTABLE_TAG);
				executableNode.setValue(MavenConstants.EXECUTABLE_VALUE);
				Xpp3Dom workingDirectoryNode = MavenUtils.createXpp3Node(configurationNode,
						MavenConstants.WORKING_DIRECTORY_TAG);
				workingDirectoryNode.setValue(MavenConstants.WORKING_DIRECTORY_VALUE);
				Xpp3Dom argumentsNode = MavenUtils.createXpp3Node(configurationNode, MavenConstants.ARGUMENTS_TAG);
				Xpp3Dom deployArgumentNode = MavenUtils.createXpp3Node(argumentsNode, MavenConstants.ARGUMENT_TAG);
				deployArgumentNode.setValue(MavenConstants.DEPLOY_PHASE);
				Xpp3Dom testSkipArgumentNode = MavenUtils.createXpp3Node(argumentsNode, MavenConstants.ARGUMENT_TAG);
				testSkipArgumentNode.setValue(MavenConstants.ARGUMENT_VALUE_SKIP_TESTS);

				pluginExecution.setConfiguration(configurationNode);

				plugin.addExecution(pluginExecution);
			}
			MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
		} catch (Exception e) {
			log.error(DataSourceProjectConstants.ERROR_MESSAGE_UNEXPECTED_ERROR, e);
		}

		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			log.error(DataSourceProjectConstants.ERROR_MESSAGE_CORE_EXCEPTION, e);
		}

	}

	/**
	 * Creating the metadata file artifact.xml while creating the DSS project.
	 * It will be hidden and users won't be able to see it via Eclipse.
	 * 
	 * @throws Exception
	 * @throws CoreException
	 */
	private void createArtifactXMLFile() throws Exception, CoreException {
		DataSourceProjectArtifact artifact = new DataSourceProjectArtifact();
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
