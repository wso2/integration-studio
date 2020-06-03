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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeGroupValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValue;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.Connection;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorRoot;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.Element;

public class ConnectionParameterRenderer {

    HashMap<String, Control> controlList;
    HashMap<String, Composite> compositeList;
    HashMap<String, Control> requiredList;
    PropertiesWidgetProvider widgetProvider;
    private FormToolkit widgetFactory;

    public ConnectionParameterRenderer(FormToolkit widgetFactory) {
        this.widgetFactory = widgetFactory;
        this.controlList = new HashMap<>();
        this.compositeList = new HashMap<>();
        this.requiredList = new HashMap<>();
        this.widgetProvider = new PropertiesWidgetProvider(controlList, compositeList, requiredList);
    }

    public HashMap<String, Control> generate(Composite parent, ConnectorRoot connectorRoot,
            Map<String, String> updateConfigMap, AttributeValue allowedConnectionTypes) {
        parent.setBackgroundMode(SWT.INHERIT_FORCE);

        boolean isFirstTime = true;
        CTabFolder tabFolder = null;
        for (Element elem : connectorRoot.getElements()) {
            if (elem.getType().equals("attribute")) {
                evaluateAttribute((AttributeValue) elem.getValue(), parent, widgetFactory, 0);
            }
        }
        
        List<Connection> connectorConnectionTypes = allowedConnectionTypes.getAllowedConnectionTypes();
        allowedConnectionTypes.setDisplayName("Connection Type");
        allowedConnectionTypes.setName("connectionType");
        String connectionTypes[] = new String[connectorConnectionTypes.size()]; 
        for (int j = 0; j < connectorConnectionTypes.size(); j++) { 
            connectionTypes[j] = connectorConnectionTypes.get(j).toString(); 
        } 
        widgetProvider.createDropDownField(widgetFactory, parent, connectionTypes, allowedConnectionTypes);

        for (Element elem : connectorRoot.getElements()) {
            if (elem.getType().equals("attributeGroup")) {
                if (isFirstTime) {
                    Group tabSection = widgetProvider.createGroup(parent, "");
                    tabFolder = new CTabFolder(tabSection, SWT.NONE);
                    GridData tableLayoutData = new GridData(GridData.FILL_HORIZONTAL);
                    tabFolder.setLayoutData(tableLayoutData);
                    tabFolder.setBackground(new Color(Display.getCurrent(), 255, 255, 255));
                    isFirstTime = false;
                }
                AttributeGroupValue agv = (AttributeGroupValue) elem.getValue();
                CTabItem tabGeneralSection = new CTabItem(tabFolder, SWT.NULL);
                tabGeneralSection.setText(agv.getGroupName());

                Composite tabComposite = new Composite(tabFolder, SWT.NONE);
                GridLayout tabCompositeGroupLayout = new GridLayout();
                tabComposite.setLayout(tabCompositeGroupLayout);
                tabGeneralSection.setControl(tabComposite);
                for (Element ele : agv.getElements()) {
                    createDynamicWidgetComponents(ele, tabComposite);
                }
            }
        }

        tabFolder.setSelection(0);

        if (updateConfigMap != null && updateConfigMap.size() > 0) {
            for (Map.Entry<String, String> entry : updateConfigMap.entrySet()) {
                if (controlList.containsKey(entry.getKey())) {
                    Control control = controlList.get(entry.getKey());
                    if (control instanceof Text) {
                        ((Text) control).setText(entry.getValue());
                    } else if (control instanceof Combo) {
                        ((Combo) control).setText(entry.getValue());
                    }
                }
            }
        }
        return controlList;
    }

    public void createDynamicWidgetComponents(Element element, Composite parent) {
        if (element.getType().equals("attribute")) {
            evaluateAttribute((AttributeValue) element.getValue(), parent, widgetFactory, 0);
        } else {
            AttributeGroupValue agv = (AttributeGroupValue) element.getValue();
            Group subGroup = widgetProvider.createGroup(parent, agv.getGroupName());
            for (Element elem : agv.getElements()) {
                createDynamicWidgetComponents(elem, subGroup);
            }
        }
    }

    public void evaluateAttribute(AttributeValue value, Composite parent, FormToolkit widgetFactory, int level) {
        if (AttributeValueType.STRING.equals(value.getType())) {
            widgetProvider.createTextBoxFieldWithButton(widgetFactory, parent, value);
        } else if (AttributeValueType.BOOLEANOREXPRESSION.equals(value.getType())) {
            widgetProvider.createDropDownField(widgetFactory, parent, new String[] { "true", "false" }, value);
        } else if (AttributeValueType.COMBO.equals(value.getType())) {
            widgetProvider.createDropDownField(widgetFactory, parent, value.getComboValues().toArray(new String[0]),
                    value);
        } else if (AttributeValueType.CONNECTION.equals(value.getType())) {
            widgetProvider.createConnectionField(widgetFactory, parent, value, getConnectionEntriesList());
        }
    }

    public String[] getConnectionEntriesList() {
        return new String[] { "SMTP", "POP3", "IMAP" };
    }
}
