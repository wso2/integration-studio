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
import org.wso2.developerstudio.eclipse.gmf.esb.RuleMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResult;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleResultValueType;
import org.wso2.developerstudio.eclipse.logging.core.IDeveloperStudioLog;
import org.wso2.developerstudio.eclipse.logging.core.Logger;

/**
 * RuleMediator results configuration *dialog
 *
 */
public class ConfigureRuleMediatorResultsDialog extends TitleAreaDialog {
	
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
	private Table tblResults;
	private Button cmdResultAdd;
	private Button cmdResultRemove;
	private Combo cmbType;
	private Text txtName;
	private Combo cmbTargetType;
	private PropertyText txtValue;
	
	/**
	 * table editors
	 */
	private TableEditor typeEditor;
	private TableEditor nameEditor;
	private TableEditor targetTypeEditor;
	private TableEditor valueEditor;
	
	private final static String LITERAL_VALUE = "Literal";
	private final static String LITERAL_EXPRESSION = "Expression";
	private final static String LITERAL_KEY = "Key";
	
	private List<String> resultTypes = new ArrayList<String>();
	
	public ConfigureRuleMediatorResultsDialog(Shell parentShell,RuleMediator ruleMediator, TransactionalEditingDomain editingDomain) {
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
		setTitle("Results Configuration");
		setMessage("Results describes what should do with return values form the rule execution.");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		tblResults = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		tblResults.setBounds(10, 10, 510, 222);
		tblResults.setHeaderVisible(true);
		tblResults.setLinesVisible(true);
		tblResults.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (null != e.item) {
					if (e.item instanceof TableItem) {
						TableItem item = (TableItem) e.item;
						editItem(item);
						cmdResultRemove.setEnabled(true);
					}
				} else{
					cmdResultRemove.setEnabled(false);
					updateSelection();
				}
			}
		});
		
		TableColumn tblclmnType = new TableColumn(tblResults, SWT.NONE);
		tblclmnType.setWidth(150);
		tblclmnType.setText("Type");
		
		TableColumn tblclmnName = new TableColumn(tblResults, SWT.NONE);
		tblclmnName.setWidth(150);
		tblclmnName.setText("Name");
		
		TableColumn tblclmnValue = new TableColumn(tblResults, SWT.NONE);
		tblclmnValue.setWidth(180);
		tblclmnValue.setText("NameSpace/xpath");
		
		cmdResultAdd = new Button(container, SWT.NONE);
		cmdResultAdd.setBounds(527, 10, 86, 29);
		cmdResultAdd.setText("Add");
		cmdResultAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RuleResult result = EsbFactory.eINSTANCE.createRuleResult();
				ResultWrapper wrapper = new ResultWrapper(result);
				wrapper.setResultName(result.getResultName());
				wrapper.setResultCustomType(result.getResultCustomType());
				wrapper.setResultType(result.getResultType());
				wrapper.setValueType(result.getValueType());
				wrapper.setValueLiteral(result.getValueLiteral());
				wrapper.setValueExpression(EsbFactory.eINSTANCE.copyNamespacedProperty(result.getValueExpression()));
				wrapper.setValueKey(EsbFactory.eINSTANCE.copyRegistryKeyProperty(result.getValueKey()));
				bindResult(wrapper);
			}
		});
		
		cmdResultRemove = new Button(container, SWT.NONE);
		cmdResultRemove.setBounds(526, 45, 86, 29);
		cmdResultRemove.setText("Remove");
		cmdResultRemove.setEnabled(false);
		cmdResultRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblResults.getSelectionIndex();
				if (-1 != selectedIndex) {
					unbindResult(selectedIndex);
					// Select the next available candidate for deletion.
					if (selectedIndex <  tblResults.getItemCount()) {
						 tblResults.select(selectedIndex);
					} else {
						 tblResults.select(selectedIndex - 1);
					}
					updateSelection();
				}
			}
		});
		
		for(RuleResultType ruleResultType : RuleResultType.VALUES){
			if(ruleResultType!=RuleResultType.CUSTOM){
				resultTypes.add(ruleResultType.getLiteral());
			}
		}
		
		for(RuleResult result : ruleMediator.getResultsConfiguration().getResults()){
			ResultWrapper wrapper = new ResultWrapper(result);
			wrapper.setResultName(result.getResultName());
			wrapper.setResultCustomType(result.getResultCustomType());
			wrapper.setResultType(result.getResultType());
			wrapper.setValueType(result.getValueType());
			wrapper.setValueLiteral(result.getValueLiteral());
			wrapper.setValueExpression(EsbFactory.eINSTANCE.copyNamespacedProperty(result.getValueExpression()));
			wrapper.setValueKey(EsbFactory.eINSTANCE.copyRegistryKeyProperty(result.getValueKey()));
			bindResult(wrapper);
		}
		return area;
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
	
	protected void editItem(final TableItem item) {

		final ResultWrapper wrapper = (ResultWrapper) item.getData();
		
		typeEditor = initTableEditor(typeEditor,
				item.getParent());
		cmbType = new Combo(item.getParent(),SWT.NONE);
		cmbType.setItems(resultTypes.toArray(new String[]{}));
		cmbType.setText(item.getText(0));
		typeEditor.setEditor(cmbType, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		Listener cmbTypeListener = new Listener() {
			public void handleEvent(Event evt) {
				String text = cmbType.getText();
				item.setText(0, text);
				if(RuleResultType.DOM.getLiteral().equals(text)){
					wrapper.setResultType(RuleResultType.DOM);
				} else if(RuleResultType.MESSAGE.getLiteral().equals(text)){
					wrapper.setResultType(RuleResultType.MESSAGE);
				} else if(RuleResultType.CONTEXT.getLiteral().equals(text)){
					wrapper.setResultType(RuleResultType.CONTEXT);
				} else if(RuleResultType.OMELEMENT.getLiteral().equals(text)){
					wrapper.setResultType(RuleResultType.OMELEMENT);
				} else if(RuleResultType.MEDIATOR.getLiteral().equals(text)){
					wrapper.setResultType(RuleResultType.MEDIATOR);
				} else{
					wrapper.setResultType(RuleResultType.CUSTOM);
					wrapper.setResultCustomType(text);
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
				wrapper.setResultName(txtName.getText());
			}
		});

		cmbTargetType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbTargetType.setItems(new String[] { LITERAL_VALUE, LITERAL_EXPRESSION,LITERAL_KEY });
		cmbTargetType.select(1);
		valueEditor = initTableEditor(valueEditor,item.getParent());
		 
		
		txtValue = new PropertyText(item.getParent(), SWT.NONE, cmbTargetType);
		txtValue.addProperties(wrapper.getValueLiteral(),wrapper.getValueExpression(),wrapper.getValueKey());
		valueEditor.setEditor(txtValue, item, 2);
		item.getParent().redraw();
		item.getParent().layout();
		txtValue.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(3,txtValue.getText());
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
		initTableEditor(typeEditor,tblResults);
		initTableEditor(nameEditor,tblResults);
		initTableEditor(targetTypeEditor,tblResults);
		initTableEditor(valueEditor,tblResults);
		if(tblResults.getSelectionIndex()==-1){
			cmdResultRemove.setEnabled(false);
		} else{
			cmdResultRemove.setEnabled(true);
		}
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
	 * Utility method for binding a result into the UI. Note that this
	 * method does not record any commands, it simply adds a new row into the
	 * table and associates the passed {@link RuleResult} to it.
	 * 
	 * @return {@link TableItem} which was introduced.
	 */
	private TableItem bindResult(ResultWrapper wrapper) {
		TableItem item = new TableItem(tblResults, SWT.NONE);
		if(wrapper.getResultType()==RuleResultType.CUSTOM){
			item.setText(0, wrapper.getResultCustomType());
		} else{
			item.setText(0, wrapper.getResultType().getLiteral());
		}
		item.setText(1, wrapper.getResultName());
		item.setText(2,LITERAL_EXPRESSION);
		item.setText(3,wrapper.getValueExpression().getPropertyValue());
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
	private void unbindResult(int itemIndex) {
		TableItem item = tblResults.getItem(itemIndex);
		ResultWrapper wrapper = (ResultWrapper) item.getData();
		RuleResult result = wrapper.getResult();
		
		if (null != result.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					ruleMediator.getResultsConfiguration(), EsbPackage.Literals.RULE_RESULTS_CONFIGURATION__RESULTS,
					result);
			getResultCommand().append(removeCmd);
		}
		tblResults.remove(tblResults.indexOf(item));
	}
	
	@Override
	protected void okPressed() {
		for (TableItem item : tblResults.getItems()) {
			ResultWrapper wrapper = (ResultWrapper) item.getData();
			RuleResult result = wrapper.getResult();
			AddCommand addCmd = null;

			if (null == result.eContainer()) {
				addCmd = new AddCommand(editingDomain, ruleMediator.getResultsConfiguration(),
						EsbPackage.Literals.RULE_RESULTS_CONFIGURATION__RESULTS, result);
				getResultCommand().append(addCmd);
			}

			SetCommand setCommand = null;
			
			if(!result.getResultName().equals(wrapper.getResultName())){
				setCommand = new SetCommand(editingDomain, result,
						EsbPackage.Literals.RULE_RESULT__RESULT_NAME, wrapper.getResultName());
				getResultCommand().append(setCommand);
			}
			
			if (!(result.getResultType().equals(wrapper.getResultType()) && result.getResultCustomType()
					.equals(wrapper.getResultCustomType()))) {
				String customResultType = "custom_type";
				RuleResultType resultType = RuleResultType.CUSTOM;
				if (wrapper.getResultType() == RuleResultType.CUSTOM) {
					customResultType = wrapper.getResultCustomType();
				} else {
					resultType = wrapper.getResultType();
				}

				setCommand = new SetCommand(editingDomain, result,
						EsbPackage.Literals.RULE_RESULT__RESULT_CUSTOM_TYPE, customResultType);
				getResultCommand().append(setCommand);

				setCommand = new SetCommand(editingDomain, result,
						EsbPackage.Literals.RULE_RESULT__RESULT_TYPE, resultType);
				getResultCommand().append(setCommand);
			}
			
			if(!result.getValueType().equals(wrapper.getValueType())){
				if(wrapper.getValueType()==RuleResultValueType.REGISTRY_REFERENCE){
					wrapper.setValueLiteral("default");
					wrapper.getValueExpression().setPropertyValue("/default/expression");
				} else if(wrapper.getValueType()==RuleResultValueType.EXPRESSION){
					wrapper.getValueKey().setKeyValue("/default/key");
					wrapper.setValueLiteral("default");
				} else{
					wrapper.getValueExpression().setPropertyValue("/default/expression");
					wrapper.setValueLiteral("default");
				}
				
				setCommand = new SetCommand(editingDomain, result,
						EsbPackage.Literals.RULE_RESULT__VALUE_TYPE, wrapper.getValueType());
				getResultCommand().append(setCommand);
			}
			
			if(!result.getValueLiteral().equals( wrapper.getValueLiteral())){
				setCommand = new SetCommand(editingDomain, result,
						EsbPackage.Literals.RULE_RESULT__VALUE_LITERAL, wrapper.getValueLiteral());
				getResultCommand().append(setCommand);
			}
			
			if(!result.getValueExpression().equals(wrapper.getValueExpression())){
				setCommand = new SetCommand(editingDomain, result,
						EsbPackage.Literals.RULE_RESULT__VALUE_EXPRESSION, wrapper.getValueExpression());
				getResultCommand().append(setCommand);
			}
			
			if(!result.getValueKey().equals(wrapper.getValueKey())){
				setCommand = new SetCommand(editingDomain, result,
						EsbPackage.Literals.RULE_RESULT__VALUE_KEY, wrapper.getValueKey());
				getResultCommand().append(setCommand);
			}

		}

		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		} else {
			if(getResultCommand().getCommandList().size()>1){
				log.error("RuleMediator results configuration : cannot save results", new Exception(
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
	 * Wrapper class for RuleResult
	 * 
	 */
	class ResultWrapper{
		RuleResult result;
		RuleResultType resultType;
		String resultCustomType;
		String resultName;
		RuleResultValueType valueType;
		String valueLiteral;
		NamespacedProperty valueExpression;
		RegistryKeyProperty valueKey;
		
		public ResultWrapper(RuleResult result){
			this.result = result;
		}
		
		public RuleResult getResult() {
			return result;
		}
		public void setFact(RuleResult result) {
			this.result = result;
		}
		public RuleResultType getResultType() {
			return resultType;
		}
		public void setResultType(RuleResultType resultType) {
			this.resultType = resultType;
		}
		public String getResultCustomType() {
			return resultCustomType;
		}
		public void setResultCustomType(String resultCustomType) {
			this.resultCustomType = resultCustomType;
		}
		public String getResultName() {
			return resultName;
		}
		public void setResultName(String factName) {
			this.resultName = factName;
		}
		public RuleResultValueType getValueType() {
			return valueType;
		}
		public void setValueType(RuleResultValueType valueType) {
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
