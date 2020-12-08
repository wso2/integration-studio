/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 *      http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.eclipse.carbonserver44microei12.debug;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.handlers.PlatformEarlyStartUpHandler;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.util.ServerConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class RunShortcut implements ILaunchShortcut {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    @Override
    public void launch(ISelection selection, String mode) {

        try {
            ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
            // Get the ESB Debug profile from the launch manager
            ILaunchConfiguration debugESBLauchConfig = PlatformEarlyStartUpHandler
                    .findLaunchConfigurationByName(launchManager, PlatformEarlyStartUpHandler.RUN_PROFILE_NAME);
            // Launch the debug mode
            debugESBLauchConfig.launch(ServerConstants.RUN, new NullProgressMonitor());
        } catch (Exception e) {
            log.error("Error occured while restarting the micro-integrator", e);
        }
    }

    @Override
    public void launch(IEditorPart editor, String mode) {
        try {
            ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
            // Get the ESB Debug profile from the launch manager
            ILaunchConfiguration debugESBLauchConfig = PlatformEarlyStartUpHandler
                    .findLaunchConfigurationByName(launchManager, PlatformEarlyStartUpHandler.RUN_PROFILE_NAME);
            // Launch the run mode
            debugESBLauchConfig.launch(ServerConstants.RUN, new NullProgressMonitor());
        } catch (Exception e) {
            log.error("Error occured while restarting the micro-integrator", e);
        }
    }
}