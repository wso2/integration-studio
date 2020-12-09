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
 * A predicate.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */

@SuppressWarnings("nls")
public class Predicate {
	
	Expr fExpr ;
	
	/** 
	 * Brand new predicate on an expression.
	 * @param expr
	 */
	
	public Predicate (Expr expr) {
		fExpr = expr;
	}
	
	/**
	 * @return the predicate (boolean) expression.
	 */
	public Expr getExpr () {
		return fExpr;
	}
	
	/**
	 * @return return it as text.
	 */
	
	public String getText() {
		return "["  + fExpr.getText() + "]";
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("{").append(getClass().getName()).append(",");
		sb.append("[").append(fExpr).append("]");
		return sb.toString();
	}	
	
	/**
	 * @return the position of the predicate in the input "stream"
	 */
	public int getPosition () 
	{
		return fExpr != null ? fExpr.getPosition() : -1;
	}
	
	/**
	 * @return the end position of the predicate in the input "stream"
	 */
	public int getEndPosition () 
	{
		return fExpr != null ? fExpr.getEndPosition() : -1;
	}
}
