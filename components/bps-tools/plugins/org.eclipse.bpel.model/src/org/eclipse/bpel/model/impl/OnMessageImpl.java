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
 * $Id: OnMessageImpl.java,v 1.13 2011/03/30 18:54:24 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.FromParts;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.OnMessage;
import org.eclipse.bpel.model.PartnerLink;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.proxy.OperationProxy;
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
 * An implementation of the model object '<em><b>On Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.OnMessageImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnMessageImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnMessageImpl#getPortType <em>Port Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnMessageImpl#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnMessageImpl#getCorrelations <em>Correlations</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnMessageImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnMessageImpl#getFromParts <em>From Parts</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnMessageImpl#getMessageExchange <em>Message Exchange</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OnMessageImpl extends BPELExtensibleElementImpl implements
		OnMessage {
	/**
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable variable;

	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected Activity activity;

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
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation operation;

	/**
	 * The cached value of the '{@link #getFromParts() <em>From Parts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromParts()
	 * @generated
	 * @ordered
	 */
	protected FromParts fromParts;

	/**
	 * The cached value of the '{@link #getMessageExchange() <em>Message Exchange</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageExchange()
	 * @generated
	 * @ordered
	 */
	protected MessageExchange messageExchange;

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
	protected OnMessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.ON_MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable() {
		if (variable != null && variable.eIsProxy()) {
			InternalEObject oldVariable = (InternalEObject) variable;
			variable = (Variable) eResolveProxy(oldVariable);
			if (variable != oldVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.ON_MESSAGE__VARIABLE, oldVariable,
							variable));
			}
		}
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setVariable(Variable newVariable) {
		Variable oldVariable = variable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_VARIABLE, newVariable == null ? null
							: newVariable.getName());
		}
		variable = newVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_MESSAGE__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getActivity() {
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetActivity(Activity newActivity,
			NotificationChain msgs) {
		Activity oldActivity = activity;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldActivity, newActivity);
		}
		activity = newActivity;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.ON_MESSAGE__ACTIVITY,
					oldActivity, newActivity);
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
	public void setActivity(Activity newActivity) {
		if (newActivity != activity) {
			NotificationChain msgs = null;
			if (activity != null)
				msgs = ((InternalEObject) activity).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_MESSAGE__ACTIVITY, null, msgs);
			if (newActivity != null)
				msgs = ((InternalEObject) newActivity).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_MESSAGE__ACTIVITY, null, msgs);
			msgs = basicSetActivity(newActivity, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_MESSAGE__ACTIVITY, newActivity, newActivity));
	}

	/**
	 * Customizes {@link #getPortTypeGen()} to handle the case where the port type is not specified.
	 * @generated NOT
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
				Role role = link.getMyRole();
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
							BPELPackage.ON_MESSAGE__PORT_TYPE, oldPortType,
							portType));
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
					BPELPackage.ON_MESSAGE__PORT_TYPE, oldPortType, portType));
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
							BPELPackage.ON_MESSAGE__PARTNER_LINK,
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
					BPELPackage.ON_MESSAGE__PARTNER_LINK, oldPartnerLink,
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
					Notification.SET, BPELPackage.ON_MESSAGE__CORRELATIONS,
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
								- BPELPackage.ON_MESSAGE__CORRELATIONS, null,
						msgs);
			if (newCorrelations != null)
				msgs = ((InternalEObject) newCorrelations).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_MESSAGE__CORRELATIONS, null,
						msgs);
			msgs = basicSetCorrelations(newCorrelations, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_MESSAGE__CORRELATIONS, newCorrelations,
					newCorrelations));
	}

	/**
	 * Customizes {@link #getOperationGen()} to handle the case where the port type is not specified.
	 * @generated NOT
	 */
	public Operation getOperation() {
		if (operation == null && operationName != null) {
			PortType portType = getPortType();
			if (portType != null) {
				// Create an operation proxy with the deserialized operation name.
				operation = new OperationProxy(eResource().getURI(), portType,
						operationName);
				operationName = null;
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
							BPELPackage.ON_MESSAGE__OPERATION, oldOperation,
							operation));
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
					BPELPackage.ON_MESSAGE__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromParts getFromParts() {
		return fromParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetFromParts(FromParts newFromParts,
			NotificationChain msgs) {
		FromParts oldFromParts = fromParts;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldFromParts, newFromParts);
		}
		fromParts = newFromParts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.ON_MESSAGE__FROM_PARTS,
					oldFromParts, newFromParts);
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
	public void setFromParts(FromParts newFromParts) {
		if (newFromParts != fromParts) {
			NotificationChain msgs = null;
			if (fromParts != null)
				msgs = ((InternalEObject) fromParts).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_MESSAGE__FROM_PARTS, null,
						msgs);
			if (newFromParts != null)
				msgs = ((InternalEObject) newFromParts).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_MESSAGE__FROM_PARTS, null,
						msgs);
			msgs = basicSetFromParts(newFromParts, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_MESSAGE__FROM_PARTS, newFromParts,
					newFromParts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageExchange getMessageExchange() {
		if (messageExchange != null && messageExchange.eIsProxy()) {
			InternalEObject oldMessageExchange = (InternalEObject) messageExchange;
			messageExchange = (MessageExchange) eResolveProxy(oldMessageExchange);
			if (messageExchange != oldMessageExchange) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.ON_MESSAGE__MESSAGE_EXCHANGE,
							oldMessageExchange, messageExchange));
			}
		}
		return messageExchange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageExchange basicGetMessageExchange() {
		return messageExchange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @author Miriam Grundig (MGrundig@de.ibm.com)
	 */
	public void setMessageExchange(MessageExchange newMessageExchange) {
		MessageExchange oldMessageExchange = messageExchange;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					BPELConstants.AT_MESSAGE_EXCHANGE,
					newMessageExchange == null ? null : newMessageExchange
							.getName());
		}
		messageExchange = newMessageExchange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_MESSAGE__MESSAGE_EXCHANGE,
					oldMessageExchange, messageExchange));
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
		case BPELPackage.ON_MESSAGE__ACTIVITY:
			return basicSetActivity(null, msgs);
		case BPELPackage.ON_MESSAGE__CORRELATIONS:
			return basicSetCorrelations(null, msgs);
		case BPELPackage.ON_MESSAGE__FROM_PARTS:
			return basicSetFromParts(null, msgs);
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
		case BPELPackage.ON_MESSAGE__VARIABLE:
			if (resolve)
				return getVariable();
			return basicGetVariable();
		case BPELPackage.ON_MESSAGE__ACTIVITY:
			return getActivity();
		case BPELPackage.ON_MESSAGE__PORT_TYPE:
			if (resolve)
				return getPortType();
			return basicGetPortType();
		case BPELPackage.ON_MESSAGE__PARTNER_LINK:
			if (resolve)
				return getPartnerLink();
			return basicGetPartnerLink();
		case BPELPackage.ON_MESSAGE__CORRELATIONS:
			return getCorrelations();
		case BPELPackage.ON_MESSAGE__OPERATION:
			if (resolve)
				return getOperation();
			return basicGetOperation();
		case BPELPackage.ON_MESSAGE__FROM_PARTS:
			return getFromParts();
		case BPELPackage.ON_MESSAGE__MESSAGE_EXCHANGE:
			if (resolve)
				return getMessageExchange();
			return basicGetMessageExchange();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case BPELPackage.ON_MESSAGE__VARIABLE:
			setVariable((Variable) newValue);
			return;
		case BPELPackage.ON_MESSAGE__ACTIVITY:
			setActivity((Activity) newValue);
			return;
		case BPELPackage.ON_MESSAGE__PORT_TYPE:
			setPortType((PortType) newValue);
			return;
		case BPELPackage.ON_MESSAGE__PARTNER_LINK:
			setPartnerLink((PartnerLink) newValue);
			return;
		case BPELPackage.ON_MESSAGE__CORRELATIONS:
			setCorrelations((Correlations) newValue);
			return;
		case BPELPackage.ON_MESSAGE__OPERATION:
			setOperation((Operation) newValue);
			return;
		case BPELPackage.ON_MESSAGE__FROM_PARTS:
			setFromParts((FromParts) newValue);
			return;
		case BPELPackage.ON_MESSAGE__MESSAGE_EXCHANGE:
			setMessageExchange((MessageExchange) newValue);
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
		case BPELPackage.ON_MESSAGE__VARIABLE:
			setVariable((Variable) null);
			return;
		case BPELPackage.ON_MESSAGE__ACTIVITY:
			setActivity((Activity) null);
			return;
		case BPELPackage.ON_MESSAGE__PORT_TYPE:
			setPortType((PortType) null);
			return;
		case BPELPackage.ON_MESSAGE__PARTNER_LINK:
			setPartnerLink((PartnerLink) null);
			return;
		case BPELPackage.ON_MESSAGE__CORRELATIONS:
			setCorrelations((Correlations) null);
			return;
		case BPELPackage.ON_MESSAGE__OPERATION:
			setOperation((Operation) null);
			return;
		case BPELPackage.ON_MESSAGE__FROM_PARTS:
			setFromParts((FromParts) null);
			return;
		case BPELPackage.ON_MESSAGE__MESSAGE_EXCHANGE:
			setMessageExchange((MessageExchange) null);
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
		case BPELPackage.ON_MESSAGE__VARIABLE:
			return variable != null;
		case BPELPackage.ON_MESSAGE__ACTIVITY:
			return activity != null;
		case BPELPackage.ON_MESSAGE__PORT_TYPE:
			return portType != null;
		case BPELPackage.ON_MESSAGE__PARTNER_LINK:
			return partnerLink != null;
		case BPELPackage.ON_MESSAGE__CORRELATIONS:
			return correlations != null;
		case BPELPackage.ON_MESSAGE__OPERATION:
			return operation != null;
		case BPELPackage.ON_MESSAGE__FROM_PARTS:
			return fromParts != null;
		case BPELPackage.ON_MESSAGE__MESSAGE_EXCHANGE:
			return messageExchange != null;
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

} //OnMessageImpl
