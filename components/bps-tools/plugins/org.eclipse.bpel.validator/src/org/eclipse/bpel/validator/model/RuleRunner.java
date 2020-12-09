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
import java.util.List;
import java.util.Stack;

import org.eclipse.bpel.validator.model.Rules.IndexFilter;
import org.eclipse.bpel.validator.model.Rules.Rule;

/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Aug 13, 2007
 *
 */
public class RuleRunner {
		
	/** The rules which a validator class exposes to be run. */
	Rules fRules;
			
	/** Currently executing rules ... */
	Stack<Rule> fRuleStack = new Stack<Rule>();	
	
	/** The currently executing rule */
	Rule fCurrentRule = null;
	
	/** Tells us which rules to skip */
	List<IFilter<Rule>> fRuleFilter = new ArrayList<IFilter<Rule>>(4) ;
	
	/** the validator on which this runner runs the rules */
	Validator fValidator = null;
	
	/**
	 * @param validator
	 */
	public RuleRunner (Validator validator) {
		fValidator = validator;
		fRules = Rules.getRules(validator.getClass());	
	}

	
	/**
	 * Run the rules in the order intended. This is simply an iteration over
	 * the rules discovered for the given class. 
	 * <p>
	 * Each of the validator classes can dynamically disabled a rule from being
	 * run. 
	 * <p>
     *
	 * @param tag the tag used on the rules.
	 * @param args to pass to the rules (if any).
	 */
		
	public void runRules ( String tag, Object ... args ) {	
		
		for (Rule rule: fRules.mRules) {
			
			// Filter away rules that make no sense in this context.					
			if (tag.equals(rule.getTag()) == false) {
				continue ;
			}
			if (isDisabled(rule)) {
				continue;
			}
						
			try {
				fCurrentRule = fRuleStack.push(rule);
				rule.invoke (fValidator, args);
			} catch (Throwable t) {				
				log (fValidator, rule, t);
			} finally {	
				fCurrentRule = fRuleStack.empty() ? null : fRuleStack.pop();				
			}
		}
	}

	
	
	/**
	 * Log any errors during rule execution.
	 * 
	 * @param context
	 * @param rule
	 * @param t
	 */
	
	void log ( Validator context, Rule rule , Throwable t) {
		
		context.internalProblem(rule, t);
		
		Rules.p("Problem executing rule {0}, stack trace shown below",rule.getFullName()); //$NON-NLS-1$
		t.printStackTrace( System.out );			
	}
	
	/**
	 * @param indexFilter
	 */
	public void addFilter(IndexFilter indexFilter) {
		fRuleFilter.add( indexFilter );		
	}

	/**
	 * 
	 */
	public void start() {
		fRuleFilter.clear();		
	}
	
	/**
	 * Called just before rules are run on this class.
	 * 
	 * @param nextRule the next rule which will be run
	 * @return true if the nextRule can be run, false otherwise.
	 */
		
	boolean isDisabled ( Rule nextRule ) {
						
		if (fRuleFilter.size() > 0) {
			for(IFilter<Rule> f: fRuleFilter) {
				if (f.select(nextRule)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * @return the currently executing rule.
	 */
	
	public Rule getExecutingRule ( ) {
		return fCurrentRule;
	}
}
