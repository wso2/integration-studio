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
package org.wso2.developerstudio.eclipse.esb.synapse.unit.test.wizard.assertion;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.Assertion;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.model.TestCase;
import org.wso2.developerstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;

/**
 * Class responsible for creation of wizard of entering assertion details.
 */
public class AssertionCreationWizard extends Wizard implements IExportWizard {

    private final String WINDOW_TITLE = "Add Assertion for the Test Case";

    private AssertionDetailPage assertionDetailPage;
    private boolean initError = false;
    private SynapseUnitTest synapseTestDataHolder;

    public AssertionCreationWizard(SynapseUnitTest synapseTestData) {
        synapseTestDataHolder = synapseTestData;
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);
        assertionDetailPage = new AssertionDetailPage(workbench, selection, synapseTestDataHolder);
    }

    @Override
    public boolean performFinish() {
        if (assertionDetailPage.isPageDirty()) {
            return false;
        }

        String actualValue = assertionDetailPage.getActualValue();
        String assertionType = assertionDetailPage.getAssertionType();
        String errorMessage = assertionDetailPage.getAssertMessage();
        String expectedValue = assertionDetailPage.getExpectedValue();
        if (expectedValue != null) {
            expectedValue = CommonUtil.addCDATATagToPayloads(expectedValue);
        }

        Assertion assertion = new Assertion();
        assertion.setAssertType(assertionType);
        assertion.setActual(actualValue);
        assertion.setExpected(expectedValue);
        assertion.setMessage(errorMessage);

        String storeAssertKey = assertionType + "-" + actualValue;
        if (!synapseTestDataHolder.isAssertionUpdate()) {
            synapseTestDataHolder.addTemporaryAssertion(storeAssertKey, assertion);
        } else if (!synapseTestDataHolder.isTestCaseUpdate() && synapseTestDataHolder.isAssertionUpdate()) {
            String oldAssertKey = synapseTestDataHolder.getSelectedAssertionKey();
            synapseTestDataHolder.getTemporaryAssertions().remove(oldAssertKey);
            synapseTestDataHolder.addTemporaryAssertion(storeAssertKey, assertion);
        } else if (synapseTestDataHolder.isTestCaseUpdate() && synapseTestDataHolder.isAssertionUpdate()) {
            String oldAssertKey = synapseTestDataHolder.getSelectedAssertionKey();
            int testCaseKey = synapseTestDataHolder.getSelectedTestCaseKey();
            TestCase selectedTestCase = synapseTestDataHolder.getSelectedTestCase(testCaseKey);

            if (selectedTestCase.getAssertions().containsKey(oldAssertKey)) {
                selectedTestCase.removeSelectedAssertion(oldAssertKey);
                selectedTestCase.addAssertion(storeAssertKey, assertion);
            } else {
                synapseTestDataHolder.getTemporaryAssertions().remove(oldAssertKey);
                synapseTestDataHolder.addTemporaryAssertion(storeAssertKey, assertion);
            }
        }
        return true;
    }

    public void addPages() {
        if (!initError) {
            addPage(assertionDetailPage);
            super.addPages();
        }
    }
}
