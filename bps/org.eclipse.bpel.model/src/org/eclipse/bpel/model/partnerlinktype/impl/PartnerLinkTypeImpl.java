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
 * $Id: PartnerLinkTypeImpl.java,v 1.8 2011/03/30 18:54:25 rbrodt Exp $
 */
package org.eclipse.bpel.model.partnerlinktype.impl;

import java.util.Collection;
import java.util.Iterator;

import javax.xml.namespace.QName;

// Bugzilla 340654 - renamed to avoid confusion with WSDL's ExtensibilityElement
import org.eclipse.bpel.model.impl.BPELExtensibilityElementImpl;
import org.eclipse.bpel.model.partnerlinktype.PartnerLinkType;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypeFactory;
import org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage;
import org.eclipse.bpel.model.partnerlinktype.Role;
import org.eclipse.bpel.model.partnerlinktype.util.PartnerlinktypeConstants;
import org.eclipse.bpel.model.util.BPELServicesUtility;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.wst.wsdl.internal.impl.ExtensibilityElementImpl;
import org.w3c.dom.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Partner Link Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.partnerlinktype.impl.PartnerLinkTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.partnerlinktype.impl.PartnerLinkTypeImpl#getID <em>ID</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.partnerlinktype.impl.PartnerLinkTypeImpl#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PartnerLinkTypeImpl extends ExtensibilityElementImpl implements
		PartnerLinkType {
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
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> role;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PartnerLinkTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PartnerlinktypePackage.Literals.PARTNER_LINK_TYPE;
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
					PartnerlinktypePackage.PARTNER_LINK_TYPE__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getID() {
		String id = BPELServicesUtility.getIdForExtensibilityElement(this,
				getName());
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Role> getRole() {
		if (role == null) {
			role = new EObjectContainmentEList<Role>(Role.class, this,
					PartnerlinktypePackage.PARTNER_LINK_TYPE__ROLE);
		}
		return role;
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
		case PartnerlinktypePackage.PARTNER_LINK_TYPE__ROLE:
			return ((InternalEList<?>) getRole()).basicRemove(otherEnd, msgs);
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
		case PartnerlinktypePackage.PARTNER_LINK_TYPE__NAME:
			return getName();
		case PartnerlinktypePackage.PARTNER_LINK_TYPE__ID:
			return getID();
		case PartnerlinktypePackage.PARTNER_LINK_TYPE__ROLE:
			return getRole();
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
		case PartnerlinktypePackage.PARTNER_LINK_TYPE__NAME:
			setName((String) newValue);
			return;
		case PartnerlinktypePackage.PARTNER_LINK_TYPE__ROLE:
			getRole().clear();
			getRole().addAll((Collection<? extends Role>) newValue);
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
		case PartnerlinktypePackage.PARTNER_LINK_TYPE__NAME:
			setName(NAME_EDEFAULT);
			return;
		case PartnerlinktypePackage.PARTNER_LINK_TYPE__ROLE:
			getRole().clear();
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
		case PartnerlinktypePackage.PARTNER_LINK_TYPE__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case PartnerlinktypePackage.PARTNER_LINK_TYPE__ID:
			return ID_EDEFAULT == null ? getID() != null : !ID_EDEFAULT
					.equals(getID());
		case PartnerlinktypePackage.PARTNER_LINK_TYPE__ROLE:
			return role != null && !role.isEmpty();
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
					PartnerlinktypeConstants.PARTNER_LINK_TYPE_ELEMENT_TAG);
		return elementType;
	}

	//
	// Reconcile methods: DOM -> Model
	//

	@Override
	public void reconcileAttributes(Element changedElement) {
		//System.out.println("PartnerLinkTypeImpl.reconcileAttributes()");
		super.reconcileAttributes(changedElement);

		setName(PartnerlinktypeConstants.getAttribute(changedElement,
				PartnerlinktypeConstants.NAME_ATTRIBUTE));

		reconcileReferences(false); // TODO true?
	}

	@Override
	public void reconcileReferences(boolean deep) {
		//System.out.println("PartnerLinkTypeImpl.reconcileReferences("+deep+")");
		super.reconcileReferences(deep);
	}

	@Override
	public void handleUnreconciledElement(Element child,
			Collection remainingModelObjects) {
		//System.out.println("PartnerLinkTypeImpl.handleUnreconciledElement()");
		if (PartnerlinktypeConstants.ROLE_ELEMENT_TAG.equals(child
				.getLocalName())) {
			Role role = PartnerlinktypeFactory.eINSTANCE.createRole();
			role.setEnclosingDefinition(getEnclosingDefinition());
			role.setElement(child);
			getRole().add(role);
		}
	}

	@Override
	protected void handleReconciliation(Collection remainingModelObjects) {
		//System.out.println("PartnerLinkTypeImpl.handleReconciliation("+remainingModelObjects+")");
		for (Iterator i = remainingModelObjects.iterator(); i.hasNext();) {
			remove(this, i.next());
		}
	}

	protected void remove(Object component, Object modelObject) {
		//System.out.println("PartnerLinkTypeImpl.remove("+component+","+modelObject+")");
		PartnerLinkType plt = (PartnerLinkType) component;
		if (modelObject instanceof Role) {
			plt.getRole().remove(modelObject);
		}
	}

	//
	// For reconciliation: Model -> DOM
	//

	@Override
	protected void changeAttribute(EAttribute eAttribute) {
		//System.out.println("PartnerLinkTypeImpl.changeAttribute("+eAttribute+")");

		if (isReconciling)
			return;

		super.changeAttribute(eAttribute);
		Element theElement = getElement();
		if (theElement != null) {
			if (eAttribute == null
					|| eAttribute == PartnerlinktypePackage.eINSTANCE
							.getPartnerLinkType_Name())
				niceSetAttribute(theElement,
						PartnerlinktypeConstants.NAME_ATTRIBUTE, getName());
		}
	}

	@Override
	protected void changeReference(EReference eReference) {
		//System.out.println("PartnerLinkTypeImpl.changeReference("+eReference+")");

		if (isReconciling)
			return;

		super.changeReference(eReference);
		Element theElement = getElement();
		if (theElement != null) {
			if (eReference == null
					|| eReference == PartnerlinktypePackage.eINSTANCE
							.getPartnerLinkType_Role()) {
				// TODO: Should I do something here?
				//                List roles = getRole();
				//                for (Iterator i = roles.iterator(); i.hasNext();)
				//                {
				//                    Role role = (Role) i.next();
				//                }
			}
		}
	}

	@Override
	public Element createElement() {
		//System.out.println("PartnerLinkTypeImpl.createElement()");

		// Register a prefix for the namespace.  
		// If we don't do this, the WSDL model will deserialize our elements as UnknownExtensibilityElements.

		//if (getEnclosingDefinition().getPrefix(PartnerlinktypeConstants.NAMESPACE) == null) {
		//	getEnclosingDefinition().addNamespace(PartnerlinktypePackage.eNS_PREFIX, PartnerlinktypeConstants.NAMESPACE);
		//}		
		// System.out.println("Namespace: " + getEnclosingDefinition().getNamespaces());

		Element newElement = super.createElement();

		for (Iterator<Role> i = getRole().iterator(); i.hasNext();) {
			Object obj = i.next();
			if (obj instanceof Role) {
				Role role = (Role) obj;
				Element child = ((RoleImpl) role).createElement();
				newElement.appendChild(child);
			}
		}

		return newElement;
	}

} //PartnerLinkTypeImpl
