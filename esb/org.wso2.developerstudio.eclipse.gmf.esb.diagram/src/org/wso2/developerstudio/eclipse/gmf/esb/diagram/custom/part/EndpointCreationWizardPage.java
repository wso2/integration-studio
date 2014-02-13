package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.part;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class EndpointCreationWizardPage extends WizardPage implements Observer{

	private Composite container;
	private Combo endpointTypeCombo;
	public int selection;
	
	public EndpointCreationWizardPage(String pageName) {
		super(pageName);
	    setTitle("Select Endpoint type");
	    setDescription("Specify the requiered Endpoint type.");
	}
	
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		Label label = new Label(container, SWT.WRAP);
		label.setText("Select endpoint type");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(gd);
		label.setFont(parent.getFont());

		endpointTypeCombo = new Combo(container, SWT.SINGLE | SWT.BORDER);
		endpointTypeCombo.setLayoutData(gd);
		endpointTypeCombo.setItems(new String[] { "Default Endpoint",
				"Address Endpoint", "WSDL Endpoint", "Loadbalance Endpoint", "Failover Endpoint" });
		endpointTypeCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				selection = endpointTypeCombo.getSelectionIndex();
				setPageComplete(true);
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});

	    setControl(container);
	    setPageComplete(false);
	}
	
	public void update(Observable arg0, Object arg1) {
		
	}

}
