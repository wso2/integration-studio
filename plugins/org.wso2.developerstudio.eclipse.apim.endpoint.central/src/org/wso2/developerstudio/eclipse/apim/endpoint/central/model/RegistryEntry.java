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

/**
 * Represents the RegistryEntry of the Endpoint Registry REST API.
 */
public class RegistryEntry {
    private String id;
    private String entryName;
    private String serviceUrl;
    private String serviceCategory;
    private String serviceType;
    private String definitionType;
    private String definitionUrl;
    private String metadata;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getServiceCategory() {
        return serviceCategory;
    }

    public void setServiceCategory(String serviceCategory) {
        this.serviceCategory = serviceCategory;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getDefinitionType() {
        return definitionType;
    }

    public void setDefinitionType(String definitionType) {
        this.definitionType = definitionType;
    }

    public String getDefinitionUrl() {
        return definitionUrl;
    }

    public void setDefinitionUrl(String definitionUrl) {
        this.definitionUrl = definitionUrl;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
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
        RegistryEntry registryEntry = (RegistryEntry) object;
        return Objects.equals(this.id, registryEntry.id) && Objects.equals(this.entryName, registryEntry.entryName)
                && Objects.equals(this.serviceUrl, registryEntry.serviceUrl)
                && Objects.equals(this.serviceCategory, registryEntry.serviceCategory)
                && Objects.equals(this.serviceType, registryEntry.serviceType)
                && Objects.equals(this.definitionType, registryEntry.definitionType)
                && Objects.equals(this.definitionUrl, registryEntry.definitionUrl)
                && Objects.equals(this.metadata, registryEntry.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryName, serviceUrl, serviceCategory, serviceType, definitionType, definitionUrl,
                metadata);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RegistryEntry {").append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    id: ").append(toIndentedString(id)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    entryName: ").append(toIndentedString(entryName)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    serviceUrl: ").append(toIndentedString(serviceUrl));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    serviceCategory: ").append(toIndentedString(serviceCategory));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    serviceType: ").append(toIndentedString(serviceType));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    definitionType: ").append(toIndentedString(definitionType));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    definitionUrl: ").append(toIndentedString(definitionUrl));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    metadata: ").append(toIndentedString(metadata)).append(EndpointCentralConstants.LINE_BREAK);
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
