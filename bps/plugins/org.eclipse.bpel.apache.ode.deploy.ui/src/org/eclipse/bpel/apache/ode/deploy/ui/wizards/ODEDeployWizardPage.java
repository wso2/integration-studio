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
package org.eclipse.bpel.apache.ode.deploy.ui.wizards;

import org.eclipse.bpel.apache.ode.deploy.ui.messages.ODEDeployUIMessages;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.wizards.Messages;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * ODE deployment descriptor wizard page.
 * 
 * @author Simon Moser (IBM)
 * @author Tammo van Lessen (IAAS)
 */
public class ODEDeployWizardPage extends WizardPage {
	private Text containerText;

	private Text fileText;

	private ISelection selection;
	private static final String DEPLOYFILE = "deploy.xml";

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public ODEDeployWizardPage(ISelection selection) {
		super(ODEDeployUIMessages.ODEDeployWizardPage_Name);
		setTitle(ODEDeployUIMessages.ODEDeployWizardPage_Title);
		setDescription(ODEDeployUIMessages.ODEDeployWizardPage_Description);
		this.selection = selection;
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 3;
		layout.verticalSpacing = 9;
		Label label = new Label(container, SWT.NULL);
		label.setText(ODEDeployUIMessages.ODEDeployWizardPage_Label_BPELProject);

		containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		containerText.setLayoutData(gd);
		containerText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		Button button = new Button(container, SWT.PUSH);
		button.setText(ODEDeployUIMessages.ODEDeployWizardPage_Button_Browse);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				handleBrowse();
			}
		});
		label = new Label(container, SWT.NULL);
		label.setText(ODEDeployUIMessages.ODEDeployWizardPage_Label_DeployFile);

		fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
		fileText.setText(DEPLOYFILE);
		fileText.setEditable(false);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		fileText.setLayoutData(gd);
		initialize();
		dialogChanged();
		setControl(container);
	}

	/**
	 * Tests if the current workbench selection is a suitable container to use.
	 */

	private void initialize() {
		if (selection != null && selection.isEmpty() == false
				&& selection instanceof IStructuredSelection) {
			IStructuredSelection ssel = (IStructuredSelection) selection;
			if (ssel.size() > 1)
				return;
			Object obj = ssel.getFirstElement();

			if (obj instanceof IResource) {
				IResource res = (IResource) obj;
				if (res instanceof IProject) {
					IContainer bpelContent = BPELUtil.getBPELContentFolder(res.getProject());
					if (bpelContent != null) {
						res = bpelContent;
					}
				}
				hasBPELContent(res);
				if (res instanceof IContainer) {
					containerText.setText(res.getFullPath().toString());
				} else {
					containerText.setText(res.getParent().getFullPath().toString());
				}
			}
		}
	}

	/**
	 * Uses the standard container selection dialog to choose the new value for
	 * the container field.
	 */

	private void handleBrowse() {
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(
				getShell(), ResourcesPlugin.getWorkspace().getRoot(), false,
				ODEDeployUIMessages.ODEDeployWizardPage_ContainerSelectionDialog_Message);
		if (dialog.open() == ContainerSelectionDialog.OK) {
			Object[] result = dialog.getResult();
			if (result.length == 1) {
				containerText.setText(((Path) result[0]).toString());
			}
		}
	}

	/**
	 * Ensures that both text fields are set.
	 */

	private void dialogChanged() {
		IResource container = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(new Path(getContainerName()));

		if (getContainerName().length() == 0) {
			updateStatus(ODEDeployUIMessages.ODEDeployWizardPage_Error_Container_IsNULL);
			return;
		}
		if (container == null
				|| (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
			updateStatus(ODEDeployUIMessages.ODEDeployWizardPage_Error_Container_IsHere);
			return;
		}
		if (!container.isAccessible()) {
			updateStatus(ODEDeployUIMessages.ODEDeployWizardPage_Error_Container_IsWritable);
			return;
		}
//		if (fileName.length() == 0) {
//			updateStatus("File name must be specified");
//			return;
//		}
//		if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
//			updateStatus("File name must be valid");
//			return;
//		}
//		int dotLoc = fileName.lastIndexOf('.');
//		if (dotLoc != -1) {
//			String ext = fileName.substring(dotLoc + 1);
//			if (ext.equalsIgnoreCase("xml") == false) {
//				updateStatus("File extension must be \"xml\"");
//				return;
//			}
//		}
		
		hasBPELContent(container);		
		updateStatus(null);
	}

	private void hasBPELContent(IResource res) {
		IContainer bpelContent = null;
		if (!BPELUtil.isBPELProject(res.getProject())) {
			setMessage(Messages.NewFileWizard_Not_A_BPELFaceted_Project, WizardPage.WARNING);
			return;
		} else {
			bpelContent = BPELUtil.getBPELContentFolder(res.getProject());
			if (!res.equals(bpelContent) && !res.getParent().equals(bpelContent)) {
				setMessage(Messages.NewFileWizard_Not_A_BPELContent_Folder, WizardPage.WARNING);
				return;
		    }
		}
		setMessage(null, WizardPage.WARNING);
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getContainerName() {
		return containerText.getText();
	}

	public String getFileName() {
		return fileText.getText();
	}
}