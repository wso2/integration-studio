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

package org.wso2.developerstudio.datamapper.diagram.custom.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.datamapper.diagram.Activator;
import org.wso2.developerstudio.datamapper.diagram.custom.action.Messages;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.InputEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OutputEditPart;
import org.wso2.developerstudio.datamapper.diagram.part.DataMapperSchemaEditorUtil;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryConnection;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbEndpoint;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbLocalEntry;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbSequence;
import org.wso2.developerstudio.eclipse.general.project.dialogs.NewResourceTemplateDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.DeveloperStudioElementProviderDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.EmbeddedEntriesDialog;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryData;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryFile;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryHandler;
import org.wso2.developerstudio.datamapper.diagram.schemagen.util.*;

public class SchemaKeyEditorDialog extends Dialog {

	private static final String NO_SUCH_RESOURCE_EXISTS = Messages.SchemaKeyEditorFialog_NoSuchResource;
	private static final String RESGISTRY_RESOURCE_RETRIVING_ERROR = Messages.SchemaKeyEditorDialog_ErrorRetreivingResource;
	private static final String FILE_DIALOG_TITLE = "Select File";
	private Text schemaKeyTextField;
	private Label lblSchemaTypeLabel;
	private Combo schemaTypeCombo;
	private EditPart selectedEP;
	private IFile inputFile;
	private String schemaType;
	private SchemaGeneratorHelper schemaGeneratorHelper;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private static final String FILE_NAME_VALUE = "tempSchemaContnt";
	private static final String DEFAULT_REGISTRY_URL = "https://localhost:9443/registry"; //$NON-NLS-1$
	private static final String REGISTRY_BROWSER = Messages.SchemaKeyEditorDialog_RegistryBrowser;
	private static final String SELECT_REGISTRY_RESOURCE = Messages.SchemaKeyEditorDialog_SelectRegistryResource;
	private static final String TEMP_REG_RESOURCE_LOC = "tempRegRrsourceGenLocation";
	private static final String JAVA_IO_TMPDIR = "java.io.tmpdir";
	private static final String tempOutput = System.getProperty(JAVA_IO_TMPDIR) + File.separator
			+ TEMP_REG_RESOURCE_LOC;
	private static final String NEW_RESOURCE = Messages.SchemaKeyEditorDialog_NewResource;
	private static final String WORKSPACE_ELEMENT_PROVIDERS = Messages.SchemaKeyEditorDialog_WorkspaceElementProviders;
	private static final String EMBEDDED_RESOURCES = Messages.SchemaKeyEditorDialog_EmbeddedResources;
	private static final String G_REG_PATH_PREFIX = "/_system/governance/"; //$NON-NLS-1$
	private static final String C_REG_PATH_PREFIX = "/_system/config/"; //$NON-NLS-1$
	private static final String C_REG_PREFIX = "conf:%s"; //$NON-NLS-1$
	private static final String G_REG_PREFIX = "gov:%s"; //$NON-NLS-1$

	private static final String LOCAL_ENTRIES = "local entries"; //$NON-NLS-1$
	private static final String WORKSPACE = "workspace"; //$NON-NLS-1$
	private static final String REGISTRY = "registry"; //$NON-NLS-1$
	private static final String FILE_SYSTEM = "file system"; //$NON-NLS-1$

	private static final String ERROR_MSG_HEADER = Messages.SchemaKeyEditorDialog_ErrorMsgHeader;
	private static final String RESOURCE_KEY = Messages.SchemaKeyEditorDialog_ResourceKey;
	private static final String SCHEMA_KEY_EDITOR_DIALOG_TEXT = Messages.SchemaKeyEditorDialog_SchemaKeyEditorDialogMessage
			+ FILE_SYSTEM + "</a> or <a>" + REGISTRY + "</a> or <a>" + WORKSPACE + "</a>"; //$NON-NLS-1$ //$NON-NLS-2$

	private static final String ERROR_OPENING_FILE = Messages.SchemaKeyEditorDialog_ErrorOpeningFile;
	private static final String REASON_OPENING_FILE = Messages.SchemaKeyEditorDialog_ReasonOpeningFile;
	private static final String ERROR_REGISTRY_BROWSER = Messages.SchemaKeyEditorDialog_ErrorRegistryBrowser;
	private static final String REASON_REGISTRY_BROWSER = Messages.SchemaKeyEditorDialog_ReasonRegistryBrowser;
	private static final String ERROR_REGISTRY_URL = Messages.SchemaKeyEditorDialog_ErrorRegistryURL;
	private static final String REASON_REGISTRY_URL = Messages.SchemaKeyEditorDialog_ReasonRegistryURL;
	private static final String SELECT_SCHEMA_SOURCE = Messages.SchemaKeyEditorDialog_SelecSchemaSource;
	private static final String ERROR_DIALOG_VISIBILITY = Messages.SchemaKeyEditorFialog_VisibilityError; //$NON-NLS-1$

	public SchemaKeyEditorDialog(Shell parent, EditPart selectedEP, IWorkbenchPart workbenchPart, String schemaType) {
		super(parent);
		this.selectedEP = selectedEP;
		this.schemaType = schemaType;
		schemaGeneratorHelper = new SchemaGeneratorHelper();
		IEditorPart editorPart = workbenchPart.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
		if (editorPart != null) {
			IFileEditorInput input = (IFileEditorInput) editorPart.getEditorInput();
			inputFile = input.getFile();
		}
	}

	private void hide() {
		changeVisibility(false);
	}

	private void show() {
		changeVisibility(true);
	}

	private void changeVisibility(boolean visible) {
		try {
			if (this.getShell() != null) {
				this.getShell().setVisible(visible);
			}
		} catch (Exception e) {
			log.error(ERROR_DIALOG_VISIBILITY, e);
		}
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FillLayout fl_container = new FillLayout(SWT.HORIZONTAL);
		fl_container.marginHeight = 5;
		fl_container.marginWidth = 5;
		fl_container.spacing = 10;
		container.setLayout(fl_container);

		Group grpPropertyKey = new Group(container, SWT.None);
		//grpPropertyKey.setText(RESOURCE_KEY);

		FormLayout fl_grpPropertyKey = new FormLayout();
		fl_grpPropertyKey.marginHeight = 10;
		fl_grpPropertyKey.marginWidth = 10;
		grpPropertyKey.setLayout(fl_grpPropertyKey);

		FormData lableLayoutData = new FormData();
		lblSchemaTypeLabel = new Label(grpPropertyKey, SWT.NORMAL);
		lblSchemaTypeLabel.setText(SELECT_SCHEMA_SOURCE);
		lblSchemaTypeLabel.setLayoutData(lableLayoutData);

		FormData comboLayoutData = new FormData();
		comboLayoutData.left = new FormAttachment(lblSchemaTypeLabel, 10);
		schemaTypeCombo = new Combo(grpPropertyKey, SWT.DROP_DOWN | SWT.READ_ONLY);
		schemaTypeCombo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
			}
		});
		int optionsLenght = FileType.values().length;
		String[] options = new String[optionsLenght];
		for (int i = 0; i < optionsLenght; i++) {
			options[i] = FileType.values()[i].name();
		}
		schemaTypeCombo.setItems(options);
		schemaTypeCombo.select(0);
		schemaTypeCombo.setLayoutData(comboLayoutData);

		FormData fd_link = new FormData();
		fd_link.top = new FormAttachment(lblSchemaTypeLabel, 20);
		Link link = new Link(grpPropertyKey, SWT.NONE);
		link.setLayoutData(fd_link);
		link.setText(SCHEMA_KEY_EDITOR_DIALOG_TEXT);

		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selectedCommand = e.text;
				if (FILE_SYSTEM.equals(selectedCommand)) {
					openFileBrowser();
				} else if (REGISTRY.equals(selectedCommand)) {
					openRegistryBrowser();
				} else if (WORKSPACE.equals(selectedCommand)) {
					openRegistryResourceProviderDialog();
				}
			}
		});

		// Selected schema key to be appeared here OR typed
		schemaKeyTextField = new Text(grpPropertyKey, SWT.BORDER);
		schemaKeyTextField.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				saveConfiguration();
			}
		});
		{
			FormData schemaKeyTextFieldLayoutData = new FormData();
			schemaKeyTextFieldLayoutData.top = new FormAttachment(lblSchemaTypeLabel, 50);
			schemaKeyTextFieldLayoutData.left = new FormAttachment(0, 5);
			schemaKeyTextFieldLayoutData.right = new FormAttachment(100, -5);
			schemaKeyTextField.setLayoutData(schemaKeyTextFieldLayoutData);
		}

		loadConfiguration();
		return container;
	}

	/**
	 * Retrieve from model and set to text field
	 */
	private void loadConfiguration() {
		// TODO Get schema key value from model and set to text field
		/*
		 * if (!StringUtils.isBlank(schemaKey.getKeyValue())) {
		 * schemaKeyTextField.setText(schemaKey.getKeyValue()); }
		 */
	}

	@Override
	protected void okPressed() {
		saveConfiguration();
		super.okPressed();
	}

	/**
	 * Write from design to model
	 */
	private void saveConfiguration() {
	}

	/**
	 * browser for in-workspace local-entries
	 */
	protected void openEmbeddedEntryBrowser() {
		hide();
		try {
			EmbeddedEntriesDialog embeddedEntriesDialog = new EmbeddedEntriesDialog(getParentShell(), null);
			embeddedEntriesDialog.create();
			embeddedEntriesDialog.getShell().setText(EMBEDDED_RESOURCES);
			embeddedEntriesDialog.open();
			if (embeddedEntriesDialog.getReturnCode() == Window.OK) {
				setSelectedPath(embeddedEntriesDialog.getSelectedItem().trim());
			}
		} finally {
			show();
		}
	}

	/**
	 * Create new resource dialog
	 */
	protected void openNewResourceTemplateDialog() {
		hide();
		try {
			NewResourceTemplateDialog newResourceTemplateDialog = new NewResourceTemplateDialog(getParentShell(), null);
			newResourceTemplateDialog.create();
			newResourceTemplateDialog.getShell().setText(NEW_RESOURCE);
			newResourceTemplateDialog.open();
			if (newResourceTemplateDialog.getReturnCode() == Window.OK) {
				setSelectedPath(newResourceTemplateDialog.getSelectedPath());
			}
		} finally {
			show();
		}
	}

	/**
	 * Import schema from projects in workspace
	 */
	private void openRegistryResourceProviderDialog() {
		hide();
		try {
			DataMapperSchemaEditorUtil schemaEditorUtil = new DataMapperSchemaEditorUtil(inputFile);
			RegistryKeyProperty registryPropertyKey = EsbFactory.eINSTANCE.createRegistryKeyProperty();
			@SuppressWarnings("unchecked")
			DeveloperStudioElementProviderDialog registryResourceProviderSelector = new DeveloperStudioElementProviderDialog(
					getParentShell(), new Class[] { IRegistryFile.class },
					(Map<String, List<String>>) registryPropertyKey.getFilters());
			registryResourceProviderSelector.create();
			registryResourceProviderSelector.getShell().setText(WORKSPACE_ELEMENT_PROVIDERS);
			registryResourceProviderSelector.open();
			if (registryResourceProviderSelector.getReturnCode() == Window.OK) {
				FileType fileType = extractFileTypeFromFileExtension(registryResourceProviderSelector.getSelectedPath());
				if (fileType == null) {
					// throw a user message saying not an accepted file type
					return;
				}

				String[] getFileName = registryResourceProviderSelector.getSelectedPath().split(File.separator);
				String resourceFile = retrieveWorkSpaceFileLoc(getFileName[getFileName.length - 1]);

				String schema = schemaGeneratorHelper.getSchemaContent(fileType, resourceFile);
				String schemaFilePath = null;
				try {
					schemaFilePath = schemaEditorUtil.createDiagram(schema, schemaType);
				} catch (Exception e) {
					// log the error
				}

				if (!schemaFilePath.isEmpty()) {
					setSelectedPath(schemaFilePath);
					if (Messages.LoadInputSchemaAction_SchemaTypeInput.equals(schemaType)) {
						InputEditPart iep = (InputEditPart) selectedEP;
						iep.resetInputTreeFromFile(schemaFilePath);
					} else if (Messages.LoadOutputSchemaAction_SchemaTypeOutput.equals(schemaType)) {
						OutputEditPart iep = (OutputEditPart) selectedEP;
						iep.resetOutputTreeFromFile(schemaFilePath);
					}
				}

			} else {
				return;
			}
		} finally {
			show();
		}
	}

	/**
	 * retrieve the local path of th eregistry resource user selected from the
	 * workspace, iterate through all the registry resource projects check if
	 * the resource exist in some project, if so return the local file path to
	 * that resource
	 * 
	 * @param fileName
	 * @return
	 */
	private String retrieveWorkSpaceFileLoc(String fileName) {
		ArrayList<String> regResourceProjects = loadRegistryResourceProjects();
		boolean fileExists = false;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		String folder = workspace.getRoot().getLocation().toFile().getPath().toString();
		String resourceFilePath = null;
		for (String regResourceProject : regResourceProjects) {
			resourceFilePath = folder + File.separator + regResourceProject + File.separator + fileName;
			File resourceFile = new File(resourceFilePath);
			if (resourceFile.exists()) {
				fileExists = true;
				break;
			}
		}
		if (!fileExists) {
			displayUserError(RESGISTRY_RESOURCE_RETRIVING_ERROR, NO_SUCH_RESOURCE_EXISTS);
		}
		return resourceFilePath;
	}

	private FileType extractFileTypeFromFileExtension(String selectedPath) {
		if (selectedPath.endsWith(".xsd")) {
			return FileType.XSD;
		} else if (selectedPath.endsWith(".xml")) {
			return FileType.XML;
		} else if (selectedPath.endsWith(".jschema")) {
			return FileType.JSONSCHEMA;
		} else {
			return null;
		}
	}

	/**
	 * Open Registry browser
	 */
	private void openRegistryBrowser() {
		hide();
		try {
			DataMapperSchemaEditorUtil schemaEditorUtil = new DataMapperSchemaEditorUtil(inputFile);
			IRegistryConnection[] registryConnections = CAppEnvironment.getRegistryHandler().getRegistryConnections();
			if (registryConnections.length == 0) {
				RegistryConnection registryConnection = new RegistryConnection();
				try {
					registryConnection.setURL(new URL(DEFAULT_REGISTRY_URL));
				} catch (MalformedURLException e) {
					log.error(ERROR_REGISTRY_URL, e);

					displayUserError(REASON_REGISTRY_URL, ERROR_REGISTRY_URL);
				}
				registryConnection.setPath(C_REG_PATH_PREFIX);
			}
			IRegistryData selectedPathData = CAppEnvironment.getRegistryHandler().selectRegistryPath(
					registryConnections, REGISTRY_BROWSER, SELECT_REGISTRY_RESOURCE,
					IRegistryHandler.SELECTED_REGISTRY_RESOURCE);
			if (selectedPathData == null) {
				return;
			}
			// String mediaType = selectedPathData.getMediaType();
			String mediaType = "xml"; // TODO need to replace this with the
										// above commented out line when the new
										// kernel version is available
			FileType fileType = extractFileTypeFromRegistryResource(mediaType);

			String fileName = FILE_NAME_VALUE + "." + fileType.toString().toLowerCase();
			File outputDirectory = new File(tempOutput);
			if (!outputDirectory.exists()) {
				outputDirectory.mkdir();
			}
			File outputFile = new File(tempOutput + File.separator + fileName);
			if (outputFile.exists()) {
				outputFile.delete();
				outputFile.createNewFile();
			}
			CAppEnvironment.getRegistryHandler().importRegistryResourceToFileSystem((IRegistryData) selectedPathData,
					outputFile);

			String schema = schemaGeneratorHelper.getSchemaContent(
					FileType.values()[schemaTypeCombo.getSelectionIndex()], outputFile.getAbsolutePath());
			outputDirectory.deleteOnExit();
			String schemaFilePath = schemaEditorUtil.createDiagram(schema, schemaType);

			if (!schemaFilePath.isEmpty()) {
				setSelectedPath(schemaFilePath);
				if (Messages.LoadInputSchemaAction_SchemaTypeInput.equals(schemaType)) {
					InputEditPart iep = (InputEditPart) selectedEP;
					iep.resetInputTreeFromFile(schemaFilePath);
				} else if (Messages.LoadOutputSchemaAction_SchemaTypeOutput.equals(schemaType)) {
					OutputEditPart iep = (OutputEditPart) selectedEP;
					iep.resetOutputTreeFromFile(schemaFilePath);
				}
			}

		} catch (Exception e) {
			log.error(ERROR_REGISTRY_BROWSER, e);

			displayUserError(REASON_REGISTRY_BROWSER, ERROR_REGISTRY_BROWSER);
		} finally {
			show();
		}
	}

	private void displayUserError(String reason, String message) {
		IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, reason);
		ErrorDialog.openError(Display.getCurrent().getActiveShell(), ERROR_MSG_HEADER, message, editorStatus);
	}

	/**
	 * Pre-processing registry path
	 */
	private void setSelectedPath(String selectedPath) {
		if (selectedPath.startsWith(G_REG_PATH_PREFIX)) {
			selectedPath = String.format(G_REG_PREFIX, selectedPath.substring(G_REG_PATH_PREFIX.length()));
		} else if (selectedPath.startsWith(C_REG_PATH_PREFIX)) {
			selectedPath = String.format(C_REG_PREFIX, selectedPath.substring(C_REG_PATH_PREFIX.length()));
		}

		schemaKeyTextField.setText(selectedPath);
		if (selectedPath != null && !selectedPath.trim().equals("")) { //$NON-NLS-1$
			okPressed();
		}
	}

	/**
	 * Open file browser
	 */
	private void openFileBrowser() {
		hide();
		try {
			DataMapperSchemaEditorUtil schemaEditorUtil = new DataMapperSchemaEditorUtil(inputFile);
			FileType option = FileType.values()[schemaTypeCombo.getSelectionIndex()];
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			FileDialog fid = new FileDialog(shell);
			if (option != FileType.JSONSCHEMA) {
				fid.setFilterExtensions(new String[] { fileExtensionForFileType(option) });
			}
			fid.setText(FILE_DIALOG_TITLE);
			String filePath = fid.open();
			if (filePath == null) {
				return;
			}
			String schema = schemaGeneratorHelper.getSchemaContent(
					FileType.values()[schemaTypeCombo.getSelectionIndex()], filePath);
			if (schema != null) {
				String schemaFilePath = schemaEditorUtil.createDiagram(schema, schemaType);
				if (!schemaFilePath.isEmpty()) {
					setSelectedPath(schemaFilePath);

					if (Messages.LoadInputSchemaAction_SchemaTypeInput.equals(schemaType)) {
						InputEditPart iep = (InputEditPart) selectedEP;
						iep.resetInputTreeFromFile(schemaFilePath);
					} else if (Messages.LoadOutputSchemaAction_SchemaTypeOutput.equals(schemaType)) {
						OutputEditPart iep = (OutputEditPart) selectedEP;
						iep.resetOutputTreeFromFile(schemaFilePath);
					}
				}
			}

		} catch (Exception e) {
			log.error(ERROR_OPENING_FILE, e);

			displayUserError(REASON_OPENING_FILE, ERROR_OPENING_FILE);
		} finally {
			show();
		}

	}

	private String fileExtensionForFileType(FileType option) {
		switch (option) {
		case XSD:
			return "*.xsd";
		case XML:
			return "*.xml";
		case JSON:
			return "*.json";
		default:
			return "*.jschema";// this is not used since we are not adding any filter to json schema files

		}
	}

	private static FileType extractFileTypeFromRegistryResource(String mediaType) {
		if (mediaType.contains("xml")) {
			return FileType.XML;
		} else if (mediaType.contains("xsd")) {
			return FileType.XSD;
		} else if (mediaType.contains("json")) {
			return FileType.JSON;
		} else {
			return FileType.XML;
		}
	}

	private ArrayList<String> loadRegistryResourceProjects() {
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		ArrayList<String> registryProjectList = new ArrayList<String>();
		for (IProject project : projects) {
			try {
				if (project.hasNature(Constants.GENERAL_PROJECT_NATURE)) {
					registryProjectList.add(project.getName());
				}
			} catch (Exception e) {
				/* ignore */
			}
		}
		return registryProjectList;
	}

}