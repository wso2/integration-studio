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

package org.wso2.developerstudio.eclipse.registry.manager.remote.wizards;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryNode;
import org.wso2.developerstudio.eclipse.registry.base.model.RegistryResourceNode;
import org.wso2.developerstudio.eclipse.registry.base.ui.dialog.UserPermissionDialog;
import org.wso2.developerstudio.eclipse.registry.base.usermgt.ui.controls.UserPermissionTreeViewer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SetPermissionWizardPage1 extends WizardPage{
	private UserPermissionTreeViewer treeViewer;
	private List<RegistryResourceNode> selectedItemsList;

	private RegistryNode registryData;

	private String registryResourcePath;
	
	private RegistryResourceNode resourceNode;

	/**
     * @param pageName
     */
    protected SetPermissionWizardPage1(String pageName, RegistryNode registryData, String registryResourcePath,RegistryResourceNode resourceNode) {
	    super(pageName);
	    setPageComplete(true);
	    setTitle("Set Permissions to Role");
	    this.registryData=registryData;
	    this.registryResourcePath=registryResourcePath;
	    this.resourceNode=resourceNode;
    }

	/* (non-Javadoc)
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    
    public void createControl(Composite parent) {
    	Composite container = new Composite(parent, SWT.BORDER);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		// layout.verticalSpacing = 10;
		GridData gd = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(gd);
		
		treeViewer=new UserPermissionTreeViewer(container, SWT.BORDER | SWT.CHECK,registryData, registryResourcePath);
		treeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
//		treeViewer.expandAll();
		treeViewer.expandToLevel(3);
//		treeViewer.setSelection(new StructuredSelection(resourceNode), true);
//		treeViewer.refresh(resourceNode);
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			
			public void selectionChanged(SelectionChangedEvent arg0) {
				selectedItemsList= selectedItemList();
//				if(!selectedItemsList.isEmpty()){
//					setPageComplete(true);
//				}
			}
		});
		setControl(container);
    }
    
    public void savePageInfo() {
		List<RegistryResourceNode> selectedCollectionList = treeViewer
				.getSelectedRegistryPathCollections();
		List<RegistryResourceNode> selectedResourceList = treeViewer
				.getSelectedRegistryPathResources();
	}

	public List<RegistryResourceNode> selectedItemList() {
		List<RegistryResourceNode> list = new ArrayList();
		for (int i = 0; i < treeViewer.getSelectedRegistryPathCollections().size(); i++) {
			list.add(treeViewer.getSelectedRegistryPathCollections().get(i));
		}
		for (int i = 0; i < treeViewer.getSelectedRegistryPathResources().size(); i++) {
			list.add(treeViewer.getSelectedRegistryPathResources().get(i));
		}
		return list;
	}

}
