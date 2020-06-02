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

package org.wso2.developerstudio.eclipse.carbonserver44microei12.monitor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.wst.server.core.IServer;
import org.eclipse.wst.server.core.IServerListener;
import org.eclipse.wst.server.core.ServerEvent;
import org.wso2.developerstudio.eclipse.carbonserver.base.console.CarbonServerConsole;
import org.wso2.developerstudio.eclipse.carbonserver.base.interfaces.ICarbonServerMonitor;
import org.wso2.developerstudio.eclipse.carbonserver.base.manager.CarbonServerManager;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.Activator;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.register.product.servers.MicroIntegratorInstance;
import org.wso2.developerstudio.eclipse.carbonserver44microei12.util.CarbonServer44eiUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class CarbonServerListener implements IServerListener {
    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private final List<ICarbonServerMonitor> serverMonitors;

    private CarbonServer44eiUtils carbonServer44eiUtils = new CarbonServer44eiUtils();

    public CarbonServerListener(List<ICarbonServerMonitor> serverMonitors) {
        this.serverMonitors = serverMonitors;
    }

    public void serverChanged(ServerEvent event) {
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
        File cappMonitorBundle = carbonServer44eiUtils.getCappMonitorBundle();
        configureEmbeddedServerConfigurations();
        IPath dropins = CarbonServerManager.getServerHome(server).append("dropins");
        try {
            FileUtils.copyFileToDirectory(cappMonitorBundle, new File(dropins.toOSString()));
        } catch (IOException e1) {
            log.error(e1);
        }
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
        revertEmbeddedServerConfigurations();
        File cappMonitorBundle = carbonServer44eiUtils.getCappMonitorBundle();
        IPath dropins = CarbonServerManager.getServerHome(server).append("repository").append("components")
                .append("dropins").append(cappMonitorBundle.getName());
        File cappMonitorFile = new File(dropins.toOSString());
        if (cappMonitorFile.exists()) {
            cappMonitorFile.delete();
        }
        for (ICarbonServerMonitor monitor : serverMonitors) {
            try {
                monitor.stopped(server);
            } catch (Exception e) {
                log.error(e);
            }
        }
    }
    
    /**
     * This method revert temp_lib, temp_dropins, deployment_temp.toml and secret-conf_temo.properties files to original
     * state.
     */
    private void revertEmbeddedServerConfigurations() {
        String miHomePath = MicroIntegratorInstance.getInstance().getServerHome();
        File tempLibDirectory = new File(miHomePath + File.separator + "temp_lib");
        File tempDropinsDirectory = new File(miHomePath + File.separator + "temp_dropins");
        File runningLibDirectory = new File(miHomePath + File.separator + "lib");
        File runningDropinsDirectory = new File(miHomePath + File.separator + "dropins");
        File tempDeploymentTomlFile = new File(
                miHomePath + File.separator + "conf" + File.separator + "deployment_temp.toml");
        File runningDeploymentTomlFile = new File(
                miHomePath + File.separator + "conf" + File.separator + "deployment.toml");
        File tempSecretConfFile = new File(miHomePath + File.separator + "conf" + File.separator + "security"
                + File.separator + "secret-conf_temp.properties");
        File runningSecretConfFile = new File(miHomePath + File.separator + "conf" + File.separator + "security"
                + File.separator + "secret-conf.properties");

        if (tempLibDirectory.exists()) {
            try {
                org.apache.commons.io.FileUtils.deleteDirectory(runningLibDirectory);
                tempLibDirectory.renameTo(runningLibDirectory);
            } catch (IOException e) {
                log.error("An error occured while reloading default server configurations", e);
            }
        }

        if (tempDropinsDirectory.exists()) {
            try {
                org.apache.commons.io.FileUtils.deleteDirectory(runningDropinsDirectory);
                tempDropinsDirectory.renameTo(runningDropinsDirectory);
            } catch (IOException e) {
                log.error("An error occured while reloading default server configurations", e);
            }
        }

        if (tempDeploymentTomlFile.exists()) {
            runningDeploymentTomlFile.delete();
            tempDeploymentTomlFile.renameTo(runningDeploymentTomlFile);
        }

        if (tempSecretConfFile.exists()) {
            runningSecretConfFile.delete();
            tempSecretConfFile.renameTo(runningSecretConfFile);
        }
    }

    /**
     * This method takes a temp_backup of the lib, dropins directories and deployment.toml and secret-conf.properties
     * files.
     * Replace the original with customer edited configurations located in workspace/.metadata/ServerConfigs
     */
    private void configureEmbeddedServerConfigurations() {
        String workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString();
        String miHomePath = MicroIntegratorInstance.getInstance().getServerHome();

        File tempLibDirectory = new File(miHomePath + File.separator + "temp_lib");
        File tempDropinsDirectory = new File(miHomePath + File.separator + "temp_dropins");
        File runningLibDirectory = new File(miHomePath + File.separator + "lib");
        File runningDropinsDirectory = new File(miHomePath + File.separator + "dropins");
        File tempDeploymentTomlFile = new File(
                miHomePath + File.separator + "conf" + File.separator + "deployment_temp.toml");
        File runningDeploymentTomlFile = new File(
                miHomePath + File.separator + "conf" + File.separator + "deployment.toml");
        File tempSecretConfFile = new File(miHomePath + File.separator + "conf" + File.separator + "security"
                + File.separator + "secret-conf_temp.properties");
        File runningSecretConfFile = new File(miHomePath + File.separator + "conf" + File.separator + "security"
                + File.separator + "secret-conf.properties");

        if (tempLibDirectory.exists()) {
            try {
                org.apache.commons.io.FileUtils.deleteDirectory(runningLibDirectory);
                tempLibDirectory.renameTo(runningLibDirectory);
            } catch (IOException e) {
                log.error("An error occured while reloading default server configurations", e);
            }
        }

        if (tempDropinsDirectory.exists()) {
            try {
                org.apache.commons.io.FileUtils.deleteDirectory(runningDropinsDirectory);
                tempDropinsDirectory.renameTo(runningDropinsDirectory);
            } catch (IOException e) {
                log.error("An error occured while reloading default server configurations", e);
            }
        }

        if (tempDeploymentTomlFile.exists()) {
            runningDeploymentTomlFile.delete();
            tempDeploymentTomlFile.renameTo(runningDeploymentTomlFile);
        }

        if (tempSecretConfFile.exists()) {
            runningSecretConfFile.delete();
            tempSecretConfFile.renameTo(runningSecretConfFile);
        }

        try {
            String serverConfigDirectoryPath = workspace + File.separator + ".metadata" + File.separator
                    + "ServerConfigs";
            File serverConfigurationDirectory = new File(serverConfigDirectoryPath);
            File customizedTomlFile = new File(serverConfigDirectoryPath + File.separator + "deployment.toml");
            if (serverConfigurationDirectory.exists()
                    && !org.apache.commons.io.FileUtils.contentEquals(runningDeploymentTomlFile, customizedTomlFile)) {
                // backup original lib, dropins and deployment.toml resources
                FileUtils.copyDirectory(runningLibDirectory, tempLibDirectory);
                FileUtils.copyDirectory(runningDropinsDirectory, tempDropinsDirectory);
                org.apache.commons.io.FileUtils.copyFile(runningDeploymentTomlFile, tempDeploymentTomlFile);

                // copy user edited deployment.toml to conf directory
                if (customizedTomlFile.exists()) {
                    org.apache.commons.io.FileUtils.copyFile(customizedTomlFile, runningDeploymentTomlFile);
                }

                // copy user generated secret-conf.properties to conf/security directory
                File customizedSecretConflFile = new File(
                        serverConfigDirectoryPath + File.separator + "secret-conf.properties");
                if (customizedSecretConflFile.exists()) {
                    org.apache.commons.io.FileUtils.copyFile(runningSecretConfFile, tempSecretConfFile);
                    org.apache.commons.io.FileUtils.copyFile(customizedSecretConflFile, runningSecretConfFile);
                }

                // copy user selected libraries to lib directory
                String selectedLibraryPath = serverConfigDirectoryPath + File.separator + "lib" + File.separator
                        + "selected";
                File selectedCheckedLibs = new File(selectedLibraryPath);
                File[] listSelectedCheckedLibs = selectedCheckedLibs.listFiles();
                for (int i = 0; i < listSelectedCheckedLibs.length; i++) {
                    String filename = listSelectedCheckedLibs[i].getName();
                    if (filename.endsWith(".jar") || filename.endsWith(".JAR")) {
                        File jarFile = new File(selectedLibraryPath + File.separator + filename);
                        File jarToLibDirectory = new File(
                                miHomePath + File.separator + "lib" + File.separator + filename);
                        org.apache.commons.io.FileUtils.copyFile(jarFile, jarToLibDirectory);
                    }
                }
            }
        } catch (IOException e) {
            log.error("An error occured while backup default server configurations", e);
        }
    }
}
