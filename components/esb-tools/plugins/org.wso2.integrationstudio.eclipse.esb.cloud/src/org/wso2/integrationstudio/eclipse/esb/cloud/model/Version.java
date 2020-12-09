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

package org.wso2.integrationstudio.eclipse.esb.cloud.model;

/**
 * Represents an application version
 * 
 */
public class Version {
    private String deploymentPrivateURL;
    private String deploymentURL;
    private String versionId;
    private String versionName;
    private int runtimeId;

    public String getDeploymentPrivateURL() {
        return deploymentPrivateURL;
    }

    public void setDeploymentPrivateURL(String deploymentPrivateURL) {
        this.deploymentPrivateURL = deploymentPrivateURL;
    }

    public String getDeploymentURL() {
        return deploymentURL;
    }

    public void setDeploymentURL(String deploymentURL) {
        this.deploymentURL = deploymentURL;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public int getRuntimeId() {
        return runtimeId;
    }

    public void setRuntimeName(int runtimeId) {
        this.runtimeId = runtimeId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((deploymentPrivateURL == null) ? 0 : deploymentPrivateURL.hashCode());
        result = prime * result + ((deploymentURL == null) ? 0 : deploymentURL.hashCode());
        result = prime * result + ((versionId == null) ? 0 : versionId.hashCode());
        result = prime * result + ((versionName == null) ? 0 : versionName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Version other = (Version) obj;
        if (deploymentPrivateURL == null) {
            if (other.deploymentPrivateURL != null) {
                return false;
            }
        } else if (!deploymentPrivateURL.equals(other.deploymentPrivateURL)) {
            return false;
        }
        if (deploymentURL == null) {
            if (other.deploymentURL != null) {
                return false;
            }
        } else if (!deploymentURL.equals(other.deploymentURL)) {
            return false;
        }
        if (versionId == null) {
            if (other.versionId != null) {
                return false;
            }
        } else if (!versionId.equals(other.versionId)) {
            return false;
        }
        if (versionName == null) {
            if (other.versionName != null) {
                return false;
            }
        } else if (!versionName.equals(other.versionName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Version [deploymentPrivateURL=" + deploymentPrivateURL + ", deploymentURL=" + deploymentURL
                + ", versionId=" + versionId + ", versionName=" + versionName + "]";
    }

}
