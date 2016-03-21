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
 * $Id: PartnerLinkType.java,v 1.3 2007/08/01 21:02:32 mchmielewski Exp $
 */
package org.eclipse.bpel.model.partnerlinktype;

import org.eclipse.emf.common.util.EList;

import org.eclipse.wst.wsdl.ExtensibilityElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Partner Link Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.partnerlinktype.PartnerLinkType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.partnerlinktype.PartnerLinkType#getID <em>ID</em>}</li>
 *   <li>{@link org.eclipse.bpel.model.partnerlinktype.PartnerLinkType#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage#getPartnerLinkType()
 * @model
 * @generated
 */
public interface PartnerLinkType extends ExtensibilityElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage#getPartnerLinkType_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.partnerlinktype.PartnerLinkType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage#getPartnerLinkType_ID()
	 * @model id="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getID();

	/**
	 * Returns the value of the '<em><b>Role</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.bpel.model.partnerlinktype.Role}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' containment reference list.
	 * @see org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage#getPartnerLinkType_Role()
	 * @model containment="true"
	 * @generated
	 */
	EList<Role> getRole();

} // PartnerLinkType
