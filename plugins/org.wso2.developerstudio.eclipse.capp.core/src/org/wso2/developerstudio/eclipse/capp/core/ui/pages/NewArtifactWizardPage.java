/*
 * Copyright 2005,2006 WSO2, Inc. http://www.wso2.org
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

package org.wso2.developerstudio.eclipse.capp.core.ui.pages;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.capp.core.Activator;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.ICAppArtifactManager;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.IServerRole;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class NewArtifactWizardPage extends WizardPage implements Observer{
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private Text txtArtifactName;
	private String artifactName;
	private String artifactVersion;
	private String artifactServerRole;
	private Text txtArtifactVersion;
	private Combo cmbArtifactServerRole;
	
    public NewArtifactWizardPage(){
        super("New WSO2 Artifact");
        setDescription("New artifact details");
    }

    /* (non-Javadoc)
     * @see org.apache.axis2.tool.service.eclipse.ui.AbstractServiceWizardPage#initializeDefaultSettings()
     */
    protected void initializeDefaultSettings() {
    }

	
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        layout.numColumns=2;
        layout.verticalSpacing = 9;
        container.setLayout(layout);
        GridData gd = new GridData();
        gd.horizontalSpan=2;
        
        new Label(container,SWT.NONE).setText("Artifact Name");
        txtArtifactName = new Text(container,SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        txtArtifactName.addModifyListener(new ModifyListener(){
            public void modifyText(ModifyEvent arg0) {
            	setArtifactName(txtArtifactName.getText());
            	validate();
            }
        	
        });
        txtArtifactName.setLayoutData(gd);
        
        new Label(container,SWT.NONE).setText("Version");
        txtArtifactVersion = new Text(container,SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        txtArtifactVersion.addModifyListener(new ModifyListener(){
            public void modifyText(ModifyEvent arg0) {
            	setArtifactVersion(txtArtifactVersion.getText());
            	validate();
            }
        });
        txtArtifactVersion.setLayoutData(gd);
        txtArtifactVersion.setText("1.0.0");
        
        new Label(container,SWT.NONE).setText("Server role");
        cmbArtifactServerRole = new Combo(container,SWT.BORDER);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        cmbArtifactServerRole.addModifyListener(new ModifyListener(){
            public void modifyText(ModifyEvent arg0) {
            	setArtifactServerRole(cmbArtifactServerRole.getText());
            	validate();
            }
        	
        });
        cmbArtifactServerRole.setLayoutData(gd);
        fillServerRoleCombo();
        
		setControl(container);
		setPageComplete(false);
    }
    
    private void validate(){
    	if (getArtifactName()==null || getArtifactName().trim().equals("")){
    		setErrorMessage("The artifact name cannot be blank");
    		setPageComplete(false);
    		return;
    	}
    	
    	if (getArtifactVersion()==null || getArtifactVersion().trim().equals("")){
    		setErrorMessage("The artifact version cannot be blank");
    		setPageComplete(false);
    		return;
    	}

    	if (getArtifactServerRole()==null || getArtifactServerRole().trim().equals("")){
    		setErrorMessage("The artifact server role cannot be blank");
    		setPageComplete(false);
    		return;
    	}
    	
		setErrorMessage(null);
		setPageComplete(true);
    	
    }
    
    private boolean alreadyFillingServerRoles=false;
    
	private void fillServerRoleCombo(){
		if (alreadyFillingServerRoles) {
            return;
        }

		alreadyFillingServerRoles=true;
		String serverRole=cmbArtifactServerRole.getText();
		cmbArtifactServerRole.remove(0, cmbArtifactServerRole.getItemCount()-1);
//		cmbArtifactServerRole.removeAll();
		if (getArtifactXmlPath()!=null){
    		Display.getCurrent().asyncExec(new Runnable(){
                public void run() {
                	while(CAppEnvironment.getcAppManager()==null){
            			try {
            	            Thread.currentThread().sleep(500);
                        } catch (InterruptedException e) {
            	            log.error(e);
                        }
            		}
        			IProject project = getArtifactXmlPath().getProject();
        			ICAppArtifactManager cAppArtifactManager = CAppEnvironment.getcAppManager();
        			if (cAppArtifactManager.isCAppProject(project)){
                		IServerRole[] serverRoles = cAppArtifactManager.getServerRoles(project);
                		for (IServerRole serverRole : serverRoles) {
                			cmbArtifactServerRole.add(serverRole.getServerRoleName());
                        }
        			}
                }
    			
    		});
		}
		cmbArtifactServerRole.setText(serverRole);
		alreadyFillingServerRoles=false;
	}
	
	public void setArtifactName(String artifactName) {
	    this.artifactName = artifactName;
    }

	public String getArtifactName() {
	    return artifactName;
    }

	public void setArtifactVersion(String artifactVersion) {
	    this.artifactVersion = artifactVersion;
    }

	public String getArtifactVersion() {
	    return artifactVersion;
    }

	public void setArtifactServerRole(String artifactServerRole) {
	    this.artifactServerRole = artifactServerRole;
    }

	public String getArtifactServerRole() {
	    return artifactServerRole;
    }

    public void update(Observable o, Object artifactXmlPath) {
    	this.setArtifactXmlPath((IFile) artifactXmlPath);
    	fillServerRoleCombo();
    }
    public void setArtifactXmlPath(IFile artifactXmlPath) {
	    this.artifactXmlPath = artifactXmlPath;
    }

	public IFile getArtifactXmlPath() {
	    return artifactXmlPath;
    }
	private IFile artifactXmlPath;
}
