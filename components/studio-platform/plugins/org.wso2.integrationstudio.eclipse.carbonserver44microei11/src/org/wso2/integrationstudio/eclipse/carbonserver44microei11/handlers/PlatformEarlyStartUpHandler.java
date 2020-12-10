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

package org.wso2.integrationstudio.eclipse.carbonserver44microei11.handlers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.ui.IStartup;

/**
 * This is the early startup handler of the Integration Studio platform, all
 * methods that needs to run at eclipse startup should be implemented here and
 * called in early startup.
 *
 */
public class PlatformEarlyStartUpHandler implements IStartup {

	public static final String DEBUG_PROFILE_NAME = "Microei_Debug_Profile";
	public static final String RUN_PROFILE_NAME = "Microei_Run_Profile";

	@Override
	public void earlyStartup() {
		
    }

	public static ILaunchConfiguration findLaunchConfigurationByName(ILaunchManager launchManager, String configName)
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
