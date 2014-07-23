/*******************************************************************************
 * Copyright (c) 2006, 2012 IBM Corporation and others.
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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;


/**
 * Removes a Variable from a Validate.
 */
public class RemoveValidateVariableCommand extends RemoveFromListCommand {

	public RemoveValidateVariableCommand(EObject target, Variable oldVariable) {
		super(target, oldVariable, IBPELUIConstants.CMD_DELETE_VALIDATE_VARIABLE);
	}

	@Override
	protected EList<Variable> getList() {
		EList<Variable> l = ModelHelper.getValidateVariables(target);
		return (l == null)? null : l;
	}

	@Override
	protected void deleteList() {
		EList<Variable> l = ModelHelper.getValidateVariables(target);
		if (l != null)
			l.clear();
	}
}
