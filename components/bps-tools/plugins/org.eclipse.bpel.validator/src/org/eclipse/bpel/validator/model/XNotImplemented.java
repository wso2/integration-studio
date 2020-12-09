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
package org.eclipse.bpel.validator.model;

/**
 * This is runtime exception that is thrown my IModelQuery when 
 * a particular lookup is not implemented.
 * <p>
 * Note that this is a subclass of RuntimeException 
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Apr 3, 2007
 *
 */

public class XNotImplemented extends RuntimeException {

	/**
	 * @param string
	 */
	public XNotImplemented(String string) {
		super(string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2359596224592073955L;

	
}
