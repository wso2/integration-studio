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
 * Represents the Registry of the Endpoint Registry REST API.
 */
public class Registry {

    private String name;
    private String id;
    private String type;
    private String mode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
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
        Registry registry = (Registry) object;
        return Objects.equals(this.name, registry.name) && Objects.equals(this.id, registry.id)
                && Objects.equals(this.type, registry.type) && Objects.equals(this.mode, registry.mode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, type, mode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Registry {").append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    name: ").append(toIndentedString(name)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    id: ").append(toIndentedString(id)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    type: ").append(toIndentedString(type)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    mode: ").append(toIndentedString(mode)).append(EndpointCentralConstants.LINE_BREAK);
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
