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

import javax.xml.namespace.QName;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;
import org.eclipse.bpel.validator.model.Validator;


/**
 * Validates Exit nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 5, 2006
 *
 */

@SuppressWarnings("nls")
public class ConditionValidator extends CValidator {
			
	/** list of my parents */	
	static public final IFilter<INode> PARENTS = new NodeNameFilter ( 	
		ND_WHILE,
		ND_IF,
		ND_ELSEIF,
		ND_WHILE,
		ND_REPEAT_UNTIL
	);

	
	Validator fExprValidator;
		
	
	protected String fExpressionLanguage;
	
	/**
	 * @see org.eclipse.bpel.validator.model.Validator#start()
	 */
	
	@Override
	protected void start () {
		super.start();
		
	}
	
	
	/**
	 * Checks the expression language attribute for support in the model.
	 */
	
	
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "Checks the expression language for support in the BPEL model",		
		date = "10/2/2006",
		sa = 4 ,
		errors="BPELC__UNSUPPORTED_XML_LANG"
	)
	public void rule_CheckExpressionLanguageSupport_20 () {
		
		fExpressionLanguage = getLanguage(mNode,AT_EXPRESSIONLANGUAGE);
		
		IProblem problem;
		
		if ( mModelQuery.hasSupport(IModelQueryLookups.SUPPORT_EXPRESSION_LANGUAGE, 
				fExpressionLanguage) == false ) {
			
			problem = createError();
			problem.fill( 
					"BPELC__UNSUPPORTED_XML_LANG",
					AT_EXPRESSIONLANGUAGE,
					fExpressionLanguage);
			
			disableRules( 20,1000 );
			
			return ;
		}
		
	}
	
	
	/**
	 * Check the condition expression. This expression
	 * must be a boolean expression.
	 */
	
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "Checks the actual expression using the expression language validator.",		
		date = "10/2/2006",
		sa = 0,
		order = 100 ,
		warnings="BPELC__NO_EXPRESSION_VALIDATOR"
	)		
	public void checkExpression () {
		
		if (fExprValidator == null) {
			
			fExprValidator = createExpressionValidator ( new QName( fExpressionLanguage, mNode.nodeName().getLocalPart() ) );
			if (fExprValidator == null) {
				return ;
			}
			
			attach ( fExprValidator );
		}
		
	}
		
	


}
