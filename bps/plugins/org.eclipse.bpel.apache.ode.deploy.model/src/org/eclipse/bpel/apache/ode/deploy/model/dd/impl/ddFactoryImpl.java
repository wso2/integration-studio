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

import org.eclipse.bpel.apache.ode.deploy.model.dd.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ddFactoryImpl extends EFactoryImpl implements ddFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ddFactory init() {
		try {
			ddFactory theddFactory = (ddFactory)EPackage.Registry.INSTANCE.getEFactory(ddPackage.eNS_URI);
			if (theddFactory != null) {
				return theddFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ddFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ddFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ddPackage.BINDING_TYPE: return createBindingType();
			case ddPackage.DOCUMENT_ROOT: return createDocumentRoot();
			case ddPackage.MEX_INTERCEPTORS_TYPE: return createMexInterceptorsType();
			case ddPackage.PROCESS_TYPE: return createProcessType();
			case ddPackage.PROPERTY_TYPE: return createPropertyType();
			case ddPackage.TDEPLOYMENT: return createTDeployment();
			case ddPackage.TENABLE_EVENT_LIST: return createTEnableEventList();
			case ddPackage.TINVOKE: return createTInvoke();
			case ddPackage.TMEX_INTERCEPTOR: return createTMexInterceptor();
			case ddPackage.TPROCESS_EVENTS: return createTProcessEvents();
			case ddPackage.TPROVIDE: return createTProvide();
			case ddPackage.TSCOPE_EVENTS: return createTScopeEvents();
			case ddPackage.TSERVICE: return createTService();
			case ddPackage.TBAM_SERVER_PROFILES: return createTBamServerProfiles();
			case ddPackage.TPROFILE: return createTProfile();
			case ddPackage.TEND_POINT: return createTEndPoint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ddPackage.GENERATE_TYPE:
				return createGenerateTypeFromString(eDataType, initialValue);
			case ddPackage.GENERATE_TYPE_OBJECT:
				return createGenerateTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ddPackage.GENERATE_TYPE:
				return convertGenerateTypeToString(eDataType, instanceValue);
			case ddPackage.GENERATE_TYPE_OBJECT:
				return convertGenerateTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindingType createBindingType() {
		BindingTypeImpl bindingType = new BindingTypeImpl();
		return bindingType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MexInterceptorsType createMexInterceptorsType() {
		MexInterceptorsTypeImpl mexInterceptorsType = new MexInterceptorsTypeImpl();
		return mexInterceptorsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessType createProcessType() {
		ProcessTypeImpl processType = new ProcessTypeImpl();
		return processType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyType createPropertyType() {
		PropertyTypeImpl propertyType = new PropertyTypeImpl();
		return propertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TDeployment createTDeployment() {
		TDeploymentImpl tDeployment = new TDeploymentImpl();
		return tDeployment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TEnableEventList createTEnableEventList() {
		TEnableEventListImpl tEnableEventList = new TEnableEventListImpl();
		return tEnableEventList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TInvoke createTInvoke() {
		TInvokeImpl tInvoke = new TInvokeImpl();
		return tInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TMexInterceptor createTMexInterceptor() {
		TMexInterceptorImpl tMexInterceptor = new TMexInterceptorImpl();
		return tMexInterceptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TProcessEvents createTProcessEvents() {
		TProcessEventsImpl tProcessEvents = new TProcessEventsImpl();
		return tProcessEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TProvide createTProvide() {
		TProvideImpl tProvide = new TProvideImpl();
		return tProvide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TScopeEvents createTScopeEvents() {
		TScopeEventsImpl tScopeEvents = new TScopeEventsImpl();
		return tScopeEvents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TService createTService() {
		TServiceImpl tService = new TServiceImpl();
		return tService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBamServerProfiles createTBamServerProfiles() {
		TBamServerProfilesImpl tBamServerProfiles = new TBamServerProfilesImpl();
		return tBamServerProfiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TProfile createTProfile() {
		TProfileImpl tProfile = new TProfileImpl();
		return tProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TEndPoint createTEndPoint() {
		TEndPointImpl tEndPoint = new TEndPointImpl();
		return tEndPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenerateType createGenerateTypeFromString(EDataType eDataType, String initialValue) {
		GenerateType result = GenerateType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenerateTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenerateType createGenerateTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createGenerateTypeFromString(ddPackage.Literals.GENERATE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGenerateTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertGenerateTypeToString(ddPackage.Literals.GENERATE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ddPackage getddPackage() {
		return (ddPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ddPackage getPackage() {
		return ddPackage.eINSTANCE;
	}

} //ddFactoryImpl
