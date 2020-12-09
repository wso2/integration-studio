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

package org.wso2.wsf.ide.bpel.export.ui;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.wsf.ide.bpel.export.utils.BpelUtils;
import org.wso2.wsf.ide.bpel.export.utils.FileManagementUtil;

public class BpelExportWizard extends Wizard implements IExportWizard{
	private BpelExportWizardPage mainPage;
	private IStructuredSelection selection;
	
	public boolean performFinish() {
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(monitor);
				} catch (Exception e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			realException.printStackTrace();
			if (realException.getMessage().trim().equalsIgnoreCase(""))
				MessageDialog.openError(getShell(), "Error", "Error occured while deploying the data service");
			else
				MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		MessageDialog.openInformation(getShell(), "BPEL Process", "BPEL archive deployed successfully.");
		
		return true;	
	}

	public void init(IWorkbench arg0, IStructuredSelection arg1) {
		this.selection=arg1;
	}
	public void addPages() {
		super .addPages();
		IProject p = null;
		if (selection.getFirstElement() instanceof IProject){
			p=(IProject)selection.getFirstElement();
		}
		mainPage = new BpelExportWizardPage("BPEL Export",p);
		addPage(mainPage);
	}
	private void doFinish(IProgressMonitor monitor) throws Exception {
		int a;
		a=10;
		IProject[] projectList = mainPage.getProjects();
		for(int i=0; i< projectList.length; i++){
			if(mainPage.getProjectToArchive().equals(projectList[i].getName())){
			IProject p = projectList[i];
			monitor.beginTask("Determining whether the selected is a bpel project...", 100);
			List bpelValidFileList = null;
			String path = p.getLocation().toOSString();
			monitor.worked(10);
			monitor.setTaskName("Listing project artifacts...");
			List allFilesPresentInFolder = FileManagementUtil.getAllFilesPresentInFolder(new File(path));
			monitor.worked(25);
			monitor.setTaskName("Filtering out non BPEL artifacts...");
			bpelValidFileList = BpelUtils.getBpelValidFileList(path,(String[]) allFilesPresentInFolder.toArray(new String[allFilesPresentInFolder.size()]));
				if (!BpelUtils.isProjectContainsBpel(p)) {
					throw new Exception(
							"The selected project does not contain any BPEL processes.");
				} else if (!BpelUtils.isProjectContainsDeploymentDescriptor(p)) {
					throw new Exception(
							"The selected project does not contain a deployment descriptor for the Bpel process");
				} else if (bpelValidFileList.size() == 0) {
					throw new Exception(
							"The selected project does not contain any BPEL processes.");
				}

			monitor.worked(40);
			File tempFolder = null;
			try {
				tempFolder = File.createTempFile("temp",".tmp");
				tempFolder.delete();
				tempFolder.mkdir();
				File zipFolder=new File(tempFolder,p.getName());
				File tmpZip=File.createTempFile("temp",".tmp");
				tmpZip.delete();
				tmpZip.deleteOnExit();
				monitor.setTaskName("Creating the bpel artifact...");
				FileManagementUtil.copyDirectory(new File(path), zipFolder, bpelValidFileList);
				monitor.worked(55);
				FileManagementUtil.removeEmptyDirectories(zipFolder);
				monitor.worked(60);
				FileManagementUtil.zipFolder(zipFolder.getAbsolutePath(), tmpZip.getAbsolutePath());
				monitor.worked(75);
				if (tmpZip.exists()){
					monitor.setTaskName("Exporting the artifact...");
					String deployableZip = (new Path(mainPage.getFileLocation())).append(p.getName()+".zip").toOSString(); //FileManagementUtil.addNodesToPath(PersistentWSASEmitterContext.getInstance().getWSASRuntimeLocation(),new String[]{"repository", "bpel",p.getName()+".zip"});
					File deployedZip = new File(deployableZip);
					FileManagementUtil.copy(tmpZip, deployedZip);
					monitor.worked(100);
					monitor.done();
					if (deployedZip.exists()){
						return;
					}else{
						throw new Exception("Could not copy the BPEL archive file to the given location.");
					}
				}else
					throw new Exception("Unable to create the BPEL archive file.");
			} catch (IOException e) {
				throw new Exception("Unable to create the BPEL archive file.");
			}finally{
				FileManagementUtil.deleteDirectories(tempFolder);
				
			}
		}
	}
	}
	

}
                