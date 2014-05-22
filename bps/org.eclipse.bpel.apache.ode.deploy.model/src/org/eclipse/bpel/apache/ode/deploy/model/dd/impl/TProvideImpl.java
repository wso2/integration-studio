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

import org.eclipse.bpel.apache.ode.deploy.model.dd.TProvide;
import org.eclipse.bpel.apache.ode.deploy.model.dd.TService;
import org.eclipse.bpel.apache.ode.deploy.model.dd.ddPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TProvide</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProvideImpl#getService <em>Service</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProvideImpl#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.eclipse.bpel.apache.ode.deploy.model.dd.impl.TProvideImpl#getCorrelationFilter <em>Correlation Filter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TProvideImpl extends EObjectImpl implements TProvide {
	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected TService service;

	/**
	 * The default value of the '{@link #getPartnerLink() <em>Partner Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLink()
	 * @generated
	 * @ordered
	 */
	protected static final String PARTNER_LINK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPartnerLink() <em>Partner Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLink()
	 * @generated
	 * @ordered
	 */
	protected String partnerLink = PARTNER_LINK_EDEFAULT;

	/**
	 * The default value of the '{@link #getCorrelationFilter() <em>Correlation Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationFilter()
	 * @generated
	 * @ordered
	 */
	protected static final String CORRELATION_FILTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCorrelationFilter() <em>Correlation Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationFilter()
	 * @generated
	 * @ordered
	 */
	protected String correlationFilter = CORRELATION_FILTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TProvideImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ddPackage.Literals.TPROVIDE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TService getService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetService(TService newService, NotificationChain msgs) {
		TService oldService = service;
		service = newService;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ddPackage.TPROVIDE__SERVICE, oldService, newService);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setService(TService newService) {
		if (newService != service) {
			NotificationChain msgs = null;
			if (service != null)
				msgs = ((InternalEObject)service).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ddPackage.TPROVIDE__SERVICE, null, msgs);
			if (newService != null)
				msgs = ((InternalEObject)newService).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ddPackage.TPROVIDE__SERVICE, null, msgs);
			msgs = basicSetService(newService, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.TPROVIDE__SERVICE, newService, newService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPartnerLink() {
		return partnerLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPartnerLink(String newPartnerLink) {
		String oldPartnerLink = partnerLink;
		partnerLink = newPartnerLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.TPROVIDE__PARTNER_LINK, oldPartnerLink, partnerLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCorrelationFilter() {
		return correlationFilter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrelationFilter(String newCorrelationFilter) {
		String oldCorrelationFilter = correlationFilter;
		correlationFilter = newCorrelationFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ddPackage.TPROVIDE__CORRELATION_FILTER, oldCorrelationFilter, correlationFilter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ddPackage.TPROVIDE__SERVICE:
				return basicSetService(null, msgs);
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
			case ddPackage.TPROVIDE__SERVICE:
				return getService();
			case ddPackage.TPROVIDE__PARTNER_LINK:
				return getPartnerLink();
			case ddPackage.TPROVIDE__CORRELATION_FILTER:
				return getCorrelationFilter();
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
			case ddPackage.TPROVIDE__SERVICE:
				setService((TService)newValue);
				return;
			case ddPackage.TPROVIDE__PARTNER_LINK:
				setPartnerLink((String)newValue);
				return;
			case ddPackage.TPROVIDE__CORRELATION_FILTER:
				setCorrelationFilter((String)newValue);
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
			case ddPackage.TPROVIDE__SERVICE:
				setService((TService)null);
				return;
			case ddPackage.TPROVIDE__PARTNER_LINK:
				setPartnerLink(PARTNER_LINK_EDEFAULT);
				return;
			case ddPackage.TPROVIDE__CORRELATION_FILTER:
				setCorrelationFilter(CORRELATION_FILTER_EDEFAULT);
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
			case ddPackage.TPROVIDE__SERVICE:
				return service != null;
			case ddPackage.TPROVIDE__PARTNER_LINK:
				return PARTNER_LINK_EDEFAULT == null ? partnerLink != null : !PARTNER_LINK_EDEFAULT.equals(partnerLink);
			case ddPackage.TPROVIDE__CORRELATION_FILTER:
				return CORRELATION_FILTER_EDEFAULT == null ? correlationFilter != null : !CORRELATION_FILTER_EDEFAULT.equals(correlationFilter);
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
		result.append(" (partnerLink: ");
		result.append(partnerLink);
		result.append(", correlationFilter: ");
		result.append(correlationFilter);
		result.append(')');
		return result.toString();
	}

} //TProvideImpl
