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
import org.wso2.carbon.cep.core.mapping.input.property.TupleInputProperty;

import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPArtifactConstants;

public class InputTuplePropertyDialog extends TitleAreaDialog {

	public InputTuplePropertyDialog(Shell parentShell, boolean edit) {
		super(parentShell);
	}

	private Text txtName;
	private Text txtInputName;
	private Combo cmbType;
	private Combo cmbDataType;
	private String name = "";
	private String inputName = "";
	private String type = CEPArtifactConstants.WIZARD_OPTION_INTEGER;
	private String dataType = CEPArtifactConstants.WIZARD_OPTION_METADATA;
	private String[] propertyTypes = {
			CEPArtifactConstants.WIZARD_OPTION_INTEGER,
			CEPArtifactConstants.WIZARD_OPTION_DOUBLE,
			CEPArtifactConstants.WIZARD_OPTION_STRING,
			CEPArtifactConstants.WIZARD_OPTION_LONG };

	private String[] dataTypes = {
			CEPArtifactConstants.WIZARD_OPTION_CORRELATION,
			CEPArtifactConstants.WIZARD_OPTION_METADATA,
			CEPArtifactConstants.WIZARD_OPTION_PAYLOAD };

	private TupleInputProperty tupleProperty;

	@Override
	public void create() {
		super.create();
		setTitle("Input Tuple Property Configuration");
	}

	@Override
	public Control createDialogArea(Composite parent) {
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
		Label lbName = new Label(container, SWT.NULL);
		lbName.setText("Name");
		txtName = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		txtName.setText(name);
		txtName.setLayoutData(grData);

		Label lbInputName = new Label(container, SWT.NULL);
		lbInputName.setText("Input Name");
		txtInputName = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		txtInputName.setText(inputName);
		txtInputName.setLayoutData(grData);

		Label lbXpath = new Label(container, SWT.NULL);
		lbXpath.setText("Data Type");
		cmbDataType = new Combo(container, SWT.READ_ONLY);
		cmbDataType.setItems(dataTypes);
		cmbDataType.setText(dataType);
		grData = new GridData();
		grData.horizontalSpan = 2;
		cmbDataType.setLayoutData(grData);
		Label lbType = new Label(container, SWT.NULL);
		lbType.setText("Type");
		cmbType = new Combo(container, SWT.READ_ONLY);
		cmbType.setItems(propertyTypes);
		cmbType.setText(type);
		grData = new GridData();
		grData.horizontalSpan = 1;
		cmbType.setLayoutData(grData);
		scrolledContainer.setMinSize(container.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));
		container.layout();

		return super.createDialogArea(scrolledContainer);
	}

	private boolean finalizePage() {
		boolean ok = true;
		tupleProperty = new TupleInputProperty();
		tupleProperty.setName(txtName.getText().trim());
		tupleProperty.setInputDataType(cmbDataType.getText().trim());
		tupleProperty.setType(cmbType.getText().trim());
		tupleProperty.setInputName(txtInputName.getText().trim());

		if (txtName.getText().trim().equals("")) {
			ok = false;
		}
		return ok;
	}

	public TupleInputProperty getProperties() {
		return tupleProperty;
	}

	public void initialize(TupleInputProperty tupleProperty) {
		name = tupleProperty.getName();
		dataType = tupleProperty.getInputDataType();
		type = tupleProperty.getType();
		inputName = tupleProperty.getInputName();
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
