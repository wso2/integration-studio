/**
 * Copyright (c) 2011, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.wso2.developerstudio.bpel.humantask.model.impl;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.extensions.BPELExtensionRegistry;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.wst.wsdl.WSDLPackage;


import org.wso2.developerstudio.bpel.humantask.model.ModelFactory;
import org.wso2.developerstudio.bpel.humantask.model.ModelPackage;
import org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRN;
import org.wso2.developerstudio.bpel.humantask.model.PeopleActivityRT;
import org.wso2.developerstudio.bpel.humantask.model.RemoteNotification;
import org.wso2.developerstudio.bpel.humantask.model.RemoteTask;
import org.wso2.developerstudio.bpel.humantask.model.util.HTConstants;
import org.wso2.developerstudio.bpel.humantask.model.util.HTDeserializer;
import org.wso2.developerstudio.bpel.humantask.model.util.HTSerializer;
import org.wso2.developerstudio.bpel.humantask.record.RecordPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass peopleActivityRTEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass peopleActivityRNEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass remoteTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass remoteNotificationEClass = null;

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
	 * @see org.wso2.developerstudio.bpel.humantask.model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated NOT
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		RecordPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theModelPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
		
		registerSerializerAndDeserializer();
		return theModelPackage;
	}

	
	private static void registerSerializerAndDeserializer() {
		
		// Initialize BPEL extension registry
		BPELExtensionRegistry extensionRegistry = BPELExtensionRegistry.getInstance();

		// Initialize our own serializers and deserializers
		HTDeserializer htDeserilizer = new HTDeserializer();
		HTSerializer htSerializer = new HTSerializer();
		
		//People Activity - Remote Task
		String name = PeopleActivityRT.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				HTConstants.ND_PEOPLE_ACTIVITY_RT), htDeserilizer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				htSerializer);
		
		//People Activity - Remote Notification
		name =  PeopleActivityRN.class.getSimpleName();
		extensionRegistry.registerActivityDeserializer(new QName(ModelPackage.eNS_URI,
				HTConstants.ND_PEOPLE_ACTIVITY_RN), htDeserilizer);
		extensionRegistry.registerActivitySerializer(new QName(ModelPackage.eNS_URI, name),
				htSerializer);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPeopleActivityRT() {
		return peopleActivityRTEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeopleActivityRT_InputVariable() {
		return (EReference)peopleActivityRTEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeopleActivityRT_OutputVariable() {
		return (EReference)peopleActivityRTEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeopleActivityRT_IsSkipable() {
		return (EAttribute)peopleActivityRTEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPeopleActivityRT_DontShareComments() {
		return (EAttribute)peopleActivityRTEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeopleActivityRT_RemoteTask() {
		return (EReference)peopleActivityRTEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPeopleActivityRN() {
		return peopleActivityRNEClass;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeopleActivityRN_InputVariable() {
		return (EReference)peopleActivityRNEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPeopleActivityRN_RemoteNotification() {
		return (EReference)peopleActivityRNEClass.getEStructuralFeatures().get(1);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoteTask() {
		return remoteTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoteTask_PartnerLink() {
		return (EReference)remoteTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoteTask_Operation() {
		return (EReference)remoteTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoteTask_ResponseOperation() {
		return (EReference)remoteTaskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoteNotification() {
		return remoteNotificationEClass;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoteNotification_PartnerLink() {
		return (EReference)remoteNotificationEClass.getEStructuralFeatures().get(0);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoteNotification_Operation() {
		return (EReference)remoteNotificationEClass.getEStructuralFeatures().get(1);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
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
		peopleActivityRTEClass = createEClass(PEOPLE_ACTIVITY_RT);
		createEReference(peopleActivityRTEClass, PEOPLE_ACTIVITY_RT__INPUT_VARIABLE);
		createEReference(peopleActivityRTEClass, PEOPLE_ACTIVITY_RT__OUTPUT_VARIABLE);
		createEAttribute(peopleActivityRTEClass, PEOPLE_ACTIVITY_RT__IS_SKIPABLE);
		createEAttribute(peopleActivityRTEClass, PEOPLE_ACTIVITY_RT__DONT_SHARE_COMMENTS);
		createEReference(peopleActivityRTEClass, PEOPLE_ACTIVITY_RT__REMOTE_TASK);

		peopleActivityRNEClass = createEClass(PEOPLE_ACTIVITY_RN);
		createEReference(peopleActivityRNEClass, PEOPLE_ACTIVITY_RN__INPUT_VARIABLE);
		createEReference(peopleActivityRNEClass, PEOPLE_ACTIVITY_RN__REMOTE_NOTIFICATION);

		remoteTaskEClass = createEClass(REMOTE_TASK);
		createEReference(remoteTaskEClass, REMOTE_TASK__PARTNER_LINK);
		createEReference(remoteTaskEClass, REMOTE_TASK__OPERATION);
		createEReference(remoteTaskEClass, REMOTE_TASK__RESPONSE_OPERATION);

		remoteNotificationEClass = createEClass(REMOTE_NOTIFICATION);
		createEReference(remoteNotificationEClass, REMOTE_NOTIFICATION__PARTNER_LINK);
		createEReference(remoteNotificationEClass, REMOTE_NOTIFICATION__OPERATION);
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
		BPELPackage theBPELPackage = (BPELPackage)EPackage.Registry.INSTANCE.getEPackage(BPELPackage.eNS_URI);
		RecordPackage theRecordPackage = (RecordPackage)EPackage.Registry.INSTANCE.getEPackage(RecordPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		WSDLPackage theWSDLPackage = (WSDLPackage)EPackage.Registry.INSTANCE.getEPackage(WSDLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		peopleActivityRTEClass.getESuperTypes().add(theBPELPackage.getExtensionActivity());
		peopleActivityRTEClass.getESuperTypes().add(theRecordPackage.getExtensionElement());
		peopleActivityRNEClass.getESuperTypes().add(theBPELPackage.getExtensionActivity());
		peopleActivityRNEClass.getESuperTypes().add(theRecordPackage.getExtensionElement());
		remoteTaskEClass.getESuperTypes().add(theRecordPackage.getExtensionElement());
		remoteNotificationEClass.getESuperTypes().add(theRecordPackage.getExtensionElement());

		// Initialize classes and features; add operations and parameters
		initEClass(peopleActivityRTEClass, PeopleActivityRT.class, "PeopleActivityRT", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPeopleActivityRT_InputVariable(), theBPELPackage.getVariable(), null, "inputVariable", null, 0, 1, PeopleActivityRT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPeopleActivityRT_OutputVariable(), theBPELPackage.getVariable(), null, "outputVariable", null, 0, 1, PeopleActivityRT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPeopleActivityRT_IsSkipable(), theEcorePackage.getEBoolean(), "isSkipable", null, 0, 1, PeopleActivityRT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPeopleActivityRT_DontShareComments(), theEcorePackage.getEBoolean(), "dontShareComments", null, 0, 1, PeopleActivityRT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPeopleActivityRT_RemoteTask(), this.getRemoteTask(), null, "remoteTask", null, 1, 1, PeopleActivityRT.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(peopleActivityRNEClass, PeopleActivityRN.class, "PeopleActivityRN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPeopleActivityRN_InputVariable(), theBPELPackage.getVariable(), null, "inputVariable", null, 0, 1, PeopleActivityRN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPeopleActivityRN_RemoteNotification(), this.getRemoteNotification(), null, "remoteNotification", null, 1, 1, PeopleActivityRN.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(remoteTaskEClass, RemoteTask.class, "RemoteTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoteTask_PartnerLink(), theBPELPackage.getPartnerLink(), null, "partnerLink", null, 0, 1, RemoteTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemoteTask_Operation(), theWSDLPackage.getOperation(), null, "operation", null, 0, 1, RemoteTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemoteTask_ResponseOperation(), theWSDLPackage.getOperation(), null, "responseOperation", null, 0, 1, RemoteTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(remoteNotificationEClass, RemoteNotification.class, "RemoteNotification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoteNotification_PartnerLink(), theBPELPackage.getPartnerLink(), null, "partnerLink", null, 0, 1, RemoteNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemoteNotification_Operation(), theWSDLPackage.getOperation(), null, "operation", null, 0, 1, RemoteNotification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ModelPackageImpl
