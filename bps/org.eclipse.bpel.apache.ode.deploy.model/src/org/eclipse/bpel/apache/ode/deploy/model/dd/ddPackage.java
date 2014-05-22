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

package org.eclipse.bpel.apache.ode.deploy.model.dd;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddFactory
 * @model kind="package"
 * @generated
 */
public interface ddPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dd";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.apache.org/ode/schemas/dd/2007/03";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ddPackage eINSTANCE = org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.BindingTypeImpl <em>Binding Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.BindingTypeImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getBindingType()
	 * @generated
	 */
	int BINDING_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_TYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Binding Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.DocumentRootImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Deploy</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DEPLOY = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.MexInterceptorsTypeImpl <em>Mex Interceptors Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.MexInterceptorsTypeImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getMexInterceptorsType()
	 * @generated
	 */
	int MEX_INTERCEPTORS_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Mex Interceptor</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEX_INTERCEPTORS_TYPE__MEX_INTERCEPTOR = 0;

	/**
	 * The number of structural features of the '<em>Mex Interceptors Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEX_INTERCEPTORS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl <em>Process Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getProcessType()
	 * @generated
	 */
	int PROCESS_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__ACTIVE = 0;

	/**
	 * The feature id for the '<em><b>Retired</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__RETIRED = 1;

	/**
	 * The feature id for the '<em><b>In Memory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__IN_MEMORY = 2;

	/**
	 * The feature id for the '<em><b>Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Process Events</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__PROCESS_EVENTS = 4;

	/**
	 * The feature id for the '<em><b>Provide</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__PROVIDE = 5;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__INVOKE = 6;

	/**
	 * The feature id for the '<em><b>Mex Interceptors</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__MEX_INTERCEPTORS = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__TYPE = 8;

	/**
	 * The feature id for the '<em><b>Bpel11wsdl File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__BPEL11WSDL_FILE_NAME = 9;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__FILE_NAME = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__NAME = 11;

	/**
	 * The feature id for the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__MODEL = 12;

	/**
	 * The feature id for the '<em><b>Bam Server Profiles</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE__BAM_SERVER_PROFILES = 13;

	/**
	 * The number of structural features of the '<em>Process Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_TYPE_FEATURE_COUNT = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.PropertyTypeImpl <em>Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.PropertyTypeImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getPropertyType()
	 * @generated
	 */
	int PROPERTY_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__ANY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TDeploymentImpl <em>TDeployment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TDeploymentImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTDeployment()
	 * @generated
	 */
	int TDEPLOYMENT = 5;

	/**
	 * The feature id for the '<em><b>Process</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEPLOYMENT__PROCESS = 0;

	/**
	 * The number of structural features of the '<em>TDeployment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEPLOYMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEnableEventListImpl <em>TEnable Event List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEnableEventListImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTEnableEventList()
	 * @generated
	 */
	int TENABLE_EVENT_LIST = 6;

	/**
	 * The feature id for the '<em><b>Enable Event</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENABLE_EVENT_LIST__ENABLE_EVENT = 0;

	/**
	 * The number of structural features of the '<em>TEnable Event List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TENABLE_EVENT_LIST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TInvokeImpl <em>TInvoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TInvokeImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTInvoke()
	 * @generated
	 */
	int TINVOKE = 7;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__SERVICE = 0;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__BINDING = 1;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__PARTNER_LINK = 2;

	/**
	 * The number of structural features of the '<em>TInvoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TMexInterceptorImpl <em>TMex Interceptor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TMexInterceptorImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTMexInterceptor()
	 * @generated
	 */
	int TMEX_INTERCEPTOR = 8;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEX_INTERCEPTOR__CLASS_NAME = 0;

	/**
	 * The number of structural features of the '<em>TMex Interceptor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMEX_INTERCEPTOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProcessEventsImpl <em>TProcess Events</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProcessEventsImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTProcessEvents()
	 * @generated
	 */
	int TPROCESS_EVENTS = 9;

	/**
	 * The feature id for the '<em><b>Enable Event</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS_EVENTS__ENABLE_EVENT = TENABLE_EVENT_LIST__ENABLE_EVENT;

	/**
	 * The feature id for the '<em><b>Scope Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS_EVENTS__SCOPE_EVENTS = TENABLE_EVENT_LIST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Generate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS_EVENTS__GENERATE = TENABLE_EVENT_LIST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TProcess Events</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS_EVENTS_FEATURE_COUNT = TENABLE_EVENT_LIST_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProvideImpl <em>TProvide</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProvideImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTProvide()
	 * @generated
	 */
	int TPROVIDE = 10;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROVIDE__SERVICE = 0;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROVIDE__PARTNER_LINK = 1;

	/**
	 * The feature id for the '<em><b>Correlation Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROVIDE__CORRELATION_FILTER = 2;

	/**
	 * The number of structural features of the '<em>TProvide</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROVIDE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TScopeEventsImpl <em>TScope Events</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TScopeEventsImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTScopeEvents()
	 * @generated
	 */
	int TSCOPE_EVENTS = 11;

	/**
	 * The feature id for the '<em><b>Enable Event</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE_EVENTS__ENABLE_EVENT = TENABLE_EVENT_LIST__ENABLE_EVENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE_EVENTS__NAME = TENABLE_EVENT_LIST_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TScope Events</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE_EVENTS_FEATURE_COUNT = TENABLE_EVENT_LIST_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TServiceImpl <em>TService</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TServiceImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTService()
	 * @generated
	 */
	int TSERVICE = 12;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSERVICE__ANY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSERVICE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSERVICE__PORT = 2;

	/**
	 * The feature id for the '<em><b>Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSERVICE__ENDPOINT = 3;

	/**
	 * The number of structural features of the '<em>TService</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSERVICE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TBamServerProfilesImpl <em>TBam Server Profiles</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TBamServerProfilesImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTBamServerProfiles()
	 * @generated
	 */
	int TBAM_SERVER_PROFILES = 13;

	/**
	 * The feature id for the '<em><b>Profile</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBAM_SERVER_PROFILES__PROFILE = 0;

	/**
	 * The number of structural features of the '<em>TBam Server Profiles</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBAM_SERVER_PROFILES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProfileImpl <em>TProfile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProfileImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTProfile()
	 * @generated
	 */
	int TPROFILE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROFILE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROFILE__LOCATION = 1;

	/**
	 * The number of structural features of the '<em>TProfile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROFILE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEndPointImpl <em>TEnd Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEndPointImpl
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTEndPoint()
	 * @generated
	 */
	int TEND_POINT = 15;

	/**
	 * The feature id for the '<em><b>Xmlns</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEND_POINT__XMLNS = 0;

	/**
	 * The feature id for the '<em><b>Endpoint Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEND_POINT__ENDPOINT_REFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Service Description Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEND_POINT__SERVICE_DESCRIPTION_REFERENCE = 2;

	/**
	 * The number of structural features of the '<em>TEnd Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEND_POINT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType <em>Generate Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getGenerateType()
	 * @generated
	 */
	int GENERATE_TYPE = 16;

	/**
	 * The meta object id for the '<em>Generate Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getGenerateTypeObject()
	 * @generated
	 */
	int GENERATE_TYPE_OBJECT = 17;


	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.BindingType <em>Binding Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Type</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.BindingType
	 * @generated
	 */
	EClass getBindingType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.BindingType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.BindingType#getName()
	 * @see #getBindingType()
	 * @generated
	 */
	EAttribute getBindingType_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot#getDeploy <em>Deploy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Deploy</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.DocumentRoot#getDeploy()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Deploy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.MexInterceptorsType <em>Mex Interceptors Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mex Interceptors Type</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.MexInterceptorsType
	 * @generated
	 */
	EClass getMexInterceptorsType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.MexInterceptorsType#getMexInterceptor <em>Mex Interceptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mex Interceptor</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.MexInterceptorsType#getMexInterceptor()
	 * @see #getMexInterceptorsType()
	 * @generated
	 */
	EReference getMexInterceptorsType_MexInterceptor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType <em>Process Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Type</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType
	 * @generated
	 */
	EClass getProcessType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isActive()
	 * @see #getProcessType()
	 * @generated
	 */
	EAttribute getProcessType_Active();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isRetired <em>Retired</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Retired</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isRetired()
	 * @see #getProcessType()
	 * @generated
	 */
	EAttribute getProcessType_Retired();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isInMemory <em>In Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>In Memory</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#isInMemory()
	 * @see #getProcessType()
	 * @generated
	 */
	EAttribute getProcessType_InMemory();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getProperty()
	 * @see #getProcessType()
	 * @generated
	 */
	EReference getProcessType_Property();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getProcessEvents <em>Process Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Process Events</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getProcessEvents()
	 * @see #getProcessType()
	 * @generated
	 */
	EReference getProcessType_ProcessEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getProvide <em>Provide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Provide</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getProvide()
	 * @see #getProcessType()
	 * @generated
	 */
	EReference getProcessType_Provide();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getInvoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invoke</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getInvoke()
	 * @see #getProcessType()
	 * @generated
	 */
	EReference getProcessType_Invoke();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getMexInterceptors <em>Mex Interceptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mex Interceptors</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getMexInterceptors()
	 * @see #getProcessType()
	 * @generated
	 */
	EReference getProcessType_MexInterceptors();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getType()
	 * @see #getProcessType()
	 * @generated
	 */
	EAttribute getProcessType_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getBpel11wsdlFileName <em>Bpel11wsdl File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bpel11wsdl File Name</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getBpel11wsdlFileName()
	 * @see #getProcessType()
	 * @generated
	 */
	EAttribute getProcessType_Bpel11wsdlFileName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getFileName()
	 * @see #getProcessType()
	 * @generated
	 */
	EAttribute getProcessType_FileName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getName()
	 * @see #getProcessType()
	 * @generated
	 */
	EAttribute getProcessType_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Model</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getModel()
	 * @see #getProcessType()
	 * @generated
	 */
	EReference getProcessType_Model();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getBamServerProfiles <em>Bam Server Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bam Server Profiles</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ProcessType#getBamServerProfiles()
	 * @see #getProcessType()
	 * @generated
	 */
	EReference getProcessType_BamServerProfiles();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.PropertyType <em>Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Type</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.PropertyType
	 * @generated
	 */
	EClass getPropertyType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.PropertyType#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.PropertyType#getAny()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Any();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.PropertyType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.PropertyType#getName()
	 * @see #getPropertyType()
	 * @generated
	 */
	EAttribute getPropertyType_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TDeployment <em>TDeployment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDeployment</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TDeployment
	 * @generated
	 */
	EClass getTDeployment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TDeployment#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Process</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TDeployment#getProcess()
	 * @see #getTDeployment()
	 * @generated
	 */
	EReference getTDeployment_Process();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEnableEventList <em>TEnable Event List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TEnable Event List</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TEnableEventList
	 * @generated
	 */
	EClass getTEnableEventList();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEnableEventList#getEnableEvent <em>Enable Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Enable Event</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TEnableEventList#getEnableEvent()
	 * @see #getTEnableEventList()
	 * @generated
	 */
	EAttribute getTEnableEventList_EnableEvent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke <em>TInvoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TInvoke</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke
	 * @generated
	 */
	EClass getTInvoke();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke#getService()
	 * @see #getTInvoke()
	 * @generated
	 */
	EReference getTInvoke_Service();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Binding</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke#getBinding()
	 * @see #getTInvoke()
	 * @generated
	 */
	EReference getTInvoke_Binding();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke#getPartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partner Link</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TInvoke#getPartnerLink()
	 * @see #getTInvoke()
	 * @generated
	 */
	EAttribute getTInvoke_PartnerLink();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TMexInterceptor <em>TMex Interceptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TMex Interceptor</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TMexInterceptor
	 * @generated
	 */
	EClass getTMexInterceptor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TMexInterceptor#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TMexInterceptor#getClassName()
	 * @see #getTMexInterceptor()
	 * @generated
	 */
	EAttribute getTMexInterceptor_ClassName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents <em>TProcess Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TProcess Events</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents
	 * @generated
	 */
	EClass getTProcessEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents#getScopeEvents <em>Scope Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scope Events</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents#getScopeEvents()
	 * @see #getTProcessEvents()
	 * @generated
	 */
	EReference getTProcessEvents_ScopeEvents();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents#getGenerate <em>Generate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generate</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TProcessEvents#getGenerate()
	 * @see #getTProcessEvents()
	 * @generated
	 */
	EAttribute getTProcessEvents_Generate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide <em>TProvide</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TProvide</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide
	 * @generated
	 */
	EClass getTProvide();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide#getService()
	 * @see #getTProvide()
	 * @generated
	 */
	EReference getTProvide_Service();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide#getPartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partner Link</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide#getPartnerLink()
	 * @see #getTProvide()
	 * @generated
	 */
	EAttribute getTProvide_PartnerLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide#getCorrelationFilter <em>Correlation Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Correlation Filter</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide#getCorrelationFilter()
	 * @see #getTProvide()
	 * @generated
	 */
	EAttribute getTProvide_CorrelationFilter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TScopeEvents <em>TScope Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TScope Events</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TScopeEvents
	 * @generated
	 */
	EClass getTScopeEvents();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TScopeEvents#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TScopeEvents#getName()
	 * @see #getTScopeEvents()
	 * @generated
	 */
	EAttribute getTScopeEvents_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TService <em>TService</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TService</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TService
	 * @generated
	 */
	EClass getTService();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TService#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TService#getAny()
	 * @see #getTService()
	 * @generated
	 */
	EAttribute getTService_Any();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TService#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TService#getName()
	 * @see #getTService()
	 * @generated
	 */
	EAttribute getTService_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TService#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TService#getPort()
	 * @see #getTService()
	 * @generated
	 */
	EAttribute getTService_Port();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TService#getEndpoint <em>Endpoint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Endpoint</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TService#getEndpoint()
	 * @see #getTService()
	 * @generated
	 */
	EReference getTService_Endpoint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TBamServerProfiles <em>TBam Server Profiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TBam Server Profiles</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TBamServerProfiles
	 * @generated
	 */
	EClass getTBamServerProfiles();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TBamServerProfiles#getProfile <em>Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Profile</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TBamServerProfiles#getProfile()
	 * @see #getTBamServerProfiles()
	 * @generated
	 */
	EReference getTBamServerProfiles_Profile();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProfile <em>TProfile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TProfile</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TProfile
	 * @generated
	 */
	EClass getTProfile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProfile#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TProfile#getName()
	 * @see #getTProfile()
	 * @generated
	 */
	EAttribute getTProfile_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TProfile#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TProfile#getLocation()
	 * @see #getTProfile()
	 * @generated
	 */
	EAttribute getTProfile_Location();

	/**
	 * Returns the meta object for class '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint <em>TEnd Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TEnd Point</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint
	 * @generated
	 */
	EClass getTEndPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getXmlns <em>Xmlns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xmlns</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getXmlns()
	 * @see #getTEndPoint()
	 * @generated
	 */
	EAttribute getTEndPoint_Xmlns();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getEndpointReference <em>Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Endpoint Reference</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getEndpointReference()
	 * @see #getTEndPoint()
	 * @generated
	 */
	EAttribute getTEndPoint_EndpointReference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getServiceDescriptionReference <em>Service Description Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Description Reference</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint#getServiceDescriptionReference()
	 * @see #getTEndPoint()
	 * @generated
	 */
	EAttribute getTEndPoint_ServiceDescriptionReference();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType <em>Generate Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Generate Type</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType
	 * @generated
	 */
	EEnum getGenerateType();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType <em>Generate Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Generate Type Object</em>'.
	 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType
	 * @model instanceClass="org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType"
	 *        extendedMetaData="name='generate_._type:Object' baseType='generate_._type'"
	 * @generated
	 */
	EDataType getGenerateTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ddFactory getddFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.BindingTypeImpl <em>Binding Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.BindingTypeImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getBindingType()
		 * @generated
		 */
		EClass BINDING_TYPE = eINSTANCE.getBindingType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_TYPE__NAME = eINSTANCE.getBindingType_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.DocumentRootImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Deploy</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DEPLOY = eINSTANCE.getDocumentRoot_Deploy();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.MexInterceptorsTypeImpl <em>Mex Interceptors Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.MexInterceptorsTypeImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getMexInterceptorsType()
		 * @generated
		 */
		EClass MEX_INTERCEPTORS_TYPE = eINSTANCE.getMexInterceptorsType();

		/**
		 * The meta object literal for the '<em><b>Mex Interceptor</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEX_INTERCEPTORS_TYPE__MEX_INTERCEPTOR = eINSTANCE.getMexInterceptorsType_MexInterceptor();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl <em>Process Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ProcessTypeImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getProcessType()
		 * @generated
		 */
		EClass PROCESS_TYPE = eINSTANCE.getProcessType();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_TYPE__ACTIVE = eINSTANCE.getProcessType_Active();

		/**
		 * The meta object literal for the '<em><b>Retired</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_TYPE__RETIRED = eINSTANCE.getProcessType_Retired();

		/**
		 * The meta object literal for the '<em><b>In Memory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_TYPE__IN_MEMORY = eINSTANCE.getProcessType_InMemory();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_TYPE__PROPERTY = eINSTANCE.getProcessType_Property();

		/**
		 * The meta object literal for the '<em><b>Process Events</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_TYPE__PROCESS_EVENTS = eINSTANCE.getProcessType_ProcessEvents();

		/**
		 * The meta object literal for the '<em><b>Provide</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_TYPE__PROVIDE = eINSTANCE.getProcessType_Provide();

		/**
		 * The meta object literal for the '<em><b>Invoke</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_TYPE__INVOKE = eINSTANCE.getProcessType_Invoke();

		/**
		 * The meta object literal for the '<em><b>Mex Interceptors</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_TYPE__MEX_INTERCEPTORS = eINSTANCE.getProcessType_MexInterceptors();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_TYPE__TYPE = eINSTANCE.getProcessType_Type();

		/**
		 * The meta object literal for the '<em><b>Bpel11wsdl File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_TYPE__BPEL11WSDL_FILE_NAME = eINSTANCE.getProcessType_Bpel11wsdlFileName();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_TYPE__FILE_NAME = eINSTANCE.getProcessType_FileName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_TYPE__NAME = eINSTANCE.getProcessType_Name();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_TYPE__MODEL = eINSTANCE.getProcessType_Model();

		/**
		 * The meta object literal for the '<em><b>Bam Server Profiles</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_TYPE__BAM_SERVER_PROFILES = eINSTANCE.getProcessType_BamServerProfiles();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.PropertyTypeImpl <em>Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.PropertyTypeImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getPropertyType()
		 * @generated
		 */
		EClass PROPERTY_TYPE = eINSTANCE.getPropertyType();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__ANY = eINSTANCE.getPropertyType_Any();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_TYPE__NAME = eINSTANCE.getPropertyType_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TDeploymentImpl <em>TDeployment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TDeploymentImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTDeployment()
		 * @generated
		 */
		EClass TDEPLOYMENT = eINSTANCE.getTDeployment();

		/**
		 * The meta object literal for the '<em><b>Process</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEPLOYMENT__PROCESS = eINSTANCE.getTDeployment_Process();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEnableEventListImpl <em>TEnable Event List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEnableEventListImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTEnableEventList()
		 * @generated
		 */
		EClass TENABLE_EVENT_LIST = eINSTANCE.getTEnableEventList();

		/**
		 * The meta object literal for the '<em><b>Enable Event</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TENABLE_EVENT_LIST__ENABLE_EVENT = eINSTANCE.getTEnableEventList_EnableEvent();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TInvokeImpl <em>TInvoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TInvokeImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTInvoke()
		 * @generated
		 */
		EClass TINVOKE = eINSTANCE.getTInvoke();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TINVOKE__SERVICE = eINSTANCE.getTInvoke_Service();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TINVOKE__BINDING = eINSTANCE.getTInvoke_Binding();

		/**
		 * The meta object literal for the '<em><b>Partner Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TINVOKE__PARTNER_LINK = eINSTANCE.getTInvoke_PartnerLink();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TMexInterceptorImpl <em>TMex Interceptor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TMexInterceptorImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTMexInterceptor()
		 * @generated
		 */
		EClass TMEX_INTERCEPTOR = eINSTANCE.getTMexInterceptor();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMEX_INTERCEPTOR__CLASS_NAME = eINSTANCE.getTMexInterceptor_ClassName();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProcessEventsImpl <em>TProcess Events</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProcessEventsImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTProcessEvents()
		 * @generated
		 */
		EClass TPROCESS_EVENTS = eINSTANCE.getTProcessEvents();

		/**
		 * The meta object literal for the '<em><b>Scope Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS_EVENTS__SCOPE_EVENTS = eINSTANCE.getTProcessEvents_ScopeEvents();

		/**
		 * The meta object literal for the '<em><b>Generate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROCESS_EVENTS__GENERATE = eINSTANCE.getTProcessEvents_Generate();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProvideImpl <em>TProvide</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProvideImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTProvide()
		 * @generated
		 */
		EClass TPROVIDE = eINSTANCE.getTProvide();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROVIDE__SERVICE = eINSTANCE.getTProvide_Service();

		/**
		 * The meta object literal for the '<em><b>Partner Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROVIDE__PARTNER_LINK = eINSTANCE.getTProvide_PartnerLink();

		/**
		 * The meta object literal for the '<em><b>Correlation Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROVIDE__CORRELATION_FILTER = eINSTANCE.getTProvide_CorrelationFilter();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TScopeEventsImpl <em>TScope Events</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TScopeEventsImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTScopeEvents()
		 * @generated
		 */
		EClass TSCOPE_EVENTS = eINSTANCE.getTScopeEvents();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TSCOPE_EVENTS__NAME = eINSTANCE.getTScopeEvents_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TServiceImpl <em>TService</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TServiceImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTService()
		 * @generated
		 */
		EClass TSERVICE = eINSTANCE.getTService();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TSERVICE__ANY = eINSTANCE.getTService_Any();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TSERVICE__NAME = eINSTANCE.getTService_Name();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TSERVICE__PORT = eINSTANCE.getTService_Port();

		/**
		 * The meta object literal for the '<em><b>Endpoint</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSERVICE__ENDPOINT = eINSTANCE.getTService_Endpoint();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TBamServerProfilesImpl <em>TBam Server Profiles</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TBamServerProfilesImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTBamServerProfiles()
		 * @generated
		 */
		EClass TBAM_SERVER_PROFILES = eINSTANCE.getTBamServerProfiles();

		/**
		 * The meta object literal for the '<em><b>Profile</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TBAM_SERVER_PROFILES__PROFILE = eINSTANCE.getTBamServerProfiles_Profile();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProfileImpl <em>TProfile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProfileImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTProfile()
		 * @generated
		 */
		EClass TPROFILE = eINSTANCE.getTProfile();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROFILE__NAME = eINSTANCE.getTProfile_Name();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROFILE__LOCATION = eINSTANCE.getTProfile_Location();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEndPointImpl <em>TEnd Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEndPointImpl
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getTEndPoint()
		 * @generated
		 */
		EClass TEND_POINT = eINSTANCE.getTEndPoint();

		/**
		 * The meta object literal for the '<em><b>Xmlns</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEND_POINT__XMLNS = eINSTANCE.getTEndPoint_Xmlns();

		/**
		 * The meta object literal for the '<em><b>Endpoint Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEND_POINT__ENDPOINT_REFERENCE = eINSTANCE.getTEndPoint_EndpointReference();

		/**
		 * The meta object literal for the '<em><b>Service Description Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEND_POINT__SERVICE_DESCRIPTION_REFERENCE = eINSTANCE.getTEndPoint_ServiceDescriptionReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType <em>Generate Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getGenerateType()
		 * @generated
		 */
		EEnum GENERATE_TYPE = eINSTANCE.getGenerateType();

		/**
		 * The meta object literal for the '<em>Generate Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.GenerateType
		 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddPackageImpl#getGenerateTypeObject()
		 * @generated
		 */
		EDataType GENERATE_TYPE_OBJECT = eINSTANCE.getGenerateTypeObject();

	}

} //ddPackage
