/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.humantask.model.ht.impl;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.wso2.developerstudio.eclipse.humantask.model.ht.HTPackage;
import org.wso2.developerstudio.eclipse.humantask.model.ht.TTaskInterface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TTask Interface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskInterfaceImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskInterfaceImpl#getPortType <em>Port Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskInterfaceImpl#getResponseOperation <em>Response Operation</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.humantask.model.ht.impl.TTaskInterfaceImpl#getResponsePortType <em>Response Port Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TTaskInterfaceImpl extends TExtensibleElementsImpl implements TTaskInterface {
	/**
	 * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected String operation = OPERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPortType() <em>Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortType()
	 * @generated
	 * @ordered
	 */
	protected static final QName PORT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPortType() <em>Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortType()
	 * @generated
	 * @ordered
	 */
	protected QName portType = PORT_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResponseOperation() <em>Response Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseOperation()
	 * @generated
	 * @ordered
	 */
	protected static final String RESPONSE_OPERATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResponseOperation() <em>Response Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponseOperation()
	 * @generated
	 * @ordered
	 */
	protected String responseOperation = RESPONSE_OPERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getResponsePortType() <em>Response Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsePortType()
	 * @generated
	 * @ordered
	 */
	protected static final QName RESPONSE_PORT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResponsePortType() <em>Response Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsePortType()
	 * @generated
	 * @ordered
	 */
	protected QName responsePortType = RESPONSE_PORT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TTaskInterfaceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HTPackage.Literals.TTASK_INTERFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(String newOperation) {
		String oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TTASK_INTERFACE__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getPortType() {
		return portType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortType(QName newPortType) {
		QName oldPortType = portType;
		portType = newPortType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TTASK_INTERFACE__PORT_TYPE, oldPortType, portType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResponseOperation() {
		return responseOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponseOperation(String newResponseOperation) {
		String oldResponseOperation = responseOperation;
		responseOperation = newResponseOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TTASK_INTERFACE__RESPONSE_OPERATION, oldResponseOperation, responseOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getResponsePortType() {
		return responsePortType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResponsePortType(QName newResponsePortType) {
		QName oldResponsePortType = responsePortType;
		responsePortType = newResponsePortType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HTPackage.TTASK_INTERFACE__RESPONSE_PORT_TYPE, oldResponsePortType, responsePortType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HTPackage.TTASK_INTERFACE__OPERATION:
				return getOperation();
			case HTPackage.TTASK_INTERFACE__PORT_TYPE:
				return getPortType();
			case HTPackage.TTASK_INTERFACE__RESPONSE_OPERATION:
				return getResponseOperation();
			case HTPackage.TTASK_INTERFACE__RESPONSE_PORT_TYPE:
				return getResponsePortType();
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
			case HTPackage.TTASK_INTERFACE__OPERATION:
				setOperation((String)newValue);
				return;
			case HTPackage.TTASK_INTERFACE__PORT_TYPE:
				setPortType((QName)newValue);
				return;
			case HTPackage.TTASK_INTERFACE__RESPONSE_OPERATION:
				setResponseOperation((String)newValue);
				return;
			case HTPackage.TTASK_INTERFACE__RESPONSE_PORT_TYPE:
				setResponsePortType((QName)newValue);
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
			case HTPackage.TTASK_INTERFACE__OPERATION:
				setOperation(OPERATION_EDEFAULT);
				return;
			case HTPackage.TTASK_INTERFACE__PORT_TYPE:
				setPortType(PORT_TYPE_EDEFAULT);
				return;
			case HTPackage.TTASK_INTERFACE__RESPONSE_OPERATION:
				setResponseOperation(RESPONSE_OPERATION_EDEFAULT);
				return;
			case HTPackage.TTASK_INTERFACE__RESPONSE_PORT_TYPE:
				setResponsePortType(RESPONSE_PORT_TYPE_EDEFAULT);
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
			case HTPackage.TTASK_INTERFACE__OPERATION:
				return OPERATION_EDEFAULT == null ? operation != null : !OPERATION_EDEFAULT.equals(operation);
			case HTPackage.TTASK_INTERFACE__PORT_TYPE:
				return PORT_TYPE_EDEFAULT == null ? portType != null : !PORT_TYPE_EDEFAULT.equals(portType);
			case HTPackage.TTASK_INTERFACE__RESPONSE_OPERATION:
				return RESPONSE_OPERATION_EDEFAULT == null ? responseOperation != null : !RESPONSE_OPERATION_EDEFAULT.equals(responseOperation);
			case HTPackage.TTASK_INTERFACE__RESPONSE_PORT_TYPE:
				return RESPONSE_PORT_TYPE_EDEFAULT == null ? responsePortType != null : !RESPONSE_PORT_TYPE_EDEFAULT.equals(responsePortType);
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
		result.append(" (operation: ");
		result.append(operation);
		result.append(", portType: ");
		result.append(portType);
		result.append(", responseOperation: ");
		result.append(responseOperation);
		result.append(", responsePortType: ");
		result.append(responsePortType);
		result.append(')');
		return result.toString();
	}

} //TTaskInterfaceImpl
