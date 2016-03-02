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
 * A representation of the literals of the enumeration '<em><b>Fault Soap Version</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultSoapVersion()
 * @model
 * @generated
 */
public enum FaultSoapVersion implements Enumerator {
	/**
	 * The '<em><b>SOAP 11</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOAP_11_VALUE
	 * @generated
	 * @ordered
	 */
	SOAP_11(0, "SOAP_1_1", "soap11"),

	/**
	 * The '<em><b>SOAP 12</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOAP_12_VALUE
	 * @generated
	 * @ordered
	 */
	SOAP_12(1, "SOAP_1_2", "soap12"), /**
	 * The '<em><b>POX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POX_VALUE
	 * @generated
	 * @ordered
	 */
	POX(2, "POX", "POX");

	/**
	 * The '<em><b>SOAP 11</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOAP 11</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOAP_11
	 * @model name="SOAP_1_1" literal="soap11"
	 * @generated
	 * @ordered
	 */
	public static final int SOAP_11_VALUE = 0;

	/**
	 * The '<em><b>SOAP 12</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOAP 12</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOAP_12
	 * @model name="SOAP_1_2" literal="soap12"
	 * @generated
	 * @ordered
	 */
	public static final int SOAP_12_VALUE = 1;

	/**
	 * The '<em><b>POX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POX</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POX
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POX_VALUE = 2;

	/**
	 * An array of all the '<em><b>Fault Soap Version</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FaultSoapVersion[] VALUES_ARRAY =
		new FaultSoapVersion[] {
			SOAP_11,
			SOAP_12,
			POX,
		};

	/**
	 * A public read-only list of all the '<em><b>Fault Soap Version</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FaultSoapVersion> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Fault Soap Version</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FaultSoapVersion get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FaultSoapVersion result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fault Soap Version</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FaultSoapVersion getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FaultSoapVersion result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fault Soap Version</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FaultSoapVersion get(int value) {
		switch (value) {
			case SOAP_11_VALUE: return SOAP_11;
			case SOAP_12_VALUE: return SOAP_12;
			case POX_VALUE: return POX;
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
	private FaultSoapVersion(int value, String name, String literal) {
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
	
} //FaultSoapVersion
