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
import org.wso2.carbon.cep.core.mapping.input.property.XMLInputProperty;

import org.wso2.developerstudio.eclipse.artifact.cep.utils.CEPArtifactConstants;

public class InputPropertyDialog extends TitleAreaDialog {
	private Text proName;
	private Text proXPath;
	private Combo proXType;
	private String name = "";
	private String xpath = "";
	private String type = CEPArtifactConstants.WIZARD_OPTION_INTEGER;
	private String[] propertyTypes = {
			CEPArtifactConstants.WIZARD_OPTION_INTEGER,
			CEPArtifactConstants.WIZARD_OPTION_DOUBLE,
			CEPArtifactConstants.WIZARD_OPTION_STRING,
			CEPArtifactConstants.WIZARD_OPTION_LONG };
	private XMLInputProperty xmlProperty;

	protected InputPropertyDialog(Shell parentShell, boolean edit) {
		super(parentShell);

	}

	@Override
	public void create() {
		super.create();
		setTitle("Input Property Configuration");
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
		proName = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		proName.setText(name);
		proName.setLayoutData(grData);
		Label lbXpath = new Label(container, SWT.NULL);
		lbXpath.setText("Xpath");
		proXPath = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		proXPath.setLayoutData(grData);
		proXPath.setText(xpath);
		Label lbType = new Label(container, SWT.NULL);
		lbType.setText("Type");
		proXType = new Combo(container, SWT.READ_ONLY);
		proXType.setItems(propertyTypes);
		proXType.setText(type);
		grData = new GridData();
		grData.horizontalSpan = 1;
		proXType.setLayoutData(grData);
		scrolledContainer.setMinSize(container.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));
		container.layout();

		return super.createDialogArea(scrolledContainer);
	}

	private boolean finalizePage() {
		boolean ok = true;
		xmlProperty = new XMLInputProperty();
		xmlProperty.setName(proName.getText().trim());
		xmlProperty.setXpath(proXPath.getText().trim());
		xmlProperty.setType(proXType.getText().trim());
		if (proName.getText().trim().equals("")) {
			ok = false;
		}
		return ok;
	}

	public XMLInputProperty getProperties() {
		return xmlProperty;
	}

	public void initialize(XMLInputProperty xmlProperty) {
		name = xmlProperty.getName();
		xpath = xmlProperty.getXpath();
		type = xmlProperty.getType();
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
