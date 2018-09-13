/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.artifact.dataserviceTemplate.wizard;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The class Student Data Service Sample.
 */
public class StudentDataServiceTemplate extends Wizard implements INewWizard {

    String sampleName = "Student";
    String baseId = "wso2.sample" + sampleName + ".";
    String name = "Students Data Service";
    private TemplateProjectWizardPage page;
    private ISelection selection;
    private String groupId;

    public StudentDataServiceTemplate() {
        super();
        setNeedsProgressMonitor(true);
        setWindowTitle(TemplateProjectConstants.PROJECT_WIZARD_TITLE);
    }

    /**
     * Adding the page to the wizard.
     */
    @Override
    public void addPages() {
        page = new TemplateProjectWizardPage(selection, name);
        addPage(page);
    }

    /**
     * This method is called when 'Finish' button is pressed in the wizard. We will
     * create an operation and run it using wizard as execution context.
     */
    @Override
    public boolean performFinish() {

        final String containerName = page.getContainerName();

        IRunnableWithProgress op = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(containerName, monitor);
                } catch (CoreException e) {
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
            MessageDialog.openError(getShell(), TemplateProjectConstants.ERROR_MESSAGE, realException.getMessage());
            return false;
        }
        return true;
    }

    /**
     * The worker method. It will find the container, create the file if missing or
     * just replace its contents, and open the editor on the newly created file.
     */
    private void doFinish(String containerName, IProgressMonitor monitor) throws CoreException {

        try {

            groupId = baseId + containerName;

            //DSS Project Creation
            IProject dssServiceProject = ProjectCreationUtil
                    .createProject(containerName + "DataServiceProject", TemplateProjectConstants.DS_PROJECT_NATURE);

            IFolder dsfolder = ProjectUtils
                    .getWorkspaceFolder(dssServiceProject, TemplateProjectConstants.DS_PROJECT_DATASERVICE_FOLDER);

            if (!dsfolder.exists()) {
                ProjectUtils.createFolder(dsfolder);
            }

            File dssServicePomFile = dssServiceProject.getFile("pom.xml").getLocation().toFile();
            ProjectCreationUtil
                    .createProjectPOM(groupId, dssServicePomFile, containerName + "DataServiceProject", "pom");
            DSSProjectCreationUtil.updatePom(dssServicePomFile, dssServiceProject);
            ProjectUtils.addNatureToProject(dssServiceProject, false, TemplateProjectConstants.DS_PROJECT_NATURE);
            MavenUtils.updateWithMavenEclipsePlugin(dssServicePomFile, new String[] {},
                    new String[] { TemplateProjectConstants.DS_PROJECT_NATURE });

            DSSProjectArtifact dssProjectArtifact = new DSSProjectArtifact();
            IFile dssArtifactfile = dssServiceProject.getFile("artifact.xml");
            dssProjectArtifact.setSource(dssArtifactfile.getLocation().toFile());
            dssProjectArtifact.toFile();

            copyDSSFiles(dssServiceProject, dssProjectArtifact, groupId);
            dssServiceProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            // Carbon Application Project
            IProject cappProject = ProjectCreationUtil
                    .carbonAppCreation(containerName + "CarbonApplication", containerName, groupId, sampleName);
            addCappDependencies(cappProject);

            // Open synapse application on sample creation.
            String openFileName = "dataservice" + File.separator + "StudentDataService.dbs";
            IFile fileDesc = dssServiceProject.getFile(openFileName);
            Shell shell = getShell();
            ProjectCreationUtil.openEditor(shell, fileDesc, TemplateProjectConstants.DS_EDITOR_ID);

        } catch (CoreException ex) {
            IStatus status = new Status(IStatus.ERROR, TemplateProjectConstants.PLUGIN_ID, IStatus.OK,
                    TemplateProjectConstants.THE_PROJECT_EXISTS_IN_THE_WORKSPACE_MESSAGE, ex);
            throw new CoreException(status);
        } catch (Exception ex) {
            IStatus status = new Status(IStatus.ERROR, TemplateProjectConstants.PLUGIN_ID, IStatus.OK,
                    "Error creating sample project " + containerName, ex);
            throw new CoreException(status);

        }
    }

    /**
     * Will accept the selection in the workbench to see if we can initialize from
     * it.
     *
     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
     */
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
        setHelpAvailable(true);
    }

    /**
     * Copy the files related to DSS Project
     *
     * @param dssProject
     * @param dssProjectArtifact
     * @param groupID
     */
    private void copyDSSFiles(IProject dssProject, DSSProjectArtifact dssProjectArtifact, String groupID) {

        String artifactName = "StudentDataService";
        DSSProjectCreationUtil
                .copyArtifact(dssProject, sampleName + "DataService", artifactName, dssProjectArtifact, groupID);

    }

    /**
     * Add the dependencies for the carbon application of the {@link #sampleName} sample.
     *
     * @param CarbonAppProject
     * @throws Exception
     */
    private void addCappDependencies(IProject CarbonAppProject) throws Exception {

        File pomfile = CarbonAppProject.getFile("pom.xml").getLocation().toFile();

        List<Dependency> dependencyList = new ArrayList<Dependency>();
        MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
        Properties properties = mavenProject.getModel().getProperties();

        Dependency dependency = ProjectCreationUtil.addDependencyForCAPP(groupId, "StudentDataService", null);
        dependencyList.add(dependency);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency), "capp/DataServicesServer");

        ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
        properties.put("artifact.types", artifactTypeMapping.getArtifactTypes());
        mavenProject.getModel().setProperties(properties);
        MavenUtils.addMavenDependency(mavenProject, dependencyList);
        MavenUtils.saveMavenProject(mavenProject, pomfile);
        CarbonAppProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
    }

}
