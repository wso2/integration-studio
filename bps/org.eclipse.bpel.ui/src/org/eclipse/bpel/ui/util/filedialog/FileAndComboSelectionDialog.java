/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.util.filedialog;

import org.eclipse.bpel.common.ui.details.viewers.ComboViewer;
import org.eclipse.bpel.ui.BPELUIPlugin;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.FontMetrics;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ISelectionValidator;
import org.eclipse.ui.dialogs.SelectionDialog;


/**
 * A version of WorkbenchFileSelectionDialog which allows the user to select one element
 * from within the file, using a combo box. 
 * 
 * The dialog has an optional area that can be used to display details about the selected
 * item.
 */
public abstract class FileAndComboSelectionDialog extends SelectionDialog {

	private IResource initialSelection;

	private String title;
	private String message;
	private String filterPatterns;

	private IPath resultPath;
	
	private Combo combo;
	protected ComboViewer comboViewer;

	private Object comboResult;
	protected Text detailsMessage;
	private boolean useDetails;

	// validation
	private Label statusMessage;
	private org.eclipse.ui.dialogs.ISelectionValidator validator;

	// widgets
	private Button okButton;
	private boolean comboValid = false;
	private boolean fileValid = false;

	// the widget group;
	private FileSelectionGroup resourceGroup;

	/**
	 * A FileAndComboSelectionDialog takes the following arguments:
	 * <ul>
	 * <li> parentShell, the parent shell of the caller.(required)</li>
	 * <li> initialSelection, (required)</li>
	 *           = null, takes the initial selection of the file from store, where it was memorizaed
	 *          != null, starts the selection right from the specified path.
	 * <li> message, shows the message on titel bar for this dialog.(required)</li>
	 * <li> filterPatterns, a string of extentions separated with "," as deliminator (eg; "wsdl, xsd, java")(optional)
	 * <li> useDetails, true if the subclass needs the detailsMessage text widget.
	 */
	public FileAndComboSelectionDialog(Shell parentShell, IPath initialSelection,
		String message, String filterPatterns, boolean useDetails)
	{
		super(parentShell);
		this.useDetails = useDetails;

		IPath initial = initialSelection;
		if (initial == null) {
			// TODO: find a suitable default somehow?
		}
		try {
			if (initial != null)  {
				this.initialSelection =
					ResourcesPlugin.getWorkspace().getRoot().getFile(initial);
			}
		} catch (Exception e) {
			BPELUIPlugin.log(e);
		}

		this.title = Messages.FileAndComboSelectionDialog_Browse_1; 
		this.message = message;
		setShellStyle(getShellStyle() | SWT.RESIZE);
		this.filterPatterns = filterPatterns;
	}

	
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(title);
	}

	protected boolean canFinish() {
		return fileValid && comboValid;
	}

	
	protected void createButtonsForButtonBar(Composite parent) {
		okButton =
			createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(
			parent,
			IDialogConstants.CANCEL_ID,
			IDialogConstants.CANCEL_LABEL,
			false);
		okButton.setEnabled(canFinish());
	}

	/**
	 * This function should open the selected file and read necessary model object(s) from
	 * it.  It should return some sort of "root" model object which is understood by the
	 * content provider of the comboViewer.
	 */
	protected abstract Object readModelFromSelectedFile();

	protected void reloadComboContents() {
		Object modelRoot = readModelFromSelectedFile();
		comboViewer.setInput(modelRoot);
		combo.select(0);
		if (useDetails)  updateDetailsMessage();
	}
	
	/**
	 * Subclasses which use detailsMessage should override this to set its contents.
	 */
	protected void updateDetailsMessage() { }
	
	protected void clearComboContents() {
		comboViewer.setInput(null);
		updateDetailsMessage();
	}
	
	protected abstract void configureComboViewer(ComboViewer comboViewer);

	
	protected Control createDialogArea(Composite parent) {

		// create composite 
		Composite dialogArea = (Composite) super.createDialogArea(parent);

		Listener listener = new Listener() {
			public void handleEvent(Event event) {
				fileValid = true;
				if (statusMessage != null && validator != null) {
					String errorMsg =
						validator.isValid(resourceGroup.getResourceFullPath());
					if (errorMsg == null || errorMsg.equals("")) { //$NON-NLS-1$
						statusMessage.setText(""); //$NON-NLS-1$
						fileValid = true;
					} else {
						statusMessage.setForeground(
							statusMessage.getDisplay().getSystemColor(SWT.COLOR_RED));
						statusMessage.setText(errorMsg);
						fileValid = false;
					}
				}
				if (fileValid) {
					resultPath = resourceGroup.getResourceFullPath();
				}
				if (fileValid && event.type == SWT.Selection) {
					reloadComboContents();
					comboValid = (combo.getItemCount() > 0);
				}
				if (getOkButton() != null) {
					getOkButton().setEnabled(canFinish());
				} 
				if (!canFinish())  resultPath = null;
			}
		};

		// file selection group
		resourceGroup = new FileSelectionGroup(dialogArea, listener, message, filterPatterns);
		
		Composite comboComposite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 8;
		gridLayout.marginHeight = 0;
		comboComposite.setLayout(gridLayout);
		comboComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		combo = new Combo(comboComposite, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		Composite textComposite = new Composite(parent, SWT.NONE);
		
		gridLayout = new GridLayout(1, false);
		gridLayout.marginWidth = 8;
		gridLayout.marginHeight = 8;
		textComposite.setLayout(gridLayout);
		textComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		if (useDetails) {
			detailsMessage = new Text(textComposite, SWT.MULTI | SWT.WRAP | SWT.READ_ONLY);
			
			GridData data =	new GridData(GridData.FILL_BOTH);
			data.verticalSpan = 2;
			
			GC gc = new GC(detailsMessage);
			gc.setFont(detailsMessage.getFont());
			FontMetrics fontMetrics = gc.getFontMetrics();
			gc.dispose();
			data.heightHint = fontMetrics.getHeight() * 2;
			detailsMessage.setLayoutData(data);
		}

		comboViewer = new ComboViewer(combo);
		if (useDetails) {
			comboViewer.getCombo().addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					updateDetailsMessage();
				}
				public void widgetDefaultSelected(SelectionEvent e) { widgetSelected(e); }
			});
		}
		configureComboViewer(comboViewer);
		
		statusMessage = new Label(textComposite, SWT.NONE);
		statusMessage.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		if (initialSelection != null) {
			resourceGroup.setSelectedResource(initialSelection);
		}
		
		return dialogArea;
	}

	/**
	 * Subclasses can override to create extra widgets below the combo.
	 */
	public void createExtraWidgets(Composite composite) { }

	/**
	 * Returns the full path of the selected file.
	 */
	public IPath getFullPath() {
		return resultPath;
	}

	protected Object getComboSelection() {
		return ((IStructuredSelection)comboViewer.getSelection()).getFirstElement();
	}

	protected void setComboResult(Object comboResult) {
		this.comboResult = comboResult;
	}

	/**
	 * Returns the result of selecting in the combo (note: might be different from getComboSelection()!)
	 */
	public Object getComboResult() {
		return comboResult;
	}

	/**
	 * Closes this dialog.
	 */
	
	protected void okPressed() {
		resultPath = resourceGroup.getResourceFullPath();

		super.okPressed();
	}
	
	/**
	 * Sets the validator to use.
	 */
	public void setValidator(ISelectionValidator validator) {
		this.validator = validator;
	}

}
