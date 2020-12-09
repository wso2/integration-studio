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
package org.eclipse.bpel.ui.editparts.policies;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.ui.GraphicalBPELRootEditPart;
import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.SetConstraintCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.bpel.ui.editparts.FlowEditPart;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;


/**
 * GEF Edit Policy used to place bpel objects at specific XY locations
 */
public abstract class BPELXYLayoutEditPolicy extends XYLayoutEditPolicy {

	// the common guts of the AddCommand
	@Override
	protected Command createAddCommand(EditPart childEditPart, Object constraint) {
		Activity activity = (Activity)childEditPart.getModel();
		Rectangle rect = (Rectangle) constraint;

		Command add = createAddCommand((EObject)getHost().getModel(), activity);
		add.setLabel(Messages.BPELXYLayoutEditPolicy_Add_Part_1); 
		add.setDebugLabel("BPEL Editor CreateInListCommand"); //$NON-NLS-1$

		// TODO: what does the following comment mean?
		// we need to check if we should preserve the size when adding that child
		
		rect.setSize(-1, -1);
		SetConstraintCommand setConstraint = new SetConstraintCommand(activity, rect.getLocation(), null);

		setConstraint.setLabel(Messages.BPELXYLayoutEditPolicy_Move_Part_2); 
		setConstraint.setDebugLabel("BPEL Editor setConstraintCommand"); //$NON-NLS-1$
		return add.chain(setConstraint);
	}

	protected Command createAddCommand(EObject parent, EObject child) {
		return new InsertInContainerCommand(parent, child, null);
	}
	@Override
	protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
		return new SetConstraintCommand(
			(Activity)child.getModel(), ((Rectangle)constraint).getLocation(), null);
	}

	protected Command createCreateCommand(EObject parent, final EObject child) {
		CompoundCommand c = new CompoundCommand();
		c.add(new InsertInContainerCommand(parent, child, null));
		c.add(new SetNameAndDirectEditCommand(child, getHost().getViewer()));
		return c;
	}

	@Override
	protected Command getDeleteDependantCommand(Request request) {
		return null;
	}

	@Override
	protected Command getOrphanChildrenCommand(Request request) {
		return null;
	}
	
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child){
		//if (child instanceof FlowEditPart)
		//	return new org.eclipse.gef.editpolicies.ResizableEditPolicy();
		return null;
	}
	
	@Override
	public EditPart getTargetEditPart(Request request) {
		// this policy only works for the BPEL Editor itself, not the outline
		if (getHost().getRoot() instanceof GraphicalBPELRootEditPart) {
			return super.getTargetEditPart(request);
		}
		return null;
	}

	/**
	 * TODO: THIS IS A TOTAL HACK
	 */
	@Override
	protected Rectangle getCurrentConstraintFor(GraphicalEditPart child) {
		Rectangle result = super.getCurrentConstraintFor(child);
		if (result == null && child instanceof BPELEditPart && (getHost() instanceof FlowEditPart)) {
			// We need a constraint but we don't have one.
			
			// Currently, calling refreshVisuals() on the child causes it to
			// poof up a constraint for itself if its parent is a flow and the
			// constraint is missing.  Ugly hack.
			((BPELEditPart)child).refreshVisuals();
			
			result = super.getCurrentConstraintFor(child);
		}
		return result;
	}

}