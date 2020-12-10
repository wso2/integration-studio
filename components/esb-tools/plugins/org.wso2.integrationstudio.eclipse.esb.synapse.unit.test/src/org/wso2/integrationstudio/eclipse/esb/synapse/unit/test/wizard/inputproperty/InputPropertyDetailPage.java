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

import org.apache.commons.lang3.text.WordUtils;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.InputProperty;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.SynapseUnitTest;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.model.TestCase;
import org.wso2.integrationstudio.eclipse.esb.synapse.unit.test.utils.ComboItems;

public class InputPropertyDetailPage extends WizardPage {

    private static final String DIALOG_TITLE = "Synapse Unit Test - Input Property Details";
    private static final String DIALOG_DESCRIPTION = "Enter Message Context, Axis2 or Transport level properties ";
    private static final String EMPTY_STRING = "";
    private static final String PROPERTY_SCOPE = "Property Scope:";
    private static final String PROPERTY_NAME = "Property Name:";
    private static final String PROPERTY_VALUE = "Property Value:";

    private String propertyName = EMPTY_STRING;
    private String propertyValue = EMPTY_STRING;
    private String propertyScope = EMPTY_STRING;

    private Text txtPropertyName;
    private Text txtPropertyValue;

    private boolean isPageDirty;
    private SynapseUnitTest synapseTestDataHolder;

    /**
     * Class constructor.
     */
    protected InputPropertyDetailPage(IWorkbench wb, IStructuredSelection selection, SynapseUnitTest synapseTestData) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        setDescription(DIALOG_DESCRIPTION);
        this.synapseTestDataHolder = synapseTestData;

        // check page loading for update status
        if (synapseTestData.isPropertyUpdate()) {
            String propertyKey = synapseTestData.getSelectedPropertyKey();

            InputProperty inputProperty;
            TestCase selectedTestCase = null;
            if (synapseTestData.isTestCaseUpdate()) {
                int testCaseKey = synapseTestData.getSelectedTestCaseKey();
                selectedTestCase = synapseTestData.getSelectedTestCase(testCaseKey);
            }

            if (selectedTestCase != null && selectedTestCase.getPropertyMap().containsKey(propertyKey)) {
                inputProperty = selectedTestCase.getSelectedProperty(propertyKey);
            } else {
                inputProperty = synapseTestData.getSelectedTemporalProperty(propertyKey);
            }

            fillUpdatingPropertyData(inputProperty);
        }
    }

    @Override
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);

        setControl(container);
        container.setLayout(new FormLayout());

        FormData data;

        Label lblPropertyScope = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(10);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblPropertyScope.setLayoutData(data);
        lblPropertyScope.setText(PROPERTY_SCOPE);

        final String[] PROP_LEVELS = ComboItems.getPropItems(synapseTestDataHolder.getTestArtifactType());
        final String[] PROP_NAME_ITEMS = ComboItems.getPropItemNames(synapseTestDataHolder.getTestArtifactType());
        Combo combo = new Combo(container, SWT.READ_ONLY | SWT.DROP_DOWN);
        data = new FormData();
        data.top = new FormAttachment(10);
        data.left = new FormAttachment(lblPropertyScope, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        combo.setItems(PROP_LEVELS);
        combo.setLayoutData(data);
        if (!getPropertyScope().isEmpty()) {
            combo.setText(WordUtils.capitalizeFully(getPropertyScope()));
        } else {
            combo.setText(PROP_LEVELS[0]);
            setPropertyScope(PROP_LEVELS[0]);
        }

        Label lblPropertyName = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(combo, 12);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblPropertyName.setLayoutData(data);
        lblPropertyName.setText(PROPERTY_NAME);

        Label lblPropertyPrefixName = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(combo, 12);
        data.left = new FormAttachment(lblPropertyName, 3);
        data.width = 46;
        data.height = 21;
        lblPropertyPrefixName.setLayoutData(data);
        lblPropertyPrefixName.setText(" " + PROP_NAME_ITEMS[0]);
        lblPropertyPrefixName.setBackground(new Color(null, 229, 236, 253));
        Font boldFont = new Font(null, new FontData("Arial", 12, SWT.BOLD));
        lblPropertyPrefixName.setFont(boldFont);

        txtPropertyName = new Text(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(combo, 12);
        data.left = new FormAttachment(lblPropertyPrefixName, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtPropertyName.setLayoutData(data);
        if (!getPropertyName().isEmpty()) {
            txtPropertyName.setText(getPropertyName());
        }

        combo.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                setPropertyScope(combo.getText());
                validate();

                if (getPropertyScope().equals(PROP_LEVELS[0])) {
                    lblPropertyPrefixName.setText(" " + PROP_NAME_ITEMS[0]);
                } else if (getPropertyScope().equals(PROP_LEVELS[1])) {
                    lblPropertyPrefixName.setText(" " + PROP_NAME_ITEMS[1]);
                } else if (getPropertyScope().equals(PROP_LEVELS[2])) {
                    lblPropertyPrefixName.setText(" " + PROP_NAME_ITEMS[2]);
                }
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        txtPropertyName.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setPropertyName(txtPropertyName.getText());
                validate();
            }
        });

        Label lblPropertyValue = new Label(container, SWT.NONE);
        data = new FormData();
        data.top = new FormAttachment(lblPropertyName, 20);
        data.left = new FormAttachment(3);
        data.width = 160;
        lblPropertyValue.setLayoutData(data);
        lblPropertyValue.setText(PROPERTY_VALUE);

        txtPropertyValue = new Text(container, SWT.BORDER);
        data = new FormData();
        data.top = new FormAttachment(lblPropertyName, 20);
        data.left = new FormAttachment(lblPropertyValue, 0);
        data.right = new FormAttachment(97);
        data.width = 400;
        txtPropertyValue.setLayoutData(data);
        txtPropertyValue.setLayoutData(data);
        if (!getPropertyValue().isEmpty()) {
            txtPropertyValue.setText(getPropertyValue());
        }

        txtPropertyValue.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                setPropertyValue(txtPropertyValue.getText());
                validate();
            }
        });

        setPageComplete(false);
    }

    /**
     * Method for validations of wizard page. If validation fails set page as dirty
     * and not complete
     */
    private void validate() {
        if (getPropertyScope() == null || getPropertyScope().isEmpty()) {
            setErrorMessage("Please specify a scope for the property");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getPropertyName() == null || getPropertyName().isEmpty()) {
            setErrorMessage("Please specify a name for the property");
            setPageComplete(false);
            setPageDirty(true);
            return;
        } else if (getPropertyValue() == null || getPropertyValue().isEmpty()) {
            setErrorMessage("Please specify a value for the property");
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
     * @param inputProperty
     *            input-property data
     */
    private void fillUpdatingPropertyData(InputProperty inputProperty) {
        setPropertyName(inputProperty.getName());
        setPropertyScope(inputProperty.getScope());
        setPropertyValue(inputProperty.getValue());
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyScope() {
        return propertyScope;
    }

    public void setPropertyScope(String propertyScope) {
        this.propertyScope = propertyScope;
    }

    public boolean isPageDirty() {
        return isPageDirty;
    }

    public void setPageDirty(boolean isPageDirty) {
        this.isPageDirty = isPageDirty;
    }
}
