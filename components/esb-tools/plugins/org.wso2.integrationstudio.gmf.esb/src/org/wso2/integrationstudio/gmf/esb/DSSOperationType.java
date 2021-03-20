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
package org.wso2.integrationstudio.gmf.esb;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>DSS Operation Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getDSSOperationType()
 * @model
 * @generated
 */
public enum DSSOperationType implements Enumerator {
    /**
     * The '<em><b>SINGLE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SINGLE_VALUE
     * @generated
     * @ordered
     */
    SINGLE(0, "SINGLE", "SINGLE"),

    /**
     * The '<em><b>BATCH</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BATCH_VALUE
     * @generated
     * @ordered
     */
    BATCH(0, "BATCH", "BATCH"),

    /**
     * The '<em><b>REQUESTBOX</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REQUESTBOX_VALUE
     * @generated
     * @ordered
     */
    REQUESTBOX(0, "REQUESTBOX", "REQUESTBOX");

    /**
     * The '<em><b>SINGLE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #SINGLE
     * @model
     * @generated
     * @ordered
     */
    public static final int SINGLE_VALUE = 0;

    /**
     * The '<em><b>BATCH</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #BATCH
     * @model
     * @generated
     * @ordered
     */
    public static final int BATCH_VALUE = 0;

    /**
     * The '<em><b>REQUESTBOX</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #REQUESTBOX
     * @model
     * @generated
     * @ordered
     */
    public static final int REQUESTBOX_VALUE = 0;

    /**
     * An array of all the '<em><b>DSS Operation Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final DSSOperationType[] VALUES_ARRAY =
        new DSSOperationType[] {
            SINGLE,
            BATCH,
            REQUESTBOX,
        };

    /**
     * A public read-only list of all the '<em><b>DSS Operation Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<DSSOperationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>DSS Operation Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DSSOperationType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DSSOperationType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>DSS Operation Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DSSOperationType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            DSSOperationType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>DSS Operation Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static DSSOperationType get(int value) {
        switch (value) {
            case SINGLE_VALUE: return SINGLE;
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
    private DSSOperationType(int value, String name, String literal) {
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
    
} //DSSOperationType
