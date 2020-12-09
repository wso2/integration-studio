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
package org.eclipse.bpel.common.extension.model.impl;

import org.eclipse.bpel.common.extension.model.Extension;
import org.eclipse.bpel.common.extension.model.ExtensionMap;
import org.eclipse.bpel.common.extension.model.ExtensionmodelFactory;
import org.eclipse.bpel.common.extension.model.ExtensionmodelPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExtensionmodelPackageImpl extends EPackageImpl implements ExtensionmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extensionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.bpel.common.extension.model.ExtensionmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExtensionmodelPackageImpl() {
		super(eNS_URI, ExtensionmodelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ExtensionmodelPackage init() {
		if (isInited) return (ExtensionmodelPackage)EPackage.Registry.INSTANCE.get(ExtensionmodelPackage.eNS_URI);

		// Obtain or create and register package.
		ExtensionmodelPackageImpl theExtensionmodelPackage = (ExtensionmodelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExtensionmodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackageImpl.init();

		// Obtain or create and register interdependencies

		// Step 1: create meta-model objects
		theExtensionmodelPackage.createPackageContents();

		// Step 2: complete initialization
		theExtensionmodelPackage.initializePackageContents();

		return theExtensionmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtensionMap() {
		return extensionMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionMap_Namespace() {
		return (EAttribute)extensionMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionMap_Extensions() {
		return (EReference)extensionMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtension() {
		return extensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtension_ExtendedObject() {
		return (EReference)extensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtension_ExtensionObject() {
		return (EReference)extensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionmodelFactory getExtensionmodelFactory() {
		return (ExtensionmodelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		extensionMapEClass = createEClass(EXTENSION_MAP);
		createEAttribute(extensionMapEClass, EXTENSION_MAP__NAMESPACE);
		createEReference(extensionMapEClass, EXTENSION_MAP__EXTENSIONS);

		extensionEClass = createEClass(EXTENSION);
		createEReference(extensionEClass, EXTENSION__EXTENDED_OBJECT);
		createEReference(extensionEClass, EXTENSION__EXTENSION_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackageImpl theEcorePackage = (EcorePackageImpl)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(extensionMapEClass, ExtensionMap.class, "ExtensionMap", !IS_ABSTRACT, !IS_INTERFACE);
		initEAttribute(getExtensionMap_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED);
		initEReference(getExtensionMap_Extensions(), this.getExtension(), null, "extensions", null, 0, -1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED);

		addEOperation(extensionMapEClass, null, "initializeAdapter");

		initEClass(extensionEClass, Extension.class, "Extension", !IS_ABSTRACT, !IS_INTERFACE);
		initEReference(getExtension_ExtendedObject(), theEcorePackage.getEObject(), null, "extendedObject", null, 1, 1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED);
		initEReference(getExtension_ExtensionObject(), theEcorePackage.getEObject(), null, "extensionObject", null, 1, 1, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED);

		// Create resource
		createResource(eNS_URI);
	}
} //ExtensionmodelPackageImpl
