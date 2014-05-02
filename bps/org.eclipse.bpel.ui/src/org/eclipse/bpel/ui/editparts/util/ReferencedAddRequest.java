/*******************************************************************************
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.ui.editparts.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreationFactory;

/* 
 * this is our version of the CreateRequest 
 * This version does not assume that we have a mouse location
 * Instead, it takes an optional "reference" object for operations
 * like "insert before referenced object"
 **/
public class ReferencedAddRequest extends Request {
	
	private Object newObject;
	private Object referencedObject;
	private CreationFactory creationFactory;
	static public String typeString = "ReferencedAddType"; //$NON-NLS-1$
	/**
	 * Returns the CreationFactory for this request.
	 * @return the CreationFactory
	 */
	protected CreationFactory getFactory() {
		return creationFactory;
	}
	
	public Object getNewObject() {
		if (newObject == null)
			newObject = getFactory().getNewObject();
		return newObject;
	}

	public Object getNewObjectType() {
		if (newObject != null)
			return ((EObject)newObject).eClass();
		return getFactory().getObjectType();
	}

	public void setFactory(CreationFactory factory) {
		creationFactory = factory;
	}
	
	public void setReferencedObject(Object obj) {
		referencedObject = obj;
	}
	
	public void setNewObject(Object obj) {
		newObject = obj;
	}
	
	public Object getReferencedObject() {
		return referencedObject;
	}
}
