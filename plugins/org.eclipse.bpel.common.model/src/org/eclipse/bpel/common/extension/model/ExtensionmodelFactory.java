/*******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.bpel.common.extension.model;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.common.extension.model.ExtensionmodelPackage
 * @generated
 */
public interface ExtensionmodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtensionmodelFactory eINSTANCE = new org.eclipse.bpel.common.extension.model.impl.ExtensionmodelFactoryImpl();

	/**
	 * Returns a new object of class '<em>Extension Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Map</em>'.
	 * @generated
	 */
	ExtensionMap createExtensionMap();

	/**
	 * Returns a new object of class '<em>Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension</em>'.
	 * @generated
	 */
	Extension createExtension();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExtensionmodelPackage getExtensionmodelPackage();

	/**
	  * Method findExtensionSet.
	  * Given a namespace and the contents of a Resource (as an EList), this
	  * method will find the first instance of an ExtensionMap object for the
	  * given namespace. <code>null</code> is returned if one doesn't exists
	  * @param namespace - ExtensionMap namespace
	  * @param contents - Resource contents
	  * @return ExtensionMap
	  * @customized
	  */
	 ExtensionMap findExtensionMap(String namespace, EList contents);
	 
	/**
     * Method findExtensionSets. Given a namespace and the contents of a
     * Resource (as an EList), this method will find all ExtensionMap objects
     * that for the given namespace. An empty list is returned if one no
     * ExtensionMap objects meeting the criteria exists
     * @param namespace - ExtensionMap namespace
     * @param contents - Resource contents
     * @return ExtensionMap
     * @customized
		 */
		 EList findExtensionMaps(String namespace, EList contents);

	 /**
	  * Method createExtensionSet.
	  * Creates an ExtensionMap object for the given namespace.
	  * @param namespace
	  * @return ExtensionMap
	  * @customized
	  */
	 ExtensionMap createExtensionMap(String namespace);

	 /**
	  * Method adaptEObject.
	  * This method associates an adapter to a model object.
	  * @param target - object to which the adaptor is to be associated
	  * @param adapter - adapter to asociate to target
	  * @customized
	  */
	 void adaptEObject(EObject target, Adapter adapter);
	 
	/**
	 * Method getExtensionEdapter.
	 * This method returns an extension adapter associated with the
	 * given EObject.
	 * @param extendedObject - adapter object
	 * @param namesapce - adapter's namesapce
	 * @return adapter object
	 * @customized
	 */
	Adapter getExtensionAdapter(EObject extendedObject, String namesapce);
	
	
} //ExtensionmodelFactory
