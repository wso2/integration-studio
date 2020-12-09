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
package org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.wizard.assertion;

import java.util.Map;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.component.SyntaxHighlightTextBox;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.constant.Constants;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.Assertion;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.InputProperty;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.TestCase;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils.ComboTypingSuggestUtil;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils.CommonUtil;

/**
 * Class responsible for creation of wizard page of assertion details.
 */
public class AssertionDetailPage extends WizardPage {

    private static final String DIALOG_TITLE = "Unit Test - Assertions";
    private static final String DIALOG_DESCRIPTION = "Enter types of assertions which want to test";
    private static final String EMPTY_STRING = "";
    private static final String ASSERTION_TYPE = "Assertion Type:";
    private static final String ASSERTION_ACTUAL = "Actual Expression:";
    private static final String ASSERTION_EXPECTED = "Expected Value:";
    private static final String ERROR_MESSAGE = "Error Message:";

    private String assertionType = EMPTY_STRING;
    private String actualValue = EMPTY_STRING;
    private String expectedValue = EMPTY_STRING;
    private String message = EMPTY_STRING;

    private StyledText txtExpectedValue;
    private Text txtErrorAssertEqualMessage;
    private Text txtErrorAssertNotNullMessage;

    private Composite subAssertEqualContainer;
    private Composite subAssertNotNullContainer;
    private Combo assertionComboType;
    private Combo actualExpressions;

    private boolean isPageDirty;
    private SynapseUnitTest synapseDataHolder;

    /**
     * Class constructor.
     */
    protected AssertionDetailPage(IWorkbench wb, IStructuredSelection selection, SynapseUnitTest synapseTestData) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        setDescription(DIALOG_DESCRIPTION);
        this.synapseDataHolder = synapseTestData;

        // check page loading for update status
        if (synapseTestData.isAssertionUpdate()) {
            TestCase selectedTestCase = null;
            if (synapseTestData.isTestCaseUpdate()) {
                int testCaseKey = synapseTestData.getSelectedTestCaseKey();
                selectedTestCase = synapseTestData.getSelectedTestCase(testCaseKey);
            }

            String assertionKey = synapseTestData.getSelectedAssertionKey();
            Assertion assertion;
            if (selectedTestCase != null && selectedTestCase.getAssertions().containsKey(assertionKey)) {
                assertion = selectedTestCase.getSelectedAssertion(assertionKey);
            } else {
                assertion = synapseTestData.getSelectedTemporalAssertion(assertionKey);
            }

            fillUpdatingAssertionlData(assertion);
        }
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(parent);
        container.setLayout(new FormLayout());

        FormData data;

        Label lblAssertionType = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(10);
        data.left = new FormAttachment(3);
        data.width = 210;
        lblAssertionType.setLayoutData(data);
        lblAssertionType.setText(ASSERTION_TYPE);

        String[] ITEMS = { "AssertEquals", "AssertNotNull" };
        assertionComboType = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
        data = new FormData();
        data.top = new FormAttachment(10);
        data.left = new FormAttachment(lblAssertionType, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        assertionComboType.setItems(ITEMS);
        assertionComboType.setLayoutData(data);
        if (!getAssertionType().isEmpty()) {
            assertionComboType.setText(getAssertionType());
        } else {
            assertionComboType.setText(ITEMS[0]);
            setAssertionType(ITEMS[0]);
        }

        assertionComboType.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                setAssertionType(assertionComboType.getText());
                setActualValue(EMPTY_STRING);
                setAssertMessage(EMPTY_STRING);
                setExpectedValue(EMPTY_STRING);
                actualExpressions.setText(getActualValue());
                txtExpectedValue.setText(getExpectedValue());
                txtErrorAssertEqualMessage.setText(getAssertMessage());
                txtErrorAssertNotNullMessage.setText(getAssertMessage());

                viewAssertionFields();
                validate();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        Label lblAssertActual = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(assertionComboType, 12);
        data.left = new FormAttachment(3);
        data.width = 210;
        lblAssertActual.setLayoutData(data);
        lblAssertActual.setText(ASSERTION_ACTUAL);

        String[] expressions = createActualExpressionArray();
        actualExpressions = new Combo(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(assertionComboType, 12);
        data.left = new FormAttachment(lblAssertActual, 0);
        data.right = new FormAttachment(97);
        actualExpressions.setItems(expressions);
        actualExpressions.setLayoutData(data);
        ComboTypingSuggestUtil.addAutoCompleteFeature(actualExpressions);
        if (!getActualValue().isEmpty()) {
            actualExpressions.setText(getActualValue());
        }

        actualExpressions.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                setActualValue(actualExpressions.getText());

                validate();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        actualExpressions.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setActualValue(actualExpressions.getText());
                validate();
            }
        });

        subAssertEqualContainer = new Composite(container, SWT.NULL);
        subAssertNotNullContainer = new Composite(container, SWT.NULL);
        subAssertNotNullContainer.setLayout(new FormLayout());
        subAssertEqualContainer.setLayout(new FormLayout());

        data = new FormData();
        data.top = new FormAttachment(lblAssertActual, 5);
        data.left = new FormAttachment(3);
        data.right = new FormAttachment(97);
        data.height = 350;
        subAssertEqualContainer.setLayoutData(data);
        subAssertNotNullContainer.setLayoutData(data);

        showAssertNotNullContainer(0);
        showAssertEqualContainer(0);

        viewAssertionFields();
        setPageComplete(false);
    }

    /**
     * Method for validations of wizard page. If validation fails set page as dirty
     * and not complete
     */
    private void validate() {
        if (getAssertionType() == null || getAssertionType().isEmpty()) {
            setErrorMessage("Please specify a type for the assertion");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getActualValue() == null || getActualValue().isEmpty()) {
            setErrorMessage("Please specify an actual value for the assertion");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getAssertionType().equals(Constants.ASSERT_EQUAL_TYPE)
                && (getExpectedValue() == null || getExpectedValue().isEmpty())) {
            setErrorMessage("Please specify an expected value for the AssertEquals");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getAssertMessage() == null || getAssertMessage().isEmpty()) {
            setErrorMessage("Please specify an error message for the assertion");
            setPageComplete(false);
            setPageDirty(true);
            return;
        }

        setPageDirty(false);
        setErrorMessage(null);
        setPageComplete(true);
    }

    /**
     * Method for filling updating data to wizard page.
     *
     * @param assertion
     *            Assertion data
     */
    private void fillUpdatingAssertionlData(Assertion assertion) {
        setAssertionType(assertion.getAssertType());
        setActualValue(assertion.getActual());
        setExpectedValue(assertion.getExpected());
        setAssertMessage(assertion.getMessage());
    }

    /**
     * Method for get visible the correct composite for assertions.
     */
    private void viewAssertionFields() {
        if (assertionComboType.getText().equals(Constants.ASSERT_EQUAL_TYPE)) {
            subAssertNotNullContainer.setVisible(false);
            subAssertEqualContainer.setVisible(true);

        } else if (assertionComboType.getText().equals(Constants.ASSERT_NOTNULL_TYPE)) {
            subAssertNotNullContainer.setVisible(true);
            subAssertEqualContainer.setVisible(false);
        }
    }

    /**
     * Method for add AssertEqual container to the parent.
     *
     * @param style
     */
    private void showAssertEqualContainer(int style) {
        FormData data = new FormData();

        Label lblAssertExpected = new Label(subAssertEqualContainer, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(style, 20);
        data.left = new FormAttachment(0);
        data.width = 210;
        lblAssertExpected.setLayoutData(data);
        lblAssertExpected.setText(ASSERTION_EXPECTED);

        SyntaxHighlightTextBox syntaxStyler = new SyntaxHighlightTextBox();
        txtExpectedValue = syntaxStyler.getStyledTextBox(subAssertEqualContainer);
        data = new FormData();
        data.top = new FormAttachment(style, 20);
        data.left = new FormAttachment(lblAssertExpected, 0);
        data.right = new FormAttachment(99);
        data.height = 100;
        txtExpectedValue.setLayoutData(data);
        if (getExpectedValue() != null && !getExpectedValue().isEmpty()) {
            txtExpectedValue.setText(CommonUtil.removeCDATAFromPayload(getExpectedValue()));
            syntaxStyler.chooseSyntaxHighlighter(txtExpectedValue.getText(), false);
        }

        txtExpectedValue.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setExpectedValue(txtExpectedValue.getText());
                syntaxStyler.chooseSyntaxHighlighter(txtExpectedValue.getText(), false);
                validate();
            }
        });

        Label lblAssertMessage = new Label(subAssertEqualContainer, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(txtExpectedValue, 15);
        data.left = new FormAttachment(0);
        data.width = 210;
        lblAssertMessage.setLayoutData(data);
        lblAssertMessage.setText(ERROR_MESSAGE);

        txtErrorAssertEqualMessage = new Text(subAssertEqualContainer, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(txtExpectedValue, 15);
        data.left = new FormAttachment(lblAssertMessage, 0);
        data.right = new FormAttachment(99);
        txtErrorAssertEqualMessage.setLayoutData(data);
        if (!getAssertMessage().isEmpty()) {
            txtErrorAssertEqualMessage.setText(getAssertMessage());
        }

        txtErrorAssertEqualMessage.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setAssertMessage(txtErrorAssertEqualMessage.getText());
                validate();
            }
        });
    }

    /**
     * Method for add AssertNotNull container to the parent.
     *
     * @param style
     */
    private void showAssertNotNullContainer(int style) {
        FormData data = new FormData();

        Label lblAssertMessage = new Label(subAssertNotNullContainer, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(style, 18);
        data.left = new FormAttachment(0);
        data.width = 210;
        lblAssertMessage.setLayoutData(data);
        lblAssertMessage.setText(ERROR_MESSAGE);

        txtErrorAssertNotNullMessage = new Text(subAssertNotNullContainer, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(style, 18);
        data.left = new FormAttachment(lblAssertMessage, 0);
        data.right = new FormAttachment(99);
        txtErrorAssertNotNullMessage.setLayoutData(data);
        if (!getAssertMessage().isEmpty()) {
            txtErrorAssertNotNullMessage.setText(getAssertMessage());
        }

        txtErrorAssertNotNullMessage.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setAssertMessage(txtErrorAssertNotNullMessage.getText());
                validate();
            }
        });
    }

    /**
     * Method for creating expression array to the Assert actual Combo.
     * 
     * @return string array of expressions
     */
    private String[] createActualExpressionArray() {
        String[] expressionArray;
        int totalSize = 1;
        TestCase testCase = null;

        if (synapseDataHolder.isTestCaseUpdate()) {
            int testCaseKey = synapseDataHolder.getSelectedTestCaseKey();
            testCase = synapseDataHolder.getSelectedTestCase(testCaseKey);
            totalSize += testCase.getPropertyMap().size();
        }

        totalSize += synapseDataHolder.getTemporaryPropertyMap().size();
        expressionArray = new String[totalSize];

        if (synapseDataHolder.isTestCaseUpdate()) {
            for (Map.Entry<String, InputProperty> prop : testCase.getPropertyMap().entrySet()) {
                if (prop.getValue().getScope().toLowerCase().equals(Constants.SYNAPSE_LEVEL)) {
                    expressionArray[totalSize - 1] = Constants.SYNAPSE_EXPRESSION + prop.getValue().getName();
                } else if (prop.getValue().getScope().toLowerCase().equals(Constants.AXIS2_LEVEL)) {
                    expressionArray[totalSize - 1] = Constants.AXIS2_EXPRESSION + prop.getValue().getName();
                } else if (prop.getValue().getScope().toLowerCase().equals(Constants.TRANSPORT_LEVEL)) {
                    expressionArray[totalSize - 1] = Constants.TRANSPORT_EXPRESSION + prop.getValue().getName();
                }
                totalSize -= 1;
            }
        }

        for (Map.Entry<String, InputProperty> prop : synapseDataHolder.getTemporaryPropertyMap().entrySet()) {
            if (prop.getValue().getScope().toLowerCase().equals(Constants.SYNAPSE_LEVEL)) {
                expressionArray[totalSize - 1] = Constants.SYNAPSE_EXPRESSION + prop.getValue().getName();
            } else if (prop.getValue().getScope().toLowerCase().equals(Constants.AXIS2_LEVEL)) {
                expressionArray[totalSize - 1] = Constants.AXIS2_EXPRESSION + prop.getValue().getName();
            } else if (prop.getValue().getScope().toLowerCase().equals(Constants.TRANSPORT_LEVEL)) {
                expressionArray[totalSize - 1] = Constants.TRANSPORT_EXPRESSION + prop.getValue().getName();
            }
            totalSize -= 1;
        }

        expressionArray[totalSize - 1] = Constants.ASSERT_BODY_EXPRESSION;
        return expressionArray;
    }

    public String getAssertionType() {
        return assertionType;
    }

    public void setAssertionType(String assertionType) {
        this.assertionType = assertionType;
    }

    public String getActualValue() {
        return actualValue;
    }

    public void setActualValue(String actualValue) {
        this.actualValue = actualValue;
    }

    public String getExpectedValue() {
        return expectedValue;
    }

    public void setExpectedValue(String expectedValue) {
        this.expectedValue = expectedValue;
    }

    public String getAssertMessage() {
        return message;
    }

    public void setAssertMessage(String message) {
        this.message = message;
    }

    public boolean isPageDirty() {
        return isPageDirty;
    }

    public void setPageDirty(boolean isPageDirty) {
        this.isPageDirty = isPageDirty;
    }
}
