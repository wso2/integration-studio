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
package org.eclipse.bpel.ui.factories;

import org.eclipse.bpel.ui.Policy;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;


/**
 * Factory that knows how to create one conceptual type of UI object
 * (and only the one type of object).  The objects created must be EMF model objects
 * (i.e. instances of EObject) and the types that represent them must be EMF classes
 * (i.e. instances of EClass).
 * 
 * This corresponds to items that you can create with the palette of a DetailsEditor.
 * 
 * NOTE: the object returned by getNewEObject() is NOT necessarily an instance of the
 * same EClass as getEClass returns!
 * 
 * Concrete subclasses must still specify where to get icons from, and what the
 * human-readable type label of the factory should be.
 */
public abstract class AbstractUIObjectFactory implements CreationFactory {

	protected String idString;
	
	/**
	 * This implementation forms a package identifier for the EClass from its namespace URI.
	 * Example: for an Invoke object from the BPELPackage (which has a namespace URI of
	 * "http:///org/eclipse/bpel.ecore") it would return "org.eclipse.bpel.Invoke".
	 */
	protected String createUniqueIdString() {
		// (1) get the namespace URI of the enclosing EPackage,
		StringBuffer s = new StringBuffer(getModelType().getEPackage().getNsURI());
		// (2) remove colon-prefixes such as "http:" (if any),
		for (int i = s.indexOf(":"); i >= 0; i = s.indexOf(":")) s.delete(0,i+1); //$NON-NLS-1$ //$NON-NLS-2$
		// (3) remove leading slashes (if any),
		while (s.length() > 0 && s.charAt(0) == '/') s.deleteCharAt(0);
		// (4) remove ".ecore" suffix (if any), and
		if (s.toString().endsWith(".ecore")) s.setLength(s.length()-5); //$NON-NLS-1$
		// (5) convert slashes to periods.
		for (int i = 0; i<s.length(); i++) if (s.charAt(i)=='/') s.setCharAt(i,'.');

		if (s.length() > 0 && s.charAt(s.length()-1) != '.') s.append('.');
		s.append(getModelType().getName());
		
		if (Policy.DEBUG) System.out.println("uniqueIdString for "+getModelType().getName()+" is: "+s); //$NON-NLS-1$ //$NON-NLS-2$
		return s.toString();
	}

	/**
	 * Return the EClass representing the type of model object this factory creates.
	 */
	public abstract EClass getModelType();
	
	/**
	 * Return a new instance of the type of model object this factory creates.
	 * This implementation can create instances of any EClass.
	 * @param <T> the type of the return object 
	 * @return Return a new instance of the type of model object this factory creates.
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends EObject> T createInstance() {
	    EClass modelType = getModelType();
		return (T) modelType.getEPackage().getEFactoryInstance().create(modelType);
	}

	/**
	 * Return a small image representing the type of model object this factory creates
	 */
	public abstract ImageDescriptor getSmallImageDescriptor();

	/**
	 * Return a large image representing the type of model object this factory creates
	 */
	public abstract ImageDescriptor getLargeImageDescriptor();

	/**
	 * Return a small image representing the type of model object this factory creates
	 */
	public abstract Image getSmallImage();

	/**
	 * Return a large image representing the type of model object this factory creates
	 */
	public abstract Image getLargeImage();

	/**
	 * Return a string labelling the type of model object this factory creates
	 */
	public abstract String getTypeLabel();

	/**
	 * Return a string which will be unique across various models for this type of object.
	 * I.e. a string consisting of a package name reserved to that model and an EClass name
	 * for the type, e.g: "org.eclipse.bpel.Invoke"
	 * 
	 * This string is suitable for use in action IDs and other places where non-conflicting
	 * strings are necessary.
	 */
	public String getUniqueIdString() {
	    if (idString == null) {
			idString = createUniqueIdString();
	    }
	    return idString;
	}

	public final Object getNewObject() { return createInstance(); }
	public final Object getObjectType() { return getModelType(); }
}
