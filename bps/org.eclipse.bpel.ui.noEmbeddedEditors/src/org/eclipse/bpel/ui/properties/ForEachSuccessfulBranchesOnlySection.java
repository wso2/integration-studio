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
package org.eclipse.bpel.ui.properties;

import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Branches;
import org.eclipse.bpel.model.CompletionCondition;
import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.ui.IHelpContextIds;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

/**
 * Completion section for the ForEach activity
 */
public class ForEachSuccessfulBranchesOnlySection extends BPELPropertySection {

	Button		fSuccessfulBranchesOnlyCheckbox;
	Composite	fSuccessfulBranchesOnlyComposite;

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
				
		updateSuccessfulBranchesOnlyWidgets();
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#restoreUserContext(java.lang.Object)
	 */
	@Override
	public void restoreUserContext(Object userContext) {
		updateSuccessfulBranchesOnlyWidgets();
		fSuccessfulBranchesOnlyCheckbox.setFocus();
	}

	void createSuccessfulBranchesOnlyWidgets(Composite parentComposite) {
		FlatFormData data;

		fSuccessfulBranchesOnlyComposite = createFlatFormComposite(parentComposite);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		fSuccessfulBranchesOnlyComposite.setLayoutData(data);

		fSuccessfulBranchesOnlyCheckbox = fWidgetFactory
				.createButton(
						fSuccessfulBranchesOnlyComposite,
						Messages.ForEachSuccessfulBranchesOnlySection_1,
						SWT.CHECK);
		data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.top = new FlatFormAttachment(0, 0);
		fSuccessfulBranchesOnlyCheckbox.setLayoutData(data);
		
		fSuccessfulBranchesOnlyCheckbox.addSelectionListener(new SelectionListener() {

			public void widgetDefaultSelected(SelectionEvent e) {
				
			}

			@SuppressWarnings("boxing")
			public void widgetSelected(SelectionEvent e) {
				ForEach input = getModel();
				getCommandFramework().execute( wrapInShowContextCommand(
						new SetCommand(input.getCompletionCondition().getBranches(), 
								fSuccessfulBranchesOnlyCheckbox.getSelection(),
								BPELPackage.eINSTANCE.getBranches_CountCompletedBranchesOnly() )) );
			}
			
		});
	}

	@SuppressWarnings("boxing")
	void updateSuccessfulBranchesOnlyWidgets() {
		
		ForEach input = getModel();
		CompletionCondition completionCondition = input.getCompletionCondition();
		if (completionCondition == null) {
			
			fSuccessfulBranchesOnlyCheckbox.setEnabled(false);
			fSuccessfulBranchesOnlyCheckbox.setSelection(false);
			
		} else {
			Branches branches = completionCondition.getBranches();
			if (branches == null) {
				fSuccessfulBranchesOnlyCheckbox.setEnabled(false);
				fSuccessfulBranchesOnlyCheckbox.setSelection(false);
			} else {
				fSuccessfulBranchesOnlyCheckbox.setEnabled(true);
				Boolean value = branches.getCountCompletedBranchesOnly();
				
				fSuccessfulBranchesOnlyCheckbox.setSelection(value == null ? false : value );
			}
		}
	}		

	/**
	 * This implementation just hooks the first adapter on the input object.
	 * Subclasses may override.
	 */
	
	@Override
	protected void addAllAdapters() {
		
		super.addAllAdapters();
		
		ForEach input = getModel();
		CompletionCondition cc = input.getCompletionCondition();
		if (cc == null) {
			return ;
		}
		fAdapters[0].addToObject( cc );
		Branches branches = cc.getBranches();
		if (branches == null) {
			return;
		}
		fAdapters[0].addToObject( branches );
	}

	
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		return new MultiObjectAdapter[] { new MultiObjectAdapter() {

			@Override
			public void notify(Notification n) {
				if (n.getFeature() == BPELPackage.eINSTANCE.getBranches_CountCompletedBranchesOnly() ||
					n.getFeature() == BPELPackage.eINSTANCE.getCompletionCondition_Branches() ||
					n.getFeature() == BPELPackage.eINSTANCE.getForEach_CompletionCondition() )
				{
					updateSuccessfulBranchesOnlyWidgets();
				}
			}

		}};
	}

	
	@Override
	protected void createClient(Composite parent) {
		Composite parentComposite = createFlatFormComposite(parent);
		createSuccessfulBranchesOnlyWidgets(parentComposite);
    PlatformUI.getWorkbench().getHelpSystem().setHelp(parentComposite, IHelpContextIds.PROPERTY_PAGE_FOR_EACH_SUCCESSFUL);
	}
}
