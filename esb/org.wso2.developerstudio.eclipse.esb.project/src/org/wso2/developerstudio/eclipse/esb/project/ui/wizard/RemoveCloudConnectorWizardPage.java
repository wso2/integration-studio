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

package org.wso2.developerstudio.eclipse.esb.project.ui.wizard;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.wso2.developerstudio.eclipse.esb.project.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

public class RemoveCloudConnectorWizardPage extends WizardPage{
	private IProject selectedProject;
	private List<Connector> connectorList;
	private Table table;
	private static final String DIR_DOT_METADATA = ".metadata";
	private static final String DIR_CONNECTORS = ".Connectors";
	private static final String CONNECTOR_XML = "connector.xml";
	private static final String DIR_ICON = "icon";
	private static final String ICON = "icon-large.gif";
	
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	protected RemoveCloudConnectorWizardPage(IStructuredSelection selection) {
		super("remove");
		setTitle("Remove connector");
		setDescription("Remove existing connectors.");
		IProject project = getProject(selection);
		if (project != null) {
			setSelectedProject(project);
		}
	}

	@Override
	public void createControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
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
				((CloudConnectorImportWizard) getWizard()).getStoreWizardPage().setPageComplete(true);
				setPageComplete(complete);  
			}
		});
		listConnectors(table);  
	}

	public static IProject getProject(Object obj){
		if (obj == null) {
			return null;
		}
		if (obj instanceof IResource) {
			return ((IResource) obj).getProject();
		} else if (obj instanceof IStructuredSelection) {
			return getProject(((IStructuredSelection) obj).getFirstElement());
		}
		return null;
	}
		
	/*
	 * List available connectors
	 */
	private void listConnectors(Table table) {				
		String connectorDirectory = getSelectedProject().getWorkspace().getRoot().getLocation().toOSString()
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


	public IProject getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(IProject selectedProject) {
		this.selectedProject = selectedProject;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
	
	public List<Connector> getConnectorList() {
		return connectorList;
	}

	public void setConnectorList(List<Connector> connectorList) {
		this.connectorList = connectorList;
	}
}
