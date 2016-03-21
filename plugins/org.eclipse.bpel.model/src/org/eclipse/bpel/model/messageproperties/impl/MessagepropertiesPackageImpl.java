/**
 * <copyright>
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: MessagepropertiesPackageImpl.java,v 1.8 2011/03/30 18:54:26 rbrodt Exp $
 */
package org.eclipse.bpel.model.messageproperties.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.impl.BPELPackageImpl;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesFactory;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;
import org.eclipse.bpel.model.messageproperties.Property;
import org.eclipse.bpel.model.messageproperties.PropertyAlias;
import org.eclipse.bpel.model.messageproperties.Query;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.model.partnerlinktype.impl.PartnerlinktypePackageImpl;
import org.eclipse.bpel.model.messageproperties.util.MessagepropertiesConstants;
import org.eclipse.bpel.model.messageproperties.util.MessagepropertiesExtensibilityElementFactory;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;

import org.eclipse.wst.wsdl.WSDLPackage;
import org.eclipse.wst.wsdl.WSDLPlugin;

import org.eclipse.wst.wsdl.internal.impl.WSDLPackageImpl;
import org.eclipse.wst.wsdl.util.ExtensibilityElementFactory;
import org.eclipse.wst.wsdl.util.ExtensibilityElementFactoryRegistry;

import org.eclipse.xsd.impl.XSDPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MessagepropertiesPackageImpl extends EPackageImpl implements
		MessagepropertiesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyAliasEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass queryEClass = null;

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
	 * @see org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MessagepropertiesPackageImpl() {
		super(eNS_URI, MessagepropertiesFactory.eINSTANCE);
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
	 * @generated NOT
	 */
	public static MessagepropertiesPackage initGen() {
		if (isInited)
			return (MessagepropertiesPackage) EPackage.Registry.INSTANCE
					.getEPackage(MessagepropertiesPackage.eNS_URI);

		// Obtain or create and register package
		MessagepropertiesPackageImpl theMessagepropertiesPackage = (MessagepropertiesPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) instanceof MessagepropertiesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(eNS_URI) : new MessagepropertiesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackageImpl.init();
		WSDLPackageImpl.init();
		XSDPackageImpl.init();

		// Create package meta-data objects
		theMessagepropertiesPackage.createPackageContents();

		// Initialize created meta-data
		theMessagepropertiesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMessagepropertiesPackage.freeze();

		return theMessagepropertiesPackage;
	}

	/**
	 * @customized
	 */
	public static MessagepropertiesPackage init() {
		boolean inited = isInited;
		MessagepropertiesPackageImpl theMessagepropertiesPackage = (MessagepropertiesPackageImpl) initGen();

		if (inited)
			return theMessagepropertiesPackage;

		// Initialize WSDL extensibility factory if running outside Eclipse.
		// Keep this in sync with the extensions in plugin.xml.
		if (WSDLPlugin.getPlugin() == null) {
			ExtensibilityElementFactoryRegistry registry = WSDLPlugin.INSTANCE
					.getExtensibilityElementFactoryRegistry();

			ExtensibilityElementFactory eef = new MessagepropertiesExtensibilityElementFactory();

			registry.registerFactory(MessagepropertiesConstants.NAMESPACE_2004,
					eef);
			registry.registerFactory(MessagepropertiesConstants.NAMESPACE_2007,
					eef);
		}

		return theMessagepropertiesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_QName() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Type() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_ID() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyAlias() {
		return propertyAliasEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyAlias_MessageType() {
		return (EAttribute) propertyAliasEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyAlias_Part() {
		return (EAttribute) propertyAliasEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyAlias_PropertyName() {
		return (EAttribute) propertyAliasEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyAlias_ID() {
		return (EAttribute) propertyAliasEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyAlias_WsdlPart() {
		return (EReference) propertyAliasEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyAlias_Query() {
		return (EReference) propertyAliasEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyAlias_Type() {
		return (EAttribute) propertyAliasEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyAlias_XSDElement() {
		return (EAttribute) propertyAliasEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQuery() {
		return queryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuery_QueryLanguage() {
		return (EAttribute) queryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQuery_Value() {
		return (EAttribute) queryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessagepropertiesFactory getMessagepropertiesFactory() {
		return (MessagepropertiesFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__QNAME);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEAttribute(propertyEClass, PROPERTY__TYPE);
		createEAttribute(propertyEClass, PROPERTY__ID);

		propertyAliasEClass = createEClass(PROPERTY_ALIAS);
		createEAttribute(propertyAliasEClass, PROPERTY_ALIAS__MESSAGE_TYPE);
		createEAttribute(propertyAliasEClass, PROPERTY_ALIAS__PART);
		createEAttribute(propertyAliasEClass, PROPERTY_ALIAS__PROPERTY_NAME);
		createEAttribute(propertyAliasEClass, PROPERTY_ALIAS__ID);
		createEReference(propertyAliasEClass, PROPERTY_ALIAS__WSDL_PART);
		createEReference(propertyAliasEClass, PROPERTY_ALIAS__QUERY);
		createEAttribute(propertyAliasEClass, PROPERTY_ALIAS__TYPE);
		createEAttribute(propertyAliasEClass, PROPERTY_ALIAS__XSD_ELEMENT);

		queryEClass = createEClass(QUERY);
		createEAttribute(queryEClass, QUERY__QUERY_LANGUAGE);
		createEAttribute(queryEClass, QUERY__VALUE);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		WSDLPackage theWSDLPackage = (WSDLPackage) EPackage.Registry.INSTANCE
				.getEPackage(WSDLPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE
				.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		propertyEClass.getESuperTypes().add(
				theWSDLPackage.getExtensibilityElement());
		propertyAliasEClass.getESuperTypes().add(
				theWSDLPackage.getExtensibilityElement());
		queryEClass.getESuperTypes().add(
				theWSDLPackage.getExtensibilityElement());

		// Initialize classes and features; add operations and parameters
		initEClass(
				propertyEClass,
				Property.class,
				"Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getProperty_QName(),
				theWSDLPackage.getQName(),
				"qName", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getProperty_Name(),
				ecorePackage.getEString(),
				"name", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getProperty_Type(),
				theEcorePackage.getEJavaObject(),
				"type", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getProperty_ID(),
				ecorePackage.getEString(),
				"ID", null, 0, 1, Property.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				propertyAliasEClass,
				PropertyAlias.class,
				"PropertyAlias", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getPropertyAlias_MessageType(),
				theEcorePackage.getEJavaObject(),
				"messageType", null, 0, 1, PropertyAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPropertyAlias_Part(),
				ecorePackage.getEString(),
				"part", null, 0, 1, PropertyAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPropertyAlias_PropertyName(),
				theEcorePackage.getEJavaObject(),
				"propertyName", null, 0, 1, PropertyAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPropertyAlias_ID(),
				ecorePackage.getEString(),
				"ID", null, 0, 1, PropertyAlias.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getPropertyAlias_WsdlPart(),
				theWSDLPackage.getPart(),
				null,
				"wsdlPart", null, 1, 1, PropertyAlias.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getPropertyAlias_Query(),
				this.getQuery(),
				null,
				"query", null, 0, 1, PropertyAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPropertyAlias_Type(),
				theEcorePackage.getEJavaObject(),
				"type", null, 0, 1, PropertyAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPropertyAlias_XSDElement(),
				theEcorePackage.getEJavaObject(),
				"XSDElement", null, 0, 1, PropertyAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				queryEClass,
				Query.class,
				"Query", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getQuery_QueryLanguage(),
				ecorePackage.getEString(),
				"queryLanguage", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getQuery_Value(),
				ecorePackage.getEString(),
				"value", null, 0, 1, Query.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //MessagepropertiesPackageImpl
