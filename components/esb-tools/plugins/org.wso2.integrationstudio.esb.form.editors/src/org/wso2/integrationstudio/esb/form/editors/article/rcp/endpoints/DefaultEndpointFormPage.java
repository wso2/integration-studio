/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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


package org.wso2.integrationstudio.esb.form.editors.article.rcp.endpoints;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.integrationstudio.esb.form.editors.article.providers.ConfigureEndPointPropertiesDialog;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.Messages;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class DefaultEndpointFormPage extends EndpointFormPage {
	

	public Button defaultEP_Properties;
	
	public List<EndPointProperty> endpointPropertyList;
	
    Section basicSection;
    Section miscSection;

    public DefaultEndpointFormPage(FormEditor editor, boolean isTemplate) {
		super(editor);
		this.isTemplate = isTemplate;
	}

	protected void createFormContent(IManagedForm managedForm) {

		super.createFormContent(managedForm);
		if (isTemplate()) {
			form.setText(Messages.getString("DefaultEndpointTemplatePage.sectionMainTitle"));
		} else {
			form.setText(Messages.getString("DefaultEndpointPage.sectionMainTitle"));
		}
	}
	
	public void createFormMiscSection() {

		 /* Misc Section */ 
		miscSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.misc"));
		
		GridData miscSectionGridData = new GridData();
		miscSectionGridData.horizontalSpan = 3;
		miscSectionGridData.horizontalAlignment = GridData.FILL;
		miscSectionGridData.grabExcessHorizontalSpace = true;
		miscSection.setLayoutData(miscSectionGridData);
		// miscSection.setLayoutData(new TableWrapData(TableWrapData.FILL));

		Composite miscSectionClient = toolkit.createComposite(miscSection);
		miscSectionClient.setLayout(new GridLayout());
		miscSection.setClient(miscSectionClient);	
		/*
		Composite miscSectionClient = toolkit.createComposite(miscSection);
		miscSectionClient.setLayout(new TableWrapLayout());
		miscSection.setClient(miscSectionClient);*/
	
		
		toolkit.createLabel(miscSectionClient, "Optimize :");
		eP_Optimize = new Combo(miscSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		//defaultEP_Optimize.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] formats = {"LEAVE_AS_IS", "MTOM", "SWA"};
		eP_Optimize.setItems(formats);
		GridData defaultEPOptimizeGridData = new GridData();
		defaultEPOptimizeGridData.horizontalSpan = 3;
		defaultEPOptimizeGridData.horizontalAlignment = GridData.FILL;
		defaultEPOptimizeGridData.grabExcessHorizontalSpace = true;
		eP_Optimize.setLayoutData(defaultEPOptimizeGridData);
		
		eP_Optimize.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		eP_Optimize.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
		toolkit.createLabel(miscSectionClient, "Description :");
		eP_Description = toolkit.createText(miscSectionClient, "");
		eP_Description.setBackground(new Color(null, 229,236,253));
		//defaultEP_Description.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData defaultEPDescriptionGridData = new GridData();
		defaultEPDescriptionGridData.horizontalSpan = 3;
		defaultEPDescriptionGridData.horizontalAlignment = GridData.FILL;
		defaultEPDescriptionGridData.grabExcessHorizontalSpace = true;
		eP_Description.setLayoutData(defaultEPDescriptionGridData);
		
		eP_Description.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		
		toolkit.createLabel(miscSectionClient, "Properties :");
		defaultEP_Properties = toolkit.createButton(miscSectionClient, "Add Properties", SWT.PUSH);
		defaultEP_Properties.setBackground(new Color(null, 229,236,253));
		defaultEP_Properties.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = Display.getDefault().getActiveShell();
				ConfigureEndPointPropertiesDialog paramDialog = new ConfigureEndPointPropertiesDialog(shell,endpointPropertyList);
				paramDialog.setBlockOnOpen(true);
				paramDialog.open();
				endpointPropertyList = paramDialog.getEndpointPropertyList();	
				
				setSave(true);
				updateDirtyState();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		miscSection.setClient(miscSectionClient);
		
	}
	public void createFormQosSection() {
		endpointCommons.createFormQosSection(form, toolkit);
	}
	
	public void createFormErrorHandlingSection() {
		endpointCommons.createFormErrorHandlingSection(form, toolkit);
	}

	public EndpointCommons getEndpointCommons() {
		return endpointCommons;
	}
	
}
