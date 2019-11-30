/*
 * Copyright (c) 2019 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software He   
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.wso2.developerstudio.eclipse.esb.docker.wizard;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.eclipse.esb.docker.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.editor.DockerGenerationWizardPage;
import org.wso2.developerstudio.eclipse.docker.distribution.ui.wizard.DockerProjectCreationWizard;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

public class GenerateDockerImageWizard extends Wizard implements IExportWizard {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String WINDOW_TITLE = "Generate Docker Image Wizard";
    private static final String POM_FILE = "pom.xml";
    private boolean initError = false;
    private IStructuredSelection selection;
    private DockerGenerationWizardPage dockerGenerationPage;

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);
        this.selection = selection;

        dockerGenerationPage = new DockerGenerationWizardPage(workbench, selection);
    }

    @Override
    public boolean performFinish() {
        if (dockerGenerationPage.isCreateNewProjectChecked()) {
            PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
                public void run() {
                    try {
                        DockerProjectCreationWizard dockerProject = new DockerProjectCreationWizard(true);
                        dockerProject.init(PlatformUI.getWorkbench(), selection);
                        WizardDialog exportWizardDialog = new WizardDialog(
                                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), dockerProject);
                        exportWizardDialog.open();
                    } catch (Exception e) {
                        log.error("Error while getting project for create new Docker exporter project", e);
                    }
                }
            });
        } else if (dockerGenerationPage.isQuickRunDockerChecked()) {
            PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
                public void run() {
                    try {
                        ExportAndGenerateDockerImageWizard wizard = new ExportAndGenerateDockerImageWizard();
                        wizard.init(PlatformUI.getWorkbench(), selection);
                        WizardDialog exportWizardDialog = new WizardDialog(
                                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), wizard);
                        exportWizardDialog.setPageSize(665, 450);
                        exportWizardDialog.open();
                    } catch (Exception e) {
                        log.error("Error while getting project for create new Docker exporter project", e);
                    }
                }
            });
        } else if (dockerGenerationPage.isUseExistingProjectChecked()) {
            try {
                IWorkspaceRoot wroot = ResourcesPlugin.getWorkspace().getRoot();
                IWorkspace workspace = ResourcesPlugin.getWorkspace();
                IResource resource = wroot
                        .findMember(new Path(File.separator + dockerGenerationPage.getSelectedDockerProjectPath()));
                File pomFile = new File(resource.getLocation().toOSString() + File.separator + POM_FILE);
                IPath pomLocation = Path.fromOSString(pomFile.getAbsolutePath());
                IFile pomIfile = workspace.getRoot().getFileForLocation(pomLocation);
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                
                // Adding selected composite project if the project creation is based on composite right click
                MavenProject mavenProject = MavenUtils.getMavenProject(pomFile);
                IFile compositePomFile = getSelectedProject(selection).getFile(POM_FILE);
                MavenProject parentPrj = MavenUtils.getMavenProject(compositePomFile.getLocation().toFile());
                List<Dependency> dependencies = new ArrayList<>();
                dependencies.add(MavenUtils.createDependency(parentPrj.getGroupId(), parentPrj.getArtifactId(),
                        parentPrj.getVersion(), null, "car"));
                MavenUtils.addMavenDependency(mavenProject, dependencies);
                MavenUtils.saveMavenProject(mavenProject, pomFile);
                pomIfile.getProject().refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
                
                IDE.openEditor(page, pomIfile,
                        "org.wso2.developerstudio.eclipse.docker.distribution.editor.DistProjectEditor", true);
            } catch (Exception e) {
                log.error("Error while opening the Docker project with the editor", e);
            }
        }
        return true;
    }

    public void addPages() {
        if (!initError) {
            addPage(dockerGenerationPage);
            super.addPages();
        }
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
}
