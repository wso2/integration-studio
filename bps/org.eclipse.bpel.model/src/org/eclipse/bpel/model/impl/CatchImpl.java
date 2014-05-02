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
 * $Id: CatchImpl.java,v 1.13 2011/03/30 18:54:24 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.Activity;
import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.Catch;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.xsd.XSDElementDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Catch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.CatchImpl#getFaultName <em>Fault Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.CatchImpl#getFaultVariable <em>Fault Variable</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.CatchImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.CatchImpl#getFaultMessageType <em>Fault Message Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.CatchImpl#getFaultElement <em>Fault Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CatchImpl extends BPELExtensibleElementImpl implements Catch {
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
	 * The cached value of the '{@link #getFaultVariable() <em>Fault Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable faultVariable;

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
	 * The cached value of the '{@link #getFaultMessageType() <em>Fault Message Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultMessageType()
	 * @generated
	 * @ordered
	 */
	protected Message faultMessageType;

	/**
	 * The cached value of the '{@link #getFaultElement() <em>Fault Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultElement()
	 * @generated
	 * @ordered
	 */
	protected XSDElementDeclaration faultElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.CATCH;
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
					BPELConstants.AT_FAULT_NAME, newFaultName);
		}
		faultName = newFaultName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.CATCH__FAULT_NAME, oldFaultName, faultName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getFaultVariable() {
		return faultVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetFaultVariable(Variable newFaultVariable,
			NotificationChain msgs) {
		Variable oldFaultVariable = faultVariable;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					BPELConstants.AT_FAULT_VARIABLE,
					newFaultVariable == null ? null : newFaultVariable
							.getName());
		}
		faultVariable = newFaultVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.CATCH__FAULT_VARIABLE,
					oldFaultVariable, newFaultVariable);
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
	public void setFaultVariable(Variable newFaultVariable) {
		if (newFaultVariable != faultVariable) {
			NotificationChain msgs = null;
			if (faultVariable != null)
				msgs = ((InternalEObject) faultVariable)
						.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.CATCH__FAULT_VARIABLE, null, msgs);
			if (newFaultVariable != null)
				msgs = ((InternalEObject) newFaultVariable)
						.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
								- BPELPackage.CATCH__FAULT_VARIABLE, null, msgs);
			msgs = basicSetFaultVariable(newFaultVariable, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.CATCH__FAULT_VARIABLE, newFaultVariable,
					newFaultVariable));
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
					Notification.SET, BPELPackage.CATCH__ACTIVITY, oldActivity,
					newActivity);
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
						EOPPOSITE_FEATURE_BASE - BPELPackage.CATCH__ACTIVITY,
						null, msgs);
			if (newActivity != null)
				msgs = ((InternalEObject) newActivity).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.CATCH__ACTIVITY,
						null, msgs);
			msgs = basicSetActivity(newActivity, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.CATCH__ACTIVITY, newActivity, newActivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public Message getFaultMessageType() {
		if (faultVariable != null) {
			return (faultVariable).getMessageType();
		}

		if (faultMessageType != null && faultMessageType.eIsProxy()) {
			Message oldFaultMessageType = faultMessageType;
			faultMessageType = (Message) eResolveProxy((InternalEObject) faultMessageType);
			if (faultMessageType != oldFaultMessageType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.CATCH__FAULT_MESSAGE_TYPE,
							oldFaultMessageType, faultMessageType));
			}
		}
		return faultMessageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetFaultMessageType() {
		return faultMessageType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setFaultMessageType(Message newFaultMessageType) {
		Variable variable = getFaultVariable();
		if (variable != null) {
			(variable).setMessageType(newFaultMessageType);
		}

		Message oldFaultMessageType = faultMessageType;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					BPELConstants.AT_FAULT_MESSAGE_TYPE,
					newFaultMessageType == null ? null : newFaultMessageType
							.getQName());
		}
		faultMessageType = newFaultMessageType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.CATCH__FAULT_MESSAGE_TYPE, oldFaultMessageType,
					faultMessageType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public XSDElementDeclaration getFaultElement() {
		if (faultVariable != null) {
			return (faultVariable).getXSDElement();
		}

		if (faultElement != null && faultElement.eIsProxy()) {
			XSDElementDeclaration oldFaultElement = faultElement;
			faultElement = (XSDElementDeclaration) eResolveProxy((InternalEObject) faultElement);
			if (faultElement != oldFaultElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.CATCH__FAULT_ELEMENT, oldFaultElement,
							faultElement));
			}
		}
		return faultElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XSDElementDeclaration basicGetFaultElement() {
		return faultElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public void setFaultElement(XSDElementDeclaration newFaultElement) {
		Variable variable = getFaultVariable();
		if (variable != null) {
			(variable).setXSDElement(newFaultElement);
		}

		XSDElementDeclaration oldFaultElement = faultElement;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					BPELConstants.AT_FAULT_ELEMENT,
					newFaultElement == null ? null : new QName(newFaultElement
							.getTargetNamespace(), newFaultElement.getName()));
		}
		faultElement = newFaultElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.CATCH__FAULT_ELEMENT, oldFaultElement,
					faultElement));
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
		case BPELPackage.CATCH__FAULT_VARIABLE:
			return basicSetFaultVariable(null, msgs);
		case BPELPackage.CATCH__ACTIVITY:
			return basicSetActivity(null, msgs);
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
		case BPELPackage.CATCH__FAULT_NAME:
			return getFaultName();
		case BPELPackage.CATCH__FAULT_VARIABLE:
			return getFaultVariable();
		case BPELPackage.CATCH__ACTIVITY:
			return getActivity();
		case BPELPackage.CATCH__FAULT_MESSAGE_TYPE:
			if (resolve)
				return getFaultMessageType();
			return basicGetFaultMessageType();
		case BPELPackage.CATCH__FAULT_ELEMENT:
			if (resolve)
				return getFaultElement();
			return basicGetFaultElement();
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
		case BPELPackage.CATCH__FAULT_NAME:
			setFaultName((QName) newValue);
			return;
		case BPELPackage.CATCH__FAULT_VARIABLE:
			setFaultVariable((Variable) newValue);
			return;
		case BPELPackage.CATCH__ACTIVITY:
			setActivity((Activity) newValue);
			return;
		case BPELPackage.CATCH__FAULT_MESSAGE_TYPE:
			setFaultMessageType((Message) newValue);
			return;
		case BPELPackage.CATCH__FAULT_ELEMENT:
			setFaultElement((XSDElementDeclaration) newValue);
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
		case BPELPackage.CATCH__FAULT_NAME:
			setFaultName(FAULT_NAME_EDEFAULT);
			return;
		case BPELPackage.CATCH__FAULT_VARIABLE:
			setFaultVariable((Variable) null);
			return;
		case BPELPackage.CATCH__ACTIVITY:
			setActivity((Activity) null);
			return;
		case BPELPackage.CATCH__FAULT_MESSAGE_TYPE:
			setFaultMessageType((Message) null);
			return;
		case BPELPackage.CATCH__FAULT_ELEMENT:
			setFaultElement((XSDElementDeclaration) null);
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
		case BPELPackage.CATCH__FAULT_NAME:
			return FAULT_NAME_EDEFAULT == null ? faultName != null
					: !FAULT_NAME_EDEFAULT.equals(faultName);
		case BPELPackage.CATCH__FAULT_VARIABLE:
			return faultVariable != null;
		case BPELPackage.CATCH__ACTIVITY:
			return activity != null;
		case BPELPackage.CATCH__FAULT_MESSAGE_TYPE:
			return faultMessageType != null;
		case BPELPackage.CATCH__FAULT_ELEMENT:
			return faultElement != null;
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

} //CatchImpl
