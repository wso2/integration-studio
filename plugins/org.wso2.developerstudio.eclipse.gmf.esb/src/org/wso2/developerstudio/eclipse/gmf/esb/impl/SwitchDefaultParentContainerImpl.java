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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchDefaultContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.SwitchDefaultParentContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Default Parent Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.SwitchDefaultParentContainerImpl#getSwitchDefaultContainer <em>Switch Default Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchDefaultParentContainerImpl extends EsbNodeImpl implements SwitchDefaultParentContainer {
	/**
	 * The cached value of the '{@link #getSwitchDefaultContainer() <em>Switch Default Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSwitchDefaultContainer()
	 * @generated
	 * @ordered
	 */
	protected SwitchDefaultContainer switchDefaultContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchDefaultParentContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.SWITCH_DEFAULT_PARENT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchDefaultContainer getSwitchDefaultContainer() {
		return switchDefaultContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSwitchDefaultContainer(SwitchDefaultContainer newSwitchDefaultContainer, NotificationChain msgs) {
		SwitchDefaultContainer oldSwitchDefaultContainer = switchDefaultContainer;
		switchDefaultContainer = newSwitchDefaultContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.SWITCH_DEFAULT_PARENT_CONTAINER__SWITCH_DEFAULT_CONTAINER, oldSwitchDefaultContainer, newSwitchDefaultContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSwitchDefaultContainer(SwitchDefaultContainer newSwitchDefaultContainer) {
		if (newSwitchDefaultContainer != switchDefaultContainer) {
			NotificationChain msgs = null;
			if (switchDefaultContainer != null)
				msgs = ((InternalEObject)switchDefaultContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SWITCH_DEFAULT_PARENT_CONTAINER__SWITCH_DEFAULT_CONTAINER, null, msgs);
			if (newSwitchDefaultContainer != null)
				msgs = ((InternalEObject)newSwitchDefaultContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.SWITCH_DEFAULT_PARENT_CONTAINER__SWITCH_DEFAULT_CONTAINER, null, msgs);
			msgs = basicSetSwitchDefaultContainer(newSwitchDefaultContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.SWITCH_DEFAULT_PARENT_CONTAINER__SWITCH_DEFAULT_CONTAINER, newSwitchDefaultContainer, newSwitchDefaultContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.SWITCH_DEFAULT_PARENT_CONTAINER__SWITCH_DEFAULT_CONTAINER:
				return basicSetSwitchDefaultContainer(null, msgs);
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
			case EsbPackage.SWITCH_DEFAULT_PARENT_CONTAINER__SWITCH_DEFAULT_CONTAINER:
				return getSwitchDefaultContainer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.SWITCH_DEFAULT_PARENT_CONTAINER__SWITCH_DEFAULT_CONTAINER:
				setSwitchDefaultContainer((SwitchDefaultContainer)newValue);
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
			case EsbPackage.SWITCH_DEFAULT_PARENT_CONTAINER__SWITCH_DEFAULT_CONTAINER:
				setSwitchDefaultContainer((SwitchDefaultContainer)null);
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
			case EsbPackage.SWITCH_DEFAULT_PARENT_CONTAINER__SWITCH_DEFAULT_CONTAINER:
				return switchDefaultContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //SwitchDefaultParentContainerImpl
