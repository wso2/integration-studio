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
package org.eclipse.bpel.validator.helpers;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 6, 2007
 *
 */
/**
 * Detects variables in XPath expressions.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Nov 17, 2006
 *
 */
public class VariableNameWordDetector extends NCNameWordDetector {
	
	/**
	 * These always start with a $ 
	 */
	@Override
	public boolean isWordStart (char c) {
		return c == '$' ;
	}
	
	/** 
	 * The rest of the variable is a NCName but does not contain a '.' 
	 */
	@Override
	public boolean isWordPart (char c) {
		 return c != '.' && super.isWordPart(c); 
	}
}
