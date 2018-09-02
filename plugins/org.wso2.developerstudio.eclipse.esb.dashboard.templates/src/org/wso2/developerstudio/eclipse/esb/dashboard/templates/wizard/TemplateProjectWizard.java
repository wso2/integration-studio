//Liscense

package org.wso2.developerstudio.eclipse.esb.dashboard.templates.wizard;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.apache.maven.project.MavenProject;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
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
import org.wso2.developerstudio.eclipse.esb.dashboard.templates.util.TemplateProjectWizardModel;
import org.wso2.developerstudio.eclipse.maven.util.MavenUtils;
import org.wso2.developerstudio.eclipse.utils.template.TemplateUtil;

public abstract class TemplateProjectWizard extends Wizard implements INewWizard {

    private TemplateProjectWizardPage page;
    private ISelection selection;
    protected TemplateWizardUtil templateWizardUtil;
    protected String groupId;
    protected String version = "1.0.0";
    TemplateProjectWizardModel projectWizardModel;

    public TemplateProjectWizard() {
        super();
        setNeedsProgressMonitor(true);
        templateWizardUtil = new TemplateWizardUtil();
        projectWizardModel = fillWizardModel();
        setWindowTitle(projectWizardModel.getWindowTitle());        
    }
    
    protected abstract TemplateProjectWizardModel fillWizardModel();

    /**
     * Adding the page to the wizard.
     */
    @Override
    public void addPages() {
        page = new TemplateProjectWizardPage(selection, projectWizardModel.getPageTitle(), 
                projectWizardModel.getPageDescription(), projectWizardModel.getWizardPageText());
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
    
    /**
     * The worker method. It will find the container, create the file if missing
     * or just replace its contents, and open the editor on the newly created
     * file.
     */
    protected abstract void doFinish(String containerName, IProgressMonitor monitor) throws CoreException;


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
