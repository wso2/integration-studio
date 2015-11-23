/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.AdditionalOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbLink;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.InputConnector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Additional Output Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.AdditionalOutputConnectorImpl#getAdditionalOutgoingLink <em>Additional Outgoing Link</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AdditionalOutputConnectorImpl extends EsbConnectorImpl implements AdditionalOutputConnector {
	/**
	 * The cached value of the '{@link #getAdditionalOutgoingLink() <em>Additional Outgoing Link</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditionalOutgoingLink()
	 * @generated
	 * @ordered
	 */
	protected EsbLink additionalOutgoingLink;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdditionalOutputConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.ADDITIONAL_OUTPUT_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EsbLink getAdditionalOutgoingLink() {
		return additionalOutgoingLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdditionalOutgoingLink(EsbLink newAdditionalOutgoingLink, NotificationChain msgs) {
		EsbLink oldAdditionalOutgoingLink = additionalOutgoingLink;
		additionalOutgoingLink = newAdditionalOutgoingLink;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.ADDITIONAL_OUTPUT_CONNECTOR__ADDITIONAL_OUTGOING_LINK, oldAdditionalOutgoingLink, newAdditionalOutgoingLink);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdditionalOutgoingLink(EsbLink newAdditionalOutgoingLink) {
		if (newAdditionalOutgoingLink != additionalOutgoingLink) {
			NotificationChain msgs = null;
			if (additionalOutgoingLink != null)
				msgs = ((InternalEObject)additionalOutgoingLink).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ADDITIONAL_OUTPUT_CONNECTOR__ADDITIONAL_OUTGOING_LINK, null, msgs);
			if (newAdditionalOutgoingLink != null)
				msgs = ((InternalEObject)newAdditionalOutgoingLink).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.ADDITIONAL_OUTPUT_CONNECTOR__ADDITIONAL_OUTGOING_LINK, null, msgs);
			msgs = basicSetAdditionalOutgoingLink(newAdditionalOutgoingLink, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.ADDITIONAL_OUTPUT_CONNECTOR__ADDITIONAL_OUTGOING_LINK, newAdditionalOutgoingLink, newAdditionalOutgoingLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean shouldConnect(InputConnector targetEnd) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.ADDITIONAL_OUTPUT_CONNECTOR__ADDITIONAL_OUTGOING_LINK:
				return basicSetAdditionalOutgoingLink(null, msgs);
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
			case EsbPackage.ADDITIONAL_OUTPUT_CONNECTOR__ADDITIONAL_OUTGOING_LINK:
				return getAdditionalOutgoingLink();
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
			case EsbPackage.ADDITIONAL_OUTPUT_CONNECTOR__ADDITIONAL_OUTGOING_LINK:
				setAdditionalOutgoingLink((EsbLink)newValue);
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
			case EsbPackage.ADDITIONAL_OUTPUT_CONNECTOR__ADDITIONAL_OUTGOING_LINK:
				setAdditionalOutgoingLink((EsbLink)null);
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
			case EsbPackage.ADDITIONAL_OUTPUT_CONNECTOR__ADDITIONAL_OUTGOING_LINK:
				return additionalOutgoingLink != null;
		}
		return super.eIsSet(featureID);
	}

} //AdditionalOutputConnectorImpl
