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
 * A representation of the literals of the enumeration '<em><b>End Point Attachment Optimization</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getEndPointAttachmentOptimization()
 * @model
 * @generated
 */
public enum EndPointAttachmentOptimization implements Enumerator {
	/**
	 * The '<em><b>LEAVE AS IS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEAVE_AS_IS_VALUE
	 * @generated
	 * @ordered
	 */
	LEAVE_AS_IS(0, "LEAVE_AS_IS", "LEAVE_AS_IS"),

	/**
	 * The '<em><b>MTOM</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MTOM_VALUE
	 * @generated
	 * @ordered
	 */
	MTOM(1, "MTOM", "mtom"),

	/**
	 * The '<em><b>SWA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SWA_VALUE
	 * @generated
	 * @ordered
	 */
	SWA(2, "SWA", "swa");

	/**
	 * The '<em><b>LEAVE AS IS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LEAVE AS IS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LEAVE_AS_IS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LEAVE_AS_IS_VALUE = 0;

	/**
	 * The '<em><b>MTOM</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MTOM</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MTOM
	 * @model literal="mtom"
	 * @generated
	 * @ordered
	 */
	public static final int MTOM_VALUE = 1;

	/**
	 * The '<em><b>SWA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SWA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SWA
	 * @model literal="swa"
	 * @generated
	 * @ordered
	 */
	public static final int SWA_VALUE = 2;

	/**
	 * An array of all the '<em><b>End Point Attachment Optimization</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EndPointAttachmentOptimization[] VALUES_ARRAY =
		new EndPointAttachmentOptimization[] {
			LEAVE_AS_IS,
			MTOM,
			SWA,
		};

	/**
	 * A public read-only list of all the '<em><b>End Point Attachment Optimization</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EndPointAttachmentOptimization> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>End Point Attachment Optimization</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EndPointAttachmentOptimization get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EndPointAttachmentOptimization result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>End Point Attachment Optimization</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EndPointAttachmentOptimization getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EndPointAttachmentOptimization result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>End Point Attachment Optimization</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EndPointAttachmentOptimization get(int value) {
		switch (value) {
			case LEAVE_AS_IS_VALUE: return LEAVE_AS_IS;
			case MTOM_VALUE: return MTOM;
			case SWA_VALUE: return SWA;
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
	private EndPointAttachmentOptimization(int value, String name, String literal) {
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
	
} //EndPointAttachmentOptimization
