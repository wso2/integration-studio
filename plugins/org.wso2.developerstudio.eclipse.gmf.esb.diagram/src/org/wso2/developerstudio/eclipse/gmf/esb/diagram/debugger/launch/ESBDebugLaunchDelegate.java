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
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.DEFAULT_HOST_NAME;

import java.io.IOException;
import java.net.UnknownHostException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.impl.ESBDebugger;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.events.DebuggerStartedEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.model.ESBDebugTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerUtil;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;

/**
 * This class performs launching of the ESB Mediation Debugger launch
 * configuration.
 * <p>
 * A launch configuration delegate is defined by the delegate attribute of a launchConfigurationType extension.
 * 
 * <pre>
 * {@code  <extension
 *          point="org.eclipse.debug.core.launchConfigurationTypes">
 *       <launchConfigurationType
 *             delegate="org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch.ESBDebugLaunchDelegate"
 *             id="org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch"
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
    @Override
    public void launch(final ILaunchConfiguration configuration, final String mode, final ILaunch launch,
            final IProgressMonitor monitor) throws CoreException {

        int commandPort = 0;
        int eventPort = 0;
        String hostName = DEFAULT_HOST_NAME;

        try {
            commandPort = Integer.parseInt(configuration.getAttribute(Messages.DebuggerConfigTab_CommandPortLabel,
                    DEFAULT_COMMAND_PORT));
            eventPort = Integer.parseInt(configuration.getAttribute(Messages.DebuggerConfigTab_EventPortLabel,
                    DEFAULT_COMMAND_PORT));
            hostName = configuration.getAttribute(Messages.DebuggerConfigTab_ServerHostName, hostName);

            ESBDebugger esbDebugger = new ESBDebugger(commandPort, eventPort, hostName);
            ESBDebugTarget debugTarget = new ESBDebugTarget(launch);

            launch.addDebugTarget(debugTarget);
            esbDebugger.fireEvent(new DebuggerStartedEvent());

        } catch (UnknownHostException e) {
            ESBDebuggerUtil.popUpErrorDialogAndLogException(e,
                    Messages.ESBDebugLaunchDelegate_HostIPAddressCouldNotFoundErrorDialogMessage);
        } catch (IllegalArgumentException e) {
            ESBDebuggerUtil.popUpErrorDialogAndLogException(e,
                    Messages.ESBDebugLaunchDelegate_LauncherArgumentInvalidErrorDialogMessage);
        } catch (IOException e) {
            ESBDebuggerUtil.popUpErrorDialogAndLogException(e,
                    Messages.ESBDebugLaunchDelegate_DebuggerInterfaceSocketsCreationErrorDialogMessage);
        }

    }

}
