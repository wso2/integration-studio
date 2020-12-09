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
package org.eclipse.bpel.common.ui.palette;

import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * Model object for a palette category.
 */
public class PaletteCategory extends PaletteDrawer implements IOrderedPaletteEntry {

	protected ToolEntry defaultTool;
	
	/** The relative position of this category within the palette */
	protected int fOrder = 10;
	
	/** The category id */
	protected String fCategoryId = "bpel.user"; //$NON-NLS-1$
	
	/**
	 * Create a brand new PaletteCategory label.
	 * 
	 * @param label
	 */
	
	public PaletteCategory (String label) {
		this(label, null);
	}

	/**
	 * Create a brand new Palette Category with the label and an Image 
	 * 
	 * @param label the label
	 * @param icon the icon
	 */
	public PaletteCategory(String label, ImageDescriptor icon) {
		super(label, icon);
	}

	/**
	 * Return the default tool for this Palette Category.
	 * @return the default tool.
	 */
	
	public ToolEntry getDefaultTool() {
		if (defaultTool != null) {
			return defaultTool;
		}
		if (getChildren().size() > 0) {
			return (ToolEntry) getChildren().get(0);
		}
		return null;
	}

	/**
	 * Set the default tool.
	 * 
	 * @param entry
	 */
	
	public void setDefaultTool(ToolEntry entry) {
		defaultTool = entry;
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
