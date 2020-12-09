/**
 */
package org.wso2.developerstudio.datamapper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Comparison Operator Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.datamapper.DataMapperPackage#getComparisonOperatorType()
 * @model
 * @generated
 */
public enum ComparisonOperatorType implements Enumerator {
	/**
	 * The '<em><b>EQUAL VALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUAL_VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	EQUAL_VALUE(0, "EQUAL_VALUE", "=="),

	/**
	 * The '<em><b>EQUAL VALUE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EQUAL_VALUE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	EQUAL_VALUE_TYPE(1, "EQUAL_VALUE_TYPE", "==="),

	/**
	 * The '<em><b>NOT EQUAL VALUE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUAL_VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_EQUAL_VALUE(2, "NOT_EQUAL_VALUE", "!="),

	/**
	 * The '<em><b>NOT EQUAL VALUE TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUAL_VALUE_TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_EQUAL_VALUE_TYPE(3, "NOT_EQUAL_VALUE_TYPE", "!=="),

	/**
	 * The '<em><b>GREATER THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER_THAN(4, "GREATER_THAN", ">"),

	/**
	 * The '<em><b>GREATER OR EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GREATER_OR_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	GREATER_OR_EQUAL(5, "GREATER_OR_EQUAL", ">="),

	/**
	 * The '<em><b>LOWER THAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_THAN_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_THAN(6, "LOWER_THAN", "<"),

	/**
	 * The '<em><b>LOWER OR EQUAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOWER_OR_EQUAL_VALUE
	 * @generated
	 * @ordered
	 */
	LOWER_OR_EQUAL(7, "LOWER_OR_EQUAL", "<=");

	/**
	 * The '<em><b>EQUAL VALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUAL VALUE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUAL_VALUE
	 * @model literal="=="
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL_VALUE_VALUE = 0;

	/**
	 * The '<em><b>EQUAL VALUE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>EQUAL VALUE TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EQUAL_VALUE_TYPE
	 * @model literal="==="
	 * @generated
	 * @ordered
	 */
	public static final int EQUAL_VALUE_TYPE_VALUE = 1;

	/**
	 * The '<em><b>NOT EQUAL VALUE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT EQUAL VALUE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUAL_VALUE
	 * @model literal="!="
	 * @generated
	 * @ordered
	 */
	public static final int NOT_EQUAL_VALUE_VALUE = 2;

	/**
	 * The '<em><b>NOT EQUAL VALUE TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>NOT EQUAL VALUE TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NOT_EQUAL_VALUE_TYPE
	 * @model literal="!=="
	 * @generated
	 * @ordered
	 */
	public static final int NOT_EQUAL_VALUE_TYPE_VALUE = 3;

	/**
	 * The '<em><b>GREATER THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATER THAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER_THAN
	 * @model literal=">"
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_THAN_VALUE = 4;

	/**
	 * The '<em><b>GREATER OR EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>GREATER OR EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GREATER_OR_EQUAL
	 * @model literal=">="
	 * @generated
	 * @ordered
	 */
	public static final int GREATER_OR_EQUAL_VALUE = 5;

	/**
	 * The '<em><b>LOWER THAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOWER THAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER_THAN
	 * @model literal="<"
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_THAN_VALUE = 6;

	/**
	 * The '<em><b>LOWER OR EQUAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LOWER OR EQUAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOWER_OR_EQUAL
	 * @model literal="<="
	 * @generated
	 * @ordered
	 */
	public static final int LOWER_OR_EQUAL_VALUE = 7;

	/**
	 * An array of all the '<em><b>Comparison Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ComparisonOperatorType[] VALUES_ARRAY =
		new ComparisonOperatorType[] {
			EQUAL_VALUE,
			EQUAL_VALUE_TYPE,
			NOT_EQUAL_VALUE,
			NOT_EQUAL_VALUE_TYPE,
			GREATER_THAN,
			GREATER_OR_EQUAL,
			LOWER_THAN,
			LOWER_OR_EQUAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Comparison Operator Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ComparisonOperatorType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Comparison Operator Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComparisonOperatorType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComparisonOperatorType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Comparison Operator Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComparisonOperatorType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ComparisonOperatorType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Comparison Operator Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ComparisonOperatorType get(int value) {
		switch (value) {
			case EQUAL_VALUE_VALUE: return EQUAL_VALUE;
			case EQUAL_VALUE_TYPE_VALUE: return EQUAL_VALUE_TYPE;
			case NOT_EQUAL_VALUE_VALUE: return NOT_EQUAL_VALUE;
			case NOT_EQUAL_VALUE_TYPE_VALUE: return NOT_EQUAL_VALUE_TYPE;
			case GREATER_THAN_VALUE: return GREATER_THAN;
			case GREATER_OR_EQUAL_VALUE: return GREATER_OR_EQUAL;
			case LOWER_THAN_VALUE: return LOWER_THAN;
			case LOWER_OR_EQUAL_VALUE: return LOWER_OR_EQUAL;
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
	private ComparisonOperatorType(int value, String name, String literal) {
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
	
} //ComparisonOperatorType
