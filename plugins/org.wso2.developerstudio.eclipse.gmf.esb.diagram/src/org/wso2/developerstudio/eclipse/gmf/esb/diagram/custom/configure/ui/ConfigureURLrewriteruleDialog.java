package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.configure.ui;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.EvaluatorExpressionProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleActionType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleFragmentType;
import org.wso2.developerstudio.eclipse.gmf.esb.RuleOptionType;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRule;
import org.wso2.developerstudio.eclipse.gmf.esb.URLRewriteRuleAction;

public class ConfigureURLrewriteruleDialog extends Dialog {
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private Text txtCondition;
	private Table tableRules;
	private Button btnAdd;
	private Button btnAddAction;
	private Button btnRemoveAction;
	private URLRewriteMediator urlMediator;
	private TransactionalEditingDomain editingDomain;
	private CompoundCommand resultCommand;
	private Table tableActions;

	private TableEditor actionEditor;
	private TableEditor fragmentEditor;
	private TableEditor optionEditor;
	private TableEditor valueEditor;
	private TableEditor regEditor;
	private TableEditor valueEditorbtn;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public ConfigureURLrewriteruleDialog(Shell parentShell,
			URLRewriteMediator urlMediator,
			TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.urlMediator = urlMediator;
		this.editingDomain = editingDomain;
	}

	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("URLRewirte Mediator Configuration");
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */

	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FormLayout());
		final Shell newshell = parent.getShell();

		createConditionLabel(container);
		createConditionTextBox(container);
		FormData fd_txtRuleEditor = new FormData();
		fd_txtRuleEditor.right = new FormAttachment(100, -10);
		fd_txtRuleEditor.left = new FormAttachment(0, 80);
		txtCondition.setLayoutData(fd_txtRuleEditor);
		txtCondition.setEnabled(false);

		btnAdd = new Button(container, SWT.NONE);
		FormData fd_btnsave = new FormData();
		fd_btnsave.right = new FormAttachment(100, -32);
		fd_btnsave.top = new FormAttachment(0, 34);
		btnAdd.setLayoutData(fd_btnsave);
		formToolkit.adapt(btnAdd, true, true);
		btnAdd.setText("Add");

		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					EvaluatorExpressionProperty property = EsbFactory.eINSTANCE
							.createEvaluatorExpressionProperty();
					property.setEvaluatorName("Condition");
					UrlRewriteRulesWrapper rulesWrapper = new UrlRewriteRulesWrapper();
					rulesWrapper.setCondition(property);
					rulesWrapper.setActions(new ArrayList<UrlActionWrapper>());
					rulesWrapper.setUrlRule(EsbFactory.eINSTANCE
							.createURLRewriteRule());
					TableItem item = bindRules(rulesWrapper);
					item.setText("Rule");
					tableRules.forceFocus();
					updateSelection();
					tableActions.clearAll();
					fillActionsTable(tableRules.getItemCount()-1);
					tableRules.setSelection(tableRules.getItemCount()-1);
			}
		});

		Button btnRemove = new Button(container, SWT.NONE);
		fd_btnsave.left = new FormAttachment(btnRemove, 0, SWT.LEFT);
		FormData fd_btnRemove = new FormData();
		fd_btnRemove.top = new FormAttachment(btnAdd, 6);
		fd_btnRemove.right = new FormAttachment(100, -32);
		btnRemove.setLayoutData(fd_btnRemove);
		formToolkit.adapt(btnRemove, true, true);
		btnRemove.setText("Remove");

		btnRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tableRules.getSelectionIndex();
				if (-1 != selectedIndex) {
					unbindRules(selectedIndex);
					txtCondition.setText("");
					txtCondition.setEnabled(false);
					tableActions.removeAll();
					btnRemoveAction.setEnabled(false);
					btnAddAction.setEnabled(false);
					tableActions.setEnabled(false);
					if (selectedIndex < tableRules.getItemCount()) {
						tableRules.select(selectedIndex);
					} else {
						tableRules.select(selectedIndex - 1);
					}
				}
			}
		});

		tableRules = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		fd_txtRuleEditor.top = new FormAttachment(tableRules, 17);
		fd_btnRemove.left = new FormAttachment(tableRules, 30);
		FormData fd_tableRules = new FormData();
		fd_tableRules.bottom = new FormAttachment(100, -364);
		fd_tableRules.top = new FormAttachment(0, 10);
		fd_tableRules.right = new FormAttachment(100, -168);
		fd_tableRules.left = new FormAttachment(0, 10);
		tableRules.setLayoutData(fd_tableRules);
		formToolkit.adapt(tableRules);
		formToolkit.paintBordersFor(tableRules);
		tableRules.setHeaderVisible(true);
		tableRules.setLinesVisible(true);

		TableColumn tblclmnNewColumn = new TableColumn(tableRules, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Rules");

		tableActions = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		fd_txtRuleEditor.bottom = new FormAttachment(tableActions, -35);
		FormData fd_tableActions = new FormData();
		fd_tableActions.top = new FormAttachment(0, 295);
		fd_tableActions.left = new FormAttachment(0, 10);
		fd_tableActions.right = new FormAttachment(100, -10);
		tableActions.setLayoutData(fd_tableActions);
		formToolkit.adapt(tableActions);
		formToolkit.paintBordersFor(tableActions);
		tableActions.setHeaderVisible(true);
		tableActions.setLinesVisible(true);

		btnAddAction = new Button(container, SWT.NONE);
		btnAddAction.setEnabled(false);
		fd_tableActions.bottom = new FormAttachment(100, -38);
		btnAddAction.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem item = tableRules.getItem(tableRules
						.getSelectionIndex());
				UrlRewriteRulesWrapper wraprule = (UrlRewriteRulesWrapper) item
						.getData();
				UrlActionWrapper urlActionWrapper = new UrlActionWrapper();
				bindActionTotable(new TableItem(tableActions, SWT.NONE),
						urlActionWrapper, true);
				wraprule.getActions().add(urlActionWrapper);
			}
		});
		FormData fd_btnAddAction = new FormData();
		fd_btnAddAction.left = new FormAttachment(0, 10);
		fd_btnAddAction.top = new FormAttachment(tableActions, 6);
		btnAddAction.setLayoutData(fd_btnAddAction);
		formToolkit.adapt(btnAddAction, true, true);
		btnAddAction.setText("Add Action");

		btnRemoveAction = new Button(container, SWT.NONE);
		btnRemoveAction.setEnabled(false);
		btnRemoveAction.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int[] selectionIndices = tableActions.getSelectionIndices();
				int selectedIndex = tableActions.getSelectionIndex();
				unbindAction(tableActions.getItem(selectedIndex));
				tableActions.remove(selectionIndices);
				updateSelection();
				tableActions.redraw();
				if (-1 != selectedIndex) {
					if (selectedIndex < tableActions.getItemCount()) {
						tableActions.select(selectedIndex);
					} else {
						tableActions.select(selectedIndex - 1);
					}
				}
			}
		});
		FormData fd_btnRemoveAction = new FormData();
		fd_btnRemoveAction.top = new FormAttachment(tableActions, 6);
		fd_btnRemoveAction.left = new FormAttachment(btnAddAction, 21);
		btnRemoveAction.setLayoutData(fd_btnRemoveAction);
		formToolkit.adapt(btnRemoveAction, true, true);
		btnRemoveAction.setText("Remove Action");

		Label lblNewLabel = new Label(container, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.bottom = new FormAttachment(tableActions, -6);
		fd_lblNewLabel.left = new FormAttachment(0, 10);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		formToolkit.adapt(lblNewLabel, true, true);
		lblNewLabel.setText("Actions");

		TableColumn tblclmnNewColumn_1 = new TableColumn(tableActions, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Action");

		TableColumn tblclmnNewColumn_2 = new TableColumn(tableActions, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("Fragment");

		TableColumn tblclmnNewColumn_3 = new TableColumn(tableActions, SWT.NONE);
		tblclmnNewColumn_3.setWidth(83);
		tblclmnNewColumn_3.setText("Option");

		TableColumn tblclmnNewColumn_4 = new TableColumn(tableActions, SWT.NONE);
		tblclmnNewColumn_4.setWidth(139);
		tblclmnNewColumn_4.setText("Value");

		TableColumn tblclmnNewColumn_5 = new TableColumn(tableActions, SWT.NONE);
		tblclmnNewColumn_5.setWidth(92);
		tblclmnNewColumn_5.setText("Expression");

		TableColumn tblclmnNewColumn_6 = new TableColumn(tableActions, SWT.NONE);
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("Regex");
		
		
		tableRules.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tableRules.getSelectionIndex();
				fillActionsTable(selectedIndex);
			}
		});
		tableActions.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (null != e.item) {
					if (e.item instanceof TableItem) {
						createActionContorls((TableItem) e.item, newshell);
					}
				} else {

				}
			}
		});

		EList<URLRewriteRule> urlRewriteRules = urlMediator
				.getUrlRewriteRules();
		for (URLRewriteRule urlRewriteRule : urlRewriteRules) {
			UrlRewriteRulesWrapper rulesWrapper = new UrlRewriteRulesWrapper();
			EvaluatorExpressionProperty ruleCondition = urlRewriteRule
					.getUrlRewriteRuleCondition();
			if(null!=ruleCondition){
				rulesWrapper.setCondition(EsbFactory.eINSTANCE
						.copyEvaluatorExpressionProperty(ruleCondition));
			}
			List<UrlActionWrapper> actionWrapperslist = new ArrayList<UrlActionWrapper>();
			EList<URLRewriteRuleAction> rewriteRuleAction = urlRewriteRule
					.getRewriteRuleAction();
			for (URLRewriteRuleAction urlRewriteRuleAction : rewriteRuleAction) {
				UrlActionWrapper actionWrapper = new UrlActionWrapper();
				actionWrapper.setAction(urlRewriteRuleAction.getRuleAction()
						.getValue());
				actionWrapper.setFragment(urlRewriteRuleAction
						.getRuleFragment().getValue());
				actionWrapper.setOption(urlRewriteRuleAction.getRuleOption()
						.getValue());
				actionWrapper.setRegex(urlRewriteRuleAction.getActionRegex());
				actionWrapper.setNsproperty(urlRewriteRuleAction
						.getActionExpression());
				actionWrapper.setValue(urlRewriteRuleAction.getActionValue());
				actionWrapper.setUrlRewriteRuleAction(urlRewriteRuleAction);
				actionWrapperslist.add(actionWrapper);
			}
			rulesWrapper.setActions(actionWrapperslist);
			rulesWrapper.setUrlRule(urlRewriteRule);
			TableItem bindRules = bindRules(rulesWrapper);
			bindRules.setText("Rule");
			
		}
		if(tableRules.getItemCount()>0){
			tableRules.forceFocus();
			tableRules.setSelection(0);
			fillActionsTable(0);
		}
		return container;
	}

	private void createConditionLabel(Composite container) {
		Label lblCondition = new Label(container, SWT.NONE);
		FormData lblConditionFormData = new FormData();
		lblConditionFormData.top = new FormAttachment(tableRules, 190);
		lblConditionFormData.left = new FormAttachment(0, 10);
		lblCondition.setLayoutData(lblConditionFormData);
		formToolkit.adapt(lblCondition, true, true);
		lblCondition.setText("Condition");
	}

	private void createConditionTextBox(Composite container) {
		txtCondition = formToolkit.createText(container, null, SWT.BORDER | SWT.MULTI);
		txtCondition.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				int selectionIndex = tableRules.getSelectionIndex();
				String rule = txtCondition.getText();
				if (selectionIndex > -1) {
					TableItem item = tableRules.getItem(selectionIndex);
					//item.setText(txtRuleEditor.getText());
					EvaluatorExpressionProperty property = EsbFactory.eINSTANCE.createEvaluatorExpressionProperty();
					property.setEvaluatorName("Condition");
					property.setEvaluatorValue(rule);
					UrlRewriteRulesWrapper wraprule = (UrlRewriteRulesWrapper) item.getData();
					wraprule.setCondition(property);
				}
			}
		});
	}
	
	private void fillActionsTable(int selectedIndex) {
		TableItem item = tableRules.getItem(selectedIndex);
		UrlRewriteRulesWrapper wraprule = (UrlRewriteRulesWrapper) item.getData();
		if(wraprule.getCondition()!=null){
			if(wraprule.getCondition().getEvaluatorValue()!=null){
				txtCondition.setText(wraprule.getCondition().getEvaluatorValue());
			} else {
				txtCondition.setText("");
			}
		}
		
		txtCondition.setEnabled(true);
		btnRemoveAction.setEnabled(true);
		btnAddAction.setEnabled(true);
		tableActions.setEnabled(true);
		List<UrlActionWrapper> actions = wraprule.getActions();

		updateSelection();
		tableActions.removeAll();
		for (UrlActionWrapper urlActionWrapper : actions) {
			bindActionTotable(new TableItem(tableActions, SWT.NONE),
					urlActionWrapper, false);
		}
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */

	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */

	protected Point getInitialSize() {
		return new Point(687, 593);
	}

	private void updateSelection() {
		initTableEditor(actionEditor, tableActions);
		initTableEditor(fragmentEditor, tableActions);
		initTableEditor(optionEditor, tableActions);
		initTableEditor(valueEditor, tableActions);
		initTableEditor(valueEditorbtn, tableActions);
		initTableEditor(regEditor, tableActions);

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

	public void bindActionTotable(TableItem item, UrlActionWrapper action,
			boolean newAction) {
		item.setData(action);
		if (newAction) {
			URLRewriteRuleAction ruleAction = EsbFactory.eINSTANCE
					.createURLRewriteRuleAction();
			action.setUrlRewriteRuleAction(ruleAction);
			action.setAction(0);
			action.setFragment(0);
			action.setOption(0);
			action.setValue("");
			action.setRegex("");
		}
		item.setText(0, RuleActionType.get(action.getAction()).getLiteral());
		item.setText(1, RuleFragmentType.get(action.getFragment()).getLiteral());
		item.setText(2, RuleOptionType.get(action.getOption()).getLiteral());
		if (action.getOption() == 1 && action.getNsproperty() != null) {
			item.setText(3, action.getNsproperty().getPropertyValue());
		} else {
			if(action.getValue()!=null){
				item.setText(3, action.getValue());
			}
		}
		if(action.getRegex()!=null){
			item.setText(5, action.getRegex());
		}
	}

	public void unbindAction(TableItem item) {
		UrlActionWrapper action = (UrlActionWrapper) item.getData();
		TableItem itemRules = tableRules
				.getItem(tableRules.getSelectionIndex());
		UrlRewriteRulesWrapper rulesWrapper = (UrlRewriteRulesWrapper) itemRules
				.getData();
		List<UrlActionWrapper> actionsList = rulesWrapper.getActions();
		int val = actionsList.indexOf(action);
		actionsList.remove(val);
		if (action.getUrlRewriteRuleAction().eContainer() != null) {
			RemoveCommand removeCommand = new RemoveCommand(editingDomain,
					rulesWrapper.getUrlRule(),
					EsbPackage.Literals.URL_REWRITE_RULE__REWRITE_RULE_ACTION,
					action.getUrlRewriteRuleAction());
			getResultCommand().append(removeCommand);
		}
	}

	
	private void createActionContorls(final TableItem item, final Shell newshell) {

		updateSelection();
		final UrlActionWrapper action = (UrlActionWrapper) item.getData();
		actionEditor = new TableEditor(tableActions);
		actionEditor.grabHorizontal = true;
		final Combo comboAction = createCombo(new String[] {
				RuleActionType.get(0).getLiteral(),
				RuleActionType.get(1).getLiteral(),
				RuleActionType.get(2).getLiteral(),
				RuleActionType.get(3).getLiteral(),
				RuleActionType.get(4).getLiteral() });
		actionEditor.setEditor(comboAction, item, 0);
		comboAction.select(action.getAction());
		
		fragmentEditor = new TableEditor(tableActions);
		fragmentEditor.grabHorizontal = true;
		final Combo comboFragment = createCombo(new String[] {
				RuleFragmentType.get(0).getLiteral(),
				RuleFragmentType.get(1).getLiteral(),
				RuleFragmentType.get(2).getLiteral(),
				RuleFragmentType.get(3).getLiteral(),
				RuleFragmentType.get(4).getLiteral(),
				RuleFragmentType.get(5).getLiteral(),
				RuleFragmentType.get(-1).getLiteral(),
				RuleFragmentType.get(-2).getLiteral() });
		fragmentEditor.setEditor(comboFragment, item, 1);
		comboFragment.select(action.getFragment());
		comboFragment.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				item.setText(1, comboFragment.getText());
				if (comboFragment.getSelectionIndex() == 6) {
					action.setFragment(-1);
				} else if (comboFragment.getSelectionIndex() == 7) {
					action.setFragment(-2);
				} else {
					action.setFragment(comboFragment.getSelectionIndex());
				}
				
			}
		});

		optionEditor = new TableEditor(tableActions);
		optionEditor.grabHorizontal = true;
		final Combo comboOption = createCombo(new String[] {
				RuleOptionType.get(0).getLiteral(),
				RuleOptionType.get(1).getLiteral() });
		optionEditor.setEditor(comboOption, item, 2);
		comboOption.select(action.getOption());

		valueEditor = new TableEditor(tableActions);
		final Text text = new Text(tableActions, SWT.NONE);
		if (action.getOption() == 0) {
			text.setEnabled(true);
			if(action.getValue()!=null){
				text.setText(action.getValue());
			}
			text.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent arg0) {
					action.setValue(text.getText());
					item.setText(3, text.getText());
				}
			});
		} else {
			text.setText("");
			text.setEnabled(false);
		}
		valueEditor.grabHorizontal = true;
		valueEditor.setEditor(text, item, 3);
		valueEditor.horizontalAlignment = SWT.LEFT;
		valueEditorbtn = new TableEditor(tableActions);

		final Button btnNS = new Button(tableActions, SWT.PUSH);
		btnNS.setEnabled(false);
		btnNS.setText("        Edit        ");
		btnNS.pack();
		btnNS.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				NamespacedProperty nsproperty = action.getNsproperty();				
				NamespacedProperty namespacedProperty = EsbFactory.eINSTANCE.createNamespacedProperty();
				if(nsproperty!=null){
					namespacedProperty.setPropertyValue(nsproperty.getPropertyValue());
					namespacedProperty.setNamespaces(nsproperty.getNamespaces());
				}
							
				NamespacedPropertyEditorDialog dialog = new NamespacedPropertyEditorDialog(
						newshell, namespacedProperty);
				dialog.open();
				item.setText(3, namespacedProperty.getPropertyValue());
				action.setNsproperty(namespacedProperty);
				if(namespacedProperty.getPropertyValue()!=null){
					text.setText(namespacedProperty.getPropertyValue());
				}
				action.setValue(null);
			}
		});

		valueEditorbtn.minimumWidth = btnNS.getSize().x;
		valueEditorbtn.horizontalAlignment = SWT.LEFT;
		valueEditorbtn.setEditor(btnNS, item, 4);
		if (action.getOption() == 1) {
			btnNS.setEnabled(true);
		}

		comboOption.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				item.setText(2, comboOption.getText());
				action.setOption(comboOption.getSelectionIndex());
				if (comboOption.getSelectionIndex() == 0) {
					text.setEnabled(true);
					btnNS.setEnabled(false);
				} else {
					text.setText("");
					text.setEnabled(false);
					btnNS.setEnabled(true);
				}
			}
		});

		regEditor = new TableEditor(tableActions);
		final Text txtreg = new Text(tableActions, SWT.NONE);
		if(action.getRegex()!=null){
			txtreg.setText(action.getRegex());
		}
		txtreg.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				item.setText(5, txtreg.getText());
				action.setRegex(txtreg.getText());
			}
		});
		regEditor.grabHorizontal = true;
		regEditor.setEditor(txtreg, item, 5);
		tableActions.redraw();
		
		comboAction.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
				int selectionIndex = comboAction.getSelectionIndex();
				enableControls(comboOption, text, btnNS, txtreg, selectionIndex, action.getOption());
				
				item.setText(0, comboAction.getText());
				action.setAction(comboAction.getSelectionIndex());
			}
		});
		
		enableControls(comboOption, text, btnNS, txtreg, action.getAction(), action.getOption());
	}

	private void enableControls(final Combo comboOption, final Text text, final Button btnNS,
		final Text txtreg, int actionIndex, int optionIndex) {
		boolean txtRegEnable = (actionIndex == 3);
		boolean comboOptionEnable = (actionIndex != 4);
		txtreg.setEnabled(txtRegEnable);
		comboOption.setEnabled(comboOptionEnable);
		text.setEnabled(comboOptionEnable && (optionIndex == 0));
		btnNS.setEnabled(comboOptionEnable && (optionIndex == 1));
	}

	private Combo createCombo(String[] values) {
		Combo combo = new Combo(tableActions, SWT.READ_ONLY);
		int i = 0;
		for (String value : values) {
			combo.add(value, i);
			i++;
		}
		combo.select(0);
		return combo;
	}

	private TableItem bindRules(UrlRewriteRulesWrapper rule) {
		TableItem item = new TableItem(tableRules, SWT.NONE);
		item.setData(rule);
		return item;
	}

	/**
	 * Removes the corresponding table item from the table and records a command
	 * for detaching the corresponding log property from the model.
	 * 
	 * @param itemIndex
	 *            index of the row which is to be removed.
	 */
	private void unbindRules(int itemIndex) {
		TableItem item = tableRules.getItem(itemIndex);
		UrlRewriteRulesWrapper wraprule = (UrlRewriteRulesWrapper) item
				.getData();
		wraprule.setremove(true);
		tableRules.remove(tableRules.indexOf(item));
		if (wraprule.getUrlRule().eContainer() != null) {
			RemoveCommand removeCommand = new RemoveCommand(
					editingDomain,
					urlMediator,
					EsbPackage.Literals.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES,
					wraprule.getUrlRule());
			getResultCommand().append(removeCommand);
		}
	}

	private CompoundCommand getResultCommand() {
		if (null == resultCommand) {
			resultCommand = new CompoundCommand();
		}
		return resultCommand;
	}

	protected void okPressed() {

		TableItem[] items = tableRules.getItems();
		for (TableItem tableItem : items) {
			UrlRewriteRulesWrapper wraprule = (UrlRewriteRulesWrapper) tableItem
					.getData();
			URLRewriteRule rule = wraprule.getUrlRule();
			EList<URLRewriteRuleAction> rewriteRuleAction = rule.getRewriteRuleAction();
 			/* adding a new rule */
 			if (null == rule.eContainer()) {
 				rule.setUrlRewriteRuleCondition(wraprule.getCondition());
			
				List<UrlActionWrapper> actions = wraprule.getActions();
				for (UrlActionWrapper urlActionWrapper : actions) {
					URLRewriteRuleAction ruleAction = EsbFactory.eINSTANCE
							.createURLRewriteRuleAction();
					if (urlActionWrapper.getNsproperty() != null) {
						NamespacedProperty property = EsbFactory.eINSTANCE
								.createNamespacedProperty();
						property.setNamespaces(urlActionWrapper.getNsproperty()
								.getNamespaces());
						property.setPrettyName("ns");
						property.setPropertyName("ns");
						property.setPropertyValue(urlActionWrapper
								.getNsproperty().getPropertyValue());
						ruleAction.setActionExpression(property);
					}
					ruleAction.setActionRegex(urlActionWrapper.getRegex());
					ruleAction.setActionValue(urlActionWrapper.getValue());
					ruleAction.setRuleAction(RuleActionType
							.get(urlActionWrapper.getAction()));
					ruleAction.setRuleFragment(RuleFragmentType
							.get(urlActionWrapper.getFragment()));
					ruleAction.setRuleOption(RuleOptionType
							.get(urlActionWrapper.getOption()));
					rewriteRuleAction.add(ruleAction);
				}

				AddCommand addCmd = new AddCommand(
						editingDomain,
						urlMediator,
						EsbPackage.Literals.URL_REWRITE_MEDIATOR__URL_REWRITE_RULES,
						rule);
				getResultCommand().append(addCmd);
			} else {
				/* check the condition changes */
				if (rule.getUrlRewriteRuleCondition() == null
						|| !(StringUtils.equals(rule.getUrlRewriteRuleCondition()
								.getEvaluatorValue(), wraprule.getCondition().getEvaluatorValue()))) {

					SetCommand command = new SetCommand(editingDomain, rule,
							EsbPackage.Literals.URL_REWRITE_RULE__URL_REWRITE_RULE_CONDITION,
							wraprule.getCondition());
					getResultCommand().append(command);
				}

				List<UrlActionWrapper> actions = wraprule.getActions();
				for (UrlActionWrapper urlActionWrapper : actions) {
					URLRewriteRuleAction ruleAction = urlActionWrapper
							.getUrlRewriteRuleAction();
					if (null == ruleAction.eContainer()) {
						NamespacedProperty property = null;
						if (urlActionWrapper.getNsproperty() != null) {
							property = EsbFactory.eINSTANCE
									.createNamespacedProperty();
							property.setNamespaces(urlActionWrapper
									.getNsproperty().getNamespaces());
							property.setPrettyName("ns");
							property.setPropertyName("ns");
							property.setPropertyValue(urlActionWrapper
									.getNsproperty().getPropertyValue());
						}
						ruleAction.setActionExpression(property);
						ruleAction.setActionRegex(urlActionWrapper.getRegex());
						ruleAction.setActionValue(urlActionWrapper.getValue());
						ruleAction.setRuleAction(RuleActionType
								.get(urlActionWrapper.getAction()));
						ruleAction.setRuleFragment(RuleFragmentType
								.get(urlActionWrapper.getFragment()));
						ruleAction.setRuleOption(RuleOptionType
								.get(urlActionWrapper.getOption()));

						AddCommand addCommand = new AddCommand(
								editingDomain,
								rule,
								EsbPackage.Literals.URL_REWRITE_RULE__REWRITE_RULE_ACTION,
								ruleAction);
						getResultCommand().append(addCommand);
					} else {
						SetCommand setCommand = new SetCommand(
								editingDomain,
								ruleAction,
								EsbPackage.Literals.URL_REWRITE_RULE_ACTION__ACTION_EXPRESSION,
								urlActionWrapper.getNsproperty());
						getResultCommand().append(setCommand);

						setCommand = new SetCommand(
								editingDomain,
								ruleAction,
								EsbPackage.Literals.URL_REWRITE_RULE_ACTION__ACTION_REGEX,
								urlActionWrapper.getRegex());
						getResultCommand().append(setCommand);

						setCommand = new SetCommand(
								editingDomain,
								ruleAction,
								EsbPackage.Literals.URL_REWRITE_RULE_ACTION__ACTION_VALUE,
								urlActionWrapper.getValue());
						getResultCommand().append(setCommand);

						setCommand = new SetCommand(
								editingDomain,
								ruleAction,
								EsbPackage.Literals.URL_REWRITE_RULE_ACTION__RULE_ACTION,
								RuleActionType
										.get(urlActionWrapper.getAction()));
						getResultCommand().append(setCommand);

						setCommand = new SetCommand(
								editingDomain,
								ruleAction,
								EsbPackage.Literals.URL_REWRITE_RULE_ACTION__RULE_FRAGMENT,
								RuleFragmentType.get(urlActionWrapper
										.getFragment()));
						getResultCommand().append(setCommand);

						setCommand = new SetCommand(
								editingDomain,
								ruleAction,
								EsbPackage.Literals.URL_REWRITE_RULE_ACTION__RULE_OPTION,
								RuleOptionType
										.get(urlActionWrapper.getOption()));
						getResultCommand().append(setCommand);
					}
				}
			}
		}
		/* Apply changes. */
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
		}
		super.okPressed();
	}
}

class UrlRewriteRulesWrapper {

	public List<UrlActionWrapper> getActions() {
		return actions;
	}

	public void setActions(List<UrlActionWrapper> actions) {
		this.actions = actions;
	}

	public EvaluatorExpressionProperty getCondition() {
		return condition;
	}

	public void setCondition(EvaluatorExpressionProperty condition) {
		this.condition = condition;
	}

	public URLRewriteRule getUrlRule() {
		return urlRule;
	}

	public void setUrlRule(URLRewriteRule urlRule) {
		this.urlRule = urlRule;
	}

	public void setremove(boolean isremove) {
		this.remove = isremove;
	}

	public boolean isremove() {
		return remove;
	}

	private List<UrlActionWrapper> actions;
	private EvaluatorExpressionProperty condition;
	private URLRewriteRule urlRule;
	private boolean remove;

}

class UrlActionWrapper {

	public UrlActionWrapper() {

	}

	public NamespacedProperty getNsproperty() {
		return nsproperty;
	}

	public void setNsproperty(NamespacedProperty nsproperty) {
		this.nsproperty = nsproperty;
	}

	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public int getFragment() {
		return fragment;
	}

	public void setFragment(int fragment) {
		this.fragment = fragment;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setUrlRewriteRuleAction(
			URLRewriteRuleAction urlRewriteRuleAction) {
		this.urlRewriteRuleAction = urlRewriteRuleAction;
	}

	public URLRewriteRuleAction getUrlRewriteRuleAction() {
		return urlRewriteRuleAction;
	}

	private NamespacedProperty nsproperty;
	private int action;
	private int option;
	private int fragment;
	private String regex;
	private String value;
	private URLRewriteRuleAction urlRewriteRuleAction;

}
