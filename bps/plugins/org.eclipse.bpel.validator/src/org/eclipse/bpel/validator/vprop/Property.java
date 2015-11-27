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
package org.eclipse.bpel.validator.vprop;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;
import org.eclipse.bpel.validator.rules.CValidator;



/**
 * <vprop:property name="taxpayerNumber" type="txtyp:SSN" />
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 *
 */


@SuppressWarnings({"nls","boxing"})

public class Property extends CValidator {
	
	/** Parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter( WSDL_ND_DEFINITIONS );
	
	
	String ncName ;


	protected String fTypeName;


	protected String fElementName;	
	
	
	/**
	 * Start performing link checks.
	 */	
	
	@Override
	public void start () {
		super.start();		
		ncName = mNode.getAttribute( AT_NAME );		
	}
	
	/**
	 * Rule to check the name of the link. 
	 */
	@ARule(
		sa = 0,
		desc = "Check the NCName of the property",
		author = "michal.chmielewski@oracle.com",
		date = "02/15/2007",
		errors="BPELC__UNSET_ATTRIBUTE,General.NCName_Bad"
	)
	
	public void rule_CheckName_1 () {		
		// Must be a valid NCName ...		
		if (checkNCName(mNode, ncName, AT_NAME ) == false) {
			disableRules();
		}			
	}
	
	/**
	 * Check duplicate name of property
	 *
	 */
	
	@ARule(
			sa = 0,
			desc = "Check if property name is duplicated",
			author = "michal.chmielewski@oracle.com",
			date = "02/15/2007",
			errors="BPELC__DUPLICATE"
		)
	public void rule_CheckDuplicateName_5 () {
		
		if (isEmpty(ncName)) {
			return;
		}
		
		IProblem problem;
		String key = "v.property." + ncName;
		if (containsValueKey(fParentNode,key)) {
			problem = createError();
			problem.fill("BPELC__DUPLICATE",
					toString(mNode.nodeName()),
					ncName);
			return ;
		}
		
		setValue(fParentNode, key,true);
	}

	
	/**
	 * Either the type or element attributes MUST be present in a
	 * <vprop:property> element but not both.
	 */
	
	@ARule(
		sa = 19,
		desc = "Either the type or element attributes MUST be present but not both.",
		author = "michal.chmielewski@oracle.com",
		date = "02/17/2007",
		tag = "pass1",
		errors="BPELC_PROPERTY__UNSET"
	)
	
	public void rule_CheckPropertyType_10 () {
		IProblem problem;
		
		fTypeName = mNode.getAttribute(AT_TYPE);
		fElementName = mNode.getAttribute(AT_ELEMENT);
				
		if ((isEmpty(fTypeName) && isEmpty(fElementName)) ||
			(isNonEmpty(fTypeName) && isNonEmpty(fElementName))) {
			
			problem = createError();
			problem.fill("BPELC_PROPERTY__UNSET",
					toString(mNode.nodeName()),
					AT_TYPE,
					AT_ELEMENT,
					0);
			
			disableRules();
		}
		
	}
	
	
	/**
	 * Check if the type or element is visible.
	 *
	 *
	 */
	


	
	@ARule(
		desc = "Attribute cannot be resolved for XSD type or element.",
		author = "michal.chmielewski@oracle.com",
		date = "02/17/2007",
		tag = "pass1",
		errors="BPELC__UNRESOLVED_ATTRIBUTE"
	)
	
	public void rule_CheckTypeOrElement_15 () {
		
		INode typeNode = null;
		
		IProblem problem;
		
		if (isEmpty(fTypeName) == false) {
			typeNode = mModelQuery.lookup(mNode.rootNode(), 
					IModelQueryLookups.LOOKUP_NODE_XSD_TYPE, fTypeName);
			if (isUndefined(typeNode)) {
				problem = createError();
				
				problem.fill("BPELC__UNRESOLVED_ATTRIBUTE", 
						toString(mNode.nodeName()),
						AT_TYPE,
						KIND_NODE,
						fTypeName
				);
			}
		} else if (isEmpty(fElementName) == false) {
			typeNode = mModelQuery.lookup(mNode.rootNode(), 
					IModelQueryLookups.LOOKUP_NODE_XSD_ELEMENT, fElementName);
			
			if (isUndefined(typeNode)) {
				problem = createError();
				problem.fill("BPELC__UNRESOLVED_ATTRIBUTE", 
						toString(mNode.nodeName()),
						AT_ELEMENT,
						KIND_NODE,
						fElementName
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
