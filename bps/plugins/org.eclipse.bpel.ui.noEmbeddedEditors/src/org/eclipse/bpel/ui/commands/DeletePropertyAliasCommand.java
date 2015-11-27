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
import org.eclipse.bpel.ui.IBPELUIConstants;


/**
 * Deletes a PropertyAlias from the shadow WSDL file.  Also deletes all non-containment
 * references to the propertyAlias.
 */
public class DeletePropertyAliasCommand extends DeleteWSDLExtensibilityElementCommand {

	@Override
	public String getDefaultLabel() { return IBPELUIConstants.CMD_DELETE_PROPERTY_ALIAS; }

	public DeletePropertyAliasCommand(PropertyAlias propertyAlias) {
		super(propertyAlias);
	}
}
