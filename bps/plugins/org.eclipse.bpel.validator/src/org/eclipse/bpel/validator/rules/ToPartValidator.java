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

public class ToPartValidator extends CValidator {

	/** Nodes which can be our parents */
	static public IFilter<INode> PARENTS = new NodeNameFilter( ND_TO_PARTS );
	
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
	

	/**
	 * @see org.eclipse.bpel.validator.rules.CValidator#start()
	 */
	
	@Override
	protected void start () {
		
		super.start();
		
		/** This is presumably invoke or reply */
		fActivityNode = fParentNode.parentNode();
				
	}
	
	/**
	 * Check the toVariable on the toPart 
	 */
	
	@ARule(
			desc = "Check the toVariable on the toPart.",
			author = "michal.chmielewski@oracle.com",
			date = "03/15/2007",
			errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
		)
	public void rule_CheckVariable_1 () {
		fPartName = getAttribute(mNode, AT_PART, KIND_NODE, Filters.NC_NAME, true);
		fVariableName = getAttribute(mNode, AT_FROM_VARIABLE, KIND_NODE, Filters.NC_NAME, true);
	}
	
	
	/**
	 * Check the part= toVariable= is a duplicate entry.
	 */
	
	@ARule(
		sa = 0,
		desc = "Check to see if part='' fromVariable='' is a duplicate entry.",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC_PART__DUPLICATE"
	)
	
	public void rule_CheckDuplicatePartFromVariable_1 () {
		
		if (fPartName == null) {
			return ;
		}
		
		String key = "part." + fPartName ;
		
		// Parent node is toParts		
		
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
		desc = "Checks to see if the fromVariable is defined.",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE",
		warnings="BPELC_REF_NODE_PROBLEMS"
	)
	
	public void rule_CheckVariableDefined_4 () {
		
		if (fVariableName == null) {
			return ;
		}
		
		fVariableNode = mModelQuery.lookup(mNode, 
				IModelQueryLookups.LOOKUP_NODE_VARIABLE, fVariableName);
		
		if (checkAttributeNode (mNode, fVariableNode, AT_FROM_VARIABLE, KIND_NODE ) == false) {
			// variable is not accessible (either undefined or whatever).
			fVariableNode = null;
		}
		
		if (checkValidator(mNode,fVariableNode,AT_FROM_VARIABLE,KIND_NODE) == false) {
			fVariableNode = null;
			return ;
		}				
	}
	
	
	/**
	 * Check the message part 
	 */
	@ARule(
		sa = 54,
		desc = "Check to see if the fromVariable type matches the part name specified",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC__PA_NO_PART"
	)
		
	public void rule_CheckMessageParts_5 () {
		
		if (fPartName == null) {
			return ;
		}
				
		
		// Grab the input message. This is computed by the activity validator.
		INode inputMessageType = getValue(fActivityNode,"input.message.type",null);
		if (isUndefined(inputMessageType)) {
			return;
		}
		
		IProblem problem;
		
		fPartNode = mSelector.selectNode(inputMessageType,WSDL_ND_PART,
								new NodeAttributeValueFilter(AT_NAME,fPartName) );
		
		if (isUndefined(fPartNode)) {
			
			// no such part
			problem = createError();	
			problem.fill("BPELC__PA_NO_PART",
					toString(mNode.nodeName()),
					fPartName,
					inputMessageType					
			);
			
			return ;
		}
	}
	
	
	/**
	 * 
	 */
	
	@ARule(
		sa = 0,
		desc = "Check toPart and variable type compatibility",
		author = "michal.chmielewski@oracle.com",
		date = "03/10/2007",
		errors="BPELC_XSD__INCOMPATIBLE_TYPE"
	)
	
	public void rule_CheckToPartTypeCompatibility_20 () {
		
		if (isUndefined(fPartNode) || isUndefined(fVariableNode)) {
			return ;
		}
					
		// Grab the type of the variable, this is already computed by the 
		// variable validator:
	
		INode varTypeNode = getValue(fVariableNode,"type",null);
		if (isUndefined(varTypeNode)) {
			// something screwy with the variable.
			return ;
		}
		
		
		INode partTypeNode = mModelQuery.lookup(fPartNode, 
				IModelQueryLookups.LOOKUP_NODE_TYPE_OF_PART, fPartName);
		
		if (isUndefined(partTypeNode)) {
			// no such part
			return ;
		}
		
		IProblem problem;
		
			
		if (mModelQuery.check(IModelQueryLookups.TEST_COMPATIBLE_TYPE, partTypeNode, varTypeNode) == false) {
			problem = createError();
			problem.fill("BPELC_XSD__INCOMPATIBLE_TYPE",
				toString(mNode.nodeName()),
				"text.term.variable",
				fVariableName,
				varTypeNode,
				"text.term.messagePart",
				fPartName,
				partTypeNode
			);
		}				
		
	}
}
