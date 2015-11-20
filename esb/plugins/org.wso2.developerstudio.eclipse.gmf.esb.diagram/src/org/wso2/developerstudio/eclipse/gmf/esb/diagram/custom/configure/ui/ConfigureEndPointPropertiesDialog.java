/*
 * Copyright WSO2, Inc. (http://wso2.com)
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

import java.util.Iterator;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.esb.core.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPoint;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.EndPointPropertyScope;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.PropertyValueType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * EndPoint properties configuration *dialog.
 *
 */
public class ConfigureEndPointPropertiesDialog extends TitleAreaDialog {
	
	/**
	 * logger
	 */
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);

	/**
	 * Domain model
	 */
	private EndPoint endPoint;
	
	/**
	 * Editing domain.
	 */
	private TransactionalEditingDomain editingDomain;

	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;
	
	/**
	 * UI widgets 
	 */
	private Table tblProperties;
	private Button cmdAddProperty;
	private Button cmdRemoveProperty;

	private Text txtPropertyName;
	private Text txtPropertyValue;
	private Combo cmbPropertyScope;

	
	/**
	 * Table editors
	 * */
	private TableEditor propertyNameEditor;
	private TableEditor propertyValueEditor;
	private TableEditor propertyScopeEditor;
	
	public ConfigureEndPointPropertiesDialog(Shell parentShell,
			EndPoint endPoint, TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.endPoint = endPoint;
		this.editingDomain = editingDomain;
	}

	/**
	 * Create contents of the *dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("EndPoint Properties Configuration");
		setMessage("Properties can be used to associate configuration data with an endpoint.");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		tblProperties = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		tblProperties.setBounds(10, 10, 610, 222);
		tblProperties.setHeaderVisible(true);
		tblProperties.setLinesVisible(true);
		tblProperties.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (null != e.item) {
					if (e.item instanceof TableItem) {
						TableItem item = (TableItem) e.item;
						editProperty(item);
						cmdRemoveProperty.setEnabled(true);
					}
				} else{
					cmdRemoveProperty.setEnabled(false);
				}
			}
		});
		
		TableColumn tblclmnName = new TableColumn(tblProperties, SWT.NONE);
		tblclmnName.setWidth(200);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnValue = new TableColumn(tblProperties, SWT.NONE);
		tblclmnValue.setWidth(250);
		tblclmnValue.setText("Value");		
		
		TableColumn tblclmnScope = new TableColumn(tblProperties, SWT.NONE);
		tblclmnScope.setWidth(160);
		tblclmnScope.setText("Scope");
		
		
		cmdAddProperty = new Button(container, SWT.NONE);
		cmdAddProperty.setBounds(627, 10, 86, 29);
		cmdAddProperty.setText("Add");
		cmdAddProperty.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent event) {

				EndPointProperty property = EsbFactory.eINSTANCE.createEndPointProperty();
				property.setName("property_name");
				property.setValueType(PropertyValueType.LITERAL);
				property.setValue("property_value");		
				property.setScope(EndPointPropertyScope.SYNAPSE);
				TableItem item = bindProperty(property);
				tblProperties.select(tblProperties.indexOf(item));

			}
			
			public void widgetDefaultSelected(SelectionEvent event) {}
		});
		
		cmdRemoveProperty = new Button(container, SWT.NONE);
		cmdRemoveProperty.setBounds(626, 45, 86, 29);
		cmdRemoveProperty.setText("Remove");
		cmdRemoveProperty.setEnabled(false);
		cmdRemoveProperty.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				if(tblProperties.getSelectionIndex()!=-1)
					unbindProperty(tblProperties.getSelectionIndex());
				initTableEditor(propertyNameEditor, tblProperties);
				initTableEditor(propertyScopeEditor, tblProperties);
				initTableEditor(propertyValueEditor, tblProperties);
				cmdRemoveProperty.setEnabled(false);
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {}
		});
		
		for (Iterator<EndPointProperty> iterator = endPoint.getProperties().iterator(); iterator.hasNext();) {
			EndPointProperty property = iterator.next();
			bindProperty(property);
		}

		return area;
	}

	/**
	 * @param property
	 */
	public TableItem bindProperty(EndPointProperty property) {
		TableItem item = new TableItem(tblProperties, SWT.NONE);
		item.setText(0, property.getName());		
		item.setText(1,property.getValue());
		item.setText(2, property.getScope().toString());
		item.setData(property);
		return item;
	}
	
	/**
	 * @param property
	 */
	public void unbindProperty(int itemIndex) {
		TableItem item = tblProperties.getItem(itemIndex);

		if (item.getData() instanceof EndPointProperty) {
			EndPointProperty property = (EndPointProperty) item.getData();

			if (null != property.eContainer()) {
				RemoveCommand removeCmd = new RemoveCommand(editingDomain, endPoint,
						EsbPackage.Literals.END_POINT__PROPERTIES, property);
				getResultCommand().append(removeCmd);
			}
			tblProperties.remove(tblProperties.indexOf(item));
		}
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
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
	
	/**
	 * Utility method for retrieving the result {@link CompoundCommand} which is
	 * used to record user operations.
	 * 
	 * @return result command.
	 */
	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}
	
	private void editProperty(final TableItem item) {
		

		propertyNameEditor = initTableEditor(propertyNameEditor, item.getParent());
		txtPropertyName = new Text(item.getParent(), SWT.NONE);
		txtPropertyName.setText(item.getText(0));
		propertyNameEditor.setEditor(txtPropertyName, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		txtPropertyName.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				item.setText(0, txtPropertyName.getText());
			}
		});
		
		propertyValueEditor = initTableEditor(propertyValueEditor, item.getParent());
		txtPropertyValue = new Text(item.getParent(), SWT.NONE);
		txtPropertyValue.setText(item.getText(1));
		propertyValueEditor.setEditor(txtPropertyValue, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		txtPropertyValue.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				item.setText(1, txtPropertyValue.getText());
			}
		});		
		
		propertyScopeEditor = initTableEditor(propertyScopeEditor, item.getParent());
		cmbPropertyScope = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbPropertyScope.setItems(new String[] { EndPointPropertyScope.SYNAPSE.toString(),
				EndPointPropertyScope.TRANSPORT.toString(), EndPointPropertyScope.AXIS2.toString(),
				EndPointPropertyScope.AXIS2_CLIENT.toString() });
		cmbPropertyScope.setText(item.getText(2));
		propertyScopeEditor.setEditor(cmbPropertyScope, item, 2);
		item.getParent().redraw();
		item.getParent().layout();
		cmbPropertyScope.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(2, cmbPropertyScope.getText());
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
		
		for(TableItem item : tblProperties.getItems()){
			EndPointProperty property = (EndPointProperty)item.getData();
		
			AddCommand addCmd = null;

			if (null == property.eContainer()) {
				addCmd = new AddCommand(editingDomain, endPoint,
						EsbPackage.Literals.END_POINT__PROPERTIES, property);
				getResultCommand().append(addCmd);
			}

			SetCommand setCommand = null;
			
			if(!property.getName().equals(item.getText(0))){
				setCommand = new SetCommand(editingDomain, property,
						EsbPackage.Literals.END_POINT_PROPERTY__NAME, item.getText(0));
				getResultCommand().append(setCommand);
			}
				
				if(!property.getValue().equals(item.getText(1))){
					setCommand = new SetCommand(editingDomain, property,
							EsbPackage.Literals.END_POINT_PROPERTY__VALUE, item.getText(1));
					getResultCommand().append(setCommand);
				}					
			
			if(!property.getScope().toString().equals(item.getText(2))){
				setCommand = new SetCommand(editingDomain, property,
						EsbPackage.Literals.END_POINT_PROPERTY__SCOPE, EndPointPropertyScope.get(item.getText(2)));
				getResultCommand().append(setCommand);
			}
		}
		
		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		} else {
			if(getResultCommand().getCommandList().size()>1){
				log.error("EndPoint Properties : cannot save properties", new Exception(
						"Cannot execute command stack "));
			}
		}
		
		super.okPressed();
	}

}
