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

public final class FlatFormData extends BorderData {

	/**
	 * height specifies the desired height in pixels
	 */
	public int height;
	/**
	 * width specifies the desired width in pixels
	 */
	public int width;
	/**
	 * left specifies the attachment of the left side of 
	 * the control.
	 */
	public FlatFormAttachment left;
	/**
	 * right specifies the attachment of the right side of
	 * the control.
	 */
	public FlatFormAttachment right;
	/**
	 * top specifies the attachment of the top of the control.
	 */
	public FlatFormAttachment top;
	/**
	 * bottom specifies the attachment of the bottom of the
	 * control.
	 */
	public FlatFormAttachment bottom;

	int cacheHeight, cacheWidth;
	boolean isVisited;
	
public FlatFormData () {
	this (SWT.DEFAULT, SWT.DEFAULT);
}
	
public FlatFormData (int width, int height) {
	this.width = width;
	this.height = height;
}

FlatFormAttachment getBottomAttachment () {
	if (isVisited) return new FlatFormAttachment (0, cacheHeight);
	if (bottom == null) {
		if (top == null) return new FlatFormAttachment (0, cacheHeight);
		return getTopAttachment ().plus (cacheHeight);
	}
	if (bottom.control == null) return bottom;
	isVisited = true;
	FlatFormData bottomData = (FlatFormData) bottom.control.getLayoutData ();
	FlatFormAttachment topAttachment = bottomData.getTopAttachment ();
	FlatFormAttachment bottomAttachment = bottomData.getBottomAttachment ();
	isVisited = false;
	if (bottom.alignment == SWT.BOTTOM) return bottomAttachment.plus (bottom.offset);
	if (bottom.alignment == SWT.CENTER) {
		FlatFormAttachment bottomHeight = bottomAttachment.minus (topAttachment);
		return bottomAttachment.minus (bottomHeight.minus (cacheHeight).divide (2));
	}
	return topAttachment.plus (bottom.offset);	
}

FlatFormAttachment getLeftAttachment () {
	if (isVisited) return new FlatFormAttachment (0, 0);
	if (left == null) {
		if (right == null) return new FlatFormAttachment (0, 0);
		return getRightAttachment ().minus (cacheWidth);
	}
	if (left.control == null) return left;
	isVisited = true;
	FlatFormData leftData = (FlatFormData) left.control.getLayoutData ();
	FlatFormAttachment rightAttachment = leftData.getRightAttachment ();
	FlatFormAttachment leftAttachment = leftData.getLeftAttachment ();
	isVisited = false; 
	if (left.alignment == SWT.LEFT) return leftAttachment.plus (left.offset);
	if (left.alignment == SWT.CENTER) {
		FlatFormAttachment leftWidth = rightAttachment.minus (leftAttachment);
		return leftAttachment.plus (leftWidth.minus (cacheWidth).divide (2));
	}
	return rightAttachment.plus (left.offset); 
}	

FlatFormAttachment getRightAttachment () {
	if (isVisited) return new FlatFormAttachment (0, cacheWidth);
	if (right == null) {
		if (left == null) return new FlatFormAttachment (0, cacheWidth);
		return getLeftAttachment ().plus (cacheWidth);
	}
	if (right.control == null) return right;
	isVisited = true;
	FlatFormData rightData = (FlatFormData) right.control.getLayoutData ();
	FlatFormAttachment leftAttachment = rightData.getLeftAttachment ();
	FlatFormAttachment rightAttachment = rightData.getRightAttachment ();
	isVisited = false;
	if (right.alignment == SWT.RIGHT) return rightAttachment.plus (right.offset);
	if (right.alignment == SWT.CENTER) {
		FlatFormAttachment rightWidth = rightAttachment.minus (leftAttachment);
		return rightAttachment.minus (rightWidth.minus (cacheWidth).divide (2));
	}
	return leftAttachment.plus (right.offset);
}

FlatFormAttachment getTopAttachment () {
	if (isVisited) return new FlatFormAttachment (0, 0);
	if (top == null) {
		if (bottom == null) return new FlatFormAttachment (0, 0);
		return getBottomAttachment ().minus (cacheHeight);
	}
	if (top.control == null) return top;
	isVisited = true;
	FlatFormData topData = (FlatFormData) top.control.getLayoutData ();
	FlatFormAttachment topAttachment = topData.getTopAttachment ();
	FlatFormAttachment bottomAttachment = topData.getBottomAttachment ();
	isVisited = false;
	if (top.alignment == SWT.TOP) return topAttachment.plus (top.offset);
	if (top.alignment == SWT.CENTER) {
		FlatFormAttachment topHeight = bottomAttachment.minus (topAttachment);
		return topAttachment.plus (topHeight.minus (cacheHeight).divide (2));
	}
	return bottomAttachment.plus (top.offset);
}

@Override
public String toString () {
 	String string = getClass().getName ()+" {";
 	if (width != 0) string += "w=" + width + " " ;
 	if (height != 0) string += "h="+height+" ";
 	if (left != null) string += "L=(" + left + ") ";
 	if (right != null) string += "R=(" + right + ") ";
 	if (top != null) string += "T=(" + top + ") ";
 	if (bottom != null) string += "B=(" + bottom + ") ";
 	string = string.trim();
 	string += "}";
 	return string;
}

}
