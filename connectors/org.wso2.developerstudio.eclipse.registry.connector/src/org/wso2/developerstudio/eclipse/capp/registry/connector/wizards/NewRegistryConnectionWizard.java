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
import java.util.Calendar;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryConnection;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryData;
import org.wso2.developerstudio.eclipse.capp.registry.connector.Activator;
import org.wso2.developerstudio.eclipse.capp.registry.connector.utils.RegistryConnectorImageUtils;
import org.wso2.developerstudio.eclipse.capp.registry.connector.utils.RegistryHandlerUtils;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class NewRegistryConnectionWizard extends Wizard implements INewWizard {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private RegistryConnectionPage registryConnectionPage;
	private IStructuredSelection selection;
	private IRegistryConnection registryConnection;
	private boolean createRegistryConnectionAtTheEnd=true;
	
	public boolean performFinish() {
		if (createRegistryConnectionAtTheEnd) {
			if(getProject() != null ){
				RegistryHandlerUtils.addNewRegistryConnection(getProject(),getRegistryConnection());
			}else{
				RegistryHandlerUtils.addNewRegistryConnection(registryConnectionPage.getProject(),getRegistryConnection());
			}
			openRegistryConnection(getRegistryConnection());
			
		}
		return true;
	}

	private void openRegistryConnection(IRegistryConnection regConnection){
		RegistryData registryData = new RegistryData();
		registryData.setURL(regConnection.getURL());
		registryData.setPath(regConnection.getPath());
		CAppEnvironment.getRegistryHandler().openRegistryBrowserView(registryData);
	}

	public void init(IWorkbench arg0, IStructuredSelection selection) {
		this.selection=selection;

	}
    public void addPages() {
    	registryConnectionPage = new RegistryConnectionPage("New Registry Connection", getProject());
    	registryConnectionPage.setTitle("New Registry Connection");
    	registryConnectionPage.setDescription("Create a new registry connection.");
    	registryConnectionPage.setImageDescriptor(RegistryConnectorImageUtils.getInstance().getImageDescriptor("reg-connection-wizard.png"));
    	addPage(registryConnectionPage);
    }
    
    private IProject getProject(){
    	if (selection.getFirstElement() instanceof IProject){
    		return (IProject)selection.getFirstElement();
    	}else{
    		return null;
    	}
    }
    
    public void setProject(IProject project){
    	
    }

	public IRegistryConnection getRegistryConnection() {
		if (registryConnection==null){
			registryConnection=new RegistryConnection();
			try {
				registryConnection.setConnectionName(registryConnectionPage.getConnectionName());
	            registryConnection.setURL(new URL(registryConnectionPage.getServerUrl()));
				registryConnection.setId(String.valueOf(Calendar.getInstance().getTime().getTime()));
				registryConnection.setPath(registryConnectionPage.getPath());
            } catch (MalformedURLException e) {
	            log.error(e);
            }
		}
	    return registryConnection;
    }

//	public IRegistryConnection[] getRegistryConnections(){
//		
//	}

	public void setCreateRegistryConnectionAtTheEnd(boolean createRegistryConnectionAtTheEnd) {
	    this.createRegistryConnectionAtTheEnd = createRegistryConnectionAtTheEnd;
    }


	public boolean isCreateRegistryConnectionAtTheEnd() {
	    return createRegistryConnectionAtTheEnd;
    }
}
