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
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CallTemplateParameter;
import org.wso2.developerstudio.eclipse.gmf.esb.CloudConnectorOperation;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.Mediator;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.impl.EsbFactoryImpl;
	
	/**
	 * Customized Dialog for adding removing CallTemplate Parameters
	 * 
	 */
public class CallTemplateParamDialog extends Dialog {
    /**
     * Value type constant.
     */
	private static final String VALUE_TYPE = "Value";
	/**
	 * Expression type constant.
	 */
	private static final String EXPRESSION_TYPE = "Expression";
	/**
	 * Table for add/edit/remove parameters.
	 */
	private Table paramTable;
	/**
	 * Table Editors
	 */
	private TableEditor paramTypeEditor;
	private TableEditor paramNameEditor;
	private TableEditor paramValueEditor;
	/**
	 * Table widgets
	 */
	private Combo cmbParamType;
	private Text txtParamName;
	private PropertyText paramValue;
	/**
	 * Button for add new parameter.
	 */
	private Button newParamButton;
	/**
	 * Button for remove parameter.
	 */
	private Button removeParamButton;
	/**
	 * Editing domain.
	 */
	private TransactionalEditingDomain editingDomain;
	/**
	 * {@link CallTemplateMediator} domain object.
	 */
	private Mediator mediator;
	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;

	
	public CallTemplateParamDialog(Shell parentShell,
			Mediator mediator,
			TransactionalEditingDomain editingDomain) {
		super(parentShell);

		this.editingDomain = editingDomain;
		this.mediator = mediator;
		// Set title
		parentShell.setText("Call Template Mediator Configuration.");
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
						.createCallTemplateParameter());
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
					initTableEditor(paramTypeEditor, paramTable);
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
		TableColumn typeColumn = new TableColumn(paramTable, SWT.LEFT);
		TableColumn valueColumn = new TableColumn(paramTable, SWT.LEFT);
		
		nameColumn.setText("Parameter Name");
		nameColumn.setWidth(150);
		typeColumn.setText("Parameter Type");
		typeColumn.setWidth(150);
		valueColumn.setText("Value/Expression");
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
		EList<CallTemplateParameter> parameters = null;
		if(mediator instanceof CallTemplateMediator){
			parameters=((CallTemplateMediator)mediator).getTemplateParameters();
		}else if(mediator instanceof CloudConnectorOperation){
			parameters=((CloudConnectorOperation)mediator).getConnectorParameters();
		}
		for (CallTemplateParameter param : parameters) {
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

	/**
	 * Sets up a table editor that allows users to edit cell values inline.
	 * 
	 * @param table
	 *            table against which a table editor is setup.
	 */
	@Deprecated
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

	private void editItem(final TableItem item) {
		
		NamespacedProperty expression = (NamespacedProperty)item.getData("exp");
		
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
		
		paramTypeEditor = initTableEditor(paramTypeEditor,
				item.getParent());
		cmbParamType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbParamType.setItems(new String[] { VALUE_TYPE, EXPRESSION_TYPE });
		cmbParamType.setText(item.getText(1));
		paramTypeEditor.setEditor(cmbParamType, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		cmbParamType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(1, cmbParamType.getText());
			}
		});
		
		paramValueEditor = initTableEditor(paramValueEditor,
				item.getParent());
		
		paramValue = new PropertyText(item.getParent(), SWT.NONE, cmbParamType);
		paramValue.addProperties(item.getText(2),expression);
		paramValueEditor.setEditor(paramValue, item, 2);
		item.getParent().redraw();
		item.getParent().layout();
		paramValue.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(2,paramValue.getText());
				Object property = paramValue.getProperty();
				if(property instanceof NamespacedProperty){
					item.setData("exp",(NamespacedProperty)property);
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

	private TableItem bindPram(CallTemplateParameter param) {
		TableItem item = new TableItem(paramTable, SWT.NONE);
		if (param.getTemplateParameterType().getLiteral().equals(VALUE_TYPE)) {
			item.setText(new String[] { param.getParameterName(),
					param.getTemplateParameterType().getLiteral(),
					param.getParameterValue()
					 });
		}
		if (param.getTemplateParameterType().getLiteral()
				.equals(EXPRESSION_TYPE)) {
			item.setText(new String[] { param.getParameterName(),
					param.getTemplateParameterType().getLiteral(),
					param.getParameterExpression().getPropertyValue()
					});
		}

		item.setData(param);
		item.setData("exp", EsbFactory.eINSTANCE.copyNamespacedProperty(param.getParameterExpression()));
		return item;
	}

	private void unbindParam(int itemIndex) {
		TableItem item = paramTable.getItem(itemIndex);
		CallTemplateParameter param = (CallTemplateParameter) item.getData();
		if (param.eContainer() != null) {
			RemoveCommand removeCmd=null;
			if (mediator instanceof CallTemplateMediator) {
				removeCmd = new RemoveCommand(editingDomain, mediator,
						EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS, param);
			} else if (mediator instanceof CloudConnectorOperation) {
				removeCmd = new RemoveCommand(editingDomain, mediator,
						EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS, param);
			}
			getResultCommand().append(removeCmd);
		}

		paramTable.remove(paramTable.indexOf(item));
	}

	protected void okPressed() {

		for (TableItem item : paramTable.getItems()) {

			CallTemplateParameter param = (CallTemplateParameter) item.getData();
			NamespacedProperty expression = (NamespacedProperty)item.getData("exp");

			if (param.eContainer() == null) {

				param.setParameterName(item.getText(0));

				if (item.getText(1).equals(VALUE_TYPE)) {

					param.setTemplateParameterType(RuleOptionType.VALUE);
					param.setParameterValue(item.getText(2));
				}

				if (item.getText(1).equals(EXPRESSION_TYPE)) {

					param.setTemplateParameterType(RuleOptionType.EXPRESSION);
					NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
					namespaceProperty.setSupportsDynamicXPaths(true);
					namespaceProperty.setPropertyValue(item.getText(2));
					namespaceProperty.setNamespaces(expression.getNamespaces());
					namespaceProperty.setDynamic(expression.isDynamic());
					param.setParameterExpression(namespaceProperty);
				}

				AddCommand addCmd =null;
				if (mediator instanceof CallTemplateMediator) {
					addCmd = new AddCommand(editingDomain, mediator,
							EsbPackage.Literals.CALL_TEMPLATE_MEDIATOR__TEMPLATE_PARAMETERS, param);					
				} else if (mediator instanceof CloudConnectorOperation) {
					addCmd = new AddCommand(editingDomain, mediator,
							EsbPackage.Literals.CLOUD_CONNECTOR_OPERATION__CONNECTOR_PARAMETERS, param);
				}
				getResultCommand().append(addCmd);

			} else {

				if (!param.getParameterName().equals(item.getText(0))) {

					SetCommand setCmd = new SetCommand(
							editingDomain,
							param,
							EsbPackage.Literals.CALL_TEMPLATE_PARAMETER__PARAMETER_NAME,
							item.getText(0));

					getResultCommand().append(setCmd);
				}

				if (item.getText(1).equals(VALUE_TYPE)) {

					SetCommand setCmdValueType = new SetCommand(
							editingDomain,
							param,
							EsbPackage.Literals.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE,
							RuleOptionType.VALUE);
					getResultCommand().append(setCmdValueType);

					if (!param.getParameterValue().equals(item.getText(2))) {

						SetCommand setCmd = new SetCommand(
								editingDomain,
								param,
								EsbPackage.Literals.CALL_TEMPLATE_PARAMETER__PARAMETER_VALUE,
								item.getText(2));
						getResultCommand().append(setCmd);
					}
				}

				if (item.getText(1).equals(EXPRESSION_TYPE)) {

					SetCommand setCmdExpType = new SetCommand(
							editingDomain,
							param,
							EsbPackage.Literals.CALL_TEMPLATE_PARAMETER__TEMPLATE_PARAMETER_TYPE,
							RuleOptionType.EXPRESSION);
					getResultCommand().append(setCmdExpType);

					if (param.getParameterExpression() == null) {

						NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
						namespaceProperty.setSupportsDynamicXPaths(true);
						namespaceProperty.setPropertyValue(item.getText(2));
						namespaceProperty.setNamespaces(expression.getNamespaces());
						namespaceProperty.setDynamic(expression.isDynamic());
						AddCommand addCmd = new AddCommand(
								editingDomain,
								param,
								EsbPackage.Literals.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION,
								namespaceProperty);
						getResultCommand().append(addCmd);

					} else {

						NamespacedProperty namespaceProperty = EsbFactoryImpl.eINSTANCE.createNamespacedProperty();
						namespaceProperty.setSupportsDynamicXPaths(true);
						namespaceProperty.setPropertyValue(item.getText(2));
						namespaceProperty.setNamespaces(expression.getNamespaces());
						namespaceProperty.setDynamic(expression.isDynamic());

						SetCommand setCmd = new SetCommand(
								editingDomain,
								param,
								EsbPackage.Literals.CALL_TEMPLATE_PARAMETER__PARAMETER_EXPRESSION,
								namespaceProperty);
						getResultCommand().append(setCmd);
					}
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
