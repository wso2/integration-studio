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
import org.eclipse.bpel.validator.model.Validator;



/**
 * Validates To nodes.
 * 
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 10, 2006
 *
 */

@SuppressWarnings({"nls","boxing"})

public class ToValidator extends CValidator {
	
	static QName [] ENDPOINT_REFRENCE = { AT_MY_ROLE , AT_PARTNER_ROLE };
	
	/** My parents */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_COPY );
	
	
	
	protected INode fVariableNode ;

	protected INode fQueryNode;

	protected INode fPartnerLinkNode;
	
	protected INode fPropertyNode;


	protected Validator fExprValidator;

	protected String fPropertyName;

	protected String fPartName;
	
	protected INode fMessageTypeNode;

	protected INode fPartNode;

	protected String fExpressionLanguage;
	
	/**
	 * 
	 * @see org.eclipse.bpel.validator.model.Validator#start()
	 */
	 
	@Override
	protected void start () {
		super.start();
		
		fVariableNode = mModelQuery.lookup(mNode,
							IModelQueryLookups.LOOKUP_NODE_VARIABLE,
							mNode.getAttribute(AT_VARIABLE));
		
		fPartName = mNode.getAttribute(AT_PART);
				
		fQueryNode = mNode.getNode(ND_QUERY);
				
		fPartnerLinkNode = mModelQuery.lookup(mNode,
							IModelQueryLookups.LOOKUP_NODE_PARTNER_LINK,
							mNode.getAttribute(AT_PARTNER_LINK));			
		
		fPropertyName = mNode.getAttribute(AT_PROPERTY);
		
		fExpressionLanguage = getLanguage(mNode,AT_EXPRESSIONLANGUAGE);

	}
	

	/** 
	 * Checks the from variant. It must be exactly one of
	 * the variants 
	 */
	
	@SuppressWarnings("boxing")
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "Checks the allowed formats of the <to> element",
		date = "01/15/2007",			
		sa = 32 ,
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE,BPELC_TO__VARIANT",
		warnings="BPELC_REF_NODE_PROBLEMS"
	)
	
	public void rule_CheckToVariant_10 () {
		
		IProblem problem;
		
		int variant = 0;
					
		if (fVariableNode != null) {
			variant += 1;

			// if this is bad, disable all rules
			if (checkValidator(mNode, fVariableNode, AT_VARIABLE, KIND_NODE) == false ||
				checkAttributeNode(mNode, fVariableNode, AT_VARIABLE, KIND_NODE) == false) {
				disableRules();
			}
		}
				
		if (fPartnerLinkNode != null) {
			variant += 1;
			
			// if this is bad, disable all rules
			if (checkValidator(mNode, fPartnerLinkNode, AT_PARTNER_LINK, KIND_NODE) == false ||
				checkAttributeNode(mNode, fPartnerLinkNode, AT_PARTNER_LINK, KIND_NODE) == false) {
				disableRules();
			}
		
		}
		
		if (variant == 0) {
			variant += 1;
		}
		
		// 
		if (variant == 0) {
			
			problem = createError();
			problem.fill("BPELC_TO__VARIANT", //$NON-NLS-1$
					toString(mNode.nodeName()),
					variant);
					
			disableRules();
			
		} else if (variant > 1) {
			
			problem = createError();
			problem.fill("BPELC_TO__VARIANT", //$NON-NLS-1$
					toString(mNode.nodeName()),
					variant);
			
			disableRules();
		}
		
		
	}
	
	/** 
	 * Check the variable variant. 
	 */
	@ARule(
		desc = "Variables used in <to> must not have part set if they are schema types. "
			+ " (part must not be set) ",
		author = "michal.chmielewski@oracle.com",
		date = "01/15/2007",
		sa = 34 ,
		errors="BPELC_TO__VARIABLE_PART,BPELC__PA_NO_PART"
	)
	
	public void rule_CheckVariableAndPartVariant_18 () {
		
		IProblem problem ;
		
		if (isUndefined(fVariableNode) || isDefined(fPropertyNode)) {
			return ;
		}
		
		// The variable has a certain type. Get it from the variable validator.
		INode varTypeNode = getValue(fVariableNode,"type",null);	
		if (isUndefined(varTypeNode)) {
			return ;
		}
	
		setValue("type",varTypeNode);
		
		// At this point, we know that the variable is defined correctly
		// and so it must be either 
		//    1. message type
		//    2. schema type or element
		
		if ( WSDL_ND_MESSAGE.equals(varTypeNode.nodeName()) == false ) {
			
			// then part be better null too (be unset)
			if (isEmpty(fPartName) == false) {
				problem = createError();
				problem.fill ("BPELC_TO__VARIABLE_PART", //$NON-NLS-1$
						toString(mNode.nodeName()),
						AT_VARIABLE,
						fVariableNode.getAttribute(AT_NAME)
				);				
			}
			
		} else if ( isEmpty(fPartName) == false ) {
				
			// it is a message type, figure out the part type
			INode partNode = mModelQuery.lookup(varTypeNode,
					IModelQueryLookups.LOOKUP_NODE_MESSAGE_PART,fPartName);
			
			if (isUndefined(partNode)) {
				problem = createError();
				problem.fill("BPELC__PA_NO_PART",
						toString(mNode.nodeName()),
						fPartName,
						varTypeNode);	
				
				return ;
			}
			
			INode partType = mModelQuery.lookup(partNode,
					IModelQueryLookups.LOOKUP_NODE_TYPE_OF_PART,fPartName);
			
			if (isDefined(partType)) {
				setValue("type",partType);
			}
						
		}
				
		
	}
	
	
	
	/**
	 * Check the partner link variant as the source.
	 *
	 */
	
	@SuppressWarnings("nls")
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "<to> spec with partnerLink must have partnerRole set.",
		date = "01/10/2007",
		sa = 37 ,
		errors="BPELC_TO__PARTNER_LINK"
	)

	public void rule_CheckPartnerLinkVariant_20 () {
		
		if (isUndefined(fPartnerLinkNode)) {
			return ;
		}
		IProblem problem;
		
		// check for partner role
		String partnerRole = fPartnerLinkNode.getAttribute(AT_PARTNER_ROLE);
		
		//
		if (isEmptyOrWhitespace(partnerRole)) {
			problem = createError();
			problem.fill ("BPELC_TO__PARTNER_LINK", 
					toString(mNode.nodeName()),					
					fPartnerLinkNode.getAttribute(AT_NAME),
					AT_PARTNER_ROLE);
		} else {
			// the effective "type" of this is portType.
			INode portType = getValue(fPartnerLinkNode,"role.portType." + partnerRole, null);
			
			setValue("type", portType);
		}
	}
	
	
	
	
	
	
	/**
	 * Check the expression variant.
	 *
	 */
	

	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "Check variable reference expression as used in a <to> element.",
		date = "01/10/2007",
		sa = 33 ,
		warnings="BPELC__NO_EXPRESSION_VALIDATOR"
	)
	
	public void rule_CheckExpressionVariant_50 () {
		
		// not this variant.
		if (fVariableNode != null || 
			fPropertyNode != null || 
			fPartnerLinkNode != null || 
			fPartName != null ||
			fQueryNode != null ) {
			
			return ;
		}
		
		if (fExprValidator == null) {
			
			fExprValidator = createExpressionValidator (new QName( fExpressionLanguage, mNode.nodeName().getLocalPart() ) );
			
			if (fExprValidator == null) {
				return ;
			}
			
			attach ( fExprValidator );
		}
		
		// This needs to be late binding, because it is not available 
		// until Expression validator is run.
		
		setValue("type", new IValue<Object>() {
				public Object get() {
					return fExprValidator.getValue("expression.type");
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
