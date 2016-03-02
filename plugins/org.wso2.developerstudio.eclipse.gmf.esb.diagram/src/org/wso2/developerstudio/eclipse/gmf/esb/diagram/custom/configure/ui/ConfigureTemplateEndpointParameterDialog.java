 /*
  * Copyright 2012 WSO2, Inc. (http://wso2.com)
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
 
 package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;
 
 import org.eclipse.emf.common.command.CompoundCommand;
 import org.eclipse.emf.edit.command.AddCommand;
 import org.eclipse.emf.edit.command.RemoveCommand;
 import org.eclipse.emf.edit.command.SetCommand;
 import org.eclipse.emf.transaction.TransactionalEditingDomain;
 import org.eclipse.jface.dialogs.Dialog;
 import org.eclipse.swt.SWT;
 import org.eclipse.swt.custom.TableEditor;
 import org.eclipse.swt.events.ModifyEvent;
 import org.eclipse.swt.events.ModifyListener;
 import org.eclipse.swt.layout.FormAttachment;
 import org.eclipse.swt.layout.FormData;
 import org.eclipse.swt.layout.FormLayout;
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
 import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
 import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
 import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpoint;
 import org.wso2.developerstudio.eclipse.gmf.esb.TemplateEndpointParameter;
 
 public class ConfigureTemplateEndpointParameterDialog extends Dialog{
 
        private TransactionalEditingDomain editingDomain;
        private TemplateEndpoint templateEndpoint;
 
        /**
         * Table for add/edit/remove parameters.
         */
        private Table paramTable;
        /**
         * Button for add new parameter.
         */
        private Button newParamButton;
        /**
         * Button for remove parameter.
         */
        private Button removeParamButton;
 
        private TableEditor paramNameEditor;
        private TableEditor paramValueEditor;
        private CompoundCommand resultCommand;
        private Text txtParamName;
        private Text paramValue;
 
        public ConfigureTemplateEndpointParameterDialog(Shell parentShell,
                        TemplateEndpoint templateEndpoint,
                        TransactionalEditingDomain editingDomain) {
                super(parentShell);
 
                this.editingDomain = editingDomain;
                this.templateEndpoint = templateEndpoint;
 
        }
        
        protected void configureShell(Shell newShell) {
    		super.configureShell(newShell);

            // Set title
    		newShell.setText("Template Endpoint Parameter Configuration");
    	}

 
 
        protected Control createDialogArea(Composite parent) {
                Composite container = (Composite) super.createDialogArea(parent);
                FormLayout mainLayout = new FormLayout();
                mainLayout.marginHeight = 5;
                mainLayout.marginWidth = 5;
                container.setLayout(mainLayout);
 
                // Button for add new parameter.
                newParamButton = new Button(container, SWT.NONE);
                newParamButton.setText("New...");
                FormData newLogPropertyButtonLayoutData = new FormData(80, SWT.DEFAULT);
                newLogPropertyButtonLayoutData.right = new FormAttachment(100);
                newParamButton.setLayoutData(newLogPropertyButtonLayoutData);
 
                newParamButton.addListener(SWT.Selection, new Listener() {
                        public void handleEvent(Event event) {
                                TableItem item = bindPram(EsbFactory.eINSTANCE
                                                .createTemplateEndpointParameter());
                                paramTable.select(paramTable.indexOf(item));
                        }
                });
 
                // Button for remove parameter.
                removeParamButton = new Button(container, SWT.NONE);
                removeParamButton.setText("Remove");
                FormData removeLogPropertyButtonLayoutData = new FormData();
                removeLogPropertyButtonLayoutData.top = new FormAttachment(
                                newParamButton, 5);
                removeLogPropertyButtonLayoutData.right = new FormAttachment(100);
                removeLogPropertyButtonLayoutData.left = new FormAttachment(
                                newParamButton, 0, SWT.LEFT);
                removeParamButton.setLayoutData(removeLogPropertyButtonLayoutData);
 
                removeParamButton.addListener(SWT.Selection, new Listener() {
                        public void handleEvent(Event event) {
                                int selectedIndex = paramTable.getSelectionIndex();
                                if (-1 != selectedIndex) {
                                        initTableEditor(paramNameEditor, paramTable);
                                        initTableEditor(paramValueEditor, paramTable);
                                        unbindParam(selectedIndex);
 
                                        // Select the next available candidate for deletion.
                                        if (selectedIndex < paramTable.getItemCount()) {
                                                paramTable.select(selectedIndex);
                                        } else {
                                                paramTable.select(selectedIndex - 1);
                                        }
                                }
                        }
                });
 
                // Table for show the parameters.
                paramTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
                                | SWT.HIDE_SELECTION);
 
                TableColumn nameColumn = new TableColumn(paramTable, SWT.LEFT);
                TableColumn valueColumn = new TableColumn(paramTable, SWT.LEFT);
                nameColumn.setText("Name");
                nameColumn.setWidth(150);
                valueColumn.setText("Value");
                valueColumn.setWidth(200);
 
                paramTable.setHeaderVisible(true);
                paramTable.setLinesVisible(true);
 
                Listener tblPropertiesListener = new Listener() {
 
                        public void handleEvent(Event evt) {
                                if (null != evt.item) {
                                        if (evt.item instanceof TableItem) {
                                                TableItem item = (TableItem) evt.item;
                                                editItem(item);
                                        }
                                }
                        }
                };
 
                paramTable.addListener(SWT.Selection, tblPropertiesListener);
 
                // Populate params
                for (TemplateEndpointParameter param : templateEndpoint.getParameters()) {
                        bindPram(param);
                }
 
                //setupTableEditor(paramTable);
 
                FormData logPropertiesTableLayoutData = new FormData(SWT.DEFAULT, 150);
                logPropertiesTableLayoutData.top = new FormAttachment(newParamButton,
                                0, SWT.TOP);
                logPropertiesTableLayoutData.left = new FormAttachment(0);
                logPropertiesTableLayoutData.right = new FormAttachment(newParamButton,
                                -5);
                logPropertiesTableLayoutData.bottom = new FormAttachment(100);
                paramTable.setLayoutData(logPropertiesTableLayoutData);
 
                return parent;
 
        }
 
        private TableItem bindPram(TemplateEndpointParameter param) {
                TableItem item = new TableItem(paramTable, SWT.NONE);
                        item.setText(new String[] { param.getParameterName(),
                                        param.getParameterValue() });
 
                item.setData(param);
                return item;
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
 
        private void unbindParam(int itemIndex) {
                TableItem item = paramTable.getItem(itemIndex);
                TemplateEndpointParameter param = (TemplateEndpointParameter) item.getData();
                if (param.eContainer() != null) {
                        RemoveCommand removeCmd = new RemoveCommand(
                                        editingDomain,
                                        templateEndpoint,
                                        EsbPackage.Literals.TEMPLATE_ENDPOINT__PARAMETERS,
                                        param);
                        getResultCommand().append(removeCmd);
                }
 
                paramTable.remove(paramTable.indexOf(item));
        }
 
        private void editItem(final TableItem item) {
 
                paramNameEditor = initTableEditor(paramNameEditor, item.getParent());
                txtParamName = new Text(item.getParent(), SWT.NONE);
                txtParamName.setText(item.getText(0));
                paramNameEditor.setEditor(txtParamName, item, 0);
                item.getParent().redraw();
                item.getParent().layout();
                txtParamName.addModifyListener(new ModifyListener() {
 
                        public void modifyText(ModifyEvent e) {
                                item.setText(0,txtParamName.getText());
                        }
                });
 
                paramValueEditor = initTableEditor(paramValueEditor, item.getParent());
                paramValue = new Text(item.getParent(), SWT.NONE);
                paramValue.setText(item.getText(1));
                paramValueEditor.setEditor(paramValue, item, 1);
                item.getParent().redraw();
                item.getParent().layout();
                paramValue.addModifyListener(new ModifyListener() {
 
                        public void modifyText(ModifyEvent e) {
                                item.setText(1,paramValue.getText());
                        }
                });
 
        }
 
        protected void okPressed() {
                for (TableItem item : paramTable.getItems()) {
                        TemplateEndpointParameter param = (TemplateEndpointParameter) item
                                        .getData();
                        if (param.eContainer() == null) {
                                param.setParameterName(item.getText(0));
                                param.setParameterValue(item.getText(1));
 
                                //TEMPLATE_ENDPOINT__TEMPLATE_ENDOINT_PARAMETERS
                                AddCommand addCmd = new AddCommand(
                                                editingDomain,
                                                templateEndpoint,
                                                EsbPackage.Literals.TEMPLATE_ENDPOINT__PARAMETERS,
                                                param);
                                getResultCommand().append(addCmd);
                        } else {
                                if (param.getParameterName() != null && !param.getParameterName().equals(item.getText(0))) {
                                        SetCommand setCmd = new SetCommand(
                                                        editingDomain,
                                                        param,
                                                        EsbPackage.Literals.TEMPLATE_ENDPOINT_PARAMETER__PARAMETER_NAME,
                                                        item.getText(0));
 
                                        getResultCommand().append(setCmd);
                                }
                                if (param.getParameterValue() == null || !param.getParameterValue().equals(item.getText(1))) {
 
                                        SetCommand setCmd = new SetCommand(
                                                        editingDomain,
                                                        param,
                                                        EsbPackage.Literals.TEMPLATE_ENDPOINT_PARAMETER__PARAMETER_VALUE,
                                                        item.getText(1));
                                        getResultCommand().append(setCmd);
                                }
                        }
                }
 
                if (getResultCommand().canExecute()) {
                        editingDomain.getCommandStack().execute(getResultCommand());
                }
 
                super.okPressed();
 
        }
 
        private CompoundCommand getResultCommand() {
                if (null == resultCommand) {
                        resultCommand = new CompoundCommand();
                }
                return resultCommand;
        }
 
 }