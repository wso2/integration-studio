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

package org.wso2.developerstudio.eclipse.esb.cloud.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.wso2.developerstudio.eclipse.esb.cloud.Activator;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.CloudDeploymentException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.HttpClientException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.InvalidTokenException;
import org.wso2.developerstudio.eclipse.esb.cloud.exceptions.NetworkUnavailableException;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Application;
import org.wso2.developerstudio.eclipse.esb.cloud.model.Runtime;
import org.wso2.developerstudio.eclipse.esb.cloud.resources.CloudServiceConstants;
import org.wso2.developerstudio.eclipse.esb.cloud.util.HTTPClientUtil;
import org.wso2.developerstudio.eclipse.esb.cloud.util.JsonUtils;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Handles WSO2 integration cloud service actions
 *
 */
public class IntegrationCloudServiceClient {

    // maintains cookies that are required for authentication
    private static CookieStore cookieStore;

    private static IntegrationCloudServiceClient client;

    private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

    private IntegrationCloudServiceClient() {

    }

    public static IntegrationCloudServiceClient getInstance() {
        if (null == client) {
            cookieStore = new BasicCookieStore();
            client = new IntegrationCloudServiceClient();
        }
        return client;
    }

    /**
     * Login to the Integration Cloud
     * 
     * @param username
     * @param password
     * @param tenant
     * @return true if the user has successfully logged in, false if not
     * @throws CloudDeploymentException
     * @throws InvalidTokenException
     * @throws HttpClientException
     * @throws NetworkUnavailableException
     */
    public boolean login(String username, String password, String tenant)
            throws CloudDeploymentException, NetworkUnavailableException, HttpClientException {
        String loginUrl = CloudServiceConstants.ServiceEndpoints.LOGIN_URL;

        // Integration Cloud expects the username to be in <email>@<organization_key> format
        String user = username + "@" + tenant;

        Map<String, String> data = new HashMap<>();
        data.put(CloudServiceConstants.Parameters.PARAM_ACTION, CloudServiceConstants.Actions.LOGIN);
        data.put(CloudServiceConstants.Parameters.PARAM_USERNAME, user);
        data.put(CloudServiceConstants.Parameters.PARAM_PASSWORD, password);

        try {
            String response = HTTPClientUtil.sendPostWithFormData(loginUrl, new HashMap<String, String>(), data,
                    cookieStore);
            JsonParser parser = new JsonParser();
            JsonElement jsonResponse = parser.parse(response);
            JsonElement messageJson = jsonResponse.getAsJsonObject().get("message");
            if (messageJson != null) {
                String message = messageJson.getAsString();
                return CloudServiceConstants.ResponseMessages.USER_SUCCESSFULLY_LOGGED_IN.equals(message); 
            }
        } catch (InvalidTokenException e) {
            log.error("Failed to authenticate user!", e);
        }
        return false;

    }

    /**
     * Retrieve all carbon applications under the logged in cloud account
     * 
     * @return the list of applications
     * @throws CloudDeploymentException
     * @throws InvalidTokenException
     * @throws HttpClientException
     * @throws NetworkUnavailableException
     */
    public List<Application> getApplicationList()
            throws CloudDeploymentException, InvalidTokenException, NetworkUnavailableException, HttpClientException {
        String getAppListUrl = CloudServiceConstants.ServiceEndpoints.INDEX_URL;

        Map<String, String> data = new HashMap<>();
        data.put(CloudServiceConstants.Parameters.PARAM_ACTION, CloudServiceConstants.Actions.GET_APPLICATION_LIST);

        String response = HTTPClientUtil.sendPostWithFormData(getAppListUrl, new HashMap<String, String>(), data,
                cookieStore);

        if (null == response) {
            return null;
        }

        List<Application> applications = JsonUtils.getApplicationListFromJson(response);

        // Filter carbon apps
        List<Application> carbonapps = applications.stream()
                .filter(x -> CloudServiceConstants.AppConfigs.ESB.equals(x.getApplicationType()))
                .collect(Collectors.toList());

        return carbonapps;
    }

    /**
     * Retrieve application by name
     * 
     * @param appName
     * @return the application if it exists, else returns null
     * @throws CloudDeploymentException
     * @throws InvalidTokenException
     * @throws HttpClientException
     * @throws NetworkUnavailableException
     */
    public Application getApplication(String appName)
            throws CloudDeploymentException, InvalidTokenException, NetworkUnavailableException, HttpClientException {
        String getAppUrl = CloudServiceConstants.ServiceEndpoints.APPLICATION_URL;

        Map<String, String> data = new HashMap<>();
        data.put(CloudServiceConstants.Parameters.PARAM_ACTION, CloudServiceConstants.Actions.GET_APPLICATION);
        data.put(CloudServiceConstants.Parameters.PARAM_APP_NAME, appName);

        String response = HTTPClientUtil.sendPostWithFormData(getAppUrl, new HashMap<String, String>(), data,
                cookieStore);

        if (null == response) {
            return null;
        }

        return JsonUtils.getApplicationFromJson(response);
    }

    /**
     * Retrieve endpoints of a particular application
     * 
     * @param appType
     * @param deploymentURL
     * @param versionId
     * @return endpoints of a particular application, null if the endpoints are not ready yet.
     * @throws CloudDeploymentException
     * @throws InvalidTokenException
     * @throws HttpClientException
     * @throws NetworkUnavailableException
     */
    public String getApplicationEndpoints(String appType, String deploymentURL, String versionId)
            throws CloudDeploymentException, InvalidTokenException, NetworkUnavailableException, HttpClientException {
        String getAppUrl = CloudServiceConstants.ServiceEndpoints.APPLICATION_URL;

        Map<String, String> data = new HashMap<>();
        data.put(CloudServiceConstants.Parameters.PARAM_ACTION, CloudServiceConstants.Actions.LOAD_ENDPOINTS);
        data.put(CloudServiceConstants.Parameters.PARAM_APP_TYPE, appType);
        data.put(CloudServiceConstants.Parameters.PARAM_DEPLOYMENT_URL, deploymentURL);
        data.put(CloudServiceConstants.Parameters.PARAM_VERSION_ID, versionId);

        String response = HTTPClientUtil.sendPostWithFormData(getAppUrl, new HashMap<String, String>(), data,
                cookieStore);

        // If the application endpoints are not yet ready, it will return null
        if (null != response && !"null".equals(response)) {
            JsonElement endpointData = new JsonParser().parse(response);
            if (null != endpointData.getAsJsonObject().get("data")) {
                JsonObject dataJson = endpointData.getAsJsonObject().get("data").getAsJsonObject();
                response = dataJson.toString();
            } else if (null != endpointData.getAsJsonObject().get("message")) {
                response = endpointData.getAsJsonObject().get("message").getAsString();
            }
        }

        return response;
    }

    /**
     * Create new application / version
     * 
     * @param appName
     * @param appDescription
     * @param version
     * @param fileName
     * @param fileLocation
     * @param iconLocation
     * @param tags
     * @param isNewVersion
     * @throws CloudDeploymentException
     * @throws InvalidTokenException
     * @throws HttpClientException
     * @throws NetworkUnavailableException
     */
    public void createApplication(String appName, String appDescription, String version, String fileName,
            String fileLocation, String iconLocation, List<Map<String, String>> tags, boolean isNewVersion, int runtime)
            throws CloudDeploymentException, InvalidTokenException, NetworkUnavailableException, HttpClientException {

        Map<String, String> files = new HashMap<>();
        files.put(CloudServiceConstants.Parameters.PARAM_FILE, fileLocation);

        if (null != iconLocation && !iconLocation.isEmpty()) {
            files.put(CloudServiceConstants.Parameters.PARAM_ICON, iconLocation);
        }

        String createAppUrl = CloudServiceConstants.ServiceEndpoints.APPLICATION_URL;

        Map<String, String> data = new HashMap<>();
        data.put(CloudServiceConstants.Parameters.PARAM_ACTION, CloudServiceConstants.Actions.CREATE_APPLICATION);
        data.put(CloudServiceConstants.Parameters.PARAM_APP_NAME, appName);

        if (null != appDescription && !appDescription.isEmpty()) {
            data.put(CloudServiceConstants.Parameters.PARAM_APP_DESCRIPTION, appDescription);
        }

        data.put(CloudServiceConstants.Parameters.PARAM_APP_TYPE_NAME, CloudServiceConstants.AppConfigs.ESB);
        data.put(CloudServiceConstants.Parameters.PARAM_APP_REVISION, version);
        data.put(CloudServiceConstants.Parameters.PARAM_FILE_NAME, fileName);
        data.put(CloudServiceConstants.Parameters.PARAM_RUNTIME_PROPERTIES,
                CloudServiceConstants.AppConfigs.RUNTIME_PROPERTIES);
        data.put(CloudServiceConstants.Parameters.PARAM_TAGS, JsonUtils.getJsonArrayFromList(tags));
        data.put(CloudServiceConstants.Parameters.PARAM_IS_FILE_ATTACHED,
                CloudServiceConstants.AppConfigs.IS_FILE_ATTACHED);
        data.put(CloudServiceConstants.Parameters.PARAM_CON_SPEC, CloudServiceConstants.AppConfigs.CON_SPEC);
        data.put(CloudServiceConstants.Parameters.PARAM_IS_NEW_VERSION, Boolean.toString(isNewVersion));
        data.put(CloudServiceConstants.Parameters.PARAM_APP_CREATION_METHOD,
                CloudServiceConstants.AppConfigs.APP_CREATION_METHOD);
        data.put(CloudServiceConstants.Parameters.PARAM_SET_DEFAULT_VERSION,
                CloudServiceConstants.AppConfigs.SET_DEFAULT_VERSION);
        if (runtime != 0) {
            data.put(CloudServiceConstants.Parameters.PARAM_RUNTIME, Integer.toString(runtime));
        }

        HTTPClientUtil.sendPostWithMulipartFormData(createAppUrl, data, files, cookieStore);

    }

    public List<Runtime> getApplicationRuntimes(String appType)
            throws InvalidTokenException, CloudDeploymentException, NetworkUnavailableException, HttpClientException {
        String getAppUrl = CloudServiceConstants.ServiceEndpoints.APPLICATION_URL;

        Map<String, String> data = new HashMap<>();
        data.put(CloudServiceConstants.Parameters.PARAM_ACTION, CloudServiceConstants.Actions.GET_RUNTIMES);
        data.put(CloudServiceConstants.Parameters.PARAM_APP_TYPE_NAME, appType);

        String response = HTTPClientUtil.sendPostWithFormData(getAppUrl, new HashMap<String, String>(), data,
                cookieStore);

        if (null == response) {
            return null;
        }

        return JsonUtils.getRuntimesFromJson(response);
    }

    /**
     * Returns the cookies stored
     * 
     * @return
     */
    public CookieStore getCookieStore() {
        return cookieStore;
    }

}
