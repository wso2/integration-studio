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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
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

public class RabbitMQ implements IMessageStore {

	public Text rabbitMQ_hostname;
	public Text rabbitMQ_port;
	public Text rabbitMQ_queueName;
	public Text rabbitMQ_exchangeName;
	public Text rabbitMQ_routingKey;
	public Text rabbitMQ_username;
	public Text rabbitMQ_password;
	public Text rabbitMQ_virtualhost;

	public Combo rabbitMQ_sslEnabled;
	public Text rabbitMQ_keyStoreLocation;
	public Text rabbitMQ_keyStoreType;
	public Text rabbitMQ_keyStorePassword;
	public Text rabbitMQ_trustStoreLocation;
	public Text rabbitMQ_trustStoreType;
	public Text rabbitMQ_trustStorePassword;
	public Text rabbitMQ_sslVersion;
	public Label lblRabbitMQ_keyStoreLocation;
	public Label lblRabbitMQ_keyStoreType;
	public Label lblRabbitMQ_keyStorePassword;
	public Label lblRabbitMQ_trustStoreLocation;
	public Label lblRabbitMQ_trustStoreType;
	public Label lblRabbitMQ_trustStorePassword;
	public Label lblRabbitMQ_sslVersion;

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

		toolkit.createLabel(connSectionClient, "Rabbit MQ Server Hostname :");
		rabbitMQ_hostname = toolkit.createText(connSectionClient, "");
		rabbitMQ_hostname.setBackground(new Color(null, 229, 236, 253));
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

		toolkit.createLabel(connSectionClient, "Rabbit MQ Server Port :");
		rabbitMQ_port = toolkit.createText(connSectionClient, "");
		rabbitMQ_port.setBackground(new Color(null, 229, 236, 253));
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

		toolkit.createLabel(connSectionClient, "SSL Enabled :");
		rabbitMQ_sslEnabled = new Combo(connSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		String[] states = { "True", "False" };
		rabbitMQ_sslEnabled.setItems(states);
		rabbitMQ_sslEnabled.select(1);
		GridData endpoinrabbitMQ_sslEnabledGridData = new GridData();
		endpoinrabbitMQ_sslEnabledGridData.horizontalSpan = 3;
		endpoinrabbitMQ_sslEnabledGridData.horizontalAlignment = GridData.FILL;
		endpoinrabbitMQ_sslEnabledGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_sslEnabled.setLayoutData(endpoinrabbitMQ_sslEnabledGridData);

		rabbitMQ_sslEnabled.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				if (rabbitMQ_sslEnabled.getSelectionIndex() == 0) {
					enableSSLfields();
				} else {
					dissableSSLfields();
					rabbitMQ_keyStoreLocation.setText("");
					rabbitMQ_keyStoreType.setText("");
					rabbitMQ_keyStorePassword.setText("");
					rabbitMQ_trustStoreLocation.setText("");
					rabbitMQ_trustStoreType.setText("");
					rabbitMQ_trustStorePassword.setText("");
					rabbitMQ_sslVersion.setText("");
				}

				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		rabbitMQ_sslEnabled.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});

		lblRabbitMQ_keyStoreLocation = toolkit.createLabel(connSectionClient, "SSL Key Store Location :");
		GridData lblrabbitMQ_keyStoreLocationGridData = new GridData();
		lblrabbitMQ_keyStoreLocationGridData.horizontalSpan = 3;
		lblrabbitMQ_keyStoreLocationGridData.horizontalAlignment = GridData.FILL;
		lblrabbitMQ_keyStoreLocationGridData.grabExcessHorizontalSpace = true;
		lblRabbitMQ_keyStoreLocation.setLayoutData(lblrabbitMQ_keyStoreLocationGridData);
		rabbitMQ_keyStoreLocation = toolkit.createText(connSectionClient, "");
		rabbitMQ_keyStoreLocation.setBackground(new Color(null, 229, 236, 253));
		GridData rabbitMQ_keyStoreLocationGridData = new GridData();
		rabbitMQ_keyStoreLocationGridData.horizontalSpan = 3;
		rabbitMQ_keyStoreLocationGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_keyStoreLocationGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_keyStoreLocation.setLayoutData(rabbitMQ_keyStoreLocationGridData);
		rabbitMQ_keyStoreLocation.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lblRabbitMQ_keyStoreType = toolkit.createLabel(connSectionClient, "SSL Key Store Type :");
		GridData lblrabbitMQ_keyStoreTypeGridData = new GridData();
		lblrabbitMQ_keyStoreTypeGridData.horizontalSpan = 3;
		lblrabbitMQ_keyStoreTypeGridData.horizontalAlignment = GridData.FILL;
		lblrabbitMQ_keyStoreTypeGridData.grabExcessHorizontalSpace = true;
		lblRabbitMQ_keyStoreType.setLayoutData(lblrabbitMQ_keyStoreTypeGridData);
		rabbitMQ_keyStoreType = toolkit.createText(connSectionClient, "");
		rabbitMQ_keyStoreType.setBackground(new Color(null, 229, 236, 253));
		GridData rabbitMQ_keyStoreTypeGridData = new GridData();
		rabbitMQ_keyStoreTypeGridData.horizontalSpan = 3;
		rabbitMQ_keyStoreTypeGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_keyStoreTypeGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_keyStoreType.setLayoutData(rabbitMQ_keyStoreTypeGridData);
		rabbitMQ_keyStoreType.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lblRabbitMQ_keyStorePassword= toolkit.createLabel(connSectionClient, "SSL Key Store Password :");
		GridData lblrabbitMQ_keyStorePasswordGridData = new GridData();
		lblrabbitMQ_keyStorePasswordGridData.horizontalSpan = 3;
		lblrabbitMQ_keyStorePasswordGridData.horizontalAlignment = GridData.FILL;
		lblrabbitMQ_keyStorePasswordGridData.grabExcessHorizontalSpace = true;
		lblRabbitMQ_keyStorePassword.setLayoutData(lblrabbitMQ_keyStorePasswordGridData);
		rabbitMQ_keyStorePassword = toolkit.createText(connSectionClient, "");
		rabbitMQ_keyStorePassword.setBackground(new Color(null, 229, 236, 253));
		GridData rabbitMQ_keyStorePasswordGridData = new GridData();
		rabbitMQ_keyStorePasswordGridData.horizontalSpan = 3;
		rabbitMQ_keyStorePasswordGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_keyStorePasswordGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_keyStorePassword.setLayoutData(rabbitMQ_keyStorePasswordGridData);
		rabbitMQ_keyStorePassword.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lblRabbitMQ_trustStoreLocation =toolkit.createLabel(connSectionClient, "SSL Trust Store Location :");
		GridData lblrabbitMQ_trustStoreLocationGridData = new GridData();
		lblrabbitMQ_trustStoreLocationGridData.horizontalSpan = 3;
		lblrabbitMQ_trustStoreLocationGridData.horizontalAlignment = GridData.FILL;
		lblrabbitMQ_trustStoreLocationGridData.grabExcessHorizontalSpace = true;
		lblRabbitMQ_trustStoreLocation.setLayoutData(lblrabbitMQ_trustStoreLocationGridData);
		rabbitMQ_trustStoreLocation = toolkit.createText(connSectionClient, "");
		rabbitMQ_trustStoreLocation.setBackground(new Color(null, 229, 236, 253));
		GridData rabbitMQ_trustStoreLocationGridData = new GridData();
		rabbitMQ_trustStoreLocationGridData.horizontalSpan = 3;
		rabbitMQ_trustStoreLocationGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_trustStoreLocationGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_trustStoreLocation.setLayoutData(rabbitMQ_trustStoreLocationGridData);
		rabbitMQ_trustStoreLocation.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lblRabbitMQ_trustStoreType = toolkit.createLabel(connSectionClient, "SSL Trust Store Type :");
		GridData lblrabbitMQ_trustStoreTypeGridData = new GridData();
		lblrabbitMQ_trustStoreTypeGridData.horizontalSpan = 3;
		lblrabbitMQ_trustStoreTypeGridData.horizontalAlignment = GridData.FILL;
		lblrabbitMQ_trustStoreTypeGridData.grabExcessHorizontalSpace = true;
		lblRabbitMQ_trustStoreType.setLayoutData(lblrabbitMQ_trustStoreLocationGridData);
		rabbitMQ_trustStoreType = toolkit.createText(connSectionClient, "");
		rabbitMQ_trustStoreType.setBackground(new Color(null, 229, 236, 253));
		GridData rabbitMQ_trustStoreTypeGridData = new GridData();
		rabbitMQ_trustStoreTypeGridData.horizontalSpan = 3;
		rabbitMQ_trustStoreTypeGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_trustStoreTypeGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_trustStoreType.setLayoutData(rabbitMQ_trustStoreLocationGridData);
		rabbitMQ_trustStoreType.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lblRabbitMQ_trustStorePassword = toolkit.createLabel(connSectionClient, "SSL Trust Store Password :");
		GridData lblrabbitMQ_trustStorePasswordGridData = new GridData();
		lblrabbitMQ_trustStorePasswordGridData.horizontalSpan = 3;
		lblrabbitMQ_trustStorePasswordGridData.horizontalAlignment = GridData.FILL;
		lblrabbitMQ_trustStorePasswordGridData.grabExcessHorizontalSpace = true;
		lblRabbitMQ_trustStorePassword.setLayoutData(lblrabbitMQ_trustStoreLocationGridData);
		rabbitMQ_trustStorePassword = toolkit.createText(connSectionClient, "");
		rabbitMQ_trustStorePassword.setBackground(new Color(null, 229, 236, 253));
		GridData rabbitMQ_trustStorePasswordGridData = new GridData();
		rabbitMQ_trustStorePasswordGridData.horizontalSpan = 3;
		rabbitMQ_trustStorePasswordGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_trustStorePasswordGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_trustStorePassword.setLayoutData(rabbitMQ_trustStoreLocationGridData);
		rabbitMQ_trustStorePassword.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lblRabbitMQ_sslVersion = toolkit.createLabel(connSectionClient, "SSL Version :");
		GridData lblrabbitMQ_sslVersionGridData = new GridData();
		lblrabbitMQ_sslVersionGridData.horizontalSpan = 3;
		lblrabbitMQ_sslVersionGridData.horizontalAlignment = GridData.FILL;
		lblrabbitMQ_sslVersionGridData.grabExcessHorizontalSpace = true;
		lblRabbitMQ_sslVersion.setLayoutData(lblrabbitMQ_sslVersionGridData);
		rabbitMQ_sslVersion = toolkit.createText(connSectionClient, "");
		rabbitMQ_sslVersion.setBackground(new Color(null, 229, 236, 253));
		GridData rabbitMQ_sslVersionGridData = new GridData();
		rabbitMQ_sslVersionGridData.horizontalSpan = 3;
		rabbitMQ_sslVersionGridData.horizontalAlignment = GridData.FILL;
		rabbitMQ_sslVersionGridData.grabExcessHorizontalSpace = true;
		rabbitMQ_sslVersion.setLayoutData(rabbitMQ_sslVersionGridData);
		rabbitMQ_sslVersion.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		dissableSSLfields();

	}
	
	public void setSSLFields(boolean check) {
		if (check) {
			enableSSLfields();
		}else {
			dissableSSLfields();
		}
	}


	protected void enableSSLfields() {
		GridData gdStoreLocation = (GridData) rabbitMQ_keyStoreLocation.getLayoutData();
		gdStoreLocation.exclude = false;
		GridData gdStoreKey = (GridData) rabbitMQ_keyStoreType.getLayoutData();
		gdStoreKey.exclude = false;
		GridData gdStorePass = (GridData) rabbitMQ_keyStorePassword.getLayoutData();
		gdStorePass.exclude = false;
		GridData gdTrustLocation = (GridData) rabbitMQ_trustStoreLocation.getLayoutData();
		gdTrustLocation.exclude = false;
		GridData gdTrustKey = (GridData) rabbitMQ_trustStoreType.getLayoutData();
		gdTrustKey.exclude = false;
		GridData gdTrustPass = (GridData) rabbitMQ_trustStorePassword.getLayoutData();
		gdTrustPass.exclude = false;
		GridData gdSslVersion = (GridData) rabbitMQ_sslVersion.getLayoutData();
		gdSslVersion.exclude = false;
		GridData gdStoreLocationlbl = (GridData) lblRabbitMQ_keyStoreLocation.getLayoutData();
		gdStoreLocationlbl.exclude = false;
		GridData gdStoreKeylbl = (GridData) lblRabbitMQ_keyStoreType.getLayoutData();
		gdStoreKeylbl.exclude = false;
		GridData gdStorePasslbl = (GridData) lblRabbitMQ_keyStorePassword.getLayoutData();
		gdStorePasslbl.exclude = false;
		GridData gdTrustLocationlbl = (GridData) lblRabbitMQ_trustStoreLocation.getLayoutData();
		gdTrustLocationlbl.exclude = false;
		GridData gdTrustKeylbl = (GridData) lblRabbitMQ_trustStoreType.getLayoutData();
		gdTrustKeylbl.exclude = false;
		GridData gdTrustPasslbl = (GridData) lblRabbitMQ_trustStorePassword.getLayoutData();
		gdTrustPasslbl.exclude = false;
		GridData gdSslVersionlbl = (GridData) lblRabbitMQ_sslVersion.getLayoutData();
		gdSslVersionlbl.exclude = false;
		rabbitMQ_keyStoreLocation.setVisible(true);
		rabbitMQ_keyStoreType.setVisible(true);
		rabbitMQ_keyStorePassword.setVisible(true);
		rabbitMQ_trustStoreLocation.setVisible(true);
		rabbitMQ_trustStoreType.setVisible(true);
		rabbitMQ_trustStorePassword.setVisible(true);
		rabbitMQ_sslVersion.setVisible(true);
		lblRabbitMQ_keyStoreLocation.setVisible(true);
		lblRabbitMQ_keyStoreType.setVisible(true);
		lblRabbitMQ_keyStorePassword.setVisible(true);
		lblRabbitMQ_trustStoreLocation.setVisible(true);
		lblRabbitMQ_trustStoreType.setVisible(true);
		lblRabbitMQ_trustStorePassword.setVisible(true);
		lblRabbitMQ_sslVersion.setVisible(true);
		enbaleConnectionSectionFields();

	}

	protected void dissableSSLfields() {
		GridData gdStoreLocation = (GridData) rabbitMQ_keyStoreLocation.getLayoutData();
		gdStoreLocation.exclude = true;
		GridData gdStoreKey = (GridData) rabbitMQ_keyStoreType.getLayoutData();
		gdStoreKey.exclude = true;
		GridData gdStorePass = (GridData) rabbitMQ_keyStorePassword.getLayoutData();
		gdStorePass.exclude = true;
		GridData gdTrustLocation = (GridData) rabbitMQ_trustStoreLocation.getLayoutData();
		gdTrustLocation.exclude = true;
		GridData gdTrustKey = (GridData) rabbitMQ_trustStoreType.getLayoutData();
		gdTrustKey.exclude = true;
		GridData gdTrustPass = (GridData) rabbitMQ_trustStorePassword.getLayoutData();
		gdTrustPass.exclude = true;
		GridData gdSslVersion = (GridData) rabbitMQ_sslVersion.getLayoutData();
		gdSslVersion.exclude = true;
		GridData gdStoreLocationlbl = (GridData) lblRabbitMQ_keyStoreLocation.getLayoutData();
		gdStoreLocationlbl.exclude = true;
		GridData gdStoreKeylbl = (GridData) lblRabbitMQ_keyStoreType.getLayoutData();
		gdStoreKeylbl.exclude = true;
		GridData gdStorePasslbl = (GridData) lblRabbitMQ_keyStorePassword.getLayoutData();
		gdStorePasslbl.exclude = true;
		GridData gdTrustLocationlbl = (GridData) lblRabbitMQ_trustStoreLocation.getLayoutData();
		gdTrustLocationlbl.exclude = true;
		GridData gdTrustKeylbl = (GridData) lblRabbitMQ_trustStoreType.getLayoutData();
		gdTrustKeylbl.exclude = true;
		GridData gdTrustPasslbl = (GridData) lblRabbitMQ_trustStorePassword.getLayoutData();
		gdTrustPasslbl.exclude = true;
		GridData gdSslVersionlbl = (GridData) lblRabbitMQ_sslVersion.getLayoutData();
		gdSslVersionlbl.exclude = true;
		rabbitMQ_keyStoreLocation.setVisible(false);
		rabbitMQ_keyStoreType.setVisible(false);
		rabbitMQ_keyStorePassword.setVisible(false);
		rabbitMQ_trustStoreLocation.setVisible(false);
		rabbitMQ_trustStoreType.setVisible(false);
		rabbitMQ_trustStorePassword.setVisible(false);
		rabbitMQ_sslVersion.setVisible(false);
		lblRabbitMQ_keyStoreLocation.setVisible(false);
		lblRabbitMQ_keyStoreType.setVisible(false);
		lblRabbitMQ_keyStorePassword.setVisible(false);
		lblRabbitMQ_trustStoreLocation.setVisible(false);
		lblRabbitMQ_trustStoreType.setVisible(false);
		lblRabbitMQ_trustStorePassword.setVisible(false);
		lblRabbitMQ_sslVersion.setVisible(false);
		enbaleConnectionSectionFields();

	}

	private void enbaleConnectionSectionFields() {
		if (connSection.isExpanded() == true) {
			connSection.setExpanded(false);
			connSection.setExpanded(true);
		}
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
		rabbitMQ_queueName.setBackground(new Color(null, 229, 236, 253));
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
		rabbitMQ_exchangeName.setBackground(new Color(null, 229, 236, 253));
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
		rabbitMQ_routingKey.setBackground(new Color(null, 229, 236, 253));
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
		rabbitMQ_username.setBackground(new Color(null, 229, 236, 253));
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
		rabbitMQ_password.setBackground(new Color(null, 229, 236, 253));
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
		rabbitMQ_virtualhost.setBackground(new Color(null, 229, 236, 253));
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
