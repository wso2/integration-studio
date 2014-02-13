package org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.model.RegistryHandlerModel;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.Constants;

public class NewHandlerClassWizardPage extends WizardPage{
	private Text packageNametext;
	private Text classNametext;
	
	private String packageName;
	private String className;
	private RegistryHandlerModel regModel;

	public NewHandlerClassWizardPage(String pageName, RegistryHandlerModel model) {
		super(pageName);
		setDescription("Create a New Handler Class");
		setTitle(pageName);
		this.regModel = model;
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		
		Label lblPackageName = new Label(container, SWT.NONE);
		lblPackageName.setBounds(10, 20, 100, 20);
		lblPackageName.setText("Package Name");
		
		packageNametext = new Text(container, SWT.BORDER);
		packageNametext.setBounds(116, 15, 435, 23);
		
		Label lblHandlerClass = new Label(container, SWT.NONE);
		lblHandlerClass.setText("Handler Class");
		lblHandlerClass.setBounds(10, 64, 100, 20);
		
		classNametext = new Text(container, SWT.BORDER);
		classNametext.setBounds(116, 59, 435, 23);
		
		packageNametext.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				setPackageName(packageNametext.getText());
				validate();
			}
		});
		
		classNametext.addModifyListener(new ModifyListener() {
			
			public void modifyText(ModifyEvent arg0) {
				setClassName(classNametext.getText());
				validate();
			}
		});
		
		if(regModel.getHandlerClassSeletionMethod().equals(Constants.NEW_HANDLER_CLASS_TEXT)){
			validate();
		}
		
		
	}
	
	public void validate(){
		if(packageNametext.getText() == null || packageNametext.getText().equals("")){
			setErrorMessage("Package name cannot be empty");
			setPageComplete(false);
		} else if (!packageNametext.getText().matches(
				"([a-zA-Z_$][a-zA-Z\\d_$]*\\.)*[a-zA-Z_$][a-zA-Z\\d_$]*")) {
			setErrorMessage("Package name is invalid");
			setPageComplete(false);
		} else if(classNametext.getText() == null || classNametext.getText().equals("")){
			setErrorMessage("Class name cannot be empty");
			setPageComplete(false);
		} else if (!classNametext.getText()
				.matches("^[a-zA-Z_$][a-zA-Z\\d_$]*")) {
			setErrorMessage("Class name is invalid");
			setPageComplete(false);
		} else if(!packageNametext.getText().equals("") && !classNametext.getText().equals("")){
			setErrorMessage(null);
			setPageComplete(true);
		}
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassName() {
		return className;
	}
}
