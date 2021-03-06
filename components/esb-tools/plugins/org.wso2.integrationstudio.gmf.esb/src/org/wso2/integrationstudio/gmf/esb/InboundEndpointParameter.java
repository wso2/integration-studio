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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inbound Endpoint Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointParameter#getName <em>Name</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointParameter#getInboundEndpointParameterType <em>Inbound Endpoint Parameter Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointParameter#getValue <em>Value</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointParameter#getInboundEndpointParameterKey <em>Inbound Endpoint Parameter Key</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getInboundEndpointParameter()
 * @model
 * @generated
 */
public interface InboundEndpointParameter extends EObject {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * The default value is <code>"parameter_name"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getInboundEndpointParameter_Name()
     * @model default="parameter_name"
     * @generated
     */
    String getName();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointParameter#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName(String value);

    /**
     * Returns the value of the '<em><b>Inbound Endpoint Parameter Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.integrationstudio.gmf.esb.KeyType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Endpoint Parameter Type</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.KeyType
     * @see #setInboundEndpointParameterType(KeyType)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getInboundEndpointParameter_InboundEndpointParameterType()
     * @model
     * @generated
     */
    KeyType getInboundEndpointParameterType();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointParameter#getInboundEndpointParameterType <em>Inbound Endpoint Parameter Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Endpoint Parameter Type</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.KeyType
     * @see #getInboundEndpointParameterType()
     * @generated
     */
    void setInboundEndpointParameterType(KeyType value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * The default value is <code>"parameter_value"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getInboundEndpointParameter_Value()
     * @model default="parameter_value"
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointParameter#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

    /**
     * Returns the value of the '<em><b>Inbound Endpoint Parameter Key</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Inbound Endpoint Parameter Key</em>' containment reference.
     * @see #setInboundEndpointParameterKey(RegistryKeyProperty)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getInboundEndpointParameter_InboundEndpointParameterKey()
     * @model containment="true"
     * @generated
     */
    RegistryKeyProperty getInboundEndpointParameterKey();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.InboundEndpointParameter#getInboundEndpointParameterKey <em>Inbound Endpoint Parameter Key</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Inbound Endpoint Parameter Key</em>' containment reference.
     * @see #getInboundEndpointParameterKey()
     * @generated
     */
    void setInboundEndpointParameterKey(RegistryKeyProperty value);

} // InboundEndpointParameter
