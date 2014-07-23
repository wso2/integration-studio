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

import org.eclipse.gef.palette.PaletteGroup;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date May 29, 2007
 *
 */
public class OrderedPaletteGroup extends PaletteGroup implements IOrderedPaletteEntry {

	/** Order of palette entry */
	protected int fOrder = 100;
	
	/** the default category id */
	protected String fCategoryId = "group.default"; //$NON-NLS-1$
	
	
	/**
	 * Brand new shiny Ordered Palette Group. This is a regular palette group but with ordering information.
	 * 
	 * @param label the name of the group.
	 */
	
	public OrderedPaletteGroup (String label) {
		super(label);		
	}
	
	/**
	 * Return the order of this palette category within the palette.
	 * 
	 * @return the palette category entry.
	 */
	
	public int getOrder () {
		return fOrder;
	}

	/**
	 * Set the order of this palette category entry.
	 * 
	 * @param anOrder
	 */
	
	public void setOrder (int anOrder ) {
		fOrder = anOrder;
	}
	
	/** 
	 * Return the category id of this category.
	 * 
	 * @return the category id.
	 */
	
	public String getCategoryId ( ) {		
		return fCategoryId;
	}
	
	
	/**
	 * Set the category Id.
	 * 
	 * @param aCategoryId the category id for this category.
	 */
	public void setCategoryId ( String aCategoryId ) {
		fCategoryId = aCategoryId;
	}
	

}
