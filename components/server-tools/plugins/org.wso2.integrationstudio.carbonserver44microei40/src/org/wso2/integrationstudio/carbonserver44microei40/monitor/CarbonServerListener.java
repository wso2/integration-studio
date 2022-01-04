/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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

package org.wso2.integrationstudio.carbonserver44microei40.monitor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerListener;
import org.eclipse.wst.server.core.ServerEvent;
import org.wso2.integrationstudio.carbonserver.base.console.CarbonServerConsole;
import org.wso2.integrationstudio.carbonserver.base.interfaces.ICarbonServerMonitor;
import org.wso2.integrationstudio.carbonserver.base.manager.CarbonServerManager;
import org.wso2.integrationstudio.carbonserver44microei40.Activator;
import org.wso2.integrationstudio.carbonserver44microei40.monitoring.dashboard.MonitoringDashboard;
import org.wso2.integrationstudio.carbonserver44microei40.util.CarbonServer44eiUtils;
import org.wso2.integrationstudio.carbonserver44microei40.util.ServerConstants;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

public class CarbonServerListener implements IServerListener {
    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private final List<ICarbonServerMonitor> serverMonitors;

    private CarbonServer44eiUtils carbonServer44eiUtils = new CarbonServer44eiUtils();

    public CarbonServerListener(List<ICarbonServerMonitor> serverMonitors) {
        this.serverMonitors = serverMonitors;
    }

    public void serverChanged(ServerEvent event) {
        // Eclipse 2020-06 sets kind value as 80
    	// PR https://github.com/eclipse/webtools.servertools/commit/e423572dd61784ebe0a051780cb51bf95f11f3b6#diff-9b396db2c848f960e8da8f199bd3165b11ec429b8ad9906f459c5efcf1e31a91R775
    	// if kind =80, our source triggers IServer.STATE_STOPPED case.
    	if (event.getKind() == 80) {
    		return;
    	}

        switch (event.getState()) {
        case IServer.STATE_STARTING:
            triggerStarting(event.getServer());
            break;
        case IServer.STATE_STARTED:
            triggerStarted(event.getServer());
            break;
        case IServer.STATE_STOPPING:
            triggerStopping(event.getServer());
            break;
        case IServer.STATE_STOPPED:
            triggerStopped(event.getServer());
            break;
        }
    }

    private void triggerStarting(IServer server) {
        EmbeddedServerConfigurationUtil.configureEmbeddedServerConfigurations();
        IPath dropins = CarbonServerManager.getServerHome(server).append("dropins");
        for (ICarbonServerMonitor monitor : serverMonitors) {
            try {
                monitor.starting(server);
            } catch (Exception e) {
                log.error(e);
            }
        }
    }

    private void triggerStarted(IServer server) {
        for (ICarbonServerMonitor monitor : serverMonitors) {
            try {
                monitor.started(server);
            } catch (Exception e) {
                log.error(e);
            }
        }
    }

    private void triggerStopping(IServer server) {
        for (ICarbonServerMonitor monitor : serverMonitors) {
            try {
                monitor.stopping(server);
            } catch (Exception e) {
                log.error(e);
            }
        }
        // Displaying message that carbon server is about to shutdown
        CarbonServerConsole console = new CarbonServerConsole();
        console.printMessageInConsole(server.getName(), "Carbon Server " + server.getName() + " is shutting down...\n");
    }

    private void triggerStopped(IServer server) {
        // Displaying message that carbon server is about to shutdown
        CarbonServerConsole console = new CarbonServerConsole();
        console.printMessageInConsole(server.getName(), "Carbon Server " + server.getName() + " has shut down...\n");
        EmbeddedServerConfigurationUtil.revertEmbeddedServerConfigurations();
        for (ICarbonServerMonitor monitor : serverMonitors) {
            try {
                monitor.stopped(server);
            } catch (Exception e) {
                log.error(e);
            }
        }
        // If running, stop MI monitoring dashboard app.
        MonitoringDashboard.getInstance().stopMonitoringDashboard();
        
        // Closing the deployed services view
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                IViewPart view = page.findView(ServerConstants.DEPLOYED_SERVICES_VIEW);
                page.hideView(view);
            }
        });
    }
}
