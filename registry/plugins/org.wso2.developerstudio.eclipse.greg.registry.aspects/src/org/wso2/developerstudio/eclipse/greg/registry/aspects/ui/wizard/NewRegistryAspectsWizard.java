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

package org.wso2.developerstudio.eclipse.greg.registry.aspects.ui.wizard;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.greg.registry.aspects.Activator;
import org.wso2.developerstudio.eclipse.greg.registry.aspects.utils.RegistryAspectMavenUtils;
import org.wso2.developerstudio.eclipse.greg.registry.aspects.utils.RegistryAspectsImageUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class NewRegistryAspectsWizard extends Wizard implements INewWizard{
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	IStructuredSelection selection;
	private NewRegistryAspectsClassWizardPage classWizardPage;
	private String className;

	public String getProjectName() {
		return classWizardPage.getSelectedProject();
	}
	
	public boolean performFinish() {
		try {
	        className = classWizardPage.createClass();
	        setClassName(className);
        } catch (Exception e) {
	        log.error(e);
	        return false;
        }
		
		RegistryAspectMavenUtils.initMavenConfiguration(ResourcesPlugin.getWorkspace().getRoot().getProject(getProjectName()));
		
		return true;
	}
	
	public void addPages() {
		classWizardPage = new NewRegistryAspectsClassWizardPage();
		classWizardPage.init(selection);
		classWizardPage.setImageDescriptor(RegistryAspectsImageUtils.getInstance().getImageDescriptor("registry-aspects-wizard.png"));
		addPage(classWizardPage);
	    
	}
	
	public void init(IWorkbench arg0, IStructuredSelection selection) {
		this.selection=selection;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
