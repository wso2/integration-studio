package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.util.ArrayList;

import org.eclipse.emf.common.command.CompoundCommand;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.CloneTarget;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetEndpointType;
import org.wso2.developerstudio.eclipse.gmf.esb.TargetSequenceType;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.NamedEntityDescriptor;
import org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.provider.RegistryKeyPropertyEditorDialog;

public class ConfigureCloneMediatorDialog extends Dialog {

	private Shell parentShell;
	private Table targetTable;
	private Label seqTypeLable;
	private Label endPtypeLable;
	private Combo seqTypeCombo;
	private Combo endPtypeCombo;
	private Group sequenceGrp;
	private Group endPGrp;
	private Label registryKeyLable;
	private Text seqRegistryKeyText;
	private Button sequenceBrowseBtn;
	private Text endPregistryKeyText;
	private Button endPbrowseBtn;

	private CloneMediator cloneMediator;
	private TransactionalEditingDomain domain;
	private CompoundCommand resultCommand;
	private int targetCounter;
	private TableItem currentSelectedItem;

	public ConfigureCloneMediatorDialog(Shell parent,
			CloneMediator cloneMediator) {
		super(parent);
		this.cloneMediator = cloneMediator;
		this.domain = TransactionUtil.getEditingDomain(cloneMediator);
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		parentShell = newShell;
		// Set title.
		parentShell.setText("Clone Mediator Target Configuration");
	}

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setSize(SWT.DEFAULT, 1000);

		// Set layout for the main container
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);

		// setting up the target table
		targetTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);

		TableColumn targetNumColumn = new TableColumn(targetTable, SWT.LEFT);

		TableColumn soapActionColumn = new TableColumn(targetTable, SWT.LEFT);

		TableColumn toAddressColumn = new TableColumn(targetTable, SWT.LEFT);

		targetNumColumn.setText("Target Number");
		targetNumColumn.setWidth(150);

		soapActionColumn.setText("SOAP Action");
		soapActionColumn.setWidth(150);

		toAddressColumn.setText("To Address");
		toAddressColumn.setWidth(150);

		targetTable.setHeaderVisible(true);
		targetTable.setLinesVisible(true);

		// Creating sequence group widget
		sequenceGrp = new Group(container, SWT.NONE);
		sequenceGrp.setText("Sequence");
		GridLayout gl = new GridLayout(3, false);
		sequenceGrp.setLayout(gl);

		GridData gd = new GridData();
		gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gd.horizontalSpan = 1;

		seqTypeLable = new Label(sequenceGrp, SWT.NONE);
		seqTypeLable.setText("Type");
		seqTypeLable.setLayoutData(gd);

		seqTypeCombo = new Combo(sequenceGrp, SWT.READ_ONLY);
		seqTypeCombo.setItems(new String[] { "None", "Anonymous",
				"Pick From Registry" });
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		seqTypeCombo.setLayoutData(gd);

		registryKeyLable = new Label(sequenceGrp, SWT.NONE);
		registryKeyLable.setText("Pick from registry:");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalSpan = 1;
		gd.widthHint = 130;
		registryKeyLable.setLayoutData(gd);

		seqRegistryKeyText = new Text(sequenceGrp, SWT.SINGLE | SWT.BORDER);
		seqRegistryKeyText.setEnabled(false);

		seqRegistryKeyText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				CloneTarget target = getCurrentTarget();

				if (target != null) {

					if (target.getSequenceKey() == null) {

						RegistryKeyProperty regKeyProp = EsbFactory.eINSTANCE
								.createRegistryKeyProperty();
						regKeyProp.setKeyValue(seqRegistryKeyText.getText());

						SetCommand setCmd = new SetCommand(
								domain,
								target,
								EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY,
								regKeyProp);

						if (setCmd.canExecute()) {

							domain.getCommandStack().execute(setCmd);
						}

					} else if (!target.getSequenceKey().getKeyValue()
							.equals(seqRegistryKeyText.getText())) {

						RegistryKeyProperty registryPropertyKey = EsbFactory.eINSTANCE
								.createRegistryKeyProperty();
						registryPropertyKey.setKeyValue(seqRegistryKeyText
								.getText());

						SetCommand setCmd = new SetCommand(
								domain,
								target,
								EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_KEY,
								registryPropertyKey);

						if (setCmd.canExecute()) {

							domain.getCommandStack().execute(setCmd);
						}

					}

				}
			}
		});

		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalSpan = 1;
		gd.widthHint = 240;
		seqRegistryKeyText.setLayoutData(gd);

		sequenceBrowseBtn = new Button(sequenceGrp, SWT.PUSH);
		sequenceBrowseBtn.setText("Browse...");
		sequenceBrowseBtn.setEnabled(false);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalSpan = 1;
		gd.widthHint = 70;
		sequenceBrowseBtn.setLayoutData(gd);

		sequenceBrowseBtn.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				RegistryKeyProperty registryPropertyKey = EsbFactory.eINSTANCE
						.createRegistryKeyProperty();

				RegistryKeyPropertyEditorDialog rkpe = new RegistryKeyPropertyEditorDialog(
						parentShell, SWT.NULL, registryPropertyKey,
						new ArrayList<NamedEntityDescriptor>());
				rkpe.open();

				seqRegistryKeyText.setText(registryPropertyKey.getKeyValue());

			}
		});

		seqTypeCombo.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {

				CloneTarget target = getCurrentTarget();

				if (seqTypeCombo.getSelectionIndex() == 2) {

					SetCommand setTypeCmd = new SetCommand(
							domain,
							target,
							EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE,
							TargetSequenceType.REGISTRY_REFERENCE);

					if (setTypeCmd.canExecute()) {

						domain.getCommandStack().execute(setTypeCmd);
					}

					seqRegistryKeyText.setEnabled(true);
					sequenceBrowseBtn.setEnabled(true);

				} else if (seqTypeCombo.getSelectionIndex() == 0) {

					SetCommand setTypeCmd = new SetCommand(
							domain,
							target,
							EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE,
							TargetSequenceType.NONE);

					if (setTypeCmd.canExecute()) {

						domain.getCommandStack().execute(setTypeCmd);
					}

					seqRegistryKeyText.setEnabled(false);
					seqRegistryKeyText.setText("");
					sequenceBrowseBtn.setEnabled(false);

				} else if (seqTypeCombo.getSelectionIndex() == 1) {

					SetCommand setTypeCmd = new SetCommand(
							domain,
							target,
							EsbPackage.Literals.ABSTRACT_COMMON_TARGET__SEQUENCE_TYPE,
							TargetSequenceType.ANONYMOUS);

					if (setTypeCmd.canExecute()) {

						domain.getCommandStack().execute(setTypeCmd);
					}

					seqRegistryKeyText.setEnabled(false);
					seqRegistryKeyText.setText("");
					sequenceBrowseBtn.setEnabled(false);
				}
			}
		});

		// setting up the layout data for the table
		FormData targetTableLayoutData = new FormData(SWT.DEFAULT, 150);
		targetTableLayoutData.top = new FormAttachment(0, 0);
		targetTableLayoutData.left = new FormAttachment(0, 0);
		targetTableLayoutData.bottom = new FormAttachment(sequenceGrp, -5);
		targetTable.setLayoutData(targetTableLayoutData);

		FormData data = new FormData();
		data.top = new FormAttachment(targetTable, -5);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		sequenceGrp.setLayoutData(data);

		endPGrp = new Group(container, SWT.NONE);
		endPGrp.setText("Endpoint");

		data = new FormData();
		data.top = new FormAttachment(sequenceGrp, 5);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(100, 0);
		endPGrp.setLayoutData(data);

		endPGrp.setLayout(gl);

		endPtypeLable = new Label(endPGrp, SWT.NONE);
		endPtypeLable.setText("Type");
		gd = new GridData();
		gd.horizontalAlignment = GridData.HORIZONTAL_ALIGN_BEGINNING;
		gd.horizontalSpan = 1;
		endPtypeLable.setLayoutData(gd);

		endPtypeCombo = new Combo(endPGrp, SWT.READ_ONLY);
		endPtypeCombo.setItems(new String[] { "None", "Anonymous",
				"Pick From Registry" });
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		endPtypeCombo.setLayoutData(gd);

		registryKeyLable = new Label(endPGrp, SWT.NONE);
		registryKeyLable.setText("Pick from registry:");
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalSpan = 1;
		gd.widthHint = 130;
		registryKeyLable.setLayoutData(gd);

		endPregistryKeyText = new Text(endPGrp, SWT.SINGLE | SWT.BORDER);
		endPregistryKeyText.setEnabled(false);

		endPregistryKeyText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {

				CloneTarget target = getCurrentTarget();

				if (target != null) {

					if (target.getEndpointKey() == null) {

						RegistryKeyProperty regKeyProp = EsbFactory.eINSTANCE
								.createRegistryKeyProperty();
						regKeyProp.setKeyValue(endPregistryKeyText.getText());

						SetCommand setCmd = new SetCommand(
								domain,
								target,
								EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY,
								regKeyProp);

						if (setCmd.canExecute()) {

							domain.getCommandStack().execute(setCmd);
						}

					}
					// Set the modified endpoint key
					else if (!target.getEndpointKey().getKeyValue()
							.equals(endPregistryKeyText.getText())) {

						RegistryKeyProperty regKeyProp = EsbFactory.eINSTANCE
								.createRegistryKeyProperty();
						regKeyProp.setKeyValue(endPregistryKeyText.getText());

						SetCommand setCmd = new SetCommand(
								domain,
								target,
								EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT_KEY,
								regKeyProp);

						if (setCmd.canExecute()) {

							domain.getCommandStack().execute(setCmd);
						}
					}
				}

			}
		});

		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalSpan = 1;
		gd.widthHint = 240;
		endPregistryKeyText.setLayoutData(gd);

		endPbrowseBtn = new Button(endPGrp, SWT.PUSH);
		endPbrowseBtn.setText("Browse...");
		endPbrowseBtn.setEnabled(false);
		gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.horizontalSpan = 1;
		gd.widthHint = 70;
		endPbrowseBtn.setLayoutData(gd);

		endPbrowseBtn.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {

				RegistryKeyProperty registryPropertyKey = EsbFactory.eINSTANCE
						.createRegistryKeyProperty();

				RegistryKeyPropertyEditorDialog rkpe = new RegistryKeyPropertyEditorDialog(
						parentShell, SWT.NULL, registryPropertyKey,
						new ArrayList<NamedEntityDescriptor>());
				rkpe.open();

				endPregistryKeyText.setText(registryPropertyKey.getKeyValue());

			}

		});

		endPtypeCombo.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {

				CloneTarget target = getCurrentTarget();

				if (endPtypeCombo.getSelectionIndex() == 2) {

					SetCommand setTypeCmd = new SetCommand(
							domain,
							target,
							EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE,
							TargetEndpointType.REGISTRY_REFERENCE);

					if (setTypeCmd.canExecute()) {

						domain.getCommandStack().execute(setTypeCmd);
					}

					endPregistryKeyText.setEnabled(true);
					endPbrowseBtn.setEnabled(true);

				} else if (endPtypeCombo.getSelectionIndex() == 0) {

					SetCommand setTypeCmd = new SetCommand(
							domain,
							target,
							EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE,
							TargetEndpointType.NONE);

					if (setTypeCmd.canExecute()) {

						domain.getCommandStack().execute(setTypeCmd);
					}

					endPregistryKeyText.setEnabled(false);
					endPregistryKeyText.setText("");
					endPbrowseBtn.setEnabled(false);

				} else if (endPtypeCombo.getSelectionIndex() == 1) {

					SetCommand setTypeCmd = new SetCommand(
							domain,
							target,
							EsbPackage.Literals.ABSTRACT_COMMON_TARGET__ENDPOINT_TYPE,
							TargetEndpointType.ANONYMOUS);

					if (setTypeCmd.canExecute()) {

						domain.getCommandStack().execute(setTypeCmd);
					}

					endPregistryKeyText.setEnabled(false);
					endPregistryKeyText.setText("");
					endPbrowseBtn.setEnabled(false);
				}
			}

		});

		Listener targetTableListner = new Listener() {

			public void handleEvent(Event evt) {
				if (null != evt.item) {
					if (evt.item instanceof TableItem) {
						TableItem item = (TableItem) evt.item;
						//Set the Current selection to class level
						setCurrentSelectedItem(item);
						
						handleItemSelectionEvent(item);

					}
				}
			}
		};

		// adding selection listener to target table.
		targetTable.addListener(SWT.Selection, targetTableListner);

		for (CloneTarget target : cloneMediator.getTargets()) {
			targetCounter++;
			bindCloneTarget(target);

		}

		targetTable.select(0);
		TableItem item = targetTable.getItem(targetTable.getSelectionIndex());
		setCurrentSelectedItem(item);

		initFields();

		setupTableEditor(targetTable);

		return parent;
	}

	private void initFields() {

		if (cloneMediator.getTargets() != null
				&& cloneMediator.getTargets().get(0) != null) {

			CloneTarget firstTarget = cloneMediator.getTargets().get(0);

			if (firstTarget.getSequenceType().equals(TargetSequenceType.NONE)) {

				seqTypeCombo.select(0);
			} else if (firstTarget.getSequenceType().equals(
					TargetSequenceType.ANONYMOUS)) {

				seqTypeCombo.select(1);
			} else if (firstTarget.getSequenceType().equals(
					TargetSequenceType.REGISTRY_REFERENCE)) {

				seqTypeCombo.select(2);
				if (firstTarget.getSequenceKey() != null) {
					seqRegistryKeyText.setText(firstTarget.getSequenceKey()
							.getKeyValue());
					seqRegistryKeyText.setEnabled(true);
					sequenceBrowseBtn.setEnabled(true);
				}
			}

			if (firstTarget.getEndpointType().equals(TargetEndpointType.NONE)) {

				endPtypeCombo.select(0);

			} else if (firstTarget.getEndpointType().equals(
					TargetEndpointType.ANONYMOUS)) {

				endPtypeCombo.select(1);

			} else if (firstTarget.getEndpointType().equals(
					TargetEndpointType.REGISTRY_REFERENCE)) {

				endPtypeCombo.select(2);
				if (firstTarget.getEndpointKey() != null) {
					endPregistryKeyText.setText(firstTarget.getEndpointKey()
							.getKeyValue());
					endPregistryKeyText.setEnabled(true);
					endPbrowseBtn.setEnabled(true);
				}
			}
		}
	}

	private void handleItemSelectionEvent(final TableItem item) {

		CloneTarget target = getCurrentTarget();

		if (target.getSequenceKey() != null
				&& target.getSequenceType().equals(
						TargetSequenceType.REGISTRY_REFERENCE)) {

			seqTypeCombo.select(2);
			seqRegistryKeyText.setText(target.getSequenceKey().getKeyValue());

			seqRegistryKeyText.setEnabled(true);
			sequenceBrowseBtn.setEnabled(true);

		} else if (target.getSequenceType().equals(TargetSequenceType.NONE)) {

			seqTypeCombo.select(0);
			seqRegistryKeyText.setText("");
			seqRegistryKeyText.setEnabled(false);
			sequenceBrowseBtn.setEnabled(false);

		} else if (target.getSequenceType()
				.equals(TargetSequenceType.ANONYMOUS)) {

			seqTypeCombo.select(1);
			seqRegistryKeyText.setText("");
			seqRegistryKeyText.setEnabled(false);
			sequenceBrowseBtn.setEnabled(false);
		}

		if (target.getEndpointKey() != null
				&& target.getEndpointType().equals(
						TargetEndpointType.REGISTRY_REFERENCE)) {

			endPtypeCombo.select(2);
			endPregistryKeyText.setText(target.getEndpointKey().getKeyValue());

			endPregistryKeyText.setEnabled(true);
			endPbrowseBtn.setEnabled(true);

		} else if (target.getEndpointType().equals(TargetEndpointType.NONE)) {

			endPtypeCombo.select(0);
			endPregistryKeyText.setText("");
			endPregistryKeyText.setEnabled(false);
			endPbrowseBtn.setEnabled(false);

		} else if (target.getEndpointType()
				.equals(TargetEndpointType.ANONYMOUS)) {

			endPtypeCombo.select(1);
			endPregistryKeyText.setText("");
			endPregistryKeyText.setEnabled(false);
			endPbrowseBtn.setEnabled(false);
		}

	}

	private TableItem bindCloneTarget(CloneTarget target) {

		TableItem item = new TableItem(targetTable, SWT.NONE);

		item.setText(new String[] { Integer.toString(targetCounter),
				target.getSoapAction(), target.getToAddress() });

		item.setData(target);

		// handleItemSelectionEvent(item);

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
				if (-1 != selectedColumn && selectedColumn != 0) {
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

	protected void okPressed() {

		for (TableItem item : targetTable.getItems()) {

			CloneTarget target = (CloneTarget) item.getData();

			// Set the modified soapaction.
			if (!target.getSoapAction().equals(item.getText(1))) {

				SetCommand setCmd = new SetCommand(domain, target,
						EsbPackage.Literals.CLONE_TARGET__SOAP_ACTION,
						item.getText(1));
				getResultCommand().append(setCmd);
			}

			// Set the modified toaddress.
			if (!target.getToAddress().equals(item.getText(2))) {

				SetCommand setCmd = new SetCommand(domain, target,
						EsbPackage.Literals.CLONE_TARGET__TO_ADDRESS,
						item.getText(2));
				getResultCommand().append(setCmd);
			}

		}

		// Apply changes.
		if (getResultCommand().canExecute()) {
			domain.getCommandStack().execute(getResultCommand());
		}

		super.okPressed();
	}

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}

	private CloneTarget getCurrentTarget() {

		TableItem curentItem = getCurrentSelectedItem();

		if (curentItem != null) {

			CloneTarget target = (CloneTarget) curentItem.getData();
			return target;
		}

		return null;
	}

	public TableItem getCurrentSelectedItem() {
		return currentSelectedItem;
	}

	public void setCurrentSelectedItem(TableItem currentSelectedItem) {
		this.currentSelectedItem = currentSelectedItem;
	}

}
