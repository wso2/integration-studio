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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Combo;
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
	
	Section connSection;
    Section parameterSection; 
	
	public JMS(ScrolledForm form, FormToolkit toolkit) {
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
		
		toolkit.createLabel(connSectionClient, "Initial Context Factory");
		jms_initCtxFactory = toolkit.createText(connSectionClient, "");
		jms_initCtxFactory.setBackground(new Color(null, 229,236,253));
		jms_initCtxFactory.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(connSectionClient, "Provider URL");
		jms_providerUrl = toolkit.createText(connSectionClient, "");
		jms_providerUrl.setBackground(new Color(null, 229,236,253));
		jms_providerUrl.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}

	@Override
	public void createParameterSectionFields() {
		
		parameterSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));
	   	 
    	Composite paramSectionClient = toolkit.createComposite(parameterSection);
    	paramSectionClient.setLayout(new TableWrapLayout());
    	parameterSection.setClient(paramSectionClient);
		
    	parameterSection.setVisible(false);
		
		
		toolkit.createLabel(paramSectionClient, "JNDI Queue Name");
		jms_jndiQueueName = toolkit.createText(paramSectionClient, "");
		jms_jndiQueueName.setBackground(new Color(null, 229,236,253));
		jms_jndiQueueName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(paramSectionClient, "Connection Factory");
		jms_connectionFactory = toolkit.createText(paramSectionClient, "");
		jms_connectionFactory.setBackground(new Color(null, 229,236,253));
		jms_connectionFactory.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(paramSectionClient, "Username");
		jms_username = toolkit.createText(paramSectionClient, "");
		jms_username.setBackground(new Color(null, 229,236,253));
		jms_username.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(paramSectionClient, "Password");
		jms_password = toolkit.createText(paramSectionClient, "");
		jms_password.setBackground(new Color(null, 229,236,253));
		jms_password.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(paramSectionClient, "Cache Connection");
		jms_cacheConnection = new Combo(paramSectionClient, SWT.DROP_DOWN);
		jms_cacheConnection.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] values = {"false", "true"};
		jms_cacheConnection.setItems(values);
		jms_cacheConnection.select(0);
		
		toolkit.createLabel(paramSectionClient, "JMS API Specification Version");
		jms_apiVersion = new Combo(paramSectionClient, SWT.DROP_DOWN);
		jms_apiVersion.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] versions = {"1.1", "1.0"};
		jms_apiVersion.setItems(versions);
		
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
