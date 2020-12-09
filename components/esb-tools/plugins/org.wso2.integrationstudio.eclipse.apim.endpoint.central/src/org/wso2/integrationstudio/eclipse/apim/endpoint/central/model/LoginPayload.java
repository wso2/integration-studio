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
package org.wso2.integrationstudio.eclipse.apim.endpoint.central.model;

import java.util.Objects;

import org.wso2.integrationstudio.eclipse.apim.endpoint.central.resources.EndpointCentralConstants;

/**
 * Represent the payload sent to servlet for login.
 */
public class LoginPayload {
    private String username;
    private String password;
    private String host;
    private String endpointRegistryVersion;
    private String clientRegistrationVersion;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getEndpointRegistryVersion() {
        return endpointRegistryVersion;
    }

    public void setEndpointRegistryVersion(String endpointRegistryVersion) {
        this.endpointRegistryVersion = endpointRegistryVersion;
    }

    public String getClientRegistrationVersion() {
        return clientRegistrationVersion;
    }

    public void setClientRegistrationVersion(String clientRegistrationVersion) {
        this.clientRegistrationVersion = clientRegistrationVersion;
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
        LoginPayload loginPayload = (LoginPayload) object;
        return Objects.equals(this.username, loginPayload.username)
                && Objects.equals(this.password, loginPayload.password) 
                && Objects.equals(this.host, loginPayload.host)
                && Objects.equals(this.endpointRegistryVersion, loginPayload.endpointRegistryVersion)
                && Objects.equals(this.clientRegistrationVersion, loginPayload.clientRegistrationVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, host, endpointRegistryVersion, clientRegistrationVersion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoginPayload {").append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    username: ").append(toIndentedString(username)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    password: ").append(toIndentedString(password)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    host: ").append(toIndentedString(host)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    endpointRegistryVersion: ").append(toIndentedString(endpointRegistryVersion));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    clientRegistrationVersion: ").append(toIndentedString(clientRegistrationVersion))
                .append(EndpointCentralConstants.LINE_BREAK);
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
