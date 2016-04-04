/**
 * <copyright>
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: PartnerActivityImpl.java,v 1.11 2009/04/14 10:50:37 smoser Exp $
 */
package org.eclipse.bpel.model.impl;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.Invoke;
import org.eclipse.bpel.model.PartnerActivity;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.proxy.OperationProxy;
import org.eclipse.bpel.model.proxy.PortTypeProxy;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partner Activity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.PartnerActivityImpl#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.PartnerActivityImpl#getCorrelations <em>Correlations</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.PartnerActivityImpl#getPortType <em>Port Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.PartnerActivityImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class PartnerActivityImpl extends ActivityImpl implements
		PartnerActivity {
	/**
	 * The cached value of the '{@link #getPartnerLink() <em>Partner Link</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartnerLink()
	 * @generated
	 * @ordered
	 */
	protected PartnerLink partnerLink;

	/**
	 * The cached value of the '{@link #getCorrelations() <em>Correlations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelations()
	 * @generated
	 * @ordered
	 */
	protected Correlations correlations;

	/**
	 * The cached value of the '{@link #getPortType() <em>Port Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortType()
	 * @generated
	 * @ordered
	 */
	protected PortType portType;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation operation;

	/**
	 * The deserialized value of the operation name.
	 * @customized
	 */
	protected String operationName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartnerActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.PARTNER_ACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerLink getPartnerLink() {
		if (partnerLink != null && partnerLink.eIsProxy()) {
			InternalEObject oldPartnerLink = (InternalEObject) partnerLink;
			partnerLink = (PartnerLink) eResolveProxy(oldPartnerLink);
			if (partnerLink != oldPartnerLink) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.PARTNER_ACTIVITY__PARTNER_LINK,
							oldPartnerLink, partnerLink));
			}
		}
		return partnerLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PartnerLink basicGetPartnerLink() {
		return partnerLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setPartnerLink(PartnerLink newPartnerLink) {
		PartnerLink oldPartnerLink = partnerLink;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_PARTNER_LINK,
					newPartnerLink == null ? null : newPartnerLink.getName());
		}
		partnerLink = newPartnerLink;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PARTNER_ACTIVITY__PARTNER_LINK, oldPartnerLink,
					partnerLink));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Correlations getCorrelations() {
		return correlations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetCorrelations(Correlations newCorrelations,
			NotificationChain msgs) {
		Correlations oldCorrelations = correlations;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldCorrelations,
					newCorrelations);
		}
		correlations = newCorrelations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					BPELPackage.PARTNER_ACTIVITY__CORRELATIONS,
					oldCorrelations, newCorrelations);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorrelations(Correlations newCorrelations) {
		if (newCorrelations != correlations) {
			NotificationChain msgs = null;
			if (correlations != null)
				msgs = ((InternalEObject) correlations).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.PARTNER_ACTIVITY__CORRELATIONS,
						null, msgs);
			if (newCorrelations != null)
				msgs = ((InternalEObject) newCorrelations).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.PARTNER_ACTIVITY__CORRELATIONS,
						null, msgs);
			msgs = basicSetCorrelations(newCorrelations, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PARTNER_ACTIVITY__CORRELATIONS,
					newCorrelations, newCorrelations));
	}

	/**
	 * Customizes {@link #getPortTypeGen()} to handle the case where the port type is not specified.
	 * @customized
	 */
	public PortType getPortType() {
		if (portType != null) {
			return getPortTypeGen();
		} else {
			// portType is now optional. If the user hasn't set it, then
			// infer it from the partnerLink attribute and the 
			// direction of this activity.
			PartnerLink link = getPartnerLink();
			if (link != null) {
				Role role = null;
				if (this instanceof Invoke) {
					role = link.getPartnerRole();
				} else {
					role = link.getMyRole();
				}
				if (role != null) {
					portType = (PortType) role.getPortType();
				}
			}
			return portType;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortType getPortTypeGen() {
		if (portType != null && portType.eIsProxy()) {
			InternalEObject oldPortType = (InternalEObject) portType;
			portType = (PortType) eResolveProxy(oldPortType);
			if (portType != oldPortType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.PARTNER_ACTIVITY__PORT_TYPE,
							oldPortType, portType));
			}
		}
		return portType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortType basicGetPortType() {
		return portType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setPortType(PortType newPortType) {
		PortType oldPortType = portType;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_PORT_TYPE, newPortType == null ? null
							: newPortType.getQName());
		}
		portType = newPortType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PARTNER_ACTIVITY__PORT_TYPE, oldPortType,
					portType));
	}

	/**
	 * Customizes {@link #getOperationGen()} to handle the case where the port type is not specified.
	 * @customized
	 */
	public Operation getOperation() {
		if (operation == null && operationName != null) {
			PortType portType = getPortType();
			if (portType != null) {
				// Create an operation proxy with the deserialized operation name.
				operation = new OperationProxy(eResource().getURI(), portType,
						operationName);
				operationName = null;
			} else {
				portType = new PortTypeProxy(eResource().getURI(), new QName(
						"null"));
				operation = new OperationProxy(eResource().getURI(), portType,
						operationName);
			}
		}
		return getOperationGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getOperationGen() {
		if (operation != null && operation.eIsProxy()) {
			InternalEObject oldOperation = (InternalEObject) operation;
			operation = (Operation) eResolveProxy(oldOperation);
			if (operation != oldOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.PARTNER_ACTIVITY__OPERATION,
							oldOperation, operation));
			}
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setOperation(Operation newOperation) {
		Operation oldOperation = operation;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_OPERATION, newOperation == null ? null
							: newOperation.getName());
		}
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.PARTNER_ACTIVITY__OPERATION, oldOperation,
					operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case BPELPackage.PARTNER_ACTIVITY__CORRELATIONS:
			return basicSetCorrelations(null, msgs);
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
		case BPELPackage.PARTNER_ACTIVITY__PARTNER_LINK:
			if (resolve)
				return getPartnerLink();
			return basicGetPartnerLink();
		case BPELPackage.PARTNER_ACTIVITY__CORRELATIONS:
			return getCorrelations();
		case BPELPackage.PARTNER_ACTIVITY__PORT_TYPE:
			if (resolve)
				return getPortType();
			return basicGetPortType();
		case BPELPackage.PARTNER_ACTIVITY__OPERATION:
			if (resolve)
				return getOperation();
			return basicGetOperation();
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
		case BPELPackage.PARTNER_ACTIVITY__PARTNER_LINK:
			setPartnerLink((PartnerLink) newValue);
			return;
		case BPELPackage.PARTNER_ACTIVITY__CORRELATIONS:
			setCorrelations((Correlations) newValue);
			return;
		case BPELPackage.PARTNER_ACTIVITY__PORT_TYPE:
			setPortType((PortType) newValue);
			return;
		case BPELPackage.PARTNER_ACTIVITY__OPERATION:
			setOperation((Operation) newValue);
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
		case BPELPackage.PARTNER_ACTIVITY__PARTNER_LINK:
			setPartnerLink((PartnerLink) null);
			return;
		case BPELPackage.PARTNER_ACTIVITY__CORRELATIONS:
			setCorrelations((Correlations) null);
			return;
		case BPELPackage.PARTNER_ACTIVITY__PORT_TYPE:
			setPortType((PortType) null);
			return;
		case BPELPackage.PARTNER_ACTIVITY__OPERATION:
			setOperation((Operation) null);
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
		case BPELPackage.PARTNER_ACTIVITY__PARTNER_LINK:
			return partnerLink != null;
		case BPELPackage.PARTNER_ACTIVITY__CORRELATIONS:
			return correlations != null;
		case BPELPackage.PARTNER_ACTIVITY__PORT_TYPE:
			return portType != null;
		case BPELPackage.PARTNER_ACTIVITY__OPERATION:
			return operation != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Set the deserialized value of the operation name.
	 * @customized
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

} //PartnerActivityImpl
