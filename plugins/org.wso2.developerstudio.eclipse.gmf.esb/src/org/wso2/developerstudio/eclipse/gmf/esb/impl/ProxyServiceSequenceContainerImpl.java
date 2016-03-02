/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 *//*
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceInSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceOutSequence;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceSequenceContainer;

*//**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proxy Service Sequence Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceSequenceContainerImpl#getInSequence <em>In Sequence</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceSequenceContainerImpl#getOutSequence <em>Out Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 *//*
public class ProxyServiceSequenceContainerImpl extends EsbNodeImpl implements ProxyServiceSequenceContainer {
	*//**
	 * The cached value of the '{@link #getInSequence() <em>In Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInSequence()
	 * @generated
	 * @ordered
	 *//*
	protected ProxyServiceInSequence inSequence;

	*//**
	 * The cached value of the '{@link #getOutSequence() <em>Out Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutSequence()
	 * @generated
	 * @ordered
	 *//*
	protected ProxyServiceOutSequence outSequence;

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	protected ProxyServiceSequenceContainerImpl() {
		super();
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.PROXY_SERVICE_SEQUENCE_CONTAINER;
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	public ProxyServiceInSequence getInSequence() {
		return inSequence;
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	public NotificationChain basicSetInSequence(ProxyServiceInSequence newInSequence, NotificationChain msgs) {
		ProxyServiceInSequence oldInSequence = inSequence;
		inSequence = newInSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__IN_SEQUENCE, oldInSequence, newInSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	public void setInSequence(ProxyServiceInSequence newInSequence) {
		if (newInSequence != inSequence) {
			NotificationChain msgs = null;
			if (inSequence != null)
				msgs = ((InternalEObject)inSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__IN_SEQUENCE, null, msgs);
			if (newInSequence != null)
				msgs = ((InternalEObject)newInSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__IN_SEQUENCE, null, msgs);
			msgs = basicSetInSequence(newInSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__IN_SEQUENCE, newInSequence, newInSequence));
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	public ProxyServiceOutSequence getOutSequence() {
		return outSequence;
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	public NotificationChain basicSetOutSequence(ProxyServiceOutSequence newOutSequence, NotificationChain msgs) {
		ProxyServiceOutSequence oldOutSequence = outSequence;
		outSequence = newOutSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__OUT_SEQUENCE, oldOutSequence, newOutSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	public void setOutSequence(ProxyServiceOutSequence newOutSequence) {
		if (newOutSequence != outSequence) {
			NotificationChain msgs = null;
			if (outSequence != null)
				msgs = ((InternalEObject)outSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__OUT_SEQUENCE, null, msgs);
			if (newOutSequence != null)
				msgs = ((InternalEObject)newOutSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__OUT_SEQUENCE, null, msgs);
			msgs = basicSetOutSequence(newOutSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__OUT_SEQUENCE, newOutSequence, newOutSequence));
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__IN_SEQUENCE:
				return basicSetInSequence(null, msgs);
			case EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__OUT_SEQUENCE:
				return basicSetOutSequence(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__IN_SEQUENCE:
				return getInSequence();
			case EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__OUT_SEQUENCE:
				return getOutSequence();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__IN_SEQUENCE:
				setInSequence((ProxyServiceInSequence)newValue);
				return;
			case EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__OUT_SEQUENCE:
				setOutSequence((ProxyServiceOutSequence)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__IN_SEQUENCE:
				setInSequence((ProxyServiceInSequence)null);
				return;
			case EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__OUT_SEQUENCE:
				setOutSequence((ProxyServiceOutSequence)null);
				return;
		}
		super.eUnset(featureID);
	}

	*//**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 *//*
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__IN_SEQUENCE:
				return inSequence != null;
			case EsbPackage.PROXY_SERVICE_SEQUENCE_CONTAINER__OUT_SEQUENCE:
				return outSequence != null;
		}
		return super.eIsSet(featureID);
	}

} //ProxyServiceSequenceContainerImpl
*/