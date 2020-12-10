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
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;


/** 
 * Sets a variable property of a model object.
 * 
 * Invoke activities have an inputVariable, which corresponds to the variable
 * of a Reply activity (i.e. it's used for "outgoing" messages).
 * 
 * Invoke activities also have an outputVariable, which corresponds to the
 * variable of a Receive activity (i.e. it's used for "incoming" messages).
 */
public class SetVariableCommand extends SetCommand {

	int direction;
	
	public int getDirection() {
		return direction;
	}

	public String getDefaultLabel() { return IBPELUIConstants.CMD_SELECT_VARIABLE; }

	public SetVariableCommand(EObject target, Variable newVariable) {
		this(target,newVariable,ModelHelper.NOT_SPECIFIED);
	}
	
	public SetVariableCommand(EObject target, Variable newVariable, int direction)  {
		super(target, newVariable);
		this.direction = direction;		
	}

	@Override
	public Object get() {
		return ModelHelper.getVariable(fTarget, direction);
	}
	@Override
	public void set(Object o) {
		ModelHelper.setVariable(fTarget, (Variable)o, direction);
	}
}
