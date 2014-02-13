package org.wso2.developerstudio.eclipse.artifact.axis2.ui.wizard;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.wso2.developerstudio.eclipse.artifact.axis2.model.DataModel;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class Axis2ImportWizardPage extends WizardPage {
	private Text text;
    private DataModel model;
    private Axis2ConfigurationPage configpage;
	/**
	 * Create the wizard.
	 */
	public Axis2ImportWizardPage(DataModel model, Axis2ConfigurationPage configpage) {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
		this.model = model;
		this.configpage = configpage;
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
        final Shell shell = container.getShell();
		setControl(container);
		container.setLayout(new GridLayout(3, false));
		
		Label lblWsdl = new Label(container, SWT.NONE);
		lblWsdl.setAlignment(SWT.CENTER);
		GridData gd_lblWsdl = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblWsdl.widthHint = 92;
		lblWsdl.setLayoutData(gd_lblWsdl);
		lblWsdl.setText("WSDL");
		
		text = new Text(container, SWT.BORDER);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 388;
		text.setLayoutData(gd_text);
		
		Button btnNewButton = new Button(container, SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 74;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell, SWT.OPEN);
				 	fd.setText("Open");
			        String[] filterExt = { "*.wsdl" };
			        fd.setFilterExtensions(filterExt);
			        fd.open();
			        String url = fd.getFilterPath() +"/"+ fd.getFileName();
			        text.setText(url);
			        model.setWsdlURI(url);
			        model.setGenerateServerSideCode(true);
			      
			}
		});
		btnNewButton.setText("Brows");
	}

	
	public IWizardPage getNextPage() {
	    configpage.populateParamsFromWSDL();
		return super.getNextPage();
	}
	
}
