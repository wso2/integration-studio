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

import java.util.ArrayList;
import java.util.List;

/**
 * A filter expression.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */
public class FilterExpr extends Expr {

	List<Predicate> fList = new ArrayList<Predicate>();
	Expr fExpr;
	
	
	/**
	 * Brand new shiny filter expression.
	 * 
	 * @param expr the expression to which the filter (predicates) are to be applied.
	 */
	public FilterExpr (Expr expr) {
		super(expr.toString());
		fExpr = expr;
	}
	
	/**
	 * @return the expression that is to be predicated.
	 */
	public Expr getExpr () {
		return fExpr;		
	}
	
    /**
     * @return a list of predicates for this filter.
     */
    public List<Predicate> getPredicates() {
    	return fList;
    }
   
    /**
     * Add a predicate to the filter list.
     * @param p the predicate to add.
     */
    public void addPredicate (Predicate p) {
    	fList.add(p);
    }
    
    /**
     * @return true if yes, false if no.
     */
    
    public boolean hasPredicates ()
    {
    	return fList.size() > 0;
    }
    
    @Override
	protected String asText()
    {
        StringBuilder sb = new StringBuilder();
        if ( fExpr != null ) {
        	sb.append(fExpr.getText());
        }
        for(Predicate p : fList) {
        	sb.append(p.getText());
        }
        return sb.toString();
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
