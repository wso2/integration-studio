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

import org.eclipse.bpel.model.ForEach;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.emf.ecore.EObject;


/** 
 * Sets the the forEach isParallel flag.
 */
public class SetForEachIsParallelCommand extends SetCommand {

	public String getDefaultLabel() { return IBPELUIConstants.CMD_SET_PARALLEL_EXECUTION; }

	public SetForEachIsParallelCommand(EObject forEach, boolean isParallel)  {
		super(forEach, Boolean.valueOf( isParallel ));
	}

	@Override
	public Object get() {
		return ((ForEach)fTarget).getParallel();
	}
	
	@Override
	public void set(Object o) {
		((ForEach)fTarget).setParallel(((Boolean)o).booleanValue());
	}
}
