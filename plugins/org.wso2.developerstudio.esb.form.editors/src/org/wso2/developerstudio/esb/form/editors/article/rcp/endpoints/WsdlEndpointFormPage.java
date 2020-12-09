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
public class WsdlEndpointFormPage extends EndpointFormPage {
	private Text wsdlEP_WsdlUri;
	private Text wsdlEP_Service;
	private Text wsdlEP_Port;

	public Combo wsdlEP_Format;
	public Combo endpointTrace;
	public Combo endpointStatistics;
	
	public Button wsdlEP_Properties;
	public Combo wsdlEP_Optimize;
	public Text wsdlEP_Description;
	public List<EndPointProperty> endpointPropertyList;

    Section basicSection;
    Section miscSection;
	
	

	public Text getWsdlEP_WsdlUri() {
		return wsdlEP_WsdlUri;
	}

	public void setWsdlEP_WsdlUri(Text wsdlEP_WsdlUri) {
		this.wsdlEP_WsdlUri = wsdlEP_WsdlUri;
	}

	public Text getWsdlEP_Service() {
		return wsdlEP_Service;
	}

	public void setWsdlEP_Service(Text wsdlEP_Service) {
		this.wsdlEP_Service = wsdlEP_Service;
	}

	public Text getWsdlEP_Port() {
		return wsdlEP_Port;
	}

	public void setWsdlEP_Port(Text wsdlEP_Port) {
		this.wsdlEP_Port = wsdlEP_Port;
	}

	public Section getBasicSection() {
		return basicSection;
	}

	public void setBasicSection(Section basicSection) {
		this.basicSection = basicSection;
	}

	public Section getMiscSection() {
		return miscSection;
	}

	public void setMiscSection(Section miscSection) {
		this.miscSection = miscSection;
	}

    public WsdlEndpointFormPage(FormEditor editor, boolean isTemplate) {
		super(editor);
		this.isTemplate = isTemplate;
	}

	protected void createFormContent(IManagedForm managedForm) {
		super.createFormContent(managedForm);
		if (isTemplate()) {
			form.setText(Messages.getString("WsdlEndpointTemplatePage.sectionMainTitle"));
		} else {
			form.setText(Messages.getString("WsdlEndpointPage.sectionMainTitle"));
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
		
		toolkit.createLabel(miscSectionClient, "Optimize :");
		eP_Optimize = new Combo(miscSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		//eP_Optimize.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] formats = {"LEAVE_AS_IS", "MTOM", "SWA"};
		eP_Optimize.setItems(formats);
		GridData epOptimizeGridData = new GridData();
		epOptimizeGridData.horizontalSpan = 3;
		epOptimizeGridData.horizontalAlignment = GridData.FILL;
		epOptimizeGridData.grabExcessHorizontalSpace = true;
		eP_Optimize.setLayoutData(epOptimizeGridData);
		
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
		//eP_Description.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData epDescriptionGridData = new GridData();
		epDescriptionGridData.horizontalSpan = 3;
		epDescriptionGridData.horizontalAlignment = GridData.FILL;
		epDescriptionGridData.grabExcessHorizontalSpace = true;
		eP_Description.setLayoutData(epDescriptionGridData);
		
		eP_Description.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});

		
		toolkit.createLabel(miscSectionClient, "WSDL URI :");
		wsdlEP_WsdlUri = toolkit.createText(miscSectionClient, "");
		wsdlEP_WsdlUri.setBackground(new Color(null, 229,236,253));
		//wsdlEP_WsdlUri.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData wsdlEPWsdlUriGridData = new GridData();
		wsdlEPWsdlUriGridData.horizontalSpan = 3;
		wsdlEPWsdlUriGridData.horizontalAlignment = GridData.FILL;
		wsdlEPWsdlUriGridData.grabExcessHorizontalSpace = true;
		wsdlEP_WsdlUri.setLayoutData(wsdlEPWsdlUriGridData);
		
		wsdlEP_WsdlUri.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		toolkit.createLabel(miscSectionClient, "Service :");
		wsdlEP_Service = toolkit.createText(miscSectionClient, "");
		wsdlEP_Service.setBackground(new Color(null, 229,236,253));
		//wsdlEP_Service.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData wsdlEPServiceGridData = new GridData();
		wsdlEPServiceGridData.horizontalSpan = 3;
		wsdlEPServiceGridData.horizontalAlignment = GridData.FILL;
		wsdlEPServiceGridData.grabExcessHorizontalSpace = true;
		wsdlEP_Service.setLayoutData(wsdlEPServiceGridData);
		
		wsdlEP_Service.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		toolkit.createLabel(miscSectionClient, "Port :");
		wsdlEP_Port = toolkit.createText(miscSectionClient, "");
		wsdlEP_Port.setBackground(new Color(null, 229,236,253));
		//wsdlEP_Port.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		GridData wsdlEPPortGridData = new GridData();
		wsdlEPPortGridData.horizontalSpan = 3;
		wsdlEPPortGridData.horizontalAlignment = GridData.FILL;
		wsdlEPPortGridData.grabExcessHorizontalSpace = true;
		wsdlEP_Port.setLayoutData(wsdlEPPortGridData);
		
		wsdlEP_Port.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				setSave(true);
				updateDirtyState();
			}
		});
		
		toolkit.createLabel(miscSectionClient, "Properties :");
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
				
				setSave(true);
				updateDirtyState();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
