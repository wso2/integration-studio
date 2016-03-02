/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.gmf.esb.CloneMediatorTargetOutputConnector;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Clone Mediator Target Output Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorTargetOutputConnectorImpl#getSoapAction <em>Soap Action</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.CloneMediatorTargetOutputConnectorImpl#getToAddress <em>To Address</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CloneMediatorTargetOutputConnectorImpl extends OutputConnectorImpl implements CloneMediatorTargetOutputConnector {
	/**
	 * The default value of the '{@link #getSoapAction() <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoapAction()
	 * @generated
	 * @ordered
	 */
	protected static final String SOAP_ACTION_EDEFAULT = "soapAction";

	/**
	 * The cached value of the '{@link #getSoapAction() <em>Soap Action</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSoapAction()
	 * @generated
	 * @ordered
	 */
	protected String soapAction = SOAP_ACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getToAddress() <em>To Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_ADDRESS_EDEFAULT = "toAddress";

	/**
	 * The cached value of the '{@link #getToAddress() <em>To Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToAddress()
	 * @generated
	 * @ordered
	 */
	protected String toAddress = TO_ADDRESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CloneMediatorTargetOutputConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSoapAction() {
		return soapAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSoapAction(String newSoapAction) {
		String oldSoapAction = soapAction;
		soapAction = newSoapAction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__SOAP_ACTION, oldSoapAction, soapAction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToAddress() {
		return toAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToAddress(String newToAddress) {
		String oldToAddress = toAddress;
		toAddress = newToAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__TO_ADDRESS, oldToAddress, toAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__SOAP_ACTION:
				return getSoapAction();
			case EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__TO_ADDRESS:
				return getToAddress();
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
			case EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__SOAP_ACTION:
				setSoapAction((String)newValue);
				return;
			case EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__TO_ADDRESS:
				setToAddress((String)newValue);
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
			case EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__SOAP_ACTION:
				setSoapAction(SOAP_ACTION_EDEFAULT);
				return;
			case EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__TO_ADDRESS:
				setToAddress(TO_ADDRESS_EDEFAULT);
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
			case EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__SOAP_ACTION:
				return SOAP_ACTION_EDEFAULT == null ? soapAction != null : !SOAP_ACTION_EDEFAULT.equals(soapAction);
			case EsbPackage.CLONE_MEDIATOR_TARGET_OUTPUT_CONNECTOR__TO_ADDRESS:
				return TO_ADDRESS_EDEFAULT == null ? toAddress != null : !TO_ADDRESS_EDEFAULT.equals(toAddress);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (soapAction: ");
		result.append(soapAction);
		result.append(", toAddress: ");
		result.append(toAddress);
		result.append(')');
		return result.toString();
	}

} //CloneMediatorTargetOutputConnectorImpl
