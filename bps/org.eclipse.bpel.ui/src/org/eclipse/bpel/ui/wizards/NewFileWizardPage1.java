/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation
 *******************************************************************************/

package org.eclipse.bpel.ui.wizards;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Templates;
import org.eclipse.bpel.ui.Templates.Template;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.eclipse.wst.common.componentcore.ModuleCoreNature;

/**
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * 
 */

@SuppressWarnings("restriction")
public class NewFileWizardPage1 extends WizardPage {

	static final String EMPTY = ""; //$NON-NLS-1$

	/** last namespace used in creating a project, saved in dialog settings */
	static final String LAST_NAMESPACE_KEY = "last.namespace.used"; //$NON-NLS-1$

	/** Process name field */
	private Text processNameField;

	/** which namespace to use to create the process */
	Combo processNamespaceField;

	/** which template to use to create a process */
	Combo processTemplateField;

	/** Template description, in summary */
	Text templateDescription;

	/** option for creating an abstract process */
	Button processAbstractOptionButton;

	private Map<String, Object> mArgs = new HashMap<String, Object>(3);

	private String[] lastNS;
	private List<String> temNS;

	private Listener validateListner = new Listener() {
		public void handleEvent(Event event) {
			setPageComplete(validatePage());
		}
	};

	// constants
	private static final int SIZING_TEXT_FIELD_WIDTH = 250;

	/**
	 * Creates a new project creation wizard page.
	 * 
	 * @param pageName
	 *            the name of this page
	 */
	public NewFileWizardPage1(String pageName) {
		super(pageName);
		setPageComplete(false);

		setTitle(Messages.NewFileWizardPage1_2);
		setDescription(Messages.NewFileWizardPage1_3);

		setImageDescriptor(BPELUIPlugin.INSTANCE
				.getImageDescriptor(IBPELUIConstants.ICON_WIZARD_BANNER));
	}

	/**
	 * Method declared on IDialogPage.
	 * 
	 * @param parent
	 *            the parent composite that we must attach ourselves to
	 */

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());

		initializeDialogUnits(parent);

		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createProjectGroup(composite);

		setPageComplete(validatePage());

		// no errors on opening up the wizard
		setErrorMessage(null);
		setMessage(null);
		setControl(composite);

		// figure out the what needs to go
	}

	/**
	 * Creates the project name specification controls.
	 * 
	 * @param parent
	 *            the parent composite
	 */
	private final void createProjectGroup(Composite parent) {
		Group projectGroup = new Group(parent, SWT.NONE);
		projectGroup.setText(Messages.NewFileWizardPage1_4);
		projectGroup.setLayout(new GridLayout());
		projectGroup.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Composite fields = new Composite(projectGroup, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		fields.setLayout(layout);
		fields.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// new project label
		Label projectLabel = new Label(fields, SWT.NONE);
		projectLabel.setText(Messages.NewFileWizardPage1_5);
		projectLabel.setFont(parent.getFont());

		// new project name entry field
		processNameField = new Text(fields, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		processNameField.setLayoutData(data);
		processNameField.setFont(parent.getFont());

		processNameField.addListener(SWT.Modify, validateListner);

		// new project label
		Label namespaceLabel = new Label(fields, SWT.NONE);
		namespaceLabel.setText(Messages.NewFileWizardPage1_6);
		namespaceLabel.setFont(parent.getFont());

		// new project name entry field
		processNamespaceField = new Combo(fields, SWT.DROP_DOWN | SWT.SIMPLE);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		processNamespaceField.setLayoutData(data);
		processNamespaceField.setFont(parent.getFont());

		// add the namespace values
		processNamespaceField.setItems(getProcessNameSpaces());
		processNamespaceField.addListener(SWT.Modify, validateListner);

		String lastNamespace = null;
		if (lastNS != null) {
			if (lastNS.length > 0) {
				lastNamespace = lastNS[0];
			}
		}
		if (lastNamespace != null) {
			processNamespaceField.setText(lastNamespace);
		}

		// new project type
		Label typeLabel = new Label(fields, SWT.NONE);
		typeLabel.setText(Messages.NewFileWizardPage1_7);
		typeLabel.setFont(parent.getFont());

		// new project type selector
		processTemplateField = new Combo(fields, SWT.DROP_DOWN | SWT.SIMPLE
				| SWT.READ_ONLY);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		processTemplateField.setLayoutData(data);

		processTemplateField.addListener(SWT.Modify, new Listener() {

			public void handleEvent(Event event) {
				String val = processTemplateField.getText().trim();
				// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
				// https://jira.jboss.org/browse/JBIDE-7165
				mArgs.put(Templates.PROPERTY_NAME, val);
				Template template = BPELUIPlugin.INSTANCE.getTemplates()
						.getTemplateByName(val);
				if (template != null) {
					String txt = template.getDescription();
					templateDescription.setText(txt == null ? EMPTY : txt);
					// https://jira.jboss.org/browse/JBIDE-7165
					mArgs.put(Templates.PROPERTY_KEY, template.getKey());
				}

			}
		});

		templateDescription = new Text(projectGroup, SWT.READ_ONLY | SWT.WRAP
				| SWT.SCROLL_LINE | SWT.V_SCROLL);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		data.heightHint = 60;
		templateDescription.setLayoutData(data);
		templateDescription.setFont(parent.getFont());

		// Scan directories in the "templates" folder
		// and built up a list

		String templates[] = BPELUIPlugin.INSTANCE.getTemplates()
				.getTemplateNames();
		processTemplateField.setItems(templates);

		// Select the top one.
		if (templates.length > 0) {
			processTemplateField.select(0);
		}

		// add checkbox for abstract process option
		processAbstractOptionButton = new Button(projectGroup, SWT.CHECK);
		processAbstractOptionButton.setText(Messages.NewFileWizardPage1_9);
		processAbstractOptionButton.setFont(parent.getFont());
		processAbstractOptionButton
				.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						setPageComplete(validatePage());
					}
				});
	}

	private String[] getProcessNameSpaces() {
		// project specification group
		IDialogSettings settings = getWizard().getDialogSettings();
		String ns = settings.get(LAST_NAMESPACE_KEY);
		ArrayList<String> list = new ArrayList<String>();
		if (ns != null && !"".equals(ns)) {
			lastNS = ns.split(";");
			for (String str : lastNS) {
				list.add(str);
			}
		}
		temNS = new ArrayList<String>();
		for (String str : BPELUIPlugin.INSTANCE.getTemplates()
				.getNamespaceNames()) {
			temNS.add(str);
		}
		list.addAll(temNS);
		String[] a = new String[(lastNS == null ? 0 : lastNS.length)
				+ temNS.size()];
		return list.toArray(a);
	}

	/**
	 * Returns the current project name as entered by the user, or its
	 * anticipated initial value.
	 * 
	 * @return the project name, its anticipated initial value, or
	 *         <code>null</code> if no project name is known
	 */
	public String getProjectName() {
		return getProjectNameFieldValue();
	}

	/**
	 * Returns the value of the project name field with leading and trailing
	 * spaces removed.
	 * 
	 * @return the project name in the field
	 */
	private String getProjectNameFieldValue() {

		if (processNameField == null) {
			return EMPTY;
		}
		return processNameField.getText().trim();
	}

	/**
	 * Returns the current project name as entered by the user, or its
	 * anticipated initial value.
	 * 
	 * @return the project name, its anticipated initial value, or
	 *         <code>null</code> if no project name is known
	 */
	public String getProjectNamespace() {

		return getProjectNamespaceFieldValue();
	}

	/**
	 * Returns the value of the project name field with leading and trailing
	 * spaces removed.
	 * 
	 * @return the project name in the field
	 */
	private String getProjectNamespaceFieldValue() {
		if (processNameField == null) {
			return EMPTY;
		}
		return processNamespaceField.getText().trim();
	}

	/**
	 * Returns whether this page's controls currently all contain valid values.
	 * 
	 * @return <code>true</code> if all controls are valid, and
	 *         <code>false</code> if at least one is invalid
	 */
	protected boolean validatePage() {

		IWorkspace workspace = IDEWorkbenchPlugin.getPluginWorkspace();

		IDialogSettings settings = getWizard().getDialogSettings();

		String processName = processNameField.getText();

		if (processName.equals(EMPTY)) {
			setErrorMessage(null);
			setMessage(Messages.NewFileWizardPage1_8);
			return false;
		}

		IStatus nameStatus = workspace
				.validateName(processName, IResource.FILE);

		if (!nameStatus.isOK()) {
			setErrorMessage(nameStatus.getMessage());
			return false;
		}

		// Make sure that there are no spaces in the name
		if (processName.indexOf(" ") > -1) //$NON-NLS-1$
		{
			setErrorMessage(Messages.NewFileWizardPage1_10);
			return false;
		}

		setErrorMessage(null);
		setMessage(null);

		// https://issues.jboss.org/browse/JBIDE-8591
		NewFileWizard wiz = (NewFileWizard)getWizard();
		// https://issues.jboss.org/browse/JBIDE-8738
		IContainer container = wiz.getBPELContainer(); 
		if (container!=null) {
			if (!ModuleCoreNature.isFlexibleProject(container.getProject()))
				setMessage(Messages.NewFileWizard_Not_A_Faceted_Project, WizardPage.WARNING);
			
			if (container.findMember(processNameField.getText()+".bpel")!=null ) //$NON-NLS-1$
				setMessage(Messages.NewFileWizardPage1_12,WARNING);
		}

		String namespace = processNamespaceField.getText().trim();
		if (namespace.length() < 1) {
			setErrorMessage(Messages.NewFileWizardPage1_11);
			return false;
		}

		String bpelNamespace = (isAbstractOptionButtonChecked()) ? BPELConstants.NAMESPACE_ABSTRACT_2007
				: BPELConstants.NAMESPACE;

		// settings for next time the dialog is used.
		settings.put(LAST_NAMESPACE_KEY, addNSToDefault(namespace));

		// Template arguments
		mArgs.put("processName", processName); //$NON-NLS-1$
		mArgs.put("namespace", namespace); //$NON-NLS-1$
		mArgs.put("bpelNamespace", bpelNamespace); //$NON-NLS-1$
		mArgs.put("date", new Date()); //$NON-NLS-1$

		// set the default value of the wsdlpage
		setValuesForWSDLPage(processName);

		return true;
	}

	private void setValuesForWSDLPage(String processName) {
		WSDLCustomPage page = (WSDLCustomPage) this.getWizard().getPage(
				Messages.NewFileWizard_WSDLCustomPage_Name);
		if (page != null) {
			page.getServiceNameField().setText(processName);
			page.getPortNameField().setText(processName + "Port");
			page.getAddressField().setText(
					"http://localhost:8080/" + processName);
		}
		NewFileWizardPage2 page2 = (NewFileWizardPage2) this.getWizard().getPage(
				Messages.NewFileWizardPage2_Name);
		if (page2 != null) {
			page2.setProcessName(processName);
		}
	}

	public IWizardPage getNextPage() {
		if (processAbstractOptionButton.getSelection()) {
			return this.getWizard().getPage(Messages.NewFileWizardPage2_Name);
		}
		return super.getNextPage();
	}

	/**
	 * add the last namespace to the default namespace array
	 * 
	 * @param namespace
	 * @return
	 */
	private String addNSToDefault(String namespace) {
		StringBuffer ns = new StringBuffer();
		if (!"".equals(namespace) && !temNS.contains(namespace)) {
			ns.append(namespace).append(";");
			;
			if (lastNS != null) {
				for (int i = 0; i < lastNS.length; i++) {
					if (namespace.equals(lastNS[i])) {
						continue;
					} else {
						ns.append(lastNS[i]).append(";");
						if (i > 8) {
							break;
						}
					}
				}
			}
		} else {
			if (lastNS != null) {
				for (String str : lastNS) {
					ns.append(str).append(";");
				}
			}
		}
		return ns.toString();
	}

	/**
	 * @return true if Option for abstract process is checked
	 */
	private boolean isAbstractOptionButtonChecked() {
		return processAbstractOptionButton.getSelection();
	}

	/**
	 * see @DialogPage.setVisible(boolean)
	 * 
	 * @param visible
	 *            whether should be visible or not
	 * 
	 */

	
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			processNameField.setFocus();
			// https://issues.jboss.org/browse/JBIDE-8591
			validatePage();
		}
	}

	/**
	 * @return the actual selected template.
	 */

	public Template getSelectedTemplate() {
		String txt = processTemplateField.getText().trim();
		return BPELUIPlugin.INSTANCE.getTemplates().getTemplateByName(txt);
	}

	/**
	 * @return the arguments that need to be supplied to the template mechanism.
	 */

	public Map<String, Object> getArgs() {

		return mArgs;
	}
}
