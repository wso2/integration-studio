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

import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.wst.wsdl.Definition;

/**
 * Creates a new Property in a WSDL file.
 * 
 * NOTE: Not to be confused with AddPropertyCommand which adds an existing Property to
 * a CorrelationSet!
 */
public class CreatePropertyCommand extends CreateWSDLExtensibilityElementCommand {

	@Override
	public String getDefaultLabel() { return IBPELUIConstants.CMD_ADD_PROPERTY; }

	public CreatePropertyCommand(Definition definition, Property property) {
		super(definition, property);
	}
	public CreatePropertyCommand(BPELEditor bpelEditor, Property property) {
		super(bpelEditor, property);
	}
}
