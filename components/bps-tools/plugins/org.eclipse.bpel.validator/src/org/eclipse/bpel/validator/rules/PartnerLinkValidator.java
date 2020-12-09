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
 * JDK dependency here 
 */

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Dependency on the BPEL validation model only in here ...
 */

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.NodeNameFilter;
import org.eclipse.bpel.validator.model.Selector;

/**
 * PartnerLink validation rules. 
 * <p>
 * Note, there is only dependency on the validator API. Actual BPEL model
 * is provided behind the INode facade.
 * <p>
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 19, 2006
 */

@SuppressWarnings("nls")

public class PartnerLinkValidator extends CValidator {

	/**
	 * What are my parent nodes ?
	 */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_PARTNER_LINKS );
	
	INode fPartnerLinkType;
	INode fPartnerLink;
	
	String ncName ;
	String fMyRole;
	String fPartnerRole;

	protected String fInitializePartnerRole;

	
	List<INode> fRoles = Collections.emptyList();
	
	
	/**
	 * Start validation of the partner link node ...
	 */
	
	@Override
	protected void start () {
		
		super.start();	
		
		fPartnerLink = mNode;
		fPartnerLinkType = mModelQuery.lookup (mNode,
							IModelQueryLookups.LOOKUP_NODE_PARTNER_LINK_TYPE,
							mNode.getAttributeAsQName( AT_PARTNER_LINK_TYPE ) ) ;
		
		if (fPartnerLinkType != null) {
			fRoles = fPartnerLinkType.children();
		}
		
		ncName = mNode.getAttribute( AT_NAME );
	}

	
	/**
	 * Check the name attribute. 
	 * 
	 */
	
	@ARule(
			sa = 0,
			desc = "Check the NCName of the partner link.",
			author = "michal.chmielewski@oracle.com",
			date = "02/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,General.NCName_Bad"
		)
	public void rule_CheckName_1 () {
				
		checkNCName(mNode, ncName, AT_NAME );		
	}
	
	
	/**
	 * Check if partner link type is defined.
	 */
	
	@ARule(
			author = "michal.chmielewski@oracle.com",
			desc = "Checks partner link type",
			date = "01/15/2007",			
			sa = 32 ,
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE"
		)
	public void rule_CheckPartnerLinkType_2 () {
		
		if (checkAttributeNode(mNode, fPartnerLinkType, AT_PARTNER_LINK_TYPE, KIND_NODE) == false) {
			fPartnerLinkType = null;
		}		
	}
	
		
	/**
	 * 
	 * Checks to see if myRole or partnerRole is set.
	 * One of them must be set. This is per SA00016 of the spec.
	 * 
	 */
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc="myRole or partnerRole (or both) must be set",
		date = "09/19/2006",
		sa=16 ,
		errors="BPELC_PARTNER_LINK__NO_ROLES_SET"		
	)	
	public void rule_CheckForUndefinedPartnerLinkRoles_4 () {
		
		fMyRole = fPartnerLink.getAttribute(AT_MY_ROLE);
		fPartnerRole = fPartnerLink.getAttribute(AT_PARTNER_ROLE);
		
		IProblem problem ;
		
		if (fMyRole == null && fPartnerRole == null) {
			
			problem = createError ( );
			problem.fill( "BPELC_PARTNER_LINK__NO_ROLES_SET", //$NON-NLS-1$
					fPartnerLink.nodeName(),
					ncName,
					AT_MY_ROLE,
					AT_PARTNER_ROLE
			);
		}		
	}
	
	/**
	 * Check if initializePartnerRole is set on the partnerLink
	 * if partnerRole is set (or not).
	 * 
	 * 
	 */
	@ARule(
		author = "michal.chmielewski@oracle.com",
		desc = "Check if initializePartnerRole is set on the partnerLink" +
	           " if partnerRole is set (or not).",
		date = "09/19/2006",
		sa = 17,
		errors="BPELC_PARTNER_LINK__INIT_PARTNER_ROLE,BPELC__UNRESOLVED_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"		
	)
	
	public void rule_CheckInitializePartnerRole_8 () {
		
		fInitializePartnerRole = getAttribute(fPartnerLink, 
				AT_INITIALIZE_PARTNER_ROLE, 
				KIND_ACTIVITY, 
				Filters.BOOLEAN_FILTER, 
				false);
		
		
		if (fPartnerRole != null) {
			
			if (isEmpty(fPartnerRole)) {
				fInitializePartnerRole = NO;
			}
			
			return ;
		}
		
		
		IProblem problem;
		
		if (fInitializePartnerRole != null) {
		
			problem = createError();
			problem.fill("BPELC_PARTNER_LINK__INIT_PARTNER_ROLE", //$NON-NLS-1$
					toString(mNode.nodeName()),
					AT_INITIALIZE_PARTNER_ROLE,
					AT_PARTNER_ROLE);
		}
		
		
		
	}
	
	
	/**
	 * Check the partner link roles. Once a partner link type is 
	 * deemed defined, then the roles are checked to see if they are 
	 * defined.
	 */
	@ARule(
			desc = "Check if partner link role exists",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC_PARTNER_LINK_TYPE__NO_SUCH_ROLE"
		)

	
	public void rule_CheckPartnerLinkRoles_10 () {
				
		if (fPartnerLinkType == null) {
			return ;
		}
		
		if (fMyRole != null) {
			checkRole ( fMyRole );
		}
		
		if (fPartnerRole != null) {
			checkRole (fPartnerRole);
		}
		
	}
	

	/**
	 * 
	 * Checks to make sure there are at most 2 or at least 1
	 * partner links defined on this partner link type. 
	 * 
	 */
	
	public void rule_CheckRolesOnPartnerLinkType_17 () {
			
		if (fPartnerLinkType == null) {
			return ;
		}
	
		IProblem problem;
		
		if (fRoles.size() == 0) {
			
			problem = createWarning(mNode);
			problem.fill("BPELC_PARTNER_LINK_TYPE__NO_ROLES_DEFINED",  //$NON-NLS-1$
					AT_PARTNER_LINK_TYPE,AT_PARTNER_LINK );					
		}
				
		if (fRoles.size() > 2) {
			problem = createWarning(mNode);
			problem.fill("BPELC_PARTNER_LINK_TYPE__TWO_MANY_ROLES_DEFINED", //$NON-NLS-1$
					AT_PARTNER_LINK_TYPE,AT_PARTNER_LINK);
		}			
	}
	
	
	/**
	 * Check the port types in partner link types
	 * 
	 */
		
	@ARule(
			author = "michal.chmielewski@oracle.com",
			desc = "Check if port type is set on the partnerLink",
			date = "09/19/2006",
			sa = 17,
			errors="BPELC_PLT__NO_PORT_TYPE"		
		)
	public void rule_CheckPortTypes_18 () {
		
		if (fPartnerLinkType == null) {
			return ;
		}
		
		IProblem problem;						
		
		for(INode role : fRoles) {
			
			INode portType = mModelQuery.lookup (role, 
								IModelQueryLookups.LOOKUP_NODE_PORT_TYPE,
								role.getAttribute( AT_PORT_TYPE )) ;
			
			if ( isUndefined(portType) ) {

				// problem = createError( mNode );
				problem = createError( );
				problem.fill("BPELC_PLT__NO_PORT_TYPE",
						role.getAttribute(AT_NAME),
						role.getAttribute(AT_PORT_TYPE),
						AT_PARTNER_LINK_TYPE,
						AT_PORT_TYPE);
				
			} else {
				
				runRules("direct",portType);
				
			}
			
		}					 
	}
	
	
	
	/**
	 * Check the port type as per SA 1 of the BPEL spec.
	 * @param portType
	 */
	
	@ARule(
		sa = 1,
		desc = "Check solicit-response or notification port types",
		date = "02/16/2007",
		author = "michal.chmielewski@oracle.com",
		tag = "direct",
		errors="BPELC_PL__NOTIFICATION,BPELC_PL__SOLICIT_RESPONSE"
	)
		
	public void checkSolicitResponseAndNotification ( INode portType ) {
		
		IProblem problem;
		
		for(INode op: portType.getNodeList( WSDL_ND_OPERATION )) {
		
			List<INode> children = op.children();
			
			if (children.size() == 1) {
				
				if (WSDL_ND_OUTPUT.equals(children.get(0).nodeName())) {
					// notification
					problem = createError();
					problem.fill("BPELC_PL__NOTIFICATION",
							toString(mNode.nodeName()),
							mNode.getAttribute(AT_NAME),
							mNode.getAttributeAsQName(AT_PARTNER_LINK_TYPE),
							
							portType.getAttribute(AT_NAME),
							op.getAttribute(AT_NAME) );
				}
				
			} else if (children.size() > 1) {
				
				if (WSDL_ND_OUTPUT.equals(children.get(0).nodeName()) && 
					WSDL_ND_INPUT.equals(children.get(1).nodeName())) {
					
					// solicit-response
					problem = createError();
					problem.fill("BPELC_PL__SOLICIT_RESPONSE",
							toString(mNode.nodeName()),
							mNode.getAttribute(AT_NAME),
							mNode.getAttributeAsQName(AT_PARTNER_LINK_TYPE),
							
							portType.getAttribute(AT_NAME),
							op.getAttribute(AT_NAME) );
				}
			}
			
			
		}
	}
	
	
	/**
	 * Check the port type as per SA 1 of the BPEL spec.
	 * @param portType
	 */
	
	
	@ARule(
		sa = 2,
		desc = "Check for overloaded operation names in port types",
		date = "02/16/2007",
		author = "michal.chmielewski@oracle.com",
		tag = "direct",
		errors="BPELC_PL__OVERLOADED"
	)
		
	public void checkOverloadedOperationNames ( INode portType ) {
		
		Set<String> names = new HashSet<String>();
		IProblem problem;
		
		for(INode op : portType.getNodeList( WSDL_ND_OPERATION ) ) {
			String name = op.getAttribute(AT_NAME);
			if (name == null) {
				continue;
			}
			
			if (names.contains(name)) {
				problem = createError();
				problem.fill("BPELC_PL__OVERLOADED",
						toString(mNode.nodeName()),
						mNode.getAttribute(AT_NAME),
						mNode.getAttributeAsQName(AT_PARTNER_LINK_TYPE),
						portType.getAttribute(AT_NAME),
						name );
			}
			names.add(name);
		}
	}
	
	
	
	
	/** ------------------------- private methods --------------------------- */
	
	void checkRole (final String roleName) {

		// see if such a role exists.
		INode roleNode = mSelector.selectNode(
					fPartnerLinkType, 
				    Selector.ALL,  
				    new IFilter<INode> () {
						public boolean select(INode node) {
							return roleName.equals( node.getAttribute(AT_NAME) );
						}
					}
		);
		
		
		setValue("role." + roleName , roleNode);
				
		IProblem problem;
		
		if (roleNode == null) {
			//problem = createError ( fPartnerLinkType );			
			problem = createError ();			
			problem.fill("BPELC_PARTNER_LINK_TYPE__NO_SUCH_ROLE",  //$NON-NLS-1$
					fPartnerLinkType.nodeName(),roleName);
			
			return ;
		}
		
		
		INode portTypeFromRole = mModelQuery.lookup( roleNode ,
				IModelQueryLookups.LOOKUP_NODE_PORT_TYPE,
				roleNode.getAttribute( AT_PORT_TYPE )) ;
		
		setValue("role.portType." + roleName , portTypeFromRole);		
		
	}
		
}
