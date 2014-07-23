/*******************************************************************************
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.runtimes.ui.wizards;

import org.eclipse.bpel.runtimes.IBPELModuleFacetConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wst.common.project.facet.ui.IFacetWizardPage;
import org.eclipse.wst.web.ui.internal.wizards.DataModelFacetInstallPage;

public class BPELFacetInstallPage extends DataModelFacetInstallPage implements
		IFacetWizardPage {

	private Label contentDirLabel;
	private Text contentDir;
	public BPELFacetInstallPage() {
		super("Test BPEL");
		setTitle("BPEL Title");
		setDescription("BPEL Description");
	}

	@Override
	protected String[] getValidationPropertyNames() {
		return new String[]{IBPELModuleFacetConstants.BPEL_CONTENT_FOLDER};
	}

	@Override
	protected Composite createTopLevelComposite(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		this.contentDirLabel = new Label(composite, SWT.NONE);
		this.contentDirLabel.setText("Content Folder");
		this.contentDirLabel.setLayoutData(new GridData());

		this.contentDir = new Text(composite, SWT.BORDER);
		this.contentDir.setLayoutData(gdhfill());
		this.contentDir.setData("label", this.contentDirLabel); //$NON-NLS-1$
		this.synchHelper.synchText(contentDir, IBPELModuleFacetConstants.BPEL_CONTENT_FOLDER, null);
		this.contentDir.setText(IBPELModuleFacetConstants.BPEL_CONTENT_DEFAULT_FOLDER);
		new Label(composite, SWT.NONE); // pad
		return composite;
	}

}
