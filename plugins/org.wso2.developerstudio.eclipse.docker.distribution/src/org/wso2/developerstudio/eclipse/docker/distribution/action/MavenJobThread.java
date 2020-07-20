/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.docker.distribution.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.swt.SWT;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.model.DockerHubAuth;
import org.wso2.developerstudio.eclipse.docker.distribution.utils.DockerProjectConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * Class responsible for run the maven jobs in a seperate thread.
 */
public class MavenJobThread implements Runnable {

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
    private boolean isMavenBuildDone;
    private int isBuildSuccess = 1;
    private ILaunch launcher;
    private IProject project;
    private DockerHubAuth authConfiguration;

    /**
     * Constructor of the class.
     * 
     * @param isBuild status of the running build
     * @param launch launch maven profile
     * @param project currently selecting project
     * @param configuration docker registry credentials
     * @param isThisOldContainerProject
     */
    public MavenJobThread(boolean isBuild, ILaunch launch, IProject project, DockerHubAuth configuration,
            boolean isThisOldContainerProject) {
        this.isMavenBuildDone = isBuild;
        this.launcher = launch;
        this.project = project;
        this.authConfiguration = configuration;
    }

    /**
     * Method of running the maven thread.
     */
    public void run() {
        executeMavenBuildJob();
    }

    /**
     * Method of executing maven job for docker build using maven launcher.
     * Waits until maven build is pass or failure
     * If not, breaks the launcher process after 120 seconds
     * If project is an kubernetes, run maven push job for maven build successors
     */
    private void executeMavenBuildJob() {        
        try {
            if (launcher == null) {
                executeMavenPushJob();
                return;
            }
            
            int loopCount = 0;
            while (!isMavenBuildDone) {
                List<Boolean> listOfProcessTermination = new ArrayList<>();
                for (IProcess process : launcher.getProcesses()) {
                    listOfProcessTermination.add(process.isTerminated());
                }

                //check all the sub processors are terminated
                if (getAllProcessTerminated(listOfProcessTermination)) {
                    isMavenBuildDone = true;
                    isBuildSuccess = launcher.getProcesses()[0].getExitValue();

                    revertDockerConfigurationFile();
                    if (isBuildSuccess == 0 && authConfiguration != null && authConfiguration.isKubernetesProject()) {
                        executeMavenPushJob();
                    } else if (isBuildSuccess == 0 && authConfiguration == null) {
                        DockerBuildActionUtil.showMessageBox(DockerProjectConstants.MESSAGE_BOX_TITLE,
                                DockerProjectConstants.DOCKER_IMAGE_GEN_SUCCESS_MESSAGE, SWT.ICON_WORKING);
                    } else {
                        DockerBuildActionUtil.showMessageBox(DockerProjectConstants.MESSAGE_BOX_TITLE,
                                DockerProjectConstants.DOCKER_IMAGE_GEN_FAILED_MESSAGE, SWT.ERROR);
                    }
                }

                // skip the the await after two minutes
                if (loopCount > 120) {
                    break;
                }

                Thread.sleep(1000);
                loopCount++;
            }
        } catch (InterruptedException e) {
            log.error("Error while waiting for the next iteration of checking IProcesses", e);
        } catch (DebugException e) {
            log.error("DebugException while waiting for the next iteration of checking IProcesses", e);
        } catch (CoreException e) {
            log.error("CoreException while pushing the built image to the registry", e);
        }
    }

    /**
     * Method of checking whether maven build is terminated or not.
     * 
     * @param listOfProcessTermination
     *            launcher processes
     * @return build is terminated or not
     */
    private static boolean getAllProcessTerminated(List<Boolean> listOfProcessTermination) {
        for (boolean value : listOfProcessTermination) {
            if (!value) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method of executing maven push job for docker images.
     * 
     * @throws InterruptedException error when thread handling
     * @throws CoreException error when maven jobs running
     */
    private void executeMavenPushJob() throws InterruptedException, CoreException {
        ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
        final String MAVEN_DOCKER_PUSH = "Run Docker Push Internal Configuration";
        
        // change .docker/config.json file which storing authentication data
        renameDockerConfigurationFile();

        // remove existing maven launcher for docker build
        if (DockerBuildActionUtil.findLaunchConfigurationByName(launchManager, MAVEN_DOCKER_PUSH) != null) {
            DockerBuildActionUtil.findLaunchConfigurationByName(launchManager, MAVEN_DOCKER_PUSH).delete();
        }

        // creating a new Launcher for docker build
        ILaunchConfigurationType mavenTestLaunchType = launchManager
                .getLaunchConfigurationType(DockerBuildActionUtil.MAVEN_CONFIGURATION_TYPE);
        ILaunchConfigurationWorkingCopy mavenTestLaunchConfig = mavenTestLaunchType.newInstance(null,
                DebugPlugin.getDefault().getLaunchManager().generateLaunchConfigurationName(MAVEN_DOCKER_PUSH));

        // set maven properties for the created launcher
        mavenTestLaunchConfig.setAttribute(DockerBuildActionUtil.MAVEN_GOAL_KEY,
                mavenDockerBuildGoal());
        mavenTestLaunchConfig.setAttribute(DockerBuildActionUtil.MAVEN_WORKING_DIR_KEY,
                "${workspace_loc:/" + project.getName() + "}");
        String javaHomePath = DockerBuildActionUtil.getJavaHomePath();
        Map<String, String> environmentVariableMap = new HashMap<>();
        environmentVariableMap.put(DockerBuildActionUtil.JAVA_HOME_KEY, javaHomePath);
        mavenTestLaunchConfig.setAttribute(DockerBuildActionUtil.MAVEN_ENVIRONMENT_KEY, environmentVariableMap);

        // save the launcher with configuration data
        mavenTestLaunchConfig.doSave();

        // Select the maven launcher and run it
        for (ILaunchConfiguration launchConfig : launchManager.getLaunchConfigurations()) {
            if (launchConfig.getName().equals(MAVEN_DOCKER_PUSH)) {
                ILaunch launch = launchConfig.launch(DockerBuildActionUtil.LAUNCHER_RUN, null);

                int loopCount = 0;
                boolean isMavenPushBuildDone = false;
                int isPushSuccess;
                while (!isMavenPushBuildDone) {
                    List<Boolean> listOfProcessTermination = new ArrayList<>();
                    for (IProcess process : launch.getProcesses()) {
                        listOfProcessTermination.add(process.isTerminated());
                    }

                    if (getAllProcessTerminated(listOfProcessTermination)) {
                        isMavenPushBuildDone = true;
                        isPushSuccess = launch.getProcesses()[0].getExitValue();

                        revertDockerConfigurationFile();
                        if (isPushSuccess == 0) {
                            DockerBuildActionUtil.showMessageBox(DockerProjectConstants.MESSAGE_BOX_TITLE,
                                    DockerProjectConstants.DOCKER_IMAGE_PUSH_SUCCESS_MESSAGE, SWT.ICON_WORKING);
                        } else {
                            DockerBuildActionUtil.showMessageBox(DockerProjectConstants.MESSAGE_BOX_TITLE,
                                    DockerProjectConstants.DOCKER_IMAGE_PUSH_FAILED_MESSAGE, SWT.ERROR);
                        }
                    }

                    // skip the the await after two minutes
                    if (loopCount > 120) {
                        break;
                    }

                    Thread.sleep(1000);
                    loopCount++;
                }

                break;
            }
        }
    }

    /**
     * Method of generating the testing maven goal according to the local or remote server.
     * 
     * @param unitTestConfigDetailPage  object of unit test config detail page
     * @return string of maven goal
     */
    private String mavenDockerBuildGoal() {
        StringBuilder builder = new StringBuilder();
        builder.append("dockerfile:push")
        .append(" -Ddockerfile.username=" + authConfiguration.getAuthUsername())
        .append(" -Ddockerfile.password=" + authConfiguration.getAuthPassword());
        return builder.toString();
    }

    /**
     * Method of getting the status of the maven build.
     * 
     * @param status of the maven build
     */
    public boolean getBuildStatus() {
        return isMavenBuildDone;
    }

    /**
     * Method of getting build success or failure.
     * 
     * @param success stands as zero and failure  stands as one
     */
    public int isBuildSuccess() {
        return isBuildSuccess;
    }
    
    private void renameDockerConfigurationFile() {
        try {
            String userHome = System.getProperty("user.home") + File.separator;
            String dockerConfigLocation = ".docker" + File.separator;
            File dockerConfigFile = new File(userHome + dockerConfigLocation + "config.json");
            File targetNewDockerConfigFile = new File(userHome + dockerConfigLocation + "config_tooling_temp.json");

            if (dockerConfigFile.exists()) {
                dockerConfigFile.renameTo(targetNewDockerConfigFile);
            }
        } catch (Exception e) {
            /* ignore */} ;
    }

    private void revertDockerConfigurationFile() {
        try {
            String userHome = System.getProperty("user.home") + File.separator;
            String dockerConfigLocation = ".docker" + File.separator;
            File dockerConfigFile = new File(userHome + dockerConfigLocation + "config.json");
            File targetNewDockerConfigFile = new File(userHome + dockerConfigLocation + "config_tooling_temp.json");

            if (targetNewDockerConfigFile.exists()) {
                targetNewDockerConfigFile.renameTo(dockerConfigFile);
            }
        } catch (Exception e) {
            /* ignore */} ;
    }
}
