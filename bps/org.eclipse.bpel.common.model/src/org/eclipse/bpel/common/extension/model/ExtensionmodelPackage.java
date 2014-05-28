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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.common.extension.model.ExtensionmodelFactory
 * @model kind="package"
 * @generated
 */
public interface ExtensionmodelPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///extensionmodel.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "extensionmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtensionmodelPackage eINSTANCE = org.eclipse.bpel.common.extension.model.impl.ExtensionmodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.common.extension.model.impl.ExtensionMapImpl <em>Extension Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.common.extension.model.impl.ExtensionMapImpl
	 * @see org.eclipse.bpel.common.extension.model.impl.ExtensionmodelPackageImpl#getExtensionMap()
	 * @generated
	 */
	int EXTENSION_MAP = 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_MAP__NAMESPACE = 0;

	/**
	 * The feature id for the '<em><b>Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_MAP__EXTENSIONS = 1;

	/**
	 * The number of structural features of the '<em>Extension Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.common.extension.model.impl.ExtensionImpl <em>Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.common.extension.model.impl.ExtensionImpl
	 * @see org.eclipse.bpel.common.extension.model.impl.ExtensionmodelPackageImpl#getExtension()
	 * @generated
	 */
	int EXTENSION = 1;

	/**
	 * The feature id for the '<em><b>Extended Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__EXTENDED_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Extension Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION__EXTENSION_OBJECT = 1;

	/**
	 * The number of structural features of the '<em>Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENSION_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.common.extension.model.ExtensionMap <em>Extension Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension Map</em>'.
	 * @see org.eclipse.bpel.common.extension.model.ExtensionMap
	 * @generated
	 */
	EClass getExtensionMap();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.common.extension.model.ExtensionMap#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.eclipse.bpel.common.extension.model.ExtensionMap#getNamespace()
	 * @see #getExtensionMap()
	 * @generated
	 */
	EAttribute getExtensionMap_Namespace();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.common.extension.model.ExtensionMap#getExtensions <em>Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Extensions</em>'.
	 * @see org.eclipse.bpel.common.extension.model.ExtensionMap#getExtensions()
	 * @see #getExtensionMap()
	 * @generated
	 */
	EReference getExtensionMap_Extensions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.common.extension.model.Extension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extension</em>'.
	 * @see org.eclipse.bpel.common.extension.model.Extension
	 * @generated
	 */
	EClass getExtension();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.bpel.common.extension.model.Extension#getExtendedObject <em>Extended Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extended Object</em>'.
	 * @see org.eclipse.bpel.common.extension.model.Extension#getExtendedObject()
	 * @see #getExtension()
	 * @generated
	 */
	EReference getExtension_ExtendedObject();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.common.extension.model.Extension#getExtensionObject <em>Extension Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extension Object</em>'.
	 * @see org.eclipse.bpel.common.extension.model.Extension#getExtensionObject()
	 * @see #getExtension()
	 * @generated
	 */
	EReference getExtension_ExtensionObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExtensionmodelFactory getExtensionmodelFactory();

} //ExtensionmodelPackage
