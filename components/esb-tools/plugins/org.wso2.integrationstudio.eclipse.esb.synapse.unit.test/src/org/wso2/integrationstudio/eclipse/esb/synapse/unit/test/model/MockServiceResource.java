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
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model;

import java.util.LinkedHashMap;

/**
 * Class responsible handle Mock Service Resource data.
 */
public class MockServiceResource {

    private String subContext;
    private String method;
    private String requestPayload;
    private String responsePayload;
    private int statusCode;
    private LinkedHashMap<String, String> requestHeaders = new LinkedHashMap<>();
    private LinkedHashMap<String, String> responseHeaders = new LinkedHashMap<>();

    public String getSubContext() {
        return subContext;
    }

    public void setSubContext(String subContext) {
        this.subContext = subContext;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(String requestPayload) {
        this.requestPayload = requestPayload;
    }

    public String getResponsePayload() {
        return responsePayload;
    }

    public void setResponsePayload(String responsePayload) {
        this.responsePayload = responsePayload;
    }

    public LinkedHashMap<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    public String getRequestHeaderValue(String key) {
        return requestHeaders.get(key);
    }

    public void addRequestHeaders(String key, String value) {
        this.requestHeaders.put(key, value);
    }

    public LinkedHashMap<String, String> getResponseHeaders() {
        return responseHeaders;
    }

    public String getResponseHeaderValue(String key) {
        return responseHeaders.get(key);
    }

    public void addResponseHeaders(String key, String value) {
        this.responseHeaders.put(key, value);
    }

    public void removeRequestHeader(String key) {
        this.requestHeaders.remove(key);
    }

    public void removeResponseHeader(String key) {
        this.responseHeaders.remove(key);
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
