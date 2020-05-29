package org.wso2.developerstudio.eclipse.gmf.esb.presentation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.wso2.developerstudio.eclipse.gmf.esb.presentation.desc.parser.ConnectorRoot;

public class ConnectionParameterWizardPage extends WizardPage  {
	private static final String DIALOG_TITLE = "Connection Configurations";
    private static final String DIALOG_DESCRIPTION = "Configure your connector connection configurations";
    
    protected ReferenceGroup connectionParameters;
    private ConnectorRoot root;
    private HashMap<String, Control> elements;
    private Map<String, String> updateConfigMap;
	
	protected ConnectionParameterWizardPage(ConnectorRoot root) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        setDescription(DIALOG_DESCRIPTION);
        this.root = root;
    }
	
	protected ConnectionParameterWizardPage(ConnectorRoot root, Map<String, String> updateConfigMap) {
        super(DIALOG_TITLE);
        setTitle(DIALOG_TITLE);
        setDescription(DIALOG_DESCRIPTION);
        this.root = root;
        this.updateConfigMap = updateConfigMap;
    }
	
	@Override
    public void createControl(Composite parent) {	
		Composite composite = new Composite(parent, SWT.NO_BACKGROUND);
		GridLayout propertiesGroupLayout = new GridLayout();
		composite.setLayout(propertiesGroupLayout);
		this.connectionParameters = new ReferenceGroup(new ConnectionParameterRenderer());
		elements = this.connectionParameters.createControls(composite, root, updateConfigMap);
		setControl(composite);
	}
	
	public HashMap<String, Control> getGeneratedElements() {
		return this.elements;
	}
}
