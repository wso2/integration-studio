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

package org.wso2.developerstudio.eclipse.registry.manager.remote.wizards;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.wizard.Wizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserRoleContainer;
import org.wso2.developerstudio.eclipse.usermgt.remote.Activator;

/**
 *
 */
public class AddRoleWizard extends Wizard{
	
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private AddRoleWizardPage1 addRolePage1;
	private SetPermissionWizardPage1 permissionPage1;
//	private SetPermissionWizardPage2 permissionPage2;
	private RegistryUserRoleContainer regUserRoleContainer;
	private RegistryResourceNode resourceNode;
	private RegistryNode registryData;
	private String registryResourcePath;
	
	/**
     * 
     */
    public AddRoleWizard(RegistryUserRoleContainer regUserRoleContainer,RegistryNode registryData, String registryResourcePath,RegistryResourceNode resourceNode) {
    	setWindowTitle("Add New Role");
    	this.registryData=registryData;
    	this.registryResourcePath=registryResourcePath;
    	this.regUserRoleContainer=regUserRoleContainer;
    	this.resourceNode=resourceNode;
    }
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	
	public void addPages() {
		addRolePage1=new AddRoleWizardPage1("Add Role Information", this);
		addPage(addRolePage1);
		permissionPage1=new SetPermissionWizardPage1("Hello",registryData, registryResourcePath,resourceNode);
	    addPage(permissionPage1);
//	    permissionPage2=new SetPermissionWizardPage2("Set role permissions", regUserRoleContainer,addRolePage1, permissionPage1);
//	    addPage(permissionPage2);
	}

	/* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#performFinish()
     */
    
    public boolean performFinish() {
    	try {
	        regUserRoleContainer.getRegistryUserManagerContainer().getUserManager().addRole(addRolePage1.getRoleName(), convert(addRolePage1.getSelectedRoleList()), convertToStringAndArray(permissionPage1.selectedItemList()));
	        regUserRoleContainer.setIterativeRefresh(true);
	        return true;
        } catch (Exception e) {
	        log.error(e);
        }
    	
    	
//    	UserManager mgr=new UserManager(url, user, pass);
//    	try {
//	        mgr.addRole("Martin "+System.currentTimeMillis(), null, null);
//        } catch (RemoteException e) {
//	        e.printStackTrace();
//        } catch (UserAdminExceptionException e) {
//	        e.printStackTrace();
//        } catch (AuthenticationExceptionException e) {
//	        e.printStackTrace();
//        }
//        
        
	    return false;
    }
    
    private String[] convert(List<String> list){
    	String[] arr=new String[list.size()];
    	int i=0;
    	for (Iterator iterator = list.iterator(); iterator.hasNext();i++) {
	        String string = (String) iterator.next();
	        arr[i]=string;
        }
    	return arr;    	
    }
    
    private String[] convertToStringAndArray(List<RegistryResourceNode> list){
    	String[] arr=new String[list.size()];
    	String commonRegPath=registryResourcePath.substring(0, registryResourcePath.lastIndexOf('/'));
    	int i=0;
    	for (Iterator iterator = list.iterator(); iterator.hasNext();i++) {
	        RegistryResourceNode registryResourceNode = (RegistryResourceNode) iterator.next();
	        arr[i]=registryResourceNode.getRegistryResourcePath().substring(commonRegPath.length());
        }
    	return arr;    	
    }

	/**
     * @param regUserRoleContainer the regUserRoleContainer to set
     */
    public void setRegUserRoleContainer(RegistryUserRoleContainer regUserRoleContainer) {
	    this.regUserRoleContainer = regUserRoleContainer;
    }

	/**
     * @return the regUserRoleContainer
     */
    public RegistryUserRoleContainer getRegUserRoleContainer() {
	    return regUserRoleContainer;
    }

}
