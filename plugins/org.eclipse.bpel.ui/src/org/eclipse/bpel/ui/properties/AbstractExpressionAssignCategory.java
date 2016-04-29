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

import org.eclipse.bpel.model.AbstractAssignBound;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;


/**
 * TODO: when you first set the model object into the details page, it should query the
 * sections to find out which one thinks it "owns" the model object.  If NONE of them
 * claim to own it, then we will use whatever combo selection is stored in the transient
 * CopyExtension.  The same procedure is followed when refreshing the contents of the
 * page.
 *
 * When you select a *different* category in the combo, we must update the value in the
 * CopyExtension.  We should also replace the existing Copy with an *empty* Copy.
 *
 * Categories should become responsible for storing the value into the model themselves.
 */
public abstract class AbstractExpressionAssignCategory extends AbstractStyledTextExpressionSection implements IAssignCategory {

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#isHidden()
	 */
	public boolean isHidden() {
		return this.isHidden;
	}

	protected BPELPropertySection fOwnerSection;

	protected Composite composite;

	protected Composite fParent;

	protected AbstractExpressionAssignCategory() {
		
	}
	
	protected AbstractExpressionAssignCategory( BPELPropertySection ownerSection ) {
		this.fOwnerSection = ownerSection;
	}


	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection
	 * #createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		this.fParent = parent;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory
	 * #getComposite()
	 */
	public Composite getComposite() {
		return this.fParent;
	}


	// This is used by changeHelper to determine what shows up in Undo/Redo.
	// The return value is FlatFormatted with getName() as the only argument.
	// Subclasses may override.
	protected String getLabelFlatFormatString() {
		return IBPELUIConstants.FORMAT_CMD_SELECT;
	}

	protected boolean isToOrFromAffected(Notification n) {
		return true;
	}

	/**
	 * Policy: wrap the command with contexts from the ownerSection (rather
	 * than from the category itself).  On undo, the ownerSection will delegate
	 * to the category's methods.
	 */
	@Override
	protected Command wrapInShowContextCommand(Command inner) {
		return super.wrapInShowContextCommand(inner, this.fOwnerSection);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory
	 * #isCategoryForModel(org.eclipse.emf.ecore.EObject)
	 */
	public boolean isCategoryForModel(EObject aModel) {
		IVirtualCopyRuleSide side = BPELUtil.adapt(aModel,
				IVirtualCopyRuleSide.class);
		
		if (side == null)
			return false;
		Expression exp = side.getExpression();
		if (exp == null)
			return false;
		return exp.getExpressionLanguage() != null &&
				exp.getExpressionLanguage().equals(getExpressionLanguage());
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.ui.properties.ExpressionSection
	 * #getStructuralFeature(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	protected EStructuralFeature getStructuralFeature(EObject object) {
		return object instanceof AbstractAssignBound ? BPELPackage.eINSTANCE.getAbstractAssignBound_Expression() : null;
	}

	/**
	 * This is just a workaround to keep the AssignCategory from changing too much.
	 * @param model the model object
	 */
	public void setInput (EObject model) {
		basicSetInput(model);
		addAllAdapters();
	}

	/**
	 * @return the expression language
	 */
	protected abstract String getExpressionLanguage();

}

