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
 * $Id: VariableImpl.java,v 1.16 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.impl;

import javax.xml.namespace.QName;

import org.eclipse.bpel.model.BPELPackage;
import org.eclipse.bpel.model.From;
import org.eclipse.bpel.model.Variable;
import org.eclipse.bpel.model.util.BPELConstants;
import org.eclipse.bpel.model.util.ReconciliationHelper;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.wst.wsdl.Message;
import org.eclipse.wst.wsdl.WSDLElement;
import org.eclipse.xsd.XSDElementDeclaration;
import org.eclipse.xsd.XSDTypeDefinition;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.impl.VariableImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.VariableImpl#getMessageType <em>Message Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.VariableImpl#getXSDElement <em>XSD Element</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.VariableImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.impl.VariableImpl#getFrom <em>From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */

@SuppressWarnings("restriction")
public class VariableImpl extends BPELExtensibleElementImpl implements Variable {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMessageType() <em>Message Type</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getMessageType()
	 * @generated
	 * @ordered
	 */
	protected Message messageType;

	/**
	 * The cached value of the '{@link #getXSDElement() <em>XSD Element</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getXSDElement()
	 * @generated
	 * @ordered
	 */
	protected XSDElementDeclaration xsdElement;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected XSDTypeDefinition type;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected From from;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BPELPackage.Literals.VARIABLE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public void setName(String newName) {
		String oldName = name;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this, BPELConstants.AT_NAME,
					newName);
			ReconciliationHelper.updateVariableName((WSDLElement) eContainer(),
					newName);
		}
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.VARIABLE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Message getMessageType() {
		if (messageType != null && messageType.eIsProxy()) {
			InternalEObject oldMessageType = (InternalEObject) messageType;
			messageType = (Message) eResolveProxy(oldMessageType);
			if (messageType != oldMessageType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.VARIABLE__MESSAGE_TYPE, oldMessageType,
							messageType));
			}
		}
		return messageType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetMessageType() {
		return messageType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public void setMessageType(Message newMessageType) {
		Message oldMessageType = messageType;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_MESSAGE_TYPE,
					newMessageType == null ? null : newMessageType.getQName());
		}
		messageType = newMessageType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.VARIABLE__MESSAGE_TYPE, oldMessageType,
					messageType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public XSDElementDeclaration getXSDElement() {
		if (xsdElement != null && xsdElement.eIsProxy()) {
			InternalEObject oldXSDElement = (InternalEObject) xsdElement;
			xsdElement = (XSDElementDeclaration) eResolveProxy(oldXSDElement);
			if (xsdElement != oldXSDElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.VARIABLE__XSD_ELEMENT, oldXSDElement,
							xsdElement));
			}
		}
		return xsdElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public XSDElementDeclaration basicGetXSDElement() {
		return xsdElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public void setXSDElement(XSDElementDeclaration newXSDElement) {
		XSDElementDeclaration oldXSDElement = xsdElement;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(this,
					BPELConstants.AT_ELEMENT, newXSDElement == null ? null
							: new QName(newXSDElement.getTargetNamespace(),
									newXSDElement.getName()));
		}
		xsdElement = newXSDElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.VARIABLE__XSD_ELEMENT, oldXSDElement,
					xsdElement));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public XSDTypeDefinition getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject) type;
			type = (XSDTypeDefinition) eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							BPELPackage.VARIABLE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public XSDTypeDefinition basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 */
	public void setType(XSDTypeDefinition newType) {
		XSDTypeDefinition oldType = type;
		if (!isReconciling) {
			ReconciliationHelper.replaceAttribute(
					this,
					BPELConstants.AT_TYPE,
					newType == null ? null : new QName(newType
							.getTargetNamespace(), newType.getName()));
		}
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.VARIABLE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public From getFrom() {
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public NotificationChain basicSetFrom(From newFrom, NotificationChain msgs) {
		From oldFrom = from;
		if (!isReconciling) {
			ReconciliationHelper.replaceChild(this, oldFrom, newFrom);
		}
		from = newFrom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, BPELPackage.VARIABLE__FROM, oldFrom,
					newFrom);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(From newFrom) {
		if (newFrom != from) {
			NotificationChain msgs = null;
			if (from != null)
				msgs = ((InternalEObject) from).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.VARIABLE__FROM,
						null, msgs);
			if (newFrom != null)
				msgs = ((InternalEObject) newFrom).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - BPELPackage.VARIABLE__FROM,
						null, msgs);
			msgs = basicSetFrom(newFrom, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					BPELPackage.VARIABLE__FROM, newFrom, newFrom));
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
		case BPELPackage.VARIABLE__FROM:
			return basicSetFrom(null, msgs);
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
		case BPELPackage.VARIABLE__NAME:
			return getName();
		case BPELPackage.VARIABLE__MESSAGE_TYPE:
			if (resolve)
				return getMessageType();
			return basicGetMessageType();
		case BPELPackage.VARIABLE__XSD_ELEMENT:
			if (resolve)
				return getXSDElement();
			return basicGetXSDElement();
		case BPELPackage.VARIABLE__TYPE:
			if (resolve)
				return getType();
			return basicGetType();
		case BPELPackage.VARIABLE__FROM:
			return getFrom();
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
		case BPELPackage.VARIABLE__NAME:
			setName((String) newValue);
			return;
		case BPELPackage.VARIABLE__MESSAGE_TYPE:
			setMessageType((Message) newValue);
			return;
		case BPELPackage.VARIABLE__XSD_ELEMENT:
			setXSDElement((XSDElementDeclaration) newValue);
			return;
		case BPELPackage.VARIABLE__TYPE:
			setType((XSDTypeDefinition) newValue);
			return;
		case BPELPackage.VARIABLE__FROM:
			setFrom((From) newValue);
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
		case BPELPackage.VARIABLE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case BPELPackage.VARIABLE__MESSAGE_TYPE:
			setMessageType((Message) null);
			return;
		case BPELPackage.VARIABLE__XSD_ELEMENT:
			setXSDElement((XSDElementDeclaration) null);
			return;
		case BPELPackage.VARIABLE__TYPE:
			setType((XSDTypeDefinition) null);
			return;
		case BPELPackage.VARIABLE__FROM:
			setFrom((From) null);
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
		case BPELPackage.VARIABLE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case BPELPackage.VARIABLE__MESSAGE_TYPE:
			return messageType != null;
		case BPELPackage.VARIABLE__XSD_ELEMENT:
			return xsdElement != null;
		case BPELPackage.VARIABLE__TYPE:
			return type != null;
		case BPELPackage.VARIABLE__FROM:
			return from != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // VariableImpl
