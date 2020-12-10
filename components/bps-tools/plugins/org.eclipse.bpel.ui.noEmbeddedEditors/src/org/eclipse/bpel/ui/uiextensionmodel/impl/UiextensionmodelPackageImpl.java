/**
 * <copyright>
 * Copyright (c) 2005, 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: UiextensionmodelPackageImpl.java,v 1.3 2008/05/04 11:05:28 odanilov Exp $
 */
package org.eclipse.bpel.ui.uiextensionmodel.impl;

import org.eclipse.bpel.ui.uiextensionmodel.ActivityExtension;
import org.eclipse.bpel.ui.uiextensionmodel.CaseExtension;
import org.eclipse.bpel.ui.uiextensionmodel.CopyExtension;
import org.eclipse.bpel.ui.uiextensionmodel.EndNode;
import org.eclipse.bpel.ui.uiextensionmodel.LinkExtension;
import org.eclipse.bpel.ui.uiextensionmodel.OnAlarmExtension;
import org.eclipse.bpel.ui.uiextensionmodel.OnEventExtension;
import org.eclipse.bpel.ui.uiextensionmodel.OnMessageExtension;
import org.eclipse.bpel.ui.uiextensionmodel.PartnerLinkExtension;
import org.eclipse.bpel.ui.uiextensionmodel.ProcessExtension;
import org.eclipse.bpel.ui.uiextensionmodel.ReferencePartnerLinks;
import org.eclipse.bpel.ui.uiextensionmodel.StartNode;
import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelFactory;
import org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelPackage;
import org.eclipse.bpel.ui.uiextensionmodel.VariableExtension;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.namespace.XMLNamespacePackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UiextensionmodelPackageImpl extends EPackageImpl implements UiextensionmodelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass copyExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass onAlarmExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass onEventExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass onMessageExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partnerLinkExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referencePartnerLinksEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableExtensionEClass = null;

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
	 * @see org.eclipse.bpel.ui.uiextensionmodel.UiextensionmodelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UiextensionmodelPackageImpl() {
		super(eNS_URI, UiextensionmodelFactory.eINSTANCE);
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
	public static UiextensionmodelPackage init() {
		if (isInited) return (UiextensionmodelPackage)EPackage.Registry.INSTANCE.getEPackage(UiextensionmodelPackage.eNS_URI);

		// Obtain or create and register package
		UiextensionmodelPackageImpl theUiextensionmodelPackage = (UiextensionmodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof UiextensionmodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new UiextensionmodelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		XMLNamespacePackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUiextensionmodelPackage.createPackageContents();

		// Initialize created meta-data
		theUiextensionmodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUiextensionmodelPackage.freeze();

		return theUiextensionmodelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivityExtension() {
		return activityExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityExtension_X() {
		return (EAttribute)activityExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityExtension_Y() {
		return (EAttribute)activityExtensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityExtension_Width() {
		return (EAttribute)activityExtensionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityExtension_Height() {
		return (EAttribute)activityExtensionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivityExtension_Implicit() {
		return (EAttribute)activityExtensionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseExtension() {
		return caseExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCaseExtension_DisplayName() {
		return (EAttribute)caseExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCopyExtension() {
		return copyExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCopyExtension_FromType() {
		return (EAttribute)copyExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCopyExtension_ToType() {
		return (EAttribute)copyExtensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndNode() {
		return endNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkExtension() {
		return linkExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOnAlarmExtension() {
		return onAlarmExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOnAlarmExtension_DisplayName() {
		return (EAttribute)onAlarmExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOnEventExtension() {
		return onEventExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOnEventExtension_DisplayName() {
		return (EAttribute)onEventExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOnMessageExtension() {
		return onMessageExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOnMessageExtension_DisplayName() {
		return (EAttribute)onMessageExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPartnerLinkExtension() {
		return partnerLinkExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPartnerLinkExtension_PartnerKind() {
		return (EAttribute)partnerLinkExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessExtension() {
		return processExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessExtension_SpecCompliant() {
		return (EAttribute)processExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessExtension_ModificationStamp() {
		return (EAttribute)processExtensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferencePartnerLinks() {
		return referencePartnerLinksEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartNode() {
		return startNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableExtension() {
		return variableExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableExtension_AdvancedKind() {
		return (EAttribute)variableExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableExtension_VariableKind() {
		return (EAttribute)variableExtensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiextensionmodelFactory getUiextensionmodelFactory() {
		return (UiextensionmodelFactory)getEFactoryInstance();
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
		activityExtensionEClass = createEClass(ACTIVITY_EXTENSION);
		createEAttribute(activityExtensionEClass, ACTIVITY_EXTENSION__X);
		createEAttribute(activityExtensionEClass, ACTIVITY_EXTENSION__Y);
		createEAttribute(activityExtensionEClass, ACTIVITY_EXTENSION__WIDTH);
		createEAttribute(activityExtensionEClass, ACTIVITY_EXTENSION__HEIGHT);
		createEAttribute(activityExtensionEClass, ACTIVITY_EXTENSION__IMPLICIT);

		caseExtensionEClass = createEClass(CASE_EXTENSION);
		createEAttribute(caseExtensionEClass, CASE_EXTENSION__DISPLAY_NAME);

		copyExtensionEClass = createEClass(COPY_EXTENSION);
		createEAttribute(copyExtensionEClass, COPY_EXTENSION__FROM_TYPE);
		createEAttribute(copyExtensionEClass, COPY_EXTENSION__TO_TYPE);

		endNodeEClass = createEClass(END_NODE);

		linkExtensionEClass = createEClass(LINK_EXTENSION);

		onAlarmExtensionEClass = createEClass(ON_ALARM_EXTENSION);
		createEAttribute(onAlarmExtensionEClass, ON_ALARM_EXTENSION__DISPLAY_NAME);

		onEventExtensionEClass = createEClass(ON_EVENT_EXTENSION);
		createEAttribute(onEventExtensionEClass, ON_EVENT_EXTENSION__DISPLAY_NAME);

		onMessageExtensionEClass = createEClass(ON_MESSAGE_EXTENSION);
		createEAttribute(onMessageExtensionEClass, ON_MESSAGE_EXTENSION__DISPLAY_NAME);

		partnerLinkExtensionEClass = createEClass(PARTNER_LINK_EXTENSION);
		createEAttribute(partnerLinkExtensionEClass, PARTNER_LINK_EXTENSION__PARTNER_KIND);

		processExtensionEClass = createEClass(PROCESS_EXTENSION);
		createEAttribute(processExtensionEClass, PROCESS_EXTENSION__SPEC_COMPLIANT);
		createEAttribute(processExtensionEClass, PROCESS_EXTENSION__MODIFICATION_STAMP);

		referencePartnerLinksEClass = createEClass(REFERENCE_PARTNER_LINKS);

		startNodeEClass = createEClass(START_NODE);

		variableExtensionEClass = createEClass(VARIABLE_EXTENSION);
		createEAttribute(variableExtensionEClass, VARIABLE_EXTENSION__ADVANCED_KIND);
		createEAttribute(variableExtensionEClass, VARIABLE_EXTENSION__VARIABLE_KIND);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(activityExtensionEClass, ActivityExtension.class, "ActivityExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActivityExtension_X(), ecorePackage.getEInt(), "x", null, 0, 1, ActivityExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityExtension_Y(), ecorePackage.getEInt(), "y", null, 0, 1, ActivityExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityExtension_Width(), ecorePackage.getEInt(), "width", null, 0, 1, ActivityExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityExtension_Height(), ecorePackage.getEInt(), "height", null, 0, 1, ActivityExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivityExtension_Implicit(), ecorePackage.getEBoolean(), "implicit", null, 0, 1, ActivityExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseExtensionEClass, CaseExtension.class, "CaseExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCaseExtension_DisplayName(), ecorePackage.getEString(), "displayName", null, 0, 1, CaseExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(copyExtensionEClass, CopyExtension.class, "CopyExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCopyExtension_FromType(), ecorePackage.getEInt(), "fromType", null, 0, 1, CopyExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCopyExtension_ToType(), ecorePackage.getEInt(), "toType", null, 0, 1, CopyExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endNodeEClass, EndNode.class, "EndNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(linkExtensionEClass, LinkExtension.class, "LinkExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(onAlarmExtensionEClass, OnAlarmExtension.class, "OnAlarmExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOnAlarmExtension_DisplayName(), ecorePackage.getEString(), "displayName", null, 0, 1, OnAlarmExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(onEventExtensionEClass, OnEventExtension.class, "OnEventExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOnEventExtension_DisplayName(), ecorePackage.getEString(), "displayName", null, 0, 1, OnEventExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(onMessageExtensionEClass, OnMessageExtension.class, "OnMessageExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOnMessageExtension_DisplayName(), ecorePackage.getEString(), "displayName", null, 0, 1, OnMessageExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partnerLinkExtensionEClass, PartnerLinkExtension.class, "PartnerLinkExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPartnerLinkExtension_PartnerKind(), ecorePackage.getEInt(), "partnerKind", null, 0, 1, PartnerLinkExtension.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processExtensionEClass, ProcessExtension.class, "ProcessExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcessExtension_SpecCompliant(), ecorePackage.getEBoolean(), "specCompliant", null, 0, 1, ProcessExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessExtension_ModificationStamp(), ecorePackage.getELong(), "modificationStamp", null, 0, 1, ProcessExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referencePartnerLinksEClass, ReferencePartnerLinks.class, "ReferencePartnerLinks", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(startNodeEClass, StartNode.class, "StartNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableExtensionEClass, VariableExtension.class, "VariableExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableExtension_AdvancedKind(), ecorePackage.getEInt(), "advancedKind", null, 0, 1, VariableExtension.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariableExtension_VariableKind(), ecorePackage.getEInt(), "variableKind", null, 0, 1, VariableExtension.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UiextensionmodelPackageImpl
