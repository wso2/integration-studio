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
 * Represent the payload sent to servlet for importing API specifications.
 */
public class APIImportPayload {
    private String id;
    private String projectName;
    private String apiName;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * Check whether type of given object and attributes of given object equals to this object.
     * 
     * @param bbject object
     */
    @Override
    public boolean equals(Object bbject) {
        if (this == bbject) {
            return true;
        }
        if (bbject == null || getClass() != bbject.getClass()) {
            return false;
        }
        APIImportPayload aPIImportPayload = (APIImportPayload) bbject;
        return Objects.equals(this.id, aPIImportPayload.id)
                && Objects.equals(this.projectName, aPIImportPayload.projectName)
                && Objects.equals(this.apiName, aPIImportPayload.apiName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectName, apiName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class APIImportPayload {").append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    id: ").append(toIndentedString(id)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    projectName: ").append(toIndentedString(projectName))
                .append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    apiName: ").append(toIndentedString(apiName)).append(EndpointCentralConstants.LINE_BREAK);
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
