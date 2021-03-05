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
package org.wso2.integrationstudio.maven.multi.module.add.other.projects;

import java.io.File;
import java.net.URI;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
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
import org.wso2.integrationstudio.maven.multi.module.Activator;
import org.wso2.integrationstudio.maven.multi.module.handlers.MavenMultiModuleProjectImageUtils;
import org.wso2.integrationstudio.distribution.project.util.MavenMultiModuleImportUtils;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.ui.wizard.AbstractWSO2ProjectCreationWizard;

public class MMMProjectSelectionWizard extends AbstractWSO2ProjectCreationWizard {

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private MMMProjectSelectionWizardPage selectionPage;
    private IProject selectedNonMMMProject;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle("Import into Integration Project");
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
        
        IWorkspace workspaceResource = ResourcesPlugin.getWorkspace();
        IWorkspaceRoot rootResource = workspaceResource.getRoot();
        String workspace = rootResource.getLocation().toOSString();
        String nonMMMProjectName = selectionPage.getSelectedProjectName();
        
        if (selectedNonMMMProject != null && selectedNonMMMProject.getLocation() != null) {
            File nonMMMProjectFile = new File(selectedNonMMMProject.getLocation().toOSString());
            IProject mmmProjectResource = rootResource.getProject(nonMMMProjectName);
            String tempFileLocationForNonMMMProject = workspace + File.separator + ".tmp" + File.separator + selectedNonMMMProject.getName();
            File nonMMMProjectTempFile = new File(tempFileLocationForNonMMMProject);
            File nonMMMProjectNewFile = new File(mmmProjectResource.getLocation().toOSString() + File.separator + selectedNonMMMProject.getName());

            // copy selected importing non MMM project to .tmp location and delete non MMM project from the workspace
            try {
                FileUtils.copyDirectory(nonMMMProjectFile, nonMMMProjectTempFile);
                FileUtils.copyDirectory(nonMMMProjectFile, nonMMMProjectNewFile);
                
                // delete non MMM project from the absolute location
                selectedNonMMMProject.delete(true, true, new NullProgressMonitor());
                ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

                File copyingFileProjectFile = new File(nonMMMProjectNewFile.getAbsolutePath() + File.separator + ".project");
                String projectNature = MavenMultiModuleImportUtils.readProjectNatureFromProjectFile(copyingFileProjectFile);
                IProject copyingNewProject = rootResource.getProject(nonMMMProjectNewFile.getName());
                IProjectDescription newProjectDescription = workspaceResource.newProjectDescription(nonMMMProjectNewFile.getName());
                String[] natureIds = { projectNature };
                newProjectDescription.setNatureIds(natureIds);
                URI mmmProjectURI = nonMMMProjectNewFile.toURI();
                newProjectDescription.setLocationURI(mmmProjectURI);

                copyingNewProject.create(newProjectDescription, new NullProgressMonitor());
                ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
                copyingNewProject.open(IResource.BACKGROUND_REFRESH, new NullProgressMonitor());
                copyingNewProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
                ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
                
                MavenMultiModuleImportUtils.importConnectorsFromConnectorExporterProject(mmmProjectResource);
                MavenMultiModuleImportUtils.addModuleToParentPOM(mmmProjectResource);
                FileUtils.deleteDirectory(nonMMMProjectTempFile);
                ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
            } catch (Exception e) {
                log.error("Error while importing selected project", e);
                showErrorMessage("Error occured while importing " + selectedNonMMMProject.getName() + " project to "
                        + mmmProjectResource.getName()
                        + " maven multi module project. Backup project is saved in "
                        + tempFileLocationForNonMMMProject + " location", "Import Error");
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
