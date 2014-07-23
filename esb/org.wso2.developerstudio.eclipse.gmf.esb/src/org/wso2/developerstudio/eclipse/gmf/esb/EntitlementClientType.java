/**
 * Copyright 2009-2012 WSO2, Inc. (http://wso2.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Entitlement Client Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEntitlementClientType()
 * @model
 * @generated
 */
public enum EntitlementClientType implements Enumerator {
	/**
	 * The '<em><b>BASIC AUTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BASIC_AUTH_VALUE
	 * @generated
	 * @ordered
	 */
	BASIC_AUTH(0, "BASIC_AUTH", " SOAP - Basic Auth (WSO2 IS 4.0.0 or later)"), /**
	 * The '<em><b>THRIFT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #THRIFT_VALUE
	 * @generated
	 * @ordered
	 */
	THRIFT(1, "THRIFT", "THRIFT"),

	/**
	 * The '<em><b>SOAP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOAP_VALUE
	 * @generated
	 * @ordered
	 */
	SOAP(2, "SOAP", "SOAP - Authentication Admin (WSO2 IS 3.2.3 or earlier) "), /**
	 * The '<em><b>WSXACML</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WSXACML_VALUE
	 * @generated
	 * @ordered
	 */
	WSXACML(3, "WSXACML", "WSXACML");

	/**
	 * The '<em><b>BASIC AUTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BASIC AUTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BASIC_AUTH
	 * @model literal=" SOAP - Basic Auth (WSO2 IS 4.0.0 or later)"
	 * @generated
	 * @ordered
	 */
	public static final int BASIC_AUTH_VALUE = 0;

	/**
	 * The '<em><b>THRIFT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Thrift</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #THRIFT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int THRIFT_VALUE = 1;

	/**
	 * The '<em><b>SOAP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOAP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOAP
	 * @model literal="SOAP - Authentication Admin (WSO2 IS 3.2.3 or earlier) "
	 * @generated
	 * @ordered
	 */
	public static final int SOAP_VALUE = 2;

	/**
	 * The '<em><b>WSXACML</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WSXACML</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WSXACML
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int WSXACML_VALUE = 3;

	/**
	 * An array of all the '<em><b>Entitlement Client Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EntitlementClientType[] VALUES_ARRAY =
		new EntitlementClientType[] {
			BASIC_AUTH,
			THRIFT,
			SOAP,
			WSXACML,
		};

	/**
	 * A public read-only list of all the '<em><b>Entitlement Client Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EntitlementClientType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Entitlement Client Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntitlementClientType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EntitlementClientType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Entitlement Client Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntitlementClientType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EntitlementClientType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Entitlement Client Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EntitlementClientType get(int value) {
		switch (value) {
			case BASIC_AUTH_VALUE: return BASIC_AUTH;
			case THRIFT_VALUE: return THRIFT;
			case SOAP_VALUE: return SOAP;
			case WSXACML_VALUE: return WSXACML;
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
	private EntitlementClientType(int value, String name, String literal) {
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
	
} //EntitlementClientType
