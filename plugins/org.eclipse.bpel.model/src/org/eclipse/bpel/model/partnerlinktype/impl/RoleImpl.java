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
 * $Id: RoleImpl.java,v 1.10 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.partnerlinktype.impl;

import javax.xml.namespace.QName;

//Bugzilla 340654 - renamed to avoid confusion with WSDL's ExtensibilityElement
import org.eclipse.bpel.model.impl.BPELExtensibilityElementImpl;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.partnerlinktype.util.PartnerlinktypeConstants;
import org.eclipse.bpel.model.util.BPELServicesUtility;
import org.eclipse.bpel.model.util.WSDLUtil;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.wst.wsdl.internal.impl.ExtensibilityElementImpl;
import org.eclipse.wst.wsdl.Definition;
import org.eclipse.wst.wsdl.PortType;
import org.w3c.dom.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.partnerlinktype.impl.RoleImpl#getID <em>ID</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.partnerlinktype.impl.RoleImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.partnerlinktype.impl.RoleImpl#getPortType <em>Port Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleImpl extends ExtensibilityElementImpl implements Role {
	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPortType() <em>Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortType()
	 * @generated
	 * @ordered
	 */
	protected static final Object PORT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPortType() <em>Port Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortType()
	 * @generated
	 * @ordered
	 */
	protected Object portType = PORT_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartnerlinktypePackage.Literals.ROLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @customized
	 */
	public String getID() {
		String id = ID_EDEFAULT;
		PartnerLinkType plt = (PartnerLinkType) eContainer();
		if (plt != null) {
			id = BPELServicesUtility.getIdForNestedNamedObject(plt.getID(),
					this, getName());
		}
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					PartnerlinktypePackage.ROLE__NAME, oldName, name));
	}

	/**
	 * @customized
	 */
	public Object getPortType() {
		if (portType instanceof PortType && ((PortType) portType).eIsProxy()) {
			PortType oldPortType = (PortType) portType;
			portType = eResolveProxy((InternalEObject) portType);
			if (portType != oldPortType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							PartnerlinktypePackage.ROLE__PORT_TYPE,
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
	public void setPortType(Object newPortType) {
		Object oldPortType = portType;
		portType = newPortType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					PartnerlinktypePackage.ROLE__PORT_TYPE, oldPortType,
					portType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PartnerlinktypePackage.ROLE__ID:
			return getID();
		case PartnerlinktypePackage.ROLE__NAME:
			return getName();
		case PartnerlinktypePackage.ROLE__PORT_TYPE:
			return getPortType();
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
		case PartnerlinktypePackage.ROLE__NAME:
			setName((String) newValue);
			return;
		case PartnerlinktypePackage.ROLE__PORT_TYPE:
			setPortType(newValue);
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
		case PartnerlinktypePackage.ROLE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case PartnerlinktypePackage.ROLE__PORT_TYPE:
			setPortType(PORT_TYPE_EDEFAULT);
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
		case PartnerlinktypePackage.ROLE__ID:
			return ID_EDEFAULT == null ? getID() != null : !ID_EDEFAULT
					.equals(getID());
		case PartnerlinktypePackage.ROLE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case PartnerlinktypePackage.ROLE__PORT_TYPE:
			return PORT_TYPE_EDEFAULT == null ? portType != null
					: !PORT_TYPE_EDEFAULT.equals(portType);
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
		result.append(" (name: "); //$NON-NLS-1$
		result.append(name);
		result.append(", portType: "); //$NON-NLS-1$
		result.append(portType);
		result.append(')');
		return result.toString();
	}

	/**
	 * Override the XML element token.
	 */
	@Override
	public QName getElementType() {
		if (elementType == null)
			elementType = new QName(PartnerlinktypeConstants.NAMESPACE,
					PartnerlinktypeConstants.ROLE_ELEMENT_TAG);
		return elementType;
	}

	//
	// Reconcile methods: DOM -> Model
	//

	@Override
	public void reconcileAttributes(Element changedElement) {
		super.reconcileAttributes(changedElement);

		setName(PartnerlinktypeConstants.getAttribute(changedElement,
				PartnerlinktypeConstants.NAME_ATTRIBUTE));

		reconcileReferences(false);
	}

	@Override
	public void reconcileReferences(boolean deep) {

		if (deep == false) {
			return;
		}

		// Reconcile the PortType reference.
		if (element != null
				&& element
						.hasAttribute(PartnerlinktypeConstants.PORT_TYPE_ATTRIBUTE)) {
			Definition definition = getEnclosingDefinition();
			if (definition != null) {
				QName portTypeQName = createQName(
						definition,
						element.getAttribute(PartnerlinktypeConstants.PORT_TYPE_ATTRIBUTE));

				PortType newPortType = null;

				if (portTypeQName != null) {
					newPortType = WSDLUtil.resolvePortType(definition,
							portTypeQName);
				}

				if (newPortType != null && newPortType != getPortType()) {
					setPortType(newPortType);
				}
			}

		}
		super.reconcileReferences(deep);
	}

	//
	// For reconciliation: Model -> DOM
	//

	@Override
	protected void changeAttribute(EAttribute eAttribute) {
		//System.out.println("RoleImpl.changeAttribute("+eAttribute+")");
		if (isReconciling)
			return;

		super.changeAttribute(eAttribute);
		Element theElement = getElement();
		if (theElement != null) {
			if (eAttribute == null
					|| eAttribute == PartnerlinktypePackage.eINSTANCE
							.getRole_Name())
				niceSetAttribute(theElement,
						PartnerlinktypeConstants.NAME_ATTRIBUTE, getName());
			if (eAttribute == null
					|| eAttribute == PartnerlinktypePackage.eINSTANCE
							.getRole_PortType()) {
				PortType pt = (PortType) getPortType();
				QName qname = (pt == null) ? null : pt.getQName();
				if (qname != null)
					niceSetAttributeURIValue(
							theElement,
							PartnerlinktypeConstants.PORT_TYPE_ATTRIBUTE,
							qname.getNamespaceURI() + "#"
									+ qname.getLocalPart());
			}

		}
	}
} //RoleImpl
