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
 * A representation of the model object '<em><b>NTLM Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getUsername <em>Username</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getPassword <em>Password</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getHost <em>Host</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getDomain <em>Domain</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getNtlmVersion <em>Ntlm Version</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getUsernameExpression <em>Username Expression</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getPasswordExpression <em>Password Expression</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getHostExpression <em>Host Expression</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getDomainExpression <em>Domain Expression</em>}</li>
 *   <li>{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getNtlmVersionExpression <em>Ntlm Version Expression</em>}</li>
 * </ul>
 *
 * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator()
 * @model
 * @generated
 */
public interface NTLMMediator extends Mediator {
    /**
     * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Connector</em>' containment reference.
     * @see #setInputConnector(NTLMMediatorInputConnector)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_InputConnector()
     * @model containment="true"
     * @generated
     */
    NTLMMediatorInputConnector getInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getInputConnector <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Connector</em>' containment reference.
     * @see #getInputConnector()
     * @generated
     */
    void setInputConnector(NTLMMediatorInputConnector value);

    /**
     * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Connector</em>' containment reference.
     * @see #setOutputConnector(NTLMMediatorOutputConnector)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_OutputConnector()
     * @model containment="true"
     * @generated
     */
    NTLMMediatorOutputConnector getOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Connector</em>' containment reference.
     * @see #getOutputConnector()
     * @generated
     */
    void setOutputConnector(NTLMMediatorOutputConnector value);

    /**
     * Returns the value of the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Username</em>' attribute.
     * @see #setUsername(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_Username()
     * @model
     * @generated
     */
    String getUsername();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getUsername <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Username</em>' attribute.
     * @see #getUsername()
     * @generated
     */
    void setUsername(String value);

    /**
     * Returns the value of the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Password</em>' attribute.
     * @see #setPassword(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_Password()
     * @model
     * @generated
     */
    String getPassword();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getPassword <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password</em>' attribute.
     * @see #getPassword()
     * @generated
     */
    void setPassword(String value);

    /**
     * Returns the value of the '<em><b>Host</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Host</em>' attribute.
     * @see #setHost(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_Host()
     * @model
     * @generated
     */
    String getHost();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getHost <em>Host</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Host</em>' attribute.
     * @see #getHost()
     * @generated
     */
    void setHost(String value);

    /**
     * Returns the value of the '<em><b>Domain</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Domain</em>' attribute.
     * @see #setDomain(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_Domain()
     * @model
     * @generated
     */
    String getDomain();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getDomain <em>Domain</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Domain</em>' attribute.
     * @see #getDomain()
     * @generated
     */
    void setDomain(String value);

    /**
     * Returns the value of the '<em><b>Ntlm Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ntlm Version</em>' attribute.
     * @see #setNtlmVersion(String)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_NtlmVersion()
     * @model
     * @generated
     */
    String getNtlmVersion();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getNtlmVersion <em>Ntlm Version</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ntlm Version</em>' attribute.
     * @see #getNtlmVersion()
     * @generated
     */
    void setNtlmVersion(String value);

    /**
     * Returns the value of the '<em><b>Username Expression</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Username Expression</em>' reference.
     * @see #setUsernameExpression(NamespacedProperty)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_UsernameExpression()
     * @model
     * @generated
     */
    NamespacedProperty getUsernameExpression();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getUsernameExpression <em>Username Expression</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Username Expression</em>' reference.
     * @see #getUsernameExpression()
     * @generated
     */
    void setUsernameExpression(NamespacedProperty value);

    /**
     * Returns the value of the '<em><b>Password Expression</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Password Expression</em>' reference.
     * @see #setPasswordExpression(NamespacedProperty)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_PasswordExpression()
     * @model
     * @generated
     */
    NamespacedProperty getPasswordExpression();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getPasswordExpression <em>Password Expression</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password Expression</em>' reference.
     * @see #getPasswordExpression()
     * @generated
     */
    void setPasswordExpression(NamespacedProperty value);

    /**
     * Returns the value of the '<em><b>Host Expression</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Host Expression</em>' reference.
     * @see #setHostExpression(NamespacedProperty)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_HostExpression()
     * @model
     * @generated
     */
    NamespacedProperty getHostExpression();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getHostExpression <em>Host Expression</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Host Expression</em>' reference.
     * @see #getHostExpression()
     * @generated
     */
    void setHostExpression(NamespacedProperty value);

    /**
     * Returns the value of the '<em><b>Domain Expression</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Domain Expression</em>' reference.
     * @see #setDomainExpression(NamespacedProperty)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_DomainExpression()
     * @model
     * @generated
     */
    NamespacedProperty getDomainExpression();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getDomainExpression <em>Domain Expression</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Domain Expression</em>' reference.
     * @see #getDomainExpression()
     * @generated
     */
    void setDomainExpression(NamespacedProperty value);

    /**
     * Returns the value of the '<em><b>Ntlm Version Expression</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ntlm Version Expression</em>' reference.
     * @see #setNtlmVersionExpression(NamespacedProperty)
     * @see org.wso2.integrationstudio.gmf.esb.EsbPackage#getNTLMMediator_NtlmVersionExpression()
     * @model
     * @generated
     */
    NamespacedProperty getNtlmVersionExpression();

    /**
     * Sets the value of the '{@link org.wso2.integrationstudio.gmf.esb.NTLMMediator#getNtlmVersionExpression <em>Ntlm Version Expression</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ntlm Version Expression</em>' reference.
     * @see #getNtlmVersionExpression()
     * @generated
     */
    void setNtlmVersionExpression(NamespacedProperty value);

} // NTLMMediator
