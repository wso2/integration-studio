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
 * Contains the API artifact data that needs to shown in the client application.
 */
public class APIArtifact {

    private String name;
    private String path;
    private String parent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
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
        APIArtifact apiArtifact = (APIArtifact) object;
        return Objects.equals(this.name, apiArtifact.name) && Objects.equals(this.path, apiArtifact.path)
                && Objects.equals(this.parent, apiArtifact.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path, parent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class APIArtifact {").append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    name: ").append(toIndentedString(name)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    path: ").append(toIndentedString(path)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    parent: ").append(toIndentedString(parent)).append(EndpointCentralConstants.LINE_BREAK);
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
