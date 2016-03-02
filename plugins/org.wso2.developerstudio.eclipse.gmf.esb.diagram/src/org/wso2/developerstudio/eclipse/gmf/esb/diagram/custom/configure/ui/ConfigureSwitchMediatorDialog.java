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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseBranchOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchMediator;

public class ConfigureSwitchMediatorDialog extends Dialog {
	private Text txtXPath;
	private Table tblCases;
	private SwitchMediator mediator;
	private TransactionalEditingDomain editingDomain;
	private CompoundCommand resultCommand;
	private int branchCounter;
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public ConfigureSwitchMediatorDialog(Shell parentShell, SwitchMediator mediator) {
		super(parentShell);
		this.mediator = mediator;
		this.editingDomain = TransactionUtil.getEditingDomain(mediator);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	
	protected Control createDialogArea(final Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(null);
		
		/*txtXPath = new Text(container, SWT.BORDER);
		txtXPath.setBounds(60, 10, 297, 21);
		
		Label lblXPath = new Label(container, SWT.NONE);
		lblXPath.setText("XPath");
		lblXPath.setBounds(10, 13, 76, 15);
		
		Button cmdBrowseXPath = new Button(container, SWT.NONE);
		cmdBrowseXPath.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				
				NamespacedPropertyEditorDialog switchMediatorXpathConfigDialog = 
					new NamespacedPropertyEditorDialog(parent.getShell(),mediator.getSourceXpath());
				switchMediatorXpathConfigDialog.open();
				txtXPath.setText(mediator.getSourceXpath().getPropertyValue());
			}
		});
		cmdBrowseXPath.setText("..");
		cmdBrowseXPath.setBounds(360, 10, 20, 20);*/
		
		Label caseBranchesLabel = new Label(container, SWT.NONE);
		caseBranchesLabel.setText("Case Branches:");
		caseBranchesLabel.setBounds(10, 13, 100, 15);
		
		tblCases = new Table(container, SWT.BORDER | SWT.FULL_SELECTION );
		tblCases.setLinesVisible(true);
		tblCases.setHeaderVisible(true);
		tblCases.setBounds(10, 40, 430, 162);
		
		TableColumn tblclmnCase = new TableColumn(tblCases, SWT.NONE);
		tblclmnCase.setWidth(100);
		tblclmnCase.setText("Case");
		
		TableColumn tblclmnRegexp = new TableColumn(tblCases, SWT.NONE);
		tblclmnRegexp.setWidth(311);
		tblclmnRegexp.setText("RegExp");
		/**
		 * Commented out because of no need to have adding and removing feature 
		 * in the configure dialog.
		 */
     /* Button cmdRemove = new Button(container, SWT.NONE);
		cmdRemove.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblCases.getSelectionIndex();
				if (-1 != selectedIndex) {
					unbindCase(selectedIndex);
					if (selectedIndex < tblCases.getItemCount())
						tblCases.select(selectedIndex);
					 else 
						tblCases.select(selectedIndex - 1);
				}		
			}
		});
		cmdRemove.setText("Remove");
		cmdRemove.setBounds(351, 78, 75, 25);
		
		Button cmdNew = new Button(container, SWT.NONE);
		cmdNew.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				TableItem item = bindCase(EsbFactory.eINSTANCE.createSwitchCaseBranchOutputConnector());
				tblCases.select(tblCases.indexOf(item));
			}
		});
		cmdNew.setText("New");
		cmdNew.setBounds(351, 47, 75, 25);*/
		
		setupTableEditor(tblCases);
		
		for(SwitchCaseBranchOutputConnector s: mediator.getCaseBranches()){
			 branchCounter ++;
			 bindCase(s);
		}
		
		/*NamespacedProperty sourceXPath = mediator.getSourceXpath();
		if(sourceXPath.getPropertyValue()!=null){
			txtXPath.setText(sourceXPath.getPropertyValue());
		}*/
		
		return container;
	}

	private TableItem bindCase(SwitchCaseBranchOutputConnector s) {
		TableItem item = new TableItem(tblCases, SWT.NONE);
		item.setText(new String [] {Integer.toString(branchCounter),s.getCaseRegex()});
		item.setData(s);
		return item;
	}
	
	private void unbindCase(int itemIndex) {
		TableItem item = tblCases.getItem(itemIndex);
		SwitchCaseBranchOutputConnector s = (SwitchCaseBranchOutputConnector) item.getData();
		if (null != s.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain,mediator,EsbPackage.Literals.SWITCH_MEDIATOR__CASE_BRANCHES, s);
			getResultCommand().append(removeCmd);
		}
		tblCases.remove(tblCases.indexOf(item));
	}
	
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	
	protected void okPressed() {
		
		/*if(!mediator.getSourceXpath().getPropertyValue().equals(txtXPath.getText())){
			NamespacedProperty xPath = mediator.getSourceXpath();
			SetCommand setCmd = new SetCommand(editingDomain, xPath,EsbPackage.Literals.NAMESPACED_PROPERTY__PROPERTY_VALUE, txtXPath.getText());
			getResultCommand().append(setCmd);
		}*/
		for (TableItem item : tblCases.getItems()) {
			SwitchCaseBranchOutputConnector s = (SwitchCaseBranchOutputConnector) item.getData();
			if (null == s.eContainer()) {
				s.setCaseRegex(item.getText(0));
				AddCommand addCmd = new AddCommand(editingDomain,mediator,EsbPackage.Literals.SWITCH_MEDIATOR__CASE_BRANCHES, s);
				getResultCommand().append(addCmd);
			}
			else{
				if (!s.getCaseRegex().equals(item.getText())) {
					SetCommand setCmd = new SetCommand(editingDomain, s,EsbPackage.Literals.SWITCH_CASE_BRANCH_OUTPUT_CONNECTOR__CASE_REGEX, item.getText(1));
					getResultCommand().append(setCmd);
				}
			}
		}
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		}
		super.okPressed();
	}
	
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("Switch Mediator Configuration");
	}

	/**
	 * Return the initial size of the dialog.
	 */
	
	protected Point getInitialSize() {
		return new Point(450, 317);
	}
	
	/**
	 * Sets up a table editor that allows users to edit cell values inline.
	 * 
	 * @param table table against which a table editor is setup.
	 */
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
				if (null != oldEditorControl) oldEditorControl.dispose();					
				
				// Mouse location.
				Point mouseLocation = new Point(e.x, e.y);
				
				// Grab the selected row.					
				TableItem item = (TableItem) table.getItem(mouseLocation);
				if (null == item) return;
				
				// Determine which column was selected.					
				int selectedColumn = -1;					
				for (int i = 0, n = table.getColumnCount(); i < n; i++) {
					if (item.getBounds(i).contains(mouseLocation)) {
						selectedColumn = i;
						break;
					}
				}
				
				// Setup a new editor control.
				if (-1 != selectedColumn && 0 != selectedColumn) {
					Text editorControl = new Text(table, SWT.NONE);
					final int editorControlColumn = selectedColumn;
					editorControl.setText(item.getText(selectedColumn));
					editorControl.addModifyListener(new ModifyListener() {							
						public void modifyText(ModifyEvent e) {
							Text text = (Text) cellEditor.getEditor();
							cellEditor.getItem().setText(editorControlColumn, text.getText());
						}
					});
					editorControl.selectAll();
					editorControl.setFocus();
					cellEditor.setEditor(editorControl, item, selectedColumn);
				}										
			}	
			
			/**
			 * Dispose cell editor control at mouse down (otherwise the control keep showing).
			 */
			public void mouseDown(MouseEvent e) {
				Control oldEditorControl = cellEditor.getEditor();
				if (null != oldEditorControl) oldEditorControl.dispose();		
			}
		});
	}		

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}
	
}
