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

import org.eclipse.bpel.validator.model.Filter;
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.ValueFilter;



/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jan 18, 2007
 *
 */

@SuppressWarnings({"nls","boxing"})
public class CatchValidator extends CatchAllValidator {
	
	protected String fFaultName;
	
	protected QName fFaultQName;
	
	protected QName fFaultMessageType;
	
	protected QName fFaultElement;

	protected String fFaultVariableName;

	protected INode fFaultVariableType;
	

	/**
	 * @see org.eclipse.bpel.validator.model.Validator#start()
	 */
	@Override
	protected void start() {
		
		super.start();			
		
		fFaultName = mNode.getAttribute(AT_FAULT_NAME);
		fFaultVariableName = mNode.getAttribute(AT_FAULT_VARIABLE);
	}
	
	
	/**
	 * Check to see if the catch handles standard fault.
	 *
	 */
	
	@ARule(
		date = "01/10/2007",
		author = "michal.chmielewski@oracle.com",
		desc = "When exitOnStandardFault=yes, standard fault handlers cannot be present.",
		sa = 3 ,
		errors="BPELC_CATCH__STANDARD_FAULT"
	)
	public void rule_CheckExitStandardFaults_1 () {
		
		if ( fFaultName == null ) {
			return ;
		}
		
				
		fFaultQName = mModelQuery.createQName(mNode, fFaultName);

		if (Filters.STANDARD_FAULTS.select( fFaultQName ) == false) {
			return ;  
		}
		
		String value = getExitOnStandardFault ( mNode );
		
		if (YES.equals( value ) == false) {
			return ;
		}
		
		// otherwise, we have a standard fault when exit standard faults is set to yes.
		IProblem problem = createError();
		problem.fill ("BPELC_CATCH__STANDARD_FAULT",
					toString(mNode.nodeName()),
					fFaultQName );				
	}
	
	
	
	static IFilter<QName> TYPE_DEFS = new ValueFilter<QName> ( 
			Filter.QNAME_COMPARATOR,
			AT_FAULT_MESSAGE_TYPE, AT_FAULT_ELEMENT 
	);
	
	/**
	 * Check fault variable.
	 *
	 */
	
	
	@ARule(
		sa = 81,
		desc = "Fault variable must have message type or element set",
		author = "michal.chmielewski@oracle.com",
		date = "01/25/2007",
		errors="BPELC__AT_LEAST_ONE,BPELC__AT_MOST_ONE,BPELC__UNSET_ATTRIBUTE,BPELC__UNRESOLVED_ATTRIBUTE"
	)
		
	public void rule_CheckFaultVariable_4 () {

		IProblem problem;

		// messageType or element must be used
		String msgType = mNode.getAttribute(AT_FAULT_MESSAGE_TYPE);
		String elmDecl = mNode.getAttribute(AT_FAULT_ELEMENT);

		boolean bMsgTypeEmpty = isEmptyOrWhitespace(msgType);
		boolean bElmDeclEmpty = isEmptyOrWhitespace(elmDecl);
		

		if (isEmpty(fFaultVariableName) == false) {
									
			if ( bElmDeclEmpty && bMsgTypeEmpty ) {
				
				problem = createError();
				problem.fill("BPELC__AT_LEAST_ONE",
						toString(mNode.nodeName()),
						KIND_NODE,
						TYPE_DEFS,
						KIND_ATTRIBUTE
				);	
				// quick exit, nothing to do
				return ;
			} 


			if ( !bElmDeclEmpty && !bMsgTypeEmpty) {
				
				problem = createError();
				problem.fill("BPELC__AT_MOST_ONE",
						toString(mNode.nodeName()),
						KIND_NODE,
						TYPE_DEFS,
						KIND_ATTRIBUTE
				);	
			} 

			
			
			if (!bElmDeclEmpty) {
				// element is specified
				fFaultVariableType = mModelQuery.lookup(mNode, 
						IModelQueryLookups.LOOKUP_NODE_XSD_ELEMENT,elmDecl);
			
				checkAttributeNode(mNode, fFaultVariableType, AT_FAULT_ELEMENT, KIND_NODE);
				
			} 

			if (!bMsgTypeEmpty) {
				// message type is specified
				fFaultVariableType = mModelQuery.lookup(mNode, 
						IModelQueryLookups.LOOKUP_NODE_MESSAGE_TYPE,msgType);
				
				checkAttributeNode(mNode, fFaultVariableType, AT_FAULT_MESSAGE_TYPE, KIND_NODE);
			}					
		
			
		} else {
			
			// the message type or element declaration must not be present
			if (!bElmDeclEmpty || !bMsgTypeEmpty) {
				problem = createError();
				problem.fill("BPELC__SPECIFY_NONE",
						toString(mNode.nodeName()),
						KIND_NODE,
						TYPE_DEFS,
						KIND_ATTRIBUTE);
			}
			
		}
		
		
		setValue("fault.variable", fFaultVariableName);
		// fix Bug 323936
		setValue("type",fFaultVariableType);

	}
	
	/**
	 * Check if the catch construct already exists.
	 *
	 */
	
	@ARule(
		sa = 93,
		desc = "Check to see if a duplicate catch has been specified",
		author = "michal.chmielewski@oracle.com",
		date = "01/20/2007",
		errors="BPELC_CATCH__EXIST"
	)
	public void rule_CheckDuplicateCatch_10 () {
						
		String key = "set.catch.";
		if (fFaultQName != null) {
			key += AT_FAULT_NAME + "=" + fFaultQName + ";";
		}
		
		if (fFaultElement != null) {
			key += AT_FAULT_MESSAGE_TYPE + "=" + fFaultElement + ";" ;
		} else if (fFaultMessageType != null) {
			key += AT_FAULT_ELEMENT + "=" + fFaultElement + ";" ;
		}
				
		
		if (containsValueKey(fParentNode,key)) {
			
			IProblem problem = createError();
			problem.fill("BPELC_CATCH__EXIST", 
					toString(mNode.nodeName()),
					fFaultQName,
					(fFaultMessageType == null ? fFaultElement : fFaultMessageType)					
			);
			
			return ;
		}
		
		setValue(fParentNode, key, Boolean.TRUE);		
	}
 
	
}
