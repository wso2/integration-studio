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
package org.eclipse.bpel.validator.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 *
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Jan 2, 2007
 *
 */


@SuppressWarnings("nls")

public class Runner {

	/** The root node from where validation should be started */
	INode fRoot;
	
	/** The query interface to our model */
	IModelQuery fModelQuery;
	
	/** empty list of problems */
	IProblem[] fProblems = {};
	
	/** The list of validators to run */
	List<Validator> fValidators = new ArrayList<Validator>(256);

	/** A set which collects the SA checks that the validators makes */
	Set<ARule> fSAChecks = new HashSet<ARule>();
	
	
	
	/**
	 * Return a brand new shiny instance of a runner. The runner's purpose is to validate
	 * the nodes in the tree starting at node passed.
	 * 
	 * @param query the model query
	 * @param root the root node.
	 */
	
	public Runner ( IModelQuery query, INode root) {

		fRoot = root ;
		fModelQuery = query;
		
	}
	
	
	
	void init () {
		
		fValidators.clear();
		
		// Create a depth first iteration from the root node
		ArrayList<INode> iteratorList = new ArrayList<INode>(32);		
		
		// start at the root node
		iteratorList.add(fRoot);
		
		// 1. Generate the list of validators to call, in order
		while (iteratorList.size() > 0) {
			
			INode nextNode = iteratorList.remove(0);
			
			Validator validator = nextNode.nodeValidator();
			
			if (validator != null) {				
				
				validator.setModelQuery(fModelQuery);
				validator.setSAChecks(fSAChecks);				
				
				fValidators.add(validator);
			}
			
			// the facaded object will tell us what children to include in the walk
			List<INode> children = nextNode.children();			
			if (children.size() > 0) {
				iteratorList.addAll(0, children);
			}			
		}
	}
	
	
	/**
	 * Perform the validation run.
	 * 
	 * @return list of problems found.
	 */
	
	
	public IProblem[] run ( ) {

		fSAChecks.clear();
		
		if (fValidators.size() < 1) {
			init();
		}
				
		// Pass 1
		for(Validator validator : fValidators) {			
			validator.validate(Validator.PASS1);
		}
		
		ArrayList<IProblem> problems = new ArrayList<IProblem>( 64 );
		
		// Pass 2		
		for(Validator validator : fValidators) {
			validator.validate(Validator.PASS2);
			
			for(IProblem problem : validator.getProblems() ) {
				problems.add (problem);
			}
		}

		return problems.toArray( fProblems );
	}
	
	
	/**
	 * Return the list of SA checks performed on this validation run. 
	 * @return Return the list of SA checks performed on this validation run.
	 */
	
	public Set<ARule> getSAChecks () {
		return fSAChecks;
	}
}
