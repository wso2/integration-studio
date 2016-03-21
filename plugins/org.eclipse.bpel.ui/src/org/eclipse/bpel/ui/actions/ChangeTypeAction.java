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
package org.eclipse.bpel.ui.actions;

import java.util.List;

import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.editparts.BPELEditPart;
import org.eclipse.bpel.ui.editparts.OutlineTreeEditPart;
import org.eclipse.bpel.ui.extensions.ActionDescriptor;
import org.eclipse.bpel.ui.extensions.BPELUIRegistry;
import org.eclipse.bpel.ui.factories.AbstractUIObjectFactory;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.IWorkbenchPart;


public class ChangeTypeAction extends SelectionAction {

	protected AbstractUIObjectFactory factory;
	
	public ChangeTypeAction(IWorkbenchPart editor, AbstractUIObjectFactory factory) {
		this(editor, factory, factory.getTypeLabel());
	}
	
	public ChangeTypeAction(IWorkbenchPart editor, AbstractUIObjectFactory factory, String label) {
		super(editor);
		this.factory = factory;
		setId(calculateID());
		setText(label);
		setToolTipText(NLS.bind(Messages.ChangeTypeAction_Change_type_to_1, (new Object[] { getText() }))); 
		setImageDescriptor(factory.getSmallImageDescriptor());
	}

	protected String calculateID() {
		return "changeType." + factory.getUniqueIdString(); //$NON-NLS-1$
	}
	
	@Override
	protected boolean calculateEnabled() {
		// TODO: there should be a better way that doesn't do as much work.
		Command cmd = createReplaceInListCommand(getSelectedObjects());
		if (cmd == null)
			return false;
		return cmd.canExecute();
	}

	private Command createReplaceInListCommand(List list) {
		if (list.isEmpty())
			return null;
		//Command can only be executed on single selection
		if (list.size() != 1)
			return null;			
		if (!(list.get(0) instanceof BPELEditPart) &&
			(!(list.get(0) instanceof OutlineTreeEditPart)))
			return null;
		EditPart editPart = (EditPart) list.get(0);
		EClass editPartModelEClass = ((EObject)editPart.getModel()).eClass();
		// should not offer to change to the same type - makes no sense
		if (editPartModelEClass == factory.getModelType()) {
			return null;
		}
		// A BPEL action can only be changed into another BPEL action.
		boolean isToTypeAnAction = BPELUtil.isBPELAction(factory.getModelType());
		boolean isFromTypeAnAction = BPELUtil.isBPELAction(editPartModelEClass);
		if (isFromTypeAnAction || isToTypeAnAction) {
			if (isFromTypeAnAction && isToTypeAnAction) {
				ActionDescriptor desc = BPELUIRegistry.getInstance().getActionDescriptor(factory.getModelType());
				if (desc != null) {
					Object parent = editPart.getParent().getModel();
					Object current = editPart.getModel();
					Object newType = factory.createInstance();
					return desc.getAction().getChangeActionTypeCommand(parent, current, newType);
				}
			}
			return null;
		}

		//Use create request (handles using create factory to make the new element)
		//But override the type to indicate change type, not adding new element
		CreateRequest request = new CreateRequest();
		request.setType("changeType"); //$NON-NLS-1$
		request.setFactory(factory);

		//Get the command from the edit part
		return editPart.getCommand(request);		
	}

	@Override
	public void run() {
		execute(createReplaceInListCommand(getSelectedObjects()));
	}
}
