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

import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementAdviceContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementObligationsContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementOnAcceptContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EntitlementOnRejectContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entitlement Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementContainerImpl#getOnRejectContainer <em>On Reject Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementContainerImpl#getOnAcceptContainer <em>On Accept Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementContainerImpl#getAdviceContainer <em>Advice Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.EntitlementContainerImpl#getObligationsContainer <em>Obligations Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntitlementContainerImpl extends EsbNodeImpl implements EntitlementContainer {
	/**
	 * The cached value of the '{@link #getOnRejectContainer() <em>On Reject Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnRejectContainer()
	 * @generated
	 * @ordered
	 */
	protected EntitlementOnRejectContainer onRejectContainer;

	/**
	 * The cached value of the '{@link #getOnAcceptContainer() <em>On Accept Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnAcceptContainer()
	 * @generated
	 * @ordered
	 */
	protected EntitlementOnAcceptContainer onAcceptContainer;

	/**
	 * The cached value of the '{@link #getAdviceContainer() <em>Advice Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdviceContainer()
	 * @generated
	 * @ordered
	 */
	protected EntitlementAdviceContainer adviceContainer;

	/**
	 * The cached value of the '{@link #getObligationsContainer() <em>Obligations Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObligationsContainer()
	 * @generated
	 * @ordered
	 */
	protected EntitlementObligationsContainer obligationsContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntitlementContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ENTITLEMENT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementOnRejectContainer getOnRejectContainer() {
		return onRejectContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnRejectContainer(EntitlementOnRejectContainer newOnRejectContainer, NotificationChain msgs) {
		EntitlementOnRejectContainer oldOnRejectContainer = onRejectContainer;
		onRejectContainer = newOnRejectContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_CONTAINER__ON_REJECT_CONTAINER, oldOnRejectContainer, newOnRejectContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnRejectContainer(EntitlementOnRejectContainer newOnRejectContainer) {
		if (newOnRejectContainer != onRejectContainer) {
			NotificationChain msgs = null;
			if (onRejectContainer != null)
				msgs = ((InternalEObject)onRejectContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_CONTAINER__ON_REJECT_CONTAINER, null, msgs);
			if (newOnRejectContainer != null)
				msgs = ((InternalEObject)newOnRejectContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_CONTAINER__ON_REJECT_CONTAINER, null, msgs);
			msgs = basicSetOnRejectContainer(newOnRejectContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_CONTAINER__ON_REJECT_CONTAINER, newOnRejectContainer, newOnRejectContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementOnAcceptContainer getOnAcceptContainer() {
		return onAcceptContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOnAcceptContainer(EntitlementOnAcceptContainer newOnAcceptContainer, NotificationChain msgs) {
		EntitlementOnAcceptContainer oldOnAcceptContainer = onAcceptContainer;
		onAcceptContainer = newOnAcceptContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_CONTAINER__ON_ACCEPT_CONTAINER, oldOnAcceptContainer, newOnAcceptContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOnAcceptContainer(EntitlementOnAcceptContainer newOnAcceptContainer) {
		if (newOnAcceptContainer != onAcceptContainer) {
			NotificationChain msgs = null;
			if (onAcceptContainer != null)
				msgs = ((InternalEObject)onAcceptContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_CONTAINER__ON_ACCEPT_CONTAINER, null, msgs);
			if (newOnAcceptContainer != null)
				msgs = ((InternalEObject)newOnAcceptContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_CONTAINER__ON_ACCEPT_CONTAINER, null, msgs);
			msgs = basicSetOnAcceptContainer(newOnAcceptContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_CONTAINER__ON_ACCEPT_CONTAINER, newOnAcceptContainer, newOnAcceptContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementAdviceContainer getAdviceContainer() {
		return adviceContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdviceContainer(EntitlementAdviceContainer newAdviceContainer, NotificationChain msgs) {
		EntitlementAdviceContainer oldAdviceContainer = adviceContainer;
		adviceContainer = newAdviceContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_CONTAINER__ADVICE_CONTAINER, oldAdviceContainer, newAdviceContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdviceContainer(EntitlementAdviceContainer newAdviceContainer) {
		if (newAdviceContainer != adviceContainer) {
			NotificationChain msgs = null;
			if (adviceContainer != null)
				msgs = ((InternalEObject)adviceContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_CONTAINER__ADVICE_CONTAINER, null, msgs);
			if (newAdviceContainer != null)
				msgs = ((InternalEObject)newAdviceContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_CONTAINER__ADVICE_CONTAINER, null, msgs);
			msgs = basicSetAdviceContainer(newAdviceContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_CONTAINER__ADVICE_CONTAINER, newAdviceContainer, newAdviceContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntitlementObligationsContainer getObligationsContainer() {
		return obligationsContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObligationsContainer(EntitlementObligationsContainer newObligationsContainer, NotificationChain msgs) {
		EntitlementObligationsContainer oldObligationsContainer = obligationsContainer;
		obligationsContainer = newObligationsContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_CONTAINER__OBLIGATIONS_CONTAINER, oldObligationsContainer, newObligationsContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObligationsContainer(EntitlementObligationsContainer newObligationsContainer) {
		if (newObligationsContainer != obligationsContainer) {
			NotificationChain msgs = null;
			if (obligationsContainer != null)
				msgs = ((InternalEObject)obligationsContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_CONTAINER__OBLIGATIONS_CONTAINER, null, msgs);
			if (newObligationsContainer != null)
				msgs = ((InternalEObject)newObligationsContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ENTITLEMENT_CONTAINER__OBLIGATIONS_CONTAINER, null, msgs);
			msgs = basicSetObligationsContainer(newObligationsContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ENTITLEMENT_CONTAINER__OBLIGATIONS_CONTAINER, newObligationsContainer, newObligationsContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ENTITLEMENT_CONTAINER__ON_REJECT_CONTAINER:
				return basicSetOnRejectContainer(null, msgs);
			case EsbPackage.ENTITLEMENT_CONTAINER__ON_ACCEPT_CONTAINER:
				return basicSetOnAcceptContainer(null, msgs);
			case EsbPackage.ENTITLEMENT_CONTAINER__ADVICE_CONTAINER:
				return basicSetAdviceContainer(null, msgs);
			case EsbPackage.ENTITLEMENT_CONTAINER__OBLIGATIONS_CONTAINER:
				return basicSetObligationsContainer(null, msgs);
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
			case EsbPackage.ENTITLEMENT_CONTAINER__ON_REJECT_CONTAINER:
				return getOnRejectContainer();
			case EsbPackage.ENTITLEMENT_CONTAINER__ON_ACCEPT_CONTAINER:
				return getOnAcceptContainer();
			case EsbPackage.ENTITLEMENT_CONTAINER__ADVICE_CONTAINER:
				return getAdviceContainer();
			case EsbPackage.ENTITLEMENT_CONTAINER__OBLIGATIONS_CONTAINER:
				return getObligationsContainer();
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
			case EsbPackage.ENTITLEMENT_CONTAINER__ON_REJECT_CONTAINER:
				setOnRejectContainer((EntitlementOnRejectContainer)newValue);
				return;
			case EsbPackage.ENTITLEMENT_CONTAINER__ON_ACCEPT_CONTAINER:
				setOnAcceptContainer((EntitlementOnAcceptContainer)newValue);
				return;
			case EsbPackage.ENTITLEMENT_CONTAINER__ADVICE_CONTAINER:
				setAdviceContainer((EntitlementAdviceContainer)newValue);
				return;
			case EsbPackage.ENTITLEMENT_CONTAINER__OBLIGATIONS_CONTAINER:
				setObligationsContainer((EntitlementObligationsContainer)newValue);
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
			case EsbPackage.ENTITLEMENT_CONTAINER__ON_REJECT_CONTAINER:
				setOnRejectContainer((EntitlementOnRejectContainer)null);
				return;
			case EsbPackage.ENTITLEMENT_CONTAINER__ON_ACCEPT_CONTAINER:
				setOnAcceptContainer((EntitlementOnAcceptContainer)null);
				return;
			case EsbPackage.ENTITLEMENT_CONTAINER__ADVICE_CONTAINER:
				setAdviceContainer((EntitlementAdviceContainer)null);
				return;
			case EsbPackage.ENTITLEMENT_CONTAINER__OBLIGATIONS_CONTAINER:
				setObligationsContainer((EntitlementObligationsContainer)null);
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
			case EsbPackage.ENTITLEMENT_CONTAINER__ON_REJECT_CONTAINER:
				return onRejectContainer != null;
			case EsbPackage.ENTITLEMENT_CONTAINER__ON_ACCEPT_CONTAINER:
				return onAcceptContainer != null;
			case EsbPackage.ENTITLEMENT_CONTAINER__ADVICE_CONTAINER:
				return adviceContainer != null;
			case EsbPackage.ENTITLEMENT_CONTAINER__OBLIGATIONS_CONTAINER:
				return obligationsContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //EntitlementContainerImpl
