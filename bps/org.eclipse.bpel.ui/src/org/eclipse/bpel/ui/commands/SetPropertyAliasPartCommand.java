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

/**
 * Command to set the Part property of a PropertyAlias.
 */
public class SetPropertyAliasPartCommand extends SetCommand {

	// TODO: label?

	public SetPropertyAliasPartCommand(PropertyAlias target, String newPartName) {
		super(target, newPartName);
	}

	@Override
	public Object get() {
		return ((PropertyAlias)fTarget).getPart();
	}

	@Override
	public void set(Object o) {
		((PropertyAlias)fTarget).setPart((String)o);
	}
}
