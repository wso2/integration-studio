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

package org.wso2.developerstudio.eclipse.esb.docker.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;

import javax.ws.rs.ext.RuntimeDelegate;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.glassfish.jersey.internal.RuntimeDelegateImpl;
import org.wso2.developerstudio.eclipse.esb.docker.Activator;
import org.wso2.developerstudio.eclipse.esb.docker.model.MicroIntegratorDockerModel;
import org.wso2.developerstudio.eclipse.esb.docker.resources.DockerGenConstants;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.ProgressHandler;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.ProgressMessage;

/**
 * This class contains the Docker image generation logic.
 *
 */
public class DockerImageGenerator {

    private MicroIntegratorDockerModel dockerModel;

    private static final String FILE_POSTFIX_TAR = ".tar";
    private static final String SUCCESS_MESSAGE = "OK";
    private static final String STRING_SPACE = " ";
    private static final String EMPTY_STRING = "";

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public DockerImageGenerator(MicroIntegratorDockerModel dockerModel) {
        // Setting the runtime delegate
        RuntimeDelegate.setInstance(new RuntimeDelegateImpl());

        this.dockerModel = dockerModel;

        // Setting the Docker certificate path if available
        if (dockerModel.getDockerCertPath() != null && !"".equals(dockerModel.getDockerCertPath())) {
            System.setProperty("docker.cert.path", dockerModel.getDockerCertPath());
        }
    }

    /**
     * Generates the Dockerfile content.
     * 
     * @return Dockerfile content as a string.
     */
    public String generateDockerFileContent() {
        String dockerBase = DockerGenConstants.ImageParamDefaults.DOCKER_FILE_HEADING + "\n\n"
                + DockerGenConstants.DockerFileCommands.FROM + STRING_SPACE + dockerModel.getBaseImage() + "\n"
                + DockerGenConstants.DockerFileCommands.LABEL + " "
                + DockerGenConstants.ImageParamDefaults.DOCKER_FILE_MAINTAINERS + "\n\n";

        StringBuilder stringBuilder = new StringBuilder(dockerBase);

        dockerModel.getExternalFiles().forEach(file -> {
            // Extract the source filename relative to docker folder.
            String sourceFileName = String.valueOf(Paths.get(file.getSource()).getFileName());
            stringBuilder.append(DockerGenConstants.DockerFileCommands.COPY).append(STRING_SPACE).append(sourceFileName)
                    .append(STRING_SPACE).append(file.getDestination()).append("\n");
        });

        stringBuilder.append(DockerGenConstants.DockerFileCommands.ENV).append(STRING_SPACE)
                .append(DockerGenConstants.EnvVariables.MICROESB_HOME).append(STRING_SPACE)
                .append(dockerModel.getServerHome()).append("\n\n");

        if (dockerModel.getPorts().size() > 0) {
            stringBuilder.append(DockerGenConstants.DockerFileCommands.EXPOSE);
            dockerModel.getPorts().forEach(port -> stringBuilder.append(STRING_SPACE).append(port));
            stringBuilder.append("\n\n");
        }

        stringBuilder.append(DockerGenConstants.DockerFileCommands.CMD).append(STRING_SPACE)
                .append(dockerModel.getCommandArg()).append("\n");

        if (dockerModel.isEnableDebug()) {
            stringBuilder.append(STRING_SPACE).append(DockerGenConstants.CommandArgs.DEBUG).append(STRING_SPACE)
                    .append(dockerModel.getDebugPort());
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    /**
     * Generates the Docker image and bundles into a given location as a tarball.
     * 
     * @param dockerDirectory Directory which contains the Dockerfile.
     * @param outputDir Destination directory.
     * @throws IOException I/O Exception.
     */
    public void generateDockerImage(String dockerDirectory, String outputDir) throws IOException {
        // Write docker file
        String dockerFileContent = generateDockerFileContent();
        DockerGeneratorUtils.getInstance().writeToFile(dockerFileContent,
                dockerDirectory + File.separator + DockerGenConstants.ImageParamDefaults.DOCKER_FILE_NAME);

        try {
            buildImage(dockerModel, dockerDirectory, outputDir);
        } catch (InterruptedException | DockerException e) {
            showMessageBox(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE,
                    DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_MSG, SWT.ICON_ERROR);
        }

    }

    /**
     * Builds the Docker image based on a given Docker model.
     * 
     * @param dockerModel The docker model instance.
     * @param dockerDir Directory containing the Dockerfile.
     * @param outputDirectory Destination directory.
     * 
     * @throws InterruptedException Thread Interrupted Exception.
     * @throws IOException I/O Exception.
     * @throws DockerException Docker Exception.
     */
    private void buildImage(MicroIntegratorDockerModel dockerModel, String dockerDir, String outputDirectory)
            throws InterruptedException, IOException, DockerException {

        // Creating the docker client instance
        DockerClient docker = DefaultDockerClient.builder().uri(dockerModel.getDockerHost()).build();
        
        try {
            // Check if the docker daemon is running
            final String pingResponse = docker.ping();
        } catch (DockerException e) {
            String msg = DockerGenConstants.ErrorMessages.DOCKER_CONNECTION_FAIL_MSG;
            log.error(msg, e);
            showMessageBox(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE, msg, SWT.ICON_ERROR);
            
            return;
        }

        // Atomic reference to store the generated docker image ID
        final AtomicReference<String> imageIdFromMessage = new AtomicReference<>();
        String returnedImageId = EMPTY_STRING;

        String imageNameWithTag = dockerModel.getName() + DockerGenConstants.ImageParamDefaults.TAG_SEPARATOR
                + dockerModel.getTag();

        try {
            // build the image
            returnedImageId = docker.build(Paths.get(dockerDir), imageNameWithTag, new ProgressHandler() {
                @Override
                public void progress(ProgressMessage message) throws DockerException {
                    final String imageId = message.buildImageId();

                    // Image creation successful
                    if (imageId != null) {
                        log.info(DockerGenConstants.SuccessMessages.DOCKER_IMAGE_GEN_SUCCESS_MESSAGE + imageId);
                        imageIdFromMessage.set(imageId);
                    }

                }
            });
        } catch (DockerException e) {
            String msg = DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE;
            log.info(msg, e);
            throw new DockerException(msg, e);
        }

        final File destinationDirectory = new File(outputDirectory);
        String tarFileName = dockerModel.getName() + DockerGenConstants.ImageParamDefaults.HYPHEN_SEPARATOR
                + dockerModel.getTag();
        final File imageFile = new File(destinationDirectory, tarFileName + FILE_POSTFIX_TAR);

        imageFile.createNewFile();
        imageFile.deleteOnExit();
        final byte[] buffer = new byte[2048];
        int read;

        try (OutputStream imageOutput = new BufferedOutputStream(new FileOutputStream(imageFile))) {
            // pull the image from the local registry and write to a file
            try (InputStream imageInput = docker.save(imageNameWithTag)) {
                while ((read = imageInput.read(buffer)) > -1) {
                    imageOutput.write(buffer, 0, read);
                }

                showMessageBox(DockerGenConstants.SuccessMessages.SUCCESSFUL_TITLE,
                        DockerGenConstants.SuccessMessages.DOCKER_IMAGE_GEN_SUCCESS_MESSAGE + returnedImageId,
                        SWT.ICON_INFORMATION);

            } catch (DockerException e) {
                log.error(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_FILE_CREATION_FAIL_TITLE, e);

                showMessageBox(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE,
                        DockerGenConstants.ErrorMessages.DOCKER_IMAGE_FILE_CREATION_FAIL_TITLE, SWT.ICON_ERROR);
            }
        }

    }

    private void showMessageBox(String title, String message, int style) {

        new Thread(new Runnable() {
            public void run() {
                Display.getDefault().asyncExec(new Runnable() {
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
        }).start();
    }

    public MicroIntegratorDockerModel getDockerModel() {
        return dockerModel;
    }

    public void setDockerModel(MicroIntegratorDockerModel dockerModel) {
        this.dockerModel = dockerModel;
    }

}
