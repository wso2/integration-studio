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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.*;

import org.apache.commons.lang.StringUtils;
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
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.PropertyChangeCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.PropertyValueBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;

/**
 * This class manages the dialog box for inject property attribute selection.
 *
 */
public class InjectPropertyDialog extends Dialog {

    private String propertyContext;
    private String propertyKey;
    private String propertyValue;

    public InjectPropertyDialog(Shell parent) {
        super(parent);
    }

    public InjectPropertyDialog(Shell parent, int style) {
        super(parent, style);
    }

    public PropertyChangeCommand open() {
        Shell parent = getParent();
        final Shell shell = new Shell(parent, SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL);
        shell.setText(Messages.InjectPropertyDialog_PropertyInjectShellTitle);

        shell.setLayout(new GridLayout(2, true));

        Label propertyContextLabel = new Label(shell, SWT.NULL);
        propertyContextLabel.setText(Messages.InjectPropertyDialog_PropertyContextLabel);
        final Combo propertyContextValueDropDown = new Combo(shell, SWT.DROP_DOWN | SWT.BORDER);
        propertyContextValueDropDown.add(AXIS2_CLIENT_PROPERTIES_KEY);
        propertyContextValueDropDown.add(TRANSPORT_PROPERTIES_KEY);
        propertyContextValueDropDown.add(AXIS2_PROPERTIES_KEY);
        propertyContextValueDropDown.add(OPERATION_PROPERTIES_KEY);
        propertyContextValueDropDown.add(SYNAPSE_PROPERTIES_KEY);

        Label propertyKeyLabel = new Label(shell, SWT.NULL);
        propertyKeyLabel.setText(Messages.InjectPropertyDialog_PropertNameLabel);
        final Text propertyKeyValue = new Text(shell, SWT.SINGLE | SWT.BORDER);

        Label propertyValueLabel = new Label(shell, SWT.NULL);
        propertyValueLabel.setText(Messages.InjectPropertyDialog_PropertyValueLabel);
        final Text propertyValueText = new Text(shell, SWT.SINGLE | SWT.BORDER);

        final Button buttonOK = new Button(shell, SWT.PUSH);
        buttonOK.setText(Messages.InjectPropertyDialog_OkButtonLabel);
        buttonOK.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_END));
        Button buttonCancel = new Button(shell, SWT.PUSH);
        buttonCancel.setText(Messages.InjectPropertyDialog_CancelButtonLabel);
        buttonOK.setEnabled(false);

        propertyContextValueDropDown.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    propertyContext = new String(propertyContextValueDropDown.getText());
                    if (!(StringUtils.isEmpty(propertyContext) || StringUtils.isEmpty(propertyKey) || StringUtils
                            .isEmpty(propertyValue))) {
                        buttonOK.setEnabled(true);
                    } else {
                        buttonOK.setEnabled(false);
                    }
                } catch (Exception e) {
                    buttonOK.setEnabled(false);
                }
            }
        });
        propertyKeyValue.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    propertyKey = new String(propertyKeyValue.getText());
                    if (!(StringUtils.isEmpty(propertyContext) || StringUtils.isEmpty(propertyKey) || StringUtils
                            .isEmpty(propertyValue))) {
                        buttonOK.setEnabled(true);
                    } else {
                        buttonOK.setEnabled(false);
                    }
                } catch (Exception e) {
                    buttonOK.setEnabled(false);
                }
            }
        });
        propertyValueText.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    propertyValue = new String(propertyValueText.getText());
                    if (!(StringUtils.isEmpty(propertyContext) || StringUtils.isEmpty(propertyKey) || StringUtils
                            .isEmpty(propertyValue))) {
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

        PropertyValueBean property = new PropertyValueBean(propertyKey, propertyValue);
        PropertyChangeCommand command = new PropertyChangeCommand(SET_COMMAND, propertyContext, property);
        return command;
    }
}
