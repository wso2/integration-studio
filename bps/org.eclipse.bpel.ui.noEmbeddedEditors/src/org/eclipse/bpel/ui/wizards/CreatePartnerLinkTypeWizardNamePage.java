/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.wizards;

import java.util.Iterator;

import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.wsdl.Definition;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 14, 2006
 * 
 */
public class CreatePartnerLinkTypeWizardNamePage extends WizardPage {

	Text partnerLinkTypeName;

	Text hintText;

	Definition fDefinitions;

	// constants
	static final int SIZING_TEXT_FIELD_WIDTH = 250;

	/**
	 * @param pageName
	 */
	protected CreatePartnerLinkTypeWizardNamePage(String pageName) {
		super(pageName);
		setPageComplete(false);

		setTitle(Messages.CreatePartnerLinkTypeWizardNamePage_0);
		setDescription(Messages.CreatePartnerLinkTypeWizardNamePage_1);
		setImageDescriptor(BPELUIPlugin.INSTANCE.getImageDescriptor(
				IBPELUIConstants.ICON_WIZARD_BANNER));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());

		initializeDialogUnits(parent);

		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		createPartnerLinkName(composite);

		setPageComplete(validatePage());

		// no errors on opening up the wizard
		setErrorMessage(null);
		setMessage(null);
		setControl(composite);

		// figure out the what needs to go

	}

	Composite createPartnerLinkName(Composite parent) {

		Composite fields = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		fields.setLayout(layout);
		fields.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		// new project label
		Label label = new Label(fields, SWT.NONE);
		label.setText(Messages.CreatePartnerLinkTypeWizardNamePage_2);
		label.setFont(parent.getFont());

		// new project name entry field
		partnerLinkTypeName = new Text(fields, SWT.BORDER);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		partnerLinkTypeName.setLayoutData(data);
		partnerLinkTypeName.setFont(parent.getFont());

		partnerLinkTypeName.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				setPageComplete(validatePage());
			}
		});

		hintText = new Text(parent, SWT.READ_ONLY | SWT.WRAP | SWT.SCROLL_LINE);
		data = new GridData(GridData.FILL_HORIZONTAL);
		data.widthHint = SIZING_TEXT_FIELD_WIDTH;
		data.heightHint = 80;
		hintText.setLayoutData(data);
		hintText.setFont(parent.getFont());

		hintText
				.setText(Messages.CreatePartnerLinkTypeWizardNamePage_3);

		return fields;
	}

	/**
	 * Returns whether this page's controls currently all contain valid values.
	 * 
	 * @return <code>true</code> if all controls are valid, and
	 *         <code>false</code> if at least one is invalid
	 */
	protected boolean validatePage() {

		String pltName = partnerLinkTypeName.getText();

		IInputValidator validator = BPELUtil.getNCNameValidator();
		String pltMsg = validator.isValid(pltName);

		if (pltMsg != null) {
			// all is OK
			setMessage(pltMsg,ERROR);
			return false;
		}
		if (fDefinitions != null) {
			// This is silly, it has to belong someplace else.
			Iterator it = fDefinitions.getEExtensibilityElements().iterator();
			while (it.hasNext()) {
				Object element = it.next();
				if (element instanceof PartnerLinkType) {
					PartnerLinkType plt = (PartnerLinkType) element;
					if (pltName.equals( plt.getName())) {
						setMessage(Messages.CreatePartnerLinkTypeWizardNamePage_4,ERROR);
						return false;
					}
				}
				
			}
		}
		setMessage(null,NONE);

		return true;
	}
	
	
	public String getPartnerLinkTypeName () {
		return partnerLinkTypeName.getText();
	}

	/**
	 * @param artifactsDefinition
	 */
	public void setDefinitions(Definition defn) {
		fDefinitions = defn;
		
	}

}
