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

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicReference;

import javax.ws.rs.ext.RuntimeDelegate;

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


public class DockerImageGenerator {

    private MicroIntegratorDockerModel dockerModel;
    // private DockerClient dockerClient;

    private static final String STRING_SPACE = " ";

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    public DockerImageGenerator(MicroIntegratorDockerModel dockerModel) {
        init();
        this.dockerModel = dockerModel;
        if (dockerModel.getDockerCertPath() != null && !"".equals(dockerModel.getDockerCertPath())) {
            System.setProperty("docker.cert.path", dockerModel.getDockerCertPath());
        }
    }

    private void init() {
        // createDockerClient();
    }

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

    public void generateDockerImage(String outputDir) throws IOException {
        // Write docker file
        String dockerFileContent = generateDockerFileContent();
        DockerGeneratorUtils.getInstance().writeToFile(dockerFileContent,
                outputDir + File.separator + DockerGenConstants.ImageParamDefaults.DOCKER_FILE_NAME);
        
        try {
            buildImage(dockerModel, outputDir);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void buildImage(MicroIntegratorDockerModel dockerModel, String dockerDir) throws InterruptedException, IOException {

        RuntimeDelegate.setInstance(new RuntimeDelegateImpl());
        
        DockerClient docker = DefaultDockerClient.builder().uri("unix:///var/run/docker.sock").build();
        System.out.println("#########################");
        
//        final DockerClient docker = DefaultDockerClient.fromEnv().build();

        String path = "/Applications/Eclipse.app/Contents/MacOS/dockerTempDir";
        

        final AtomicReference<String> imageIdFromMessage = new AtomicReference<>();

        try {
            final String returnedImageId = docker.build(
                    Paths.get(path), "dileesha", new ProgressHandler() {
                        @Override
                        public void progress(ProgressMessage message) throws DockerException {
                            final String imageId = message.buildImageId();
                            if (imageId != null) {
                                imageIdFromMessage.set(imageId);
                            }
                        }
                    });
            final String pingResponse = docker.ping();
            
            System.out.println("############ : " + returnedImageId);
        } catch (DockerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createDockerClient() {
        // Create Docker client
//        dockerClient = DefaultDockerClient.builder().uri(dockerModel.getDockerHost()).build();
    }

}
