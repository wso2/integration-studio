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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CarExportDetailsWizardPage extends WizardPage {
	private Text txtExportPath;
	private Text txtName;
	private Text txtVersion;
	private String name = "";
	private String version = "";
	private String initialName = "";
	private String initialVersion = "";
	private String exportPath = "";
	private IProject selectedProject;
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
	private boolean pageDirty = false;

	protected CarExportDetailsWizardPage() {
		super("WSO2 Platform Distribution");
		setTitle("WSO2 Platform Distribution");

	}
	
	protected CarExportDetailsWizardPage(IWorkbench wb, IStructuredSelection selection) {
		super("WSO2 Platform Distribution");
		setTitle("WSO2 Platform Distribution");
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
	
	public void setName(String carName) {
		this.name = carName;
	}

	public String getName() {
		return name;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getVersion() {
		return version;
	}


	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblName = new Label(container, SWT.NONE);
		GridData gd_lblName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblName.widthHint = 79;
		lblName.setLayoutData(gd_lblName);
		lblName.setText("Name");
		
		txtName = new Text(container, SWT.BORDER);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 2, 1);
		gd_text.widthHint = 253;
		txtName.setLayoutData(gd_text);
		initialName = getName();
		txtName.setText(initialName);
		txtName.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent evt) {
				setName(txtName.getText());
				validate();
			}
		});
		
		Label lblVersion = new Label(container, SWT.NONE);
		lblVersion.setText("Version");
		
		txtVersion = new Text(container, SWT.BORDER);
		GridData gd_txtVersion = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtVersion.widthHint = 253;
		initialVersion = getVersion();
		txtVersion.setText(initialVersion);
		txtVersion.setLayoutData(gd_txtVersion);
		txtVersion.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent evt) {
				setVersion(txtVersion.getText());
				validate();
			}
		});
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
	}

	
	private void validate() {
		 if ((getName() == null || getName().equals("")) || getVersion() == null
				|| getVersion().equals("")) {
			setErrorMessage("Please specify a name and version to to .car file.");
			setPageComplete(false);
			return;
		} else if (!getName().matches("[_a-zA-Z0-9\\-\\.]+")) {
			setErrorMessage("Could not create CAR files with special characters");
			setPageComplete(false);
			return;
		} else if ((getExportPath() == null || getExportPath().equals(""))) {
			setErrorMessage("Please specify a export destination");
			setPageComplete(false);
			return;
		} else {
			String version = txtVersion.getText();
			String[] versionParts = version.split("\\.");
			if (version.endsWith(".")) {
				setErrorMessage("File version cannot end with period.");
				setPageComplete(false);
				return;
			}
			if (versionParts.length > 4) {
				setErrorMessage("File version should be in the standared format.");
				setPageComplete(false);
				return;
			}
			if (!Character.isDigit(version.charAt(0))) {
				setErrorMessage("File version should start with a numeric value.");
				setPageComplete(false);
				return;
			}
			if(!(new File(getExportPath())).exists()){
				setErrorMessage("Export destination must be a valid path.");
				setPageComplete(false);
				return;
			}
		}
		setPageDirtyState();
		setErrorMessage(null);
		setPageComplete(true);
	}

	private void setPageDirtyState() {
		if (getName().equals(initialName) && getVersion().equals(initialVersion)){
			pageDirty = false;
		} else {
			pageDirty = true;
		}
	}
	
	public boolean isPageDirty(){
		return pageDirty;
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
		return txtExportPath;
	}
}

