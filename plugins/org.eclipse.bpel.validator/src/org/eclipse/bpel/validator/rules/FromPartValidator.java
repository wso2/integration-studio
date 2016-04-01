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

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.NodeAttributeValueFilter;
import org.eclipse.bpel.validator.model.NodeNameFilter;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 7, 2006
 *
 */

@SuppressWarnings("nls")

public class FromPartValidator extends CValidator {

	/** Nodes which can be our parents */
	static public IFilter<INode> PARENTS = new NodeNameFilter(  ND_FROM_PARTS );
	
	/** Part name */
	protected String fPartName;

	/** Variable name */
	protected String fVariableName;

	/** Variable node */
	protected INode fVariableNode;

	/** Part node */
	private INode fPartNode;

	/** Which activity from part do I belong to */
	protected INode fActivityNode;

	/** Message type used by the PLT */
	private INode fMessageType;
	
	
	@Override
	protected void start () {
		
		super.start();
		
		fPartName = mNode.getAttribute(AT_PART);
		fVariableName = mNode.getAttribute(AT_TO_VARIABLE);
		
		fActivityNode = fParentNode.parentNode();
		
		
		QName activityName = fActivityNode.nodeName();
		
		if (ND_INVOKE.equals(activityName) ) {
			fMessageType = getValue(fActivityNode,"output.message.type",null);
		} else {
			fMessageType = getValue(fActivityNode,"input.message.type",null);
		}
		
	}
	
	/**
	 * Check the toVariable on the toPart 
	 */
	
	@ARule(
			desc = "Check toVariable on the toPart.",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
		)
	public void rule_CheckVariable_1 () {
		fPartName = getAttribute(mNode, AT_PART, KIND_NODE, Filters.NC_NAME, true);
		fVariableName = getAttribute(mNode, AT_TO_VARIABLE, KIND_ACTIVITY, Filters.NC_NAME, true);				
	}
	
	
	/**
	 * Check the part= toVariable= is a duplicate entry.
	 */
	
	@ARule(
		sa = 0,
		desc = "Check to see if part='' toVariable='' is a duplicate entry.",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC_PART__DUPLICATE"
	)
	
	public void rule_CheckDuplicatePartToVariable_1 () {
		if (fPartName == null) {
			return ;
		}
		
		String key = "part." + fPartName;
		
		// Instance data that fromParts holds
		
		if (containsValueKey(fParentNode,key)) {		
			IProblem problem = createError();
			problem.fill("BPELC_PART__DUPLICATE",
					toString(mNode.nodeName()),
					fPartName,
					fVariableName );
			return ;
		}
		setValue(fParentNode, key, Boolean.TRUE);
	}
	
	
	/**
	 * Checks to see if the variable is defined.
	 *
	 */
	@ARule(
		sa = 0,
		desc = "Checks to see if the toVariable is defined.",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE",
		warnings="BPELC_REF_NODE_PROBLEMS"
	)
	
	public void rule_CheckVariableDefined_4 () {
		
		if (ND_ON_EVENT.equals(fActivityNode.nodeName())) {
			return ;
		}
		if (fVariableName == null) {
			return ;
		}
		
		fVariableNode = mModelQuery.lookup(mNode, IModelQueryLookups.LOOKUP_NODE_VARIABLE, fVariableName);
		
		if (checkAttributeNode (mNode, fVariableNode, AT_TO_VARIABLE, KIND_NODE ) == false) {
			// variable is not accessible (either undefined or whatever).
			fVariableNode = null;
		}
		
		if (checkValidator(mNode,fVariableNode,AT_TO_VARIABLE,KIND_NODE) == false) {
			fVariableNode = null;
			return ;
		}				
	}
	
	
	
	
	/**
	 * Check the message part 
	 */
	@ARule(
		sa = 53,
		desc = "Check to see if the toVariable matches the type of the partName",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC_PART__DUPLICATE"
	)
		
	public void rule_CheckMessagePart_5 () {
		
		if (fPartName == null || isUndefined(fMessageType) ) {
			return ;
		}
		
		IProblem problem;
		
		fPartNode = mSelector.selectNode(fMessageType,WSDL_ND_PART,
								new NodeAttributeValueFilter(AT_NAME,fPartName) );
		
		if (isUndefined(fPartNode)) {
			
			// no such part
			problem = createError();	
			problem.fill("BPELC__PA_NO_PART",
					toString(mNode.nodeName()),
					fPartName,
					fMessageType.getAttribute(AT_NAME)					
			);
			
			return ;
		}
	}

	
	/**
	 * For <onEvent>, variables referenced by the variable attribute of
	 * <fromPart> elements or the variable attribute of an <onEvent> element are
	 * implicitly declared in the associated scope of the event handler.
	 * Variables of the same names MUST NOT be explicitly declared in the
	 * associated scope..
	 */
	
	@ARule(
		sa = 86,
		desc = "Variables defined in fromPart are implicitly declared in the associated scope",
		author = "michal.chmielewski@oracle.com",
		date = "03/15/2007"
	)
	public void rule_ImplicitOnEventVariable_10 () {
		
		if (ND_ON_EVENT.equals( fActivityNode.nodeName()) == false) {
			return ;
		}
		// the partNode defines the type
		
	}

	
	
}
