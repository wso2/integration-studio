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

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.TableTree;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;


/**
 * Superclass for border-aware layout classes such as FlatFormLayout.
 * Mainly useful for the getBorderType() method which selects the most
 * appropriate default border type based on the type of control passed
 * in.
 */
public abstract class BorderLayout extends Layout implements IBorderConstants {

	static final int BT_NONE = 0;
	static final int BT_1P1 = 1;
	static final int BT_1P2 = 2;
	static final int BT_2P2 = 3;
	static final int BT_BLACK = 1;
	static final int BT_SOFT = 2;
	static final int BT_BKGND = 3;

	static final int BorderColor[] = {
		BT_NONE, BT_NONE, BT_BLACK, BT_SOFT, BT_BLACK, BT_SOFT, BT_BLACK, BT_SOFT, BT_BKGND
	};
	static final int BorderShape[] = {
		BT_NONE, BT_NONE, BT_1P1, BT_1P1, BT_1P2, BT_1P2, BT_2P2, BT_2P2, BT_2P2
	};

	static final int LeftBorderSize[]   = { 0, 1, 1, 2 };
	static final int RightBorderSize[]  = { 0, 1, 2, 2 };
	static final int TopBorderSize[]    = { 0, 1, 1, 2 };
	static final int BottomBorderSize[] = { 0, 1, 2, 2 };

	public static final int getBorderType(int bt, Control control) {
		if (bt != BORDER_DEFAULT) return bt;
	
		if (control instanceof CLabel)  return BORDER_NONE; // TODO: added this line
		if (control instanceof Text)       return BORDER_2P2_BLACK;
		if (control instanceof Canvas)     return BORDER_2P2_BLACK;
		if (control instanceof CCombo)     return BORDER_2P2_BLACK;
		if (control instanceof StyledText) return BORDER_2P2_BLACK;
		if (control instanceof List)       return BORDER_2P2_BLACK;

		if (control instanceof Table)      return BORDER_1P1_BLACK;
		
		if (control instanceof Tree)       return BORDER_2P2_BLACK;
		if (control instanceof TableTree)  return BORDER_1P1_BLACK;
	
		return BORDER_NONE;
	}
}