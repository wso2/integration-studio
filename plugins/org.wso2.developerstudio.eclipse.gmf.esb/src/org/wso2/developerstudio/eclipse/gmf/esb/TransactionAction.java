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
 * A representation of the literals of the enumeration '<em><b>Transaction Action</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getTransactionAction()
 * @model
 * @generated
 */
public enum TransactionAction implements Enumerator {
	/**
	 * The '<em><b>COMMIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMIT_VALUE
	 * @generated
	 * @ordered
	 */
	COMMIT(0, "COMMIT", "Commit transaction"),

	/**
	 * The '<em><b>FAULT IF NO TRANSACTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAULT_IF_NO_TRANSACTION_VALUE
	 * @generated
	 * @ordered
	 */
	FAULT_IF_NO_TRANSACTION(1, "FAULT_IF_NO_TRANSACTION", "Fault if no transaction"),

	/**
	 * The '<em><b>INITIATE NEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INITIATE_NEW_VALUE
	 * @generated
	 * @ordered
	 */
	INITIATE_NEW(2, "INITIATE_NEW", "Initiate new transaction"),

	/**
	 * The '<em><b>RESUME</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RESUME_VALUE
	 * @generated
	 * @ordered
	 */
	RESUME(3, "RESUME", "Resume transaction"),

	/**
	 * The '<em><b>SUSPEND</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SUSPEND_VALUE
	 * @generated
	 * @ordered
	 */
	SUSPEND(4, "SUSPEND", "Suspend transaction"),

	/**
	 * The '<em><b>ROLLBACK</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROLLBACK_VALUE
	 * @generated
	 * @ordered
	 */
	ROLLBACK(5, "ROLLBACK", "Rollback transaction"),

	/**
	 * The '<em><b>USE EXISTING OR NEW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USE_EXISTING_OR_NEW_VALUE
	 * @generated
	 * @ordered
	 */
	USE_EXISTING_OR_NEW(6, "USE_EXISTING_OR_NEW", "Use existing or initiate transaction");

	/**
	 * The '<em><b>COMMIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COMMIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMMIT
	 * @model literal="Commit transaction"
	 * @generated
	 * @ordered
	 */
	public static final int COMMIT_VALUE = 0;

	/**
	 * The '<em><b>FAULT IF NO TRANSACTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FAULT IF NO TRANSACTION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAULT_IF_NO_TRANSACTION
	 * @model literal="Fault if no transaction"
	 * @generated
	 * @ordered
	 */
	public static final int FAULT_IF_NO_TRANSACTION_VALUE = 1;

	/**
	 * The '<em><b>INITIATE NEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>INITIATE NEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INITIATE_NEW
	 * @model literal="Initiate new transaction"
	 * @generated
	 * @ordered
	 */
	public static final int INITIATE_NEW_VALUE = 2;

	/**
	 * The '<em><b>RESUME</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>RESUME</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #RESUME
	 * @model literal="Resume transaction"
	 * @generated
	 * @ordered
	 */
	public static final int RESUME_VALUE = 3;

	/**
	 * The '<em><b>SUSPEND</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SUSPEND</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SUSPEND
	 * @model literal="Suspend transaction"
	 * @generated
	 * @ordered
	 */
	public static final int SUSPEND_VALUE = 4;

	/**
	 * The '<em><b>ROLLBACK</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ROLLBACK</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ROLLBACK
	 * @model literal="Rollback transaction"
	 * @generated
	 * @ordered
	 */
	public static final int ROLLBACK_VALUE = 5;

	/**
	 * The '<em><b>USE EXISTING OR NEW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>USE EXISTING OR NEW</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USE_EXISTING_OR_NEW
	 * @model literal="Use existing or initiate transaction"
	 * @generated
	 * @ordered
	 */
	public static final int USE_EXISTING_OR_NEW_VALUE = 6;

	/**
	 * An array of all the '<em><b>Transaction Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransactionAction[] VALUES_ARRAY =
		new TransactionAction[] {
			COMMIT,
			FAULT_IF_NO_TRANSACTION,
			INITIATE_NEW,
			RESUME,
			SUSPEND,
			ROLLBACK,
			USE_EXISTING_OR_NEW,
		};

	/**
	 * A public read-only list of all the '<em><b>Transaction Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TransactionAction> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transaction Action</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransactionAction get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransactionAction result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transaction Action</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransactionAction getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransactionAction result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transaction Action</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransactionAction get(int value) {
		switch (value) {
			case COMMIT_VALUE: return COMMIT;
			case FAULT_IF_NO_TRANSACTION_VALUE: return FAULT_IF_NO_TRANSACTION;
			case INITIATE_NEW_VALUE: return INITIATE_NEW;
			case RESUME_VALUE: return RESUME;
			case SUSPEND_VALUE: return SUSPEND;
			case ROLLBACK_VALUE: return ROLLBACK;
			case USE_EXISTING_OR_NEW_VALUE: return USE_EXISTING_OR_NEW;
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
	private TransactionAction(int value, String name, String literal) {
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
	
} //TransactionAction
