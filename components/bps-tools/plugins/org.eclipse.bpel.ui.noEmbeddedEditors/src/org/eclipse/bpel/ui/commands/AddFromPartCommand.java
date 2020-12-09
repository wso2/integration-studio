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
import org.eclipse.bpel.model.FromPart;
import org.eclipse.bpel.model.FromParts;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Part;

/**
 * This command modifies the FromParts of an Invoke / Receive / OnEvent / OnMessage. It handles the
 * following scenarios:
 * 
 * (1) If the FromParts element of the target object doesn't contains a FromPart for the given Part 
 *  	- create a new FromPart - set the given Part to the FromPart
 *  	- set the given variable to the FromPart's toVariable 
 *  	- add the new FromPart to the FromParts (FromParts will be created if necessary)
 * 
 * (2) If the FromParts element of the target object already contains a FromPart for the given Part 
 * 		- set the toVariable of the existing FromPart to the given variable
 * 
 * @author Michael Illiger
 */
public class AddFromPartCommand extends AutoUndoCommand {

	private Variable variable;
	private Part part;
	private EObject target;
	
	public AddFromPartCommand(EObject target, Variable variable, Part part) {
		super("Set fromPart", target);
		this.variable = variable;
		this.part = part;
		this.target = target;
	}

	private List<FromPart> getList() {
		FromParts fromParts = ModelHelper.getFromParts(target);
		return (fromParts == null) ? null : fromParts.getChildren();
	}

	private void createList() {
		ModelHelper.setFromParts(target, BPELFactory.eINSTANCE.createFromParts());
	}
	
	private void deleteList() {
		ModelHelper.setFromParts(target, null);
	}

	@Override
	public void doExecute() {
		if (this.part == null)
			throw new IllegalStateException();
		
		List<FromPart> list = getList();
		if (list == null || list.isEmpty()) {
			createList();
			list = getList();
		}
		
		for (FromPart fromPart : list) {
			if (this.part.equals(fromPart.getPart())) {
				// we already have a fromPart for the given part -> just replace the variable
				fromPart.setToVariable(variable);
				return;
			}
		}
		
		// if we get here we need a new fromPart
		FromPart fromPart = BPELFactory.eINSTANCE.createFromPart();
		fromPart.setPart(part);
		fromPart.setToVariable(variable);
		
		list.add(fromPart);
	}
	
}
