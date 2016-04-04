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
 * 
 * A binary expression. Something with left and right side and an operator in the middle.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */
@SuppressWarnings("nls")

public class BinaryExpr extends Expr {
	
	String fOperator;
	Expr fLHS;
	Expr fRHS;
	
	/**
	 * Brand new shiny binary expression.
	 * 
	 * @param op
	 * @param lhs
	 * @param rhs
	 */
	public BinaryExpr (String op, Expr lhs, Expr rhs) {
		super("");
		fOperator = op;
		fLHS = lhs;
		fRHS = rhs;
	}
	
	/**
	 * @return the operator of the binary expression.
	 */
	
	public String getOperator() {
		return fOperator;
	}
	/**
	 * 
	 * @return the left hand side of the expression.
	 */
	
	public Expr getLHS() {
		return fLHS;	
	}
	
    /**
     * 
     * @return the right hand side of the expression.
     */
	
    public Expr getRHS() {
    	return fRHS;
    }
    

	@Override
	protected String asText() {
    	StringBuilder sb = new StringBuilder();
    	if (isWrapParen()) {
    		sb.append("(");
    	}
    	sb.append( fLHS != null ? fLHS.getText() : "?" );
    	sb.append(" ");
    	sb.append(getOperator());
    	sb.append(" ");
    	sb.append( fRHS != null ? fRHS.getText() : "?" );    
    	if (isWrapParen()) {
    		sb.append(")");
    	}
    	return sb.toString();
    }
    

    @Override
	protected String asString () {
    	StringBuilder sb = new StringBuilder();
    	if (isWrapParen()) {
    		sb.append("(");
    	}
    	sb.append(getLHS()).append(" ").append(getOperator()).append(" ").append(getRHS());
    	if (isWrapParen()) {
    		sb.append(")");
    	}
    	return sb.toString();
    }
    
     
    /**
     * @see org.eclipse.bpel.xpath10.Expr#getPosition()
     */
    @Override
	public int getPosition () {    	
    	return getLHS().getPosition();
    }
    
    /**
     * @see org.eclipse.bpel.xpath10.Expr#getEndPosition()
     */
    
    @Override
	public int getEndPosition () {
    	return getRHS().getEndPosition();
    }
    
}
