//Liscense

package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;

public class Template2ProjectWizard extends Wizard implements INewWizard {

    private TemplateProjectWizardPage page;
    private ISelection selection;
    private TemplateWizardUtil templateWizardUtil;
    private String groupId;

    String sampleName = "Proxying_A_SOAP_API";
    String baseId = "wso2.sample" + sampleName + ".";

    public Template2ProjectWizard() {
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
        page = new TemplateProjectWizardPage(selection);
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
     * Copy each files which belongs to the samples.
     *
     * @param esbProject
     * @param esbProjectArtifact
     */
    private void copyFiles(IProject esbProject, ESBProjectArtifact esbProjectArtifact) {

        // Copy  Proxy Files
        String proxyName = "Sample2";
        ProjectCreationUtil
                .copyArtifact(esbProject, groupId, sampleName, proxyName, esbProjectArtifact, "proxy-services");

        String apiName = "API1";
        ProjectCreationUtil.copyArtifact(esbProject, groupId, sampleName, apiName, esbProjectArtifact, "api");

    }

    private void addCappDependencies(IProject CarbonAppProject) throws Exception {

        File pomfile = CarbonAppProject.getFile("pom.xml").getLocation().toFile();

        List<Dependency> dependencyList = new ArrayList<Dependency>();
        MavenProject mavenProject = MavenUtils.getMavenProject(pomfile);
        Properties properties = mavenProject.getModel().getProperties();

        Dependency dependency = ProjectCreationUtil.addDependencyForCAPP(groupId, "Sample2", "proxy-service");
        dependencyList.add(dependency);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency), "capp/EnterpriseServiceBus");

        Dependency dependency2 = ProjectCreationUtil.addDependencyForCAPP(groupId, "API1", "api");
        dependencyList.add(dependency2);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency2), "capp/EnterpriseServiceBus");

        Dependency dependency3 = ProjectCreationUtil.addDependencyForCAPP(groupId, "salesforce-connector", "lib");
        dependencyList.add(dependency3);
        properties.put(ProjectCreationUtil.getArtifactInfoAsString(dependency3), "capp/EnterpriseServiceBus");

        ArtifactTypeMapping artifactTypeMapping = new ArtifactTypeMapping();
        properties.put("artifact.types", artifactTypeMapping.getArtifactTypes());
        mavenProject.getModel().setProperties(properties);
        MavenUtils.addMavenDependency(mavenProject, dependencyList);
        MavenUtils.saveMavenProject(mavenProject, pomfile);
        CarbonAppProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

    }

    /**
     * The worker method. It will find the container, create the file if missing or
     * just replace its contents, and open the editor on the newly created file.
     */
    private void doFinish(String containerName, IProgressMonitor monitor) throws CoreException {

        try {

            IProject project = ProjectCreationUtil
                    .createProject(containerName, TemplateProjectConstants.ESB_PROJECT_NATURE);

            File pomfile = project.getFile("pom.xml").getLocation().toFile();

            groupId = baseId + containerName;

            ProjectCreationUtil.createProjectPOM(groupId, pomfile, containerName, "pom");

            templateWizardUtil.addNature(project, TemplateProjectConstants.ESB_PROJECT_NATURE);

            MavenUtils.updateWithMavenEclipsePlugin(pomfile, new String[] {},
                    new String[] { TemplateProjectConstants.ESB_PROJECT_NATURE });

            // add connector.
            String connectorName = "salesforce-connector";
            String connectorVersion = "2.0.2";
            ProjectCreationUtil.addConnectorToWorkSpace(connectorName + "-" + connectorVersion);
            IProject connectorProject = ProjectCreationUtil.createConnectorExporterProject(groupId, containerName);
            ProjectCreationUtil.addConnectorToProject(connectorProject, connectorName, connectorVersion, groupId); 
            
           connectorName = "fileconnector-connector";
            connectorVersion = "2.0.10";
            ProjectCreationUtil.addConnectorToWorkSpace(connectorName + "-" + connectorVersion);
           // IProject connectorProject = ProjectCreationUtil.createConnectorExporterProject(groupId, containerName);
            ProjectCreationUtil.addConnectorToProject(connectorProject, connectorName, connectorVersion, groupId); 
            
            
            connectorProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            
            ESBProjectArtifact esbProjectArtifact = new ESBProjectArtifact();
            IFile artifactXML = project.getFile("artifact.xml");
            esbProjectArtifact.setSource(artifactXML.getLocation().toFile());
            esbProjectArtifact.toFile();

            copyFiles(project, esbProjectArtifact);

            esbProjectArtifact.toFile();

            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

            IProject cappProject = ProjectCreationUtil
                    .carbonAppCreation(containerName + "CarbonApplication", containerName, groupId, sampleName);

            addCappDependencies(cappProject);

        } catch (Exception ex) {
            templateWizardUtil.throwCoreException("Error creating pom file for project " + containerName, ex);
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

}
