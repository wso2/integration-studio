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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_CLIENT_PROPERTIES_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_CLIENT_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_PROPERTIES_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.CLEAR_COMMAND;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.OPERATION_PROPERTIES_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.OPERATION_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SYNAPSE_PROPERTIES_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SYNAPSE_PROPERTIES_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TRANSPORT_PROPERTIES_KEY;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TRANSPORT_PROPERTIES_TAG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
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
public class ClearPropertyDialog extends Dialog {
    private String propertyContext;
    private String propertyKey;
    private Map<String, List<String>> propertyVariableMap;

    public ClearPropertyDialog(Shell parent, List<IVariable> variables) throws DebugException {
        super(parent);
        propertyVariableMap = new HashMap<String, List<String>>();
        populatePropertyVariableMap(variables);
    }

    public ClearPropertyDialog(Shell parent, int style, List<IVariable> variables) throws DebugException {
        super(parent, style);
        propertyVariableMap = new HashMap<String, List<String>>();
        populatePropertyVariableMap(variables);
    }

    public PropertyChangeCommand open() {
        Shell parent = getParent();
        final Shell shell = new Shell(parent, SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
        shell.setText(Messages.ClearPropertyDialog_MessageMediationPropertyClearShellTitle);

        shell.setLayout(new GridLayout(2, true));

        Label propertyContextLabel = new Label(shell, SWT.NULL);
        propertyContextLabel.setText(Messages.ClearPropertyDialog_PropertContextLabel);
        final Combo propertyContextValueDropDown = new Combo(shell, SWT.DROP_DOWN | SWT.BORDER);
        propertyContextValueDropDown.add(AXIS2_CLIENT_PROPERTIES_KEY);
        propertyContextValueDropDown.add(TRANSPORT_PROPERTIES_KEY);
        propertyContextValueDropDown.add(AXIS2_PROPERTIES_KEY);
        propertyContextValueDropDown.add(OPERATION_PROPERTIES_KEY);
        propertyContextValueDropDown.add(SYNAPSE_PROPERTIES_KEY);

        Label propertyKeyLabel = new Label(shell, SWT.NULL);
        propertyKeyLabel.setText(Messages.ClearPropertyDialog_PropertyNameLabel);
        final Combo propertyKeyValueDropDown = new Combo(shell, SWT.DROP_DOWN | SWT.BORDER | SWT.H_SCROLL);
        propertyKeyValueDropDown.setText(Messages.ClearPropertyDialog_PropertyKeyDefaultMessage);
        final Button buttonOK = new Button(shell, SWT.PUSH);
        buttonOK.setText(Messages.ClearPropertyDialog_OkButtonText);
        buttonOK.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
        Button buttonCancel = new Button(shell, SWT.PUSH);
        buttonCancel.setText(Messages.ClearPropertyDialog_CancelButtonText);
        buttonOK.setEnabled(false);

        propertyContextValueDropDown.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    propertyContext = new String(propertyContextValueDropDown.getText());
                    propertyKeyValueDropDown.setText(""); //$NON-NLS-1$
                    propertyKeyValueDropDown.clearSelection();
                    updatePropertyKeyList();
                    if (!(StringUtils.isEmpty(propertyContext) || StringUtils.isEmpty(propertyKey))) {
                        buttonOK.setEnabled(true);
                    } else {
                        buttonOK.setEnabled(false);
                    }
                } catch (Exception e) {
                    buttonOK.setEnabled(false);
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
                        buttonOK.setEnabled(true);
                    } else {
                        buttonOK.setEnabled(false);
                    }
                } catch (Exception e) {
                    buttonOK.setEnabled(false);
                }
            }
        });
        buttonOK.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                shell.dispose();
            }
        });

        buttonCancel.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                propertyContext = null;
                shell.dispose();
            }
        });

        shell.addListener(SWT.Traverse, new Listener() {
            public void handleEvent(Event event) {
                if (event.detail == SWT.TRAVERSE_ESCAPE)
                    event.doit = false;
            }
        });

        shell.pack();
        shell.open();

        Display display = parent.getDisplay();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }

        PropertyValueBean property = new PropertyValueBean(propertyKey, null);
        PropertyChangeCommand command = new PropertyChangeCommand(CLEAR_COMMAND, propertyContext, property);
        return command;
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

    private String getESBContextNameFromUITableVariableName(String name) {
        switch (name) {
        case AXIS2_PROPERTIES_TAG:
            return AXIS2_PROPERTIES_KEY;
        case AXIS2_CLIENT_PROPERTIES_TAG:
            return AXIS2_CLIENT_PROPERTIES_KEY;
        case SYNAPSE_PROPERTIES_TAG:
            return SYNAPSE_PROPERTIES_KEY;
        case TRANSPORT_PROPERTIES_TAG:
            return TRANSPORT_PROPERTIES_KEY;
        case OPERATION_PROPERTIES_TAG:
            return OPERATION_PROPERTIES_KEY;
        }
        return name;
    }
}
