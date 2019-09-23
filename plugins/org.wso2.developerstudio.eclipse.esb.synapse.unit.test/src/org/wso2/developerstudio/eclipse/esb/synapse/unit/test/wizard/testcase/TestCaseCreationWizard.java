/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.

 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at

 * http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.testcase;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.Assertion;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.InputProperty;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.TestCase;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;

/**
 * Class responsible for creation of wizard page for test cases.
 */
public class TestCaseCreationWizard extends Wizard implements IExportWizard {

    private final String WINDOW_TITLE = "Add New Test Case";

    private boolean initError = false;
    private TestCaseDetailPage testSuiteDetailPage;
    private SynapseUnitTest synapseTestDataHolder;

    /**
     * Class constructor.
     */
    public TestCaseCreationWizard(SynapseUnitTest synapseTestData) {
        synapseTestDataHolder = synapseTestData;
        synapseTestDataHolder.clearAllTemporalDataHolders();
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);
        testSuiteDetailPage = new TestCaseDetailPage(workbench, selection, synapseTestDataHolder);
    }

    @Override
    public boolean performFinish() {
        if (testSuiteDetailPage.isPageDirty()) {
            return false;
        }

        String testCaseName = testSuiteDetailPage.getTestCaseName();
        String requestPath = testSuiteDetailPage.getResourcePath();
        String requestMethod = testSuiteDetailPage.getResourceMethod();
        String inputPayload = testSuiteDetailPage.getInputPayload();
        if (inputPayload != null && !inputPayload.isEmpty()) {
            inputPayload = CommonUtil.addCDATATagToPayloads(inputPayload);
        }
        LinkedHashMap<String, Assertion> assertions = synapseTestDataHolder.getTemporaryAssertions();
        LinkedHashMap<String, InputProperty> properties = synapseTestDataHolder.getTemporaryPropertyMap();

        if (!synapseTestDataHolder.isTestCaseUpdate()) {
            TestCase testCase = new TestCase();
            testCase.setTestCaseName(testCaseName);
            testCase.setRequestPath(requestPath);
            testCase.setRequestMethod(requestMethod);
            testCase.setInputPayload(inputPayload);

            for (Map.Entry<String, Assertion> assertEntry : assertions.entrySet()) {
                testCase.addAssertion(assertEntry.getKey(), assertEntry.getValue());
            }

            for (Map.Entry<String, InputProperty> propertyEntry : properties.entrySet()) {
                testCase.addPropertyMap(propertyEntry.getKey(), propertyEntry.getValue());
            }

            int testCaseCode = synapseTestDataHolder.getTestCaseCount();
            testCase.setTestCaseCode(testCaseCode);

            synapseTestDataHolder.addTestCases(testCaseCode, testCase);
            testCaseCode++;
            synapseTestDataHolder.setTestCaseCount(testCaseCode);
        } else {
            int testCaseKey = synapseTestDataHolder.getSelectedTestCaseKey();
            TestCase selectedTestCase = synapseTestDataHolder.getSelectedTestCase(testCaseKey);
            selectedTestCase.setTestCaseName(testCaseName);
            selectedTestCase.setRequestPath(requestPath);
            selectedTestCase.setRequestMethod(requestMethod);
            selectedTestCase.setInputPayload(inputPayload);

            for (Map.Entry<String, Assertion> assertEntry : assertions.entrySet()) {
                selectedTestCase.addAssertion(assertEntry.getKey(), assertEntry.getValue());
            }

            for (Map.Entry<String, InputProperty> propertyEntry : properties.entrySet()) {
                selectedTestCase.addPropertyMap(propertyEntry.getKey(), propertyEntry.getValue());
            }

            synapseTestDataHolder.addTestCases(testCaseKey, selectedTestCase);
        }

        return true;
    }

    public void addPages() {
        if (!initError) {
            addPage(testSuiteDetailPage);
            super.addPages();
        }
    }
}
