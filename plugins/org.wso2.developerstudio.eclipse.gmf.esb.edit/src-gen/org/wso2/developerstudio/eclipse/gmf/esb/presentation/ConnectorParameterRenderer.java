/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 *
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.condition.manager.EnableConditionManager;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeGroupValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorRoot;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.Element;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ConnectorParameterRenderer extends PropertyParameterRenderer {

    HashMap<String, Control> controlList;
    HashMap<String, Control> requiredList;
    HashMap<String, Composite> compositeList;
    IPropertiesEditionComponent propertiesEditionComponent;
    SectionPropertiesEditingPart partForm;
    PropertiesWidgetProvider widgetProvider;
    private final EnableConditionManager enableConditionManager;
    private static IDeveloperStudioLog log = Logger.getLog(EEFPropertyViewUtil.PLUGIN_ID);
    public final int MAX_ALLOWED_ATTRTIBUTES = 100;
    private int attributeCount = 0;

    public ConnectorParameterRenderer(IPropertiesEditionComponent propertiesEditionComponent,
            SectionPropertiesEditingPart partForm) {

        this.propertiesEditionComponent = propertiesEditionComponent;
        this.partForm = partForm;
        this.controlList = new HashMap<String, Control>();
        this.compositeList = new HashMap<String, Composite>();
        this.requiredList = new HashMap<String, Control>();
        this.enableConditionManager = new EnableConditionManager(compositeList);
        widgetProvider = new PropertiesWidgetProvider(partForm, propertiesEditionComponent, controlList, compositeList,
                requiredList, enableConditionManager);
    }

    @Override
    public Composite generate(FormToolkit widgetFactory, Composite parent, ConnectorRoot connectorRoot) {
        // Create main group
        Group generalGroup = widgetProvider.createGroup(parent, "General");
        // Iterate over the ui schema
        for (Element elem : connectorRoot.getElements()) {
            recursive(elem, parent, generalGroup, widgetFactory, 0);
        }
        return parent;

    }

    public void recursive(Element element, Composite parent, Composite generalGroup, FormToolkit widgetFactory,
            int level) {

        ++level;
        if (element.getType().equals("attribute")) {
            attributeCount++;
            if (attributeCount < MAX_ALLOWED_ATTRTIBUTES) {
                if (level != 2) { // Will be 2 since ++ level
                    evaluateAttribute((AttributeValue) element.getValue(), parent, widgetFactory, level);
                } else {
                    evaluateAttribute((AttributeValue) element.getValue(), generalGroup, widgetFactory, level);
                }
            } else {
                widgetProvider.addToAttributeQueue(widgetFactory, parent, (AttributeValue) element.getValue()
                        );
            }
        } else {
            AttributeGroupValue agv = (AttributeGroupValue) element.getValue();
            // Is group Name connection special????
            if (level != 1) {
                Group subGroup = widgetProvider.createGroup(parent, agv.getGroupName());
                for (Element elem : agv.getElements()) {
                    recursive(elem, subGroup, generalGroup, widgetFactory, level);
                }
            } else {
                for (Element elem : agv.getElements()) {
                    recursive(elem, parent, generalGroup, widgetFactory, level);
                }
            }

        }
    }

    public void evaluateAttribute(AttributeValue value, Composite parent, FormToolkit widgetFactory, int level) {
        if (AttributeValueType.STRING.equals(value.getType())) {
            if (level == 2) {
                widgetProvider.createTextBoxField(widgetFactory, parent, value);
            } else {
                widgetProvider.createTextBoxFieldWithButton(widgetFactory, parent, value);
            }
        } else if (AttributeValueType.BOOLEANOREXPRESSION.equals(value.getType())) {
            widgetProvider.createDropDownField(widgetFactory, parent, new String[] { "true", "false" }, value);
        } else if (AttributeValueType.COMBO.equals(value.getType())) {
            widgetProvider.createDropDownField(widgetFactory, parent, value.getComboValues().toArray(new String[0]),
                    value);
        } else if (AttributeValueType.TEXTAREAOREXPRESSION.equals(value.getType())) {
            widgetProvider.createTextAreaFieldWithButton(widgetFactory, parent, value);
        } else if (AttributeValueType.CONNECTION.equals(value.getType())) {
            widgetProvider.createConnectionField(widgetFactory, parent, value,
                    getConnectionEntriesList(value.getAllowedConnectionTypes()));
        } else if (AttributeValueType.PASSWORDTEXTOREXPRESSION.equals(value.getType())) {
            widgetProvider.createPasswordTextBoxFieldWithButton(widgetFactory, parent, value);
        } else if (AttributeValueType.SEARCHBOX.equals(value.getType())) {
            widgetProvider.createSearchBoxFieldWithButton(widgetFactory, parent, value);
        } else if (AttributeValueType.KEYVALUETABLE.equals(value.getType())) {
            widgetProvider.createKeyValueTable(widgetFactory, parent, value);
        }
    }

    public String[] getConnectionEntriesList(List<String> allowedTypes) {

        ArrayList<String> availableConnections = null;
        try {
            availableConnections = EEFPropertyViewUtil.getAvailableConnectionEntriesList(allowedTypes);
        } catch (CoreException e) {
            log.error("Error loading available connections", e);
        }
        if (availableConnections == null || availableConnections.isEmpty()) {
            return new String[] { "" };
        } else {
            return availableConnections.toArray(new String[] {});
        }
    }

    // Triggerred with ecore event bus
    @Override
    public void fillData(EObject dataObject) {

        EList<CallTemplateParameter> parameterList = ((CloudConnectorOperation) dataObject).getConnectorParameters();
        enableConditionManager.handleValueChange(parameterList);
        /// Exclude properties which are not parameters
        String configRefValue = ((CloudConnectorOperation) dataObject).getConfigRef();
        Combo configRefCombo = (Combo) controlList.get("configRef");
        if (configRefCombo != null && configRefValue != null) {
            configRefCombo.select(configRefCombo.indexOf(configRefValue));
            Button connectionEditButton = (Button) configRefCombo.getData("editConnectionButton");
            connectionEditButton.setEnabled(true);
        }
        String descriptionValue = ((CloudConnectorOperation) dataObject).getDescription();
        Text descriptionText = (Text) controlList.get("description");
        if (descriptionText != null) {
            descriptionText.setText(descriptionValue);
        }

        // Iterate through controlList and fill data
        for (String key : controlList.keySet()) {
            CallTemplateParameter ctp = null;
            for (Object parameter : parameterList) {
                CallTemplateParameter ctpi = (CallTemplateParameter) parameter;
                if (((String) key).equals(ctpi.getParameterName())) {
                    ctp = ctpi;
                }
            }
            if (ctp != null) {
                String value = ctp.getParameterValue();
                if (ctp.getTemplateParameterType().equals(RuleOptionType.EXPRESSION)) {
                    NamespacedProperty namespacedExpression = ctp.getParameterExpression();
                    value = namespacedExpression.getPropertyValue();
                    if (controlList.get(key) instanceof Text) {
                        StyledText expText = (StyledText) controlList
                                .get(key + EEFPropertyConstants.EXPRESSION_FIELD_SUFFIX);
                        expText.setText(value);
                        expText.setData(ctp);
                        ((Text) controlList.get(key)).setData(ctp);
                    } else if (controlList.get(key) instanceof Combo) {
                        StyledText expText = (StyledText) controlList
                                .get(key + EEFPropertyConstants.EXPRESSION_FIELD_SUFFIX);
                        expText.setText(value);
                        expText.setData(ctp);
                        Combo combo = (Combo) controlList.get(key);
                        combo.setData(ctp);
                    }
                    Control exButton = (Control) controlList.get(key).getData(EEFPropertyConstants.ASSOCIATED_BUTTON);
                    if (exButton != null && exButton instanceof Button) {
                        ((Button) exButton).setSelection(true);
                        ((Button) exButton).notifyListeners(SWT.Selection, new Event());
                    }

                } else {
                    if (controlList.get(key) instanceof Text) {
                        ((Text) controlList.get(key)).setText(value);
                        ((Text) controlList.get(key)).setData(ctp);
                    } else if (controlList.get(key) instanceof Combo) {
                        Combo combo = (Combo) controlList.get(key);
                        combo.setText(value);
                        combo.setData(ctp);
                    } else if (controlList.get(key) instanceof Table) {
                        Table table = (Table) controlList.get(key);
                        table.setData(ctp);
                        try {
                            widgetProvider.deserializeKeyValueTableJson(ctp.getParameterValue(), table);
                        } catch (JSONException e) {
                            log.error("Error parsing JSON string", e);
                        }
                    }
                    Control expControl = controlList.get(key + EEFPropertyConstants.EXPRESSION_FIELD_SUFFIX);
                    if (expControl != null) {
                        ((StyledText) expControl).setData(ctp);
                    }

                }
            }

        }
        validate();
        widgetProvider.checkRequired();
    }

    public void addDefaultValues() {

        for (Control control : controlList.values()) {

            AttributeValue uiSchemaValue = (AttributeValue) control.getData(EEFPropertyConstants.UI_SCHEMA_OBJECT_KEY);
            if (uiSchemaValue != null) {
                String defaultValue = uiSchemaValue.getDefaultValue();

                if (control instanceof Text) {
                    Text text = (Text) control;
                    if (uiSchemaValue.getRequired() && defaultValue != null && !defaultValue.isEmpty()
                            && text.getText().equals("")) {
                        text.setText(defaultValue);
                        text.notifyListeners(SWT.KeyUp, new Event());
                    }

                } else if (control instanceof Combo) {
                    Combo combo = (Combo) control;
                    if (defaultValue != null && !defaultValue.isEmpty() && combo.getText().equals("")) {
                        combo.setText(defaultValue);
                        combo.notifyListeners(SWT.Selection, new Event());
                    }
                }
            }

        }
    }

    public void validate() {
        // Todo: Enable condition logic
    }

}
