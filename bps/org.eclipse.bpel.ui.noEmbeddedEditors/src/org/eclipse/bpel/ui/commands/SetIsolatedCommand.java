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

import org.eclipse.bpel.model.Scope;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.emf.ecore.EObject;


/** 
 * Sets the "isolated" property of a Scope.
 */
public class SetIsolatedCommand extends SetCommand {

	public String getDefaultLabel() { return IBPELUIConstants.CMD_SELECT_ISOLATED; }

	public SetIsolatedCommand(EObject target, Boolean isolated)  {
		super(target, isolated);
	}

	@Override
	public Object get() {
		return ((Scope)fTarget).getIsolated();
	}
	@Override
	public void set(Object o) {
		((Scope)fTarget).setIsolated((Boolean)o);
	}
}
