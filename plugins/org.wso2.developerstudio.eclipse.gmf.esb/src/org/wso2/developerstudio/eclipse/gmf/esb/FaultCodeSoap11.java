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
 * A representation of the literals of the enumeration '<em><b>Fault Code Soap11</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getFaultCodeSoap11()
 * @model
 * @generated
 */
public enum FaultCodeSoap11 implements Enumerator {
	/**
	 * The '<em><b>VERSION MISSMATCH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VERSION_MISSMATCH_VALUE
	 * @generated
	 * @ordered
	 */
	VERSION_MISSMATCH(0, "VERSION_MISSMATCH", "VersionMismatch"),

	/**
	 * The '<em><b>MUST UNDERSTAND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MUST_UNDERSTAND_VALUE
	 * @generated
	 * @ordered
	 */
	MUST_UNDERSTAND(1, "MUST_UNDERSTAND", "MustUnderstand"),

	/**
	 * The '<em><b>CLIENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CLIENT_VALUE
	 * @generated
	 * @ordered
	 */
	CLIENT(2, "CLIENT", "Client"),

	/**
	 * The '<em><b>SERVER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SERVER_VALUE
	 * @generated
	 * @ordered
	 */
	SERVER(3, "SERVER", "Server");

	/**
	 * The '<em><b>VERSION MISSMATCH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>VERSION MISSMATCH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VERSION_MISSMATCH
	 * @model literal="VersionMismatch"
	 * @generated
	 * @ordered
	 */
	public static final int VERSION_MISSMATCH_VALUE = 0;

	/**
	 * The '<em><b>MUST UNDERSTAND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MUST UNDERSTAND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MUST_UNDERSTAND
	 * @model literal="MustUnderstand"
	 * @generated
	 * @ordered
	 */
	public static final int MUST_UNDERSTAND_VALUE = 1;

	/**
	 * The '<em><b>CLIENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CLIENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CLIENT
	 * @model literal="Client"
	 * @generated
	 * @ordered
	 */
	public static final int CLIENT_VALUE = 2;

	/**
	 * The '<em><b>SERVER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SERVER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SERVER
	 * @model literal="Server"
	 * @generated
	 * @ordered
	 */
	public static final int SERVER_VALUE = 3;

	/**
	 * An array of all the '<em><b>Fault Code Soap11</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FaultCodeSoap11[] VALUES_ARRAY =
		new FaultCodeSoap11[] {
			VERSION_MISSMATCH,
			MUST_UNDERSTAND,
			CLIENT,
			SERVER,
		};

	/**
	 * A public read-only list of all the '<em><b>Fault Code Soap11</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FaultCodeSoap11> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Fault Code Soap11</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FaultCodeSoap11 get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FaultCodeSoap11 result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fault Code Soap11</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FaultCodeSoap11 getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FaultCodeSoap11 result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Fault Code Soap11</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FaultCodeSoap11 get(int value) {
		switch (value) {
			case VERSION_MISSMATCH_VALUE: return VERSION_MISSMATCH;
			case MUST_UNDERSTAND_VALUE: return MUST_UNDERSTAND;
			case CLIENT_VALUE: return CLIENT;
			case SERVER_VALUE: return SERVER;
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
	private FaultCodeSoap11(int value, String name, String literal) {
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
	
} //FaultCodeSoap11
