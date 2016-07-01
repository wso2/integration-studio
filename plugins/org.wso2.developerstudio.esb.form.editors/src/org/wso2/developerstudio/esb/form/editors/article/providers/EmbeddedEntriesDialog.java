/*
 * Copyright 2009-2016 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.esb.form.editors.article.providers;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class EmbeddedEntriesDialog extends Dialog {

	private java.util.List<NamedEntityDescriptor> localNamedEntities;
	private String selectedItem=null;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public EmbeddedEntriesDialog(Shell parentShell,java.util.List<NamedEntityDescriptor> localNamedEntities) {
		super(parentShell);
		setLocalNamedEntities(localNamedEntities);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		
		Group grpSelectAnEntry = new Group(container, SWT.NONE);
		grpSelectAnEntry.setLayout(new FillLayout(SWT.HORIZONTAL));
		grpSelectAnEntry.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grpSelectAnEntry.setText("Select an entry among the following");
		
		final List lstItems = new List(grpSelectAnEntry, SWT.BORDER);
		for (NamedEntityDescriptor descriptor : getLocalNamedEntities()) {
			lstItems.add(descriptor.toString());
		}
		
		lstItems.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				String[] selection = lstItems.getSelection();
				if (selection.length > 0) {
					NamedEntityDescriptor descriptor = NamedEntityDescriptor.fromString(selection[0]);
					if (null != descriptor) {
						setSelectedItem(descriptor.getName());
					}
				}
			}
		});
		return container;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	public void setLocalNamedEntities(java.util.List<NamedEntityDescriptor> localNamedEntities) {
		this.localNamedEntities = localNamedEntities;
	}

	public java.util.List<NamedEntityDescriptor> getLocalNamedEntities() {
		return localNamedEntities;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}

	public String getSelectedItem() {
		return selectedItem;
	}
}
