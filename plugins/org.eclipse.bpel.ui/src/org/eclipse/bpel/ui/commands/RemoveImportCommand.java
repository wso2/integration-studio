/*******************************************************************************
 * Copyright (c) 2006, 2012 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.commands;

import java.util.List;

import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;

/**
 * Removes an import from the process.  
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 27, 2006
 *
 */
public class RemoveImportCommand extends RemoveFromListCommand {
	
	/**
	 * @param target
	 * @param oldElement
	 * @param cmdLabel
	 */
	public RemoveImportCommand (EObject target, Object oldElement, String cmdLabel) {
		super(target, oldElement, cmdLabel);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.bpel.ui.commands.RemoveFromListCommand#getList()
	 */
	@Override
	protected List getList() {
		return BPELUtils.getProcess( target ).getImports();
	}

}
