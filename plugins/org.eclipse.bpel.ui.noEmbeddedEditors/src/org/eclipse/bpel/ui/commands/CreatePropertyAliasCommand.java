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

import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.ui.BPELEditor;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.wst.wsdl.Definition;

/**
 * Creates a new PropertyAlias in a WSDL file.
 */
public class CreatePropertyAliasCommand extends CreateWSDLExtensibilityElementCommand {

	@Override
	public String getDefaultLabel() { return IBPELUIConstants.CMD_ADD_PROPERTY_ALIAS; }

	public CreatePropertyAliasCommand(Definition definition, PropertyAlias propertyAlias) {
		super(definition, propertyAlias);
	}
	public CreatePropertyAliasCommand(BPELEditor bpelEditor, PropertyAlias propertyAlias) {
		super(bpelEditor, propertyAlias);
	}
}
