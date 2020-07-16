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

package org.wso2.developerstudio.eclipse.distribution.project.configure.embeddedserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.distribution.project.Activator;
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
    private static final String CONFIG_PROPERTIES_FILE = "config.properties";
    public static final String NEW_DROPINS_MD5SUM = "new.dropins.md5sum";
    public static final String CURRENT_DROPINS_MD5SUM = "current.dropins.md5sum";
    private static final Path SERVER_CONFIG_DROPINS = Paths.get(TEMP_SERVER_CONFIGURATION_PATH,"dropins");
    private static final Path SERVER_CONFIG_SELECTED_DROPINS = Paths.get(SERVER_CONFIG_DROPINS.toString(), 
            "selected");
    private static final String JAR_EXTENSION = ".jar";
    private static final String JAR_EXTENSION_ALL_CAPS = ".JAR";

    private EmbeddedServerConfigWizardPage serverConfigPage;
    private String miDeploymentTomlPath;
    private String serverConfigDeploymentTomlPath;
    private String miServerPath;
    private String osType;
    private Map<String, Boolean> librariesList = new HashMap<>();
    private Map<String, Boolean> dropinLibrariesList = new HashMap<>();

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        String tomlConfiguration = checkAndLoadDeploymentToml();
        loadSelectedLibrarySets();
        setWindowTitle(WINDOW_TITLE);
        serverConfigPage = new EmbeddedServerConfigWizardPage(tomlConfiguration, TEMP_SERVER_CONFIGURATION_PATH,
                librariesList, miServerPath, dropinLibrariesList);
    }

    private String checkAndLoadDeploymentToml() {
        File configDir = new File(TEMP_SERVER_CONFIGURATION_PATH);
        File dropinsDir = SERVER_CONFIG_SELECTED_DROPINS.toFile();
        miServerPath = getMicroIntegratorPath();
        miDeploymentTomlPath = miServerPath + SERVER_CONF_DIRECTORY + DEPLOYMENT_TOML_FILE;
        serverConfigDeploymentTomlPath = TEMP_SERVER_CONFIGURATION_PATH + DEPLOYMENT_TOML_FILE;
        try {
            if (!configDir.exists()) {
                configDir.mkdirs();
                new File(TEMP_SERVER_CONFIGURATION_PATH + SERVER_CONFIG_SELECTED_LIBS).mkdirs();
                FileUtils.copyFile(new File(miDeploymentTomlPath), new File(serverConfigDeploymentTomlPath));
            }
            
            if (!dropinsDir.exists()) {
                dropinsDir.mkdirs();
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
        
        selectedCheckedLibs = SERVER_CONFIG_SELECTED_DROPINS.toFile();
        listSelectedCheckedLibs = selectedCheckedLibs.listFiles();
        for (int i = 0; i < listSelectedCheckedLibs.length; i++) {
            String filename = listSelectedCheckedLibs[i].getName();
            if (filename.endsWith(JAR_EXTENSION) || filename.endsWith(JAR_EXTENSION_ALL_CAPS)) {
                dropinLibrariesList.put(filename, true);
            }
        }

        selectedLibs = SERVER_CONFIG_DROPINS.toFile();
        listSelectedLibs = selectedLibs.listFiles();
        for (int i = 0; i < listSelectedLibs.length; i++) {
            String filename = listSelectedLibs[i].getName();
            if ((filename.endsWith(JAR_EXTENSION) || filename.endsWith(JAR_EXTENSION_ALL_CAPS)) && 
            		!dropinLibrariesList.containsKey(filename)) {
                dropinLibrariesList.put(filename, false);
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

        setServerConfigProperties();
        
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

	private void setServerConfigProperties() {
		String configPropertiesPath = TEMP_SERVER_CONFIGURATION_PATH + File.separator + CONFIG_PROPERTIES_FILE;
		boolean updatePropertiesfile = false;
		Properties properties = new Properties();

		String selectedJarPath = TEMP_SERVER_CONFIGURATION_PATH + SERVER_CONFIG_SELECTED_LIBS;
		String selectedDropinsPath = SERVER_CONFIG_SELECTED_DROPINS.toString();
		try {
			properties.setProperty("new.jar.md5sum", hashDirectory(selectedJarPath));
			updatePropertiesfile = true;
			
			properties.setProperty(NEW_DROPINS_MD5SUM, hashDirectory(selectedDropinsPath));
		} catch (IOException e) {
			log.error("Error while setting the md5sum value of the selected directory.", e);
		}

		try (InputStream propertiesFileStream = Files.newInputStream(Paths.get(configPropertiesPath))) {
			if (propertiesFileStream != null) {
				Properties existingProperties = new Properties();
				existingProperties.load(propertiesFileStream);

				String currentTomlMd5sum = existingProperties.getProperty("current.toml.md5sum");
				if (currentTomlMd5sum != null) {
					properties.setProperty("current.toml.md5sum", currentTomlMd5sum);
					updatePropertiesfile = true;
				}

				String currentJarMd5sum = existingProperties.getProperty("current.jar.md5sum");
				if (currentJarMd5sum != null) {
					properties.setProperty("current.jar.md5sum", currentJarMd5sum);
					updatePropertiesfile = true;
				}

				String currentDropinsMd5sum = existingProperties.getProperty(CURRENT_DROPINS_MD5SUM);
				if (currentDropinsMd5sum != null) {
				    properties.setProperty(CURRENT_DROPINS_MD5SUM, currentDropinsMd5sum);
				    updatePropertiesfile = true;
				}
			}
		} catch (IOException | IllegalArgumentException e) {
			//ignore the error log until the config.properties file is available
		}

		try (InputStream inStream = Files.newInputStream(Paths.get(serverConfigDeploymentTomlPath))) {

			if (inStream != null) {
				String tomlMd5sum = DigestUtils.md5Hex(inStream);
				properties.setProperty("new.toml.md5sum", tomlMd5sum);
				updatePropertiesfile = true;
			}
		} catch (IOException e) {
			log.error("Error while setting the md5sum value of the toml file.", e);
		}

		if (updatePropertiesfile) {
			try (OutputStream outputStream = new FileOutputStream(configPropertiesPath)) {
				properties.store(outputStream, null);
			} catch (IOException e) {
				log.error("Error while writing to the conf.properties file.", e);
			}
		}
	}

	private static String hashDirectory(String directoryPath) throws IOException {
		File directory = new File(directoryPath);

		if (!directory.isDirectory()) {
			throw new IllegalArgumentException("Not a directory");
		}

		Vector<FileInputStream> fileStreams = new Vector<>();
		collectFiles(directory, fileStreams, false);

		try (SequenceInputStream sequenceInputStream = new SequenceInputStream(fileStreams.elements())) {
			return DigestUtils.md5Hex(sequenceInputStream);
		}
	}

	private static void collectFiles(File directory, List<FileInputStream> fileInputStreams, boolean includeHiddenFiles)
			throws IOException {
		File[] files = directory.listFiles();

		if (files != null) {
			Arrays.sort(files, Comparator.comparing(File::getName));

			for (File file : files) {
				if (includeHiddenFiles || !Files.isHidden(file.toPath())) {
					if (file.isDirectory()) {
						collectFiles(file, fileInputStreams, includeHiddenFiles);
					} else {
						fileInputStreams.add(new FileInputStream(file));
					}
				}
			}
		}
	}

    public void addPages() {
        addPage(serverConfigPage);
        super.addPages();
    }
}
