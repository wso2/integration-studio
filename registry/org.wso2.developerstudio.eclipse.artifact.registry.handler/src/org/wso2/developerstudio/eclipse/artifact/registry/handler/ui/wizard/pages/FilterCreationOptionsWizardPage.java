package org.wso2.developerstudio.eclipse.artifact.registry.handler.ui.wizard.pages;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.wso2.developerstudio.eclipse.artifact.registry.handler.util.Constants;

public class FilterCreationOptionsWizardPage extends WizardPage{
	
	private String filterClassCreationMethod;
	
	public FilterCreationOptionsWizardPage(String pageName) {
		super(pageName);
		setDescription("Filter Class Creation Methods");
		setTitle(pageName);
	}

	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		
		Button existingFilterRadioButton = new Button(container, SWT.RADIO);
		existingFilterRadioButton.setSelection(true);
		setFilterClassCreationMethod(Constants.FROM_EXISTING_FILTER_CLASS);
		existingFilterRadioButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				setFilterClassCreationMethod(Constants.FROM_EXISTING_FILTER_CLASS);
				getWizard().canFinish();
				getWizard().getContainer().updateButtons();
			}
		});
		existingFilterRadioButton.setBounds(10, 10, 325, 22);
		existingFilterRadioButton.setText("Already Existing Filter Class");
		
		Button newFilterRadioButton = new Button(container, SWT.RADIO);
		newFilterRadioButton.setBounds(10, 40, 325, 22);
		newFilterRadioButton.setText("New Filter Class");
		
		newFilterRadioButton.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				setFilterClassCreationMethod(Constants.NEW_FILTER_CLASS);
				getWizard().canFinish();
				getWizard().getContainer().updateButtons();
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
	}
	
	public void setFilterClassCreationMethod(String filterClassCreationMethod) {
		this.filterClassCreationMethod = filterClassCreationMethod;
	}

	public String getFilterClassCreationMethod() {
		return filterClassCreationMethod;
	}
}
