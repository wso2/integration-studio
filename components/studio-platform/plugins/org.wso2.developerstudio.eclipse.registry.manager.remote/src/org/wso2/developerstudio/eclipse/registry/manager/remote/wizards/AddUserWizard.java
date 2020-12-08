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

import java.rmi.RemoteException;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.wso2.carbon.core.services.authentication.AuthenticationExceptionException;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.registry.base.logger.ExceptionHandler;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUser;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryUserContainer;
import org.wso2.developerstudio.eclipse.usermgt.remote.Activator;
import org.wso2.developerstudio.eclipse.usermgt.remote.UserManager;

public class AddUserWizard extends Wizard {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private AddUserInfoWizardPage userInfoPage;
	private RegistryUserContainer regUserContainer;
	private UserManager regUserManager;
	private ExceptionHandler exHandler;
	public boolean isNew;
	private RegistryUser regUser;
	private RegistryNode regData;

	public RegistryNode getRegData() {
		return regData;
	}

	public void setRegData(RegistryNode regData) {
		this.regData = regData;
	}

	public AddUserWizard(Object object, boolean isNew, RegistryNode regData) {
		super();
		if (object instanceof RegistryUserContainer) {
			this.regUserContainer = (RegistryUserContainer) object;
		} else if (object instanceof RegistryUser) {
			this.regUser = (RegistryUser) object;
		}
		this.regData = regData;
		if (this.regUserContainer != null) {
			this.regUserManager = regUserContainer
					.getRegistryUserManagerContainer().getUserManager();
		} else {
			this.regUserManager = regData.getUserManagerContent()
					.getUserManager();
		}
		exHandler = new ExceptionHandler();
		this.isNew = isNew;
		setNeedsProgressMonitor(true);
		String userAction = "";
		if(isNew){
			userAction = "Add User Info";
		}else{
			userAction = "Modify User Info";
		}
		setWindowTitle(userAction);
	}

	public boolean performFinish() {
		try {
			doFinish();
		} catch (Exception e) {
	        log.error(e);
			exHandler.showMessage(Display.getCurrent().getActiveShell(),
					"User "+userInfoPage.getUserName()+" cannot be added. There is an existing user account by the same name.");
			return false;
		}

		return true;
	}

	public void addPages() {
		String userAction = "";
		if(isNew){
			userAction = "Add User Info";
		}else{
			userAction = "Modify User Info";
		}
		userInfoPage = new AddUserInfoWizardPage(userAction, this);
		addPage(userInfoPage);
	}

	public void doFinish() throws RemoteException, 
			AuthenticationExceptionException, Exception {

		String[] selectedRoles = new String[userInfoPage.getSelectedRoleList()
				.size()];
		for (int i = 0; i < userInfoPage.getSelectedRoleList().size(); i++) {
			selectedRoles[i] = userInfoPage.getSelectedRoleList().get(i);
		}
		if (isNew) {
			regUserManager.addUser(userInfoPage.getUserName(), userInfoPage
					.getPwd(), selectedRoles);
		} else {
			if(!userInfoPage.getPwd().equals("")  && 
				!userInfoPage.getRepeatPwd().equals("") && 
				userInfoPage.passwordMatch(userInfoPage.getPwd(), userInfoPage.getRepeatPwd())){
				regUserManager.changePWD(regUser.getUserName(), userInfoPage.getPwd());
				regUserManager.updateUserRoles(regUser.getUserName(), selectedRoles);
			}
			
			
		}
	}

	public RegistryUserContainer getRegUserContainer() {
		return regUserContainer;
	}

	public void setRegUserContainer(RegistryUserContainer regUserContainer) {
		this.regUserContainer = regUserContainer;
	}

	public RegistryUser getRegUser() {
		return regUser;
	}

	public void setRegUser(RegistryUser regUser) {
		this.regUser = regUser;
	}

}
