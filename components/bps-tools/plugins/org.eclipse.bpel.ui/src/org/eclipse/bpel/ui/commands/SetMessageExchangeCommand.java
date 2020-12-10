/**
 * <copyright>
 * Copyright (c) 2008, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 */
 
package org.eclipse.bpel.ui.commands;

import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.bpel.ui.util.ModelHelper;
import org.eclipse.emf.ecore.EObject;

/**
 * 
 * @author Miriam Grundig (MGrundig@de.ibm.com)
 *
 */
public class SetMessageExchangeCommand extends SetCommand {

	public String getDefaultLabel() { 
		return IBPELUIConstants.CMD_SELECT_MESSAGE_EXCHANGE;
	}

	public SetMessageExchangeCommand(EObject target, MessageExchange newMessageExchange)  {
		super(target, newMessageExchange);
	}

	@Override
	public Object get() {
		return ModelHelper.getMessageExchange(fTarget);
	}
	
	@Override
	public void set(Object o) {
	    MessageExchange me = (MessageExchange)o;
		ModelHelper.setMessageExchange(fTarget, me);
	}
}
