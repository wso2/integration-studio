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
 
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public final class FlatFormLayout extends BorderLayout {
	/**
	 * marginWidth specifies the number of pixels of horizontal margin
	 * that will be placed along the left and right edges of the layout.
	 *
	 * The default value is 0.
	 */
	public int marginWidth = 0;
	/**
	 * marginHeight specifies the number of pixels of vertical margin
	 * that will be placed along the top and bottom edges of the layout.
	 *
	 * The default value is 0.
	 */
	public int marginHeight = 0;
	
/**
 * Constructs a new instance of this class.
 */
public FlatFormLayout () {
}

/**
 * Computes the preferred height of the form with
 * respect to the preferred height of the control.
 * 
 * Given that the equations for top (T) and bottom (B)
 * of the control in terms of the height of the form (X)
 * are:
 *		T = AX + B
 *		B = CX + D
 * 
 * The equation for the height of the control (H)
 * is bottom (B) minus top (T) or (H = B - T) or:
 * 
 *		H = (CX + D) - (AX + B)
 * 
 * Solving for (X), the height of the form, we get:
 * 
 *		X = (H + B - D) / (C - A)
 * 
 * When (A = C), (C - A = 0) and the equation has no
 * solution for X.  This is a special case meaning that
 * the control does not constrain the height of the
 * form.  In this case, we need to arbitrarily define
 * the height of the form (X):
 * 
 * Case 1: A = C, A = 0, C = 0
 *
 * 		Let X = D, the distance from the top of the form
 * 		to the bottom edge of the control.  In this case,
 * 		the control was attatched to the top of the form
 * 		and the form needs to be large enough to show the
 * 		bottom edge of the control.
 * 
 * Case 2: A = C, A = 1, C = 1
 * 
 * 		Let X = -B, the distance from the bottom of the
 *		form to the top edge of the control.  In this case,
 * 		the control was attached to the bottom of the form
 * 		and the only way that the control would be visible
 * 		is if the offset is negative.  If the offset is
 * 		positive, there is no possible height for the form
 * 		that will show the control as it will always be
 * 		below the bottom edge of the form.
 * 
 * Case 3: A = C, A != 0, C != 0 and A != 1, C != 0
 * 
 * 		Let X = D / (1 - C), the distance from the top of the 
 * 		form to the bottom edge of the control.  In this case, 
 * 		since C is not 0 or 1, it must be a fraction, U / V.  
 * 		The offset D is the distance from CX to the bottom edge 
 * 		of the control.  This represents a fraction of the form 
 * 		(1 - C)X. Since the height of a fraction of the form is 
 * 		known, the height of the entire form can be found by setting
 * 		(1 - C)X = D.  We solve this equation for X in terms of U 
 * 		and V, giving us X = (U * D) / (U - V). Similarily, if the 
 * 		offset D is	negative, the control is positioned above CX.
 * 		The offset -B is the distance from the top edge of the control
 * 		to CX. We can find the height of the entire form by setting 
 * 		CX = -B. Solving in terms of U and V gives us X = (-B * V) / U.
 */
int computeHeight (FlatFormData data) {
	FlatFormAttachment top = data.getTopAttachment ();
	FlatFormAttachment bottom = data.getBottomAttachment ();
	FlatFormAttachment height = bottom.minus (top);
	if (height.numerator == 0) {
		if (bottom.numerator == 0) return bottom.offset;
		if (bottom.numerator == bottom.denominator) return -top.offset;
		if (bottom.offset <= 0) {
			return -top.offset * top.denominator / bottom.numerator;
		}
		int divider = bottom.denominator - bottom.numerator; 
		return bottom.denominator * bottom.offset / divider;
	}
	return height.solveY (data.cacheHeight);
}

@Override
protected Point computeSize (Composite composite, int wHint, int hHint, boolean flushCache) {
	Point size = layout (composite, false, 0, 0, 0, 0, flushCache);
	size.x += marginWidth * 2;
	size.y += marginHeight * 2;
	return size;
}

/**
 * Computes the preferred height of the form with
 * respect to the preferred height of the control.
 */
int computeWidth (FlatFormData data) {
	FlatFormAttachment left = data.getLeftAttachment ();
	FlatFormAttachment right = data.getRightAttachment ();
	FlatFormAttachment width = right.minus (left);
	if (width.numerator == 0) {
		if (right.numerator == 0) return right.offset;
		if (right.numerator == right.denominator) return -left.offset;
		if (right.offset <= 0) {
			return -left.offset * left.denominator / left.numerator;
		}
		int divider = right.denominator - right.numerator; 
		return right.denominator * right.offset / divider;
	}
	return width.solveY (data.cacheWidth);
}

Point getSize (Control control, boolean flushCache) {
	int wHint = SWT.DEFAULT, hHint = SWT.DEFAULT;
	FlatFormData data = (FlatFormData) control.getLayoutData ();
	if (data != null) {
		wHint = data.width;
		hHint = data.height;
	}
	/* Reserve additional space here for the border! */
	Point pt = control.computeSize (wHint, hHint, flushCache);
	int bshape = BorderShape[getBorderType(
		(data==null)? BORDER_DEFAULT : data.borderType, control)];
	pt.x += LeftBorderSize[bshape] + RightBorderSize[bshape];
	pt.y += TopBorderSize[bshape] + BottomBorderSize[bshape];
	return pt;
}

@Override
protected void layout (Composite composite, boolean flushCache) {
	Rectangle rect = composite.getClientArea ();
	int x = rect.x + marginWidth;
	int y = rect.y + marginHeight;
	int width = Math.max (0, rect.width - 2 * marginWidth);
	int height = Math.max (0, rect.height - 2 * marginHeight);
	layout (composite, true, x, y, width, height, flushCache);
}

Point layout (Composite composite, boolean move, int x, int y, int width, int height, boolean flushCache) {
	Control [] children = composite.getChildren ();
	for (int i = 0; i < children.length; i++) {
		Control child = children [i];
		Point pt = getSize (child, false);
		FlatFormData data = (FlatFormData) child.getLayoutData ();
		if (data == null) {
			child.setLayoutData (data = new FlatFormData ());
		}
		data.cacheWidth = pt.x;
		data.cacheHeight = pt.y;
	}
	for (int i=0; i<children.length; i++) {
		Control child = children [i];
		FlatFormData data = (FlatFormData) child.getLayoutData ();
		/* Adjust the child's position according to its border type! */
		int bshape = BorderShape[getBorderType(
			(data==null)? BORDER_DEFAULT : data.borderType, child)];
		
		if( data != null ) {
			if( move ) {
				int x1 = data.getLeftAttachment ().solveX (width) + LeftBorderSize[bshape];
				int y1 = data.getTopAttachment ().solveX (height) + TopBorderSize[bshape];
				int x2 = data.getRightAttachment ().solveX (width) - RightBorderSize[bshape];
				int y2 = data.getBottomAttachment ().solveX (height) - BottomBorderSize[bshape];
				child.setBounds (x + x1, y + y1, x2 - x1, y2 - y1);
			} else {
				width = Math.max (computeWidth (data), width);
				height = Math.max (computeHeight (data), height);
			}
		}
	}
	
	return move ? null : new Point (width, height);
}
	

@Override
public String toString () {
 	String string = getClass().getName ()+" {";
 	if (marginWidth != 0) string += "marginWidth=" + marginWidth + " " ;
 	if (marginHeight != 0) string += "marginHeight="+marginHeight+" ";
 	
 	string = string.trim();
 	string += "}";
 	return string;
}

}
