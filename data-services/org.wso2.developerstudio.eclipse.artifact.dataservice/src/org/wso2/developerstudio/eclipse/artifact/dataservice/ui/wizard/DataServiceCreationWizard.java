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
import org.apache.maven.model.PluginExecution;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.artifact.dataservice.Activator;
import org.wso2.developerstudio.eclipse.artifact.dataservice.artifact.DSSArtifact;
import org.wso2.developerstudio.eclipse.artifact.dataservice.artifact.DSSProjectArtifact;
import org.wso2.developerstudio.eclipse.artifact.dataservice.model.DataServiceModel;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceArtifactConstants;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceImageUtils;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceTemplateUtils;
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

	private static final String DS_PROJECT_NATURE = "org.wso2.developerstudio.eclipse.ds.project.nature";
	private static final String IMPORT_OPTION = "import.ds";
	private static final String NEW_OPTION = "new.ds";
	private static final String POM_FILE = "pom.xml";
	private static final String GROUP_ID = "org.wso2.maven";
	private static final String ARTIFACT_ID = "maven-dataservice-plugin";
	private static final String ARTIFACT_FILE = "artifact.xml";
	private static final String DBS_EXTENSION = ".dbs";
	private static final String TYPE = "service/dataservice";
	private static final String SERVER_ROLE = "DataServicesServer";
	private static final String LINE_SEPERATOR = "line.separator";
	private static final String DATASERVICE_TEMPLATE = "templates/Dataservice1.dbs";
	private String version = "1.0.0";

	private final DataServiceModel dsModel;
	private DSSProjectArtifact dssProjectArtifact;
	private IProject project;
	private NewDataSourceWizardPage newDataSourcepage;
	private IWizardPage[] pages;

	public DataServiceCreationWizard() {
		this.dsModel = new DataServiceModel();
		setModel(this.dsModel);
		setWindowTitle(DataServiceArtifactConstants.DS_WIZARD_WINDOW_TITLE);
		setDefaultPageImageDescriptor(DataServiceImageUtils.getInstance().getImageDescriptor("ds-wizard.png"));
	}

	public boolean performFinish() {
		try {
			File openFile = null;
			if (getModel().getSelectedOption().equals(IMPORT_OPTION)) {
				if (dsModel.getDataServiceSaveLocation() != null) {
					project = dsModel.getDataServiceSaveLocation().getProject();
				} else {
					project = createNewProject();
					createDSSProjectStructure(project);
				}
				// gets the import file from the file location
				File importFile = dsModel.getImportFile();
				// gets the imported file from workspace location
				openFile = saveImportFileToWorkspace(project, importFile);
				/*
				 * FIXME When importing an already included .dbs then the
				 * project wizard is not getting closed
				 */
				if (openFile.exists()) {
					if (!MessageDialog
							.openQuestion(getShell(), "WARNING", DataServiceArtifactConstants.WARNING_MESSAGE)) {
						return true;
					}
				}
				FileUtils.copy(importFile, openFile);
			}

			if (getModel().getSelectedOption().equals(NEW_OPTION)) {
				if (dsModel.getDataServiceSaveLocation() != null) {

					if (dsModel.getDataServiceSaveLocation().getProject().getLocation() != null) {
						project = dsModel.getDataServiceSaveLocation().getProject();
					} else {
						project = createNewDSSProject(dsModel.getDataServiceSaveLocation().getProject().getName());
						createDSSProjectStructure(project);
					}
				}

				openFile = addDSTemplate(project);
			}

			getModel().addToWorkingSet(project);
			File mavenProjectPom = project.getFile(POM_FILE).getLocation().toFile();
			updateDSSPlugin(openFile, mavenProjectPom);
			String groupId = getMavenGroupId(mavenProjectPom)+ ".dataservice";
			String relativePath = FileUtils.getRelativePath(project.getLocation().toFile(), openFile).replaceAll(
					Pattern.quote(File.separator), "/");

			// adds meta data about the data service
			addMetaData(openFile, groupId, relativePath);
			try {
				refreshDistProjects();
				IFile dbsFile = ResourcesPlugin.getWorkspace().getRoot()
						.getFileForLocation(Path.fromOSString(openFile.getAbsolutePath()));
				IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), dbsFile);
			} catch (Exception e) {
				log.error(DataServiceArtifactConstants.ERROR_MESSAGE_FILE_OPEN, e);
			}
		} catch (CoreException e) {
			log.error(DataServiceArtifactConstants.ERROR_MESSAGE_CORE_EXCEPTION, e);
		} catch (Exception e) {
			log.error(DataServiceArtifactConstants.ERROR_MESSAGE_UNEXPECTED_ERROR, e);
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
	private void addMetaData(File openFile, String groupId, String relativePath) throws FactoryConfigurationError,
			Exception, CoreException {
		dssProjectArtifact = new DSSProjectArtifact();
		dssProjectArtifact.fromFile(project.getFile(ARTIFACT_FILE).getLocation().toFile());

		String servieName = FilenameUtils.removeExtension(openFile.getName());
		dssProjectArtifact.addDSSArtifact(createArtifact(servieName, groupId, version, relativePath));
		dssProjectArtifact.toFile();
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
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
		artifact.setType(TYPE);
		artifact.setServerRole(SERVER_ROLE);
		artifact.setGroupId(groupId);
		artifact.setFile(path);
		return artifact;
	}

	/**
	 * Updates the pom file
	 * 
	 * @param openFile
	 *            current .dbs file
	 * @throws Exception
	 */
	public void updateDSSPlugin(File openFile, File mavenProjectPom) throws IOException, XmlPullParserException {
		MavenProject mavenProject = MavenUtils.getMavenProject(mavenProjectPom);

		// Skip changing the pom file if group ID and artifact ID are matched
		if (MavenUtils.checkOldPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID)) {
			return;
		}

		Plugin pluginEntry = MavenUtils.createPluginEntry(mavenProject, GROUP_ID, ARTIFACT_ID,
				MavenConstants.MAVEN_DATASERVICE_PLUGIN_VERSION, true);
		PluginExecution pluginExecution = new PluginExecution();
		pluginExecution.addGoal("pom-gen");
		pluginExecution.setPhase("process-resources");
		pluginExecution.setId("dataservice");

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode, "artifactLocation");
		artifactLocationNode.setValue(".");
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, "typeList");
		typeListNode.setValue("${artifact.types}");
		pluginExecution.setConfiguration(configurationNode);
		pluginEntry.addExecution(pluginExecution);
		MavenUtils.saveMavenProject(mavenProject, mavenProjectPom);
	}

	/**
	 * Creates a new DSS project
	 * 
	 * @param projectName
	 *            project name
	 * @return project
	 */
	private IProject createNewDSSProject(String projectName) {
		String name = projectName;
		IProgressMonitor progressMonitor = new NullProgressMonitor();
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = root.getProject(name);

		try {
			project.create(progressMonitor);
			project.open(progressMonitor);
		} catch (CoreException e) {
			log.error(DataServiceArtifactConstants.ERROR_MESSAGE_CORE_EXCEPTION, e);
		}

		return project;
	}

	/**
	 * Gets the .dbs file
	 * 
	 * @return data service resource file
	 * @throws CoreException
	 */
	private IFile getDBSFile() throws CoreException {
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		FileExtensionResourcevisitor fileExtensionResourceVisitor = new FileExtensionResourcevisitor(DBS_EXTENSION,
				IResource.FILE);
		project.accept(fileExtensionResourceVisitor);
		List<IResource> resources = fileExtensionResourceVisitor.getResourceList();
		return resources.size() == 0 ? null : (IFile) resources.get(0);
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
	private Plugin getExistingPlugin(MavenProject project, String groupId, String artifactId, String version) {
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
	 * Adds import file to the workspace project
	 * 
	 * @param importProject
	 *            project
	 * @param importFile
	 *            import .dbs
	 * @return new .dbs file
	 * @throws IOException
	 */
	public File saveImportFileToWorkspace(IProject importProject, File importFile) throws IOException {

		IFolder dsResourceFolder = ProjectUtils.getWorkspaceFolder(importProject,
				DataServiceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER);
		File dsResourceFile = new File(dsResourceFolder.getLocation().toFile(), importFile.getName());
		return dsResourceFile;
	}

	/**
	 * Creates a new DSS project
	 * 
	 * @return
	 */
	private void createDSSProjectStructure(IProject project) {
		try {
			// createDSSProjectStructure(project);
			IFolder dsfolder = ProjectUtils.getWorkspaceFolder(project,
					DataServiceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER);
			if (!dsfolder.exists()) {
				// creates the template
				ProjectUtils.createFolder(dsfolder);
			}
			File pomfile = project.getFile(POM_FILE).getLocation().toFile();
			getModel().getMavenInfo().setPackageName(TYPE);
			// creates the pom file
			createPOM(pomfile);
			// updates pom file with data service plugin
			// updatePOMWithDSSPlugin(pomfile);

			ProjectUtils.addNatureToProject(project, false, DS_PROJECT_NATURE);
			MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {}, new String[] { DS_PROJECT_NATURE });
			getModel().addToWorkingSet(project);
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

			// creates the artifact.xml file
			createArtifactXMLFile();
		} catch (CoreException e) {
			log.error(DataServiceArtifactConstants.ERROR_MESSAGE_CORE_EXCEPTION, e);
		} catch (Exception e) {
			log.error(DataServiceArtifactConstants.ERROR_MESSAGE_UNEXPECTED_ERROR, e);
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

	/**
	 * Updates the pom file
	 * 
	 * @param openFile
	 *            current .dbs file
	 * @throws Exception
	 */
	public void updatePOMWithDSSPlugin(File mavenProjectPomLocation) throws Exception {
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
	 * Copies the import file
	 * 
	 * @param importProject
	 *            project
	 * @return .dbs file
	 * @throws IOException
	 */
	public File copyImportFile(IProject importProject) throws IOException {
		File importFile = getModel().getImportFile();
		IFolder dsResourceFolder = ProjectUtils.getWorkspaceFolder(importProject,
				DataServiceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER);
		File dsResourceFile = new File(dsResourceFolder.getLocation().toFile(), importFile.getName());
		FileUtils.copy(importFile, dsResourceFile);
		return dsResourceFile;
	}

	/**
	 * Adds the template
	 * 
	 * @param project
	 *            project
	 * @return .dbs file
	 * @throws Exception
	 */
	private File addDSTemplate(IProject project) throws Exception {
		String eol = System.getProperty(LINE_SEPERATOR);
		ITemporaryFileTag dsTempTag = FileUtils.createNewTempTag();
		StringBuffer sb = new StringBuffer();
		File dsTemplateFile = new DataServiceTemplateUtils().getResourceFile(DATASERVICE_TEMPLATE);
		String templateContent = FileUtils.getContentAsString(dsTemplateFile);
		templateContent = templateContent.replaceAll("\\{", "<");
		templateContent = templateContent.replaceAll("\\}", ">");
		templateContent = templateContent.replaceAll("<service.name>", dsModel.getServiceName());
		templateContent = templateContent.replaceAll("<service.group>", dsModel.getServiceGroup());
		templateContent = templateContent.replaceAll("<service.NS>", dsModel.getServiceNS());
		templateContent = templateContent.replaceAll("<service.description>", dsModel.getServiceDescription());
		templateContent = templateContent.replaceAll("<config.id>", dsModel.getDataSourceId());
		LinkedHashMap<String, String> config = dsModel.getDataSourceConfig().getConfig();
		Iterator<String> iterator = config.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			sb.append("<property name=\"").append(key).append("\">").append(config.get(key)).append("</property>\n");
		}
		templateContent = templateContent.replaceAll("<config.properties>", sb.toString());

		IFolder dsfolder = project.getFolder(DataServiceArtifactConstants.DS_PROJECT_DATASERVICE_FOLDER);
		File template = new File(dsfolder.getLocation().toFile(), dsModel.getServiceName() + DBS_EXTENSION);
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

	protected boolean isRequireProjectLocationSection() {
		return false;
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
			if (getModel().getSelectedOption().equalsIgnoreCase(NEW_OPTION)) {
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
