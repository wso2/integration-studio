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

public class CTLEnvironment {
    private String Name;
    private String ApplicationEndpoint;
    private String AdminEndpoint;
    private String ApiManagerEndpoint;
    private String PublisherEndpoint;
    private String TokenEndpoint;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getApplicationEndpoint() {
        return ApplicationEndpoint;
    }

    public void setApplicationEndpoint(String applicationEndpoint) {
        ApplicationEndpoint = applicationEndpoint;
    }

    public String getAdminEndpoint() {
        return AdminEndpoint;
    }

    public void setAdminEndpoint(String adminEndpoint) {
        AdminEndpoint = adminEndpoint;
    }

    public String getApiManagerEndpoint() {
        return ApiManagerEndpoint;
    }

    public void setApiManagerEndpoint(String apiManagerEndpoint) {
        ApiManagerEndpoint = apiManagerEndpoint;
    }

    public String getPublisherEndpoint() {
        return PublisherEndpoint;
    }

    public void setPublisherEndpoint(String publisherEndpoint) {
        PublisherEndpoint = publisherEndpoint;
    }

    public String getTokenEndpoint() {
        return TokenEndpoint;
    }

    public void setTokenEndpoint(String tokenEndpoint) {
        TokenEndpoint = tokenEndpoint;
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
        CTLEnvironment CTLEnvironmentPayload = (CTLEnvironment) object;
        return Objects.equals(this.Name, CTLEnvironmentPayload.Name)
                && Objects.equals(this.ApplicationEndpoint, CTLEnvironmentPayload.ApplicationEndpoint)
                && Objects.equals(this.AdminEndpoint, CTLEnvironmentPayload.AdminEndpoint)
                && Objects.equals(this.ApiManagerEndpoint, CTLEnvironmentPayload.ApiManagerEndpoint)
                && Objects.equals(this.PublisherEndpoint, CTLEnvironmentPayload.PublisherEndpoint)
                && Objects.equals(this.TokenEndpoint, CTLEnvironmentPayload.TokenEndpoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, ApplicationEndpoint, AdminEndpoint, ApiManagerEndpoint, PublisherEndpoint,
                TokenEndpoint);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CTLEnvironment {").append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    Name: ").append(toIndentedString(Name)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    ApplicationEndpoint: ").append(toIndentedString(ApplicationEndpoint))
                .append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    AdminEndpoint: ").append(toIndentedString(AdminEndpoint))
                .append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    ApiManagerEndpoint: ").append(toIndentedString(ApiManagerEndpoint));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    PublisherEndpoint: ").append(toIndentedString(PublisherEndpoint))
                .append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    TokenEndpoint: ").append(toIndentedString(TokenEndpoint))
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
