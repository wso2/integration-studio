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
package org.eclipse.bpel.ui.dialogs;

import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.ui.details.providers.ModelTreeLabelProvider;
import org.eclipse.bpel.ui.details.providers.PartnerLinkTypeTreeContentProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.StatusDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

public class PartnerLinkRoleSelectorDialog extends StatusDialog {

	private int fSelectedRole;
	private EList<Role> fRoles;
	private Tree fTree;
	private TreeViewer fTreeViewer;
	private PartnerLinkTypeTreeContentProvider treeContentProvider;
	private PartnerLinkType fPartnerLinkType;

	public PartnerLinkRoleSelectorDialog(Shell shell, EList<Role> list,
			PartnerLinkType plinkType) {
		super(shell);
		fRoles = list;
		fPartnerLinkType = plinkType;
	}

	@Override
	public Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);

		Group group = new Group(composite, SWT.NONE);
		group.setLayout(new GridLayout());
		group.setText("Roles");

		createRadioButton(group, fRoles.get(0).getName(), 0, true);
		createRadioButton(group, fRoles.get(1).getName(), 1, false);

		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.widthHint = 400;
		group.setLayoutData(gridData);

		createLowerView(composite);
		fTreeViewer.setInput(fPartnerLinkType);

		return composite;

	}

	protected Button createRadioButton(Composite parent, String label, int id,
			boolean checked) {

		Button button = new Button(parent, SWT.RADIO);
		button.setText(label);
		button.setFont(JFaceResources.getDialogFont());
		button.setData( Integer.valueOf( id ));
		button.setSelection(checked);

		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				Button b = (Button) event.widget;
				fSelectedRole = ((Integer) b.getData()).intValue();
			}
		});

		return button;

	}

	private Object createLowerView(Composite parent) {
		treeContentProvider = new PartnerLinkTypeTreeContentProvider(true);
		fTree = new Tree(parent, SWT.BORDER);
		fTreeViewer = new TreeViewer(fTree);
		fTreeViewer.setContentProvider(treeContentProvider);
		fTreeViewer.setLabelProvider(new ModelTreeLabelProvider());
		fTreeViewer.setInput(null);
		fTreeViewer.setAutoExpandLevel(5);
		GridData data = new GridData();
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = GridData.FILL;
		data.verticalAlignment = GridData.FILL;
		data.minimumHeight = 200;
		fTree.setLayoutData(data);
		return fTree;
	}

	public int getSelectedRole() {
		return fSelectedRole;
	}

}
