package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.util.ArrayList;

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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariable;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableType;
import org.wso2.developerstudio.eclipse.gmf.esb.XQueryVariableValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.NamedEntityDescriptor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.RegistryKeyPropertyEditorDialog;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;

public class ConfigureXQueryMediatorDialog extends Dialog {
	
	private static final String LITERAL_TYPE = "LITERAL";
	private static final String EXPRESSION_TYPE = "EXPRESSION";
	private Table xqueryVariableTable;
	private TableEditor variableTypeEditor;
	private TableEditor valueTypeEditor;
	private TableEditor regKeyEditor;
	private TableEditor variableValueEditor;
	private Combo cmbValueType;
	private Combo cmbVariableType;
	private Text regKeyText;
	private PropertyText variableValue;
	private XQueryMediator xqueryMediator;
	private TransactionalEditingDomain editingDomain;
	private Button newXQueryVariableButton;
	private Label xqueryVariableLabel;
	private Button removeXQueryVariableButton;
	private CompoundCommand resultCommand;
	private Shell parentShell;
	
	public ConfigureXQueryMediatorDialog(Shell parentShell,
			XQueryMediator xqueryMediator, TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.xqueryMediator = xqueryMediator;
		this.editingDomain = editingDomain;
	}
	
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		parentShell = newShell;
		// Set title.
		newShell.setText("XQuery Variables Configuration");
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);
		
		newXQueryVariableButton = new Button(container, SWT.NONE);
		{
			newXQueryVariableButton.setText("New...");
			FormData newXQueryVariableButtonLayoutData = new FormData(80,
					SWT.DEFAULT);
			newXQueryVariableButtonLayoutData.top = new FormAttachment(
					xqueryVariableLabel, 10);
			newXQueryVariableButtonLayoutData.right = new FormAttachment(100);
			newXQueryVariableButton.setLayoutData(newXQueryVariableButtonLayoutData);

			newXQueryVariableButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					TableItem item = bindXQueryVariable(EsbFactory.eINSTANCE
							.createXQueryVariable());
					xqueryVariableTable.select(xqueryVariableTable.indexOf(item));
				}
			});
		}
		
		removeXQueryVariableButton = new Button(container, SWT.NONE);
		{
			removeXQueryVariableButton.setText("Remove");
			FormData removeXQueryVariableButtonLayoutData = new FormData();
			removeXQueryVariableButtonLayoutData.top = new FormAttachment(
					newXQueryVariableButton, 5);
			removeXQueryVariableButtonLayoutData.right = new FormAttachment(100);
			removeXQueryVariableButtonLayoutData.left = new FormAttachment(
					newXQueryVariableButton, 0, SWT.LEFT);
			removeXQueryVariableButton
					.setLayoutData(removeXQueryVariableButtonLayoutData);

			removeXQueryVariableButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					int selectedIndex = xqueryVariableTable.getSelectionIndex();
					if (-1 != selectedIndex) {
						initTableEditor(variableTypeEditor, xqueryVariableTable);
						initTableEditor(valueTypeEditor, xqueryVariableTable);
						initTableEditor(regKeyEditor, xqueryVariableTable);
						initTableEditor(variableValueEditor, xqueryVariableTable);
						
						unbindXQueryVariable(selectedIndex);

						// Select the next available candidate for deletion.
						if (selectedIndex < xqueryVariableTable.getItemCount()) {
							xqueryVariableTable.select(selectedIndex);
						} else {
							xqueryVariableTable.select(selectedIndex - 1);
						}
					}
				}
			});
		}
		
		xqueryVariableTable = new Table(container, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		{
			TableColumn nameColumn = new TableColumn(xqueryVariableTable,
					SWT.LEFT);
			TableColumn variableTypeColumn = new TableColumn(xqueryVariableTable,
					SWT.LEFT);
			TableColumn valueColumn = new TableColumn(xqueryVariableTable,
					SWT.LEFT);
			TableColumn typeColumn = new TableColumn(xqueryVariableTable,
					SWT.LEFT);
			TableColumn keyColumn = new TableColumn(xqueryVariableTable, SWT.LEFT);
			
			nameColumn.setText("Name");
			nameColumn.setWidth(150);
			variableTypeColumn.setText("Variable Type");
			variableTypeColumn.setWidth(150);
			valueColumn.setText("Value/Expression");
			valueColumn.setWidth(200);
			typeColumn.setText("Type");
			typeColumn.setWidth(150);
			keyColumn.setText("Key");
			keyColumn.setWidth(150);

			xqueryVariableTable.setHeaderVisible(true);
			xqueryVariableTable.setLinesVisible(true);

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

			xqueryVariableTable
					.addListener(SWT.Selection, tblPropertiesListener);

			// Populate properties.
			for (XQueryVariable variable : xqueryMediator.getVariables()) {
				bindXQueryVariable(variable);
			}

			// In-line editing of properties.
			setupTableEditor(xqueryVariableTable);

			// Layout.
			FormData xqueryVariableTableLayoutData = new FormData(SWT.DEFAULT,
					150);
			xqueryVariableTableLayoutData.top = new FormAttachment(
					newXQueryVariableButton, 0, SWT.TOP);
			xqueryVariableTableLayoutData.left = new FormAttachment(0);
			xqueryVariableTableLayoutData.right = new FormAttachment(
					newXQueryVariableButton, -5);
			xqueryVariableTableLayoutData.bottom = new FormAttachment(100);
			xqueryVariableTable.setLayoutData(xqueryVariableTableLayoutData);
		}

		return container;
	}
	
	private void editItem(final TableItem item) {
		
		NamespacedProperty expression = (NamespacedProperty)item.getData("exp");
		
		//value type table editor
		valueTypeEditor = initTableEditor(valueTypeEditor,
				item.getParent());
		cmbValueType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbValueType.setItems(new String[] { LITERAL_TYPE,EXPRESSION_TYPE });
		cmbValueType.setText(item.getText(3));
		valueTypeEditor.setEditor(cmbValueType, item, 3);
		
		//variable type table editor
		variableTypeEditor = initTableEditor(variableTypeEditor,
				item.getParent());
		cmbVariableType=new Combo(item.getParent(), SWT.READ_ONLY);
		cmbVariableType.setItems(new String[]{"DOCUMENT","DOCUMENT_ELEMENT","ELEMENT","INT","INTEGER","BOOLEAN","BYTE","DOUBLE","SHORT","LONG","FLOAT","STRING"});		
		cmbVariableType.setText(item.getText(1));
		variableTypeEditor.setEditor(cmbVariableType, item, 1);
		
		regKeyEditor = initTableEditor(regKeyEditor, item.getParent());
		
		regKeyText = new Text(item.getParent(), SWT.NONE);
		regKeyText.setEditable(false);
		
		regKeyText.addMouseListener(new MouseAdapter() {
		
			public void mouseDown(MouseEvent e) {
				
				if (item.getText(3).equals(EXPRESSION_TYPE)) {
					RegistryKeyProperty registryPropertyKey = EsbFactory.eINSTANCE
							.createRegistryKeyProperty();

					RegistryKeyPropertyEditorDialog rkpe = new RegistryKeyPropertyEditorDialog(
							parentShell, SWT.NULL, registryPropertyKey,
							new ArrayList<NamedEntityDescriptor>());
					rkpe.open();

					if (registryPropertyKey.getKeyValue() != null) {
						
						item.setText(4, registryPropertyKey.getKeyValue());
						regKeyText.setText(item.getText(4));
						
					}

				}
			}
			
		});	
		
		regKeyEditor.setEditor(regKeyText,item,4);
				
		item.getParent().redraw();
		item.getParent().layout();
		cmbValueType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				String selectedItemText = cmbValueType.getText();
				item.setText(3, cmbValueType.getText());
				
				if(selectedItemText.equals(EXPRESSION_TYPE)){
					
					if(!regKeyText.isEnabled()){
						
						regKeyText.setEnabled(true);
					}
					
				}else if(selectedItemText.equals(LITERAL_TYPE)){
					
					regKeyText.setText("");
					if(regKeyText.isEnabled()){
						
						regKeyText.setEnabled(false);
					}
				}
			}
		});
		
		variableValueEditor = initTableEditor(variableValueEditor,
				item.getParent());
		
		variableValue = new PropertyText(item.getParent(), SWT.NONE, cmbValueType);
		variableValue.addProperties(item.getText(2), expression);
		variableValueEditor.setEditor(variableValue, item, 2);
		item.getParent().redraw();
		item.getParent().layout();
		variableValue.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(2,variableValue.getText());
				Object property = variableValue.getProperty();
				if(property instanceof NamespacedProperty){
					item.setData("exp",(NamespacedProperty)property);
				} 
			}
		});
		
		cmbVariableType.addListener(SWT.Selection, new Listener() {			
			public void handleEvent(Event evt) {
				item.setText(1, cmbVariableType.getText());
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
	
	private TableItem bindXQueryVariable(XQueryVariable variable) {
		TableItem item = new TableItem(xqueryVariableTable, SWT.NONE);
		if (variable.getValueType().getLiteral().equals("LITERAL")) {
			item.setText(new String[] { variable.getVariableName(),
					variable.getVariableType().getLiteral(),
					variable.getValueLiteral(),
					variable.getValueType().getLiteral()});
		}
		if (variable.getValueType().getLiteral().equals("EXPRESSION")) {
			item.setText(new String[] { variable.getVariableName(),
					variable.getVariableType().getLiteral(),
					variable.getValueExpression().getPropertyValue(),
					variable.getValueType().getLiteral(),
					variable.getValueKey().getKeyValue()});
		}

		item.setData(variable);
		item.setData("exp",
				EsbFactory.eINSTANCE.copyNamespacedProperty(variable.getValueExpression()));
		return item;
	}
	
	private void setupTableEditor(final Table table) {
		final TableEditor cellEditor = new TableEditor(table);
		cellEditor.grabHorizontal = true;
		cellEditor.minimumWidth = 50;
		table.addMouseListener(new MouseAdapter() {
			/**
			 * Setup a new cell editor control at double click event.
			 */
			public void mouseDoubleClick(MouseEvent e) {
				// Dispose the old editor control (if one is setup).
				Control oldEditorControl = cellEditor.getEditor();
				if (null != oldEditorControl)
					oldEditorControl.dispose();

				// Mouse location.
				Point mouseLocation = new Point(e.x, e.y);

				// Grab the selected row.
				TableItem item = (TableItem) table.getItem(mouseLocation);
				if (null == item)
					return;

				// Determine which column was selected.
				int selectedColumn = -1;
				for (int i = 0, n = table.getColumnCount(); i < n; i++) {
					if (item.getBounds(i).contains(mouseLocation)) {
						selectedColumn = i;
						break;
					}
				}

				// Setup a new editor control.
				if (-1 != selectedColumn) {
					Text editorControl = new Text(table, SWT.NONE);
					final int editorControlColumn = selectedColumn;
					editorControl.setText(item.getText(selectedColumn));
					editorControl.addModifyListener(new ModifyListener() {
						public void modifyText(ModifyEvent e) {
							Text text = (Text) cellEditor.getEditor();
							cellEditor.getItem().setText(editorControlColumn,
									text.getText());
						}
					});
					editorControl.selectAll();
					editorControl.setFocus();
					cellEditor.setEditor(editorControl, item, selectedColumn);
				}
			}

			/**
			 * Dispose cell editor control at mouse down (otherwise the control
			 * keep showing).
			 */
			public void mouseDown(MouseEvent e) {
				Control oldEditorControl = cellEditor.getEditor();
				if (null != oldEditorControl)
					oldEditorControl.dispose();
			}
		});
	}
	
	private void unbindXQueryVariable(int itemIndex) {
		TableItem item = xqueryVariableTable.getItem(itemIndex);
		XQueryVariable variable = (XQueryVariable) item.getData();
		if (null != variable.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					xqueryMediator, EsbPackage.Literals.XQUERY_MEDIATOR__VARIABLES,
					variable);
			getResultCommand().append(removeCmd);
		}
		xqueryVariableTable.remove(xqueryVariableTable.indexOf(item));
	}
	
	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}
	
	protected void okPressed() {
		
		for (TableItem item : xqueryVariableTable.getItems()) {
			XQueryVariable variable = (XQueryVariable) item.getData();
			NamespacedProperty expression = (NamespacedProperty)item.getData("exp");

			// If the variable is a new one, add it to the model.
			if (null == variable.eContainer()) {
				XQueryVariableType xqueryVariableType = null;
				// Update the xquery variable with the latest data from table row.
				variable.setVariableName(item.getText(0));
				
				if (item.getText(3).equals("LITERAL")) {
					variable.setValueType(XQueryVariableValueType.LITERAL);
					variable.setValueLiteral(item.getText(2));
				}

				if (item.getText(3).equals("EXPRESSION")) {
					variable.setValueType(XQueryVariableValueType.EXPRESSION);
					NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE
							.createNamespacedProperty();
					namespaceProperty.setPropertyValue(item.getText(2));
					namespaceProperty.setNamespaces(expression.getNamespaces());
					variable.setValueExpression(namespaceProperty);
					
					RegistryKeyProperty keyProperty=EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
					keyProperty.setKeyValue(item.getText(4));
					variable.setValueKey(keyProperty);
				}
				
				if(item.getText(1).equals("DOCUMENT")) 
					xqueryVariableType=XQueryVariableType.DOCUMENT;						
				if(item.getText(1).equals("DOCUMENT_ELEMENT"))
					 xqueryVariableType=XQueryVariableType.DOCUMENT_ELEMENT;
				if(item.getText(1).equals("ELEMENT"))
					 xqueryVariableType=XQueryVariableType.ELEMENT;
				if(item.getText(1).equals("INT"))
					 xqueryVariableType=XQueryVariableType.INT;
				if(item.getText(1).equals("INTEGER"))
					 xqueryVariableType=XQueryVariableType.INTEGER;
				if(item.getText(1).equals("BOOLEAN"))
					 xqueryVariableType=XQueryVariableType.BOOLEAN;
				if(item.getText(1).equals("BYTE"))
					 xqueryVariableType=XQueryVariableType.BYTE;
				if(item.getText(1).equals("DOUBLE"))
					 xqueryVariableType=XQueryVariableType.DOUBLE;
				if(item.getText(1).equals("SHORT"))
					 xqueryVariableType=XQueryVariableType.SHORT;
				if(item.getText(1).equals("LONG"))
					 xqueryVariableType=XQueryVariableType.LONG;
				if(item.getText(1).equals("FLOAT"))
					 xqueryVariableType=XQueryVariableType.FLOAT;
				if(item.getText(1).equals("STRING"))
					 xqueryVariableType=XQueryVariableType.STRING;
				

				variable.setVariableType(xqueryVariableType);
				
				
				

				// Record the add operation.
				AddCommand addCmd = new AddCommand(editingDomain, xqueryMediator,
						EsbPackage.Literals.XQUERY_MEDIATOR__VARIABLES, variable);
				getResultCommand().append(addCmd);
			} else {
				XQueryVariableType xqueryVariableType = null;
				// If the property name needs to be updated.
				if (!variable.getVariableName().equals(item.getText(0))) {
					SetCommand setCmd = new SetCommand(
							editingDomain,
							variable,
							EsbPackage.Literals.XQUERY_VARIABLE__VARIABLE_NAME,
							item.getText(0));
					getResultCommand().append(setCmd);
				}

				if (item.getText(3).equals("LITERAL")) {

					SetCommand setCmdValueType = new SetCommand(
							editingDomain,
							variable,
							EsbPackage.Literals.XQUERY_VARIABLE__VALUE_TYPE,
							XQueryVariableValueType.LITERAL);
					getResultCommand().append(setCmdValueType);
					if (!variable.getValueLiteral().equals(item.getText(2))) {
						SetCommand setCmd = new SetCommand(
								editingDomain,
								variable,
								EsbPackage.Literals.XQUERY_VARIABLE__VALUE_LITERAL,
								item.getText(2));
						getResultCommand().append(setCmd);
					}
				}
				if (item.getText(3).equals("EXPRESSION")) {
					SetCommand setCmdValueType = new SetCommand(
							editingDomain,
							variable,
							EsbPackage.Literals.XQUERY_VARIABLE__VALUE_TYPE,
							XQueryVariableValueType.EXPRESSION);
					getResultCommand().append(setCmdValueType);

					if (variable.getValueExpression() == null) {
						NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE
								.createNamespacedProperty();
						namespaceProperty.setPropertyValue(item.getText(2));
						namespaceProperty.setNamespaces(expression.getNamespaces());

						AddCommand addCmd = new AddCommand(
								editingDomain,
								variable,
								EsbPackage.Literals.XQUERY_VARIABLE__VALUE_EXPRESSION,
								namespaceProperty);
						getResultCommand().append(addCmd);
					} else {
						SetCommand setCmd = new SetCommand(
								editingDomain,
								variable.getValueExpression(),
								EsbPackage.Literals.NAMESPACED_PROPERTY__PROPERTY_VALUE,
								item.getText(2));
						getResultCommand().append(setCmd);
						
						setCmd = new SetCommand(
								editingDomain,
								variable.getValueExpression(),
								EsbPackage.Literals.NAMESPACED_PROPERTY__NAMESPACES,
								expression.getNamespaces());
						getResultCommand().append(setCmd);
					}
					
					if(variable.getValueKey()==null){
						RegistryKeyProperty keyProperty =EsbFactoryImpl.eINSTANCE.createRegistryKeyProperty();
						keyProperty.setKeyValue(item.getText(4));
						
						AddCommand addCmd = new AddCommand(
								editingDomain,
								variable,
								EsbPackage.Literals.XQUERY_VARIABLE__VALUE_KEY,
								keyProperty);
						getResultCommand().append(addCmd);
						
					} else{
						SetCommand setCmd = new SetCommand(
								editingDomain,
								variable.getValueKey(),
								EsbPackage.Literals.REGISTRY_KEY_PROPERTY__KEY_VALUE,
								item.getText(4));
						getResultCommand().append(setCmd);
					}

				}
				if(item.getText(1).equals("DOCUMENT"))
					 xqueryVariableType=XQueryVariableType.DOCUMENT;						
				if(item.getText(1).equals("DOCUMENT_ELEMENT"))
					 xqueryVariableType=XQueryVariableType.DOCUMENT_ELEMENT;
				if(item.getText(1).equals("ELEMENT"))
					 xqueryVariableType=XQueryVariableType.ELEMENT;
				if(item.getText(1).equals("INT"))
					 xqueryVariableType=XQueryVariableType.INT;
				if(item.getText(1).equals("INTEGER"))
					 xqueryVariableType=XQueryVariableType.INTEGER;
				if(item.getText(1).equals("BOOLEAN"))
					 xqueryVariableType=XQueryVariableType.BOOLEAN;
				if(item.getText(1).equals("BYTE"))
					 xqueryVariableType=XQueryVariableType.BYTE;
				if(item.getText(1).equals("DOUBLE"))
					 xqueryVariableType=XQueryVariableType.DOUBLE;
				if(item.getText(1).equals("SHORT"))
					 xqueryVariableType=XQueryVariableType.SHORT;
				if(item.getText(1).equals("LONG"))
					 xqueryVariableType=XQueryVariableType.LONG;
				if(item.getText(1).equals("FLOAT"))
					 xqueryVariableType=XQueryVariableType.FLOAT;
				if(item.getText(1).equals("STRING"))
					 xqueryVariableType=XQueryVariableType.STRING;
				SetCommand setCmdValueType = new SetCommand(
						editingDomain,
						variable,
						EsbPackage.Literals.XQUERY_VARIABLE__VARIABLE_TYPE,
						xqueryVariableType);
				getResultCommand().append(setCmdValueType);

			}
		}

		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		} 
		

		super.okPressed();
	}
	
	
	
}
