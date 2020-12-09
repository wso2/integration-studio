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
package org.eclipse.bpel.common.ui.details;

/**
 * Constants used by the DetailsArea and/or implementors of IDetailsSection.
 */
public interface IDetailsAreaConstants {

	/**
	 * These values are used for the margin around the DetailsArea composite.
	 * Each details section should use a margin of 0, 0.
	 */
	public static final int HMARGIN = 6;
	public static final int VMARGIN = 6;

	/**
	 * Space to leave between related widgets.  Each details section should
	 * use these values for spacing its widgets.  For example, you can use
	 * +/- HSPACE as the offset of a left or right FlatFormAttachment.
	 * 
	 * The DetailsArea composite also inserts VSPACE pixels between section
	 * composites if more than one section is displayed.  
	 */
	public static final int HSPACE = 5;
	public static final int VSPACE = 4;

	/**
	 * Space to leave between the center of the details page and the closest
	 * widget to the left or right.  I.e. for a details page whose widgets are
	 * logically divided into two halves, the total space between the halves
	 * should be 2*CENTER_SPACE.
	 */
	public static final int CENTER_SPACE = 10;

	// error codes
	public static final int MISSING_ATTRIBUTE = 1;
	public static final int COULD_NOT_INSTANTIATE_SECTION = 2;
	public static final int EDITOR_DOES_NOT_EXIST = 3;
	public static final int PAGE_DOES_NOT_EXIST = 4;
}
