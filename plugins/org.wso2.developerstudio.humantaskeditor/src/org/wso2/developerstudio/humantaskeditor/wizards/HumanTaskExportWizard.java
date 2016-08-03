/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.humantaskeditor.wizards;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.humantaskeditor.HumantaskEditorConstants;

public class HumanTaskExportWizard extends Wizard implements IExportWizard {
    private HumanTaskExportWizardPage mainPage;
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
            if (realException.getMessage().trim().equalsIgnoreCase(""))
                MessageDialog.openError(getShell(), "Error", "Error occured while deploying the data service");
            else
                MessageDialog.openError(getShell(), "Error", realException.getMessage());
            return false;
        }
        MessageDialog
                .openInformation(getShell(), "Human Task Distribution", "Human task archive exported successfully");

        return true;
    }

    public void init(IWorkbench arg0, IStructuredSelection arg1) {
        this.selection = arg1;
        setWindowTitle(HumantaskEditorConstants.HUMAN_TASK_EXPORT_WIZARD_TITLE);
        setHelpAvailable(false);
    }

    public void addPages() {
        super.addPages();
        IProject p = null;
        if (selection.getFirstElement() instanceof IProject) {
            p = (IProject) selection.getFirstElement();
        }
        mainPage = new HumanTaskExportWizardPage("BPEL Export", p);
        addPage(mainPage);
    }

    private void doFinish(IProgressMonitor monitor) throws Exception {
        IProject[] projectList = mainPage.getProjects();
        for (IProject aProjectList : projectList) {
            if (mainPage.getProjectToArchive().equals(aProjectList.getName())) {
                String path = aProjectList.getLocation().toOSString();
                File tempFolder = null;
                try {
                    tempFolder = File.createTempFile("temp", ".tmp");
                    boolean tmpDeleted = tempFolder.delete();
                    boolean tmpCreated = tempFolder.mkdir();
                    if (!tmpDeleted) {
                        MessageDialog.openError(getShell(), "Error",
                                HumantaskEditorConstants.ERROR_DELETING_TMP_FOLDER_MESSAGE);
                    }
                    if (!tmpCreated) {
                        MessageDialog.openError(getShell(), "Error",
                                HumantaskEditorConstants.ERROR_CREATING_TMP_FOLDER_MESSAGE);
                    }
                    File zipFolder = new File(tempFolder, aProjectList.getName());
                    File tmpZip = File.createTempFile("temp", ".tmp");
                    boolean tmpZipDeleted = tmpZip.delete();
                    tmpZip.deleteOnExit();
                    if (!tmpZipDeleted) {
                        MessageDialog.openError(getShell(), "Error",
                                HumantaskEditorConstants.ERROR_DELETING_TMP_FOLDER_MESSAGE);
                    }
                    monitor.setTaskName("Creating the human task artifact...");
                    FileUtils.copyDirectory(
                            new File(path + File.separator + HumantaskEditorConstants.BASE_FOLDER_NAME), zipFolder);
                    FileManagementUtil.removeEmptyDirectories(zipFolder);
                    FileManagementUtil.zipFolder(zipFolder.getAbsolutePath(), tmpZip.getAbsolutePath());
                    if (tmpZip.exists()) {
                        String deployableZip = (new Path(mainPage.getFileLocation())).append(
                                aProjectList.getName() + ".zip").toOSString(); // FileManagementUtil.addNodesToPath(PersistentWSASEmitterContext.getInstance().getWSASRuntimeLocation(),new
                        // String[]{"repository", "bpel",p.getName()+".zip"});
                        File deployedZip = new File(deployableZip);
                        FileUtils.copyFile(tmpZip, deployedZip);
                        monitor.done();
                        if (deployedZip.exists()) {
                            return;
                        } else {
                            throw new Exception("Could not copy the human task archive file to the given location.");
                        }
                    } else
                        throw new Exception("Unable to create the human task archive file.");
                } finally {
                    if (tempFolder != null) {
                        if (tempFolder.delete()) {
                            MessageDialog.openError(getShell(), "Error",
                                    HumantaskEditorConstants.ERROR_DELETING_TMP_FOLDER_MESSAGE);
                        }
                    }
                }
            }
        }
    }

}