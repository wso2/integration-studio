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

package org.wso2.developerstudio.eclipse.bpel.connector.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.bpel.runtimes.ui.wizards.NewBPELProjectWizard;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.common.componentcore.datamodel.properties.IFacetDataModelProperties;
import org.wso2.wsf.ide.bpel.export.utils.BpelUtils;
import org.wso2.wsf.ide.bpel.export.utils.FileManagementUtil;

public class BPELConnectorUtils {
	public static IProject createNewBPELProject(Shell shell){
		
		NewBPELProjectWizard bpelProjectWizard = new NewBPELProjectWizard();
		bpelProjectWizard.init(PlatformUI.getWorkbench(),  null);
		bpelProjectWizard.setForcePreviousAndNextButtons(true);
		WizardDialog wizardDialog = new WizardDialog(shell,bpelProjectWizard);
		if (wizardDialog.open()==Window.OK){
			Object projectName = bpelProjectWizard.getDataModel().getProperty(IFacetDataModelProperties.FACET_PROJECT_NAME);
			if (projectName!=null)
				return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName.toString());
			else
				return null;
		}
		return null;
	}
	
	public static List<IProject> getBPELWorkflowProjects(){
		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		return new ArrayList<IProject>(Arrays.asList(projects));
	}
	
	public static File createArchive(File location) throws Exception{
		String path = location.toString();
		List allFilesPresentInFolder = FileManagementUtil.getAllFilesPresentInFolder(new File(path));
		List bpelValidFileList = BpelUtils.getBpelValidFileList(path,(String[]) allFilesPresentInFolder.toArray(new String[allFilesPresentInFolder.size()]));
//		if (!BpelUtils.isProjectContainsBpel(p)){
//			throw new Exception("The selected project does not contain any bpel processes.");
//		}else
			if (bpelValidFileList.size()==0){
				throw new Exception("The selected location "+location.getName()+"("+location.toString()+") does not contain any bpel processes.");
			}
		
		File tempFolder = null;
		try {
			tempFolder = File.createTempFile("temp",".tmp");
			tempFolder.delete();
			tempFolder.mkdir();
			File zipFolder=new File(tempFolder,location.getName());
			File tmpZip=File.createTempFile("temp",".tmp");
			tmpZip.delete();
			tmpZip.deleteOnExit();
			FileManagementUtil.copyDirectory(new File(path), zipFolder, bpelValidFileList);
			FileManagementUtil.removeEmptyDirectories(zipFolder);
			FileManagementUtil.zipFolder(zipFolder.getAbsolutePath(), tmpZip.getAbsolutePath());
			return tmpZip;
		}catch (Exception e) {
			throw e;
		}

	}
}
