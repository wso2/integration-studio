package org.wso2.developerstudio.eclipse.carbonserver44microei11.debug;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.wso2.developerstudio.eclipse.carbonserver44microei11.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44microei11.handlers.PlatformEarlyStartUpHandler;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class DebugShortcut implements ILaunchShortcut {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    @Override
    public void launch(ISelection selection, String mode) {

        try {
            ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
            // Get the ESB Debug profile from the launch manager
            ILaunchConfiguration debugESBLauchConfig = PlatformEarlyStartUpHandler
                    .findLaunchConfigurationByName(launchManager, PlatformEarlyStartUpHandler.DEBUG_PROFILE_NAME);
            // Launch the debug mode
            debugESBLauchConfig.launch("debug", new NullProgressMonitor());
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
                    .findLaunchConfigurationByName(launchManager, PlatformEarlyStartUpHandler.DEBUG_PROFILE_NAME);
            // Launch the debug mode
            debugESBLauchConfig.launch("debug", new NullProgressMonitor());
        } catch (Exception e) {
            log.error("Error occured while restarting the micro-integrator", e);
        }
    }

}