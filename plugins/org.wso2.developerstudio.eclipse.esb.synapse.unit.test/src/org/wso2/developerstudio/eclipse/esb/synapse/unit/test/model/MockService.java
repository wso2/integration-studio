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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model;

import java.util.LinkedHashMap;

/**
 * Class responsible handle Mock Service data.
 */
public class MockService {

    private String mockServiceName;
    private int mockServicePort;
    private String mockServiceContext;
    private LinkedHashMap<String, MockServiceResource> resources = new LinkedHashMap<>();

    private LinkedHashMap<String, String> temporalRequestHeaders = new LinkedHashMap<>();
    private LinkedHashMap<String, String> temporalResponseHeaders = new LinkedHashMap<>();

    private boolean isMockServiceResourceUpdate;
    private boolean isMockServiceRequestHeaderUpdate;
    private boolean isMockServiceResponseHeaderUpdate;

    private String selectedMockResourceKey;
    private String selectedRequestHeaderKey;
    private String selectedResponseHeaderKey;

    public String getServiceName() {
        return mockServiceName;
    }

    public void setMockServiceName(String serviceName) {
        this.mockServiceName = serviceName;
    }

    public int getMockServicePort() {
        return mockServicePort;
    }

    public void setMockServicePort(int servicePort) {
        this.mockServicePort = servicePort;
    }

    public String getMockServiceContext() {
        return mockServiceContext;
    }

    public void setMockServiceContext(String serviceContext) {
        this.mockServiceContext = serviceContext;
    }

    public LinkedHashMap<String, MockServiceResource> getMockResources() {
        return resources;
    }

    public MockServiceResource getMockResource(String key) {
        return resources.get(key);
    }
    
    public void clearAllMockResources() {
        this.resources.clear();
    }

    public void addMockResources(String key, MockServiceResource resource) {
        this.resources.put(key, resource);
    }

    public void removeMockResource(String key) {
        this.resources.remove(key);
    }

    public boolean isMockServiceResourceUpdate() {
        return isMockServiceResourceUpdate;
    }

    public void setMockServiceResourceUpdate(boolean isMockServiceResourceUpdate) {
        this.isMockServiceResourceUpdate = isMockServiceResourceUpdate;
    }

    public boolean isMockServiceRequestHeaderUpdate() {
        return isMockServiceRequestHeaderUpdate;
    }

    public void setMockServiceRequestHeaderUpdate(boolean isMockServiceRequestHeaderUpdate) {
        this.isMockServiceRequestHeaderUpdate = isMockServiceRequestHeaderUpdate;
    }

    public boolean isMockServiceResponseHeaderUpdate() {
        return isMockServiceResponseHeaderUpdate;
    }

    public void setMockServiceResponseHeaderUpdate(boolean isMockServiceResponseHeaderUpdate) {
        this.isMockServiceResponseHeaderUpdate = isMockServiceResponseHeaderUpdate;
    }

    public LinkedHashMap<String, String> getTemporalRequestHeaders() {
        return temporalRequestHeaders;
    }

    public String getTemporalRequestHeaderValue(String key) {
        return temporalRequestHeaders.get(key);
    }

    public void addTemporalRequestHeaders(String key, String value) {
        this.temporalRequestHeaders.put(key, value);
    }

    public void removeTemporalRequestHeaders(String key) {
        this.temporalRequestHeaders.remove(key);
    }

    public LinkedHashMap<String, String> getTemporalResponseHeaders() {
        return temporalResponseHeaders;
    }

    public String getTemporalResponseHeaderValue(String key) {
        return temporalResponseHeaders.get(key);
    }

    public void addTemporalResponseHeaders(String key, String value) {
        this.temporalResponseHeaders.put(key, value);
    }

    public void removeTemporalResponseHeaders(String key) {
        this.temporalResponseHeaders.remove(key);
    }

    public void clearAllTemporalDataHolders() {
        temporalResponseHeaders.clear();
        temporalRequestHeaders.clear();
    }

    public String getSelectedMockResourceKey() {
        return selectedMockResourceKey;
    }

    public void setSelectedMockResourceKey(String selectedMockResourceKey) {
        this.selectedMockResourceKey = selectedMockResourceKey;
    }

    public String getSelectedRequestHeaderKey() {
        return selectedRequestHeaderKey;
    }

    public void setSelectedRequestHeaderKey(String selectedRequestHeaderKey) {
        this.selectedRequestHeaderKey = selectedRequestHeaderKey;
    }

    public String getSelectedResponseHeaderKey() {
        return selectedResponseHeaderKey;
    }

    public void setSelectedResponseHeaderKey(String selectedResponseHeaderKey) {
        this.selectedResponseHeaderKey = selectedResponseHeaderKey;
    }
}
