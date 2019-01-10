package org.wso2.developerstudio.eclipse.carbonserver44microei.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.wso2.developerstudio.eclipse.carbonserver44microei.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class MediationDebugLauncher extends Thread {

	private static final String DEBUG_PROFILE_NAME = "INTERNAL_DEBUG_PROFILE";
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	public void run() {
		try {
			// Get the internal debug launcher from the launch manager
			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
			// Get the ESB Debug profile from the launch manager
			ILaunchConfiguration debugESBLauchConfig = findLaunchConfigurationByName(launchManager, DEBUG_PROFILE_NAME);
			// Launch the debug mode
			debugESBLauchConfig.launch("debug", new NullProgressMonitor());
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
