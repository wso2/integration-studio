/*
 * Copyright 2012 WSO2, Inc. (http://wso2.com)
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


import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.esb.core.Activator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFact;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFactValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * RuleMediator facts configuration *dialog
 *
 */
public class ConfigureRuleMediatorFactsDialog extends TitleAreaDialog {
	
	/**
	 * logger
	 */
	private static IDeveloperStudioLog log = Logger.getLog(Activator.PLUGIN_ID);
	
	/**
	 * Domain model
	 */
	private RuleMediator ruleMediator;
	
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
	private Table tblFacts;
	private Button cmdFactAdd;
	private Button cmdFactRemove;
	private Combo cmbType;
	private Text txtName;
	private Combo cmbSourceType;
	private PropertyText txtValue;
	
	/**
	 * table editors
	 */
	private TableEditor typeEditor;
	private TableEditor nameEditor;
	private TableEditor sourceTypeEditor;
	private TableEditor valueEditor;
	
	private final static String LITERAL_VALUE = "Literal";
	private final static String LITERAL_EXPRESSION = "Expression";
	private final static String LITERAL_KEY = "Key";
	
	private List<String> factTypes = new ArrayList<String>();

	
	public ConfigureRuleMediatorFactsDialog(Shell parentShell,RuleMediator ruleMediator, TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.ruleMediator = ruleMediator;
		this.editingDomain = editingDomain;
	}

	/**
	 * Create contents of the *dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setTitle("Facts Configuration");
		setMessage("Facts defines what are the facts that should injected to Rule Engine in order to fire rules.");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		tblFacts = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		tblFacts.setBounds(10, 10, 510, 222);
		tblFacts.setHeaderVisible(true);
		tblFacts.setLinesVisible(true);
		tblFacts.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (null != e.item) {
					if (e.item instanceof TableItem) {
						TableItem item = (TableItem) e.item;
						editItem(item);
						cmdFactRemove.setEnabled(true);
					}
				} else{
					cmdFactRemove.setEnabled(false);
					updateSelection();
				}
			}
		});
		
		TableColumn tblclmnType = new TableColumn(tblFacts, SWT.NONE);
		tblclmnType.setWidth(150);
		tblclmnType.setText("Type");
		
		TableColumn tblclmnName = new TableColumn(tblFacts, SWT.NONE);
		tblclmnName.setWidth(150);
		tblclmnName.setText("Name");
		
		/*TableColumn tblclmnSourceType = new TableColumn(tblFacts, SWT.NONE);
		tblclmnSourceType.setWidth(100);
		tblclmnSourceType.setText("Source Type");*/
		
		TableColumn tblclmnValue = new TableColumn(tblFacts, SWT.NONE);
		tblclmnValue.setWidth(180);
		tblclmnValue.setText("Namespace/xpath");
		
		cmdFactAdd = new Button(container, SWT.NONE);
		cmdFactAdd.setBounds(527, 10, 86, 29);
		cmdFactAdd.setText("Add");
		cmdFactAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RuleFact fact = EsbFactory.eINSTANCE.createRuleFact();
				FactWrapper wrapper = new FactWrapper(fact);
				wrapper.setFactName(fact.getFactName());
				wrapper.setFactCustomType(fact.getFactCustomType());
				wrapper.setFactType(fact.getFactType());
				wrapper.setValueType(fact.getValueType());
				wrapper.setValueLiteral(fact.getValueLiteral());
				wrapper.setValueExpression(EsbFactory.eINSTANCE.copyNamespacedProperty(fact.getValueExpression()));
				wrapper.setValueKey(EsbFactory.eINSTANCE.copyRegistryKeyProperty(fact.getValueKey()));
				bindFact(wrapper);
			}
		});
		
		cmdFactRemove = new Button(container, SWT.NONE);
		cmdFactRemove.setBounds(526, 45, 86, 29);
		cmdFactRemove.setText("Remove");
		cmdFactRemove.setEnabled(false);
		cmdFactRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblFacts.getSelectionIndex();
				if (-1 != selectedIndex) {
					unbindFact(selectedIndex);
					// Select the next available candidate for deletion.
					if (selectedIndex <  tblFacts.getItemCount()) {
						 tblFacts.select(selectedIndex);
					} else {
						 tblFacts.select(selectedIndex - 1);
					}
					updateSelection();
				}
			}
		});
		
		for(RuleFactType ruleFactType : RuleFactType.VALUES){
			if(ruleFactType!=RuleFactType.CUSTOM){
				factTypes.add(ruleFactType.getLiteral());
			}
		}
		
		for(RuleFact fact : ruleMediator.getFactsConfiguration().getFacts()){
			FactWrapper wrapper = new FactWrapper(fact);
			wrapper.setFactName(fact.getFactName());
			wrapper.setFactCustomType(fact.getFactCustomType());
			wrapper.setFactType(fact.getFactType());
			wrapper.setValueType(fact.getValueType());
			wrapper.setValueLiteral(fact.getValueLiteral());
			wrapper.setValueExpression(EsbFactory.eINSTANCE.copyNamespacedProperty(fact.getValueExpression()));
			wrapper.setValueKey(EsbFactory.eINSTANCE.copyRegistryKeyProperty(fact.getValueKey()));
			bindFact(wrapper);
		}

		return area;
	}
	
	protected void editItem(final TableItem item) {
		
		final FactWrapper wrapper = (FactWrapper) item.getData();
		
		typeEditor = initTableEditor(typeEditor,
				item.getParent());
		cmbType = new Combo(item.getParent(),SWT.NONE);
		cmbType.setItems(factTypes.toArray(new String[]{}));
		cmbType.setText(item.getText(0));
		typeEditor.setEditor(cmbType, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		
		Listener cmbTypeListener = new Listener() {
			public void handleEvent(Event evt) {
				String text = cmbType.getText();
				item.setText(0, text);
				if(RuleFactType.DOM.getLiteral().equals(text)){
					wrapper.setFactType(RuleFactType.DOM);
				} else if(RuleFactType.MESSAGE.getLiteral().equals(text)){
					wrapper.setFactType(RuleFactType.MESSAGE);
				} else if(RuleFactType.CONTEXT.getLiteral().equals(text)){
					wrapper.setFactType(RuleFactType.CONTEXT);
				} else if(RuleFactType.OMELEMENT.getLiteral().equals(text)){
					wrapper.setFactType(RuleFactType.OMELEMENT);
				} else if(RuleFactType.MEDIATOR.getLiteral().equals(text)){
					wrapper.setFactType(RuleFactType.MEDIATOR);
				} else{
					wrapper.setFactType(RuleFactType.CUSTOM);
					wrapper.setFactCustomType(text);
				}
				
			}
		};
		
		cmbType.addListener(SWT.Selection, cmbTypeListener);
		cmbType.addListener(SWT.Modify, cmbTypeListener);
		
		nameEditor = initTableEditor(nameEditor,
				item.getParent());
		txtName = new Text(item.getParent(),SWT.NONE);
		txtName.setText(item.getText(1));
		nameEditor.setEditor(txtName, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		txtName.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(1, txtName.getText());
				wrapper.setFactName(txtName.getText());
			}
		});
		cmbSourceType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbSourceType.setItems(new String[] { LITERAL_VALUE, LITERAL_EXPRESSION,LITERAL_KEY });
		cmbSourceType.select(1);
		valueEditor = initTableEditor(valueEditor,item.getParent());
		
		txtValue = new PropertyText(item.getParent(), SWT.NONE, cmbSourceType);
		txtValue.addProperties(wrapper.getValueLiteral(),wrapper.getValueExpression(),wrapper.getValueKey());
		valueEditor.setEditor(txtValue, item, 2);
		item.getParent().redraw();
		item.getParent().layout();
		txtValue.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(2,txtValue.getText());
				Object property = txtValue.getProperty();
				if(property instanceof RegistryKeyProperty){
					wrapper.setValueKey((RegistryKeyProperty)property);
				} else if(property instanceof NamespacedProperty){
					wrapper.setValueExpression((NamespacedProperty)property);
				} else{
					wrapper.setValueLiteral(property.toString());
				}
			}
		});
	}

	private void updateSelection(){
		initTableEditor(typeEditor,tblFacts);
		initTableEditor(nameEditor,tblFacts);
		initTableEditor(sourceTypeEditor,tblFacts);
		initTableEditor(valueEditor,tblFacts);
		if(tblFacts.getSelectionIndex()==-1){
			cmdFactRemove.setEnabled(false);
		} else{
			cmdFactRemove.setEnabled(true);
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

		newShell.setText("RuleMediator Configuration");
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
	private TableItem bindFact(FactWrapper wrapper) {
		TableItem item = new TableItem(tblFacts, SWT.NONE);
		if(wrapper.getFactType()==RuleFactType.CUSTOM){
			item.setText(0, wrapper.getFactCustomType());
		} else{
			item.setText(0, wrapper.getFactType().getLiteral());
		}
		item.setText(1, wrapper.getFactName());
		item.setText(2,LITERAL_EXPRESSION);
		item.setText(3,wrapper.getValueExpression().getPropertyValue());
		/*if(wrapper.getValueType()==RuleFactValueType.EXPRESSION){
			item.setText(2,LITERAL_EXPRESSION);
			item.setText(3,wrapper.getValueExpression().getPropertyValue());
		} else if(wrapper.getValueType()==RuleFactValueType.REGISTRY_REFERENCE){
			item.setText(2,LITERAL_KEY);
			item.setText(3,wrapper.getValueKey().getKeyValue());
		} else{
			item.setText(2,LITERAL_VALUE);
			item.setText(3,wrapper.getValueLiteral());
		}*/
		
		item.setData(wrapper);
		return item;
	}

	/**
	 * Removes the corresponding table item from the table and records a command
	 * for detaching the corresponding argument from the model.
	 * 
	 * @param itemIndex
	 *            index of the row which is to be removed.
	 */
	private void unbindFact(int itemIndex) {
		TableItem item = tblFacts.getItem(itemIndex);
		FactWrapper wrapper = (FactWrapper) item.getData();
		RuleFact fact = wrapper.getFact();
		
		if (null != fact.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					ruleMediator.getFactsConfiguration(), EsbPackage.Literals.RULE_FACTS_CONFIGURATION__FACTS,
					fact);
			getResultCommand().append(removeCmd);
		}
		tblFacts.remove(tblFacts.indexOf(item));
	}
	
	@Override
	protected void okPressed() {
		for (TableItem item : tblFacts.getItems()) {
			FactWrapper wrapper = (FactWrapper) item.getData();
			RuleFact fact = wrapper.getFact();
			AddCommand addCmd = null;

			if (null == fact.eContainer()) {
				addCmd = new AddCommand(editingDomain, ruleMediator.getFactsConfiguration(),
						EsbPackage.Literals.RULE_FACTS_CONFIGURATION__FACTS, fact);
				getResultCommand().append(addCmd);
			}

			SetCommand setCommand = null;
			
			if(!fact.getFactName().equals(wrapper.getFactName())){
				setCommand = new SetCommand(editingDomain, fact,
						EsbPackage.Literals.RULE_FACT__FACT_NAME, wrapper.getFactName());
				getResultCommand().append(setCommand);
			}
			
			if (!(fact.getFactType().equals(wrapper.getFactType()) && fact.getFactCustomType()
					.equals(wrapper.getFactCustomType()))) {
				String customFactType = "custom_type";
				RuleFactType factType = RuleFactType.CUSTOM;
				if (wrapper.getFactType() == RuleFactType.CUSTOM) {
					customFactType = wrapper.getFactCustomType();
				} else {
					factType = wrapper.getFactType();
				}

				setCommand = new SetCommand(editingDomain, fact,
						EsbPackage.Literals.RULE_FACT__FACT_CUSTOM_TYPE, customFactType);
				getResultCommand().append(setCommand);

				setCommand = new SetCommand(editingDomain, fact,
						EsbPackage.Literals.RULE_FACT__FACT_TYPE, factType);
				getResultCommand().append(setCommand);
			}
			
			if(!fact.getValueType().equals(wrapper.getValueType())){
				if(wrapper.getValueType()==RuleFactValueType.REGISTRY_REFERENCE){
					wrapper.setValueLiteral("default");
					wrapper.getValueExpression().setPropertyValue("/default/expression");
				} else if(wrapper.getValueType()==RuleFactValueType.EXPRESSION){
					wrapper.getValueKey().setKeyValue("/default/key");
					wrapper.setValueLiteral("default");
				} else{
					wrapper.getValueExpression().setPropertyValue("/default/expression");
					wrapper.setValueLiteral("default");
				}
				
				setCommand = new SetCommand(editingDomain, fact,
						EsbPackage.Literals.RULE_FACT__VALUE_TYPE, wrapper.getValueType());
				getResultCommand().append(setCommand);
			}
			
			if(!fact.getValueLiteral().equals( wrapper.getValueLiteral())){
				setCommand = new SetCommand(editingDomain, fact,
						EsbPackage.Literals.RULE_FACT__VALUE_LITERAL, wrapper.getValueLiteral());
				getResultCommand().append(setCommand);
			}
			
			if(!fact.getValueExpression().equals(wrapper.getValueExpression())){
				setCommand = new SetCommand(editingDomain, fact,
						EsbPackage.Literals.RULE_FACT__VALUE_EXPRESSION, wrapper.getValueExpression());
				getResultCommand().append(setCommand);
			}
			
			if(!fact.getValueKey().equals(wrapper.getValueKey())){
				setCommand = new SetCommand(editingDomain, fact,
						EsbPackage.Literals.RULE_FACT__VALUE_KEY, wrapper.getValueKey());
				getResultCommand().append(setCommand);
			}

		}

		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		} else {
			if(getResultCommand().getCommandList().size()>1){
				log.error("RuleMediator facts configuration : cannot save facts", new Exception(
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
	
	/**
	 * Wrapper class for RuleFact
	 * 
	 */
	class FactWrapper{
		RuleFact fact;
		RuleFactType factType;
		String factCustomType;
		String factName;
		RuleFactValueType valueType;
		String valueLiteral;
		NamespacedProperty valueExpression;
		RegistryKeyProperty valueKey;
		
		public FactWrapper(RuleFact fact){
			this.fact = fact;
		}
		
		public RuleFact getFact() {
			return fact;
		}
		public void setFact(RuleFact fact) {
			this.fact = fact;
		}
		public RuleFactType getFactType() {
			return factType;
		}
		public void setFactType(RuleFactType factType) {
			this.factType = factType;
		}
		public String getFactCustomType() {
			return factCustomType;
		}
		public void setFactCustomType(String factCustomType) {
			this.factCustomType = factCustomType;
		}
		public String getFactName() {
			return factName;
		}
		public void setFactName(String factName) {
			this.factName = factName;
		}
		public RuleFactValueType getValueType() {
			return valueType;
		}
		public void setValueType(RuleFactValueType valueType) {
			this.valueType = valueType;
		}
		public String getValueLiteral() {
			return valueLiteral;
		}
		public void setValueLiteral(String valueLiteral) {
			this.valueLiteral = valueLiteral;
		}
		public NamespacedProperty getValueExpression() {
			return valueExpression;
		}
		public void setValueExpression(NamespacedProperty valueExpression) {
			this.valueExpression = valueExpression;
		}
		public RegistryKeyProperty getValueKey() {
			return valueKey;
		}
		public void setValueKey(RegistryKeyProperty valueKey) {
			this.valueKey = valueKey;
		}
	}
}
