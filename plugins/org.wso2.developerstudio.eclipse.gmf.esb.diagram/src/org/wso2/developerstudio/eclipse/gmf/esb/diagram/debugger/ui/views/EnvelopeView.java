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
package org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.ui.views;

import static org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.ESBDebuggerConstants.ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT;

import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.AddPropertyToTableDialogRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.internal.communication.requests.ClearPropertyFromTableDialogRequest;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.Messages;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.debugger.utils.OpenEditorUtil;

/**
 * This class define view to show the ESB Mediation Debugger envelope properties while debugging
 *
 */
public class EnvelopeView extends ViewPart implements ContentAcceptHandler {

    private Text messageEnvelope;
    private Table propertyTable;
    private Color tableEvenIndexColor;
    private Color tableOddIndexColor;
    private IEventBroker addClearPropertyCommandEB;

    @Override
    public void createPartControl(Composite parent) {
        Display display = PlatformUI.createDisplay();
        tableEvenIndexColor = display.getSystemColor(SWT.COLOR_WIDGET_LIGHT_SHADOW);
        tableOddIndexColor = display.getSystemColor(SWT.COLOR_WHITE);
        messageEnvelope = new Text(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.READ_ONLY);
        messageEnvelope.setBackground(tableEvenIndexColor);

        Composite propertyArea = new Composite(parent, SWT.NONE);
        propertyArea.setLayout(new GridLayout(1, true));
        propertyArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        ScrolledComposite propertyTableArea = new ScrolledComposite(propertyArea, SWT.BORDER | SWT.H_SCROLL);
        propertyTableArea.setLayout(new GridLayout(1, true));
        propertyTableArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        propertyTable = new Table(propertyTableArea, SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.BORDER);
        propertyTable.setHeaderVisible(true);
        propertyTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        propertyTableArea.setContent(propertyTable);
        propertyTableArea.setExpandHorizontal(true);
        propertyTableArea.setExpandVertical(true);
        propertyTableArea.setAlwaysShowScrollBars(true);

        TableColumn keyColumn = new TableColumn(propertyTable, SWT.LEFT | SWT.BORDER);
        keyColumn.setText(Messages.EnvelopeView_PropertyKeyLabel);
        keyColumn.setWidth(150);

        TableColumn valueColumn = new TableColumn(propertyTable, SWT.LEFT | SWT.FILL);
        valueColumn.setText(Messages.EnvelopeView_PropertyValueLabel);
        valueColumn.setWidth(200);

        Composite propertyButtonArea = new Composite(propertyArea, SWT.NONE);
        propertyButtonArea.setLayout(new GridLayout(8, true));

        Button addPropertyFieldButton = new Button(propertyButtonArea, SWT.PUSH);
        addPropertyFieldButton.setText(Messages.EnvelopeView_AddPropertyButtonLabel);
        GridData buttonLayoutData = new GridData();
        buttonLayoutData.verticalAlignment = SWT.BOTTOM;
        buttonLayoutData.horizontalAlignment = SWT.FILL;
        addPropertyFieldButton.setLayoutData(buttonLayoutData);
        addPropertyFieldButton.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                if (addClearPropertyCommandEB == null) {
                    addClearPropertyCommandEB = (IEventBroker) PlatformUI.getWorkbench().getService(IEventBroker.class);
                }
                addClearPropertyCommandEB.send(ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT,
                        new AddPropertyToTableDialogRequest());
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent event) {
                if (addClearPropertyCommandEB == null) {
                    addClearPropertyCommandEB = (IEventBroker) PlatformUI.getWorkbench().getService(IEventBroker.class);
                }
                addClearPropertyCommandEB.send(ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT,
                        new AddPropertyToTableDialogRequest());
            }
        });

        Button clearPropertyFieldButton = new Button(propertyButtonArea, SWT.PUSH);
        clearPropertyFieldButton.setText(Messages.EnvelopeView_ClearPropertyButtonLabel);
        clearPropertyFieldButton.setLayoutData(buttonLayoutData);
        clearPropertyFieldButton.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                if (addClearPropertyCommandEB == null) {
                    addClearPropertyCommandEB = (IEventBroker) PlatformUI.getWorkbench().getService(IEventBroker.class);
                }
                addClearPropertyCommandEB.send(ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT,
                        new ClearPropertyFromTableDialogRequest());
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent event) {
                if (addClearPropertyCommandEB == null) {
                    addClearPropertyCommandEB = (IEventBroker) PlatformUI.getWorkbench().getService(IEventBroker.class);
                }
                addClearPropertyCommandEB.send(ESB_STACK_FRAME_PROPERTY_CHANGE_EVENT,
                        new ClearPropertyFromTableDialogRequest());
            }
        });
    }

    @Override
    public void setFocus() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void acceptContent(Object content, AcceptedContentAction action) {
        if (content instanceof String) {
            setMessageEnvelope((String) content);
        } else if (content instanceof String[]) {
            if (AcceptedContentAction.ADD.equals(action)) {
                String[] keyValuePair = (String[]) content;
                setTableItem(keyValuePair[0], keyValuePair[1]);
            } else if (AcceptedContentAction.REMOVE.equals(action)) {
                String[] keyValuePair = (String[]) content;
                removeTableItem(keyValuePair[0]);
            }
        }
        refreshTableColors();
    }

    private void removeTableItem(String key) {
        TableItem[] itemList = propertyTable.getItems();
        int index = 0;
        for (TableItem tableItem : itemList) {
            if (tableItem.getText(0).equals(key)) {
                propertyTable.remove(index);
                return;
            }
            index++;
        }
    }

    private void setMessageEnvelope(String messageEnvelope) {
        this.messageEnvelope.setText(OpenEditorUtil.formatMessageEnvelope(messageEnvelope));
        this.messageEnvelope.update();
    }

    private void setTableItem(String key, String value) {
        TableItem[] itemList = propertyTable.getItems();
        for (TableItem tableItem : itemList) {
            if (tableItem.getText(0).equals(key)) {
                tableItem.setText(1, value);
                return;
            }
        }
        TableItem item = new TableItem(propertyTable, SWT.NONE);
        item.setText(new String[] { key, value });
    }

    private void refreshTableColors() {
        TableItem[] itemList = propertyTable.getItems();
        boolean evenIndexPosition = false;
        for (TableItem tableItem : itemList) {
            if (evenIndexPosition) {
                tableItem.setBackground(tableEvenIndexColor);
                evenIndexPosition = false;
            } else {
                tableItem.setBackground(tableOddIndexColor);
                evenIndexPosition = true;
            }
        }
    }

}
