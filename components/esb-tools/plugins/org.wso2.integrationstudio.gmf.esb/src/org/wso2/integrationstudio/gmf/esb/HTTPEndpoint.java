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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>HTTP Endpoint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getURITemplate <em>URI Template</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getHttpMethod <em>Http Method</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOAuthGrantType <em>OAuth Grant Type</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOAuthClientId <em>OAuth Client Id</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOAuthClientSecret <em>OAuth Client Secret</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOAuthTokenUrl <em>OAuth Token Url</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOAuthRefreshToken <em>OAuth Refresh Token</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpoint()
 * @model
 * @generated
 */
public interface HTTPEndpoint extends AbstractEndPoint {
    /**
     * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Connector</em>' containment reference.
     * @see #setInputConnector(HTTPEndPointInputConnector)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpoint_InputConnector()
     * @model containment="true"
     * @generated
     */
    HTTPEndPointInputConnector getInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getInputConnector <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Connector</em>' containment reference.
     * @see #getInputConnector()
     * @generated
     */
    void setInputConnector(HTTPEndPointInputConnector value);

    /**
     * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Connector</em>' containment reference.
     * @see #setOutputConnector(HTTPEndPointOutputConnector)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpoint_OutputConnector()
     * @model containment="true"
     * @generated
     */
    HTTPEndPointOutputConnector getOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOutputConnector <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Connector</em>' containment reference.
     * @see #getOutputConnector()
     * @generated
     */
    void setOutputConnector(HTTPEndPointOutputConnector value);

    /**
     * Returns the value of the '<em><b>URI Template</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>URI Template</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>URI Template</em>' attribute.
     * @see #setURITemplate(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpoint_URITemplate()
     * @model
     * @generated
     */
    String getURITemplate();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getURITemplate <em>URI Template</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>URI Template</em>' attribute.
     * @see #getURITemplate()
     * @generated
     */
    void setURITemplate(String value);

    /**
     * Returns the value of the '<em><b>Http Method</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.integrationstudio.gmf.esb.HttpMethodType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Http Method</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Http Method</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.HttpMethodType
     * @see #setHttpMethod(HttpMethodType)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpoint_HttpMethod()
     * @model
     * @generated
     */
    HttpMethodType getHttpMethod();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getHttpMethod <em>Http Method</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Http Method</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.HttpMethodType
     * @see #getHttpMethod()
     * @generated
     */
    void setHttpMethod(HttpMethodType value);

    /**
     * Returns the value of the '<em><b>OAuth Grant Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.integrationstudio.gmf.esb.HTTPEndpointOAuthGrantType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>OAuth Grant Type</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.HTTPEndpointOAuthGrantType
     * @see #setOAuthGrantType(HTTPEndpointOAuthGrantType)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpoint_OAuthGrantType()
     * @model
     * @generated
     */
    HTTPEndpointOAuthGrantType getOAuthGrantType();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOAuthGrantType <em>OAuth Grant Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>OAuth Grant Type</em>' attribute.
     * @see org.wso2.integrationstudio.gmf.esb.HTTPEndpointOAuthGrantType
     * @see #getOAuthGrantType()
     * @generated
     */
    void setOAuthGrantType(HTTPEndpointOAuthGrantType value);

    /**
     * Returns the value of the '<em><b>OAuth Client Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>OAuth Client Id</em>' attribute.
     * @see #setOAuthClientId(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpoint_OAuthClientId()
     * @model
     * @generated
     */
    String getOAuthClientId();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOAuthClientId <em>OAuth Client Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>OAuth Client Id</em>' attribute.
     * @see #getOAuthClientId()
     * @generated
     */
    void setOAuthClientId(String value);

    /**
     * Returns the value of the '<em><b>OAuth Client Secret</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>OAuth Client Secret</em>' attribute.
     * @see #setOAuthClientSecret(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpoint_OAuthClientSecret()
     * @model
     * @generated
     */
    String getOAuthClientSecret();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOAuthClientSecret <em>OAuth Client Secret</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>OAuth Client Secret</em>' attribute.
     * @see #getOAuthClientSecret()
     * @generated
     */
    void setOAuthClientSecret(String value);

    /**
     * Returns the value of the '<em><b>OAuth Token Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>OAuth Token Url</em>' attribute.
     * @see #setOAuthTokenUrl(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpoint_OAuthTokenUrl()
     * @model
     * @generated
     */
    String getOAuthTokenUrl();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOAuthTokenUrl <em>OAuth Token Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>OAuth Token Url</em>' attribute.
     * @see #getOAuthTokenUrl()
     * @generated
     */
    void setOAuthTokenUrl(String value);

    /**
     * Returns the value of the '<em><b>OAuth Refresh Token</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>OAuth Refresh Token</em>' attribute.
     * @see #setOAuthRefreshToken(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getHTTPEndpoint_OAuthRefreshToken()
     * @model
     * @generated
     */
    String getOAuthRefreshToken();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.HTTPEndpoint#getOAuthRefreshToken <em>OAuth Refresh Token</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>OAuth Refresh Token</em>' attribute.
     * @see #getOAuthRefreshToken()
     * @generated
     */
    void setOAuthRefreshToken(String value);

} // HTTPEndpoint
