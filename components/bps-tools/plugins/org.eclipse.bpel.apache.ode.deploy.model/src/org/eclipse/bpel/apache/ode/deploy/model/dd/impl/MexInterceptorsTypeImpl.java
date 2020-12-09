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

import java.util.Collection;

import org.eclipse.bpel.apache.ode.deploy.model.dd.MexInterceptorsType;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TMexInterceptor;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mex Interceptors Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.MexInterceptorsTypeImpl#getMexInterceptor <em>Mex Interceptor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MexInterceptorsTypeImpl extends EObjectImpl implements MexInterceptorsType {
	/**
	 * The cached value of the '{@link #getMexInterceptor() <em>Mex Interceptor</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMexInterceptor()
	 * @generated
	 * @ordered
	 */
	protected EList<TMexInterceptor> mexInterceptor;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MexInterceptorsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ddPackage.Literals.MEX_INTERCEPTORS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TMexInterceptor> getMexInterceptor() {
		if (mexInterceptor == null) {
			mexInterceptor = new EObjectContainmentEList<TMexInterceptor>(TMexInterceptor.class, this, ddPackage.MEX_INTERCEPTORS_TYPE__MEX_INTERCEPTOR);
		}
		return mexInterceptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ddPackage.MEX_INTERCEPTORS_TYPE__MEX_INTERCEPTOR:
				return ((InternalEList<?>)getMexInterceptor()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ddPackage.MEX_INTERCEPTORS_TYPE__MEX_INTERCEPTOR:
				return getMexInterceptor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ddPackage.MEX_INTERCEPTORS_TYPE__MEX_INTERCEPTOR:
				getMexInterceptor().clear();
				getMexInterceptor().addAll((Collection<? extends TMexInterceptor>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ddPackage.MEX_INTERCEPTORS_TYPE__MEX_INTERCEPTOR:
				getMexInterceptor().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ddPackage.MEX_INTERCEPTORS_TYPE__MEX_INTERCEPTOR:
				return mexInterceptor != null && !mexInterceptor.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //MexInterceptorsTypeImpl
