/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.runtest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.Activator;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.propertytester.RunTestResourceTester;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Class responsible for creation of wizard for mock service resource headers.
 */
public class UnitTestConfigurationWizard extends Wizard implements IExportWizard {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private final String WINDOW_TITLE = "Unit Test Run Configuration";
    private boolean initError = false;
    private UnitTestConfigurationDetailPage unitTestConfigDetailPage;
    private IStructuredSelection selection;

    private static final String MAVEN_UNIT_TEST = "Run Unit Test Internal Configuration";
    private static final String MAVEN_CONFIGURATION_TYPE = "org.eclipse.m2e.Maven2LaunchConfigurationType";
    private static final String MAVEN_GOAL_KEY = "M2_GOALS";
    private static final String LAUNCHER_RUN = "run";
    private static final String MAVEN_WORKING_DIR_KEY = "org.eclipse.jdt.launching.WORKING_DIRECTORY";
    private static final String MAVEN_ENVIRONMENT_KEY = "org.eclipse.debug.core.environmentVariables";
    private static final String JAVA_HOME_KEY = "JAVA_HOME";
    private static final String TARGET_FILE = "target";
    private static final String JDK_PATH = "jdk-home";
    private static final String TOOLING_PATH_MAC = "/Applications/IntegrationStudio.app/Contents/Eclipse";
    private static final String JDK_PATH_MAC = "jdk-home/Contents/Home";

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);
        this.selection = selection;

        unitTestConfigDetailPage = new UnitTestConfigurationDetailPage();
    }

    @Override
    public boolean performFinish() {
        // save all the existing editors
        IWorkbenchPage[] pages = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPages();
        if (pages != null) {
            for (IWorkbenchPage page : pages) {
                IEditorPart editor = page.getActiveEditor();
                if (editor != null) {
                    page.saveEditor(editor, true);
                }
            }
        }
        
        
        try {
            ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
            Object element = selection.getFirstElement();
            IProject project = ((IResource) element).getProject();
            String targetFolder = project.getLocation().toOSString() + File.separator + TARGET_FILE;

            createAndRunMavenTestAnProfile(launchManager, project, targetFolder, unitTestConfigDetailPage);
        } catch (CoreException e) {
            log.error("Exception occured while maven unit test profile", e);
        }
        return true;
    }

    /**
     * Method of creating maven launcher profile in ILaunchManager.
     * 
     * @param launchManager
     *            launcher
     * @param project
     *            selected IProject
     * @param targetFolder
     *            target folder
     */
    private void createAndRunMavenTestAnProfile(ILaunchManager launchManager, IProject project, String targetFolder,
            UnitTestConfigurationDetailPage unitTestConfigDetailPage) throws CoreException {
        // remove existing maven launcher for unit testing
        if (findLaunchConfigurationByName(launchManager, MAVEN_UNIT_TEST) != null) {
            findLaunchConfigurationByName(launchManager, MAVEN_UNIT_TEST).delete();
        }

        // creating a new Launcher for unit testing
        ILaunchConfigurationType mavenTestLaunchType = launchManager
                .getLaunchConfigurationType(MAVEN_CONFIGURATION_TYPE);
        ILaunchConfigurationWorkingCopy mavenTestLaunchConfig = mavenTestLaunchType.newInstance(null,
                DebugPlugin.getDefault().getLaunchManager().generateLaunchConfigurationName(MAVEN_UNIT_TEST));

        // set maven properties for the created launcher
        String mavenTestGoal = generateMavenTestGoal(unitTestConfigDetailPage);
        mavenTestLaunchConfig.setAttribute(MAVEN_GOAL_KEY, mavenTestGoal);
        mavenTestLaunchConfig.setAttribute(MAVEN_WORKING_DIR_KEY, "${workspace_loc:/" + project.getName() + "}");
        String javaHomePath = getJavaHomePath();
        Map<String, String> environmentVariableMap = new HashMap<>();
        environmentVariableMap.put(JAVA_HOME_KEY, javaHomePath);
        mavenTestLaunchConfig.setAttribute(MAVEN_ENVIRONMENT_KEY, environmentVariableMap);

        // save the launcher with configuration data
        mavenTestLaunchConfig.doSave();

        // Select the maven launcher and run it
        for (ILaunchConfiguration launchConfig : launchManager.getLaunchConfigurations()) {
            if (launchConfig.getName().equals(MAVEN_UNIT_TEST)) {
                ILaunch lauch = launchConfig.launch(LAUNCHER_RUN, null);

                new Thread() {
                    public void run() {
                        try {
                            boolean isBuildOver = false;
                            int loopCount = 0;
                            while (!isBuildOver) {
                                List<Boolean> listOfProcessTermination = new ArrayList<>();
                                for (IProcess process : lauch.getProcesses()) {
                                    listOfProcessTermination.add(process.isTerminated());
                                }

                                if (getAllProcessTerminated(listOfProcessTermination)) {
                                    isBuildOver = true;
                                }

                                // skip the the await after two minutes
                                if (loopCount > 120) {
                                    break;
                                }

                                Thread.sleep(1000);
                                loopCount++;
                            }
                            // Remove the created target directory from the maven
                            removeTargetDirectory(targetFolder);
                        } catch (InterruptedException e) {
                            log.error("Error while waiting for the next iteration of checking IProcesses");
                        } catch (IOException e) {
                            log.error("Error while executing the maven pricess and removing target directory");
                        }
                    }
                }.start();
            }
        }
    }

    /**
     * Method of checking whether maven build is terminated or not.
     * 
     * @param listOfProcessTermination
     *            launcher processes
     * @return build is terminated or not
     */
    private boolean getAllProcessTerminated(List<Boolean> listOfProcessTermination) {
        for (boolean value : listOfProcessTermination) {
            if (!value) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method of finding a ILauncher from existing ILaunchers by its name.
     * 
     * @param launchManager
     * @param configName
     *            name of the searching ILauncher
     * @return ILaunchConfiguration searched
     */
    private ILaunchConfiguration findLaunchConfigurationByName(ILaunchManager launchManager, String configName)
            throws CoreException {
        ILaunchConfiguration[] availableLauchConfigs = launchManager.getLaunchConfigurations();
        for (ILaunchConfiguration iLaunchConfig : availableLauchConfigs) {
            if (configName.equals(iLaunchConfig.getName())) {
                return iLaunchConfig;
            }
        }
        return null;
    }

    /**
     * Method of getting JAVA_HOME path based on the OS type.
     * 
     * @return JAVA_HOME path
     */
    private String getJavaHomePath() {
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String microInteratorPath;

        if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
            // check if EI Tooling is in Application folder for MAC
            File macOSEIToolingAppFile = new File(TOOLING_PATH_MAC);
            if (macOSEIToolingAppFile.exists()) {
                microInteratorPath = TOOLING_PATH_MAC + File.separator + JDK_PATH_MAC;
            } else {
                java.nio.file.Path path = Paths.get("");
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator + JDK_PATH_MAC;
            }
        } else {
            java.nio.file.Path path = Paths.get("");
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator + JDK_PATH;
        }

        return microInteratorPath;
    }

    /**
     * Method of removing target folder created by maven build.
     * 
     * @param directoryToBeDeleted
     *            deleted folder name
     */
    private void removeTargetDirectory(String directoryToBeDeleted) throws IOException {
        boolean isFileCreated = false;

        // set timeout time to 20 seconds
        long timeoutExpiredMs = System.currentTimeMillis() + 20000;
        while (!isFileCreated) {
            long waitMillis = timeoutExpiredMs - System.currentTimeMillis();
            isFileCreated = targetFileExists(directoryToBeDeleted);

            if (waitMillis <= 0) {
                // timeout expired
                throw new IOException("Timeout in checking target folder in the project");
            }
        }

        FileUtils.deleteDirectory(new File(directoryToBeDeleted));
    }

    /**
     * Method of checking target folder exists or not.
     * 
     * @param filePathString
     *            deleted folder path
     * @return file existance
     */
    private boolean targetFileExists(String filePathString) {
        File f = new File(filePathString);
        if (f.exists() && f.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method of generating the testing maven goal according to the local or remote
     * server.
     * 
     * @param unitTestConfigDetailPage
     *            object of unit test config detail page
     * @return string of maven goal
     */
    private String generateMavenTestGoal(UnitTestConfigurationDetailPage unitTestConfigDetailPage) {
        String mavenGoal = "test";
        StringBuilder builder = new StringBuilder(mavenGoal);

        boolean isLocalServerSelect = unitTestConfigDetailPage.isLocalServerChecked();

        if (isLocalServerSelect) {
            String serverPath = unitTestConfigDetailPage.getServerPath();
            String serverPort = unitTestConfigDetailPage.getLocalServerPort();

            builder.append(" -DtestServerType=local");
            builder.append(" -DtestServerPort=" + serverPort);
            builder.append(" -DtestServerPath=\"" + serverPath + "\"");
            
            //clear embedded MI pack carbonapps folder before to run the test
            clearCarbonAppsFolder();
        } else {
            String serverHost = unitTestConfigDetailPage.getServerHosth();
            String serverPort = unitTestConfigDetailPage.getRemoteServerPort();

            builder.append(" -DtestServerType=remote");
            builder.append(" -DtestServerHost=" + serverHost);
            builder.append(" -DtestServerPort=" + serverPort);
        }

        if (RunTestResourceTester.isUnitTestFileSelected) {
            builder.append(" -DtestFile=" + RunTestResourceTester.getSelectedFileName());
        }

        return builder.toString();
    }
    
    /**
     * Clear the carbonapps folder of the embedded MI pack.
     */
    private void clearCarbonAppsFolder() {
        String microesbPath = "runtime" + File.separator + "microesb";
        String carbonAppsFolderPath = File.separator + "repository" + File.separator + "deployment" + File.separator
                + "server" + File.separator + "carbonapps";
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
        String microInteratorPath;

        if (OS.indexOf("windows") >= 0) {
            java.nio.file.Path path = Paths.get("");
            microInteratorPath = (path).toAbsolutePath().toString() + File.separator + microesbPath;
        } else {
            // check if EI Tooling is in Application folder for MAC
            File macOSEIToolingAppFile = new File(TOOLING_PATH_MAC);
            if (macOSEIToolingAppFile.exists()) {
                microInteratorPath = TOOLING_PATH_MAC + File.separator + microesbPath;
            } else {
                java.nio.file.Path path = Paths.get("");
                microInteratorPath = (path).toAbsolutePath().toString() + File.separator + microesbPath;
            }
        }

        // check carbonapps contains any files
        File carbonAppsFolder = new File(microInteratorPath + carbonAppsFolderPath);
        if (carbonAppsFolder.listFiles().length > 0) {
            try {
                FileUtils.cleanDirectory(carbonAppsFolder);
            } catch (IOException e) {
                log.error("Error while clearing the carbonapps folder in MI", e);
            }
        }
    }

    public void addPages() {
        if (!initError) {
            addPage(unitTestConfigDetailPage);
            super.addPages();
        }
    }
}
