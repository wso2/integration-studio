/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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

package org.wso2.developerstudio.eclipse.carbonserver44microei.handlers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.ui.IStartup;
import org.wso2.developerstudio.eclipse.carbonserver44microei.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * This is the early startup handler of the developer studio platform, all
 * methods that needs to run at eclipse startup should be implemented here and
 * called in early startup.
 *
 */
public class PlatformEarlyStartUpHandler implements IStartup {

	private static final String DEBUG_PROFILE_NAME = "Microei_Debug_Profile";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	@Override
	public void earlyStartup() {
		// Create ESB mediation debug launch configuration in the EI tooling IDE
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		try {
			createESBDebugProfile(launchManager);
		} catch (CoreException e) {
			log.error("Exception occured while creating micro-integrator debug profile", e);
		}

	}

	private void createESBDebugProfile(ILaunchManager launchManager) throws CoreException {
		if (findLaunchConfigurationByName(launchManager, DEBUG_PROFILE_NAME) == null) {
			ILaunchConfigurationType debugESBLaunchType = launchManager
					.getLaunchConfigurationType("org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.launch");
			ILaunchConfigurationWorkingCopy debugESBLaunchConfig = debugESBLaunchType.newInstance(null,
					DebugPlugin.getDefault().getLaunchManager().generateLaunchConfigurationName(DEBUG_PROFILE_NAME));
			debugESBLaunchConfig.doSave();
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
