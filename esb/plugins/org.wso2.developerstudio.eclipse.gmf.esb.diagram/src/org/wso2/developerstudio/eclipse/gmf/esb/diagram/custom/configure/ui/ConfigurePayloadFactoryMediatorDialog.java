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

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.MediaType;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgument;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryArgumentType;
import org.wso2.developerstudio.eclipse.gmf.esb.PayloadFactoryMediator;

/**
 *  Configuration dialog for PayloadFactory mediator arguments
 */
public class ConfigurePayloadFactoryMediatorDialog extends Dialog {
	
	/**
	 * PayloadFactoryMediator model
	 */
	private PayloadFactoryMediator mediator;
	/**
	 * Table of arguments.
	 */
	private Table tblArguments;
	
	/**
	 * Editing domain.
	 */
	private TransactionalEditingDomain editingDomain;

	/**
	 * Command for recording user operations.
	 */
	private CompoundCommand resultCommand;
	
	/**
	 * Widgets 
	 */
	private Combo cmbArgumentType;
	private Combo cmbArgumentEvaluator;
	private TableEditor argumentTypeEditor;
	private TableEditor argumentValueEditor;
	private TableEditor argumentEvaluatorEditor;
	private PropertyText argumentValue;
	private Button cmdAddArgument;
	private Button cmdRemoveArgument;
	
	private final static String LITERAL_VALUE = "Value";
	private final static String LITERAL_EXPRESSION = "Expression";
	private final static String LITERAL_XML = "xml";
	private final static String LITERAL_JSON = "json";

	/**
	 * Create the dialog.
	 * @param parentShell
	 * @param mediator
	 * @param editingDomain
	 */
	public ConfigurePayloadFactoryMediatorDialog(Shell parentShell,PayloadFactoryMediator mediator , TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.mediator = mediator;
		this.editingDomain = editingDomain;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FormLayout());
		
		Label lblArguments = new Label(container, SWT.NONE);
		FormData fd_lblArguments = new FormData();
		fd_lblArguments.top = new FormAttachment(0, 10);
		fd_lblArguments.left = new FormAttachment(0, 10);
		lblArguments.setLayoutData(fd_lblArguments);
		lblArguments.setText("Argumen&ts");
		
		tblArguments = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		FormData fd_tblArguments = new FormData();
		fd_tblArguments.bottom = new FormAttachment(lblArguments, 194, SWT.BOTTOM);
		fd_tblArguments.top = new FormAttachment(lblArguments, 6);
		fd_tblArguments.left = new FormAttachment(0, 10);
		fd_tblArguments.right = new FormAttachment(0, 481);
		tblArguments.setLayoutData(fd_tblArguments);
		tblArguments.setHeaderVisible(true);
		tblArguments.setLinesVisible(true);
		tblArguments.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (null != e.item) {
					if (e.item instanceof TableItem) {
						TableItem item = (TableItem) e.item;
						editItem(item);
						cmdRemoveArgument.setEnabled(true);
					}
				} else{
					cmdRemoveArgument.setEnabled(false);
				}
			}
		});
		
		TableColumn tblclmnArgumentType = new TableColumn(tblArguments, SWT.NONE);
		tblclmnArgumentType.setWidth(105);
		tblclmnArgumentType.setText("Type");
		
		TableColumn tblclmnArgumentValue = new TableColumn(tblArguments, SWT.NONE);
		tblclmnArgumentValue.setWidth(260);
		tblclmnArgumentValue.setText("Value");
		
		TableColumn tblclmnArgumentEvaluator = new TableColumn(tblArguments, SWT.NONE);
		tblclmnArgumentEvaluator.setWidth(100);
		tblclmnArgumentEvaluator.setText("Evaluator");
		
		
		cmdAddArgument = new Button(container, SWT.NONE);
		cmdAddArgument.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem item = bindArgument(EsbFactory.eINSTANCE
						.createPayloadFactoryArgument());
				tblArguments.select(tblArguments.indexOf(item));
			}
		});
		FormData fd_cmdAddArgument = new FormData();
		fd_cmdAddArgument.left = new FormAttachment(100, -92);
		fd_cmdAddArgument.top = new FormAttachment(0, 33);
		fd_cmdAddArgument.right = new FormAttachment(100, -10);
		cmdAddArgument.setLayoutData(fd_cmdAddArgument);
		cmdAddArgument.setText("&Add");
		
		cmdRemoveArgument = new Button(container, SWT.NONE);
		cmdRemoveArgument.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblArguments.getSelectionIndex();
				if (-1 != selectedIndex) {
					 initTableEditor(argumentTypeEditor,tblArguments);
					 initTableEditor(argumentValueEditor,tblArguments);
					 initTableEditor(argumentEvaluatorEditor,tblArguments);
					unbindArgument(selectedIndex);
					if (selectedIndex < tblArguments.getItemCount()) {
						tblArguments.select(selectedIndex);
					} else {
						tblArguments.select(selectedIndex - 1);
					}
				}
			}
		});
		cmdRemoveArgument.setEnabled(false);
		FormData fd_cmdRemoveArgument = new FormData();
		fd_cmdRemoveArgument.left = new FormAttachment(100, -92);
		fd_cmdRemoveArgument.top = new FormAttachment(cmdAddArgument, 9);
		fd_cmdRemoveArgument.right = new FormAttachment(100, -10);
		cmdRemoveArgument.setLayoutData(fd_cmdRemoveArgument);
		cmdRemoveArgument.setText("&Remove");
		
		// Populate arguments
		for(PayloadFactoryArgument arg : mediator.getArgs() ){
			bindArgument(arg);
		}

		return container;
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
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(597, 329);
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		newShell.setText("PayloadFactory Mediator Arguments");
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
	
	private void editItem(final TableItem item) {
		final ArgumentWrapper wrapper = (ArgumentWrapper) item.getData();
		
		argumentTypeEditor = initTableEditor(argumentTypeEditor, item.getParent());
		cmbArgumentType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbArgumentType.setItems(new String[] { LITERAL_VALUE, LITERAL_EXPRESSION });
		cmbArgumentType.setText(item.getText(0));
		argumentTypeEditor.setEditor(cmbArgumentType, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		cmbArgumentType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(0, cmbArgumentType.getText());
				if(cmbArgumentType.getSelectionIndex()==1){
					wrapper.setExpression(true);
					item.setText(1,wrapper.getArgumentExpression().getPropertyValue());
					
					String evalString = MediaType.XML.toString();
					if (wrapper.getEvaluator() != null) {
						evalString = wrapper.getEvaluator().toString();
					}
					item.setText(2, evalString);
					cmbArgumentEvaluator.setText(evalString);
					cmbArgumentEvaluator.setEnabled(true);
				} else{
					wrapper.setExpression(false);
					item.setText(1,wrapper.getArgumentValue());
					item.setText(2,"");
					cmbArgumentEvaluator.setText("");
					cmbArgumentEvaluator.setEnabled(false);
				}
			}
		});
		
		argumentValueEditor = initTableEditor(argumentValueEditor, item.getParent());
		argumentValue = new PropertyText(item.getParent(), SWT.NONE, cmbArgumentType);
		argumentValue.addProperties(wrapper.getArgumentValue(), wrapper.getArgumentExpression());
		argumentValueEditor.setEditor(argumentValue, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		argumentValue.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(1,argumentValue.getText());
				Object property = argumentValue.getProperty();
				if(property instanceof NamespacedProperty){
/*					if (wrapper.getEvaluator() == MediaType.XML) {
						wrapper.setArgumentExpression((NamespacedProperty)property);
					} else if (wrapper.getEvaluator() == MediaType.JSON){
						String modifiedText = argumentValue.getText();
						NamespacedProperty namespacedProperty = (NamespacedProperty)property;
						namespacedProperty.setPropertyValue(modifiedText);
						wrapper.setArgumentExpression(namespacedProperty);
					}*/
					wrapper.setArgumentExpression((NamespacedProperty)property);
				} else{
					wrapper.setArgumentValue(property.toString());
				}
			}
		});
		
		argumentEvaluatorEditor = initTableEditor(argumentEvaluatorEditor, item.getParent());
		cmbArgumentEvaluator = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbArgumentEvaluator.setItems(new String[] { LITERAL_XML, LITERAL_JSON });
		cmbArgumentEvaluator.setText(item.getText(2));
		argumentEvaluatorEditor.setEditor(cmbArgumentEvaluator, item, 2);
		cmbArgumentEvaluator.setEnabled(wrapper.isExpression()); 
		item.getParent().redraw();
		item.getParent().layout();
		cmbArgumentEvaluator.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				
				item.setText(2, cmbArgumentEvaluator.getText());
				if(cmbArgumentEvaluator.getSelectionIndex()==0){
					wrapper.setEvaluator(MediaType.XML);
					//argumentValue.setForcefullInlineEditing(false);
				} else{
					wrapper.setEvaluator(MediaType.JSON);
					//argumentValue.setForcefullInlineEditing(true);
				}
			}
		});
		
/*		if (wrapper.isExpression()) {
			if (wrapper.getEvaluator() == MediaType.XML){
				argumentValue.setForcefullInlineEditing(false);
			} else if (wrapper.getEvaluator() == MediaType.JSON){
				argumentValue.setForcefullInlineEditing(true);
			}
		}*/
	}
	
	/**
	 * Utility method for binding an argument into the UI. Note that this
	 * method does not record any commands, it simply adds a new row into the
	 * table and associates the passed {@link PayloadFactoryArgument} to it.
	 * 
	 * @return {@link TableItem} which was introduced.
	 */
	private TableItem bindArgument(PayloadFactoryArgument argument) {
		TableItem item = new TableItem(tblArguments, SWT.NONE);
		ArgumentWrapper wrapper = new ArgumentWrapper(argument);
		wrapper.setArgumentExpression(EsbFactory.eINSTANCE.copyNamespacedProperty(argument.getArgumentExpression()));
		wrapper.setArgumentValue(argument.getArgumentValue());

		if (argument.getArgumentType() == PayloadFactoryArgumentType.EXPRESSION) {
			item.setText(new String[] { LITERAL_EXPRESSION,
							wrapper.getArgumentExpression().getPropertyValue(),
							argument.getEvaluator().toString()});
			wrapper.setEvaluator(argument.getEvaluator());
			wrapper.setExpression(true);
		} else {
			item.setText(new String[] { LITERAL_VALUE, wrapper.getArgumentValue(), "" });
			wrapper.setEvaluator(null);
			wrapper.setExpression(false);
		}
		
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
	private void unbindArgument(int itemIndex) {
		TableItem item = tblArguments.getItem(itemIndex);
		ArgumentWrapper wrapper = (ArgumentWrapper) item.getData();
		PayloadFactoryArgument argument = wrapper.getArgument();
		
		if (null != argument.eContainer()) {
			RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					mediator, EsbPackage.Literals.PAYLOAD_FACTORY_MEDIATOR__ARGS,
					argument);
			getResultCommand().append(removeCmd);
		}
		tblArguments.remove(tblArguments.indexOf(item));
	}
	
	@Override
	protected void okPressed() {
		for (TableItem item : tblArguments.getItems()) {
			ArgumentWrapper wrapper = (ArgumentWrapper) item.getData();
			PayloadFactoryArgument argument = wrapper.getArgument();
			
			// If the argument is a new one, add it to the model.
			if (null == argument.eContainer()) {
				AddCommand addCmd = new AddCommand(editingDomain,
						mediator, EsbPackage.Literals.PAYLOAD_FACTORY_MEDIATOR__ARGS,
						argument);
				getResultCommand().append(addCmd);
			}
			
			SetCommand setCmd = null;
			//set argument type if it has been changed i.e expression or value
			if ((argument.getArgumentType() == PayloadFactoryArgumentType.EXPRESSION) != wrapper.isExpression()) {
				setCmd = new SetCommand(
						editingDomain,
						argument,
						EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_TYPE,
						wrapper.isExpression()?PayloadFactoryArgumentType.EXPRESSION:PayloadFactoryArgumentType.VALUE );
				getResultCommand().append(setCmd);
			}
			
			if(wrapper.isExpression()){
				wrapper.setArgumentValue("default");
			} else{
				wrapper.getArgumentExpression().setPropertyValue("/default/expression");
			}
			
			if (wrapper.isExpression()) {
				setCmd = new SetCommand(
						editingDomain,
						argument,
						EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT__EVALUATOR,
						wrapper.getEvaluator());
				getResultCommand().append(setCmd);
			}
			
			if(!argument.getArgumentExpression().equals(wrapper.getArgumentExpression())){
				setCmd = new SetCommand(
						editingDomain,
						argument,
						EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_EXPRESSION,
						wrapper.getArgumentExpression() );
				getResultCommand().append(setCmd);
			}
			
			if(!argument.getArgumentValue().equals(wrapper.getArgumentValue())){
				setCmd = new SetCommand(
						editingDomain,
						argument,
						EsbPackage.Literals.PAYLOAD_FACTORY_ARGUMENT__ARGUMENT_VALUE,
						wrapper.getArgumentValue() );
				getResultCommand().append(setCmd);
			}
		}
		// Apply changes.
		if (getResultCommand().canExecute()) {
			editingDomain.getCommandStack().execute(getResultCommand());
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
	
	class ArgumentWrapper{
		
		public ArgumentWrapper(PayloadFactoryArgument argument) {
			this.argument = argument;
			this.evaluator = MediaType.XML;
		}
		public PayloadFactoryArgument getArgument() {
			return argument;
		}
		public void setArgument(PayloadFactoryArgument argument) {
			this.argument = argument;
		}
		public String getArgumentValue() {
			return argumentValue;
		}
		public void setArgumentValue(String argumentValue) {
			this.argumentValue = argumentValue;
		}
		public NamespacedProperty getArgumentExpression() {
			return argumentExpression;
		}
		public void setArgumentExpression(NamespacedProperty argumentExpression) {
			this.argumentExpression = argumentExpression;
		}
		public boolean isExpression() {
			return expression;
		}
		public void setExpression(boolean expression) {
			this.expression = expression;
		}
		public MediaType getEvaluator() {
			return evaluator;
		}
		public void setEvaluator(MediaType formatEvaluator) {
			this.evaluator = formatEvaluator;
		}
		
		private PayloadFactoryArgument argument; 
		private String argumentValue;
		private NamespacedProperty argumentExpression;
		private boolean expression;
		private MediaType evaluator;
	}
}
