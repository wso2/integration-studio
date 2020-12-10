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
 * Class responsible handle test case data.
 */
public class TestCase {

    private int testCaseCode;
    private String testCaseName;
    private String requestPath;
    private String requestMethod;
    private String inputPayload;
    private LinkedHashMap<String, InputProperty> propertyMap = new LinkedHashMap<>();
    private LinkedHashMap<String, Assertion> assertions = new LinkedHashMap<>();

    /**
     * Get test case code of particular test case.
     *
     * @return code of requested test case
     */
    public int getTestCaseCode() {
        return testCaseCode;
    }

    /**
     * Set test case code of particular test case.
     *
     * @param testCaseCode
     *            code of requested test case
     */
    public void setTestCaseCode(int testCaseCode) {
        this.testCaseCode = testCaseCode;
    }

    /**
     * Get input payload of particular test case.
     *
     * @return input payload of requested test case
     */
    public String getInputPayload() {
        return inputPayload;
    }

    /**
     * Get input property values of particular test case.
     *
     * @return expected property values of requested test case
     */
    public LinkedHashMap<String, InputProperty> getPropertyMap() {
        return propertyMap;
    }

    /**
     * Remove selected property.
     *
     * @param key
     *            key of property
     */
    public void removeSelectedProperty(String key) {
        propertyMap.remove(key);
    }

    /**
     * Get selected property from key.
     *
     * @param key
     *            property key
     * @return InputProperty data
     */
    public InputProperty getSelectedProperty(String key) {
        return propertyMap.get(key);
    }

    /**
     * Get assert equals set of particular test case.
     *
     * @return assert equals set of requested test case
     */
    public LinkedHashMap<String, Assertion> getAssertions() {
        return assertions;
    }

    /**
     * Remove selected assertion.
     *
     * @param key
     *            key of assertion
     */
    public void removeSelectedAssertion(String key) {
        assertions.remove(key);
    }

    /**
     * Get selected assertion from key.
     *
     * @param key
     *            property key
     * @return Assertion data
     */
    public Assertion getSelectedAssertion(String key) {
        return assertions.get(key);
    }

    /**
     * Get request path of particular test case.
     *
     * @return request path of requested test case
     */
    public String getRequestPath() {
        return requestPath;
    }

    /**
     * Get request method of particular test case.
     *
     * @return request method of requested test case
     */
    public String getRequestMethod() {
        return requestMethod;
    }

    /**
     * Get name of the test case.
     *
     * @return name of the test case
     */
    public String getTestCaseName() {
        return testCaseName;
    }

    /**
     * Add input payload into a ArrayList.
     *
     * @param inputPayload
     *            input payload of a particular test case
     */
    public void setInputPayload(String inputPayload) {
        this.inputPayload = inputPayload;
    }

    /**
     * Add input property values into a ArrayList.
     *
     * @param propertyMap
     *            input property values of a particular test case
     */
    public void addPropertyMap(String key, InputProperty property) {
        this.propertyMap.put(key, property);
    }

    /**
     * Add assertEquals set into a ArrayList.
     *
     * @param assertEquals
     *            assertEquals set of a particular test case
     */
    public void addAssertion(String key, Assertion assertion) {
        this.assertions.put(key, assertion);
    }

    /**
     * Add requestPath.
     *
     * @param requestPath
     *            requestPath of a particular test case
     */
    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    /**
     * Add requestMethod.
     *
     * @param requestMethod
     *            requestMethod of a particular test case
     */
    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    /**
     * Set test case name.
     *
     * @param testCaseName
     *            name of the test case
     */
    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }
}
