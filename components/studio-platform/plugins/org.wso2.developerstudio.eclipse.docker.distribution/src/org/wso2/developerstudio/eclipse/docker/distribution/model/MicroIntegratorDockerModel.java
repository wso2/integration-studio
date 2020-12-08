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

package org.wso2.developerstudio.eclipse.docker.distribution.model;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.wso2.developerstudio.eclipse.docker.distribution.resources.DockerGenConstants;

/**
 * Represents a Docker model for image generation.
 *
 */
public class MicroIntegratorDockerModel {

    private String name;
    private String registry;
    private String tag;
    private boolean push;
    private String username;
    private String password;
    private boolean buildImage;
    private String baseImage;
    private Set<Integer> ports;
    private boolean enableDebug;
    private int debugPort;
    private String dockerHost;
    private String dockerCertPath;
    private String serverHome;
    private Set<CopyFileModel> externalFiles;
    private String commandArg;

    public MicroIntegratorDockerModel() {
        init();
    }

    /**
     * Initialize with default values.
     */
    private void init() {

        // Detect the operating system
        String operatingSystem = System.getProperty(DockerGenConstants.OSTypes.OS_NAME)
                .toLowerCase(Locale.getDefault());

        // Set default docker host based on the Operating System
        if (operatingSystem.contains(DockerGenConstants.OSTypes.WINDOWS)) {
            this.dockerHost = DockerGenConstants.ImageParamDefaults.WINDOWS_DEFAULT_DOCKER_HOST;
        } else {
            this.dockerHost = DockerGenConstants.ImageParamDefaults.UNIX_DEFAULT_DOCKER_HOST;
        }

        this.tag = DockerGenConstants.Tags.TAG_LATEST;
        this.baseImage = DockerGenConstants.ImageParamDefaults.EI_BASE_IMAGE
                + DockerGenConstants.ImageParamDefaults.TAG_SEPARATOR
                + DockerGenConstants.ImageParamDefaults.EI_BASE_IMAGE_VERSION;
        this.debugPort = 5005;

        this.push = false;
        this.buildImage = true;
        this.enableDebug = false;

        externalFiles = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isPush() {
        return push;
    }

    public void setPush(boolean push) {
        this.push = push;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBuildImage() {
        return buildImage;
    }

    public void setBuildImage(boolean buildImage) {
        this.buildImage = buildImage;
    }

    public String getBaseImage() {
        return baseImage;
    }

    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    public Set<Integer> getPorts() {
        return ports;
    }

    public void setPorts(Set<Integer> ports) {
        this.ports = ports;
    }

    public boolean isEnableDebug() {
        return enableDebug;
    }

    public void setEnableDebug(boolean enableDebug) {
        this.enableDebug = enableDebug;
    }

    public int getDebugPort() {
        return debugPort;
    }

    public void setDebugPort(int debugPort) {
        this.debugPort = debugPort;
    }

    public String getDockerHost() {
        return dockerHost;
    }

    public void setDockerHost(String dockerHost) {
        this.dockerHost = dockerHost;
    }

    public String getDockerCertPath() {
        return dockerCertPath;
    }

    public void setDockerCertPath(String dockerCertPath) {
        this.dockerCertPath = dockerCertPath;
    }

    public String getCommandArg() {
        return commandArg;
    }

    public void setCommandArg(String commandArg) {
        this.commandArg = commandArg;
    }

    public Set<CopyFileModel> getExternalFiles() {
        return externalFiles;
    }

    public void setExternalFiles(Set<CopyFileModel> externalFiles) {
        this.externalFiles = externalFiles;
    }

    public String getServerHome() {
        return serverHome;
    }

    public void setServerHome(String serverHome) {
        this.serverHome = serverHome;
    }

    @Override
    public String toString() {
        return "DockerModel{" + "name='" + name + '\'' + ", registry='" + registry + '\'' + ", tag='" + tag + '\''
                + ", push=" + push + ", username='" + username + '\'' + ", password='" + password + '\''
                + ", buildImage" + "=" + buildImage + ", baseImage='" + baseImage + '\'' + ", ports=" + ports
                + ", enableDebug=" + enableDebug + ", debugPort=" + debugPort + ", dockerHost='" + dockerHost + '\''
                + ", dockerCertPath='" + dockerCertPath + '\'' + ", externalFiles=" + externalFiles + ", serverHome="
                + serverHome + ", commandArg='" + commandArg + '\'' + '}';
    }

}
