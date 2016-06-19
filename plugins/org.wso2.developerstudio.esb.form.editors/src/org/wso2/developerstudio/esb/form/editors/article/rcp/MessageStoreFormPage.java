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


package org.wso2.developerstudio.esb.form.editors.article.rcp;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.FormColors;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.wso2.developerstudio.esb.forgm.editors.article.FormArticlePlugin;
/**
 * 
 * To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Generation - Code and Comments
 */
public class MessageStoreFormPage extends FormPage {
	/**
	 * @param id
	 * @param title
	 */
	
	private String[] messageStoreTypes = {"In-Memory Message Store", "JMS Message Store", "WSO2 MB Message Store", "RabbitMQ Message Store", "JDBC Message Store", "Custom Message Store"};
	private MessageStore currentMessageStore = null;
	private ArrayList<Section> sectionsList = new ArrayList<Section>();
	
	public MessageStoreFormPage(FormEditor editor) {
		super(editor, "messageStoreForm", Messages.getString("MessageStorePage.sectionMainTitle"));
	}

	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		FormToolkit toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("MessageStorePage.sectionMainTitle")); 
		form.setBackgroundImage(FormArticlePlugin.getDefault().getImage(FormArticlePlugin.IMG_FORM_BG));

		ColumnLayout layout = new ColumnLayout();
		layout.leftMargin = 10;
		layout.rightMargin = 10;
		layout.maxNumColumns = 2;
		form.getBody().setLayout(layout);

		// Only show basic
		createFormBasicSection(form, toolkit);
		
	}
	
	private void createFormBasicSection(final ScrolledForm form, FormToolkit toolkit) {
		/* Basic Section */
		Section basicSection = toolkit.createSection(form.getBody(), Section.TWISTIE | Section.EXPANDED);
		basicSection.setActiveToggleColor(toolkit.getHyperlinkGroup().getActiveForeground());
		basicSection.setToggleColor(toolkit.getColors().getColor(FormColors.SEPARATOR));
		toolkit.createCompositeSeparator(basicSection);
		
		basicSection.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(false);
			}
		});
		basicSection.setText(Messages.getString("MessageStorePage.section.basic"));
		
		Composite basicSectionClient = toolkit.createComposite(basicSection);
		basicSectionClient.setLayout(new TableWrapLayout());
		
		toolkit.createLabel(basicSectionClient, "Message Store Name");
		Text storeName = toolkit.createText(basicSectionClient, "");
		storeName.setBackground(new Color(null, 229,236,253));
		storeName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(basicSectionClient, "Message Store Type");
		Combo storeType = new Combo(basicSectionClient, SWT.DROP_DOWN);
		storeType.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] triggerTypes = messageStoreTypes;
		storeType.setItems(triggerTypes);
		storeType.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Create message stores
				if (storeType.getText().equals("In-Memory Message Store")) {
					currentMessageStore = new InMemory();
				} else if (storeType.getText().equals("JMS Message Store")) {
					currentMessageStore = new JMS();
				} else if (storeType.getText().equals("WSO2 MB Message Store")) {
					currentMessageStore = new WSO2MB();
				} else if (storeType.getText().equals("RabbitMQ Message Store")) {
					currentMessageStore = new RabbitMQ();
				} else if (storeType.getText().equals("JDBC Message Store")) {
					currentMessageStore = new JDBC();
				} else if (storeType.getText().equals("Custom Message Store")) {
					currentMessageStore = new CustomStore();
				}
				
				if (currentMessageStore != null) {
					
					// dispose and clear sections, if already existing
					for (Section sec:sectionsList) {
						sec.dispose();
					}
					sectionsList.clear();
					

					// if identified message store, show the rest
					createFormConnectionSection(form, toolkit);
					createFormGuaranteedDeliverySection(form, toolkit);
					createFormParameterSection(form, toolkit);
					
				}
			}
		});
		
		basicSection.setClient(basicSectionClient);
		
	}
	
	
	private void createFormConnectionSection(final ScrolledForm form, FormToolkit toolkit) {

		
		if(!currentMessageStore.hasConnection()) return;
		
		 /* Connection Section */ 
		Section connSection = this.createSection(form, toolkit, Messages.getString("MessageStorePage.section.conn"));
		
		Composite connSectionClient = toolkit.createComposite(connSection);
		connSectionClient.setLayout(new TableWrapLayout());
		
		
		currentMessageStore.createConnectionSectionFields(form, toolkit, connSectionClient);
		
		connSection.setClient(connSectionClient);
		
		sectionsList.add(connSection);
		
	}
	
	
	private void createFormGuaranteedDeliverySection(final ScrolledForm form, FormToolkit toolkit) {
		
		if(!currentMessageStore.hasGuaranteedDelivery()) return;
		
		/* Guaranteed Delivery Section */ 
		Section guaranteedDeliverySection = this.createSection(form, toolkit, Messages.getString("MessageStorePage.section.guaranteedDelivery"));
		
		Composite guaranteedDeliverySectionClient = toolkit.createComposite(guaranteedDeliverySection);
		guaranteedDeliverySectionClient.setLayout(new TableWrapLayout());
		
		toolkit.createLabel(guaranteedDeliverySectionClient, "Enable Producer Guaranteed Delivery");
		Combo guaranteedDeliveryEnable = new Combo(guaranteedDeliverySectionClient, SWT.DROP_DOWN);
		guaranteedDeliveryEnable.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] states = {"True", "False"};
		guaranteedDeliveryEnable.setItems(states);
		guaranteedDeliveryEnable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				super.widgetSelected(e);
			}
		});
		
		
		toolkit.createLabel(guaranteedDeliverySectionClient, "Failover Message Store");
		Text failoverMessageStore = toolkit.createText(guaranteedDeliverySectionClient, "");
		failoverMessageStore.setBackground(new Color(null, 229,236,253));
		failoverMessageStore.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));

		
		guaranteedDeliverySection.setClient(guaranteedDeliverySectionClient);
		sectionsList.add(guaranteedDeliverySection);
	}
	
	
	private void createFormParameterSection(final ScrolledForm form, FormToolkit toolkit) {
		
		if(!currentMessageStore.hasParameters()) return;
		
		/* Trigger Information */ 
		Section parameterSection = this.createSection(form, toolkit, Messages.getString("MessageStorePage.section.parameter"));
		
		Composite parameterSectionClient = toolkit.createComposite(parameterSection);
		parameterSectionClient.setLayout(new TableWrapLayout());

		currentMessageStore.createParameterSectionFields(form, toolkit, parameterSectionClient);
		
		parameterSection.setClient(parameterSectionClient);
		sectionsList.add(parameterSection);
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




interface MessageStore {
	
	public void createConnectionSectionFields(final ScrolledForm form, FormToolkit toolkit, Composite sectionClient);
	public void createParameterSectionFields(final ScrolledForm form, FormToolkit toolkit, Composite sectionClient);
	
	public boolean hasGuaranteedDelivery();
	public boolean hasParameters();
	public boolean hasConnection();
}

class InMemory implements MessageStore {

	@Override
	public void createConnectionSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {}

	@Override
	public void createParameterSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {}

	@Override
	public boolean hasGuaranteedDelivery() {
		return false;
	}

	@Override
	public boolean hasParameters() {
		return false;
	}

	@Override
	public boolean hasConnection() {
		return false;
	}
	
	
}

class JMS implements MessageStore {

	@Override
	public void createConnectionSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "Initial Context Factory");
		Text jms_initCtxFactory = toolkit.createText(sectionClient, "");
		jms_initCtxFactory.setBackground(new Color(null, 229,236,253));
		jms_initCtxFactory.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Provider URL");
		Text jms_providerUrl = toolkit.createText(sectionClient, "");
		jms_providerUrl.setBackground(new Color(null, 229,236,253));
		jms_providerUrl.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}

	@Override
	public void createParameterSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "JNDI Queue Name");
		Text jms_jndiQueueName = toolkit.createText(sectionClient, "");
		jms_jndiQueueName.setBackground(new Color(null, 229,236,253));
		jms_jndiQueueName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Connection Factory");
		Text jms_connectionFactory = toolkit.createText(sectionClient, "");
		jms_connectionFactory.setBackground(new Color(null, 229,236,253));
		jms_connectionFactory.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Username");
		Text jms_username = toolkit.createText(sectionClient, "");
		jms_username.setBackground(new Color(null, 229,236,253));
		jms_username.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Password");
		Text jms_password = toolkit.createText(sectionClient, "");
		jms_password.setBackground(new Color(null, 229,236,253));
		jms_password.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "JMS API Specification Version");
		Combo jms_apiVersion = new Combo(sectionClient, SWT.DROP_DOWN);
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
	
}

class WSO2MB implements MessageStore {

	@Override
	public void createConnectionSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createParameterSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		// TODO Auto-generated method stub
		
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
	
}



class RabbitMQ implements MessageStore {

	@Override
	public void createConnectionSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "Rabbit MQ Server Hostname");
		Text rabbitMQ_hostname = toolkit.createText(sectionClient, "");
		rabbitMQ_hostname.setBackground(new Color(null, 229,236,253));
		rabbitMQ_hostname.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Rabbit MQ Server Port");
		Text rabbitMQ_port = toolkit.createText(sectionClient, "");
		rabbitMQ_port.setBackground(new Color(null, 229,236,253));
		rabbitMQ_port.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}

	@Override
	public void createParameterSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "RabbitMQ Queue Name");
		Text rabbitMQ_queueName = toolkit.createText(sectionClient, "");
		rabbitMQ_queueName.setBackground(new Color(null, 229,236,253));
		rabbitMQ_queueName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "RabbitMQ Exchange Name");
		Text rabbitMQ_exchangeName = toolkit.createText(sectionClient, "");
		rabbitMQ_exchangeName.setBackground(new Color(null, 229,236,253));
		rabbitMQ_exchangeName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Routing Key");
		Text rabbitMQ_routingKey = toolkit.createText(sectionClient, "");
		rabbitMQ_routingKey.setBackground(new Color(null, 229,236,253));
		rabbitMQ_routingKey.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "RabbitMQ Username");
		Text rabbitMQ_username = toolkit.createText(sectionClient, "");
		rabbitMQ_username.setBackground(new Color(null, 229,236,253));
		rabbitMQ_username.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "RabbitMQ Password");
		Text rabbitMQ_password = toolkit.createText(sectionClient, "");
		rabbitMQ_password.setBackground(new Color(null, 229,236,253));
		rabbitMQ_password.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "Virtual Host");
		Text rabbitMQ_virtualhost = toolkit.createText(sectionClient, "");
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
	
}

class JDBC implements MessageStore {

	@Override
	public void createConnectionSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "JDBC Database Table");
		Text jdbc_dbTable = toolkit.createText(sectionClient, "");
		jdbc_dbTable.setBackground(new Color(null, 229,236,253));
		jdbc_dbTable.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
		toolkit.createLabel(sectionClient, "JDBC Conection Information");
		Combo jdbc_connectionInfo = new Combo(sectionClient, SWT.DROP_DOWN);
		jdbc_connectionInfo.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] jdbcTypes = {"JDBC_POOL", "JDBC_CARBON_DATASOURCE"};
		jdbc_connectionInfo.setItems(jdbcTypes);
		jdbc_connectionInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				super.widgetSelected(e);
			}
		});
		
		
		
			//-- if connection info is JDBC_POOL
			toolkit.createLabel(sectionClient, "JDBC Driver");
			Text jdbc_driver = toolkit.createText(sectionClient, "");
			jdbc_driver.setBackground(new Color(null, 229,236,253));
			jdbc_driver.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
			
			toolkit.createLabel(sectionClient, "JDBC URL");
			Text jdbc_url = toolkit.createText(sectionClient, "");
			jdbc_url.setBackground(new Color(null, 229,236,253));
			jdbc_url.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
			
			toolkit.createLabel(sectionClient, "JDBC Username");
			Text jdbc_username = toolkit.createText(sectionClient, "");
			jdbc_username.setBackground(new Color(null, 229,236,253));
			jdbc_username.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
			
			toolkit.createLabel(sectionClient, "JDBC Password");
			Text jdbc_password = toolkit.createText(sectionClient, "");
			jdbc_password.setBackground(new Color(null, 229,236,253));
			jdbc_password.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
			
			
			//-- if connection info is JDBC_CARBON_DATASOURCE
			toolkit.createLabel(sectionClient, "JDBC Datasource Name");
			Text jdbc_DsName = toolkit.createText(sectionClient, "");
			jdbc_DsName.setBackground(new Color(null, 229,236,253));
			jdbc_DsName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		
	}

	@Override
	public void createParameterSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean hasGuaranteedDelivery() {
		return true;
	}

	@Override
	public boolean hasParameters() {
		return false;
	}

	@Override
	public boolean hasConnection() {
		return true;
	}
	
}

class CustomStore implements MessageStore {

	@Override
	public void createConnectionSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "Provider Class");
		Text custom_providerClass = toolkit.createText(sectionClient, "");
		custom_providerClass.setBackground(new Color(null, 229,236,253));
		custom_providerClass.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
	}

	@Override
	public void createParameterSectionFields(ScrolledForm form, FormToolkit toolkit, Composite sectionClient) {
		toolkit.createLabel(sectionClient, "Message Store Parameters");
		Text custom_parameters = toolkit.createText(sectionClient, "");
		custom_parameters.setBackground(new Color(null, 229,236,253));
		custom_parameters.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
	}
	
	@Override
	public boolean hasGuaranteedDelivery() {
		return false;
	}

	@Override
	public boolean hasParameters() {
		return true;
	}

	@Override
	public boolean hasConnection() {
		return true;
	}
	
}


