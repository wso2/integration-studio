/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
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
package org.wso2.developerstudio.eclipse.esb;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proxy Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration#getInlineEndpoint <em>Inline Endpoint</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration#getEndpointKey <em>Endpoint Key</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration#getEndpointName <em>Endpoint Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyEndpointConfiguration()
 * @model
 * @generated
 */
public interface ProxyEndpointConfiguration extends ModelObject {

	/**
	 * Returns the value of the '<em><b>Endpoint Type</b></em>' attribute.
	 * The default value is <code>"ANONYMOUS"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.ProxyEndpointType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyEndpointType
	 * @see #setEndpointType(ProxyEndpointType)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyEndpointConfiguration_EndpointType()
	 * @model default="ANONYMOUS"
	 * @generated
	 */
	ProxyEndpointType getEndpointType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration#getEndpointType <em>Endpoint Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.ProxyEndpointType
	 * @see #getEndpointType()
	 * @generated
	 */
	void setEndpointType(ProxyEndpointType value);

	/**
	 * Returns the value of the '<em><b>Inline Endpoint</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inline Endpoint</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inline Endpoint</em>' containment reference.
	 * @see #setInlineEndpoint(EndPoint)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyEndpointConfiguration_InlineEndpoint()
	 * @model containment="true"
	 * @generated
	 */
	EndPoint getInlineEndpoint();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration#getInlineEndpoint <em>Inline Endpoint</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inline Endpoint</em>' containment reference.
	 * @see #getInlineEndpoint()
	 * @generated
	 */
	void setInlineEndpoint(EndPoint value);

	/**
	 * Returns the value of the '<em><b>Endpoint Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Key</em>' containment reference.
	 * @see #setEndpointKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyEndpointConfiguration_EndpointKey()
	 * @model containment="true"
	 * @generated
	 */
	RegistryKeyProperty getEndpointKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration#getEndpointKey <em>Endpoint Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Key</em>' containment reference.
	 * @see #getEndpointKey()
	 * @generated
	 */
	void setEndpointKey(RegistryKeyProperty value);

	/**
	 * Returns the value of the '<em><b>Endpoint Name</b></em>' attribute.
	 * The default value is <code>"endpoint_name"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Name</em>' attribute.
	 * @see #setEndpointName(String)
	 * @see org.wso2.developerstudio.eclipse.esb.EsbPackage#getProxyEndpointConfiguration_EndpointName()
	 * @model default="endpoint_name"
	 * @generated
	 */
	String getEndpointName();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.ProxyEndpointConfiguration#getEndpointName <em>Endpoint Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Name</em>' attribute.
	 * @see #getEndpointName()
	 * @generated
	 */
	void setEndpointName(String value);
} // ProxyEndpoint
