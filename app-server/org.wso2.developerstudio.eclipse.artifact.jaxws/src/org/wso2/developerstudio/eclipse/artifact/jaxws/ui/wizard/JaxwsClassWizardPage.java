/*
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.jaxws.ui.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.wso2.developerstudio.eclipse.platform.ui.validator.CommonFieldValidator;
import org.eclipse.jdt.internal.ui.dialogs.StatusInfo;


@SuppressWarnings("restriction")
public class JaxwsClassWizardPage extends NewTypeWizardPage implements Listener {
	
	  public JaxwsClassWizardPage(IWorkbench workbench,IStructuredSelection selection) {
		super(true, "Create new JAX-WS class");
	}

	private Button fCreateStubs;
	private Label lblServiceInterfacePkg;
	private Text txtServiceInterfacePkg;
	private Label lblServiceInterfaceClass;
	private Text txtServiceInterfaceClass;
	private Button btnServiceInterfacePkg;
	private Button fCreateServiceInterface;
	private Label lblServiceInterface;
	private String ifClass;
	private String ifPkg;

	    public void init(IStructuredSelection selection) {
	    	setTitle("Create new JAX-WS class");
	        IJavaElement jelem= getInitialJavaElement(selection);
	        initContainerPage(jelem);
	        initTypePage(jelem);
	        doStatusUpdate();
	    } 

		private void doStatusUpdate() {
	    	final String pkgName = getPackageText();
	    	final String className = getTypeName();
	    	final String classFqn = pkgName + "." + className;
	    	final String ifPkgName = (txtServiceInterfacePkg!=null)?txtServiceInterfacePkg.getText():"";
	    	final String ifClassName = (txtServiceInterfaceClass!=null)?txtServiceInterfaceClass.getText():"";
	    	final String ifFqn = ifPkgName + "." + ifClassName;
	    	final boolean nameConflict = ifFqn.equals(classFqn);
	    	IStatus ifClassStatus = new StatusInfo(IStatus.ERROR, "Service interface class name is invalid");
	    	IStatus ifpkgStatus = new StatusInfo(IStatus.ERROR, "Service interface package name is invalid");
	    	IStatus okStatus = new StatusInfo(IStatus.OK, "");
	    	IStatus ifResource = new StatusInfo(IStatus.OK, "");
	    	IJavaProject javaProject = getJavaProject();
	    	try {
				IType findType = javaProject.findType(ifFqn);
				if(findType!=null && findType.exists()){
					ifResource = new StatusInfo(IStatus.ERROR, "Service interface type already exists");
				}
			} catch (Exception e) {
				/*safe to ignore*/
			}
	    	
	    	IStatus pkgStatus = new IStatus() {
				
				public boolean matches(int arg) {
					if(pkgName.trim().isEmpty()) {
						return true;
					}
					return fPackageStatus.matches(arg);
				}
				
				public boolean isOK() {
					if(pkgName.trim().isEmpty()) {
						return false;
					}
					return fPackageStatus.isOK();
				}
				
				public boolean isMultiStatus() {
					return fPackageStatus.isMultiStatus();
				}
				
				public int getSeverity() { 
					if(pkgName.trim().isEmpty()) {
						return 4;
					}
					return fPackageStatus.getSeverity();
				}
				
				public String getPlugin() {
					return fPackageStatus.getPlugin();
				}
				
				public String getMessage() {
					return fPackageStatus.getMessage();
				}
				
				public Throwable getException() {
					return fPackageStatus.getException();
				}
				
				public int getCode() {
					return fPackageStatus.getCode();
				}
				
				public IStatus[] getChildren() {
					return fPackageStatus.getChildren();
				}
			};
			
			IStatus classStatus = new IStatus(){

				public boolean matches(int arg) {
					if(nameConflict) {
						return true;
					}
					return fTypeNameStatus.matches(arg);
				}
				
				public boolean isOK() {
					if(nameConflict) {
						return false;
					}
					return fTypeNameStatus.isOK();
				}
				
				public boolean isMultiStatus() {
					return fTypeNameStatus.isMultiStatus();
				}
				
				public int getSeverity() { 
					if(nameConflict) {
						return 4;
					}
					return fTypeNameStatus.getSeverity();
				}
				
				public String getPlugin() {
					return fTypeNameStatus.getPlugin();
				}
				
				public String getMessage() {
					return (!nameConflict)?fTypeNameStatus.getMessage():"Service class name conflicts with interface class";
				}
				
				public Throwable getException() {
					return fTypeNameStatus.getException();
				}
				
				public int getCode() {
					return fTypeNameStatus.getCode();
				}
				
				public IStatus[] getChildren() {
					return fTypeNameStatus.getChildren();
				}
				
			};
			
	    	
	        IStatus[] status= new IStatus[] {
	            fContainerStatus,
	            isEnclosingTypeSelected() ? fEnclosingTypeStatus : pkgStatus,
	            classStatus,
	            ifResource,
	            (CommonFieldValidator.isJavaClassName(ifClassName) || !isCreateServiceInterface()) ? okStatus : ifClassStatus,
	            (CommonFieldValidator.isJavaPackageName(ifPkgName)  || !isCreateServiceInterface()) ? okStatus : ifpkgStatus
	        };
	        updateStatus(status);
	    }


	    protected void handleFieldChanged(String fieldName) {
	        super.handleFieldChanged(fieldName);

	        doStatusUpdate();
	    }
	 
	    public void createControl(Composite parent) {
	        initializeDialogUnits(parent);
	        Composite composite= new Composite(parent, SWT.NONE);
	        int nColumns= 4;
	        GridLayout layout= new GridLayout();
	        layout.numColumns= nColumns;
	        composite.setLayout(layout);
	        
	        GridData gd= new GridData();
	        gd.horizontalSpan= nColumns;

	        // Create the standard input fields
	        createContainerControls(composite, nColumns);
	        createPackageControls(composite, nColumns);
	        
	        createSeparator(composite, nColumns);

	        createTypeNameControls(composite, nColumns);
	        createSuperClassControls(composite, nColumns);
	        
	        createSeparator(composite, nColumns);
	        
	        // Create the checkbox controlling whether we want Service interface class
	        fCreateServiceInterface= new Button(composite, SWT.CHECK);
	        fCreateServiceInterface.setText("Create separate service interface class");
	        fCreateServiceInterface.setSelection(false);
	       
	        fCreateServiceInterface.setLayoutData(gd);
	        
	        lblServiceInterface = new Label(composite, SWT.NONE);
	        lblServiceInterface.setLayoutData(gd);
	        lblServiceInterface.setText("Service Interface");
	        lblServiceInterface.setEnabled(false);
	        
	    	lblServiceInterfacePkg = new Label(composite, SWT.NONE);
	    	lblServiceInterfacePkg.setText("Packa&ge");
	    	lblServiceInterfacePkg.setEnabled(false);
	    	txtServiceInterfacePkg = new Text(composite, SWT.BORDER);
	    	txtServiceInterfacePkg.setEnabled(false);
	    	GridData gridData= new GridData(GridData.FILL_HORIZONTAL);
	    	gridData.horizontalSpan= 2;
	    	txtServiceInterfacePkg.setLayoutData(gridData);
	    	txtServiceInterfacePkg.addListener(SWT.CHANGED, this);
	    	txtServiceInterfacePkg.setEnabled(false);
	    	
	    	btnServiceInterfacePkg = new Button(composite, SWT.NONE);
	    	btnServiceInterfacePkg.setText("B&rowse...");
	    	btnServiceInterfacePkg.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    	btnServiceInterfacePkg.addListener(SWT.MouseDown, this);
	    	btnServiceInterfacePkg.setEnabled(false);

	    	lblServiceInterfaceClass = new Label(composite, SWT.NONE);
	    	lblServiceInterfaceClass.setText("Nam&e");
	    	lblServiceInterfaceClass.setEnabled(false);
	    	txtServiceInterfaceClass = new Text(composite, SWT.BORDER);
	    	txtServiceInterfaceClass.setLayoutData(gridData);
	    	txtServiceInterfaceClass.addListener(SWT.CHANGED, this);
	    	txtServiceInterfaceClass.setEnabled(false);
	    	
	    	fCreateServiceInterface.addSelectionListener(new SelectionListener() {
				
				@Override
				public void widgetSelected(SelectionEvent event) {
					Button widget = (Button) event.widget;
					boolean selection = widget.getSelection();
					lblServiceInterface.setEnabled(selection);
					txtServiceInterfacePkg.setEnabled(selection);
					lblServiceInterfacePkg.setEnabled(selection);
					lblServiceInterfaceClass.setEnabled(selection);
					txtServiceInterfaceClass.setEnabled(selection);
					btnServiceInterfacePkg.setEnabled(selection);
					
				}
				
				@Override
				public void widgetDefaultSelected(SelectionEvent event) {
					widgetSelected(event);
					
				}
			});
	    	
	    	new Label(composite, SWT.NONE);
	        createSeparator(composite, nColumns);
	        
	        createSuperInterfacesControls(composite, nColumns);
	        createSeparator(composite, nColumns);

	        // Create the checkbox controlling whether we want stubs
	        fCreateStubs= new Button(composite, SWT.CHECK);
	        fCreateStubs.setText("Add sample webservice method to new class");
	        fCreateStubs.setSelection(false);
	       
	        fCreateStubs.setLayoutData(gd);

	        setControl(composite);
	        setSuperClass("java.lang.Object", true);
			
	    }

	    protected void createTypeMembers(IType newType, ImportsManager imports, IProgressMonitor monitor) throws CoreException {
	    
	    	createInheritedMethods(newType, false, true, imports, monitor);
	    	if (fCreateStubs.getSelection() && !fCreateServiceInterface.getSelection()) {
	    		StringBuffer buffer = new StringBuffer();
	    		buffer.append("/** This is a sample web service operation */\n");
	    		buffer.append("@" + imports.addImport("javax.jws.WebMethod") + "(operationName = \"hello\")\n");
	    		buffer.append("\npublic String hello(@" + imports.addImport("javax.jws.WebParam") + "(name = \"name\") String txt) {\n");
	    		buffer.append("return \"Hello \" + txt + \" !\";\n");
	    		buffer.append("}");
	            newType.createMethod(buffer.toString(), null, false, null);

	        }
	   }
	    
	    public boolean isCreateStubs(){
	    	return fCreateStubs.getSelection();
	    }
	    
	    public boolean isCreateServiceInterface(){
	    	if(fCreateServiceInterface!=null){
	    		return fCreateServiceInterface.getSelection();
	    	} 
	    	return false;
	    	
	    }

		@Override
		public void handleEvent(Event event) {
			if(btnServiceInterfacePkg== event.widget){
				IPackageFragment choosePackage = choosePackage();
				txtServiceInterfacePkg.setText(choosePackage.getElementName());
			} else if(txtServiceInterfaceClass== event.widget || txtServiceInterfacePkg== event.widget){
				setIfClass(txtServiceInterfaceClass.getText());
				setIfPkg(txtServiceInterfacePkg.getText());
				doStatusUpdate();
			} 
		}

		public void setIfClass(String ifClass) {
			this.ifClass = ifClass;
		}

		public String getIfClass() {
			return ifClass;
		}

		public void setIfPkg(String ifPkg) {
			this.ifPkg = ifPkg;
		}

		public String getIfPkg() {
			return ifPkg;
		}
	   
}
