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
package org.eclipse.bpel.common.ui.palette;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 29, 2007
 *
 */
public interface IOrderedPaletteEntry {

	/**
	 * Return the order of this palette entry within the palette.
	 * 
	 * @return the order (lower means first).
	 */
	
	int getOrder ();
	
	
	
	/**
	 * Return the category id.
	 * 
	 * @return the category id.
	 */
	
	String getCategoryId ();
}
