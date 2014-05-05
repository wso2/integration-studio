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
import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Expression;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.IVirtualCopyRuleSide;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.SetCommand;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.bpel.ui.util.BatchedMultiObjectAdapter;
import org.eclipse.bpel.ui.util.MultiObjectAdapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.commands.Command;
import org.eclipse.swt.layout.FillLayout;
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
public class ExpressionAssignCategory extends ExpressionSection implements IAssignCategory {

	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#isHidden()
	 */
	public boolean isHidden() {
		return isHidden; 
	}
	
	protected BPELPropertySection fOwnerSection;

	protected Composite composite;
	
	protected Composite fParent;
		
	protected ExpressionAssignCategory( BPELPropertySection ownerSection ) {		
		this.fOwnerSection = ownerSection;
	}

	
	/**
	 * @see org.eclipse.bpel.ui.properties.BPELPropertySection#createControls(org.eclipse.swt.widgets.Composite, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage)
	 */
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {		
		super.createControls(parent, aTabbedPropertySheetPage);
		fParent = parent;
	}
	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#getComposite()
	 */
	public Composite getComposite() {
		return fParent;
	}
	
	
	// This is used by changeHelper to determine what shows up in Undo/Redo.
	// The return value is FlatFormatted with getName() as the only argument.
	// Subclasses may override.
	protected String getLabelFlatFormatString() {
		return IBPELUIConstants.FORMAT_CMD_SELECT;
	}

	protected boolean isToOrFromAffected(Notification n) {
		// hack:
		return true;
//		if (isFrom) {
//			return (n.getFeatureID(Copy.class) == BPELPackage.COPY__FROM);
//		}
//		return (n.getFeatureID(Copy.class) == BPELPackage.COPY__TO);
	}

	
	@Override
	protected MultiObjectAdapter[] createAdapters() {
		MultiObjectAdapter adapter = new BatchedMultiObjectAdapter() {
			boolean needRefresh = false;
			boolean toOrFromAffected = false;
			@Override
			public void notify(Notification n) {
				needRefresh = isBodyAffected(n);
				
				// if (isBodyAffected(n) && !isExecutingStoreCommand) needRefresh = true;
				if (isToOrFromAffected(n)) {
					toOrFromAffected = true;
				}
				refreshAdapters();
			}
			@Override
			public void finish() {
				if (needRefresh || toOrFromAffected) {
					updateWidgets();
				}
				if (toOrFromAffected) {
					updateCategoryWidgets();
				}
				toOrFromAffected = false;
				needRefresh = false;
			}
		};
		return new MultiObjectAdapter[] { adapter };
	}
		
	protected void updateCategoryWidgets() {
		updateEditor();
	}

	/**
	 * Policy: wrap the command with contexts from the ownerSection (rather
	 * than from the category itself).  On undo, the ownerSection will delegate
	 * to the category's methods. 
	 */
	
	@Override
	protected Command wrapInShowContextCommand(Command inner) {
		return super.wrapInShowContextCommand(inner, fOwnerSection);
	}
	
	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#getName()
	 */
	public String getName() { 
		return Messages.ExpressionAssignCategory_Expression_1; 
	} 

	
	/**
	 * @see org.eclipse.bpel.ui.properties.IAssignCategory#isCategoryForModel(org.eclipse.emf.ecore.EObject)
	 */
	public boolean isCategoryForModel ( EObject aModel ) {
		IVirtualCopyRuleSide side = BPELUtil.adapt(aModel, IVirtualCopyRuleSide.class);
		if (side != null) {
			return side.getExpression() != null;
		}		
		return false;
	}

	
	@Override
	protected Command newStoreToModelCommand  (Object body) {
		CompoundCommand result = new CompoundCommand();
		// If there is no condition, create one.
		Expression oldExp = getExprFromModel();
		Expression exp = BPELFactory.eINSTANCE.createExpression();
		
		// Don't set the language, because if the user has changed the
		// language, a condition would already exist at this point.
		if (oldExp != null) {
			exp.setExpressionLanguage(oldExp.getExpressionLanguage());
		}
		exp.setBody(body);
		result.add(new SetCommand( getExpressionTarget(), exp, getStructuralFeature() ));
		fEditor.addExtraStoreCommands(result);
		return result;
	}

	
	@Override
	protected EStructuralFeature getStructuralFeature(EObject object) {
		if (object instanceof AbstractAssignBound) {
			return BPELPackage.eINSTANCE.getAbstractAssignBound_Expression();
		}
		return super.getStructuralFeature(object);
	}


	/**
	 * This is just a workaround to keep the AssignCategory from changing too much.
	 * @param model the model object
	 */
	
	public void setInput (EObject model) {
		basicSetInput(model);
		addAllAdapters();
		
		
		Object language = selectedExpressionLanguage ();
		
		if (language == NO_EXPRESSION) {
			doChooseExpressionLanguage ( SAME_AS_PARENT );
		}		
	}
	
	
	@Override
	protected final void createClient(Composite parent) {
		// ugly HACK to make subclasses work
		//FlatFormLayout layout = new FlatFormLayout();
		//layout.marginHeight = layout.marginWidth = 0;
		//parent.setLayout(layout);
		FillLayout fillLayout = new FillLayout();
		fillLayout.marginHeight = fillLayout.marginWidth = 0;
		parent.setLayout(fillLayout);
		super.createClient(parent);
	}
	
}

