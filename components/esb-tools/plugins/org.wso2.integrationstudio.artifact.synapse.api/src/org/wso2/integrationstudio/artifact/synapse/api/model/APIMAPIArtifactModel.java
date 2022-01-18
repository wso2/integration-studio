package org.wso2.integrationstudio.artifact.synapse.api.model;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.wso2.integrationstudio.artifact.synapse.api.Activator;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.APIMConnectException;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.HttpClientException;
import org.wso2.integrationstudio.artifact.synapse.api.exceptions.InvalidTokenException;
import org.wso2.integrationstudio.artifact.synapse.api.util.ArtifactConstants;
import org.wso2.integrationstudio.artifact.synapse.api.util.HttpClientUtil;
import org.wso2.integrationstudio.logging.core.IIntegrationStudioLog;
import org.wso2.integrationstudio.logging.core.Logger;
import org.wso2.integrationstudio.platform.core.project.model.ProjectDataModel;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class APIMAPIArtifactModel extends ProjectDataModel {
    private static IIntegrationStudioLog log=Logger.getLog(Activator.PLUGIN_ID);
    
    private String userName;
    private String password;
    private String apimHostUrl;

    private ArrayList<PublisherAPI> apiList = new ArrayList<PublisherAPI>();
    
    
    
    public String getUserName() {
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getApimHostUrl() {
        return apimHostUrl;
    }

    public void setApimHostUrl(String apimHostUrl) {
        this.apimHostUrl = apimHostUrl;
    }
    
    /**
     * Get API List.
     * 
     * @param userName user name of the user
     * @param passowrd password of the user
     * @param hostUrl url of the APIM server
     * @throws HttpClientException errors during http calls
     * @throws URISyntaxException errors building request
     * @throws APIMConnectException errors connecting to APIM Server
     * @throws InvalidTokenException auth failures
     */
    public void getAPIs(String userName, String password, String hostUrl)
            throws HttpClientException, URISyntaxException, InvalidTokenException, APIMConnectException {
        JsonParser parser = new JsonParser();
        Map<String, String> headers = new HashMap<>();
        String encodedToken = Base64.getEncoder().encodeToString(
                (userName + ":" + password).getBytes());
        headers.put(ArtifactConstants.HEADERS.AUTHORIZATION,
                ArtifactConstants.HEADERS.BASIC + encodedToken);
        Map<String, String> params = new HashMap<>();
        String getAPIsURL = hostUrl + ArtifactConstants.PublisherAPI.getAPis;
       
        String response = HttpClientUtil.sendGet(getAPIsURL, headers);
        JsonElement jsonResponse = parser.parse(response);
        int apiCount = jsonResponse.getAsJsonObject().get("count").getAsInt();
        JsonArray jsonArray = (JsonArray) jsonResponse.getAsJsonObject().get("list");
        setApiList(apiCount, jsonArray);
        
    }
    
    public void getAPISwagger(String userName, String password, String hostUrl)
            throws HttpClientException, URISyntaxException, InvalidTokenException, APIMConnectException {
        JsonParser parser = new JsonParser();
        Map<String, String> headers = new HashMap<>();
        String encodedToken = Base64.getEncoder().encodeToString(
                (userName + ":" + password).getBytes());
        headers.put(ArtifactConstants.HEADERS.AUTHORIZATION,
                ArtifactConstants.HEADERS.BASIC + encodedToken);
        Map<String, String> params = new HashMap<>();
        String getAPIsURL = hostUrl + ArtifactConstants.PublisherAPI.getAPis;
       
        String response = HttpClientUtil.sendGet(getAPIsURL, headers);
        JsonElement jsonResponse = parser.parse(response);
        int apiCount = jsonResponse.getAsJsonObject().get("count").getAsInt();
        JsonArray jsonArray = (JsonArray) jsonResponse.getAsJsonObject().get("list");
        setApiList(apiCount, jsonArray);
        
    }
    
    public void setApiList(int apiCount, JsonArray ApiArray) {
        
        for(int i=0; i< apiCount; i++) {
            PublisherAPI publisherAPI = new PublisherAPI();
            JsonObject jsonObjectApi = (JsonObject) ApiArray.get(i);
            publisherAPI.setApiId(jsonObjectApi.get("id").getAsString());
            publisherAPI.setApiName(jsonObjectApi.get("name").getAsString());
            publisherAPI.setApiVersion(jsonObjectApi.get("version").getAsString());
            publisherAPI.setApiContext(jsonObjectApi.get("context").getAsString());
            
            apiList.add(publisherAPI);
        }
    }
    
    public ArrayList<PublisherAPI> getAPIList() {
        return apiList;
    }

}
