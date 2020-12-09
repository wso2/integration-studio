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
package org.wso2.developerstudio.datamapper.diagram.custom.dialogs;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
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
import org.wso2.developerstudio.datamapper.DataMapperFactory;
import org.wso2.developerstudio.datamapper.DataMapperPackage;
import org.wso2.developerstudio.datamapper.OperatorRightConnector;
import org.wso2.developerstudio.datamapper.Split;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.OperatorRectangle;
import org.wso2.developerstudio.datamapper.diagram.edit.parts.SplitEditPart;
import org.wso2.developerstudio.datamapper.impl.SplitImpl;

public class ConfigureSplitOperatorDialog extends AbstractConfigureOperatorDialog {

    private String outputCount;
    private String delimiter;
    private TransactionalEditingDomain editingDomain;
    SplitImpl splitImpl = null;
    private EditPart editPart;
    private ArrayList<OperatorRightConnector> caseOutputConnectors = new ArrayList<OperatorRightConnector>();

    public ConfigureSplitOperatorDialog(Shell parentShell, Split splitOperator,
            TransactionalEditingDomain editingDomain, EditPart selectedEP) {
        super(parentShell);
        this.splitImpl = (SplitImpl) splitOperator;
        this.editingDomain = editingDomain;
        this.editPart=selectedEP;
    }

    @Override
    public void create() {
        super.create();
        setTitle("Configure Split Operator");
        setMessage("Set split operator properties", IMessageProvider.INFORMATION);
    }

    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        // Set title.
        newShell.setText("Split Operator Properties");
    }

    @Override
    protected boolean isResizable() {
        return true;
    }

    protected Control createDialogArea(Composite parent) {
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        GridLayout layout = new GridLayout(2, false);
        container.setLayout(layout);

        Label splitOutputConnectorCountLabel = new Label(container, SWT.NULL);
        splitOutputConnectorCountLabel.setText("Number of Outputs : ");

        final Text outputConnectorCount = new Text(container, SWT.BORDER);
        outputConnectorCount.setLayoutData(dataPropertyConfigText);
        outputConnectorCount
                .setText(splitImpl.getBasicContainer().getRightContainer().getRightConnectors().size() + "");
        outputCount = outputConnectorCount.getText();
        outputConnectorCount.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    outputCount = new String(outputConnectorCount.getText());
                    if (!(StringUtils.isEmpty(outputCount) && StringUtils.isEmpty(delimiter))) {
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

        Label splitDelimiterLabel = new Label(container, SWT.NULL);
        splitDelimiterLabel.setText("Split Delimiter : ");

        final Text delimiterText = new Text(container, SWT.BORDER);
        delimiterText.setLayoutData(dataPropertyConfigText);
        if (splitImpl.getDelimiter() != null) {
            delimiterText.setText(splitImpl.getDelimiter());
        } else {
            delimiterText.setText("");
        }
        delimiter = delimiterText.getText();

        delimiterText.addListener(SWT.Modify, new Listener() {
            public void handleEvent(Event event) {
                try {
                    delimiter = new String(delimiterText.getText());
                    if (!(StringUtils.isEmpty(outputCount) && StringUtils.isEmpty(delimiter))) {
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
        if (delimiter != null && outputCount != null) {
            if (!StringUtils.isEmpty(delimiter)) {
                if (!outputCount.equals("0") && !StringUtils.isEmpty(outputCount)) {
                    isEnabled = true;
                }
            }
        }
        if (okButton != null) {
            okButton.setEnabled(isEnabled);
        }
    }

    protected void okPressed() {
        if (!StringUtils.isEmpty(delimiter)) {
        	Split splitOperatorInstance = splitImpl;
        	SetCommand setCmnd = new SetCommand(editingDomain, splitOperatorInstance, DataMapperPackage.Literals.SPLIT__DELIMITER, delimiter);
            if (setCmnd.canExecute()) {
                editingDomain.getCommandStack().execute(setCmnd);
            }
        	((OperatorRectangle)((SplitEditPart)editPart).getSplitFigure()).changeOperatorHeader("Split : \""+delimiter+"\"");
    		
        }
        int number = Integer.parseInt(outputCount)
                - splitImpl.getBasicContainer().getRightContainer().getRightConnectors().size();
        if (number > 0) {
            for (int i = 0; i < number; ++i) {
                OperatorRightConnector splitOperatorContainers = DataMapperFactory.eINSTANCE
                        .createOperatorRightConnector();
                AddCommand addCmd = new AddCommand(editingDomain, splitImpl.getBasicContainer().getRightContainer(),
                        DataMapperPackage.Literals.OPERATOR_RIGHT_CONTAINER__RIGHT_CONNECTORS, splitOperatorContainers);
                if (addCmd.canExecute()) {
                    editingDomain.getCommandStack().execute(addCmd);
                }
            }
        } else if (number < 0) {
            for (int i = 0; i < Math.abs(number); i++) {
                EList<OperatorRightConnector> listOfRightConnectors = splitImpl.getBasicContainer()
                        .getRightContainer().getRightConnectors();
                OperatorRightConnector splitOperatorConnector = listOfRightConnectors
                        .get(listOfRightConnectors.size() - 1);
                caseOutputConnectors.add(splitOperatorConnector);
                DeleteCommand deleteCmd = new DeleteCommand(editingDomain, caseOutputConnectors);
                if (deleteCmd.canExecute()) {
                    editingDomain.getCommandStack().execute(deleteCmd);
                }
                caseOutputConnectors.remove(splitOperatorConnector);
            }
        }

        super.okPressed();
    }

}
