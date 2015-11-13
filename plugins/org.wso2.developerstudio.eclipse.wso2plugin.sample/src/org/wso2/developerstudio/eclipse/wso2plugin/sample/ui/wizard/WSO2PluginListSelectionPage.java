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
package org.wso2.developerstudio.eclipse.wso2plugin.sample.ui.wizard;

import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.IWizardNode;
import org.eclipse.jface.wizard.WizardSelectionPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.wso2.developerstudio.eclipse.wso2plugin.sample.ui.elements.WSO2PluginSampleExt;
import org.wso2.developerstudio.eclipse.wso2plugin.sample.ui.elements.WSO2PluginSampleExtList;
import org.wso2.developerstudio.eclipse.wso2plugin.sample.util.PluginImageUtils;
import org.wso2.developerstudio.eclipse.wso2plugin.sample.util.WSO2PluginConstants;

public class WSO2PluginListSelectionPage extends WizardSelectionPage {
	TableViewer wizardSelectionViewer;
	private WSO2PluginFormBrowser descriptionBrowser;
	private WSO2PluginSampleExtList wso2ElemList;
	private WSO2PluginProjectWizard wso2PluginProjectWizard;
	private boolean isPluginProjectSelected;

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

	private class WizardSelectedAction extends Action {
		public WizardSelectedAction() {
			super("wizardSelection"); //$NON-NLS-1$
		}

		@Override
		public void run() {
			selectionChanged(new SelectionChangedEvent(wizardSelectionViewer,
			                                           wizardSelectionViewer.getSelection()));
			wso2PluginProjectWizard.setSelectedPlugin(wizardSelectionViewer.getSelection());
			wso2PluginProjectWizard.setWizardSelected(isPluginProjectSelected);
		}
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);

		// Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 10;
		container.setLayout(layout);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		// createAbove(container, 1);
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
		wizardSelectionViewer.setLabelProvider(ListItemLabelProvider );
		wizardSelectionViewer.getTable().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				isPluginProjectSelected = true;
				pluginProjectSelectedAction.run();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
			}
		});

		createDescriptionIn(sashForm);
		initializeViewer();

		wizardSelectionViewer.setInput(wso2ElemList);
		Dialog.applyDialogFont(container);
		setControl(container);
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

}
