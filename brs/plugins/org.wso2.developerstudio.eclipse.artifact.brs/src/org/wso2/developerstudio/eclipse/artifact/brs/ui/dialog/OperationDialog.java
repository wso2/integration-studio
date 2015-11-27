/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.wso2.developerstudio.eclipse.artifact.brs.ui.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.wso2.carbon.rule.common.Fact;
import org.wso2.carbon.rule.common.Input;
import org.wso2.carbon.rule.common.Operation;
import org.wso2.carbon.rule.common.Output;
import org.wso2.carbon.rule.common.RuleService;
import org.wso2.developerstudio.eclipse.artifact.brs.utils.RuleServiceArtifactConstants;

public class OperationDialog extends Dialog{
	private final RuleService ruleService;
	private List<Fact> inputFacts,outputFacts;
	private int tableIndex;
	private boolean tableEdited=false;
	private String operationName;
	private String wrapperName;
	private String nameSpace;
	private String outputWrapperName;
	private String outputNameSpace;
	private Input input=new Input();
	private Output output=new Output();
	private Table factTable;
	private TableViewer factviewer;
	private String factElememntname;
	private String factNameSpace;
	private String factType;
	private int factsTableIndex;
	private Table outputfactTable;
	private TableViewer outputfactviewer;
	private int outputFactsTableIndex;
	private IProject project;
	public OperationDialog(Shell parentShell,RuleService ruleservice,IProject project) {
		super(parentShell);
		this.ruleService=ruleservice;
		this.inputFacts = new ArrayList<Fact>();
		this.outputFacts=new ArrayList<Fact>();
		this.project=project;
	}

	@Override
	protected Control createDialogArea(Composite parent){
		Composite container;
		final Text txtOperationName, txtwrapperName,txtnameSpace,txtOutputwrapperName,txtOutputnameSpace;

		container = (Composite) super.createDialogArea(parent);
		container.getShell().setText("Operation Dialog");
		GridLayout dialogLayout=new GridLayout();
		dialogLayout.numColumns=2;
		container.setLayout(dialogLayout);

		Label operationNameLabel=new Label(container, SWT.NULL);
		operationNameLabel.setText("Operation name :");

		txtOperationName=new Text(container, SWT.BORDER|SWT.NULL);
		txtOperationName.setText(updateOperationName());
		GridData operationNameGridData=new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		operationNameGridData.widthHint=400;
		txtOperationName.setLayoutData(operationNameGridData);
		txtOperationName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				setOperationName(txtOperationName.getText().trim());
			}
		});

		Group inputgroup = new Group(container, SWT.NULL);
		inputgroup.setText("Input :");
		GridLayout groupLayout=new GridLayout();
		groupLayout.numColumns=2;

		inputgroup.setLayout(groupLayout);
		GridData inputGridData=new GridData();
		inputGridData.horizontalSpan=2;
		inputGridData.grabExcessHorizontalSpace=true;
		inputGridData.horizontalAlignment=GridData.FILL;
		inputGridData.verticalAlignment=GridData.FILL;
		inputgroup.setLayoutData(inputGridData);

		Label wrapperNameLabel=new Label(inputgroup, SWT.NULL);
		wrapperNameLabel.setText("Wrapper name");

		txtwrapperName=new Text(inputgroup, SWT.BORDER|SWT.NULL);
		txtwrapperName.setText(updateWrapperName());
		GridData wrapperNameGridData=new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		wrapperNameGridData.widthHint=400;
		txtwrapperName.setLayoutData(wrapperNameGridData);
		txtwrapperName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				setWrapperName(txtwrapperName.getText().trim());
			}
		});

		Label nameSpaceLabel=new Label(inputgroup, SWT.NULL);
		nameSpaceLabel.setText("Namespace");

		txtnameSpace=new Text(inputgroup, SWT.BORDER|SWT.NULL);
		txtnameSpace.setText(updateNameSpace());
		GridData nameSpaceGridData=new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		nameSpaceGridData.widthHint=400;

		txtnameSpace.setLayoutData(nameSpaceGridData);
		txtnameSpace.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				setNameSpace(txtnameSpace.getText().trim());
			}
		});

		Group inputFactsgroup = new Group(inputgroup, SWT.NULL);
		inputFactsgroup.setText("Facts");
		GridLayout factsgroupLayout=new GridLayout();
		factsgroupLayout.numColumns=2;

		inputFactsgroup.setLayout(groupLayout);
		GridData factsinputGridData=new GridData();
		factsinputGridData.horizontalSpan=2;
		factsinputGridData.grabExcessHorizontalSpace=true;
		factsinputGridData.grabExcessHorizontalSpace=true;
		factsinputGridData.horizontalAlignment=GridData.FILL;
		factsinputGridData.verticalAlignment=GridData.FILL;
		inputFactsgroup.setLayoutData(factsinputGridData);

		createFactsTable(inputFactsgroup);

		GridData addFactsButtonGridData=new GridData();
		addFactsButtonGridData.horizontalSpan=1;
		addFactsButtonGridData.verticalSpan=1;
		addFactsButtonGridData.widthHint=80;
		Button addFactsButton=new Button(inputFactsgroup, SWT.NONE);
		addFactsButton.setText(RuleServiceArtifactConstants.ADD_BUTTON_LABEL);
		addFactsButton.setLayoutData(addFactsButtonGridData);

		GridData editFactsButtonGridData=new GridData();
		editFactsButtonGridData.horizontalSpan=1;
		editFactsButtonGridData.verticalSpan=1;
		editFactsButtonGridData.widthHint=80;
		final Button editFactsButton=new Button(inputFactsgroup, SWT.NONE);
		editFactsButton.setText(RuleServiceArtifactConstants.EDIT_BUTTON_LABEL);
		editFactsButton.setLayoutData(editFactsButtonGridData);

		GridData deleteFactsButtonGridData=new GridData();
		deleteFactsButtonGridData.horizontalSpan=1;
		deleteFactsButtonGridData.verticalSpan=1;
		deleteFactsButtonGridData.widthHint=80;
		final Button deleteFactsButton=new Button(inputFactsgroup, SWT.NONE);
		deleteFactsButton.setText(RuleServiceArtifactConstants.DELETE_BUTTON_LABEL);
		deleteFactsButton.setLayoutData(deleteFactsButtonGridData);

		if(input.getFacts().isEmpty()){
			deleteFactsButton.setEnabled(false);
			editFactsButton.setEnabled(false);
		}
		else{
			deleteFactsButton.setEnabled(true);
			editFactsButton.setEnabled(true);
		}
		addFactsButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				FactsDialog fDialog=new FactsDialog(Display.getCurrent().getActiveShell(),ruleService,project);

				beforeUpdateFactsTable(fDialog);
				try{
				fDialog.open();
				}catch(ArrayIndexOutOfBoundsException e){
					MessageBox msgBox = new MessageBox(getShell(),
							SWT.ICON_INFORMATION);
					msgBox.setMessage("There are no facts defined yet. Please add new facts");
					msgBox.open();
				}
				updateFactsTable(fDialog);
				if(input.getFacts().isEmpty()){
					deleteFactsButton.setEnabled(false);
					editFactsButton.setEnabled(false);
				}
				else{
					deleteFactsButton.setEnabled(true);
					editFactsButton.setEnabled(true);
				}
			}
		});

		editFactsButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				FactsDialog fDialog=new FactsDialog(Display.getCurrent().getActiveShell(),ruleService,project);

				editFactsTable(fDialog);
				fDialog.open();
				updateEditFactsTable(fDialog);
			}
		});

		deleteFactsButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				deleteInputFactsTable();
				if(input.getFacts().isEmpty()){
					deleteFactsButton.setEnabled(false);
					editFactsButton.setEnabled(false);
				}
				else{
					deleteFactsButton.setEnabled(true);
					editFactsButton.setEnabled(true);
				}
			}
		});


		Group outputgroup = new Group(container, SWT.NULL);
		outputgroup.setText("Output :");
		GridLayout outputGroupLayout=new GridLayout();
		outputGroupLayout.numColumns=2;
		outputgroup.setLayout(outputGroupLayout);
		GridData outputGridData=new GridData();
		outputGridData.horizontalSpan=2;
		outputGridData.grabExcessHorizontalSpace=true;
		outputGridData.grabExcessVerticalSpace=true;
		outputGridData.horizontalAlignment=GridData.FILL;
		outputGridData.verticalAlignment=GridData.FILL;
		outputgroup.setLayoutData(outputGridData);

		Label outputwrapperNameLabel=new Label(outputgroup, SWT.NULL);
		outputwrapperNameLabel.setText("Wrapper name");

		txtOutputwrapperName=new Text(outputgroup, SWT.BORDER|SWT.NULL);
		txtOutputwrapperName.setText(updateOutputWrapperName());
		GridData outputwrapperNameGridData=new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		outputwrapperNameGridData.widthHint=400;
		txtOutputwrapperName.setLayoutData(outputwrapperNameGridData);
		txtOutputwrapperName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				setOutputWrapperName(txtOutputwrapperName.getText().trim());
			}
		});

		Label outputnameSpaceLabel=new Label(outputgroup, SWT.NULL);
		outputnameSpaceLabel.setText("Namespace");

		txtOutputnameSpace=new Text(outputgroup, SWT.BORDER|SWT.NULL);
		txtOutputnameSpace.setText(updateOutputNameSpace());
		GridData outputnameSpaceGridData=new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		outputnameSpaceGridData.widthHint=400;
		txtOutputnameSpace.setLayoutData(nameSpaceGridData);
		txtOutputnameSpace.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				setOutputnameSpace(txtOutputnameSpace.getText().trim());
			}
		});

		Group outputFactsgroup = new Group(outputgroup, SWT.NULL);
		outputFactsgroup.setText("Facts");
		GridLayout outputFactsGroupLayout=new GridLayout();
		outputFactsGroupLayout.numColumns=2;
		outputFactsgroup.setLayout(outputFactsGroupLayout);
		GridData factsoutputGridData=new GridData();
		factsoutputGridData.horizontalSpan=2;
		factsoutputGridData.grabExcessHorizontalSpace=true;
		factsoutputGridData.grabExcessVerticalSpace=true;
		factsoutputGridData.horizontalAlignment=GridData.FILL;
		factsoutputGridData.verticalAlignment=GridData.FILL;
		outputFactsgroup.setLayoutData(factsoutputGridData);

		createOutputFactsTable(outputFactsgroup);

		GridData addoutputFactsButtonGridData=new GridData();
		addoutputFactsButtonGridData.horizontalSpan=1;
		addoutputFactsButtonGridData.verticalSpan=1;
		addoutputFactsButtonGridData.widthHint=80;
		Button addoutputFactsButton=new Button(outputFactsgroup, SWT.NONE);
		addoutputFactsButton.setText(RuleServiceArtifactConstants.ADD_BUTTON_LABEL);
		addoutputFactsButton.setLayoutData(addoutputFactsButtonGridData);

		GridData editoutputFactsButtonGridData=new GridData();
		editoutputFactsButtonGridData.horizontalSpan=1;
		editoutputFactsButtonGridData.verticalSpan=1;
		editoutputFactsButtonGridData.widthHint=80;
		final Button editoutputFactsButton=new Button(outputFactsgroup, SWT.NONE);
		editoutputFactsButton.setText(RuleServiceArtifactConstants.EDIT_BUTTON_LABEL);
		editoutputFactsButton.setLayoutData(editoutputFactsButtonGridData);

		GridData deleteoutputFactsButtonGridData=new GridData();
		deleteoutputFactsButtonGridData.horizontalSpan=1;
		deleteFactsButtonGridData.verticalSpan=1;
		deleteoutputFactsButtonGridData.widthHint=80;
		final Button deleteoutputFactsButton=new Button(outputFactsgroup, SWT.NONE);
		deleteoutputFactsButton.setText(RuleServiceArtifactConstants.DELETE_BUTTON_LABEL);
		deleteoutputFactsButton.setLayoutData(deleteoutputFactsButtonGridData);
		if(output.getFacts().isEmpty()){
			deleteoutputFactsButton.setEnabled(false);
			editoutputFactsButton.setEnabled(false);
		}
		else{
			deleteoutputFactsButton.setEnabled(true);
			editoutputFactsButton.setEnabled(true);
		}
		addoutputFactsButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				FactsDialog fDialog=new FactsDialog(Display.getCurrent().getActiveShell(),ruleService,project);

				beforeUpdateOutputFactsTable(fDialog);
				try{
				fDialog.open();
			}catch(ArrayIndexOutOfBoundsException e){
				MessageBox msgBox = new MessageBox(getShell(),
						SWT.ICON_INFORMATION);
				msgBox.setMessage("There are no facts defined yet. Please add new facts");
				msgBox.open();
			}
				updateOutputFactsTable(fDialog);
				if(output.getFacts().isEmpty()){
					deleteoutputFactsButton.setEnabled(false);
					editoutputFactsButton.setEnabled(false);
				}
				else{
					deleteoutputFactsButton.setEnabled(true);
					editoutputFactsButton.setEnabled(true);
				}
			}
		});

		editoutputFactsButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				FactsDialog fDialog=new FactsDialog(Display.getCurrent().getActiveShell(),ruleService,project);

				editOutputFactsTable(fDialog);
				fDialog.open();
				updateEditOutputFactsTable(fDialog);
			}
		});

		deleteoutputFactsButton.addListener(SWT.MouseDown, new Listener() {

			@Override
			public void handleEvent(Event arg0) {
				deleteOutputFactsTable();
				if(output.getFacts().isEmpty()){
					deleteoutputFactsButton.setEnabled(false);
					editoutputFactsButton.setEnabled(false);
				}
				else{
					deleteoutputFactsButton.setEnabled(true);
					editoutputFactsButton.setEnabled(true);
				}
			}
		});

		setDialogLocation();

		return container;
	}

	private void setDialogLocation() {
		Rectangle monitorArea = getShell().getDisplay().getPrimaryMonitor()
		.getBounds();
		Rectangle shellArea = getShell().getBounds();
		int x = monitorArea.x + (monitorArea.width - shellArea.width) / 2;
		int y = monitorArea.y + (monitorArea.height - shellArea.height) / 2;

		getShell().setLocation(x, y);
	}

	private void deleteOutputFactsTable(){
		int tableIndex;

		tableIndex=outputfactTable.getSelectionIndex();
		output.getFacts().remove(tableIndex);
		outputfactviewer.setInput(output.getFacts().toArray());
		outputfactviewer.refresh();
	}

	private void updateEditOutputFactsTable(FactsDialog fdialog){
		outputfactviewer.setInput(output.getFacts().toArray());
		outputfactviewer.refresh();
	}


	private void editOutputFactsTable(FactsDialog fdialog){
		outputFactsTableIndex=outputfactTable.getSelectionIndex();
		fdialog.editEditorOutputFactsTable(outputFactsTableIndex,output);
	}

	private void updateOutputFactsTable(FactsDialog fdialog){
		outputfactviewer.setInput(output.getFacts().toArray());
		setOutputFact(output.getFacts());
		outputfactviewer.refresh();
	}

	private void setOutputFact(List<Fact> facts){
		this.outputFacts=facts;
	}

	private void beforeUpdateOutputFactsTable(FactsDialog fdialog){
		output.setWrapperElementName(getOutputWrapperName());
		output.setNameSpace(getOutputNameSpace());
		fdialog.connectOutput(output);
	}

	public void createOutputFactsTable(Composite composite){
		final Table table=new Table(composite,   SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER| SWT.VIRTUAL);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		outputfactTable=table;
		outputfactviewer =new TableViewer(table);
		table.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 3));
		createFactTableColumns(outputfactviewer);
		outputfactviewer.setContentProvider(new ArrayContentProvider());
		outputfactviewer.setInput(output.getFacts().toArray());
		table.setLinesVisible(true);
		table.setItemCount(5);
	}

	private String updateOutputNameSpace(){

		if(getOutputNameSpace()!=null){
			return getOutputNameSpace();
		}
		else return "";
	}

	public String getOutputNameSpace(){
		return outputNameSpace;
	}

	private String updateOutputWrapperName(){

		if(getOutputWrapperName()!=null){
			return getOutputWrapperName();
		}
		else return "";
	}

	public String getOutputWrapperName(){
		return outputWrapperName;
	}

	private void deleteInputFactsTable(){
		int tableIndex;

		tableIndex=factTable.getSelectionIndex();
		input.getFacts().remove(tableIndex);
		factviewer.setInput(input.getFacts().toArray());
		factviewer.refresh();
	}

	private void updateEditFactsTable(FactsDialog fdialog){
		factviewer.setInput(input.getFacts().toArray());
		factviewer.refresh();
	}

	private void editFactsTable(FactsDialog fdialog){
		factsTableIndex=factTable.getSelectionIndex();
		fdialog.editEditorFactsTable(factsTableIndex,input);
	}


	@Override
	protected boolean isResizable(){
		return true;
	}

	public void setFactNameSpace(FactsDialog fdialog){
		this.factNameSpace=fdialog.getNameSpace();
	}

	public void setFactElemntName(FactsDialog fdialog){
		this.factElememntname=fdialog.getFactName();
	}

	public String getFactNameSpace(){
		return factNameSpace;
	}

	public String getFactElemntName(){
		return factElememntname;
	}

	public void setFactType(FactsDialog fdialog){
		this.factType=fdialog.getFactType();
	}

	public String getFactType(){
		return factType;
	}

	private void updateFactsTable(FactsDialog fdialog){
		factviewer.setInput(input.getFacts().toArray());
		setFact(input.getFacts());
		factviewer.refresh();
	}


	private void setFact(List<Fact> facts){
		this.inputFacts=facts;
	}

	private void beforeUpdateFactsTable(FactsDialog fdialog){
		input.setWrapperElementName(getWrapperName());
		input.setNameSpace(getNameSpace());
		fdialog.connectInput(input);
	}

	public void editEditorOperationTable(int tableindex){
		this.tableIndex=tableindex;
		this.tableEdited=true;
		Operation operation=ruleService.getOperations().get(tableindex);
		setOperationName(operation.getName());
		setWrapperName(operation.getInput().getWrapperElementName());
		setNameSpace(operation.getInput().getNameSpace());
		setOutputWrapperName(operation.getOutput().getWrapperElementName());
		setOutputnameSpace(operation.getOutput().getNameSpace());
		input=operation.getInput();
		output=operation.getOutput();
	}

	public void createFactsTable(Composite composite){
		final Table table=new Table(composite,   SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER| SWT.VIRTUAL);

		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		factTable=table;
		factviewer =new TableViewer(table);
		table.setLayoutData(new GridData(SWT.NONE, SWT.NONE, false, false, 1, 3));
		createFactTableColumns(factviewer);
		factviewer.setContentProvider(new ArrayContentProvider());
		factviewer.setInput(input.getFacts().toArray());
		table.setItemCount(5);
	}

	private void createFactTableColumns(TableViewer factviewer){

		TableViewerColumn typeColumn=new TableViewerColumn(factviewer, SWT.NONE, 0);
		typeColumn.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element){

				Fact fact=(Fact) element;
				if(fact!=null){
					return fact.getType();
				}
				else return "";
			}
		});
		typeColumn.getColumn().setWidth(200);
		typeColumn.getColumn().setText("Fact Type");
		
		TableViewerColumn nameColumn=new TableViewerColumn(factviewer, SWT.NONE, 1);
		nameColumn.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element){
				Fact fact=(Fact) element;
				if(fact!=null){
					return fact.getElementName();
				}
				else return "";
			}
		});
		nameColumn.getColumn().setWidth(200);
		nameColumn.getColumn().setText("Element Name");

		TableViewerColumn nameSpaceColumn=new TableViewerColumn(factviewer, SWT.NONE, 2);
		nameSpaceColumn.setLabelProvider(new ColumnLabelProvider(){
			@Override
			public String getText(Object element){
				Fact fact=(Fact) element;
				if(fact!=null){
					return fact.getNamespace();
				}
				else return "";
			}
		});
		nameSpaceColumn.getColumn().setWidth(200);
		nameSpaceColumn.getColumn().setText("Element Namespace");

		

	}

	private String updateNameSpace(){

		if(getNameSpace()!=null){
			return getNameSpace();
		}
		else return "";
	}

	public String getNameSpace(){
		return nameSpace;
	}

	private String updateOperationName(){

		if(getOperationName()!=null){
			return getOperationName();
		}
		else return "";
	}

	private String updateWrapperName(){

		if(getWrapperName()!=null){
			return getWrapperName();
		}
		else return "";
	}

	public String getWrapperName(){
		return wrapperName;
	}

	public String getOperationName(){
		return operationName;

	}

	public void setOperationName(String operationname){
		this.operationName=operationname;
	}

	public void setWrapperName(String wrappername){
		this.wrapperName=wrappername;
	}

	public void setNameSpace(String namespace){
		this.nameSpace=namespace;
	}

	public void setOutputWrapperName(String outputwrappername){
		this.outputWrapperName=outputwrappername;
	}

	public void setOutputnameSpace(String outputnamespace){
		this.outputNameSpace=outputnamespace;
	}

	public void updateEditorWithOperaionInfo(){
		Operation operation=new Operation();

		operation.setName(getOperationName());
		operation.setInput(input);
		operation.getInput().setFacts(getInputFacts());
		operation.setOutput(output);
		operation.getOutput().setFacts(getOututFacts());
		ruleService.getOperations().add(operation);
	}

	public List<Fact> getInputFacts(){
		return inputFacts;
	}

	public List<Fact> getOututFacts(){
		return outputFacts;
	}

	@Override
	protected void cancelPressed(){
		super.cancelPressed();
	}

	@Override
	protected void okPressed() {

		if(tableEdited==true){
			updateEditOerationTable();
		}
		else{
			updateEditorWithOperaionInfo();
		}

		super.okPressed();
	}

	private void updateEditOerationTable(){
		Operation operation=new Operation();

		operation.setName(getOperationName());
		operation.getInput().setWrapperElementName(getWrapperName());
		operation.getInput().setNameSpace(getNameSpace());
		operation.getOutput().setWrapperElementName(getOutputWrapperName());
		operation.getOutput().setNameSpace(getOutputNameSpace());
		operation.getInput().setFacts(input.getFacts());
		operation.getOutput().setFacts(output.getFacts());
		ruleService.getOperations().set(tableIndex, operation);
	}

	public void addOutputfacts(Fact fact){
		this.outputFacts.add(fact);
	}
}
