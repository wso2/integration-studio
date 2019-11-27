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

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.WizardSelectionPage;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.DeveloperPreferencePage;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.PreferenceInitializer;
import org.wso2.developerstudio.eclipse.platform.ui.preferences.UpdateCheckerPreferencePage;
import org.wso2.developerstudio.eclipse.platform.ui.utils.MessageDialogUtils;
import org.wso2.developerstudio.eclipse.platform.ui.utils.PluginImageUtils;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.Activator;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.ui.elements.WSO2PluginSampleExt;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.ui.elements.WSO2PluginSampleExtList;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.util.JGitSampleRepoManager;
import org.wso2.developerstudio.eclipse.wso2plugin.template.manager.util.WSO2PluginConstants;

public class WSO2PluginListSelectionPage extends WizardSelectionPage {

	TableViewer wizardSelectionViewer;
	private WSO2PluginFormBrowser descriptionBrowser;
	private WSO2PluginSampleExtList wso2ElemList;
	private WSO2PluginProjectWizard wso2PluginProjectWizard;
	private boolean isPluginProjectSelected;
	public static boolean isUpdateFromGit;
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public WSO2PluginListSelectionPage(WSO2PluginSampleExtList elemList, String pageName,
	                                   WSO2PluginProjectWizard wso2PluginProjectWizard) {
		super(pageName);
		this.wso2PluginProjectWizard = wso2PluginProjectWizard;
		this.wso2ElemList = elemList;
		setTitle("Templates");
		setDescription(WSO2PluginConstants.PLUGIN_SELECTION_WIZARD_DESCRIPTION);
		setImageDescriptor(PluginImageUtils.getInstance().getImageDescriptor("templates-icon.png"));
	}

	private WizardSelectedAction pluginProjectSelectedAction = new WizardSelectedAction();
	private IBaseLabelProvider ListItemLabelProvider = new ListItemLabelProvider();
	public static String tempCloneDir = null;

	private class WizardSelectedAction extends Action {
		public WizardSelectedAction() {
			super("wizardSelection"); //$NON-NLS-1$
		}

		@Override
		public void run() {
			selectionChanged(new SelectionChangedEvent(wizardSelectionViewer, wizardSelectionViewer.getSelection()));
			wso2PluginProjectWizard.setSelectedPlugin(wizardSelectionViewer.getSelection());
			wso2PluginProjectWizard.setWizardSelected(isPluginProjectSelected);
		}
	}

	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);

		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 10;
		container.setLayout(layout);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label label = new Label(container, SWT.NONE);
		label.setText("Select the WSO2 Developer Studio Plugin you want to Create from the List Below.");
		GridData gd = new GridData();
		label.setLayoutData(gd);

		SashForm sashForm = new SashForm(container, SWT.HORIZONTAL);
		gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 300;
		sashForm.setLayoutData(gd);

		wizardSelectionViewer = new TableViewer(sashForm, SWT.BORDER);
		wizardSelectionViewer.setContentProvider(PluginContentProvider.getInstance());
		wizardSelectionViewer.setLabelProvider(ListItemLabelProvider);
		
		Button updateButton = new Button(container, SWT.PUSH);
		updateButton.setText("update plugin templates");
		GridData bGrid = new GridData();
		updateButton.setLayoutData(bGrid);
		updateButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				String property = WSO2PluginConstants.JAVA_IO_TMPDIR;
				String tempDir = System.getProperty(property);
				tempCloneDir = tempDir + File.separator + WSO2PluginConstants.DEV_STUDIO_CLONED_SAMPLES;
				if (isInternetReachable()) {
					container.getDisplay().asyncExec(new Runnable() {

						@Override
						public void run() {
							if(updateSampleTemplates()){
								isUpdateFromGit = true;
								WSO2PluginProjectWizard wso2PluginProjectWizard = new WSO2PluginProjectWizard();
								WSO2PluginSampleExtList updatedElemList = wso2PluginProjectWizard.getAvailableWSO2Plugins();
								wizardSelectionViewer.setInput(updatedElemList);
							}
						}
					});

				} else if ((new File(tempCloneDir)).exists()) {
					container.getDisplay().asyncExec(new Runnable() {

						@Override
						public void run() {
							isUpdateFromGit = true;
							WSO2PluginProjectWizard wso2PluginProjectWizard = new WSO2PluginProjectWizard();
							WSO2PluginSampleExtList updatedElemList = wso2PluginProjectWizard.getAvailableWSO2Plugins();
							wizardSelectionViewer.setInput(updatedElemList);
						}
					});
					MultiStatus status =
		                     MessageDialogUtils.createMultiStatus("", new Throwable(),
		                                                          WSO2PluginConstants.PACKAGE_ID);
					ErrorDialog.openError(wizardSelectionViewer.getTable().getShell(),
					                      WSO2PluginConstants.ERROR_DIALOG_TITLE,
					                      "You are not connected to the internet, Using previously cloned temaplates list, please retry with a working internet connection to view latest templates. ",
					                      status);

				} else {
					MultiStatus status =
		                     MessageDialogUtils.createMultiStatus("", new Throwable(),
		                                                          WSO2PluginConstants.PACKAGE_ID);
					// show error dialog
					ErrorDialog.openError(wizardSelectionViewer.getTable().getShell(),
					                      WSO2PluginConstants.ERROR_DIALOG_TITLE,
					                      "You are not connected to the internet, Please make sure you are connected to the internet to update plugin templates. ",
					                      status);
				}

			}
		});

		createDescriptionIn(sashForm);
		initializeViewer();

		wizardSelectionViewer.setInput(wso2ElemList);
		Dialog.applyDialogFont(container);
		setControl(container);
		
		wizardSelectionViewer.getTable().addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				isPluginProjectSelected = true;
				wso2PluginProjectWizard.setSelectedPlugin(wizardSelectionViewer.getSelection());
				wso2PluginProjectWizard.setWizardSelected(isPluginProjectSelected);
				pluginProjectSelectedAction.run();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// no implementation
			}
		});
	}

	public void createDescriptionIn(Composite composite) {
		descriptionBrowser = new WSO2PluginFormBrowser(SWT.BORDER | SWT.V_SCROLL);
		descriptionBrowser.setText("");
		descriptionBrowser.createControl(composite);
		Control c = descriptionBrowser.getControl();
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.widthHint = 200;
		c.setLayoutData(gd);
	}

	protected void initializeViewer() {
	}

	private boolean updateSampleTemplates() {
		IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(PreferenceInitializer.PREFERENCES_PLUGIN_ID);
		String value = prefs.get(DeveloperPreferencePage.PLUGIN_TEMPLATE_URL, PreferenceInitializer.KERNEL_SAMPLES_GIT);
		if (value == null || value.isEmpty()) {
			value = PreferenceInitializer.KERNEL_SAMPLES_GIT;
		}
		String gitRepoURL = value;
		File yourTempFile = new File(tempCloneDir);
		try {
			if (!yourTempFile.exists()) {
				yourTempFile.mkdir();
				JGitSampleRepoManager.gitClone(gitRepoURL, tempCloneDir);
				return true;
			} else {
				JGitSampleRepoManager.gitPull(tempCloneDir);
				return true;
			}
		} catch (GitAPIException | IOException e) {
			log.error("could not clone content from the git URL " + gitRepoURL + e);
		}
		return false;
	}

	public void selectionChanged(SelectionChangedEvent event) {
		setErrorMessage(null);
		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		WSO2PluginSampleExt currentWizardSelection = null;
		Iterator<?> selectionItem = selection.iterator();
		if (selectionItem.hasNext())
			currentWizardSelection = (WSO2PluginSampleExt) selectionItem.next();
		if (currentWizardSelection == null) {
			setDescriptionText(""); //$NON-NLS-1$
			setSelectedNode(null);
			return;
		}
		final WSO2PluginSampleExt finalSelection = currentWizardSelection;
		setSelectedNode(createWizardNode(finalSelection));
		setDescriptionText(finalSelection.getPluginDescription());
		getContainer().updateButtons();
	}

	public void setDescriptionText(String text) {
		if (text == null) {
			text = WSO2PluginConstants.NO_DESCRIPTION_TO_BE_SET;
		}
		descriptionBrowser.setText(text);
	}

	protected IWizardNode createWizardNode(WSO2PluginSampleExt element) {
		return null;
	}

	public boolean isPageComplete() {
		if (isPluginProjectSelected) {
			return true;
		}
		return false;
	}

	public static boolean isInternetReachable() {
		try {
			// make a URL to a known source
			URL url = new URL(WSO2PluginConstants.GOOGLE_COM);
			// open a connection to that source
			HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
			// trying to retrieve data from the source. If there
			// is no connection, this line will fail
			Object objData = urlConnect.getContent();

		} catch (IOException e) {
			return false;

		}
		return true;
	}

}
