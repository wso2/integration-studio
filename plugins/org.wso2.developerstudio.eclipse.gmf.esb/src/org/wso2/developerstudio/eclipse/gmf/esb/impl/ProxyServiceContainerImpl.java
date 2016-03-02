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

import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceFaultContainer;
import org.wso2.developerstudio.eclipse.gmf.esb.ProxyServiceSequenceAndEndpointContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proxy Service Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceContainerImpl#getSequenceAndEndpointContainer <em>Sequence And Endpoint Container</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.impl.ProxyServiceContainerImpl#getFaultContainer <em>Fault Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProxyServiceContainerImpl extends EsbNodeImpl implements ProxyServiceContainer {
	/**
	 * The cached value of the '{@link #getSequenceAndEndpointContainer() <em>Sequence And Endpoint Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSequenceAndEndpointContainer()
	 * @generated
	 * @ordered
	 */
	protected ProxyServiceSequenceAndEndpointContainer sequenceAndEndpointContainer;

	/**
	 * The cached value of the '{@link #getFaultContainer() <em>Fault Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultContainer()
	 * @generated
	 * @ordered
	 */
	protected ProxyServiceFaultContainer faultContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProxyServiceContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EsbPackage.Literals.PROXY_SERVICE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyServiceSequenceAndEndpointContainer getSequenceAndEndpointContainer() {
		return sequenceAndEndpointContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSequenceAndEndpointContainer(ProxyServiceSequenceAndEndpointContainer newSequenceAndEndpointContainer, NotificationChain msgs) {
		ProxyServiceSequenceAndEndpointContainer oldSequenceAndEndpointContainer = sequenceAndEndpointContainer;
		sequenceAndEndpointContainer = newSequenceAndEndpointContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE_CONTAINER__SEQUENCE_AND_ENDPOINT_CONTAINER, oldSequenceAndEndpointContainer, newSequenceAndEndpointContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequenceAndEndpointContainer(ProxyServiceSequenceAndEndpointContainer newSequenceAndEndpointContainer) {
		if (newSequenceAndEndpointContainer != sequenceAndEndpointContainer) {
			NotificationChain msgs = null;
			if (sequenceAndEndpointContainer != null)
				msgs = ((InternalEObject)sequenceAndEndpointContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE_CONTAINER__SEQUENCE_AND_ENDPOINT_CONTAINER, null, msgs);
			if (newSequenceAndEndpointContainer != null)
				msgs = ((InternalEObject)newSequenceAndEndpointContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE_CONTAINER__SEQUENCE_AND_ENDPOINT_CONTAINER, null, msgs);
			msgs = basicSetSequenceAndEndpointContainer(newSequenceAndEndpointContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE_CONTAINER__SEQUENCE_AND_ENDPOINT_CONTAINER, newSequenceAndEndpointContainer, newSequenceAndEndpointContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProxyServiceFaultContainer getFaultContainer() {
		return faultContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFaultContainer(ProxyServiceFaultContainer newFaultContainer, NotificationChain msgs) {
		ProxyServiceFaultContainer oldFaultContainer = faultContainer;
		faultContainer = newFaultContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE_CONTAINER__FAULT_CONTAINER, oldFaultContainer, newFaultContainer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultContainer(ProxyServiceFaultContainer newFaultContainer) {
		if (newFaultContainer != faultContainer) {
			NotificationChain msgs = null;
			if (faultContainer != null)
				msgs = ((InternalEObject)faultContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE_CONTAINER__FAULT_CONTAINER, null, msgs);
			if (newFaultContainer != null)
				msgs = ((InternalEObject)newFaultContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EsbPackage.PROXY_SERVICE_CONTAINER__FAULT_CONTAINER, null, msgs);
			msgs = basicSetFaultContainer(newFaultContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EsbPackage.PROXY_SERVICE_CONTAINER__FAULT_CONTAINER, newFaultContainer, newFaultContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EsbPackage.PROXY_SERVICE_CONTAINER__SEQUENCE_AND_ENDPOINT_CONTAINER:
				return basicSetSequenceAndEndpointContainer(null, msgs);
			case EsbPackage.PROXY_SERVICE_CONTAINER__FAULT_CONTAINER:
				return basicSetFaultContainer(null, msgs);
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
			case EsbPackage.PROXY_SERVICE_CONTAINER__SEQUENCE_AND_ENDPOINT_CONTAINER:
				return getSequenceAndEndpointContainer();
			case EsbPackage.PROXY_SERVICE_CONTAINER__FAULT_CONTAINER:
				return getFaultContainer();
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
			case EsbPackage.PROXY_SERVICE_CONTAINER__SEQUENCE_AND_ENDPOINT_CONTAINER:
				setSequenceAndEndpointContainer((ProxyServiceSequenceAndEndpointContainer)newValue);
				return;
			case EsbPackage.PROXY_SERVICE_CONTAINER__FAULT_CONTAINER:
				setFaultContainer((ProxyServiceFaultContainer)newValue);
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
			case EsbPackage.PROXY_SERVICE_CONTAINER__SEQUENCE_AND_ENDPOINT_CONTAINER:
				setSequenceAndEndpointContainer((ProxyServiceSequenceAndEndpointContainer)null);
				return;
			case EsbPackage.PROXY_SERVICE_CONTAINER__FAULT_CONTAINER:
				setFaultContainer((ProxyServiceFaultContainer)null);
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
			case EsbPackage.PROXY_SERVICE_CONTAINER__SEQUENCE_AND_ENDPOINT_CONTAINER:
				return sequenceAndEndpointContainer != null;
			case EsbPackage.PROXY_SERVICE_CONTAINER__FAULT_CONTAINER:
				return faultContainer != null;
		}
		return super.eIsSet(featureID);
	}

} //ProxyServiceContainerImpl
