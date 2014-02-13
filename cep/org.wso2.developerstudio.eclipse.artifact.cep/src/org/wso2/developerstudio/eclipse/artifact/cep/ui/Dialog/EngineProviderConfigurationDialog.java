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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.developerstudio.eclipse.artifact.cep.model.EngineProviderPropertyModel;

public class EngineProviderConfigurationDialog extends TitleAreaDialog {
	private Text txtName;
	private Text txtValue;
	private String name = "";
	private String value = "";
	private EngineProviderPropertyModel property;

	public EngineProviderConfigurationDialog(Shell parentShell) {
		super(parentShell);

	}

	@Override
	public void create() {
		super.create();
		setTitle("Engine Provider Configuration");

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
		Label lbPrefix = new Label(container, SWT.NULL);
		lbPrefix.setText("Name");
		txtName = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		txtName.setLayoutData(grData);
		txtName.setText(name);
		Label lbNamespace = new Label(container, SWT.NULL);
		lbNamespace.setText("Value");
		txtValue = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;

		txtValue.setLayoutData(grData);
		txtValue.setText(value);

		container.layout();
		scrolledContainer.setSize(100, 80);
		container.layout();
		return super.createDialogArea(scrolledContainer);
	}

	@Override
	protected void okPressed() {
		if (finalizePage()) {
			super.okPressed();
		} else {
			super.cancelPressed();
		}
	}

	@Override
	protected Point getInitialSize() {
		Point size = new Point(350, 250);
		return size;
	}

	private boolean finalizePage() {
		boolean ok = true;

		name = txtName.getText().trim();
		value = txtValue.getText().trim();
		property = new EngineProviderPropertyModel(name, value);

		if (name.equals("")) {
			ok = false;
		}
		return ok;
	}

	public void initializePage(EngineProviderPropertyModel propetyModel) {
		name = propetyModel.getPropertyName();
		value = propetyModel.getPropertyValue();

	}

	public EngineProviderPropertyModel getPropertModel() {
		return property;
	}

}
