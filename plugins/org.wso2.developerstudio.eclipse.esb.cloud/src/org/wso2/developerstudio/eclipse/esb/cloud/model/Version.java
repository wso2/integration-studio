package org.wso2.developerstudio.eclipse.esb.cloud.model;

public class Version {
    private String deploymentPrivateURL;
    private String deploymentURL;
    private String versionId;
    private String versionName;
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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Version other = (Version) obj;
        if (deploymentPrivateURL == null) {
            if (other.deploymentPrivateURL != null)
                return false;
        } else if (!deploymentPrivateURL.equals(other.deploymentPrivateURL))
            return false;
        if (deploymentURL == null) {
            if (other.deploymentURL != null)
                return false;
        } else if (!deploymentURL.equals(other.deploymentURL))
            return false;
        if (versionId == null) {
            if (other.versionId != null)
                return false;
        } else if (!versionId.equals(other.versionId))
            return false;
        if (versionName == null) {
            if (other.versionName != null)
                return false;
        } else if (!versionName.equals(other.versionName))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Version [deploymentPrivateURL=" + deploymentPrivateURL + ", deploymentURL=" + deploymentURL
                + ", versionId=" + versionId + ", versionName=" + versionName + "]";
    }
    
    
    
}
