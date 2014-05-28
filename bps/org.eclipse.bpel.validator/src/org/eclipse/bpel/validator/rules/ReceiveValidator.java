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

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;


/**
 * Validate the receive activity.
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 25, 2006
 *
 */

@SuppressWarnings({"nls","boxing"})

public class ReceiveValidator extends CPartnerActivityValidator {
		
	protected INode fMyRoleNode;
			
	protected INode fVariable;
	protected INode fPortTypeFromRole;

	protected String fCreateInstance;

	protected int fFromPartsCount;

	protected String fVariableName;	

	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {
		super.checkChildren();
		fFromPartsCount = checkChild(ND_FROM_PARTS,0,1);		
	}

	
	/**
	 * 
	 * @see org.eclipse.bpel.validator.model.Validator#start()
	 */
	
	@Override
	protected void start () {
		
		super.start();
	}
	
	
	/**
	 * Lookup variable
	 */
	@ARule(
			desc = "Check variable on receive activity",
			author = "michal.chmielewski@oracle.com",
			date = "01/10/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
		)
	public void rule_LookupVariable_1 () {
		
		fVariableName = getAttribute(mNode, AT_VARIABLE, KIND_ACTIVITY, Filters.NC_NAME, false);
		
		if (isEmpty(fVariableName) == false) {
			fVariable = mModelQuery.lookup(mNode,
							IModelQueryLookups.LOOKUP_NODE_VARIABLE,
							fVariableName );
		
		}
		
		fPartnerLinkType = null;
		fMyRoleNode = null;
		
	}

		
	/** 
	 * Checks to see if the createInstance attribute is set to either yes/no
	 *
	 */
	@ARule(
			desc = "Check createInstance attribute on receive activity.",
			author = "michal.chmielewski@oracle.com",
			date = "01/10/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
		)
	public void rule_CheckCreateInstanceSetting_2 () {
		
		fCreateInstance = getAttribute(mNode, 
				AT_CREATE_INSTANCE, 
				KIND_ACTIVITY, 
				Filters.BOOLEAN_FILTER, 
				false);
		
		if (isEmpty(fCreateInstance)) {			
			fCreateInstance = NO;
		} 
	}
	
	/**
	 * Check if this is a valid start activity. 
	 *
	 */
	@ARule(
		sa = 56,
		desc = "Check if this 'start' <receive> activity is positioned correctly",
		author = "michal.chmielewski@oracle.com",
		date = "01/10/2007",
		errors="BPELC__START_ACTIVITY"
	)
	
	public void rule_CheckIfStartActivity_3 () {
		
		if (NO.equals(fCreateInstance)) {
			return ;
		}
		
		checkStartActivityPositioning();
		
		// mark in the process that we are a start activity.											
		List<INode> starts = getValue ( mNode.rootNode(), "start.activities" , null );								
		starts.add( mNode );
	}
	

	/**
	 * Check to see if the variable in the receive is set and is resolvable.
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
	public void rule_CheckVariable_3 () {		
		fVariable = verifyVariable( fVariable, AT_VARIABLE );				
	}
	
	
	
		
	
	/**
	 * Check if the partner role is defined on this partner link.
	 */
		
	@ARule(
			author = "michal.chmielewski@oracle.com",
			date = "9/25/2006",
			desc = "Checks if partner role is defined in receive activity.",
			errors = "BPELC_MISSING_ROLE"
		)
	public void rule_CheckIfMyRoleIsDefined_5 () {		
		fMyRoleNode = lookupRoleNode ( fPartnerLinkNode , AT_MY_ROLE );
	}

	

	/**
	 * Check if the partnerLinkType derived port type and the port type present
	 * on the receive are one and the same.
	 */
	@ARule(
		author = "michal.chmielewski@oracle.com",
		date = "9/25/2006",
		desc = "Checks portType and derived portType values on receive activity.",
		sa = 5 ,
		errors="BPELC_MISMATCH_ROLE_PORT_TYPE"
	)
	
	public void rule_CheckRolePortTypeWithReceivePortType_10 ()	{
		fPortTypeFromRole = verifyPortTypeFromRole ( fMyRoleNode, AT_MY_ROLE, fPortType ) ;					
	}
			
	
	/**
	 * 1) Receive needs myRole set. 
	 * 2) myRole -> portType
	 * 3) portType (has operations) -> operation
	 * 4) operation -> "input" message must be set.
	 */
	
	INode fInputMessage ;
	
	/** 
	 * Checks the Input Message for the receive. This just makes
	 * sure that input message is defined in the WSDL.
	 * 
	 */
	

	@ARule(
			author = "michal.chmielewski@oracle.com",
			date = "9/25/2006",
			desc = "Checks if input messages is defined for receive activity.",
			errors="BPELC_PA__NO_MESSAGE,BPELC_PA__MSG_TYPE"
		)
	public void rule_CheckInputMessage_12 () {		
		fInputMessage = findMessageType (fPortTypeFromRole, fOperation,WSDL_ND_INPUT, true );
		setValue("input.message.type", fInputMessage);
	}
	
	
	

	/**
	 * Check variable and message structure compatibility.
	 *
	 */
	@ARule(
		sa = 58,
		desc = "Check message type compatability on receive",
		author = "michal.chmielewski@oracle.com",
		date = "02/22/2007",
		errors="BPELC_PA__MESSAGE_TYPE_MISMATCH"
	)
	public void rule_CheckVariableAndMessageStructureCompatibility_20 ()
	{
		IProblem problem;
		
		if (isUndefined(fInputMessage)  || isUndefined( fVariable )) {
			return ;
		}
	
		// the variable validator will have the type of variable.
		INode varType = getValue(fVariable,"type", null );
		
		if (isUndefined(varType)) {
			return ;
		}
		
		// source -> destination		
		if (mModelQuery.check( IModelQueryLookups.TEST_COMPATIBLE_PARTNER_ACTIVITY_MESSAGE, varType, fInputMessage ) == false) {
				
			problem = createError( );
			problem.fill( "BPELC_PA__MESSAGE_TYPE_MISMATCH",  //$NON-NLS-1$
					toString(mNode.nodeName()),
					AT_VARIABLE,
					fVariable.getAttribute( AT_NAME ),
					fInputMessage,
					varType
			);
		}
	}
	
	
	
	/**
	 * Check the presence of fromParts.
	 */
	

	
	@ARule(
		sa = 55,
		desc = "Check to see if fromPart is specified; if so then " +
		       " variable must not be used on the receive.",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__PA_PARTS"
	)	
	public void rule_checkFromPartsPresence_50 () {
	
		List<INode> fFromParts;
		
		fFromParts = mSelector.selectNodes(mNode, ND_FROM_PARTS, ND_FROM_PART );
		
		IProblem problem;
		
		if (fFromParts.size() > 0 && isEmptyOrWhitespace(mNode.getAttribute(AT_VARIABLE)) == false)  {			
			problem = createError();
			problem.fill("BPELC__PA_PARTS",
					toString(mNode.nodeName()),
					toString (ND_FROM_PART) ,
					AT_VARIABLE,
					KIND_ACTIVITY);			
		}		
	}
	
	
}
