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

import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.IValue;
import org.eclipse.bpel.validator.model.NodeNameFilter;
import org.eclipse.bpel.validator.model.RuleFactory;
import org.eclipse.bpel.validator.model.Validator;



/**
 * Validates From nodes.
 * 
 * Variants: Part/Query
 * 
   <from variable="BPELVariableName" part="NCName"?>
     <query queryLanguage="anyURI"?>?
        queryContent
     </query>     
   </from>
   
 * Partner link
   <from partnerLink="NCName" endpointReference="myRole|partnerRole" />
   
 * Variable property
   <from variable="BPELVariableName" property="QName" />
   
 * Expression
   <from expressionLanguage="anyURI"?>expression</from>
 
 * Literal
   <from><literal>literal value</literal></from>
   
 * Empty
   <from/>
 *  
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 10, 2006
 *
 */


@SuppressWarnings( {"nls","boxing"} )


public class FromValidator extends CValidator {
	
	static QName [] ENDPOINT_REFRENCE = { AT_MY_ROLE , AT_PARTNER_ROLE };
	
	/** Can be part of variable too */
	static public IFilter<INode> PARENTS = new NodeNameFilter(  
			ND_VARIABLE, ND_COPY 
	) ;	
	
	
	protected INode fVariableNode ;

	protected INode fQueryNode;

	protected INode fLiteralNode;

	protected INode fPartnerLinkNode;

	protected INode fPartNode;
	
	protected INode fPropertyNode;

	protected String fEndpointReference;

	protected Validator fExprValidator;

	protected String fExpressionLanguage;

	protected String fPropertyName;

	protected String fPartName;
	
	protected String fHeaderName;
	
	/**
	 * 
	 */
	 
	@Override
	protected void start () {
		super.start();
		fVariableNode = mModelQuery.lookup(mNode,
							IModelQueryLookups.LOOKUP_NODE_VARIABLE,
							mNode.getAttribute(AT_VARIABLE));
		
		fPartName = mNode.getAttribute(AT_PART);
		// fix Bug 323945
		fHeaderName = mNode.getAttribute(AT_HEADER);
		
		fQueryNode = mNode.getNode(ND_QUERY);
				
		fPartnerLinkNode = mModelQuery.lookup(mNode,
							IModelQueryLookups.LOOKUP_NODE_PARTNER_LINK,
							mNode.getAttribute(AT_PARTNER_LINK));
		
		fEndpointReference = mNode.getAttribute(AT_ENDPOINT_REFERENCE);
		
		fPropertyName = mNode.getAttribute(AT_PROPERTY);
		
		fExpressionLanguage = getLanguage(mNode,AT_EXPRESSIONLANGUAGE);

		fLiteralNode = mNode.getNode(ND_LITERAL);
	}
	

	/** 
	 * Checks the from variant. It must be exactly one of
	 * the variants 
	 */
	
	@SuppressWarnings("boxing")
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "Checks the allowed formats of the <from> element",
		date = "01/15/2007",			
		sa = 32 ,
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE,BPELC_FROM__VARIANT",
		warnings="BPELC_REF_NODE_PROBLEMS"
	)
	public void rule_CheckFromVariant_10 () {
		
		IProblem problem;
		
		int variant = 0;
		
		if (fLiteralNode != null) {		
			variant += 1;
		}
		// fix Bug 323945
		if(!isEmpty(fHeaderName)){
			setValue("header", fHeaderName);
		}
		
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
			
			fEndpointReference = getAttribute(mNode, 
					AT_ENDPOINT_REFERENCE, 
					KIND_NODE, 
					Filters.ENDPOINT_FILTER,
					true);
			
			if (isEmpty(fEndpointReference)) {				
				disableRules();
			}
		
		}

		// if nothing else, it must be the expression variant.
		if (variant == 0) {
			variant += 1;
		}
		
		// 
		if (variant == 0) {
			
			problem = createError();
			problem.fill("BPELC_FROM__VARIANT", //$NON-NLS-1$
					toString(mNode.nodeName()),
					variant);
					
			disableRules();
			
		} else if (variant > 1) {
			
			problem = createError();
			problem.fill("BPELC_FROM__VARIANT", //$NON-NLS-1$
					toString(mNode.nodeName()),
					variant);
			
			disableRules();
		}
		
		
	}
	
	/** 
	 * Check the variable variant. 
	 */

	@ARule(
		desc = "Variables used in <from> must not have part set if they are schema types. "
			+ " (part must not be set) ",
		author = "michal.chmielewski@oracle.com",
		date = "01/15/2007",
		sa = 34 ,
		errors="BPELC_FROM__VARIABLE_PART,BPELC__PA_NO_PART"
	)
	public void rule_CheckVariableVariant_18 () {
		
		IProblem problem ;
		
		// variable is not specified.
		if (isUndefined(fVariableNode) || isDefined(fPropertyNode)) {					
			return ;
		}
	
		// The variable has a certain type. Get it from the variable validator.		
		INode varTypeNode = getValue(fVariableNode,"type",null);					
		
		if (isUndefined(varTypeNode)) {
			return ;
		}
		// type-of from is the variable type 
		setValue("type", varTypeNode);
		
		
		// Not a WSDL message
		if (WSDL_ND_MESSAGE.equals(varTypeNode.nodeName()) == false) {
			
			// not a WSDL message type
			if (isEmpty(fPartName) == false) {
				problem = createError();
				problem.fill("BPELC_FROM__VARIABLE_PART", //$NON-NLS-1$
						toString(mNode.nodeName()),
						AT_VARIABLE,
						fVariableNode.getAttribute(AT_NAME)
				);				
			}	
						
		} else if (isEmpty(fPartName) == false ) {

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
	 * Check to make sure that if endpointReference is set to myRole
	 * the partner link specifies the attribute myRole.
	 */
	@SuppressWarnings({"boxing", "nls"})
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "A partner link referenced in a <from> spec with endpoint " + 
		       " reference of 'myRole' must have myRole set.",
		date = "01/10/2007",
		sa = 35 ,
		errors="BPELC_FROM__PARTNER_LINK"
	)
	
	public void rule_CheckPartnerLinkVariantMyRole_21 () {
		
		if ( isUndefined(fPartnerLinkNode) ) {
			return ;
		}
		
		IProblem problem;
		
		if (AT_MY_ROLE.equals(fEndpointReference)) {
			
			String myRole = fPartnerLinkNode.getAttribute(AT_MY_ROLE);
			
			if (isEmptyOrWhitespace(myRole) ) {
				
				problem = createError();
				problem.fill("BPELC_FROM__PARTNER_LINK", //$NON-NLS-1$
							toString(mNode.nodeName()),
							fPartnerLinkNode.getAttribute(AT_NAME),
							fEndpointReference							
					);
				
			} else {
				// the effective "type" of this is portType.
				INode portType = getValue(fPartnerLinkNode,"role.portType." + myRole, null);
				
				setValue("type", portType);
			}
			
		 }	
	}
	
	
	
	/**
	 * Check to make sure that if endpointReference is set to partnerRole
	 * the partner link specifies the attribute partnerRole.
	 */
	@SuppressWarnings("nls")
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "A partner link referenced in a <from> spec with endpoint " + 
		       " reference of 'partnerRole' must have partnerRole set.",
		date = "01/10/2007",
		sa = 36 ,
		errors="BPELC_FROM__PARTNER_LINK"
	)
	
	public void rule_CheckPartnerLinkVariantPartnerRole_22 () {
		
		if ( isUndefined(fPartnerLinkNode) ) {
			return ;
		}
		
		IProblem problem;
		
		if (AT_PARTNER_ROLE.equals(fEndpointReference)) {
			
			String partnerRole = fPartnerLinkNode.getAttribute(AT_PARTNER_ROLE);
			
			if (isEmptyOrWhitespace(partnerRole) ) {
				
				problem = createError();
				problem.fill("BPELC_FROM__PARTNER_LINK", //$NON-NLS-1$
							toString(mNode.nodeName()),
							fPartnerLinkNode.getAttribute(AT_NAME),
							fEndpointReference							
							);				
			} else {
				
				// effective type is the portType
				INode portType = getValue(fPartnerLinkNode,"role.portType." + partnerRole, null);
				
				setValue("type", portType);
			}
		 }	
	}
	
	
	/**
	 * Check the literal variant. Here, an XML literal is
	 * being used as the source. 
	 *
	 */
	@SuppressWarnings({ "nls", "boxing" })
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "The literal <from> spec must return a EII or a TII only",
		date = "01/10/2007",
		sa = 38 ,
		errors="BPELC_FROM__LITERAL"
	)
	
	public void rule_CheckLiteralVariant_30 () {
		
		if (isUndefined(fLiteralNode)) {
			return ;
		}
		
		IProblem problem;
		
		List<INode> children = fLiteralNode.children();
		
		if (children.size() > 1) {
			problem = createError();
			problem.fill("BPELC_FROM__LITERAL",
					toString(mNode.nodeName()),
					fLiteralNode.nodeName(),
					children.size()
				);
		} 
		
		// Compute the type of this literal in this <from>
		
		if (children.size() > 0) {			
			INode first = children.get(0);
			// literal			
		}
		
	}
	
	
	
	/**
	 * Check the expression variant.
	 *
	 */
	
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "Checks the actual expression using the expression language validator.",		
		date = "10/2/2006",
		sa = 1000 ,
		warnings="BPELC__NO_EXPRESSION_VALIDATOR"
	)	
	public void rule_CheckExpressionVariant_50 () {
		// not this variant.
		if (fVariableNode != null || 
		    fPropertyNode != null || 
		    fPartnerLinkNode != null || 
		    fPartName != null ||
		    fLiteralNode != null ||
		    fQueryNode != null ) {
			
			return ;
		}		
		
		
		
		/** 
		 * How to dynamically add an validator to the chain.
		 * 
		 * 1. Have we been through here before ? 
		 */
		if (fExprValidator == null) {		
			
			/** 2. If no, then create the validator. We use the normal factory mechanism for */ 
			QName qname = new QName( fExpressionLanguage, mNode.nodeName().getLocalPart() );
		
			fExprValidator = RuleFactory.INSTANCE.createValidator ( qname ); 
		
			IProblem problem;
		
			if  (fExprValidator == null) {
			
				problem = createWarning();
				problem.fill("BPELC__NO_EXPRESSION_VALIDATOR",  //$NON-NLS-1$					
						toString(mNode.nodeName()),
						fExpressionLanguage
				);			
				return ;
			}
			
			/** 
			 * 3. Add this validator to my chain. Some points to follow below ... 		
			 *     a) add() will check against instance equality, but not against anything else.
			 *     b) because this is a "dynamic" addition, (validation is already running),
			 *        the code there will not be executed until all the rules here are done. 
			 */
			
			attach (fExprValidator);
						
		}		
		
		// "expression.type" is not computed until that validator is run.
		// this does not happen until we are done, to the IValue binding mechanism
		// is used.
		
		setValue("type", new IValue<Object>() {
				public Object get() {
					return fExprValidator.getValue("expression.type");
				}			
			}
		);
		
	}
	
		
	

	/**
	 * Check the expression variant.
	 *
	 */
	
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "Query variant checking.",		
		date = "07/07/2007",
		sa = 1000
	)	
	public void rule_CheckQueryVariant_55 () {
		
		if (fQueryNode == null) {
			return ;
		}
	}
	
	/** End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
