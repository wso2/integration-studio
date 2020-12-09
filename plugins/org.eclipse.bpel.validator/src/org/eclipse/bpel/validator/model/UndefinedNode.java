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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.xml.namespace.QName;

import org.eclipse.bpel.validator.helpers.ModelQueryImpl;


/**
 * @author Michal Chmielewski (michal.chmielewski@oracle.com)
 * @date Dec 14, 2006
 *
 */
public class UndefinedNode implements INode {
	
	HashMap<Object,Object> mMap = new HashMap<Object,Object>(5);
	QName fNode ;
	
	/**
	 * @param name
	 * @param args
	 */
	public UndefinedNode ( QName name, Object ... args ) {
		fNode = name;
		
		for(int i=0; i < args.length; i += 2) {
			mMap.put(args[i], args[i+1]);			
		}
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.INode#children()
	 */
	public List<INode> children() {
		return Collections.emptyList();
	}

	/**
	 * @see org.eclipse.bpel.validator.model.INode#getAttribute(javax.xml.namespace.QName)
	 */
	public String getAttribute (QName name) {
		Object value = mMap.get(name);
		if (value == null) {
			return null;
		}
		if (value instanceof String) {
			return (String) value;
		}
		return null;		
	}

	/**
	 * @see org.eclipse.bpel.validator.model.INode#getAttributeAsQName(javax.xml.namespace.QName)
	 */
	
	public QName getAttributeAsQName ( QName name ) {
		String value = getAttribute (name);
		if (value == null) {
			return null;
		}
		return ModelQueryImpl.getModelQuery().createQName(this, value);
	}
	
	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.INode#getNode(javax.xml.namespace.QName)
	 */
	
	public INode getNode (QName name) {		
		return null;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.INode#getNodeList(javax.xml.namespace.QName)
	 */	
	public List<INode> getNodeList(QName name) {
		return Collections.emptyList();
	}

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.INode#isResolved()
	 */
	public boolean isResolved() {
		return false;		
	}

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.INode#nodeName()
	 */
	
	public QName nodeName() {
		return fNode;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.INode#nodeValidator()
	 */
	public Validator nodeValidator() { 
		return null;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.INode#nodeValue()
	 */
	
	public Object nodeValue() {	
		return null;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.INode#parentNode()
	 */
	public INode parentNode() {
		return null;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.bpel.validator.model.INode#rootNode()
	 */
	public INode rootNode() {		
		return null;
	}
}
