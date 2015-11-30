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

import java.lang.reflect.Field;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.validator.model.ARule;
import org.eclipse.bpel.validator.model.Filters;
import org.eclipse.bpel.validator.model.IConstants;
import org.eclipse.bpel.validator.model.IFilter;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.IProblem;
import org.eclipse.bpel.validator.model.NodeNameFilter;
import org.eclipse.bpel.validator.model.RuleFactory;
import org.eclipse.bpel.validator.model.Validator;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Oct 12, 2006
 *
 */

@SuppressWarnings("nls")
public class CValidator extends Validator {
	
	/** The parent node */
	protected INode fParentNode;

	/** Children nodes */
	protected List<INode> fChildren;

	List<INode> fTypeToCheckList;
	
	
	@Override
	protected void start () {
		
		super.start();
		
		fParentNode = mNode.parentNode();
		
		// get the children, as we will be checking them
		fChildren = mNode.children() ;		
	}
	/**
	 * Check to make sure that parent node 
	 * of my node is within the set of nodes
	 * that is allowed.  
	 */
	
	@ARule(
		sa = 2001,
		desc = "Check to make sure that my parent node is within a set of allowed nodes",
		author = "michal.chmielewski@oracle.com",
		date = "02/15/2007",
		errors="BPELC__WRONG_PARENT"
	)
	public void rule_CheckParentNode_1 () {
		
		checkParentNode ();
	}
	
	
	/**
	 * Check the parent Node
	 */
	public void checkParentNode () {
		IFilter<INode> filter = parentNodeNames();
		
		if (fParentNode == null) {
			return ;
		}
		
		if (filter.select(fParentNode) ) {
			return ;
		}
		
		// Otherwise, we have a problem ...
		
		IProblem problem;
		problem = createError();
		problem.fill("BPELC__WRONG_PARENT", //$NON-NLS-1$
				toString(mNode.nodeName()),
				toString(fParentNode.nodeName()),
				filter.toString() );
		
		// Disable all the rules from being run, if we get here.
		disableRules();	
			
	}
	
	
	/**
	 * Check the children nodes, to make sure that they are present
	 */
	
	@ARule(
		sa = 2002,
		desc = "Check my children nodes (types and occurances)",
		author = "michal.chmielewski@oracle.com",
		date = "02/15/2007",
		errors="BPELC__MIN_IN_PARENT,BPELC__MAX_IN_PARENT"
	)
	public void rule_CheckChildrenNodes_0 () {
		checkChildren();
	}
	
	
	
	/**
	 * Check the children nodes
	 *
	 */
	
	public void checkChildren () {
		
	}

	
	/**
	 * Check to make sure that the node nodeName appears in the 
	 * children as specified by  he min/max parameters.
	 * @param node
	 * @param min
	 * @param max
	 * @return the number of occurrences of this child.
	 */	
	
	public int checkChild (QName node, int min, int max) {
		return checkChild ( new NodeNameFilter(node),min,max) ;
	}
	
	/**
	 * @param filter
	 * @param min
	 * @param max
	 * @return the # of occurrences of this child
	 */
	
	
	@SuppressWarnings("boxing")
	public int checkChild ( IFilter<INode> filter, int min, int max) {
		int count = 0;		
		for(INode n : fChildren) {
			if (filter.select(n)) {
				count += 1;
			}
		}
		
		IProblem problem;
		
		if (count < min) {
			problem = createError();
			problem.fill("BPELC__MIN_IN_PARENT",										
					toString(mNode.nodeName()),
					getNodeKind ( mNode ),
					IConstants.KIND_NODE,
					filter.toString(),					
					count,
					min
			);			
			
		} else if (count > max) {
			problem = createError();
			problem.fill("BPELC__MAX_IN_PARENT",
					toString(mNode.nodeName()),
					getNodeKind ( mNode ),
					IConstants.KIND_NODE,
					filter.toString(),
					count,
					max
			);
		}
		
		return count;		
	}
	
	
	
	/**
	 * Answer with my parent nodes. Subclasses must override this
	 * because most nodes can only be children of certain nodes.
	 * 
	 * @return an array of valid parent nodes.
	 */
		
	
	@SuppressWarnings("unchecked")
	public  IFilter<INode> parentNodeNames () {
		try {
			Field f = getClass().getField("PARENTS");
			return (IFilter) f.get(null);	
		} catch (java.lang.NoSuchFieldException nsfe) {
			// do nothing.
		} catch (Throwable t) {
			t.printStackTrace();
		}		
		return Filters.EMPTY ;
	}	
	
	
	/**
	 * Return the value of getExitOnStandardFault
	 * 
	 * @param node
	 * @return either yes or no, depending on the setting in the scopes.
	 */
	
	public String getExitOnStandardFault ( INode node ) {
		
		INode nn = mSelector.selectParent(node, new IFilter<INode>() {

			public boolean select(INode n) {
				QName name = n.nodeName();
				if (name.equals(ND_SCOPE) == false && name.equals(ND_PROCESS) == false) {
					return false;
				}
				String value = n.getAttribute(AT_EXIT_ON_STANDARD_FAULT);
				if (isEmpty(value) == false) {
					return true;					
				}
				return false;
			}		
		});
		
		if (nn != null) {
			return nn.getAttribute(AT_EXIT_ON_STANDARD_FAULT);			
		}
		return NO;
	}
	
	
	/**
	 * Register a type to check.
	 * @param node
	 */
	
	public void registerTypeToCheck (INode node) {
		
		if (isUndefined(node)) {
			return;
		}
		
		if ( fTypeToCheckList == null) {
			
			INode process = mNode.rootNode();
			fTypeToCheckList = getValue(process, "types.to.check", null);
		}
		
		if (fTypeToCheckList == null) {
			return ;
		}
		
		if ( fTypeToCheckList.contains ( node ) == false ) {
			fTypeToCheckList.add ( node );
		}
		
	}

	

	/**
	 * Check if the copy is compatible 
	 * 
	 * @param fromNode
	 * @param toNode
	 */
	public void compatibleCopyCheck ( INode fromNode, INode toNode ) {

		INode fromTypeNode = getValue(fromNode,"type",null);
		INode toTypeNode = getValue(toNode,"type",null);
		
		if (hasProblems(fromNode) || hasProblems(toNode)) { 
			return ;
		}
		
		if (fromTypeNode == null && toTypeNode == null) {
			return ;
		}
				
		/** Compatible assign */
		IProblem problem ;
		if (fromTypeNode == null || toTypeNode == null) {
			
			problem = createInfo();
			problem.fill("BPELC_COPY__NOT_CHECKED",
					toString(mNode.nodeName()),
					"text.term.from",					
					fromTypeNode == null ? "text.term.unspecified" : fromTypeNode ,
					"text.term.to",
					toTypeNode == null ? "text.term.unspecified" : toTypeNode ); 
			return ;
		}
		// fix Bug 323945
		String fHeaderName = getValue(fromNode, "header", null);
		//if there is a header defined in from, it should ODE ws-bpel extension, so ignore
		//the compatibleCopyCheck
		if(!isEmpty(fHeaderName)){
			return ;
		}
		
		// source -> destination		
		boolean bCompatible = mModelQuery.check(IModelQueryLookups.TEST_COMPATIBLE_TYPE, fromTypeNode, toTypeNode);
		
		// if these are simple types, warn if incompatibility found as engines may perform implicit conversion
		// much like XPath does.
		
		if (mModelQuery.check(IModelQueryLookups.TEST_IS_SIMPLE_TYPE,fromTypeNode,null) &&
			mModelQuery.check(IModelQueryLookups.TEST_IS_SIMPLE_TYPE,toTypeNode,null)) {
			
			if (bCompatible == false) {
				
				problem = createWarning();
				problem.fill("BPELC_COPY__INCOMPATIBLE_SIMPLE",
						toString(mNode.nodeName()),
						"text.term.from",					
						fromTypeNode,
						"text.term.to",
						toTypeNode
				);
				
			}

			// Temporary workaround for 3369 - disable check if from/to has a part attr
			String fromPart = fromNode.getAttribute(AT_PART);
			String toPart = toNode.getAttribute(AT_PART);
			if (fromPart != null || toPart != null){
				return;
			}

			
		} else if (bCompatible == false) {
			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=330813
			// https://jira.jboss.org/browse/JBIDE-7351
			// added diagnostic message for easier location of the incompatibility
			problem = createError();
			problem.fill("BPELC_COPY__INCOMPATIBLE",
					toString(mNode.nodeName()),
					"text.term.from",					
					fromTypeNode,
					"text.term.to",
					toTypeNode,
					mModelQuery.getDiagnostic(0)
			);
			
		}		
		
	}
	

	/**
	 * A generic check against attributes
	 * 
	 * @param node the context node.
	 * @param name name of the attribute
	 * @param kind 1 for activity node, 0 for generic node
	 * @param filter the filter that checks the allowed values 
	 * @param bMandatory true for mandatory, false otherwise. 
	 * @return the attribute value or null if the value does not exist or is not allowed.
	 */
	
	@SuppressWarnings("boxing")
	public String  getAttribute ( INode node, QName name, int kind, IFilter<String> filter, boolean bMandatory  ) {
		
		IProblem problem;
		
		String value = node.getAttribute(name);
		
		if (bMandatory) {
			if (isEmpty(value)) {
				problem = createError(node);
				problem.setAttribute(IProblem.CONTEXT, name.getLocalPart() );
				problem.fill("BPELC__UNSET_ATTRIBUTE", //$NON-NLS-1$
						toString(node.nodeName()) , 
						toString(name), kind );
				return null;				
			}
		}
		
		
		if (filter == null || isEmpty(value) ) {
			return value;
		}
		
		if (filter.select(value)) {
			return value;
		}
		
		problem = createError(node);
		problem.setAttribute(IProblem.CONTEXT, name.getLocalPart());
		problem.fill("BPELC__INVALID_ATTRIBUTE_VALUE", //$NON-NLS-1$
				toString(node.nodeName()),
				toString(name), 
				value,
				filter.toString() ,
				kind);
		
		return null ;		
	}


	/**
	 * A generic check against all attributes that are pointers to other
	 * objects. For example, portType on invoke, partnerLink, etc. are 
	 * represented as attributes but in fact refer to larger objects in the
	 * models. 
	 * 
	 * @param node
	 * @param ref the referenced node 
	 * @param name the name of the attribute that references the node
	 * @param kind 1 for activity node, 0 for generic node
	 * @return true if the attribute pointer can be resolved, false otherwise
	 */
	
	@SuppressWarnings("boxing")
	public boolean checkAttributeNode ( INode node, INode ref, QName name, int kind ) {
		
		IProblem problem;
		
		if (ref == null) {
			problem = createError(node);
			problem.setAttribute(IProblem.CONTEXT, name);
			problem.fill("BPELC__UNSET_ATTRIBUTE", //$NON-NLS-1$
					toString(node.nodeName()) , 
					toString(name), kind );
			return false;				
		}
		
		if (ref.isResolved() == false) {		
			String atValue = node.getAttribute( name );
			
			problem = createError(node);
			problem.setAttribute(IProblem.CONTEXT, name);
			problem.fill("BPELC__UNRESOLVED_ATTRIBUTE", //$NON-NLS-1$
					toString(node.nodeName()), 
					toString(name), kind , atValue );
			return false;
		}
		
		return true;				
	}


	/**
	 * Check if NCName is valid.
	 * 
	 * @param node the node on which we are checking.
	 * @param ncName the ncName
	 * @param atName the attribute name from where the ncName came from.
	 * @return return true if checkName succeeds, false otherwise.
	 */
	
	
	@SuppressWarnings("boxing")
	public boolean checkNCName ( INode node, String ncName, QName atName ) {
		
		if (ncName == null || ncName.length() == 0) {
			
			IProblem problem = createError( node );
			problem.setAttribute(IProblem.CONTEXT, atName.getLocalPart() );
			problem.fill("BPELC__UNSET_ATTRIBUTE", 
					toString(node.nodeName()) ,
					atName,
					IConstants.KIND_NODE);
			return false ;
		}
		
		if (Filters.NC_NAME.select(ncName) == false) {
			
			IProblem problem = createError( node );
			problem.setAttribute(IProblem.CONTEXT, atName.getLocalPart() );
			problem.fill("General.NCName_Bad", //$NON-NLS-1$
					toString(atName), 
					toString(node.nodeName()) , ncName );
			return false;
		}
		
		// Check for uniqueness of name within a scope or process ?
		return true;
	}


	/** 
	 * Check the node's validator to see if there are any problems reported on the
	 * node. 
	 * 
	 * @param node the context node
	 * @param ref  the referenced node that comes from the node via an attribute
	 * @param name the name of the attribute reference
	 * @param kind 0 for node, 1 for activity
	 * @return true if there are any problems, false otherwise.
	 */
	
	@SuppressWarnings("boxing")
	public boolean checkValidator ( INode node, INode ref, QName name, int kind ) {
		
		if (ref == null) {		
			return false;
		}
		
		Validator validator = ref.nodeValidator();
		if (validator == null) {
			return true;
		}
		
		IProblem problem;
		if (validator.hasProblems()) {
			problem = createWarning(node);
			problem.setAttribute(IProblem.CONTEXT, name.getLocalPart() );
			problem.fill("BPELC_REF_NODE_PROBLEMS", //$NON-NLS-1$					
					toString(node.nodeName()),
					toString(ref.nodeName()),
					name,
					kind);
			
			return false;
		}
		
		return true;		
	}

	
	/**
	 * 
	 * Return the language (expression or query) from the node.
	 * 
	 * @param node
	 * @param atName the attribute name 
	 * @return the default language.
	 */
	
	public String getLanguage (INode node, QName atName) {

		// get the expression language
		String lang = node.getAttribute (atName);		
		if (lang == null) {
			INode process = node.rootNode ();
			lang = process.getAttribute(atName);			
		}
		
		// the default language
		
		if (lang == null) {
			return IConstants.XMLNS_XPATH_EXPRESSION_LANGUAGE;
		}
		return lang;
	}
		
	
	protected int getNodeKind ( INode node ) {
		if (Filters.ACTIVITIES.select(node)) {
			return IConstants.KIND_ACTIVITY;
		}
		return IConstants.KIND_NODE;
	}
	
	
	protected Validator createExpressionValidator ( QName qname ) {

		Validator object = RuleFactory.INSTANCE.createValidator ( qname ); 
	
		IProblem problem;
	
		if  (object == null) {
		
			problem = createWarning();
			problem.fill("BPELC__NO_EXPRESSION_VALIDATOR",  //$NON-NLS-1$					
					toString(mNode.nodeName()),
					qname.getNamespaceURI()
			);			
			return null;
		}
		return object;
	}
	
	
	
}
