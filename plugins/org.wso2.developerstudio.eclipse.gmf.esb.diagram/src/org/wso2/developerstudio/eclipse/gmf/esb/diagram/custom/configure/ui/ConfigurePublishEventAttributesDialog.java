/*
 * Copyright 2015 WSO2, Inc. (http://wso2.com)
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
import org.eclipse.emf.common.util.EList;
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
import org.wso2.developerstudio.eclipse.gmf.esb.AttributeType;
import org.wso2.developerstudio.eclipse.gmf.esb.AttributeValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.PublishEventMediatorAttribute;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.PublishEventMediatorAttributeImpl;

public class ConfigurePublishEventAttributesDialog extends Dialog {
	private static final String EXPRESSION_DATA = "exp";
	private static final String PUBLISH_EVENT_ARBITRARY_CATEGORY = "arbitrary";
	private static final String PUBLISH_EVENT_PAYLOAD_CATEGORY = "payload";
	private static final String PUBLISH_EVENT_CORRELATION_CATEGORY = "correlation";
	private static final String PUBLISH_EVENT_META_CATEGORY = "meta";

	private Table publishEventAttributeTable;
	private TableEditor valueTypeEditor;
	private TableEditor typeEditor;
	private TableEditor attributeValueEditor;
	private Combo cmbValueType;
	private Combo cmbType;
	private PropertyText attributeValue;
	private PublishEventMediator publishEventMediator;
	private TransactionalEditingDomain editingDomain;
	private Button newAttributeButton;
	private Label publishEventAttributeLabel;
	private Button removeAttributeButton;
	private CompoundCommand resultCommand;
	private String attributeCategory;

	public ConfigurePublishEventAttributesDialog(Shell parentShell,
			PublishEventMediator publishEventMediator,
			TransactionalEditingDomain editingDomain, String attributeCategory) {
		super(parentShell);
		this.publishEventMediator = publishEventMediator;
		this.editingDomain = editingDomain;
		this.attributeCategory = attributeCategory;
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		// Set title.
		newShell.setText("PublishEvent Attributes Configuration");
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		newAttributeButton = new Button(container, SWT.NONE);
		{
			newAttributeButton.setText("New");
			FormData newAttributeButtonLayoutData = new FormData(80,
					SWT.DEFAULT);
			newAttributeButtonLayoutData.top = new FormAttachment(
					publishEventAttributeLabel, 10);
			newAttributeButtonLayoutData.right = new FormAttachment(100);
			newAttributeButton.setLayoutData(newAttributeButtonLayoutData);

			newAttributeButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					TableItem item = bindPublishEventAttribute(EsbFactory.eINSTANCE
							.createPublishEventMediatorAttribute());
					publishEventAttributeTable
							.select(publishEventAttributeTable.indexOf(item));
				}
			});
		}

		removeAttributeButton = new Button(container, SWT.NONE);
		{
			removeAttributeButton.setText("Remove");
			FormData removeAttributeButtonLayoutData = new FormData();
			removeAttributeButtonLayoutData.top = new FormAttachment(
					newAttributeButton, 5);
			removeAttributeButtonLayoutData.right = new FormAttachment(100);
			removeAttributeButtonLayoutData.left = new FormAttachment(
					newAttributeButton, 0, SWT.LEFT);
			removeAttributeButton
					.setLayoutData(removeAttributeButtonLayoutData);

			removeAttributeButton.addListener(SWT.Selection, new Listener() {
				public void handleEvent(Event event) {
					int selectedIndex = publishEventAttributeTable
							.getSelectionIndex();
					if (-1 != selectedIndex) {
						initTableEditor(valueTypeEditor,
								publishEventAttributeTable);
						initTableEditor(attributeValueEditor,
								publishEventAttributeTable);

						unbindpublishEventAttribute(selectedIndex);

						// Select the next available candidate for deletion.
						if (selectedIndex < publishEventAttributeTable
								.getItemCount()) {
							publishEventAttributeTable.select(selectedIndex);
						} else {
							publishEventAttributeTable
									.select(selectedIndex - 1);
						}
					}
				}
			});
		}

		publishEventAttributeTable = new Table(container, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
		{
			TableColumn nameColumn = new TableColumn(
					publishEventAttributeTable, SWT.LEFT);
			TableColumn valueColumn = new TableColumn(
					publishEventAttributeTable, SWT.LEFT);
			TableColumn valueTypeColumn = new TableColumn(
					publishEventAttributeTable, SWT.LEFT);
			TableColumn typeColumn = new TableColumn(
					publishEventAttributeTable, SWT.LEFT);

			nameColumn.setText("Name");
			nameColumn.setWidth(125);
			valueColumn.setText("Value/Expression");
			valueColumn.setWidth(175);
			valueTypeColumn.setText("Attribute Value");
			valueTypeColumn.setWidth(125);
			typeColumn.setText("Type");
			typeColumn.setWidth(125);

			publishEventAttributeTable.setHeaderVisible(true);
			publishEventAttributeTable.setLinesVisible(true);

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

			publishEventAttributeTable.addListener(SWT.Selection,
					tblPropertiesListener);

			// Populate properties.
			EList<PublishEventMediatorAttribute> visualAttributesList = null;
			if (attributeCategory.equals(PUBLISH_EVENT_META_CATEGORY)) {
				visualAttributesList = publishEventMediator.getMetaAttributes();
			}
			if (attributeCategory.equals(PUBLISH_EVENT_CORRELATION_CATEGORY)) {
				visualAttributesList = publishEventMediator
						.getCorrelationAttributes();
			}
			if (attributeCategory.equals(PUBLISH_EVENT_PAYLOAD_CATEGORY)) {
				visualAttributesList = publishEventMediator
						.getPayloadAttributes();
			}
			if (attributeCategory.equals(PUBLISH_EVENT_ARBITRARY_CATEGORY)) {
				visualAttributesList = publishEventMediator
						.getArbitraryAttributes();
			}
			for (PublishEventMediatorAttribute attribute : visualAttributesList) {
				bindPublishEventAttribute(attribute);
			}

			// In-line editing of properties.
			setupTableEditor(publishEventAttributeTable);

			// Layout.
			FormData publishEventAttributeTableLayoutData = new FormData(
					SWT.DEFAULT, 150);
			publishEventAttributeTableLayoutData.top = new FormAttachment(
					newAttributeButton, 0, SWT.TOP);
			publishEventAttributeTableLayoutData.left = new FormAttachment(0);
			publishEventAttributeTableLayoutData.right = new FormAttachment(
					newAttributeButton, -5);
			publishEventAttributeTableLayoutData.bottom = new FormAttachment(
					100);
			publishEventAttributeTable
					.setLayoutData(publishEventAttributeTableLayoutData);
		}

		return container;
	}

	private void editItem(final TableItem item) {
		NamespacedProperty expression = ((PublishEventMediatorAttributeImpl) item
				.getData()).getAttributeExpression();

		// value type table editor
		valueTypeEditor = initTableEditor(valueTypeEditor, item.getParent());
		cmbValueType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbValueType.setItems(new String[] {
				AttributeValueType.VALUE.getLiteral(),
				AttributeValueType.EXPRESSION.getLiteral() });
		cmbValueType.setText(item.getText(2));
		valueTypeEditor.setEditor(cmbValueType, item, 2);

		item.getParent().redraw();
		item.getParent().layout();

		typeEditor = initTableEditor(typeEditor, item.getParent());
		cmbType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbType.setItems(new String[] { AttributeType.STRING.getLiteral(),
				AttributeType.INTEGER.getLiteral(),
				AttributeType.BOOLEAN.getLiteral(),
				AttributeType.DOUBLE.getLiteral(),
				AttributeType.FLOAT.getLiteral(),
				AttributeType.LONG.getLiteral() });
		cmbType.setText(item.getText(3));
		typeEditor.setEditor(cmbType, item, 3);

		item.getParent().redraw();
		item.getParent().layout();

		cmbValueType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(2, cmbValueType.getText());
			}
		});

		cmbType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(3, cmbType.getText());
			}
		});

		attributeValueEditor = initTableEditor(attributeValueEditor,
				item.getParent());
		attributeValue = new PropertyText(item.getParent(), SWT.NONE,
				cmbValueType);
		attributeValue.addProperties(item.getText(1), expression);
		attributeValueEditor.setEditor(attributeValue, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		attributeValue.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				item.setText(1, attributeValue.getText());
				Object property = attributeValue.getProperty();
				if (property instanceof NamespacedProperty) {
					item.setData(EXPRESSION_DATA, (NamespacedProperty) property);
				}
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

	private TableItem bindPublishEventAttribute(
			PublishEventMediatorAttribute attribute) {
		TableItem item = new TableItem(publishEventAttributeTable, SWT.NONE);
		if (attribute.getAttributeValueType().getLiteral()
				.equals(AttributeValueType.VALUE.getLiteral())) {
			item.setText(new String[] { attribute.getAttributeName(),
					attribute.getAttributeValue(),
					attribute.getAttributeValueType().getLiteral(),
					attribute.getAttributeType().getLiteral() });
		}
		if (attribute.getAttributeValueType().getLiteral()
				.equals(AttributeValueType.EXPRESSION.getLiteral())) {
			item.setText(new String[] { attribute.getAttributeName(),
					attribute.getAttributeExpression().getPropertyValue(),
					attribute.getAttributeValueType().getLiteral(),
					attribute.getAttributeType().getLiteral() });
			item.setData(EXPRESSION_DATA, EsbFactory.eINSTANCE
					.copyNamespacedProperty(attribute.getAttributeExpression()));
		}

		item.setData(attribute);
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

	private void unbindpublishEventAttribute(int itemIndex) {
		TableItem item = publishEventAttributeTable.getItem(itemIndex);
		PublishEventMediatorAttribute attribute = (PublishEventMediatorAttribute) item
				.getData();
		if (null != attribute.eContainer()) {
			RemoveCommand removeCmd = null;
			if (attributeCategory.equals(PUBLISH_EVENT_META_CATEGORY)) {
				removeCmd = new RemoveCommand(
						editingDomain,
						publishEventMediator,
						EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES,
						attribute);
			}
			if (attributeCategory.equals(PUBLISH_EVENT_CORRELATION_CATEGORY)) {
				removeCmd = new RemoveCommand(
						editingDomain,
						publishEventMediator,
						EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES,
						attribute);
			}
			if (attributeCategory.equals(PUBLISH_EVENT_PAYLOAD_CATEGORY)) {
				removeCmd = new RemoveCommand(
						editingDomain,
						publishEventMediator,
						EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES,
						attribute);
			}
			if (attributeCategory.equals(PUBLISH_EVENT_ARBITRARY_CATEGORY)) {
				removeCmd = new RemoveCommand(
						editingDomain,
						publishEventMediator,
						EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES,
						attribute);
			}
			getResultCommand().append(removeCmd);
		}
		publishEventAttributeTable.remove(publishEventAttributeTable
				.indexOf(item));
	}

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}

	protected void okPressed() {
		configureAttributes();
		super.okPressed();
	}

	private void configureAttributes() {
		for (TableItem item : publishEventAttributeTable.getItems()) {
			PublishEventMediatorAttribute attribute = (PublishEventMediatorAttribute) item
					.getData();
			NamespacedProperty expression = ((PublishEventMediatorAttributeImpl) item
					.getData()).getAttributeExpression();

			// If this attribute is a new one
			// eContainer is null when attribute class is not bound to EMF
			// model. Setters are used instead of commands
			if (attribute.eContainer() == null) {
				// Update the publishEvent attribute with the latest data from
				// table row
				attribute.setAttributeName(item.getText(0));

				if (item.getText(2).equals(
						AttributeValueType.VALUE.getLiteral())) {
					attribute.setAttributeValueType(AttributeValueType.VALUE);
					attribute.setAttributeValue(item.getText(1));
				} else if (item.getText(2).equals(
						AttributeValueType.EXPRESSION.getLiteral())) {
					attribute
							.setAttributeValueType(AttributeValueType.EXPRESSION);
					NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE
							.createNamespacedProperty();
					namespaceProperty.setPropertyValue(item.getText(1));
					namespaceProperty.setNamespaces(expression.getNamespaces());
					attribute.setAttributeExpression(namespaceProperty);
				}

				if (item.getText(3).equals(AttributeType.STRING.getLiteral())) {
					attribute.setAttributeType(AttributeType.STRING);
				} else if (item.getText(3).equals(
						AttributeType.INTEGER.getLiteral())) {
					attribute.setAttributeType(AttributeType.INTEGER);
				} else if (item.getText(3).equals(
						AttributeType.BOOLEAN.getLiteral())) {
					attribute.setAttributeType(AttributeType.BOOLEAN);
				} else if (item.getText(3).equals(
						AttributeType.FLOAT.getLiteral())) {
					attribute.setAttributeType(AttributeType.FLOAT);
				} else if (item.getText(3).equals(
						AttributeType.DOUBLE.getLiteral())) {
					attribute.setAttributeType(AttributeType.DOUBLE);
				} else if (item.getText(3).equals(
						AttributeType.LONG.getLiteral())) {
					attribute.setAttributeType(AttributeType.LONG);
				}

				// Record the add operation.
				AddCommand addCmd = null;
				if (attributeCategory.equals(PUBLISH_EVENT_META_CATEGORY)) {
					addCmd = new AddCommand(
							editingDomain,
							publishEventMediator,
							EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__META_ATTRIBUTES,
							attribute);
				}
				if (attributeCategory
						.equals(PUBLISH_EVENT_CORRELATION_CATEGORY)) {
					addCmd = new AddCommand(
							editingDomain,
							publishEventMediator,
							EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__CORRELATION_ATTRIBUTES,
							attribute);
				}
				if (attributeCategory.equals(PUBLISH_EVENT_PAYLOAD_CATEGORY)) {
					addCmd = new AddCommand(
							editingDomain,
							publishEventMediator,
							EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__PAYLOAD_ATTRIBUTES,
							attribute);
				}
				if (attributeCategory.equals(PUBLISH_EVENT_ARBITRARY_CATEGORY)) {
					addCmd = new AddCommand(
							editingDomain,
							publishEventMediator,
							EsbPackage.Literals.PUBLISH_EVENT_MEDIATOR__ARBITRARY_ATTRIBUTES,
							attribute);
				}
				getResultCommand().append(addCmd);
			} else {
				// If the property name needs to be updated.
				SetCommand setCmdName = new SetCommand(
						editingDomain,
						attribute,
						EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_NAME,
						item.getText(0));
				getResultCommand().append(setCmdName);

				if (item.getText(2).equals(
						AttributeValueType.VALUE.getLiteral())) {
					SetCommand setCmdType = new SetCommand(
							editingDomain,
							attribute,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE_TYPE,
							AttributeValueType.VALUE);
					getResultCommand().append(setCmdType);
					SetCommand setCmdValue = new SetCommand(
							editingDomain,
							attribute,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE,
							item.getText(1));
					getResultCommand().append(setCmdValue);
				} else if (item.getText(2).equals(
						AttributeValueType.EXPRESSION.getLiteral())) {
					SetCommand setCmdType = new SetCommand(
							editingDomain,
							attribute,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_VALUE_TYPE,
							AttributeValueType.EXPRESSION);
					getResultCommand().append(setCmdType);

					NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE
							.createNamespacedProperty();
					namespaceProperty.setPropertyValue(item.getText(1));
					namespaceProperty.setNamespaces(expression.getNamespaces());

					SetCommand setCmdExpression = new SetCommand(
							editingDomain,
							attribute,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_EXPRESSION,
							namespaceProperty);
					getResultCommand().append(setCmdExpression);
				}

				if (item.getText(3).equals(AttributeType.STRING.getLiteral())) {
					SetCommand setCmdType = new SetCommand(
							editingDomain,
							attribute,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE,
							AttributeType.STRING);
					getResultCommand().append(setCmdType);
				} else if (item.getText(3).equals(
						AttributeType.INTEGER.getLiteral())) {
					SetCommand setCmdType = new SetCommand(
							editingDomain,
							attribute,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE,
							AttributeType.INTEGER);
					getResultCommand().append(setCmdType);
				} else if (item.getText(3).equals(
						AttributeType.BOOLEAN.getLiteral())) {
					SetCommand setCmdType = new SetCommand(
							editingDomain,
							attribute,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE,
							AttributeType.BOOLEAN);
					getResultCommand().append(setCmdType);
				} else if (item.getText(3).equals(
						AttributeType.FLOAT.getLiteral())) {
					SetCommand setCmdType = new SetCommand(
							editingDomain,
							attribute,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE,
							AttributeType.FLOAT);
					getResultCommand().append(setCmdType);
				} else if (item.getText(3).equals(
						AttributeType.DOUBLE.getLiteral())) {
					SetCommand setCmdType = new SetCommand(
							editingDomain,
							attribute,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE,
							AttributeType.DOUBLE);
					getResultCommand().append(setCmdType);
				} else if (item.getText(3).equals(
						AttributeType.LONG.getLiteral())) {
					SetCommand setCmdType = new SetCommand(
							editingDomain,
							attribute,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_EXPRESSION_ATTRIBUTE__ATTRIBUTE_TYPE,
							AttributeType.LONG);
					getResultCommand().append(setCmdType);
				}
			}
		}
		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		}
	}

}
