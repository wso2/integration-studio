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

package org.wso2.wsf.ide.bpel.export.popup;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.ObjectPluginAction;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.wsf.ide.bpel.export.WSO2BPELPlugin;
import org.wso2.wsf.ide.bpel.export.utils.BpelUtils;
import org.wso2.wsf.ide.bpel.export.utils.FileManagementUtil;

public class WSO2BpelPopupHandler implements IObjectActionDelegate {
	private static IDeveloperStudioLog log=Logger.getLog(WSO2BPELPlugin.PLUGIN_ID);
	private Shell shell;
	public void setActivePart(IAction arg0, IWorkbenchPart arg1) {
		shell = arg1.getSite().getShell();
	}

	@SuppressWarnings("restriction")
	public void run(IAction arg0) {
		try{
			if (arg0 instanceof ObjectPluginAction){
				ObjectPluginAction obj=(ObjectPluginAction)arg0;
				if (obj.getSelection() instanceof TreeSelection){
					TreeSelection tree=(TreeSelection)obj.getSelection();
					if (tree.getFirstElement() instanceof IProject){
						IProject p=(IProject)tree.getFirstElement();
						if (!BpelUtils.isProjectContainsBpel(p)){
							MessageDialog.openError(shell, "BPEL Process", "The selected project does not contain any BPEL processes.");
							return;
						}
						String path = p.getLocation().toOSString();
						
						List allFilesPresentInFolder = FileManagementUtil.getAllFilesPresentInFolder(new File(path));
						List bpelValidFileList = BpelUtils.getBpelValidFileList(path,(String[]) allFilesPresentInFolder.toArray(new String[allFilesPresentInFolder.size()]));
						try {
							File tempFolder = File.createTempFile("temp",".tmp");
							tempFolder.delete();
							tempFolder.mkdir();
							File zipFolder=new File(tempFolder,p.getName());
							File tmpZip=File.createTempFile("temp",".tmp");
							tmpZip.delete();
							tmpZip.deleteOnExit();
							FileManagementUtil.copyDirectory(new File(path), zipFolder, bpelValidFileList);
							FileManagementUtil.removeEmptyDirectories(zipFolder);
							FileManagementUtil.zipFolder(tempFolder.getAbsolutePath(), tmpZip.getAbsolutePath());
							if (tmpZip.exists()){
//								String deployableZip = FileManagementUtil.addNodesToPath(PersistentWSASEmitterContext.getInstance().getWSASRuntimeLocation(),new String[]{"repository", "bpel",p.getName()+".zip"});
//								File deployedZip = new File(deployableZip);
//								FileManagementUtil.copy(tmpZip, deployedZip);
//								if (deployedZip.exists())
//									MessageDialog.openInformation(shell, "BPEL Process", "Bpel archive deployed successfully.");
//								else
//									MessageDialog.openError(shell, "BPEL Process", "Couldbpel archive file.");	
							}else
								MessageDialog.openError(shell, "BPEL Process", "Unable to create the bpel archive file.");
							FileManagementUtil.deleteDirectories(tempFolder);
						} catch (IOException e) {
							MessageDialog.openError(shell, "BPEL Process", "Unable to create the bpel archive file.");
							log.error(e);
						}
					}
				}
			}
		}catch(Exception ex){
			MessageDialog.openError(shell, "BPEL Process", ex.getLocalizedMessage());
		}
	}

	public void selectionChanged(IAction arg0, ISelection arg1) {
	}

}
