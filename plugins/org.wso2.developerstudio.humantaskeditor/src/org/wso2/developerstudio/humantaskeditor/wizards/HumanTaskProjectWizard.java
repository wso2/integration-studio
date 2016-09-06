/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.humantaskeditor.wizards;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.wso2.developerstudio.humantaskeditor.Activator;
import org.wso2.developerstudio.humantaskeditor.HumantaskEditorConstants;

public class HumanTaskProjectWizard extends Wizard implements INewWizard {

    private HumanTaskProjectWizardPage page;

    private ISelection selection;

    private HumanTaskWizardUtil humanTaskWizardUtil;

    private static final Logger logger = Logger.getLogger(Activator.PLUGIN_ID);

    /**
     * Constructor for HumanTaskWizard.
     */
    public HumanTaskProjectWizard() {
        super();
        setNeedsProgressMonitor(true);
        humanTaskWizardUtil = new HumanTaskWizardUtil();
        setWindowTitle(HumantaskEditorConstants.HUMAN_TASK_PROJECT_WIZARD_TITLE);
    }

    /**
     * Adding the page to the wizard.
     */
    @Override
    public void addPages() {
        page = new HumanTaskProjectWizardPage(selection);
        addPage(page);
    }

    /**
     * This method is called when 'Finish' button is pressed in the wizard. We
     * will create an operation and run it using wizard as execution context.
     */
    @Override
    public boolean performFinish() {
        final String containerName = page.getContainerName();
        final String fileName = page.getFileName() + "." + HumantaskEditorConstants.HT_EXTENSION;
        final String taskName = page.getTaskName();
        final String tnsName = page.getTNSName();

        IRunnableWithProgress op = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(containerName, fileName, taskName, tnsName, monitor);
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
            MessageDialog.openError(getShell(), HumantaskEditorConstants.ERROR_MESSAGE, realException.getMessage());
            return false;
        }
        return true;
    }

    /**
     * The worker method. It will find the container, create the file if missing
     * or just replace its contents, and open the editor on the newly created
     * file.
     */
    private void doFinish(String containerName, String fileName, String taskName, String tnsName,
            IProgressMonitor monitor) throws CoreException {
        monitor.beginTask("Creating " + fileName, 2);
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(containerName);
        if (project.exists()) {
            humanTaskWizardUtil.throwCoreException(
                    HumantaskEditorConstants.THE_PROJECT_EXISTS_IN_THE_WORKSPACE_MESSAGE, null);
        } else {
            project.create(null);
            project.open(null);
        }

        IResource resource = root.findMember(new Path(containerName));
        if (!resource.exists() || !(resource instanceof IContainer)) {
            humanTaskWizardUtil.throwCoreException("Container \"" + containerName + "\" does not exist.", null);
        }
        IContainer container = (IContainer) resource;
        final IFolder folder = container.getFolder(new Path(HumantaskEditorConstants.BASE_FOLDER_NAME));
        folder.create(true, true, monitor);
        final IFile file = container.getFile(new Path(HumantaskEditorConstants.BASE_FOLDER_NAME + File.separator
                + fileName));
        final IFile wsdlfile = container.getFile(new Path(HumantaskEditorConstants.BASE_FOLDER_NAME + File.separator
                + taskName + HumantaskEditorConstants.TASK_WSDL_SUFFIX));
        final IFile cbwsdlfile = container.getFile(new Path(HumantaskEditorConstants.BASE_FOLDER_NAME + File.separator
                + taskName + HumantaskEditorConstants.CALLBACK_TASK_WSDL_SUFFIX));
        final IFile orgSchemafile = container.getFile(new Path(HumantaskEditorConstants.BASE_FOLDER_NAME
                + File.separator + HumantaskEditorConstants.ORGANIZATIONAL_ENTITY_SCHEMA_FILE));
        final IFile htconfigfile = container.getFile(new Path(HumantaskEditorConstants.BASE_FOLDER_NAME
                + File.separator + HumantaskEditorConstants.INITIAL_HTCONFIG_NAME));
        final IFile pomfile = container.getFile(new Path(HumantaskEditorConstants.INITIAL_POM_NAME));
        HumanTaskWizardUtil.addNature(file.getProject());
        InputStream stream = null;
        InputStream wsdlStream = null;
        InputStream htconfigStream = null;
        InputStream orgSchemaStream = null;
        InputStream pomStream = null;
        try {
            stream = humanTaskWizardUtil.openContentStream(taskName, tnsName);
            wsdlStream = humanTaskWizardUtil.openWSDLStream();
            htconfigStream = humanTaskWizardUtil.openHTConfigStream();
            orgSchemaStream = humanTaskWizardUtil.openOrgSchemaStream();
            pomStream = humanTaskWizardUtil.openPomStream(containerName);
            if (file.exists()) {
                file.setContents(stream, true, true, monitor);
            } else {
                file.create(stream, true, monitor);
                wsdlfile.create(wsdlStream, true, monitor);
                cbwsdlfile.create(wsdlStream, true, monitor);
                htconfigfile.create(htconfigStream, true, monitor);
                orgSchemafile.create(orgSchemaStream, true, monitor);
                pomfile.create(pomStream, true, monitor);
            }
        } catch (IOException e) {
            logger.log(Level.FINE, HumantaskEditorConstants.ERROR_CREATING_INITIAL_FILE_MESSAGE, e);
            IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
            ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                    HumantaskEditorConstants.ERROR_MESSAGE,
                    HumantaskEditorConstants.ERROR_CREATING_INITIAL_FILE_MESSAGE, editorStatus);
        } finally {
            try {
                if (stream != null)
                    stream.close();
                if (wsdlStream != null)
                    wsdlStream.close();
                if (htconfigStream != null)
                    htconfigStream.close();
                if (orgSchemaStream != null)
                    orgSchemaStream.close();
                if (pomStream != null)
                    pomStream.close();
            } catch (IOException e) {
                logger.log(Level.FINE, HumantaskEditorConstants.ERROR_CREATING_INITIAL_FILE_MESSAGE, e);
                IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
                ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                        HumantaskEditorConstants.ERROR_MESSAGE,
                        HumantaskEditorConstants.ERROR_CREATING_INITIAL_FILE_MESSAGE, editorStatus);
            }
        }
        monitor.worked(1);
        monitor.setTaskName(HumantaskEditorConstants.OPENING_FILE_FOR_EDITING_MESSAGE);
        getShell().getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                try {
                    IDE.openEditor(page, file, true);
                } catch (PartInitException e) {
                    logger.log(Level.FINE, HumantaskEditorConstants.ERROR_OPENING_THE_EDITOR_MESSAGE, e);
                    IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage());
                    ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
                            HumantaskEditorConstants.ERROR_MESSAGE,
                            HumantaskEditorConstants.ERROR_OPENING_THE_EDITOR_MESSAGE, editorStatus);
                }
            }
        });
        monitor.worked(1);
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
