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
 * A function all expression in XPath.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */

@SuppressWarnings("nls")

public class FunctionCallExpr extends Expr {
	
	final List<Expr> fParams = new ArrayList<Expr>();
	String fName;
	String fPrefix;
	
	/**
	 * Brand new shiny XPath expression.
	 * 
	 * @param pfx the prefix 
	 * @param name the function name.
	 */
	public FunctionCallExpr (String pfx, String name) {
		super(null);
		fName = name;
		fPrefix = pfx;
	}
	
	/**
	 * @return the function prefix (if defined).
	 */
	public String getPrefix() {
		return fPrefix;
	}
	
    /**
     * @return the function name
     */
    public String getFunctionName() {
    	return fName;
    }
    
    /**
     * @return the parameter list for this function.
     */
    public List<Expr> getParameters() {
    	return fParams;
    }

    /** 
     * Add a parameter to the parameter list. The parser
     * call this method.
     * 
     * @param p the parameter
     */
    public void addParameter (Expr p) {
    	fParams.add(p);
    }
    
    @Override
	protected String asText() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(fnName()).append(argsToString(false));
    	return sb.toString();
    }
    
    /**
     * @see org.eclipse.bpel.xpath10.Expr#toString()
     */
    
    @Override
	public String toString () {
    	StringBuilder sb = new StringBuilder();
    	sb.append("{FunctionCall,").append(getFunctionName()).append(",").append( argsToString(true) ).append("}");
    	return sb.toString();
    }
    
    
	String fnName () {
    	if ("".equals(fPrefix) || fPrefix == null) {
    		return fName;
    	}
    	return fPrefix + ":" + fName;
    }
    
    String argsToString (boolean asString ) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("(");
    	int count = 0;
    	for(Expr n : fParams) {
    		if (count > 0) {
    			sb.append(", ");
    		}
    		if (asString) {
    			sb.append(n);
    		} else {
    			sb.append(n.getText());
    		}    		    	
    		count ++;
    	}
    	sb.append(")");
    	return sb.toString();
    }
}
