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
public class WsdlEndpointFormPage extends EndpointFormPage {

	public Combo wsdlEP_Format;
	public Combo endpointTrace;
	public Combo endpointStatistics;
	
	public Button wsdlEP_Properties;
	public Combo wsdlEP_Optimize;
	public Text wsdlEP_Description;
	public Text wsdlEP_WsdlUri;
	public Text wsdlEP_Service;
	public Text wsdlEP_Port;
	public List<EndPointProperty> endpointPropertyList;

    Section basicSection;
    Section miscSection;
	
    public WsdlEndpointFormPage(FormEditor editor) {
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
		
		toolkit.createLabel(basicSectionClient, "Format");
		wsdlEP_Format = new Combo(basicSectionClient, SWT.DROP_DOWN);
		wsdlEP_Format.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] formats = {"LEAVE_AS_IS", "SOAP 1.1", "SOAP 1.2", "POX", "GET", "REST"};
		wsdlEP_Format.setItems(formats);
		
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
		
		toolkit.createLabel(miscSectionClient, "Optimize");
		wsdlEP_Optimize = new Combo(miscSectionClient, SWT.DROP_DOWN);
		wsdlEP_Optimize.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] formats = {"LEAVE_AS_IS", "MTOM", "SWA"};
		wsdlEP_Optimize.setItems(formats);
		
		toolkit.createLabel(miscSectionClient, "Description");
		wsdlEP_Description = toolkit.createText(miscSectionClient, "");
		wsdlEP_Description.setBackground(new Color(null, 229,236,253));
		wsdlEP_Description.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(miscSectionClient, "WSDL URI");
		wsdlEP_WsdlUri = toolkit.createText(miscSectionClient, "");
		wsdlEP_WsdlUri.setBackground(new Color(null, 229,236,253));
		wsdlEP_WsdlUri.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(miscSectionClient, "Service");
		wsdlEP_Service = toolkit.createText(miscSectionClient, "");
		wsdlEP_Service.setBackground(new Color(null, 229,236,253));
		wsdlEP_Service.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(miscSectionClient, "Port");
		wsdlEP_Port = toolkit.createText(miscSectionClient, "");
		wsdlEP_Port.setBackground(new Color(null, 229,236,253));
		wsdlEP_Port.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		wsdlEP_Properties = toolkit.createButton(miscSectionClient, "Add Properties", SWT.PUSH);
		wsdlEP_Properties.setBackground(new Color(null, 229,236,253));
		wsdlEP_Properties.addSelectionListener(new SelectionListener() {
			
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

	public EndpointCommons getEndpointCommons() {
		return endpointCommons;
	}
	
}
