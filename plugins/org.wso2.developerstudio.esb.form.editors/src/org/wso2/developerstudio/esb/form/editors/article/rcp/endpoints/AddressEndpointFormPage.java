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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class AddressEndpointFormPage extends FormPage {

	RealEndpointUtils endpointUtils = new RealEndpointUtils();

	public Combo addressEP_Format;
	public Combo endpointTrace;
	public Combo endpointStatistics;
	public Text addressEP_URI;

	public Text addressEP_Properties;
	public Combo addressEP_Optimize;
	public Text addressEP_Description;


	public AddressEndpointFormPage(FormEditor editor) {
		super(editor, "addressEndpointForm", Messages.getString("AddressEndpointPage.sectionMainTitle"));
	}

	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("AddressEndpointPage.sectionMainTitle")); 
		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));

		ColumnLayout layout = new ColumnLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.maxNumColumns = 2;
		form.getBody().setLayout(layout);

		createFormBasicSection(form, toolkit);
		createFormQosSection(form, toolkit);
		createFormMiscSection(form, toolkit);
		createFormErrorHandlingSection(form, toolkit);
		
	}
	
	private void createFormBasicSection(final ScrolledForm form, FormToolkit toolkit) {
		/* Basic Section */
		Section basicSection = endpointUtils.createSection(form, toolkit, Messages.getString("EndpointPage.section.basic"));
		
		Composite basicSectionClient = toolkit.createComposite(basicSection);
		basicSectionClient.setLayout(new TableWrapLayout());
		
		toolkit.createLabel(basicSectionClient, "Format");
		addressEP_Format = new Combo(basicSectionClient, SWT.DROP_DOWN);
		addressEP_Format.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] formats = {"LEAVE_AS_IS", "SOAP 1.1", "SOAP 1.2", "POX", "GET", "REST"};
		addressEP_Format.setItems(formats);
		
		toolkit.createLabel(basicSectionClient, "Trace Enabled");
		endpointTrace = new Combo(basicSectionClient, SWT.DROP_DOWN);
		endpointTrace.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] tracingStates = {"True", "False"};
		endpointTrace.setItems(tracingStates);
		
		toolkit.createLabel(basicSectionClient, "Statistics Enabled");
		endpointStatistics = new Combo(basicSectionClient, SWT.DROP_DOWN);
		endpointStatistics.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] statisticsStates = {"True", "False"};
		endpointStatistics.setItems(statisticsStates);
		
		toolkit.createLabel(basicSectionClient, "URI");
		addressEP_URI = toolkit.createText(basicSectionClient, "");
		addressEP_URI.setBackground(new Color(null, 229,236,253));
		addressEP_URI.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		
		basicSection.setClient(basicSectionClient);
		
	}
	
	private void createFormQosSection(final ScrolledForm form, FormToolkit toolkit) {
		
		endpointUtils.createFormQosSection(form, toolkit);
		
	}
	
	private void createFormMiscSection(final ScrolledForm form, FormToolkit toolkit) {

		 /* Misc Section */ 
		Section miscSection = endpointUtils.createSection(form, toolkit, Messages.getString("EndpointPage.section.misc"));
		
		Composite miscSectionClient = toolkit.createComposite(miscSection);
		miscSectionClient.setLayout(new TableWrapLayout());
		
		
		toolkit.createLabel(miscSectionClient, "Properties");
		addressEP_Properties = toolkit.createText(miscSectionClient, "");
		addressEP_Properties.setBackground(new Color(null, 229,236,253));
		addressEP_Properties.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(miscSectionClient, "Optimize");
		addressEP_Optimize = new Combo(miscSectionClient, SWT.DROP_DOWN);
		addressEP_Optimize.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] formats = {"LEAVE_AS_IS", "MTOM", "SWA"};
		addressEP_Optimize.setItems(formats);
		
		toolkit.createLabel(miscSectionClient, "Description");
		addressEP_Description = toolkit.createText(miscSectionClient, "");
		addressEP_Description.setBackground(new Color(null, 229,236,253));
		addressEP_Description.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		miscSection.setClient(miscSectionClient);
		
	}
	
	
	private void createFormErrorHandlingSection(final ScrolledForm form, FormToolkit toolkit) {
		
		endpointUtils.createFormErrorHandlingSection(form, toolkit);

	}

	public RealEndpointUtils getEndpointUtils() {
		return endpointUtils;
	}

}
