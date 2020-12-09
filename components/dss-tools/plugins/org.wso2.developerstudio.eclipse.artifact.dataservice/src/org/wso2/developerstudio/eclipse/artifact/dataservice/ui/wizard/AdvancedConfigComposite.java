
/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.dataservice.ui.wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import static org.wso2.developerstudio.eclipse.platform.core.mediatype.PlatformMediaTypeConstants.*;

import org.wso2.developerstudio.eclipse.artifact.dataservice.model.DataServiceModel;
import org.wso2.developerstudio.eclipse.artifact.dataservice.utils.DataServiceArtifactConstants;
import org.wso2.developerstudio.eclipse.platform.core.model.AbstractComposite;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectDataModel;
import org.wso2.developerstudio.eclipse.platform.core.project.model.ProjectOptionData;
import org.wso2.developerstudio.eclipse.platform.core.utils.ResourceManager;
import org.wso2.developerstudio.eclipse.ds.presentation.ui.NamedEntityDescriptor;


public class AdvancedConfigComposite extends AbstractComposite {

	private static final String SYMBOLIC_NAME = "org.wso2.developerstudio.eclipse.artifact.dataservice";
	private static final String REG_BROWSE_TOOL_TIP = "browse key from registry or workspace";
	private DataServiceModel model;

	
	/* secure dss */
	private Label lblSecPolicy;
	private Text txtSecPolicy;
	private Button cmdSecPolicyRegBrowse;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 * @param model
	 */
	public AdvancedConfigComposite(Composite parent, int style,
			ProjectDataModel model, ProjectOptionData optionData,
			WizardPage wizardPage) {
		super(parent, style, model, optionData, wizardPage);
		setLayout(new GridLayout(3, false));
		setModel((DataServiceModel) getProjectModel());



		/* Secure */
		lblSecPolicy = new Label(this, SWT.NONE);
		lblSecPolicy.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lblSecPolicy.setText("Security Policy");
		

		txtSecPolicy = new Text(this, SWT.BORDER);
		GridData gd_txtSecPolicy = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		txtSecPolicy.setLayoutData(gd_txtSecPolicy);
		
		txtSecPolicy.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent evt) {
				setModelPropertyValue(DataServiceArtifactConstants.WIZARD_OPTION_SERVICE_SECPOLICY, txtSecPolicy.getText());
			}
		});
		
		cmdSecPolicyRegBrowse = new Button(this, SWT.NONE);
		cmdSecPolicyRegBrowse.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
		cmdSecPolicyRegBrowse.setImage(ResourceManager.getPluginImage(SYMBOLIC_NAME, "icons/registry.png"));
		cmdSecPolicyRegBrowse.setToolTipText(REG_BROWSE_TOOL_TIP);
		cmdSecPolicyRegBrowse.setText("Browse...");
		cmdSecPolicyRegBrowse.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent evt) {
				selectRegistryResource(txtSecPolicy, MEDIA_TYPE_WSPOLICY);
			}

			public void widgetDefaultSelected(SelectionEvent evt) {
				widgetSelected(evt);
			}
		});
		
		//no need to hide since we have only one advanced option upto now
		//hideControls(lblSecPolicy); 
		//hideControls(txtSecPolicy); 
		//hideControls(cmdSecPolicyRegBrowse);  

	}

	/**
	 * 
	 * @param ctrls
	 */
	void hideControls(Control... ctrls) {
		for (Control ctrl : ctrls) {
			if (!ctrl.isDisposed()) {
				ctrl.setVisible(false);
				if (ctrl.getLayoutData() instanceof GridData) {
					((GridData) ctrl.getLayoutData()).exclude = true;
					
				}
			}
		}
	}

	/**
	 * 
	 * @param ctrls
	 */
	void showControls(Control... ctrls) {
		for (Control ctrl : ctrls) {
			if (!ctrl.isDisposed()) {
				ctrl.setVisible(true);
				if (ctrl.getLayoutData() instanceof GridData) {
					((GridData) ctrl.getLayoutData()).exclude = false;
				}
			}
		}
	}

	Label createEmptyLabel(Composite parent) {
		Label EmptyLabel = new Label(parent, SWT.NONE);
		EmptyLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		return EmptyLabel;
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable o, Object arg) {
		
		if(this.isDisposed()){
			return;
		}
		
		/*
		ArtifactTemplate selectedTemplate = AdvancedConfigComposite.this.getModel().getSelectedTemplate();
		if("new.proxyservice".equalsIgnoreCase(getModel().getSelectedOption())){
			String templateId = selectedTemplate.getId();
			AdvancedConfigComposite.this.layout();
		}
		*/
	}

	/**
	 * Browse key from registry, workspace or local entries
	 * @param textBox 
	 * @param mediaType
	 */
	@SuppressWarnings("unchecked")
	
	private void selectRegistryResource(Text textBox, String mediaType) {
		
		/*RegistryResourceBrowserDialog dialog = new RegistryResourceBrowserDialog(getShell(), SWT.NULL, new ArrayList<NamedEntityDescriptor>());
		int dialogOpen = dialog.open();
		if (dialogOpen == Window.OK) {
			String keyValue = dialog.getSelectedPath();
			textBox.setText(keyValue);
		}*/
	}
	

	public void setModel(DataServiceModel model) {
		this.model = model;
	}

	public DataServiceModel getModel() {
		return model;
	}
	
	void enableControls(Control... ctrls){
		for (Control ctrl : ctrls) {
			if (!ctrl.isDisposed()) {
				ctrl.setEnabled(true);
			}
		}
	}
	
	void disableControls(Control... ctrls){
		for (Control ctrl : ctrls) {
			if (!ctrl.isDisposed()) {
				ctrl.setEnabled(false);
			}
		}
	}

	@Override
	public List<String> getCustomFields() {
		// TODO Auto-generated method stub
		return null;
	}

}
