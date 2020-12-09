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
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.inputproperty;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.InputProperty;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.TestCase;

/**
 * Class responsible for creation of input property wizard.
 */
public class InputPropertyCreationWizard extends Wizard implements IExportWizard {

    private final String WINDOW_TITLE = "Add Multiple Input Properties";

    private InputPropertyDetailPage propertyDetailPage;
    private boolean initError = false;
    private SynapseUnitTest synapseTestDataHolder;

    /**
     * Class constructor.
     */
    public InputPropertyCreationWizard(SynapseUnitTest synapseTestData) {
        synapseTestDataHolder = synapseTestData;
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        setWindowTitle(WINDOW_TITLE);
        propertyDetailPage = new InputPropertyDetailPage(workbench, selection, synapseTestDataHolder);
    }

    @Override
    public boolean performFinish() {
        if (propertyDetailPage.isPageDirty()) {
            return false;
        }

        String propertyScope = propertyDetailPage.getPropertyScope().toLowerCase();
        String propertyName = propertyDetailPage.getPropertyName();
        String propertyValue = propertyDetailPage.getPropertyValue();

        InputProperty property = new InputProperty();
        property.setName(propertyName);
        property.setScope(propertyScope);
        property.setValue(propertyValue);

        if (!synapseTestDataHolder.isPropertyUpdate()) {
            synapseTestDataHolder.addTemporaryPropertyMap(propertyName, property);
        } else if (!synapseTestDataHolder.isTestCaseUpdate() && synapseTestDataHolder.isPropertyUpdate()) {
            String oldPropertyKey = synapseTestDataHolder.getSelectedPropertyKey();
            synapseTestDataHolder.getTemporaryPropertyMap().remove(oldPropertyKey);
            synapseTestDataHolder.addTemporaryPropertyMap(propertyName, property);
        } else if (synapseTestDataHolder.isTestCaseUpdate() && synapseTestDataHolder.isPropertyUpdate()) {
            String oldPropertyKey = synapseTestDataHolder.getSelectedPropertyKey();
            int testCaseKey = synapseTestDataHolder.getSelectedTestCaseKey();
            TestCase selectedTestCase = synapseTestDataHolder.getSelectedTestCase(testCaseKey);

            if (selectedTestCase.getPropertyMap().containsKey(oldPropertyKey)) {
                selectedTestCase.removeSelectedProperty(oldPropertyKey);
                selectedTestCase.addPropertyMap(propertyName, property);
            } else {
                synapseTestDataHolder.getTemporaryPropertyMap().remove(oldPropertyKey);
                synapseTestDataHolder.addTemporaryPropertyMap(propertyName, property);
            }
        }

        return true;
    }

    public void addPages() {
        if (!initError) {
            addPage(propertyDetailPage);
            super.addPages();
        }
    }
}
