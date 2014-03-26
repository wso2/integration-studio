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

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPart;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryConnection;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbEndpoint;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbLocalEntry;
import org.wso2.developerstudio.eclipse.esb.core.interfaces.IEsbSequence;
import org.wso2.developerstudio.eclipse.esb.presentation.ui.DeveloperStudioElementProviderDialog;
import org.wso2.developerstudio.eclipse.esb.presentation.ui.EmbeddedEntriesDialog;
import org.wso2.developerstudio.eclipse.esb.presentation.ui.NewResourceTemplateDialog;
import org.wso2.developerstudio.eclipse.greg.core.interfaces.IRegistryConnection;
import org.wso2.developerstudio.eclipse.greg.core.interfaces.IRegistryData;
import org.wso2.developerstudio.eclipse.greg.core.interfaces.IRegistryFile;
import org.wso2.developerstudio.eclipse.greg.core.interfaces.IRegistryHandler;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.visualdatamapper.diagram.Activator;

import dataMapper.diagram.edit.parts.InputEditPart;
import dataMapper.diagram.edit.parts.OutputEditPart;
import dataMapper.diagram.part.DataMapperSchemaEditorUtil;

/**
 * A SWT based editor dialog to be used for editing registry key properties.
 */
public class SchemaKeyEditorDialog extends Dialog {
	
	/**
	 * Default registry url.
	 */
	private static final String DEFAULT_REGISTRY_URL = "https://localhost:9443/registry";
	
	
	/**
	 * Prefix for governance registry paths.
	 */
	private static final String G_REG_PATH_PREFIX = "/_system/governance/";
	
	/**
	 * Prefix for configuration registry paths.
	 */
	private static final String C_REG_PATH_PREFIX = "/_system/config/";
	
	/**
	 * Registry key text field.
	 */
	private Text rkTextField;
	
	/**
	 * Local named entities.
	 */
	private FormData rkTextFieldLayoutData;
		
	private EditPart selectedEP;
	
	private IFile inputFile;
	
	private IProject project;
	
	private String schemaType;

	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
//	/**
//	 * Status indicating whether this dialog was saved or cancelled.
//	 */
//	private boolean saved;		

	/**
	 * Creates a new {@link SchemaKeyEditorDialog} instance.
	 * 
	 * @param parent
	 *            parent shell.
	 * @param style
	 *            style.
	 * @param property
	 *            {@link RegistryKeyProperty} to be edited.
	 * @param localNamedEntities
	 *            named entities currently defined on the local configuration.
	 */
	public SchemaKeyEditorDialog(Shell parent, EditPart selectedEP, IWorkbenchPart workbenchPart, String schemaType) {
		super(parent);
		this.selectedEP = selectedEP;
		this.schemaType = schemaType;

		IEditorPart editorPart = workbenchPart.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
		if(editorPart  != null)
		{
		    IFileEditorInput input = (IFileEditorInput)editorPart.getEditorInput() ;
		    inputFile = input.getFile();
		    project = inputFile.getProject();
		}
	}	
		
	private void hide(){
		changeVisibility(false);
	}
	
	private void show(){
		changeVisibility(true);
	}

	private void changeVisibility(boolean visible) {
		try {
			this.getShell().setVisible(visible);
		} catch (Exception e) {
			//ignore this
		}
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FillLayout fl_container = new FillLayout(SWT.HORIZONTAL);
		fl_container.marginHeight = 5;
		fl_container.marginWidth = 5;
		fl_container.spacing = 10;
		container.setLayout(fl_container);
		
		Group grpPropertyKey = new Group(container,SWT.None);
		grpPropertyKey.setText("Resource Key");
		
		FormLayout fl_grpPropertyKey = new FormLayout();
		fl_grpPropertyKey.marginHeight = 10;
		fl_grpPropertyKey.marginWidth = 10;
		grpPropertyKey.setLayout(fl_grpPropertyKey);
		
		// Registry key text field.
		rkTextField = new Text(grpPropertyKey, SWT.BORDER);
		rkTextField.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				saveConfiguration();
			}
		});
		{
			rkTextFieldLayoutData = new FormData();
			rkTextFieldLayoutData.right = new FormAttachment(100, -8);
			rkTextField.setLayoutData(rkTextFieldLayoutData);			
		}
		
		Link link = new Link(grpPropertyKey, SWT.NONE);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selectedCommand = e.text;
				if ("file system".equals(selectedCommand)){
					openFileBrowser();
				}else if ("registry".equals(selectedCommand)){
					openRegistryBrowser();
				}else if ("workspace".equals(selectedCommand)){
					openRegistryResourceProviderDialog();
				}else if ("local entries".equals(selectedCommand)){
					openEmbeddedEntryBrowser();
				}
			}
		});
		rkTextFieldLayoutData.top = new FormAttachment(link, 7);
		rkTextFieldLayoutData.left = new FormAttachment(link, 0, SWT.LEFT);
		FormData fd_link = new FormData();
		fd_link.right = new FormAttachment(100, -4);
		fd_link.left = new FormAttachment(0);
		fd_link.top = new FormAttachment(0, -2);
		fd_link.bottom = new FormAttachment(0, 15);
		link.setLayoutData(fd_link);
		//link.setText("Type the key or specify from <a>file system</a>, <a>registry</a>, <a>workspace</a> or <a>local entries</a>");
		link.setText("Type the key or specify from <a>file system</a> or <a>registry</a>");
		/*
		Link link_1 = new Link(grpPropertyKey, SWT.NONE);
		link_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				openNewResourceTemplateDialog();
			}
		});
		FormData fd_link_1 = new FormData();
		fd_link_1.top = new FormAttachment(rkTextField, 6);
		fd_link_1.right = new FormAttachment(rkTextField, 0, SWT.RIGHT);
		link_1.setLayoutData(fd_link_1);
		link_1.setText("<a>Create && point to a new resource...</a>");*/
		loadConfiguration();
		return container;
	}

	private void loadConfiguration() {
		/*if (!StringUtils.isBlank(rkProperty.getKeyValue())) {
			rkTextField.setText(rkProperty.getKeyValue());
		}*/
	}
	
	@Override
	protected void okPressed() {
		saveConfiguration();
		super.okPressed();
	}
	
	private void saveConfiguration() {
		//rkProperty.setKeyValue(rkTextField.getText());
	}
	
	protected void openEmbeddedEntryBrowser() {
		hide();
		try{
			EmbeddedEntriesDialog embeddedEntriesDialog = new EmbeddedEntriesDialog(getParentShell(), null);
			embeddedEntriesDialog.create();
			embeddedEntriesDialog.getShell().setText("Embedded Resources");
			embeddedEntriesDialog.open();
			if (embeddedEntriesDialog.getReturnCode()==Window.OK){
				setSelectedPath(embeddedEntriesDialog.getSelectedItem().trim());
			}			
		}finally{
			show();
		}

	}

	protected void openNewResourceTemplateDialog() {
		hide();
		try{
			NewResourceTemplateDialog newResourceTemplateDialog = new NewResourceTemplateDialog(getParentShell(),null);
			newResourceTemplateDialog.create();
			newResourceTemplateDialog.getShell().setText("New Resource");
			newResourceTemplateDialog.open();
			if (newResourceTemplateDialog.getReturnCode()==Window.OK){
				setSelectedPath(newResourceTemplateDialog.getSelectedPath());
			}
		}finally{
			show();
		}

	}
	
	private void openRegistryBrowser() {
		// Open registry browser.
		hide();
		try{
			IRegistryConnection[] registryConnections = CAppEnvironment.getRegistryHandler().getRegistryConnections();
			if (registryConnections.length==0){
				RegistryConnection registryConnection = new RegistryConnection();
				try {
					registryConnection.setURL(new URL(DEFAULT_REGISTRY_URL));
				} catch (MalformedURLException e) {
					log.error("Error occured while setting registry URL", e);
				}
				registryConnection.setPath("/_system/config");
			}
			
			IRegistryData selectedPathData = CAppEnvironment.getRegistryHandler().selectRegistryPath(registryConnections, "Registry Browser", "Select Registry Resource:",
					IRegistryHandler.SELECTED_REGISTRY_RESOURCE);			
						
			DataMapperSchemaEditorUtil schemaEditorUtil = new DataMapperSchemaEditorUtil(inputFile);
			String schemaFilePath = schemaEditorUtil.createDiagram(selectedPathData, schemaType);
						
			if (selectedPathData!=null && schemaFilePath!=null){

				setSelectedPath(selectedPathData.getPath());
				
				if("input".equals(schemaType)){
					InputEditPart iep = (InputEditPart)selectedEP;
					iep.resetInputTreeFromFile(schemaFilePath); 					
				} else if("output".equals(schemaType)){
					OutputEditPart iep = (OutputEditPart)selectedEP;
					iep.resetOutputTreeFromFile(schemaFilePath); 
				}
				
			}
		} catch (Exception e) {
			log.error("Error occured while opening registry browser", e);
		}finally{
			show();
		}
	}

	private void setSelectedPath(String selectedPath) {
		if (selectedPath.startsWith(G_REG_PATH_PREFIX)) {
			selectedPath = String.format("gov:%s", selectedPath.substring(G_REG_PATH_PREFIX.length()));
		} else if (selectedPath.startsWith(C_REG_PATH_PREFIX)) {
			selectedPath = String.format("conf:%s", selectedPath.substring(C_REG_PATH_PREFIX.length()));
		}
		
		rkTextField.setText(selectedPath);
		if (selectedPath!=null && !selectedPath.trim().equals("")){
			okPressed();
		}
	}
	
	private void openRegistryResourceProviderDialog(){
		hide();
		try{
			DeveloperStudioElementProviderDialog registryResourceProviderSelector = new DeveloperStudioElementProviderDialog(getParentShell(),new Class[]{IRegistryFile.class, IEsbEndpoint.class, IEsbSequence.class, IEsbLocalEntry.class},null);
			registryResourceProviderSelector.create();
			registryResourceProviderSelector.getShell().setText("Workspace Element Providers");
			registryResourceProviderSelector.open();
			if (registryResourceProviderSelector.getReturnCode()==Window.OK){
				setSelectedPath(registryResourceProviderSelector.getSelectedPath());
				/*String localPathOfRegistryKey = registryResourceProviderSelector.getIPathOfSelection();
				((RegistryKeyPropertyImpl)rkProperty).setLocalPathOfRegistryKey(localPathOfRegistryKey);*/
			}
		}finally{
			show();
		}
	}
	
	private void openFileBrowser(){
		hide();
		try{
			Display display = Display.getDefault();
			Shell shell = new Shell(display);		
			FileDialog fid = new FileDialog(shell);
			fid.setFilterExtensions(new String [] {"*.avsc", "*.txt"});
			fid.setText("Input Schema File");
			String filePath = fid.open();
			
			if (!filePath.isEmpty()) {
				setSelectedPath(filePath);

				if("input".equals(schemaType)){
					InputEditPart iep = (InputEditPart)selectedEP;
					iep.resetInputTreeFromFile(filePath); 			
				} else if("output".equals(schemaType)){
					OutputEditPart iep = (OutputEditPart)selectedEP;
					iep.resetOutputTreeFromFile(filePath); 
				}				
				
				InputEditPart iep = (InputEditPart)selectedEP;
				iep.resetInputTreeFromFile(filePath); 
			}
		}finally{
			show();
		}
		
	}
	
}