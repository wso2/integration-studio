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

package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model;

import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.constant.Constants;

/**
 * Class responsible handle CommonArtifactDataNode data for Dependency tree
 * data.
 */
public class CommonArtifactDataNode {
    private boolean hasChildren;
    private IProject project;
    private Map.Entry<IPath, String> artifact;
    private Map.Entry<String, RegistryResource> registryResource;
    private boolean isRegistryDataNode = false;
    private boolean isConnectorDataNode = false;

    @SuppressWarnings("unchecked")
    public CommonArtifactDataNode(Object object) {
        if (object instanceof Map.Entry<?, ?>) {
            if (isRegistryDataNode()) {
                registryResource = (Map.Entry<String, RegistryResource>) object;
            } else {
                artifact = (Map.Entry<IPath, String>) object;
            }
        } else if (object instanceof IProject) {
            project = (IProject) object;
            setHasChildren(true);
        }
    }

    @SuppressWarnings("unchecked")
    public CommonArtifactDataNode(Object object, String isRegistryOrConnector) {
        if (isRegistryOrConnector.equals(Constants.REGISTRY_PROJECT)) {
            registryResource = (Map.Entry<String, RegistryResource>) object;
            setRegistryDataNode(true);
        } else if (isRegistryOrConnector.equals(Constants.CONNECTOR_PROJECT)) {
            artifact = (Map.Entry<IPath, String>) object;
            setConnectorDataNode(true);
        }
    }

    public boolean hasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public IProject getProject() {
        return project;
    }

    public void setProject(IProject project) {
        this.project = project;
    }

    public Map.Entry<IPath, String> getArtifact() {
        return artifact;
    }

    public Map.Entry<String, RegistryResource> getRegistryDataNode() {
        return registryResource;
    }

    public void setArtifact(Map.Entry<IPath, String> artifact) {
        this.artifact = artifact;
    }

    public boolean isRegistryDataNode() {
        return isRegistryDataNode;
    }

    public void setRegistryDataNode(boolean isRegistryDataNode) {
        this.isRegistryDataNode = isRegistryDataNode;
    }

    public boolean isConnectorDataNode() {
        return isConnectorDataNode;
    }

    public void setConnectorDataNode(boolean isConnectorDataNode) {
        this.isConnectorDataNode = isConnectorDataNode;
    }
}
