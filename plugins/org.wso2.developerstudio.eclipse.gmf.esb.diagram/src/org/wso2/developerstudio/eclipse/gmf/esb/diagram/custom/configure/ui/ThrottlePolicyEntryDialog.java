package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleAccessType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleConditionType;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.ThrottlePolicyEntry;

/**
 * 
 * Dialog that responsible for editing the Throttle Policy Entry.
 *
 */
public class ThrottlePolicyEntryDialog extends Dialog {
	
	private static final String intExpression = "[0-9]*[0-9]+$";  
	/**
	 * Table that holds the Policy Entry details.
	 */
	private Table policyEntryTable; 
	/**
	 * Add button for the policy entry addition.
	 */
	private Button addBtn;
	/**
	 * Remove button for policy entry removal.
	 */
	private Button removeBtn;
	/**
	 * Editor for type combo.
	 */
	private TableEditor typeEditor;
	/**
	 * Editor for Max Request Count
	 */
	private TableEditor mrcEditor;
	/**
	 * Editor for Unit Time (ms)
	 */
	private TableEditor utEditor;
	/**
	 * Prohibit Time Period (ms)
	 */
	private TableEditor ptpEditor;
	/**
	 * Editor for access type combo.
	 */
	private TableEditor accsessTypeEditor;
	/**
	 * Combo box for holding the type of the policy entry.
	 */
	private Combo cmbType;
	/**
	 * Text box for Max Request Count
	 */
	private Text mrcTxt;
	/**
	 * Text box for Unit Time (ms)
	 */
	private Text utTxt;
	/**
	 * Text box for Prohibit Time Period (ms)
	 */
	private Text ptpTxt;
	/**
	 * Combo box for holding the type of the access.
	 */
	private Combo cmbAccessType;
	/**
	 * Throttle Mediator object that we are dealing with at the moment.
	 */
	private ThrottleMediator throttleMediator;
	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;
	/**
	 * Editing domain.
	 */
	private TransactionalEditingDomain editingDomain;
	/**
	 * Pattern Holder
	 */
	private Pattern pattern;
	
	private Label lblMaxConcurentAccess;
	private Text txtMaxConcurrentAccess;
	/**
	 * 
	 * @param parentShell -Shell for the dialog box
	 * @param throttleMediator - Throttle Mediator object that we are dealing with at the moment.
	 */
	public ThrottlePolicyEntryDialog(Shell parentShell,ThrottleMediator throttleMediator) {
		super(parentShell);
		this.throttleMediator = throttleMediator;
		this.editingDomain = TransactionUtil.getEditingDomain(throttleMediator);
		pattern = Pattern.compile(intExpression);  
	}
	
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Throttle Policy Editor");
	}
	
	/**
	 * Create the UI elements. 
	 */
	protected Control createDialogArea(Composite parent) {
		
		Composite container = (Composite) super.createDialogArea(parent);
		container.setSize(SWT.DEFAULT, 1000);

		// Set layout for the main container
		FormLayout mainLayout = new FormLayout();
		mainLayout.marginHeight = 5;
		mainLayout.marginWidth = 5;
		container.setLayout(mainLayout);
		
		lblMaxConcurentAccess = new Label(container, SWT.NONE);
		FormData lblConditionFormData = new FormData();
		lblConditionFormData.top = new FormAttachment(0, 20);
		lblConditionFormData.left = new FormAttachment(0, 10);
		lblMaxConcurentAccess.setLayoutData(lblConditionFormData);
		lblMaxConcurentAccess.setText("Max Concurent Access");
		
		txtMaxConcurrentAccess = new Text(container, SWT.BORDER);
		{
			FormData nsUriTextFieldLayoutData = new FormData();
			nsUriTextFieldLayoutData.top = new FormAttachment(0, 14);
			nsUriTextFieldLayoutData.left = new FormAttachment(0, 175);
			nsUriTextFieldLayoutData.right = new FormAttachment(0, 250);
			txtMaxConcurrentAccess.setLayoutData(nsUriTextFieldLayoutData);
		}
		
		txtMaxConcurrentAccess.setText(Integer.toString(throttleMediator.getMaxConcurrentAccessCount()));
//		txtMaxConcurrentAccess.addModifyListener(new ModifyListener() {
//			public void modifyText(ModifyEvent arg0) {
//				try {
//					maxConcurentAcess = Integer.parseInt(txtMaxConcurrentAccess.getText());
//				} catch (Exception e) {
//					// String message = "Invalid Max Concurent Acess value"
//					maxConcurentAcess = 0;
//				}
//			}
//		});

		// setting up the policy entry table
		policyEntryTable = new Table(container, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);
		// Layout related configurations
		FormData policyEntryTableLayoutData = new FormData(SWT.DEFAULT, 150);
		policyEntryTableLayoutData.top = new FormAttachment(0, 48);
		policyEntryTableLayoutData.left = new FormAttachment(0, 10);
		policyEntryTable.setLayoutData(policyEntryTableLayoutData);

		TableColumn rangeColumn = new TableColumn(policyEntryTable, SWT.LEFT);

		TableColumn typeColumn = new TableColumn(policyEntryTable, SWT.LEFT);

		TableColumn maxReqCountColumn = new TableColumn(policyEntryTable, SWT.LEFT);
		
		TableColumn unitTimeColumn = new TableColumn(policyEntryTable, SWT.LEFT);
		
		TableColumn prohibitTimeColumn = new TableColumn(policyEntryTable, SWT.LEFT);
		
		TableColumn accsessColumn = new TableColumn(policyEntryTable, SWT.LEFT);

		rangeColumn.setText("Range");
		rangeColumn.setWidth(150);

		typeColumn.setText("Type");
		typeColumn.setWidth(150);

		maxReqCountColumn.setText("Max Request Count");
		maxReqCountColumn.setWidth(150);
		
		unitTimeColumn.setText("Unit Time (ms)");
		unitTimeColumn.setWidth(150);
		
		prohibitTimeColumn.setText("Prohibit Time Period (ms)");
		prohibitTimeColumn.setWidth(150);
		
		accsessColumn.setText("Access");
		accsessColumn.setWidth(150);

		policyEntryTable.setHeaderVisible(true);
		policyEntryTable.setLinesVisible(true);
		
		addBtn = new Button(container, SWT.NONE);
		addBtn.setText("Add...");
		addBtn.addListener(SWT.Selection, new Listener() {
			
			
			public void handleEvent(Event event) {
				
				TableItem item = bindPolicyEntry(EsbFactory.eINSTANCE.createThrottlePolicyEntry());
				policyEntryTable.select(policyEntryTable.indexOf(item));
				
			}
		});
		
		removeBtn = new Button(container, SWT.NONE);
		removeBtn.setText("Remove");
		removeBtn.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				int selectedIndex = policyEntryTable.getSelectionIndex();
				if (-1 != selectedIndex) {
					initTableEditor(typeEditor, policyEntryTable);
					initTableEditor(mrcEditor, policyEntryTable);
					initTableEditor(utEditor, policyEntryTable);
					initTableEditor(ptpEditor, policyEntryTable);
					initTableEditor(accsessTypeEditor, policyEntryTable);
					unbindPolicyEntry(selectedIndex);

					// Select the next available candidate for deletion.
					if (selectedIndex < policyEntryTable.getItemCount()) {
						policyEntryTable.select(selectedIndex);
					} else {
						policyEntryTable.select(selectedIndex - 1);
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
		
		policyEntryTable.addListener(SWT.Selection, policyEntryTableListner);
		
		for(ThrottlePolicyEntry policyEntry : throttleMediator.getPolicyEntries()){
			
			bindPolicyEntry(policyEntry);
		}
		
		setupTableEditor(policyEntryTable);
	
		
		FormData frmData = new FormData();
		frmData.top = new FormAttachment(0, 48);
		frmData.left = new FormAttachment(policyEntryTable,5);
		frmData.right = new FormAttachment(100,0);
	    addBtn.setLayoutData(frmData);
	    
	    frmData = new FormData();
	    frmData.top = new FormAttachment(addBtn,5);
	    frmData.left = new FormAttachment(policyEntryTable,5);
	    removeBtn.setLayoutData(frmData);
	    
		return parent;
		
	}
	
	private void editItem(final TableItem item) {
		
		typeEditor = initTableEditor(typeEditor,item.getParent());
		mrcEditor = initTableEditor(mrcEditor, item.getParent());
		utEditor = initTableEditor(utEditor, item.getParent());
		ptpEditor = initTableEditor(ptpEditor, item.getParent());
		accsessTypeEditor = initTableEditor(accsessTypeEditor, item.getParent());
		
		cmbType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbType.setItems(new String [] {"IP","DOMAIN"});
		cmbType.setText(item.getText(1));
		cmbType.addListener(SWT.Selection, new Listener() {
			
			
			public void handleEvent(Event event) {
				
				item.setText(1, cmbType.getText());
			}
		});
		
		mrcTxt = new Text(item.getParent(),SWT.NONE);
		mrcTxt.addModifyListener(new ModifyListener() {
			
			
			public void modifyText(ModifyEvent e) {
				
				item.setText(2,mrcTxt.getText());
				
			}
		});
		
		utTxt = new Text(item.getParent(),SWT.NONE);
		utTxt.addModifyListener(new ModifyListener() {
			
			
			public void modifyText(ModifyEvent e) {
				
				item.setText(3,utTxt.getText());
			}
		});
		
		ptpTxt = new Text(item.getParent(), SWT.NONE);
		ptpTxt.addModifyListener(new ModifyListener() {
			
			
			public void modifyText(ModifyEvent e) {
				
				item.setText(4,ptpTxt.getText());
			}
		});
		
	   cmbAccessType = new Combo(item.getParent(), SWT.READ_ONLY);
	   cmbAccessType.setItems(new String [] {"Allow","Deny","Control"});
	   cmbAccessType.setText(item.getText(5));
	   cmbAccessType.addListener(SWT.Selection, new Listener() {
		
			
			public void handleEvent(Event event) {

				item.setText(5, cmbAccessType.getText());
			}
		});

		typeEditor.setEditor(cmbType, item, 1);
		mrcEditor.setEditor(mrcTxt, item, 2);
		utEditor.setEditor(utTxt, item, 3);
		ptpEditor.setEditor(ptpTxt,item,4);
		accsessTypeEditor.setEditor(cmbAccessType, item, 5);
		
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
	
	private TableItem bindPolicyEntry(ThrottlePolicyEntry policyEntry){
	    
		TableItem item = new TableItem(policyEntryTable, SWT.NONE);
		
		item.setText(new String []{
				policyEntry.getThrottleRange(),
				policyEntry.getThrottleType().getLiteral(),
				Integer.toString(policyEntry.getMaxRequestCount()),
				Integer.toString(policyEntry.getUnitTime()),
				Integer.toString(policyEntry.getProhibitPeriod()),
				policyEntry.getAccessType().getLiteral()});
		
		item.setData(policyEntry);
		
		return item;
	}
	
	private void unbindPolicyEntry(int itemIndex){
		
		TableItem item = policyEntryTable.getItem(itemIndex);
		ThrottlePolicyEntry policyEntry = (ThrottlePolicyEntry)item.getData();
		
		if(policyEntry.eContainer() != null){	
			RemoveCommand rmCommnd = new RemoveCommand(editingDomain, throttleMediator,
					EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_ENTRIES, policyEntry);
			getResultCommand().append(rmCommnd);
		}
		
		policyEntryTable.remove(policyEntryTable.indexOf(item));
		
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
	
	protected void okPressed() {
		
		int maxConcurentAcess = 0;
		try {
			maxConcurentAcess = Integer.parseInt(txtMaxConcurrentAccess.getText());
		} catch (Exception e) {
			// String message = "Invalid Max Concurent Acess value"
			maxConcurentAcess = 0;
		}
		
		SetCommand addCmdMaxConcCount = new SetCommand(editingDomain, throttleMediator,
				EsbPackage.Literals.THROTTLE_MEDIATOR__MAX_CONCURRENT_ACCESS_COUNT, maxConcurentAcess);
		getResultCommand().append(addCmdMaxConcCount);
		
		for(TableItem item : policyEntryTable.getItems()){
			
			ThrottlePolicyEntry policyEntry = (ThrottlePolicyEntry)item.getData();
			
			//if entry is new one
			if(policyEntry.eContainer() == null){
				
				policyEntry.setThrottleRange(item.getText(0));
				
				if(item.getText(1).equals("IP")){
					policyEntry.setThrottleType(ThrottleConditionType.IP);
				}else if(item.getText(1).equals("DOMAIN")){
					policyEntry.setThrottleType(ThrottleConditionType.DOMAIN);
				}
				
				/*
				 * Need to come up with some proper validation notification mechanism
				 * we can add Text box to the cell and use ControlDecoration other than that
				 * jface tables dose not have arbitrary validation.At the moment no notification here.
				 */
				
				if(isInteger(item.getText(2))){
				policyEntry.setMaxRequestCount(Integer.parseInt(item.getText(2)));
				}
				
				if(isInteger(item.getText(3))){
				policyEntry.setUnitTime(Integer.parseInt(item.getText(3)));
				}
				
				if(isInteger(item.getText(4))){
				policyEntry.setProhibitPeriod(Integer.parseInt(item.getText(4)));
				}
				
				if(item.getText(5).equals("Allow")){
					policyEntry.setAccessType(ThrottleAccessType.ALLOW);
				}else if(item.getText(5).equals("Deny")){
					policyEntry.setAccessType(ThrottleAccessType.DENY);
				}else if(item.getText().equals("Control")){
					policyEntry.setAccessType(ThrottleAccessType.CONTROL);
					
					policyEntry.setMaxRequestCount(Integer.parseInt(item.getText(2)));
					
					policyEntry.setUnitTime(Integer.parseInt(item.getText(3)));
					
					policyEntry.setProhibitPeriod(Integer.parseInt(item.getText(4)));
				}
				
				AddCommand addCmd = new AddCommand(editingDomain, throttleMediator,
						EsbPackage.Literals.THROTTLE_MEDIATOR__POLICY_ENTRIES,policyEntry );
				getResultCommand().append(addCmd);
				
			}else{
				
				if(!policyEntry.getThrottleRange().equals(item.getText(0))){
					SetCommand setCmd = new SetCommand(editingDomain,policyEntry,
							EsbPackage.Literals.THROTTLE_POLICY_ENTRY__THROTTLE_RANGE,item.getText(0));
					getResultCommand().append(setCmd);
				}
				
				String throttlePloicyType = policyEntry.getThrottleType().toString();
				if(!throttlePloicyType.equals(item.getText(1))){
					ThrottleConditionType type = null;
					if(item.getText(1).equals("IP")){
						
						type = ThrottleConditionType.IP;
					}else if(item.getText(1).equals("DOMAIN")){
						
						type = ThrottleConditionType.DOMAIN;
					}
					SetCommand setCmd = new SetCommand(editingDomain,policyEntry,
							EsbPackage.Literals.THROTTLE_POLICY_ENTRY__THROTTLE_TYPE,
							type);
					getResultCommand().append(setCmd);
				}
				
				if(isInteger(item.getText(2)) && 
						(policyEntry.getMaxRequestCount() != Integer.parseInt(item.getText(2)))){
					
					SetCommand setCmd = new SetCommand(editingDomain,policyEntry,
							EsbPackage.Literals.THROTTLE_POLICY_ENTRY__MAX_REQUEST_COUNT,Integer.parseInt(item.getText(2)));
					getResultCommand().append(setCmd);
				}
				
				if(isInteger(item.getText(3)) && policyEntry.getUnitTime() != Integer.parseInt(item.getText(3))){
					
					SetCommand setCmd = new SetCommand(editingDomain,policyEntry,
							EsbPackage.Literals.THROTTLE_POLICY_ENTRY__UNIT_TIME,Integer.parseInt(item.getText(3)));
					getResultCommand().append(setCmd);
				}
				
				if(isInteger(item.getText(4)) && policyEntry.getProhibitPeriod() != Integer.parseInt(item.getText(4))){
					
					SetCommand setCmd = new SetCommand(editingDomain,policyEntry,
							EsbPackage.Literals.THROTTLE_POLICY_ENTRY__PROHIBIT_PERIOD,Integer.parseInt(item.getText(4)));
					getResultCommand().append(setCmd);
				}
				
				String accessType = policyEntry.getAccessType().toString();
				if(!accessType.equals(item.getText(5))){
					ThrottleAccessType type = null;
					if(item.getText(5).equals("Allow")){
						
						type = ThrottleAccessType.ALLOW;
					}else if(item.getText(5).equals("Deny")){
						
						type = ThrottleAccessType.DENY;
					}else if(item.getText(5).equals("Control")){
						
						type = ThrottleAccessType.CONTROL;
					}
					SetCommand setCmd = new SetCommand(editingDomain,policyEntry,
							EsbPackage.Literals.THROTTLE_POLICY_ENTRY__ACCESS_TYPE,
							type);
					getResultCommand().append(setCmd);
				}
			}
		}
		
		
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		} 
		

		super.okPressed();
	}
	
	public boolean isInteger(String number){  
        boolean isValid = false;  
          CharSequence inputStr = number;  
          Matcher matcher = pattern.matcher(inputStr);  
          if(matcher.matches()){  
             isValid = true;  
          }  
          return isValid;  
        }  
}
