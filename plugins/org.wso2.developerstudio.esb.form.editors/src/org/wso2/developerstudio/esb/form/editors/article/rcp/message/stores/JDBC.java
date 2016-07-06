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
import org.wso2.developerstudio.esb.form.editors.article.rcp.AbstractEsbFormPage;
import org.wso2.developerstudio.esb.form.editors.article.rcp.Messages;

public class JDBC implements IMessageStore {
	
	public Text jdbc_dbTable;
	public Combo jdbc_connectionInfo;
	public Text jdbc_driver;
	public Text jdbc_url;
	public Text jdbc_username;
	public Text jdbc_password;
	public Text jdbc_DsName;
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
		connSectionClient.setLayout(new TableWrapLayout());
		connSection.setClient(connSectionClient);
		
		connSection.setVisible(false);
		
		toolkit.createLabel(connSectionClient, "JDBC Database Table");
		jdbc_dbTable = toolkit.createText(connSectionClient, "");
		jdbc_dbTable.setBackground(new Color(null, 229,236,253));
		jdbc_dbTable.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		jdbc_dbTable.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		toolkit.createLabel(connSectionClient, "JDBC Conection Information");
		jdbc_connectionInfo = new Combo(connSectionClient, SWT.DROP_DOWN);
		jdbc_connectionInfo.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
		String[] jdbcTypes = {"JDBC_POOL", "JDBC_CARBON_DATASOURCE"};
		jdbc_connectionInfo.setItems(jdbcTypes);
		jdbc_connectionInfo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				esbFormPage.setSave(true);
				esbFormPage.updateDirtyState();
			}
		});
		
		
		
			//-- if connection info is JDBC_POOL
			toolkit.createLabel(connSectionClient, "JDBC Driver");
			jdbc_driver = toolkit.createText(connSectionClient, "");
			jdbc_driver.setBackground(new Color(null, 229,236,253));
			jdbc_driver.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
			jdbc_driver.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					esbFormPage.setSave(true);
					esbFormPage.updateDirtyState();
				}
			});
			
			toolkit.createLabel(connSectionClient, "JDBC URL");
			jdbc_url = toolkit.createText(connSectionClient, "");
			jdbc_url.setBackground(new Color(null, 229,236,253));
			jdbc_url.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
			jdbc_url.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					esbFormPage.setSave(true);
					esbFormPage.updateDirtyState();
				}
			});
			
			toolkit.createLabel(connSectionClient, "JDBC Username");
			jdbc_username = toolkit.createText(connSectionClient, "");
			jdbc_username.setBackground(new Color(null, 229,236,253));
			jdbc_username.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
			jdbc_username.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					esbFormPage.setSave(true);
					esbFormPage.updateDirtyState();
				}
			});
			
			toolkit.createLabel(connSectionClient, "JDBC Password");
			jdbc_password = toolkit.createText(connSectionClient, "");
			jdbc_password.setBackground(new Color(null, 229,236,253));
			jdbc_password.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
			jdbc_password.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					esbFormPage.setSave(true);
					esbFormPage.updateDirtyState();
				}
			});
			
			
			//-- if connection info is JDBC_CARBON_DATASOURCE
			toolkit.createLabel(connSectionClient, "JDBC Datasource Name");
			jdbc_DsName = toolkit.createText(connSectionClient, "");
			jdbc_DsName.setBackground(new Color(null, 229,236,253));
			jdbc_DsName.setLayoutData(new TableWrapData(TableWrapData.FILL_GRAB));
			jdbc_DsName.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					esbFormPage.setSave(true);
					esbFormPage.updateDirtyState();
				}
			});
		
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
//		 parameterSection.setVisible(false);
		
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
//		 parameterSection.setVisible(true);
		
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
