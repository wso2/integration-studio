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
package org.wso2.developerstudio.eclipse.apim.endpoint.central.utils;

import java.net.URISyntaxException;

import org.wso2.developerstudio.eclipse.apim.endpoint.central.client.APIMServiceClient;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.EndpointRegistryConnectException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.HttpClientException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.exceptions.InvalidTokenException;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.handler.APIMEarlyStartupHandler;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.model.UserSession;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.EndpointCentralServletConstants;

/**
 * This class manages the user session.
 */
public class UserSessionManager {

    private static UserSession session;
    private static APIMServiceClient client;

    private UserSessionManager() {
    }

    /**
     * Creates a new session.
     * 
     * @param userName username
     * @param registryName name of the registry to connect
     * @param encodedClientIdSecret encoded clientId:clientSecret
     * @param refreshToken refresh token
     * @param accessToken access token to api manager
     * @param registryId id of the registry to connect
     * @param endpointRegistryVersion version in the endpoint url
     * @param baseUrl https://host:port of the api instance
     */
    public static void createSession(String userName, String registryName, String encodedClientIdSecret,
            String refreshToken, String accessToken, String registryId, String endpointRegistryVersion,
            String baseUrl) {
        session = new UserSession(userName, registryName, encodedClientIdSecret, accessToken, refreshToken, 
                registryId, endpointRegistryVersion, baseUrl);
        APIMEarlyStartupHandler.writeCredential(session);
    }

    /**
     * Remove the existing session.
     */
    public static void removeSession() {
        if (session != null) {
            APIMEarlyStartupHandler.writeCredential(session);
            session = null;
        }
    }

    /**
     * Renew the access token and refresh token in case of token has been refreshed.
     * 
     * @param refreshToken new refresh token
     * @param accessToken new access token
     */
    public static void renewSession(String refreshToken, String accessToken) {
        session.setAccessToken(accessToken);
        session.setRefreshToken(refreshToken);
        APIMEarlyStartupHandler.writeCredential(session);
    }

    /**
     * Validate and return the current session.
     * 
     * @return current session
     * @throws HttpClientException request failures
     * @throws URISyntaxException request build failures
     * @throws EndpointRegistryConnectException other failures
     * @throws InvalidTokenException auth failures
     */
    public static UserSession getCurrentSession()
            throws HttpClientException, URISyntaxException, EndpointRegistryConnectException, InvalidTokenException {
        if (session == null) {
            throw new InvalidTokenException(EndpointCentralServletConstants.ResponseMessages.NOT_LOGGED);
        }
        try {
            if (null == client) {
                client = APIMServiceClient.getInstance();
            }
            // To check if the token is valid, we call this endpoint
            // If it returns unauthorized, it is considered as an expired token
            // This method will throw an InvalidTokenException if the user token is invalid
            client.getRegistries(session.getAccessToken(), session.getEndpointRegistryUrl());
        } catch (InvalidTokenException e) {
            client.refreshToken(session.getRefreshToken(), session.getEncodedClientIdSecret(), session.getTokenUrl());
        }
        return session;
    }
}
