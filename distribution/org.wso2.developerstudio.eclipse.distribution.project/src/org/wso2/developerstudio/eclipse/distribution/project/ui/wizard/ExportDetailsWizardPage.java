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

package org.wso2.developerstudio.eclipse.distribution.project.ui.wizard;


import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;

public class ExportDetailsWizardPage extends WizardPage {
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	
	private Text txtExportPath;
	private Combo cmbProjects;
	private IProject selectedProject;
	private String exportPath;

	protected ExportDetailsWizardPage(IWorkbench wb, IStructuredSelection selection) {
		super("WSO2 Platform Distribution");
		setTitle("WSO2 Platform Distribution");
		setDescription("Select a project to use to create a deployable artifact.");
		try {
			IProject project = getProject(selection);
			if(project!=null){
				setSelectedProject(project);
				exportPath=(String) getSelectedProject().getSessionProperty(new QualifiedName("",getSelectedProject().getName()));
			}
		} catch (CoreException e){
			log.error("Error getting session properties", e);
		} catch (Exception e) {
			log.error("Error reading project", e);
		}
	}


	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblProject = new Label(container, SWT.NONE);
		lblProject.setText("Project");
		
		cmbProjects = new Combo(container, SWT.NONE|SWT.READ_ONLY);
		cmbProjects.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				if(cmbProjects.getSelectionIndex() !=-1){
					Object obj = cmbProjects.getData(cmbProjects.getText());
					if(obj instanceof IProject){
						setSelectedProject((IProject)obj);
					}
				}
			}
		});
		cmbProjects.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(container, SWT.NONE);
		
		Label lblExportDestination = new Label(container, SWT.NONE);
		lblExportDestination.setText("Export Destination");
		
		txtExportPath = new Text(container, SWT.BORDER);
		GridData gd_txtExportPath = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtExportPath.widthHint = 499;
		txtExportPath.setLayoutData(gd_txtExportPath);		
		txtExportPath.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent evt) {
				setExportPath(txtExportPath.getText());
				txtExportPath.setFocus();
				int charcount =txtExportPath.getCharCount();
				txtExportPath.setSelection(charcount);		
				validate();
			}
		});
		if(exportPath!=null){
			txtExportPath.setText(exportPath);
		}else{
			setPageComplete(false);
		}
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				DirectoryDialog dirDlg = new DirectoryDialog(getShell());
				String dirName = dirDlg.open();
				if(dirName!=null) {
					txtExportPath.setText(dirName);
				}
				validate();
			}
		});
		btnBrowse.setText("Browse..");
		fillProjects();
		if(getSelectedProject()!=null){
			cmbProjects.setText(getSelectedProject().getName());
			cmbProjects.setEnabled(true);
		} 		
	}
	
	public static IProject getProject(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getProject(((IStructuredSelection) obj).getFirstElement());
        }
        return null;
    }

	private void fillProjects(){
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IProject[] projects = root.getProjects();
		cmbProjects.removeAll();
		try {
			for (IProject project : projects) {
					if(project.isOpen()){
						if(project.hasNature(Constants.AXIS2_PROJECT_NATURE) ||
						   project.hasNature(Constants.BPEL_PROJECT_NATURE) ||
						   project.hasNature(Constants.DS_VALIDATOR_PROJECT_NATURE) ||
						   project.hasNature(Constants.JAXWS_PROJECT_NATURE) ||
						   project.hasNature(Constants.JAXRS_PROJECT_NATURE) ||
						   project.hasNature(Constants.WEBAPP_PROJECT_NATURE) ||
						   project.hasNature(Constants.GADGET_PROJECT_NATURE) ||
						   project.hasNature(Constants.LIBRARY_PROJECT_NATURE) ||
						   project.hasNature(Constants.MEDIATOR_PROJECT_NATURE) ||
						   project.hasNature(Constants.REGISTRY_FILTER_PROJECT_NATURE) ||
						   project.hasNature(Constants.REGISTRY_HANDLER_PROJECT_NATURE) ||
						   project.hasNature(Constants.ESB_PROJECT_NATURE) ||
						   project.hasNature(Constants.CARBON_UI_PROJECT_NATURE)||
						   project.hasNature(Constants.ANALYTICS_PROJECT_NATURE)||
						   project.hasNature(Constants.BRS_PROJECT_NATURE)||
						   project.hasNature(Constants.JAGGERY_NATURE)){
							cmbProjects.add(project.getName());
							cmbProjects.setData(project.getName(), project);
							}
					}
			}
		} catch (CoreException e) {
			log.error("Error reading projects", e);
		}
	}
	
	private void validate() {
		if ((getExportPath() == null || getExportPath().equals(""))) {
			setErrorMessage("Please specify a export destination");
			setPageComplete(false);
			return;
		} else if (getSelectedProject()==null){
			setErrorMessage("Please specify a project to export.");
			setPageComplete(false);
			return;
		} else {
			if(!(new File(getExportPath())).exists()){
				setErrorMessage("Export destination must be a valid path.");
				setPageComplete(false);
				return;
			}
		}
		setErrorMessage(null);
		setPageComplete(true);
	}


	public void setSelectedProject(IProject selectedProject) {
		this.selectedProject = selectedProject;
	}


	public IProject getSelectedProject() {
		return selectedProject;
	}
	
	public String getExportPath() {
		return exportPath;
	}

	public void setExportPath(String path) {
		this.exportPath = path;
	}
	
	public Text getTxtExportPathText(){
		return this.txtExportPath;
	}
}

