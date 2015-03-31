/*
 * Copyright (c) 2012-2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.dataservice.ui.wizard;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.xml.stream.FactoryConfigurationError;

import org.apache.commons.io.FilenameUtils;
import org.apache.maven.model.Plugin;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.dataservice.Activator;
import org.wso2.developerstudio.eclipse.artifact.dataservice.model.DataServiceModel;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceArtifactConstants;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceImageUtils;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceTemplateUtils;
import org.wso2.developerstudio.eclipse.artifact.dataserviceProject.artifact.DSSArtifact;
import org.wso2.developerstudio.eclipse.artifact.dataserviceProject.artifact.DSSProjectArtifact;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.utils.XMLUtil;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.MavenDetailsPage;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.ide.FileExtensionResourcevisitor;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class DataServiceCreationWizard extends AbstractWSO2ProjectCreationWizard {

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String IMPORT_OPTION = "import.ds";
	private static final String NEW_OPTION = "new.ds";
	private static final String POM_FILE = "pom.xml";
	private static final String ARTIFACT_TAG = "artifact";
	private static final String GROUP_ID = "org.wso2.maven";
	private static final String ARTIFACT_ID = "maven-dataservice-plugin";
	private static final String ARTIFACT_FILE = "artifact.xml";
	private static final String DBS_EXTENSION = ".dbs";

	private static final String LINE_SEPERATOR = "line.separator";
	private static final String DATASERVICE_TEMPLATE = "templates/Dataservice1.dbs";

	private final DataServiceModel dsModel;
	private DSSProjectArtifact dssProjectArtifact;
	private IProject project;
	private NewDataSourceWizardPage newDataSourcepage;
	private IWizardPage[] pages;

	private String version = "1.0.0";

	public DataServiceCreationWizard() {
		this.dsModel = new DataServiceModel();
		setModel(this.dsModel);
		setWindowTitle(DataServiceArtifactConstants.DS_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(DataServiceImageUtils.getInstance().getImageDescriptor(
				"ds-wizard.png"));
	}

	public boolean performFinish() {
		try {
			File openFile = null;
			if (getModel().getSelectedOption().equals(IMPORT_OPTION)) {
				project = dsModel.getDataServiceSaveLocation().getProject();
				// gets the import file from the file location
				File importFile = dsModel.getImportFile();
				// gets the imported file from workspace location
				openFile = getImportFileFromWorkspace(project, importFile);

				 /*FIXME When importing an already included .dbs then the
				 project wizard is not getting closed*/
				if (openFile.exists()) {
					if (!MessageDialog.openQuestion(getShell(), "WARNING",
							"Do you like to override exsiting dataservice in the workspace")) {
						return false;
					}
				}
				FileUtils.copy(importFile, openFile);
			}

			if (getModel().getSelectedOption().equals(NEW_OPTION)) {
				project = dsModel.getDataServiceSaveLocation().getProject();
				openFile = addDSTemplate(project);
			}

			getModel().addToWorkingSet(project);
			File mavenProjectPomLocation = project.getFile(POM_FILE).getLocation().toFile();
			updatePom(openFile, mavenProjectPomLocation);

			String groupId = getMavenGroupId(mavenProjectPomLocation);
			String relativePath = FileUtils.getRelativePath(project.getLocation().toFile(),
					openFile).replaceAll(Pattern.quote(File.separator), "/");

			// adds meta data about the data service
			addMetaData(openFile, groupId, relativePath);

			try {
				refreshDistProjects();
				IFile dbsFile = ResourcesPlugin.getWorkspace().getRoot()
						.getFileForLocation(Path.fromOSString(openFile.getAbsolutePath()));
				IDE.openEditor(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
						dbsFile);
			} catch (Exception e) {
				log.error("Cannot open file in editor", e);
			}
		} catch (CoreException e) {
			log.error("CoreException has occurred", e);
		} catch (Exception e) {
			log.error("An unexpected error has occurred", e);
		}

		return true;
	}

	/**
	 * Adds meta data
	 * 
	 * @param openFile
	 *            data service file
	 * @param groupId
	 *            group ID
	 * @param relativePath
	 *            relative path
	 * @throws FactoryConfigurationError
	 * @throws Exception
	 * @throws CoreException
	 */
	private void addMetaData(File openFile, String groupId, String relativePath)
			throws FactoryConfigurationError, Exception, CoreException {
		dssProjectArtifact = new DSSProjectArtifact();
		dssProjectArtifact.fromFile(project.getFile(ARTIFACT_FILE).getLocation().toFile());

		String servieName = FilenameUtils.removeExtension(openFile.getName());
		dssProjectArtifact
				.addDSSArtifact(createArtifact(servieName, groupId, version, relativePath));
		dssProjectArtifact.toFile();
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
	}

	/**
	 * Updates the pom file
	 * 
	 * @param openFile
	 *            current .dbs file
	 * @throws Exception
	 */
	public void updatePom(File openFile, File mavenProjectPomLocation) throws Exception {
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);

		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID,
				MavenConstants.MAVEN_DATASERVICE_PLUGIN_VERSION);

		Plugin pluginEntry = null;

		if (!pluginExists) {
			pluginEntry = MavenUtils.createPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID,
					MavenConstants.MAVEN_DATASERVICE_PLUGIN_VERSION, true);
		} else {
			pluginEntry = getExistingPlugin(mavenProject, GROUP_ID, ARTIFACT_ID,
					MavenConstants.MAVEN_DATASERVICE_PLUGIN_VERSION);
		}

		if (getDBSFile() != null) {
			String fileName = FileUtils.getRelativePath(project.getLocation().toFile(), openFile)
					.replaceAll(Pattern.quote(File.separator), "/");

			Xpp3Dom existingArtifactNode = ((Xpp3Dom) pluginEntry.getConfiguration())
					.getChild(ARTIFACT_TAG);

			if (existingArtifactNode != null) {
				Xpp3Dom newArtifactTag = new Xpp3Dom(ARTIFACT_TAG);
				((Xpp3Dom) pluginEntry.getConfiguration()).addChild(newArtifactTag);
				newArtifactTag.setValue(fileName);
			} else {

				Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode(pluginEntry);
				Xpp3Dom artifactNode = MavenUtils.createXpp3Node(configurationNode, ARTIFACT_TAG);
				artifactNode.setValue(fileName);
			}

		}
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	/**
	 * Gets the dss plugin if it is already available
	 * 
	 * @param project
	 *            maven project
	 * @param groupId
	 *            group ID
	 * @param artifactId
	 *            artufact ID
	 * @param version
	 *            version
	 * @return dss plugin
	 */
	private Plugin getExistingPlugin(MavenProject project, String groupId, String artifactId,
			String version) {
		List<Plugin> plugins = project.getBuild().getPlugins();
		Iterator<Plugin> iterator = plugins.iterator();
		Plugin dssPlugin = null;
		while (iterator.hasNext()) {
			Plugin plugin = iterator.next();
			if (plugin.getGroupId().equals(groupId) && plugin.getArtifactId().equals(artifactId)) {
				dssPlugin = plugin;
			}
		}
		return dssPlugin;
	}

	/**
	 * Gets the .dbs file
	 * 
	 * @return data service resource file
	 * @throws CoreException
	 */
	private IFile getDBSFile() throws CoreException {
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		FileExtensionResourcevisitor fileExtensionResourceVisitor = new FileExtensionResourcevisitor(
				DBS_EXTENSION, IResource.FILE);
		project.accept(fileExtensionResourceVisitor);
		List<IResource> resources = fileExtensionResourceVisitor.getResourceList();
		return resources.size() == 0 ? null : (IFile) resources.get(0);
	}

	/**
	 * Adds import file to the workspace project
	 * 
	 * @param importProject
	 *            project
	 * @param importFile
	 *            import .dbs
	 * @return new .dbs file
	 * @throws IOException
	 */
	public File getImportFileFromWorkspace(IProject importProject, File importFile)
			throws IOException {

		IFolder dsResourceFolder = ProjectUtils.getWorkspaceFolder(importProject,
				DataServiceArtifactConstants.DS_PROJECT_SOURCE_FOLDER,
				DataServiceArtifactConstants.DS_PROJECT_MAIN_FOLDER,
				DataServiceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER);
		File dsResourceFile = new File(dsResourceFolder.getLocation().toFile(),
				importFile.getName());
		return dsResourceFile;
	}

	/**
	 * Creates artifact
	 * 
	 * @param name
	 *            artifact name
	 * @param groupId
	 *            group ID
	 * @param version
	 *            version
	 * @param path
	 *            path
	 * @return artifact
	 */
	private DSSArtifact createArtifact(String name, String groupId, String version, String path) {
		DSSArtifact artifact = new DSSArtifact();
		artifact.setName(name);
		artifact.setVersion(version);
		artifact.setType("service/dataservice");
		artifact.setServerRole("DataServicesServer");
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}

	/**
	 * Adds the DSS template
	 * 
	 * @param project
	 *            current project
	 * @return file
	 * @throws Exception
	 */
	private File addDSTemplate(IProject project) throws Exception {
		String eol = System.getProperty(LINE_SEPERATOR);
		ITemporaryFileTag dsTempTag = FileUtils.createNewTempTag();
		StringBuffer sb = new StringBuffer();
		File dsTemplateFile = new DataServiceTemplateUtils()
				.getResourceFile(DATASERVICE_TEMPLATE);
		String templateContent = FileUtils.getContentAsString(dsTemplateFile);
		templateContent = templateContent.replaceAll("\\{", "<");
		templateContent = templateContent.replaceAll("\\}", ">");
		templateContent = templateContent.replaceAll("<service.name>", dsModel.getServiceName());
		templateContent = templateContent.replaceAll("<service.group>", dsModel.getServiceGroup());
		templateContent = templateContent.replaceAll("<service.NS>", dsModel.getServiceNS());
		templateContent = templateContent.replaceAll("<service.description>",
				dsModel.getServiceDescription());
		templateContent = templateContent.replaceAll("<config.id>", dsModel.getDataSourceId());
		templateContent = templateContent.replaceAll("<service.policykey>", dsModel.getSecPolicy());

		LinkedHashMap<String, String> config = dsModel.getDataSourceConfig().getConfig();
		Iterator<String> iterator = config.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			sb.append("<property name=\"").append(key).append("\">").append(config.get(key))
					.append("</property>\n");
		}
		templateContent = templateContent.replaceAll("<config.properties>", sb.toString());

		IFolder dsfolder = project.getFolder("src/main/dataservice");
		File template = new File(dsfolder.getLocation().toFile(), dsModel.getServiceName() + ".dbs");
		templateContent = XMLUtil.prettify(templateContent);
		templateContent = templateContent.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "");
		templateContent = templateContent.replaceAll("^" + eol, "");
		FileUtils.createFile(template, templateContent);
		dsTempTag.clearAndEnd();
		return template;
	}

	public IResource getCreatedResource() {
		return project;
	}

	public void addPages() {
		newDataSourcepage = new NewDataSourceWizardPage();
		super.addPages();
		addPage(newDataSourcepage);
		pages = getPages();
	}

	public IWizardPage getNextPage(IWizardPage page) {
		IWizardPage nextPage = super.getNextPage(page);
		if (page instanceof ProjectOptionsDataPage) {
			if (getModel().getSelectedOption().equalsIgnoreCase(NEW_OPTION)) {
				nextPage = newDataSourcepage;
			} else {
				nextPage = null;
			}
		}
		if (page instanceof NewDataSourceWizardPage) {
			nextPage = null;

		}
		return nextPage;
	}

	public IWizardPage getPreviousPage(IWizardPage page) {
		IWizardPage previousPage = super.getNextPage(page);
		if (page instanceof MavenDetailsPage) {
			if (getModel().getSelectedOption().equalsIgnoreCase(NEW_OPTION)) {
				previousPage = newDataSourcepage;
			}
		}
		if (page instanceof NewDataSourceWizardPage) {
			previousPage = pages[1];
		}
		return previousPage;
	}

	public boolean canFinish() {
		if (getContainer().getCurrentPage() instanceof ProjectOptionsDataPage) {
			if (getModel().getSelectedOption().equalsIgnoreCase("new.dsproject")) {
				return false;
			} else {
				return dsModel.getImportFile().exists();
			}
		} else if (getContainer().getCurrentPage() instanceof NewDataSourceWizardPage) {
			return true;
		}
		return super.canFinish();
	}

}
