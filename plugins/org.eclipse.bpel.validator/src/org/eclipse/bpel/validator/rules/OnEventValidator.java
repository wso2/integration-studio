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


import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Filter;
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;
import org.eclipse.bpel.validator.model.ValueFilter;

/**
 * Dependency on the BPEL validation model only in here.
 * Structurarily, the onEvent looks like this 
 * <pre>
   <onEvent partnerLink="NCName"
      portType="QName"?
      operation="NCName"
      ( messageType="QName" | element="QName" )?
      variable="BPELVariableName"?
      messageExchange="NCName"?>*
      <correlations>?
         <correlation set="NCName" initiate="yes|join|no"? />+
      </correlations>
      <fromParts>?
         <fromPart part="NCName" toVariable="BPELVariableName" />+
      </fromParts>
      <scope ...>...</scope>
    </onEvent>
   </pre>
 */



/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 28, 2008
 *
 */

@SuppressWarnings( {"hiding","nls","boxing"} )
public class OnEventValidator extends CPartnerActivityValidator {
		

	protected INode fMyRoleNode;
	
	protected INode fVariable;
	protected INode fPortTypeFromRole;
	protected INode fAssociatedScope;
	
	protected String fCreateInstance;

	protected int fFromPartsCount;

	protected String fVariableName;

	private INode fVariableType;
		
	/** The parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_EVENT_HANDLERS );
		
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {
		super.checkChildren();
		fFromPartsCount = checkChild(ND_FROM_PARTS,0,1);
		checkChild(ND_SCOPE, 1, 1);
	}
	
	
	/**
	 * 
	 * @see org.eclipse.bpel.validator.model.Validator#start()
	 */
	
	@Override
	protected void start () {		
		super.start();
		
		fAssociatedScope = mSelector.selectNode(mNode, ND_SCOPE);
		
		setValue("associated.scope",fAssociatedScope);
	}
	


	/**
	 * @see org.eclipse.bpel.validator.rules.CActivityValidator#rule_CheckName_1()
	 */
	@Override
	public void rule_CheckName_1() {
		// we don't check the name, disable it here.
	}

	/**
	 * @see org.eclipse.bpel.validator.rules.CActivityValidator#rule_CheckSuppressJoinFailure_1()
	 */
	@Override
	public void rule_CheckSuppressJoinFailure_1() {
		// we don't do anything here, disable it on OnMessage
	}
	
	/** 
	 * @see org.eclipse.bpel.validator.rules.CPartnerActivityValidator#rule_LookupPartnerLink_0()
	 * 
	 * This method overrides the same method in the parent class.  
	 */
	
	@ARule(
		sa = 84,
		desc = "Partner Link resolution: associated scope first, then ancestor scopes",
		author = "michal.chmielewski@oracle.com",
		date = "03/15/2007",
		errors = "BPELC_MISSING_ROLE"
	)
	@Override
	public void rule_LookupPartnerLink_0 () {
		
		INode context = fAssociatedScope;
		
		if (isUndefined(context)) {
			context = mNode;
		}
		
		fPartnerLinkNode = mModelQuery.lookup (context ,
				IModelQueryLookups.LOOKUP_NODE_PARTNER_LINK ,
				mNode.getAttribute( AT_PARTNER_LINK ) );
		
		
		markSAExecution(null);		
	}
	
	

	static IFilter<QName> TYPE_DEFS = new ValueFilter<QName>( 
			Filter.QNAME_COMPARATOR,
			AT_MESSAGE_TYPE, AT_ELEMENT);
	
	
	/**
	 * If the variable attribute is used in the <onEvent> element, either the
	 * messageType or the element attribute MUST be provided in the <onEvent>
	 * element.
	 */
	@ARule(
		sa = 90,
		desc = "Either messageType or element must be specified if variable variant is used",
		date = "3/15/2007",
		author = "michal.chmielewski@oracle.com",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE,BPELC__AT_LEAST_ONE,BPELC__AT_MOST_ONE,BPELC__SPECIFY_NONE"
	)
	
	public void rule_LookupVariable_5 () {
		
		fVariableName = getAttribute(mNode, AT_VARIABLE, KIND_ACTIVITY, Filters.NC_NAME, false);
			
		IProblem problem;
		
		// messageType or element must be used
		String msgType = mNode.getAttribute(AT_MESSAGE_TYPE);
		String elmDecl = mNode.getAttribute(AT_ELEMENT);

		boolean bMsgTypeEmpty = isEmptyOrWhitespace(msgType);
		boolean bElmDeclEmpty = isEmptyOrWhitespace(elmDecl);

		
		if (isEmpty(fVariableName) == false) {
						
			
			// both empty
			if ( bElmDeclEmpty && bMsgTypeEmpty) {
				
				problem = createError();
				problem.fill("BPELC__AT_LEAST_ONE",
						toString(mNode.nodeName()),
						KIND_ACTIVITY,
						TYPE_DEFS,
						KIND_ATTRIBUTE
				);
				
				return ;							
			} 
			
			
			// both specified			
			if ( !bElmDeclEmpty && !bMsgTypeEmpty) {
				
				problem = createError();
				problem.fill("BPELC__AT_MOST_ONE",
						toString(mNode.nodeName()),
						KIND_ACTIVITY,
						TYPE_DEFS,
						KIND_ATTRIBUTE
				);										
			} 
			
			
			if (!bElmDeclEmpty) {
				// element is specified
				fVariableType = mModelQuery.lookup(mNode, 
						IModelQueryLookups.LOOKUP_NODE_XSD_ELEMENT,elmDecl);
				checkAttributeNode(mNode, fVariableType, AT_ELEMENT, KIND_ACTIVITY);
				
			} 
			
			if (!bMsgTypeEmpty) {
				// message type is specified
				fVariableType = mModelQuery.lookup(mNode, 
						IModelQueryLookups.LOOKUP_NODE_MESSAGE_TYPE,msgType);
				checkAttributeNode(mNode, fVariableType, AT_MESSAGE_TYPE, KIND_ACTIVITY);
			}

		
		} else {

			// the message type or element declaration must not be present
			if (!bMsgTypeEmpty || !bElmDeclEmpty) {
				problem = createError();
				problem.fill("BPELC__SPECIFY_NONE",
						toString(mNode.nodeName()),
						KIND_NODE,
						TYPE_DEFS,
						KIND_ATTRIBUTE);
			}
		}
		
	}
	
	
	/**
	 * Check if the partner role is defined on this partner link.
	 */
		
	@ARule(
			sa = 84,
			author = "michal.chmielewski@oracle.com",
			date = "9/25/2006",
			desc = "Checks if my role is defined in onMessage activity.",
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
		date = "03/13/2007",
		desc = "Checks portType and derived portType values on onEvent.",
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
			desc = "Checks if input message is defined for onEvent activity.",
			errors="BPELC_PA__NO_MESSAGE,BPELC_PA__MSG_TYPE"
		)
	public void rule_CheckInputMessage_12 () {		
		fInputMessage = findMessageType (fPortTypeFromRole, fOperation,WSDL_ND_INPUT, true );
		setValue("input.message.type", fInputMessage);
	}
	
	
	/**
	 * 
	 */
	@ARule(
		sa = 87,
		desc = "Check message type compatability on onEvent",
		author = "michal.chmielewski@oracle.com",
		date = "03/15/2007",
		errors="BPELC_PA__MESSAGE_TYPE_MISMATCH"
	)
	public void rule_CheckVariableAndMessageStructureCompatibility_20 ()
	{
		IProblem problem;
		
		if (isUndefined(fInputMessage)  || isUndefined( fVariableType )) {
			return ;
		}
			
		// source -> destination		
		if (mModelQuery.check( IModelQueryLookups.TEST_COMPATIBLE_PARTNER_ACTIVITY_MESSAGE, fVariableType, fInputMessage ) == false) {
				
			problem = createError( );
			problem.fill( "BPELC_PA__MESSAGE_TYPE_MISMATCH",  //$NON-NLS-1$
					toString(mNode.nodeName()),
					AT_VARIABLE,
					fVariableName,
					fInputMessage,
					fVariableType						
			);
		}
		
		markSAExecution(null);
	}
		
	
	/**
	 * Check the presence of fromParts.
	 */
	


	@ARule(
		sa = 85,
		desc = "Check to see if fromPart is specified; if so then " +
		       " variable must not be used onEvent.",
		author = "michal.chmielewski@oracle.com",
		date = "03/20/2007",
		errors="BPELC__PA_PARTS"
	)
	public void rule_checkFromPartsPresence_50 () {
		
		List<INode> fFromParts;
			
		fFromParts = mSelector.selectNodes(mNode, ND_FROM_PARTS, ND_FROM_PART );
			
		IProblem problem;
			
		boolean bNoVariable = isEmptyOrWhitespace(mNode.getAttribute(AT_VARIABLE));
		if (fFromParts.size() > 0 && !bNoVariable)  {			
			problem = createError();
			problem.fill("BPELC__PA_PARTS",
					toString(mNode.nodeName()),
					ND_FROM_PART,
					AT_VARIABLE,
					KIND_ACTIVITY);			
		}

		
		if (fFromParts.size() == 0 && bNoVariable) {
			problem = createError();
			problem.fill("BPELC__PA_PARTS",
					toString(mNode.nodeName()),
					ND_FROM_PART,
					AT_VARIABLE,
					KIND_ACTIVITY);
		}
	}
	
}

