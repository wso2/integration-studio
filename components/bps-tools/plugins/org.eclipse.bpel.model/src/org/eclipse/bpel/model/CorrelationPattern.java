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
 * $Id: CorrelationPattern.java,v 1.8 2011/03/30 14:59:18 rbrodt Exp $
 */
package org.eclipse.bpel.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Correlation Pattern</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.bpel.model.BPELPackage#getCorrelationPattern()
 * @model
 * @generated
 */
public enum CorrelationPattern implements Enumerator {
	/**
	 * The '<em><b>Request</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REQUEST
	 * @generated
	 * @ordered
	 */
	REQUEST_LITERAL(0, "request", "request"), /**
											  * The '<em><b>Response</b></em>' literal object.
											  * <!-- begin-user-doc -->
											  * <!-- end-user-doc -->
											  * @see #RESPONSE
											  * @generated
											  * @ordered
											  */
	RESPONSE_LITERAL(1, "response", "response"), /**
												 * The '<em><b>Requestresponse</b></em>' literal object.
												 * <!-- begin-user-doc -->
												 * <!-- end-user-doc -->
												 * @see #REQUESTRESPONSE
												 * @generated
												 * @ordered
												 */
	REQUESTRESPONSE_LITERAL(2, "requestresponse", "request-response");
	/**
	 * The '<em><b>Request</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Request</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REQUEST_LITERAL
	 * @model name="request"
	 * @generated
	 * @ordered
	 */
	public static final int REQUEST = 0;

	/**
	 * The '<em><b>Response</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Response</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESPONSE_LITERAL
	 * @model name="response"
	 * @generated
	 * @ordered
	 */
	public static final int RESPONSE = 1;

	/**
	 * The '<em><b>Requestresponse</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Requestresponse</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * Bugzilla 340654 - fix request-response literal name
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REQUESTRESPONSE_LITERAL
	 * @model name="requestresponse" literal="request-response"
	 * @generated
	 * @ordered
	 */
	public static final int REQUESTRESPONSE = 2;

	/**
	 * An array of all the '<em><b>Correlation Pattern</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CorrelationPattern[] VALUES_ARRAY = new CorrelationPattern[] {
			REQUEST_LITERAL, RESPONSE_LITERAL, REQUESTRESPONSE_LITERAL, };

	/**
	 * A public read-only list of all the '<em><b>Correlation Pattern</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CorrelationPattern> VALUES = Collections
			.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Correlation Pattern</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CorrelationPattern get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CorrelationPattern result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Correlation Pattern</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CorrelationPattern getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CorrelationPattern result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Correlation Pattern</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CorrelationPattern get(int value) {
		switch (value) {
		case REQUEST:
			return REQUEST_LITERAL;
		case RESPONSE:
			return RESPONSE_LITERAL;
		case REQUESTRESPONSE:
			return REQUESTRESPONSE_LITERAL;
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
	private CorrelationPattern(int value, String name, String literal) {
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
