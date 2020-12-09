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

package org.wso2.integrationstudio.esb.form.editors.article.rcp.message.stores;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;
import org.wso2.integrationstudio.esb.form.editors.article.rcp.Messages;

public class WSO2MB implements IMessageStore {
	
	public Text wso2mb_initCtxFactory;
	public Text wso2mb_QueueConnFactory;
	public Text wso2mb_jndiQueueName;
	public Combo wso2mb_apiVersion;
	public Combo mb_cacheConnection;
	
	private AbstractEsbFormPage esbFormPage;
	ScrolledForm form;
	FormToolkit toolkit;
	
	Section connSection;
    Section parameterSection;

	public WSO2MB(ScrolledForm form, FormToolkit toolkit, AbstractEsbFormPage esbFormPage) {
		this.form = form;
		this.toolkit = toolkit;
		this.esbFormPage = esbFormPage;
	}

	@Override
	public void createConnectionSectionFields() {
		
		connSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));
	  	 
		GridData samplegridData = new GridData();
		samplegridData.horizontalSpan = 3;
		samplegridData.horizontalAlignment = SWT.FILL;
		samplegridData.grabExcessHorizontalSpace = true;
		connSection.setLayoutData(samplegridData);

    	Composite connSectionClient = toolkit.createComposite(connSection);
		connSectionClient.setLayout(new GridLayout());
		connSection.setClient(connSectionClient);
		
		connSection.setVisible(false);
		
		toolkit.createLabel(connSectionClient, "Initial Context Factory *");
		wso2mb_initCtxFactory = toolkit.createText(connSectionClient, "");
		wso2mb_initCtxFactory.setBackground(new Color(null, 229,236,253));
		GridData wso2mb_initCtxFactoryGridData = new GridData();
		wso2mb_initCtxFactoryGridData.horizontalSpan = 3;
		wso2mb_initCtxFactoryGridData.horizontalAlignment = GridData.FILL;
		wso2mb_initCtxFactoryGridData.grabExcessHorizontalSpace = true;
		wso2mb_initCtxFactory.setLayoutData(wso2mb_initCtxFactoryGridData);
		wso2mb_initCtxFactory.setText("org.wso2.andes.jndi.PropertiesFileInitialContextFactory");
		wso2mb_initCtxFactory.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(connSectionClient, "Queue Connection Factory *");
		wso2mb_QueueConnFactory = toolkit.createText(connSectionClient, "");
		wso2mb_QueueConnFactory.setText("amqp://admin:admin@clientID/carbon?brokerlist='tcp://localhost:5673'");
		wso2mb_QueueConnFactory.setBackground(new Color(null, 229,236,253));
		GridData wso2mb_QueueConnFactoryGridData = new GridData();
		wso2mb_QueueConnFactoryGridData.horizontalSpan = 3;
		wso2mb_QueueConnFactoryGridData.horizontalAlignment = GridData.FILL;
		wso2mb_QueueConnFactoryGridData.grabExcessHorizontalSpace = true;
		wso2mb_QueueConnFactory.setLayoutData(wso2mb_QueueConnFactoryGridData);
		wso2mb_QueueConnFactory.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
	}

	@Override
	public void createParameterSectionFields() {
		
		parameterSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));
	   	
		GridData samplegridData = new GridData();
		samplegridData.horizontalSpan = 3;
		samplegridData.horizontalAlignment = SWT.FILL;
		samplegridData.grabExcessHorizontalSpace = true;
		parameterSection.setLayoutData(samplegridData);
		
    	Composite paramSectionClient = toolkit.createComposite(parameterSection);
    	paramSectionClient.setLayout(new GridLayout());
    	parameterSection.setClient(paramSectionClient);
		
    	parameterSection.setVisible(false);
    	
		toolkit.createLabel(paramSectionClient, "JNDI Queue Name *");
		wso2mb_jndiQueueName = toolkit.createText(paramSectionClient, "");
		wso2mb_jndiQueueName.setBackground(new Color(null, 229,236,253));
		GridData wso2mb_jndiQueueNameGridData = new GridData();
		wso2mb_jndiQueueNameGridData.horizontalSpan = 3;
		wso2mb_jndiQueueNameGridData.horizontalAlignment = GridData.FILL;
		wso2mb_jndiQueueNameGridData.grabExcessHorizontalSpace = true;
		wso2mb_jndiQueueName.setLayoutData(wso2mb_jndiQueueNameGridData);
		wso2mb_jndiQueueName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(paramSectionClient, "JMS API Specification Version");
		wso2mb_apiVersion = new Combo(paramSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData wso2mb_apiVersionGridData = new GridData();
		wso2mb_apiVersionGridData.horizontalSpan = 3;
		wso2mb_apiVersionGridData.horizontalAlignment = GridData.FILL;
		wso2mb_apiVersionGridData.grabExcessHorizontalSpace = true;
		wso2mb_apiVersion.setLayoutData(wso2mb_apiVersionGridData);
		String[] versions = {"1.1", "1.0"};
		wso2mb_apiVersion.setItems(versions);
		wso2mb_apiVersion.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		wso2mb_apiVersion.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
		toolkit.createLabel(paramSectionClient, "Cache Connection");
		mb_cacheConnection = new Combo(paramSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData mb_cacheConnectionGridData = new GridData();
		mb_cacheConnectionGridData.horizontalSpan = 3;
		mb_cacheConnectionGridData.horizontalAlignment = GridData.FILL;
		mb_cacheConnectionGridData.grabExcessHorizontalSpace = true;
		mb_cacheConnection.setLayoutData(mb_cacheConnectionGridData);
		String[] values = {"false", "true"};
		mb_cacheConnection.setItems(values);
		mb_cacheConnection.select(0);
		mb_cacheConnection.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		mb_cacheConnection.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
	}

	@Override
	public boolean hasGuaranteedDelivery() {
		return true;
	}

	@Override
	public boolean hasParameters() {
		return true;
	}

	@Override
	public boolean hasConnection() {
		return true;
	}

	@Override
	public void hideGuaranteedDeliverySection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hideParametersSection() {
		 parameterSection.setVisible(false);
		 parameterSection.setExpanded(false);
	}

	@Override
	public void hideConnectionSection() {
		connSection.setVisible(false);
		connSection.setExpanded(false);
	}

	@Override
	public void showGuaranteedDeliverySection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showParametersSection() {
		 parameterSection.setVisible(true);
		 parameterSection.setExpanded(true);
		
	}

	@Override
	public void showConnectionSection() {
		connSection.setVisible(true);
		connSection.setExpanded(true);
		
	}
	
	private Section createSection(final ScrolledForm form, FormToolkit toolkit, final String heading) {
		
		Section section = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		section.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		section.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(section);
		
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		section.setText(heading);
		
		return section;
	}
	
}
