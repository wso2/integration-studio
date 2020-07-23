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

package org.wso2.developerstudio.eclipse.carbonserver44microei12.monitoring.dashboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.wso2.developerstudio.eclipse.carbonserver44microei12.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.monitoring.dashboard.util.MonitoringDashboardConstants;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.monitoring.dashboard.util.MonitoringDashboardUtil;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class MonitoringDashboard {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
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

                    // set timeout time to 120 seconds
                    long timeoutExpiredMs = System.currentTimeMillis() + 120000;
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
}
