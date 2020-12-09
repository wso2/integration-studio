/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.actions;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_CLIENT_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_CLIENT_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.CLEAR_COMMAND;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.OPERATION_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.OPERATION_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SYANPSE_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SYNAPSE_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TRANSPORT_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TRANSPORT_PROPERTY_TAG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.PropertyChangeCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.PropertyValueBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;

/**
 * This class manages the dialog box for property clear message.
 *
 */
public class AddPropertyToTableDialog extends TitleAreaDialog {
    private String propertyContext;
    private String propertyKey;
    private Map<String, List<String>> propertyVariableMap;

    public AddPropertyToTableDialog(Shell parent, List<IVariable> variables) throws DebugException {
        super(parent);
        propertyVariableMap = new HashMap<String, List<String>>();
        populatePropertyVariableMap(variables);
    }

    @Override
    public void create() {
        super.create();
        setTitle(Messages.AddPropertyToTableDialog_DialogTitle);
        setMessage(Messages.AddPropertyToTableDialog_DialogDescription, IMessageProvider.INFORMATION);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout = new GridLayout(2, false);
        container.setLayout(layout);

        GridData dataPropertyConfigText = new GridData();
        dataPropertyConfigText.grabExcessHorizontalSpace = true;
        dataPropertyConfigText.horizontalAlignment = GridData.FILL;

        Label propertyContextLabel = new Label(container, SWT.NULL);
        propertyContextLabel.setText(Messages.ClearPropertyDialog_PropertContextLabel);
        final Combo propertyContextValueDropDown = new Combo(container, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
        propertyContextValueDropDown.setLayoutData(dataPropertyConfigText);
        propertyContextValueDropDown.add(AXIS2_CLIENT_PROPERTY_TAG);
        propertyContextValueDropDown.add(TRANSPORT_PROPERTY_TAG);
        propertyContextValueDropDown.add(AXIS2_PROPERTY_TAG);
        propertyContextValueDropDown.add(OPERATION_PROPERTY_TAG);
        propertyContextValueDropDown.add(SYANPSE_PROPERTY_TAG);

        Label propertyKeyLabel = new Label(container, SWT.NULL);
        propertyKeyLabel.setText(Messages.ClearPropertyDialog_PropertyNameLabel);
        final Combo propertyKeyValueDropDown = new Combo(container,
                SWT.DROP_DOWN | SWT.BORDER | SWT.H_SCROLL | SWT.READ_ONLY);
        propertyKeyValueDropDown.setLayoutData(dataPropertyConfigText);
        propertyContextValueDropDown.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    propertyContext = new String(propertyContextValueDropDown.getText());
                    propertyKeyValueDropDown.setText(""); //$NON-NLS-1$
                    propertyKeyValueDropDown.clearSelection();
                    updatePropertyKeyList();
                    if (!(StringUtils.isEmpty(propertyContext) || StringUtils.isEmpty(propertyKey))) {
                        getButton(IDialogConstants.OK_ID).setEnabled(true);
                    } else {
                        getButton(IDialogConstants.OK_ID).setEnabled(false);
                    }
                } catch (Exception e) {
                    getButton(IDialogConstants.OK_ID).setEnabled(false);
                }
            }

            private void updatePropertyKeyList() {
                propertyKeyValueDropDown.removeAll();
                List<String> propertyKeyList = propertyVariableMap.get(propertyContext);
                for (String key : propertyKeyList) {
                    propertyKeyValueDropDown.add(key);
                }

            }
        });
        propertyKeyValueDropDown.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    propertyKey = new String(propertyKeyValueDropDown.getText());
                    if (!(StringUtils.isEmpty(propertyContext) || StringUtils.isEmpty(propertyKey))) {
                        getButton(IDialogConstants.OK_ID).setEnabled(true);
                    } else {
                        getButton(IDialogConstants.OK_ID).setEnabled(false);
                    }
                } catch (Exception e) {
                    getButton(IDialogConstants.OK_ID).setEnabled(false);
                }
            }
        });
        return area;
    }

    @Override
    protected void okPressed() {
        super.okPressed();
    }

    @Override
    protected void cancelPressed() {
        super.cancelPressed();
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.AddPropertyToTableDialog_ShellTitle);
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

    private String getESBContextNameFromUITableVariableName(String name) {
        switch (name) {
        case AXIS2_PROPERTIES_TAG:
            return AXIS2_PROPERTY_TAG;
        case AXIS2_CLIENT_PROPERTIES_TAG:
            return AXIS2_CLIENT_PROPERTY_TAG;
        case SYNAPSE_PROPERTIES_TAG:
            return SYANPSE_PROPERTY_TAG;
        case TRANSPORT_PROPERTIES_TAG:
            return TRANSPORT_PROPERTY_TAG;
        case OPERATION_PROPERTIES_TAG:
            return OPERATION_PROPERTY_TAG;
        }
        return name;
    }

    private void populatePropertyVariableMap(List<IVariable> variables) throws DebugException {
        for (IVariable iVariable : variables) {
            String propertyContextName = getESBContextNameFromUITableVariableName(iVariable.getName());
            IVariable[] childPropertyArray = iVariable.getValue().getVariables();
            List<String> childVariableList = new ArrayList<>();
            for (IVariable childVariable : childPropertyArray) {
                childVariableList.add(childVariable.getName());
            }
            propertyVariableMap.put(propertyContextName, childVariableList);
        }
    }

    public PropertyChangeCommand getCommandMessage() {
        PropertyValueBean property = new PropertyValueBean(propertyKey, null);
        PropertyChangeCommand command = new PropertyChangeCommand(CLEAR_COMMAND, propertyContext, property);
        return command;
    }
}
