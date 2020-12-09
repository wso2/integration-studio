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

import java.util.List;

import javax.xml.namespace.QName;

/**
 * A simple facade interface that can be used to describe 
 * tree like structures. We use it to map the BPEL EMF API. 
 * <p>
 * In practice, any BPEL model API could be facaded by INode,
 * even a DOM. 
 * <p>
 * The intention is to build a validator which contains rules that
 * do not depend on any one implementation of the BPEL 
 * model API. 
 * <p>
 * The idea is that INode can contain nodes on 2 axis.
 * <ul>
 *  <li> Child axis and 
 *  <li> Attribute Axis
 * </ul>
 * 
 * 
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 18, 2006
 *
 */

public interface INode {
	
	/**
	 * Return the string value of an attribute node. Note
	 * that attribute nodes in the DOM API are leaf nodes, but
	 * the INode facade does not necessarily make it so.
	 * <p> 
	 * Consider a variable definition in BPEL. In the DOM, 
	 * the type is an attribute (a QName). In a model (such EMF)
	 * it may be an XMLTypeDefition. This is one example when 
	 * simple attributes in one model become complex nodes in another.
	 * <p> 
	 * This method return the attribute as a string value. You can
	 * think of it as returning the "pointer name" to the attribute Node.
	 * <p>
	 * In some cases, attribute nodes will just have the string name,
	 * and will not necessarily facade any other model behind them.
	 * <p>
	 * As an example, the name attribute on many BPEL activities is an NCName.
	 * (which a restricted "string"). 
	 * <p>
	 * @param name the name of the attribute node 
	 * @return the string value of the attribute node.
	 */
	
	public String getAttribute( QName name );
	
	
	/**
	 * Same as above except that the value of attribute is returned as the most
	 * correct QName (taking namespace mappings into account).
	 * 
	 * @param name attribute name
	 * @return the QName value of the attribute.
	 */
	
	public QName getAttributeAsQName ( QName name );
	
	/** 
	 * Return an INode facade to the attribute node. Note that 
	 * in some cases, the facade returned may in fact be a node (INode facade) 
	 * from another model tree. For example, WSDL, XSD, etc.
	 * 
	 * @param name the name of the node
	 * @return the INode facade of the attribute node.
	 */
 
	
	/**
	 * Return an INode facade to the name named name. 
	 * <p>
	 * Here we look at the children of the current node and return
	 * the first node (or the only node) which is named so in the 
	 * model space. 
	 * 
	 * @param name
	 * @return the INode facade to the given node or null if not set.
	 */
	
	public INode getNode ( QName name ) ;
	
	
	/**
	 * Return a list of INode facaded nodes which correspond to the collection
	 * named name. 
	 * <p>
	 * Here we look at the children of the current node and return
	 * that list which matches the name specified.  
	 * 
	 * @param name
	 * @return a list of such nodes.
	 */
	
	public List<INode> getNodeList ( QName name ) ;
	
	/**
	 * Return the node name of this node. This is used to understand and
	 * translate model specific information into the facade and is totally
	 * model dependent. 
	 * 
	 * @return the mode node name
	 */
	
	public QName nodeName ();
	
	
	/**
	 * Return the model specific value of the object that INode is facading.
	 * This has little use in the validator, since any judgments pronounced
	 * on this value can only be made in the context of the actual 
	 * object model which understands it.
	 * 
	 * @return the facaded object, whatever it may be.
	 */
	
	public Object nodeValue ();
	
	
	/**
	 * Return the node validator for the given node that INode is facading.
	 * 
	 * This may return null.
	 * 
	 * @return the INodeValidator that will or had validated this INode
	 */
	
	public Validator nodeValidator ();
	
	
	/**
	 * Return the parent node. The parent node of the root node is null
	 * for simplicity. Otherwise, every node returned will have a pointer
	 * to it's parent node.
	 * 
	 * @return the parentNode or null if there is no parent
	 */
	
	public INode parentNode ();
	
	/**
	 * Returns the root node of the tree
	 * 
	 * @return root node of this tree
	 */
	
	public INode rootNode ();
	
	/**
	 * Return the non-attribute immediate children of this node. 
	 * This method never returns null. If there are no children, 
	 * then an empty list must be returned.
	 * 
	 * @return the list of children.
	 */
	
	public List<INode> children ();

	
	
	/**
	 * Answer if the current INode is resolved. The idea here is that some nodes
	 * in the model are really references or pointers to other model objects.
	 * <p> 
	 * Some examples of this concept:
	 * <ul>
	 *  <li>variable nodes in invoke activities
	 *  <li>XML type nodes in variable declarations
	 *  <li>portType nodes in partner activities
	 * </ul>
	 * <p>
	 * Conceptually, the node in the BPEL model is either resolved or not resolved. 
	 * Nodes which are not resolved and cannot be resolved correctly are not specified
	 * correctly.
	 * <p>
	 * As an example, consider variable in a receive activity as in
	 * <pre>
	 *   &lt;receive variable="foobar">
	 * </pre>
	 * The validator needs to know if the variable "foobar" is defined (not null) and if
	 * it is resolved (if it points to a valid definition of a variable) as one of its 
	 * checks. 
	 * 
	 * <p>
	 * The code to check if the variable is defined correctly is dependent on the actual
	 * BPEL model representation. In the BPEL EMF model, this is simply a check to see
	 * if the EObject is a proxy. Other models would have to implement this in another way. 
	 * 
	 * @return true if resolved, false if not.
	 */
	boolean isResolved ();
}
