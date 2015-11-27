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

import java.util.List;

import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.ui.IBPELUIConstants;


/**
 * Removes a Property from a CorrelationSet.
 * 
 * NOTE: Not to be confused with DeletePropertyCommand which deletes the property, and any
 * property aliases for it, from a WSDL file.
 */
public class RemovePropertyCommand extends RemoveFromListCommand {

	public RemovePropertyCommand(CorrelationSet target, Property oldProperty) {
		super(target, oldProperty, IBPELUIConstants.CMD_REMOVE_PROPERTY);
	}

	@Override
	protected List getList() {
		return ((CorrelationSet)target).getProperties();
	}
}
