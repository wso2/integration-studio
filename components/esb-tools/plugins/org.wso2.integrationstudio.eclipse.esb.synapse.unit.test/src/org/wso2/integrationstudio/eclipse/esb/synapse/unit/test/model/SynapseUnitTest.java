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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Class responsible handle unit test data.
 */
public class SynapseUnitTest {

    private int testCaseCount;
    private String testArtifactType;
    private String testArtifact;
    private List<String> supportiveArtifacts = new ArrayList<>();
    private LinkedHashMap<String, RegistryResource> registryResources = new LinkedHashMap<>();
    private List<String> connectorFiles = new ArrayList<>();
    private List<String> mockServices = new ArrayList<>();
    private LinkedHashMap<Integer, TestCase> testCases = new LinkedHashMap<>();
    private Map<Integer, Integer> testCaseTableMapping = new HashMap<>();

    private boolean isTestCaseUpdate;
    private boolean isPropertyUpdate;
    private boolean isAssertionUpdate;

    private int selectedTestCaseKey;
    private String selectedPropertyKey;
    private String selectedAssertionKey;

    private LinkedHashMap<String, InputProperty> temporaryPropertyMap = new LinkedHashMap<>();
    private LinkedHashMap<String, Assertion> temporaryAssertionMap = new LinkedHashMap<>();

    public String getTestArtifactType() {
        return testArtifactType;
    }

    public void setTestArtifactType(String testArtifactType) {
        this.testArtifactType = testArtifactType;
    }

    public String getTestArtifact() {
        return testArtifact;
    }

    public void setTestArtifact(String testArtifact) {
        this.testArtifact = testArtifact;
    }

    public List<String> getSupportiveArtifacts() {
        return supportiveArtifacts;
    }

    public List<String> getConnectorFiles() {
        return connectorFiles;
    }

    public void addSupportiveArtifacts(String supportiveArtifacts) {
        this.supportiveArtifacts.add(supportiveArtifacts);
    }

    public void addConnectorFile(String connectorFile) {
        this.connectorFiles.add(connectorFile);
    }

    public LinkedHashMap<String, RegistryResource> getRegistryResource() {
        return registryResources;
    }

    public void addRegistryResource(RegistryResource resource) {
        this.registryResources.put(resource.getFileName(), resource);
    }

    public List<String> getMockServices() {
        return mockServices;
    }

    public void addMockServices(String mockServices) {
        this.mockServices.add(mockServices);
    }

    public LinkedHashMap<Integer, TestCase> getTestCases() {
        return testCases;
    }

    public TestCase getSelectedTestCase(int key) {
        return testCases.get(key);
    }

    public void removeSelectedTestCase(int key) {
        this.testCases.remove(key);
    }

    public void addTestCases(int testCode, TestCase testCase) {
        this.testCases.put(testCode, testCase);
    }

    public void clearDataHolders() {
        supportiveArtifacts.clear();
        mockServices.clear();
        testCases.clear();
    }

    public boolean isTestCaseUpdate() {
        return isTestCaseUpdate;
    }

    public void setTestCaseUpdate(boolean isTestCaseUpdate) {
        this.isTestCaseUpdate = isTestCaseUpdate;
    }

    public boolean isPropertyUpdate() {
        return isPropertyUpdate;
    }

    public void setPropertyUpdate(boolean isPropertyUpdate) {
        this.isPropertyUpdate = isPropertyUpdate;
    }

    public boolean isAssertionUpdate() {
        return isAssertionUpdate;
    }

    public void setAssertionUpdate(boolean isAssertionUpdate) {
        this.isAssertionUpdate = isAssertionUpdate;
    }

    public LinkedHashMap<String, InputProperty> getTemporaryPropertyMap() {
        return temporaryPropertyMap;
    }

    public void addTemporaryPropertyMap(String key, InputProperty property) {
        this.temporaryPropertyMap.put(key, property);
    }

    public void removeSelectedTemporalProperty(String key) {
        this.temporaryPropertyMap.remove(key);
    }

    public InputProperty getSelectedTemporalProperty(String key) {
        return this.temporaryPropertyMap.get(key);
    }

    public LinkedHashMap<String, Assertion> getTemporaryAssertions() {
        return temporaryAssertionMap;
    }

    public Assertion getSelectedTemporalAssertion(String key) {
        return this.temporaryAssertionMap.get(key);
    }

    public void removeSelectedTemporalAssertion(String key) {
        this.temporaryAssertionMap.remove(key);
    }

    public void addTemporaryAssertion(String key, Assertion assertion) {
        this.temporaryAssertionMap.put(key, assertion);
    }

    public int getSelectedTestCaseKey() {
        return selectedTestCaseKey;
    }

    public void setSelectedTestCaseKey(int selectedTestCaseKey) {
        this.selectedTestCaseKey = selectedTestCaseKey;
    }

    public String getSelectedPropertyKey() {
        return selectedPropertyKey;
    }

    public void setSelectedPropertyKey(String selectedPropertyKey) {
        this.selectedPropertyKey = selectedPropertyKey;
    }

    public String getSelectedAssertionKey() {
        return selectedAssertionKey;
    }

    public void setSelectedAssertionKey(String selectedAssertionKey) {
        this.selectedAssertionKey = selectedAssertionKey;
    }

    public void clearAllTemporalDataHolders() {
        temporaryPropertyMap.clear();
        temporaryAssertionMap.clear();
    }

    public int getTestCaseCount() {
        return testCaseCount;
    }

    public void setTestCaseCount(int testCaseCount) {
        this.testCaseCount = testCaseCount;
    }

    public void addTestCaseTableMapping(int index, int testCaseCode) {
        this.testCaseTableMapping.put(index, testCaseCode);
    }

    public int getTestCaseCodeFromTableMapping(int index) {
        return this.testCaseTableMapping.get(index);
    }

    public void clearTestCaseTableMapping() {
        testCaseTableMapping.clear();
    }
}
