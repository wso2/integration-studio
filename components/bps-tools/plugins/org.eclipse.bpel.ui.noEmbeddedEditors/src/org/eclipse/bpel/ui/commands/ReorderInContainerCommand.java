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
package org.eclipse.bpel.ui.commands;

import org.eclipse.bpel.ui.Messages;
import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;


/** 
 * Reorders a child within a parent object that implements IContainer.
 */
public class ReorderInContainerCommand extends AutoUndoCommand {

	protected Object child, parent, before;
	
	public ReorderInContainerCommand(EObject parent, Object child, Object before) {
		super(Messages.ReorderInContainerCommand_Reorder_1, parent); 
		this.child = child;
		this.parent = parent;
		this.before = before;
	}
	
	@Override
	public void doExecute() {
		IContainer container = BPELUtil.adapt(parent, IContainer.class);
		container.removeChild(parent, child); 
		container.addChild(parent, child, before);
	}
}
