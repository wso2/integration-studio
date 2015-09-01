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
 * A representation of the literals of the enumeration '<em><b>Auto Offset Reset Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getAutoOffsetResetType()
 * @model
 * @generated
 */
public enum AutoOffsetResetType implements Enumerator {
	/**
	 * The '<em><b>Smallest</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SMALLEST_VALUE
	 * @generated
	 * @ordered
	 */
	SMALLEST(0, "smallest", "smallest"),

	/**
	 * The '<em><b>Largest</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LARGEST_VALUE
	 * @generated
	 * @ordered
	 */
	LARGEST(1, "largest", "largest");

	/**
	 * The '<em><b>Smallest</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Smallest</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SMALLEST
	 * @model name="smallest"
	 * @generated
	 * @ordered
	 */
	public static final int SMALLEST_VALUE = 0;

	/**
	 * The '<em><b>Largest</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Largest</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LARGEST
	 * @model name="largest"
	 * @generated
	 * @ordered
	 */
	public static final int LARGEST_VALUE = 1;

	/**
	 * An array of all the '<em><b>Auto Offset Reset Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AutoOffsetResetType[] VALUES_ARRAY =
		new AutoOffsetResetType[] {
			SMALLEST,
			LARGEST,
		};

	/**
	 * A public read-only list of all the '<em><b>Auto Offset Reset Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AutoOffsetResetType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Auto Offset Reset Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AutoOffsetResetType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AutoOffsetResetType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Auto Offset Reset Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AutoOffsetResetType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AutoOffsetResetType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Auto Offset Reset Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AutoOffsetResetType get(int value) {
		switch (value) {
			case SMALLEST_VALUE: return SMALLEST;
			case LARGEST_VALUE: return LARGEST;
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
	private AutoOffsetResetType(int value, String name, String literal) {
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
	
} //AutoOffsetResetType
