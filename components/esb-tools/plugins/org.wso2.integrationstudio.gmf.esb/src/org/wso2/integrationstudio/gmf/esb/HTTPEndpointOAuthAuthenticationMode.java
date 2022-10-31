/**
 * Copyright 2021 WSO2, Inc. (http://wso2.com)
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
 * A representation of the literals of the enumeration '<em><b>HTTP Endpoint OAuth Authentication Mode</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpointOAuthAuthenticationMode()
 * @model
 * @generated
 */
public enum HTTPEndpointOAuthAuthenticationMode implements Enumerator {
    /**
     * The '<em><b>Header OAuth Authentication Mode</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #HEADER_OAUTH_AUTHENTICATION_MODE_VALUE
     * @generated
     * @ordered
     */
    HEADER_OAUTH_AUTHENTICATION_MODE(0, "Header_OAuth_Authentication_Mode", "Header"),

    /**
     * The '<em><b>Payload OAuth Authentication Mode</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PAYLOAD_OAUTH_AUTHENTICATION_MODE_VALUE
     * @generated
     * @ordered
     */
    PAYLOAD_OAUTH_AUTHENTICATION_MODE(1, "Payload_OAuth_Authentication_Mode", "Payload");

    /**
     * The '<em><b>Header OAuth Authentication Mode</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #HEADER_OAUTH_AUTHENTICATION_MODE
     * @model name="Header_OAuth_Authentication_Mode" literal="Header OAuth Authentication Mode"
     * @generated
     * @ordered
     */
    public static final int HEADER_OAUTH_AUTHENTICATION_MODE_VALUE = 0;

    /**
     * The '<em><b>Payload OAuth Authentication Mode</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #PAYLOAD_OAUTH_AUTHENTICATION_MODE
     * @model name="Payload_OAuth_Authentication_Mode" literal="Payload OAuth Authentication Mode"
     * @generated
     * @ordered
     */
    public static final int PAYLOAD_OAUTH_AUTHENTICATION_MODE_VALUE = 1;

    /**
     * An array of all the '<em><b>HTTP Endpoint OAuth Authentication Mode</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final HTTPEndpointOAuthAuthenticationMode[] VALUES_ARRAY =
        new HTTPEndpointOAuthAuthenticationMode[] {
            HEADER_OAUTH_AUTHENTICATION_MODE,
            PAYLOAD_OAUTH_AUTHENTICATION_MODE,
        };

    /**
     * A public read-only list of all the '<em><b>HTTP Endpoint OAuth Authentication Mode</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<HTTPEndpointOAuthAuthenticationMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>HTTP Endpoint OAuth Authentication Mode</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static HTTPEndpointOAuthAuthenticationMode get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            HTTPEndpointOAuthAuthenticationMode result = VALUES_ARRAY[i];
            if (result.toString().equalsIgnoreCase(literal)) {
                return result;
            }
        }
        return HEADER_OAUTH_AUTHENTICATION_MODE;
    }

    /**
     * Returns the '<em><b>HTTP Endpoint OAuth Authentication Mode</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static HTTPEndpointOAuthAuthenticationMode getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            HTTPEndpointOAuthAuthenticationMode result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>HTTP Endpoint OAuth Authentication Mode</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static HTTPEndpointOAuthAuthenticationMode get(int value) {
        switch (value) {
            case HEADER_OAUTH_AUTHENTICATION_MODE_VALUE: return HEADER_OAUTH_AUTHENTICATION_MODE;
            case PAYLOAD_OAUTH_AUTHENTICATION_MODE_VALUE: return PAYLOAD_OAUTH_AUTHENTICATION_MODE;
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
    private HTTPEndpointOAuthAuthenticationMode(int value, String name, String literal) {
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
    
} //HTTPEndpointOAuthAuthenticationMode
