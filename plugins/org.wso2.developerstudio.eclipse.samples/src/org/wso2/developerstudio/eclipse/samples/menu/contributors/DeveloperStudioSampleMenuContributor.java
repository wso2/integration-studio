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

package org.wso2.developerstudio.eclipse.samples.menu.contributors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.samples.Activator;
import org.wso2.developerstudio.eclipse.samples.contributor.IDeveloperStudioSampleContributor;
import org.wso2.developerstudio.eclipse.samples.utils.ExtensionPointHandler;
import org.wso2.developerstudio.eclipse.samples.wizards.ProjectCreationWizard;

public class DeveloperStudioSampleMenuContributor extends CompoundContributionItem {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	Shell shell;
	
	protected IContributionItem[] getContributionItems() {
		List<IContributionItem> actionsList = new ArrayList<IContributionItem>();
		addActionContributionItems(actionsList);
		return (IContributionItem[])actionsList.toArray(new IContributionItem[]{});
	}

	private void addActionContributionItems(List<IContributionItem> actionsList) {
	    List<IDeveloperStudioSampleContributor> samples = ExtensionPointHandler.getSamples();
        shell = Display.getCurrent().getActiveShell();
		for (IDeveloperStudioSampleContributor sampleContributor : samples) {
			SampleAction sampleAction = new SampleAction(shell,sampleContributor){
                public void execute() {
                	IProject project = getProject(getContributor());
                	if (project!=null){
            			try {
                    		if (!project.exists()){
    	                            project.create(null);
                    		}
                			if (!project.isOpen()){
                				project.open(null);
                			}
                			getContributor().addSampleTo(project);
            			} catch (Exception e) {
            				log.error(e);
                        }
                	}
                }
	        };
			actionsList.add(new ActionContributionItem(sampleAction));

        }
    }

	private IProject getProject(IDeveloperStudioSampleContributor contributor){
		String projectName = getProjectName(contributor);
		ImageDescriptor wizardImage = contributor.getWizardPageImage();
		String title = contributor.getCaption();
		
		ProjectCreationWizard wizard = new ProjectCreationWizard(projectName, title, wizardImage);
		wizard.setWindowTitle(contributor.getCaption());
//		BasicNewProjectResourceWizard wizard = new BasicNewProjectResourceWizard();
		wizard.init(PlatformUI.getWorkbench(), null);
		WizardDialog wizardDialog = new WizardDialog(shell, wizard);
//		String projectName = getProjectName(contributor);
//		IWizardPage[] pages = wizard.getPages();
		wizardDialog.create();
//		for (IWizardPage page : pages) {
//	        if (page instanceof WizardNewProjectCreationPage){
////	        	((WizardNewProjectCreationPage)page).setInitialProjectName(projectName);
////	        	((WizardNewProjectCreationPage)page).
//	        	((WizardNewProjectCreationPage)page).setInitialProjectName("abc");
//	        }
//        }
		
		if (wizardDialog.open()==Dialog.OK){
			IProject createdProject = wizard.getCreatedProject();
			return createdProject;
//			return wizard.getNewProject();
		}else{
			return null;
		}
	}

	private String getProjectName(IDeveloperStudioSampleContributor contributor) {
	    String projectName = contributor.getProjectName();
	    return projectName;
    }
	
	

}
