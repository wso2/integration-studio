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
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.esb.form.editors.article.providers.ConfigureEndPointPropertiesDialog;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class DefaultEndpointFormPage extends EndpointFormPage {
	
	public Combo defaultEP_Format;
	public Combo endpointTrace;
	public Combo endpointStatistics;

	public Button defaultEP_Properties;
	public Combo defaultEP_Optimize;
	public Text defaultEP_Description;
	
	public List<EndPointProperty> endpointPropertyList;
	
    Section basicSection;
    Section miscSection;

    public DefaultEndpointFormPage(FormEditor editor) {
		super(editor);
	}

	protected void createFormContent(IManagedForm managedForm) {

		super.createFormContent(managedForm);
		
		form.setText(Messages.getString("DefaultEndpointPage.sectionMainTitle"));
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
		defaultEP_Format = new Combo(basicSectionClient, SWT.DROP_DOWN);
		//defaultEP_Format.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] formats = {"LEAVE_AS_IS", "SOAP 1.1", "SOAP 1.2", "POX", "GET", "REST"};
		defaultEP_Format.setItems(formats);
		GridData defaultEPFormatGridData = new GridData();
		defaultEPFormatGridData.horizontalSpan = 3;
		defaultEPFormatGridData.horizontalAlignment = GridData.FILL;
		defaultEPFormatGridData.grabExcessHorizontalSpace = true;
		defaultEP_Format.setLayoutData(defaultEPFormatGridData);
		
		toolkit.createLabel(basicSectionClient, "Trace Enabled");
		endpointTrace = new Combo(basicSectionClient, SWT.DROP_DOWN);
		//endpointTrace.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] tracingStates = {"True", "False"};
		endpointTrace.setItems(tracingStates);
		GridData endpointTraceGridData = new GridData();
		endpointTraceGridData.horizontalSpan = 3;
		endpointTraceGridData.horizontalAlignment = GridData.FILL;
		endpointTraceGridData.grabExcessHorizontalSpace = true;
		endpointTrace.setLayoutData(defaultEPFormatGridData);
		
		toolkit.createLabel(basicSectionClient, "Statistics Enabled");
		endpointStatistics = new Combo(basicSectionClient, SWT.DROP_DOWN);
		//endpointStatistics.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] statisticsStates = {"True", "False"};
		endpointStatistics.setItems(statisticsStates);
		GridData endpointStatisticsGridData = new GridData();
		endpointStatisticsGridData.horizontalSpan = 3;
		endpointStatisticsGridData.horizontalAlignment = GridData.FILL;
		endpointStatisticsGridData.grabExcessHorizontalSpace = true;
		endpointStatistics.setLayoutData(endpointStatisticsGridData);
		
		
		basicSection.setClient(basicSectionClient);
		
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
		defaultEP_Optimize = new Combo(miscSectionClient, SWT.DROP_DOWN);
		//defaultEP_Optimize.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] formats = {"LEAVE_AS_IS", "MTOM", "SWA"};
		defaultEP_Optimize.setItems(formats);
		GridData defaultEPOptimizeGridData = new GridData();
		defaultEPOptimizeGridData.horizontalSpan = 3;
		defaultEPOptimizeGridData.horizontalAlignment = GridData.FILL;
		defaultEPOptimizeGridData.grabExcessHorizontalSpace = true;
		defaultEP_Optimize.setLayoutData(defaultEPOptimizeGridData);
		
		toolkit.createLabel(miscSectionClient, "Description");
		defaultEP_Description = toolkit.createText(miscSectionClient, "");
		defaultEP_Description.setBackground(new Color(null, 229,236,253));
		//defaultEP_Description.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData defaultEPDescriptionGridData = new GridData();
		defaultEPDescriptionGridData.horizontalSpan = 3;
		defaultEPDescriptionGridData.horizontalAlignment = GridData.FILL;
		defaultEPDescriptionGridData.grabExcessHorizontalSpace = true;
		defaultEP_Description.setLayoutData(defaultEPDescriptionGridData);
		
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
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		miscSection.setClient(miscSectionClient);
		
	}
	
	
	public void createFormErrorHandlingSection() {
		
		endpointCommons.createFormErrorHandlingSection(form, toolkit);

	}

	public EndpointCommons getEndpointCommons() {
		return endpointCommons;
	}
	
}
