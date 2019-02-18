package org.wso2.developerstudio.eclipse.esb.cloud.client;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.NotFoundException;
import org.wso2.developerstudio.eclipse.esb.cloud.util.HTTPClientUtil;
import org.wso2.developerstudio.eclipse.esb.docker.resources.CloudServiceConstants;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IntegrationCloudServiceClient {
    
    private static CookieStore cookieStore;
    private static IntegrationCloudServiceClient client;
    
    private IntegrationCloudServiceClient() {
        
    }
    
    public static IntegrationCloudServiceClient getInstance() {
        if (client == null) {
            cookieStore = new BasicCookieStore();
            client = new IntegrationCloudServiceClient();
        } 
        return client;
    }

    public boolean login(String username, String password) throws NotFoundException {
        String loginUrl = CloudServiceConstants.ServiceEndpoints.LOGIN_URL;

        Map<String, String> data = new HashMap<>();
        data.put("action", "login");
        data.put("userName", username);
        data.put("password", password);

        String response = HTTPClientUtil.sendPostWithFormData(loginUrl, new HashMap<String, String>(), data, cookieStore);
        
        System.out.println(response);
        
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(response);
        
        String message = jsonTree.getAsJsonObject().get("message").getAsString();
        
        return message.equals("User successfully logged in");
    }

    public void getApplication(String appName) throws NotFoundException {
        String getAppUrl = CloudServiceConstants.ServiceEndpoints.APPLICATION_URL;

        Map<String, String> data = new HashMap<>();
        data.put("action", "getApplication");
        data.put("applicationName", appName);

        String response = HTTPClientUtil.sendPostWithFormData(getAppUrl, new HashMap<String, String>(), data, cookieStore);

        System.out.println(response);
    }

    public void createApplication(String appName, String appDescription, String version, String fileName, String fileLocation) throws NotFoundException {

        List<String> files = new ArrayList<>();
        files.add(fileLocation);

        String createAppUrl = CloudServiceConstants.ServiceEndpoints.APPLICATION_URL;

        Map<String, String> data = new HashMap<>();
        data.put("action", "createApplication");
        data.put("applicationName", appName);
        data.put("applicationDescription", appDescription);
        data.put("appTypeName", CloudServiceConstants.AppConfigs.ESB);
        data.put("applicationRevision", version);
        data.put("uploadedFileName", fileName);
        data.put("runtimeProperties", "[]");
        data.put("tags", "[]");
        data.put("isFileAttached", "true");
        data.put("conSpec", "5");
        data.put("isNewVersion", "false");
        data.put("appCreationMethod", "default");
        data.put("setDefaultVersion", "true");
        data.put("runtime", CloudServiceConstants.AppConfigs.RUNTIME);        
        
        String response = HTTPClientUtil.sendPostWithMulipartFormData(createAppUrl, data, files, cookieStore);

        System.out.println(response);
    }

    public CookieStore getCookieStore() {
        return cookieStore;
    }

}

    
    