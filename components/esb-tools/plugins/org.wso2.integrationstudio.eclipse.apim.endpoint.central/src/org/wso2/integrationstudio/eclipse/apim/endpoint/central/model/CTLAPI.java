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

public class CTLAPI {
    private String Name;
    private String Context;
    private String Id;
    private String LifeCycleStatus;
    private String Provider;
    private String Version;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLifeCycleStatus() {
        return LifeCycleStatus;
    }

    public void setLifeCycleStatus(String lifeCycleStatus) {
        LifeCycleStatus = lifeCycleStatus;
    }

    public String getProvider() {
        return Provider;
    }

    public void setProvider(String provider) {
        Provider = provider;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
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
        CTLAPI CTLAPIPayload = (CTLAPI) object;
        return Objects.equals(this.Name, CTLAPIPayload.Name) && Objects.equals(this.Id, CTLAPIPayload.Id)
                && Objects.equals(this.Context, CTLAPIPayload.Context)
                && Objects.equals(this.LifeCycleStatus, CTLAPIPayload.LifeCycleStatus)
                && Objects.equals(this.Provider, CTLAPIPayload.Provider)
                && Objects.equals(this.Version, CTLAPIPayload.Version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Id, Context, LifeCycleStatus, Provider, Version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CTLAPI {").append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    Name: ").append(toIndentedString(Name)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    Id: ").append(toIndentedString(Id)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    Context: ").append(toIndentedString(Context)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    LifeCycleStatus: ").append(toIndentedString(LifeCycleStatus));
        sb.append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    Provider: ").append(toIndentedString(Provider)).append(EndpointCentralConstants.LINE_BREAK);
        sb.append("    Version: ").append(toIndentedString(Version)).append(EndpointCentralConstants.LINE_BREAK);
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
