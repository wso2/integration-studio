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
 * $Id: EndpointReferenceRole.java,v 1.5 2009/04/14 10:50:37 smoser Exp $
 */
package org.eclipse.bpel.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Endpoint Reference Role</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.model.BPELPackage#getEndpointReferenceRole()
 * @model
 * @generated
 */
public enum EndpointReferenceRole implements Enumerator {
	/**
	 * The '<em><b>My Role</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MY_ROLE
	 * @generated
	 * @ordered
	 */
	MY_ROLE_LITERAL(0, "myRole", "myRole"),
	/**
	 * The '<em><b>Partner Role</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTNER_ROLE
	 * @generated
	 * @ordered
	 */
	PARTNER_ROLE_LITERAL(1, "partnerRole", "partnerRole");
	/**
	 * The '<em><b>My Role</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>My Role</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MY_ROLE_LITERAL
	 * @model name="myRole"
	 * @generated
	 * @ordered
	 */
	public static final int MY_ROLE = 0;

	/**
	 * The '<em><b>Partner Role</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Partner Role</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARTNER_ROLE_LITERAL
	 * @model name="partnerRole"
	 * @generated
	 * @ordered
	 */
	public static final int PARTNER_ROLE = 1;

	/**
	 * An array of all the '<em><b>Endpoint Reference Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EndpointReferenceRole[] VALUES_ARRAY = new EndpointReferenceRole[] {
			MY_ROLE_LITERAL, PARTNER_ROLE_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Endpoint Reference Role</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EndpointReferenceRole> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Endpoint Reference Role</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EndpointReferenceRole get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EndpointReferenceRole result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Endpoint Reference Role</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EndpointReferenceRole getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EndpointReferenceRole result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Endpoint Reference Role</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EndpointReferenceRole get(int value) {
		switch (value) {
		case MY_ROLE:
			return MY_ROLE_LITERAL;
		case PARTNER_ROLE:
			return PARTNER_ROLE_LITERAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EndpointReferenceRole(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
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
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
}
