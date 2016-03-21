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
 * $Id: RolePortType.java,v 1.1 2005/11/29 18:50:28 james Exp $
 */
package org.eclipse.bpel.model.partnerlinktype;

import org.eclipse.wst.wsdl.ExtensibilityElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Port Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.bpel.model.partnerlinktype.RolePortType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage#getRolePortType()
 * @model
 * @generated
 */
public interface RolePortType extends ExtensibilityElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(Object)
	 * @see org.eclipse.bpel.model.partnerlinktype.PartnerlinktypePackage#getRolePortType_Name()
	 * @model
	 * @generated
	 */
	Object getName();

	/**
	 * Sets the value of the '{@link org.eclipse.bpel.model.partnerlinktype.RolePortType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(Object value);

} // RolePortType
