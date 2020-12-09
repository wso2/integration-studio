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

import org.eclipse.gef.palette.PaletteRoot;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 21, 2007
 *
 */
public interface IPaletteProvider {

	/**
	 * Contribute the palette items the the palette root.
	 * 
	 * @param paletteRoot
	 */
	
	public void contributeItems ( PaletteRoot paletteRoot );

}
