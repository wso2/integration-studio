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

package org.wso2.developerstudio.eclipse.carbonserver44microei12.launch;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.platform.core.utils.Constants;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.register.product.servers.MicroIntegratorInstance;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.util.CarbonServer44eiUtils;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.wizard.CompositeApplicationArtifactUpdateWizard;

/**
 * This class performs launching of the Micro Integrator launch
 * configuration.
 * <p>
 * A launch configuration delegate is defined by the delegate attribute of a
 * launchConfigurationType extension.
 * 
 * <pre>
 * {@code <extension
 *        point="org.eclipse.debug.core.launchConfigurationTypes">
 *     <launchConfigurationType
 *           delegate="org.wso2.developerstudio.eclipse.carbonserver44microei12.launch.MicroIntegratorRunLaunchDelegate"
 *           id="org.wso2.developerstudio.eclipse.carbonserver44microei12.launch"
 *           modes="run"
 *           name="Micro Integrator Runtime">
 *     </launchConfigurationType>
 *  </extension>}
 * </pre>
 *
 */
public class MicroIntegratorRunLaunchDelegate implements ILaunchConfigurationDelegate {

    /**
     * Launches the Micro Integrator configuration in the run mode,
     * contributing run targets and/or processes to the given launch object.
     * <p>
     * The launch object has already been registered with the launch manager.
     * 
     * @throws CoreException
     *             if launching fails
     * @see ILaunchConfiguration
     * @see ILaunch
     */

    private IWorkbenchWindow activeWorkBenchWindow;
    private int statusCode = Window.CANCEL;

    @Override
    public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch,
            final IProgressMonitor monitor) throws CoreException {

        // Get the active workbench window using an UI thread
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                activeWorkBenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            }
        });

        IWorkbenchPage activePage = activeWorkBenchWindow.getActivePage();
        IWorkbenchPart viewpart = activePage.findView("org.eclipse.ui.navigator.ProjectExplorer");
        IStructuredSelection selection = (IStructuredSelection) viewpart.getSite().getSelectionProvider()
                .getSelection();
        if (selection.isEmpty()) {
        	popUpErrorDialogAndLogException("Please select a project to run with embedded Micro Integrator");
        	return;
        }
        IProject selectedProject = (IProject) ((IResource) selection.getFirstElement()).getProject();
        String currentProjectName = selectedProject.getName();
        // Get the associated carbon application for the selected project from the
        // project explorer
        IResource selectedCARAppResource = selectedProject.getParent()
                .findMember(currentProjectName + "CompositeApplication");
        
        //check selected project is created from new Integration Wizard
        if (selectedCARAppResource == null) {
            selectedCARAppResource = selectedProject.getParent()
                    .findMember(currentProjectName.split("Configs")[0] + "CompositeExporter");
        }
        
        //check selected project is created from new Integration Wizard
        if (selectedCARAppResource == null) {
            selectedCARAppResource = selectedProject.getParent()
                    .findMember(currentProjectName.split("DataServiceConfigs")[0] + "CompositeExporter");
        }
        
        boolean isCompositeSelectionPageNeeded = false;
        if (selectedCARAppResource == null && currentProjectName != null
                && !currentProjectName.contains("CompositeApplication") && !currentProjectName.contains("CompositeExporter")
                        && !selectedProject.hasNature(Constants.DISTRIBUTION_PROJECT_NATURE)) {
            isCompositeSelectionPageNeeded = true;
        }

        // Create the wizard for creating CAPP with the user selected artifacts
        CompositeApplicationArtifactUpdateWizard wizard = new CompositeApplicationArtifactUpdateWizard(
                isCompositeSelectionPageNeeded);

        if (currentProjectName != null && (currentProjectName.contains("CompositeApplication") 
                || currentProjectName.contains("CompositeExporter")
                || selectedProject.hasNature(Constants.DISTRIBUTION_PROJECT_NATURE))) {
            // Initialize the CAPP creation wizard using the user selection as it is a
            // carbon application
            wizard.init(null, selection);
        } else if (selectedCARAppResource != null) {
            // Initializing the CAPP creating wizard using the associated CAPP for the user
            // selected project
            wizard.init(null, selectedCARAppResource);
        } else {
            //Open CompositeProjectSelectionPage in CompositeApplicationArtifactUpdateWizard
            //to select or create a composite application project
            wizard.init();
        }

        final WizardDialog exportWizardDialog = new WizardDialog(activeWorkBenchWindow.getShell(), wizard);

        // Open Carbon Application wizard from an UI thread
        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                statusCode = exportWizardDialog.open();
            }
        });

        if (statusCode == Window.OK) {
            // If the debugger running mode is set to internal ESB runtime, start the
            // micro-integrator set the mediation debug mode in micro-integrator instance
            MicroIntegratorInstance microIntegratorInstance = MicroIntegratorInstance.getInstance();
            microIntegratorInstance.setDebugMode(false);
            if (CarbonServer44eiUtils.hasEmbeddedConfigsChanged() || !microIntegratorInstance.isServerStarted()
                    || !CarbonServer44eiUtils.isHotDeploymentEnabled(microIntegratorInstance)) {
                microIntegratorInstance.restart();
            } else {
                new Thread(new Runnable() {
                    public void run() {
                        CarbonServer44eiUtils.updateDeployedServices();
                    }
                }).start();
            }
        }

    }

    /**
     * This method will handle an error occurred in the application. The thrown
     * exception will be logged using {@link IDeveloperStudioLog} and also pop
     * up an error Dialog of {@link ErrorDialog} mentioning the given message
     * and occurred exception.
     * 
     * @param ex
     * @param message
     * @see ErrorDialog
     * @see IStatus
     */
    public static void popUpErrorDialogAndLogException(final String message) {
        final IStatus editorStatus = new Status(IStatus.ERROR, Activator.PLUGIN_ID, message);
        Display.getDefault().syncExec(new Runnable() {
            @Override
            public void run() {
                ErrorDialog.openError(Display.getDefault().getActiveShell(), "Error selecting project", message,
                        editorStatus);

            }
        });
    }
}
