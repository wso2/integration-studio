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

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.carbon.rule.common.Fact;
import org.wso2.carbon.rule.common.Input;
import org.wso2.carbon.rule.common.Output;
import org.wso2.carbon.rule.common.RuleService;
import org.wso2.developerstudio.eclipse.utils.jdt.JavaUtils;
import org.wso2.developerstudio.eclipse.utils.project.ProjectUtils;

public class FactsDialog extends Dialog{
	private Input input=new Input();
	private String factNameSpace;
	private String factName;
	private String factType;
	private int tableIndex;
	private boolean tableEdited=false;
	private Output output=new Output();
	private int outputTableIndex;
	private boolean outputtableEdited=false;
	private Text txtFactName;
	private Text txtFactNameSpace;
	private IProject project;

	public FactsDialog(Shell parentShell,RuleService ruleservice,IProject project) {
		super(parentShell);
		this.project=project;
	}

	@Override
	protected Control createDialogArea(Composite parent){
		final Combo factTypeCombo;
		Composite container;
		container=(Composite) super.createDialogArea(parent);
		container.getShell().setText("Facts Dialog");
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		
		Label typeLabel=new Label(container, SWT.NULL);
		typeLabel.setText("Fact Type");

		factTypeCombo = new Combo(container, SWT.DROP_DOWN |SWT.READ_ONLY);
		ArrayList<String> javaClass = new ArrayList<String>();
		ArrayList<String> pakagesList = new ArrayList<String>();
		ArrayList<IPackageFragment> packFrag= new ArrayList<IPackageFragment>();
		IJavaProject javaProject = JavaCore.create(project);
		try {
			IPackageFragment[] packages = javaProject.getPackageFragments();
			for (IPackageFragment iPackageFragment : packages) {
				iPackageFragment.getElementName();
				if (iPackageFragment.getKind() == IPackageFragmentRoot.K_SOURCE) { 
					if(iPackageFragment.hasChildren()){
						pakagesList.add(iPackageFragment.getElementName());
						packFrag.add(iPackageFragment);
						for (ICompilationUnit unit : iPackageFragment.getCompilationUnits()) {
							javaClass.add(unit.getElementName());
						}
					}
				}
			}
			String[] factsForCombo=new String[javaClass.size()];
			int i=0;
			for(int j=0;j<pakagesList.size();j++){
				for (ICompilationUnit unit : packFrag.get(j).getCompilationUnits()) {
					factsForCombo[i]=packFrag.get(j).getElementName()+"."+unit.getElementName().replace(".java", "");
					i++;
				}
			}
			
			factTypeCombo.setItems(factsForCombo);
			
			if (factsForCombo.length > 0) {
				factTypeCombo.setText(factsForCombo[0]);
			}
			
			factTypeCombo.setText(updateFactType());
			
			setFactType(factTypeCombo.getText().trim());
			factTypeCombo.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
			factTypeCombo.addSelectionListener(new SelectionListener() {
				@Override
				public void widgetSelected(SelectionEvent event) {
					setFactType(factTypeCombo.getText().trim());
				}
				@Override
				public void widgetDefaultSelected(SelectionEvent event) {

				}
			});
			
		} catch (JavaModelException e) {
			
			e.printStackTrace();
		}
		
		Label factNameLabel=new Label(container, SWT.NULL);
		factNameLabel.setText("Element Name");
		txtFactName = new Text(container, SWT.BORDER|SWT.NULL);
		txtFactName.setText(updateFactName());
		GridData factNameGridData=new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		factNameGridData.widthHint=200;
		txtFactName.setLayoutData(factNameGridData);

		txtFactName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				setFactName(txtFactName.getText().trim());
			}
		});

		Label factNameSpaceLabel=new Label(container, SWT.NULL);
		factNameSpaceLabel.setText("Element Namespace");
		txtFactNameSpace = new Text(container, SWT.BORDER|SWT.NULL);
		txtFactNameSpace.setText(updateFactNameSpace());
		GridData factNameSpaceGridData=new GridData(SWT.LEFT, SWT.CENTER, true,
				false, 1, 1);
		factNameSpaceGridData.widthHint=200;
		txtFactNameSpace.setLayoutData(factNameSpaceGridData);

		txtFactNameSpace.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				setNameSpace(txtFactNameSpace.getText().trim());
			}
		});

		
		return container;
	}

	@Override
	protected boolean isResizable(){
		return true;
	}

	public void updateOperationDialogWithOperaionInfo(){
		Fact fact=new Fact();
		fact.setType(getFactType());
		fact.setElementName(getFactName());
		fact.setNamespace(getNameSpace());
		input.addFact(fact);
	}

	private String updateFactNameSpace(){

		if(getNameSpace()!=null){
			return getNameSpace();
		}
		else return "";
	}

	private String updateFactName(){

		if(getFactName()!=null){
			return getFactName();
		}
		else return "";
	}

	private String updateFactType(){

		if(getFactType()!=null){
			return getFactType();
		}
		else return "";
	}

	public void editEditorOutputFactsTable(int tableindex,Output output){
		this.outputTableIndex=tableindex;
		this.outputtableEdited=true;
		this.output=output;
		Fact fact=output.getFacts().get(tableindex);
		setFactName(fact.getElementName());
		setFactType(fact.getType());
		setNameSpace(fact.getNamespace());
	}


	public void editEditorFactsTable(int tableindex,Input input){
		this.tableIndex=tableindex;
		this.tableEdited=true;
		this.input=input;
		Fact fact=input.getFacts().get(tableindex);

		setFactName(fact.getElementName());
		setFactType(fact.getType());
		setNameSpace(fact.getNamespace());
	}

	public void updateOperationDialogWithOutputInfo(){
		Fact fact=new Fact();

		fact.setType(getFactType());
		fact.setElementName(getFactName());
		fact.setNamespace(getNameSpace());
		output.addFact(fact);

	}

	public void connectOutput(Output output){
		this.output=output;
	}

	public void setNameSpace(String namespace){
		this.factNameSpace=namespace;
	}

	public void setFactName(String factname){
		this.factName=factname;
	}

	@Override
	protected void cancelPressed(){
		super.cancelPressed();
	}

	private void updateEditInputFactsTable(){
		Fact fact=new Fact();

		fact.setElementName(getFactName());
		fact.setNamespace(getNameSpace());
		fact.setType(getFactType());
		input.getFacts().set(tableIndex, fact);
	}

	private void updateEditOutputFactsTable(){
		Fact fact=new Fact();

		fact.setElementName(getFactName());
		fact.setNamespace(getNameSpace());
		fact.setType(getFactType());
		output.getFacts().set(outputTableIndex, fact);
	}

	@Override
	protected void okPressed() {

		if (tableEdited==false){
			updateOperationDialogWithOperaionInfo();
		}
		if(tableEdited==true){
			updateEditInputFactsTable();
		}
		if(outputtableEdited==false){
			updateOperationDialogWithOutputInfo();
		}
		if(outputtableEdited==true){
			updateEditOutputFactsTable();
		}

		super.okPressed();
	}

	public void setFactType(String facttype){
		this.factType=facttype;
	}

	public void connectInput(Input input){
		this.input=input;
	}

	public String getNameSpace(){
		return factNameSpace;
	}

	public String getFactName(){
		return factName;
	}

	public String getFactType(){
		return factType;
	}
}
