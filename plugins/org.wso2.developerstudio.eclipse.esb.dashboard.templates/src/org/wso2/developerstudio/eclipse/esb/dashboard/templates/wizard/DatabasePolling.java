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
package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import org.apache.maven.model.Dependency;
import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The class handles Database Polling Template Sample.
 */
public class DatabasePolling extends Wizard implements INewWizard {

    String sampleName = "DatabasePolling";
    String baseId = "wso2.sample" + sampleName + ".";
    String name = "Database Polling";
    private TemplateProjectWizardPage page;
    private ISelection selection;
    private TemplateWizardUtil templateWizardUtil;
    private String groupId;

    public DatabasePolling() {
        super();
        setNeedsProgressMonitor(true);
        templateWizardUtil = new TemplateWizardUtil();
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
            //ESB Project
            IProject project = ProjectCreationUtil
                    .createProject(containerName, TemplateProjectConstants.ESB_PROJECT_NATURE);

            File pomfile = project.getFile("pom.xml").getLocation().toFile();
            groupId = baseId + containerName;
            ProjectCreationUtil.createProjectPOM(groupId, pomfile, containerName, "pom");

            templateWizardUtil.addNature(project, TemplateProjectConstants.ESB_PROJECT_NATURE);

            MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                    new String[] { TemplateProjectConstants.ESB_PROJECT_NATURE });

            ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
            IFile artifactXML = project.getFile("artifact.xml");
            esbProjectArtifact.setSource(artifactXML.getLocation().toFile());
            copyFiles(project, esbProjectArtifact);
            esbProjectArtifact.toFile();

            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

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

            ESBProjectArtifact dssProjectArtifact = new ESBProjectArtifact();
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
            String openFileName =
                    "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator + "tasks"
                            + File.separator + "DoctorsRecordsSyncTask.xml";
            IFile fileDesc = project.getFile(openFileName);
            Shell shell = getShell();
            URL url = ProjectCreationUtil.copyReadMe( project , sampleName );            
            ProjectCreationUtil.openEditor(shell, fileDesc, TemplateProjectConstants.SYNAPSE_CONFIG_EDITOR_ID, url);

        } catch (CoreException ex) {
            templateWizardUtil
                    .throwCoreException(TemplateProjectConstants.THE_PROJECT_EXISTS_IN_THE_WORKSPACE_MESSAGE, null);
        } catch (Exception ex) {
            templateWizardUtil.throwCoreException("Error creating sample project " + containerName, ex);
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
    private void copyDSSFiles(IProject dssProject, ESBProjectArtifact dssProjectArtifact, String groupID) {

        String artifactName = "DoctorsDataService";
        DSSProjectCreationUtil
                .copyArtifact(dssProject, sampleName + "DataService", artifactName, dssProjectArtifact, groupID);

    }

    /**
     * Copy the files which belongs to the samples.
     *
     * @param esbProject
     * @param esbProjectArtifact
     */
    private void copyFiles(IProject esbProject, ESBProjectArtifact esbProjectArtifact) {

        String artifactName = "DoctorsRecordsSyncTask";
        String type = "tasks";
        ProjectCreationUtil.copyArtifact(esbProject, groupId, sampleName, artifactName, esbProjectArtifact, type);

        artifactName = "DoctorsRecordsSyncSeq";
        type = "sequences";
        ProjectCreationUtil.copyArtifact(esbProject, groupId, sampleName, artifactName, esbProjectArtifact, type);

        artifactName = "DoctorsDataServiceEP";
        type = "endpoints";
        ProjectCreationUtil.copyArtifact(esbProject, groupId, sampleName, artifactName, esbProjectArtifact, type);

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

        Dependency dependency = ProjectCreationUtil.addDependencyForCAPP(groupId, "DoctorsRecordsSyncTask", "task");
        dependencyList.add(dependency);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency), "capp/EnterpriseServiceBus");

        Dependency dependency2 = ProjectCreationUtil.addDependencyForCAPP(groupId, "DoctorsRecordsSyncSeq", "sequence");
        dependencyList.add(dependency2);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency2), "capp/EnterpriseServiceBus");

        Dependency dependency3 = ProjectCreationUtil.addDependencyForCAPP(groupId, "DoctorsDataServiceEP", "endpoint");
        dependencyList.add(dependency3);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency3), "capp/EnterpriseServiceBus");

        Dependency dependency4 = ProjectCreationUtil.addDependencyForCAPP(groupId, "DoctorsDataService", null);
        dependencyList.add(dependency4);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency4), "capp/DataServicesServer");

        ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
        properties.put("artifact.types", artifactTypeMapping.getArtifactTypes());
        mavenProject.getModel().setProperties(properties);
        MavenUtils.addMavenDependency(mavenProject, dependencyList);
        MavenUtils.saveMavenProject(mavenProject, pomfile);
        CarbonAppProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
    }

}
