/*
 * Copyright (c) 2019 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.developerstudio.esb.form.editors.article.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

public class ConfigureEndpointsDialog extends TitleAreaDialog {

    /**
     * UI widgets
     */
    private Table tblEndpoints;
    private Button cmdAddEndpoint;
    private Button cmdRemoveEndpoint;
    private Button cmdEditEndpoint;

    private Text txtEndpointValue;
    private Combo cmbEndpointType;

    private boolean isOk = false;

    /**
     * Table editors
     */
    private TableEditor endpointTypeEditor;
    private TableEditor endpointValueEditor;

    private List<EndpointTableEntry> endpointsList = new ArrayList<EndpointTableEntry>();

    public ConfigureEndpointsDialog(Shell parentShell, List<EndpointTableEntry> list) {
        super(parentShell);
        if (list != null) {
            endpointsList = list;
        } else {
            list = new ArrayList<EndpointTableEntry>();
        }
    }

    /**
     * Create contents of the *dialog.
     * 
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        setTitle("EndPoints Configuration");
        setMessage("Load balance group distributes the load among the listed endpoints.");
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        tblEndpoints = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
        tblEndpoints.setBounds(10, 10, 610, 222);
        tblEndpoints.setHeaderVisible(true);
        tblEndpoints.setLinesVisible(true);
        tblEndpoints.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (null != e.item) {
                    if (e.item instanceof TableItem) {
                        TableItem item = (TableItem) e.item;
                        editProperty(item);
                        cmdRemoveEndpoint.setEnabled(true);
                        cmdEditEndpoint.setEnabled(true);
                    }
                } else {
                    cmdRemoveEndpoint.setEnabled(false);
                    cmdEditEndpoint.setEnabled(false);
                }
            }
        });

        TableColumn tblclmnName = new TableColumn(tblEndpoints, SWT.NONE);
        tblclmnName.setWidth(200);
        tblclmnName.setText("Endpoint Type");

        TableColumn tblclmnType = new TableColumn(tblEndpoints, SWT.NONE);
        tblclmnType.setWidth(250);
        tblclmnType.setText("Endpoint Value");

        if (endpointsList != null && endpointsList.size() > 0) {
            for (int i = 0; i < endpointsList.size(); i++) {
                EndpointTableEntry endpointTableEntry = endpointsList.get(i);
                bindEndpoint(endpointTableEntry);
            }
        }

        cmdAddEndpoint = new Button(container, SWT.NONE);
        cmdAddEndpoint.setBounds(627, 10, 86, 29);
        cmdAddEndpoint.setText("Add");
        cmdAddEndpoint.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent event) {

                Shell shell = Display.getDefault().getActiveShell();
                ConfigureEndpointsWizard wizard = new ConfigureEndpointsWizard(shell);
                wizard.init(PlatformUI.getWorkbench(), null);
                WizardDialog exportWizardDialog = new WizardDialog(shell, wizard);
                exportWizardDialog.open();

                if (wizard.isFinish()) {
                    EndpointTableEntry endpointTableEntry = wizard.getEndpointTableEntry();
                    TableItem item = bindEndpoint(endpointTableEntry);
                    endpointsList.add(endpointTableEntry);
                    tblEndpoints.select(tblEndpoints.indexOf(item));
                }
            }

            public void widgetDefaultSelected(SelectionEvent event) {

            }
        });

        cmdEditEndpoint = new Button(container, SWT.NONE);
        cmdEditEndpoint.setBounds(626, 45, 86, 29);
        cmdEditEndpoint.setText("Edit");
        cmdEditEndpoint.setEnabled(false);
        cmdEditEndpoint.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent event) {

                Shell shell = Display.getDefault().getActiveShell();
                ConfigureEndpointsWizard wizard = new ConfigureEndpointsWizard(shell);
                wizard.setIsEdit();

                int index = tblEndpoints.getSelectionIndex();
                if (index != -1) {
                    TableItem item = tblEndpoints.getItem(index);
                    EndpointTableEntry tableEntry = (EndpointTableEntry) item.getData();
                    wizard.setEndpointTableEntry(tableEntry);

                    wizard.init(PlatformUI.getWorkbench(), null);
                    WizardDialog exportWizardDialog = new WizardDialog(shell, wizard);

                    exportWizardDialog.open();

                    if (wizard.isFinish()) {
                        editEndpoint(wizard.getEndpointTableEntry(), index);
                        tblEndpoints.select(index);
                    }
                }
            }

            public void widgetDefaultSelected(SelectionEvent event) {
            }
        });

        cmdRemoveEndpoint = new Button(container, SWT.NONE);
        cmdRemoveEndpoint.setBounds(625, 80, 86, 29);
        cmdRemoveEndpoint.setText("Remove");
        cmdRemoveEndpoint.setEnabled(false);
        cmdRemoveEndpoint.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent arg0) {

                if (tblEndpoints.getSelectionIndex() != -1) {
                    unbindProperty(tblEndpoints.getSelectionIndex());
                }
                initTableEditor(endpointValueEditor, tblEndpoints);
                initTableEditor(endpointTypeEditor, tblEndpoints);
                cmdRemoveEndpoint.setEnabled(false);
            }

            public void widgetDefaultSelected(SelectionEvent arg0) {

            }
        });

        return area;
    }

    private void editEndpoint(EndpointTableEntry endpointTableEntry, int index) {
        TableItem item = tblEndpoints.getItem(index);
        if (endpointTableEntry.isInline()) {
            item.setText(0, "INLINE");
        } else {
            item.setText(0, "STATIC");
        }
        item.setText(1, endpointTableEntry.getEndpointValue());
        item.setData(endpointTableEntry);
        
        endpointsList.remove(index);
        endpointsList.add(index, endpointTableEntry);
        
        initTableEditor(endpointValueEditor, tblEndpoints);
        initTableEditor(endpointTypeEditor, tblEndpoints);

    }

    /**
     * @param endpoint
     */
    private TableItem bindEndpoint(EndpointTableEntry endpoint) {
        TableItem item = new TableItem(tblEndpoints, SWT.NONE);
        if (endpoint.isInline()) {
            item.setText(0, "INLINE");
        } else {
            item.setText(0, "STATIC");
        }
        item.setText(1, endpoint.getEndpointValue());
        item.setData(endpoint);
        return item;
    }

    /**
     * @param property
     */
    private void unbindProperty(int itemIndex) {
        TableItem item = tblEndpoints.getItem(itemIndex);
        EndpointTableEntry tableEntry = (EndpointTableEntry) item.getData();
        removeTaskProperty(tableEntry);
        tblEndpoints.remove(tblEndpoints.indexOf(item));

    }

    private void removeTaskProperty(EndpointTableEntry param) {
        if (param != null) {
            for (EndpointTableEntry propertyItem : endpointsList) {
                if (!(propertyItem.isInline() ^ param.isInline())
                        && propertyItem.getEndpointValue().equals(param.getEndpointValue())) {
                    endpointsList.remove(propertyItem);
                    break;
                }
            }
        }
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
    }

    /**
     * Return the initial size of the *dialog.
     */
    @Override
    protected Point getInitialSize() {
        return new Point(731, 400);
    }

    /**
     * {@inheritDoc}
     */
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);

        newShell.setText("Properties");
    }

    private void editProperty(final TableItem item) {

        endpointTypeEditor = initTableEditor(endpointTypeEditor, item.getParent());
        cmbEndpointType = new Combo(item.getParent(), SWT.DROP_DOWN | SWT.READ_ONLY);
        cmbEndpointType.setItems(new String[] { "INLINE", "STATIC" });
        cmbEndpointType.setText(item.getText(0));
        endpointTypeEditor.setEditor(cmbEndpointType, item, 0);
        item.getParent().redraw();
        item.getParent().layout();

        cmbEndpointType.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event evt) {
                item.setText(0, cmbEndpointType.getText());
            }
        });

        cmbEndpointType.addListener(SWT.MouseVerticalWheel, new Listener() {
            @Override
            public void handleEvent(Event event) {
                event.doit = false;
            }
        });
        
        endpointValueEditor = initTableEditor(endpointValueEditor, item.getParent());
        txtEndpointValue = new Text(item.getParent(), SWT.NONE);
        txtEndpointValue.setText(item.getText(1));
        endpointValueEditor.setEditor(txtEndpointValue, item, 1);
        item.getParent().redraw();
        item.getParent().layout();

        txtEndpointValue.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                item.setText(1, txtEndpointValue.getText());
            }
        });
    }

    private TableEditor initTableEditor(TableEditor editor, Table table) {
        if (editor != null) {
            Control lastCtrl = editor.getEditor();
            if (null != lastCtrl) {
                lastCtrl.dispose();
            }
        }
        editor = new TableEditor(table);
        editor.horizontalAlignment = SWT.LEFT;
        editor.grabHorizontal = true;
        return editor;
    }

    @Override
    protected void okPressed() {
        setEndpointPropertyList(endpointsList);
        this.isOk = true;
        super.okPressed();
    }

    public void setEndpointPropertyList(List<EndpointTableEntry> endpointPropertyList) {
        this.endpointsList = endpointPropertyList;

    }

    public List<EndpointTableEntry> getEndpointsList() {
        return endpointsList;
    }

    public boolean isOk() {
        return this.isOk;
    }

}
