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
 * $Id: ReplyImpl.java,v 1.15 2011/03/30 18:54:24 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.MessageExchange;
import org.eclipse.bpel.model.Reply;
import org.eclipse.bpel.model.ToParts;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reply</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.ReplyImpl#getFaultName <em>Fault Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ReplyImpl#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ReplyImpl#getToParts <em>To Parts</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.ReplyImpl#getMessageExchange <em>Message Exchange</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
@SuppressWarnings("restriction")
public class ReplyImpl extends PartnerActivityImpl implements Reply {
	/**
	 * The default value of the '{@link #getFaultName() <em>Fault Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultName()
	 * @generated
	 * @ordered
	 */
	protected static final QName FAULT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaultName() <em>Fault Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultName()
	 * @generated
	 * @ordered
	 */
	protected QName faultName = FAULT_NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getToParts() <em>To Parts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToParts()
	 * @generated
	 * @ordered
	 */
	protected ToParts toParts;

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
	protected ReplyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.REPLY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getFaultName() {
		return faultName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setFaultName(QName newFaultName) {
		QName oldFaultName = faultName;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_FAULT_NAME, newFaultName == null ? null
							: newFaultName);
		}
		faultName = newFaultName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.REPLY__FAULT_NAME, oldFaultName, faultName));
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
							BPELPackage.REPLY__VARIABLE, oldVariable, variable));
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
					BPELPackage.REPLY__VARIABLE, oldVariable, variable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToParts getToParts() {
		return toParts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetToParts(ToParts newToParts,
			NotificationChain msgs) {
		ToParts oldToParts = toParts;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldToParts, newToParts);
		}
		toParts = newToParts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.REPLY__TO_PARTS, oldToParts,
					newToParts);
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
	public void setToParts(ToParts newToParts) {
		if (newToParts != toParts) {
			NotificationChain msgs = null;
			if (toParts != null)
				msgs = ((InternalEObject) toParts).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.REPLY__TO_PARTS,
						null, msgs);
			if (newToParts != null)
				msgs = ((InternalEObject) newToParts).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.REPLY__TO_PARTS,
						null, msgs);
			msgs = basicSetToParts(newToParts, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.REPLY__TO_PARTS, newToParts, newToParts));
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
							BPELPackage.REPLY__MESSAGE_EXCHANGE,
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
					BPELPackage.REPLY__MESSAGE_EXCHANGE, oldMessageExchange,
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
		case BPELPackage.REPLY__TO_PARTS:
			return basicSetToParts(null, msgs);
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
		case BPELPackage.REPLY__FAULT_NAME:
			return getFaultName();
		case BPELPackage.REPLY__VARIABLE:
			if (resolve)
				return getVariable();
			return basicGetVariable();
		case BPELPackage.REPLY__TO_PARTS:
			return getToParts();
		case BPELPackage.REPLY__MESSAGE_EXCHANGE:
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
		case BPELPackage.REPLY__FAULT_NAME:
			setFaultName((QName) newValue);
			return;
		case BPELPackage.REPLY__VARIABLE:
			setVariable((Variable) newValue);
			return;
		case BPELPackage.REPLY__TO_PARTS:
			setToParts((ToParts) newValue);
			return;
		case BPELPackage.REPLY__MESSAGE_EXCHANGE:
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
		case BPELPackage.REPLY__FAULT_NAME:
			setFaultName(FAULT_NAME_EDEFAULT);
			return;
		case BPELPackage.REPLY__VARIABLE:
			setVariable((Variable) null);
			return;
		case BPELPackage.REPLY__TO_PARTS:
			setToParts((ToParts) null);
			return;
		case BPELPackage.REPLY__MESSAGE_EXCHANGE:
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
		case BPELPackage.REPLY__FAULT_NAME:
			return FAULT_NAME_EDEFAULT == null ? faultName != null
					: !FAULT_NAME_EDEFAULT.equals(faultName);
		case BPELPackage.REPLY__VARIABLE:
			return variable != null;
		case BPELPackage.REPLY__TO_PARTS:
			return toParts != null;
		case BPELPackage.REPLY__MESSAGE_EXCHANGE:
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
		result.append(" (faultName: "); //$NON-NLS-1$
		result.append(faultName);
		result.append(')');
		return result.toString();
	}

	//	@Override
	//	protected void adoptContent(EReference reference, Object object) {
	//		if (object instanceof ToPart) {
	//			ReconciliationHelper
	//					.adoptChild(this, toPart, (ToPart) object, BPELConstants.ND_TO_PART);
	//		}
	//		super.adoptContent(reference, object);
	//	}
	//
	//	@Override
	//	protected void orphanContent(EReference reference, Object obj) {
	//		if (obj instanceof ToPart) {
	//			ReconciliationHelper.orphanChild(this, (ToPart) obj);
	//		}
	//		super.orphanContent(reference, obj);
	//	}

} //ReplyImpl
