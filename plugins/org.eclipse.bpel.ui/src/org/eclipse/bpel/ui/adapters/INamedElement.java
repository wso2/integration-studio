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
package org.eclipse.bpel.ui.adapters;

import org.eclipse.emf.common.notify.Notification;

/**
 * An INamedElement provides a common API for accessing the
 * name of a model element.
 */
public interface INamedElement {
	/**
	 * Return the name of the given element. The name may
	 * be null.
	 */
	public String getName(Object modelObject);
	
	/**
	 * Set the name of the element to the given string.
	 * The string may be null;
	 */
	public void setName(Object modelObject, String name);
	
	/**
	 * Returns true if the given notification affects the name of the model element. 
	 */
	public boolean isNameAffected(Object modelObject, Notification n);
}
