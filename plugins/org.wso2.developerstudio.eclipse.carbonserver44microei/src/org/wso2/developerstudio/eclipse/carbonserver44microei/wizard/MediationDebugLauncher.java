/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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
package org.wso2.developerstudio.eclipse.carbonserver44microei.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.wso2.developerstudio.eclipse.carbonserver44microei.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This class will launch the ESB mediation debugger
 */
public class MediationDebugLauncher extends Thread {

	private static final String DEBUG_PROFILE_NAME = "Microei_Debug_Profile";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public void run() {
		try {
			// Get the internal debug launcher from the launch manager
			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
			// Get the ESB Debug profile from the launch manager
			ILaunchConfiguration debugESBLauchConfig = findLaunchConfigurationByName(launchManager, DEBUG_PROFILE_NAME);
			if (debugESBLauchConfig != null) {
				// Launch the debug mode
				debugESBLauchConfig.launch("debug", new NullProgressMonitor());
			}
			else {
				log.error("Unable to find the ESB mediation debugger profile :" + DEBUG_PROFILE_NAME);
			}
		} catch (Exception e) {
			log.error("Exception occured while trying to launch the debug mode", e);
		}
	}

	private ILaunchConfiguration findLaunchConfigurationByName(ILaunchManager launchManager, String configName)
			throws CoreException {
		ILaunchConfiguration[] availableLauchConfigs = launchManager.getLaunchConfigurations();
		for (ILaunchConfiguration iLaunchConfig : availableLauchConfigs) {
			if (configName.equals(iLaunchConfig.getName())) {
				return iLaunchConfig;
			}
		}
		return null;
	}
}
