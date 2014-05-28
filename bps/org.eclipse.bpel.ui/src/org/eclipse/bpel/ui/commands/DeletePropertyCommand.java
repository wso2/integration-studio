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
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.ui.IBPELUIConstants;
import org.eclipse.wst.wsdl.Definition;

/**
 * Deletes a Property from the shadow WSDL file.  Also deletes all propertyAliases to the property
 * and all references to the property or any of its propertyAliases.
 * 
 * NOTE: Not to be confused with AddPropertyCommand which adds an existing Property to
 * a CorrelationSet!
 */
public class DeletePropertyCommand extends DeleteWSDLExtensibilityElementCommand {

	CompoundCommand deleteAliasesCmd;

	/**
	 * @see org.eclipse.bpel.ui.commands.DeleteWSDLExtensibilityElementCommand#getDefaultLabel()
	 */
	@Override
	public String getDefaultLabel() { 
		return IBPELUIConstants.CMD_DELETE_PROPERTY; 
	}

	/**
	 * @param property
	 */
	public DeletePropertyCommand(Property property) {
		super(property);
	}

	/**
	 * @see org.eclipse.bpel.ui.commands.DeleteWSDLExtensibilityElementCommand#doExecute()
	 */
	@Override
	public void doExecute() {
		deleteAliasesCmd = new CompoundCommand();
		
		Property property = (Property) fElement;
		
		Definition definition = property.getEnclosingDefinition();
		
		for(Object n : definition.getEExtensibilityElements()) {
			if (n instanceof PropertyAlias) {
				PropertyAlias alias = (PropertyAlias)n;
				if (alias.getMessageType() == property) {
					deleteAliasesCmd.add(new DeletePropertyAliasCommand(alias));
				}
			}
		}
	
		deleteAliasesCmd.execute();
		super.execute();
	}
}
