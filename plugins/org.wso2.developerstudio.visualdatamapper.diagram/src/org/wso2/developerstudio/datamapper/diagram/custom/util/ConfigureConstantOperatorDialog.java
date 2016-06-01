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
package org.wso2.developerstudio.datamapper.diagram.custom.util;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.datamapper.Constant;
import org.wso2.developerstudio.datamapper.impl.ConstantImpl;

public class ConfigureConstantOperatorDialog extends TitleAreaDialog {

    private Constant constantOperator;
    private String type;
    private String value;
    private EditPart editpart;
    private TransactionalEditingDomain editingDomain;
    ConstantImpl constant = null;
    private String propertyContext;

    public ConfigureConstantOperatorDialog(Shell parentShell, Constant constantOperator,
            TransactionalEditingDomain editingDomain, EditPart editpart) {
        super(parentShell);
        this.constantOperator = constantOperator;
        this.editpart = editpart;
        this.editingDomain = editingDomain;
        CSSShapeImpl constantdd = (CSSShapeImpl) this.editpart.getModel();
        constant = (ConstantImpl) constantdd.getElement();
    }

    @Override
    public void create() {
        super.create();
        setTitle("Configure Constant Operator");
        setMessage("Set constant operator properties", IMessageProvider.INFORMATION);
    }

    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        // Set title.
        newShell.setText("Constant Operator Properties");
    }

    protected Control createDialogArea(Composite parent) {

        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout = new GridLayout(2, false);
        container.setLayout(layout);

        GridData dataPropertyConfigText = new GridData();
        dataPropertyConfigText.grabExcessHorizontalSpace = true;
        dataPropertyConfigText.horizontalAlignment = GridData.FILL;

        Label constantTypeLabel = new Label(container, SWT.NULL);
        constantTypeLabel.setText("Constant Type : ");
        final Combo constantTypeDropDown = new Combo(container, SWT.DROP_DOWN | SWT.BORDER | SWT.READ_ONLY);
        constantTypeDropDown.setLayoutData(dataPropertyConfigText);
        constantTypeDropDown.add("STRING");
        constantTypeDropDown.add("INT");
        constantTypeDropDown.add("BOOLEAN");
        constantTypeDropDown.add("FLOAT");

        constantTypeDropDown.addListener(SWT.Modify, new Listener() {

            public void handleEvent(Event event) {
                try {
                    type = new String(constantTypeDropDown.getText());
                    if (!(StringUtils.isEmpty(type) && StringUtils.isEmpty(value))) {
                        getButton(IDialogConstants.OK_ID).setEnabled(true);
                    } else {
                        getButton(IDialogConstants.OK_ID).setEnabled(false);
                    }
                } catch (Exception e) {
                    getButton(IDialogConstants.OK_ID).setEnabled(false);
                }
            }
        });

        Label constantValueLabel = new Label(container, SWT.NULL);
        constantValueLabel.setText("Constant Value : ");

        final Text constantValue = new Text(container, SWT.BORDER);
        constantValue.setLayoutData(dataPropertyConfigText);

        constantValue.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    value = new String(constantValue.getText());
                    if (!(StringUtils.isEmpty(type) && StringUtils.isEmpty(value))) {
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

    /**
     * Create contents of the button bar.
     * 
     * @param parent
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
        validate();
    }

    private void validate() {
        boolean isEnabled = false;
        Button okButton = getButton(IDialogConstants.OK_ID);
        if (StringUtils.isNotEmpty(value) && StringUtils.isNotEmpty(type)) {
            isEnabled = true;
        }
        if (okButton != null) {
            okButton.setEnabled(isEnabled);
        }
    }

    protected void okPressed() {
        if (StringUtils.isNotEmpty(value)) {
            constant.setConstValue(value);
        }
        if (StringUtils.isNotEmpty(type)) {
            constant.setConstType(type);
        }

        super.okPressed();
    }

}
