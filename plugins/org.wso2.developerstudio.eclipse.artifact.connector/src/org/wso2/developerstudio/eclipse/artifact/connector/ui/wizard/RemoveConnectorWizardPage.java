/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.connector.ui.wizard;

import javax.xml.stream.FactoryConfigurationError;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.wso2.developerstudio.eclipse.artifact.connector.Activator;
import org.wso2.developerstudio.eclipse.artifact.connector.artifact.ConnectorArtifact;
import org.wso2.developerstudio.eclipse.artifact.connector.artifact.ConnectorProjectArtifact;
import org.wso2.developerstudio.eclipse.artifact.connector.model.ConnectorModel;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class RemoveConnectorWizardPage extends WizardPage {
	private TableViewer tblLibraryInfoViewer;
	private ConnectorModel model;
	private Table table;
	private IProject project;
	private ConnectorProjectArtifact connectorProjectArtifact;
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public RemoveConnectorWizardPage(IProject project, ConnectorProjectArtifact connectorProjectArtifact) {
		super("wizardPage");
		setTitle("Add/Remove connector");
		setDescription("Add/Remove connector");
		this.project = project;
		this.connectorProjectArtifact = connectorProjectArtifact;
	}

	public RemoveConnectorWizardPage(boolean existingProject) {
		super("wizardPage");
		setTitle("Add/Remove connector");
		setDescription("Add/Remove connector");
	}

	public void createControl(Composite parent) {		
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		gridData.grabExcessHorizontalSpace = true;
		gridData.heightHint = 260;
		gridData.widthHint = 300;
		table = new Table(container, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		table.setEnabled(true);
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);			
		tc1.setText("Connector");
		tc1.setWidth(200);
		table.setHeaderVisible(true);
		table.setLayoutData(gridData);
		table.addListener(SWT.Selection, new Listener() {	        			
			public void handleEvent(Event e) {
				boolean complete = false;
				for(TableItem item: table.getItems()){
				if(item.getChecked()){
					complete = true;
    				break;
				}
				}
				((AddRemoveConnectorWizard) getWizard()).getAddWizardPage().setPageComplete(true);
				setPageComplete(complete);  
			}
		});
		try {
			listConnectors(table);
		} catch (FactoryConfigurationError e1) {
			log.error("Error while listing connectors ", e1);
			MessageDialog.openError(getShell(), "Error while listing connectors ", e1.getMessage());
		} catch (Exception e1) {
			log.error("Error while listing connectors ", e1);
			MessageDialog.openError(getShell(), "Error while listing connectors ", e1.getMessage());
		}  		
	}	
	
	/*
	 * List available connectors
	 */
	private void listConnectors(Table table) throws FactoryConfigurationError, Exception {
		connectorProjectArtifact.fromFile(project.getFile("artifact.xml").getLocation().toFile());
		model = ((AddRemoveConnectorWizard) getWizard()).getRemoveConnectorModel();
		
		for(ConnectorArtifact connectorArtifact : connectorProjectArtifact.getAllESBArtifacts()){			
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(connectorArtifact.getFile());
			item.setData(connectorArtifact);
			model.getConnectors().add(connectorArtifact);
		}
	}

	public boolean isValid() {
		if (tblLibraryInfoViewer.getTable().getItemCount() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
}
