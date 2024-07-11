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

package org.wso2.integrationstudio.carbonserver44microei43.monitoring.dashboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.wso2.integrationstudio.carbonserver44microei43.Activator;
import org.wso2.integrationstudio.carbonserver44microei43.monitor.EmbeddedServerConfigurationUtil;
import org.wso2.integrationstudio.carbonserver44microei43.monitoring.dashboard.util.MonitoringDashboardConstants;
import org.wso2.integrationstudio.carbonserver44microei43.monitoring.dashboard.util.MonitoringDashboardUtil;
import org.wso2.integrationstudio.carbonserver44microei43.util.ServerConstants;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;

public class MonitoringDashboard {

    private static IIntegrationStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private static MonitoringDashboard monitoringDashboard;
    private static Object lock = new Object();

    private String serverHost;
    private int serverPort;
    private boolean dashboardStarted;

    private MonitoringDashboard() {
    }

    /**
     * Provides MonitoringDashboard instance.
     *
     * @return MonitoringDashboard instance
     */
    public static MonitoringDashboard getInstance() {
        if (monitoringDashboard == null) {
            synchronized (lock) {
                if (monitoringDashboard == null) {
                    monitoringDashboard = new MonitoringDashboard();
                }
            }
        }
        return monitoringDashboard;
    }

    /**
     * Get the url of the MI dashboard and start the server if not already running.
     *
     * @return url of the MI dashboard
     * @throws IOException errors starting the dashboard
     */
    public String getUrl() throws IOException {
        startMonitoringDashboard();
        return MonitoringDashboardConstants.HTTP + serverHost + MonitoringDashboardConstants.COLON + serverPort
                + MonitoringDashboardConstants.MI_DASHBOARD_CONTEXT_PATH;
    }

    /**
     * Start the MI monitoring dashboard app.
     *
     * @throws IOException if error occurred while starting the app
     */
    private void startMonitoringDashboard() throws IOException {
        if (!dashboardStarted) {
            synchronized (lock) {
                if (!dashboardStarted) {
                    serverHost = MonitoringDashboardConstants.DEFAULT_HOST;
                    serverPort = MonitoringDashboardConstants.DEFAULT_PORT;

                    // check port availability
                    while (!MonitoringDashboardUtil.checkPortAvailability(serverHost, serverPort)) {
                        return;
                    }

                    // Starting the dashboard
                    String miMonitoringDashboardPath = MonitoringDashboardUtil.getMIMonitoringDashboardPath();

                    // Check whether the dashboard app exits (It may not be available in older versions of studio).
                    File miMonitoringDashBoardApp = new File(miMonitoringDashboardPath);
                    if (!miMonitoringDashBoardApp.exists()) {
                        throw new IOException("MI Monotoring Dashboard is not available.");
                    }

                    ProcessBuilder processBuilder = new ProcessBuilder(miMonitoringDashboardPath);
                    processBuilder.environment().put(MonitoringDashboardConstants.JAVA_HOME_ENV_VAR,
                            MonitoringDashboardUtil.getJavaHomePath());
                    Process processor = processBuilder.start();

                    BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(processor.getInputStream()));
                    String line = null;

                    // set timeout time to 410 seconds
                    long timeoutExpiredMs = System.currentTimeMillis() + 410000;
                    while ((line = inputBuffer.readLine()) != null) {
                        long waitMillis = timeoutExpiredMs - System.currentTimeMillis();
                        if (waitMillis <= 0) {

                            // timeout expired
                            processor.destroyForcibly();
                            throw new IOException("Failed start the monitoring dashboard in port - " + serverPort);
                        } else if (line.contains("WSO2 Micro Integration Monitoring Dashboard started")) {
                            dashboardStarted = true;
                            break;
                        }
                    }
                    inputBuffer.close();
                }
            }
        }
        
        // since, CarbonServerListner events are not passing in latest tooling version, couldnt track server stop event via the IServer console.
        // Hence, this async thread checks the embedded MI server port in every 5 second interval and verify MI server is running.
        // When it detects, server is down then stopMonitoringDashboard() will be invoked 
        if (dashboardStarted) {
            serverStoppedAction();
        }
    }

    /**
     * Stop the MI Monitoring dashboard.
     */
    public void stopMonitoringDashboard() {
        if (dashboardStarted) {
            synchronized (lock) {
                if (dashboardStarted) {
                    try {
                        BufferedReader bufferReader;

                        // check running operating system
                        if (MonitoringDashboardUtil.isWindows()) {
                            Runtime runTime = Runtime.getRuntime();
                            Process proc = runTime
                                    .exec("cmd /c netstat -ano | findstr " + serverPort + " | findStr LISTENING");

                            bufferReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

                            String stream = bufferReader.readLine();
                            if (stream != null) {
                                int index = stream.lastIndexOf(' ');
                                String pid = stream.substring(index);
                                runTime.exec("cmd /c Taskkill /PID " + pid + " /T /F");
                            }
                        } else {
                            Process pr = Runtime.getRuntime().exec("lsof -t -i:" + serverPort + " -sTCP:LISTEN");
                            bufferReader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                            String pid = bufferReader.readLine();
                            Runtime.getRuntime().exec("kill -9 " + pid);
                        }
                        bufferReader.close();
                        dashboardStarted = false;
                        serverPort = -1;
                        serverHost = null;
                    } catch (IOException e) {
                        log.error("Failed to stop the mi monitoring dashboard", e);
                    }
                }
            }
        }
    }
    
    private void serverStoppedAction() {
           
        new Thread() {
            public void run() {
                String portOffset = "10";
                String deploymentTomlPath = MonitoringDashboardUtil.getMicroIntegratorPath() + File.separator
                        + "conf" + File.separator + "deployment.toml";
                try (BufferedReader br = new BufferedReader(new FileReader(new File(deploymentTomlPath)))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.trim().contains("offset")) {
                            if (!line.trim().startsWith("#")) {
                                String[] array = line.trim().split("=");
                                portOffset = array[1].trim();
                            }
                            break;
                        }
                    }
                } catch (FileNotFoundException e1) {
                    // TODO Auto-generated catch block
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                }

                int miPassthroughPort = 8280 + Integer.parseInt(portOffset);
                while (!MonitoringDashboardUtil.checkPortAvailability(serverHost, miPassthroughPort)) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                    }
                }

                // Closing the mi dashboard
                stopMonitoringDashboard();
                // revert embedded server configuration changes
                EmbeddedServerConfigurationUtil.revertEmbeddedServerConfigurations();
                // Closing the deployed services view
                Display.getDefault().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
                                .getActivePage();
                        IViewPart view = page.findView(ServerConstants.DEPLOYED_SERVICES_VIEW);
                        page.hideView(view);
                    }
                });
            }
        }.start();
    }
}
