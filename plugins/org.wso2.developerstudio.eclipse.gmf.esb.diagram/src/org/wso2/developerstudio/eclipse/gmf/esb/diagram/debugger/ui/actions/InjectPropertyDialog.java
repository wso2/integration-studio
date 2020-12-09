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

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_CLIENT_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.AXIS2_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.OPERATION_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SET_COMMAND;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.SYANPSE_PROPERTY_TAG;
import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.TRANSPORT_PROPERTY_TAG;

import org.apache.commons.lang.StringUtils;
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
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.command.PropertyChangeCommand;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.messages.util.PropertyValueBean;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;

/**
 * This class manages the dialog box for inject property attribute selection.
 *
 */
public class InjectPropertyDialog extends TitleAreaDialog {

    private String propertyContext;
    private String propertyKey;
    private String propertyValue;

    public InjectPropertyDialog(Shell parent) {
        super(parent);
    }

    @Override
    public void create() {
        super.create();
        setTitle(Messages.InjectPropertyDialog_PropertyInjectShellTitle);
        setMessage(Messages.InjectPropertyDialog_Description, IMessageProvider.INFORMATION);
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
        propertyContextLabel.setText(Messages.InjectPropertyDialog_PropertyContextLabel);
        final Combo propertyContextValueDropDown = new Combo(container, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
        propertyContextValueDropDown.setLayoutData(dataPropertyConfigText);
        propertyContextValueDropDown.add(AXIS2_CLIENT_PROPERTY_TAG);
        propertyContextValueDropDown.add(TRANSPORT_PROPERTY_TAG);
        propertyContextValueDropDown.add(AXIS2_PROPERTY_TAG);
        propertyContextValueDropDown.add(OPERATION_PROPERTY_TAG);
        propertyContextValueDropDown.add(SYANPSE_PROPERTY_TAG);

        Label propertyKeyLabel = new Label(container, SWT.NULL);
        propertyKeyLabel.setText(Messages.InjectPropertyDialog_PropertNameLabel);

        final Text propertyKeyValue = new Text(container, SWT.BORDER);
        propertyKeyValue.setLayoutData(dataPropertyConfigText);

        Label propertyValueLabel = new Label(container, SWT.NULL);
        propertyValueLabel.setText(Messages.InjectPropertyDialog_PropertyValueLabel);
        final Text propertyValueText = new Text(container, SWT.BORDER);
        propertyValueText.setLayoutData(dataPropertyConfigText);

        propertyContextValueDropDown.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    propertyContext = new String(propertyContextValueDropDown.getText());
                    if (!(StringUtils.isEmpty(propertyContext) || StringUtils.isEmpty(propertyKey)
                            || StringUtils.isEmpty(propertyValue))) {
                        getButton(IDialogConstants.OK_ID).setEnabled(true);
                    } else {
                        getButton(IDialogConstants.OK_ID).setEnabled(false);
                    }
                } catch (Exception e) {
                    getButton(IDialogConstants.OK_ID).setEnabled(false);
                }
            }
        });
        propertyKeyValue.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    propertyKey = new String(propertyKeyValue.getText());
                    if (!(StringUtils.isEmpty(propertyContext) || StringUtils.isEmpty(propertyKey)
                            || StringUtils.isEmpty(propertyValue))) {
                        getButton(IDialogConstants.OK_ID).setEnabled(true);
                    } else {
                        getButton(IDialogConstants.OK_ID).setEnabled(false);
                    }
                } catch (Exception e) {
                    getButton(IDialogConstants.OK_ID).setEnabled(false);
                }
            }
        });
        propertyValueText.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    propertyValue = new String(propertyValueText.getText());
                    if (!(StringUtils.isEmpty(propertyContext) || StringUtils.isEmpty(propertyKey)
                            || StringUtils.isEmpty(propertyValue))) {
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
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText(Messages.ClearPropertyDialog_ShellTitle);
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

    public PropertyChangeCommand getCommandMessage() {
        PropertyValueBean property = new PropertyValueBean(propertyKey, propertyValue);
        PropertyChangeCommand command = new PropertyChangeCommand(SET_COMMAND, propertyContext, property);
        return command;
    }
}
