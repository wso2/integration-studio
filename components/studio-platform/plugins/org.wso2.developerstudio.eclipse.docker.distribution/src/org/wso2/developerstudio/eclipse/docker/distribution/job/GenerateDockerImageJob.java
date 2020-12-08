/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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

package org.wso2.developerstudio.eclipse.docker.distribution.job;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.mylyn.commons.ui.dialogs.AbstractNotificationPopup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.Bundle;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.exceptions.DockerConnectionException;
import org.wso2.developerstudio.eclipse.docker.distribution.exceptions.DockerImageGenerationException;
import org.wso2.developerstudio.eclipse.docker.distribution.model.MicroIntegratorDockerModel;
import org.wso2.developerstudio.eclipse.docker.distribution.notification.ImageCreationSuccessNotificationPopUp;
import org.wso2.developerstudio.eclipse.docker.distribution.resources.DockerGenConstants;
import org.wso2.developerstudio.eclipse.docker.distribution.util.DockerImageGenerator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;
import org.wso2.developerstudio.eclipse.utils.file.FileUtils;

import com.spotify.docker.client.exceptions.DockerException;

/**
 * Represents a background job to generate the Docker image.
 *
 */
public class GenerateDockerImageJob extends Job {

    private String dockerDirectory;
    private String deploymentDirectory;
    private String destinationDirectory;
    private String eiDistributionSource;
    private String eiDistributionDestination;
    private File carbonFile;
    private MicroIntegratorDockerModel dockerModel;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public GenerateDockerImageJob(String dockerDir, String eiDistributionSource, String eiDistributionDestination,
            String deploymentDir, String destinationDir, File carbonFile,
            MicroIntegratorDockerModel dockerModel) {
        super("Generating Docker Image...");
        this.dockerDirectory = dockerDir;
        this.deploymentDirectory = deploymentDir;
        this.destinationDirectory = destinationDir;
        this.eiDistributionSource = eiDistributionSource;
        this.eiDistributionDestination = eiDistributionDestination;
        this.carbonFile = carbonFile;
        this.dockerModel = dockerModel;
    }

    @Override
    protected IStatus run(IProgressMonitor monitor) {

        String operationText = "Preparing files... ";
        monitor.beginTask(operationText, 100);

        String generatedImageId = null;

        operationText = "Copying files...";
        monitor.subTask(operationText);
        monitor.worked(10);

        try {
            // Copy MicroEI distribution to the docker directory
            FileUtils.copyDirectory(new File(getEiDistributionSource()), new File(getEiDistributionDestination()));

            // Copy entrypoint init file to the docker directory
            Bundle bundle = Platform.getBundle(Activator.PLUGIN_ID);
            URL fileURL = bundle.getEntry(DockerGenConstants.ImageParamDefaults.INIT_FILE_PATH);
            File initFile = null;

            URL resolvedFileURL = FileLocator.toFileURL(fileURL);
            URI resolvedURI = new URI(resolvedFileURL.getProtocol(), resolvedFileURL.getPath(), null);
            initFile = new File(resolvedURI);

            FileUtils.copy(initFile,
                    new File(dockerDirectory + File.separator + DockerGenConstants.ImageParamDefaults.INIT_FILE_NAME));

            operationText = "Clearing temporary directories...";
            monitor.subTask(operationText);
            monitor.worked(20);

            // Clear the deployment directory
            org.apache.commons.io.FileUtils.cleanDirectory(new File(getDeploymentDirectory()));

            operationText = "Copying CAR application...";
            monitor.subTask(operationText);
            monitor.worked(20);

            // Copy CAR file to the deployment directory
            try {
                FileUtils.copyFile(getCarbonFile().getAbsolutePath(),
                        getDeploymentDirectory() + File.separator + getCarbonFile().getName());
            } catch (Exception e) {
                log.error(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE, e);
                showMessageBox(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE,
                        DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_MSG, SWT.ICON_ERROR);
            }

            // Remove temporary CAR file
            org.apache.commons.io.FileUtils.deleteQuietly(getCarbonFile());

            operationText = "Generating docker image...";
            monitor.subTask(operationText);
            monitor.worked(20);

            // Generate the docker image
            DockerImageGenerator generator = new DockerImageGenerator(getDockerModel());

            generatedImageId = generator.generateDockerImage(getDockerDirectory(), getDestinationDirectory());

            operationText = "Clearing temporary directories...";
            monitor.subTask(operationText);
            monitor.worked(20);
        } catch (IOException | IllegalArgumentException | InterruptedException | URISyntaxException e) {
            log.error(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE, e);
            showMessageBox(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE,
                    DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_INTERNAL_ERROR_MSG, SWT.ICON_ERROR);

            operationText = e.getMessage();
            monitor.beginTask(operationText, 100);
            monitor.worked(0);
            monitor.setCanceled(true);
        } catch (DockerImageGenerationException e) {
            log.error(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE, e);
            showMessageBox(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE,
                    DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_MSG, SWT.ICON_ERROR);

            operationText = e.getMessage();
            monitor.beginTask(operationText, 100);
            monitor.worked(0);
            monitor.setCanceled(true);
        } catch (DockerConnectionException e) {
            log.error(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE, e);
            showMessageBox(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE,
                    DockerGenConstants.ErrorMessages.DOCKER_CONNECTION_FAIL_MSG, SWT.ICON_ERROR);

            operationText = e.getMessage();
            monitor.beginTask(operationText, 100);
            monitor.worked(0);
            monitor.setCanceled(true);
        }

        monitor.worked(100);
        monitor.done();
        
        FileUtils.deleteDir(new File(dockerDirectory));

        // Image generation successful
        if (null != generatedImageId) {
        	showSuccessNotification(generatedImageId, dockerModel.getName(), dockerModel.getTag());
        } else {
            showMessageBox(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE,
                    DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_MSG, SWT.ICON_ERROR);
        }

        return Status.OK_STATUS;
    }

    private void showSuccessNotification(String imageId, String imageName, String imageTag) {
    	
    	Display.getDefault().syncExec(new Runnable() {
            public void run() {
                Display display = PlatformUI.getWorkbench().getDisplay();
                final AbstractNotificationPopup popup = 
                        new ImageCreationSuccessNotificationPopUp(display, imageId, imageName, imageTag);
                popup.setFadingEnabled(false);
                popup.setDelayClose(0L);
                popup.open();
            }
        });
    }
    
    private void showMessageBox(String title, String message, int style) {

        Display.getDefault().syncExec(new Runnable() {
            public void run() {
                Display display = PlatformUI.getWorkbench().getDisplay();
                Shell shell = display.getActiveShell();

                MessageBox exportMsg = new MessageBox(shell, style);
                exportMsg.setText(title);
                exportMsg.setMessage(message);

                exportMsg.open();
            }
        });
    }

    public String getDockerDirectory() {
        return dockerDirectory;
    }

    public void setDockerDirectory(String dockerDirectory) {
        this.dockerDirectory = dockerDirectory;
    }

    public String getDeploymentDirectory() {
        return deploymentDirectory;
    }

    public void setDeploymentDirectory(String deploymentDirectory) {
        this.deploymentDirectory = deploymentDirectory;
    }

    public String getDestinationDirectory() {
        return destinationDirectory;
    }

    public void setDestinationDirectory(String destinationDirectory) {
        this.destinationDirectory = destinationDirectory;
    }

    public String getEiDistributionSource() {
        return eiDistributionSource;
    }

    public void setEiDistributionSource(String eiDistributionSource) {
        this.eiDistributionSource = eiDistributionSource;
    }

    public String getEiDistributionDestination() {
        return eiDistributionDestination;
    }

    public void setEiDistributionDestination(String eiDistributionDestination) {
        this.eiDistributionDestination = eiDistributionDestination;
    }

    public File getCarbonFile() {
        return carbonFile;
    }

    public void setCarbonFile(File carbonFile) {
        this.carbonFile = carbonFile;
    }

    public MicroIntegratorDockerModel getDockerModel() {
        return dockerModel;
    }

    public void setDockerModel(MicroIntegratorDockerModel dockerModel) {
        this.dockerModel = dockerModel;
    }

}
