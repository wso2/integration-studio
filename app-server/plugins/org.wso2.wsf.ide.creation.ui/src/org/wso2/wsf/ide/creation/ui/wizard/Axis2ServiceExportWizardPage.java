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

package org.wso2.wsf.ide.creation.ui.wizard;

import java.util.ArrayList;
import java.util.Map;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.wst.Axis2ServiceUtils;
import org.wso2.wsf.ide.creation.ui.plugin.WebServiceWSASCreationUIPlugin;

public class Axis2ServiceExportWizardPage extends WizardPage {
	private static IDeveloperStudioLog log=Logger.getLog(WebServiceWSASCreationUIPlugin.PLUGIN_ID);

    private Combo serviceSelectionCombo;
    private IFolder selectedFolder;
	private Map<IFolder, IProject> pathList;

	private ArrayList<IFolder> folders;

	public Axis2ServiceExportWizardPage(String pageName , IProject p) {
		super(pageName);
		setTitle("Axis2 Service Archive");
		setDescription("Create an axis2 service archive file");
    }

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		container.setLayout(layout);
		Label lblWorkspaceService=new Label(container,SWT.NULL);
		lblWorkspaceService.setText("Axis2 service in the workspace");
		GridData gd = new GridData();
        gd.horizontalSpan=1;
//        gd.horizontalIndent=10;
        lblWorkspaceService.setLayoutData(gd);

        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan=1;
//        gd.horizontalIndent=25;
		serviceSelectionCombo = new Combo(container,SWT.NONE | SWT.READ_ONLY);
		serviceSelectionCombo.setLayoutData(gd);
		serviceSelectionCombo.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e) {
				setSelectedFolder(folders.get(serviceSelectionCombo.getSelectionIndex()));
			}
		});
		fillServiceSelectionCombo();
		updateControlData();
		validate();
		setControl(container);
	}
	
	private void fillServiceSelectionCombo(){
		try {
	        pathList=Axis2ServiceUtils.getServiceFolders();
			if (pathList.size() != 0) {
				folders=new ArrayList<IFolder>();
				serviceSelectionCombo.removeAll();
				for(IFolder folder:pathList.keySet()){
					folders.add(folder);
					serviceSelectionCombo.add(Axis2ServiceUtils.getServiceNameFromFolder(folder.getLocation().toOSString())+" - ["+pathList.get(folder).getName()+"]");
				}
				updateStatus(null);
			}else{
				updateStatus("No services present in workspace");
			}
		} catch (Exception e) {
	        log.error(e);
        } 
	}
	
    public void updateControlData(){
    	if (serviceSelectionCombo.getItemCount()>0){
    		serviceSelectionCombo.select(0);
    		setSelectedFolder(folders.get(0));
    	}
    }

    
	private void validate() {
		if (serviceSelectionCombo.getSelectionIndex()==-1){
			updateStatus("No services exists in the workspace to export");
		}else{
			updateStatus(null);
		}
    }
	
	private void updateStatus(String message) {
		setPageComplete(message==null);
		setErrorMessage(message);
    }

	public void setSelectedFolder(IFolder selectedFolder) {
	    this.selectedFolder = selectedFolder;
    }

	public IFolder getSelectedFolder() {
	    return selectedFolder;
    }
}
