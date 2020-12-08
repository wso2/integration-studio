/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.maven.multi.module.add.other.projects;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.maven.multi.module.Activator;
import org.wso2.developerstudio.eclipse.maven.multi.module.handlers.MavenMultiModuleProjectImageUtils;
import org.wso2.developerstudio.eclipse.distribution.project.util.MavenMultiModuleImportUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;

public class MMMProjectSelectionWizard extends AbstractWSO2ProjectCreationWizard {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private MMMProjectSelectionWizardPage selectionPage;
    private IProject selectedNonMMMProject;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle("Import to Maven Multi Module Project");
        setDefaultPageImageDescriptor(MavenMultiModuleProjectImageUtils.getInstance().getImageDescriptor("mmm-import.png"));
        selectionPage = new MMMProjectSelectionWizardPage();

        try {
            selectedNonMMMProject = getSelectedProject(selection);
        } catch (Exception e) {
            log.error("Error reading project", e);
        }

    }

    /**
     * Adding wizard pages
     */
    public void addPages() {
        addPage(selectionPage);
    }

    public boolean performFinish() {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        String mavenProjectName = selectionPage.getSelectedProjectName();
        String workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toOSString();
        if (selectedNonMMMProject != null && selectedNonMMMProject.getLocation() != null) {
            File oldImportingProject = new File(selectedNonMMMProject.getLocation().toOSString());
            IProject mavenMultiModuleProject = root.getProject(mavenProjectName);
            File mavenProject = new File(mavenMultiModuleProject.getLocation().toOSString());
            String tmpMavenDir = workspace + File.separator + ".tmp" + File.separator + mavenMultiModuleProject.getName();
            String tmpNewSubDir = tmpMavenDir + File.separator + selectedNonMMMProject.getName();
            File importingMavenProject = new File(tmpMavenDir);
            File importingSubProject = new File(tmpNewSubDir);

            // copy selected importing project to .tmp location and delete project from workspace
            try {

                FileUtils.copyDirectory(mavenProject, importingMavenProject);
                FileUtils.copyDirectory(oldImportingProject, importingSubProject);
                mavenMultiModuleProject.delete(true, true, new NullProgressMonitor());
                ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
                selectedNonMMMProject.delete(true, true, new NullProgressMonitor());
                ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

                if (MavenMultiModuleImportUtils.importMavenMultiModuleProjectToWorkspace(importingMavenProject)) {
                    // delete project in .tmp due to import is success
                    FileUtils.deleteDirectory(importingMavenProject);
                    MavenMultiModuleImportUtils.addModuleToParentPOM(root.getProject(mavenProjectName));
                } else {
                    showErrorMessage("Error occured while importing " + selectedNonMMMProject.getName() + "project to "
                                    + mavenProjectName
                                    + " maven multi module project. Backup project is saved in ${workspace}/.tmp/"
                                    + mavenProjectName + " directory", "Import Error");
                }
                ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            } catch (Exception e) {
                log.error("Error while importing selected project", e);
            }
        }
        return true;
    }

    @Override
    public IResource getCreatedResource() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Method for getting current project from IStructuredSelection.
     * 
     * @param obj
     *            IStructuredSelection as an object
     * @return IProject
     */
    public static IProject getSelectedProject(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }

        if (obj instanceof IResource) {
            return ((IResource) obj).getProject();
        } else if (obj instanceof IStructuredSelection) {
            return getSelectedProject(((IStructuredSelection) obj).getFirstElement());
        }

        return null;
    }

    /**
     * Show success message pop up
     * 
     * @param message
     * @param title
     */
    private void showErrorMessage(final String message, final String title) {
        Display.getDefault().asyncExec(new Runnable() {
            public void run() {
                Display display = PlatformUI.getWorkbench().getDisplay();
                Shell shell = display.getActiveShell();

                MessageBox exportMsg = new MessageBox(shell, SWT.ICON_ERROR);
                exportMsg.setText(title);
                exportMsg.setMessage(message);

                exportMsg.open();
            }
        });
    }
}
