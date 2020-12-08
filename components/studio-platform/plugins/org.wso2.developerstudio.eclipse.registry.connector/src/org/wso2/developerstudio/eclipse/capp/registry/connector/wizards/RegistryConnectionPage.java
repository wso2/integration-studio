/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.capp.registry.connector.wizards;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
//import org.wso2.developerstudio.eclipse.capp.project.ui.wizard.CAppProjectWizard;
//import org.wso2.developerstudio.eclipse.capp.project.utils.CAppConstants;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryHandler;

public class RegistryConnectionPage extends WizardPage {

	private String serverUrl;
	private String path;
	private String connectionName;
	
//	private String userName;
//	private String passwd;
//	private boolean savePassword;
	private IProject project;
	private IRegistryHandler registryHandler = CAppEnvironment.getRegistryHandler();
	private GridData gd_1;
	private Combo projectsCombo;
	private IProject cappProject;
	
	public IProject getCappProject() {
		return cappProject;
	}

	public void setCappProject(IProject cappProject) {
		this.cappProject = cappProject;
	}

	protected RegistryConnectionPage(String pageName, IProject project) {
	    super(pageName);
	    setProject(project);
    }

	public void createControl(Composite parent) {
		Composite container = new Composite(parent,SWT.None);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		Group group = new Group(container,SWT.None);
		layout = new GridLayout();
		layout.numColumns = 2;
		group.setLayout(layout);
		if (getProject()==null || !CAppEnvironment.getcAppManager().isCAppProject(getProject())){
			updatePageStatus("Select a carbon application project to create registry connections");
			setControl(container);
		}
		
		GridData gd = new GridData(GridData.FILL_HORIZONTAL
				| GridData.VERTICAL_ALIGN_FILL);
		container.setLayoutData(gd);
		gd_1 = new GridData(GridData.FILL_HORIZONTAL
		  				| GridData.VERTICAL_ALIGN_FILL);
		gd_1.heightHint = 176;
		
		group.setLayoutData(gd_1);
		Label nameLabel = new Label(group, SWT.NONE);
		nameLabel.setText("Connection Name ");

		Text nameText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		nameText.setLayoutData(gd);

		nameText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				Text name = (Text) event.widget;
				connectionName = name.getText();
				setConnectionName(connectionName);
			}
		});
		gd=new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan=2;
		new Label(group,SWT.SEPARATOR|SWT.HORIZONTAL).setLayoutData(gd);
		
		Label urlLabel = new Label(group, SWT.NONE);
		urlLabel.setText("URL ");

		Text urlText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		urlText.setLayoutData(gd);

		urlText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				Text url = (Text) event.widget;
				serverUrl = url.getText();
				setServerUrl(serverUrl);
			}
		});

		Label pathLabel = new Label(group, SWT.NONE);
		pathLabel.setText("Collection Path ");

		Text pathText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		pathText.setLayoutData(gd);

		pathText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent event) {
				Text url = (Text) event.widget;
				path = url.getText();
				setPath(path);
			}
		});
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setText("C-App Project");
		
		projectsCombo = new Combo(group, SWT.READ_ONLY);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		projectsCombo.setLayoutData(gd);
		
		try {
			loadProjects();
		} catch (CoreException e) {
			e.printStackTrace();
		}
		
//		Link createNewCAppLink = new Link(group, SWT.NULL);
//		gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
//		gd.horizontalSpan = 2;
//		createNewCAppLink.setLayoutData(gd);
//		createNewCAppLink.setText("<a>Create a new C-App project...</a>");
//		
//		createNewCAppLink.addSelectionListener(new SelectionAdapter() {
//			public void widgetSelected(SelectionEvent e) {
//				String selectedCommand = e.text;
//				if (selectedCommand.equals("Create a new C-App project...")){
//					openProjectCreation();
//				}
//			}
//		});
		
		projectsCombo.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				IProject selectedCAppProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectsCombo.getText());
				setProject(selectedCAppProject);
			}
		});
		
		if(projectsCombo.getItemCount() > 0){
			projectsCombo.setEnabled(true);
			setSelectedProject();
		}else{
			projectsCombo.setEnabled(false);
		}
		
		String connectionName="NewConnection";
		String proposedRegistryConnectionName;
		int i=1;
		while(true){
			proposedRegistryConnectionName=connectionName+i;
			if (registryHandler.isRegistryConnectionPresent(project, proposedRegistryConnectionName)){
				i++;
			}else{
				break;
			}
		}
		nameText.setText(proposedRegistryConnectionName);
		urlText.setText("https://localhost:9443/registry");
//		userNameText.setText("admin");
//		pwdText.setText("admin");
		pathText.setText("/");
		validate();
		setControl(container);
	}
	
//	private void openProjectCreation(){
//		CAppProjectWizard cappProjectWizard = new CAppProjectWizard();
//		cappProjectWizard.init(PlatformUI.getWorkbench(),  null);
//		cappProjectWizard.setForcePreviousAndNextButtons(true);
//		WizardDialog wizardDialog = new WizardDialog(getShell(),cappProjectWizard);
//		if (wizardDialog.open()==Window.OK){
//			IProject createdCAppProject = cappProjectWizard.getCreatedProject();
//			setProject(createdCAppProject);
//		}
//		projectsCombo.setEnabled(true);
//		projectsCombo.add(getProject().getName());
//		projectsCombo.setText(getProject().getName());
//		validate();
////		projectsCombo.remove("No Available C-App projects");
//	}
	
	private void loadProjects() throws CoreException{
		projectsCombo.removeAll();
		projectsCombo.setEnabled(true);
		List<IProject> cAppPrjects = new ArrayList<IProject>();
		IProject[] wsProjects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for (IProject iProject : wsProjects) {
			if(iProject.hasNature("org.wso2.developerstudio.eclipse.distribution.project.nature")){
				cAppPrjects.add(iProject);
			}
		}
		
		for (IProject cappProject : cAppPrjects) {
			projectsCombo.add(cappProject.getName());
		}
		
	}
	
	private void setSelectedProject() {
		String[] items = projectsCombo.getItems();
		int index = 0;
		if (getProject() != null) {
			for (int i = 0; i < items.length; i++) {
				if (items[i].equalsIgnoreCase(getProject().getName())) {
					index = i;
					break;
				}
			}
		}
		projectsCombo.select(index);
	}

	private void validate(){
		if (getConnectionName()==null || getConnectionName().equals("")){
        	updatePageStatus("The name is not valid");
	        return;
        }
		
		if (registryHandler.isRegistryConnectionPresent(project, getConnectionName())){
        	updatePageStatus("The connection name already exists. Please choose another");
	        return;
        }
		
		try {
	        new URL(getServerUrl());
        } catch (MalformedURLException e) {
	        updatePageStatus("The registry url is invalid");
	        return;
        }
        
        if (getPath()==null || getPath().equals("")){
        	updatePageStatus("The path is invalid");
	        return;
        }
        
        if(projectsCombo.getText() == null || projectsCombo.getText().equals("")){
        	updatePageStatus("No C-App projects in the workspace. Please create a C-App project.");
	        return;
        }
        
        updatePageStatus(null);
	}
	
	private void updatePageStatus(String msg){
		setErrorMessage(msg);
		setPageComplete(msg==null);
	}
	
	public boolean isAllDatavalid() {
		return false;
	}
	
	public String getServerUrl() {
		return serverUrl;
	}

	public void setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
		validate();
	}

//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getPasswd() {
//		return passwd;
//	}
//
//	public void setPasswd(String pwd) {
//		this.passwd = pwd;
//	}

	public void setPath(String path) {
		this.path = path;
		validate();
	}

	public String getPath() {
		return path;
	}

	public void setProject(IProject project) {
	    this.project = project;
    }

	public IProject getProject() {
	    return project;
    }

	public void setConnectionName(String connectionName) {
	    this.connectionName = connectionName;
	    validate();
    }

	public String getConnectionName() {
	    return connectionName;
    }

//	public void setSavePassword(boolean savePassword) {
//		this.savePassword = savePassword;
//	}
//
//	public boolean isSavePassword() {
//		return savePassword;
//	}
}
