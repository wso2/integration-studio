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

import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;


/** 
 * Sets the faultName property of a model object.  This is supported for
 * Throw, Catch and Reply activities.
 */
public class SetFaultNameCommand extends SetCommand {

	public String getDefaultLabel() { return IBPELUIConstants.CMD_EDIT_FAULTNAME; }

	public SetFaultNameCommand(EObject target, String newFaultName)  {
		super(target, newFaultName);
	}

	@Override
	public Object get() {
		return ModelHelper.getFaultName(fTarget);
	}
	@Override
	public void set(Object o) {
		ModelHelper.setFaultName(fTarget, (String)o);
	}
}
