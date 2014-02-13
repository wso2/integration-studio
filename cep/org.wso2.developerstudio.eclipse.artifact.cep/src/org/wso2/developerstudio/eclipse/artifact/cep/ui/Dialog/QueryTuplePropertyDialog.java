/*
 * Copyright (c) 2012, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.artifact.cep.ui.Dialog;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import org.wso2.carbon.cep.core.mapping.output.property.TupleOutputProperty;

import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPArtifactConstants;

public class QueryTuplePropertyDialog extends TitleAreaDialog {

	private String name = "";
	private String type = CEPArtifactConstants.WIZARD_OPTION_INTEGER;
	private String valueOf = "";
	private Text txtName;
	private Text txtValueOf;
	private String title = "";
	private Combo cmbType;
	private String[] types = { CEPArtifactConstants.WIZARD_OPTION_DOUBLE,
			CEPArtifactConstants.WIZARD_OPTION_INTEGER,
			CEPArtifactConstants.WIZARD_OPTION_STRING,
			CEPArtifactConstants.WIZARD_OPTION_LONG };

	private TupleOutputProperty property;

	public QueryTuplePropertyDialog(Shell parentShell, String title) {
		super(parentShell);
		this.title = title;
	}

	@Override
	public void create() {
		super.create();
		setTitle(title);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		GridData grData = null;
		final ScrolledComposite scrolledContainer = new ScrolledComposite(
				parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.FILL);

		scrolledContainer.setExpandHorizontal(true);
		scrolledContainer.setExpandVertical(true);
		scrolledContainer.setAlwaysShowScrollBars(true);
		scrolledContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		final Composite container = new Composite(scrolledContainer, SWT.NONE);
		scrolledContainer.setContent(container);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		container.setLayout(layout);
		final Label lbName = new Label(container, SWT.NULL);
		lbName.setText("Name");

		txtName = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		txtName.setLayoutData(grData);
		txtName.setText(name);

		final Label lbFieldName = new Label(container, SWT.NULL);
		lbFieldName.setText("Value Of");

		txtValueOf = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;

		txtValueOf.setLayoutData(grData);
		txtValueOf.setText(valueOf);

		final Label lbFieldType = new Label(container, SWT.NULL);
		lbFieldType.setText("Type");

		cmbType = new Combo(container, SWT.READ_ONLY);
		grData = new GridData();

		cmbType.setItems(types);
		cmbType.setText(type);
		cmbType.setLayoutData(grData);

		scrolledContainer.setMinSize(container.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));
		container.layout();

		return super.createDialogArea(scrolledContainer);
	}

	private boolean finalizePage() {
		boolean ok = true;

		name = txtName.getText().trim();
		valueOf = txtValueOf.getText().trim();
		type = cmbType.getText().trim();
		property = new TupleOutputProperty(name, valueOf, type);
		if (txtName.getText().trim().equals("")) {
			ok = false;
		}
		return ok;
	}

	public void initializePage(TupleOutputProperty property) {
		name = property.getName();
		valueOf = property.getValueOf();
		type = property.getType();
	}

	public TupleOutputProperty getProperty() {
		return property;
	}

	@Override
	protected void okPressed() {
		if (finalizePage()) {
			super.okPressed();
		} else {
			super.cancelPressed();
		}
	}

}
