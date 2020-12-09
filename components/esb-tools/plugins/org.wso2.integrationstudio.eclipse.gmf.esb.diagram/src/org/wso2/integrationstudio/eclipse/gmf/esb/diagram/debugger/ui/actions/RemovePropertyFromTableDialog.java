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
package org.wso2.integrationstudio.eclipse.gmf.esb.diagram.debugger.ui.actions;

import static org.wso2.integrationstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.CLEAR_COMMAND;

import java.util.Set;

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
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.debugger.messages.command.PropertyChangeCommand;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.debugger.messages.util.PropertyValueBean;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.debugger.model.ESBStackFrame;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.debugger.ui.views.EnvelopeView;
import org.wso2.integrationstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;

/**
 * This class represent the request event from {@link EnvelopeView} to {@link ESBStackFrame} when property value is
 * needed to be removed from the table in the separate view.
 *
 */
public class RemovePropertyFromTableDialog extends TitleAreaDialog {

    private Set<String> variablesSet;
    private String propertyKey;

    public RemovePropertyFromTableDialog(Shell parent, Set<String> variables) {
        super(parent);
        variablesSet = variables;
    }

    @Override
    public void create() {
        super.create();
        setTitle(Messages.RemovePropertyFromTableDialog_DialogTitle);
        setMessage(Messages.RemovePropertyFromTableDialog_DialogDescription, IMessageProvider.INFORMATION);
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

        Label propertyKeyLabel = new Label(container, SWT.NULL);
        propertyKeyLabel.setText(Messages.ClearPropertyDialog_PropertyNameLabel);
        final Combo propertyKeyValueDropDown = new Combo(container,
                SWT.DROP_DOWN | SWT.BORDER | SWT.H_SCROLL | SWT.READ_ONLY);
        propertyKeyValueDropDown.setLayoutData(dataPropertyConfigText);
        for (String key : variablesSet) {
            propertyKeyValueDropDown.add(key);
        }
        propertyKeyValueDropDown.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    propertyKey = new String(propertyKeyValueDropDown.getText());
                    if (!StringUtils.isEmpty(propertyKey)) {
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

    public PropertyChangeCommand getCommandMessage() {
        PropertyValueBean property = new PropertyValueBean(propertyKey, null);
        PropertyChangeCommand command = new PropertyChangeCommand(CLEAR_COMMAND, "", property); //$NON-NLS-1$
        return command;
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
        newShell.setText(Messages.RemovePropertyFromTableDialog_ShellTitle);
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

}