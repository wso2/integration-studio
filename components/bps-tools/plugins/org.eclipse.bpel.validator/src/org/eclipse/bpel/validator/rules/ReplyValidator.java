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

@SuppressWarnings("nls")

public class ReplyValidator extends CPartnerActivityValidator {
		
	protected INode fPartnerRoleNode;
			
	protected INode fVariable;
	protected INode fPortTypeFromRole;

	protected String fVariableName;	

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {
		super.checkChildren();
		checkChild(ND_TO_PARTS,0,1);		
	}
	
	/**
	 * 
	 * @see org.eclipse.bpel.validator.model.Validator#start()
	 */
	
	@Override
	protected void start () {
		
		super.start();
			
		fVariableName = getAttribute(mNode, AT_VARIABLE, KIND_ACTIVITY, Filters.NC_NAME, false);
		fVariable = mModelQuery.lookup(mNode,
						IModelQueryLookups.LOOKUP_NODE_VARIABLE,
						fVariableName );
		
		
		fPartnerLinkType = null;
		fPartnerRoleNode = null;
	}

	

	/**
	 * Check to see if the variable in the receive is set and is resolvable.
	 * 
	 *
	 */
	@ARule(
			sa = 2003,
			desc = "Check if outputVariable is set and exists and is defined correctly.",
			author="michal.chmielewski@oracle.com",
			date = "01/20/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE",
			warnings="BPELC_REF_NODE_PROBLEMS"
		)
	public void rule_CheckVariable_3 () {
		
		fVariable = verifyVariable(fVariable, AT_VARIABLE) ;
	}
	
	
	
		
	
	/**
	 * Check if the partner role is defined on this partner link.
	 */
		
	@ARule(
			author = "michal.chmielewski@oracle.com",
			date = "9/25/2006",
			desc = "Checks if partner role is defined in reply activity.",
			errors = "BPELC_MISSING_ROLE"
		)
	public void rule_CheckIfPartnerRoleIsDefined_5 () {		
		fPartnerRoleNode = lookupRoleNode ( fPartnerLinkNode, AT_PARTNER_ROLE );
	}

	

	/**
	 * Check if the partnerLinkType derived port type and the port type present
	 * on the receive are one and the same.
	 */
	
	@ARule(
		author = "michal.chmielewski@oracle.com",
		date = "9/25/2006",
		desc = "Checks portType and derived portType values on reply activity.",
		sa = 5 ,
		errors="BPELC_MISMATCH_ROLE_PORT_TYPE"
	)
	public void rule_CheckRolePortTypeWithReceivePortType_10 ()
	{
		fPortTypeFromRole = verifyPortTypeFromRole(fPartnerRoleNode, AT_PARTNER_ROLE,fPortType);
	}
			
	
	/**
	 * 1) Reply needs partnerRole set. 
	 * 2) partnerRole -> portType
	 * 3) portType (has operations) -> operation
	 * 4) operation -> "input" message must be set.
	 */
	
	INode fOutMessage ;
	
	/** 
	 * Checks the Input Message for the receive. This just makes
	 * sure that input message is defined in the WSDL.
	 * 
	 */
	
	
	@ARule(
			author = "michal.chmielewski@oracle.com",
			date = "9/25/2006",
			desc = "Checks if output message is defined for reply activity.",
			errors="BPELC_PA__NO_MESSAGE,BPELC_PA__MSG_TYPE"
		)
	public void rule_CheckOutputMessage_12 () {		
		fOutMessage = findMessageType (fPortTypeFromRole,fOperation,WSDL_ND_OUTPUT, true );
		setValue("input.message.type", fOutMessage);
	}
	
	
	

	/**
	 * Check variable and message structure compatibility.
	 *
	 */
	
	@ARule(
		sa = 58,
		desc = "Check message type compatability on reply",
		author = "michal.chmielewski@oracle.com",
		date = "02/22/2007",
		errors="BPELC__PA_PARTS"
	)
	
	public void rule_CheckVariableAndMessageStructureCompatibility_20 ()
	{
		IProblem problem;
		
		if (isUndefined(fOutMessage)  || isUndefined(fVariable )) {
			return ;
		}
	
		//	the variable validator will have the type of variable.
		INode varType = getValue(fVariable, "type", null );
		
		if (isUndefined(varType)) {
			return ;
		}
		
		// source -> destination		
		if (mModelQuery.check( IModelQueryLookups.TEST_COMPATIBLE_PARTNER_ACTIVITY_MESSAGE, varType, fOutMessage ) == false) {
				
			problem = createError( );
			problem.fill( "BPELC_PA__MESSAGE_TYPE_MISMATCH",  //$NON-NLS-1$
					toString(mNode.nodeName()),
					AT_VARIABLE,
					fVariable.getAttribute( AT_NAME ),
					fOutMessage,
					varType
			);
		}
	}
	
	
	
	/**
	 * Check the presence of toParts.
	 */
	
	@SuppressWarnings({ "nls", "boxing" })
	
	@ARule(
		sa = 59,
		desc = "Check to see if toPart is specified; if so then " +
		       " variable must not be used on the reply.",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__PA_PARTS"
	)	
	public void rule_checkToPartsPresence_50 () {
	
		List<INode> fFromParts;
		
		fFromParts = mSelector.selectNodes(mNode, ND_TO_PARTS, ND_TO_PART );
		
		IProblem problem;
		
		if (fFromParts.size() > 0 && isEmpty(fVariableName) == false)  {			
			problem = createError();
			problem.fill("BPELC__PA_PARTS",
					toString(mNode.nodeName()),
					ND_TO_PART,
					AT_VARIABLE,
					KIND_ACTIVITY);

		}		
	}
	
}
