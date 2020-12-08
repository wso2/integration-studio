/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.developerstudio.eclipse.wso2plugin.template.manager.ui.wizard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectWizardSettings;
import org.wso2.developerstudio.eclipse.platform.core.utils.DeveloperStudioProviderUtils;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsDataPage;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.pages.ProjectOptionsPage;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.Activator;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.project.WSO2PluginProjectModel;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.ui.elements.WSO2PluginSampleExt;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.ui.elements.WSO2PluginSampleExtList;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.util.AbstractDefaultProjectTemplateManager;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.util.DefaultProjectTemplateManager;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.util.IProjectTemplateManager;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.util.WSO2PluginConstants;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class WSO2PluginProjectWizard extends AbstractWSO2ProjectCreationWizard {

	private WSO2PluginProjectModel wso2PluginProjectModel;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	private ISelection selectedPlugin;
	private boolean isWizardSelected = false;
	boolean isProjectCreated = false;

	public WSO2PluginProjectWizard() {
		setWso2PluginProjectModel(new WSO2PluginProjectModel());
		setModel(wso2PluginProjectModel);
		setWindowTitle(WSO2PluginConstants.PROJECT_WIZARD_WINDOW_TITLE);
	}

	private void setWso2PluginProjectModel(WSO2PluginProjectModel wso2PluginProjectModel) {
		this.wso2PluginProjectModel = wso2PluginProjectModel;
	}

	@Override
	public void addPages() {
		URL resource = getWizardManifest();
		try {
			ProjectWizardSettings settings = new ProjectWizardSettings(resource.openStream(), configElement);

			if (settings.getProjectOptions().size() == 1) {
				getModel().setSelectedOption(settings.getProjectOptions().get(0).getId());
			} else {
				addPage(new ProjectOptionsPage(settings, getModel()));
			}
			addPage(new ProjectOptionsDataPage(settings, getModel(), getCurrentSelection(),
					isRequireProjectLocationSection(), isRequiredWorkingSet(), isRequiredWorkspaceLocation()));
			if (isCustomPageRequired()) {
				addPage(getCustomPage());
			}
			addPage(new WSO2PluginListSelectionPage(getAvailableWSO2Plugins(),
					WSO2PluginConstants.PLUGIN_SELECT_WIZARD_PAGE_NAME, this));

		} catch (Exception e) {
			log.error("error adding pages", e);
		}

	}

	@Override
	public IResource getCreatedResource() {
		return null;
	}

	@Override
	public boolean performFinish() {
		Job projectCreationJob = new Job(WSO2PluginConstants.CREATE_PLUGIN_PROJECT_JOB) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				isProjectCreated = openSelectedProjectInWorkspace(selectedPlugin);
				return Status.OK_STATUS;
			}
		};
		projectCreationJob.schedule();
		return true;
	}

	public WSO2PluginSampleExtList getAvailableWSO2Plugins() {
		Map<String, String> availablePluginIds = new HashMap<String, String>();
		WSO2PluginSampleExtList elemList = new WSO2PluginSampleExtList();
		DeveloperStudioProviderUtils devStudioUtils = new DeveloperStudioProviderUtils();
		IConfigurationElement[] elements = devStudioUtils.getExtensionPointmembers(WSO2PluginConstants.EXTENSION_ID);
		for (int j = 0; j < elements.length; j++) {
			WSO2PluginSampleExt element = createWizardElement(elements[j]);
			if (element != null) {
				elemList.addWSO2Plugin(element);
				availablePluginIds.put(element.getId(), element.getPluginName());
			}
		}
		if (WSO2PluginListSelectionPage.isUpdateFromGit) {
			boolean isPluginsUptoDate = true;
			String fileName = WSO2PluginListSelectionPage.tempCloneDir + File.separator;
			List<String> pluginSampleExt = addWizardElemsFromDownloadedPlugins(
					fileName + WSO2PluginConstants.SAMPLE_DESCRIPTION_FILE);
			for (String pluginSampleId : pluginSampleExt) {
				if (!availablePluginIds.containsKey(pluginSampleId)) {
					WSO2PluginSampleExt newElem = generateWSO2PluginSampleExt(fileName, pluginSampleId);
					isPluginsUptoDate = false;
					if (newElem != null) {
						elemList.addWSO2Plugin(generateWSO2PluginSampleExt(fileName, pluginSampleId));
					} else {
						log.error("Template for " + pluginSampleId + "Could not be loaded.");
					}
				}

			}
			if (isPluginsUptoDate) {
				MessageDialog.openInformation(this.getShell(), "Plugin Templates are up-to-date",
						"The plugin template list is up-to-date, no updates");
			}
		}
		return elemList;
	}

	private WSO2PluginSampleExt generateWSO2PluginSampleExt(String fileName, String pluginSamlpeId) {
		Gson gson = new Gson();
		WSO2PluginSampleExt wso2PluginSampleExt = null;
		String fileToRead = fileName + pluginSamlpeId + File.separator + WSO2PluginConstants.SAMPLE_DESCRIPTION_FILE;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileToRead));
			wso2PluginSampleExt = gson.fromJson(br, WSO2PluginSampleExt.class);
			wso2PluginSampleExt.setIsUpdatedFromGit("true");
			wso2PluginSampleExt.setPluginArchive(
					fileName + pluginSamlpeId + File.separator + wso2PluginSampleExt.getPluginArchive());
		} catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
			log.error("Could not load the plugin sample from the archive, error in the sample format " + e);
			MultiStatus status = MessageDialogUtils.createMultiStatus(e.getLocalizedMessage(), e,
					WSO2PluginConstants.PACKAGE_ID);
			// show error dialog
			ErrorDialog.openError(this.getShell(), WSO2PluginConstants.ERROR_DIALOG_TITLE,
					"Could not load the plugin sample from the archive, error in the sample format ", status);
		}

		return wso2PluginSampleExt;

	}

	private List<String> addWizardElemsFromDownloadedPlugins(String fileName) {
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement jsonElement = null;
		List<String> templateIDList = new ArrayList<String>();
		try {
			jsonElement = parser.parse(new FileReader(fileName));
			Type type = new TypeToken<List<String>>() {
			}.getType();
			templateIDList = gson.fromJson(jsonElement, type);
		} catch (JsonIOException | JsonSyntaxException | IOException e1) {
			log.error("Could not read the json file containing the plugin template information " + e1);
			MultiStatus status = MessageDialogUtils.createMultiStatus(e1.getLocalizedMessage(), e1,
					WSO2PluginConstants.PACKAGE_ID);
			// show error dialog
			ErrorDialog.openError(this.getShell(), WSO2PluginConstants.ERROR_DIALOG_TITLE,
					"Could not read the json file containing the plugin template information. Sample List is empty ",
					status);
		}

		return templateIDList;

	}

	protected WSO2PluginSampleExt createWizardElement(IConfigurationElement config) {
		Object execClassObject = null;
		String name = config.getAttribute(WSO2PluginConstants.PLUGIN_NAME);
		String archive = config.getAttribute(WSO2PluginConstants.PLUGIN_ARCHIVE_LOCATION);
		String description = config.getAttribute(WSO2PluginConstants.GET_PLUGIN_DESCRIPTION);
		String providerBundleID = config.getContributor().getName();
		String iconLoc = config.getAttribute(WSO2PluginConstants.ICON);
		String id = config.getAttribute(WSO2PluginConstants.PLUGIN_ID);
		String className = config.getAttribute(WSO2PluginConstants.CLASS);
		if (className != null && !className.isEmpty()) {
			try {
				execClassObject = config.createExecutableExtension("class");
			} catch (CoreException e) {
				log.error("error in loading the class instance from the defined extension point, will attempt to load it via the default project loader.", e);
			}
		}
		if (name == null || archive == null || providerBundleID == null) {
			openSelectedProjectInWorkspace(selectedPlugin);
		}
		WSO2PluginSampleExt pluginElem = new WSO2PluginSampleExt(name, archive, description, providerBundleID, iconLoc,
				String.valueOf(false), id, (AbstractDefaultProjectTemplateManager) execClassObject);
		return pluginElem;
	}

	public boolean openSelectedProjectInWorkspace(ISelection iSelection) {
		DefaultProjectTemplateManager defaultProjectTemplateManager = new DefaultProjectTemplateManager();
		iSelection.getClass();
		if (!(iSelection instanceof IStructuredSelection)) {
			return false;
		}
		IStructuredSelection structSelection = (IStructuredSelection) iSelection;
		WSO2PluginSampleExt element = (WSO2PluginSampleExt) structSelection.getFirstElement();
		String projectName = wso2PluginProjectModel.getPluginProjectName();
		Object classInstance = element.getProjectTemplatemanager();
		if (classInstance != null && classInstance instanceof IProjectTemplateManager) {
			return executeExtension(classInstance, element, projectName);
		} 
		return defaultProjectTemplateManager.executeSelectedProjectTemplate(element, projectName);

	}

	public boolean canFinish() {
		return isWizardSelected;
	}

	public boolean isWizardSelected() {
		return isWizardSelected;
	}

	public void setWizardSelected(boolean isWizardSelected) {
		this.isWizardSelected = isWizardSelected;
	}

	public ISelection getSelectedPlugin() {
		return selectedPlugin;
	}

	public void setSelectedPlugin(ISelection selectedPlugin) {
		this.selectedPlugin = selectedPlugin;
	}

	protected URL getWizardManifest() {
		if (configElement != null) {
			String wizardManifestPath = configElement.getAttribute("wizardManifest");

			URL docBaseResource = FileLocator.find(Platform.getBundle(configElement.getContributor().getName()),
					new Path(wizardManifestPath), null);
			try {
				return FileLocator.toFileURL(docBaseResource);
			} catch (IOException e) {
				log.error("an exception occurred in extracting the Wizard manifest from bundle", e);
				return null;
			}
		}
		return null;
	}

	public boolean executeExtension(final Object execClass, final WSO2PluginSampleExt element, final String projectName) {
		ISafeRunnable runnable = new ISafeRunnable() {
			@Override
			public void handleException(Throwable e) {
				log.error("Exception in client");
			}

			@Override
			public void run() throws Exception {
				((IProjectTemplateManager) execClass).executeSelectedProjectTemplate(element,
						projectName);
			}
		};
		SafeRunner.run(runnable);
		return true;
	}

}
