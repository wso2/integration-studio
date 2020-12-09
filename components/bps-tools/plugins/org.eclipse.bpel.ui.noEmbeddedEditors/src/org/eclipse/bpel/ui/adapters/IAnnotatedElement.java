/*******************************************************************************
 * Copyright (c) 2007, 2012 Intel Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Oleg Danilov, Intel - Initial API and Implementation
 *
 *******************************************************************************/

package org.eclipse.bpel.ui.adapters;

public interface IAnnotatedElement {
	/**
	 * Return a summary of the given model object properties. 
	 * The returned array lists the properties in such order: name,value,name,value... 
	 */
	public String[] getAnnotation(Object object);
}
