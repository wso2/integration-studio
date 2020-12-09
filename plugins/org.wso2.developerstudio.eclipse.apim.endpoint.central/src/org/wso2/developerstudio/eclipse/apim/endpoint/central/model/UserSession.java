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
package org.wso2.developerstudio.eclipse.apim.endpoint.central.model;

import java.util.Objects;

import org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.EndpointCentralConstants;
import org.wso2.developerstudio.eclipse.apim.endpoint.central.resources.EndpointRegistryServiceConstants;

/**
 * Contains user session details.
 */
public class UserSession {

    private String accessToken;
    private String refreshToken;
    private String registryId;
    private String registryName;
    private String endpointRegistryVersion;
    private String baseUrl;
    private String encodedClientIdSecret;
    private String userName;

    public UserSession(String accessToken) {
        super();
        this.accessToken = accessToken;
    }

    public UserSession(String accessToken, String refreshToken) {
        super();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public UserSession(String encodedClientIdSecret, String accessToken, String refreshToken, String registryId,
            String endpointRegistryVersion, String baseUrl) {
        super();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.registryId = registryId;
        this.endpointRegistryVersion = endpointRegistryVersion;
        this.baseUrl = baseUrl;
        this.encodedClientIdSecret = encodedClientIdSecret;
    }

    public UserSession(String userName, String registryName, String encodedClientIdSecret, String accessToken,
            String refreshToken, String registryId, String endpointRegistryVersion, String baseUrl) {
        super();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.registryId = registryId;
        this.endpointRegistryVersion = endpointRegistryVersion;
        this.baseUrl = baseUrl;
        this.encodedClientIdSecret = encodedClientIdSecret;
        this.userName = userName;
        this.registryName = registryName;
    }

    public String getRegistryName() {
        return registryName;
    }

    public void setRegistryName(String registryName) {
        this.registryName = registryName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRegistryId() {
        return registryId;
    }

    public String getEncodedClientIdSecret() {
        return encodedClientIdSecret;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setRegistryId(String registryId) {
        this.registryId = registryId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String username) {
        this.accessToken = username;
    }

    public String getEndpointRegistryVersion() {
        return endpointRegistryVersion;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Return the url to obtain tokens from api manager.
     * 
     * @return url
     */
    public String getTokenUrl() {
        return EndpointRegistryServiceConstants.getTokenUrl(baseUrl);
    }

    /**
     * Return the url of the endpoint registry.
     * 
     * @return url
     */
    public String getEndpointRegistryUrl() {
        return EndpointRegistryServiceConstants.getEndpointRegistryUrl(baseUrl, endpointRegistryVersion);
    }

    /**
     * Check whether type of given object and attributes of given object equals to this object.
     * 
     * @param object object
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        UserSession userSession = (UserSession) object;
        return Objects.equals(this.accessToken, userSession.accessToken)
                && Objects.equals(this.baseUrl, userSession.baseUrl)
                && Objects.equals(this.encodedClientIdSecret, userSession.encodedClientIdSecret)
                && Objects.equals(this.endpointRegistryVersion, userSession.endpointRegistryVersion)
                && Objects.equals(this.refreshToken, userSession.refreshToken)
                && Objects.equals(this.registryId, userSession.registryId)
                && Objects.equals(this.registryName, userSession.registryName)
                && Objects.equals(this.userName, userSession.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, baseUrl, encodedClientIdSecret, endpointRegistryVersion, refreshToken,
                registryId, userName, registryName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserSession {").append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    accessToken: ").append(toIndentedString(accessToken));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    baseUrl: ").append(toIndentedString(baseUrl));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    encodedClientIdSecret: ").append(toIndentedString(encodedClientIdSecret));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    endpointRegistryVersion: ").append(toIndentedString(endpointRegistryVersion));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    refreshToken: ").append(toIndentedString(refreshToken));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    registryId: ").append(toIndentedString(registryId));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    userName: ").append(toIndentedString(userName));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    registryName: ").append(toIndentedString(registryName));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append(EndpointCentralConstants.CLOSE_BRACKET);
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * 
     * @param object object to convert
     */
    private String toIndentedString(Object object) {
        if (object == null) {
            return EndpointCentralConstants.NULL_STRING;
        }
        return object.toString().replace(EndpointCentralConstants.LINE_BREAK,
                EndpointCentralConstants.LINE_BREAK + EndpointCentralConstants.TAB_SPACES);
    }
}
