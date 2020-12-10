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

import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;

/** 
 * Set the operation on any of the partner interaction activities.
 * In addition to setting the operation, the portType is set, as it is
 * the parent of the operation.
 */

public class SetOperationCommand extends SetCommand {

	public String getDefaultLabel() { return IBPELUIConstants.CMD_SELECT_OPERATION; }

	public SetOperationCommand(EObject target, Operation newOperation)  {
		super(target, newOperation);
	}

	@Override
	public Object get() {
		return ModelHelper.getOperation(fTarget);
	}
	@Override
	public void set(Object o) {
		Operation op = (Operation) o;
		ModelHelper.setOperation(fTarget, op);
		 
		if (op == null) {
			ModelHelper.setPortType(fTarget, null);
		} else {
			PortType portType = (PortType) op.eContainer();
			ModelHelper.setPortType(fTarget, portType);
		}
	}
}
