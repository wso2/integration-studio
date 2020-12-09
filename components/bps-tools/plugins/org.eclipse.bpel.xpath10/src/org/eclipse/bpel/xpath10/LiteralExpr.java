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
 * A literal expression (string literal).
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */

@SuppressWarnings("nls")

public class LiteralExpr extends Expr {

	String fLiteral;
	
	/**
	 * Brand new shiny string literal expression.
	 * 
	 * @param text
	 */
	public LiteralExpr (String text) {
		super(text);
		fLiteral = parseLiteral( text);
	}
	
    /**
     * @return the literal
     */
    public String getLiteral() {
    	return fLiteral;    	
    }
    
    
	protected String parseLiteral (String string) {
    	if (string.length()  < 2) {
    		return "";
    	}
    	char ch1 = string.charAt(0);
    	char ch2 = string.charAt(string.length()-1);
    	if ( (ch1 == '"' || ch1 == '\'') && ch1 == ch2 ) {
    		//bugzilla 288935
    		return string.substring(1, string.length()-1);
    	}
    	return string;
    }
    
}
