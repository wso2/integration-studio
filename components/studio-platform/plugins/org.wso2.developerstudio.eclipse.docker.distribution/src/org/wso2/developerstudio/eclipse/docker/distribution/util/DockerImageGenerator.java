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

package org.wso2.developerstudio.eclipse.docker.distribution.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;

import javax.ws.rs.ext.RuntimeDelegate;

import org.glassfish.jersey.internal.RuntimeDelegateImpl;
import org.wso2.developerstudio.eclipse.docker.distribution.Activator;
import org.wso2.developerstudio.eclipse.docker.distribution.exceptions.DockerConnectionException;
import org.wso2.developerstudio.eclipse.docker.distribution.exceptions.DockerImageGenerationException;
import org.wso2.developerstudio.eclipse.docker.distribution.model.MicroIntegratorDockerModel;
import org.wso2.developerstudio.eclipse.docker.distribution.resources.DockerGenConstants;
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
    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";
    private static final String TAG_LATEST = "latest";

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
                + DockerGenConstants.DockerFileCommands.FROM + SPACE + dockerModel.getBaseImage() + "\n"
                + DockerGenConstants.DockerFileCommands.LABEL + " "
                + DockerGenConstants.ImageParamDefaults.DOCKER_FILE_MAINTAINERS + "\n\n";

        StringBuilder stringBuilder = new StringBuilder(dockerBase);

        // Set ARG variables
        // User variables
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ARG).append(SPACE)
                .append(DockerGenConstants.EnvVariables.USER).append(DockerGenConstants.DefaultArguments.USER)
                .append("\n");
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ARG).append(SPACE)
                .append(DockerGenConstants.EnvVariables.USER_ID).append(DockerGenConstants.DefaultArguments.USER_ID)
                .append("\n");
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ARG).append(SPACE)
                .append(DockerGenConstants.EnvVariables.USER_GROUP)
                .append(DockerGenConstants.DefaultArguments.USER_GROUP).append("\n");
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ARG).append(SPACE)
                .append(DockerGenConstants.EnvVariables.USER_GROUP_ID)
                .append(DockerGenConstants.DefaultArguments.USER_GROUP_ID).append("\n");
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ARG).append(SPACE)
                .append(DockerGenConstants.EnvVariables.USER_HOME).append(DockerGenConstants.DefaultArguments.USER_HOME)
                .append("\n");

        // Files directory
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ARG).append(SPACE)
                .append(DockerGenConstants.EnvVariables.FILES).append(DockerGenConstants.DefaultArguments.FILES)
                .append("\n");

        // Server variables
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ARG).append(SPACE)
                .append(DockerGenConstants.EnvVariables.WSO2_SERVER)
                .append(DockerGenConstants.DefaultArguments.WSO2_SERVER).append("\n");
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ARG).append(SPACE)
                .append(DockerGenConstants.EnvVariables.WSO2_SERVER_VERSION)
                .append(DockerGenConstants.DefaultArguments.WSO2_SERVER_VERSION).append("\n");
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ARG).append(SPACE)
                .append(DockerGenConstants.EnvVariables.WSO2_SERVER_PACK)
                .append(DockerGenConstants.DefaultArguments.WSO2_SERVER_PACK).append("\n");
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ARG).append(SPACE)
                .append(DockerGenConstants.EnvVariables.WSO2_SERVER_HOME)
                .append(DockerGenConstants.DefaultArguments.WSO2_SERVER_HOME).append("\n");

        stringBuilder.append(DockerGenConstants.DockerFileCommands.ENV).append(SPACE)
                .append(DockerGenConstants.EnvVariables.ENV).append(DockerGenConstants.DefaultArguments.ENV)
                .append("\n\n");

        // Run commands
        stringBuilder.append(DockerGenConstants.DockerFileCommands.RUN).append(SPACE)
                .append(DockerGenConstants.RunCommands.INSTALL_REQUIRED_PACKAGES_CMD).append("\n\n");
        stringBuilder.append(DockerGenConstants.DockerFileCommands.RUN).append(SPACE)
                .append(DockerGenConstants.RunCommands.ADD_USER_GROUP_CMD).append("\n\n");

        // Copy commands
        stringBuilder.append(DockerGenConstants.DockerFileCommands.COPY).append(SPACE)
                .append(DockerGenConstants.CopyCommands.COPY_SERVER_PACK_CMD).append("\n");
        stringBuilder.append(DockerGenConstants.DockerFileCommands.COPY).append(SPACE)
                .append(DockerGenConstants.CopyCommands.COPY_INIT_FILE_CMD).append("\n");

        dockerModel.getExternalFiles().forEach(file -> {
            // Extract the source filename relative to docker folder.
            String sourceFileName = String.valueOf(Paths.get(file.getSource()).getFileName());
            stringBuilder.append(DockerGenConstants.DockerFileCommands.COPY).append(SPACE).append(sourceFileName)
                    .append(SPACE).append(file.getDestination()).append("\n");
        });
        stringBuilder.append("\n");

        // Change permission of the init script
        stringBuilder.append(DockerGenConstants.DockerFileCommands.RUN).append(SPACE)
                .append(DockerGenConstants.RunCommands.CHMOD_INIT_FILE_CMD).append("\n\n");

        // Set user and work directory
        stringBuilder.append(DockerGenConstants.DockerFileCommands.USER).append(SPACE)
                .append(DockerGenConstants.EnvVariables.USER_ID_VAR).append("\n");
        stringBuilder.append(DockerGenConstants.DockerFileCommands.WORKDIR).append(SPACE)
                .append(DockerGenConstants.EnvVariables.USER_HOME_VAR).append("\n\n");

        // Set server environment variables
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ENV).append(SPACE)
                .append(DockerGenConstants.DefaultArguments.ENV_VARIABLES_CMD).append("\n\n");

        // Expose ports
        if (dockerModel.getPorts().size() > 0) {
            stringBuilder.append(DockerGenConstants.DockerFileCommands.EXPOSE);
            dockerModel.getPorts().forEach(port -> stringBuilder.append(SPACE).append(port));
            stringBuilder.append("\n\n");
        }

        if (dockerModel.isEnableDebug()) {
            stringBuilder.append(SPACE).append(DockerGenConstants.CommandArgs.DEBUG).append(SPACE)
                    .append(dockerModel.getDebugPort()).append("\n\n");
        }

        // Set entry point
        stringBuilder.append(DockerGenConstants.DockerFileCommands.ENTRYPOINT).append(SPACE)
                .append(DockerGenConstants.DefaultArguments.ENTRY_POINT_COMMAND);

        return stringBuilder.toString();
    }

    /**
     * Generates the Docker image and bundles into a given location as a tarball.
     * 
     * @param dockerDirectory Directory which contains the Dockerfile.
     * @param outputDir Destination directory.
     * @throws IOException I/O Exception.
     * @throws DockerImageGenerationException Docker image generation exception.
     * @throws InterruptedException Interrupted exception.
     * @throws DockerConnectionException Docker connection exception.
     */
    public String generateDockerImage(String dockerDirectory, String outputDir)
            throws IOException, InterruptedException, DockerImageGenerationException, DockerConnectionException {
        // Write docker file
        String dockerFileContent = generateDockerFileContent();
        DockerGeneratorUtils.getInstance().writeToFile(dockerFileContent,
                dockerDirectory + File.separator + DockerGenConstants.ImageParamDefaults.DOCKER_FILE_NAME);

        return buildImage(dockerModel, dockerDirectory, outputDir);

    }

    /**
     * Builds the Docker image based on a given Docker model.
     * 
     * @param dockerModel The docker model instance.
     * @param dockerDir Directory containing the Dockerfile.
     * @param outputDirectory Destination directory.
     * 
     * @return Generated image's ID.
     * 
     * @throws InterruptedException Thread Interrupted Exception.
     * @throws IOException I/O Exception.
     * @throws DockerConnectionException Docker connection exception.
     * @throws DockerImageGenerationException Docker image generation Exception.
     */
    private String buildImage(MicroIntegratorDockerModel dockerModel, String dockerDir, String outputDirectory)
            throws InterruptedException, IOException, DockerImageGenerationException, DockerConnectionException {

        // Creating the docker client instance
        DockerClient docker = DefaultDockerClient.builder().uri(dockerModel.getDockerHost()).build();

        // Test connection to Docker server
        try {
            docker.ping();
        } catch (DockerException e1) {
            log.error(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_CREATION_FAILED_TITLE, e1);
            throw new DockerConnectionException(DockerGenConstants.ErrorMessages.DOCKER_CONNECTION_FAIL_MSG, e1);
        }

        // Atomic reference to store the generated docker image ID
        final AtomicReference<String> imageIdFromMessage = new AtomicReference<>();
        String returnedImageId = EMPTY_STRING;

        String imageNameWithTag = EMPTY_STRING;

		if (dockerModel.getTag() != null && !dockerModel.getTag().equals(EMPTY_STRING)) {
			imageNameWithTag = dockerModel.getName() + 
					DockerGenConstants.ImageParamDefaults.TAG_SEPARATOR + dockerModel.getTag();
		} else {
			imageNameWithTag = dockerModel.getName() + 
					DockerGenConstants.ImageParamDefaults.TAG_SEPARATOR + TAG_LATEST;
		}

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

                        // Bundle the image
                        try {
                            bundleImage(docker, imageId, outputDirectory);
                        } catch (Exception e) {
                            log.error(DockerGenConstants.ErrorMessages.IMAGE_BUNDLE_CREATION_FAILED_MSG, e);
                            throw new DockerImageGenerationException(
                                    DockerGenConstants.ErrorMessages.IMAGE_BUNDLE_CREATION_FAILED_MSG, e);
                        }
                    }

                }
            }, DockerClient.BuildParam.noCache(), DockerClient.BuildParam.forceRm());
        } catch (DockerException e2) {
            log.error(DockerGenConstants.ErrorMessages.IMAGE_BUNDLE_CREATION_FAILED_MSG, e2);
            throw new DockerImageGenerationException(DockerGenConstants.ErrorMessages.IMAGE_BUNDLE_CREATION_FAILED_MSG,
                    e2);
        }

        return returnedImageId;
    }

    private void bundleImage(DockerClient docker, String imageId, String outputDirectory)
            throws IOException, InterruptedException, DockerException {
        final File destinationDirectory = new File(outputDirectory);

        String tarFileName = EMPTY_STRING;

        if (dockerModel.getTag() != null || !dockerModel.getTag().equals(EMPTY_STRING)) {
            tarFileName = dockerModel.getName() + DockerGenConstants.ImageParamDefaults.HYPHEN_SEPARATOR
                    + dockerModel.getTag();
        } else {
            tarFileName = dockerModel.getName();
        }

        final File imageFile = new File(destinationDirectory, tarFileName + FILE_POSTFIX_TAR);

        imageFile.createNewFile();
        final byte[] buffer = new byte[2048];
        int read;

        try (OutputStream imageOutput = new BufferedOutputStream(new FileOutputStream(imageFile))) {
            // pull the image from the local registry and write to a file
            try (InputStream imageInput = docker.save(imageId)) {
                while ((read = imageInput.read(buffer)) > -1) {
                    imageOutput.write(buffer, 0, read);
                }
            } catch (DockerException e) {
                log.error(DockerGenConstants.ErrorMessages.DOCKER_IMAGE_FILE_CREATION_FAIL_TITLE, e);
                throw new DockerImageGenerationException(
                        DockerGenConstants.ErrorMessages.DOCKER_IMAGE_FILE_CREATION_FAIL_TITLE, e);
            } finally {
                imageOutput.close();
            }
        }
    }

    public MicroIntegratorDockerModel getDockerModel() {
        return dockerModel;
    }

    public void setDockerModel(MicroIntegratorDockerModel dockerModel) {
        this.dockerModel = dockerModel;
    }

}
