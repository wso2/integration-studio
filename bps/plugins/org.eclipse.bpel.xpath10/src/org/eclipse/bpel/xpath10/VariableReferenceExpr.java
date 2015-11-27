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
 * Variable Reference Expression. $variable bit of XPath
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 26, 2008
 *
 */
@SuppressWarnings("nls")

public class VariableReferenceExpr extends Expr {
	String fName;
	String fPrefix;

	/**
	 * Brand new shiny VariableRefExpr.
	 * @param prefix prefix of the variable (may be null or "")
	 * @param name the name of the variable
	 */
	
	public VariableReferenceExpr (String prefix, String name) {
		super(null);
		fPrefix = prefix;		
		fName = name;
		fText = getText();
	}
	/**
	 * 
	 * @return the prefix
	 */
	
	public String getPrefix() {
		return fPrefix;
	}

	/** 
	 * @return The variable name (sans prefix)
	 */
	public String getVariableName() {
		return fName;
	}

	/**
	 * Return the QName that represents this variable name. 
	 * The QName is returned as a string, with the original prefix used to specify the namespace.
	 * 
	 * @return the QName of this variable
	 */
	
	public String getQName() {
		if ("".equals(fPrefix) || fPrefix == null) {
			return fName;
		}
		return fPrefix + ":" + fName;
	}

	
	@Override
	protected String asText() {
		return "$" + getQName();
	}
}
