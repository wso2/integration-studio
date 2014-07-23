/**
 * Copyright (c) 2008 IBM Corporation, University of Stuttgart (IAAS) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation, University of Stuttgart (IAAS) - initial API and implementation
 */
package org.eclipse.bpel.apache.ode.deploy.model.dd.impl;

import org.eclipse.bpel.apache.ode.deploy.model.dd.TEndPoint;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TEnd Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEndPointImpl#getXmlns <em>Xmlns</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEndPointImpl#getEndpointReference <em>Endpoint Reference</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TEndPointImpl#getServiceDescriptionReference <em>Service Description Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TEndPointImpl extends EObjectImpl implements TEndPoint {
	/**
	 * The default value of the '{@link #getXmlns() <em>Xmlns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmlns()
	 * @generated
	 * @ordered
	 */
	protected static final String XMLNS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getXmlns() <em>Xmlns</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXmlns()
	 * @generated
	 * @ordered
	 */
	protected String xmlns = XMLNS_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndpointReference() <em>Endpoint Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointReference()
	 * @generated
	 * @ordered
	 */
	protected static final String ENDPOINT_REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndpointReference() <em>Endpoint Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndpointReference()
	 * @generated
	 * @ordered
	 */
	protected String endpointReference = ENDPOINT_REFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceDescriptionReference() <em>Service Description Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceDescriptionReference()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_DESCRIPTION_REFERENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceDescriptionReference() <em>Service Description Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceDescriptionReference()
	 * @generated
	 * @ordered
	 */
	protected String serviceDescriptionReference = SERVICE_DESCRIPTION_REFERENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TEndPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ddPackage.Literals.TEND_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getXmlns() {
		return xmlns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXmlns(String newXmlns) {
		String oldXmlns = xmlns;
		xmlns = newXmlns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.TEND_POINT__XMLNS, oldXmlns, xmlns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEndpointReference() {
		return endpointReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndpointReference(String newEndpointReference) {
		String oldEndpointReference = endpointReference;
		endpointReference = newEndpointReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.TEND_POINT__ENDPOINT_REFERENCE, oldEndpointReference, endpointReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceDescriptionReference() {
		return serviceDescriptionReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceDescriptionReference(String newServiceDescriptionReference) {
		String oldServiceDescriptionReference = serviceDescriptionReference;
		serviceDescriptionReference = newServiceDescriptionReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.TEND_POINT__SERVICE_DESCRIPTION_REFERENCE, oldServiceDescriptionReference, serviceDescriptionReference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ddPackage.TEND_POINT__XMLNS:
				return getXmlns();
			case ddPackage.TEND_POINT__ENDPOINT_REFERENCE:
				return getEndpointReference();
			case ddPackage.TEND_POINT__SERVICE_DESCRIPTION_REFERENCE:
				return getServiceDescriptionReference();
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
			case ddPackage.TEND_POINT__XMLNS:
				setXmlns((String)newValue);
				return;
			case ddPackage.TEND_POINT__ENDPOINT_REFERENCE:
				setEndpointReference((String)newValue);
				return;
			case ddPackage.TEND_POINT__SERVICE_DESCRIPTION_REFERENCE:
				setServiceDescriptionReference((String)newValue);
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
			case ddPackage.TEND_POINT__XMLNS:
				setXmlns(XMLNS_EDEFAULT);
				return;
			case ddPackage.TEND_POINT__ENDPOINT_REFERENCE:
				setEndpointReference(ENDPOINT_REFERENCE_EDEFAULT);
				return;
			case ddPackage.TEND_POINT__SERVICE_DESCRIPTION_REFERENCE:
				setServiceDescriptionReference(SERVICE_DESCRIPTION_REFERENCE_EDEFAULT);
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
			case ddPackage.TEND_POINT__XMLNS:
				return XMLNS_EDEFAULT == null ? xmlns != null : !XMLNS_EDEFAULT.equals(xmlns);
			case ddPackage.TEND_POINT__ENDPOINT_REFERENCE:
				return ENDPOINT_REFERENCE_EDEFAULT == null ? endpointReference != null : !ENDPOINT_REFERENCE_EDEFAULT.equals(endpointReference);
			case ddPackage.TEND_POINT__SERVICE_DESCRIPTION_REFERENCE:
				return SERVICE_DESCRIPTION_REFERENCE_EDEFAULT == null ? serviceDescriptionReference != null : !SERVICE_DESCRIPTION_REFERENCE_EDEFAULT.equals(serviceDescriptionReference);
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
		result.append(" (xmlns: ");
		result.append(xmlns);
		result.append(", endpointReference: ");
		result.append(endpointReference);
		result.append(", serviceDescriptionReference: ");
		result.append(serviceDescriptionReference);
		result.append(')');
		return result.toString();
	}

} //TEndPointImpl
