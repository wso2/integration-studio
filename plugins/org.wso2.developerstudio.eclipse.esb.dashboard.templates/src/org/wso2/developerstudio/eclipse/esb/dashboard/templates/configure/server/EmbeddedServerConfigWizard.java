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

package org.wso2.developerstudio.eclipse.esb.dashboard.templates.configure.server;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.esb.dashboard.templates.Activator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class EmbeddedServerConfigWizard extends Wizard implements INewWizard, IExportWizard {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private static final String WINDOW_TITLE = "Embedded Micro Integrator Configuration";
    private static final String SERVER_CONFIG_LOCATION = File.separator + ".metadata" + File.separator
            + "ServerConfigs";
    private static final String TOOLING_PATH_MAC = "/Applications/IntegrationStudio.app/Contents/Eclipse";
    private static final String EMPTY_STRING = "";
    private static final String MI_FOLDER = "runtime" + File.separator + "microesb";
    private static final String DEPLOYMENT_TOML_FILE = File.separator + "deployment.toml";
    private static final String SECRET_CONF_FILE = File.separator + "secret-conf.properties";
    private static final String PASSWORD_PERSISTS_WINDOWS = File.separator + "password-persist.txt";
    private static final String PASSWORD_PERSISTS_OTHERS = File.separator + "password-persist";
    private static final String SERVER_CONFIG_LIBS = File.separator + "lib";
    private static final String SERVER_CONF_DIRECTORY = File.separator + "conf";
    private static final String SERVER_CONFIG_SELECTED_LIBS = SERVER_CONFIG_LIBS + File.separator + "selected";
    private static final String TEMP_SERVER_CONFIGURATION_PATH = ResourcesPlugin.getWorkspace().getRoot().getLocation()
            .toOSString() + SERVER_CONFIG_LOCATION;
    private static final String WINDOW_OS = "WINDOWS";
    private static final String OTHER_OS = "OTHER";

    private EmbeddedServerConfigWizardPage serverConfigPage;
    private String miDeploymentTomlPath;
    private String serverConfigDeploymentTomlPath;
    private String miServerPath;
    private String osType;
    private Map<String, Boolean> librariesList = new HashMap<>();

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        String tomlConfiguration = checkAndLoadDeploymentToml();
        loadSelectedLibrarySets();
        setWindowTitle(WINDOW_TITLE);
        serverConfigPage = new EmbeddedServerConfigWizardPage(tomlConfiguration, TEMP_SERVER_CONFIGURATION_PATH,
                librariesList, miServerPath);
    }

    private String checkAndLoadDeploymentToml() {
        File configDir = new File(TEMP_SERVER_CONFIGURATION_PATH);
        miServerPath = getMicroIntegratorPath();
        miDeploymentTomlPath = miServerPath + SERVER_CONF_DIRECTORY + DEPLOYMENT_TOML_FILE;
        serverConfigDeploymentTomlPath = TEMP_SERVER_CONFIGURATION_PATH + DEPLOYMENT_TOML_FILE;
        try {
            if (!configDir.exists()) {
                configDir.mkdirs();
                new File(TEMP_SERVER_CONFIGURATION_PATH + SERVER_CONFIG_SELECTED_LIBS).mkdirs();
                FileUtils.copyFile(new File(miDeploymentTomlPath), new File(serverConfigDeploymentTomlPath));
            }

            String content = new String(Files.readAllBytes(Paths.get(serverConfigDeploymentTomlPath)));
            return content;
        } catch (IOException e) {
            log.error("Error while reading toml configurations", e);
        }
        return null;
    }

    private void loadSelectedLibrarySets() {
        File selectedCheckedLibs = new File(TEMP_SERVER_CONFIGURATION_PATH + SERVER_CONFIG_SELECTED_LIBS);
        File[] listSelectedCheckedLibs = selectedCheckedLibs.listFiles();
        for (int i = 0; i < listSelectedCheckedLibs.length; i++) {
            String filename = listSelectedCheckedLibs[i].getName();
            if (filename.endsWith(".jar") || filename.endsWith(".JAR")) {
                librariesList.put(filename, true);
            }
        }

        File selectedLibs = new File(TEMP_SERVER_CONFIGURATION_PATH + SERVER_CONFIG_LIBS);
        File[] listSelectedLibs = selectedLibs.listFiles();
        for (int i = 0; i < listSelectedLibs.length; i++) {
            String filename = listSelectedLibs[i].getName();
            if ((filename.endsWith(".jar") || filename.endsWith(".JAR")) && !librariesList.containsKey(filename)) {
                librariesList.put(filename, false);
            }
        }
    }

    /**
     * Method of getting MI path based on the OS type.
     * 
     * @return MI path
     */
    private String getMicroIntegratorPath() {
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String microInteratorPath;

        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            osType = OTHER_OS;
            // check if EI Tooling is in Application folder for MAC
            File macOSEIToolingAppFile = new File(TOOLING_PATH_MAC);
            if (macOSEIToolingAppFile.exists()) {
                microInteratorPath = TOOLING_PATH_MAC + File.separator + MI_FOLDER;
            } else {
                java.nio.file.Path path = Paths.get(EMPTY_STRING);
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator + MI_FOLDER;
            }
        } else {
            osType = WINDOW_OS;
            java.nio.file.Path path = Paths.get(EMPTY_STRING);
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator + MI_FOLDER;
        }
        return microInteratorPath;
    }

    @Override
    public boolean canFinish() {
        if (serverConfigPage.isPageComplete()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean performFinish() {
        if (serverConfigPage.isTomlChanged()) {
            String deploymentTomlContent = serverConfigPage.getTomlConfig();
            try {
                FileUtils.writeStringToFile(new File(serverConfigDeploymentTomlPath), deploymentTomlContent);
            } catch (IOException e) {
                log.error("Error while writing toml configurations", e);
            }
        }

        try {
            Map<String, String> secrets = serverConfigPage.getSecretsFromConfiguration(serverConfigDeploymentTomlPath);
            
            File passwordFile;
            if (osType.equals(WINDOW_OS)) {
                passwordFile = new File(TEMP_SERVER_CONFIGURATION_PATH + PASSWORD_PERSISTS_WINDOWS);
            } else {
                passwordFile = new File(TEMP_SERVER_CONFIGURATION_PATH + PASSWORD_PERSISTS_OTHERS); 
            }
            
            if (secrets.size() == 0) {
                File secretConfFile = new File(TEMP_SERVER_CONFIGURATION_PATH + SECRET_CONF_FILE);
                if (secretConfFile.exists()) {
                    secretConfFile.delete();
                }
                
                if (passwordFile.exists()) {
                    passwordFile.delete();
                }
            } else {
                if (!passwordFile.exists()) {
                    passwordFile.createNewFile();
                    try (FileWriter myWriter = new FileWriter(passwordFile)) {
                        myWriter.write("wso2carbon");
                    } catch (IOException e) {
                        log.error("Error while creating password-persist file", e);
                    }
                }
            }
        } catch (IOException e) {
            log.error("Error while reading toml configurations", e);
        }

        return true;
    }

    public void addPages() {
        addPage(serverConfigPage);
        super.addPages();
    }
}
