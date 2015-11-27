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
package org.eclipse.bpel.validator.adapters;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELExtensibleElement;
import org.eclipse.bpel.model.adapters.AbstractStatefulAdapter;
import org.eclipse.bpel.validator.Activator;
import org.eclipse.bpel.validator.helpers.ModelQueryImpl;
import org.eclipse.bpel.validator.model.IConstants;
import org.eclipse.bpel.validator.model.IModelQuery;
import org.eclipse.bpel.validator.model.IModelQueryLookups;
import org.eclipse.bpel.validator.model.INode;
import org.eclipse.bpel.validator.model.RuleFactory;
import org.eclipse.bpel.validator.model.Validator;
import org.eclipse.emf.ecore.EObject;
import org.w3c.dom.Element;


/**
 * This adapter adapts the EMF BPEL model objects to the INode and IValidate interfaces. 
 * <p>
 * INode is a very thin navigation interface that allows us to access aspects of
 * the EMF BPEL model objects. It makes no assumptions about how such model is stored, other
 * then it is a tree. 
 * <p>
 * This is where the world of the validator and the BPEL editor is bridged. 
 *   
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Sep 18, 2006
 *
 */

public class BasicAdapter extends AbstractStatefulAdapter 
	implements INode {
		
	/** The validator that we want */
	Validator mValidator = null;

	QName mNodeName = null;
	
	
	/** 
	 * Since we are "adapting" the EMF BPEL model, the convention here is to use
	 * the validator classes defined in org.eclipse.bpel.validator.rules.
	 * <p>
	 * The name of the class which contain the rules is the name of the EMF class
	 * (which corresponds to the BPEL name) followed by the word "Validator".
	 * <p>
	 * Clearly, any adapters can override this validator creation step.
	 * 
	 * @return returns a suitable validator, null, if one cannot be created. 
	 */
		
	public Validator createValidator () {
		
		EObject obj = (EObject) getTarget();
		QName qname = new QName(IConstants.XMLNS_BPEL,obj.eClass().getName());
		return RuleFactory.INSTANCE.createValidator( qname );
	}
	
	
	/**
	 * Returns the list of the children of this node, as INode objects.
	 * Only direct descendants of this node are returned.
	 * 
	 * @return the list of children of this node.
	 */
		
	public List<INode> children() {	
		
		EObject obj = (EObject) getTarget();
		List<?> childList = obj.eContents();
		ArrayList<INode> list = new ArrayList<INode>(childList.size());
		
		for(Object next : obj.eContents()) {
			INode node = adapt(next, INode.class );
			if (node != null) {
				list.add( node );
			}
		}
		return list;
	}

	/**
	 * Return the name of accessor method that we can call on the EMF model object
	 * to get the value of the property passed in propertyName.
	 * <p>
	 * By default, the bean interface is used to figure out the method name.
	 * <p>
	 * Classes can override this method.
	 * 
	 * @param propertyName
	 * @return the name of the method.
	 */
	
	
	public String getAccessorMethodName ( String propertyName ) {
		
		return "get" +  //$NON-NLS-1$
			Character.toUpperCase( propertyName.charAt(0)) + 
			propertyName.substring(1);
	}
	
	
	
	/**
	 * Return the actual method that can be called on the target object
	 * to retrieve the necessary information.
	 * 
	 * @param name
	 * @return the method that will be called to get the value of the attributeName, or null
	 */
		
	Method methodFor ( String name ) {
		
		Class<?> clazz = getTarget().getClass();
		
		try {
			return clazz.getMethod( getAccessorMethodName ( name ) );
		} catch (NoSuchMethodException nsme) {
			// we log this, as our validator code must have access to such methods			
			Activator.log(nsme);
		}		
		return null;
	}
	
	/**
	 * TODO: At some point, when the DOM Facade is done in the EMF model, then
	 * we can getAttribute as follows ...
	 * 
	 * // When DOM Facade is done.
		// return eObj.getElement().getAttribute( AT_VARIABLES );		
	 */
	
	/**
	 * Return the value of the attribute specified that belongs to this INode.
	 * <p>
	 * Classes may want to override this method when the "attribute" node is expressed as
	 * a complex object in the (EMF) model. 
	 * <p>
	 * 
	 * (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.INode#getAttribute(javax.xml.namespace.QName)
	 */
	
	public String getAttribute (QName name) {

		BPELExtensibleElement obj =	getTarget(getTarget(), BPELExtensibleElement.class);
		
		// Turn to the DOM for that information
		Element element = obj.getElement();
		if (element != null) {
			if (element.hasAttributeNS(name.getNamespaceURI(),name.getLocalPart())) {
				return element.getAttributeNS(name.getNamespaceURI(),name.getLocalPart());
			}
		}
		

		
		Method method = methodFor ( name.getLocalPart() ) ;
		
		if (method == null) {
			return null;
		}
		
		Object result = null;
		try {
			result = method.invoke( getTarget() );			
		} catch (Exception ex) {
			// ignore 
		}
		if (result == null) {
			return null;
		}
		
		// If string return it ...
		if (result instanceof String) {
			return (String) result;
		}
		
		return null;
	}


	/**
	 * @see org.eclipse.bpel.validator.model.INode#getAttributeAsQName(javax.xml.namespace.QName)
	 */
	
	public QName getAttributeAsQName ( QName name ) {
		String value = getAttribute(name);
		if (value == null) {
			return null;
		}
		return ModelQueryImpl.getModelQuery().createQName(this, value);
	}
	
	
	/**
	 * Return the child node which matches the name
	 * @param name the name of the child node
	 * @return the INode facade for that node.
	 */
	
	public INode getNode (QName name ) {
		
		Method method = methodFor(name.getLocalPart());
		if (method == null) {
			return null;
		}
		
		try {
			Object result = method.invoke(getTarget());			
			if (result != null) {
				return adapt(result, INode.class);
			}
			
		} catch (Exception ex) {
			// ignore 
		}
		return null;
	}
	
	
	
	/**
	 * Return the list of nodes which matches the name.
	 * @param name the name of the "property"
	 * @return a list of relevant nodes, INode facaded.
	 */
		
	public List<INode> getNodeList ( QName name ) {
		
		Method method = methodFor( name.getLocalPart() );
		if (method == null) {
			return null;
		}
		
		Object result = null;
		try {
			result = method.invoke(getTarget());			
		} catch (Exception ex) {
			 
		}
		
		// If empty or not a list, then we ignore it.
		if (result == null || (result instanceof List) == false ) {
			return Collections.emptyList();
		}		
		// convert to a list of INode objects.
		List<?> r = (List<?>) result;
		if (r.size() == 0) {
			return Collections.emptyList();
		}
		List<INode> newList = new LinkedList<INode>();
		Iterator<?> it = r.iterator();
		while (it.hasNext()) {
			newList.add ( adapt ( it.next(), INode.class ) );
		}		
		return newList;
	}
	
	
	/**
	 * Return if the object under the facade is "resolved" in the model object
	 * space. This is useful in the validator code to check (for example) whether 
	 * an variable's type is visible to the model (whether it is a proxy or not in
	 * EMF terms). 
	 * @return true if the model object is resolved, false otherwise.
	 */
	
	public boolean isResolved ()
	{
		EObject eObj = (EObject) getTarget();
		return (eObj.eIsProxy() == false);			
	}
	

	/**
	 * @see org.eclipse.bpel.validator.model.INode#nodeName()
	 */
	
	public QName nodeName() {
		if (mNodeName != null) {
			return mNodeName;
		}
		EObject obj = (EObject) getTarget();
		String name = obj.eClass().getName();		
		// by convention, this is how the EMF model is naming its BPEL activities.
		mNodeName = new QName(IConstants.XMLNS_BPEL,Character.toLowerCase(name.charAt(0)) + name.substring(1));
		return mNodeName;
	}

	/**
	 * @see org.eclipse.bpel.validator.model.INode#nodeValue()
	 */
	public Object nodeValue() {
		return getTarget();
	}

	
	/**
	 * Return the node validator used to validate this INode
	 * 
	 * @return the node validator used to validate this INode 
	 */
	
	public Validator nodeValidator () {
		if (mValidator == null) {
			mValidator = createValidator();
			if (mValidator != null) {
				mValidator.setNode(this);
			}
		}
		return mValidator;
	}
	
	
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.INode#parentNode()
	 */
	public INode parentNode() {
		
		EObject obj = (EObject) getTarget();
		EObject parent = obj.eContainer();
		if (parent == null) {
			return null;
		}
		return adapt ( parent, INode.class );		
	}

	
	
	/**
	 * Return the root node of this tree.
	 * 
	 * @return the root node of this tree
	 */
	
	public INode rootNode ()
	{
		EObject obj = (EObject) getTarget();
		while (obj.eContainer() != null) {
			obj = obj.eContainer();
		}		
		return adapt ( obj, INode.class );
	}
	
	/**
	 * Adapt to whatever class we need.
	 * 
	 * @param target
	 * @param type
	 * @return the object adapted.
	 */
	
	protected <T extends Object> T adapt ( Object target, Class<T> type) {
		IModelQuery mq = ModelQueryImpl.getModelQuery();
		return mq.adapt(target,type,IModelQueryLookups.ADAPT_HINT_NONE);				
	}
}
