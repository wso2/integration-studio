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

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
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
	
	ScrolledForm form;
	FormToolkit toolkit;
	
	Section connSection;
    Section parameterSection; 

	public RabbitMQ(ScrolledForm form, FormToolkit toolkit) {
		this.form = form;
		this.toolkit = toolkit;
	}

	@Override
	public void createConnectionSectionFields() {
		
		connSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));
	   	 
    	Composite connSectionClient = toolkit.createComposite(connSection);
		connSectionClient.setLayout(new TableWrapLayout());
		connSection.setClient(connSectionClient);
		
		connSection.setVisible(false);
		
		toolkit.createLabel(connSectionClient, "Rabbit MQ Server Hostname");
		rabbitMQ_hostname = toolkit.createText(connSectionClient, "");
		rabbitMQ_hostname.setBackground(new Color(null, 229,236,253));
		rabbitMQ_hostname.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(connSectionClient, "Rabbit MQ Server Port");
		rabbitMQ_port = toolkit.createText(connSectionClient, "");
		rabbitMQ_port.setBackground(new Color(null, 229,236,253));
		rabbitMQ_port.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}

	@Override
	public void createParameterSectionFields() {
		
		parameterSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));
	   	 
    	Composite paramSectionClient = toolkit.createComposite(parameterSection);
    	paramSectionClient.setLayout(new TableWrapLayout());
    	parameterSection.setClient(paramSectionClient);
		
    	parameterSection.setVisible(false);
		
    	
		toolkit.createLabel(paramSectionClient, "RabbitMQ Queue Name");
		rabbitMQ_queueName = toolkit.createText(paramSectionClient, "");
		rabbitMQ_queueName.setBackground(new Color(null, 229,236,253));
		rabbitMQ_queueName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(paramSectionClient, "RabbitMQ Exchange Name");
		rabbitMQ_exchangeName = toolkit.createText(paramSectionClient, "");
		rabbitMQ_exchangeName.setBackground(new Color(null, 229,236,253));
		rabbitMQ_exchangeName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(paramSectionClient, "Routing Key");
		rabbitMQ_routingKey = toolkit.createText(paramSectionClient, "");
		rabbitMQ_routingKey.setBackground(new Color(null, 229,236,253));
		rabbitMQ_routingKey.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(paramSectionClient, "RabbitMQ Username");
		rabbitMQ_username = toolkit.createText(paramSectionClient, "");
		rabbitMQ_username.setBackground(new Color(null, 229,236,253));
		rabbitMQ_username.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(paramSectionClient, "RabbitMQ Password");
		rabbitMQ_password = toolkit.createText(paramSectionClient, "");
		rabbitMQ_password.setBackground(new Color(null, 229,236,253));
		rabbitMQ_password.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(paramSectionClient, "Virtual Host");
		rabbitMQ_virtualhost = toolkit.createText(paramSectionClient, "");
		rabbitMQ_virtualhost.setBackground(new Color(null, 229,236,253));
		rabbitMQ_virtualhost.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
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
