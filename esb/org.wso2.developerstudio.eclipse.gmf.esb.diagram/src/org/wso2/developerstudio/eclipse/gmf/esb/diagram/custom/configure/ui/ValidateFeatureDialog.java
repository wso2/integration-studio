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
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateFeature;
import org.wso2.developerstudio.eclipse.gmf.esb.ValidateMediator;

public class ValidateFeatureDialog extends Dialog {

	private Table featureTable;

	private Button addBtn;

	private Button removeBtn;

	private TableEditor isEnbaledEdior;

	private Combo isEnabledcombo;

	private ValidateMediator validateMediatoer;

	private TransactionalEditingDomain editingDomain;

	private CompoundCommand resultCommand;

	public ValidateFeatureDialog(Shell parentShell,
			ValidateMediator validateMediator) {
		super(parentShell);

		this.validateMediatoer = validateMediator;
		this.editingDomain = TransactionUtil.getEditingDomain(validateMediator);

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
		featureTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);

		TableColumn nameColumn = new TableColumn(featureTable, SWT.LEFT);
		TableColumn valueColumn = new TableColumn(featureTable, SWT.LEFT);

		nameColumn.setText("Name");
		nameColumn.setWidth(150);

		valueColumn.setText("Value");
		valueColumn.setWidth(150);

		featureTable.setHeaderVisible(true);
		featureTable.setLinesVisible(true);

		addBtn = new Button(container, SWT.NONE);
		addBtn.setText("Add...");
		addBtn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {

				TableItem item = bindFeature(EsbFactory.eINSTANCE
						.createValidateFeature());
				featureTable.select(featureTable.indexOf(item));

			}
		});

		removeBtn = new Button(container, SWT.NONE);
		removeBtn.setText("Remove");
		removeBtn.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				int selectedIndex = featureTable.getSelectionIndex();
				if (-1 != selectedIndex) {

					unbindFeature(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < featureTable.getItemCount()) {
						featureTable.select(selectedIndex);
					} else {
						featureTable.select(selectedIndex - 1);
					}
				}

			}
		});

		Listener policyEntryTableListner = new Listener() {

			public void handleEvent(Event evt) {
				if (null != evt.item) {
					if (evt.item instanceof TableItem) {

						TableItem item = (TableItem) evt.item;
						editItem(item);

					}
				}
			}
		};

		featureTable.addListener(SWT.Selection, policyEntryTableListner);

		for (ValidateFeature feature : validateMediatoer.getFeatures()) {

			bindFeature(feature);
		}

		setupTableEditor(featureTable);

		// Layout related configurations
		FormData schemaTableLayoutData = new FormData(SWT.DEFAULT, 150);
		schemaTableLayoutData.top = new FormAttachment(0, 0);
		schemaTableLayoutData.left = new FormAttachment(0, 0);
		featureTable.setLayoutData(schemaTableLayoutData);

		FormData frmData = new FormData();
		frmData.left = new FormAttachment(featureTable, 5);
		frmData.right = new FormAttachment(100, 0);
		addBtn.setLayoutData(frmData);

		frmData = new FormData();
		frmData.top = new FormAttachment(addBtn, 5);
		frmData.left = new FormAttachment(featureTable, 5);
		removeBtn.setLayoutData(frmData);

		return parent;

	}

	private TableItem bindFeature(ValidateFeature feature) {

		TableItem item = new TableItem(featureTable, SWT.NONE);
		item.setText(new String[] { feature.getFeatureName(),
				Boolean.toString(feature.isFeatureEnabled()) });

		item.setData(feature);

		return item;
	}

	private void unbindFeature(int selectedIndex) {

		TableItem item= featureTable.getItem(selectedIndex);
		
		ValidateFeature feature = (ValidateFeature) item.getData();
		
		
		if (null != feature.eContainer()) {

			RemoveCommand reoveCmd = new RemoveCommand(editingDomain,
					validateMediatoer,
					EsbPackage.Literals.VALIDATE_MEDIATOR__FEATURES, feature);
			getResultCommand().append(reoveCmd);

		}

	    
		featureTable.remove(featureTable.indexOf(item));
		
		if (null != isEnbaledEdior) {
			Control lastCtrl = isEnbaledEdior.getEditor();
			if (null != lastCtrl) {
				lastCtrl.dispose();
			}
		}

	}

	private void editItem(final TableItem item) {

		ValidateFeature feature = (ValidateFeature) item.getData();
		isEnbaledEdior = initTableEditor(isEnbaledEdior, item.getParent());

		isEnabledcombo = new Combo(item.getParent(), SWT.READ_ONLY);
		isEnabledcombo.setItems(new String[] { "true", "false" });
		isEnabledcombo.setText(Boolean.toString(feature.isFeatureEnabled()));

		isEnabledcombo.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {

				item.setText(1, isEnabledcombo.getText());

			}
		});

		isEnbaledEdior.setEditor(isEnabledcombo, item, 1);
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

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
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
				if (null != oldEditorControl){
					oldEditorControl.dispose();
				}

				// Mouse location.
				Point mouseLocation = new Point(e.x, e.y);

				// Grab the selected row.
				TableItem item = (TableItem) table.getItem(mouseLocation);
				if (null == item){
					return;
				}

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

	public void okPressed() {

		for (TableItem item : featureTable.getItems()) {

			ValidateFeature feature = (ValidateFeature) item.getData();

			if (feature.eContainer() == null) {

				feature.setFeatureName(item.getText(0));
				if (item.getText(1).equals("true")) {
					feature.setFeatureEnabled(true);
				} else {
					feature.setFeatureEnabled(false);
				}

				AddCommand addCmd = new AddCommand(editingDomain,
						validateMediatoer,
						EsbPackage.Literals.VALIDATE_MEDIATOR__FEATURES,
						feature);
				getResultCommand().append(addCmd);

			} else {

				if (!item.getText(0).equals(feature.getFeatureName())) {
					SetCommand setTypeCmd = new SetCommand(
							editingDomain,
							feature,
							EsbPackage.Literals.ABSTRACT_BOOLEAN_FEATURE__FEATURE_NAME,
							item.getText(0));
					getResultCommand().append(setTypeCmd);
				}

				if (!item.getText(1).equals(
						Boolean.toString(feature.isFeatureEnabled()))) {

					SetCommand setTypeCmd = new SetCommand(
							editingDomain,
							feature,
							EsbPackage.Literals.ABSTRACT_BOOLEAN_FEATURE__FEATURE_ENABLED,
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
		shell.setText("Configure Features.");
	}
}
