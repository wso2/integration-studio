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
 * A representation of the literals of the enumeration '<em><b>HTTP Endpoint OAuth Grant Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpointOAuthGrantType()
 * @model
 * @generated
 */
public enum HTTPEndpointOAuthGrantType implements Enumerator {
    /**
     * The '<em><b>None</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NONE_VALUE
     * @generated
     * @ordered
     */
    NONE(0, "None", "None"),

    /**
     * The '<em><b>Authorization Code Grant</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #AUTHORIZATION_CODE_GRANT_VALUE
     * @generated
     * @ordered
     */
    AUTHORIZATION_CODE_GRANT(1, "Authorization_Code_Grant", "Authorization Code Grant"),

    /**
     * The '<em><b>Client Credentials Grant</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CLIENT_CREDENTIALS_GRANT_VALUE
     * @generated
     * @ordered
     */
    CLIENT_CREDENTIALS_GRANT(2, "Client_Credentials_Grant", "Client Credentials Grant");

    /**
     * The '<em><b>None</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NONE
     * @model name="None"
     * @generated
     * @ordered
     */
    public static final int NONE_VALUE = 0;

    /**
     * The '<em><b>Authorization Code Grant</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #AUTHORIZATION_CODE_GRANT
     * @model name="Authorization_Code_Grant" literal="Authorization Code Grant"
     * @generated
     * @ordered
     */
    public static final int AUTHORIZATION_CODE_GRANT_VALUE = 1;

    /**
     * The '<em><b>Client Credentials Grant</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #CLIENT_CREDENTIALS_GRANT
     * @model name="Client_Credentials_Grant" literal="Client Credentials Grant"
     * @generated
     * @ordered
     */
    public static final int CLIENT_CREDENTIALS_GRANT_VALUE = 2;

    /**
     * An array of all the '<em><b>HTTP Endpoint OAuth Grant Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final HTTPEndpointOAuthGrantType[] VALUES_ARRAY =
        new HTTPEndpointOAuthGrantType[] {
            NONE,
            AUTHORIZATION_CODE_GRANT,
            CLIENT_CREDENTIALS_GRANT,
        };

    /**
     * A public read-only list of all the '<em><b>HTTP Endpoint OAuth Grant Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<HTTPEndpointOAuthGrantType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>HTTP Endpoint OAuth Grant Type</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static HTTPEndpointOAuthGrantType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            HTTPEndpointOAuthGrantType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>HTTP Endpoint OAuth Grant Type</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static HTTPEndpointOAuthGrantType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            HTTPEndpointOAuthGrantType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>HTTP Endpoint OAuth Grant Type</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static HTTPEndpointOAuthGrantType get(int value) {
        switch (value) {
            case NONE_VALUE: return NONE;
            case AUTHORIZATION_CODE_GRANT_VALUE: return AUTHORIZATION_CODE_GRANT;
            case CLIENT_CREDENTIALS_GRANT_VALUE: return CLIENT_CREDENTIALS_GRANT;
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
    private HTTPEndpointOAuthGrantType(int value, String name, String literal) {
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
    
} //HTTPEndpointOAuthGrantType
