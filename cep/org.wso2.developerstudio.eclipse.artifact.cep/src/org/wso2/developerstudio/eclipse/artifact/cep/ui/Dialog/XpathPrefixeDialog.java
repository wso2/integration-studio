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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.wso2.carbon.cep.core.XpathDefinition;

public class XpathPrefixeDialog extends TitleAreaDialog {
	private Text prefix;
	private Text namespace;
	private String sPrefix = "";
	private String sNamespace = "";
	private XpathDefinition definition;

	protected XpathPrefixeDialog(Shell parentShell, boolean edit) {
		super(parentShell);

	}

	@Override
	public void create() {
		super.create();
		setTitle("XpathPrefix Configuration");
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
		lbPrefix.setText("prefix");
		prefix = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		prefix.setLayoutData(grData);
		prefix.setText(sPrefix);
		Label lbNamespace = new Label(container, SWT.NULL);
		lbNamespace.setText("Namespace");
		namespace = new Text(container, SWT.BORDER | SWT.SINGLE);
		grData = new GridData(GridData.FILL_HORIZONTAL);
		grData.horizontalSpan = 2;
		namespace.setLayoutData(grData);
		namespace.setText(sNamespace);
		container.layout();
		scrolledContainer.setMinSize(container.computeSize(SWT.DEFAULT,
				SWT.DEFAULT));
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

	private boolean finalizePage() {
		boolean ok = true;
		definition = new XpathDefinition();
		sPrefix = prefix.getText().trim();
		sNamespace = namespace.getText().trim();
		definition.setPrefix(sPrefix);
		definition.setNamespace(sNamespace);
		if (sPrefix.equals("")) {
			ok = false;
		}
		return ok;
	}

	public void initializePage(XpathDefinition xpathDefinition) {
		sPrefix = xpathDefinition.getPrefix();
		sNamespace = xpathDefinition.getNamespace();

	}

	public XpathDefinition getXpathPrefix() {
		return definition;
	}
}
