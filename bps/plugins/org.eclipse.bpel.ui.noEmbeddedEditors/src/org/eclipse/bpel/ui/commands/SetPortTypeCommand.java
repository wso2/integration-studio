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

import org.eclipse.wst.wsdl.PortType;

/** 
 * Sets the "portType" property of a model object.  This is supported for
 * Invoke/Receive/Reply activities.  It should also set the "operation" property
 * of a model object, since the old value is no longer valid.
 */
public class SetPortTypeCommand extends SetCommand {

	public String getDefaultLabel() { return IBPELUIConstants.CMD_SELECT_PORTTYPE; }

	public SetPortTypeCommand(EObject target, PortType newPortType)  {
		super(target, newPortType);
	}

	@Override
	public Object get() {
		return ModelHelper.getPortType(fTarget);
	}
	
	@Override
	public void set(Object o) {
		ModelHelper.setPortType(fTarget, (PortType)o);
	}
}
