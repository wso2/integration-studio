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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage
 * @generated
 */
public interface ddFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ddFactory eINSTANCE = org.eclipse.bpel.apache.ode.deploy.model.dd.impl.ddFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Binding Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Binding Type</em>'.
	 * @generated
	 */
	BindingType createBindingType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Mex Interceptors Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mex Interceptors Type</em>'.
	 * @generated
	 */
	MexInterceptorsType createMexInterceptorsType();

	/**
	 * Returns a new object of class '<em>Process Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Type</em>'.
	 * @generated
	 */
	ProcessType createProcessType();

	/**
	 * Returns a new object of class '<em>Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Type</em>'.
	 * @generated
	 */
	PropertyType createPropertyType();

	/**
	 * Returns a new object of class '<em>TDeployment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TDeployment</em>'.
	 * @generated
	 */
	TDeployment createTDeployment();

	/**
	 * Returns a new object of class '<em>TEnable Event List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TEnable Event List</em>'.
	 * @generated
	 */
	TEnableEventList createTEnableEventList();

	/**
	 * Returns a new object of class '<em>TInvoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TInvoke</em>'.
	 * @generated
	 */
	TInvoke createTInvoke();

	/**
	 * Returns a new object of class '<em>TMex Interceptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TMex Interceptor</em>'.
	 * @generated
	 */
	TMexInterceptor createTMexInterceptor();

	/**
	 * Returns a new object of class '<em>TProcess Events</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TProcess Events</em>'.
	 * @generated
	 */
	TProcessEvents createTProcessEvents();

	/**
	 * Returns a new object of class '<em>TProvide</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TProvide</em>'.
	 * @generated
	 */
	TProvide createTProvide();

	/**
	 * Returns a new object of class '<em>TScope Events</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TScope Events</em>'.
	 * @generated
	 */
	TScopeEvents createTScopeEvents();

	/**
	 * Returns a new object of class '<em>TService</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TService</em>'.
	 * @generated
	 */
	TService createTService();

	/**
	 * Returns a new object of class '<em>TBam Server Profiles</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TBam Server Profiles</em>'.
	 * @generated
	 */
	TBamServerProfiles createTBamServerProfiles();

	/**
	 * Returns a new object of class '<em>TProfile</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TProfile</em>'.
	 * @generated
	 */
	TProfile createTProfile();

	/**
	 * Returns a new object of class '<em>TEnd Point</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>TEnd Point</em>'.
	 * @generated
	 */
	TEndPoint createTEndPoint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ddPackage getddPackage();

} //ddFactory
