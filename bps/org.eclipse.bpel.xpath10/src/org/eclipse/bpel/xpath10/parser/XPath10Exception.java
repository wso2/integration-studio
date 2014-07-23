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

package org.eclipse.bpel.xpath10.parser;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jun 23, 2008
 */
public class XPath10Exception extends Error {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7269923697850123266L;

	int fPosition = 0;
	/**
	 * @param message
	 * @param cause
	 * @param position
	 */
	
	public XPath10Exception(String message, Throwable cause, int position ) {
		super(message, cause);
		fPosition = position;
	}
	
	/**
	 * @return the position within the input stream where the exception has occurred.
	 */
	public int getPosition () {
		return fPosition;
	}
	
}
