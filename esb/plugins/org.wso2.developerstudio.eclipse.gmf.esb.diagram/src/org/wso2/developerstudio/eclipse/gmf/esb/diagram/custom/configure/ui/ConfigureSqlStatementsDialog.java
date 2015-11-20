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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.wso2.developerstudio.eclipse.gmf.esb.AbstractSqlExecutorMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.DBLookupMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbFactory;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterDataType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterDefinition;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlParameterValueType;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlResultMapping;
import org.wso2.developerstudio.eclipse.gmf.esb.SqlStatement;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;

/**
 * Configuration dialog for SQL statements of DBLookup and DBReport mediators
 *
 */
public class ConfigureSqlStatementsDialog extends Dialog {
	
	/**
	 * Domain model
	 */
	private AbstractSqlExecutorMediator sqlExecutorMediator;
	
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
	private Table tblStatements;
	private Text txtSQL;
	private Table tblParameters;
	private Table tblResults;
	private Button cmdAddStatement;
	private Button cmdRemoveStatement;
	private Group grpStatement;
	private Button cmdAddParameter;
	private Button cmdRemoveParameter;
	private Button cmdAddResult;
	private Button cmdRemoveResult;
	private Combo cmbParameterType;
	private Combo cmbPropertyType;
	private PropertyText propertyValue;
	private Text txtResultName;
	private Text txtResultColumn;
	
	private Listener updateListener;
	private boolean updateLock=false;
	private boolean resultsEnabled;
	
	/**
	 * Table editors
	 */
	private TableEditor parameterTypeEditor;
	private TableEditor propertyTypeEditor;
	private TableEditor propertyValueEditor;
	private TableEditor resultNameEditor;
	private TableEditor resultColumnEditor;
	
	private final static String LITERAL_VALUE = "Value";
	private final static String LITERAL_EXPRESSION = "Expression";
	

	/**
	 * Create the dialog.
	 * @param parentShell
	 * @param sqlExecutorMediator
	 * @param editingDomain
	 */
	public ConfigureSqlStatementsDialog(Shell parentShell,
			AbstractSqlExecutorMediator sqlExecutorMediator, TransactionalEditingDomain editingDomain) {
		super(parentShell);
		this.sqlExecutorMediator = sqlExecutorMediator;
		this.editingDomain = editingDomain;
		
		if (sqlExecutorMediator instanceof DBLookupMediator) {
			resultsEnabled = true;
		} else {
			resultsEnabled = false;
		}
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		
	updateListener = new Listener() {
			
			public void handleEvent(Event e) {
				if(tblStatements.getSelectionIndex()!=-1){
					TableItem item = tblStatements.getItem(tblStatements.getSelectionIndex());
					StatementWrapper wrapper = (StatementWrapper)item.getData();
					
					if (!updateLock) {
						updateLock=true;
						wrapper.setQueryString(txtSQL.getText());
						item.setText("Statement [" + wrapper.getQueryString() + "]");
						updateLock=false;
					}
		
				}
			}
		};
		
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FormLayout());
		
		Label lblSqlStatements = new Label(container, SWT.NONE);
		FormData fd_lblSqlStatements = new FormData();
		fd_lblSqlStatements.top = new FormAttachment(0, 10);
		fd_lblSqlStatements.left = new FormAttachment(0, 10);
		lblSqlStatements.setLayoutData(fd_lblSqlStatements);
		lblSqlStatements.setText("SQL Statements");
		
		tblStatements = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		tblStatements.setLinesVisible(true);
		FormData fd_tblStatements = new FormData();
		fd_tblStatements.bottom = new FormAttachment(lblSqlStatements, 115, SWT.BOTTOM);
		fd_tblStatements.top = new FormAttachment(lblSqlStatements, 6);
		fd_tblStatements.left = new FormAttachment(0, 10);
		fd_tblStatements.right = new FormAttachment(0, 461);
		tblStatements.setLayoutData(fd_tblStatements);
		tblStatements.setHeaderVisible(true);
		tblStatements.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateSelection();
			}
		});
		
		TableColumn tblclmnStatements = new TableColumn(tblStatements, SWT.NONE);
		tblclmnStatements.setWidth(445);
		tblclmnStatements.setText("Statements");
		
		cmdAddStatement = new Button(container, SWT.NONE);
		FormData fd_cmdAddStatement = new FormData();
		fd_cmdAddStatement.right = new FormAttachment(tblStatements, 92, SWT.RIGHT);
		fd_cmdAddStatement.top = new FormAttachment(0, 33);
		fd_cmdAddStatement.left = new FormAttachment(tblStatements, 6);
		cmdAddStatement.setLayoutData(fd_cmdAddStatement);
		cmdAddStatement.setText("Add");
		cmdAddStatement.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				SqlStatement sqlStatement = EsbFactory.eINSTANCE.createSqlStatement();
				sqlStatement.setQueryString("sql_query");
				sqlStatement.setResultsEnabled(resultsEnabled);
				StatementWrapper wrapper = new StatementWrapper(sqlStatement);
				TableItem item = bindStatement(wrapper);
				tblStatements.select(tblStatements.indexOf(item));
				updateSelection();
			}
		});
		
		cmdRemoveStatement = new Button(container, SWT.NONE);
		FormData fd_cmdRemoveStatement = new FormData();
		fd_cmdRemoveStatement.right = new FormAttachment(cmdAddStatement, 0, SWT.RIGHT);
		fd_cmdRemoveStatement.top = new FormAttachment(cmdAddStatement, 6);
		fd_cmdRemoveStatement.left = new FormAttachment(tblStatements, 6);
		cmdRemoveStatement.setLayoutData(fd_cmdRemoveStatement);
		cmdRemoveStatement.setText("Remove");
		cmdRemoveStatement.setEnabled(false);
		cmdRemoveStatement.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblStatements.getSelectionIndex();
				if (-1 != selectedIndex) {
					unbindStatement(selectedIndex);
					// Select the next available candidate for deletion.
					if (selectedIndex < tblStatements.getItemCount()) {
						tblStatements.select(selectedIndex);
					} else {
						tblStatements.select(selectedIndex - 1);
					}
					updateSelection();
				}
			}
		});
		
		grpStatement = new Group(container, SWT.NONE);
		grpStatement.setText("Statement configuration");
		grpStatement.setLayout(new GridLayout(3, false));
		FormData fd_grpStatement = new FormData();
		fd_grpStatement.bottom = new FormAttachment(tblStatements, 412, SWT.BOTTOM);
		fd_grpStatement.right = new FormAttachment(cmdAddStatement, 0, SWT.RIGHT);
		fd_grpStatement.top = new FormAttachment(tblStatements, 6);
		fd_grpStatement.left = new FormAttachment(0, 10);
		grpStatement.setLayoutData(fd_grpStatement);
		grpStatement.setEnabled(false);
		
		Label lblSql = new Label(grpStatement, SWT.NONE);
		lblSql.setText("SQL");
		
		txtSQL = new Text(grpStatement, SWT.BORDER);
		txtSQL.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		txtSQL.addListener(SWT.Modify, updateListener);
	/*	txtSQL.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent e) {
				e.doit=false;
				String text = ((Text) e.widget).getText();
				if(!text.trim().isEmpty()){
					e.doit=true;
				}
				
			}
		});*/
		
		Label lblStatem = new Label(grpStatement, SWT.NONE);
		lblStatem.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblStatem.setText("Parameters");
		
		tblParameters = new Table(grpStatement, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_Parameters = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 5);
		gd_Parameters.widthHint = 401;
		gd_Parameters.heightHint = 126;
		tblParameters.setLayoutData(gd_Parameters);
		tblParameters.setHeaderVisible(true);
		tblParameters.setLinesVisible(true);
		tblParameters.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (null != e.item) {
					if (e.item instanceof TableItem) {
						TableItem item = (TableItem) e.item;
						editParameter(item);
						cmdRemoveParameter.setEnabled(true);
					}
				} else{
					cmdRemoveParameter.setEnabled(false);
				}
			}
		});
		
		TableColumn clmnParametersParameterType = new TableColumn(tblParameters, SWT.NONE);
		clmnParametersParameterType.setMoveable(true);
		clmnParametersParameterType.setWidth(130);
		clmnParametersParameterType.setText("Parameter Type");
		
		TableColumn clmnParametersPropertyType = new TableColumn(tblParameters, SWT.NONE);
		clmnParametersPropertyType.setWidth(140);
		clmnParametersPropertyType.setText("Property Type");
		
		TableColumn clmnParametersValue = new TableColumn(tblParameters, SWT.NONE);
		clmnParametersValue.setMoveable(true);
		clmnParametersValue.setWidth(200);
		clmnParametersValue.setText("Value");
		
		cmdAddParameter = new Button(grpStatement, SWT.NONE);
		cmdAddParameter.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		cmdAddParameter.setText("Add");
		cmdAddParameter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int selectedIndex = tblStatements.getSelectionIndex();
				if (-1 != selectedIndex) {
					TableItem item = tblStatements.getItem(selectedIndex);
					StatementWrapper wrapper = (StatementWrapper) item.getData();
					SqlParameterDefinition parameter = EsbFactory.eINSTANCE.createSqlParameterDefinition();
					ParameterWrapper paramWrapper = new ParameterWrapper(parameter);
					paramWrapper.setValueExpression(EsbFactory.eINSTANCE.copyNamespacedProperty(parameter.getValueExpression()));
					paramWrapper.setValueLiteral(parameter.getValueLiteral());
					paramWrapper.setExpression(parameter.getValueType()==SqlParameterValueType.EXPRESSION);
					paramWrapper.setDataType(parameter.getDataType());
					bindParameter(paramWrapper);
					wrapper.getParameters().add(paramWrapper);
				}
				
			}
		});

		cmdRemoveParameter = new Button(grpStatement, SWT.NONE);
		cmdRemoveParameter.setText("Remove");
		cmdRemoveParameter.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 4));
		cmdRemoveParameter.setEnabled(false);
		cmdRemoveParameter.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblParameters.getSelectionIndex();
				if (-1 != selectedIndex) {
					unbindParameter(selectedIndex);
					// Select the next available candidate for deletion.
					if (selectedIndex < tblParameters.getItemCount()) {
						tblParameters.select(selectedIndex);
					} else {
						tblParameters.select(selectedIndex - 1);
					}
					initTableEditor(parameterTypeEditor,tblParameters);
					initTableEditor(propertyTypeEditor,tblParameters);
					initTableEditor(propertyValueEditor,tblParameters);
				}
				cmdRemoveParameter.setEnabled(tblParameters.getSelectionIndex()!=-1);
			}
		});
		
		Label lblResults = new Label(grpStatement, SWT.NONE);
		lblResults.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblResults.setText("Results");
		lblResults.setEnabled(resultsEnabled);
		
		tblResults = new Table(grpStatement, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_results = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 5);
		gd_results.widthHint = 401;
		gd_results.heightHint = 126;
		tblResults.setLayoutData(gd_results);
		tblResults.setHeaderVisible(true);
		tblResults.setLinesVisible(true);
		tblResults.setEnabled(resultsEnabled);
		tblResults.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (null != e.item) {
					if (e.item instanceof TableItem) {
						TableItem item = (TableItem) e.item;
						editResult(item);
						cmdRemoveResult.setEnabled(true);
					}
				} else{
					cmdRemoveResult.setEnabled(false);
				}
			}
		});
		
		TableColumn clmnResultsResultName = new TableColumn(tblResults, SWT.NONE);
		clmnResultsResultName.setMoveable(true);
		clmnResultsResultName.setWidth(130);
		clmnResultsResultName.setText("Result Name");
		
		TableColumn clmnResultsColumn = new TableColumn(tblResults, SWT.NONE);
		clmnResultsColumn.setWidth(325);
		clmnResultsColumn.setText("Column");
		
		cmdAddResult = new Button(grpStatement, SWT.NONE);
		cmdAddResult.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		cmdAddResult.setText("Add");
		cmdAddResult.setEnabled(resultsEnabled);
		cmdAddResult.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int selectedIndex = tblStatements.getSelectionIndex();
				if (-1 != selectedIndex) {
					TableItem item = tblStatements.getItem(selectedIndex);
					StatementWrapper wrapper = (StatementWrapper) item.getData();
					SqlResultMapping result = EsbFactory.eINSTANCE.createSqlResultMapping();
					result.setPropertyName("property_name");
					result.setColumnId("column_name_or_index");
					ResultWrapper resultWrapper = new ResultWrapper(result);
					resultWrapper.setPropertyName(result.getPropertyName());
					resultWrapper.setColumnId(result.getColumnId());
					bindResult(resultWrapper);
					wrapper.getResults().add(resultWrapper);
				}
				
			}
		});
		
		cmdRemoveResult = new Button(grpStatement, SWT.NONE);
		cmdRemoveResult.setText("Remove");
		cmdRemoveResult.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 4));
		cmdRemoveResult.setEnabled(false);
		cmdRemoveResult.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblResults.getSelectionIndex();
				if (-1 != selectedIndex) {
					unbindResult(selectedIndex);
					// Select the next available candidate for deletion.
					if (selectedIndex < tblResults.getItemCount()) {
						tblResults.select(selectedIndex);
					} else {
						tblResults.select(selectedIndex - 1);
					}
					initTableEditor(resultNameEditor,tblResults);
					initTableEditor(resultColumnEditor,tblResults);
				}
				cmdRemoveResult.setEnabled(tblResults.getSelectionIndex()!=-1);
			}
		});
		for(SqlStatement statement  :sqlExecutorMediator.getSqlStatements()){
			bindStatement(new StatementWrapper(statement));
		}
		

		return container;
	}
	
	private void updateSelection(){
		initTableEditor(parameterTypeEditor,tblParameters);
		initTableEditor(propertyTypeEditor,tblParameters);
		initTableEditor(propertyValueEditor,tblParameters);
		initTableEditor(resultNameEditor,tblResults);
		initTableEditor(resultColumnEditor,tblResults);
		cmdRemoveParameter.setEnabled(false);
		cmdRemoveResult.setEnabled(false);
		tblParameters.removeAll();
		tblResults.removeAll();
		if(tblStatements.getSelectionIndex()==-1){
			grpStatement.setEnabled(false);
			cmdRemoveStatement.setEnabled(false);
			txtSQL.setText("");
		} else{
			grpStatement.setEnabled(true);
			cmdRemoveStatement.setEnabled(true);
			TableItem item = tblStatements.getItem(tblStatements.getSelectionIndex());
			StatementWrapper wrapper = (StatementWrapper) item.getData();
			txtSQL.setText(wrapper.getQueryString());
			
			for(ParameterWrapper parmWrapper : wrapper.getParameters()){
				bindParameter(parmWrapper);
			}
			
			for(ResultWrapper resultWrapper : wrapper.getResults() ){
				bindResult(resultWrapper);
			}
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
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(585, 641);
	}
	
	/**
	 * {@inheritDoc}
	 */
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("SQL Statements Configuration");
	}
	
	private TableItem bindStatement(StatementWrapper wrapper){
		TableItem item = new TableItem(tblStatements, SWT.NONE);
		
		SqlStatement statement = wrapper.getStatement();
		item.setText("Statement [" + statement.getQueryString() + "]");
		wrapper.setQueryString(statement.getQueryString());
		
		for(SqlParameterDefinition parameter: statement.getParameters()){
			ParameterWrapper  paramWrapper = new ParameterWrapper(parameter);
			paramWrapper.setDataType(parameter.getDataType());
			paramWrapper.setValueExpression(EsbFactory.eINSTANCE.copyNamespacedProperty(parameter.getValueExpression()));
			paramWrapper.setValueLiteral(parameter.getValueLiteral());
			paramWrapper.setExpression(parameter.getValueType()==SqlParameterValueType.EXPRESSION);
			wrapper.getParameters().add(paramWrapper);
		}
		
		for(SqlResultMapping result: statement.getResults()){
			ResultWrapper resultWrapper = new ResultWrapper(result);
			resultWrapper.setPropertyName(result.getPropertyName());
			resultWrapper.setColumnId(result.getColumnId());
			wrapper.getResults().add(resultWrapper);
		}
		
		item.setData(wrapper);
		return item;
	}
	
	private void unbindStatement(int itemIndex) {
		TableItem item = tblStatements.getItem(itemIndex);
		StatementWrapper wrapper = (StatementWrapper) item.getData();
		SqlStatement statement = wrapper.getStatement();
		if (null != statement.eContainer()) {
			
			RemoveCommand removeCmd = new RemoveCommand(editingDomain,
					sqlExecutorMediator, EsbPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS,
					statement);
			getResultCommand().append(removeCmd);

		}
		tblStatements.remove(tblStatements.indexOf(item));

	}
	
	private TableItem bindParameter(ParameterWrapper wrapper){
		TableItem item = new TableItem(tblParameters, SWT.NONE);
		item.setText(0,wrapper.getDataType().getLiteral());
		if(wrapper.isExpression()){
			item.setText(1,LITERAL_EXPRESSION);
			item.setText(2,wrapper.getValueExpression().getPropertyValue());
		} else{
			item.setText(1,LITERAL_VALUE);
			item.setText(2,wrapper.getValueLiteral());
		}
		
		item.setData(wrapper);
		return item;
	}
	
	private void unbindParameter(int itemIndex) {
		if (tblStatements.getSelectionIndex() != -1) {
			TableItem statementItem = tblStatements.getItem(tblStatements.getSelectionIndex());
			StatementWrapper wrapper = (StatementWrapper) statementItem.getData();
			SqlStatement statement = wrapper.getStatement();
			TableItem item = tblParameters.getItem(itemIndex);
			ParameterWrapper parmWrapper = (ParameterWrapper) item.getData();
			SqlParameterDefinition parameter = parmWrapper.getParameter();
			if (null != parameter.eContainer()) {
				RemoveCommand removeCmd = new RemoveCommand(editingDomain, statement,
						EsbPackage.Literals.SQL_STATEMENT__PARAMETERS, parameter);
				getResultCommand().append(removeCmd);
			}
			wrapper.getParameters().remove(parmWrapper);
			tblParameters.remove(tblParameters.indexOf(item));
		}
	}
	
	private TableItem bindResult(ResultWrapper wrapper){
		TableItem item = new TableItem(tblResults, SWT.NONE);
		item.setText(0,wrapper.getPropertyName());
		item.setText(1,wrapper.getColumnId());
		item.setData(wrapper);
		return item;
	}
	
	private void unbindResult(int itemIndex) {
		if (tblStatements.getSelectionIndex() != -1) {
			TableItem statementItem = tblStatements.getItem(tblStatements.getSelectionIndex());
			StatementWrapper wrapper = (StatementWrapper) statementItem.getData();
			SqlStatement statement = wrapper.getStatement();
			TableItem item = tblResults.getItem(itemIndex);
			ResultWrapper resultWrapper = (ResultWrapper) item.getData();
			SqlResultMapping result = resultWrapper.getResult();
			if (null != result.eContainer()) {
				RemoveCommand removeCmd = new RemoveCommand(editingDomain, statement,
						EsbPackage.Literals.SQL_STATEMENT__RESULTS, result);
				getResultCommand().append(removeCmd);
			}
			wrapper.getResults().remove(resultWrapper);
			tblResults.remove(tblResults.indexOf(item));
		}
	}
	
	private void editParameter(final TableItem item) {
		final ParameterWrapper wrapper = (ParameterWrapper) item.getData();
		
		parameterTypeEditor = initTableEditor(parameterTypeEditor,
				item.getParent());
		cmbParameterType = new Combo(item.getParent(), SWT.READ_ONLY);
		List<SqlParameterDataType> values = SqlParameterDataType.VALUES;
		for (SqlParameterDataType sqlParameterDataType : values) {
			cmbParameterType.add(sqlParameterDataType.getLiteral());
		}
		cmbParameterType.setText(item.getText(0));
		parameterTypeEditor.setEditor(cmbParameterType, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		cmbParameterType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(0, cmbParameterType.getText());
				wrapper.setDataType(SqlParameterDataType.get(cmbParameterType.getText()));
			}
		});

		propertyTypeEditor = initTableEditor(propertyTypeEditor,
				item.getParent());
	
		cmbPropertyType = new Combo(item.getParent(), SWT.READ_ONLY);
		cmbPropertyType.setItems(new String[] { LITERAL_VALUE, LITERAL_EXPRESSION });
		cmbPropertyType.setText(item.getText(1));
		propertyTypeEditor.setEditor(cmbPropertyType, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		cmbPropertyType.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event evt) {
				item.setText(1, cmbPropertyType.getText());
				if(cmbPropertyType.getSelectionIndex()==1){
					wrapper.setExpression(true);
					item.setText(2,wrapper.getValueExpression().getPropertyValue());
				} else{
					wrapper.setExpression(false);
					item.setText(2,wrapper.getValueLiteral());
				}
			}
		});
		propertyValueEditor = initTableEditor(propertyValueEditor,
				item.getParent());
		
		propertyValue = new PropertyText(item.getParent(), SWT.NONE, cmbPropertyType);
		propertyValue.addProperties(wrapper.getValueLiteral(),wrapper.getValueExpression());
		propertyValueEditor.setEditor(propertyValue, item, 2);
		item.getParent().redraw();
		item.getParent().layout();
		propertyValue.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent e) {
				item.setText(2,propertyValue.getText());
				Object property = propertyValue.getProperty();
				if(property instanceof NamespacedProperty){
					wrapper.setValueExpression((NamespacedProperty)property);
				} else{
					wrapper.setValueLiteral(property.toString());
				}
			}
		});
	}
	
	private void editResult(final TableItem item) {
		final ResultWrapper wrapper = (ResultWrapper) item.getData();

		resultNameEditor = initTableEditor(resultNameEditor, item.getParent());
		txtResultName = new Text(item.getParent(), SWT.NONE);
		txtResultName.setText(item.getText(0));
		resultNameEditor.setEditor(txtResultName, item, 0);
		item.getParent().redraw();
		item.getParent().layout();
		txtResultName.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				item.setText(0,txtResultName.getText());
				wrapper.setPropertyName(txtResultName.getText());
			}
		});

		resultColumnEditor = initTableEditor(resultColumnEditor, item.getParent());
		txtResultColumn = new Text(item.getParent(), SWT.NONE);
		txtResultColumn.setText(item.getText(1));
		resultColumnEditor.setEditor(txtResultColumn, item, 1);
		item.getParent().redraw();
		item.getParent().layout();
		txtResultColumn.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				item.setText(1,txtResultColumn.getText());
				wrapper.setColumnId(txtResultColumn.getText());
			}
		});

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
	
	@Override
	protected void okPressed() {
		
		for (TableItem item : tblStatements.getItems()) {
			StatementWrapper wrapper = (StatementWrapper) item.getData();
			SqlStatement statement = wrapper.getStatement();
			AddCommand addCmd = null;
			
			if (null == statement.eContainer()) {
				addCmd = new AddCommand(editingDomain,
						sqlExecutorMediator, EsbPackage.Literals.ABSTRACT_SQL_EXECUTOR_MEDIATOR__SQL_STATEMENTS,
						statement);
				getResultCommand().append(addCmd);
			}
			
			SetCommand setCommand=null;
			if(!statement.getQueryString().equals(wrapper.getQueryString())){
				setCommand = new SetCommand(editingDomain,
						statement, EsbPackage.Literals.SQL_STATEMENT__QUERY_STRING,
						wrapper.getQueryString());
				getResultCommand().append(setCommand);
			}
			
			for(ParameterWrapper parmWrapper : wrapper.getParameters()){
				SqlParameterDefinition parameter = parmWrapper.getParameter();
				
				if(null==parameter.eContainer()){
					addCmd = new AddCommand(editingDomain,
							statement, EsbPackage.Literals.SQL_STATEMENT__PARAMETERS,
							parameter);
					getResultCommand().append(addCmd);
				}
				
				if ((parameter.getValueType() == SqlParameterValueType.EXPRESSION) != parmWrapper
						.isExpression()) {
					setCommand = new SetCommand(
							editingDomain,
							parameter,
							EsbPackage.Literals.SQL_PARAMETER_DEFINITION__VALUE_TYPE,
							parmWrapper.isExpression()?SqlParameterValueType.EXPRESSION:SqlParameterValueType.LITERAL );
					getResultCommand().append(setCommand);
				}
				
				if(parmWrapper.isExpression()){
					parmWrapper.setValueLiteral("default");
				} else{
					parmWrapper.getValueExpression().setPropertyValue("/default/expression");
				}
				
				if(!parameter.getValueExpression().equals(parmWrapper.getValueExpression())){
					setCommand = new SetCommand(
							editingDomain,
							parameter,
							EsbPackage.Literals.SQL_PARAMETER_DEFINITION__VALUE_EXPRESSION,
							parmWrapper.getValueExpression() );
					getResultCommand().append(setCommand);
				}
				
				if(!parameter.getValueLiteral().equals(parmWrapper.getValueLiteral())){
					setCommand = new SetCommand(
							editingDomain,
							parameter,
							EsbPackage.Literals.SQL_PARAMETER_DEFINITION__VALUE_LITERAL,
							parmWrapper.getValueLiteral() );
					getResultCommand().append(setCommand);
				}
				
				if(!parameter.getDataType().equals(parmWrapper.getDataType())){
					setCommand = new SetCommand(
							editingDomain,
							parameter,
							EsbPackage.Literals.SQL_PARAMETER_DEFINITION__DATA_TYPE,
							parmWrapper.getDataType() );
					getResultCommand().append(setCommand);
				}
			}
			
			for(ResultWrapper resultWrapper : wrapper.getResults() ){
				SqlResultMapping result = resultWrapper.getResult();
				
				if(null==result.eContainer()){
					addCmd = new AddCommand(editingDomain,
							statement, EsbPackage.Literals.SQL_STATEMENT__RESULTS,
							result);
					getResultCommand().append(addCmd);
				}
				
				if(!result.getPropertyName().equals(resultWrapper.getPropertyName())){
					setCommand = new SetCommand(
							editingDomain,
							result,
							EsbPackage.Literals.SQL_RESULT_MAPPING__PROPERTY_NAME,
							resultWrapper.getPropertyName() );
					getResultCommand().append(setCommand);
				}
				
				if(!result.getColumnId().equals(resultWrapper.getColumnId())){
					setCommand = new SetCommand(
							editingDomain,
							result,
							EsbPackage.Literals.SQL_RESULT_MAPPING__COLUMN_ID,
							resultWrapper.getColumnId());
					getResultCommand().append(setCommand);
				}
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
	
	/**
	 * Wrapper class for SqlStatement
	 *
	 */
	class StatementWrapper{
		private SqlStatement statement;
		private boolean resultsEnabled;
		private String queryString;
		private List<ResultWrapper> results;
		private List<ParameterWrapper>  parameters;
		
		public StatementWrapper(SqlStatement statement){
			this.statement = statement;
			parameters = new ArrayList<ParameterWrapper>();
			results = new ArrayList<ResultWrapper>();
		}

		public void setStatement(SqlStatement statement) {
			this.statement = statement;
		}

		public SqlStatement getStatement() {
			return statement;
		}

		public void setResultsEnabled(boolean resultsEnabled) {
			this.resultsEnabled = resultsEnabled;
		}

		public boolean isResultsEnabled() {
			return resultsEnabled;
		}
		
		public List<ResultWrapper> getResults() {
			return results;
		}

		public List<ParameterWrapper> getParameters() {
			return parameters;
		}

		public void setQueryString(String queryString) {
			this.queryString = queryString;
		}

		public String getQueryString() {
			return queryString;
		}
		
	}
	
	/**
	 * Wrapper class for SqlParameterDefinition
	 *
	 */
	class ParameterWrapper{
		private SqlParameterDefinition parameter;
		private String valueLiteral;
		private NamespacedProperty valueExpression;
		private SqlParameterDataType dataType;
		private boolean expression;
		
		public ParameterWrapper(SqlParameterDefinition parameter){
			this.parameter = parameter;
		}
		
		public SqlParameterDefinition getParameter() {
			return parameter;
		}
		public void setParameter(SqlParameterDefinition parameter) {
			this.parameter = parameter;
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
		public SqlParameterDataType getDataType() {
			return dataType;
		}
		public void setDataType(SqlParameterDataType dataType) {
			this.dataType = dataType;
		}
		public boolean isExpression() {
			return expression;
		}
		public void setExpression(boolean expression) {
			this.expression = expression;
		}

	}
	
	/**
	 * Wrapper class for SqlResultMapping
	 * 
	 */
	class ResultWrapper {
		private SqlResultMapping result;
		private String propertyName;
		private String columnId;
		
		public ResultWrapper(SqlResultMapping result){
			this.result = result;
		}
		
		public void setResult(SqlResultMapping result) {
			this.result = result;
		}
		public SqlResultMapping getResult() {
			return result;
		}
		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}
		public String getPropertyName() {
			return propertyName;
		}
		public void setColumnId(String columnId) {
			this.columnId = columnId;
		}
		public String getColumnId() {
			return columnId;
		}
	}
}
