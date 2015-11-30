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
import org.eclipse.emf.ecore.EObject;


/**
 * Command to set the Type property of a Property.  Currently we expect this
 * to be an XSDTypeDefinition or an XSDElementDeclaration.
 */
public class SetPropertyTypeCommand extends SetCommand {

	// TODO: label?

	public SetPropertyTypeCommand(Property target, EObject newType) {
		super(target, newType);
	}

	@Override
	public Object get() {
		return ((Property)fTarget).getType();
	}

	@Override
	public void set(Object o) {
		((Property)fTarget).setType(o);
	}
}
