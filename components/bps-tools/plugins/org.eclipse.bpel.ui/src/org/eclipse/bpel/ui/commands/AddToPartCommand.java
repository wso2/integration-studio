/*******************************************************************************
 * Copyright (c) 2007, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.commands;

import java.util.List;

import org.eclipse.bpel.model.BPELFactory;
import org.eclipse.bpel.model.ToPart;
import org.eclipse.bpel.model.ToParts;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Part;

/**
 * This command modifies the ToParts of Invoke / Reply. It handles the following scenarios:
 * 
 * (1) If the ToParts element of the target object doesn't contains a ToPart for the given Part
 * 	    - create a new ToPart
 * 		- set the given Part to the ToPart
 * 		- set the given variable to the ToPart's fromVariable
 * 		- add the new ToPart to the ToParts (ToParts will be created if necessary)
 * 
 * (2) If the ToParts element of the target object already contains a ToPart for the given Part
 *      - set the fromVariable of the existing ToPart to the given variable
 * 
 * @author Michael Illiger
 */
public class AddToPartCommand extends AutoUndoCommand {

	private Variable variable;
	private Part part;
	private EObject target;
	
	public AddToPartCommand(EObject target, Variable variable, Part part) {
		super("Set toPart", target);
		this.variable = variable;
		this.part = part;
		this.target = target;
	}

	private List<ToPart> getList() {
		ToParts toParts = ModelHelper.getToParts(target);
		return (toParts == null) ? null : toParts.getChildren();
	}

	private void createList() {
		ModelHelper.setToParts(target, BPELFactory.eINSTANCE.createToParts());
	}

	@Override
	public void doExecute() {
		if (this.part == null)
			throw new IllegalStateException();
		
		List<ToPart> list = getList();
		if (list == null || list.isEmpty()) {
			createList();
			list = getList();
		}
		
		for (ToPart toPart : list) {
			if (this.part.equals(toPart.getPart())) {
				// we already have a toPart for the given part -> just replace the variable
				toPart.setFromVariable(variable);
				return;
			}
		}
		
		// if we get here we need a new toPart
		ToPart toPart = BPELFactory.eINSTANCE.createToPart();
		toPart.setPart(part);
		toPart.setFromVariable(variable);
		
		list.add(toPart);
	}
	
}
