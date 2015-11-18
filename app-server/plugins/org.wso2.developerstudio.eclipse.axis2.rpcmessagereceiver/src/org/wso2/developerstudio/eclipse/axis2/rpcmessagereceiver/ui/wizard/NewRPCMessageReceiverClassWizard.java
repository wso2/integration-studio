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

package org.wso2.developerstudio.eclipse.axis2.rpcmessagereceiver.ui.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.axis2.rpcmessagereceiver.Activator;
import org.wso2.developerstudio.eclipse.axis2.rpcmessagereceiver.utils.Axis2ImageUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class NewRPCMessageReceiverClassWizard extends Wizard implements INewWizard{
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	IStructuredSelection selection;
	private String className;

	public String getProjectName() {
		return classWizardPage.getSelectedProject();
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	private NewRPCMessageReceiverClassWizardPage classWizardPage;
	public boolean performFinish() {
		try {
			className = classWizardPage.createClass();
			setClassName(className);
        } catch (Exception e) {
	        log.error(e);
	        return false;
        }
		return true;
	}
	
	public void addPages() {
		classWizardPage = new NewRPCMessageReceiverClassWizardPage();
		classWizardPage.init(selection);
		classWizardPage.setImageDescriptor(Axis2ImageUtils.getInstance().getImageDescriptor("axis2-message-receiver-wizard.png"));
		addPage(classWizardPage);
	    
	}
	
	public void init(IWorkbench arg0, IStructuredSelection selection) {
		this.selection=selection;
	}

}
