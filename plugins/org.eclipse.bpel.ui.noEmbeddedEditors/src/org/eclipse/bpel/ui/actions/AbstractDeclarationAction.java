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
package org.eclipse.bpel.ui.actions;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.PartnerLinks;
import org.eclipse.bpel.ui.actions.editpart.AbstractAction;
import org.eclipse.bpel.ui.commands.CompoundCommand;
import org.eclipse.bpel.ui.commands.InsertInContainerCommand;
import org.eclipse.bpel.ui.commands.SetNameAndDirectEditCommand;
import org.eclipse.bpel.ui.commands.SetSelectionCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * A class for actions that create scope "declarations", i.e. variables, partnerlinks,
 * messageExchanges and correlationSets.
 * 
 * @author bbrodt
 * @see https://issues.jboss.org/browse/JBIDE-7953
 *
 */
public abstract class AbstractDeclarationAction extends AbstractAction {

	protected EObject parent;
	protected EObject child;
	
	public AbstractDeclarationAction(EditPart anEditPart) {
		super(anEditPart);
	}

	@Override
	public boolean onButtonPressed() {
		parent = getParent();
		child = getChild();
		if (parent==null || child==null)
			return false;

		InsertInContainerCommand insertCmd = new InsertInContainerCommand(parent, child, null);
		CompoundCommand command = new CompoundCommand(insertCmd.getLabel());
		command.add( insertCmd ); 
		command.add( new SetSelectionCommand ( parent, true ) );
		command.add( new SetSelectionCommand ( child, false ) );
		command.add(new SetNameAndDirectEditCommand(child, viewer));
		ModelHelper.getBPELEditor(modelObject).getCommandStack().execute(command);
		return true;
	}

	@Override
	public String getToolTip() {
		return getChild().eClass().getName();
	}

	public abstract EObject getParent();
	public abstract EObject getChild();
}
