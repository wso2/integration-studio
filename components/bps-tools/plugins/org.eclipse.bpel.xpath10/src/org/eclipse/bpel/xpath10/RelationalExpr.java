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

package org.eclipse.bpel.xpath10;

/**
 * A relational expression ( >,<, etc.) 
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */
public class RelationalExpr extends BinaryExpr {
	
	/**
	 * A brand new shiny relational expression.
	 * 
	 * @param op
	 * @param left
	 * @param right
	 */
	
	public RelationalExpr (String op, Expr left, Expr right) {
		super (op,left,right);
	}
}
