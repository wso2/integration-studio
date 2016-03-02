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

package org.wso2.developerstudio.eclipse.artifact.connector.ui.dialog;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.wso2.developerstudio.eclipse.artifact.connector.Activator;
import org.wso2.developerstudio.eclipse.artifact.connector.model.ConnectorModel;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class WorkspaceConnectorImportDialog extends Dialog {
	
	private Table table;
	private ConnectorModel model;
	private TableViewer tblLibraryInfoViewer;
	private static final String DIR_DOT_METADATA = ".metadata";
	private static final String DIR_CONNECTORS = ".Connectors";
	private static final String CONNECTOR_XML = "connector.xml";
	private static final String DIR_ICON = "icon";
	private static final String ICON = "icon-large.gif";
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	public WorkspaceConnectorImportDialog(Shell parentShell, ConnectorModel model, TableViewer tblLibraryInfoViewer) {
		super(parentShell);
		this.model = model;
		this.tblLibraryInfoViewer = tblLibraryInfoViewer;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(1, false));
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		gridData.grabExcessHorizontalSpace = true;
		gridData.heightHint = 400;
		gridData.widthHint = 250;
		table = new Table(container, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		table.setEnabled(true);
		TableColumn tc1 = new TableColumn(table, SWT.LEFT);		
		TableColumn tc2 = new TableColumn(table, SWT.LEFT);		
		tc1.setText("Connector");
		tc2.setText("Description");
		tc1.setWidth(200);
		tc2.setWidth(328);
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
			}
		});
		listConnectors(table); 
		return container;
	}
	
	@Override
	protected void okPressed() {
		for (TableItem tableItem :table.getItems()) {
			if (tableItem.getChecked()) {
				String filePath = ((org.wso2.developerstudio.eclipse.artifact.connector.ui.dialog.Connector) tableItem.getData()).getConnectorFilePath();
				model.getConnectors().add(new File(filePath+".zip"));
			}
		}
		super.okPressed();
	}
	
	/*
	 * List available connectors
	 */
	private void listConnectors(Table table) {	
		String connectorDirectory = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()
				+ File.separator + DIR_DOT_METADATA + File.separator + DIR_CONNECTORS;
		File directory=new File(connectorDirectory);
		if(directory.isDirectory()){
			File[] children=directory.listFiles();
	        for(int i=0;i<children.length;++i){
	        	if(children[i].isDirectory()){
	        		TableItem item = new TableItem(table, SWT.NONE);
	        		Connector connector = deserializeConnectorXML(children[i].getAbsolutePath()+File.separator+CONNECTOR_XML);
	        		connector.setConnectorFilePath(children[i].getAbsolutePath());
	        		item.setText(new String[] {connector.getConnectorName(),connector.getConnectorDescription()});
	        		item.setData(connector);	        		
	        		String iconFileName = children[i].getAbsolutePath()+File.separator+DIR_ICON+File.separator+ICON;
	        		File icon = new File(iconFileName);
					if (icon.exists()) {
						Image image = new Image(Display.getDefault(), iconFileName);
						item.setImage(image);
					}
	        	}
	        }
		}
	}
	
	private Connector deserializeConnectorXML(String connectorFileName){
		Connector connector = null; 
		try{
			File artifactsFile = new File(connectorFileName);
			String artifactsContent = FileUtils.getContentAsString(artifactsFile);
			connector = new Connector();
			connector.deserialize(artifactsContent);
			
		}catch(Exception e){
			log.error("Error while deserializing connector xml", e);
		}
		return connector;
	}

	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Selection dialog");
	}
	
	protected boolean isResizable() {
	    return true;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(550, 520);
	}
}
