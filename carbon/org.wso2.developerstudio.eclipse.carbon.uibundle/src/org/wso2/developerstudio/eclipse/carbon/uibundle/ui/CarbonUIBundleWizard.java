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

package org.wso2.developerstudio.eclipse.carbon.uibundle.ui;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.pde.internal.ui.wizards.NewWizard;
import org.eclipse.pde.internal.ui.wizards.plugin.NewProjectCreationOperation;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginContentPage;
import org.eclipse.pde.internal.ui.wizards.plugin.PluginFieldData;
import org.eclipse.pde.ui.IPluginContentWizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.wso2.developerstudio.eclipse.carbon.uibundle.Activator;
import org.wso2.developerstudio.eclipse.carbon.uibundle.nature.CarbonUIProjectNature;
import org.wso2.developerstudio.eclipse.carbon.uibundle.nature.CarbonUIProjectNatureData;
import org.wso2.developerstudio.eclipse.carbon.uibundle.utils.CarbonUIImageUtils;
import org.wso2.developerstudio.eclipse.carbon.uibundle.utils.Constants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

@SuppressWarnings({ "restriction"})
public class CarbonUIBundleWizard extends NewWizard implements IExecutableExtension, INewWizard {
	private static IDeveloperStudioLog log=Logger.getLog(Activator.PLUGIN_ID);

	private IConfigurationElement fConfig;
	private PluginFieldData fPluginData;
	private IProjectProvider fProjectProvider;
	private NewCarbonUIProjectCreationPage fMainPage;
	private PluginContentPage fContentPage;
	private boolean fPureOSGi;
	private IStructuredSelection selection;
	private String suggestedProjectName;
	private NewCarbonUIBundlePathPage newCarbonUIPathPage;
	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public boolean performFinish() {
		try {
			fMainPage.updateData();
			fContentPage.updateData();
			IDialogSettings settings = getDialogSettings();
			if (settings != null) {
				fMainPage.saveSettings(settings);
				fContentPage.saveSettings(settings);
			}

			IProject project = fProjectProvider.getProject();

			BasicNewProjectResourceWizard.updatePerspective(fConfig);

			IPluginContentWizard contentWizard = null;//fWizardListPage.getSelectedWizard();
			getContainer().run(false, true, new NewProjectCreationOperation(fPluginData, fProjectProvider, contentWizard));

			IWorkingSet[] workingSets = fMainPage.getSelectedWorkingSets();

			if (workingSets.length > 0)
				getWorkbench().getWorkingSetManager().addToWorkingSets(project, workingSets);
			CarbonUIProjectNatureData data = new CarbonUIProjectNatureData(project);
			data.setUrlPath(newCarbonUIPathPage.getPath());
			CarbonUIProjectNature.getProjectData().put(project, data);
			CarbonUIProjectNature.addNatureToProject(project, Constants.PROJECT_NATURE_CARBON_UI_PROJECT);
//			setProjectName(newCarbonUIPathPage.getPrjctName());
			setProjectName(fMainPage.getProjectName());
			return true;
		} catch (InvocationTargetException e) {
			log.error(e);
		} catch (InterruptedException e) {
		} catch (CoreException e) {
			log.error(e);
		}
		return false;
	}

	public CarbonUIBundleWizard() {
		setDialogSettings(Activator.getDefault().getDialogSettings());
		fPluginData = new PluginFieldData();
	}

	public void init(IWorkbench arg0, IStructuredSelection selection) {
		setSelection(selection);
	}

	public CarbonUIBundleWizard(String suggestedProjectName) {
		this();
		setSuggestedProjectName(suggestedProjectName);
	}

	public void addPages() {
		fMainPage = new NewCarbonUIProjectCreationPage("main", fPluginData, fPureOSGi, getSelection()); //$NON-NLS-1$
		fMainPage.setTitle("Carbon UI Component");
		fMainPage.setDescription("Create a new carbon ui component using an OSGI project");
		String pname = getSuggestedProjectName();
		if (pname != null)
			fMainPage.setInitialProjectName(pname);
		addPage(fMainPage);

		fProjectProvider = new IProjectProvider() {
			public String getProjectName() {
				return fMainPage.getProjectName();
			}

			public IProject getProject() {
				return fMainPage.getProjectHandle();
			}

			public IPath getLocationPath() {
				return fMainPage.getLocationPath();
			}
		};

		fContentPage = new PluginContentPage("page2", fProjectProvider, fMainPage, fPluginData); //$NON-NLS-1$
		fContentPage.setTitle("Carbon UI Component");
		fContentPage.setDescription("Specify carbon ui component bundle configuration data");
//		fWizardListPage = new TemplateListSelectionPage(getAvailableCodegenWizards(), fContentPage, PDEUIMessages.WizardListSelectionPage_templates);
//		String tid = getDefaultValue(DEF_TEMPLATE_ID);
//		if (tid != null)
//			fWizardListPage.setInitialTemplateId(tid);
//
		fMainPage.setImageDescriptor(CarbonUIImageUtils.getInstance().getImageDescriptor("carbon-ui-bundle-headder.png"));
		fContentPage.setImageDescriptor(CarbonUIImageUtils.getInstance().getImageDescriptor("carbon-ui-bundle-headder.png"));
		addPage(fContentPage);

		newCarbonUIPathPage = new NewCarbonUIBundlePathPage("Specify deploy path", fProjectProvider);
		newCarbonUIPathPage.setTitle("Carbon UI Component");
		newCarbonUIPathPage.setDescription("Specify carbon ui component path data");

		addPage(newCarbonUIPathPage);


	}

	public boolean canFinish() {
		IWizardPage page = getContainer().getCurrentPage();
		return super.canFinish() && page != fMainPage;
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

	public IStructuredSelection getSelection() {
		return selection;
	}

	public void setInitializationData(IConfigurationElement config, String arg1,
			Object arg2) throws CoreException {
		fConfig=config;
	}

	public void setSuggestedProjectName(String suggestedProjectName) {
		this.suggestedProjectName = suggestedProjectName;
	}

	public String getSuggestedProjectName() {
		return suggestedProjectName;
	}

}
