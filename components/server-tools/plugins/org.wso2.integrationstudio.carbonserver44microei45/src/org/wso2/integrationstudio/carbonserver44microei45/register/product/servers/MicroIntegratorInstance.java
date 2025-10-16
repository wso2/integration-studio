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

package org.wso2.integrationstudio.carbonserver44microei45.register.product.servers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.launchConfigurations.LaunchHistory;
import org.eclipse.jst.server.generic.core.internal.GenericServer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wst.server.core.IRuntime;
import org.eclipse.wst.server.core.IRuntimeType;
import org.eclipse.wst.server.core.IRuntimeWorkingCopy;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerType;
import org.eclipse.wst.server.core.IServerWorkingCopy;
import org.eclipse.wst.server.core.ServerCore;
import org.wso2.integrationstudio.carbonserver44microei45.Activator;
import org.wso2.integrationstudio.carbonserver44microei45.ServerProperties;
import org.wso2.integrationstudio.carbonserver44microei45.monitor.EmbeddedServerConfigurationUtil;
import org.wso2.integrationstudio.carbonserver44microei45.util.CarbonServer44eiUtils;
import org.wso2.integrationstudio.carbonserver44microei45.util.ServerConstants;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

/**
 * This class contains and manages the micro-integrator
 * instance and registering as a eclipse server
 */
@SuppressWarnings("restriction")
public class MicroIntegratorInstance {

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static MicroIntegratorInstance instance;

    private IServer microIntegratorServer;
    private IServerWorkingCopy server = null;
    private boolean isDebugMode = false;

    /**
     * Private constructor for singleton micro integrator instance
     */
    private MicroIntegratorInstance() {
        setupServer();
    }

    /**
     * Get micro integrator instance
     * 
     * @return MicroIntegratorInstance (IServer is wrapped internally)
     */
    public static MicroIntegratorInstance getInstance() {
        if (instance == null) {
            instance = new MicroIntegratorInstance();
        }
        return instance;
    }

    /**
     * Setup micro-integrator server as a eclipse server runtime
     */
    private void setupServer() {

        IRuntimeType runtimeType450 = ServerCore.findRuntimeType(ServerConstants.WSO2_MI_450_RUNTIME);
        IServerType serverType450 = ServerCore.findServerType(ServerConstants.WSO2_MI_450_SERVER_TYPE);
        boolean isServerExists= false;
        
        // Check already existing servers and runtime of micro-ei
        try {
            IServer[] availableServers = ServerCore.getServers();
            for (IServer tempServers : availableServers) {
                if ((tempServers.getServerType().equals(serverType450) && tempServers.getName()
                        .equals(ServerConstants.MICRO_INTEGRATOR_SERVER + " " + ServerConstants.VERSION))) {
                    server = tempServers.createWorkingCopy();
                    microIntegratorServer = server.saveAll(false, new NullProgressMonitor());
                    isServerExists = true;
                }
            }
        } catch (CoreException e) {
            log.error("Exception occured while trying to delete the old runtime", e);
        }
        
        try {
            if (!isServerExists) {
                NullProgressMonitor progressMonitor = new NullProgressMonitor();

                IRuntimeWorkingCopy runtime = runtimeType450.createRuntime("org.wso2.micro.integrator.runtime45",
                        progressMonitor);
                runtime.setName(ServerConstants.MICRO_INTEGRATOR_RUNTIME + " " + ServerConstants.VERSION);
                runtime.setLocation(new Path(getServerHome()));

                IRuntime microIntegratorRuntime = runtime.save(true, progressMonitor);
                server = serverType450.createServer("org.wso2.micro.integrator.server45", null, microIntegratorRuntime,
                        progressMonitor);
                server.setName(ServerConstants.MICRO_INTEGRATOR_SERVER + " " + ServerConstants.VERSION);
                readConfigs(server);

                microIntegratorServer = server.saveAll(false, progressMonitor);
            }

        } catch (CoreException e) {
            log.error("Error while creating Micro Integrator profile.", e);
        }
    }

    /**
     * Set serverInstanceProperties
     * 
     * @param server server to set properties
     * @throws CoreException on an exception duting setting up
     */
    private void readConfigs(IServerWorkingCopy server) throws CoreException {
        GenericServer microIntegratorGenericServer = (GenericServer) server.loadAdapter(GenericServer.class, null);
        Map<String, String> temserverInstanceProperties = microIntegratorGenericServer.getServerInstanceProperties();
        IRuntime runtime = server.getRuntime();
        String location = runtime.getLocation().toOSString();
        Map<String, String> serverInstanceProperties = new ServerProperties().getServerInstanceProperties(location);
        for (Map.Entry<String, String> entry : serverInstanceProperties.entrySet()) {
            temserverInstanceProperties.put(entry.getKey(), entry.getValue());
        }
        // Once set server instance properties they will be used to override properties defined at server definition xml
        // file
        microIntegratorGenericServer.setServerInstanceProperties(temserverInstanceProperties);
        microIntegratorGenericServer.saveConfiguration(new NullProgressMonitor());
    }

    /**
     * Get absolute path to server home folder
     * 
     * @return return path as a string
     */
    public String getServerHome() {
        String microInteratorPath = null;
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            // check if EI Tooling is in Application folder for MAC
            boolean isRelativeToolingAppExists = false;
            File macOSRelativeToolingApp = null;
            try {
                macOSRelativeToolingApp = new File((new File(".").getCanonicalFile()).getParent().toString() 
                        + File.separator + "Eclipse");
                if (macOSRelativeToolingApp.exists()) {
                    isRelativeToolingAppExists = true;
                }
            } catch (IOException e) {}
            if (isRelativeToolingAppExists && macOSRelativeToolingApp != null) {
                microInteratorPath = macOSRelativeToolingApp.getAbsolutePath() + File.separator + ServerConstants.MICRO_ESB_PATH;
            } else if (new File(ServerConstants.INTEGRATION_STUDIO_HOME_MAC).exists()) {
                microInteratorPath = ServerConstants.INTEGRATION_STUDIO_HOME_MAC + File.separator
                        + ServerConstants.MICRO_ESB_PATH;
            } else {
                java.nio.file.Path path = Paths.get("");
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator
                        + ServerConstants.MICRO_ESB_PATH;
            }

        } else {
            java.nio.file.Path path = Paths.get("");
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator + ServerConstants.MICRO_ESB_PATH;
        }
        return microInteratorPath;
    }

    /**
     * Start the server asynchronously
     * 
     * @throws CoreException on an error during startup
     */
    public void start() throws CoreException {
        EmbeddedServerConfigurationUtil.configureEmbeddedServerConfigurations();
        
        if (microIntegratorServer.getServerState() == IServer.STATE_STOPPED) {
            microIntegratorServer.start(ILaunchManager.RUN_MODE, new NullProgressMonitor());
        } else {
            log.warn("Micro Integrator server is not in stopped mode to start back. Trying force stop.");
            microIntegratorServer.stop(true);
            boolean serverStopped = waitUntilStop();
            if (serverStopped) {
                microIntegratorServer.start(ILaunchManager.RUN_MODE, new NullProgressMonitor());
            } else {
                log.error("Embedded Micro Integrator refused to stop within 20 seconds. " + "Please kill the process");
            }
        }
    }

    /**
     * Stop the server and wait until stop is complete (max 20 seconds)
     * 
     * @return true if the server stopped fine
     */
    public boolean stop() {
        microIntegratorServer.stop(true);
        return waitUntilStop();
    }

    /**
     * Stop the server, what until it get stops and start back. If server failed to stop start
     * will not happen
     * 
     * @throws CoreException
     */
    public void restart() throws CoreException {
        boolean serverStopped = stop();
        if (serverStopped) {
            start();
        } else {
            log.error("Embedded Micro Integrator refused to stop within 20 seconds. " + "Please kill the process");
        }
        clearLauncherHistory();
    }

    /**
     * Wait until server stop is complete. Max time is 41 seconds
     * 
     * @return true if server stopped
     */
    private boolean waitUntilStop() {
        int maxIterations = 20;
        int currentTry = 0;
        boolean serverStopped = false;
        while (currentTry < maxIterations) {
            if (microIntegratorServer.getServerState() != IServer.STATE_STOPPED) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    // ignore
                }
                currentTry = currentTry + 1;
            } else {
                serverStopped = true;
                break;
            }
        }
        return serverStopped;
    }

    /**
     * Get offset of the embedded micro integrator Carbon server (defined at carbon.xml)
     * 
     * @return offset as an integer
     */
    public int getOffset() {
        GenericServer microIntegratorGenericServer = (GenericServer) microIntegratorServer
                .loadAdapter(GenericServer.class, null);
        Map<String, String> serverInstanceProperties = microIntegratorGenericServer.getServerInstanceProperties();
        int offset = Integer.parseInt(serverInstanceProperties.get("carbon.offset"));
        return offset;
    }

    /**
     * This will set the mediation debug parameter to the micro-ei instance
     * 
     * @param setDebug the configuration for the mediation debug server parameter
     */
    public void setDebugMode(boolean setDebug) {
        GenericServer microIntegratorGenericServer = (GenericServer) server.loadAdapter(GenericServer.class, null);
        Map<String, String> temserverInstanceProperties = microIntegratorGenericServer.getServerInstanceProperties();
        temserverInstanceProperties.put(ServerConstants.ESB_DEBUG_ATTRIBUTE, String.valueOf(setDebug));
        microIntegratorGenericServer.setServerInstanceProperties(temserverInstanceProperties);
        try {
            microIntegratorGenericServer.saveConfiguration(new NullProgressMonitor());
            isDebugMode = setDebug;
        } catch (CoreException e) {
            log.error("Unexpected error occured while trying to set mediation debug argument to the "
                    + "micro integrator server instance", e);
        }
    }

    /**
     * This method will return the status of the mediation debug with the current
     * micro-ei instance
     * 
     * @return the mediation debug mode status
     */
    public boolean isDebugMode() {
        return isDebugMode;
    }

    /**
     * This method will delete the launcher history for the micro integrater server
     * 
     */
    private void clearLauncherHistory() {
        new Thread() {
            public void run() {
                boolean isHistoryCleard = false;
                while (!isHistoryCleard) {
                    try {
                        if (microIntegratorServer.getServerState() == IServer.STATE_STARTED) {
                            ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
                            LaunchHistory runHistory = DebugUIPlugin.getDefault().getLaunchConfigurationManager()
                                    .getLaunchHistory("org.eclipse.debug.ui.launchGroup.run");
                            LaunchHistory debugHistory = DebugUIPlugin.getDefault().getLaunchConfigurationManager()
                                    .getLaunchHistory("org.eclipse.debug.ui.launchGroup.debug");
                            ILaunchConfiguration[] launchers = launchManager.getLaunchConfigurations();
                            for (ILaunchConfiguration tmpLauncher : launchers) {
                                if ("Micro Integrator Server 1.2.0".equals(tmpLauncher.getName())) {
                                    runHistory.removeFromHistory(tmpLauncher);
                                    debugHistory.removeFromHistory(tmpLauncher);
                                }
                            }
                            isHistoryCleard = true;
                            try {
                                getDeployedServices();
                            } catch (Exception e) {
                                log.error("Error while rendering deployed services view.", e);
                            }
                        } else {
                            Thread.sleep(1000);
                        }
                    } catch (Exception e) {
                        // ignore
                    }
                }
            }
        }.start();
    }

    /**
     * Renders the deployed services view, which is consisted of the details of endpoints deployed in embedded MI.
     * 
     * @throws IOException
     */
    private void getDeployedServices() throws IOException {
        Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
                try {
                    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                    IViewPart view = page.findView(ServerConstants.DEPLOYED_SERVICES_VIEW);
                    page.hideView(view);
                    page.showView(ServerConstants.DEPLOYED_SERVICES_VIEW);

                } catch (PartInitException e) {
                    log.error("Error while initializing deployed services view.", e);
                }
            }
        });
    }

    /**
     * This method return the server state
     */
    public int getServerState() {
        return microIntegratorServer.getServerState();
    }

    public boolean isServerStarted() {
        return (microIntegratorServer.getServerState() == 2) ? true : false;
    }

    public boolean isHotDeploymentEnabled() {
        CarbonServer44eiUtils carbonServer44eiUtils = new CarbonServer44eiUtils();
        String hotDeploymentEnabled = carbonServer44eiUtils.resolveProperties(microIntegratorServer,
                ServerConstants.PROP_HOT_DEPLOYMENT);
        if ("false".equals(hotDeploymentEnabled)) {
            return false;
        }
        return true;
    }
}
