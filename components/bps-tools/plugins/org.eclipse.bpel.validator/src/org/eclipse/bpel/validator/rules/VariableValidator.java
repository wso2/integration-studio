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
import org.eclipse.bpel.validator.model.NodeNameFilter;


/**
 * Validates variable related rules.
 * <p>
 * When thinking 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */


@SuppressWarnings("nls")
public class VariableValidator extends CValidator {
	
	/** Parent nodes */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_VARIABLES );
		
	String ncName ;

	protected INode fMessageTypeNode;

	protected INode fElementNode;

	private INode fTypeNode;	
		
	protected INode fFromNode ;
	
	/**
	 * Start performing variable checks.
	 */	
	
	@Override
	protected void start () {
		super.start();		
		ncName = mNode.getAttribute( AT_NAME );
		
		fFromNode = mNode.getNode(ND_FROM);
	}
	
	
	/**
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren() {		
		super.checkChildren();
		checkChild(ND_FROM, 0, 1);
	}


	/**
	 * Rule to check the name of the variable. 
	 */
	@ARule(
		author = "michal.chmielewski@oracle.com",
		date = "9/14/2006",
		desc = "Checks that variable NCName further does not contain a period (.) in the name.",
		sa = 24,
		errors="BPELC__UNSET_ATTRIBUTE,General.NCName_Bad,BPELC_VARIABLE__NO_DOT"
	)	
	public void rule_CheckName_1 () {			
		
		// Must be a valid NCName ...
		if (checkNCName(mNode, ncName, AT_NAME ) == false) {
			return ;
		}
		
		IProblem problem ;
		// ... and not contain a .
		if (ncName.indexOf('.') >= 0) {
			problem = createError();
			problem.setAttribute(IProblem.CONTEXT, AT_NAME);
			problem.fill("BPELC_VARIABLE__NO_DOT", //$NON-NLS-1$
				ncName);
		}
	}
	
	
	
	/**
	 * Rule to check the type of the variable.
	 * 
	 * It can be either:
	 *   1) MessageType
	 *   2) Element
	 *   3) Type
	 *   
	 * Only one must be defined, more then one cannot be defined. 
	 *  
	 */
	@ARule(
		author = "michal.chmielewski@oracle.com",
		date = "9/14/2006",
		desc = "Variable type specification (either element, messaageType, or type).",
		sa = 25 ,
		errors="BPELC_VARIABLE__NO_TYPE"
	)
	
	public void rule_CheckType_2 () {
		
		int typeCount = 0;
		IProblem problem;
		
		// Check messageType 
		QName messageType = mNode.getAttributeAsQName(AT_MESSAGE_TYPE);		 
		if (messageType != null) {
			typeCount += 1;
			fMessageTypeNode = mModelQuery.lookup(mNode, 
										IModelQueryLookups.LOOKUP_NODE_MESSAGE_TYPE, 
					  					messageType);			
		}
		
		
		// Check element
		QName element = mNode.getAttributeAsQName(AT_ELEMENT);		
		if (element != null) {
			typeCount += 1;
			fElementNode = mModelQuery.lookup(mNode, 
							IModelQueryLookups.LOOKUP_NODE_XSD_ELEMENT,
							element );			
		}
		
		// Check Type (XMLType)
		QName type = mNode.getAttributeAsQName( AT_TYPE );			
		if (type != null) {
			typeCount += 1;
			fTypeNode = mModelQuery.lookup(mNode, 
										IModelQueryLookups.LOOKUP_NODE_XSD_TYPE,
										type );			
		}
		
		
		
		// Missing and too many types
		if (typeCount == 0) {
			problem = createError( );
			problem.setAttribute(IProblem.CONTEXT, AT_TYPE);
			problem.fill( "BPELC_VARIABLE__NO_TYPE", ncName); //$NON-NLS-1$
			
		} else if (typeCount > 1) {
			
			problem = createError( );
			problem.setAttribute(IProblem.CONTEXT, AT_TYPE);
			problem.fill( "BPELC_VARIABLE__NO_TYPE", ncName); //$NON-NLS-1$			
		}
	}
	

	/**
	 * Check message type node
	 */
	@ARule(
		sa = 10,
		desc = "Make sure that Message Type is visible from the import(s)",
		author = "michal.chmielewski@oracle.com",
		date = "01/25/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE"
	)
	
	public void rule_CheckMessageTypeNode_4 () {
		if (fMessageTypeNode == null) {
			return ;
		}
		
		checkAttributeNode (mNode, fMessageTypeNode, AT_MESSAGE_TYPE, KIND_NODE );
		setValue("type",fMessageTypeNode);
	}
	
	/**
	 * Check message type node
	 */
	@ARule(
		sa = 10,
		desc = "Make sure that Element is visible from the import(s)",
		author = "michal.chmielewski@oracle.com",
		date = "01/25/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE"
	)	
	public void rule_CheckElementNode_4 () {
		if (fElementNode == null) {
			return ;
		}
		checkAttributeNode (mNode, fElementNode, AT_ELEMENT , KIND_NODE) ;
		setValue("type",fElementNode);
	}

	/**
	 * Check message type node
	 */
	@ARule(
		sa = 10,
		desc = "Make sure that Type is visible from the import(s)",
		author = "michal.chmielewski@oracle.com",
		date = "01/25/2007",
		errors="BPELC__UNSET_ATTRIBUTE"
	)	
	public void rule_CheckTypeNode_4 () {
		if (fTypeNode == null) {
			return ;
		}
		checkAttributeNode (mNode, fTypeNode, AT_TYPE, KIND_NODE );
		setValue("type",fTypeNode);
	}

	
	/**
 	 *
	 * Check if variable is hiding other variables (in higher scopes,process). 
	 */
	
	@ARule(
		sa = 0,
		desc = "Check to see if variable hides super variables",
		author = "michal.chmielewski@oracle.com",
		date = "01/25/2007",
		infos = "BPELC__LEXICAL_HIDE"
	)
	public void rule_CheckIfVariableHidesSuperVariables_15 () {
		
		// check if our variable hides other global variables ?
		INode refNode = mNode.parentNode();
		// refNode == "variables"
		// 
		if (refNode == null) {
			return ;
		}
		refNode = refNode.parentNode();
		// refNode == "scope" or "process"
		if (refNode == null) {
			return ;
		}
		refNode = refNode.parentNode();
		
		// if scope, then this is non-empty, if process then this is empty
		if (refNode == null) {
			return ;
		}
		
		INode node = mModelQuery.lookup(refNode, 
				IModelQueryLookups.LOOKUP_NODE_VARIABLE, 
				ncName);
		
		// Does not exist or is the same thing.
		if (node == null || node.isResolved() == false 
				|| 
				mModelQuery.check(IModelQueryLookups.TEST_EQUAL,node, mNode) ) {
			return ;
		}
		
		IProblem problem = createInfo();
		problem.setAttribute(IProblem.CONTEXT, AT_NAME);
		problem.fill( "BPELC__LEXICAL_HIDE", 
				ND_VARIABLE, 
				ncName ); 
	}
	

	/**
	 * Register the types to check for double or conflicting definitions ...
	 */
	
	@ARule(
		sa = 14,
		desc = "Mark the types/elements/messages used to be checked for duplicates",
		author = "michal.chmielewski@oracle.com",
		date = "02/25/2007",
		errors="BPELC_XSD__CONFLICTING_DEFINITION"
	)	
	public void rule_RegisterTypesToCheck_50 () {
		
		registerTypeToCheck ( fElementNode );
		registerTypeToCheck ( fTypeNode );
		registerTypeToCheck ( fMessageTypeNode );
	}
			
		
	
	/**
	 * Check that if we are a scope that belongs to forEach, we don't declare 
	 * a variable that matches the counter name.
	 *
	 */
	@ARule(
		sa = 76,
		desc = "For <forEach>  the enclosed scope MUST NOT " 
			+ " declare a variable with the same name as specified in the counterName " 
			+ " attribute of <forEach>.",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC_VARIABLE__COUNTER"
	)
		
	public void rule_CheckForEachCounter_30 () {
		// scope/variables/variable
		INode scope = fParentNode.parentNode();
		
		if (ND_SCOPE.equals(scope.nodeName()) == false) {
			return ;
		}
		// forEach/scope/variables/variable
		INode forEachNode = scope.parentNode();		
		if (ND_FOR_EACH.equals(forEachNode.nodeName()) == false) {
			return;
		}
		
		// counter name from forEach.
		String counterName = forEachNode.getAttribute(AT_COUNTER_NAME);
		if (isEmptyOrWhitespace(counterName)) {
			return ;
		}
		
		
		IProblem problem;
		
		if (counterName.equals(ncName)) {
			problem = createError();
			problem.fill("BPELC_VARIABLE__COUNTER",
				toString(mNode.nodeName()),
				ncName,
				forEachNode.nodeName(),
				forEachNode.getAttribute(AT_NAME));
			
		}
		
		
	}
	
	
	/**
	 * Check compatible implicit copy on this from initializer. 
	 * This rule is run at the end (pass2)
	 */
	
	@ARule(
		sa = 43,
		desc = "From and to spec must have compatible types",
		author = "michal.chmielewski@oracle.com",
		date = "02/16/2007",
		tag = "pass2",
		errors="BPELC_COPY__INCOMPATIBLE",
		warnings="BPELC_COPY__INCOMPATIBLE_SIMPLE",
		infos = "BPELC_COPY__NOT_CHECKED"
	)	
	public void rule_CheckCompatibleCopy_40 () {
			
		if (isUndefined(fFromNode)) {
			return ;
		}
		
		compatibleCopyCheck(fFromNode,mNode);
	}
		
	/** 
	 * End of public rule methods.
	 * 
	 * Other methods are support methods for this class to perform its
	 * validation function.
	 * 
	 */

}
