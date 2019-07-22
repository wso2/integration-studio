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

package org.wso2.developerstudio.esb.form.editors.article.rcp.message.stores;

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
import org.wso2.developerstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;

public class JMS implements IMessageStore {
	
	public Text jms_initCtxFactory;
	public Text jms_providerUrl;
	public Text jms_jndiQueueName;
	public Text jms_connectionFactory;
	public Text jms_username;
	public Text jms_password;
	public Combo jms_cacheConnection;
	public Combo jms_apiVersion;	
	
	ScrolledForm form;
	FormToolkit toolkit;
	AbstractEsbFormPage esbFormPage;
	
	Section connSection;
    Section parameterSection; 
	
	public JMS(ScrolledForm form, FormToolkit toolkit, AbstractEsbFormPage esbFormPage) {
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
		jms_initCtxFactory = toolkit.createText(connSectionClient, "");
		jms_initCtxFactory.setBackground(new Color(null, 229,236,253));
		GridData jms_initCtxFactoryGridData = new GridData();
		jms_initCtxFactoryGridData.horizontalSpan = 3;
		jms_initCtxFactoryGridData.horizontalAlignment = GridData.FILL;
		jms_initCtxFactoryGridData.grabExcessHorizontalSpace = true;
		jms_initCtxFactory.setLayoutData(jms_initCtxFactoryGridData);
		jms_initCtxFactory.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(connSectionClient, "Provider URL *");
		jms_providerUrl = toolkit.createText(connSectionClient, "");
		jms_providerUrl.setBackground(new Color(null, 229,236,253));
		GridData jms_providerUrlGridData = new GridData();
		jms_providerUrlGridData.horizontalSpan = 3;
		jms_providerUrlGridData.horizontalAlignment = GridData.FILL;
		jms_providerUrlGridData.grabExcessHorizontalSpace = true;
		jms_providerUrl.setLayoutData(jms_providerUrlGridData);
		jms_providerUrl.addModifyListener(new ModifyListener() {
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
		
		
		toolkit.createLabel(paramSectionClient, "JNDI Queue Name");
		jms_jndiQueueName = toolkit.createText(paramSectionClient, "");
		jms_jndiQueueName.setBackground(new Color(null, 229,236,253));
		GridData jms_jndiQueueNameGridData = new GridData();
		jms_jndiQueueNameGridData.horizontalSpan = 3;
		jms_jndiQueueNameGridData.horizontalAlignment = GridData.FILL;
		jms_jndiQueueNameGridData.grabExcessHorizontalSpace = true;
		jms_jndiQueueName.setLayoutData(jms_jndiQueueNameGridData);
		jms_jndiQueueName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(paramSectionClient, "Connection Factory");
		jms_connectionFactory = toolkit.createText(paramSectionClient, "");
		jms_connectionFactory.setBackground(new Color(null, 229,236,253));
		GridData jms_connectionFactoryGridData = new GridData();
		jms_connectionFactoryGridData.horizontalSpan = 3;
		jms_connectionFactoryGridData.horizontalAlignment = GridData.FILL;
		jms_connectionFactoryGridData.grabExcessHorizontalSpace = true;
		jms_connectionFactory.setLayoutData(jms_connectionFactoryGridData);
		jms_connectionFactory.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(paramSectionClient, "Username");
		jms_username = toolkit.createText(paramSectionClient, "");
		jms_username.setBackground(new Color(null, 229,236,253));
		GridData jms_usernameFactoryGridData = new GridData();
		jms_usernameFactoryGridData.horizontalSpan = 3;
		jms_usernameFactoryGridData.horizontalAlignment = GridData.FILL;
		jms_usernameFactoryGridData.grabExcessHorizontalSpace = true;
		jms_username.setLayoutData(jms_usernameFactoryGridData);
		jms_username.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(paramSectionClient, "Password");
		jms_password = toolkit.createText(paramSectionClient, "");
		jms_password.setBackground(new Color(null, 229,236,253));
		GridData jms_passwordFactoryGridData = new GridData();
		jms_passwordFactoryGridData.horizontalSpan = 3;
		jms_passwordFactoryGridData.horizontalAlignment = GridData.FILL;
		jms_passwordFactoryGridData.grabExcessHorizontalSpace = true;
		jms_password.setLayoutData(jms_passwordFactoryGridData);
		jms_password.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(paramSectionClient, "Cache Connection");
		jms_cacheConnection = new Combo(paramSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData jms_cacheConnectionGridData = new GridData();
		jms_cacheConnectionGridData.horizontalSpan = 3;
		jms_cacheConnectionGridData.horizontalAlignment = GridData.FILL;
		jms_cacheConnectionGridData.grabExcessHorizontalSpace = true;
		jms_cacheConnection.setLayoutData(jms_cacheConnectionGridData);
		String[] values = {"false", "true"};
		jms_cacheConnection.setItems(values);
		jms_cacheConnection.select(0);
		jms_cacheConnection.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		jms_cacheConnection.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
		
		toolkit.createLabel(paramSectionClient, "JMS API Specification Version");
		jms_apiVersion = new Combo(paramSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData jms_apiVersionGridData = new GridData();
		jms_apiVersionGridData.horizontalSpan = 3;
		jms_apiVersionGridData.horizontalAlignment = GridData.FILL;
		jms_apiVersionGridData.grabExcessHorizontalSpace = true;
		jms_apiVersion.setLayoutData(jms_apiVersionGridData);
		String[] versions = {"1.1", "1.0"};
		jms_apiVersion.setItems(versions);
		jms_apiVersion.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		jms_apiVersion.addListener(SWT.MouseVerticalWheel, new Listener() {
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
