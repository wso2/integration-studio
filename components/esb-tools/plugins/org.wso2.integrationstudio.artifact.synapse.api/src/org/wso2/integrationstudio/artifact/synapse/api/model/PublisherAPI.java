package org.wso2.integrationstudio.artifact.synapse.api.model;

public class PublisherAPI {
    
    private String apiId;
    private String apiName;
    private String apiVersion;
    private String apiContext;
    
    
    public String getApiId() {
        return apiId;
    }
    public void setApiId(String apiId) {
        this.apiId = apiId;
    }
    public String getApiName() {
        return apiName;
    }
    public void setApiName(String apiName) {
        this.apiName = apiName;
    }
    public String getApiVersion() {
        return apiVersion;
    }
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }
    public String getApiContext() {
        return apiContext;
    }
    public void setApiContext(String apiContext) {
        this.apiContext = apiContext;
    }

}
