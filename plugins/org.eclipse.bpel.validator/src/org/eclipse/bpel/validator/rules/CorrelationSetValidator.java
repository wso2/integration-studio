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


import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;



/**
 * Validates variable related rules.
 * <p>
 * When thinking 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */

@SuppressWarnings({"nls","boxing"})
public class CorrelationSetValidator extends CValidator {
	
	/** Parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_CORRELATION_SETS );
	
	
	protected String ncName ;


	protected String fProperties;
	
	
	
	
	/**
	 * Start performing variable checks.
	 */	
	
	@Override
	protected void start () {
		super.start();		
		ncName = mNode.getAttribute( AT_NAME );
		fProperties = mNode.getAttribute(AT_PROPERTIES);
		
	}
	
	/**
	 * Check the NCName of the correlation set.
	 */
	@ARule(
		sa = 0,
		desc = "Check the NCName of the correlationSet",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__UNSET_ATTRIBUTE,General.NCName_Bad"
	)
	public void rule_CheckName_1 () {					
		// Must be a valid NCName ...
		checkNCName(mNode, ncName, AT_NAME );
				
	}
	
	/**
	 * Check if the correlation already exists.
	 *
	 */
	
	@ARule(
		sa = 44,
		desc = "Check to see if the correlationSet is already specified",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC_DUPLICATE_NAME"
	)
	public void rule_CheckDuplicateCorrelationSet_2 () {
		if (ncName == null) {
			return ;
		}
		String key = "set." + ncName;
					
		// parent is correlationSets, 
		if (containsValueKey(fParentNode,key)) {
			IProblem problem = createError();
			problem.fill("BPELC_DUPLICATE_NAME",
					toString(mNode.parentNode().nodeName()),
					toString(mNode.nodeName()),
					ncName);
			return ;
		}
		
		setValue(fParentNode, key, Boolean.TRUE);		
	}
	
	
	

	/**
	 * Check to make sure that properties are set.
	 */
	@ARule(
			desc = "Check if property attribute is set",
			author = "michal.chmielewski@oracle.com",
			date = "01/20/2007",
			errors="BPELC__UNSET_ATTRIBUTE"
		)
	public void rule_CheckPropertiesAttribute_10 () {
		
		IProblem problem;
		
		if (isEmptyOrWhitespace(fProperties)) {
			problem = createError();
			problem.fill("BPELC__UNSET_ATTRIBUTE",
					toString(mNode.nodeName()) ,
					AT_PROPERTIES,					
					KIND_NODE);
			
		}
	}
	

	/**
	 * Properties used in a <correlationSet> MUST be defined using XML Schema simple types.
	 * 
	 */
	
	@ARule(
		sa = 45,
		desc = "Properties used in a <correlationSet> MUST be defined using " 
			  + " XML Schema simple types.",
			  
		author = "michal.chmielewski@oracle.com",
		date = "03/01/2007",
		errors="BPELC__UNRESOLVED_ATTRIBUTE,BPELC_XSD__NOT_SIMPLE_TYPE"
	)
	
	public void rule_CheckProperties_15 () {
		
		if (isEmpty(fProperties)) {
			return ;
		}
		
		String[] qnList = fProperties.split("\\s");
		INode property;
		IProblem problem;
		
		for(String qName : qnList) {
			
			property = mModelQuery.lookup(mNode, IModelQueryLookups.LOOKUP_NODE_PROPERTY, qName);
			
			if (isUndefined(property)) {
				
				problem = createError();
				problem.fill("BPELC__UNRESOLVED_ATTRIBUTE", 
					toString( mNode.nodeName() ), AT_PROPERTIES, KIND_NODE , qName ) ;
				
				continue;
			} 
			
			String atType = property.getAttribute(AT_TYPE);
			
			if (isEmpty(atType)) {
				continue ;
			}
			
			INode typeDef = mModelQuery.lookup( mNode,  IModelQueryLookups.LOOKUP_NODE_XSD_TYPE, atType);					
			
			if (isUndefined(typeDef)) {
				continue;
			}
			
			if (mModelQuery.check(IModelQueryLookups.TEST_IS_SIMPLE_TYPE, typeDef, null) == false) {
				problem = createError();
				problem.fill("BPELC_XSD__NOT_SIMPLE_TYPE",
						toString(mNode.nodeName()),
						atType,
						"text.property",
						qName
				);
				
			}
			
		}		
	}
	
	
	/** 
	 * End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
