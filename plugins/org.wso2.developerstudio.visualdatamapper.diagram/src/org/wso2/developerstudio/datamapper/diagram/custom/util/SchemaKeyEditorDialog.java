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

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.avro.Schema;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
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
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.datamapper.diagram.schemagen.util.*;

public class SchemaKeyEditorDialog extends Dialog {

	
	private Text schemaKeyTextField;
	private Label lblSchemaTypeLabel;
	private Combo schemaTypeCombo;
	private EditPart selectedEP;
	private IFile inputFile;
	private String schemaType;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	private static final String DEFAULT_REGISTRY_URL = "https://localhost:9443/registry"; //$NON-NLS-1$
	private static final String G_REG_PATH_PREFIX = "/_system/governance/"; //$NON-NLS-1$
	private static final String C_REG_PATH_PREFIX = "/_system/config/"; //$NON-NLS-1$
	private static final String C_REG_PREFIX = "conf:%s"; //$NON-NLS-1$
	private static final String G_REG_PREFIX = "gov:%s"; //$NON-NLS-1$

	private static final String LOCAL_ENTRIES = "local entries"; //$NON-NLS-1$
	private static final String WORKSPACE = "workspace"; //$NON-NLS-1$
	private static final String REGISTRY = "registry"; //$NON-NLS-1$
	private static final String FILE_SYSTEM = "file system"; //$NON-NLS-1$

	private static final String ERROR_MSG_HEADER = Messages.SchemaKeyEditorDialog_ErrorMsgHeader;
	private static final String REGISTRY_BROWSER = Messages.SchemaKeyEditorDialog_RegistryBrowser;
	private static final String RESOURCE_KEY = Messages.SchemaKeyEditorDialog_ResourceKey;
	private static final String SELECT_REGISTRY_RESOURCE = Messages.SchemaKeyEditorDialog_SelectRegistryResource;
	private static final String SCHEMA_KEY_EDITOR_DIALOG_TEXT = Messages.SchemaKeyEditorDialog_SchemaKeyEditorDialogMessage
			+ FILE_SYSTEM + "</a> or <a>" + REGISTRY + "</a>"; //$NON-NLS-1$ //$NON-NLS-2$
	// private static final String SCHEMA_KEY_EDITOR_DIALOG_TEXT =
	// "Type the key or specify from <a>" + FILE_SYSTEM + "</a>, <a>" + REGISTRY
	// + "</a>, <a>" + WORKSPACE + "</a> or <a>" + LOCAL_ENTRIES + "</a>";

	private static final String ERROR_OPENING_FILE = Messages.SchemaKeyEditorDialog_ErrorOpeningFile;
	private static final String REASON_OPENING_FILE = Messages.SchemaKeyEditorDialog_ReasonOpeningFile;
	private static final String ERROR_REGISTRY_BROWSER = Messages.SchemaKeyEditorDialog_ErrorRegistryBrowser;
	private static final String REASON_REGISTRY_BROWSER = Messages.SchemaKeyEditorDialog_ReasonRegistryBrowser;
	private static final String ERROR_REGISTRY_URL = Messages.SchemaKeyEditorDialog_ErrorRegistryURL;
	private static final String REASON_REGISTRY_URL = Messages.SchemaKeyEditorDialog_ReasonRegistryURL;
	private static final String SELECT_SCHEMA_SOURCE = Messages.SchemaKeyEditorDialog_SelecSchemaSource;;
	private static final String ERROR_DIALOG_VISIBILITY = "Error occured while changing dialog visibility"; //$NON-NLS-1$

	public SchemaKeyEditorDialog(Shell parent, EditPart selectedEP, IWorkbenchPart workbenchPart,
			String schemaType) {
		super(parent);
		this.selectedEP = selectedEP;
		this.schemaType = schemaType;

		IEditorPart editorPart = workbenchPart.getSite().getWorkbenchWindow().getActivePage()
				.getActiveEditor();
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
			if(this.getShell() != null) {
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
		grpPropertyKey.setText(RESOURCE_KEY);

		FormLayout fl_grpPropertyKey = new FormLayout();
		fl_grpPropertyKey.marginHeight = 10;
		fl_grpPropertyKey.marginWidth = 10;
		grpPropertyKey.setLayout(fl_grpPropertyKey);
		
		FormData lableLayoutData  = new FormData();
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
					//commented by susinda openRegistryResourceProviderDialog();
				} else if (LOCAL_ENTRIES.equals(selectedCommand)) {
					//commented by susinda  openEmbeddedEntryBrowser();
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
		// TODO Get schema key value from text field and write to model
		/* schemaProperty.setKeyValue(schemaKeyTextField.getText()); */
	}

	/**
	 * browser for in-workspace local-entries
	 */
	/* Commented by susinda
	protected void openEmbeddedEntryBrowser() {
		hide();
		try {
			EmbeddedEntriesDialog embeddedEntriesDialog = new EmbeddedEntriesDialog(
					getParentShell(), null);
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
	*/

	/**
	 * Create new resource dialog
	 */
	/* Commented by susinda
	protected void openNewResourceTemplateDialog() {
		hide();
		try {
			NewResourceTemplateDialog newResourceTemplateDialog = new NewResourceTemplateDialog(
					getParentShell(), null);
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
	*/

	/**
	 * Open Registry browser
	 */
	//TODO refactor using the introduced factory method
	private void openRegistryBrowser() {
		hide();
try {
			DataMapperSchemaEditorUtil schemaEditorUtil = new DataMapperSchemaEditorUtil(inputFile);
			String schema = SchemaGeneratorFromRegResourceHelper.getSchemaContent(FileType.values()[schemaTypeCombo.getSelectionIndex()]);
			
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

			IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, REASON_REGISTRY_BROWSER);
			ErrorDialog.openError(Display.getCurrent().getActiveShell(), ERROR_MSG_HEADER,
					ERROR_REGISTRY_BROWSER, editorStatus);
		} finally {
			show();
		}
	}

	/**
	 * Pre-processing registry path
	 */
	private void setSelectedPath(String selectedPath) {
		if (selectedPath.startsWith(G_REG_PATH_PREFIX)) {
			selectedPath = String.format(G_REG_PREFIX,
					selectedPath.substring(G_REG_PATH_PREFIX.length()));
		} else if (selectedPath.startsWith(C_REG_PATH_PREFIX)) {
			selectedPath = String.format(C_REG_PREFIX,
					selectedPath.substring(C_REG_PATH_PREFIX.length()));
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
			String schema = SchemaGeneratorFromFileSystemHelper.getSchemaContent(FileType.values()[schemaTypeCombo.getSelectionIndex()]);
			if(schema != null){
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

			IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, REASON_OPENING_FILE);
			ErrorDialog.openError(Display.getCurrent().getActiveShell(), ERROR_MSG_HEADER,
					ERROR_OPENING_FILE, editorStatus);
		} finally {
			show();
		}

	}

}