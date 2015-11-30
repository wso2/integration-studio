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

import org.eclipse.bpel.model.CorrelationSet;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.emf.common.util.EList;


/**
 * Adds a Property to a CorrelationSet.
 * 
 * NOTE: Not to be confused with CreatePropertyCommand which creates a new property in the
 * artifacts WSDL file.
 */
public class AddPropertyCommand extends AddToListCommand {

	public AddPropertyCommand(CorrelationSet target, Property newProperty) {
		super(target, newProperty, IBPELUIConstants.CMD_ADD_PROPERTY);
	}

	@Override
	protected EList<Property> getList() {
		return ((CorrelationSet)target).getProperties();
	}
}
