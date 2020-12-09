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
 * The base expression class for XPath semantic tree hierarchy.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */

@SuppressWarnings("nls")

public class Expr  {
	
	String fText ;
	int fStartPosition = -1;
	int fEndPosition = -1;
	
	boolean fWrapWithParenthesis = false;
	
	/**
	 * Brand new shiny Expr object.
	 * @param text
	 */
	public Expr (String text) {
		fText = text;
	}
	
	
	/** 
	 * @return the expression as a text 
	 */
	public final String getText() {
		StringBuilder sb = new StringBuilder();
		if (fWrapWithParenthesis) {
			sb.append("(");
		}
		sb.append(asText());
		if (fWrapWithParenthesis) {
			sb.append(")");
		}
		return sb.toString();
	};
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("{").append(getClass().getSimpleName()).append(",").append(asString()).append("}") ;
		return sb.toString();
	}

	protected String asString () {
		return getText();
	}
	
	protected String asText () {
		return fText;
	}
	
	/**
	 * @return whether the expression is wrapped in parenthesis.
	 */
	public boolean isWrapParen () {
		return fWrapWithParenthesis;
	}
	
	/**
	 * @param wrap
	 */
	public void setWrapParen ( boolean wrap ) {
		fWrapWithParenthesis = wrap;
	}
	
	/**
	 * This is useful for error reporting :-)
	 * 
	 * @return the end position of the expression in the "stream" that it was parsed from  
	 */
	public int getEndPosition() {
		return fEndPosition;
	}

	/**
	 * This is useful for error reporting :-)
	 * 
	 * @return the start position of the expression in the "stream" that it was parsed from  
	 */
	
	public int getPosition() {
		return fStartPosition;
	}
	
	/**
	 * Set the start and end position of the expression in the input "stream" it was parsed from.
	 * The parser uses this to provide location information to the semantic tree model.
	 * 
	 * @param start
	 * @param end
	 */
	public void setPosition (int start, int end) {
		fStartPosition = start;		
		fEndPosition = end;
	}
}
