package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
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
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleSetCreationProperty;

public class ConfigureRuleMediatorSetPropertyDialog extends Dialog {

	private Table ruleSetPropTable;

	private Button addBtn;

	private Button removeBtn;

	private RuleMediator ruleMediator;

	private TransactionalEditingDomain editingDomain;

	private CompoundCommand resultCommand;

	public ConfigureRuleMediatorSetPropertyDialog(Shell parentShell,
			RuleMediator ruleMediator) {
		super(parentShell);
		this.ruleMediator = ruleMediator;
		this.editingDomain = TransactionUtil
				.getEditingDomain(this.ruleMediator);
	}

	protected Control createDialogArea(Composite parent) {

		Composite container = (Composite) super.createDialogArea(parent);
		container.setSize(SWT.DEFAULT, 1000);

		// Set layout for the main container
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		// setting up the feature table
		ruleSetPropTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);

		TableColumn keyTypeColumn = new TableColumn(ruleSetPropTable, SWT.LEFT);
		TableColumn staticKey = new TableColumn(ruleSetPropTable, SWT.LEFT);

		keyTypeColumn.setText("Name");
		keyTypeColumn.setWidth(150);

		staticKey.setText("Value");
		staticKey.setWidth(150);

		ruleSetPropTable.setHeaderVisible(true);
		ruleSetPropTable.setLinesVisible(true);

		addBtn = new Button(container, SWT.NONE);
		addBtn.setText("Add...");
		addBtn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {

				TableItem item = bindRuleSetProperty(EsbFactory.eINSTANCE
						.createRuleSetCreationProperty());
				ruleSetPropTable.select(ruleSetPropTable.indexOf(item));

			}
		});

		removeBtn = new Button(container, SWT.NONE);
		removeBtn.setText("Remove");
		removeBtn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				int selectedIndex = ruleSetPropTable.getSelectionIndex();
				if (-1 != selectedIndex) {

					unbindRuleSetProperty(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < ruleSetPropTable.getItemCount()) {
						ruleSetPropTable.select(selectedIndex);
					} else {
						ruleSetPropTable.select(selectedIndex - 1);
					}
				}

			}
		});

		/*for (RuleSetCreationProperty ruleSetProp : ruleMediator
				.getRuleSetProperties()) {

			bindRuleSetProperty(ruleSetProp);
		}*/

		setupTableEditor(ruleSetPropTable);

		// Layout related configurations
		FormData schemaTableLayoutData = new FormData(SWT.DEFAULT, 150);
		schemaTableLayoutData.top = new FormAttachment(0, 0);
		schemaTableLayoutData.left = new FormAttachment(0, 0);
		ruleSetPropTable.setLayoutData(schemaTableLayoutData);

		FormData frmData = new FormData();
		frmData.left = new FormAttachment(ruleSetPropTable, 5);
		frmData.right = new FormAttachment(100, 0);
		addBtn.setLayoutData(frmData);

		frmData = new FormData();
		frmData.top = new FormAttachment(addBtn, 5);
		frmData.left = new FormAttachment(ruleSetPropTable, 5);
		removeBtn.setLayoutData(frmData);

		return parent;

	}

	private TableItem bindRuleSetProperty(
			RuleSetCreationProperty ruleSetProperty) {

		TableItem item = new TableItem(ruleSetPropTable, SWT.NONE);
		item.setText(new String[] { ruleSetProperty.getPropertyName(),
				ruleSetProperty.getPropertyValue() });
		item.setData(ruleSetProperty);

		return item;

	}

	private void unbindRuleSetProperty(int selectedIndex) {

		TableItem item = ruleSetPropTable.getItem(selectedIndex);

		RuleSetCreationProperty setProp = (RuleSetCreationProperty) item
				.getData();

		/*if (null != setProp.eContainer()) {

			RemoveCommand reoveCmd = new RemoveCommand(editingDomain,
					ruleMediator,
					EsbPackage.Literals.RULE_MEDIATOR__RULE_SET_PROPERTIES,
					setProp);
			getResultCommand().append(reoveCmd);
		}

		ruleSetPropTable.remove(ruleSetPropTable.indexOf(item));*/

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

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}

	public void okPressed() {

		for (TableItem item : ruleSetPropTable.getItems()) {

			RuleSetCreationProperty setProp = (RuleSetCreationProperty) item
					.getData();

			if (setProp.eContainer() == null) {

				/*setProp.setPropertyName(item.getText(0));
				setProp.setPropertyValue(item.getText(1));

				AddCommand addCmd = new AddCommand(editingDomain, ruleMediator,
						EsbPackage.Literals.RULE_MEDIATOR__RULE_SET_PROPERTIES,
						setProp);
				getResultCommand().append(addCmd);*/
			} else {

				if (!item.getText(0).equals(setProp.getPropertyName())) {
					SetCommand setTypeCmd = new SetCommand(
							editingDomain,
							setProp,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_NAME,
							item.getText(0));
					getResultCommand().append(setTypeCmd);
				}

				if (!item.getText(1).equals(setProp.getPropertyValue())) {

					SetCommand setTypeCmd = new SetCommand(
							editingDomain,
							setProp,
							EsbPackage.Literals.ABSTRACT_NAME_VALUE_PROPERTY__PROPERTY_VALUE,
							item.getText(1));
					getResultCommand().append(setTypeCmd);
				}
			}
		}

		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		}

		super.okPressed();
	}

	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Rule Set Property Dialog");
	}

}
