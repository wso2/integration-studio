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

package org.wso2.developerstudio.eclipse.carbonserver44microei12.monitoring.dashboard.util;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.Locale;

public class MonitoringDashboardUtil {

    /**
     * Check port availability.
     *
     * @param host host to check
     * @param port port which want to check availability
     * @return if available true else false
     */
    public static boolean checkPortAvailability(String host, int port) {
        boolean isPortAvailable;
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port));
            isPortAvailable = false;
        } catch (IOException e) {
            isPortAvailable = true;
        }
        return isPortAvailable;
    }

    /**
     * Returns the path to the MI Dashboard app.
     * 
     * @return path to the MI Dashboard app
     */
    public static String getMIMonitoringDashboardPath() {
        String microInteratorPath;
        if (isMac()) {
            // check if EI Tooling is in Application folder for MAC
            File macOSEIToolingAppFile = new File(MonitoringDashboardConstants.TOOLING_PATH_MAC);
            if (macOSEIToolingAppFile.exists()) {
                microInteratorPath = MonitoringDashboardConstants.TOOLING_PATH_MAC + File.separator
                        + MonitoringDashboardConstants.MI_DASHBOARD_PATH;
            } else {
                java.nio.file.Path path = Paths.get(MonitoringDashboardConstants.EMPTY_STRING);
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator
                        + MonitoringDashboardConstants.MI_DASHBOARD_PATH;
            }
        } else {
            java.nio.file.Path path = Paths.get(MonitoringDashboardConstants.EMPTY_STRING);
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator
                    + MonitoringDashboardConstants.MI_DASHBOARD_PATH;
        }
        
        if (isWindows()) {
            microInteratorPath += MonitoringDashboardConstants.MI_DASHBOARD_APP_WINDOWS;
        } else {
            microInteratorPath += MonitoringDashboardConstants.MI_DASHBOARD_APP_UNIX;
        }
        return microInteratorPath;
    }

    /**
     * Check if the OS is windows.
     * 
     * @return is windows
     */
    public static boolean isWindows() {
        String OS = System.getProperty(MonitoringDashboardConstants.OS_NAME, MonitoringDashboardConstants.GENERIC)
                .toLowerCase(Locale.ENGLISH);
        return OS.contains(MonitoringDashboardConstants.WINDOWS);
    }

    /**
     * Check if the OS is MAC.
     * 
     * @return is MAC
     */
    public static boolean isMac() {
        String OS = System.getProperty(MonitoringDashboardConstants.OS_NAME, MonitoringDashboardConstants.GENERIC)
                .toLowerCase(Locale.ENGLISH);
        return (OS.indexOf(MonitoringDashboardConstants.MAC) >= 0)
                || (OS.indexOf(MonitoringDashboardConstants.DARWIN) >= 0);
    }

    /**
     * Method of getting JAVA_HOME path based on the OS type.
     *
     * @return JAVA_HOME path
     */
    public static String getJavaHomePath() {
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String microInteratorPath;

        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            // check if EI Tooling is in Application folder for MAC
            File macOSEIToolingAppFile = new File(MonitoringDashboardConstants.TOOLING_PATH_MAC);
            if (macOSEIToolingAppFile.exists()) {
                microInteratorPath = MonitoringDashboardConstants.TOOLING_PATH_MAC + File.separator +
                        MonitoringDashboardConstants.JDK_PATH_MAC;
            } else {
                java.nio.file.Path path = Paths.get("");
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator +
                        MonitoringDashboardConstants.JDK_PATH_MAC;
            }
        } else {
            java.nio.file.Path path = Paths.get("");
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator +
                    MonitoringDashboardConstants.JDK_PATH;
        }

        return microInteratorPath;
    }
}
