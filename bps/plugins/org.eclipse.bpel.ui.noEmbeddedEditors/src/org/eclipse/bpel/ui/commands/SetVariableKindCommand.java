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
import org.eclipse.bpel.ui.uiextensionmodel.VariableExtension;


/**
 * Sets the VariableKind property in a VariableExtension.
 */
public class SetVariableKindCommand extends SetCommand {

	public String getDefaultLabel() { return IBPELUIConstants.CMD_EDIT_VARIABLE_TYPE; }

	public SetVariableKindCommand(VariableExtension target, int newKind) {
		super(target, Integer.valueOf(newKind));
	}

	@Override
	public Object get() {
		return Integer.valueOf(((VariableExtension)fTarget).getVariableKind());
	}
	@Override
	public void set(Object o) {
		((VariableExtension)fTarget).setVariableKind(((Integer)o).intValue());
	}
}
