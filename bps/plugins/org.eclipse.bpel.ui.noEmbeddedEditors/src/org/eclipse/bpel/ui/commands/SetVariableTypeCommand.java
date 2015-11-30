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

import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;


public class SetVariableTypeCommand extends SetCommand {

	public String getDefaultLabel() { return IBPELUIConstants.CMD_EDIT_VARIABLE_TYPE; }

	public SetVariableTypeCommand(Variable target, EObject newVariableType)  {
		super(target, newVariableType);
	}
	
	@Override
	public Object get() {
		Object o = ((Variable)fTarget).getMessageType();
		if (o == null) {
			o = ((Variable)fTarget).getType();
		}
		if (o == null) {
			o = ((Variable)fTarget).getXSDElement();
		}
		return o;
	}
	
	@Override
	public void set(Object o) {
		Variable variable = (Variable)fTarget;
		if (o instanceof Message) {
			variable.setMessageType((Message)o);
		} else {
			variable.setMessageType(null);
		}
		if (o instanceof XSDTypeDefinition) {
			variable.setType((XSDTypeDefinition)o);
		} else {
			variable.setType(null);
		}
		if (o instanceof XSDElementDeclaration) {
			variable.setXSDElement((XSDElementDeclaration)o);
		} else {
			variable.setXSDElement(null);
		}
	}
}
