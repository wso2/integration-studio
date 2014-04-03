/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package dataMapper.diagram.custom.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.capp.maven.utils.MavenConstants;
import org.wso2.developerstudio.eclipse.esb.core.utils.EsbTemplateFormatter;
import org.wso2.developerstudio.eclipse.esb.impl.MediatorImpl;
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.general.project.utils.GeneralProjectUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceInfo;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceInfoDoc;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceUtils;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplateHandler;

import dataMapper.diagram.custom.action.Messages;

import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.visualdatamapper.diagram.Activator;

public class CreateNewConfigurationDialog extends Dialog {

	private Text txtResourceName;
	private Text txtRegistryPath;
	private ArtifactTemplate[] artifactTemplates;
	private String selectedPath;
	private String ipathOfSelection;
	private Map<String, java.util.List<String>> filters;
	private Combo cmbProject;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String REPO_ID_1 = "wso2-nexus-maven2-repository-1"; //$NON-NLS-1$
	private static final String REPO_URL_1 = "http://maven.wso2.org/nexus/content/groups/wso2-public/"; //$NON-NLS-1$
	private static final String REPO_ID = "wso2-maven2-repository-1"; //$NON-NLS-1$
	private static final String REPO_URL = "http://dist.wso2.org/maven2"; //$NON-NLS-1$
	private static final String ARTIFACT_TYPES = "${artifact.types}"; //$NON-NLS-1$
	private static final String TYPE_LIST = "typeList"; //$NON-NLS-1$
	private static final String ARTIFACT_LOCATION = "artifactLocation"; //$NON-NLS-1$
	private static final String REGISTRY = "registry"; //$NON-NLS-1$
	private static final String PROCESS_RESOURCES = "process-resources"; //$NON-NLS-1$
	private static final String POM_GEN = "pom-gen"; //$NON-NLS-1$
	private static final String MAVEN_ARTIFACT_ID = "wso2-general-project-plugin"; //$NON-NLS-1$
	private static final String MAVEN_GROUP_ID = "org.wso2.maven"; //$NON-NLS-1$
	private static final String POM_PACKAGING_TYPE = "pom"; //$NON-NLS-1$
	private static final String SERVER_ROLE = "EnterpriseServiceBus"; //$NON-NLS-1$
	private static final String ARTIFACT_TYPE = "registry/resource"; //$NON-NLS-1$
	private static final String ARTIFACT_VERSION = "1.0.0"; //$NON-NLS-1$
	private static final String ARTIFACT_FILE = "artifact.xml"; //$NON-NLS-1$
	private static final String GROUP_ID_RESOURCE = ".resource"; //$NON-NLS-1$
	private static final String POM_FILE = "pom.xml"; //$NON-NLS-1$
	private static final String ERROR_READING_POM_FILE = "error reading pom file"; //$NON-NLS-1$
	private static final String GROUP_ID = "org.wso2.carbon"; //$NON-NLS-1$
	private static final int DIALOG_INITIAL_SIZE_Y = 280;
	private static final int DIALOG_INITIAL_SIZE_X = 400;
	private static final int REGISTRY_RESOURCE = 0;
	private static final String DATA_MAPPER_TEMPLATE_STRING = "/* WSO2 Data Mapper Config */"; //$NON-NLS-1$
	private static final String DEFAULT_REGISTRY_PATH = "/_system/governance/datamapper"; //$NON-NLS-1$
	private static final String INPUT_AVROSCHEMA = "_inputSchema.avsc";
	private static final String OUTPUT_AVROSCHEMA = "_outputSchema.avsc";

	private static final String DIALOG_MESSAGE = Messages.CreateNewConfigurationDialog_DialogMessage;
	private static final String DIALOG_HEADER_TEMPLATE_CREATION = Messages.CreateNewConfigurationDialog_DialogHeaderTemplateCreation;
	private static final String DIALOG_HEADER_RESOURCE_CREATION = Messages.CreateNewConfigurationDialog_DialogHeaderResourceCreation;
	private static final String DIALOG_HEADER_LOADING_CAPP_PROJECTS = Messages.CreateNewConfigurationDialog_DialogHeaderLoadingCAppProjects;
	private static final String TXT_REGISTRY_PATH = Messages.CreateNewConfigurationDialog_TxtRegistryPath;
	private static final String DEFAULT_CONFIG_NAME = Messages.CreateNewConfigurationDialog_DefaultConfigName;
	private static final String TXT_FILE_NAME = Messages.CreateNewConfigurationDialog_TxtFileName;
	private static final String LINK_CREATE_NEW_PROJECT = Messages.CreateNewConfigurationDialog_LinkCreateNewProject;
	private static final String TXT_PROJECT = Messages.CreateNewConfigurationDialog_TxtProject;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public CreateNewConfigurationDialog(Shell parentShell,
			Map<String, java.util.List<String>> filters) {
		super(parentShell);
		setFilters(filters);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FormLayout());

		Label lblProject = new Label(container, SWT.NONE);
		FormData fd_lblProject = new FormData();
		fd_lblProject.top = new FormAttachment(0, 31);
		fd_lblProject.left = new FormAttachment(0, 10);
		lblProject.setLayoutData(fd_lblProject);
		lblProject.setText(TXT_PROJECT);

		cmbProject = new Combo(container, SWT.READ_ONLY);
		cmbProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				validate();
			}
		});
		FormData fd_cmbProject = new FormData();
		fd_cmbProject.left = new FormAttachment(lblProject, 70);
		fd_cmbProject.top = new FormAttachment(lblProject, -5, SWT.TOP);
		cmbProject.setLayoutData(fd_cmbProject);

		Link linkButton = new Link(container, SWT.NULL);
		linkButton.setText(LINK_CREATE_NEW_PROJECT);

		FormData fd_linkButton = new FormData();
		fd_linkButton.left = new FormAttachment(lblProject, 70);
		fd_linkButton.top = new FormAttachment(cmbProject, 40, SWT.TOP);
		linkButton.setLayoutData(fd_linkButton);
		linkButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Shell shell = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell();
				IProject generalProject = GeneralProjectUtils
						.createGeneralProject(shell);
				if (generalProject != null) {
					cmbProject.add(generalProject.getName());
					if (cmbProject.getItems().length > 0) {
						cmbProject.select(cmbProject.getItems().length - 1);
					}
				}
			}
		});
		Label lblArtifactName = new Label(container, SWT.NONE);
		FormData fd_lblArtifactName = new FormData();
		fd_lblArtifactName.top = new FormAttachment(linkButton, 22);
		fd_lblArtifactName.left = new FormAttachment(0, 10);
		lblArtifactName.setLayoutData(fd_lblArtifactName);
		lblArtifactName.setText(TXT_FILE_NAME);

		txtResourceName = new Text(container, SWT.BORDER);
		txtResourceName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				validate();
			}
		});
		txtResourceName.setText(DEFAULT_CONFIG_NAME);
		FormData fd_txtResourceName = new FormData();
		fd_txtResourceName.top = new FormAttachment(lblArtifactName, -5,
				SWT.TOP);
		fd_txtResourceName.right = new FormAttachment(cmbProject, 0, SWT.RIGHT);
		fd_txtResourceName.left = new FormAttachment(lblArtifactName, 52);
		txtResourceName.setLayoutData(fd_txtResourceName);

		Label lblRegistryPath = new Label(container, SWT.NONE);
		FormData fd_lblRegistryPath = new FormData();
		fd_lblRegistryPath.top = new FormAttachment(txtResourceName, 17);
		fd_lblRegistryPath.left = new FormAttachment(lblProject, 0, SWT.LEFT);
		lblRegistryPath.setLayoutData(fd_lblRegistryPath);
		lblRegistryPath.setText(TXT_REGISTRY_PATH);

		txtRegistryPath = new Text(container, SWT.BORDER);
		txtRegistryPath.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				validate();
			}
		});
		txtRegistryPath.setText(DEFAULT_REGISTRY_PATH);
		FormData fd_txtRegistryPath = new FormData();
		fd_txtRegistryPath.top = new FormAttachment(lblRegistryPath, -5,
				SWT.TOP);
		fd_txtRegistryPath.left = new FormAttachment(lblRegistryPath, 30);
		fd_txtRegistryPath.right = new FormAttachment(cmbProject, 0, SWT.RIGHT);
		txtRegistryPath.setLayoutData(fd_txtRegistryPath);

		Label label = new Label(container, SWT.VERTICAL);
		fd_cmbProject.right = new FormAttachment(label, 130);
		FormData fd_label = new FormData();
		fd_label.left = new FormAttachment(0, 250);
		fd_label.top = new FormAttachment(0, 10);
		fd_label.bottom = new FormAttachment(0, 198);
		label.setLayoutData(fd_label);

		loadCAppProjects();
		loadTemplateList();
		return container;
	}

	private void loadCAppProjects() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot()
				.getProjects();
		cmbProject.removeAll();
		for (IProject project : projects) {
			try {
				if (project.isOpen()
						&& project.hasNature(Messages.GENERAL_PROJECT_NATURE)) {
					cmbProject.add(project.getName());
				}
			} catch (Exception e) {
				log.error(e);
				MessageDialog.openError(getShell(),
						DIALOG_HEADER_LOADING_CAPP_PROJECTS, e.getMessage());
			}
		}
		if (cmbProject.getItemCount() > 0) {
			cmbProject.select(0);
		}
	}

	private void validate() {
		Button okButton = getButton(IDialogConstants.OK_ID);
		boolean okButtonState = true;
		if (cmbProject.getText() == null || cmbProject.getText().equals("") //$NON-NLS-1$
				|| txtResourceName.getText().trim().equals("") //$NON-NLS-1$
				|| txtRegistryPath.getText().trim().equals("")) { //$NON-NLS-1$
			okButtonState = false;
		}
		if (okButton != null) {
			okButton.setEnabled(okButtonState);
		}
	}

	private void updateResourceFileName() {
		String resourceName = txtResourceName.getText();
		String resourceFileName = FileUtils.getResourceFileName(resourceName);
		String selectedTemplateExtension = getSelectedTemplateExtension();
		if (selectedTemplateExtension == null) {
			txtResourceName.setText(resourceFileName);
		} else {
			txtResourceName.setText(resourceFileName
					+ "." + selectedTemplateExtension); //$NON-NLS-1$
		}
	}

	private String getSelectedTemplateExtension() {
		return artifactTemplates[0].getDefaultExtension();
	}

	private void loadTemplateList() {
		artifactTemplates = ArtifactTemplateHandler
				.getArtifactTemplates(getFilters());

		updateResourceFileName();
	}

	@Override
	protected void okPressed() {
		try {
			String templateString;
			templateString = DATA_MAPPER_TEMPLATE_STRING;
			String name = txtResourceName.getText();

			String content = EsbTemplateFormatter.stripParameters(
					templateString, name);
			ITemporaryFileTag createNewTempTag = FileUtils.createNewTempTag();
			File tempFile = new File(FileUtils.createTempDirectory(), name);
			tempFile.getParentFile().mkdirs();
			FileUtils.writeContent(tempFile, content);

			String projectName = cmbProject.getText();
			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName);
			String path = txtRegistryPath.getText();

			boolean configFileCreationSucess = createRegistryArtifact(project,
					name, path, content);

			createRegistryResourcesForInputScemaAndOutputSchema(name, project,
					path);

			if (!configFileCreationSucess) {
				MessageDialog.openInformation(getShell(),
						DIALOG_HEADER_RESOURCE_CREATION,
						String.format(DIALOG_MESSAGE, name, projectName));
				return;
			}

			String configPath = path.endsWith("/") ? path + name : path + "/" + name; //$NON-NLS-1$ //$NON-NLS-2$

			setSelectedPath(configPath);
			setIPathOfSelection(project.getFullPath().append(name).toString());

			createNewTempTag.clearAndEnd();
		} catch (IOException e) {
			log.error(e);
			MessageDialog.openError(getShell(),
					DIALOG_HEADER_TEMPLATE_CREATION, e.getMessage());
			return;
		} catch (CoreException e) {
			log.error(e);
			MessageDialog.openError(getShell(),
					DIALOG_HEADER_RESOURCE_CREATION, e.getMessage());
			return;
		} catch (Exception e) {
			log.error(e);
			MessageDialog.openError(getShell(),
					DIALOG_HEADER_RESOURCE_CREATION, e.getMessage());
			return;
		}
		super.okPressed();
	}

	public static void createRegistryResourcesForInputScemaAndOutputSchema(
			String name, IProject project, String path) throws Exception {
		String inputAvroSchemaName = name.replace(".dmc", INPUT_AVROSCHEMA);
		String outputAvroSchemaName = name.replace(".dmc", OUTPUT_AVROSCHEMA);
		createRegistryArtifact(project, inputAvroSchemaName, path, "");
		createRegistryArtifact(project, outputAvroSchemaName, path, "");
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
		validate();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(DIALOG_INITIAL_SIZE_X, DIALOG_INITIAL_SIZE_Y);
	}

	public void setSelectedPath(String selectedPath) {
		this.selectedPath = selectedPath;
	}

	public String getSelectedPath() {
		return selectedPath;
	}

	public void setFilters(Map<String, java.util.List<String>> filters) {
		this.filters = filters;
	}

	public Map<String, java.util.List<String>> getFilters() {
		return filters;
	}

	private static String getMavenGroupId(File pomLocation) {
		String groupId = GROUP_ID;
		if (pomLocation != null && pomLocation.exists()) {
			try {
				MavenProject mavenProject = MavenUtils
						.getMavenProject(pomLocation);
				groupId = mavenProject.getGroupId();
			} catch (Exception e) {
				log.error(ERROR_READING_POM_FILE, e);
			}
		}
		return groupId;
	}

	private static boolean createRegistryArtifact(IProject project,
			String fileName, String registryPath, String content)
			throws Exception {
		File destFile = project.getFile(fileName).getLocation().toFile();
		String resourceName = FileUtils.getResourceFileName(fileName);
		if (destFile.exists()) {
			return false;
		}

		String groupId = getMavenGroupId(project.getFile(POM_FILE)
				.getLocation().toFile());
		groupId += GROUP_ID_RESOURCE;

		FileUtils.createFile(destFile, content);

		RegistryResourceInfoDoc regResInfoDoc = new RegistryResourceInfoDoc();

		RegistryResourceUtils.createMetaDataForFolder(registryPath, project
				.getLocation().toFile());
		RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc,
				project.getLocation().toFile(), registryPath);

		GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
		generalProjectArtifact.fromFile(project.getFile(ARTIFACT_FILE)
				.getLocation().toFile());

		RegistryArtifact artifact = new RegistryArtifact();
		artifact.setName(resourceName);
		artifact.setVersion(ARTIFACT_VERSION);
		artifact.setType(ARTIFACT_TYPE);
		artifact.setServerRole(SERVER_ROLE);
		artifact.setGroupId(groupId);
		java.util.List<RegistryResourceInfo> registryResources = regResInfoDoc
				.getRegistryResources();
		for (RegistryResourceInfo registryResourceInfo : registryResources) {
			RegistryElement item = null;
			if (registryResourceInfo.getType() == REGISTRY_RESOURCE) { //$NON-NLS-1$
				item = new RegistryItem();
				((RegistryItem) item).setFile(registryResourceInfo
						.getResourceBaseRelativePath());
				item.setPath(registryResourceInfo.getDeployPath().replaceAll(
						"/$", "")); //$NON-NLS-1$ //$NON-NLS-2$
				artifact.addRegistryElement(item);
				((RegistryItem) item).setMediaType("text/plain");
			}
		}
		generalProjectArtifact.addArtifact(artifact);
		generalProjectArtifact.toFile();
		addGeneralProjectPlugin(project);
		project.refreshLocal(IResource.DEPTH_INFINITE,
				new NullProgressMonitor());
		return true;
	}

	private static void addGeneralProjectPlugin(IProject project)
			throws Exception {
		MavenProject mavenProject;

		File mavenProjectPomLocation = project.getFile(POM_FILE).getLocation()
				.toFile();
		if (!mavenProjectPomLocation.exists()) {
			mavenProject = MavenUtils.createMavenProject(GROUP_ID,
					project.getName(), ARTIFACT_VERSION, POM_PACKAGING_TYPE);
		} else {
			mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		}

		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject,
				MAVEN_GROUP_ID, MAVEN_ARTIFACT_ID,
				MavenConstants.WSO2_GENERAL_PROJECT_VERSION);
		if (pluginExists) {
			return;
		}

		mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		Plugin plugin = MavenUtils.createPluginEntry(mavenProject,
				MAVEN_GROUP_ID, MAVEN_ARTIFACT_ID,
				MavenConstants.WSO2_GENERAL_PROJECT_VERSION, true);

		PluginExecution pluginExecution;

		pluginExecution = new PluginExecution();
		pluginExecution.addGoal(POM_GEN);
		pluginExecution.setPhase(PROCESS_RESOURCES);
		pluginExecution.setId(REGISTRY);
		plugin.addExecution(pluginExecution);

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(
				configurationNode, ARTIFACT_LOCATION);
		artifactLocationNode.setValue("."); //$NON-NLS-1$
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode,
				TYPE_LIST);
		typeListNode.setValue(ARTIFACT_TYPES);
		pluginExecution.setConfiguration(configurationNode);

		Repository repo = new Repository();
		repo.setUrl(REPO_URL);
		repo.setId(REPO_ID);

		Repository repo1 = new Repository();
		repo1.setUrl(REPO_URL_1);
		repo1.setId(REPO_ID_1);

		if (!mavenProject.getRepositories().contains(repo)) {
			mavenProject.getModel().addRepository(repo);
			mavenProject.getModel().addPluginRepository(repo);
		}

		if (!mavenProject.getRepositories().contains(repo1)) {
			mavenProject.getModel().addRepository(repo1);
			mavenProject.getModel().addPluginRepository(repo1);
		}

		MavenUtils.saveMavenProject(mavenProject, mavenProjectPomLocation);
	}

	public void setIPathOfSelection(String ipath) {
		ipathOfSelection = ipath;
	}

	public String getIPathOfSelection() {
		return ipathOfSelection;
	}

}
