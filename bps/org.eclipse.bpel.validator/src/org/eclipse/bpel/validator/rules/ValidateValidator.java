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
package org.eclipse.bpel.validator.rules;

import java.util.StringTokenizer;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;



/**
 * Validates Validate nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 5, 2006
 *
 */


public class ValidateValidator extends CActivityValidator {
			
		
	String variables;
	
	/**
	 * Start validation process for this node.
	 */
	
	@Override
	protected void start() {
		super.start();
		
		variables = mNode.getAttribute(AT_VARIABLES);
	}
	
	/**
	 * Make sure that the variables defined in 
	 * the validate activity exist in the process.
	 */
	
	@ARule(
			sa = 0,
			desc = "Make sure that the variables defined in the validate activity are defined.",
			author = "michal.chmielewski@oracle.com",
			date = "02/15/2007",
			errors="BPELC_VALIDATE__NO_VARIABLES_SPECIFIED,BPELC_VALIDATE__NO_SUCH_VARIABLE"
		)
	public void rule_CheckValidateVariables_15 () {
		
		IProblem problem;
		
		if (isEmptyOrWhitespace(variables)) {
			problem = createError();
			problem.setAttribute(IProblem.CONTEXT, AT_VARIABLES);
			problem.fill("BPELC_VALIDATE__NO_VARIABLES_SPECIFIED", //$NON-NLS-1$
					toString(mNode.nodeName()));
			return ;
		}
		
		
		StringTokenizer tokenizer = new StringTokenizer(variables, " "); //$NON-NLS-1$
		while (tokenizer.hasMoreTokens()) {
			
			String nextVarName = tokenizer.nextToken();
			
			INode variableNode = mModelQuery.lookup( mNode, 
									IModelQueryLookups.LOOKUP_NODE_VARIABLE, 
									nextVarName);
			
			if (isUndefined(variableNode)) {
				problem = createError();
				problem.setAttribute(IProblem.CONTEXT, AT_VARIABLES);
				problem.fill("BPELC_VALIDATE__NO_SUCH_VARIABLE", //$NON-NLS-1$
						nextVarName,
						toString(mNode.nodeName()));
				
			}
		}		
	}
	
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
