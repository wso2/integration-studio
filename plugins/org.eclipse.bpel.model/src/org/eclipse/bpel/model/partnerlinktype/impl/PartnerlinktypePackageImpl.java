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
 * $Id: PartnerlinktypePackageImpl.java,v 1.8 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.partnerlinktype.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.impl.BPELPackageImpl;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;
import org.eclipse.bpel.model.messageproperties.impl.MessagepropertiesPackageImpl;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.partnerlinktype.util.PartnerlinktypeConstants;
import org.eclipse.bpel.model.partnerlinktype.util.PartnerlinktypeExtensibilityElementFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.wst.wsdl.WSDLPackage;
import org.eclipse.xsd.XSDPackage;
import org.eclipse.wst.wsdl.WSDLPlugin;
import org.eclipse.wst.wsdl.util.ExtensibilityElementFactory;
import org.eclipse.wst.wsdl.util.ExtensibilityElementFactoryRegistry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PartnerlinktypePackageImpl extends EPackageImpl implements
		PartnerlinktypePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partnerLinkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roleEClass = null;

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
	 * @see org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PartnerlinktypePackageImpl() {
		super(eNS_URI, PartnerlinktypeFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link PartnerlinktypePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PartnerlinktypePackage initGen() {
		if (isInited)
			return (PartnerlinktypePackage) EPackage.Registry.INSTANCE
					.getEPackage(PartnerlinktypePackage.eNS_URI);

		// Obtain or create and register package
		PartnerlinktypePackageImpl thePartnerlinktypePackage = (PartnerlinktypePackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof PartnerlinktypePackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new PartnerlinktypePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		WSDLPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		BPELPackageImpl theBPELPackage = (BPELPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(BPELPackage.eNS_URI) instanceof BPELPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(BPELPackage.eNS_URI) : BPELPackage.eINSTANCE);
		MessagepropertiesPackageImpl theMessagepropertiesPackage = (MessagepropertiesPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(MessagepropertiesPackage.eNS_URI) instanceof MessagepropertiesPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(MessagepropertiesPackage.eNS_URI)
				: MessagepropertiesPackage.eINSTANCE);

		// Create package meta-data objects
		thePartnerlinktypePackage.createPackageContents();
		theBPELPackage.createPackageContents();
		theMessagepropertiesPackage.createPackageContents();

		// Initialize created meta-data
		thePartnerlinktypePackage.initializePackageContents();
		theBPELPackage.initializePackageContents();
		theMessagepropertiesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePartnerlinktypePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PartnerlinktypePackage.eNS_URI,
				thePartnerlinktypePackage);
		return thePartnerlinktypePackage;
	}

	/**
	 * @customized
	 */
	public static PartnerlinktypePackage init() {
		boolean inited = isInited;
		PartnerlinktypePackage thePartnerlinktypePackage = initGen();

		if (inited)
			return thePartnerlinktypePackage;

		// Initialize WSDL extensibility factory if running outside Eclipse.
		// Keep this in sync with the extensions in plugin.xml.
		if (WSDLPlugin.getPlugin() == null) {
			ExtensibilityElementFactoryRegistry registry = WSDLPlugin.INSTANCE
					.getExtensibilityElementFactoryRegistry();

			ExtensibilityElementFactory eef = new PartnerlinktypeExtensibilityElementFactory();

			registry.registerFactory(PartnerlinktypeConstants.NAMESPACE_2004,
					eef);
			registry.registerFactory(PartnerlinktypeConstants.NAMESPACE_2007,
					eef);
		}

		return thePartnerlinktypePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartnerLinkType() {
		return partnerLinkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartnerLinkType_Name() {
		return (EAttribute) partnerLinkTypeEClass.getEStructuralFeatures().get(
				0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartnerLinkType_ID() {
		return (EAttribute) partnerLinkTypeEClass.getEStructuralFeatures().get(
				1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPartnerLinkType_Role() {
		return (EReference) partnerLinkTypeEClass.getEStructuralFeatures().get(
				2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRole() {
		return roleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_ID() {
		return (EAttribute) roleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_Name() {
		return (EAttribute) roleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRole_PortType() {
		return (EAttribute) roleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerlinktypeFactory getPartnerlinktypeFactory() {
		return (PartnerlinktypeFactory) getEFactoryInstance();
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
		partnerLinkTypeEClass = createEClass(PARTNER_LINK_TYPE);
		createEAttribute(partnerLinkTypeEClass, PARTNER_LINK_TYPE__NAME);
		createEAttribute(partnerLinkTypeEClass, PARTNER_LINK_TYPE__ID);
		createEReference(partnerLinkTypeEClass, PARTNER_LINK_TYPE__ROLE);

		roleEClass = createEClass(ROLE);
		createEAttribute(roleEClass, ROLE__ID);
		createEAttribute(roleEClass, ROLE__NAME);
		createEAttribute(roleEClass, ROLE__PORT_TYPE);
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
		partnerLinkTypeEClass.getESuperTypes().add(
				theWSDLPackage.getExtensibilityElement());
		roleEClass.getESuperTypes().add(
				theWSDLPackage.getExtensibilityElement());

		// Initialize classes and features; add operations and parameters
		initEClass(
				partnerLinkTypeEClass,
				PartnerLinkType.class,
				"PartnerLinkType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getPartnerLinkType_Name(),
				ecorePackage.getEString(),
				"name", null, 0, 1, PartnerLinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getPartnerLinkType_ID(),
				ecorePackage.getEString(),
				"ID", null, 0, 1, PartnerLinkType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(
				getPartnerLinkType_Role(),
				this.getRole(),
				null,
				"role", null, 0, -1, PartnerLinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(
				roleEClass,
				Role.class,
				"Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(
				getRole_ID(),
				ecorePackage.getEString(),
				"ID", null, 0, 1, Role.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRole_Name(),
				ecorePackage.getEString(),
				"name", null, 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(
				getRole_PortType(),
				theEcorePackage.getEJavaObject(),
				"portType", null, 0, 1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //PartnerlinktypePackageImpl
