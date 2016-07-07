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


package org.wso2.developerstudio.esb.form.editors.article.rcp.endpoints;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;
import org.wso2.developerstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public abstract class EndpointFormPage extends AbstractEsbFormPage {

	protected EndpointCommons endpointCommons;
	
	protected ScrolledForm form;
    protected FormToolkit toolkit;
    protected Text endpointName;

    protected Combo endpointTrace;
    protected Combo endpointStatistics;
	
    protected Text eP_Properties;
    protected Combo eP_Optimize;
    protected Text eP_Description;

    protected Combo eP_Format;
    Section basicSection;
	
	 
	public Text getEndpointName() {
		return endpointName;
	}

	public void setEndpointName(Text endpointName) {
		this.endpointName = endpointName;
	}
		
	public Combo getEP_Format() {
		return eP_Format;
	}

	public void setEP_Format(Combo wsdlEP_Format) {
		this.eP_Format = wsdlEP_Format;
	}

	public Combo getEndpointTrace() {
		return endpointTrace;
	}

	public void setEndpointTrace(Combo endpointTrace) {
		this.endpointTrace = endpointTrace;
	}

	public Combo getEndpointStatistics() {
		return endpointStatistics;
	}

	public void setEndpointStatistics(Combo endpointStatistics) {
		this.endpointStatistics = endpointStatistics;
	}

	public Text getEP_Properties() {
		return eP_Properties;
	}

	public void setEP_Properties(Text wsdlEP_Properties) {
		this.eP_Properties = wsdlEP_Properties;
	}

	public Combo getEP_Optimize() {
		return eP_Optimize;
	}

	public void setEP_Optimize(Combo wsdlEP_Optimize) {
		this.eP_Optimize = wsdlEP_Optimize;
	}

	public Text getEP_Description() {
		return eP_Description;
	}

	public void setEP_Description(Text wsdlEP_Description) {
		this.eP_Description = wsdlEP_Description;
	}

	public EndpointFormPage(FormEditor editor) {
		super(editor, "endpointForm", Messages.getString("EndpointPage.sectionMainTitle"));
		
		endpointCommons = new EndpointCommons(this);
	}

	protected void createFormContent(IManagedForm managedForm) {
		form = managedForm.getForm();
		toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("EndpointPage.sectionMainTitle")); 
		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));
		
		GridLayout layout = new GridLayout();
		layout.marginLeft = 20;
		layout.marginRight = 20;
		layout.marginTop = 10;
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = true;
		
		form.getBody().setLayout(layout);
		GridData formGridData = new GridData();
		formGridData.horizontalSpan = 6;
		formGridData.grabExcessHorizontalSpace = true;
		form.setLayoutData(formGridData);
		
		
		/*ColumnLayout layout = new ColumnLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.maxNumColumns = 2;
		form.getBody().setLayout(layout);*/
		
		createFormBasicSection();
		createFormMiscSection();
		createFormQosSection();
		createFormErrorHandlingSection();
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
		
		toolkit.createLabel(basicSectionClient, "Name :");
		endpointName = toolkit.createText(basicSectionClient, "");
		endpointName.setBackground(new Color(null, 229,236,253));
		//endpointName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData endpointNameGridData = new GridData();
		endpointNameGridData.horizontalSpan = 3;
		endpointNameGridData.horizontalAlignment = GridData.FILL;
		endpointNameGridData.grabExcessHorizontalSpace = true;
		endpointName.setLayoutData(endpointNameGridData);
		
		endpointName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});

		
		toolkit.createLabel(basicSectionClient, "Format :");
		eP_Format = new Combo(basicSectionClient, SWT.DROP_DOWN);
		//eP_Format.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] formats = {"LEAVE_AS_IS", "SOAP 1.1", "SOAP 1.2", "POX", "GET", "REST"};
		eP_Format.setItems(formats);
		GridData endpointFormatGridData = new GridData();
		endpointFormatGridData.horizontalSpan = 3;
		endpointFormatGridData.horizontalAlignment = GridData.FILL;
		endpointFormatGridData.grabExcessHorizontalSpace = true;
		eP_Format.setLayoutData(endpointFormatGridData);
		
		eP_Format.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		toolkit.createLabel(basicSectionClient, "Trace Enabled :");
		endpointTrace = new Combo(basicSectionClient, SWT.DROP_DOWN);
		//endpointTrace.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] tracingStates = {"True", "False"};
		endpointTrace.setItems(tracingStates);
		GridData endpointTraceGridData = new GridData();
		endpointTraceGridData.horizontalSpan = 3;
		endpointTraceGridData.horizontalAlignment = GridData.FILL;
		endpointTraceGridData.grabExcessHorizontalSpace = true;
		endpointTrace.setLayoutData(endpointTraceGridData);
		
		endpointTrace.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		toolkit.createLabel(basicSectionClient, "Statistics Enabled :");
		endpointStatistics = new Combo(basicSectionClient, SWT.DROP_DOWN);
		//endpointStatistics.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] statisticsStates = {"True", "False"};
		endpointStatistics.setItems(statisticsStates);
		GridData endpointStatisticsGridData = new GridData();
		endpointStatisticsGridData.horizontalSpan = 3;
		endpointStatisticsGridData.horizontalAlignment = GridData.FILL;
		endpointStatisticsGridData.grabExcessHorizontalSpace = true;
		endpointStatistics.setLayoutData(endpointStatisticsGridData);
		
		endpointStatistics.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
	}
	public void createFormMiscSection() {}
	
	public void createFormQosSection() {}
	
	public void createFormErrorHandlingSection(){}
	
	
	public EndpointCommons getEndpointCommons() {
		return endpointCommons;
	}
	
}
