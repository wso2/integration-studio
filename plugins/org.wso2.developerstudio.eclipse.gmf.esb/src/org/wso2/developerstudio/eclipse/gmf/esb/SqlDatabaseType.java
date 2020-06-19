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
 * A representation of the literals of the enumeration '<em><b>Sql Database Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getSqlDatabaseType()
 * @model
 * @generated
 */
public enum SqlDatabaseType implements Enumerator {
    /**
     * The '<em><b>OTHER</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #OTHER_VALUE
     * @generated
     * @ordered
     */
    OTHER(0, "OTHER", "OTHER"),

    /**
     * The '<em><b>MYSQL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MYSQL_VALUE
     * @generated
     * @ordered
     */
    MYSQL(1, "MYSQL", "MYSQL"),

    /**
     * The '<em><b>ORACLE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ORACLE_VALUE
     * @generated
     * @ordered
     */
    ORACLE(2, "ORACLE", "ORACLE"),

    /**
     * The '<em><b>MSSQL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #MSSQL_VALUE
     * @generated
     * @ordered
     */
    MSSQL(3, "MSSQL", "MSSQL"),

    /**
     * The '<em><b>POSTGRESQL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #POSTGRESQL_VALUE
     * @generated
     * @ordered
     */
    POSTGRESQL(4, "POSTGRESQL", "POSTGRESQL");

    /**
     * The '<em><b>OTHER</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>OTHER</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #OTHER
     * @model
     * @generated
     * @ordered
     */
    public static final int OTHER_VALUE = 0;

    /**
     * The '<em><b>MYSQL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MYSQL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MYSQL
     * @model
     * @generated
     * @ordered
     */
    public static final int MYSQL_VALUE = 1;

    /**
     * The '<em><b>ORACLE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ORACLE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ORACLE
     * @model
     * @generated
     * @ordered
     */
    public static final int ORACLE_VALUE = 2;

    /**
     * The '<em><b>MSSQL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>MSSQL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #MSSQL
     * @model
     * @generated
     * @ordered
     */
    public static final int MSSQL_VALUE = 3;

    /**
     * The '<em><b>POSTGRESQL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>POSTGRESQL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #POSTGRESQL
     * @model
     * @generated
     * @ordered
     */
    public static final int POSTGRESQL_VALUE = 4;

    /**
     * An array of all the '<em><b>Sql Database Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final SqlDatabaseType[] VALUES_ARRAY =
        new SqlDatabaseType[] {
            OTHER,
            MYSQL,
            ORACLE,
            MSSQL,
            POSTGRESQL,
        };

    /**
     * A public read-only list of all the '<em><b>Sql Database Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<SqlDatabaseType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Sql Database Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static SqlDatabaseType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            SqlDatabaseType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Sql Database Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static SqlDatabaseType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            SqlDatabaseType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Sql Database Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static SqlDatabaseType get(int value) {
        switch (value) {
            case OTHER_VALUE: return OTHER;
            case MYSQL_VALUE: return MYSQL;
            case ORACLE_VALUE: return ORACLE;
            case MSSQL_VALUE: return MSSQL;
            case POSTGRESQL_VALUE: return POSTGRESQL;
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
    private SqlDatabaseType(int value, String name, String literal) {
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
    
} //SqlDatabaseType
