package org.wso2.developerstudio.eclipse.carbonserver.remote.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.ServerUtil;

public class CarbonRemoteServerLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
	                                                                                                             throws CoreException {
		// well nothing to do there
		IServer server = ServerUtil.getServer(configuration);
		if (server != null) {
			RemoteCarbonServerBehavior carbonServer =
			                                          (RemoteCarbonServerBehavior) server.loadAdapter(RemoteCarbonServerBehavior.class,
			                                                                                          null);
			carbonServer.startPingThread();
		}
	}

}
