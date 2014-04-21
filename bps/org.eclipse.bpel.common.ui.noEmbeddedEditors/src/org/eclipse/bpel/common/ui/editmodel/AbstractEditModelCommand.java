/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.editmodel;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.commands.Command;

/**
 * Default implementation of IEditModelCommand. Clients of EditModel framework
 * can either subclass AbstractEditModelCommand or implement IEditModelCommand
 */
public abstract class AbstractEditModelCommand extends Command implements
		IEditModelCommand {

	protected static Resource[] EMPTY_RESOURCE_ARRAY = new Resource[0];

	/**
	 * 
	 */
	
	public AbstractEditModelCommand() {
		super();
	}

	/**
	 * @param label
	 */
	public AbstractEditModelCommand (String label) {
		super(label);
	}

	/**
	 * @see org.eclipse.bpel.common.ui.editmodel.IEditModelCommand#getResources()
	 */
	public Resource[] getResources() {
		return EMPTY_RESOURCE_ARRAY;
	}

	/**
	 * @see org.eclipse.bpel.common.ui.editmodel.IEditModelCommand#getModifiedResources()
	 */
	public Resource[] getModifiedResources() {
		return getResources();
	}

}
