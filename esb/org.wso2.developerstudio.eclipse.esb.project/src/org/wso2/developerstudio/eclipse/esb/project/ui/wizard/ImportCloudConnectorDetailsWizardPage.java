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

package org.wso2.developerstudio.eclipse.esb.project.ui.wizard;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
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
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ImportCloudConnectorDetailsWizardPage extends WizardPage{

	private Text txtCloudConnectorPath;
	private String cloudConnectorPath;
	private IProject selectedProject;
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);


	protected ImportCloudConnectorDetailsWizardPage(IStructuredSelection selection) {
		super("ESB Connector");
		setTitle("ESB Connector");
		setDescription("Import a connector to ESB Project.");
		try {
			IProject project = getProject(selection);
			if(project!=null){
				setSelectedProject(project);
			}
		} catch (Exception e) {
			log.error("Error reading project", e);
		}
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblCloudConnectorPath = new Label(container, SWT.NONE);
		lblCloudConnectorPath.setText("Connector location");
		
		txtCloudConnectorPath = new Text(container, SWT.BORDER);
		GridData gd_txtPath = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtPath.widthHint = 400;
		txtCloudConnectorPath.setLayoutData(gd_txtPath);		
		txtCloudConnectorPath.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent evt) {
				setCloudConnectorPath(txtCloudConnectorPath.getText());
				txtCloudConnectorPath.setFocus();
				int charcount =txtCloudConnectorPath.getCharCount();
				txtCloudConnectorPath.setSelection(charcount);		
				validate();
			}
		});
		if(cloudConnectorPath!=null){
			txtCloudConnectorPath.setText(cloudConnectorPath);
		}else{
			setPageComplete(false);
		}
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDlg = new FileDialog(getShell());
				String fileName = fileDlg.open();
				if(fileName!=null) {
					txtCloudConnectorPath.setText(fileName);
				}
				validate();
			}
		});
		btnBrowse.setText("Browse..");		
	}
	
	private void validate() {
		if ((getCloudConnectorPath() == null || getCloudConnectorPath().equals(""))) {
			setErrorMessage("Please specify a connector path");
			setPageComplete(false);
			return;
		} else {
			if(!(new File(getCloudConnectorPath())).exists()){
				setErrorMessage("Connector path must be a valid path.");
				setPageComplete(false);
				return;
			}
		}
		setErrorMessage(null);
		setPageComplete(true);
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
	
	public String getCloudConnectorPath() {
		return cloudConnectorPath;
	}

	public void setCloudConnectorPath(String cloudConnectorPath) {
		this.cloudConnectorPath = cloudConnectorPath;
	}
	

	public IProject getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(IProject selectedProject) {
		this.selectedProject = selectedProject;
	}

}
