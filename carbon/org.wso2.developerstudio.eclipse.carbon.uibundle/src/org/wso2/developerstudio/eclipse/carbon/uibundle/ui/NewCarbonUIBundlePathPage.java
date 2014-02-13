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

package org.wso2.developerstudio.eclipse.carbon.uibundle.ui;

import javax.sound.midi.Patch;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.pde.internal.ui.wizards.IProjectProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewCarbonUIBundlePathPage extends WizardPage{

//	private NewCarbonUIProjectCreationPage fMainPage;
	private String prjctName;
	private String path;
	private IProjectProvider projectProvider;
	private Text pathText;
	
	public String getPrjctName() {
		return prjctName;
	}

	public void setPrjctName(String prjctName) {
		this.prjctName = prjctName;
	}

	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	protected NewCarbonUIBundlePathPage(String pageName, IProjectProvider prjctProvider) {
		super(pageName);
		this.projectProvider = prjctProvider;
		// TODO Auto-generated constructor stub
	}

	public void createControl(Composite parent) {
		if(projectProvider != null){
			prjctName = projectProvider.getProjectName();
			setPrjctName(prjctName);
		}
		
		final Group group = new Group(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		group.setLayout(layout);	
		
		GridData gd = new GridData();
		Label deployPathLabel = new Label(group, SWT.NULL);
		deployPathLabel.setText("Deploy Path: ");
		gd.horizontalSpan = 2;
		deployPathLabel.setLayoutData(gd);
		
		gd = new GridData();
		Label pathInfoLabel = new Label(group, SWT.NULL);
		pathInfoLabel.setText("https://<host_name>/<context>/");
		pathInfoLabel.setLayoutData(gd);
		
		gd = new GridData(GridData.FILL_HORIZONTAL);
		pathText = new Text(group, SWT.BORDER);
		if(prjctName != null){
			pathText.setText("customui/" + prjctName);
		}
		pathText.setText("customui/");
		setPath(pathText.getText());
		pathText.setLayoutData(gd);
		
		pathText.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				setPath(pathText.getText());
				
			}
		});
		
		setControl(group);
		
		
	}
	
		public void setVisible(boolean visible) {
			prjctName = projectProvider.getProjectName();
			pathText.setText("customui/" + prjctName);
			setPath(pathText.getText());
			super.setVisible(visible);
		}



}
