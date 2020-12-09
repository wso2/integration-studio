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
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeAttributeValueFilter;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Mar 16, 2007
 *
 */
/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 5, 2006
 *
 */

@SuppressWarnings("nls")

public class CPartnerActivityValidator extends CActivityValidator {
		
	protected INode fPartnerLinkNode;
	protected String fOperation;
	protected INode fPortType;
	
	protected INode fPartnerLinkType;
	
	protected boolean resolvedPartnerLinkType;
	
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {
		super.checkChildren();
		checkChild(ND_CORRELATIONS,0,1);		
	}
	
	/**
	 * Start the validation of this node.
	 */
	
	@Override
	protected void start () {		
		super.start();			
	}
	
	/**
	 * Partner link type lookup.
	 *
	 */
	
	public void rule_LookupPartnerLink_0 () {
		
		fPartnerLinkNode = mModelQuery.lookup (mNode ,
				IModelQueryLookups.LOOKUP_NODE_PARTNER_LINK ,
				mNode.getAttribute( AT_PARTNER_LINK ));

	}
	
	/**
	 * Lookup port type 
	 */
	
	public void rule_LookupPortType_0 () {
		// Look up the port type absolutely.
		fPortType = mModelQuery.lookup(mNode,
			IModelQueryLookups.LOOKUP_NODE_PORT_TYPE,
			mNode.getAttribute( AT_PORT_TYPE ));
	}
	
	/**
	 * Check if operation is set.
	 *
	 */
	
	@ARule(
			sa = 88,
			desc = "Correlation set lookup, first associated scope, then ancestor scopes",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
		)
	public void rule_CheckOperationSet_0 () {		
		fOperation = getAttribute(mNode, AT_OPERATION, KIND_ACTIVITY, 
				Filters.NC_NAME, true);
	}
	
	
	/**
	 * Checks partner link. Partner link must be set on a partner activity.
	 *
	 */
	
	@ARule(
			desc = "Check if partner link exists",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE",
			warnings="BPELC_REF_NODE_PROBLEMS"
		)
	public void rule_CheckPartnerLink_2 () {
		
		if (checkAttributeNode(mNode, fPartnerLinkNode, AT_PARTNER_LINK, KIND_ACTIVITY ) == false) {
			// partnerLink is not accessible.
			fPartnerLinkNode = null;
			return ;
		}
		
		if (checkValidator(mNode,fPartnerLinkNode,AT_PARTNER_LINK,KIND_ACTIVITY) == false) {			
			fPartnerLinkNode = null;
			return ;
		}
		
	}
			
	
	/**
	 * If the portType attribute is included for readability, 
	 * in a <receive>, <reply>, <invoke>, <onEvent> or <onMessage>  element, 
	 * the value of the portType attribute MUST match the portType value implied
	 * by the combination of the specified partnerLink and the role implicitly
	 * specified by the activity.
	 *
	 */
	@ARule(
			desc = "Check if port type exists",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE",
			warnings="BPELC_REF_NODE_PROBLEMS"
		)
	public void rule_CheckPortType_3 () {
	
		// Port Type
		if (fPortType == null) {
			return ;
		}
		
		if (checkAttributeNode(mNode, fPortType, AT_PORT_TYPE , KIND_ACTIVITY) == false) {
			// portType is not accessible.
			fPortType = null;
			return;
		}
		
		if (checkValidator(mNode,fPortType,AT_PORT_TYPE,KIND_ACTIVITY) == false) {
			fPortType = null;
			return ;
		}
	}
		
		

	/**
	 * Check the basic of the partner link.
	 *
	 */
	
	@ARule(
			desc = "Check partner link type",
			author = "michal.chmielewski@oracle.com",
			date = "02/27/2007",
			warnings="BPELC_REF_NODE_PROBLEMS"
		)
	public void rule_CheckPartnerLinkType_4 () {
				
		if (isUndefined(fPartnerLinkNode)) {
			return ;
		}
		
		fPartnerLinkType = mModelQuery.lookup(fPartnerLinkNode, 
								IModelQueryLookups.LOOKUP_NODE_PARTNER_LINK_TYPE,
								mNode.getAttribute(AT_PARTNER_LINK_TYPE) );				
		
		// we don't generate any messages here since these would be generated 
		// in the partner link type validation. Here, we just have to make sure
		// that we can resolve this partner link to its partnerLinkType
		
		if ( isDefined(fPartnerLinkType) ) {
			resolvedPartnerLinkType = true;
		} else {
			
			// unresolved. error, this partner link type cannot be resolved.
			if (checkValidator(fPartnerLinkNode,fPartnerLinkType,AT_PARTNER_LINK_TYPE,KIND_NODE) == false) {
				fPartnerLinkType = null;		
				resolvedPartnerLinkType = false;
			}		
		}
		
	}
	
		
	
	/**
	 * These are shared among the various partner activities.
	 * 
	 */
	
	
	@ARule(
			desc = "Check variable exists",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE",
			warnings="BPELC_REF_NODE_PROBLEMS"
		)
	protected INode verifyVariable ( INode varNode, QName atName) {

		// variable is optional, if not specified the there better be fromParts		
		if (varNode == null) {
			return varNode ;
		}
		
		if (checkAttributeNode (mNode, varNode, atName, KIND_ACTIVITY ) == false) {
			// variable is not accessible (either undefined or whatever).
			return null;
		}
		
		if (checkValidator(mNode,varNode,atName,KIND_ACTIVITY) == false) {
			return null;
		}
		
		return varNode;
	}
	
	
	
	
	protected INode lookupRoleNode ( INode partnerLink, QName atName ) {
		
		if (partnerLink == null) {
			return null;
		}
		
		String roleName = partnerLink.getAttribute( atName );
		
		if (isUndefined(partnerLink) || roleName == null) {
			return null ;
		}			
				
		IProblem problem;
		
		INode role = getValue(partnerLink, "role." + roleName, null );

		if (isUndefined(role) ) {
			
			problem = createError();
			problem.setAttribute(IProblem.CONTEXT, atName);
			problem.fill( "BPELC_MISSING_ROLE",  //$NON-NLS-1$
					toString(mNode.nodeName()),
					ncName,  
					mNode.getAttribute(AT_PARTNER_LINK) ,
					atName);				
		}
		
		return role;

	}
	
	
	
	protected INode verifyPortTypeFromRole ( INode role, QName atRole, INode portType ) {
		 
		if (isUndefined(role)) {
			return null;
		}
		
		INode portTypeFromRole = mModelQuery.lookup( role ,
							IModelQueryLookups.LOOKUP_NODE_PORT_TYPE,
							role.getAttribute( AT_PORT_TYPE )) ;
			
		IProblem problem;
		
		if (portType != null) {
			
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7116
			// port types just have to be compatible, not necessarily the same java object
			if (mModelQuery.check ( IModelQueryLookups.TEST_COMPATIBLE_TYPE, portTypeFromRole , portType ) == false) {
				
				problem = createError();
				problem.fill( "BPELC_MISMATCH_ROLE_PORT_TYPE",  //$NON-NLS-1$
						toString(mNode.nodeName()),
						ncName,
						mNode.getAttribute(AT_PORT_TYPE),					
						fPartnerLinkNode.getAttribute(AT_NAME),
						atRole,					
						mModelQuery.lookup(portTypeFromRole,IModelQueryLookups.LOOKUP_TEXT_RESOURCE_PATH,null,null) );				
			}
		}
		
		return portTypeFromRole ;
	}
	
	
	
	
	protected INode findMessageType (INode portType, String operationName, QName messageKind , boolean bError ) {

		//	preconditions for this to run ...
		if ( isUndefined(portType) || operationName == null ) {
			return null ;
		}
		IProblem problem;
		
		// portType -> operation name="opName" -> input/output/fault
		List<INode> messages = lookupMessages (portType, operationName, messageKind);
				
		INode message = null;
		
		if (messages.size() == 0) {
			
			if (bError) {
				problem = createError();
				problem.fill("BPELC_PA__NO_MESSAGE",
					toString(mNode.nodeName()),
					portType,
					operationName,
					messageKind
				);
			}
			
			return null ;
		}
		
		message = messages.get(0);
		
		INode msgType = mModelQuery.lookup( message ,
				IModelQueryLookups.LOOKUP_NODE_MESSAGE_TYPE,
				message.getAttribute( WSDL_AT_MESSAGE ) );
		
		
		if ( isUndefined(msgType) ) {
						
			problem = createError();
			problem.fill("BPELC_PA__MSG_TYPE",
					toString(mNode.nodeName()),
					operationName,
					messageKind,
					message.getAttribute( WSDL_AT_MESSAGE )
			) ;
			
		}
		return msgType;	
	}
	
	
	protected List<INode> lookupMessages ( INode portType, String operationName , QName messageKind ) {
		
		return mSelector.selectNodes(
				portType, 
				WSDL_ND_OPERATION, 
				new NodeAttributeValueFilter( AT_NAME , operationName ),
				messageKind );		
	}	
}
