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
 * A representation of the literals of the enumeration '<em><b>Sql Executor Isolation Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSqlExecutorIsolationLevel()
 * @model
 * @generated
 */
public enum SqlExecutorIsolationLevel implements Enumerator {
	/**
	 * The '<em><b>TRANSACTION NONE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSACTION_NONE_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSACTION_NONE(0, "TRANSACTION_NONE", "Connection.TRANSACTION_NONE"),

	/**
	 * The '<em><b>TRANSACTION READ COMMITTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSACTION_READ_COMMITTED_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSACTION_READ_COMMITTED(1, "TRANSACTION_READ_COMMITTED", "Connection.TRANSACTION_READ_COMMITTED"),

	/**
	 * The '<em><b>TRANSACTION READ UNCOMMITTED</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSACTION_READ_UNCOMMITTED_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSACTION_READ_UNCOMMITTED(2, "TRANSACTION_READ_UNCOMMITTED", "Connection.TRANSACTION_READ_UNCOMMITTED"),

	/**
	 * The '<em><b>TRANSACTION REPEATABLE READ</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSACTION_REPEATABLE_READ_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSACTION_REPEATABLE_READ(3, "TRANSACTION_REPEATABLE_READ", "Connection.TRANSACTION_REPEATABLE_READ"),

	/**
	 * The '<em><b>TRANSACTION SERIALIZABLE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TRANSACTION_SERIALIZABLE_VALUE
	 * @generated
	 * @ordered
	 */
	TRANSACTION_SERIALIZABLE(4, "TRANSACTION_SERIALIZABLE", "Connection.TRANSACTION_SERIALIZABLE"),

	/**
	 * The '<em><b>DEFAULT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEFAULT_VALUE
	 * @generated
	 * @ordered
	 */
	DEFAULT(5, "DEFAULT", "DEFAULT");

	/**
	 * The '<em><b>TRANSACTION NONE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSACTION NONE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSACTION_NONE
	 * @model literal="Connection.TRANSACTION_NONE"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSACTION_NONE_VALUE = 0;

	/**
	 * The '<em><b>TRANSACTION READ COMMITTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSACTION READ COMMITTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSACTION_READ_COMMITTED
	 * @model literal="Connection.TRANSACTION_READ_COMMITTED"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSACTION_READ_COMMITTED_VALUE = 1;

	/**
	 * The '<em><b>TRANSACTION READ UNCOMMITTED</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSACTION READ UNCOMMITTED</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSACTION_READ_UNCOMMITTED
	 * @model literal="Connection.TRANSACTION_READ_UNCOMMITTED"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSACTION_READ_UNCOMMITTED_VALUE = 2;

	/**
	 * The '<em><b>TRANSACTION REPEATABLE READ</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSACTION REPEATABLE READ</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSACTION_REPEATABLE_READ
	 * @model literal="Connection.TRANSACTION_REPEATABLE_READ"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSACTION_REPEATABLE_READ_VALUE = 3;

	/**
	 * The '<em><b>TRANSACTION SERIALIZABLE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TRANSACTION SERIALIZABLE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TRANSACTION_SERIALIZABLE
	 * @model literal="Connection.TRANSACTION_SERIALIZABLE"
	 * @generated
	 * @ordered
	 */
	public static final int TRANSACTION_SERIALIZABLE_VALUE = 4;

	/**
	 * The '<em><b>DEFAULT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEFAULT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEFAULT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEFAULT_VALUE = 5;

	/**
	 * An array of all the '<em><b>Sql Executor Isolation Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SqlExecutorIsolationLevel[] VALUES_ARRAY =
		new SqlExecutorIsolationLevel[] {
			TRANSACTION_NONE,
			TRANSACTION_READ_COMMITTED,
			TRANSACTION_READ_UNCOMMITTED,
			TRANSACTION_REPEATABLE_READ,
			TRANSACTION_SERIALIZABLE,
			DEFAULT,
		};

	/**
	 * A public read-only list of all the '<em><b>Sql Executor Isolation Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SqlExecutorIsolationLevel> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Sql Executor Isolation Level</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SqlExecutorIsolationLevel get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SqlExecutorIsolationLevel result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sql Executor Isolation Level</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SqlExecutorIsolationLevel getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SqlExecutorIsolationLevel result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Sql Executor Isolation Level</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SqlExecutorIsolationLevel get(int value) {
		switch (value) {
			case TRANSACTION_NONE_VALUE: return TRANSACTION_NONE;
			case TRANSACTION_READ_COMMITTED_VALUE: return TRANSACTION_READ_COMMITTED;
			case TRANSACTION_READ_UNCOMMITTED_VALUE: return TRANSACTION_READ_UNCOMMITTED;
			case TRANSACTION_REPEATABLE_READ_VALUE: return TRANSACTION_REPEATABLE_READ;
			case TRANSACTION_SERIALIZABLE_VALUE: return TRANSACTION_SERIALIZABLE;
			case DEFAULT_VALUE: return DEFAULT;
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
	private SqlExecutorIsolationLevel(int value, String name, String literal) {
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
	
} //SqlExecutorIsolationLevel
