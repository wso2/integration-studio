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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;

public class RabbitMQ implements IMessageStore {
	
	public Text rabbitMQ_hostname;
	public Text rabbitMQ_port;
	public Text rabbitMQ_queueName;
	public Text rabbitMQ_exchangeName;
	public Text rabbitMQ_routingKey;
	public Text rabbitMQ_username;
	public Text rabbitMQ_password;
	public Text rabbitMQ_virtualhost;
	
	private AbstractEsbFormPage esbFormPage;
	
	ScrolledForm form;
	FormToolkit toolkit;
	
	Section connSection;
    Section parameterSection; 

	public RabbitMQ(ScrolledForm form, FormToolkit toolkit, AbstractEsbFormPage esbFormPage) {
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
		
		toolkit.createLabel(connSectionClient, "Rabbit MQ Server Hostname");
		rabbitMQ_hostname = toolkit.createText(connSectionClient, "");
		rabbitMQ_hostname.setBackground(new Color(null, 229,236,253));
		GridData rabbitMQ_hostnameGridData = new GridData();
		rabbitMQ_hostnameGridData.horizontalSpan = 3;
		rabbitMQ_hostnameGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_hostnameGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_hostname.setLayoutData(rabbitMQ_hostnameGridData);
		rabbitMQ_hostname.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(connSectionClient, "Rabbit MQ Server Port");
		rabbitMQ_port = toolkit.createText(connSectionClient, "");
		rabbitMQ_port.setBackground(new Color(null, 229,236,253));
		GridData rabbitMQ_portGridData = new GridData();
		rabbitMQ_portGridData.horizontalSpan = 3;
		rabbitMQ_portGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_portGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_port.setLayoutData(rabbitMQ_portGridData);
		rabbitMQ_port.addModifyListener(new ModifyListener() {
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
		
    	
		toolkit.createLabel(paramSectionClient, "RabbitMQ Queue Name");
		rabbitMQ_queueName = toolkit.createText(paramSectionClient, "");
		rabbitMQ_queueName.setBackground(new Color(null, 229,236,253));
		GridData rabbitMQ_queueNameGridData = new GridData();
		rabbitMQ_queueNameGridData.horizontalSpan = 3;
		rabbitMQ_queueNameGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_queueNameGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_queueName.setLayoutData(rabbitMQ_queueNameGridData);
		rabbitMQ_queueName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(paramSectionClient, "RabbitMQ Exchange Name");
		rabbitMQ_exchangeName = toolkit.createText(paramSectionClient, "");
		rabbitMQ_exchangeName.setBackground(new Color(null, 229,236,253));
		GridData rabbitMQ_exchangeNameGridData = new GridData();
		rabbitMQ_exchangeNameGridData.horizontalSpan = 3;
		rabbitMQ_exchangeNameGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_exchangeNameGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_exchangeName.setLayoutData(rabbitMQ_exchangeNameGridData);
		rabbitMQ_exchangeName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(paramSectionClient, "Routing Key");
		rabbitMQ_routingKey = toolkit.createText(paramSectionClient, "");
		rabbitMQ_routingKey.setBackground(new Color(null, 229,236,253));
		GridData rabbitMQ_routingKeyGridData = new GridData();
		rabbitMQ_routingKeyGridData.horizontalSpan = 3;
		rabbitMQ_routingKeyGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_routingKeyGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_routingKey.setLayoutData(rabbitMQ_routingKeyGridData);
		rabbitMQ_routingKey.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(paramSectionClient, "RabbitMQ Username");
		rabbitMQ_username = toolkit.createText(paramSectionClient, "");
		rabbitMQ_username.setBackground(new Color(null, 229,236,253));
		GridData rabbitMQ_usernameGridData = new GridData();
		rabbitMQ_usernameGridData.horizontalSpan = 3;
		rabbitMQ_usernameGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_usernameGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_username.setLayoutData(rabbitMQ_usernameGridData);
		rabbitMQ_username.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(paramSectionClient, "RabbitMQ Password");
		rabbitMQ_password = toolkit.createText(paramSectionClient, "");
		rabbitMQ_password.setBackground(new Color(null, 229,236,253));
		GridData rabbitMQ_passwordGridData = new GridData();
		rabbitMQ_passwordGridData.horizontalSpan = 3;
		rabbitMQ_passwordGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_passwordGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_password.setLayoutData(rabbitMQ_passwordGridData);
		rabbitMQ_password.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(paramSectionClient, "Virtual Host");
		rabbitMQ_virtualhost = toolkit.createText(paramSectionClient, "");
		rabbitMQ_virtualhost.setBackground(new Color(null, 229,236,253));
		GridData rabbitMQ_virtualhostGridData = new GridData();
		rabbitMQ_virtualhostGridData.horizontalSpan = 3;
		rabbitMQ_virtualhostGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_virtualhostGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_virtualhost.setLayoutData(rabbitMQ_virtualhostGridData);
		rabbitMQ_virtualhost.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
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
