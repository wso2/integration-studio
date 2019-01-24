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

package org.wso2.developerstudio.eclipse.esb.docker.resources;

public class DockerGenConstants {
    
    public class ImageParamDefaults {
        public static final String EI_BASE_IMAGE = "openjdk";
        public static final String EI_BASE_IMAGE_VERSION = "8-jre-alpine";
        public static final String REGISTRY_SEPARATOR = "/";
        public static final String TAG_SEPARATOR = ":";
        public static final String PORT = "port";
        public static final String ARTIFACT_DIRECTORY = "docker";
        public static final String UNIX_DEFAULT_DOCKER_HOST = "unix:///var/run/docker.sock";
        public static final String WINDOWS_DEFAULT_DOCKER_HOST = "tcp://localhost:2375";
        public static final String EI_START_COMMAND = "[\"sh\", \"-c\", \"${MICROESB_HOME}/bin/micro-integrator.sh\"]";
        public static final String DOCKER_FILE_HEADING = "# Auto Generated Dockerfile";
        public static final String DOCKER_FILE_MAINTAINERS = "maintainer=\"dev@wso2.org\"";
        public static final String DOCKER_FILE_NAME = "Dockerfile";
    }
    
    public class Tags {
        public static final String TAG_LATEST = "latest";
    }
    
    public class OSTypes {
        public static final String OS_NAME = "os.name";
        public static final String WINDOWS = "win";
    }
    
    public class DockerFileCommands {
        public static final String FROM = "FROM";
        public static final String LABEL = "LABEL";
        public static final String COPY = "COPY";
        public static final String EXPOSE = "EXPOSE";
        public static final String ENV = "ENV";
        public static final String CMD = "CMD";
    }
    
    public class EnvVariables {
        public static final String MICROESB_HOME = "MICROESB_HOME";
    }
    
    public class CommandArgs {
        public static final String DEBUG = "--debug";
    }

}
