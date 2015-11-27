/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.dialogs;

import org.eclipse.bpel.ui.Messages;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.TwoPaneElementSelector;
import org.eclipse.ui.progress.WorkbenchJob;


/**
 * A selection dialog that also lets the user create a new element.
 */
public class SelectionAndCreationDialog extends TwoPaneElementSelector {

	protected boolean allowCreateNewArtifact;
	
	public SelectionAndCreationDialog(Shell parent, ILabelProvider elementRenderer, ILabelProvider qualifierRenderer) {
		super(parent, elementRenderer, qualifierRenderer);
		allowCreateNewArtifact = true;
	}

	@Override
	protected Text createFilterText(Composite parent) {
	    Composite newComposite = new Composite(parent, SWT.NONE);
	    GridLayout layout = new GridLayout(2, false);
	    layout.marginHeight = 0;
	    layout.marginWidth = 0;
	    newComposite.setLayout(layout);
	    newComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
	    
	    Text filterText = super.createFilterText(newComposite);
	    ((GridData)filterText.getLayoutData()).verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
	    filterText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				// We need to run the update in a job because the selection also
				// runs in a job and we have to update the OK button status only
				// after the selection is updated.
				WorkbenchJob job = new WorkbenchJob(Display.getCurrent(), "") { //$NON-NLS-1$
					@Override
					public IStatus runInUIThread(IProgressMonitor monitor) {
						updateOkState();
						return Status.OK_STATUS;
					}
				};
				job.schedule();
			}
		});
	    
        if (allowCreateNewArtifact) {
		    Button button = new Button(newComposite, SWT.PUSH);
		    button.setFont(newComposite.getFont());
		    button.setText(Messages.SelectionAndCreationDialog_New_1); 
			GridData data = new GridData();
			data.verticalAlignment = GridData.VERTICAL_ALIGN_CENTER;
			button.setLayoutData(data);
		
			button.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
                    handleNewButtonPushed();
				}
				public void widgetDefaultSelected(SelectionEvent e) {
					// do nothing
				}
			});
        }

        return filterText;
	}

	/**
	 * Called when the user pushes the "New..." button. 
	 */
	protected void handleNewButtonPushed() {
	}
	
	/**
	 * Sets whether this dialog should have a "New..." button.
	 */
	public void setAllowCreateNewArtifact(boolean allowCreateNewArtifact) {
		this.allowCreateNewArtifact = allowCreateNewArtifact;
	}
	
	@Override
	protected void okPressed() {
		// check if there's a selection
		if (getSelectedElements().length == 0) {
			// We can get into the state of not having a selection due to timing issues.
			// The enablement of the OK button is based on a selection. Selections can
			// depend on the table being updated and that is done in a background thread
			// for performance reasons. Sometimes (not often) the user can get into a state
			// where the OK button is enabled but there are no selections. If the user hits
			// OK we have to at least show a dialog saying that no selections were made so
			// we can't close the dialog using the OK button.
			MessageDialog.openError(getShell(), Messages.SelectionAndCreationDialog_Error_2, Messages.SelectionAndCreationDialog_No_elements_were_selected_3); 
			return;
		}
		super.okPressed();
	}
}
