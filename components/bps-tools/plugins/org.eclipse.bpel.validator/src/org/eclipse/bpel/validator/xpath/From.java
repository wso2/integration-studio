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
package org.eclipse.bpel.validator.xpath;

import org.eclipse.bpel.validator.model.ARule;

import org.eclipse.bpel.xpath10.FunctionCallExpr;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Mar 23, 2007
 *
 */

@SuppressWarnings({ "boxing", "nls" })

public class From extends XPathValidator {

	/**
	 * Check the general expression.
	 *
	 */
	@ARule(
		sa = 0,
		desc = "Check the general XPath expression",
		author = "michal.chmielewski@oracle.com",
		date = "01/10/2007",
		order = 15
	)
	public void checkGeneralExpression () {	
		mVisitor.visit( xpathExpr );				
	}
	
	
	/**
	 * @param expr 
	 * 
	 */

	@ARule(
		sa = 26,
		desc = "Check that initialize expressions use idempotent functions",
		author = "michal.chmielewski@oracle.com",
		date = "03/15/2007",
		tag = "functions",
		order = 15
	)
		
	public void checkIdempotentFunctions ( FunctionCallExpr expr ) {
		boolean bCheckIdempotent = getValue("idempotent.functions",false);
		
		if (bCheckIdempotent == false) {
			return;
		}
		// TODO: check idempotent functions
		
		
	}

}
