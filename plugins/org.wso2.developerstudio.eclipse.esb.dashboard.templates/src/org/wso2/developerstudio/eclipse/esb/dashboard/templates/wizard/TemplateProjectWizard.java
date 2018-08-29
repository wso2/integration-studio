//Liscense

package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBArtifact;
import org.wso2.developerstudio.eclipse.esb.project.artifact.ESBProjectArtifact;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;
import org.wso2.developerstudio.eclipse.utils.template.TemplateUtil;

public class TemplateProjectWizard extends Wizard implements INewWizard {

    private TemplateProjectWizardPage page;
    private ISelection selection;
    private TemplateWizardUtil templateWizardUtil;
    private File pomfile;
    private String groupId;
    private String version = "1.0.0";
    ESBProjectArtifact esbProjectArtifact;
    String name = "HelloWorld";

    public TemplateProjectWizard() {
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
     * This method is called when 'Finish' button is pressed in the wizard. We
     * will create an operation and run it using wizard as execution context.
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

    private void copyFiles(IProject esbProject) {

        IContainer location = esbProject.getFolder(
                "src" + File.separator + "main" + File.separator + "synapse-config" + File.separator
                        + "proxy-services");
        try {
            File importFile = getSampleResourceFile();
            String sampleFileName = name + ".xml";
            File sampleFile = new File(sampleFileName);
            IFile proxyServiceFile = location.getFile(new Path(sampleFile.getName()));
            File destFile = proxyServiceFile.getLocation().toFile();
            FileUtils.copy(importFile, destFile);
            String grpID = groupId + ".proxy-service";
            String relativePath = FileUtils.getRelativePath(location.getProject().getLocation().toFile(),
                    new File(location.getLocation().toFile(), sampleFileName))
                    .replaceAll(Pattern.quote(File.separator), "/");
            esbProjectArtifact.addESBArtifact(createArtifact(sampleFileName, grpID, version, relativePath));
            esbProjectArtifact.toFile();
            esbProject.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
        } catch (Exception e) {
            // TODO Auto-generated catch block
        }
    }

    protected File getSampleResourceFile() throws IOException {
        return ProxyServiceTemplateUtils.getInstance().getResourceFile("Samples/HelloWorld/HelloWorld.xml");
    }

    private ESBArtifact createArtifact(String name, String groupId, String version, String path) {
        ESBArtifact artifact = new ESBArtifact();
        artifact.setName(name);
        artifact.setVersion(version);
        artifact.setType("synapse/proxy-service");
        artifact.setServerRole("EnterpriseServiceBus");
        artifact.setGroupId(groupId);
        artifact.setFile(path);
        return artifact;
    }

    /**
     * The worker method. It will find the container, create the file if missing
     * or just replace its contents, and open the editor on the newly created
     * file.
     */
    private void doFinish(String containerName, IProgressMonitor monitor) throws CoreException {
        IProject project = createProject(containerName, TemplateProjectConstants.ESB_PROJECT_NATURE);
        pomfile = project.getFile("pom.xml").getLocation().toFile();
        try {
            createPOM(pomfile, containerName);
            templateWizardUtil.addNature(project, TemplateProjectConstants.ESB_PROJECT_NATURE);
            esbProjectArtifact = new ESBProjectArtifact();
            IFile file = project.getFile("artifact.xml");
            esbProjectArtifact.setSource(file.getLocation().toFile());
            esbProjectArtifact.toFile();
            copyFiles(project);
        } catch (Exception ex) {
            templateWizardUtil.throwCoreException("Error creating pom file for project " + containerName, ex);
        }
    }

    /**
     * Create the pom file for the template project.
     *
     * @param pomLocation
     * @param projectName
     * @throws Exception
     */
    public void createPOM(File pomLocation, String projectName) throws Exception {
        groupId = "wso2.template." + projectName;
        MavenProject mavenProject = MavenUtils.createMavenProject(groupId, projectName, version, "pom");
        MavenUtils.saveMavenProject(mavenProject, pomLocation);
    }

    public IProject createProject(String containerName, String natureID) throws CoreException {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(containerName);
        if (project.exists()) {
            templateWizardUtil
                    .throwCoreException(TemplateProjectConstants.THE_PROJECT_EXISTS_IN_THE_WORKSPACE_MESSAGE, null);
        } else {
            project.create(null);
            project.open(null);
        }

        IResource resource = root.findMember(new Path(containerName));
        if (!resource.exists() || !(resource instanceof IContainer)) {
            templateWizardUtil.throwCoreException("Container \"" + containerName + "\" does not exist.", null);
        }

        return project;
    }

    /**
     * Will accept the selection in the workbench to see if we can initialize
     * from it.
     *
     * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
     */
    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
        setHelpAvailable(true);
    }
}

class ProxyServiceTemplateUtils extends TemplateUtil {

    private static TemplateUtil instance;

    public static TemplateUtil getInstance() {
        if (instance == null) {
            instance = new ProxyServiceTemplateUtils();
        }
        return instance;
    }

    protected Bundle getBundle() {
        return Platform.getBundle(org.wso2.developerstudio.eclipse.esb.dashboard.templates.Activator.PLUGIN_ID);
    }
}
