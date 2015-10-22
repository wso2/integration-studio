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

package org.wso2.developerstudio.eclipse.registry.core.ui.widgets;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryConnection;
import org.wso2.developerstudio.eclipse.registry.core.interfaces.IRegistryHandler;

public class FromRegistry extends Composite{

	private boolean isRadioButtonEnabled;
	private Text pathText;
	private IProject selectedProject;
	private List<IRegistryConnection> registryConnections;
	
	public FromRegistry(Composite parent, int style, boolean controlEnabled, IProject p) {
		super(parent, style);
		this.isRadioButtonEnabled = controlEnabled;
		createControl(parent);
		this.selectedProject = p;
	}
	
	public void createControl(Composite parent){
		final Group group = new Group(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
		layout.verticalSpacing = 9;
		group.setLayout(layout);
		
		GridData gd = new GridData();
		Button enabledButton = new Button(group, SWT.RADIO);
		enabledButton.setLayoutData(gd);
		enabledButton.setVisible(false);
		
		if(isRadioButtonEnabled){
			enabledButton.setVisible(true);
		}
		
		gd = new GridData();
		Label regPathLabel = new Label(group, SWT.NULL);
		regPathLabel.setText("Registry Path");
		regPathLabel.setLayoutData(gd);
		
		pathText = new Text(group, SWT.BORDER);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		pathText.setLayoutData(gd);
		
		Button browseButton = new Button(group, SWT.PUSH);
		browseButton.setText("Browse");
		gd = new GridData();
		gd.widthHint = 100; 
		browseButton.setLayoutData(gd);
		
//        if(CAppEnvironment.isRegistryHandlerPresent()){
//        	registryConnections = CAppEnvironment.getRegistryHandler().getRegistryConnections(selectedProject);
//        }
//		
//		browseButton.addSelectionListener(new SelectionListener() {
//			
//			public void widgetSelected(SelectionEvent arg0) {
//				int type = IRegistryHandler.SELECTED_REGISTRY_RESOURCE | IRegistryHandler.SELECTED_REGISTRY_PATH;
//				String title = "Browse registry path to check-out";
//				String message = "Select registry path to check-out";
//				CAppEnvironment.getRegistryHandler().selectRegistryPath(registryConnectionsList(), title, message, type);
//			}
//			
//			public void widgetDefaultSelected(SelectionEvent arg0) {
//				
//			}
//		});
		
	}
	
	public IRegistryConnection[] registryConnectionsList(){
		IRegistryConnection[] cons = null;
		if(!registryConnections.isEmpty()){
			cons = new IRegistryConnection[registryConnections.size()];
			for(int i = 0; i<registryConnections.size(); i++){
				cons[i] = registryConnections.get(i);
			}
		}
		return cons;
	}
}
