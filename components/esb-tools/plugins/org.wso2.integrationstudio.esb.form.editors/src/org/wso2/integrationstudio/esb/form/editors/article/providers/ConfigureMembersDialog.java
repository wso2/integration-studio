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

package org.wso2.integrationstudio.esb.form.editors.article.providers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.integrationstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.integrationstudio.eclipse.gmf.esb.Member;

public class ConfigureMembersDialog extends TitleAreaDialog {
    /**
     * UI widgets
     */
    private Table tblMembers;
    private Button cmdAddProperty;
    private Button cmdRemoveProperty;

    private Text txtHostName;
    private Text txtHTTPPort;
    private Text txtHTTPSPort;

    /**
     * Table editors
     */
    private TableEditor hostNameEditor;
    private TableEditor httpPortEditor;
    private TableEditor httpsPortEditor;
    
    private boolean isOk = false;

    private List<Member> memberPropertyList = new ArrayList<Member>();

    public ConfigureMembersDialog(Shell parentShell, List<Member> list) {
        super(parentShell);

        if (list != null) {
            memberPropertyList = list;
        } else {
            list = new ArrayList<Member>();
        }

    }

    /**
     * Create contents of the *dialog.
     * 
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent) {
        setTitle("Member Properties Configuration");
        setMessage("Memeber properties can be used to associate configuration data with an endpoint.");
        Composite area = (Composite) super.createDialogArea(parent);
        Composite container = new Composite(area, SWT.NONE);
        container.setLayoutData(new GridData(GridData.FILL_BOTH));

        tblMembers = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
        tblMembers.setBounds(10, 10, 610, 222);
        tblMembers.setHeaderVisible(true);
        tblMembers.setLinesVisible(true);
        tblMembers.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (null != e.item) {
                    if (e.item instanceof TableItem) {
                        TableItem item = (TableItem) e.item;
                        editProperty(item);
                        cmdRemoveProperty.setEnabled(true);
                    }
                } else {
                    cmdRemoveProperty.setEnabled(false);
                }
            }
        });

        TableColumn tblclmnName = new TableColumn(tblMembers, SWT.NONE);
        tblclmnName.setWidth(200);
        tblclmnName.setText("Host name");

        TableColumn tblclmnValue = new TableColumn(tblMembers, SWT.NONE);
        tblclmnValue.setWidth(250);
        tblclmnValue.setText("HTTP Port");

        TableColumn tblclmnScope = new TableColumn(tblMembers, SWT.NONE);
        tblclmnScope.setWidth(160);
        tblclmnScope.setText("HTTPS Port");

        cmdAddProperty = new Button(container, SWT.NONE);
        cmdAddProperty.setBounds(627, 10, 86, 29);
        cmdAddProperty.setText("Add");
        cmdAddProperty.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent event) {

                Member member = EsbFactory.eINSTANCE.createMember();
                member.setHostName("localhost");
                member.setHttpPort("8080");
                member.setHttpsPort("8043");
                TableItem item = bindMember(member);
                tblMembers.select(tblMembers.indexOf(item));

            }

            public void widgetDefaultSelected(SelectionEvent event) {
            }
        });

        cmdRemoveProperty = new Button(container, SWT.NONE);
        cmdRemoveProperty.setBounds(626, 45, 86, 29);
        cmdRemoveProperty.setText("Remove");
        cmdRemoveProperty.setEnabled(false);
        cmdRemoveProperty.addSelectionListener(new SelectionListener() {

            public void widgetSelected(SelectionEvent arg0) {
                if (tblMembers.getSelectionIndex() != -1)
                    unbindProperty(tblMembers.getSelectionIndex());
                initTableEditor(hostNameEditor, tblMembers);
                initTableEditor(httpsPortEditor, tblMembers);
                initTableEditor(httpPortEditor, tblMembers);
                cmdRemoveProperty.setEnabled(false);
            }

            public void widgetDefaultSelected(SelectionEvent arg0) {
            }
        });

        if (memberPropertyList.size() > 0) {
            for (Member property : memberPropertyList) {
                bindMember(property);
            }
        }

        return area;
    }

    /**
     * @param property
     */
    public TableItem bindMember(Member property) {
        TableItem item = new TableItem(tblMembers, SWT.NONE);
        item.setText(0, property.getHostName());
        item.setText(1, property.getHttpPort());
        item.setText(2, property.getHttpsPort());
        item.setData(property);
        return item;
    }

    /**
     * @param property
     */
    public void unbindProperty(int itemIndex) {
        TableItem item = tblMembers.getItem(itemIndex);
        Member property = (Member) item.getData();
        removeTaskProperty(property);
        tblMembers.remove(tblMembers.indexOf(item));

    }

    private void removeTaskProperty(Member param) {
        if (param != null) {
            for (Member propertyItem : memberPropertyList) {
                if (propertyItem.getHostName().equals(param.getHostName())) {
                    memberPropertyList.remove(propertyItem);
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

        hostNameEditor = initTableEditor(hostNameEditor, item.getParent());
        txtHostName = new Text(item.getParent(), SWT.NONE);
        txtHostName.setText(item.getText(0));
        hostNameEditor.setEditor(txtHostName, item, 0);
        item.getParent().redraw();
        item.getParent().layout();
        txtHostName.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                item.setText(0, txtHostName.getText());
            }
        });

        httpPortEditor = initTableEditor(httpPortEditor, item.getParent());
        txtHTTPPort = new Text(item.getParent(), SWT.NONE);
        txtHTTPPort.setText(item.getText(1));
        httpPortEditor.setEditor(txtHTTPPort, item, 1);
        item.getParent().redraw();
        item.getParent().layout();
        txtHTTPPort.addModifyListener(new ModifyListener() {

            public void modifyText(ModifyEvent e) {
                item.setText(1, txtHTTPPort.getText());
            }
        });

        httpsPortEditor = initTableEditor(httpsPortEditor, item.getParent());
        txtHTTPSPort = new Text(item.getParent(), SWT.NONE);
        txtHTTPSPort.setText(item.getText(2));
        httpsPortEditor.setEditor(txtHTTPSPort, item, 2);
        item.getParent().redraw();
        item.getParent().layout();
        txtHTTPSPort.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event evt) {
                item.setText(2, txtHTTPSPort.getText());
            }
        });
    }

    private TableEditor initTableEditor(TableEditor editor, Table table) {
        if (null != editor) {
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

        for (TableItem item : tblMembers.getItems()) {

            Member parameter = null;

            if (item.getData() == null) {
                parameter = EsbFactory.eINSTANCE.createMember();
                parameter.setHostName(item.getText(0));
                parameter.setHttpPort(item.getText(1));
                parameter.setHttpsPort(item.getText(2));

            } else {
                parameter = (Member) item.getData();
                parameter.setHostName(item.getText(0));
                parameter.setHttpPort(item.getText(1));
                parameter.setHttpsPort(item.getText(2));

            }

            for (Member propertyItem : memberPropertyList) {
                // When updating the existing members, remove the old member
                if (propertyItem.getHostName().equals(parameter.getHostName())
                        && propertyItem.getHttpPort().equals(parameter.getHttpPort())
                        && propertyItem.getHttpsPort().equals(parameter.getHttpsPort())) {
                    memberPropertyList.remove(propertyItem);
                    break;
                }
            }
            memberPropertyList.add(parameter);
        }
        setEndpointMemberList(memberPropertyList);
        
        this.isOk = true;
        
        super.okPressed();
    }

    public void setEndpointMemberList(List<Member> endpointPropertyList) {
        this.memberPropertyList = endpointPropertyList;

    }

    public List<Member> getEndpointMemberList() {
        return memberPropertyList;
    }
    
    public boolean isOk() {
        return this.isOk;
    }
}
