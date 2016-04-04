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
package org.eclipse.bpel.ui.editparts;

import org.eclipse.bpel.common.ui.tray.TrayCategoryEditPart;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.editparts.policies.TrayContainerEditPolicy;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.AccessibleEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;
import org.eclipse.jface.viewers.StructuredSelection;

public abstract class BPELTrayCategoryEditPart extends TrayCategoryEditPart{
	
	// added by Grid.Qian
	// use the variable to hold the root of the editpart
	// because when we delete a correlationSets from scope
	// the editpart parent will be null
	private RootEditPart holdRoot;
	
	// added by Grid.Qian
	// use the variable to hold the parent's of the model
	// that will be a scope or a process
	// because when we delete a correlationSets from scope
	// the eContainer will be null
	private EObject eObj;
	
	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		// handles creations
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new TrayContainerEditPolicy());
	}
	
	@Override
	protected AccessibleEditPart createAccessible() {
		return new BPELTrayAccessibleEditPart(this);
	}
	
	/**
	 * WARNING: only call this method if you know what you're doing!
	 * 
	 * HACK: The following hack avoids the Process from being selected when a variable,
	 * correlationSet or partnerLink is deleted. If the Process is selected, this edit part	 * 
	 * has its parent set to null and when its time for the variable, correlationSet or partnerLink 
	 * being deleted to "unregister visuals" it will try to get the viewer and that will cause a
	 * NPR because the parent is null.
	 */
	protected void selectAnotherEntry() {
		int size = getModelChildren().size();
		if (size > 0) {
			selectEditPart(getModelChildren().get(0));
		} else {
			// if we are executing this method we are dealing with scoped variables
			
			// delete the line by Grid.Qian because the econtainer maybe null
			// when the model is deleted from the scope
			// Scope scope = (Scope)((EObject)getModel()).eContainer();
			BPELEditor editor = ModelHelper.getBPELEditor(eObj);
			EditPart editPart = (EditPart)editor.getGraphicalViewer().getEditPartRegistry().get(eObj);
			if (editPart != null) {
				getViewer().setSelection(new StructuredSelection(editPart));
			}
		}
	}
	
	/**
	 * Overwrite the method by Grid.Qian to get the viewer 
	 * when the editpart's parent == null
	 */
	public EditPartViewer getViewer() {
		try {
			return super.getViewer();
		} catch (Exception e) {
			return holdRoot.getViewer();
		}

	}

	/**
	 * Overwrite the method by Grid.Qian
	 * Hold the editpart's root editpart
	 */
	public void setParent(EditPart parent) {
		if (this.getParent() == parent)
			return;
		if (parent != null) {
			holdRoot = parent.getRoot();
		}
		super.setParent(parent);
	}
	

	/**
	 * Overwrite the method by Grid.Qian
	 * Hold the scope or process that the model belong to
	 */
	public void setModel(Object model) {
		if (getModel() == model)
			return;
		eObj = ((EObject) model).eContainer();
		super.setModel(model);
	}

}
