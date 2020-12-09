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

import org.eclipse.bpel.common.ui.command.ICommandFramework;
import org.eclipse.bpel.common.ui.details.ChangeHelper;
import org.eclipse.bpel.common.ui.flatui.FlatFormAttachment;
import org.eclipse.bpel.common.ui.flatui.FlatFormData;
import org.eclipse.bpel.common.ui.flatui.FlatFormLayout;
import org.eclipse.bpel.ui.BPELTabbedPropertySheetPage;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide;
import org.eclipse.bpel.ui.commands.util.UpdateModelCommand;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;



/**
 * An IDetailsSection representing a panel of widgets for one specifying one kind
 * of From/To contents.  Subclasses of AssignCategory can answer whether they apply
 * to the contents of a particular From or To, and they provide widgets specific to
 * that kind of contents.
 *  
 */

public abstract class AssignCategoryBase extends BPELPropertySection implements IAssignCategory {
	
	protected BPELPropertySection fOwnerSection;
	
	protected Composite fComposite;
	protected ChangeHelper fChangeHelper;
	protected Composite fParent;
	
	protected IVirtualCopyRuleSide fCopyRuleSide;

		
	protected AssignCategoryBase ( BPELPropertySection ownerSection  ) {		
		fOwnerSection = ownerSection;
	}

	/**
	 * Initialize the widgets from the state in the toOrFrom object.
	 * The toOrFrom object may contain additional state which isn't used by the widgets
	 * of this category; this state will be preserved in the model unless the user changes
	 * something in the category's widgets and causes a storeIntoModel() to occur.
	 * 
	 * If isFrom is true, toOrFrom will be a From object, otherwise it will be a To object.
	 */
	
	protected abstract void load (IVirtualCopyRuleSide side);

	/**
	 * Store the state represented by the widgets into the toOrFrom object.
	 * If isFrom is true, toOrFrom will be a From object, otherwise it will be a To object.
	 */
	
	protected abstract void store (IVirtualCopyRuleSide side);

	// This is used by changeHelper to determine what shows up in Undo/Redo.
	// The return value is FlatFormatted with getName() as the only argument.
	// Subclasses may override.
	protected String getLabelFlatFormatString() {
		return IBPELUIConstants.FORMAT_CMD_SELECT;
	}
	
	protected ChangeHelper getChangeHelper() { 
		return fChangeHelper;
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#getName()
	 */
	public String getName() {
		return null;
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#isCategoryForModel(org.eclipse.emf.ecore.EObject)
	 */
	public boolean isCategoryForModel(EObject model) {
		return false;
	}

	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#dispose()
	 */
	@Override
	public void dispose() {		
		super.dispose();
	}

	/**
	 * Policy: wrap the command with contexts from the ownerSection (rather
	 * than from the category itself).  On undo, the ownerSection will delegate
	 * to the category's methods. 
	 */
		@Override
	protected Command wrapInShowContextCommand (Command inner) {
		return super.wrapInShowContextCommand(inner, fOwnerSection);
	}
	
	protected boolean isToOrFromAffected (Notification n) {
		return true;
	}

	@Override
	protected MultiObjectAdapter[] createAdapters() {		
		return new BatchedMultiObjectAdapter[] {			

			new BatchedMultiObjectAdapter() {
				boolean bUpdate = false;
				@Override
				public void notify (Notification n) {
					bUpdate = isToOrFromAffected(n) ;
				}

				@Override
				public void finish() {
					if (bUpdate) {
						updateCategoryWidgets();
						bUpdate = false;
					}					
				}
			}
		};
	}
	
	/**
	 * Return the composite that was used in createControls call.
	 * 
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#getComposite()
	 */	
	public Composite getComposite () {
		return fParent;		
	}

	
	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls (Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		// hack - we have to do this in order to get the command framework before calling super.createControls
		ICommandFramework commandFramework = ((BPELTabbedPropertySheetPage)aTabbedPropertySheetPage).getEditor().getCommandFramework();
		
		fChangeHelper = new ChangeHelper(commandFramework) {
			public String getLabel() {
				return BPELUtil.formatString(getLabelFlatFormatString(), getName());
			}
			public Command createApplyCommand() {
				return wrapInShowContextCommand(newStoreModelCommand());
			}
			public void restoreOldState() {
				updateCategoryWidgets();
			}
		};
		
		super.createControls(parent, aTabbedPropertySheetPage);
		
		fParent = parent;		
	}

	@SuppressWarnings("nls")
	@Override
	protected void basicSetInput (EObject newInput) {		
		fCopyRuleSide = BPELUtil.adapt(newInput, IVirtualCopyRuleSide.class);			
		super.basicSetInput(newInput);			
	}

	
	/**
	 * This is a little whacked here.
	 *
	 */
	
	@SuppressWarnings("nls")
	protected void updateCategoryWidgets() {		
		load(fCopyRuleSide);		
	}

	/**
	 * Return a newStoreModelCommand 
	 * @return the command
	 */
	
	@SuppressWarnings("nls")
	public Command newStoreModelCommand()  {		
		return new UpdateModelCommand(fCopyRuleSide.getCopyRuleSide(),"Modify ..!") {
			@Override
			public void doExecute() {
				store ( fCopyRuleSide );
			}			
		};
	}
	
	protected boolean isDefaultCompositeOpaque() { 
		return true; 
	}

	@Override
	protected final void createClient(Composite parent) {
		// ugly HACK to make subclasses work
		FlatFormLayout layout = new FlatFormLayout();
		layout.marginHeight = layout.marginWidth = 0;
		parent.setLayout(layout);
		createClient2(parent);
	}
		
	/**
	 * Override this method.  Call this version if the subclass wants its own composite
	 * with margin and black border. 
	 */
	protected void createClient2(Composite parent) {
		if (isDefaultCompositeOpaque()) {
			fComposite = fWidgetFactory.createPlainComposite(parent, SWT.NONE);
		} else {
			fComposite = fWidgetFactory.createComposite(parent);
		}
		FlatFormLayout layout = new FlatFormLayout();
		layout.marginWidth = 0;//IDetailsAreaConstants.HMARGIN;
		layout.marginHeight = 0;//IDetailsAreaConstants.VMARGIN;
		fComposite.setLayout(layout);
		FlatFormData data = new FlatFormData();
		data.left = new FlatFormAttachment(0, 0);
		data.right = new FlatFormAttachment(100, 0);
		data.top = new FlatFormAttachment(0, 0);
		data.bottom = new FlatFormAttachment(100, 0);
//		data.borderType = IBorderConstants.BORDER_1P1_BLACK;
		fComposite.setLayoutData(data);
	}

	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		updateCategoryWidgets();
	}

	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#aboutToBeHidden()
	 */
	@Override
	public void aboutToBeHidden() {
		if (isCreated) {
			// hack!
			ChangeHelper changeHelper = getChangeHelper();
			if (changeHelper != null) {
				getCommandFramework().notifyChangeDone(changeHelper);
			}
		}
		super.aboutToBeHidden();
	}
	
	/**
	 * This is just a workaround to keep the AssignCategory from changing too much.
	 * @param model the model object
	 */
	
	public void setInput (EObject model) {
		removeAllAdapters();				    
		basicSetInput(model);
		addAllAdapters();
	}
	
	
	
	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#isHidden()
	 */
	public boolean isHidden() { 
		return isHidden; 
	}
}
