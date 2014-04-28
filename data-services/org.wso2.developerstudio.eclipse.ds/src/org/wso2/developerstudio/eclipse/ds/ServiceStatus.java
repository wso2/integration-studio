/**
 * <copyright>
 * </copyright>
 * 
 * $Id$
 */
package org.wso2.developerstudio.eclipse.ds;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '
 * <em><b>Service Status</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.ds.DsPackage#getServiceStatus()
 * @model extendedMetaData="name='serviceStatus_._type'"
 * @generated
 */
public enum ServiceStatus implements Enumerator {
	/**
	 * The '<em><b>Active</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE(0, "active", "active"),

	/**
	 * The '<em><b>Inactive</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INACTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	INACTIVE(1, "inactive", "inactive");

	/**
	 * The '<em><b>Active</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Active</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE
	 * @model name="active"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_VALUE = 0;

	/**
	 * The '<em><b>Inactive</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inactive</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INACTIVE
	 * @model name="inactive"
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_VALUE = 1;

	/**
	 * An array of all the '<em><b>Service Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ServiceStatus[] VALUES_ARRAY = new ServiceStatus[] {
			ACTIVE,
			INACTIVE,
		};

	/**
	 * A public read-only list of all the '<em><b>Service Status</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ServiceStatus> VALUES =
	                                                 Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Service Status</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServiceStatus get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceStatus result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Service Status</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServiceStatus getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ServiceStatus result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Service Status</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServiceStatus get(int value) {
		switch (value) {
			case ACTIVE_VALUE: return ACTIVE;
			case INACTIVE_VALUE: return INACTIVE;
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
	private ServiceStatus(int value, String name, String literal) {
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

} // ServiceStatus
