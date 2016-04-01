/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 *******************************************************************************/

package org.eclipse.bpel.apache.ode.deploy.model.dd.impl;

import org.eclipse.bpel.apache.ode.deploy.model.dd.BindingType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot;
import org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.MexInterceptorsType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.PropertyType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TBamServerProfiles;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TDeployment;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TEnableEventList;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TMexInterceptor;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TProfile;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TScopeEvents;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TService;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddFactory;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.messageproperties.MessagepropertiesPackage;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.wst.wsdl.WSDLPackage;
import org.eclipse.xsd.XSDPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ddPackageImpl extends EPackageImpl implements ddPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mexInterceptorsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tDeploymentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tEnableEventListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tMexInterceptorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tProcessEventsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tProvideEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tScopeEventsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tBamServerProfilesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tProfileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tEndPointEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum generateTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType generateTypeObjectEDataType = null;

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
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ddPackageImpl() {
		super(eNS_URI, ddFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ddPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ddPackage init() {
		if (isInited) return (ddPackage)EPackage.Registry.INSTANCE.getEPackage(ddPackage.eNS_URI);

		// Obtain or create and register package
		ddPackageImpl theddPackage = (ddPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ddPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ddPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BPELPackage.eINSTANCE.eClass();
		PartnerlinktypePackage.eINSTANCE.eClass();
		MessagepropertiesPackage.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theddPackage.createPackageContents();

		// Initialize created meta-data
		theddPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theddPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ddPackage.eNS_URI, theddPackage);
		return theddPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingType() {
		return bindingTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingType_Name() {
		return (EAttribute)bindingTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_Deploy() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMexInterceptorsType() {
		return mexInterceptorsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMexInterceptorsType_MexInterceptor() {
		return (EReference)mexInterceptorsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessType() {
		return processTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessType_Active() {
		return (EAttribute)processTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessType_Retired() {
		return (EAttribute)processTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessType_InMemory() {
		return (EAttribute)processTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_Property() {
		return (EReference)processTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_ProcessEvents() {
		return (EReference)processTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_Provide() {
		return (EReference)processTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_Invoke() {
		return (EReference)processTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_MexInterceptors() {
		return (EReference)processTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessType_Type() {
		return (EAttribute)processTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessType_Bpel11wsdlFileName() {
		return (EAttribute)processTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessType_FileName() {
		return (EAttribute)processTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessType_Name() {
		return (EAttribute)processTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_Model() {
		return (EReference)processTypeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessType_BamServerProfiles() {
		return (EReference)processTypeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyType() {
		return propertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyType_Any() {
		return (EAttribute)propertyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyType_Name() {
		return (EAttribute)propertyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTDeployment() {
		return tDeploymentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTDeployment_Process() {
		return (EReference)tDeploymentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTEnableEventList() {
		return tEnableEventListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTEnableEventList_EnableEvent() {
		return (EAttribute)tEnableEventListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTInvoke() {
		return tInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInvoke_Service() {
		return (EReference)tInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTInvoke_Binding() {
		return (EReference)tInvokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTInvoke_PartnerLink() {
		return (EAttribute)tInvokeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTMexInterceptor() {
		return tMexInterceptorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTMexInterceptor_ClassName() {
		return (EAttribute)tMexInterceptorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTProcessEvents() {
		return tProcessEventsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProcessEvents_ScopeEvents() {
		return (EReference)tProcessEventsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProcessEvents_Generate() {
		return (EAttribute)tProcessEventsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTProvide() {
		return tProvideEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTProvide_Service() {
		return (EReference)tProvideEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProvide_PartnerLink() {
		return (EAttribute)tProvideEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProvide_CorrelationFilter() {
		return (EAttribute)tProvideEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTScopeEvents() {
		return tScopeEventsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTScopeEvents_Name() {
		return (EAttribute)tScopeEventsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTService() {
		return tServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTService_Any() {
		return (EAttribute)tServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTService_Name() {
		return (EAttribute)tServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTService_Port() {
		return (EAttribute)tServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTService_Endpoint() {
		return (EReference)tServiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTBamServerProfiles() {
		return tBamServerProfilesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTBamServerProfiles_Profile() {
		return (EReference)tBamServerProfilesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTProfile() {
		return tProfileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProfile_Name() {
		return (EAttribute)tProfileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTProfile_Location() {
		return (EAttribute)tProfileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTEndPoint() {
		return tEndPointEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTEndPoint_Xmlns() {
		return (EAttribute)tEndPointEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTEndPoint_EndpointReference() {
		return (EAttribute)tEndPointEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTEndPoint_ServiceDescriptionReference() {
		return (EAttribute)tEndPointEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGenerateType() {
		return generateTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getGenerateTypeObject() {
		return generateTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ddFactory getddFactory() {
		return (ddFactory)getEFactoryInstance();
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
		bindingTypeEClass = createEClass(BINDING_TYPE);
		createEAttribute(bindingTypeEClass, BINDING_TYPE__NAME);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__DEPLOY);

		mexInterceptorsTypeEClass = createEClass(MEX_INTERCEPTORS_TYPE);
		createEReference(mexInterceptorsTypeEClass, MEX_INTERCEPTORS_TYPE__MEX_INTERCEPTOR);

		processTypeEClass = createEClass(PROCESS_TYPE);
		createEAttribute(processTypeEClass, PROCESS_TYPE__ACTIVE);
		createEAttribute(processTypeEClass, PROCESS_TYPE__RETIRED);
		createEAttribute(processTypeEClass, PROCESS_TYPE__IN_MEMORY);
		createEReference(processTypeEClass, PROCESS_TYPE__PROPERTY);
		createEReference(processTypeEClass, PROCESS_TYPE__PROCESS_EVENTS);
		createEReference(processTypeEClass, PROCESS_TYPE__PROVIDE);
		createEReference(processTypeEClass, PROCESS_TYPE__INVOKE);
		createEReference(processTypeEClass, PROCESS_TYPE__MEX_INTERCEPTORS);
		createEAttribute(processTypeEClass, PROCESS_TYPE__TYPE);
		createEAttribute(processTypeEClass, PROCESS_TYPE__BPEL11WSDL_FILE_NAME);
		createEAttribute(processTypeEClass, PROCESS_TYPE__FILE_NAME);
		createEAttribute(processTypeEClass, PROCESS_TYPE__NAME);
		createEReference(processTypeEClass, PROCESS_TYPE__MODEL);
		createEReference(processTypeEClass, PROCESS_TYPE__BAM_SERVER_PROFILES);

		propertyTypeEClass = createEClass(PROPERTY_TYPE);
		createEAttribute(propertyTypeEClass, PROPERTY_TYPE__ANY);
		createEAttribute(propertyTypeEClass, PROPERTY_TYPE__NAME);

		tDeploymentEClass = createEClass(TDEPLOYMENT);
		createEReference(tDeploymentEClass, TDEPLOYMENT__PROCESS);

		tEnableEventListEClass = createEClass(TENABLE_EVENT_LIST);
		createEAttribute(tEnableEventListEClass, TENABLE_EVENT_LIST__ENABLE_EVENT);

		tInvokeEClass = createEClass(TINVOKE);
		createEReference(tInvokeEClass, TINVOKE__SERVICE);
		createEReference(tInvokeEClass, TINVOKE__BINDING);
		createEAttribute(tInvokeEClass, TINVOKE__PARTNER_LINK);

		tMexInterceptorEClass = createEClass(TMEX_INTERCEPTOR);
		createEAttribute(tMexInterceptorEClass, TMEX_INTERCEPTOR__CLASS_NAME);

		tProcessEventsEClass = createEClass(TPROCESS_EVENTS);
		createEReference(tProcessEventsEClass, TPROCESS_EVENTS__SCOPE_EVENTS);
		createEAttribute(tProcessEventsEClass, TPROCESS_EVENTS__GENERATE);

		tProvideEClass = createEClass(TPROVIDE);
		createEReference(tProvideEClass, TPROVIDE__SERVICE);
		createEAttribute(tProvideEClass, TPROVIDE__PARTNER_LINK);
		createEAttribute(tProvideEClass, TPROVIDE__CORRELATION_FILTER);

		tScopeEventsEClass = createEClass(TSCOPE_EVENTS);
		createEAttribute(tScopeEventsEClass, TSCOPE_EVENTS__NAME);

		tServiceEClass = createEClass(TSERVICE);
		createEAttribute(tServiceEClass, TSERVICE__ANY);
		createEAttribute(tServiceEClass, TSERVICE__NAME);
		createEAttribute(tServiceEClass, TSERVICE__PORT);
		createEReference(tServiceEClass, TSERVICE__ENDPOINT);

		tBamServerProfilesEClass = createEClass(TBAM_SERVER_PROFILES);
		createEReference(tBamServerProfilesEClass, TBAM_SERVER_PROFILES__PROFILE);

		tProfileEClass = createEClass(TPROFILE);
		createEAttribute(tProfileEClass, TPROFILE__NAME);
		createEAttribute(tProfileEClass, TPROFILE__LOCATION);

		tEndPointEClass = createEClass(TEND_POINT);
		createEAttribute(tEndPointEClass, TEND_POINT__XMLNS);
		createEAttribute(tEndPointEClass, TEND_POINT__ENDPOINT_REFERENCE);
		createEAttribute(tEndPointEClass, TEND_POINT__SERVICE_DESCRIPTION_REFERENCE);

		// Create enums
		generateTypeEEnum = createEEnum(GENERATE_TYPE);

		// Create data types
		generateTypeObjectEDataType = createEDataType(GENERATE_TYPE_OBJECT);
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
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		BPELPackage theBPELPackage = (BPELPackage)EPackage.Registry.INSTANCE.getEPackage(BPELPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		tProcessEventsEClass.getESuperTypes().add(this.getTEnableEventList());
		tScopeEventsEClass.getESuperTypes().add(this.getTEnableEventList());

		// Initialize classes and features; add operations and parameters
		initEClass(bindingTypeEClass, BindingType.class, "BindingType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindingType_Name(), theXMLTypePackage.getQName(), "name", null, 1, 1, BindingType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Deploy(), this.getTDeployment(), null, "deploy", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(mexInterceptorsTypeEClass, MexInterceptorsType.class, "MexInterceptorsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMexInterceptorsType_MexInterceptor(), this.getTMexInterceptor(), null, "mexInterceptor", null, 0, -1, MexInterceptorsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processTypeEClass, ProcessType.class, "ProcessType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcessType_Active(), theXMLTypePackage.getBoolean(), "active", "true", 0, 1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessType_Retired(), theXMLTypePackage.getBoolean(), "retired", "false", 0, 1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessType_InMemory(), theXMLTypePackage.getBoolean(), "inMemory", "false", 0, 1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessType_Property(), this.getPropertyType(), null, "property", null, 0, -1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessType_ProcessEvents(), this.getTProcessEvents(), null, "processEvents", null, 0, 1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessType_Provide(), this.getTProvide(), null, "provide", null, 0, -1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessType_Invoke(), this.getTInvoke(), null, "invoke", null, 0, -1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessType_MexInterceptors(), this.getMexInterceptorsType(), null, "mexInterceptors", null, 0, 1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessType_Type(), theXMLTypePackage.getQName(), "type", null, 0, 1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessType_Bpel11wsdlFileName(), theXMLTypePackage.getString(), "bpel11wsdlFileName", null, 0, 1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessType_FileName(), theXMLTypePackage.getString(), "fileName", null, 0, 1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessType_Name(), theXMLTypePackage.getQName(), "name", null, 1, 1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessType_Model(), theBPELPackage.getProcess(), null, "model", null, 0, 1, ProcessType.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessType_BamServerProfiles(), this.getTBamServerProfiles(), null, "bamServerProfiles", null, 0, 1, ProcessType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyTypeEClass, PropertyType.class, "PropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyType_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyType_Name(), theXMLTypePackage.getQName(), "name", null, 1, 1, PropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tDeploymentEClass, TDeployment.class, "TDeployment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTDeployment_Process(), this.getProcessType(), null, "process", null, 0, -1, TDeployment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tEnableEventListEClass, TEnableEventList.class, "TEnableEventList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTEnableEventList_EnableEvent(), theXMLTypePackage.getString(), "enableEvent", null, 1, -1, TEnableEventList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tInvokeEClass, TInvoke.class, "TInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTInvoke_Service(), this.getTService(), null, "service", null, 0, 1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTInvoke_Binding(), this.getBindingType(), null, "binding", null, 0, 1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTInvoke_PartnerLink(), theXMLTypePackage.getString(), "partnerLink", null, 1, 1, TInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tMexInterceptorEClass, TMexInterceptor.class, "TMexInterceptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTMexInterceptor_ClassName(), theXMLTypePackage.getString(), "className", null, 1, 1, TMexInterceptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tProcessEventsEClass, TProcessEvents.class, "TProcessEvents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTProcessEvents_ScopeEvents(), this.getTScopeEvents(), null, "scopeEvents", null, 1, -1, TProcessEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTProcessEvents_Generate(), this.getGenerateType(), "generate", "all", 0, 1, TProcessEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tProvideEClass, TProvide.class, "TProvide", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTProvide_Service(), this.getTService(), null, "service", null, 1, 1, TProvide.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTProvide_PartnerLink(), theXMLTypePackage.getString(), "partnerLink", null, 1, 1, TProvide.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTProvide_CorrelationFilter(), theXMLTypePackage.getString(), "correlationFilter", null, 0, 1, TProvide.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tScopeEventsEClass, TScopeEvents.class, "TScopeEvents", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTScopeEvents_Name(), theXMLTypePackage.getString(), "name", null, 1, 1, TScopeEvents.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tServiceEClass, TService.class, "TService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTService_Any(), ecorePackage.getEFeatureMapEntry(), "any", null, 0, -1, TService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTService_Name(), theXMLTypePackage.getQName(), "name", null, 1, 1, TService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTService_Port(), theXMLTypePackage.getNCName(), "port", null, 1, 1, TService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTService_Endpoint(), this.getTEndPoint(), null, "endpoint", null, 0, 1, TService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tBamServerProfilesEClass, TBamServerProfiles.class, "TBamServerProfiles", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTBamServerProfiles_Profile(), this.getTProfile(), null, "profile", null, 0, 1, TBamServerProfiles.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tProfileEClass, TProfile.class, "TProfile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTProfile_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, TProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTProfile_Location(), theXMLTypePackage.getString(), "location", null, 0, 1, TProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tEndPointEClass, TEndPoint.class, "TEndPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTEndPoint_Xmlns(), theXMLTypePackage.getString(), "xmlns", null, 0, 1, TEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTEndPoint_EndpointReference(), theXMLTypePackage.getString(), "endpointReference", null, 0, 1, TEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTEndPoint_ServiceDescriptionReference(), theXMLTypePackage.getString(), "serviceDescriptionReference", null, 0, 1, TEndPoint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(generateTypeEEnum, GenerateType.class, "GenerateType");
		addEEnumLiteral(generateTypeEEnum, GenerateType.ALL);
		addEEnumLiteral(generateTypeEEnum, GenerateType.NONE);

		// Initialize data types
		initEDataType(generateTypeObjectEDataType, GenerateType.class, "GenerateTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (bindingTypeEClass, 
		   source, 
		   new String[] {
			 "name", "binding_._type",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getBindingType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_Deploy(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "deploy",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (generateTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "generate_._type"
		   });		
		addAnnotation
		  (generateTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "generate_._type:Object",
			 "baseType", "generate_._type"
		   });		
		addAnnotation
		  (mexInterceptorsTypeEClass, 
		   source, 
		   new String[] {
			 "name", "mex-interceptors_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMexInterceptorsType_MexInterceptor(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "mex-interceptor",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (processTypeEClass, 
		   source, 
		   new String[] {
			 "name", "process_._type",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getProcessType_Active(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "active",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getProcessType_Retired(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "retired",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getProcessType_InMemory(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "in-memory",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getProcessType_Property(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "property",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getProcessType_ProcessEvents(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "process-events",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getProcessType_Provide(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "provide",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getProcessType_Invoke(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "invoke",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getProcessType_MexInterceptors(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "mex-interceptors",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getProcessType_Type(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });			
		addAnnotation
		  (getProcessType_Bpel11wsdlFileName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "bpel11wsdlFileName"
		   });		
		addAnnotation
		  (getProcessType_FileName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "fileName"
		   });		
		addAnnotation
		  (getProcessType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getProcessType_BamServerProfiles(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "bamServerProfiles",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (propertyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "property_._type",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPropertyType_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":0",
			 "processing", "lax"
		   });		
		addAnnotation
		  (getPropertyType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tDeploymentEClass, 
		   source, 
		   new String[] {
			 "name", "tDeployment",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTDeployment_Process(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "process",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tEnableEventListEClass, 
		   source, 
		   new String[] {
			 "name", "tEnableEventList",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTEnableEventList_EnableEvent(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "enable-event",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tInvokeEClass, 
		   source, 
		   new String[] {
			 "name", "tInvoke",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTInvoke_Service(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "service",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTInvoke_Binding(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "binding",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTInvoke_PartnerLink(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "partnerLink"
		   });			
		addAnnotation
		  (tMexInterceptorEClass, 
		   source, 
		   new String[] {
			 "name", "tMexInterceptor",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTMexInterceptor_ClassName(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "class-name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tProcessEventsEClass, 
		   source, 
		   new String[] {
			 "name", "tProcessEvents",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTProcessEvents_ScopeEvents(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "scope-events",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProcessEvents_Generate(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "generate"
		   });		
		addAnnotation
		  (tProvideEClass, 
		   source, 
		   new String[] {
			 "name", "tProvide",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTProvide_Service(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "service",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getTProvide_PartnerLink(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "partnerLink"
		   });		
		addAnnotation
		  (tScopeEventsEClass, 
		   source, 
		   new String[] {
			 "name", "tScopeEvents",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTScopeEvents_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (tServiceEClass, 
		   source, 
		   new String[] {
			 "name", "tService",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTService_Any(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "wildcards", "##other",
			 "name", ":0",
			 "processing", "lax"
		   });		
		addAnnotation
		  (getTService_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTService_Port(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "port"
		   });		
		addAnnotation
		  (getTService_Endpoint(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "endpoint",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tBamServerProfilesEClass, 
		   source, 
		   new String[] {
			 "name", "tBamServerProfiles",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTBamServerProfiles_Profile(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "profile",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (tProfileEClass, 
		   source, 
		   new String[] {
			 "name", "tProfile",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTProfile_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name"
		   });		
		addAnnotation
		  (getTProfile_Location(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "location"
		   });		
		addAnnotation
		  (tEndPointEClass, 
		   source, 
		   new String[] {
			 "name", "tEndPoint",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getTEndPoint_Xmlns(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns"
		   });		
		addAnnotation
		  (getTEndPoint_EndpointReference(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "endpointReference"
		   });		
		addAnnotation
		  (getTEndPoint_ServiceDescriptionReference(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "serviceDescriptionReference"
		   });
	}

} //ddPackageImpl
