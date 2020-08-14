/*
 * Copyright 2020 WSO2, Inc. (http://wso2.com)
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

package org.wso2.developerstudio.datamapper.diagram.custom.dialogs;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.datamapper.AdvancedCustomFunction;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.AdvancedCustomFunctionEditPart;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRectangle;
import org.wso2.developerstudio.datamapper.impl.AdvancedCustomFunctionImpl;

public class ConfigureAdvancedCustomFunctionOperatorDialog extends AbstractConfigureOperatorDialog {

    private TransactionalEditingDomain editingDomain;
    private AdvancedCustomFunctionImpl customFunctionImpl;
    private EditPart editPart;
    private String functionName;
    private String functionDefinition;

    public ConfigureAdvancedCustomFunctionOperatorDialog(Shell parentShell, AdvancedCustomFunction concatOperator,
            TransactionalEditingDomain editingDomain, EditPart selectedEP) {
        super(parentShell);
        this.customFunctionImpl = (AdvancedCustomFunctionImpl) concatOperator;
        this.editingDomain = editingDomain;
        this.editPart = selectedEP;
    }

    @Override
    public void create() {
        super.create();
        setTitle("Configure Advanced Custom Function Operator");
        setMessage("Set advanced custom function operator properties", IMessageProvider.INFORMATION);
    }

    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        // Set title.
        newShell.setText("Configure Custom Function Operator");
    }

    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout = new GridLayout(2, false);
        container.setLayout(layout);

        Label functionNameLabel = new Label(container, SWT.NULL);
        functionNameLabel.setText("Function Name : ");

        final Text functionNameText = new Text(container, SWT.BORDER);
        functionNameText.setLayoutData(dataPropertyConfigText);
        if (customFunctionImpl.getFunctionName() != null) {
            functionNameText.setText(customFunctionImpl.getFunctionName());
        }
        functionName = functionNameText.getText();
        functionNameText.setEditable(false);

        Label functionDefinitionLabel = new Label(container, SWT.NULL);
        functionDefinitionLabel.setText("Function Definition : ");

        final Text functionDefinitionText = new Text(container, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
        functionDefinitionText.setLayoutData(new GridData(GridData.FILL_BOTH));
        if (customFunctionImpl.getFunctionDefinition() != null) {
            functionDefinitionText.setText(customFunctionImpl.getFunctionDefinition());
        }
        functionDefinition = functionDefinitionText.getText();

        functionDefinitionText.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    functionDefinition = new String(functionDefinitionText.getText());
                    if (StringUtils.isNotEmpty(functionName) && StringUtils.isNotEmpty(functionDefinition)) {
                        getButton(IDialogConstants.OK_ID).setEnabled(true);
                        validate();
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
        if (StringUtils.isNotEmpty(functionName) && StringUtils.isNotEmpty(functionDefinition)) {
            isEnabled = true;
        }
        if (okButton != null) {
            okButton.setEnabled(isEnabled);
        }
    }

    protected void okPressed() {

        if (!StringUtils.isEmpty(functionName)) {
            AdvancedCustomFunction concatOperatorInstance = customFunctionImpl;
            SetCommand setCmnd = new SetCommand(editingDomain, concatOperatorInstance,
                    DataMapperPackage.Literals.ADVANCED_CUSTOM_FUNCTION__FUNCTION_NAME, functionName);
            if (setCmnd.canExecute()) {
                editingDomain.getCommandStack().execute(setCmnd);
            }
            ((OperatorRectangle) ((AdvancedCustomFunctionEditPart) editPart).getAdvancedCustomFunctionFigure())
                    .changeOperatorHeader("AdvancedCustomFunction : " + functionName);
        }

        if (!StringUtils.isEmpty(functionDefinition)) {
            AdvancedCustomFunction concatOperatorInstance = customFunctionImpl;
            SetCommand setCmnd = new SetCommand(editingDomain, concatOperatorInstance,
                    DataMapperPackage.Literals.ADVANCED_CUSTOM_FUNCTION__FUNCTION_DEFINITION, functionDefinition);
            if (setCmnd.canExecute()) {
                editingDomain.getCommandStack().execute(setCmnd);
            }
        }
        super.okPressed();
    }
}
