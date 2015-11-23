package org.wso2.developerstudio.eclipse.artifact.axis2.ui.wizard;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.ui.wizards.NewTypeWizardPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;

public class Axis2ClassWizardPage extends  NewTypeWizardPage{

	  public Axis2ClassWizardPage(IWorkbench workbench,IStructuredSelection selection) {
			super(true, "Create new Axis2  class");
		}

		    public void init(IStructuredSelection selection) {
		    	setTitle("Create new Axis2 class");
		        IJavaElement jelem= getInitialJavaElement(selection);
		        initContainerPage(jelem);
		        initTypePage(jelem);
		        doStatusUpdate();
		    }

		    private void doStatusUpdate() {
		    	final String pkgName = getPackageText();
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
		    	
		        IStatus[] status= new IStatus[] {
		            fContainerStatus,
		            isEnclosingTypeSelected() ? fEnclosingTypeStatus : pkgStatus,
		            fTypeNameStatus,
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

		        // Create the standard input fields
		        createContainerControls(composite, nColumns);
		        createPackageControls(composite, nColumns);
		        createSeparator(composite, nColumns);
		        createTypeNameControls(composite, nColumns);
		        createSuperClassControls(composite, nColumns);
		        createSuperInterfacesControls(composite, nColumns);
		        createSeparator(composite, nColumns);

		       /* // Create the checkbox controlling whether we want stubs
		        fCreateStubs= new Button(composite, SWT.CHECK);
		        fCreateStubs.setText("Add sample webservice method to new class");
		        fCreateStubs.setSelection(true);
		        GridData gd= new GridData();
		        gd.horizontalSpan= nColumns;
		        fCreateStubs.setLayoutData(gd);*/

		        setControl(composite);
		        setSuperClass("java.lang.Object", true);
				
		    }
		    
		    

}
