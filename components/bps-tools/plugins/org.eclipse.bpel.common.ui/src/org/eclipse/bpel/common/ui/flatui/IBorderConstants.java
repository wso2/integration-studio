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
package org.eclipse.bpel.common.ui.flatui;

/**
 * Constants for the types of border that can be painted around a widget
 * by BorderPainter.  The space for these borders is reserved by BorderLayout.
 */
public interface IBorderConstants {

	// NOTE: "2P2" etc. refers to the size of the border.  The first digit
	// is the size reserved on the left and top, the second is the size reserved
	// on the right and bottom.

	public static final int BORDER_DEFAULT = 0;
	public static final int BORDER_NONE = 1;
	public static final int BORDER_1P1_BLACK = 2;
	public static final int BORDER_1P1_SOFT  = 3;
	public static final int BORDER_1P2_BLACK = 4;
	public static final int BORDER_1P2_SOFT  = 5;
	public static final int BORDER_2P2_BLACK = 6;
	public static final int BORDER_2P2_SOFT  = 7;
	public static final int BORDER_2P2_BKGND = 8;

}
