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
package org.eclipse.bpel.ui.util;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Nov 6, 2006
 *
 */

public interface IGate {

	/**
	 * Turns the gate on.
	 *
	 */
	public void on () ;
	
	/** 
	 * Turns the gate off.
	 *
	 */
	public void off ();

}
