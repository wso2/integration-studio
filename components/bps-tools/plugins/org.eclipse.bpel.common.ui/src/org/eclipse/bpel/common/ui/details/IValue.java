/*******************************************************************************
 * Copyright (c) 2006 Oracle Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.ui.details;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jul 27, 2007
 *
 */
public interface IValue {
	
	/**
	 * Get a value.
	 * @return the value held
	 */
	Object get ();
	
	/**
	 * Set a value
	 * @param object the value to set
	 */
	void set (Object object);
}
