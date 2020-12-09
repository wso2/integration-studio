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
import org.eclipse.swt.widgets.Control;

public final class FlatFormAttachment {

	/**
	 * numerator specifies the numerator of the "a" term in the
	 * equation, y = ax + b, which defines the attachment.
	 */
	public int numerator;
	/**
	 * denominator specifies the denominator of the "a" term in the
	 * equation, y = ax + b, which defines the attachment.
	 * 
	 * The default value is 100.
	 */
	public int denominator = 100;
	/**
	 * offset specifies the offset, in pixels, of the control side
	 * from the attachment position.
	 * If the offset is positive, then the control side is offset
	 * to the right of or below the attachment position. If it is
	 * negative, then the control side is offset to the left of or
	 * above the attachment position.
	 * 
	 * This is equivalent to the "b" term in the equation y = ax + b.
	 * The default value is 0.
	 */
	public int offset;
	/**
	 * control specifies the control to which the control side is
	 * attached.
	 */
	public Control control;
	/**
	 * alignment specifies the alignment of the control side that is
	 * attached to a control.
	 * For top and bottom attachments, TOP, BOTTOM and CENTER are used. For left 
	 * and right attachments, LEFT, RIGHT and CENTER are used. If any other case
	 * occurs, the default will be used instead.
	 * 
	 * Possible values are:
	 * 
	 * TOP: Attach the side to the top side of the specified control.
	 * BOTTOM : Attach the side to the bottom side of the specified control.
	 * LEFT: Attach the side to the left side of the specified control.
	 * RIGHT: Attach the side to the right side of the specified control.
	 * CENTER: Attach the side at a position which will center the control on
	 * the specified control.
	 * DEFAULT: Attach the side to the adjacent side of the specified control.
	 */
	public int alignment;
	
FlatFormAttachment () {
}

/**
 * Constructs a new instance of this class given a numerator 
 * and denominator and an offset. The position of the side is
 * given by the fraction of the form defined by the numerator
 * and denominator.
 *
 * @param numerator the numerator of the position
 * @param denominator the denominator of the position
 * @param offset the offset of the side from the position
 */
public FlatFormAttachment (int numerator, int denominator, int offset) {
	if (denominator == 0) SWT.error (SWT.ERROR_CANNOT_BE_ZERO);
	this.numerator = numerator;
	this.denominator = denominator;
	this.offset = offset;
}

/**
 * Constructs a new instance of this class given a numerator
 * and an offset. Since no denominator is specified, the default
 * is to read the numerator as a percentage of the form, with a 
 * denominator of 100.
 * 
 * @param numerator the percentage of the position
 * @param offset the offset of the side from the position
 */
public FlatFormAttachment (int numerator, int offset) {
	this (numerator, 100, offset);
}

/**
 * Constructs a new instance of this class given a control,
 * an offset and an alignment.
 * 
 * @param control the control the side is attached to
 * @param offset the offset of the side from the control
 * @param alignment the alignment of the side to the control it is attached to
 */
public FlatFormAttachment (Control control, int offset, int alignment) {
	this.control = control;
	this.offset = offset;
	this.alignment = alignment;
}
	
/**
 * Constructs a new instance of this class given a control
 * and an offset. Since no alignment is specified, the default
 * alignment is to attach the side to the adjacent side of the 
 * specified control.
 * 
 * @param control the control the side is attached to
 * @param offset the offset of the side from the control
 */
public FlatFormAttachment (Control control, int offset) {
	this (control, offset, SWT.DEFAULT);
}

/**
 * Constructs a new instance of this class given a control.
 * Since no alignment is specified, the default alignment is
 * to attach the side to the adjacent side of the specified 
 * control. Since no offset is specified, an offset of 0 is
 * used.
 * 
 * @param control the control the side is attached to
 */
public FlatFormAttachment (Control control) {
	this (control, 0, SWT.DEFAULT);
}

FlatFormAttachment divide (int value) {
	return new FlatFormAttachment (numerator, denominator * value, offset / value);
}

int gcd (int m, int n) {
	int temp;
	m = Math.abs (m); n = Math.abs (n);
	if (m < n) {
		temp = m;
		m = n;
		n = temp;
	}
	while (n != 0){
		temp = m;
		m = n;
		n = temp % n;
	}
	return m;
}

FlatFormAttachment minus (FlatFormAttachment attachment) {
	FlatFormAttachment solution = new FlatFormAttachment ();
	solution.numerator = numerator * attachment.denominator - denominator * attachment.numerator;
	solution.denominator = denominator * attachment.denominator;
	int gcd = gcd (solution.denominator, solution.numerator);
	solution.numerator = solution.numerator / gcd;
	solution.denominator = solution.denominator / gcd;
	solution.offset = offset - attachment.offset;
	return solution;
}

FlatFormAttachment minus (int value) {
	return new FlatFormAttachment (numerator, denominator, offset - value);
}

FlatFormAttachment plus (FlatFormAttachment attachment) {
	FlatFormAttachment solution = new FlatFormAttachment ();
	solution.numerator = numerator * attachment.denominator + denominator * attachment.numerator;
	solution.denominator = denominator * attachment.denominator;
	int gcd = gcd (solution.denominator, solution.numerator);
	solution.numerator = solution.numerator / gcd;
	solution.denominator = solution.denominator / gcd;
	solution.offset = offset + attachment.offset;
	return solution;
}

FlatFormAttachment plus (int value) {
	return new FlatFormAttachment (numerator, denominator, offset + value);
}

int solveX (int value) {
	if (denominator == 0) SWT.error (SWT.ERROR_CANNOT_BE_ZERO);
	return ((numerator * value) / denominator) + offset;
}

int solveY (int value) {
	if (numerator == 0) SWT.error (SWT.ERROR_CANNOT_BE_ZERO);
	return (value - offset) * denominator / numerator;
}
	
@Override
public String toString () {
 	String string = control != null ? control.toString () : numerator + "/" + denominator; //$NON-NLS-1$
	return "y = (" + string + (offset >= 0 ? ")x + " + offset: ")x - " + (-offset)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
}

}
