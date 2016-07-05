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


package org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.esb.form.editors.article.providers.ConfigureEndPointPropertiesDialog;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class AddressEndpointFormPage extends EndpointFormPage {

	public Combo addressEP_Format;
	public Combo endpointTrace;
	public Combo endpointStatistics;
	public Text addressEP_URI;

	public Button addressEP_Properties;
	public Combo addressEP_Optimize;
	public Text addressEP_Description;
	
	public List<EndPointProperty> endpointPropertyList;
    Section basicSection;
    Section miscSection;
    
    public AddressEndpointFormPage(FormEditor editor) {
		super(editor);
	}

	protected void createFormContent(IManagedForm managedForm) {
		
		super.createFormContent(managedForm);
		
		form.setText(Messages.getString("EndpointPage.sectionMainTitle"));
	}


	public void createFormBasicSection() {
		/* Basic Section */
		basicSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.basic"));
		
		GridData samplegridData = new GridData();
		samplegridData.horizontalSpan = 3;
		samplegridData.horizontalAlignment = SWT.FILL;
		samplegridData.grabExcessHorizontalSpace = true;
		basicSection.setLayoutData(samplegridData);
		// section.setLayoutData(new TableWrapData(TableWrapData.FILL));

		Composite basicSectionClient = toolkit.createComposite(basicSection);
		basicSectionClient.setLayout(new GridLayout());
		basicSection.setClient(basicSectionClient);
				
		/*Composite basicSectionClient = toolkit.createComposite(basicSection);
		basicSectionClient.setLayout(new TableWrapLayout());
		basicSection.setClient(basicSectionClient);*/
				
		toolkit.createLabel(basicSectionClient, "Format");
		addressEP_Format = new Combo(basicSectionClient, SWT.DROP_DOWN);
		//addressEP_Format.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] formats = {"LEAVE_AS_IS", "SOAP 1.1", "SOAP 1.2", "POX", "GET", "REST"};
		addressEP_Format.setItems(formats);	
		GridData addressEPFormatGridData = new GridData();
		addressEPFormatGridData.horizontalSpan = 3;
		addressEPFormatGridData.horizontalAlignment = GridData.FILL;
		addressEPFormatGridData.grabExcessHorizontalSpace = true;
		addressEP_Format.setLayoutData(addressEPFormatGridData);
		
		toolkit.createLabel(basicSectionClient, "Trace Enabled");
		endpointTrace = new Combo(basicSectionClient, SWT.DROP_DOWN);
	    //endpointTrace.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] tracingStates = {"True", "False"};
		endpointTrace.setItems(tracingStates);
		GridData endpointTaceGridData = new GridData();
		endpointTaceGridData.horizontalSpan = 3;
		endpointTaceGridData.horizontalAlignment = GridData.FILL;
		endpointTaceGridData.grabExcessHorizontalSpace = true;
		endpointTrace.setLayoutData(endpointTaceGridData);
		
		toolkit.createLabel(basicSectionClient, "Statistics Enabled");
		endpointStatistics = new Combo(basicSectionClient, SWT.DROP_DOWN);
		//endpointStatistics.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] statisticsStates = {"True", "False"};
		endpointStatistics.setItems(statisticsStates);
		GridData endpointStatisticsGridData = new GridData();
		endpointTaceGridData.horizontalSpan = 3;
		endpointTaceGridData.horizontalAlignment = GridData.FILL;
		endpointTaceGridData.grabExcessHorizontalSpace = true;
		endpointStatistics.setLayoutData(endpointStatisticsGridData);
		
		toolkit.createLabel(basicSectionClient, "URI");
		addressEP_URI = toolkit.createText(basicSectionClient, "");
		addressEP_URI.setBackground(new Color(null, 229,236,253));
		//addressEP_URI.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData addressEPUriGridData = new GridData();
		addressEPUriGridData.horizontalSpan = 3;
		addressEPUriGridData.horizontalAlignment = GridData.FILL;
		addressEPUriGridData.grabExcessHorizontalSpace = true;
		addressEP_URI.setLayoutData(addressEPUriGridData);
		
		
	}
	
	public void createFormQosSection() {
		
		endpointCommons.createFormQosSection(form, toolkit);
		
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
		
		toolkit.createLabel(miscSectionClient, "Optimize");
		addressEP_Optimize = new Combo(miscSectionClient, SWT.DROP_DOWN);
		//addressEP_Optimize.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] formats = {"LEAVE_AS_IS", "MTOM", "SWA"};
		addressEP_Optimize.setItems(formats);
		GridData addressEPOptimizeGridData = new GridData();
		addressEPOptimizeGridData.horizontalSpan = 3;
		addressEPOptimizeGridData.horizontalAlignment = GridData.FILL;
		addressEPOptimizeGridData.grabExcessHorizontalSpace = true;
		addressEP_Optimize.setLayoutData(addressEPOptimizeGridData);
		
		toolkit.createLabel(miscSectionClient, "Description");
		addressEP_Description = toolkit.createText(miscSectionClient, "");
		addressEP_Description.setBackground(new Color(null, 229,236,253));
		//addressEP_Description.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData addressEPDescriptionGridData = new GridData();
		addressEPDescriptionGridData.horizontalSpan = 3;
		addressEPDescriptionGridData.horizontalAlignment = GridData.FILL;
		addressEPDescriptionGridData.grabExcessHorizontalSpace = true;
		addressEP_Description.setLayoutData(addressEPDescriptionGridData);
		
		addressEP_Properties = toolkit.createButton(miscSectionClient, "Add Properties", SWT.PUSH);
		addressEP_Properties.setBackground(new Color(null, 229,236,253));
		addressEP_Properties.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = Display.getDefault().getActiveShell();
				ConfigureEndPointPropertiesDialog paramDialog = new ConfigureEndPointPropertiesDialog(shell,endpointPropertyList);
				paramDialog.setBlockOnOpen(true);
				paramDialog.open();
				endpointPropertyList = paramDialog.getEndpointPropertyList();		
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	
	public void createFormErrorHandlingSection() {
		
		endpointCommons.createFormErrorHandlingSection(form, toolkit);

	}

}
