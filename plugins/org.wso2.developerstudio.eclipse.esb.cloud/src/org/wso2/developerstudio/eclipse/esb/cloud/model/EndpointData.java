/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

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

package org.wso2.developerstudio.eclipse.esb.cloud.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the response from retrieving all endpoints in an application
 * 
 */
public class EndpointData {
    List<Endpoint> restEndpoints;
    List<Endpoint> soapEndpoints;
    List<Endpoint> webEndpoints;
    List<Endpoint> swaggerEndpoints;

    public EndpointData() {
        super();
        restEndpoints = new ArrayList<>();
        soapEndpoints = new ArrayList<>();
        webEndpoints = new ArrayList<>();
        swaggerEndpoints = new ArrayList<>();
    }

    public List<Endpoint> getRestEndpoints() {
        return restEndpoints;
    }

    public void setRestEndpoints(List<Endpoint> restEndpoints) {
        this.restEndpoints = restEndpoints;
    }

    public List<Endpoint> getSoapEndpoints() {
        return soapEndpoints;
    }

    public void setSoapEndpoints(List<Endpoint> soapEndpoints) {
        this.soapEndpoints = soapEndpoints;
    }

    public List<Endpoint> getWebEndpoints() {
        return webEndpoints;
    }

    public void setWebEndpoints(List<Endpoint> webEndpoints) {
        this.webEndpoints = webEndpoints;
    }

    public List<Endpoint> getSwaggerEndpoints() {
        return swaggerEndpoints;
    }

    public void setSwaggerEndpoints(List<Endpoint> swaggerEndpoints) {
        this.swaggerEndpoints = swaggerEndpoints;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((restEndpoints == null) ? 0 : restEndpoints.hashCode());
        result = prime * result + ((soapEndpoints == null) ? 0 : soapEndpoints.hashCode());
        result = prime * result + ((swaggerEndpoints == null) ? 0 : swaggerEndpoints.hashCode());
        result = prime * result + ((webEndpoints == null) ? 0 : webEndpoints.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        EndpointData other = (EndpointData) obj;
        if (restEndpoints == null) {
            if (other.restEndpoints != null) {
                return false;
            }
        } else if (!restEndpoints.equals(other.restEndpoints)) {
            return false;
        }
        if (soapEndpoints == null) {
            if (other.soapEndpoints != null) {
                return false;
            }
        } else if (!soapEndpoints.equals(other.soapEndpoints)) {
            return false;
        }
        if (swaggerEndpoints == null) {
            if (other.swaggerEndpoints != null) {
                return false;
            }
        } else if (!swaggerEndpoints.equals(other.swaggerEndpoints)) {
            return false;
        }
        if (webEndpoints == null) {
            if (other.webEndpoints != null) {
                return false;
            }
        } else if (!webEndpoints.equals(other.webEndpoints)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EndpointData [restEndpoints=" + restEndpoints + ", soapEndpoints=" + soapEndpoints + ", webEndpoints="
                + webEndpoints + ", swaggerEndpoints=" + swaggerEndpoints + "]";
    }

}
