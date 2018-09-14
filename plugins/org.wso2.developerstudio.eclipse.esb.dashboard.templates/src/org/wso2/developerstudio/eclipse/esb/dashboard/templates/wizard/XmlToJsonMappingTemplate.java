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
import org.wso2.developerstudio.eclipse.general.project.artifact.GeneralProjectArtifact;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * The class handles XML to JSON mapping template which includes data mapper.
 */
public class XmlToJsonMappingTemplate extends Wizard implements INewWizard {

    String sampleName = "XmlToJsonMappingTemplate";
    String baseId = "wso2.sample" + sampleName + ".";
    String name = "XML to JSON Mapping";
    private TemplateProjectWizardPage page;
    private ISelection selection;
    private TemplateWizardUtil templateWizardUtil;
    private String groupId;

    public XmlToJsonMappingTemplate() {
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
            groupId = baseId + containerName;

            //ESB Solution Project Creation
            IProject esbSolutionProject = ProjectCreationUtil
                    .createProject(containerName, TemplateProjectConstants.ESB_PROJECT_NATURE);

            File pomfile = esbSolutionProject.getFile("pom.xml").getLocation().toFile();
            ProjectCreationUtil.createProjectPOM(groupId, pomfile, containerName, "pom");

            templateWizardUtil.addNature(esbSolutionProject, TemplateProjectConstants.ESB_PROJECT_NATURE);

            MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                    new String[] { TemplateProjectConstants.ESB_PROJECT_NATURE });

            ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
            IFile artifactXML = esbSolutionProject.getFile("artifact.xml");
            esbProjectArtifact.setSource(artifactXML.getLocation().toFile());
            copyFiles(esbSolutionProject, esbProjectArtifact);
            esbProjectArtifact.toFile();

            esbSolutionProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            // Registry Resource Project Creation
            IProject registryProject = ProjectCreationUtil.createProject(containerName + "RegistryResource", null);
            JavaUtils.addJavaNature(registryProject, false);

            File refgistryProjectPOM = registryProject.getFile("pom.xml").getLocation().toFile();
            ProjectCreationUtil
                    .createProjectPOM(groupId, refgistryProjectPOM, containerName + "RegistryResource", "pom");

            File registryProjectPOMFile = registryProject.getFile("pom.xml").getLocation().toFile();

            ProjectUtils.addNatureToProject(registryProject, false, TemplateProjectConstants.GENERAL_PROJECT_NATURE);
            MavenUtils.updateWithMavenEclipsePlugin(registryProjectPOMFile,
                    new String[] { TemplateProjectConstants.JDT_BUILD_COMMAND }, new String[] {
                            TemplateProjectConstants.GENERAL_PROJECT_NATURE, TemplateProjectConstants.JDT_PROJECT_NATURE
                    });

            GeneralProjectArtifact registryArtifact = new GeneralProjectArtifact();
            IFile registryArtifactFile = registryProject.getFile("artifact.xml");
            registryArtifact.setSource(registryArtifactFile.getLocation().toFile());
            registryArtifact.toFile();
            //Refresh the project to show the changes. But still won't see the newly created project.
            registryProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            copyRegistryFiles(registryProject, registryArtifact, groupId);

            // Carbon Application Project Creation
            IProject cappProject = ProjectCreationUtil
                    .carbonAppCreation(containerName + "CarbonApplication", containerName, groupId, sampleName);
            addCappDependencies(cappProject);

            // Open synapse application on sample creation.
            String openFileName = "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                    + "proxy-services" + File.separator + "EngineerEmployeeService.xml";
            IFile fileDesc = esbSolutionProject.getFile(openFileName);
            Shell shell = getShell();
            ProjectCreationUtil.openEditor(shell, fileDesc, TemplateProjectConstants.SYNAPSE_CONFIG_EDITOR_ID,
                    TemplateProjectConstants.JSON_TO_XML_MAPPING_TEMPLATE_HELP_CONTEXT);

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
     * Copy Registry Resource Files for Data Mapper.
     *
     * @throws Exception
     */
    private void copyRegistryFiles(IProject registryProject, GeneralProjectArtifact registryArtifact, String groupID)
            throws Exception {

        String configName = "EmployeeToEngineerMappingConfig";
        RegistryProjectCreationUtil
                .copyArtifact(registryProject, sampleName + "RegistryResource", configName, registryArtifact, groupID);

        RegistryProjectCreationUtil.updateRegistryResourcePOM(registryProject);
    }

    /**
     * Copy the files which belongs to the sample.
     *
     * @param esbProject
     * @param esbProjectArtifact
     */
    private void copyFiles(IProject esbProject, ESBProjectArtifact esbProjectArtifact) {

        String artifactName = "EngineerEmployeeService";
        String type = "proxy-services";
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

        Dependency dependency = ProjectCreationUtil
                .addDependencyForCAPP(groupId, "EngineerEmployeeService", "proxy-service");
        dependencyList.add(dependency);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency), "capp/EnterpriseServiceBus");

        String[] fileTypes = { "_inputSchema", "_outputSchema", "" };
        String[] registryFiles = { "EmployeeToEngineerMappingConfig" };

        for (String registryFile : registryFiles) {
            for (String fileType : fileTypes) {
                Dependency dependency2 = ProjectCreationUtil
                        .addDependencyForCAPP(groupId, registryFile + fileType, "resource");
                dependencyList.add(dependency2);
                properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency2), "capp/EnterpriseServiceBus");
            }
        }

        ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
        properties.put("artifact.types", artifactTypeMapping.getArtifactTypes());
        mavenProject.getModel().setProperties(properties);
        MavenUtils.addMavenDependency(mavenProject, dependencyList);
        MavenUtils.saveMavenProject(mavenProject, pomfile);
        CarbonAppProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
    }

}
