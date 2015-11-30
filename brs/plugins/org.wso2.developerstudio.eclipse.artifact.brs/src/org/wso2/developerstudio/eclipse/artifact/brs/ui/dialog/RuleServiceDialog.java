/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.brs.ui.dialog;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.carbon.rule.common.Rule;
import org.wso2.carbon.rule.common.RuleService;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

/* creates the dialog which accepts rule information */
public class RuleServiceDialog extends Dialog {
	private final RuleService ruleService;
	private int tableIndex;
	private boolean tableEdited = false;
	private String resourceType;
	private String sourceType;
	private String value;
	private String uriValue,inlineValue,registryValue,fileValue;
	private String name;
	private CTabItem inlineTab, uriTab, registerTab, fileTab;
	private static final String[] FILTER_EXTS = { "*.*" };
	private static final String SYMBOLIC_NAME = "org.wso2.developerstudio.eclipse.artifact.proxyservice";
	private IProject project;

	public RuleServiceDialog(Shell parentShell, RuleService ruleservice, IProject project) {
		super(parentShell);
		this.ruleService = ruleservice;
		this.project=project;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite container;
		final Text txtDescription,uriText,registerText,fileText;
		final Combo resourceCombo,fileCombo;
		final CTabFolder sourceTabFolder;
		final StyledText inlineText;
		Button cmdEndPointConRegBrowse,cmdEndPointGovRegBrowse,registryBrowser;

		container = (Composite) super.createDialogArea(parent);
		container.getShell().setText("Input Dialog");
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		Label descriptionLabel = new Label(container, SWT.NULL);
		descriptionLabel.setText("Description");
		txtDescription = new Text(container, SWT.BORDER | SWT.NULL);
		txtDescription.setText(updateRuleDescription());
		GridData descriptionGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		descriptionGridData.widthHint = 200;
		descriptionGridData.horizontalAlignment = GridData.FILL;
		descriptionGridData.verticalAlignment = GridData.FILL;
		txtDescription.setLayoutData(descriptionGridData);

		txtDescription.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent event) {
				setDescription(txtDescription.getText().trim());
			}
		});

		Label resourceLabel = new Label(container, SWT.NULL);
		resourceLabel.setText("Resource Type");
		resourceCombo = new Combo(container, SWT.READ_ONLY);
		resourceCombo.setItems(new String[] { "regular", "dtable" });
		resourceCombo.setText("regular");
		resourceCombo.setText(updateResourceCombo());
		
		setResourceType(resourceCombo.getText().trim());
		resourceCombo.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));

		resourceCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent event) {

				setResourceType(resourceCombo.getText().trim());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent event) {

			}
		});

		Label sourceLabel = new Label(container, SWT.NULL);
		sourceLabel.setText("Source Type");
		sourceTabFolder = new CTabFolder(container, SWT.BORDER | SWT.RESIZE);
		GridData tabgriddata = new GridData();
		tabgriddata.minimumHeight = 400;
		tabgriddata.minimumWidth = 500;
		tabgriddata.grabExcessHorizontalSpace = true;
		tabgriddata.grabExcessVerticalSpace = true;
		tabgriddata.horizontalAlignment = GridData.FILL;
		tabgriddata.verticalAlignment = GridData.FILL;

		sourceTabFolder.setLayoutData(tabgriddata);
		inlineTab = new CTabItem(sourceTabFolder, SWT.NULL);
		inlineTab.setText("inline");
		inlineText = new StyledText(sourceTabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		inlineText.setText(updateInlineText());
		//setValue(updateInlineText());
		GridData inlineTextGridData = new GridData();
		inlineTextGridData.minimumHeight = 500;
		inlineTextGridData.minimumWidth = 500;
		inlineTextGridData.grabExcessHorizontalSpace = true;
		inlineTextGridData.grabExcessVerticalSpace = true;
		inlineText.setLayoutData(inlineTextGridData);
		Font font = new Font(sourceTabFolder.getDisplay(), "Courier New", 12, SWT.NORMAL);
		inlineText.setFont(font);
		Color foreGroundColor = Display.getDefault().getSystemColor(SWT.COLOR_BLUE);
		inlineText.setForeground(foreGroundColor);

		inlineText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				//setValue(inlineText.getText().trim());
				setInline(inlineText.getText().trim());
			}
		});
		inlineTab.setControl(inlineText);

		uriTab = new CTabItem(sourceTabFolder, SWT.NULL);
		uriTab.setText("URI");
		GridLayout uriTabLayout = new GridLayout();
		uriTabLayout.numColumns = 2;
		Composite uriTabComposite = new Composite(sourceTabFolder, SWT.BORDER);
		uriTabComposite.setLayout(uriTabLayout);
		Label uriLabel = new Label(uriTabComposite, SWT.NULL);
		uriLabel.setText("URI");
		uriText = new Text(uriTabComposite, SWT.BORDER | SWT.SINGLE);
		uriText.setText(updateUriText());
		GridData uriGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		uriGridData.widthHint = 180;
		uriGridData.horizontalAlignment = GridData.FILL;
		uriGridData.verticalAlignment = GridData.FILL;
		uriText.setLayoutData(uriGridData);

		uriText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				//setValue(uriText.getText().trim());
				seturiValue(uriText.getText().trim());
			}
		});

		uriTab.setControl(uriTabComposite);

		registerTab = new CTabItem(sourceTabFolder, SWT.NULL);
		registerTab.setText("registry");
		GridLayout registerTabLayout = new GridLayout();
		registerTabLayout.numColumns = 4;
		Composite registerTabComposite = new Composite(sourceTabFolder, SWT.BORDER);
		registerTabComposite.setLayout(registerTabLayout);
		Label registerLabel = new Label(registerTabComposite, SWT.NULL);
		registerLabel.setText("Resource URI");
		registerText = new Text(registerTabComposite, SWT.BORDER | SWT.SINGLE|SWT.READ_ONLY);
		registerText.setText(updateRegistryText());
		GridData registerGridData = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		registerGridData.widthHint = 180;
		registerGridData.horizontalAlignment = GridData.FILL;
		registerGridData.verticalAlignment = GridData.FILL;
		registerText.setLayoutData(registerGridData);
		registryBrowser=new Button(registerTabComposite, SWT.NONE);
		registryBrowser.setLayoutData(new GridData(SWT.CENTER,
				SWT.CENTER, false, false, 1, 1));

		registryBrowser.setText("Registry Browser");
		registryBrowser.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent evt) {
				try{
				BrsRegistryKeyPropertyEditorDialog registryDialog=new BrsRegistryKeyPropertyEditorDialog(Display.getCurrent().getActiveShell(),SWT.NULL);
				registryDialog.open();
				
				registerText.setText(registryDialog.getRegistryValue());
				}catch(IllegalArgumentException e){
					
				}
			
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});

		registerText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent arg0) {
				//setValue(registerText.getText().trim());
				setRegistry(registerText.getText().trim());
			}
		});

		registerTab.setControl(registerTabComposite);

		fileTab = new CTabItem(sourceTabFolder, SWT.NULL);
		fileTab.setText("file");
		GridLayout fileTabLayout = new GridLayout();
		fileTabLayout.numColumns = 3;
		Composite fileTabComposite = new Composite(sourceTabFolder, SWT.BORDER);
		fileTabComposite.setLayout(fileTabLayout);
		Label fileLabel = new Label(fileTabComposite, SWT.NULL);
		fileLabel.setText("File");
		
		fileCombo=new Combo(fileTabComposite, SWT.DROP_DOWN);
		
		IFolder confFolder = ProjectUtils.getWorkspaceFolder(project, "src", "main", "ruleservice","conf");
		try {
			IResource[] confResources=confFolder.members();
			String[] ruleFilesResources=new String[confResources.length];
			for(int i=0;i<ruleFilesResources.length;i++){
				ruleFilesResources[i]=confResources[i].getName();
			}
			fileCombo.setItems(ruleFilesResources);
			fileCombo.setText(updateFileText());
			setFile(fileCombo.getText().trim());
			fileCombo.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent event) {

					setFile(fileCombo.getText().trim());
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent event) {

				}
			});
		} catch (CoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Button browseButton = new Button(fileTabComposite, SWT.CENTER);
		browseButton.setText("Browse");

		browseButton.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				FileDialog fileDialog = new FileDialog(container.getShell());
				fileDialog.setFilterExtensions(FILTER_EXTS);
				String path=fileDialog.open();
				String fileName =fileDialog.getFileName();
				if (fileName != null) {
					fileCombo.setText(fileName);
					setFile(fileCombo.getText().trim());
					
					
					try {
					File drlFile=new File(path);
					fileCombo.add(fileCombo.getText().trim());
					IPath conf = project.getFolder(
							"src" + File.separator + "main" + File.separator
							+ "ruleservice" + File.separator + "conf").getLocation();
					
						FileUtils.copy(drlFile,new File(conf.toFile().getPath(),drlFile.getName()));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch(NullPointerException e){
						MessageBox msgBox = new MessageBox(getShell(),
								SWT.ICON_INFORMATION);
						msgBox.setMessage("There are no files selected yet. Please select a file");
						msgBox.open();
					}
					
				}
			}
		});

		fileTab.setControl(fileTabComposite);
		sourceTabFolder.setSelection(updateSourceTab());
		setSource(sourceTabFolder.getSelection().getText());

		sourceTabFolder.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				setSource(sourceTabFolder.getSelection().getText());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent event) {
			}
		});

		setDialogLocation();

		return container;
	}



	public void editEditorInputTable(int tableindex) {
		this.tableIndex = tableindex;
		this.tableEdited = true;
		Rule rule = ruleService.getRuleSet().getRules().get(tableindex);
		setResourceType(rule.getResourceType());
		setSource(rule.getSourceType());
		
		if(rule.getSourceType().equals("inline")){
			setInline(rule.getValue());
		}
		else if(rule.getSourceType().equals("URI")){
			seturiValue(rule.getValue());
		}
		else if(rule.getSourceType().equals("registry")){
			setRegistry(rule.getValue());
		}
		else{
			setFile(rule.getValue());
		}
		setDescription(rule.getDescription());
	}

	public void updateEditorWithRuleInfo() {
		Rule rule = new Rule();
		rule.setResourceType(getResource());
		rule.setSourceType(getSource());
		if(getSource().equals("inline")){
			rule.setValue(getInline());
		}else if(getSource().equals("URI")){
			rule.setValue(getUriValue());
		}
		else if(getSource().equals("registry")){
			rule.setValue(getRegistry());
		}
		else{
			rule.setValue(getFile());
		}
		//rule.setValue(getValue());
		rule.setDescription(getDescription());
		ruleService.getRuleSet().addRule(rule);
	}

	public String updateRuleDescription() {

		if (getDescription() != null) {
			return getDescription();
		} else
			return "";
	}

	private String updateResourceCombo() {
		String txtResourceCombo;
		if (getResource() != null) {
			txtResourceCombo = getResource();
			return txtResourceCombo;
		} else
			return "";
	}

	private CTabItem updateSourceTab() {

		if (getSource() != null && getSource().equals(inlineTab.getText())) {
			return inlineTab;
		}
		if (getSource() != null && getSource().equals(registerTab.getText())) {
			return registerTab;
		}
		if (getSource() != null && getSource().equals(fileTab.getText())) {
			return fileTab;
		} else

			return uriTab;
	}

	private String updateInlineText() {

		if (getInline() != null) {
			return getInline();
		} else
			return "";
	}
	private String updateUriText() {

		if(getUriValue()!=null){
			return getUriValue();
		} else
			return "";
	}
	private String updateRegistryText() {

		if(getRegistry()!=null){
			return getRegistry();
		}else
			return "";
	}
	private String updateFileText() {

		if(getFile()!=null){
			return getFile();
		}else
			return "";
	}
	@Override
	protected void okPressed() {

		if (tableEdited == true) {
			updateEditInputTable();
		} else {
			updateEditorWithRuleInfo();
		}

		super.okPressed();
	}
	
	@Override
	protected void cancelPressed(){
		super.cancelPressed();
	}

	private void updateEditInputTable() {
		Rule rule = new Rule();
		rule.setResourceType(getResource());
		rule.setSourceType(getSource());
		if(getSource().equals("inline")){
			rule.setValue(getInline());
		}else if(getSource().equals("URI")){
			rule.setValue(getUriValue());
		}
		else if(getSource().equals("registry")){
			rule.setValue(getRegistry());
		}
		else{
			rule.setValue(getFile());
		}
		//rule.setValue(getValue());
		rule.setDescription(getDescription());
		ruleService.getRuleSet().getRules().set(tableIndex, rule);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	private void setDialogLocation() {
		Rectangle monitorArea = getShell().getDisplay().getPrimaryMonitor().getBounds();
		Rectangle shellArea = getShell().getBounds();
		int x = monitorArea.x + (monitorArea.width - shellArea.width) / 2;
		int y = monitorArea.y + (monitorArea.height - shellArea.height) / 2;
		getShell().setLocation(x, y);
	}

	public String getResource() {
		return resourceType;
	}

	public String getSource() {
		return sourceType;
	}

	public String getValue() {
		return value;
	}

	public String getInline() {
		return inlineValue;
	}
	public void setInline(String value) {
		this.inlineValue = value;
	}
	public String getFile() {
		return fileValue;
	}
	public void setFile(String value) {
		this.fileValue = value;
	}
	public String getRegistry() {
		return registryValue;
	}
	public void setRegistry(String value) {
		this.registryValue = value;
	}


	public String getUriValue() {
		return uriValue;
	}
	public void seturiValue(String value) {
		this.uriValue = value;
	}

	public String getDescription() {
		return name;
	}

	public void setResourceType(String resource) {
		this.resourceType = resource;
	}

	public void setSource(String source) {
		this.sourceType = source;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setDescription(String servicename) {
		this.name = servicename;
	}

}
