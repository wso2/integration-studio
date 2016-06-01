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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.infra.gmfdiag.css.CSSShapeImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.datamapper.Constant;
import org.wso2.developerstudio.datamapper.impl.ConstantImpl;

public class ConfigureConstantOperatorDialog extends Dialog {

    private Constant constantOperator;
    private Label caseType;
    private Label caseValue;
    private Text type;
    private Text value;
    private EditPart editpart;
    private TransactionalEditingDomain editingDomain;
    ConstantImpl constant = null;

    public ConfigureConstantOperatorDialog(Shell parentShell, Constant constantOperator,
            TransactionalEditingDomain editingDomain, EditPart editpart) {

        super(parentShell);
        this.constantOperator = constantOperator;
        this.editpart = editpart;
        this.editingDomain = editingDomain;
        CSSShapeImpl constantdd = (CSSShapeImpl) this.editpart.getModel();
        constant = (ConstantImpl) constantdd.getElement();
    }

    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        // Set title.
        newShell.setText("Constant Operator Properties");
    }

    protected Control createDialogArea(Composite parent) {
        Composite container = (Composite) super.createDialogArea(parent);
        FormLayout mainLayout = new FormLayout();
        mainLayout.marginHeight = 5;
        mainLayout.marginWidth = 5;
        container.setLayout(mainLayout);

        caseType = new Label(container, SWT.NONE);
        caseType.setText("Constant Operator Type : ");
        FormData caseTypeLabelLayoutData = new FormData();
        caseTypeLabelLayoutData.top = new FormAttachment(0, 5);
        caseTypeLabelLayoutData.left = new FormAttachment(0);
        caseType.setLayoutData(caseTypeLabelLayoutData);

        type = new Text(container, SWT.NONE);
        type.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                validate();
            }
        });
        FormData countLayoutData = new FormData();
        countLayoutData.width = 50;
        countLayoutData.top = new FormAttachment(caseType, 0, SWT.CENTER);
        countLayoutData.left = new FormAttachment(caseType, 5);
        type.setLayoutData(countLayoutData);
        int i = constantOperator.getBasicContainer().getRightContainer().getRightConnectors().size();
        type.setText(Integer.toString(i));
        caseValue = new Label(container, SWT.NONE);
        caseValue.setText("Constant Operator Value : ");
        FormData caseValueLabelLayoutData = new FormData();
        caseValueLabelLayoutData.top = new FormAttachment(0, 40);
        caseValueLabelLayoutData.left = new FormAttachment(0);
        caseValue.setLayoutData(caseValueLabelLayoutData);

        value = new Text(container, SWT.NONE);

        if (constant.getConstValue() != null) {
            value.setText(constant.getConstValue());
        } else {
            value.setText(",");
        }
        value.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent arg0) {
                validate();
            }
        });
        FormData valueLayoutData = new FormData();
        valueLayoutData.width = 50;
        valueLayoutData.top = new FormAttachment(caseValue, 0, SWT.CENTER);
        valueLayoutData.left = new FormAttachment(caseValue, 40);
        value.setLayoutData(valueLayoutData);

        return container;
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
        if (value != null && type != null) {
            if (StringUtils.isNotEmpty(value.getText()) && StringUtils.isNotEmpty(value.getText())) {
                isEnabled = true;
            }
        }
        if (okButton != null) {
            okButton.setEnabled(isEnabled);
        }
    }

    protected void okPressed() {
        if (value.getText() != null && !value.getText().isEmpty()) {
            constant.setConstValue(value.getText());
        }
        if (type.getText() != null && !type.getText().isEmpty()) {
            constant.setConstType(type.getText());
        }

        super.okPressed();
    }

}
