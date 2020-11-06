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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Mediator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getInputConnector <em>Input Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getOutputConnector <em>Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getEndpointOutputConnector <em>Endpoint Output Connector</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getMediatorFlow <em>Mediator Flow</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getEndpointType <em>Endpoint Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#isEnableBlockingCalls <em>Enable Blocking Calls</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getEndpointRegistrykey <em>Endpoint Registrykey</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getEndpointXpath <em>Endpoint Xpath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getSourcePayload <em>Source Payload</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getSourceProperty <em>Source Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getContentType <em>Content Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getSourceXPath <em>Source XPath</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getTargetType <em>Target Type</em>}</li>
 * </ul>
 *
 * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator()
 * @model
 * @generated
 */
public interface CallMediator extends Mediator {
    /**
     * Returns the value of the '<em><b>Input Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Input Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Input Connector</em>' containment reference.
     * @see #setInputConnector(CallMediatorInputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_InputConnector()
     * @model containment="true"
     * @generated
     */
    CallMediatorInputConnector getInputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getInputConnector <em>Input Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Input Connector</em>' containment reference.
     * @see #getInputConnector()
     * @generated
     */
    void setInputConnector(CallMediatorInputConnector value);

    /**
     * Returns the value of the '<em><b>Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Output Connector</em>' containment reference.
     * @see #setOutputConnector(CallMediatorOutputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_OutputConnector()
     * @model containment="true"
     * @generated
     */
    CallMediatorOutputConnector getOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getOutputConnector <em>Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Output Connector</em>' containment reference.
     * @see #getOutputConnector()
     * @generated
     */
    void setOutputConnector(CallMediatorOutputConnector value);

    /**
     * Returns the value of the '<em><b>Endpoint</b></em>' reference list.
     * The list contents are of type {@link org.wso2.developerstudio.eclipse.gmf.esb.EndPoint}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint</em>' reference list.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_Endpoint()
     * @model
     * @generated
     */
    EList<EndPoint> getEndpoint();

    /**
     * Returns the value of the '<em><b>Endpoint Output Connector</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint Output Connector</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint Output Connector</em>' containment reference.
     * @see #setEndpointOutputConnector(CallMediatorEndpointOutputConnector)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_EndpointOutputConnector()
     * @model containment="true"
     * @generated
     */
    CallMediatorEndpointOutputConnector getEndpointOutputConnector();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getEndpointOutputConnector <em>Endpoint Output Connector</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint Output Connector</em>' containment reference.
     * @see #getEndpointOutputConnector()
     * @generated
     */
    void setEndpointOutputConnector(CallMediatorEndpointOutputConnector value);

    /**
     * Returns the value of the '<em><b>Mediator Flow</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mediator Flow</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mediator Flow</em>' containment reference.
     * @see #setMediatorFlow(MediatorFlow)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_MediatorFlow()
     * @model containment="true"
     * @generated
     */
    MediatorFlow getMediatorFlow();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getMediatorFlow <em>Mediator Flow</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Mediator Flow</em>' containment reference.
     * @see #getMediatorFlow()
     * @generated
     */
    void setMediatorFlow(MediatorFlow value);

    /**
     * Returns the value of the '<em><b>Endpoint Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointType
     * @see #setEndpointType(CallMediatorEndpointType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_EndpointType()
     * @model
     * @generated
     */
    CallMediatorEndpointType getEndpointType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getEndpointType <em>Endpoint Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.CallMediatorEndpointType
     * @see #getEndpointType()
     * @generated
     */
    void setEndpointType(CallMediatorEndpointType value);

    /**
     * Returns the value of the '<em><b>Enable Blocking Calls</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Enable Blocking Calls</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Enable Blocking Calls</em>' attribute.
     * @see #setEnableBlockingCalls(boolean)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_EnableBlockingCalls()
     * @model default="false"
     * @generated
     */
    boolean isEnableBlockingCalls();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#isEnableBlockingCalls <em>Enable Blocking Calls</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Enable Blocking Calls</em>' attribute.
     * @see #isEnableBlockingCalls()
     * @generated
     */
    void setEnableBlockingCalls(boolean value);

    /**
     * Returns the value of the '<em><b>Endpoint Registrykey</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint Registrykey</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint Registrykey</em>' containment reference.
     * @see #setEndpointRegistrykey(RegistryKeyProperty)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_EndpointRegistrykey()
     * @model containment="true"
     * @generated
     */
    RegistryKeyProperty getEndpointRegistrykey();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getEndpointRegistrykey <em>Endpoint Registrykey</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint Registrykey</em>' containment reference.
     * @see #getEndpointRegistrykey()
     * @generated
     */
    void setEndpointRegistrykey(RegistryKeyProperty value);

    /**
     * Returns the value of the '<em><b>Endpoint Xpath</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint Xpath</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint Xpath</em>' containment reference.
     * @see #setEndpointXpath(NamespacedProperty)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_EndpointXpath()
     * @model containment="true"
     * @generated
     */
    NamespacedProperty getEndpointXpath();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getEndpointXpath <em>Endpoint Xpath</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint Xpath</em>' containment reference.
     * @see #getEndpointXpath()
     * @generated
     */
    void setEndpointXpath(NamespacedProperty value);

    /**
     * Returns the value of the '<em><b>Source Payload</b></em>' attribute.
     * The default value is <code>"<inline/>"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Payload</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Payload</em>' attribute.
     * @see #setSourcePayload(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_SourcePayload()
     * @model default="&lt;inline/&gt;"
     * @generated
     */
    String getSourcePayload();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getSourcePayload <em>Source Payload</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Payload</em>' attribute.
     * @see #getSourcePayload()
     * @generated
     */
    void setSourcePayload(String value);

    /**
     * Returns the value of the '<em><b>Source Property</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Property</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Property</em>' attribute.
     * @see #setSourceProperty(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_SourceProperty()
     * @model
     * @generated
     */
    String getSourceProperty();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getSourceProperty <em>Source Property</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Property</em>' attribute.
     * @see #getSourceProperty()
     * @generated
     */
    void setSourceProperty(String value);

    /**
     * Returns the value of the '<em><b>Content Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Content Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Content Type</em>' attribute.
     * @see #setContentType(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_ContentType()
     * @model
     * @generated
     */
    String getContentType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getContentType <em>Content Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Content Type</em>' attribute.
     * @see #getContentType()
     * @generated
     */
    void setContentType(String value);

    /**
     * Returns the value of the '<em><b>Source XPath</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source XPath</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source XPath</em>' containment reference.
     * @see #setSourceXPath(NamespacedProperty)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_SourceXPath()
     * @model containment="true"
     * @generated
     */
    NamespacedProperty getSourceXPath();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getSourceXPath <em>Source XPath</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source XPath</em>' containment reference.
     * @see #getSourceXPath()
     * @generated
     */
    void setSourceXPath(NamespacedProperty value);

    /**
     * Returns the value of the '<em><b>Target Property</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Property</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Property</em>' attribute.
     * @see #setTargetProperty(String)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_TargetProperty()
     * @model
     * @generated
     */
    String getTargetProperty();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getTargetProperty <em>Target Property</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Property</em>' attribute.
     * @see #getTargetProperty()
     * @generated
     */
    void setTargetProperty(String value);

    /**
     * Returns the value of the '<em><b>Source Type</b></em>' attribute.
     * The default value is <code>"none"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CallSourceType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.CallSourceType
     * @see #setSourceType(CallSourceType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_SourceType()
     * @model default="none"
     * @generated
     */
    CallSourceType getSourceType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getSourceType <em>Source Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.CallSourceType
     * @see #getSourceType()
     * @generated
     */
    void setSourceType(CallSourceType value);

    /**
     * Returns the value of the '<em><b>Target Type</b></em>' attribute.
     * The default value is <code>"none"</code>.
     * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.gmf.esb.CallTargetType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Target Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Target Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.CallTargetType
     * @see #setTargetType(CallTargetType)
     * @see org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage#getCallMediator_TargetType()
     * @model default="none"
     * @generated
     */
    CallTargetType getTargetType();

    /**
     * Sets the value of the '{@link org.wso2.developerstudio.eclipse.gmf.esb.CallMediator#getTargetType <em>Target Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Type</em>' attribute.
     * @see org.wso2.developerstudio.eclipse.gmf.esb.CallTargetType
     * @see #getTargetType()
     * @generated
     */
    void setTargetType(CallTargetType value);

} // CallMediator
