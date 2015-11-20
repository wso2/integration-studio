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
 * A representation of the literals of the enumeration '<em><b>Command Property Context Action</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCommandPropertyContextAction()
 * @model
 * @generated
 */
public enum CommandPropertyContextAction implements Enumerator {
	/**
	 * The '<em><b>READ CONTEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #READ_CONTEXT_VALUE
	 * @generated
	 * @ordered
	 */
	READ_CONTEXT(0, "READ_CONTEXT", "ReadContext"),

	/**
	 * The '<em><b>UPDATE CONTEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE_CONTEXT_VALUE
	 * @generated
	 * @ordered
	 */
	UPDATE_CONTEXT(1, "UPDATE_CONTEXT", "UpdateContext"),

	/**
	 * The '<em><b>READ AND UPDATE CONTEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #READ_AND_UPDATE_CONTEXT_VALUE
	 * @generated
	 * @ordered
	 */
	READ_AND_UPDATE_CONTEXT(2, "READ_AND_UPDATE_CONTEXT", "ReadAndUpdateContext");

	/**
	 * The '<em><b>READ CONTEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>READ CONTEXT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #READ_CONTEXT
	 * @model literal="ReadContext"
	 * @generated
	 * @ordered
	 */
	public static final int READ_CONTEXT_VALUE = 0;

	/**
	 * The '<em><b>UPDATE CONTEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UPDATE CONTEXT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UPDATE_CONTEXT
	 * @model literal="UpdateContext"
	 * @generated
	 * @ordered
	 */
	public static final int UPDATE_CONTEXT_VALUE = 1;

	/**
	 * The '<em><b>READ AND UPDATE CONTEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>READ AND UPDATE CONTEXT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #READ_AND_UPDATE_CONTEXT
	 * @model literal="ReadAndUpdateContext"
	 * @generated
	 * @ordered
	 */
	public static final int READ_AND_UPDATE_CONTEXT_VALUE = 2;

	/**
	 * An array of all the '<em><b>Command Property Context Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final CommandPropertyContextAction[] VALUES_ARRAY =
		new CommandPropertyContextAction[] {
			READ_CONTEXT,
			UPDATE_CONTEXT,
			READ_AND_UPDATE_CONTEXT,
		};

	/**
	 * A public read-only list of all the '<em><b>Command Property Context Action</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<CommandPropertyContextAction> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Command Property Context Action</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommandPropertyContextAction get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CommandPropertyContextAction result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Command Property Context Action</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommandPropertyContextAction getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			CommandPropertyContextAction result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Command Property Context Action</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CommandPropertyContextAction get(int value) {
		switch (value) {
			case READ_CONTEXT_VALUE: return READ_CONTEXT;
			case UPDATE_CONTEXT_VALUE: return UPDATE_CONTEXT;
			case READ_AND_UPDATE_CONTEXT_VALUE: return READ_AND_UPDATE_CONTEXT;
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
	private CommandPropertyContextAction(int value, String name, String literal) {
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
	
} //CommandPropertyContextAction
