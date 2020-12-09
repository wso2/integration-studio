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
 * $Id: ReceiveImpl.java,v 1.16 2011/03/30 18:54:24 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.FromParts;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.Receive;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.BPELUtils;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Receive</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ReceiveImpl#getCreateInstance <em>Create Instance</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ReceiveImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ReceiveImpl#getFromParts <em>From Parts</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ReceiveImpl#getMessageExchange <em>Message Exchange</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class ReceiveImpl extends PartnerActivityImpl implements Receive {
	/**
	 * The default value of the '{@link #getCreateInstance() <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateInstance()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean CREATE_INSTANCE_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getCreateInstance() <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateInstance()
	 * @generated
	 * @ordered
	 */
	protected Boolean createInstance = CREATE_INSTANCE_EDEFAULT;

	/**
	 * This is true if the Create Instance attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean createInstanceESet;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReceiveImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.RECEIVE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getCreateInstance() {
		return createInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setCreateInstance(Boolean newCreateInstance) {
		Boolean oldCreateInstance = createInstance;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_CREATE_INSTANCE,
					BPELUtils.boolean2XML(newCreateInstance));
		}
		createInstance = newCreateInstance;
		boolean oldCreateInstanceESet = createInstanceESet;
		createInstanceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.RECEIVE__CREATE_INSTANCE, oldCreateInstance,
					createInstance, !oldCreateInstanceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void unsetCreateInstance() {
		Boolean oldCreateInstance = createInstance;
		boolean oldCreateInstanceESet = createInstanceESet;
		createInstance = CREATE_INSTANCE_EDEFAULT;
		createInstanceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET,
					BPELPackage.RECEIVE__CREATE_INSTANCE, oldCreateInstance,
					CREATE_INSTANCE_EDEFAULT, oldCreateInstanceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreateInstance() {
		return createInstanceESet;
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
							BPELPackage.RECEIVE__VARIABLE, oldVariable,
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
					BPELPackage.RECEIVE__VARIABLE, oldVariable, variable));
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
					Notification.SET, BPELPackage.RECEIVE__FROM_PARTS,
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
								- BPELPackage.RECEIVE__FROM_PARTS, null, msgs);
			if (newFromParts != null)
				msgs = ((InternalEObject) newFromParts).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- BPELPackage.RECEIVE__FROM_PARTS, null, msgs);
			msgs = basicSetFromParts(newFromParts, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.RECEIVE__FROM_PARTS, newFromParts, newFromParts));
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
							BPELPackage.RECEIVE__MESSAGE_EXCHANGE,
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
					BPELPackage.RECEIVE__MESSAGE_EXCHANGE, oldMessageExchange,
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
		case BPELPackage.RECEIVE__FROM_PARTS:
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
		case BPELPackage.RECEIVE__CREATE_INSTANCE:
			return getCreateInstance();
		case BPELPackage.RECEIVE__VARIABLE:
			if (resolve)
				return getVariable();
			return basicGetVariable();
		case BPELPackage.RECEIVE__FROM_PARTS:
			return getFromParts();
		case BPELPackage.RECEIVE__MESSAGE_EXCHANGE:
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
		case BPELPackage.RECEIVE__CREATE_INSTANCE:
			setCreateInstance((Boolean) newValue);
			return;
		case BPELPackage.RECEIVE__VARIABLE:
			setVariable((Variable) newValue);
			return;
		case BPELPackage.RECEIVE__FROM_PARTS:
			setFromParts((FromParts) newValue);
			return;
		case BPELPackage.RECEIVE__MESSAGE_EXCHANGE:
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
		case BPELPackage.RECEIVE__CREATE_INSTANCE:
			unsetCreateInstance();
			return;
		case BPELPackage.RECEIVE__VARIABLE:
			setVariable((Variable) null);
			return;
		case BPELPackage.RECEIVE__FROM_PARTS:
			setFromParts((FromParts) null);
			return;
		case BPELPackage.RECEIVE__MESSAGE_EXCHANGE:
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
		case BPELPackage.RECEIVE__CREATE_INSTANCE:
			return isSetCreateInstance();
		case BPELPackage.RECEIVE__VARIABLE:
			return variable != null;
		case BPELPackage.RECEIVE__FROM_PARTS:
			return fromParts != null;
		case BPELPackage.RECEIVE__MESSAGE_EXCHANGE:
			return messageExchange != null;
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
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (createInstance: "); //$NON-NLS-1$
		if (createInstanceESet)
			result.append(createInstance);
		else
			result.append("<unset>"); //$NON-NLS-1$
		result.append(')');
		return result.toString();
	}
} //ReceiveImpl
