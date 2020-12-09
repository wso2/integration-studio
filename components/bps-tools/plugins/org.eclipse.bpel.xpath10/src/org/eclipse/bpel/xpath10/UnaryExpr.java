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
 * A unary expression.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */
@SuppressWarnings("nls")

public class UnaryExpr extends Expr {

	Expr fExpr;
	String fOparand;
		
	/**
	 * Brand new shiny unary expression
	 * @param expr
	 */
	public UnaryExpr (Expr expr) {
		super(expr.toString());
		fExpr = expr;
	}
	
	/** 
	 * @return the RHS of the unary expression.
	 */
	
	public Expr getExpr () {
		return fExpr;		
	}
    
	/**
	 * Set the operand of the unary expression.
	 * 
	 * @param operand the operand
	 */
	
	public void setOperand  (String operand)
	{
		fOparand = operand;
	}
	
    @Override
	protected String asText()
    {
    	StringBuilder sb = new StringBuilder();
    	if (fOparand != null) {
    		sb.append(fOparand);    		
    	}    	
    	if (fExpr != null) {
    		sb.append(fExpr.asText());
    	}
    	return sb.toString();
    }
    
    
	@Override
	protected String asString () {
    	StringBuilder sb = new StringBuilder();
    	if (fOparand != null) {
    		sb.append(fOparand);
    		sb.append(",");
    	}    	
    	if (fExpr != null) {
    		sb.append(fExpr);
    	}
    	return sb.toString();
    }
    
    /**
     * @see org.eclipse.bpel.xpath10.Expr#isWrapParen()
     */
    @Override
	public boolean isWrapParen () {
    	return fExpr != null ? fExpr.isWrapParen() : false;
    }
    
    /**
     * @see org.eclipse.bpel.xpath10.Expr#getPosition()
     */
    @Override
	public int getPosition ()  {
    	return fExpr != null ? fExpr.getPosition() : -1;
    }
    
    /**
     * @see org.eclipse.bpel.xpath10.Expr#getEndPosition()
     */
    @Override
	public int getEndPosition () {
    	return fExpr != null ? fExpr.getEndPosition() : -1;
    }
    
}
