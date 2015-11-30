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

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Selector;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 5, 2006
 *
 */

@SuppressWarnings("nls")

public class CActivityValidator extends CValidator {
		
	protected String ncName ;

	protected String fSuppressJoinFailre;

	protected  List<INode> fCorrelationSets; 

	/** What are my parents */
	static public IFilter<INode> PARENTS = Filters.ACTIVITY_CONTAINER;

	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.rules.CValidator#checkChildren()
	 */
	@Override
	public void checkChildren () {
		super.checkChildren();
		
		checkChild ( ND_TARGETS, 0,1);
		checkChild ( ND_SOURCES, 0,1);
		
		
	}
	
	
	/**
	 * Start the validation of this node.
	 */
	@Override
	protected void start () {
		super.start();
		
		ncName = mNode.getAttribute( AT_NAME );	
		if (ncName == null) {
			ncName = "Unnamed";
		}
		fCorrelationSets = new ArrayList<INode>();
		setValue("correlation.sets", fCorrelationSets);
	}
	
	/**
	 * Rule to check the name of the variable. 
	 */
	
		
	@ARule(
		date = "10/05/2006",		
		desc = "Check the name of the activity which must be valid NCName",
		author = "michal.chmielewski@oracle.com",
		errors="BPELC__UNSET_ATTRIBUTE,General.NCName_Bad"
	)	
	
	public void rule_CheckName_1 () {					
		checkNCName(mNode, ncName, AT_NAME );
	}
	
	/**
	 * Check the supressJoinFailure attribute. It checks if it is set 
	 * and has a value of yes or no.
	 *
	 */
	
	@ARule(
		date = "10/05/2006",		
		desc = "Check the supressJoinFailure attribute. " + 
			   " It checks if it is set and has a value of yes or no.",			       
		author = "michal.chmielewski@oracle.com",
		errors="BPELC__UNSET_ATTRIBUTE,BPELC__INVALID_ATTRIBUTE_VALUE"
	)	

	
	public void rule_CheckSuppressJoinFailure_1 () {
		
		fSuppressJoinFailre = getAttribute(mNode, 
				AT_SUPPRESS_JOIN_FAILURE, 
				KIND_ACTIVITY, 
				Filters.BOOLEAN_FILTER, 
				false);
		
		
		if (isEmpty(fSuppressJoinFailre)) {
			
			// ask parent
			INode parent = fParentNode;
			while (parent != null && isEmpty(fSuppressJoinFailre) ) {				
				fSuppressJoinFailre = getValue(parent,AT_SUPPRESS_JOIN_FAILURE,null);
				parent = parent.parentNode();
			}						
		}
				
		setValue(AT_SUPPRESS_JOIN_FAILURE,fSuppressJoinFailre);		
	}
	
	
	
	
	/**
	 * Check the start activity, make sure it exists and is positioned correctly.
	 *
	 */
	@SuppressWarnings("boxing")
	public void checkStartActivityPositioning () {

		// examine the parent of pick. It can only be a 
		//   <sequence>, <scope>, or <flow>
		//
		// for it to be valid start activity
		//
		
		IProblem problem;
		
		INode context = mNode;
		INode parent = context.parentNode();
		boolean bSequenceChecked = false;
		
		while (parent != null) {
		
			QName pnn = parent.nodeName();
			
			if (ND_FLOW.equals( pnn )) {
				// OK
			} else if (ND_SCOPE.equals( pnn ) ) {
				// OK
			} else if (ND_PROCESS.equals( pnn ) ) {
				// OK
				break;
				
			} else if (ND_SEQUENCE.equals (pnn)) {
				if (bSequenceChecked == false) {					
					// check to see that I am the first element in the sequence
					List<INode> nodes = mSelector.selectNodes(parent, 
							Selector.ALL, 
							Filters.ACTIVITIES) ;
					int index = nodes.indexOf( context ) + 1;
					if (index != 1) {
						problem = createError();
						problem.fill("BPELC__START_ACTIVITY", 
								toString(mNode.nodeName()),
								index
						);									
					}
					
					bSequenceChecked = true;
				}
				
			} else {
				problem = createError();
				problem.fill("BPELC__START_ACTIVITY", 
						toString(mNode.nodeName()),
						-1
				);							
						
			}				
			
			context = parent;
			parent = context.parentNode();
		}
	}
	
	
	
	
}
