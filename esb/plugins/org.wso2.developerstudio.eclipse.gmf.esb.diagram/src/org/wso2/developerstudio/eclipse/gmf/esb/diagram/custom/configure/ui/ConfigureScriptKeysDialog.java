package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.wso2.developerstudio.eclipse.esb.core.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFact;
import org.wso2.developerstudio.eclipse.gmf.esb.ScriptMediator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

public class ConfigureScriptKeysDialog extends TitleAreaDialog {
	
 
	/**
	 * logger
	 */
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	/**
	 * Domain model
	 */
	private ScriptMediator scriptMediator;
	
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
	private Table tblKeys;
	private Button cmdKeyAdd;
	private Button cmdKeyRemove;
	private PropertyText txtValue;
	
	/**
	 * table editors
	 */
	private TableEditor valueEditor;
	
	
	public ConfigureScriptKeysDialog(Shell parentShell,ScriptMediator scriptMediator, TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.scriptMediator = scriptMediator;
		this.editingDomain = editingDomain;
	}

	/**
	 * Create contents of the *dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Keys Configuration");
		//setMessage("Facts defines what are the facts that should injected to Rule Engine in order to fire rules.");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		tblKeys = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		tblKeys.setBounds(10, 10, 510, 222);
		tblKeys.setHeaderVisible(true);
		tblKeys.setLinesVisible(true);
		tblKeys.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (null != e.item) {
					if (e.item instanceof TableItem) {
						TableItem item = (TableItem) e.item;
						editItem(item);
						cmdKeyRemove.setEnabled(true);
					}
				} else{
					cmdKeyRemove.setEnabled(false);
					updateSelection();
				}
			}
		});
 
		TableColumn tblclmnValue = new TableColumn(tblKeys, SWT.NONE);
		tblclmnValue.setWidth(192);
		tblclmnValue.setText(" Keys ");
		
		cmdKeyAdd = new Button(container, SWT.NONE);
		cmdKeyAdd.setBounds(527, 10, 86, 29);
		cmdKeyAdd.setText("Add");
		cmdKeyAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RegistryKeyProperty createRegistryKeyProperty = EsbFactory.eINSTANCE.createRegistryKeyProperty();
				createRegistryKeyProperty.setKeyValue("/default/key");
				createRegistryKeyProperty.setKeyName("Registry Key");
				bindKeys(createRegistryKeyProperty);
			}
		});
		
		cmdKeyRemove = new Button(container, SWT.NONE);
		cmdKeyRemove.setBounds(526, 45, 86, 29);
		cmdKeyRemove.setText("Remove");
		cmdKeyRemove.setEnabled(false);
		cmdKeyRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblKeys.getSelectionIndex();
				if (-1 != selectedIndex) {
					unbindKeys(selectedIndex);
					// Select the next available candidate for deletion.
					if (selectedIndex <  tblKeys.getItemCount()) {
						 tblKeys.select(selectedIndex);
					} else {
						 tblKeys.select(selectedIndex - 1);
					}
					updateSelection();
				}
			}
		});

		for (RegistryKeyProperty registryKeyProperty : scriptMediator.getScriptKeys()) {
			     bindKeys(registryKeyProperty);
        	} 
		
		return area;
	}
	
	protected void editItem(final TableItem item) {
		RegistryKeyProperty registryKeyProperty = (RegistryKeyProperty)item.getData();
		valueEditor = initTableEditor(valueEditor,item.getParent());
		txtValue = new PropertyText(item.getParent(), SWT.NONE);
		txtValue.addProperties(registryKeyProperty);
		valueEditor.setEditor(txtValue, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		txtValue.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				item.setText(0,txtValue.getText());
				Object property = txtValue.getProperty();
				if(property instanceof RegistryKeyProperty){
				item.setData((RegistryKeyProperty)property);
				}
			}
		});
	}

	private void updateSelection(){
		initTableEditor(valueEditor,tblKeys);
		if(tblKeys.getSelectionIndex()==-1){
			cmdKeyRemove.setEnabled(false);
		} else{
			cmdKeyRemove.setEnabled(true);
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
		return new Point(631, 400);
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		newShell.setText("ScriptMediator Configuration");
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
	
	
	/**
	 * Utility method for binding a fact into the UI. Note that this
	 * method does not record any commands, it simply adds a new row into the
	 * table and associates the passed {@link RuleFact} to it.
	 * 
	 * @return {@link TableItem} which was introduced.
	 */
	private TableItem bindKeys(RegistryKeyProperty registryKeyProperty ) {
		TableItem item = new TableItem(tblKeys, SWT.NONE);
		item.setText(0, registryKeyProperty.getKeyValue());
		item.setData(registryKeyProperty);
		return item;
	}

	/**
	 * Removes the corresponding table item from the table and records a command
	 * for detaching the corresponding argument from the model.
	 * 
	 * @param itemIndex
	 *            index of the row which is to be removed.
	 */
	private void unbindKeys(int itemIndex) {
		TableItem item = tblKeys.getItem(itemIndex);
		RegistryKeyProperty regProperty = (RegistryKeyProperty) item.getData();
		if (null != regProperty.eContainer()) {
			 RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					scriptMediator,EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_KEYS,regProperty);
			getResultCommand().append(removeCmd); 
		}
		tblKeys.remove(tblKeys.indexOf(item));
	}
	
	@Override
	protected void okPressed() {
		for (TableItem item : tblKeys.getItems()) {
			RegistryKeyProperty property = (RegistryKeyProperty) item.getData();
			AddCommand addCmd = null;
			if (null == property.eContainer()) {
				addCmd = new AddCommand(editingDomain,scriptMediator,
						EsbPackage.Literals.SCRIPT_MEDIATOR__SCRIPT_KEYS,property);
				getResultCommand().append(addCmd);
			}
			SetCommand setCommand = null;	
			if(!property.getKeyValue().equals(item.getText())){
				setCommand = new SetCommand(editingDomain, property,
						EsbPackage.Literals.RULE_FACT__FACT_NAME, item.getText());
				getResultCommand().append(setCommand);
			}
	 	}

 	// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		} else {
			if(getResultCommand().getCommandList().size()>1){
				log.error(" ScriptMediator Keys configuration : cannot save keys", new Exception(
						"Cannot execute command stack "));
			} 
		 } 
		super.okPressed();
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
	

}
