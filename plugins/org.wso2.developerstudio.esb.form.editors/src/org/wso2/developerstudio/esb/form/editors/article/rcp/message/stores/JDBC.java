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
import org.wso2.developerstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;

public class JDBC implements IMessageStore {

	public Text jdbc_dbTable;
	public Combo jdbc_connectionInfo;
	public Text jdbc_driver;
	public Label lbl_jdbc_driver;
	public Text jdbc_url;
	public Label lbl_jdbc_url;
	public Text jdbc_username;
	public Label lbl_jdbc_username;
	public Text jdbc_password;
	public Label lbl_jdbc_password;
	public Text jdbc_DsName;
	public Label lbl_jdbc_DsName;
	private AbstractEsbFormPage esbFormPage;

	ScrolledForm form;
	FormToolkit toolkit;

	Section connSection;
	Section parameterSection;

	public JDBC(ScrolledForm form, FormToolkit toolkit, AbstractEsbFormPage esbFormPage) {
		this.form = form;
		this.toolkit = toolkit;
		this.esbFormPage = esbFormPage;
	}

	@Override
	public void createConnectionSectionFields() {

		connSection = this.createSection(form, toolkit, Messages.getString("MessageProcessorPage.section.misc"));

		Composite connSectionClient = toolkit.createComposite(connSection);
		connSectionClient.setLayout(new GridLayout());
		connSection.setClient(connSectionClient);

		connSection.setVisible(false);

		GridData taskImplGridData = new GridData();
		taskImplGridData.horizontalSpan = 3;
		taskImplGridData.horizontalAlignment = GridData.FILL;
		taskImplGridData.grabExcessHorizontalSpace = true;
		connSection.setLayoutData(taskImplGridData);

		toolkit.createLabel(connSectionClient, "JDBC Database Table");
		jdbc_dbTable = toolkit.createText(connSectionClient, "");
		jdbc_dbTable.setBackground(new Color(null, 229, 236, 253));
		GridData jdbc_dbTableGridData = new GridData();
		jdbc_dbTableGridData.horizontalSpan = 3;
		jdbc_dbTableGridData.horizontalAlignment = GridData.FILL;
		jdbc_dbTableGridData.grabExcessHorizontalSpace = true;
		jdbc_dbTable.setLayoutData(jdbc_dbTableGridData);
		jdbc_dbTable.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		toolkit.createLabel(connSectionClient, "JDBC Conection Information");
		jdbc_connectionInfo = new Combo(connSectionClient, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData jdbc_connectionInfoGridData = new GridData();
		jdbc_connectionInfoGridData.horizontalSpan = 3;
		jdbc_connectionInfoGridData.horizontalAlignment = GridData.FILL;
		jdbc_connectionInfoGridData.grabExcessHorizontalSpace = true;
		jdbc_connectionInfo.setLayoutData(jdbc_connectionInfoGridData);
		String[] jdbcTypes = { "JDBC_POOL", "JDBC_CARBON_DATASOURCE" };
		jdbc_connectionInfo.setItems(jdbcTypes);
		jdbc_connectionInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (jdbc_connectionInfo.getSelectionIndex() == 0) {
					enablePoolfields();
					disableDataSourcefields();
					jdbc_DsName.setText("");
				} else {
					disablePoolfields();
					enableDataSourcefields();
					jdbc_driver.setText("");
					jdbc_url.setText("");
					jdbc_username.setText("");
					jdbc_password.setText("");
				}
				super.widgetSelected(e);
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();

			}
		});
		
		jdbc_connectionInfo.addListener(SWT.MouseVerticalWheel, new Listener() {
			@Override
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});

		// -- if connection info is JDBC_POOL
		lbl_jdbc_driver = toolkit.createLabel(connSectionClient, "JDBC Driver");
		GridData lbl_jdbc_driverInfoGridData = new GridData();
		lbl_jdbc_driverInfoGridData.horizontalSpan = 3;
		lbl_jdbc_driverInfoGridData.horizontalAlignment = GridData.FILL;
		lbl_jdbc_driverInfoGridData.grabExcessHorizontalSpace = true;
		lbl_jdbc_driver.setLayoutData(lbl_jdbc_driverInfoGridData);

		jdbc_driver = toolkit.createText(connSectionClient, "");
		jdbc_driver.setBackground(new Color(null, 229, 236, 253));
		GridData jdbc_driverInfoGridData = new GridData();
		jdbc_driverInfoGridData.horizontalSpan = 3;
		jdbc_driverInfoGridData.horizontalAlignment = GridData.FILL;
		jdbc_driverInfoGridData.grabExcessHorizontalSpace = true;
		jdbc_driver.setLayoutData(jdbc_driverInfoGridData);
		jdbc_driver.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lbl_jdbc_url =toolkit.createLabel(connSectionClient, "JDBC URL");
		GridData lbl_jdbc_urlGridData = new GridData();
		lbl_jdbc_urlGridData.horizontalSpan = 3;
		lbl_jdbc_urlGridData.horizontalAlignment = GridData.FILL;
		lbl_jdbc_urlGridData.grabExcessHorizontalSpace = true;
		lbl_jdbc_url.setLayoutData(lbl_jdbc_urlGridData);
		
		jdbc_url = toolkit.createText(connSectionClient, "");
		jdbc_url.setBackground(new Color(null, 229, 236, 253));
		GridData jdbc_urlInfoGridData = new GridData();
		jdbc_urlInfoGridData.horizontalSpan = 3;
		jdbc_urlInfoGridData.horizontalAlignment = GridData.FILL;
		jdbc_urlInfoGridData.grabExcessHorizontalSpace = true;
		jdbc_url.setLayoutData(jdbc_urlInfoGridData);
		jdbc_url.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lbl_jdbc_username =toolkit.createLabel(connSectionClient, "JDBC Username");
		GridData lbl_jdbc_usernameGridData = new GridData();
		lbl_jdbc_usernameGridData.horizontalSpan = 3;
		lbl_jdbc_usernameGridData.horizontalAlignment = GridData.FILL;
		lbl_jdbc_usernameGridData.grabExcessHorizontalSpace = true;
		lbl_jdbc_username.setLayoutData(lbl_jdbc_usernameGridData);
		
		jdbc_username = toolkit.createText(connSectionClient, "");
		jdbc_username.setBackground(new Color(null, 229, 236, 253));
		GridData jdbc_usernameGridData = new GridData();
		jdbc_usernameGridData.horizontalSpan = 3;
		jdbc_usernameGridData.horizontalAlignment = GridData.FILL;
		jdbc_usernameGridData.grabExcessHorizontalSpace = true;
		jdbc_username.setLayoutData(jdbc_usernameGridData);
		jdbc_username.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		lbl_jdbc_password =toolkit.createLabel(connSectionClient, "JDBC Password");
		GridData lbl_jdbc_passwordGridData = new GridData();
		lbl_jdbc_passwordGridData.horizontalSpan = 3;
		lbl_jdbc_passwordGridData.horizontalAlignment = GridData.FILL;
		lbl_jdbc_passwordGridData.grabExcessHorizontalSpace = true;
		lbl_jdbc_password.setLayoutData(lbl_jdbc_passwordGridData);
		
		jdbc_password = toolkit.createText(connSectionClient, "");
		jdbc_password.setBackground(new Color(null, 229, 236, 253));
		GridData jdbc_passwordGridData = new GridData();
		jdbc_passwordGridData.horizontalSpan = 3;
		jdbc_passwordGridData.horizontalAlignment = GridData.FILL;
		jdbc_passwordGridData.grabExcessHorizontalSpace = true;
		jdbc_password.setLayoutData(jdbc_passwordGridData);
		jdbc_password.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		disablePoolfields();

		// -- if connection info is JDBC_CARBON_DATASOURCE
		lbl_jdbc_DsName =toolkit.createLabel(connSectionClient, "JDBC Datasource Name");;
		GridData lbl_jdbc_DsNameGridData = new GridData();
		lbl_jdbc_DsNameGridData.horizontalSpan = 3;
		lbl_jdbc_DsNameGridData.horizontalAlignment = GridData.FILL;
		lbl_jdbc_DsNameGridData.grabExcessHorizontalSpace = true;
		lbl_jdbc_DsName.setLayoutData(lbl_jdbc_DsNameGridData);
		
		jdbc_DsName = toolkit.createText(connSectionClient, "");
		jdbc_DsName.setBackground(new Color(null, 229, 236, 253));
		GridData jdbc_DsNameGridData = new GridData();
		jdbc_DsNameGridData.horizontalSpan = 3;
		jdbc_DsNameGridData.horizontalAlignment = GridData.FILL;
		jdbc_DsNameGridData.grabExcessHorizontalSpace = true;
		jdbc_DsName.setLayoutData(jdbc_DsNameGridData);
		jdbc_DsName.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});

		disableDataSourcefields();

	}

	private void disablePoolfields() {

		GridData gdDriver = (GridData) jdbc_driver.getLayoutData();
		gdDriver.exclude = true;
		GridData gdDriverLbl = (GridData) lbl_jdbc_driver.getLayoutData();
		gdDriverLbl.exclude = true;
		GridData gdUrl = (GridData) jdbc_url.getLayoutData();
		gdUrl.exclude = true;
		GridData gdUrlLbl = (GridData) lbl_jdbc_url.getLayoutData();
		gdUrlLbl.exclude = true;
		GridData gdUName = (GridData) jdbc_username.getLayoutData();
		gdUName.exclude = true;
		GridData gdUNameLbl = (GridData) lbl_jdbc_username.getLayoutData();
		gdUNameLbl.exclude = true;
		GridData gdPass = (GridData) jdbc_password.getLayoutData();
		gdPass.exclude = true;
		GridData gdPassLbl = (GridData) lbl_jdbc_password.getLayoutData();
		gdPassLbl.exclude = true;
		// rmPolicy.setVisible(false);
		jdbc_driver.setVisible(false);
		lbl_jdbc_driver.setVisible(false);
		jdbc_url.setVisible(false);
		lbl_jdbc_url.setVisible(false);
		jdbc_username.setVisible(false);
		lbl_jdbc_username.setVisible(false);
		jdbc_password.setVisible(false);
		lbl_jdbc_password.setVisible(false);
		enbaleVisualizingConnectionFields();
	}

	private void enablePoolfields() {

		GridData gdDriver = (GridData) jdbc_driver.getLayoutData();
		gdDriver.exclude = false;
		GridData gdDriverLbl = (GridData) lbl_jdbc_driver.getLayoutData();
		gdDriverLbl.exclude = false;
		GridData gdUrlLbl = (GridData) lbl_jdbc_url.getLayoutData();
		gdUrlLbl.exclude = false;
		GridData gdUrl = (GridData) jdbc_url.getLayoutData();
		gdUrl.exclude = false;
		GridData gdUName = (GridData) jdbc_username.getLayoutData();
		gdUName.exclude = false;
		GridData gdUNameLbl = (GridData) lbl_jdbc_username.getLayoutData();
		gdUNameLbl.exclude = false;
		GridData gdPass = (GridData) jdbc_password.getLayoutData();
		gdPass.exclude = false;
		GridData gdPassLbl = (GridData) lbl_jdbc_password.getLayoutData();
		gdPassLbl.exclude = false;
		// rmPolicy.setVisible(false);
		jdbc_driver.setVisible(true);
		lbl_jdbc_driver.setVisible(true);
		jdbc_url.setVisible(true);
		lbl_jdbc_url.setVisible(true);
		jdbc_username.setVisible(true);
		lbl_jdbc_username.setVisible(true);
		jdbc_password.setVisible(true);
		lbl_jdbc_password.setVisible(true);
		enbaleVisualizingConnectionFields();
	}

	public void setPoolingFields(boolean check) {
		if (check) {
			enablePoolfields();
		}
	}

	public void setDataSourceFields(boolean check) {
		if (check) {
			enableDataSourcefields();
		}
	}

	private void disableDataSourcefields() {

		GridData gdDSname = (GridData) jdbc_DsName.getLayoutData();
		gdDSname.exclude = true;
		GridData gdDSnameLbl = (GridData) lbl_jdbc_DsName.getLayoutData();
		gdDSnameLbl.exclude = true;
		jdbc_DsName.setVisible(false);
		lbl_jdbc_DsName.setVisible(false);
		enbaleVisualizingConnectionFields();
	}

	private void enableDataSourcefields() {

		GridData gdDSname = (GridData) jdbc_DsName.getLayoutData();
		gdDSname.exclude = false;
		GridData gdDSnameLbl = (GridData) lbl_jdbc_DsName.getLayoutData();
		gdDSnameLbl.exclude = false;
		jdbc_DsName.setVisible(true);
		lbl_jdbc_DsName.setVisible(true);
		enbaleVisualizingConnectionFields();
	}

	private void enbaleVisualizingConnectionFields() {
		if (connSection.isExpanded() == true) {
			connSection.setExpanded(false);
			connSection.setExpanded(true);
		}
	}

	@Override
	public void createParameterSectionFields() {
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

	@Override
	public void hideGuaranteedDeliverySection() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hideParametersSection() {
		// parameterSection.setVisible(false);

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
		// parameterSection.setVisible(true);

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
