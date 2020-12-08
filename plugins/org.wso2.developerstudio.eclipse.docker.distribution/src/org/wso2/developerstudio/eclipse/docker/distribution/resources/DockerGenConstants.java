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

package org.wso2.developerstudio.eclipse.docker.distribution.resources;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Constants related to Docker client operations.
 *
 */
public class DockerGenConstants {

    public static class ImageParamDefaults {
        public static final String EI_BASE_IMAGE = "adoptopenjdk/openjdk8";
        public static final String EI_BASE_IMAGE_VERSION = "jdk8u192-b12-alpine";
        public static final String REGISTRY_SEPARATOR = "/";
        public static final String TAG_SEPARATOR = ":";
        public static final String HYPHEN_SEPARATOR = "-";
        public static final String PORT = "port";
        public static final String ARTIFACT_DIRECTORY = "docker";
        public static final String UNIX_DEFAULT_DOCKER_HOST = "unix:///var/run/docker.sock";
        public static final String WINDOWS_DEFAULT_DOCKER_HOST = "npipe:////./pipe/docker_engine";
        public static final String EI_START_COMMAND = "[\"sh\", \"-c\", \"${MICROESB_HOME}/bin/"
                + "micro-integrator.sh\"]";
        public static final String DOCKER_FILE_HEADING = "# Auto Generated Dockerfile";
        public static final String DOCKER_FILE_MAINTAINERS = "maintainer=\"dev@wso2.org\"";
        public static final String DOCKER_FILE_NAME = "Dockerfile";
        public static final String INIT_FILE_PATH = "resources/init.sh";
        public static final String INIT_FILE_NAME = "init.sh";
        public static final Set<Integer> ports = new HashSet<>(Arrays.asList(8290, 8253));
    }

    public static class Tags {
        public static final String TAG_LATEST = "latest";
    }

    public static class OSTypes {
        public static final String OS_NAME = "os.name";
        public static final String WINDOWS = "win";
    }

    public static class DockerFileCommands {
        public static final String FROM = "FROM";
        public static final String LABEL = "LABEL";
        public static final String COPY = "COPY";
        public static final String EXPOSE = "EXPOSE";
        public static final String ENV = "ENV";
        public static final String CMD = "CMD";
        public static final String ARG = "ARG";
        public static final String USER = "USER";
        public static final String WORKDIR = "WORKDIR";
        public static final String RUN = "RUN";
        public static final String ENTRYPOINT = "ENTRYPOINT";
    }

    public static class EnvVariables {
        public static final String MICROESB_HOME = "MICROESB_HOME";
        public static final String USER = "USER=";
        public static final String USER_ID = "USER_ID=";
        public static final String USER_GROUP = "USER_GROUP=";
        public static final String USER_GROUP_ID = "USER_GROUP_ID=";
        public static final String USER_HOME = "USER_HOME=";
        public static final String FILES = "FILES=";
        public static final String WSO2_SERVER = "WSO2_SERVER=";
        public static final String WSO2_SERVER_VERSION = "WSO2_SERVER_VERSION=";
        public static final String WSO2_SERVER_PACK = "WSO2_SERVER_PACK=";
        public static final String WSO2_SERVER_HOME = "WSO2_SERVER_HOME=";
        public static final String ENV = "ENV=";
        public static final String USER_ID_VAR = "${USER_ID}";
        public static final String USER_HOME_VAR = "${USER_HOME}";
    }

    public static class CommandArgs {
        public static final String DEBUG = "--debug";
    }

    public static class ErrorMessages {
        public static final String DOCKER_IMAGE_FILE_CREATION_FAIL_TITLE = "Could not create the output file";
        public static final String DOCKER_CONNECTION_FAIL_MSG = "Could not connect to the docker server. "
                + "Make sure docker is running on your computer.";
        public static final String DOCKER_IMAGE_CREATION_FAILED_MSG = "Could not generate the docker image.";
        public static final String DOCKER_IMAGE_CREATION_FAILED_TITLE = "Error creating the Docker image";
        public static final String IMAGE_BUNDLE_CREATION_FAILED_MSG = "Could not create the Docker image bundle file.";
        public static final String DOCKER_IMAGE_CREATION_INTERNAL_ERROR_MSG = "Could not generate Docker image because of an internal error.";
    }

    public static class SuccessMessages {
        public static final String SUCCESSFUL_TITLE = "Successful";
        public static final String DOCKER_IMAGE_GEN_SUCCESS_MESSAGE = "Docker image successfully generated. \nName: ";
        public static final String DOCKER_IMAGE_ID_MESSAGE = "ID: ";
    }

    public static class DefaultArguments {
        public static final String USER = "wso2ei";
        public static final String USER_HOME = "/home/${USER}";
        public static final String USER_GROUP = "wso2";
        public static final String USER_ID = "802";
        public static final String USER_GROUP_ID = "802";
        public static final String FILES = ".";
        public static final String WSO2_SERVER = "wso2ei";
        public static final String WSO2_SERVER_VERSION = "7.0.0";
        public static final String WSO2_SERVER_PACK = "${WSO2_SERVER}-${WSO2_SERVER_VERSION}";
        public static final String WSO2_SERVER_HOME = "${USER_HOME}/${WSO2_SERVER_PACK}";
        public static final String ENV_VARIABLES_CMD = "WSO2_SERVER_HOME=${WSO2_SERVER_HOME} \\\n"
                + "    WORKING_DIRECTORY=${USER_HOME}";
        public static final String ENV = "${USER_HOME}\"/.ashrc\"";
        public static final String ENTRY_POINT_COMMAND = "[\"/home/wso2ei/init.sh\"]";
    }

    public static class RunCommands {
        public static final String INSTALL_REQUIRED_PACKAGES_CMD = "apk add --update --no-cache \\\n" + "    curl \\\n"
                + "    netcat-openbsd && \\\n" + "    rm -rf /var/cache/apk/*";
        public static final String ADD_USER_GROUP_CMD = "addgroup -g ${USER_GROUP_ID} ${USER_GROUP}; \\\n"
                + "     adduser -u ${USER_ID} -D -g '' -h ${USER_HOME} -G ${USER_GROUP} ${USER} ;";
        public static final String PRINT_MOTD_CMD = "echo $MOTD > \"$ENV\"";
        public static final String CHMOD_INIT_FILE_CMD = "chmod +x ${USER_HOME}/init.sh";
    }

    public static class CopyCommands {
        public static final String COPY_SERVER_PACK_CMD = "--chown=wso2ei:wso2 ${FILES}/${WSO2_SERVER_PACK} ${WSO2_SERVER_HOME}";
        public static final String COPY_INIT_FILE_CMD = "--chown=wso2ei:wso2 init.sh ${USER_HOME}/";
    }

}
