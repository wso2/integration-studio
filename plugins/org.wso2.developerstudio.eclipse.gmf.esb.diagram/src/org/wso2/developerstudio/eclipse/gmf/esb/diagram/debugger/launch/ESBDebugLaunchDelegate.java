/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.DEFAULT_COMMAND_PORT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.DEFAULT_EVENT_PORT;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.DEFAULT_HOST_NAME;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.DEBUG_PROFILE_INTERNAL_RUNNING_MODE;

import java.io.IOException;
import java.net.UnknownHostException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44microei.register.product.servers.MicroIntegratorInstance;
import org.wso2.developerstudio.eclipse.carbonserver44microei.wizard.CompositeApplicationArtifactUpdateWizard;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.impl.ESBDebugger;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.DebuggerStartedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model.ESBDebugTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This class performs launching of the ESB Mediation Debugger launch
 * configuration.
 * <p>
 * A launch configuration delegate is defined by the delegate attribute of a
 * launchConfigurationType extension.
 * 
 * <pre>
 * {@code  <extension
 *          point="org.eclipse.debug.core.launchConfigurationTypes">
 *       <launchConfigurationType
 *             delegate=
"org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch.ESBDebugLaunchDelegate"
 *             id=
"org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch"
 *             modes="debug"
 *             name="ESB Mediation Debugger">
 *       </launchConfigurationType>
 *    </extension>}
 * </pre>
 *
 */
public class ESBDebugLaunchDelegate implements ILaunchConfigurationDelegate {

    /**
     * Launches the ESB Mediation Debugger configuration in the debug mode,
     * contributing debug targets and/or processes to the given launch object.
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
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    @Override
    public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch,
            final IProgressMonitor monitor) throws CoreException {

        int commandPort = 0;
        int eventPort = 0;
        String hostName = DEFAULT_HOST_NAME;
        // Use the default debugging mode as Internal micro-integrator based debugger
        String debugMode = DEBUG_PROFILE_INTERNAL_RUNNING_MODE;

        try {
            commandPort = Integer.parseInt(
                    configuration.getAttribute(Messages.DebuggerConfigTab_CommandPortLabel, DEFAULT_COMMAND_PORT));
            eventPort = Integer.parseInt(
                    configuration.getAttribute(Messages.DebuggerConfigTab_EventPortLabel, DEFAULT_EVENT_PORT));
            hostName = configuration.getAttribute(Messages.DebuggerConfigTab_ServerHostName, hostName);
            debugMode = configuration.getAttribute(Messages.DebuggerConfigTab_DebuggerMode,
                    DEBUG_PROFILE_INTERNAL_RUNNING_MODE);

            if (DEBUG_PROFILE_INTERNAL_RUNNING_MODE.equals(debugMode)) {
                // This if block will handle the micro-integrator based integrated internal
                // debug mode

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
                String currentProjectName = ((IProject) ((IResource) selection.getFirstElement()).getProject())
                        .getName();
                // Get the associated carbon application for the selected project from the
                // project explorer
                IResource selectedCARAppResource = ((IResource) selection.getFirstElement()).getProject().getParent()
                        .findMember(currentProjectName + "CarbonApplication");

                // Create the wizard for creating CAPP with the user selected artifacts
                CompositeApplicationArtifactUpdateWizard wizard = new CompositeApplicationArtifactUpdateWizard();

                if (currentProjectName != null && currentProjectName.contains("CarbonApplication")) {
                    // Initialize the CAPP creation wizard using the user selection as it is a
                    // carbon application
                    wizard.init(null, selection);
                } else if (selectedCARAppResource != null) {
                    // Initializing the CAPP creating wizard using the associated CAPP for the user
                    // selected project
                    wizard.init(null, selectedCARAppResource);
                } else {
                    // Throw an error if debug launcher cannot find a carbon application for the
                    // user selected name from the project explorer
                    throw new Exception("Cannot find the carbon application for the name : " + currentProjectName);
                }

                WizardDialog exportWizardDialog = new WizardDialog(activeWorkBenchWindow.getShell(), wizard);

                // Open Carbon Application wizard from an UI thread
                Display.getDefault().syncExec(new Runnable() {
                    public void run() {
                        statusCode = exportWizardDialog.open();
                    }
                });

                if (statusCode == Window.OK) {
                    // If the debugger running mode is set to internal ESB runtime, start the
                    // micro-integrator set the mediation debug mode in micro-integrator instance
                    MicroIntegratorInstance.getInstance().setDebugMode(true);
                    MicroIntegratorInstance.getInstance().restart();

                    ESBDebugger esbDebugger = new ESBDebugger(commandPort, eventPort, hostName);
                    ESBDebugTarget debugTarget = new ESBDebugTarget(launch);
                    launch.addDebugTarget(debugTarget);
                    esbDebugger.fireEvent(new DebuggerStartedEvent());

                    // Reset the status code of Carbon Application update dialog box status
                    statusCode = Window.CANCEL;

                    // Reset the micro integrator debug mode to false
                    MicroIntegratorInstance.getInstance().setDebugMode(false);
                }
            } else {
                // This block is for the standard remote mediation debugger
                ESBDebugger esbDebugger = new ESBDebugger(commandPort, eventPort, hostName);
                ESBDebugTarget debugTarget = new ESBDebugTarget(launch);
                launch.addDebugTarget(debugTarget);
                esbDebugger.fireEvent(new DebuggerStartedEvent());

            }

        } catch (UnknownHostException e) {
            ESBDebuggerUtil.popUpErrorDialogAndLogException(e,
                    Messages.ESBDebugLaunchDelegate_HostIPAddressCouldNotFoundErrorDialogMessage);
        } catch (IllegalArgumentException e) {
            ESBDebuggerUtil.popUpErrorDialogAndLogException(e,
                    Messages.ESBDebugLaunchDelegate_LauncherArgumentInvalidErrorDialogMessage);
        } catch (IOException e) {
            ESBDebuggerUtil.popUpErrorDialogAndLogException(e,
                    Messages.ESBDebugLaunchDelegate_DebuggerInterfaceSocketsCreationErrorDialogMessage);
        } catch (InterruptedException e) {
            ESBDebuggerUtil.popUpErrorDialogAndLogException(e, "Exception occured while running the debugger");
        } catch (Exception e) {
            ESBDebuggerUtil.popUpErrorDialogAndLogException(e,
                    "Please select a Carbon Application form the project " + "explorer");
        }

    }

}
