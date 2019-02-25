package org.wso2.developerstudio.eclipse.esb.cloud.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    
    private String applicationName;
    private String applicationType;
    private String applicationDescription;
    private List<Map<String, String>> tags = new ArrayList<>();
    
    private String defaultURL;
    private Map<String, Version> versions;
    
    public String getApplicationName() {
        return applicationName;
    }
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
    public String getApplicationType() {
        return applicationType;
    }
    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }
    public String getDefaultURL() {
        return defaultURL;
    }
    public void setDefaultURL(String defaultURL) {
        this.defaultURL = defaultURL;
    }
    public Map<String, Version> getVersions() {
        return versions;
    }
    public void setVersions(Map<String, Version> versions) {
        this.versions = versions;
    }
    
    public String getApplicationDescription() {
        return applicationDescription;
    }
    public void setApplicationDescription(String applicationDescription) {
        this.applicationDescription = applicationDescription;
    }
    public List<Map<String, String>> getTags() {
        return tags;
    }
    public void setTags(List<Map<String, String>> tags) {
        this.tags = tags;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((applicationName == null) ? 0 : applicationName.hashCode());
        result = prime * result + ((applicationType == null) ? 0 : applicationType.hashCode());
        result = prime * result + ((defaultURL == null) ? 0 : defaultURL.hashCode());
        result = prime * result + ((versions == null) ? 0 : versions.hashCode());
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
        Application other = (Application) obj;
        if (applicationName == null) {
            if (other.applicationName != null)
                return false;
        } else if (!applicationName.equals(other.applicationName))
            return false;
        if (applicationType == null) {
            if (other.applicationType != null)
                return false;
        } else if (!applicationType.equals(other.applicationType))
            return false;
        if (defaultURL == null) {
            if (other.defaultURL != null)
                return false;
        } else if (!defaultURL.equals(other.defaultURL))
            return false;
        if (versions == null) {
            if (other.versions != null)
                return false;
        } else if (!versions.equals(other.versions))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Application [applicationName=" + applicationName + ", applicationType=" + applicationType
                + ", defaultURL=" + defaultURL + ", versions=" + versions + "]";
    }
    
    
}
