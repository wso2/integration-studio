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
import org.eclipse.bpel.validator.model.IValue;
import org.eclipse.bpel.validator.model.NodeNameFilter;
import org.eclipse.bpel.validator.model.RuleFactory;
import org.eclipse.bpel.validator.model.Validator;


/**
 * Validates Query nodes, that have query expressions.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 10, 2006
 *
 */

@SuppressWarnings("nls")

public class QueryValidator extends CValidator {

	/**
	 * The valid parent nodes (this is read via reflection in CValidator)
	 */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_FROM, ND_TO );
			
	/** 	
	 * Note that this field is stateful with the life of the object.
	 */
	
	protected Validator fQueryValidator = null;


	protected String fQueryLanguage;
		
	/**
	 * 
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
		desc = "Checks the query language for support in the BPEL model",		
		date = "10/2/2006",
		sa = 4 ,
		errors="BPELC__UNSUPPORTED_XML_LANG"
	)
	public void rule_CheckQueryLanguageSupport_20 () {
		
		fQueryLanguage = getLanguage(mNode,AT_QUERYLANGUAGE);
		
		IProblem problem;
		
		if ( mModelQuery.hasSupport(IModelQueryLookups.SUPPORT_QUERY_LANGUAGE, 
				fQueryLanguage) == false ) {
			
			problem = createError();
			problem.fill( 
					"BPELC__UNSUPPORTED_XML_LANG",  //$NON-NLS-1$
					AT_QUERYLANGUAGE,
					fQueryLanguage);
			
			disableRules( );
			
			return ;
		}
		
	}
		

	
	/**
	 * Check the condition expression. This expression
	 * must be a boolean expression.
	 */
	
	
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "Checks the actual query using the query language validator.",		
		date = "10/2/2006",
		sa = 1000 ,
		warnings="BPELC__NO_EXPRESSION_VALIDATOR"
	)
	
	public void rule_CheckQuery_30 () {
		
		QName qname = new QName( fQueryLanguage, mNode.nodeName().getLocalPart() );

		if (fQueryValidator == null) {
				
			fQueryValidator = RuleFactory.INSTANCE.createValidator ( qname ); 
			
			IProblem problem;
			
			if  (fQueryValidator == null) {
				
				problem = createWarning();
				problem.fill("BPELC__NO_EXPRESSION_VALIDATOR",  //$NON-NLS-1$					
						toString(mNode.nodeName()),
						fQueryValidator
				);		
				
				return ;
			}
		
			attach (fQueryValidator);
			
		}
			
		// The parent node (to or from) has probably figured out some type 
		// so far. We (the query) further refine it.
		
		setValue("expression.type",getValue(fParentNode,"type",null));
		
		// This is a late binding expression 
		setValue(fParentNode,"type", new IValue<Object>() {
				public Object get() {
					return fQueryValidator.getValue("expression.type");
				}			
			}
		);
		
	}
				

	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
