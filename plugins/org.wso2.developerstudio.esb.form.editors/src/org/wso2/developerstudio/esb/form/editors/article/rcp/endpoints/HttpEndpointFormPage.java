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

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class HttpEndpointFormPage extends EndpointFormPage {

	public Combo endpointTrace;
	public Combo endpointStatistics;
	public Text httpEP_UriTemplate;
	public Text httpEP_Method;

	public Text httpEP_Properties;
	public Text httpEP_Description;
	
    Section basicSection;
    Section miscSection;
	
    public HttpEndpointFormPage(FormEditor editor) {
		super(editor);
	}

	protected void createFormContent(IManagedForm managedForm) {

		super.createFormContent(managedForm);
		
		form.setText(Messages.getString("EndpointPage.sectionMainTitle"));
	}

	public void createFormBasicSection() {
		/* Basic Section */
		basicSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.basic"));
		
		Composite basicSectionClient = toolkit.createComposite(basicSection);
		basicSectionClient.setLayout(new TableWrapLayout());
		
		basicSection.setClient(basicSectionClient);
		
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
		
		toolkit.createLabel(basicSectionClient, "URI Template");
		httpEP_UriTemplate = toolkit.createText(basicSectionClient, "");
		httpEP_UriTemplate.setBackground(new Color(null, 229,236,253));
		httpEP_UriTemplate.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(basicSectionClient, "HTTP Method");
		httpEP_Method = toolkit.createText(basicSectionClient, "");
		httpEP_Method.setBackground(new Color(null, 229,236,253));
		httpEP_Method.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}
	
	public void createFormQosSection() {
		
		endpointCommons.createFormQosSection(form, toolkit);
		
	}
	
	public void createFormMiscSection() {

		 /* Misc Section */ 
		miscSection = endpointCommons.createSection(form, toolkit, Messages.getString("EndpointPage.section.misc"));
		
		Composite miscSectionClient = toolkit.createComposite(miscSection);
		miscSectionClient.setLayout(new TableWrapLayout());
		
		miscSection.setClient(miscSectionClient);
		
		toolkit.createLabel(miscSectionClient, "Properties");
		httpEP_Properties = toolkit.createText(miscSectionClient, "");
		httpEP_Properties.setBackground(new Color(null, 229,236,253));
		httpEP_Properties.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(miscSectionClient, "Description");
		httpEP_Description = toolkit.createText(miscSectionClient, "");
		httpEP_Description.setBackground(new Color(null, 229,236,253));
		httpEP_Description.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}
	
	
	public void createFormErrorHandlingSection() {
		
		endpointCommons.createFormErrorHandlingSection(form, toolkit);

	}

	public EndpointCommons getEndpointCommons() {
		return endpointCommons;
	}
	
}
