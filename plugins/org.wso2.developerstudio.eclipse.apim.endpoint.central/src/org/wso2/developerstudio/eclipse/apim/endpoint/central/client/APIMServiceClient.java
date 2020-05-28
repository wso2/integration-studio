/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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
package org.wso2.developerstudio.eclipse.apim.endpoint.central.client;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.EndpointRegistryConnectException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.HttpClientException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.InvalidTokenException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.Registry;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.RegistryEntry;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.EndpointCentralConstants;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.EndpointRegistryServiceConstants;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.utils.EncoderUtil;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.utils.HTTPClientUtil;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.utils.JsonUtils;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.utils.UserSessionManager;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Handles calls to Endpoint registry.
 */
public class APIMServiceClient {

    private static APIMServiceClient client;

    /**
     * Making the class singleton.
     */
    private APIMServiceClient() {
    }

    /**
     * Return the singleton instance.
     * 
     * @return client instance
     */
    public static APIMServiceClient getInstance() {
        if (null == client) {
            client = new APIMServiceClient();
        }
        return client;
    }

    /**
     * This methods register a new client application in the server and generate tokens,
     * 
     * @param username username of the user
     * @param password password of the user
     * @param baseUrl base url of the endpoint API manager instance
     * @param epVersion version of the endpoint registry url
     * @param crVersion version of the client registration url
     * @throws HttpClientException errors during http calls
     * @throws URISyntaxException errors building request
     * @throws EndpointRegistryConnectException errors connecting to endpoint registry
     * @throws InvalidTokenException auth failures
     */
    public void register(String username, String password, String baseUrl, String epVersion, String crVersion)
            throws HttpClientException, URISyntaxException, EndpointRegistryConnectException, InvalidTokenException {

        String clientRegistrationUrl = EndpointRegistryServiceConstants.getClientRegistrationUrl(baseUrl, crVersion);
        String tokenUrl = EndpointRegistryServiceConstants.getTokenUrl(baseUrl);
        Map<String, String> headers = new HashMap<>();
        headers.put(EndpointRegistryServiceConstants.HEADERS.CONTENT_TYPE,
                EndpointRegistryServiceConstants.HEADERS.APPLICATION_JSON);
        headers.put(EndpointRegistryServiceConstants.HEADERS.AUTHORIZATION,
                EndpointRegistryServiceConstants.HEADERS.BASIC
                        + EncoderUtil.encode(username + EndpointRegistryServiceConstants.Common.COLON + password));
        Map<String, Object> data = new HashMap<>();
        data.put(EndpointRegistryServiceConstants.ClientRegistrationPayload.CALL_BACK_URL,
                EndpointCentralConstants.DEFAULT_CALL_BACK_URL);
        data.put(EndpointRegistryServiceConstants.ClientRegistrationPayload.CLIENT_NAME,
                EndpointCentralConstants.DEFAULT_CLENT_NAME);
        data.put(EndpointRegistryServiceConstants.ClientRegistrationPayload.GRANT_TYPE,
                EndpointCentralConstants.DEFAULT_GRANT_TYPE);
        data.put(EndpointRegistryServiceConstants.ClientRegistrationPayload.OWNER, username);
        data.put(EndpointRegistryServiceConstants.ClientRegistrationPayload.SAAS_APP, true);

        String response = HTTPClientUtil.sendPostWithJsonPayload(clientRegistrationUrl, headers,
                JsonUtils.getJsonFromMap(data));
        JsonParser parser = new JsonParser();
        JsonElement jsonResponse = parser.parse(response);
        JsonElement clientIdJson = jsonResponse.getAsJsonObject()
                .get(EndpointRegistryServiceConstants.ClientRegistrationResult.CLIENT_ID);
        JsonElement clientSecretJson = jsonResponse.getAsJsonObject()
                .get(EndpointRegistryServiceConstants.ClientRegistrationResult.CLIENT_SECRET);
        if (clientIdJson != null && clientSecretJson != null) {
            String clientSecret = clientSecretJson.getAsString();
            String clientId = clientIdJson.getAsString();
            String clientIdSecretEncoded = EncoderUtil
                    .encode(clientId + EndpointRegistryServiceConstants.Common.COLON + clientSecret);
            headers = new HashMap<>();
            headers.put(EndpointRegistryServiceConstants.HEADERS.AUTHORIZATION,
                    EndpointRegistryServiceConstants.HEADERS.BASIC + clientIdSecretEncoded);
            Map<String, String> params = new HashMap<>();
            params.put(EndpointRegistryServiceConstants.TokenGenerationParams.GRANT_TYPE,
                    EndpointCentralConstants.DEFAULT_TOKEN_GRANT_TYPE);
            params.put(EndpointRegistryServiceConstants.TokenGenerationParams.USERNAME, username);
            params.put(EndpointRegistryServiceConstants.TokenGenerationParams.PASSWORD, password);
            params.put(EndpointRegistryServiceConstants.TokenGenerationParams.SCOPE,
                    EndpointCentralConstants.DEFAULT_SCOPE);
            response = HTTPClientUtil.sendPostWithFormData(tokenUrl, headers, params);
            jsonResponse = parser.parse(response);
            JsonElement accessTokenJson = jsonResponse.getAsJsonObject()
                    .get(EndpointRegistryServiceConstants.TokenGenerationResults.ACCESS_TOKEN);
            JsonElement refreshToken = jsonResponse.getAsJsonObject()
                    .get(EndpointRegistryServiceConstants.TokenGenerationResults.REFRESH_TOKEN);
            if (accessTokenJson != null && refreshToken != null) {
                String accessToken = accessTokenJson.getAsString();
                String endpointRegistryUrl = EndpointRegistryServiceConstants.getEndpointRegistryUrl(baseUrl,
                        epVersion);
                Registry registry = null;
                List<Registry> registries = getRegistries(accessToken, endpointRegistryUrl);

                // Getting the default registry
                for (Registry recievedRegistry : registries) {
                    if (recievedRegistry.getName().equals(EndpointCentralConstants.DEFAULT_REGISTRY_NAME)) {
                        registry = recievedRegistry;
                        break;
                    }
                }

                // If registry is not received, create a new one.
                if (null == registry) {
                    registry = createRegistry(EndpointCentralConstants.DEFAULT_REGISTRY_NAME, accessToken,
                            endpointRegistryUrl);
                }
                UserSessionManager.createSession(username, registry.getName(), clientIdSecretEncoded,
                        refreshToken.getAsString(), accessToken, registry.getId(), epVersion, baseUrl);
            }
        }
    }

    /**
     * Refresh the token.
     * 
     * @param refreshToken refresh token
     * @param authorizationCode encoded clientId:clientSecret key
     * @param tokenUrl url of the token service
     * @throws HttpClientException errors during http calls
     * @throws URISyntaxException errors building request
     * @throws EndpointRegistryConnectException errors connecting to endpoint registry
     * @throws InvalidTokenException auth failures
     */
    public void refreshToken(String refreshToken, String authorizationCode, String tokenUrl)
            throws HttpClientException, URISyntaxException, InvalidTokenException, EndpointRegistryConnectException {
        JsonParser parser = new JsonParser();
        Map<String, String> headers = new HashMap<>();
        headers.put(EndpointRegistryServiceConstants.HEADERS.AUTHORIZATION,
                EndpointRegistryServiceConstants.HEADERS.BASIC + authorizationCode);
        Map<String, String> params = new HashMap<>();
        params.put(EndpointRegistryServiceConstants.TokenGenerationParams.GRANT_TYPE,
                EndpointRegistryServiceConstants.TokenGenerationResults.REFRESH_TOKEN);
        params.put(EndpointRegistryServiceConstants.TokenGenerationResults.REFRESH_TOKEN, refreshToken);
        String response = HTTPClientUtil.sendPostWithFormData(tokenUrl, headers, params);
        JsonElement jsonResponse = parser.parse(response);
        JsonElement newAccessToken = jsonResponse.getAsJsonObject()
                .get(EndpointRegistryServiceConstants.TokenGenerationResults.ACCESS_TOKEN);
        JsonElement newRefreshToken = jsonResponse.getAsJsonObject()
                .get(EndpointRegistryServiceConstants.TokenGenerationResults.REFRESH_TOKEN);
        if (newAccessToken != null && newRefreshToken != null) {
            UserSessionManager.renewSession(newRefreshToken.getAsString(), newAccessToken.getAsString());
        } else {
            throw new InvalidTokenException(EndpointRegistryServiceConstants.Errors.REFRSH_FAIL);
        }
    }

    /**
     * Fetch the list of registries from the endpoint registry.
     * 
     * @param authorizationCode encoded clientId:clientSecret key
     * @param endpointRegistryUrl url of the endpoint registry
     * @return registry list
     * @throws HttpClientException errors during http calls
     * @throws URISyntaxException errors building request
     * @throws EndpointRegistryConnectException errors connecting to endpoint registry
     * @throws InvalidTokenException auth failures
     */
    public List<Registry> getRegistries(String authorizationCode, String endpointRegistryUrl)
            throws InvalidTokenException, HttpClientException, URISyntaxException, EndpointRegistryConnectException {
        Map<String, String> headers = new HashMap<>();
        headers.put(EndpointRegistryServiceConstants.HEADERS.AUTHORIZATION,
                EndpointRegistryServiceConstants.HEADERS.BEARER + authorizationCode);
        String response = HTTPClientUtil.sendGet(endpointRegistryUrl, headers);
        List<Registry> registries = JsonUtils.getRegistryListFromJson(response);
        return registries;
    }

    /**
     * Fetch a registry from the endpoint registry.
     * 
     * @param authorizationCode encoded clientId:clientSecret key
     * @param endpointRegistryUrl url of the endpoint registry
     * @param registryId id of the registry
     * @return registry
     * @throws HttpClientException errors during http calls
     * @throws URISyntaxException errors building request
     * @throws EndpointRegistryConnectException errors connecting to endpoint registry
     * @throws InvalidTokenException auth failures
     */
    public Registry getRegistry(String authorizationCode, String endpointRegistryUrl, String registryId)
            throws InvalidTokenException, HttpClientException, URISyntaxException, EndpointRegistryConnectException {
        Map<String, String> headers = new HashMap<>();
        headers.put(EndpointRegistryServiceConstants.HEADERS.AUTHORIZATION,
                EndpointRegistryServiceConstants.HEADERS.BEARER + authorizationCode);
        String response = HTTPClientUtil
                .sendGet(endpointRegistryUrl + EndpointRegistryServiceConstants.Common.SLASH + registryId, headers);
        Registry registry = JsonUtils.getRegistryFromJson(response);
        return registry;
    }

    /**
     * Create a registry in the endpoint registry.
     * 
     * @param registryName name of the registry
     * @param authorizationCode encoded clientId:clientSecret key
     * @param endpointRegistryUrl url of the endpoint registry
     * @return new registry
     * @throws HttpClientException errors during http calls
     * @throws URISyntaxException errors building request
     * @throws EndpointRegistryConnectException errors connecting to endpoint registry
     * @throws InvalidTokenException auth failures
     */
    public Registry createRegistry(String registryName, String authorizationCode, String endpointRegistryUrl)
            throws InvalidTokenException, HttpClientException, URISyntaxException, EndpointRegistryConnectException {
        Map<String, String> headers = new HashMap<>();
        headers.put(EndpointRegistryServiceConstants.HEADERS.AUTHORIZATION,
                EndpointRegistryServiceConstants.HEADERS.BEARER + authorizationCode);
        Registry registry = new Registry();
        registry.setName(registryName);
        registry.setType(EndpointCentralConstants.DEFAULT_REGISTRY_TYPE);
        registry.setMode(EndpointCentralConstants.DEFAULT_MODE);
        String json = JsonUtils.getJsonFromRegistry(registry);
        String response = HTTPClientUtil.sendPostWithJsonPayload(endpointRegistryUrl, headers, json);
        Registry returnedRegistry = JsonUtils.getRegistryFromJson(response);
        return returnedRegistry;
    }

    /**
     * Fetch entries of a given registry.
     * 
     * @param authorizationCode encoded clientId:clientSecret key
     * @param endpointRegistryUrl url of the endpoint registry
     * @param registryId id of the registry
     * @return registry entry list
     * @throws HttpClientException errors during http calls
     * @throws URISyntaxException errors building request
     * @throws EndpointRegistryConnectException errors connecting to endpoint registry
     * @throws InvalidTokenException auth failures
     */
    public List<RegistryEntry> getRegistryEntries(String authorizationCode, String endpointRegistryUrl,
            String registryId)
            throws InvalidTokenException, HttpClientException, URISyntaxException, EndpointRegistryConnectException {
        Map<String, String> headers = new HashMap<>();
        headers.put(EndpointRegistryServiceConstants.HEADERS.AUTHORIZATION,
                EndpointRegistryServiceConstants.HEADERS.BEARER + authorizationCode);
        String response = HTTPClientUtil.sendGet(endpointRegistryUrl + EndpointRegistryServiceConstants.Common.SLASH
                + registryId + EndpointRegistryServiceConstants.ENDPOINT_REGISTRY_ENTRIES_PATH, headers);
        List<RegistryEntry> registryEntries = JsonUtils.getRegistryEntryListFromJson(response);
        return registryEntries;
    }

    /**
     * Create an entry in the given registry.
     * 
     * @param authorizationCode encoded clientId:clientSecret key
     * @param endpointRegistryUrl url of the endpoint registry
     * @param registryId id of the registry
     * @param registryEntry entry data
     * @param definitionFile definition file content
     * @return new registry entry
     * @throws HttpClientException errors during http calls
     * @throws URISyntaxException errors building request
     * @throws EndpointRegistryConnectException errors connecting to endpoint registry
     * @throws InvalidTokenException auth failures
     */
    public RegistryEntry createRegistryEntry(String authorizationCode, String endpointRegistryUrl, String registryId,
            RegistryEntry registryEntry, String definitionFile)
            throws InvalidTokenException, HttpClientException, URISyntaxException, EndpointRegistryConnectException {
        Map<String, String> headers = new HashMap<>();
        headers.put(EndpointRegistryServiceConstants.HEADERS.AUTHORIZATION,
                EndpointRegistryServiceConstants.HEADERS.BEARER + authorizationCode);
        String json = JsonUtils.getJsonFromRegistryEntry(registryEntry);
        Map<String, String> params = new HashMap<>();
        params.put(EndpointRegistryServiceConstants.REGISTRY_ENTRY, json);
        Map<String, String> files = new HashMap<>();
        files.put(EndpointRegistryServiceConstants.DEFINITION_FILE, definitionFile);
        String url = endpointRegistryUrl + EndpointRegistryServiceConstants.Common.SLASH + registryId
                + EndpointRegistryServiceConstants.ENDPOINT_REGISTRY_ENTRY_PATH;
        String response = HTTPClientUtil.sendPostWithMulipartFormData(url, headers, params, files);
        RegistryEntry returnedRegistry = JsonUtils.getRegistryEntryFromJson(response);
        return returnedRegistry;
    }

    /**
     * Fetch an entry with the given Id.
     * 
     * @param authorizationCode encoded clientId:clientSecret key
     * @param endpointRegistryUrl url of the endpoint registry
     * @param registryId id of the registry
     * @param registryEntryId id of the entry
     * @return registry entry
     * @throws HttpClientException errors during http calls
     * @throws URISyntaxException errors building request
     * @throws EndpointRegistryConnectException errors connecting to endpoint registry
     * @throws InvalidTokenException auth failures
     */
    public String getRegistryEntryAPIDefinition(String authorizationCode, String endpointRegistryUrl, 
            String registryId, String registryEntryId)
            throws InvalidTokenException, HttpClientException, URISyntaxException, EndpointRegistryConnectException {
        Map<String, String> headers = new HashMap<>();
        headers.put(EndpointRegistryServiceConstants.HEADERS.AUTHORIZATION,
                EndpointRegistryServiceConstants.HEADERS.BEARER + authorizationCode);
        String url = endpointRegistryUrl + EndpointRegistryServiceConstants.Common.SLASH + registryId
                + EndpointRegistryServiceConstants.ENDPOINT_REGISTRY_ENTRIES_PATH
                + EndpointRegistryServiceConstants.Common.SLASH + registryEntryId
                + EndpointRegistryServiceConstants.ENDPOINT_REGISTRY_DEFINITION_PATH;
        String response = HTTPClientUtil.sendGet(url, headers);
        return response;
    }
}
