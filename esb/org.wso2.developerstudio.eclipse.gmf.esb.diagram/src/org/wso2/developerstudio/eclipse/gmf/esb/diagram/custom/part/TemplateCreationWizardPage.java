package org.wso2.developerstudio.eclipse.gmf.esb.diagram.custom.part;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class TemplateCreationWizardPage extends WizardPage implements Observer{
	  private Composite container;
	  public Button sequenceRadioButton;
	  public Button endpointRadioButton;
	  private Combo endpointTypeCombo;
	  public int selection;
	  private Label label;
	
	public TemplateCreationWizardPage(String pageName) {
	    super(pageName);
	    setTitle("Select Template type");
	    setDescription("Specify the requiered Template type.");
	}

	
	public void createControl(Composite parent) {
	    container = new Composite(parent, SWT.NULL);
	    GridLayout layout = new GridLayout();
	    container.setLayout(layout);
	    layout.numColumns = 1;
	    
	    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	    sequenceRadioButton=new Button(container, SWT.RADIO);
	    sequenceRadioButton.setText("Create a Sequence Template");
	    sequenceRadioButton.setLayoutData(gd);
	    sequenceRadioButton.addSelectionListener(new SelectionListener() {
			
			public void widgetSelected(SelectionEvent arg0) {
				setPageComplete(true);
				label.setEnabled(false);
				endpointTypeCombo.setEnabled(false);	
			}
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
	    
	    endpointRadioButton=new Button(container, SWT.RADIO);
	    endpointRadioButton.setLayoutData(gd);
	    endpointRadioButton.setText("Create a Endpoint Template");
	    endpointRadioButton.addSelectionListener(new SelectionListener() {
	
			public void widgetSelected(SelectionEvent arg0) {
				setPageComplete(true);
				label.setEnabled(true);
				endpointTypeCombo.setEnabled(true);				
			}
	
			public void widgetDefaultSelected(SelectionEvent arg0) {
				
			}
		});
	    
	    
	    Composite containerEPType = new Composite(container, SWT.NULL);
	    GridLayout layoutEPType = new GridLayout();
	    containerEPType.setLayout(layoutEPType);
	    layoutEPType.numColumns = 2;
		label = new Label(containerEPType, SWT.WRAP);
		label.setText("Select endpoint type");
		label.setLayoutData(gd);
		label.setFont(parent.getFont());
		label.setEnabled(false);

		endpointTypeCombo = new Combo(containerEPType, SWT.SINGLE | SWT.BORDER);
		endpointTypeCombo.setLayoutData(gd);
		endpointTypeCombo.setItems(new String[] { "Default Endpoint",
				"Address Endpoint", "WSDL Endpoint" });
		endpointTypeCombo.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				selection = endpointTypeCombo.getSelectionIndex();
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {

			}
		});
		endpointTypeCombo.select(0);
		endpointTypeCombo.setEnabled(false);

	    setControl(container);
	    setPageComplete(false);
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub		
	}
}
