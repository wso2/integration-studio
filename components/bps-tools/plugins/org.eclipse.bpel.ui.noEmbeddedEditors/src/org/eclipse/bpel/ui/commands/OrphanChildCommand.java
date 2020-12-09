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

import org.eclipse.bpel.ui.adapters.IContainer;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.bpel.ui.util.BPELUtil;
import org.eclipse.emf.ecore.EObject;


/**
 * @author IBM Original Contribution.
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 16, 2007
 */

public class OrphanChildCommand extends AutoUndoCommand {

	private EObject fChild;
	private EObject fParent;
	private IContainer<EObject> fContainer;
	
	/**
	 * Brand new shiny OrphanChildCommand.
	 * @param child
	 */
	
	public OrphanChildCommand (EObject child) {
		super(child.eContainer());		
		fChild = child;
		fParent = child.eContainer();
		fContainer = BPELUtil.adapt(fParent, IContainer.class);
	}

	/**
	 * @see org.eclipse.bpel.ui.commands.util.AutoUndoCommand#canDoExecute()
	 */
	@Override
	public boolean canDoExecute() {
		if (fChild == null || fParent == null || fContainer == null)  {
			return false;
		}
		return true;
	}

	/**
	 * @see org.eclipse.bpel.ui.commands.util.AutoUndoCommand#doExecute()
	 */
	@Override
	public void doExecute() {
		if (!canExecute())  {
			throw new IllegalStateException();
		}		
		fContainer.removeChild(fParent, fChild);
	}
}
