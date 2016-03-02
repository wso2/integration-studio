/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.wso2.developerstudio.eclipse.gmf.esb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Proxy Wsdl Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getProxyWsdlType()
 * @model
 * @generated
 */
public enum ProxyWsdlType implements Enumerator {
	/**
	 * The '<em><b>NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NONE_VALUE
	 * @generated
	 * @ordered
	 */
	NONE(0, "NONE", "NONE"),

	/**
	 * The '<em><b>INLINE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INLINE_VALUE
	 * @generated
	 * @ordered
	 */
	INLINE(1, "INLINE", "INLINE"),

	/**
	 * The '<em><b>SOURCE URL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOURCE_URL_VALUE
	 * @generated
	 * @ordered
	 */
	SOURCE_URL(2, "SOURCE_URL", "SOURCE_URL"),

	/**
	 * The '<em><b>REGISTRY KEY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REGISTRY_KEY_VALUE
	 * @generated
	 * @ordered
	 */
	REGISTRY_KEY(3, "REGISTRY_KEY", "REGISTRY_KEY"), /**
	 * The '<em><b>ENDPOINT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ENDPOINT_VALUE
	 * @generated
	 * @ordered
	 */
	ENDPOINT(4, "ENDPOINT", "ENDPOINT");

	/**
	 * The '<em><b>NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NONE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int NONE_VALUE = 0;

	/**
	 * The '<em><b>INLINE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INLINE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INLINE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int INLINE_VALUE = 1;

	/**
	 * The '<em><b>SOURCE URL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOURCE URL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOURCE_URL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOURCE_URL_VALUE = 2;

	/**
	 * The '<em><b>REGISTRY KEY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>REGISTRY KEY</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REGISTRY_KEY
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int REGISTRY_KEY_VALUE = 3;

	/**
	 * The '<em><b>ENDPOINT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ENDPOINT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ENDPOINT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ENDPOINT_VALUE = 4;

	/**
	 * An array of all the '<em><b>Proxy Wsdl Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ProxyWsdlType[] VALUES_ARRAY =
		new ProxyWsdlType[] {
			NONE,
			INLINE,
			SOURCE_URL,
			REGISTRY_KEY,
			ENDPOINT,
		};

	/**
	 * A public read-only list of all the '<em><b>Proxy Wsdl Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ProxyWsdlType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Proxy Wsdl Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProxyWsdlType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProxyWsdlType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Proxy Wsdl Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProxyWsdlType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ProxyWsdlType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Proxy Wsdl Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ProxyWsdlType get(int value) {
		switch (value) {
			case NONE_VALUE: return NONE;
			case INLINE_VALUE: return INLINE;
			case SOURCE_URL_VALUE: return SOURCE_URL;
			case REGISTRY_KEY_VALUE: return REGISTRY_KEY;
			case ENDPOINT_VALUE: return ENDPOINT;
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
	private ProxyWsdlType(int value, String name, String literal) {
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
	
} //ProxyWsdlType
