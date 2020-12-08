/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.capp.registry.connector.provider;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.wso2.developerstudio.eclipse.capp.core.artifacts.manager.CAppEnvironment;
import org.wso2.developerstudio.eclipse.capp.core.model.RegistryData;
import org.wso2.developerstudio.eclipse.capp.registry.connector.model.RegistryConnectionNode;
import org.wso2.developerstudio.eclipse.capp.registry.connector.utils.RegistryConnectorImageUtils;
import org.wso2.developerstudio.eclipse.capp.registry.connector.utils.RegistryHandlerUtils;

public class RegistryConnectionActionProvider extends CommonActionProvider{
	private Action actionOpenRegistryBrowserViewer;
	private Action actionDelete;
	private RegistryConnectionNode connection;
	
	public RegistryConnectionActionProvider() {
		createActions();
	}

	private void createActions() {
		actionOpenRegistryBrowserViewer = new Action("Open",RegistryConnectorImageUtils.getInstance().getImageDescriptor("open-in-new-window.png")){
			public void run() {
				RegistryData registryData = new RegistryData();
				registryData.setURL(connection.getRegistryConnection().getURL());
				registryData.setPath(connection.getRegistryConnection().getPath());
				CAppEnvironment.getRegistryHandler().openRegistryBrowserView(registryData);
			}
		};
		actionDelete = new Action("Delete",RegistryConnectorImageUtils.getInstance().getImageDescriptor("del.png")){
			public void run() {
				if (connection!=null){
					if (MessageDialog.openQuestion(getShell(), "Delete Registry Connection", "Are you sure you want to remove the registry connection '"+connection.getCaption()+"'")){
						RegistryHandlerUtils.removeRegistryConnection(connection.getParentRegistryConnections().getProject(),connection.getRegistryConnection());
						CAppEnvironment.getRegistryHandler().hideRegistryBrowserView(connection.getRegistryConnection().getURL().toString(), connection.getRegistryConnection().getPath());
					}
				}
			}
		};
	}

	public void fillContextMenu(IMenuManager menu) {
		updateSelectedObjects();
		menu.add(actionOpenRegistryBrowserViewer);
		menu.add(actionDelete);		
	}

	public void addGroupSeperator(IMenuManager menu) {
		menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
		menu.add(new Separator());
	}
	
	private Shell getShell(){
		return Display.getCurrent().getActiveShell();
	}
	
	private void updateSelectedObjects() {
	    TreeSelection selection=(TreeSelection)getContext().getSelection();
	    connection = null;
		if (selection.getFirstElement() instanceof RegistryConnectionNode){
			connection = (RegistryConnectionNode)selection.getFirstElement();
    	} 
    }
}
