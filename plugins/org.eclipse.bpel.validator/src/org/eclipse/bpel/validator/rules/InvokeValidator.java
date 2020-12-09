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

/**
 * Dependency on the BPEL validation model only in here ...
 */
import java.util.List;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;


/**
 * Validate the invoke activity.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 19, 2006
 *
 */

@SuppressWarnings({ "nls", "boxing" })

public class InvokeValidator extends CPartnerActivityValidator {

	/**
	 * Rule to check the name of the variable. 
	 */
	
	INode fPartnerRoleNode;
	INode fInputVariableNode;
	INode fOutputVariableNode;

	
	INode fPortTypeFromRoleNode;
	List<INode> fToPartsParts;
	List<INode> fFromParts;
	
	String fInputVariableName;
	String fOutputVariableName;
			
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {
		super.checkChildren();
		checkChild(ND_CATCH,0,Integer.MAX_VALUE);
		checkChild(ND_CATCH_ALL,0,1);
		checkChild(ND_COMPENSATION_HANDLER,0,1);
		checkChild(ND_TO_PARTS,0,1);		
		checkChild(ND_FROM_PARTS,0,1);
	}

	
	/**
	 * 
	 * @see org.eclipse.bpel.validator.model.Validator#start()
	 */
	
	@Override
	protected void start () {
		
		super.start();		
				
		fInputVariableName = getAttribute(mNode, AT_INPUT_VARIABLE, KIND_ACTIVITY, Filters.NC_NAME,false);
		
		if (isEmpty(fInputVariableName) == false) {
			
			fInputVariableNode = mModelQuery.lookup(mNode,
					IModelQueryLookups.LOOKUP_NODE_VARIABLE,
					fInputVariableName );
			
		}
		
		fOutputVariableName = getAttribute(mNode, AT_OUTPUT_VARIABLE, KIND_ACTIVITY, Filters.NC_NAME, false);
		
		if (isEmpty(fOutputVariableName) == false) {					
			fOutputVariableNode = mModelQuery.lookup(mNode,					
					IModelQueryLookups.LOOKUP_NODE_VARIABLE,
					fOutputVariableName );
		}			
	
		fPartnerLinkType = null;
		fPartnerRoleNode = null;
		
	}


	/**
	 * Check the input variable on this Invoke activity.
	 *
	 */
	
	@ARule(
		sa = 2003,
		desc = "Check if inputVariable is set and exists and is defined correctly.",
		author="michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE",
		warnings="BPELC_REF_NODE_PROBLEMS"
	)
	public void rule_CheckInputVariable_3 () {
		fInputVariableNode = verifyVariable(fInputVariableNode, AT_INPUT_VARIABLE);
	}

	/**
	 * Check the output variable on this Invoke activity.
	 *
	 */
	@ARule(
		sa = 2004,
		desc = "Check if outputVariable is set and exists and is defined correctly.",
		author="michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE",
		warnings="BPELC_REF_NODE_PROBLEMS"
	)

	public void rule_CheckOutputVariable_3 () {
		fOutputVariableNode = verifyVariable(fOutputVariableNode, AT_OUTPUT_VARIABLE);
	}
	
	
	
	/**
	 * Check the presence of toParts.
	 */
	
	@ARule(
		sa = 51,
		desc = "Check to see if toPart is specified; if so then " +
		       " inputVariable must not be used on the reply.",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__PA_PARTS"
	)	
	public void rule_checkToPartsPresence_10 () {
			
		fToPartsParts = mSelector.selectNodes(mNode, ND_TO_PARTS, ND_TO_PART );
		
		IProblem problem;
		
		if (fToPartsParts.size() > 0 && isEmpty(fInputVariableName) == false )  {			
			problem = createError();
			problem.fill("BPELC__PA_PARTS",
					toString(mNode.nodeName()),
					ND_TO_PART,
					AT_INPUT_VARIABLE,
					KIND_ACTIVITY);
			
		}
	}
			
	
	/**
	 * Check the presence of fromParts.
	 */
	
	
	
	@ARule(
		sa = 52,
		desc = "Check to see if fromPart is specified; if so then " +
		       " outputVariable must not be used on invoke.",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__PA_PARTS"
	)
	
	public void rule_checkFromPartsPresence_11 () {			
				
		fFromParts = mSelector.selectNodes(mNode, ND_FROM_PARTS, ND_FROM_PART );
		
		IProblem problem;
		
		if (fFromParts.size() > 0 && isEmpty(fOutputVariableName) == false)  {			
			problem = createError();
			problem.fill("BPELC__PA_PARTS",
					toString(mNode.nodeName()),
					ND_FROM_PART,
					AT_OUTPUT_VARIABLE,
					KIND_ACTIVITY);
			return ;
		}
		
	}
	
	
	
	
	/**
	 * Check if the partner role is defined on this partner link.
	 */
		
	@ARule(
			author = "michal.chmielewski@oracle.com",
			date = "9/25/2006",
			desc = "Checks if partner role is defined in invoke activity.",
			errors = "BPELC_MISSING_ROLE"
		)
		
	public void rule_CheckIfPartnerRoleIsDefined_5 () {		
		fPartnerRoleNode = lookupRoleNode ( fPartnerLinkNode, AT_PARTNER_ROLE );
	}


	

	/**
	 * Check if the partnerLinkType derived port type and the port type present
	 * on the invoke are one and the same.
	 */
	@ARule(
		author = "michal.chmielewski@oracle.com",
		date = "9/25/2006",
		desc = "Checks portType and derived portType values on invoke activity.",
		sa = 5 ,
		errors="BPELC_MISMATCH_ROLE_PORT_TYPE"
	)
	public void rule_CheckRolePortTypeWithInvokePortType_10 ()
	{
		fPortTypeFromRoleNode = verifyPortTypeFromRole(fPartnerRoleNode, AT_PARTNER_ROLE,fPortType);		
	}
	
	/**
	 * 1) Invoke needs partnerRole set. 
	 * 2) partnerRole -> portType
	 * 3) portType (has operations) -> operation
	 * 4) operation -> "input" message must be set. "output" message may be set 
	 *  
	 */
	
	INode fOutputMessageType;
	INode fInputMessageType;
	protected boolean fbIs2Way;
	
	
	/** 
	 * Checks the Input Message for the invoke. This just makes
	 * sure that input message is defined in the WSDL.
	 * 
	 */
	@ARule(
			author = "michal.chmielewski@oracle.com",
			date = "9/25/2006",
			desc = "Checks if input and output messages are defined for invoke activity.",
			errors="BPELC_PA__NO_MESSAGE,BPELC_PA__MSG_TYPE"
		)
	public void rule_CheckInputOutputMessages_12 () {
		
		fInputMessageType = findMessageType (fPortTypeFromRoleNode,fOperation,WSDL_ND_INPUT,true );
		setValue("input.message.type", fInputMessageType);
		
		fOutputMessageType = findMessageType (fPortTypeFromRoleNode,fOperation,WSDL_ND_OUTPUT, false );			
		setValue("output.message.type", fOutputMessageType);
		

	}

	
	/**
	 * One-way invocation requires only the inputVariable (or its equivalent
	 * <toPart> elements) since a response is not expected as part of the
	 * operation (see section 10.4. Providing Web Service Operations – Receive
	 * and Reply ). Request-response invocation requires both an inputVariable
	 * (or its equivalent <toPart> elements) and an outputVariable (or its
	 * equivalent <fromPart> elements). If a WSDL message definition does not
	 * contain any parts, then the associated attributes variable, inputVariable
	 * or outputVariable, MAY be omitted,and the <fromParts> or <toParts>
	 * construct MUST be omitted.
	 * 
	 */
	
	@ARule(
		sa = 47,
		desc = "One invocation requires inputVariable (or toPart); " 
			  + " 2-way invocation requires outputVariable (or fromPart)",
			  
		author = "michal.chmielewski@oracle.com",
		date = "02/22/2007",
		errors="BPELC_PA__OMIT,BPELC__UNSET_ATTRIBUTE,"
	)	
	
	public void rule_CheckTwoWayInvocation_25 () {

		boolean is2Way = isDefined(fInputMessageType) && isDefined(fOutputMessageType);
		
		setValue("2way", is2Way);
		
		if (isUndefined(fPartnerLinkNode)) {
			return ;
		}
		
		IProblem problem;
				
		if (isUndefined(fInputMessageType)) {
			
			if (fToPartsParts.size() > 0) {
				problem = createError();
				problem.fill("BPELC_PA__OMIT",
					toString(mNode.nodeName()),
					fPartnerLinkNode.getAttribute(AT_NAME),
					WSDL_ND_INPUT,
					KIND_NODE,
					ND_TO_PART
				);
			}
			
		} else {
			/** Message is defined */
			if (isEmpty(fInputVariableName) && fToPartsParts.size() == 0) {
				problem = createError();
				problem.fill("BPELC__UNSET_ATTRIBUTE",
						toString(mNode.nodeName()),
						AT_INPUT_VARIABLE,
						KIND_ACTIVITY
				 );
			}
		}
		
		
		
		if ( isUndefined(fOutputMessageType) ) {
			
			if (isDefined(fOutputVariableNode)) {
				problem = createError();
				problem.fill("BPELC_PA__OMIT",
					toString(mNode.nodeName()),
					fPartnerLinkNode.getAttribute(AT_NAME),
					WSDL_ND_OUTPUT,
					KIND_ATTRIBUTE,
					AT_OUTPUT_VARIABLE
				);				
			}
			
			if (fFromParts.size() > 0) {
				problem = createError();
				problem.fill("BPELC_PA__OMIT",
					toString(mNode.nodeName()),
					fPartnerLinkNode.getAttribute(AT_NAME),
					WSDL_ND_OUTPUT,
					KIND_NODE,
					ND_FROM_PART
				);
				
			}
		} else {
			/** Output message is defined */
			if (isEmpty(fOutputVariableName) && fFromParts.size() == 0) {
				problem = createError();
				problem.fill("BPELC__UNSET_ATTRIBUTE",
						toString(mNode.nodeName()),
						AT_OUTPUT_VARIABLE,
						KIND_ACTIVITY
				 );
			}
		}
		
		
		
	}
	/**
	 * Check variable and message structure compatibility.
	 *
	 */
	@ARule(
		sa = 48,
		desc = "Check message type compatability on invoke",
		author = "michal.chmielewski@oracle.com",
		date = "02/22/2007",
		errors="BPELC_PA__MESSAGE_TYPE_MISMATCH"
	)
	public void rule_CheckVariableAndMessageStructureCompatibility_40 ()
	{
		IProblem problem;
		INode varType ;
		
		if (isDefined(fInputMessageType) && isDefined( fInputVariableNode )) {
			// the variable validator will have the type of variable.
			varType = getValue(fInputVariableNode,"type", null );
		
			if (isDefined(varType)) {
				
				// source -> destination		
				if (mModelQuery.check( IModelQueryLookups.TEST_COMPATIBLE_PARTNER_ACTIVITY_MESSAGE, varType, fInputMessageType ) == false) {
						
					problem = createError( );
					problem.fill( "BPELC_PA__MESSAGE_TYPE_MISMATCH",  //$NON-NLS-1$
							toString(mNode.nodeName()),
							AT_INPUT_VARIABLE,
							fInputVariableNode.getAttribute( AT_NAME ),
							fInputMessageType,
							varType
					);
				}
			}
		}
		
		if (isDefined(fOutputMessageType) && isDefined( fOutputVariableNode )) {
			
			// the variable validator will have the type of variable.
			varType = getValue(fOutputVariableNode,"type", null );
		
			if (isDefined(varType)) {
				
				// source -> destination		
				if (mModelQuery.check( IModelQueryLookups.TEST_COMPATIBLE_PARTNER_ACTIVITY_MESSAGE, varType, fOutputMessageType ) == false) {
						
					problem = createError( );
					problem.fill( "BPELC_PA__MESSAGE_TYPE_MISMATCH",  //$NON-NLS-1$
							toString(mNode.nodeName()),
							AT_OUTPUT_VARIABLE,
							fOutputVariableNode.getAttribute( AT_NAME ),
							fOutputMessageType,
							varType
					);
				}
			}
		}
		
		
		
		
	}
	
	
	
	
}
