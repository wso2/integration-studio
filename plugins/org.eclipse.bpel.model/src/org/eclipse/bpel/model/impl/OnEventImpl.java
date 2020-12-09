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
 * $Id: OnEventImpl.java,v 1.16 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.CorrelationSets;
import org.eclipse.bpel.model.Correlations;
import org.eclipse.bpel.model.FromParts;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.OnEvent;
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
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.Operation;
import org.eclipse.wst.wsdl.PortType;
import org.eclipse.xsd.XSDElementDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>On Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.OnEventImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnEventImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnEventImpl#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnEventImpl#getCorrelations <em>Correlations</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnEventImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnEventImpl#getPortType <em>Port Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnEventImpl#getMessageType <em>Message Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnEventImpl#getXSDElement <em>XSD Element</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnEventImpl#getCorrelationSets <em>Correlation Sets</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnEventImpl#getFromParts <em>From Parts</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.OnEventImpl#getMessageExchange <em>Message Exchange</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OnEventImpl extends BPELExtensibleElementImpl implements OnEvent {
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
	 * The cached value of the '{@link #getVariable() <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable variable;

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
	 * The cached value of the '{@link #getPortType() <em>Port Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortType()
	 * @generated
	 * @ordered
	 */
	protected PortType portType;

	/**
	 * The cached value of the '{@link #getMessageType() <em>Message Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageType()
	 * @generated
	 * @ordered
	 */
	protected Message messageType;

	/**
	 * The cached value of the '{@link #getXSDElement() <em>XSD Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getXSDElement()
	 * @generated
	 * @ordered
	 */
	protected XSDElementDeclaration xsdElement;

	/**
	 * The cached value of the '{@link #getCorrelationSets() <em>Correlation Sets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationSets()
	 * @generated
	 * @ordered
	 */
	protected CorrelationSets correlationSets;

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
	 * @generated NOT
	 */
	protected String operationName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OnEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.ON_EVENT;
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
					Notification.SET, BPELPackage.ON_EVENT__ACTIVITY,
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
				msgs = ((InternalEObject) activity)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_EVENT__ACTIVITY, null, msgs);
			if (newActivity != null)
				msgs = ((InternalEObject) newActivity)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_EVENT__ACTIVITY, null, msgs);
			msgs = basicSetActivity(newActivity, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_EVENT__ACTIVITY, newActivity, newActivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getVariable() {
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetVariable(Variable newVariable,
			NotificationChain msgs) {
		Variable oldVariable = variable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_VARIABLE, newVariable == null ? null
							: newVariable.getName());
		}
		variable = newVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.ON_EVENT__VARIABLE,
					oldVariable, newVariable);
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
	public void setVariable(Variable newVariable) {
		if (newVariable != variable) {
			NotificationChain msgs = null;
			if (variable != null)
				msgs = ((InternalEObject) variable)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_EVENT__VARIABLE, null, msgs);
			if (newVariable != null)
				msgs = ((InternalEObject) newVariable)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_EVENT__VARIABLE, null, msgs);
			msgs = basicSetVariable(newVariable, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_EVENT__VARIABLE, newVariable, newVariable));
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
							BPELPackage.ON_EVENT__PARTNER_LINK, oldPartnerLink,
							partnerLink));
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
					BPELPackage.ON_EVENT__PARTNER_LINK, oldPartnerLink,
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
					Notification.SET, BPELPackage.ON_EVENT__CORRELATIONS,
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
								- BPELPackage.ON_EVENT__CORRELATIONS, null,
						msgs);
			if (newCorrelations != null)
				msgs = ((InternalEObject) newCorrelations).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_EVENT__CORRELATIONS, null,
						msgs);
			msgs = basicSetCorrelations(newCorrelations, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_EVENT__CORRELATIONS, newCorrelations,
					newCorrelations));
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
							BPELPackage.ON_EVENT__OPERATION, oldOperation,
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
					BPELPackage.ON_EVENT__OPERATION, oldOperation, operation));
	}

	/**
	 * Set the deserialized value of the operation name.
	 * @generated NOT
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName;
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
							BPELPackage.ON_EVENT__PORT_TYPE, oldPortType,
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
					BPELPackage.ON_EVENT__PORT_TYPE, oldPortType, portType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public Message getMessageType() {
		Variable variable = getVariable();
		if (variable != null) {
			return (variable).getMessageType();
		}

		if (messageType != null && messageType.eIsProxy()) {
			Message oldMessageType = messageType;
			messageType = (Message) eResolveProxy((InternalEObject) messageType);
			if (messageType != oldMessageType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.ON_EVENT__MESSAGE_TYPE, oldMessageType,
							messageType));
			}
		}
		return messageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetMessageType() {
		return messageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setMessageType(Message newMessageType) {
		Variable variable = getVariable();
		if (variable != null) {
			(variable).setMessageType(newMessageType);
		}

		Message oldMessageType = messageType;
		messageType = newMessageType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_EVENT__MESSAGE_TYPE, oldMessageType,
					messageType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=336003
	 * "element" attribute was missing from original model
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public XSDElementDeclaration getXSDElement() {
		Variable variable = getVariable();
		if (variable != null) {
			return (variable).getXSDElement();
		}

		if (xsdElement != null && xsdElement.eIsProxy()) {
			XSDElementDeclaration oldXSDElement = xsdElement;
			xsdElement = (XSDElementDeclaration) eResolveProxy((InternalEObject) xsdElement);
			if (xsdElement != oldXSDElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.ON_EVENT__XSD_ELEMENT, oldXSDElement,
							xsdElement));
			}
		}
		return xsdElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSDElementDeclaration basicGetXSDElement() {
		return xsdElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setXSDElement(XSDElementDeclaration newXSDElement) {
		Variable variable = getVariable();
		if (variable != null) {
			(variable).setXSDElement(newXSDElement);
		}

		XSDElementDeclaration oldXSDElement = xsdElement;
		xsdElement = newXSDElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_EVENT__XSD_ELEMENT, oldXSDElement,
					xsdElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorrelationSets getCorrelationSets() {
		return correlationSets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetCorrelationSets(
			CorrelationSets newCorrelationSets, NotificationChain msgs) {
		CorrelationSets oldCorrelationSets = correlationSets;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldCorrelationSets,
					newCorrelationSets);
		}
		correlationSets = newCorrelationSets;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.ON_EVENT__CORRELATION_SETS,
					oldCorrelationSets, newCorrelationSets);
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
	public void setCorrelationSets(CorrelationSets newCorrelationSets) {
		if (newCorrelationSets != correlationSets) {
			NotificationChain msgs = null;
			if (correlationSets != null)
				msgs = ((InternalEObject) correlationSets).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_EVENT__CORRELATION_SETS, null,
						msgs);
			if (newCorrelationSets != null)
				msgs = ((InternalEObject) newCorrelationSets).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_EVENT__CORRELATION_SETS, null,
						msgs);
			msgs = basicSetCorrelationSets(newCorrelationSets, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_EVENT__CORRELATION_SETS, newCorrelationSets,
					newCorrelationSets));
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
					Notification.SET, BPELPackage.ON_EVENT__FROM_PARTS,
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
								- BPELPackage.ON_EVENT__FROM_PARTS, null, msgs);
			if (newFromParts != null)
				msgs = ((InternalEObject) newFromParts).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.ON_EVENT__FROM_PARTS, null, msgs);
			msgs = basicSetFromParts(newFromParts, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.ON_EVENT__FROM_PARTS, newFromParts,
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
							BPELPackage.ON_EVENT__MESSAGE_EXCHANGE,
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
					BPELPackage.ON_EVENT__MESSAGE_EXCHANGE, oldMessageExchange,
					messageExchange));
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
		case BPELPackage.ON_EVENT__ACTIVITY:
			return basicSetActivity(null, msgs);
		case BPELPackage.ON_EVENT__VARIABLE:
			return basicSetVariable(null, msgs);
		case BPELPackage.ON_EVENT__CORRELATIONS:
			return basicSetCorrelations(null, msgs);
		case BPELPackage.ON_EVENT__CORRELATION_SETS:
			return basicSetCorrelationSets(null, msgs);
		case BPELPackage.ON_EVENT__FROM_PARTS:
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
		case BPELPackage.ON_EVENT__ACTIVITY:
			return getActivity();
		case BPELPackage.ON_EVENT__VARIABLE:
			return getVariable();
		case BPELPackage.ON_EVENT__PARTNER_LINK:
			if (resolve)
				return getPartnerLink();
			return basicGetPartnerLink();
		case BPELPackage.ON_EVENT__CORRELATIONS:
			return getCorrelations();
		case BPELPackage.ON_EVENT__OPERATION:
			if (resolve)
				return getOperation();
			return basicGetOperation();
		case BPELPackage.ON_EVENT__PORT_TYPE:
			if (resolve)
				return getPortType();
			return basicGetPortType();
		case BPELPackage.ON_EVENT__MESSAGE_TYPE:
			if (resolve)
				return getMessageType();
			return basicGetMessageType();
		case BPELPackage.ON_EVENT__XSD_ELEMENT:
			if (resolve)
				return getXSDElement();
			return basicGetXSDElement();
		case BPELPackage.ON_EVENT__CORRELATION_SETS:
			return getCorrelationSets();
		case BPELPackage.ON_EVENT__FROM_PARTS:
			return getFromParts();
		case BPELPackage.ON_EVENT__MESSAGE_EXCHANGE:
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
		case BPELPackage.ON_EVENT__ACTIVITY:
			setActivity((Activity) newValue);
			return;
		case BPELPackage.ON_EVENT__VARIABLE:
			setVariable((Variable) newValue);
			return;
		case BPELPackage.ON_EVENT__PARTNER_LINK:
			setPartnerLink((PartnerLink) newValue);
			return;
		case BPELPackage.ON_EVENT__CORRELATIONS:
			setCorrelations((Correlations) newValue);
			return;
		case BPELPackage.ON_EVENT__OPERATION:
			setOperation((Operation) newValue);
			return;
		case BPELPackage.ON_EVENT__PORT_TYPE:
			setPortType((PortType) newValue);
			return;
		case BPELPackage.ON_EVENT__MESSAGE_TYPE:
			setMessageType((Message) newValue);
			return;
		case BPELPackage.ON_EVENT__XSD_ELEMENT:
			setXSDElement((XSDElementDeclaration) newValue);
			return;
		case BPELPackage.ON_EVENT__CORRELATION_SETS:
			setCorrelationSets((CorrelationSets) newValue);
			return;
		case BPELPackage.ON_EVENT__FROM_PARTS:
			setFromParts((FromParts) newValue);
			return;
		case BPELPackage.ON_EVENT__MESSAGE_EXCHANGE:
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
		case BPELPackage.ON_EVENT__ACTIVITY:
			setActivity((Activity) null);
			return;
		case BPELPackage.ON_EVENT__VARIABLE:
			setVariable((Variable) null);
			return;
		case BPELPackage.ON_EVENT__PARTNER_LINK:
			setPartnerLink((PartnerLink) null);
			return;
		case BPELPackage.ON_EVENT__CORRELATIONS:
			setCorrelations((Correlations) null);
			return;
		case BPELPackage.ON_EVENT__OPERATION:
			setOperation((Operation) null);
			return;
		case BPELPackage.ON_EVENT__PORT_TYPE:
			setPortType((PortType) null);
			return;
		case BPELPackage.ON_EVENT__MESSAGE_TYPE:
			setMessageType((Message) null);
			return;
		case BPELPackage.ON_EVENT__XSD_ELEMENT:
			setXSDElement((XSDElementDeclaration) null);
			return;
		case BPELPackage.ON_EVENT__CORRELATION_SETS:
			setCorrelationSets((CorrelationSets) null);
			return;
		case BPELPackage.ON_EVENT__FROM_PARTS:
			setFromParts((FromParts) null);
			return;
		case BPELPackage.ON_EVENT__MESSAGE_EXCHANGE:
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
		case BPELPackage.ON_EVENT__ACTIVITY:
			return activity != null;
		case BPELPackage.ON_EVENT__VARIABLE:
			return variable != null;
		case BPELPackage.ON_EVENT__PARTNER_LINK:
			return partnerLink != null;
		case BPELPackage.ON_EVENT__CORRELATIONS:
			return correlations != null;
		case BPELPackage.ON_EVENT__OPERATION:
			return operation != null;
		case BPELPackage.ON_EVENT__PORT_TYPE:
			return portType != null;
		case BPELPackage.ON_EVENT__MESSAGE_TYPE:
			return messageType != null;
		case BPELPackage.ON_EVENT__XSD_ELEMENT:
			return xsdElement != null;
		case BPELPackage.ON_EVENT__CORRELATION_SETS:
			return correlationSets != null;
		case BPELPackage.ON_EVENT__FROM_PARTS:
			return fromParts != null;
		case BPELPackage.ON_EVENT__MESSAGE_EXCHANGE:
			return messageExchange != null;
		}
		return super.eIsSet(featureID);
	}

} //OnEventImpl
