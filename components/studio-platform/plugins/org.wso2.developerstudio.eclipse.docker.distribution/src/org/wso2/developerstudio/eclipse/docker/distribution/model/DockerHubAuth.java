/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.docker.distribution.model;

public class DockerHubAuth {
    private boolean isKubernetesProject = false;
    private boolean isDockerRegistry = true;
    private String remoteRegistryURL;
    private String authUsername;
    private String authPassword;

    public boolean isKubernetesProject() {
        return isKubernetesProject;
    }

    public void setKubernetesProject(boolean isKubernetesProject) {
        this.isKubernetesProject = isKubernetesProject;
    }
    
    public String getAuthUsername() {
        return authUsername;
    }

    public void setAuthUsername(String authUsername) {
        this.authUsername = authUsername;
    }

    public String getAuthPassword() {
        return authPassword;
    }

    public void setAuthPassword(String authPassword) {
        this.authPassword = authPassword;
    }

    public boolean isDockerRegistry() {
        return isDockerRegistry;
    }

    public void setDockerRegistry(boolean isDockerRegistry) {
        this.isDockerRegistry = isDockerRegistry;
    }

    public String getRemoteRegistryURL() {
        return remoteRegistryURL;
    }

    public void setRemoteRegistryURL(String remoteRegistryURL) {
        this.remoteRegistryURL = remoteRegistryURL;
    }
}
