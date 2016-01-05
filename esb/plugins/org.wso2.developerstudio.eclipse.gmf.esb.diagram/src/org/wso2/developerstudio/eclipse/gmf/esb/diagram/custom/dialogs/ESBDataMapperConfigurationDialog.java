package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.dialogs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFile;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
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
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.RegistryArtifact;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryElement;
import org.wso2.developerstudio.eclipse.general.project.artifact.bean.RegistryItem;
import org.wso2.developerstudio.eclipse.general.project.utils.GeneralProjectUtils;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.registry.core.RegistryManager;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.RegistryFileImpl;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioElement;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProvider;
import org.wso2.developerstudio.eclipse.platform.core.interfaces.IDeveloperStudioProviderData;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceInfo;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceInfoDoc;
import org.wso2.developerstudio.eclipse.platform.core.registry.util.RegistryResourceUtils;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplate;
import org.wso2.developerstudio.eclipse.platform.core.templates.ArtifactTemplateHandler;
import org.wso2.developerstudio.eclipse.utils.data.ITemporaryFileTag;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class ESBDataMapperConfigurationDialog extends Dialog {

	private Text textConfigName;
	private Composite compositeNewConfig;
	private Composite compositeUseExisting;
	private Combo comboProject;
	private Combo comboConfiguration;

	private int selectedOption;
	private ArtifactTemplate[] artifactTemplates;
	private Class<?>[] type;
	private Map<String, java.util.List<String>> filters;
	private Map<String, IDeveloperStudioElement> importListMap;
	private String selectedPath;
	private String ipathOfSelection;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String DATAMAPPER_REGISTRY_PATH = "/_system/governance/datamapper"; //$NON-NLS-1$
	private static final String DATA_MAPPER_TEMPLATE_STRING = "/* WSO2 Data Mapper Config */"; //$NON-NLS-1$
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
	private static final String INPUT_AVROSCHEMA = "_inputSchema.avsc"; //$NON-NLS-1$
	private static final String OUTPUT_AVROSCHEMA = "_outputSchema.avsc"; //$NON-NLS-1$
	private static final String DATAMAPPER_CONFIG_EXT = ".dmc"; //$NON-NLS-1$
	private static final String TYPE_TEXT_PLAIN = "text/plain"; //$NON-NLS-1$
	private static final int REGISTRY_RESOURCE = 0;
	private static final int CREATE_NEW_CONFIGURATION_OPTION = 0;
	private static final int USE_EXISTING_OPTION = 1;

	private static final String MSG_LOADING_CAPP_PROJECTS = Messages.DataMapperConfigurationDialog_MsgLoadingCAppProjects;
	private static final String ERROR_LOADING_CAPP_PROJECTS = Messages.DataMapperConfigurationDialog_ErrorLoadingCAppProjects;
	private static final String CONFIGURATION = Messages.DataMapperConfigurationDialog_Configuration;
	private static final String USE_EXISTING = Messages.DataMapperConfigurationDialog_UseExisting;
	private static final String CREATE_NEW_PROJECT = Messages.DataMapperConfigurationDialog_CreateNewProject;
	private static final String SAVE_IN_PROJECT = Messages.DataMapperConfigurationDialog_SaveInProject;
	private static final String CONFIGURATION_NAME = Messages.DataMapperConfigurationDialog_ConfigurationName;
	private static final String CREATE_NEW_CONFIGURATION = Messages.DataMapperConfigurationDialog_CreateNewConfiguration;
	private static final String DIALOG_TITLE = Messages.DataMapperConfigurationDialog_DialogTitle;
	private static final String DEFAULT_CONFIG_NAME = Messages.DataMapperConfigurationDialog_DefaultConfigName;
	private static final String DIALOG_HEADER_RESOURCE_CREATION = Messages.DataMapperConfigurationDialog_DialogHeaderResourceCreation;
	private static final String DIALOG_MESSAGE = Messages.DataMapperConfigurationDialog_DialogMessage;
	private static final String DIALOG_HEADER_TEMPLATE_CREATION = Messages.DataMapperConfigurationDialog_DialogHeaderTemplateCreation;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public ESBDataMapperConfigurationDialog(Shell parentShell, Class<?>[] type,
			Map<String, java.util.List<String>> filters) {
		super(parentShell);
		setShellStyle(SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.OK | SWT.APPLICATION_MODAL);
		setType(type);
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

		getShell().setText(DIALOG_TITLE);

		Button btnCreateNewConfiguration = new Button(container, SWT.RADIO);
		btnCreateNewConfiguration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setEnabled(compositeNewConfig.getChildren(), true);
				setEnabled(compositeUseExisting.getChildren(), false);
				setSelectedOption(CREATE_NEW_CONFIGURATION_OPTION);
				validate();
			}
		});
		btnCreateNewConfiguration.setText(CREATE_NEW_CONFIGURATION);

		compositeNewConfig = new Composite(container, SWT.NONE);
		GridData gd_composite_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_2.widthHint = 582;
		compositeNewConfig.setLayoutData(gd_composite_2);
		compositeNewConfig.setLayout(new GridLayout(5, false));

		Label lblNewLabel = new Label(compositeNewConfig, SWT.NONE);
		lblNewLabel.setText(CONFIGURATION_NAME);
		new Label(compositeNewConfig, SWT.NONE);
		new Label(compositeNewConfig, SWT.NONE);
		new Label(compositeNewConfig, SWT.NONE);

		textConfigName = new Text(compositeNewConfig, SWT.BORDER);
		textConfigName.setText(DEFAULT_CONFIG_NAME);
		textConfigName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				validate();
			}
		});
		textConfigName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_1 = new Label(compositeNewConfig, SWT.NONE);
		lblNewLabel_1.setText(SAVE_IN_PROJECT);
		new Label(compositeNewConfig, SWT.NONE);
		new Label(compositeNewConfig, SWT.NONE);
		new Label(compositeNewConfig, SWT.NONE);

		comboProject = new Combo(compositeNewConfig, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboProject.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				validate();
			}
		});
		comboProject.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(compositeNewConfig, SWT.NONE);
		new Label(compositeNewConfig, SWT.NONE);
		new Label(compositeNewConfig, SWT.NONE);
		new Label(compositeNewConfig, SWT.NONE);

		Link link = new Link(compositeNewConfig, SWT.NONE);
		link.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				IProject generalProject = GeneralProjectUtils.createGeneralProject(shell, null);
				if (generalProject != null) {
					comboProject.add(generalProject.getName());
					if (comboProject.getItems().length > 0) {
						comboProject.select(comboProject.getItems().length - 1);
					}
				}
			}
		});
		link.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		link.setText(CREATE_NEW_PROJECT);

		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gd_label = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_label.widthHint = 583;
		label.setLayoutData(gd_label);

		Button btnUseExistingConfiguration = new Button(container, SWT.RADIO);
		btnUseExistingConfiguration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setEnabled(compositeUseExisting.getChildren(), true);
				setEnabled(compositeNewConfig.getChildren(), false);
				setSelectedOption(USE_EXISTING_OPTION);
				validate();
			}
		});
		btnUseExistingConfiguration.setText(USE_EXISTING);

		compositeUseExisting = new Composite(container, SWT.NONE);
		GridData gd_composite_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_3.widthHint = 582;
		compositeUseExisting.setLayoutData(gd_composite_3);
		compositeUseExisting.setLayout(new GridLayout(17, false));

		Label lblNewLabel_2 = new Label(compositeUseExisting, SWT.NONE);
		lblNewLabel_2.setText(CONFIGURATION);
		new Label(compositeUseExisting, SWT.NONE);
		new Label(compositeUseExisting, SWT.NONE);
		new Label(compositeUseExisting, SWT.NONE);
		new Label(compositeUseExisting, SWT.NONE);
		new Label(compositeUseExisting, SWT.NONE);
		new Label(compositeUseExisting, SWT.NONE);
		new Label(compositeUseExisting, SWT.NONE);
		new Label(compositeUseExisting, SWT.NONE);
		new Label(compositeUseExisting, SWT.NONE);
		new Label(compositeUseExisting, SWT.NONE);
		new Label(compositeUseExisting, SWT.NONE);

		comboConfiguration = new Combo(compositeUseExisting, SWT.DROP_DOWN | SWT.READ_ONLY);
		comboConfiguration.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				validate();
			}
		});
		comboConfiguration.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));

		btnCreateNewConfiguration.setSelection(true);
		btnCreateNewConfiguration.notifyListeners(SWT.Selection, new Event());

		loadCAppProjects();
		loadTemplateList();
		validate();

		/* Get projects that provide datamapper configurations */
		IDeveloperStudioProviderData[] providerProjectsList = loadProviderProjectsList();
		setImportConfigurationsList(providerProjectsList);

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(614, 326);
	}

	@Override
	protected void okPressed() {
		if (getSelectedOption() == CREATE_NEW_CONFIGURATION_OPTION) {
			/* Create new configuration case */
			try {
				String templateString;
				templateString = DATA_MAPPER_TEMPLATE_STRING;

				String name;
				String selectedTemplateExtension = getSelectedTemplateExtension();
				if (selectedTemplateExtension == null) {
					name = textConfigName.getText();
				} else {
					name = textConfigName.getText() + "." + selectedTemplateExtension; //$NON-NLS-1$
				}

				String content = EsbTemplateFormatter.stripParameters(templateString, name);
				ITemporaryFileTag createNewTempTag = FileUtils.createNewTempTag();
				File tempFile = new File(FileUtils.createTempDirectory(), name);
				tempFile.getParentFile().mkdirs();
				FileUtils.writeContent(tempFile, content);

				String projectName = comboProject.getText();
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);

				boolean configFileCreationSucess = createRegistryArtifact(project, name,
						DATAMAPPER_REGISTRY_PATH, content);

				createRegistryResourcesForInputScemaAndOutputSchema(name, project,
						DATAMAPPER_REGISTRY_PATH);

				if (!configFileCreationSucess) {
					MessageDialog.openInformation(getShell(), DIALOG_HEADER_RESOURCE_CREATION,
							String.format(DIALOG_MESSAGE, name, projectName));
					return;
				}

				String configPath = DATAMAPPER_REGISTRY_PATH.endsWith("/") ? DATAMAPPER_REGISTRY_PATH //$NON-NLS-1$
						+ name
						: DATAMAPPER_REGISTRY_PATH + "/" + name; //$NON-NLS-1$

				setSelectedPath(configPath);
				setIPathOfSelection(project.getFullPath().append(name).toString());

				createNewTempTag.clearAndEnd();
			} catch (IOException e) {
				log.error(e);
				MessageDialog
						.openError(getShell(), DIALOG_HEADER_TEMPLATE_CREATION, e.getMessage());
				return;
			} catch (CoreException e) {
				log.error(e);
				MessageDialog
						.openError(getShell(), DIALOG_HEADER_RESOURCE_CREATION, e.getMessage());
				return;
			} catch (Exception e) {
				log.error(e);
				MessageDialog
						.openError(getShell(), DIALOG_HEADER_RESOURCE_CREATION, e.getMessage());
				return;
			}
		} else if (getSelectedOption() == USE_EXISTING_OPTION) {

			Object selectedElement = importListMap.get(comboConfiguration.getText());
			IDeveloperStudioElement resource = (IDeveloperStudioElement) selectedElement;

			if (resource.getSource() instanceof IFile) {
				IFile selectedIFile = (IFile) resource.getSource();
				ipathOfSelection = selectedIFile.getFullPath().toString();

				IProject project = selectedIFile.getProject();
				RegistryFileImpl rpi = (RegistryFileImpl) selectedElement;
				String fileName = rpi.getName();
				String fullPath = rpi.getPath();
				int index = fullPath.lastIndexOf('/');
				String path = ""; //$NON-NLS-1$
				if (index > 0) {
					path = fullPath.substring(0, index);
				}

				if (path != null && !path.isEmpty())
					try {
						setSelectedPath(fullPath);
						setIPathOfSelection(project.getFullPath().append(fileName).toString());
						createRegistryResourcesForInputScemaAndOutputSchema(fileName, project, path);
					} catch (Exception e) {
						log.error(e.getMessage());
					}
			}
		}

		super.okPressed();
	}

	private static boolean createRegistryArtifact(IProject project, String fileName,
			String registryPath, String content) throws Exception {
		File destFile = project.getFile(fileName).getLocation().toFile();
		String resourceName = FileUtils.getResourceFileName(fileName);
		if (destFile.exists()) {
			return false;
		}

		String groupId = getMavenGroupId(project.getFile(POM_FILE).getLocation().toFile());
		groupId += GROUP_ID_RESOURCE;

		FileUtils.createFile(destFile, content);

		RegistryResourceInfoDoc regResInfoDoc = new RegistryResourceInfoDoc();

		RegistryResourceUtils.createMetaDataForFolder(registryPath, project.getLocation().toFile());
		RegistryResourceUtils.addRegistryResourceInfo(destFile, regResInfoDoc, project
				.getLocation().toFile(), registryPath);

		GeneralProjectArtifact generalProjectArtifact = new GeneralProjectArtifact();
		generalProjectArtifact.fromFile(project.getFile(ARTIFACT_FILE).getLocation().toFile());

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
			if (registryResourceInfo.getType() == REGISTRY_RESOURCE) {
				item = new RegistryItem();
				((RegistryItem) item).setFile(registryResourceInfo.getResourceBaseRelativePath());
				item.setPath(registryResourceInfo.getDeployPath().replaceAll("/$", "")); //$NON-NLS-1$ //$NON-NLS-2$
				artifact.addRegistryElement(item);
				((RegistryItem) item).setMediaType(TYPE_TEXT_PLAIN);
			}
		}
		generalProjectArtifact.addArtifact(artifact);
		generalProjectArtifact.toFile();
		addGeneralProjectPlugin(project);
		project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		return true;
	}

	public static void createRegistryResourcesForInputScemaAndOutputSchema(String name,
			IProject project, String path) throws Exception {
		String inputAvroSchemaName = name.replace(DATAMAPPER_CONFIG_EXT, INPUT_AVROSCHEMA);
		String outputAvroSchemaName = name.replace(DATAMAPPER_CONFIG_EXT, OUTPUT_AVROSCHEMA);
		createRegistryArtifact(project, inputAvroSchemaName, path, ""); //$NON-NLS-1$
		createRegistryArtifact(project, outputAvroSchemaName, path, ""); //$NON-NLS-1$
	}

	private static String getMavenGroupId(File pomLocation) {
		String groupId = GROUP_ID;
		if (pomLocation != null && pomLocation.exists()) {
			try {
				MavenProject mavenProject = MavenUtils.getMavenProject(pomLocation);
				groupId = mavenProject.getGroupId();
			} catch (Exception e) {
				log.error(ERROR_READING_POM_FILE, e);
			}
		}
		return groupId;
	}

	private static void addGeneralProjectPlugin(IProject project) throws Exception {
		MavenProject mavenProject;

		File mavenProjectPomLocation = project.getFile(POM_FILE).getLocation().toFile();
		if (!mavenProjectPomLocation.exists()) {
			mavenProject = MavenUtils.createMavenProject(GROUP_ID, project.getName(),
					ARTIFACT_VERSION, POM_PACKAGING_TYPE);
		} else {
			mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		}

		boolean pluginExists = MavenUtils.checkOldPluginEntry(mavenProject, MAVEN_GROUP_ID,
				MAVEN_ARTIFACT_ID, MavenConstants.WSO2_GENERAL_PROJECT_VERSION);
		if (pluginExists) {
			return;
		}

		mavenProject = MavenUtils.getMavenProject(mavenProjectPomLocation);
		Plugin plugin = MavenUtils.createPluginEntry(mavenProject, MAVEN_GROUP_ID,
				MAVEN_ARTIFACT_ID, MavenConstants.WSO2_GENERAL_PROJECT_VERSION, true);

		PluginExecution pluginExecution;

		pluginExecution = new PluginExecution();
		pluginExecution.addGoal(POM_GEN);
		pluginExecution.setPhase(PROCESS_RESOURCES);
		pluginExecution.setId(REGISTRY);
		plugin.addExecution(pluginExecution);

		Xpp3Dom configurationNode = MavenUtils.createMainConfigurationNode();
		Xpp3Dom artifactLocationNode = MavenUtils.createXpp3Node(configurationNode,
				ARTIFACT_LOCATION);
		artifactLocationNode.setValue("."); //$NON-NLS-1$
		Xpp3Dom typeListNode = MavenUtils.createXpp3Node(configurationNode, TYPE_LIST);
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

	private void setEnabled(Control[] children, boolean enabledStatus) {
		for (Control child : children) {
			child.setEnabled(enabledStatus);
		}
	}

	private void validate() {
		Button okButton = getButton(IDialogConstants.OK_ID);
		boolean okButtonState = true;

		if (getSelectedOption() == CREATE_NEW_CONFIGURATION_OPTION) {
			/* Create new configuration case */
			if (comboProject.getText() == null || comboProject.getText().equals("") //$NON-NLS-1$
					|| textConfigName.getText().trim().equals("")) { //$NON-NLS-1$
				okButtonState = false;
			}
		} else if (getSelectedOption() == USE_EXISTING_OPTION) {
			/* use existing */
			if (comboConfiguration.getText() == null || comboConfiguration.getText().equals("")) { //$NON-NLS-1$
				okButtonState = false;
			}
		}

		/* set ok button enabled only if validation passes */
		if (okButton != null) {
			okButton.setEnabled(okButtonState);
		}
	}

	private void loadCAppProjects() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		comboProject.removeAll();
		for (IProject project : projects) {
			try {
				if (project.isOpen() && project.hasNature(Messages.GENERAL_PROJECT_NATURE)) {
					comboProject.add(project.getName());
				}
			} catch (Exception e) {
				log.error(ERROR_LOADING_CAPP_PROJECTS, e);
				MessageDialog.openError(getShell(), MSG_LOADING_CAPP_PROJECTS, e.getMessage());
			}
		}
		if (comboProject.getItemCount() > 0) {
			comboProject.select(0);
		}
	}

	private IDeveloperStudioProviderData[] loadProviderProjectsList() {
		List<Object> list = new ArrayList<Object>();
		List<Class<?>> typesList = Arrays.asList(type);

		if (typesList.contains(IRegistryFile.class)) {
			list.addAll(Arrays.asList(RegistryManager.getResourceProviders(true)));
		}

		return list.toArray(new IDeveloperStudioProviderData[] {});
	}

	private void setImportConfigurationsList(IDeveloperStudioProviderData[] providerProjectsList) {

		for (IDeveloperStudioProviderData data : providerProjectsList) {
			IDeveloperStudioProvider provider = data.getProvider();

			List<IDeveloperStudioProvider> registryProjectsList = getRegistryProjectsList(provider);
			importListMap = new HashMap<String, IDeveloperStudioElement>();

			for (IDeveloperStudioProvider registryProject : registryProjectsList) {
				List<IDeveloperStudioProvider> childrenList = getChildrenList(registryProject);

				for (IDeveloperStudioProvider child : childrenList) {
					IDeveloperStudioElement childElement = child.getElements(getFilters())[0];
					String configName = childElement.getName().substring(0,
							childElement.getName().lastIndexOf(DATAMAPPER_CONFIG_EXT));
					String comboItemText = configName + " (" + registryProject.getText() + ")"; //$NON-NLS-1$ //$NON-NLS-2$
					importListMap.put(comboItemText, childElement);
					comboConfiguration.add(comboItemText);
				}
			}
		}

		if (comboConfiguration.getItemCount() > 0) {
			comboConfiguration.select(0);
		}

	}

	private List<IDeveloperStudioProvider> getRegistryProjectsList(IDeveloperStudioProvider provider) {
		List<IDeveloperStudioProvider> list = new ArrayList<IDeveloperStudioProvider>();
		IDeveloperStudioProvider[] categories = provider.getCategories(getFilters());
		if (categories != null) {
			list.addAll(Arrays.asList(categories));
		}

		return list;
	}

	private List<IDeveloperStudioProvider> getChildrenList(IDeveloperStudioProvider provider) {
		List<IDeveloperStudioProvider> list = new ArrayList<IDeveloperStudioProvider>();

		/* Get sub categories of registry project */
		IDeveloperStudioProvider[] resources = provider.getCategories(getFilters());
		if (resources != null) {
			list.addAll(Arrays.asList(resources));
		}

		return list;
	}

	private String getSelectedTemplateExtension() {
		return artifactTemplates[0].getDefaultExtension();
	}

	private void loadTemplateList() {
		artifactTemplates = ArtifactTemplateHandler.getArtifactTemplates(getFilters());
	}

	public int getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(int selectedOption) {
		this.selectedOption = selectedOption;
	}

	public Class<?>[] getType() {
		return type;
	}

	public void setType(Class<?>[] type) {
		this.type = type;
	}

	public void setFilters(Map<String, java.util.List<String>> filters) {
		this.filters = filters;
	}

	public Map<String, java.util.List<String>> getFilters() {
		return filters;
	}

	public void setSelectedPath(String selectedPath) {
		this.selectedPath = selectedPath;
	}

	public String getSelectedPath() {
		return selectedPath;
	}

	public void setIPathOfSelection(String ipath) {
		ipathOfSelection = ipath;
	}

	public String getIPathOfSelection() {
		return ipathOfSelection;
	}

}