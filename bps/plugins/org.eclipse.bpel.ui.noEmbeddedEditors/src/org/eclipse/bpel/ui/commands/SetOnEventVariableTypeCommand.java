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

import org.eclipse.bpel.model.OnEvent;
import org.eclipse.bpel.ui.commands.util.AutoUndoCommand;
import org.eclipse.wst.wsdl.Input;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.Part;
import org.eclipse.xsd.XSDElementDeclaration;

public class SetOnEventVariableTypeCommand extends SetCommand {
	
	public SetOnEventVariableTypeCommand(OnEvent onEvent) {
		super(onEvent,null);
	}
	
	@Override
	public void doExecute() {
		if (fTarget instanceof OnEvent) {
			OnEvent onEvent = (OnEvent) fTarget;
			if (onEvent.getVariable() == null) {
				onEvent.setMessageType(null);
			} else {
				if (fNewValue instanceof XSDElementDeclaration) {
					onEvent.setMessageType(null);
					onEvent.setXSDElement((XSDElementDeclaration)fNewValue);
				}
				else {
					Message message = null;
					if (onEvent.getOperation() != null) {
						Operation op = onEvent.getOperation();
						if (op != null) {
							Input input = op.getEInput();
							if (input != null) {
								message = input.getEMessage();
							}
						}
					}
					onEvent.setMessageType(message);
					onEvent.setXSDElement(null);
				}
			}
		}
	}
}