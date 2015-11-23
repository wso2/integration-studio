/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchCaseParentContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Case Parent Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SwitchCaseParentContainerImpl#getSwitchCaseContainer <em>Switch Case Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchCaseParentContainerImpl extends EsbNodeImpl implements SwitchCaseParentContainer {
	/**
	 * The cached value of the '{@link #getSwitchCaseContainer() <em>Switch Case Container</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchCaseContainer()
	 * @generated
	 * @ordered
	 */
	protected EList<SwitchCaseContainer> switchCaseContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchCaseParentContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.SWITCH_CASE_PARENT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SwitchCaseContainer> getSwitchCaseContainer() {
		if (switchCaseContainer == null) {
			switchCaseContainer = new EObjectContainmentEList<SwitchCaseContainer>(SwitchCaseContainer.class, this, EsbPackage.SWITCH_CASE_PARENT_CONTAINER__SWITCH_CASE_CONTAINER);
		}
		return switchCaseContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.SWITCH_CASE_PARENT_CONTAINER__SWITCH_CASE_CONTAINER:
				return ((InternalEList<?>)getSwitchCaseContainer()).basicRemove(otherEnd, msgs);
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
			case EsbPackage.SWITCH_CASE_PARENT_CONTAINER__SWITCH_CASE_CONTAINER:
				return getSwitchCaseContainer();
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
			case EsbPackage.SWITCH_CASE_PARENT_CONTAINER__SWITCH_CASE_CONTAINER:
				getSwitchCaseContainer().clear();
				getSwitchCaseContainer().addAll((Collection<? extends SwitchCaseContainer>)newValue);
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
			case EsbPackage.SWITCH_CASE_PARENT_CONTAINER__SWITCH_CASE_CONTAINER:
				getSwitchCaseContainer().clear();
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
			case EsbPackage.SWITCH_CASE_PARENT_CONTAINER__SWITCH_CASE_CONTAINER:
				return switchCaseContainer != null && !switchCaseContainer.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SwitchCaseParentContainerImpl
