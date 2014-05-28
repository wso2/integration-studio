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

/**
 * Java JDK dependency 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;

/**
 * BPEL Validation model dependency 
 */

import org.eclipse.bpel.validator.model.Rules.Rule;

/**
 * The base Validator class.
 * 
 * A validator basically encapsulates an INode and runs some special methods (called rules)
 * to check the INode element. The output is a set of IProblem (s).
 * 
 * <p>
 * 
 * Rules are special methods that are discovered by reflection in two ways:
 * <ol>
 *  <li> They either have form "rule_<name>_<index>", or
 *  <li> The have the ARule annotation on them.
 * </ol>
 * 
 * <p>
 * 
 * Order of execution of the rules on a given validator is user defined - 
 * that's what the "index" means above. A rule may also be turned off by
 * the validator code during execution, so that logically exclusive conditions
 * can be simply "turned" off by rules.
 * <p>
 * If the ARule annotation is used then the order() method returns the order of execution.
 * Rules are simply discovered for every validator (only once), then sorted, and then run
 * during invocations.
 * 
 * <p>
 * 
 * Beyond that, there are just 2 other items that govern how rules are executed. 
 * <ol>
 *  <li> The rule tag (simple string), and
 *  <li> the arguments (if any) to the rule method.
 * </ol>
 * <p>
 * Rule tags are just strings which help organize the rules in some way and force their execution
 * at specific times. There are two tags reserved for the system, one is "pass1", the other is "pass2". 
 * User that write validators can invoke other rule sets by calling {@see runRules() }
 * and passing the appropriate tag and arguments. Return values from rule methods are never used.
 * 
 * <p>
 * Validators can be chained, so that you have the following scenario:
 * <pre>
 *   1 <-> 2 <-> 3 <-> 4 ... N
 * </pre>
 * For every INode there is the first validator that is always created. Other validators for the same 
 * INode can be created by simply calling the factory and then attaching the returned validator to the chain.
 * This allows for separation of concerns. For example, "query" nodes may validate in the BPEL and WSDL contexts, and
 * also validate in the Query language context (the same physical node).
 * 
 * <p>
 * 
 * Validators can keep certain state between passes, in the data hash map which is available to
 * the super-classes. This data is erased every time a "pass1" tag is triggered on the validator but
 * remains on for the duration of the object's lifetime.
 * 
 * <p>
 * This simple hash map mechanism is the way that various validators pass data to each other. This is primitive
 * but allows for very loose coupling between the code. When a validator asks for getData() the query goes
 * to its state data and if not found travels in the validator chain in the opposite direction to 
 * execution (always to previous).
 * 
 * <p> 
 * And finally a note about INode. INode represents the generic tree node that some source material
 * is sitting behind. This could be BPEL of course, but it could be any other thing as well. There are
 * adapters which adapt DOM nodes to INodes and EMF nodes to INodes (though there is fewer of those). 
 *
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 14, 2006
 *
 */

@SuppressWarnings({"unchecked","nls","boxing"})

public class Validator implements IConstants {
	
	Logger mLogger = Logger.getLogger( getClass().getName() );
	
	/** The runner which will run our rules */
	RuleRunner fRuleRunner;
	
	/** Problems produced by these rules */	
	private List<IProblem> fProblems = new ArrayList<IProblem>(4);
	
	/** An empty problem array */
	final static IProblem EMPTY_ARRAY[] = {};
	
	/** The node that we are validating */
	protected INode mNode ;
	
	/** Answer interesting things about the model */
	protected IModelQuery mModelQuery;
		
	/** a list of state information that any validator can keep */
	private Map<Object,Object> mData = new HashMap<Object,Object>(5);	
	
	/** The selector that can be used to query the INode facade */
	static protected Selector mSelector = new Selector();
		
	/** Pass 1 tag for rules */
	static public final String PASS1 = "pass1";
	
	/** PAss 2 tag for rules */
	static public final String PASS2 = "pass2";
	
	/** Support chains of validators for the same element */
	private Validator fNext = null;	
	private Validator fPrev = null;
	
	/** A set denoting the list of Static Analysis checks actually done */
	private Set<ARule> mSAChecks = null;

	
	
	
	/**
	 * Create an instance of the validator.
	 * Discover and setup the rules that we will be running. Primarily this 
	 * includes roaming through the methods and ordering them in the correct
	 * order.
	 */
	
	protected Validator () {
		fRuleRunner = new RuleRunner ( this );
	}
	

	/**
	 * @param node  
	 */
	
	public void setNode (INode node) {
		mNode = node;
	}

	/**
	 * Set the model query.
	 * @param query
	 */
	
	public void setModelQuery (IModelQuery query) {
		mModelQuery = query;
	}
	
	
	/**
	 * Use this set to determine coverage of the validators. 
	 * 
	 * @param ruleSet
	 */
	
	public void setSAChecks ( Set<ARule> ruleSet ) {
		mSAChecks = ruleSet;
	}
	
	
	/**
	 * Add a validator to the chain. It is always added to the end of the validator chain.
	 * The validators form a chain starting at the very first one like so
	 * <pre>
	 *   1 <-> 2 <-> 3 <-> 4 <-> 5 ... N
	 * </pre> 
	 * 
	 * When the main dispatcher code runs the validator for the given node, it starts running it at 1 
	 * and continues to N.
	 * <p>
	 * A validator can be attached in 2 ways
	 * <ul>
	 * <li>During the initial factory create calls where all validators for the node
	 * are created and the initial chain is built, and
	 * <li>During execution of a rule.
	 * </ul>
	 * For that reason it is important to realize that the validator mNode, mModelQuery
	 * references may not be yet set. 
	 * 
	 * @param next
	 */
	
	protected void attach ( Validator next ) {
		// no duplicates in chain
		if (this == next) {
			return ;
		}
		
		if (fNext == null) {
			fNext = next;
			
			next.fNext = null;
			next.fPrev = this;
					
		} else {
			fNext.attach ( next );
		}		
	}
			
	
	/**
	 * Validate the node using the rules provided in this validator.
	 * 
	 * @param tag the rules marked with the tag will be run
	 * model   
	 */
		
	final public void validate ( String tag ) {
				
		try {
			if (tag.equals(PASS1)) {
				start();
			}			
			fRuleRunner.runRules ( tag );			
			if (tag.equals(PASS2)) {				
				end();
			}
		} catch (Throwable t) {			
			mLogger.logp(Level.SEVERE, getClass().getName(), 
					"validate", 
					"Problem executing this validator.",
					t);
		}
		
		if (fNext != null) {
			fNext.validate(tag);
		}
		
	}
	
	
	/**
	 * Return the problems found as a result of validation
	 * in the last validation pass. 
	 * 
	 * @return the list of problems found
	 */
	
	@SuppressWarnings("unchecked")
	final public IProblem[] getProblems () {
		
		// Next is empty, just return what we have.
		if (fProblems.size() == 0) {
			return EMPTY_ARRAY;
		}
		return fProblems.toArray( EMPTY_ARRAY );
	}
	
	
	/**
	 * 
	 * Return true if this node validator has captured any problems regarding
	 * the node in question.
	 * 
	 * Chained validators are also consulted.
	 *  
	 * @return true if there are problems, false if there are no problems reported.
	 * 
	 */
	
	public boolean hasProblems () {
		return fProblems.isEmpty() == false;
	}
	
	
	/** 
	 * 
	 * @param node
	 * @return true if there are problems, false otherwise.
	 */
	
	public boolean hasProblems ( INode node ) {
		if (isDefined(node)) {
			Validator validator = node.nodeValidator();
			if (validator != null) {
				return validator.hasProblems();
			}
			return false;
		}
		
		return true;		
	}
		
	
	
	/**
	 * Disable all rules.
	 */
	
	protected void disableRules ( ) {
		disableRules(0,65536);
	}
	
	/**
	 * @param startIdx
	 * @param endIdx
	 */
	
	protected void disableRules (int startIdx, int endIdx ) {
		fRuleRunner.addFilter ( new Rules.IndexFilter ( startIdx,endIdx)  );		
	}
	
	
	/**
	 * Start the validation pass. This is run before all the rules are run.
	 * 
	 */
	
	protected void start () {				
		
		/** reset any disabled rules */		
		fRuleRunner.start();
		
		/**
		 * If we are the first validator in the chain
		 * Then we reset any problems list and clear any data that we 
		 * have.
		 */
		if (fPrev == null) {
			
			fProblems.clear();
			mData.clear();
			
		} else {
			
			/** 
			 * We point ourselves at the first validator in the chain. 
			 *  
			 */
			Validator first = getFirst();
			
			/** 
			 * These are in fact shared between the validators
			 * in the chain.
			 */
			
			fProblems = first.fProblems;
			mData = first.mData;
			mNode = first.mNode;
			mModelQuery = first.mModelQuery;
			mSAChecks = first.mSAChecks;
			
		}		
	}
	
	

	/**
	 *  The validation pass has ended for this object
	 */
	
	protected void end ( ) {
		
	}

	
	/**
	 * Runs the rules matching the tag and and the arguments given.
	 * 
	 * @param tag
	 * @param args
	 */
	
	protected void runRules ( String tag, Object ... args ) {
		fRuleRunner.runRules (tag,args);		
	}
	
	
	/**
	 * Add problems derived from contained validators into the
	 * problems we are reporting.
	 * 
	 * @param problems
	 */
		
	protected void addProblems ( IProblem[] problems ) {
		for(IProblem p : problems) {
			fProblems.add(p);
		}
	}
	
	
	@ARule(
			author = "michal.chmielewski@oracle.com",
			desc = "Internal error: no validator.",		
			date = "10/2/2006",
			sa = -1,
			warnings="BPELC__INTERNAL"
		)	
	protected void internalProblem ( Rule rule, Throwable t ) {
		
		IProblem problem = createWarning();		
		
		while ( t.getCause() != null ) {
			t = t.getCause();
		}
						
		problem.fill("BPELC__INTERNAL",
				toString(mNode.nodeName()),
				rule.getFullName(),
				rule.getIndex(),
				rule.getTag(),
				t);
		
		problem.setAttribute(IProblem.EXCEPTION, t);
	}		
	
	/**
	 * Mark that an SA check has been performed. 
	 * This is done automatically when create*() methods are called to
	 * create an error/warning/info  but you can call this method directly 
	 * too.
	 * 
	 * The is purely for testing reasons to make sure that cases 
	 * are correctly run. This method may be a noop if the validator does not
	 * have the property "internal.sa.checks" set to the right value.
	 * 
	 * @param arule the annotation to record as having been executed
	 */
	
	protected void markSAExecution (ARule arule) {
		if (mSAChecks == null) {
			return ;
		}
		if (arule == null) {
			arule = fRuleRunner.getExecutingRule().method.getAnnotation( ARule.class );
		}
		if (arule != null) {
			mSAChecks.add(arule);	
		}		
	}
	
	/**
	 * Adopt this problem as one of ours. In this case, we simply fill in the location information
	 * in the problem and add it to a list of problems that we keep.
	 * 
	 * @param problem
	 * @param node 
	 */
	
	public void adopt ( IProblem problem , INode node ) {

		// remember it 
		fProblems.add (problem);
		
		problem.setAttribute(IProblem.NODE, node );
		
		problem.setAttribute(IProblem.LINE_NUMBER, 
				mModelQuery.lookup(node, IModelQueryLookups.LOOKUP_NUMBER_LINE_NO,-1));
		
		problem.setAttribute(IProblem.COLUMN_NUMBER, 
				mModelQuery.lookup(node, IModelQueryLookups.LOOKUP_NUMBER_COLUMN_NO,-1));
		
		problem.setAttribute(IProblem.CHAR_END,    
				mModelQuery.lookup(node, IModelQueryLookups.LOOKUP_NUMBER_CHAR_END,-1));
		
		problem.setAttribute(IProblem.CHAR_START,  
				mModelQuery.lookup(node, IModelQueryLookups.LOOKUP_NUMBER_CHAR_START,-1));
				
		problem.setAttribute(IProblem.LOCATION,    
				mModelQuery.lookup(node, IModelQueryLookups.LOOKUP_TEXT_LOCATION,null,null));
		
		problem.setAttribute(IProblem.ADDRESS_MODEL,        
				mModelQuery.lookup(node, IModelQueryLookups.LOOKUP_TEXT_HREF,null,null));		
		
		problem.setAttribute(IProblem.ADDRESS_XPATH,        
				mModelQuery.lookup(node, IModelQueryLookups.LOOKUP_TEXT_HREF_XPATH,null,null));		
									
	}
	
	
	/**
	 * Create a problem based on the context node passed.
	 * 
	 * @param node the context node from which the problem will be 
	 * created.
	 * @return the IProblem marker for the node indicated. 
	 */
	

	protected IProblem createProblem ( INode node ) {
		
		IProblem problem = new Problem ( this );			
		adopt (problem, node);				
		
		Rule r = fRuleRunner.getExecutingRule();
		
		if (r != null) {
			
			problem.setAttribute(IProblem.RULE, r.getFullName() );
			
			ARule a = r.method.getAnnotation( ARule.class );
			
			if (a != null) {
				
				markSAExecution(a);
				
				problem.setAttribute( IProblem.SA_CODE, a.sa() );
				problem.setAttribute( IProblem.RULE_DESC, a.desc() );
			}
		}
		
		return problem;
	}
	
	
	/**
	 * Create an error problem on the current node
	 * 
	 * @return the problem created
	 */
	protected IProblem createError ( ) {
		return createError ( mNode );
	}
	
	
	/**
	 * Create an error problem. This does the same as this as
	 * createProblem plus it sets the problem object to severity error.
	 * 
	 * @param node
	 * @return the problem to be recorded.
	 */
	
	protected IProblem createError ( INode node ) {
		IProblem problem = createProblem (node);
		problem.setAttribute(IProblem.SEVERITY, IProblem.SEVERITY_ERROR);
		return problem;
	}

	
	/**
	 * Create a warning problem on the current node
	 * 
	 * @return the problem created
	 */
	
	protected IProblem createWarning( ) {
		return createWarning ( mNode );
	}
	
	/**
	 * Create a warning problem. This does the same as this as
	 * createProblem plus it sets the problem object to severity warning.
	 * 
	 * @param node
	 * @return the problem to be recorded.
	 */
	protected IProblem createWarning ( INode node ) {
		IProblem problem = createProblem (node);
		problem.setAttribute(IProblem.SEVERITY, IProblem.SEVERITY_WARNING);
		return problem;		
	}
	
	
	/**
	 * Create an information problem. This does the same as this as
	 * createProblem plus it sets the problem object to severity information.
	 * 
	 * @param node
	 * @return the problem to be recorded.
	 */
	
	protected IProblem createInfo ( INode node ) {
		IProblem problem = createProblem (node);
		problem.setAttribute(IProblem.SEVERITY, IProblem.SEVERITY_INFO);
		return problem;
		
	}
	
	
	
	/**
	 * Create an information problem on the current node
	 * 
	 * @return the problem created
	 */
	protected IProblem createInfo ( ) {
		return createInfo ( mNode );
	}	
	
	
	/**
	 * Is the node defined ? The check is to see if the node is empty and is resolved. 
	 * If so, then we return true. Otherwise we return false.
	 * 
	 * @param node
	 * @return true if defined, false otherwise
	 */
	
	protected boolean isDefined ( INode node ) {
		return node != null && node.isResolved();
	}
	
	/**
	 * Is the node undefined ? The check is to see if the node is empty or it is unresolved.
	 * If that's the case, we return true, otherwise we return false.
	 * 
	 * @param node
	 * @return true of undefined, false if defined.
	 */
	
	protected boolean isUndefined ( INode node ) {
		return node == null || node.isResolved() == false;
	}
	
	
	/**
	 * 
	 * @param <T>
	 * @param key
	 * @return the value
	 */
	
	public <T extends Object> T getValue ( Object key ) {
		return (T) getValue( key , null );
	}

	
	/**
	 * @param <T>
	 * @param key
	 * @param def
	 * @return the value
	 */
	
	public <T extends Object> T getValue ( Object key, T def ) {
		if (mData.containsKey(key)) {
			Object obj = mData.get(key);			
			if (obj instanceof IValue) {
				return (T) ((IValue)obj).get();
			}
			return (T) obj;				
		}		
		return def;
	}
	
	
	/**
	 * Return the data stored under the key keyName for the node node
	 * on its connected validator.
	 * 
	 * @param <T>  
	 * @param node the reference node
	 * @param key the key name
	 * @param def the default value
	 * @return the object stored or the default value passed
	 */
	
	public <T extends Object> T getValue ( INode node, Object key, T def ) {		
		Validator validator = validatorForNode(node);
		if (validator != null) {
			return validator.getValue(key,def);
		}
		return def;		
	}


	/**
	 * @param <T>  the type of the object
	 * @param keyName the key name to use
	 * @param value the value to set
	 * @return the previous value under the key
	 */
	
	public <T extends Object> T  setValue ( Object keyName, T value) {
		return (T) mData.put(keyName, value);
	}
	
	/**
	 * @param <T> the object 
	 * @param node the node on which this value ought to be set
	 * @param keyName the key name to use
	 * @param value the value to set
	 * @return the previous value held under that key or null
	 */
	
	public <T extends Object> T setValue ( INode node, Object keyName, T value) {
		
		Validator validator = validatorForNode(node);
		if (validator != null) {
			return validator.setValue(keyName,value);
		}
		return null;
	}
	
	
	/**
	 * Return true if the value key is present on us
	 * @param key
	 * @return true if present, false if not
	 */
	
	public boolean containsValueKey ( String key ) {
		return mData.containsKey(key);
	}
	
	/**
	 * Return true if the value key is contained on the node node.
	 * @param node the node
	 * @param key the key
	 * @return true if value key is present, false otherwise.
	 */
	
	public boolean containsValueKey ( INode node, String key ) {
		Validator validator = validatorForNode (node);
		return validator != null ? validator.containsValueKey(key) : false;
	}

	
	
	Validator validatorForNode ( INode node ) {
		if (isDefined(node)) {
			return node.nodeValidator();
		}
		return null;
	}
	
	
	/** 
	 * @return  Return the first validator in the chain.
	 */
	
	private Validator getFirst() {
		Validator first = this;
		while (first.fPrev != null) {
			first = first.fPrev;
		}
		return first;
	}
	
	protected String toString (QName qname) {
		
		/** No namespace, just return the local part, sans the {} */
		if (isEmptyOrWhitespace(qname.getNamespaceURI())) {
			return qname.getLocalPart();
		}
		
		/** Lookup the prefix in the model query for the context node */
		StringBuilder sb = new StringBuilder(32);
		String prefix = qname.getPrefix();
		
		if (isEmptyOrWhitespace(prefix)) {
			prefix = mModelQuery.lookup(mNode, IModelQueryLookups.LOOKUP_TEXT_NS2PREFIX, qname.getNamespaceURI(), null );					
		}
		/** No prefix, then exit with the default QName */
		if (prefix == null) {
			return qname.toString();
		}
		return sb.append(prefix).append(":").append(qname.getLocalPart()).toString();		
	}
	
	

	/**
     * Returns true if the string is either null or contains just whitespace.
	 * @param value 
	 * @return true if empty or whitespace, false otherwise.
     */
	
	
    static public boolean isEmptyOrWhitespace( String value )
    {
        if( value == null || value.length() == 0) {
            return true;
        } 
        
        for( int i = 0, j = value.length(); i < j; i++ )
        {
            if( ! Character.isWhitespace( value.charAt(i) ) ) {
                return false;
            }
        }
        return true;
    }
    
    
    
    /**
     * Test to see if a string is empty or has a value that is empty.
     * 
     * @param value
     * @return true if empty or null, false otherwise.
     */
    
    
    static public boolean isEmpty ( String value ) {
    	return value == null || value.length() == 0;
    }

    /** Test to see if a string is non empty 
     *
     * @param value the value to test
     * @return true if non empty, false if empty 
     */
    
    
    static public boolean isNonEmpty ( String value ) {
    	return value != null  && value.length () > 0;
    }

}
